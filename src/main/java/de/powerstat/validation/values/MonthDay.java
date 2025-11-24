/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Day within month.
 *
 * Not DSGVO relevant.
 *
 * TODO LeapYear support
 * TODO min, max  01.01.    31.12.
 */
public final class MonthDay implements Comparable<MonthDay>, IValueObject
 {
  /**
   * Avoid literals in if conditions.
   */
  private static final String PMD_AVOID_LITERALS_IN_IF_CONDITION = "PMD.AvoidLiteralsInIfCondition";

  /**
   * Date separator.
   */
  private static final String DATE_SEP = "-"; //$NON-NLS-1$

  /**
   * Month.
   */
  private final Month month;

  /**
   * Day.
   */
  private final Day day;


  /**
   * Constructor.
   *
   * @param month Month
   * @param day Day
   * @throws NullPointerException When month or day is null
   * @throws IndexOutOfBoundsException When the day is less than 1 or greater than 31 or the day is to large for the month.
   * @throws IllegalStateException When the month is in an illegal state
   */
  @SuppressWarnings(PMD_AVOID_LITERALS_IN_IF_CONDITION)
  private MonthDay(final Month month, final Day day)
   {
    super();
    Objects.requireNonNull(month, "month"); //$NON-NLS-1$
    Objects.requireNonNull(day, "day"); //$NON-NLS-1$
    switch (month.intValue())
     {
      case 1, 3, 5, 7, 8, 10, 12:
        break;

      case 4, 6, 9, 11:
        if (day.intValue() > 30)
         {
          throw new IndexOutOfBoundsException("Day number out of range for the month (31)!"); //$NON-NLS-1$
         }
        break;

      case 2:
        if (day.intValue() > 29)
         {
          throw new IndexOutOfBoundsException("Day number out of range for the month (30-31)!"); //$NON-NLS-1$
         }
        break;

      default:
        throw new IllegalStateException("Illegal month!"); //$NON-NLS-1$
     }
    this.month = month;
    this.day = day;
   }


  /**
   * DayMonth factory.
   *
   * @param month Month 1-12
   * @param day Day 1-31
   * @return DayMonth object
   */
  public static MonthDay of(final Month month, final Day day)
   {
    return new MonthDay(month, day);
   }


  /**
   * DayMonth factory.
   *
   * @param value ISO8601 format [m]m-[d]d
   * @return DayMonth object
   */
  @SuppressWarnings(PMD_AVOID_LITERALS_IN_IF_CONDITION)
  public static MonthDay of(final String value)
   {
    final String[] values = value.split(DATE_SEP);
    if (values.length != 2)
     {
      throw new IllegalArgumentException("value not of required format");
     }
    return of(Month.of(values[0]), Day.of(values[1]));
   }


  /**
   * Returns the month value of this DayMonth.
   *
   * @return The month value represented by this object.
   */
  public Month monthValue()
   {
    return month;
   }


  /**
   * Returns the day value of this DayMonth.
   *
   * @return The day value represented by this object.
   */
  public Day dayValue()
   {
    return day;
   }


  /**
   * Returns the String value of this DayMonth in ISO8601 format.
   *
   * @return The String value represented by this object ([m]m-[d]d).
   */
  @Override
  public String stringValue()
   {
    return month.stringValue() + DATE_SEP + day.stringValue();
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
    return Objects.hash(month, day);
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
    // if ((obj == null) || (this.getClass() != obj.getClass()))
    if (!(obj instanceof final MonthDay other))
     {
      return false;
     }
    boolean result = month.equals(other.month);
    if (result)
     {
      result = day.equals(other.day);
     }
    return result;
   }


  /**
   * Returns the string representation of this DayMonth.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "DayMonth[month=1, day=1]"
   *
   * @return String representation of this DayMonth
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(22);
    builder.append("MonthDay[month=").append(month).append(", day=").append(day).append(']'); //$NON-NLS-1$
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
  public int compareTo(final MonthDay obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = month.compareTo(obj.month);
    if (result == 0)
     {
      result = day.compareTo(obj.day);
     }
    return result;
   }


  /**
   * Fix day if necessary (day > lastDayInMonth).
   *
   * @param month Month
   * @return Fixed day
   */
  private int fixDay(final Month month)
   {
    final long lastDayInMonth = month.daysInMonth().longValue();
    int newDay = day.intValue();
    if (day.intValue() > lastDayInMonth) // NO PITEST
     {
      newDay = (int)lastDayInMonth;
     }
    return newDay;
   }


  /**
   * Add months to this MonthDay.
   *
   * @param months Months to add to this MonthDay
   * @return New MonthDay after adding the months to this MonthDay
   */
  public MonthDay add(final Months months)
   {
    long newMonth = Math.toIntExact(Math.addExact(month.intValue(), months.longValue()));
    while (newMonth > 12)
     {
      // TODO Listener year
      newMonth -= 12;
      // incrementYear();
     }
    final Month month = Month.of(Math.toIntExact(newMonth));
    final int newDay = fixDay(month);
    return MonthDay.of(month, Day.of(newDay));
   }


  /**
   * Add days to this MonthDay.
   *
   * @param days Days to add to this MonthDay
   * @return New MonthDay after adding the days to this MonthDay
   */
  @SuppressWarnings(PMD_AVOID_LITERALS_IN_IF_CONDITION)
  public MonthDay add(final Days days)
   {
    long newDay = Math.toIntExact(Math.addExact(day.intValue(), days.longValue()));
    int newMonth = month.intValue();
    while (newDay > Month.of(newMonth).daysInMonth().longValue())
     {
      newDay -= Month.of(newMonth).daysInMonth().longValue();
      ++newMonth;
      if (newMonth > 12)
       {
        newMonth = 1;
        // incrementYear()
        // TODO Listener Year
       }
     }
    return MonthDay.of(Month.of(newMonth), Day.of(Math.toIntExact(newDay)));
   }


  /**
   * Subtract months from this MonthDay.
   *
   * @param months Months to subtract from this MonthDay
   * @return New MonthDay after subtracting months from this MonthDay
   */
  public MonthDay subtract(final Months months)
   {
    long newMonth = Math.toIntExact(Math.subtractExact(month.intValue(), months.longValue()));
    while (newMonth <= 0)
     {
      // TODO Listener year
      newMonth += 12;
      // decrementYear();
     }
    final Month month = Month.of(Math.toIntExact(newMonth));
    final int newDay = fixDay(month);
    return MonthDay.of(month, Day.of(newDay));
   }


  /**
   * Subtract days from this MonthDay.
   *
   * @param days Days to subtract from this MonthDay
   * @return New MonthDay after subtrating the days from this MonthDay
   */
  public MonthDay subtract(final Days days)
   {
    long newDay = Math.toIntExact(Math.subtractExact(day.intValue(), days.longValue()));
    int newMonth = month.intValue();
    while (newDay < 1)
     {
      --newMonth;
      if (newMonth < 1)
       {
        newMonth = 12;
        // decrementYear()
        // TODO Listener Year
       }
      newDay += Month.of(newMonth).daysInMonth().longValue();
     }
    return MonthDay.of(Month.of(newMonth), Day.of(Math.toIntExact(newDay)));
   }


  /**
   * Increment this MonthDay by one month.
   *
   * @return New MonthDay after incrementing this MonthDay by one month
   */
  @SuppressWarnings(PMD_AVOID_LITERALS_IN_IF_CONDITION)
  public MonthDay incrementMonth()
   {
    int newMonth = Math.incrementExact(month.intValue());
    if (newMonth == 13)
     {
      // TODO Listener year
      newMonth = 1;
      // incrementYear();
     }
    final Month month = Month.of(Math.toIntExact(newMonth));
    final int newDay = fixDay(month);
    return MonthDay.of(month, Day.of(newDay));
   }


  /**
   * Decrement this MonthDay by one month.
   *
   * @return New MonthDay after decrement this MonthDay by one month
   */
  public MonthDay decrementMonth()
   {
    int newMonth = Math.decrementExact(month.intValue());
    if (newMonth == 0)
     {
      // TODO Listener year
      newMonth = 12;
      // decrementYear();
     }
    final Month month = Month.of(Math.toIntExact(newMonth));
    final int newDay = fixDay(month);
    return MonthDay.of(month, Day.of(newDay));
   }


  /**
   * Increment this MonthDay by one day.
   *
   * @return New MonthDay after incrementing this MonthDay by one day
   */
  @SuppressWarnings(PMD_AVOID_LITERALS_IN_IF_CONDITION)
  public MonthDay incrementDay()
   {
    int newMonth = month.intValue();
    int newDay = Math.incrementExact(day.intValue());
    if (newDay > month.daysInMonth().longValue())
     {
      newDay -= month.daysInMonth().longValue();
      // TODO Listener month
      ++newMonth;
      if (newMonth > 12)
       {
        newMonth = 1;
        // TODO Listener year
        // incrementYear();
       }
     }
    return MonthDay.of(Month.of(Math.toIntExact(newMonth)), Day.of(newDay));
   }


  /**
   * Decrement this MonthDay by one day.
   *
   * @return New MonthDay after decrementing this MonthDay by one day
   */
  public MonthDay decrementDay()
   {
    int newMonth = month.intValue();
    int newDay = Math.decrementExact(day.intValue());
    if (newDay < 1)
     {
      // TODO Listener month
      --newMonth;
      if (newMonth < 1)
       {
        newMonth = 12;
        // TODO Listener year
        // incrementYear();
       }
      newDay += Month.of(newMonth).daysInMonth().longValue();
     }
    return MonthDay.of(Month.of(Math.toIntExact(newMonth)), Day.of(newDay));
   }

 }
