/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;

import java.util.Objects;

/**
 * Months.
 *
 * Not DSGVO relevant.
 *
 * TODO add/subtract
 * TODO mult/div (7 = week)
 * TODO Listener (mod 7 = 0)
 */
public final class Months implements Comparable<Months>
 {
  /**
   * Month.
   */
  private final long months;


  /**
   * Constructor.
   *
   * @param months Months 0-..
   * @throws IndexOutOfBoundsException When the months is less than 0
   */
  public Months(final long months)
   {
    super();
    if (months < 0)
     {
      throw new IndexOutOfBoundsException("Negative months are not allowed"); //$NON-NLS-1$
     }
    this.months = months;
   }


  /**
   * Months factory.
   *
   * @param months Months 0-..
   * @return Months object
   */
  public static Months of(final long months)
   {
    return new Months(months);
   }


  /**
   * Get months.
   *
   * @return Months
   */
  public long getMonths()
   {
    return this.months;
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
    return Long.hashCode(this.months);
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
    if (!(obj instanceof Months))
     {
      return false;
     }
    final Months other = (Months)obj;
    return this.months == other.months;
   }


  /**
   * Returns the string representation of this Months.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Months[months=1]"
   *
   * @return String representation of this Months
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Months[months=").append(this.months).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Months obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.months, obj.months);
   }

 }
