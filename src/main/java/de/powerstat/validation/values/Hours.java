/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Hours.
 *
 * Not DSGVO relevant.
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
   * @deprecated Use longValue() instead
   */
  @Deprecated
  public long getHours()
   {
    return this.hours;
   }


  /**
   * Returns the value of this BFPONumber as a long.
   *
   * @return The numeric value represented by this object after conversion to type long.
   */
  public long longValue()
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


  /**
   * Add other hours to this hours.
   *
   * @param other Other hours to add to this hours
   * @return New hours after adding other hours to this hours
   * @throws ArithmeticException In case of an overflow
   */
  public Hours add(final Hours other)
   {
    return Hours.of(Math.addExact(this.hours, other.hours));
   }


  /**
   * Subtract other hours from this hours.
   *
   * @param other Other hours to subtract from this one
   * @return Absolute new hours after subtracting other hours from this hours
   */
  public Hours subtract(final Hours other)
   {
    if (other.hours > this.hours)
     {
      return Hours.of(other.hours - this.hours);
     }
    return Hours.of(this.hours - other.hours);
   }


  /**
   * Multiply hours with a multiplier.
   *
   * @param multiplier Multiplier to multiply with
   * @return New hours that is a multiplication of this hours with the multiplier
   * @throws ArithmeticException In case of an overflow
   */
  public Hours multiply(final long multiplier)
   {
    return Hours.of(Math.multiplyExact(this.hours, multiplier));
   }


  /**
   * Divide hours by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The largest (closest to positive infinity) long value that is less than or equal to the algebraic quotient.
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Hours divide(final long divisor)
   {
    return Hours.of(Math.floorDiv(this.hours, divisor));
   }


  /**
   * Floor modulo hours by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The floor modulus Hours - (floorDiv(Hours, divisor) * divisor)
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Hours modulo(final long divisor)
   {
    return Hours.of(Math.floorMod(this.hours, divisor));
   }

 }
