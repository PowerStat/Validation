/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Minutes.
 *
 * Not DSGVO relevant.
 *
 * TODO add/subtract
 * TODO mult/div (60 = hour)
 * TODO Listener (mod 60 = 0)
 */
public class Minutes implements Comparable<Minutes>
 {
  /**
   * Minutes.
   */
  private final long minutes;


  /**
   * Constructor.
   *
   * @param minutes Minutes 0-..
   * @throws IndexOutOfBoundsException When the minutes is less than 0
   */
  public Minutes(final long minutes)
   {
    super();
    if (minutes < 0)
     {
      throw new IndexOutOfBoundsException("Negative minutes are not allowed"); //$NON-NLS-1$
     }
    this.minutes = minutes;
   }


  /**
   * Minutes factory.
   *
   * @param minutes Minutes 0-..
   * @return Minutes object
   */
  public static Minutes of(final long minutes)
   {
    return new Minutes(minutes);
   }


  /**
   * Get minutes.
   *
   * @return Minutes
   */
  public long getMinutes()
   {
    return this.minutes;
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
    return Long.hashCode(this.minutes);
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
    if (!(obj instanceof Minutes))
     {
      return false;
     }
    final Minutes other = (Minutes)obj;
    return this.minutes == other.minutes;
   }


  /**
   * Returns the string representation of this Minutes.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Minutes[minutes=1]"
   *
   * @return String representation of this Minutes
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Minutes[minutes=").append(this.minutes).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Minutes obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.minutes, obj.minutes);
   }

 }
