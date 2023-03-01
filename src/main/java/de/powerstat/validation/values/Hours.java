/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Hours.
 *
 * @param hours Hours 0-..
 * 
 * Not DSGVO relevant.
 */
public record Hours(long hours) implements Comparable<Hours>
 {
  /**
   * Constructor.
   *
   * @throws IndexOutOfBoundsException When the hours is less than 0
   */
  public Hours
   {
    if (hours < 0)
     {
      throw new IndexOutOfBoundsException("Negative hours are not allowed"); //$NON-NLS-1$
     }
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
