/*
 * Copyright (C) 2021 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Millisecond.
 *
 * Not DSGVO relevant.
 */
public final class Millisecond implements Comparable<Millisecond>
 {
  /**
   * Milliseond.
   */
  private final int millisecond;


  /**
   * Constructor.
   *
   * @param millisecond Millisecond 0-999
   * @throws IndexOutOfBoundsException When the milliseond is less than 0 or greater than 999
   */
  public Millisecond(final int millisecond)
   {
    super();
    if ((millisecond < 0) || (millisecond > 999))
     {
      throw new IndexOutOfBoundsException("Millisecond out of range (0-999)!"); //$NON-NLS-1$
     }
    this.millisecond = millisecond;
   }


  /**
   * Millisecond factory.
   *
   * @param millisecond Millisecond 0-999
   * @return Millisecond object
   */
  public static Millisecond of(final int millisecond)
   {
    return new Millisecond(millisecond);
   }


  /**
   * Get millisecond.
   *
   * @return Millisecond (0-999)
   */
  public int getMillisecond()
   {
    return this.millisecond;
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
    return Integer.hashCode(this.millisecond);
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
    if (!(obj instanceof Millisecond))
     {
      return false;
     }
    final Millisecond other = (Millisecond)obj;
    return this.millisecond == other.millisecond;
   }


  /**
   * Returns the string representation of this Millisecond.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Millisecond[millisecond=0]"
   *
   * @return String representation of this Millisecond
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(25);
    builder.append("Millisecond[millisecond=").append(this.millisecond).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Millisecond obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(this.millisecond, obj.millisecond);
   }

 }
