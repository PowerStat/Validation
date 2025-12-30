/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values;


import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Years.
 *
 * @param years Years &gt;= 0
 *
 * Not DSGVO relevant.
 */
@ValueObject
public record Years(long years) implements Comparable<Years>, IValueObject
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
   * Years factory.
   *
   * @param value Years &gt;= 0 string
   * @return Years object
   */
  public static Years of(final String value)
   {
    return of(Long.parseLong(value));
   }


  /**
   * Returns the value of this Years as an String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(years);
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
    return Long.compare(years, obj.years);
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
    return Years.of(Math.addExact(years, other.years));
   }


  /**
   * Subtract other years from this years.
   *
   * @param other Other years to subtract from this one
   * @return Absolute new years after subtracting other years from this years
   */
  public Years subtract(final Years other)
   {
    if (other.years > years) // NO PITEST
     {
      return Years.of(other.years - years);
     }
    return Years.of(years - other.years);
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
    return Years.of(Math.multiplyExact(years, multiplier));
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
    return Years.of(Math.floorDiv(years, divisor));
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
    return Years.of(Math.floorMod(years, divisor));
   }

 }
