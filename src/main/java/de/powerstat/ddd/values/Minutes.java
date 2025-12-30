/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values;


import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Minutes.
 *
 * @param minutes Minutes 0-..
 *
 * Not DSGVO relevant.
 */
@ValueObject
public record Minutes(long minutes) implements Comparable<Minutes>, IValueObject
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
   * Minutes factory.
   *
   * @param value Minutes 0-.. string
   * @return Minutes object
   */
  public static Minutes of(final String value)
   {
    return of(Long.parseLong(value));
   }


  /**
   * Returns the value of this Minutes as a String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(minutes);
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
    return Long.compare(minutes, obj.minutes);
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
    return Minutes.of(Math.addExact(minutes, other.minutes));
   }


  /**
   * Subtract other minutes from this minutes.
   *
   * @param other Other minutes to subtract from this one
   * @return Absolute new minutes after subtracting other minutes from this minutes
   */
  public Minutes subtract(final Minutes other)
   {
    if (other.minutes > minutes) // NO PITEST
     {
      return Minutes.of(other.minutes - minutes);
     }
    return Minutes.of(minutes - other.minutes);
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
    return Minutes.of(Math.multiplyExact(minutes, multiplier));
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
    return Minutes.of(Math.floorDiv(minutes, divisor));
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
    return Minutes.of(Math.floorMod(minutes, divisor));
   }

 }
