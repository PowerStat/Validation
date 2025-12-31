/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.time;


import java.util.Objects;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Day.
 *
 * @param day Day 1-31
 *
 * Not DSGVO relevant.
 *
 * TODO Constructor with day, month
 * TODO Constructor with day, month, year
 * TODO Listener
 */
@ValueObject
public record Day(int day) implements Comparable<Day>, IValueObject
 {
  /**
   * Minimum allowed value 1.
   */
  public static final int MIN_VALUE = 1;

  /**
   * Maximum allowed value 31.
   */
  public static final int MAX_VALUE = 31;

  /**
   * Hours within a day.
   */
  public static final Hours HOURS_WITHIN = Hours.of(24);

  /**
   * Overflow constant.
   */
  private static final String OVERFLOW = "Overflow"; //$NON-NLS-1$

  /**
   * Underflow constant.
   */
  private static final String UNDERFLOW = "Underflow"; //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param day Day 1-31
   * @throws IndexOutOfBoundsException When the day is less than 1 or greater than 31
   */
  public Day
   {
    if ((day < 1) || (day > 31))
     {
      throw new IndexOutOfBoundsException("Day number out of range (1-31)!"); //$NON-NLS-1$
     }
   }


  /**
   * Day factory.
   *
   * @param day Day 1-31
   * @return Day object
   */
  public static Day of(final int day)
   {
    return new Day(day);
   }


  /**
   * Day factory.
   *
   * @param value String value
   * @return Day object
   */
  public static Day of(final String value)
   {
    return of(Integer.parseInt(value));
   }


  /**
   * Returns the value of this Day as an String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(day);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Day obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(day, obj.day);
   }


  /**
   * Add days to this day.
   *
   * @param days Days to add to this day
   * @return New day after adding the days to this day
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings({"PMD.AvoidLiteralsInIfCondition"})
  public Day add(final Days days)
   {
    final int newDay = Math.toIntExact(Math.addExact(day, days.days()));
    if (newDay > 31) // TODO depends on month and year
     {
      // TODO Listener
      throw new ArithmeticException(Day.OVERFLOW);
     }
    return Day.of(newDay);
   }


  /**
   * Subtract days from this day.
   *
   * @param days Days to subtract from this day
   * @return New day after subtracting days from this day
   * @throws ArithmeticException In case of an underflow
   */
  public Day subtract(final Days days)
   {
    final int newDay = Math.toIntExact(Math.subtractExact(day, days.days()));
    if (newDay <= 0)
     {
      // TODO Listener
      throw new ArithmeticException(Day.UNDERFLOW);
     }
    return Day.of(newDay);
   }


  /**
   * Increment this day.
   *
   * @return New day after incrementing this day
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings({"PMD.AvoidLiteralsInIfCondition"})
  public Day increment()
   {
    final int newDay = Math.incrementExact(day);
    if (newDay == 32) // TODO depends on month and year
     {
      // TODO Listener
      throw new ArithmeticException(Day.OVERFLOW);
     }
    return Day.of(newDay);
   }


  /**
   * Decrement this day.
   *
   * @return New day after decrement this day
   * @throws ArithmeticException In case of an overflow
   */
  public Day decrement()
   {
    final int newDay = Math.decrementExact(day);
    if (newDay == 0)
     {
      // TODO Listener
      throw new ArithmeticException(Day.UNDERFLOW);
     }
    return Day.of(newDay);
   }

 }
