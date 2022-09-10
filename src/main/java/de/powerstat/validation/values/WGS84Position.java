/*
 * Copyright (C) 2021 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * World geodetic system 1984 position.
 *
 * Possibly DSGVO relevant.
 *
 * TODO precision
 * TODO output formats
 * TODO Get address for position if possible
 */
public final class WGS84Position implements Comparable<WGS84Position>
 {
  /**
   * Positions latitude specifies the north–south position of a point on the Earth's surface.
   *
   * Ranges from 0° at the Equator to 90° (North or South) at the poles.
   */
  private final double latitude;

  /**
   * Positions longitude specifies the east–west position of a point on the Earth's surface.
   *
   * The prime meridian, which passes near the Royal Observatory, Greenwich, England, is defined as 0° longitude by convention. Positive longitudes are east of the prime meridian, and negative ones are west.
   */
  private final double longitude;

  /**
   * Positions altitude - height above sea level.
   */
  private final double altitude;


  /**
   * Constructor.
   *
   * @param latitude Positions latitude specifies the north–south position of a point on the Earth's surface. Ranges from 0° at the Equator to 90° (North or South) at the poles.
   * @param longitude Positions longitude specifies the east–west position of a point on the Earth's surface. The prime meridian, which passes near the Royal Observatory, Greenwich, England, is defined as 0° longitude by convention. Positive longitudes are east of the prime meridian, and negative ones are west.
   * @param altitude Positions altitude - height above sea level.
   */
  public WGS84Position(final double latitude, final double longitude, final double altitude)
   {
    super();
    if ((latitude < -90.0) || (latitude > 90.0))
     {
      throw new IndexOutOfBoundsException("Latitude out of range"); //$NON-NLS-1$
     }
    if ((longitude < -180.0) || (longitude > 180.0))
     {
      throw new IndexOutOfBoundsException("Longitude out of range"); //$NON-NLS-1$
     }
    this.latitude = latitude;
    this.longitude = longitude;
    this.altitude = altitude;
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
   * Get latitude.
   *
   * @return Latitude
   */
  public double getLatitude()
   {
    return this.latitude;
   }


  /**
   * Get longitude.
   *
   * @return Longitude
   */
  public double getLongitude()
   {
    return this.longitude;
   }


  /**
   * Get altitude.
   *
   * @return Altitude
   */
  public double getAltitude()
   {
    return this.altitude;
   }


  /**
   * Calculate hash code.
   *
   * @return Hash
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
   {
    int result = Double.hashCode(this.latitude);
    result = (31 * result) + Double.hashCode(this.longitude);
    return (31 * result) + Double.hashCode(this.altitude);
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof WGS84Position))
     {
      return false;
     }
    final WGS84Position other = (WGS84Position)obj;
    if ((this.latitude == other.latitude) && (this.longitude == other.longitude))
     {
      return this.altitude == other.altitude;
     }
    return false;
   }


  /**
   * Returns the string representation of this WGS84Position.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "WGS84Position[latitude=0.0, longitude=0.0, altitude=0.0]"
   *
   * @return String representation of this WGS84Position
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(47);
    builder.append("WGS84Position[latitude=").append(this.latitude).append(", longitude=").append(this.longitude).append(", altitude=").append(this.altitude).append(']'); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    return builder.toString();
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