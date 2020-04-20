/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Minute.
 *
 * TODO nextMinute, previousMinute
 */
public class Minute implements Comparable<Minute>
 {
  /**
   * Minute.
   */
  private final int minute;


  /**
   * Constructor.
   *
   * @param minute Minute 0-59
   * @throws IndexOutOfBoundsException When the minute is less than 0 or greater than 59
   */
  public Minute(final int minute)
   {
    super();
    if ((minute < 0) || (minute > 59))
     {
      throw new IndexOutOfBoundsException("Minute number out of range (0-59)!"); //$NON-NLS-1$
     }
    this.minute = minute;
   }


  /**
   * Minute factory.
   *
   * @param minute Minute 0-59
   * @return Minute object
   */
  public static Minute of(final int minute)
   {
    return new Minute(minute);
   }


  /**
   * Get minute.
   *
   * @return Minute
   */
  public int getMinute()
   {
    return this.minute;
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
    return Integer.hashCode(this.minute);
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
    if (!(obj instanceof Minute))
     {
      return false;
     }
    final Minute other = (Minute)obj;
    return this.minute == other.minute;
   }


  /**
   * Returns the string representation of this Minute.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Minute[minute=1]"
   *
   * @return String representation of this Minute
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Minute[minute=").append(this.minute).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Minute obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(this.minute, obj.minute);
   }

 }
