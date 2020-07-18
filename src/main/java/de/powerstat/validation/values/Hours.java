/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Hours.
 *
 * Not DSGVO relevant.
 *
 * TODO add/subtract
 * TODO mult/div (24 = day)
 * TODO Listener (mod 24 = 0)
 */
public final class Hours implements Comparable<Hours>
 {
  /**
   * Hours.
   */
  private final long hours;


  /**
   * Constructor.
   *
   * @param hours Hours 0-..
   * @throws IndexOutOfBoundsException When the hours is less than 0
   */
  public Hours(final long hours)
   {
    super();
    if (hours < 0)
     {
      throw new IndexOutOfBoundsException("Negative hours are not allowed"); //$NON-NLS-1$
     }
    this.hours = hours;
   }


  /**
   * Hours factory.
   *
   * @param hours Hours 0-..
   * @return Hours object
   */
  public static Hours of(final long hours)
   {
    return new Hours(hours);
   }


  /**
   * Get hours.
   *
   * @return Hours
   */
  public long getHours()
   {
    return this.hours;
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
    return Long.hashCode(this.hours);
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
    if (!(obj instanceof Hours))
     {
      return false;
     }
    final Hours other = (Hours)obj;
    return this.hours == other.hours;
   }


  /**
   * Returns the string representation of this Hours.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Hours[hours=1]"
   *
   * @return String representation of this Hours
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Hours[hours=").append(this.hours).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Hours obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.hours, obj.hours);
   }

 }
