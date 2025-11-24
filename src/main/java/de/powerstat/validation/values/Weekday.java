/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Weekday.
 *
 * @param weekday Weekday 1-7 where Monday = 1
 *
 * Not DSGVO relevant.
 *
 * TODO constructor with week, year
 * TODO Listener
 * TODO Translations short/long name
 */
public record Weekday(int weekday) implements Comparable<Weekday>, IValueObject
 {
  /**
   * Minimum allowed value 1.
   */
  public static final int MIN_VALUE = 1;

  /**
   * Maximum allowed value L7.
   */
  public static final int MAX_VALUE = 7;

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
   * @param weekday Weekday 1-7 where Monday = 1
   * @throws IndexOutOfBoundsException When the weekday is less than 1 or greater than 7
   */
  public Weekday
   {
    if ((weekday < 1) || (weekday > 7))
     {
      throw new IndexOutOfBoundsException("Weekday number out of range (1-7)!"); //$NON-NLS-1$
     }
   }


  /**
   * Weekday factory.
   *
   * @param weekday Weekday 1-7 where Monday = 1
   * @return Weekday object
   * @throws IndexOutOfBoundsException When the weekday is less than 1 or greater than 7
   */
  public static Weekday of(final int weekday)
   {
    return new Weekday(weekday);
   }


  /**
   * Weekday factory.
   *
   * @param value Weekday 1-7 string
   * @return Weekday object
   * @throws IndexOutOfBoundsException When the weekday is less than 1 or greater than 7
   */
  public static Weekday of(final String value)
   {
    return of(Integer.parseInt(value));
   }


  /**
   * Returns the value of this Weekday as an String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(weekday); // TODO language or english text
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Weekday obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(weekday, obj.weekday);
   }


  /**
   * Add weekdays to this weekday.
   *
   * @param days Days to add to this weekday
   * @return New weekday after adding the weekdays to this weekday
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Weekday add(final Days days)
   {
    final long newWeekday = Math.toIntExact(Math.addExact(weekday, days.days()));
    if (newWeekday > 7) // while (newWeekday > 7)
     {
      // TODO Listener
      // newWeekday -= 7;
      // incrementWeek();
      throw new ArithmeticException(Weekday.OVERFLOW);
     }
    return Weekday.of(Math.toIntExact(newWeekday));
   }


  /**
   * Subtract days from this weekday.
   *
   * @param days Days to subtract from this weekday
   * @return New weekday after subtracting days from this weekday
   * @throws ArithmeticException In case of an underflow
   */
  public Weekday subtract(final Days days)
   {
    final long newWeekday = Math.toIntExact(Math.subtractExact(weekday, days.days()));
    if (newWeekday <= 0) // while (newWeekday <= 0)
     {
      // TODO Listener
      // newWeekday += 7;
      // decrementYear();
      throw new ArithmeticException(Weekday.UNDERFLOW);
     }
    return Weekday.of(Math.toIntExact(newWeekday));
   }


  /**
   * Increment this weekday.
   *
   * @return New weekday after incrementing this weekday
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Weekday increment()
   {
    final int newWeekday = Math.incrementExact(weekday);
    if (newWeekday == 8)
     {
      // TODO Listener
      // newWeekday = 1;
      // incrementYear();
      throw new ArithmeticException(Weekday.OVERFLOW);
     }
    return Weekday.of(newWeekday);
   }


  /**
   * Decrement this weekday.
   *
   * @return New weekday after decrement this weekday
   * @throws ArithmeticException In case of an overflow
   */
  public Weekday decrement()
   {
    final int newWeekday = Math.decrementExact(weekday);
    if (newWeekday == 0)
     {
      // TODO Listener
      // newWeekday = 7;
      // decrementYear();
      throw new ArithmeticException(Weekday.UNDERFLOW);
     }
    return Weekday.of(newWeekday);
   }

 }
