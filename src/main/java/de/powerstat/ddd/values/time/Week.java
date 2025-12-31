/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.time;


import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Week.
 *
 * @param week Week 1-53
 *
 * Not DSGVO relevant.
 *
 * TODO Constructor with year
 * TODO Listener
 */
@ValueObject
public record Week(int week) implements Comparable<Week>, IValueObject
 {
  /**
   * Minimum allowed value 1.
   */
  public static final int MIN_VALUE = 1;

  /**
   * Maximum allowed value 53.
   */
  public static final int MAX_VALUE = 53;

  /**
   * Days within a week.
   */
  public static final Days DAYS_WITHIN = Days.of(7);

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
   * @param week Week 1-53
   * @throws IndexOutOfBoundsException When the week is less than 1 or greater than 53
   */
  public Week
   {
    if ((week < 1) || (week > 53))
     {
      throw new IndexOutOfBoundsException("Week number out of range (1-53)!"); //$NON-NLS-1$
     }
   }


  /**
   * Week factory.
   *
   * @param week Week 1-53
   * @return Week object
   */
  public static Week of(final int week)
   {
    return new Week(week);
   }


  /**
   * Week factory.
   *
   * @param value Week 1-53 string
   * @return Week object
   */
  public static Week of(final String value)
   {
    return of(Integer.parseInt(value));
   }


  /**
   * Returns the value of this Week as an String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(week);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Week obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(week, obj.week);
   }


  /**
   * Add weeks to this week.
   *
   * @param weeks Weeks to add to this week
   * @return New week after adding the weeks to this week
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Week add(final Weeks weeks)
   {
    final int newWeek = Math.toIntExact(Math.addExact(week, weeks.weeks()));
    if (newWeek > 53) // TODO 52 depends on year
     {
      // TODO Listener
      throw new ArithmeticException(Week.OVERFLOW);
     }
    return Week.of(newWeek);
   }


  /**
   * Subtract weeks from this week.
   *
   * @param weeks Weeks to subtract from this week
   * @return New week after subtracting weeks from this week
   * @throws ArithmeticException In case of an underflow
   */
  public Week subtract(final Weeks weeks)
   {
    final int newWeek = Math.toIntExact(Math.subtractExact(week, weeks.weeks()));
    if (newWeek <= 0)
     {
      // TODO Listener
      throw new ArithmeticException(Week.UNDERFLOW);
     }
    return Week.of(newWeek);
   }


  /**
   * Increment this week.
   *
   * @return New week after incrementing this week
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Week increment()
   {
    final int newWeek = Math.incrementExact(week);
    if (newWeek == 54) // TODO 53 depending on year
     {
      // TODO Listener
      throw new ArithmeticException(Week.OVERFLOW);
     }
    return Week.of(newWeek);
   }


  /**
   * Decrement this week.
   *
   * @return New week after decrement this week
   * @throws ArithmeticException In case of an overflow
   */
  public Week decrement()
   {
    final int newWeek = Math.decrementExact(week);
    if (newWeek == 0)
     {
      // TODO Listener
      throw new ArithmeticException(Week.UNDERFLOW);
     }
    return Week.of(newWeek);
   }

 }
