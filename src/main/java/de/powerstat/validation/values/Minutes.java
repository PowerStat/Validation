/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Minutes.
 *
 * @param minutes Minutes 0-..
 * 
 * Not DSGVO relevant.
 */
public record Minutes(long minutes) implements Comparable<Minutes>, IValueObject
 {
  /**
   * Constructor.
   *
   * @param minutes Minutes 0-..
   * @throws IndexOutOfBoundsException When the minutes is less than 0
   */
  public Minutes
   {
    if (minutes < 0)
     {
      throw new IndexOutOfBoundsException("Negative minutes are not allowed"); //$NON-NLS-1$
     }
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
