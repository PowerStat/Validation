/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.time;


import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Months.
 *
 * @param months Months 0-..
 *
 * Not DSGVO relevant.
 */
@ValueObject
public record Months(long months) implements Comparable<Months>, IValueObject
 {
  /**
   * Minimum allowed value 0.
   */
  public static final long MIN_VALUE = 0;

  /**
   * Maximum allowed value Long.MAX_VALUE.
   */
  public static final long MAX_VALUE = Long.MAX_VALUE;

  /**
   * Constructor.
   *
   * @param months Months 0-..
   * @throws IndexOutOfBoundsException When the months is less than 0
   */
  public Months
   {
    if (months < 0)
     {
      throw new IndexOutOfBoundsException("Negative months are not allowed"); //$NON-NLS-1$
     }
   }


  /**
   * Months factory.
   *
   * @param months Months 0-..
   * @return Months object
   */
  public static Months of(final long months)
   {
    return new Months(months);
   }


  /**
   * Months factory.
   *
   * @param value Months 0-.. string
   * @return Months object
   */
  public static Months of(final String value)
   {
    return of(Long.parseLong(value));
   }


  /**
   * Returns the value of this Months as a String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(months);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Months obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(months, obj.months);
   }


  /**
   * Add other months to this months.
   *
   * @param other Other months to add to this months
   * @return New months after adding other months to this months
   * @throws ArithmeticException In case of an overflow
   */
  public Months add(final Months other)
   {
    return Months.of(Math.addExact(months, other.months));
   }


  /**
   * Subtract other months from this months.
   *
   * @param other Other months to subtract from this one
   * @return Absolute new months after subtracting other months from this months
   */
  public Months subtract(final Months other)
   {
    if (other.months > months) // NO PITEST
     {
      return Months.of(other.months - months);
     }
    return Months.of(months - other.months);
   }


  /**
   * Multiply months with a multiplier.
   *
   * @param multiplier Multiplier to multiply with
   * @return New months that is a multiplication of this months with the multiplier
   * @throws ArithmeticException In case of an overflow
   */
  public Months multiply(final long multiplier)
   {
    return Months.of(Math.multiplyExact(months, multiplier));
   }


  /**
   * Divide months by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The largest (closest to positive infinity) long value that is less than or equal to the algebraic quotient.
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Months divide(final long divisor)
   {
    return Months.of(Math.floorDiv(months, divisor));
   }


  /**
   * Floor modulo months by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The floor modulus Months - (floorDiv(Months, divisor) * divisor)
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Months modulo(final long divisor)
   {
    return Months.of(Math.floorMod(months, divisor));
   }

 }
