/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Minutes.
 *
 * Not DSGVO relevant.
 */
public final class Minutes implements Comparable<Minutes>
 {
  /**
   * Minutes.
   */
  private final long minutes;


  /**
   * Constructor.
   *
   * @param minutes Minutes 0-..
   * @throws IndexOutOfBoundsException When the minutes is less than 0
   */
  public Minutes(final long minutes)
   {
    super();
    if (minutes < 0)
     {
      throw new IndexOutOfBoundsException("Negative minutes are not allowed"); //$NON-NLS-1$
     }
    this.minutes = minutes;
   }


  /**
   * Minutes factory.
   *
   * @param minutes Minutes 0-..
   * @return Minutes object
   */
  public static Minutes of(final long minutes)
   {
    return new Minutes(minutes);
   }


  /**
   * Get minutes.
   *
   * @return Minutes
   * @deprecated Use longValue() instead
   */
  @Deprecated
  public long getMinutes()
   {
    return this.minutes;
   }


  /**
   * Returns the value of this Minutes as a long.
   *
   * @return The numeric value represented by this object after conversion to type long.
   */
  public long longValue()
   {
    return this.minutes;
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
    return Long.hashCode(this.minutes);
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
    if (!(obj instanceof Minutes))
     {
      return false;
     }
    final Minutes other = (Minutes)obj;
    return this.minutes == other.minutes;
   }


  /**
   * Returns the string representation of this Minutes.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Minutes[minutes=1]"
   *
   * @return String representation of this Minutes
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(17);
    builder.append("Minutes[minutes=").append(this.minutes).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Minutes obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.minutes, obj.minutes);
   }


  /**
   * Add other minutes to this minutes.
   *
   * @param other Other minutes to add to this minutes
   * @return New minutes after adding other minutes to this minutes
   * @throws ArithmeticException In case of an overflow
   */
  public Minutes add(final Minutes other)
   {
    return Minutes.of(Math.addExact(this.minutes, other.minutes));
   }


  /**
   * Subtract other minutes from this minutes.
   *
   * @param other Other minutes to subtract from this one
   * @return Absolute new minutes after subtracting other minutes from this minutes
   */
  public Minutes subtract(final Minutes other)
   {
    if (other.minutes > this.minutes)
     {
      return Minutes.of(other.minutes - this.minutes);
     }
    return Minutes.of(this.minutes - other.minutes);
   }


  /**
   * Multiply minutes with a multiplier.
   *
   * @param multiplier Multiplier to multiply with
   * @return New minutes that is a multiplication of this minutes with the multiplier
   * @throws ArithmeticException In case of an overflow
   */
  public Minutes multiply(final long multiplier)
   {
    return Minutes.of(Math.multiplyExact(this.minutes, multiplier));
   }


  /**
   * Divide minutes by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The largest (closest to positive infinity) long value that is less than or equal to the algebraic quotient.
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Minutes divide(final long divisor)
   {
    return Minutes.of(Math.floorDiv(this.minutes, divisor));
   }


  /**
   * Floor modulo minutes by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The floor modulus Minutes - (floorDiv(Minutes, divisor) * divisor)
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Minutes modulo(final long divisor)
   {
    return Minutes.of(Math.floorMod(this.minutes, divisor));
   }

 }
