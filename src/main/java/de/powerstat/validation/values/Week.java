/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Week.
 *
 * Not DSGVO relevant.
 *
 * TODO Constructor with year
 */
public final class Week implements Comparable<Week>
 {
  /**
   * Week.
   */
  private final int week;


  /**
   * Constructor.
   *
   * @param week Week 1-53
   * @throws IndexOutOfBoundsException When the week is less than 1 or greater than 53
   */
  public Week(final int week)
   {
    super();
    if ((week < 1) || (week > 53))
     {
      throw new IndexOutOfBoundsException("Week number out of range (1-53)!"); //$NON-NLS-1$
     }
    this.week = week;
   }


  /**
   * Week factory.
   *
   * @param week Week 1-53
   * @return Week object
   */
  public static Week of(final int week)
   {
    return new Week(week);
   }


  /**
   * Get week.
   *
   * @return Week
   */
  public int getWeek()
   {
    return this.week;
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
    return Integer.hashCode(this.week);
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
    if (!(obj instanceof Week))
     {
      return false;
     }
    final Week other = (Week)obj;
    return this.week == other.week;
   }


  /**
   * Returns the string representation of this Week.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Week[week=1]"
   *
   * @return String representation of this Week
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Week[week=").append(this.week).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Week obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(this.week, obj.week);
   }

 }
