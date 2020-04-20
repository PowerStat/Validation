/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;

import java.util.Objects;

/**
 * Weeks.
 *
 * TODO add/subtract
 * TODO mult/div
 * TODO Listener
 */
public class Weeks implements Comparable<Weeks>
 {
  /**
   * Weeks.
   */
  private final long weeks;


  /**
   * Constructor.
   *
   * @param weeks Weeks 0-..
   * @throws IndexOutOfBoundsException When the week is less than 0
   */
  public Weeks(final long weeks)
   {
    super();
    if (weeks < 0)
     {
      throw new IndexOutOfBoundsException("Negative weeks are not allowed"); //$NON-NLS-1$
     }
    this.weeks = weeks;
   }


  /**
   * Weeks factory.
   *
   * @param weeks Weeks 0-..
   * @return Weeks object
   */
  public static Weeks of(final long weeks)
   {
    return new Weeks(weeks);
   }


  /**
   * Get weeks.
   *
   * @return Weeks
   */
  public long getWeeks()
   {
    return this.weeks;
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
    return Long.hashCode(this.weeks);
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
    if (!(obj instanceof Weeks))
     {
      return false;
     }
    final Weeks other = (Weeks)obj;
    return this.weeks == other.weeks;
   }


  /**
   * Returns the string representation of this Weeks.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Weeks[weeks=1]"
   *
   * @return String representation of this Weeks
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Weeks[weeks=").append(this.weeks).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Weeks obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.weeks, obj.weeks);
   }

 }
