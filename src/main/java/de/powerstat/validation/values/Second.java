/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Second.
   *
 * Not DSGVO relevant.
 *
   * TODO Constructor with day, month, year, hour, minute
   * TODO nextSecond, previousSecond
 */
public final class Second implements Comparable<Second>
 {
  /**
   * Second.
   */
  private final int second;


  /**
   * Constructor.
   *
   * @param second Second 0-59/60
   * @throws IndexOutOfBoundsException When the second is less than 0 or greater than 59/60
   */
  public Second(final int second)
   {
    super();
    if ((second < 0) || (second > 60))
     {
      throw new IndexOutOfBoundsException("Second number out of range (0-59/60)!"); //$NON-NLS-1$
     }
    this.second = second;
   }


  /**
   * Second factory.
   *
   * @param second Second 0-59/60
   * @return Second object
   */
  public static Second of(final int second)
   {
    return new Second(second);
   }


  /**
   * Get second.
   *
   * @return Second
   */
  public int getSecond()
   {
    return this.second;
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
    return Integer.hashCode(this.second);
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
    if (!(obj instanceof Second))
     {
      return false;
     }
    final Second other = (Second)obj;
    return this.second == other.second;
   }


  /**
   * Returns the string representation of this Second.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Second[second=1]"
   *
   * @return String representation of this Second
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Second[second=").append(this.second).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Second obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(this.second, obj.second);
   }

 }
