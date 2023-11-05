/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Gregorian calendar.
 *
 * @param country Country of gregorian calendar reform
 *
 * Not DSGVO relevant.
 *
 * TODO More country reform dates
 */
public record GregorianCalendar(Country country) implements Comparable<GregorianCalendar>, IValueObject
 {
  /**
   * Days per month.
   */
  private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  /**
   * Gregorian calendar reform before and after dates.
   */
  private static final Map<Country, Map<String, Map<String, Long>>> REFORM_DATES = new ConcurrentHashMap<>();

  /**
   * After.
   */
  private static final String AFTER = "after"; //$NON-NLS-1$

  /**
   * Before.
   */
  private static final String BEFORE = "before"; //$NON-NLS-1$

  /**
   * Days.
   */
  private static final String DAYS = "days"; //$NON-NLS-1$

  /**
   * Day.
   */
  private static final String DAY = "day"; //$NON-NLS-1$

  /**
   * Month.
   */
  private static final String MONTH = "month"; //$NON-NLS-1$

  /**
   * Year.
   */
  private static final String YEAR = "year"; //$NON-NLS-1$


  /* *
   * Static initialization.
   */
  static
   {
    final Map<String, Long> itBefore = new ConcurrentHashMap<>();
    itBefore.put(GregorianCalendar.YEAR, Long.valueOf(1582));
    itBefore.put(GregorianCalendar.MONTH, Long.valueOf(10));
    itBefore.put(GregorianCalendar.DAY, Long.valueOf(4));
    itBefore.put(GregorianCalendar.DAYS, Long.valueOf(21));
    final Map<String, Long> itAfter = new ConcurrentHashMap<>();
    itAfter.put(GregorianCalendar.YEAR, Long.valueOf(1582));
    itAfter.put(GregorianCalendar.MONTH, Long.valueOf(10));
    itAfter.put(GregorianCalendar.DAY, Long.valueOf(15));
    final Map<String, Map<String, Long>> it = new ConcurrentHashMap<>();
    it.put(GregorianCalendar.BEFORE, itBefore);
    it.put(GregorianCalendar.AFTER, itAfter);
    GregorianCalendar.REFORM_DATES.put(Country.of("IT"), it); //$NON-NLS-1$

    final Map<String, Long> beBefore = new ConcurrentHashMap<>();
    beBefore.put(GregorianCalendar.YEAR, Long.valueOf(1582));
    beBefore.put(GregorianCalendar.MONTH, Long.valueOf(12));
    beBefore.put(GregorianCalendar.DAY, Long.valueOf(21));
    beBefore.put(GregorianCalendar.DAYS, Long.valueOf(21));
    final Map<String, Long> beAfter = new ConcurrentHashMap<>();
    beAfter.put(GregorianCalendar.YEAR, Long.valueOf(1583));
    beAfter.put(GregorianCalendar.MONTH, Long.valueOf(1));
    beAfter.put(GregorianCalendar.DAY, Long.valueOf(1));
    final Map<String, Map<String, Long>> be = new ConcurrentHashMap<>();
    be.put(GregorianCalendar.BEFORE, beBefore);
    be.put(GregorianCalendar.AFTER, beAfter);
    GregorianCalendar.REFORM_DATES.put(Country.of("BE"), be); //$NON-NLS-1$

    final Map<String, Long> deBefore = new ConcurrentHashMap<>();
    deBefore.put(GregorianCalendar.YEAR, Long.valueOf(1700));
    deBefore.put(GregorianCalendar.MONTH, Long.valueOf(2));
    deBefore.put(GregorianCalendar.DAY, Long.valueOf(18));
    deBefore.put(GregorianCalendar.DAYS, Long.valueOf(18));
    final Map<String, Long> deAfter = new ConcurrentHashMap<>();
    deAfter.put(GregorianCalendar.YEAR, Long.valueOf(1700));
    deAfter.put(GregorianCalendar.MONTH, Long.valueOf(3));
    deAfter.put(GregorianCalendar.DAY, Long.valueOf(1));
    final Map<String, Map<String, Long>> de = new ConcurrentHashMap<>();
    de.put(GregorianCalendar.BEFORE, deBefore);
    de.put(GregorianCalendar.AFTER, deAfter);
    GregorianCalendar.REFORM_DATES.put(Country.of("DE"), de); //$NON-NLS-1$
    GregorianCalendar.REFORM_DATES.put(Country.of("CH"), de); //$NON-NLS-1$
    GregorianCalendar.REFORM_DATES.put(Country.of("DK"), de); //$NON-NLS-1$

    final Map<String, Long> usBefore = new ConcurrentHashMap<>();
    usBefore.put(GregorianCalendar.YEAR, Long.valueOf(1752));
    usBefore.put(GregorianCalendar.MONTH, Long.valueOf(9));
    usBefore.put(GregorianCalendar.DAY, Long.valueOf(2));
    usBefore.put(GregorianCalendar.DAYS, Long.valueOf(19));
    final Map<String, Long> usAfter = new ConcurrentHashMap<>();
    usAfter.put(GregorianCalendar.YEAR, Long.valueOf(1752));
    usAfter.put(GregorianCalendar.MONTH, Long.valueOf(9));
    usAfter.put(GregorianCalendar.DAY, Long.valueOf(14));
    final Map<String, Map<String, Long>> us = new ConcurrentHashMap<>();
    us.put(GregorianCalendar.BEFORE, usBefore);
    us.put(GregorianCalendar.AFTER, usAfter);
    GregorianCalendar.REFORM_DATES.put(Country.of("US"), us); //$NON-NLS-1$
    GregorianCalendar.REFORM_DATES.put(Country.of("GB"), us); //$NON-NLS-1$

    final Map<String, Long> seBefore = new ConcurrentHashMap<>();
    seBefore.put(GregorianCalendar.YEAR, Long.valueOf(1753));
    seBefore.put(GregorianCalendar.MONTH, Long.valueOf(2));
    seBefore.put(GregorianCalendar.DAY, Long.valueOf(17));
    seBefore.put(GregorianCalendar.DAYS, Long.valueOf(17));
    final Map<String, Long> seAfter = new ConcurrentHashMap<>();
    seAfter.put(GregorianCalendar.YEAR, Long.valueOf(1753));
    seAfter.put(GregorianCalendar.MONTH, Long.valueOf(3));
    seAfter.put(GregorianCalendar.DAY, Long.valueOf(1));
    final Map<String, Map<String, Long>> se = new ConcurrentHashMap<>();
    se.put(GregorianCalendar.BEFORE, seBefore);
    se.put(GregorianCalendar.AFTER, seAfter);
    GregorianCalendar.REFORM_DATES.put(Country.of("SE"), se); //$NON-NLS-1$

    final Map<String, Long> ruBefore = new ConcurrentHashMap<>();
    ruBefore.put(GregorianCalendar.YEAR, Long.valueOf(1918));
    ruBefore.put(GregorianCalendar.MONTH, Long.valueOf(1));
    ruBefore.put(GregorianCalendar.DAY, Long.valueOf(31));
    final Map<String, Long> ruAfter = new ConcurrentHashMap<>();
    ruAfter.put(GregorianCalendar.YEAR, Long.valueOf(1918));
    ruAfter.put(GregorianCalendar.MONTH, Long.valueOf(2));
    ruAfter.put(GregorianCalendar.DAY, Long.valueOf(14));
    ruAfter.put(GregorianCalendar.DAYS, Long.valueOf(15));
    final Map<String, Map<String, Long>> ru = new ConcurrentHashMap<>();
    ru.put(GregorianCalendar.BEFORE, ruBefore);
    ru.put(GregorianCalendar.AFTER, ruAfter);
    GregorianCalendar.REFORM_DATES.put(Country.of("RU"), ru); //$NON-NLS-1$
  }

  /*
  21.12.1582, 01.01.1583 Netherlands: Holland, Zeeland, Brabant, Limburg, Southern Provinces
  28.02.1583, 11.03.1583 Netherlands: Groningen
  18.02.1700, 01.03.1700 Netherlands
  30.06.1700, 12.07.1700 Netherlands: Gelderland
  30.11.1700, 12.12.1700 Netherlands: Utrecht, Overijssel
  31.12.1700, 12.01.1701 Netherlands: Friesland, Drenthe, Groningen
  */


  /**
   * Constructor.
   *
   * @param country Country of gregorian calendar reform
   */
  public GregorianCalendar
   {
    Objects.requireNonNull(country, "country"); //$NON-NLS-1$
   }


  /**
   * GregorianClendar factory.
   *
   * @param country Country of gregorian calendar reform
   * @return GregorianDate object
   */
  public static GregorianCalendar of(final Country country)
   { 
    return new GregorianCalendar(country);
   }


  /**
   * GregorianClendar factory.
   *
   * @param value Country alpha-2 code
   * @return GregorianDate object
   */
  public static GregorianCalendar of(final String value)
   {
    return of(Country.of(value));
   }


  /**
   * Returns the value of this GregorianCalendar as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.country.stringValue();
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final GregorianCalendar obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = GregorianCalendar.REFORM_DATES.get(this.country).get(GregorianCalendar.BEFORE).get(GregorianCalendar.YEAR).compareTo(GregorianCalendar.REFORM_DATES.get(obj.country).get(GregorianCalendar.BEFORE).get(GregorianCalendar.YEAR));
    if (result == 0)
     {
      result = GregorianCalendar.REFORM_DATES.get(this.country).get(GregorianCalendar.BEFORE).get(GregorianCalendar.MONTH).compareTo(GregorianCalendar.REFORM_DATES.get(obj.country).get(GregorianCalendar.BEFORE).get(GregorianCalendar.MONTH));
     }
    return result;
   }


  /**
   * Is leap year.
   *
   * @param year Year
   * @return true: leap year, false otherwise
   */
  public boolean isLeapYear(final Year year)
   {
    Objects.requireNonNull(year, GregorianCalendar.YEAR);

    final String beforeAfter = GregorianCalendar.REFORM_DATES.get(this.country).get(GregorianCalendar.BEFORE).get(GregorianCalendar.DAYS) == null ? GregorianCalendar.AFTER : GregorianCalendar.BEFORE;
    final long reformYear = GregorianCalendar.REFORM_DATES.get(this.country).get(beforeAfter).get(GregorianCalendar.YEAR).longValue();
    if (year.year() > reformYear)
     {
      return ((year.year() % 4) == 0) && (((year.year() % 100) != 0) || ((year.year() % 400) == 0));
     }
    return ((year.year() % 4) == 0); // TODO JulianCalendar.isLeapYear(year);
   }


  /**
   * Days in month.
   *
   * @param year Year
   * @param month Month (1-12)
   * @return Days in month (15,17,18,19,21, 28-31)
   */
  public int daysInMonth(final Year year, final Month month)
   {
    Objects.requireNonNull(year, GregorianCalendar.YEAR);
    Objects.requireNonNull(month, GregorianCalendar.MONTH);

    final String beforeAfter = GregorianCalendar.REFORM_DATES.get(this.country).get(GregorianCalendar.BEFORE).get(GregorianCalendar.DAYS) == null ? GregorianCalendar.AFTER : GregorianCalendar.BEFORE;
    final long reformYear = GregorianCalendar.REFORM_DATES.get(this.country).get(beforeAfter).get(GregorianCalendar.YEAR).longValue();
    final int reformMonth = GregorianCalendar.REFORM_DATES.get(this.country).get(beforeAfter).get(GregorianCalendar.MONTH).intValue();
    final int restDaysInMonth = GregorianCalendar.REFORM_DATES.get(this.country).get(beforeAfter).get(GregorianCalendar.DAYS).intValue();
    if ((year.year() == reformYear) && (month.month() == reformMonth)) // Depend on country
     {
      return restDaysInMonth;
     }
    return GregorianCalendar.DAYS_IN_MONTH[month.month()] + (((month.month() == 2) && isLeapYear(year)) ? 1 : 0);
   }

 }
