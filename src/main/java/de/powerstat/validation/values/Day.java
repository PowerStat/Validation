/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Day.
 *
 * Not DSGVO relevant.
 *
 * TODO Constructor with day, month
 * TODO Constructor with day, month, year
 * TODO nextDay, previousDay
 */
public final class Day implements Comparable<Day>
 {
  /**
   * Day.
   */
  private final int day;


  /**
   * Constructor.
   *
   * @param day Day 1-31
   * @throws IndexOutOfBoundsException When the day is less than 1 or greater than 31
   */
  public Day(final int day)
   {
    super();
    if ((day < 1) || (day > 31))
     {
      throw new IndexOutOfBoundsException("Day number out of range (1-31)!"); //$NON-NLS-1$
     }
    this.day = day;
   }


  /**
   * Day factory.
   *
   * @param day Day 1-31
   * @return Day object
   */
  public static Day of(final int day)
   {
    return new Day(day);
   }


  /**
   * Get day.
   *
   * @return Day
   */
  public int getDay()
   {
    return this.day;
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
    return Integer.hashCode(this.day);
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
    if (!(obj instanceof Day))
     {
      return false;
     }
    final Day other = (Day)obj;
    return this.day == other.day;
   }


  /**
   * Returns the string representation of this Day.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Day[day=1]"
   *
   * @return String representation of this Day
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Day[day=").append(this.day).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Day obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(this.day, obj.day);
   }

 }
