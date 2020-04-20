/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Month.
 *
 * TODO nextMonth, previousMonth
 */
public class Month implements Comparable<Month>
 {
  /**
   * Month.
   */
  private final int month;


  /**
   * Constructor.
   *
   * @param month Month 1-12
   * @throws IndexOutOfBoundsException When the month is less than 1 or greater than 12
   */
  public Month(final int month)
   {
    super();
    if ((month < 1) || (month > 12))
     {
      throw new IndexOutOfBoundsException("Month number out of range (1-12)!"); //$NON-NLS-1$
     }
    this.month = month;
   }


  /**
   * Month factory.
   *
   * @param month Month 1-12
   * @return Month object
   */
  public static Month of(final int month)
   {
    return new Month(month);
   }


  /**
   * Get month.
   *
   * @return Month
   */
  public int getMonth()
   {
    return this.month;
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
    return Integer.hashCode(this.month);
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
    if (!(obj instanceof Month))
     {
      return false;
     }
    final Month other = (Month)obj;
    return this.month == other.month;
   }


  /**
   * Returns the string representation of this Month.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Month[month=1]"
   *
   * @return String representation of this Month
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Month[month=").append(this.month).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Month obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(this.month, obj.month);
   }

 }
