/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Year.
 *
 * Not DSGVO relevant.
 *
 * TODO isLeapYear
 */
public final class Year implements Comparable<Year>
 {
  /**
   * Year.
   */
  private final long year;


  /**
   * Constructor.
   *
   * @param year Year != 0
   * @throws IndexOutOfBoundsException When the year is 0
   */
  public Year(final long year)
   {
    super();
    if (year == 0)
     {
      throw new IndexOutOfBoundsException("Year 0 does not exist!"); //$NON-NLS-1$
     }
    this.year = year;
   }


  /**
   * Year factory.
   *
   * @param year Year != 0
   * @return Year object
   */
  public static Year of(final long year)
   {
    return new Year(year);
   }


  /**
   * Get year.
   *
   * @return Year
   */
  public long getYear()
   {
    return this.year;
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
    return Long.hashCode(this.year);
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
    if (!(obj instanceof Year))
     {
      return false;
     }
    final Year other = (Year)obj;
    return this.year == other.year;
   }


  /**
   * Returns the string representation of this Year.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Year[year=2020]"
   *
   * @return String representation of this Year
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Year[year=").append(this.year).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Year obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.year, obj.year);
   }

 }
