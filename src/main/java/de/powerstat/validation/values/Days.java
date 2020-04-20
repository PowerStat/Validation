/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Days.
 *
 * TODO add/subtract
 * TODO mult/div (7 = week)
 * TODO Listener (mod 7 = 0)
 */
public class Days implements Comparable<Days>
 {
  /**
   * Days.
   */
  private final long days;


  /**
   * Constructor.
   *
   * @param days Days 0-..
   * @throws IndexOutOfBoundsException When the day is less than 0
   */
  public Days(final long days)
   {
    super();
    if (days < 0)
     {
      throw new IndexOutOfBoundsException("Negative days are not allowed"); //$NON-NLS-1$
     }
    this.days = days;
   }


  /**
   * Days factory.
   *
   * @param days Days 0-..
   * @return Days object
   */
  public static Days of(final long days)
   {
    return new Days(days);
   }


  /**
   * Get days.
   *
   * @return Days
   */
  public long getDays()
   {
    return this.days;
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
    return Long.hashCode(this.days);
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
    if (!(obj instanceof Days))
     {
      return false;
     }
    final Days other = (Days)obj;
    return this.days == other.days;
   }


  /**
   * Returns the string representation of this Days.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Days[days=1]"
   *
   * @return String representation of this Days
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Days[days=").append(this.days).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Days obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.days, obj.days);
   }

 }
