/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values;


import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Year.
 *
 * @param calendarSystem Calendar system: julian, gregorian
 * @param year Year != 0
 *
 * Not DSGVO relevant.
 */
@ValueObject
public record Year(CalendarSystems calendarSystem, long year) implements Comparable<Year>, IValueObject
 {
  /**
   * Minimum allowed value 8.
   */
  public static final long MIN_VALUE = 8;

  /**
   * Maximum allowed value Long.MAX_VALUE.
   */
  public static final long MAX_VALUE = Long.MAX_VALUE;

  /**
   * Months within year.
   */
  public static final Months MONTHS_WITHIN = Months.of(12);

  /**
   * Unsupported calendar system constant.
   */
  private static final String UNSUPPORTED_CALENDAR_SYSTEM = "Unsupported calendar system!";

  /**
   * Year of Gregorian calendar reform.
   *
   * TODO Country dependend.
   */
  private static final long BEFORE_GREGORIAN_YEAR = 1582;


  /**
   * Constructor.
   *
   * @param calendarSystem Calendar system: julian, gregorian
   * @param year Year != 0
   * @throws IndexOutOfBoundsException When the year is 0
   */
  public Year
   {
    if (year == 0)
     {
      throw new IndexOutOfBoundsException("Year 0 does not exist!"); //$NON-NLS-1$
     }
   }


  /**
   * Year factory.
   *
   * @param calendarSystem Calendar system
   * @param year Year != 0
   * @return Year object
   */
  public static Year of(final CalendarSystems calendarSystem, final long year)
   {
    return new Year(calendarSystem, year);
   }


  /**
   * Gregorian calendar year factory.
   *
   * @param year Year != 0
   * @return Year object
   */
  public static Year of(final long year)
   {
    return of(CalendarSystems.GREGORIAN, year);
   }


  /**
   * Gregorian calendar year factory.
   *
   * @param value Year != 0 string
   * @return Year object
   */
  public static Year of(final String value)
   {
    return of(CalendarSystems.GREGORIAN, Long.parseLong(value));
   }


  /**
   * Returns the value of this Year as an String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(year);
   }


  /**
   * Calendar system dependent leap year.
   *
   * @return true: is leap year; false otherwise
   * @throws IllegalStateException When an unsupported calendar system is used
   */
  public boolean isLeapYear()
   {
    switch (calendarSystem)
     {
      case JULIAN:
        return JulianCalendar.of().isLeapYear(this);
      case GREGORIAN:
        if (year < BEFORE_GREGORIAN_YEAR) // Country dependend // NO PITEST
         {
          return JulianCalendar.of().isLeapYear(this);
         }
        else
         {
          return GregorianCalendar.of().isLeapYear(this);
         }
      default:
        throw new IllegalStateException(UNSUPPORTED_CALENDAR_SYSTEM);
     }
   }


  /**
   * Leap year dependent days within year.
   *
   * @return Days within year
   * @throws IllegalStateException When an unsupported calendar system is used
   */
  public Days daysWithin()
   {
    switch (calendarSystem)
     {
      case JULIAN:
        return Days.of(365L + (this.isLeapYear() ? 1 : 0));
      case GREGORIAN:
        if (year == BEFORE_GREGORIAN_YEAR) // Country dependend
         {
          return Days.of(365L - 10); // Country dependend
         }
        return Days.of(365L + (this.isLeapYear() ? 1 : 0));
      default:
        throw new IllegalStateException(UNSUPPORTED_CALENDAR_SYSTEM);
     }
   }


  /**
   * Weeks within year.
   *
   * @return Weeks within year (50, 51,) 52, 53
   */
  public Weeks weeksWithin()
   {
    // long weeks = daysWithin().longValue() / 7;   // 355, ..., 365, 366 -> 50, 52
    // boolean leap = isLeapYear();
    // firstweekday = weekday(1, 1, this.year);
    // if (firstweekday == Do || ((firstweekday == Mi && leap == 1)))
    //  {
    //   ++weeks;
    //  }
    return Weeks.of(0); // TODO = (50, 51,) 52, 53 (CalendarSystem, ISO vs US)
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @throws IllegalStateException When the calendarSystems of the two years are not equal
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Year obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    if (calendarSystem.compareTo(obj.calendarSystem) != 0)
     {
      throw new IllegalStateException("CalendarSystems are not equal!");
     }
    return Long.compare(year, obj.year);
   }


  /**
   * Add years to this year.
   *
   * @param years Years to add to this year
   * @return New year after adding the years to this year with same calendarSystem
   * @throws ArithmeticException In case of an overflow
   */
  public Year add(final Years years)
   {
    long newYear = Math.addExact(year, years.years());
    if ((year < 0) && (newYear >= 0))
     {
      newYear = Math.incrementExact(newYear); // Because there is no year 0!
     }
    return Year.of(calendarSystem, newYear);
   }


  /**
   * Subtract years from this year.
   *
   * @param years Years to subtract from this year
   * @return New year after subtracting years from this year with same calendarSystem
   * @throws ArithmeticException In case of an underflow
   */
  public Year subtract(final Years years)
   {
    long newYear = Math.subtractExact(year, years.years());
    if ((year > 0) && (newYear <= 0))
     {
      newYear = Math.decrementExact(newYear); // Because there is no year 0!
     }
    return Year.of(calendarSystem, newYear);
   }


  /**
   * Increment this year.
   *
   * @return New year after incrementing this year
   * @throws ArithmeticException In case of an overflow
   */
  public Year increment()
   {
    long newYear = Math.incrementExact(year);
    if (year == -1)
     {
      newYear = Math.incrementExact(newYear); // Because there is no year 0!
     }
    return Year.of(newYear);
   }


  /**
   * Decrement this year.
   *
   * @return New year after decrement this year
   * @throws ArithmeticException In case of an overflow
   */
  public Year decrement()
   {
    long newYear = Math.decrementExact(year);
    if (year == 1)
     {
      newYear = Math.decrementExact(newYear); // Because there is no year 0!
     }
    return Year.of(newYear);
   }

 }
