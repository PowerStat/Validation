/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Hour.
 *
 * Not DSGVO relevant.
 *
 * TODO nextHour, previousHour
 */
public class Hour implements Comparable<Hour>
 {
  /**
   * Hour.
   */
  private final int hour;


  /**
   * Constructor.
   *
   * @param hour Hour 0-23
   * @throws IndexOutOfBoundsException When the hour is less than 0 or greater than 23
   */
  public Hour(final int hour)
   {
    super();
    if ((hour < 0) || (hour > 23))
     {
      throw new IndexOutOfBoundsException("Hour number out of range (0-23)!"); //$NON-NLS-1$
     }
    this.hour = hour;
   }


  /**
   * Hour factory.
   *
   * @param hour Hour 0-23
   * @return Hour object
   */
  public static Hour of(final int hour)
   {
    return new Hour(hour);
   }


  /**
   * Get hour.
   *
   * @return Hour
   */
  public int getHour()
   {
    return this.hour;
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
    return Integer.hashCode(this.hour);
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
    if (!(obj instanceof Hour))
     {
      return false;
     }
    final Hour other = (Hour)obj;
    return this.hour == other.hour;
   }


  /**
   * Returns the string representation of this Hour.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Hour[hour=1]"
   *
   * @return String representation of this Hour
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Hour[hour=").append(this.hour).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Hour obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(this.hour, obj.hour);
   }

 }
