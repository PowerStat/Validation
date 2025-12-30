/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values;


import java.util.Objects;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Julian calendar.
 *
 * Not DSGVO relevant.
 */
@ValueObject
public record JulianCalendar() implements Comparable<JulianCalendar>, IValueObject
 {
  /**
   * Days per month.
   */
  private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  /**
   * Month.
   */
  private static final String MONTH = "month"; //$NON-NLS-1$

  /**
   * Year.
   */
  private static final String YEAR = "year"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public JulianCalendar
   {
   }


  /**
   * JulianCalendar factory.
   *
   * @return JulianCalendar object
   */
  public static JulianCalendar of()
   {
    return new JulianCalendar();
   }


  /**
   * Returns the value of this JulianCalendar as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return "";
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @SuppressFBWarnings("SCRV_SUSPICIOUS_COMPARATOR_RETURN_VALUES")
  @Override
  public int compareTo(final JulianCalendar obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return 0;
   }


  /**
   * Is leap year.
   *
   * @param year Year
   * @return true: leap year, false otherwise
   */
  public boolean isLeapYear(final Year year)
   {
    Objects.requireNonNull(year, JulianCalendar.YEAR);
    return (year.year() <= 0) ? ((-year.year()) % 4) == 1 : (year.year() % 4) == 0;
   }


  /**
   * Days in month.
   *
   * @param year Year
   * @param month Month (1-12)
   * @return Days in month (28-31)
   */
  public Days daysInMonth(final Year year, final Month month)
   {
    Objects.requireNonNull(year, JulianCalendar.YEAR);
    Objects.requireNonNull(month, JulianCalendar.MONTH);
    return Days.of(DAYS_IN_MONTH[month.month()] + (((month.month() == 2) && isLeapYear(year)) ? 1 : 0));
   }


  /**
   * Days in year.
   *
   * @param year Year
   * @return Days in year (365-366)
   */
  public Days daysInYear(final Year year)
   {
    Objects.requireNonNull(year, JulianCalendar.YEAR);
    long days = 0;
    for (int day = 1; day <= 12; ++day)
     {
      days += daysInMonth(year, Month.of(day)).days();
     }
    return Days.of(days);
   }


  /**
   * Calculate julian easter date in year.
   *
   * @param year Year
   * @return MonthDay
   */
  @SuppressWarnings({"PMD.ShortVariable"})
  public MonthDay easterInYear(final Year year)
   {
    final int a = (int)(((19 * (year.year() % 19)) + 15) % 30);
    final int b = (int)(((((2 * (year.year() % 4)) + (4 * (year.year() % 7))) - a) + 34) % 7);
    final int c = a + b + 114;
    return MonthDay.of(Month.of(c / 31), Day.of((c % 31) + 1));
   }

 }
