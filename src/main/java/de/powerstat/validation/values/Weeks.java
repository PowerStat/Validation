/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Weeks.
 *
 * @param weeks Weeks 0-..
 * 
 * Not DSGVO relevant.
 */
public record Weeks(long weeks) implements Comparable<Weeks>, IValueObject
 {
  /**
   * Constructor.
   *
   * @param weeks Weeks 0-..
   * @throws IndexOutOfBoundsException When the week is less than 0
   */
  public Weeks
   {
    if (weeks < 0)
     {
      throw new IndexOutOfBoundsException("Negative weeks are not allowed"); //$NON-NLS-1$
     }
   }


  /**
   * Weeks factory.
   *
   * @param weeks Weeks 0-..
   * @return Weeks object
   */
  public static Weeks of(final long weeks)
   {
    return new Weeks(weeks);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Weeks obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.weeks, obj.weeks);
   }


  /**
   * Add other weeks to this years.
   *
   * @param other Other weeks to add to this weeks
   * @return New weeks after adding other weeks to this weeks
   * @throws ArithmeticException In case of an overflow
   */
  public Weeks add(final Weeks other)
   {
    return Weeks.of(Math.addExact(this.weeks, other.weeks));
   }


  /**
   * Subtract other weeks from this weeks.
   *
   * @param other Other weeks to subtract from this one
   * @return Absolute new weeks after subtracting other weeks from this weeks
   */
  public Weeks subtract(final Weeks other)
   {
    if (other.weeks > this.weeks)
     {
      return Weeks.of(other.weeks - this.weeks);
     }
    return Weeks.of(this.weeks - other.weeks);
   }


  /**
   * Multiply weeks with a multiplier.
   *
   * @param multiplier Multiplier to multiply with
   * @return New weeks that is a multiplication of this weeks with the multiplier
   * @throws ArithmeticException In case of an overflow
   */
  public Weeks multiply(final long multiplier)
   {
    return Weeks.of(Math.multiplyExact(this.weeks, multiplier));
   }


  /**
   * Divide weeks by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The largest (closest to positive infinity) long value that is less than or equal to the algebraic quotient.
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Weeks divide(final long divisor)
   {
    return Weeks.of(Math.floorDiv(this.weeks, divisor));
   }


  /**
   * Floor modulo weeks by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The floor modulus Weeks - (floorDiv(Weeks, divisor) * divisor)
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Weeks modulo(final long divisor)
   {
    return Weeks.of(Math.floorMod(this.weeks, divisor));
   }

 }
