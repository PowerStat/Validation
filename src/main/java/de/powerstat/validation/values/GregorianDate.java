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
 * Gregorian calendar date.
 *
 * @param calendar Gregorian calendar
 * @param year Year
 * @param month Month
 * @param day Day
 *
 * Not DSGVO relevant.
 *
 * TODO next day
 * TODO previous day
 * TODO add x days
 * TODO subtract x days
 * TODO add days, months, years
 * TODO subtract days, months, years
 * TODO getJD
 * TODO getMJD
 * TODO getWeekday
 * TODO date - date = days
 * TODO date - date = days, months, years
 * TODO get WeekNr
 * TODO format date
 * TODO parse date
 * TODO min, max
 */
@ValueObject
public record GregorianDate(GregorianCalendar calendar, Year year, Month month, Day day) implements Comparable<GregorianDate>, IValueObject
 {
  /**
   * Output format.
   */
  private static final String FORMAT_TWODIGIT = "%02d"; //$NON-NLS-1$

  /**
   * Year format.
   */
  private static final String FORMAT_FOURDIGIT = "%04d"; //$NON-NLS-1$

  /**
   * ISO8601 separator.
   */
  private static final String DATE_SEP = "-"; //$NON-NLS-1$

  /**
   * IT - italy constant.
   */
  private static final String IT = "IT"; //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param calendar Gregorian calendar
   * @param year Year
   * @param month Month
   * @param day Day
   * @throws IllegalArgumentException If the day does not exist in given month
   */
  public GregorianDate
   {
    Objects.requireNonNull(calendar, "calendar"); //$NON-NLS-1$
    Objects.requireNonNull(year, "year"); //$NON-NLS-1$
    Objects.requireNonNull(month, "month"); //$NON-NLS-1$
    Objects.requireNonNull(day, "day"); //$NON-NLS-1$
    if (day.day() > calendar.daysInMonth(year, month).days()) // TODO Does not work for gregorian reform month
     {
      throw new IllegalArgumentException("Day does not exists in month"); //$NON-NLS-1$
     }
   }


  /**
   * GregorianDate factory.
   *
   * @param calendar Gregorian calendar
   * @param year Year
   * @param month Month
   * @param day Day
   * @return GregorianDate object
   */
  public static GregorianDate of(final GregorianCalendar calendar, final Year year, final Month month, final Day day)
   {
    return new GregorianDate(calendar, year, month, day);
   }


  /**
   * GregorianDate factory for country=IT.
   *
   * @param year Year
   * @param month Month
   * @param day Day
   * @return GregorianDate object
   */
  public static GregorianDate of(final Year year, final Month month, final Day day)
   {
    return GregorianDate.of(GregorianCalendar.of(Country.of(IT)), year, month, day);
   }


  /**
   * GregorianDate factory for country=IT.
   *
   * @param value String value of ISO8601 type yyyy-mm-dd
   * @return GregorianDate object
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public static GregorianDate of(final String value)
   {
    final String[] values = value.split(DATE_SEP);
    if (values.length != 3)
     {
      throw new IllegalArgumentException("Format not as expected: yyyy-mm-dd");
     }
    return GregorianDate.of(GregorianCalendar.of(Country.of(IT)), Year.of(values[0]), Month.of(values[1]), Day.of(values[2]));
   }


  /**
   * Returns the value of this GregorianDate as a string.
   *
   * @return The text value represented by this object after conversion to type string in ISO8601 format with - as separator.
   */
  @Override
  public String stringValue()
   {
    return String.format(GregorianDate.FORMAT_FOURDIGIT, year.year()) + GregorianDate.DATE_SEP + String.format(GregorianDate.FORMAT_TWODIGIT, month.month()) + GregorianDate.DATE_SEP + String.format(GregorianDate.FORMAT_TWODIGIT, day.day());
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final GregorianDate obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    // TODO calendar
    int result = year.compareTo(obj.year);
    if (result == 0)
     {
      result = month.compareTo(obj.month);
      if (result == 0)
       {
        result = day.compareTo(obj.day);
       }
     }
    return result;
   }


  /**
   * Calculate easter date for year.
   *
   * @param calendar Gregorian calendar
   * @param year Year
   * @return GregorianDate of easter for given year
   */
  @SuppressWarnings("PMD.ShortVariable")
  public static GregorianDate easter(final GregorianCalendar calendar, final Year year)
   {
    final long a = year.year() % 19;
    final long b = year.year() / 100;
    final long c = year.year() % 100;
    final long d = ((((19 * a) + b) - (b / 4) - (((b - ((b + 8) / 25)) + 1) / 3)) + 15) % 30;
    final long e = ((32 + (2 * (b % 4)) + (2 * (c / 4))) - d - (c % 4)) % 7;
    final long f = ((d + e) - (7 * ((a + (11 * d) + (22 * e)) / 451))) + 114;
    final var day = Day.of(((int)f % 31) + 1);
    final var month = Month.of((int)(f / 31));
    return GregorianDate.of(calendar, year, month, day);
   }

 }
