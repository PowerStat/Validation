/*
 * Copyright (C) 2021-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * World geodetic system 1984 position.
 *
 * @param latitude Positions latitude specifies the north–south position of a point on the Earth's surface. Ranges from 0° at the Equator to 90° (North or South) at the poles.
 * @param longitude Positions longitude specifies the east–west position of a point on the Earth's surface. The prime meridian, which passes near the Royal Observatory, Greenwich, England, is defined as 0° longitude by convention. Positive longitudes are east of the prime meridian, and negative ones are west.
 * @param altitude Positions altitude - height above sea level.
 *
 * Possibly DSGVO relevant.
 *
 * TODO precision
 * TODO output formats
 * TODO Get address for position if possible
 */
public record WGS84Position(double latitude, double longitude, double altitude) implements Comparable<WGS84Position>, IValueObject
 {
  /**
   * Epsilon for double compare.
   */
  private static final double EPSILON = 0.000001D;

  /**
   * Position separator.
   */
  private static final String SEPARATOR = " ";


  /**
   * Constructor.
   *
   * @param latitude Positions latitude specifies the north–south position of a point on the Earth's surface. Ranges from 0° at the Equator to 90° (North or South) at the poles.
   * @param longitude Positions longitude specifies the east–west position of a point on the Earth's surface. The prime meridian, which passes near the Royal Observatory, Greenwich, England, is defined as 0° longitude by convention. Positive longitudes are east of the prime meridian, and negative ones are west.
   * @param altitude Positions altitude - height above sea level.
   * @throws IndexOutOfBoundsException If latitude or longitude is out of range.
   */
  public WGS84Position
   {
    if ((latitude < -90.0) || (latitude > 90.0))
     {
      throw new IndexOutOfBoundsException("Latitude out of range"); //$NON-NLS-1$
     }
    if ((longitude < -180.0) || (longitude > 180.0))
     {
      throw new IndexOutOfBoundsException("Longitude out of range"); //$NON-NLS-1$
     }
   }


  /**
   * WGS84Position factory.
   *
   * @param latitude Positions latitude specifies the north–south position of a point on the Earth's surface. Ranges from 0° at the Equator to 90° (North or South) at the poles.
   * @param longitude Positions longitude specifies the east–west position of a point on the Earth's surface. The prime meridian, which passes near the Royal Observatory, Greenwich, England, is defined as 0° longitude by convention. Positive longitudes are east of the prime meridian, and negative ones are west.
   * @param altitude Positions altitude - height above sea level.
   * @return WGS84Position object
   */
  public static WGS84Position of(final double latitude, final double longitude, final double altitude)
   {
    return new WGS84Position(latitude, longitude, altitude);
   }


  /**
   * WGS84Position factory.
   *
   * @param value latitude longitude altitude separated by one space
   * @return WGS84Position object
   */
  public static WGS84Position of(final String value)
   {
    final String[] values = value.split(SEPARATOR);
    if (values.length != 3)
     {
      throw new IllegalArgumentException("value not of expected format");
     }
    final double latitude = Double.parseDouble(values[0]);
    final double longitude = Double.parseDouble(values[1]);
    final double altitude = Double.parseDouble(values[2]);
    return of(latitude, longitude, altitude);
   }


  /**
   * Returns the value of this WGS84Position as a String.
   *
   * @return The value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return this.latitude + SEPARATOR + this.longitude + SEPARATOR + this.altitude;
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final WGS84Position obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = Double.compare(this.latitude, obj.latitude);
    if (result == 0)
     {
      result = Double.compare(this.longitude, obj.longitude);
      if (result == 0)
       {
        result = Double.compare(this.altitude, obj.altitude);
       }
     }
    return result;
   }

 }
