/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Years.
 *
 * Not DSGVO relevant.
 */
public final class Years implements Comparable<Years>
 {
  /**
   * Years.
   */
  private final long years;


  /**
   * Constructor.
   *
   * @param years Years &gt;= 0
   * @throws IndexOutOfBoundsException When the year is smaller than 0
   */
  public Years(final long years)
   {
    super();
    if (years < 0)
     {
      throw new IndexOutOfBoundsException("Negative years are not allowed"); //$NON-NLS-1$
     }
    this.years = years;
   }


  /**
   * Years factory.
   *
   * @param years Years &gt;= 0
   * @return Years object
   */
  public static Years of(final long years)
   {
    return new Years(years);
   }


  /**
   * Get years.
   *
   * @return Years
   */
  public long getYears()
   {
    return this.years;
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
    return Long.hashCode(this.years);
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
    if (!(obj instanceof Years))
     {
      return false;
     }
    final Years other = (Years)obj;
    return this.years == other.years;
   }


  /**
   * Returns the string representation of this Years.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Years[years=20]"
   *
   * @return String representation of this Years
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Years[years=").append(this.years).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Years obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.years, obj.years);
   }

 }
