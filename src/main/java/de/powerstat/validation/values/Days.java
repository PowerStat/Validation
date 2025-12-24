/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Days.
 *
 * @param days Days 0-..
 *
 * Not DSGVO relevant.
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
@ValueObject
public record Days(long days) implements Comparable<Days>, IValueObject
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
   * @param days Days 0-..
   * @throws IndexOutOfBoundsException When the day is less than 0
   */
  public Days
   {
    if (days < 0)
     {
      throw new IndexOutOfBoundsException("Negative days are not allowed"); //$NON-NLS-1$
     }
   }


  /**
   * Days factory.
   *
   * @param days Days 0-..
   * @return Days object
   */
  public static Days of(final long days)
   {
    return new Days(days);
   }


  /**
   * Days factory.
   *
   * @param value String value
   * @return Days object
   */
  public static Days of(final String value)
   {
    return of(Long.parseLong(value));
   }


  /**
   * Returns the value of this Days as a String.
   *
   * @return The numeric value represented by this object after conversion to type STring.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(days);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Days obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(days, obj.days);
   }


  /**
   * Add other days to this days.
   *
   * @param other Other days to add to this days
   * @return New days after adding other days to this days
   * @throws ArithmeticException In case of an overflow
   */
  public Days add(final Days other)
   {
    return Days.of(Math.addExact(days, other.days));
   }


  /**
   * Subtract other days from this days.
   *
   * @param other Other days to subtract from this one
   * @return Absolute new days after subtracting other days from this days
   */
  public Days subtract(final Days other)
   {
    if (other.days > days) // NO PITEST
     {
      return Days.of(other.days - days);
     }
    return Days.of(days - other.days);
   }


  /**
   * Multiply days with a multiplier.
   *
   * @param multiplier Multiplier to multiply with
   * @return New days that is a multiplication of this days with the multiplier
   * @throws ArithmeticException In case of an overflow
   */
  public Days multiply(final long multiplier)
   {
    return Days.of(Math.multiplyExact(days, multiplier));
   }


  /**
   * Divide days by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The largest (closest to positive infinity) long value that is less than or equal to the algebraic quotient.
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Days divide(final long divisor)
   {
    return Days.of(Math.floorDiv(days, divisor));
   }


  /**
   * Floor modulo days by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The floor modulus Days - (floorDiv(Days, divisor) * divisor)
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Days modulo(final long divisor)
   {
    return Days.of(Math.floorMod(days, divisor));
   }

 }
