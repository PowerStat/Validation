/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


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
 * TODO hoursWithin = 24
 * TODO min, max
 */
public record Day(int day) implements Comparable<Day>, IValueObject
 {
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
    return String.valueOf(this.day);
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
    return Integer.compare(this.day, obj.day);
   }


  /**
   * Add days to this day.
   *
   * @param days Days to add to this day
   * @return New day after adding the days to this day
   * @throws ArithmeticException In case of an overflow
   */
  public Day add(final Days days)
   {
    final int newDay = Math.toIntExact(Math.addExact(this.day, days.days()));
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
    final int newDay = Math.toIntExact(Math.subtractExact(this.day, days.days()));
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
  public Day increment()
   {
    final int newDay = Math.incrementExact(this.day);
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
    final int newDay = Math.decrementExact(this.day);
    if (newDay == 0)
     {
      // TODO Listener
      throw new ArithmeticException(Day.UNDERFLOW);
     }
    return Day.of(newDay);
   }

 }
