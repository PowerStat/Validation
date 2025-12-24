/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Hours.
 *
 * @param hours Hours 0-..
 *
 * Not DSGVO relevant.
 */
@ValueObject
public record Hours(long hours) implements Comparable<Hours>, IValueObject
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
   * @param hours Hours 0-..
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
   * Hours factory.
   *
   * @param value Hours 0-.. string
   * @return Hours object
   */
  public static Hours of(final String value)
   {
    return of(Long.parseLong(value));
   }


  /**
   * Returns the value of this BFPONumber as a String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(hours);
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
    return Long.compare(hours, obj.hours);
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
    return Hours.of(Math.addExact(hours, other.hours));
   }


  /**
   * Subtract other hours from this hours.
   *
   * @param other Other hours to subtract from this one
   * @return Absolute new hours after subtracting other hours from this hours
   */
  public Hours subtract(final Hours other)
   {
    if (other.hours > hours) // NO PITEST
     {
      return Hours.of(other.hours - hours);
     }
    return Hours.of(hours - other.hours);
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
    return Hours.of(Math.multiplyExact(hours, multiplier));
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
    return Hours.of(Math.floorDiv(hours, divisor));
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
    return Hours.of(Math.floorMod(hours, divisor));
   }

 }
