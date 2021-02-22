/*
 * Copyright (C) 2021 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Milliseconds.
 *
 * Not DSGVO relevant.
 */
public class Milliseconds implements Comparable<Milliseconds>
 {
  /**
   * Milliseonds.
   */
  private final long milliseconds;


  /**
   * Constructor.
   *
   * @param milliseconds Milliseconds &gt;= 0
   * @throws IndexOutOfBoundsException When the milliseonds is less than 0
   */
  public Milliseconds(final long milliseconds)
   {
    super();
    if (milliseconds < 0)
     {
      throw new IndexOutOfBoundsException("Milliseconds out of range (0-Long.MAX_VALUE)!"); //$NON-NLS-1$
     }
    this.milliseconds = milliseconds;
   }


  /**
   * Milliseconds factory.
   *
   * @param milliseconds Milliseconds 0-[Long.MAX_VALUE]
   * @return Milliseconds object
   */
  public static Milliseconds of(final long milliseconds)
   {
    return new Milliseconds(milliseconds);
   }


  /**
   * Get milliseconds.
   *
   * @return Milliseconds (0-Long.MAX_VALUE)
   */
  public long getMilliseconds()
   {
    return this.milliseconds;
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
    return Long.hashCode(this.milliseconds);
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
    if (!(obj instanceof Milliseconds))
     {
      return false;
     }
    final Milliseconds other = (Milliseconds)obj;
    return this.milliseconds == other.milliseconds;
   }


  /**
   * Returns the string representation of this Milliseconds.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Milliseconds[milliseconds=0]"
   *
   * @return String representation of this Milliseconds
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(27);
    builder.append("Milliseconds[milliseconds=").append(this.milliseconds).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Milliseconds obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.milliseconds, obj.milliseconds);
   }

 }
