/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Seconds.
 *
 * Not DSGVO relevant.
 *
 * TODO add/subtract
 * TODO mult/div (60 = minute)
 * TODO Listener (mod 60 = 0)
 */
public class Seconds implements Comparable<Seconds>
 {
  /**
   * Seconds.
   */
  private final long seconds;


  /**
   * Constructor.
   *
   * @param seconds Seconds 0-..
   * @throws IndexOutOfBoundsException When the seconds is less than 0
   */
  public Seconds(final long seconds)
   {
    super();
    if (seconds < 0)
     {
      throw new IndexOutOfBoundsException("Negative seconds are not allowed"); //$NON-NLS-1$
     }
    this.seconds = seconds;
   }


  /**
   * Seconds factory.
   *
   * @param seconds Seconds 0-..
   * @return Seconds object
   */
  public static Seconds of(final long seconds)
   {
    return new Seconds(seconds);
   }


  /**
   * Get seconds.
   *
   * @return Seconds
   */
  public long getSeconds()
   {
    return this.seconds;
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
    return Long.hashCode(this.seconds);
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
    if (!(obj instanceof Seconds))
     {
      return false;
     }
    final Seconds other = (Seconds)obj;
    return this.seconds == other.seconds;
   }


  /**
   * Returns the string representation of this Seconds.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Seconds[seconds=1]"
   *
   * @return String representation of this Seconds
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Seconds[seconds=").append(this.seconds).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Seconds obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.seconds, obj.seconds);
   }

 }
