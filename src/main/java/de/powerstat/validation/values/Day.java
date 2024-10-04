/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Day.
 *
 * Not DSGVO relevant.
 *
 * TODO Constructor with day, month
 * TODO Constructor with day, month, year
 * TODO Listener
 * TODO hoursWithin = 24
 * TODO min, max
 */
public final class Day implements Comparable<Day>, IValueObject
 {
  /**
   * Overflow constant.
   */
  private static final String OVERFLOW = "Overflow"; //$NON-NLS-1$

  /**
   * Underflow constant.
   */
  private static final String UNDERFLOW = "Underflow"; //$NON-NLS-1$

  /* *
   * Cache for singletons.
   */
  // private static final Map<Integer, Day> CACHE = new WeakHashMap<>();

  /**
   * Day.
   */
  private final int day;


  /**
   * Constructor.
   *
   * @param day Day 1-31
   * @throws IndexOutOfBoundsException When the day is less than 1 or greater than 31
   */
  private Day(final int day)
   {
    super();
    if ((day < 1) || (day > 31))
     {
      throw new IndexOutOfBoundsException("Day number out of range (1-31)!"); //$NON-NLS-1$
     }
    this.day = day;
   }


  /**
   * Day factory.
   *
   * @param day Day 1-31
   * @return Day object
   */
  public static Day of(final int day)
   {
    /*
    synchronized (Day.class)
     {
      Day obj = Day.CACHE.get(day);
      if (obj != null)
       {
        return obj;
       }
      obj = new Day(day);
      Day.CACHE.put(Integer.valueOf(day), obj);
      return obj;
     }
    */
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
   * Returns the value of this Day as an int.
   *
   * @return The numeric value represented by this object after conversion to type int.
   */
  public int intValue()
   {
    return this.day;
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
   * Calculate hash code.
   *
   * @return Hash
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
   {
    return Integer.hashCode(this.day);
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof Day))
     {
      return false;
     }
    final Day other = (Day)obj;
    return this.day == other.day;
   }


  /**
   * Returns the string representation of this Day.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Day[day=1]"
   *
   * @return String representation of this Day
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("Day[day=").append(this.day).append(']'); //$NON-NLS-1$
    return builder.toString();
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
    final int newDay = Math.toIntExact(Math.addExact(this.day, days.longValue()));
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
    final int newDay = Math.toIntExact(Math.subtractExact(this.day, days.longValue()));
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
