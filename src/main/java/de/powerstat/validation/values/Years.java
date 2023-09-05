/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Years.
 *
 * @param years Years &gt;= 0
 * 
 * Not DSGVO relevant.
 */
public record Years(long years) implements Comparable<Years>, IValueObject
 {
  /**
   * Constructor.
   *
   * @param years Years &gt;= 0
   * @throws IndexOutOfBoundsException When the year is smaller than 0
   */
  public Years
   {
    if (years < 0)
     {
      throw new IndexOutOfBoundsException("Negative years are not allowed"); //$NON-NLS-1$
     }
   }


  /**
   * Years factory.
   *
   * @param years Years &gt;= 0
   * @return Years object
   */
  public static Years of(final long years)
   {
    return new Years(years);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Years obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.years, obj.years);
   }


  /**
   * Add other years to this years.
   *
   * @param other Other years to add to this years
   * @return New years after adding other years to this years
   * @throws ArithmeticException In case of an overflow
   */
  public Years add(final Years other)
   {
    return Years.of(Math.addExact(this.years, other.years));
   }


  /**
   * Subtract other years from this years.
   *
   * @param other Other years to subtract from this one
   * @return Absolute new years after subtracting other years from this years
   */
  public Years subtract(final Years other)
   {
    if (other.years > this.years)
     {
      return Years.of(other.years - this.years);
     }
    return Years.of(this.years - other.years);
   }


  /**
   * Multiply years with a multiplier.
   *
   * @param multiplier Multiplier to multiply with
   * @return New years that is a multiplication of this years with the multiplier
   * @throws ArithmeticException In case of an overflow
   */
  public Years multiply(final long multiplier)
   {
    return Years.of(Math.multiplyExact(this.years, multiplier));
   }


  /**
   * Divide years by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The largest (closest to positive infinity) long value that is less than or equal to the algebraic quotient.
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Years divide(final long divisor)
   {
    return Years.of(Math.floorDiv(this.years, divisor));
   }


  /**
   * Floor modulo years by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The floor modulus Years - (floorDiv(Years, divisor) * divisor)
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Years modulo(final long divisor)
   {
    return Years.of(Math.floorMod(this.years, divisor));
   }

 }
