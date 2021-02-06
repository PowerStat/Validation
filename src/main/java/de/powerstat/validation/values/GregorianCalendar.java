/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Gregorian calendar.
 *
 * Not DSGVO relevant.
 *
 * TODO More country reform dates
 */
public final class GregorianCalendar implements Comparable<GregorianCalendar>
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

  /**
   * Country of gregorian calendar reform.
   */
  private final Country country;


  /**
   * Static initialization.
   */
  static
   {
    final Map<String, Long> itBefore = new ConcurrentHashMap<>();
    itBefore.put(YEAR, Long.valueOf(1582));
    itBefore.put(MONTH, Long.valueOf(10));
    itBefore.put(DAY, Long.valueOf(4));
    itBefore.put(DAYS, Long.valueOf(21));
    final Map<String, Long> itAfter = new ConcurrentHashMap<>();
    itAfter.put(YEAR, Long.valueOf(1582));
    itAfter.put(MONTH, Long.valueOf(10));
    itAfter.put(DAY, Long.valueOf(15));
    final Map<String, Map<String, Long>> it = new ConcurrentHashMap<>();
    it.put(BEFORE, itBefore);
    it.put(AFTER, itAfter);
    REFORM_DATES.put(Country.of("IT"), it); //$NON-NLS-1$

    final Map<String, Long> beBefore = new ConcurrentHashMap<>();
    beBefore.put(YEAR, Long.valueOf(1582));
    beBefore.put(MONTH, Long.valueOf(12));
    beBefore.put(DAY, Long.valueOf(21));
    beBefore.put(DAYS, Long.valueOf(21));
    final Map<String, Long> beAfter = new ConcurrentHashMap<>();
    beAfter.put(YEAR, Long.valueOf(1583));
    beAfter.put(MONTH, Long.valueOf(1));
    beAfter.put(DAY, Long.valueOf(1));
    final Map<String, Map<String, Long>> be = new ConcurrentHashMap<>();
    be.put(BEFORE, beBefore);
    be.put(AFTER, beAfter);
    REFORM_DATES.put(Country.of("BE"), be); //$NON-NLS-1$

    final Map<String, Long> deBefore = new ConcurrentHashMap<>();
    deBefore.put(YEAR, Long.valueOf(1700));
    deBefore.put(MONTH, Long.valueOf(2));
    deBefore.put(DAY, Long.valueOf(18));
    deBefore.put(DAYS, Long.valueOf(18));
    final Map<String, Long> deAfter = new ConcurrentHashMap<>();
    deAfter.put(YEAR, Long.valueOf(1700));
    deAfter.put(MONTH, Long.valueOf(3));
    deAfter.put(DAY, Long.valueOf(1));
    final Map<String, Map<String, Long>> de = new ConcurrentHashMap<>();
    de.put(BEFORE, deBefore);
    de.put(AFTER, deAfter);
    REFORM_DATES.put(Country.of("DE"), de); //$NON-NLS-1$
    REFORM_DATES.put(Country.of("CH"), de); //$NON-NLS-1$
    REFORM_DATES.put(Country.of("DK"), de); //$NON-NLS-1$

    final Map<String, Long> usBefore = new ConcurrentHashMap<>();
    usBefore.put(YEAR, Long.valueOf(1752));
    usBefore.put(MONTH, Long.valueOf(9));
    usBefore.put(DAY, Long.valueOf(2));
    usBefore.put(DAYS, Long.valueOf(19));
    final Map<String, Long> usAfter = new ConcurrentHashMap<>();
    usAfter.put(YEAR, Long.valueOf(1752));
    usAfter.put(MONTH, Long.valueOf(9));
    usAfter.put(DAY, Long.valueOf(14));
    final Map<String, Map<String, Long>> us = new ConcurrentHashMap<>();
    us.put(BEFORE, usBefore);
    us.put(AFTER, usAfter);
    REFORM_DATES.put(Country.of("US"), us); //$NON-NLS-1$
    REFORM_DATES.put(Country.of("GB"), us); //$NON-NLS-1$

    final Map<String, Long> seBefore = new ConcurrentHashMap<>();
    seBefore.put(YEAR, Long.valueOf(1753));
    seBefore.put(MONTH, Long.valueOf(2));
    seBefore.put(DAY, Long.valueOf(17));
    seBefore.put(DAYS, Long.valueOf(17));
    final Map<String, Long> seAfter = new ConcurrentHashMap<>();
    seAfter.put(YEAR, Long.valueOf(1753));
    seAfter.put(MONTH, Long.valueOf(3));
    seAfter.put(DAY, Long.valueOf(1));
    final Map<String, Map<String, Long>> se = new ConcurrentHashMap<>();
    se.put(BEFORE, seBefore);
    se.put(AFTER, seAfter);
    REFORM_DATES.put(Country.of("SE"), se); //$NON-NLS-1$

    final Map<String, Long> ruBefore = new ConcurrentHashMap<>();
    ruBefore.put(YEAR, Long.valueOf(1918));
    ruBefore.put(MONTH, Long.valueOf(1));
    ruBefore.put(DAY, Long.valueOf(31));
    final Map<String, Long> ruAfter = new ConcurrentHashMap<>();
    ruAfter.put(YEAR, Long.valueOf(1918));
    ruAfter.put(MONTH, Long.valueOf(2));
    ruAfter.put(DAY, Long.valueOf(14));
    ruAfter.put(DAYS, Long.valueOf(15));
    final Map<String, Map<String, Long>> ru = new ConcurrentHashMap<>();
    ru.put(BEFORE, ruBefore);
    ru.put(AFTER, ruAfter);
    REFORM_DATES.put(Country.of("RU"), ru); //$NON-NLS-1$
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
  public GregorianCalendar(final Country country)
   {
    super();
    Objects.requireNonNull(country, "country"); //$NON-NLS-1$
    this.country = country;
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
   * Get country.
   *
   * @return Country
   */
  public Country getCountry()
   {
    return this.country;
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
    return Objects.hash(this.country);
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
    if (!(obj instanceof GregorianCalendar))
     {
      return false;
     }
    final GregorianCalendar other = (GregorianCalendar)obj;
    return this.country.equals(other.country);
   }


  /**
   * Returns the string representation of this GregorianCalendar.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "GregorianCalendar[]"
   *
   * @return String representation of this GregorianCalendar
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("GregorianCalendar[country=").append(this.country.getCountry()).append(']'); //$NON-NLS-1$
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
  public int compareTo(final GregorianCalendar obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = REFORM_DATES.get(this.country).get(BEFORE).get(YEAR).compareTo(REFORM_DATES.get(obj.country).get(BEFORE).get(YEAR));
    if (result == 0)
     {
      result = REFORM_DATES.get(this.country).get(BEFORE).get(MONTH).compareTo(REFORM_DATES.get(obj.country).get(BEFORE).get(MONTH));
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
    Objects.requireNonNull(year, YEAR);

    long reformYear;
    if (REFORM_DATES.get(this.country).get(BEFORE).get(DAYS) == null)
     {
      reformYear = REFORM_DATES.get(this.country).get(AFTER).get(YEAR).longValue();
     }
    else
     {
      reformYear = REFORM_DATES.get(this.country).get(BEFORE).get(YEAR).longValue();
     }

    if (year.getYear() > reformYear)
     {
      return ((year.getYear() % 4) == 0) && (((year.getYear() % 100) != 0) || ((year.getYear() % 400) == 0));
     }
    return ((year.getYear() % 4) == 0); // TODO JulianCalendar.isLeapYear(year);
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
    Objects.requireNonNull(year, YEAR);
    Objects.requireNonNull(month, MONTH);

    long reformYear;
    int reformMonth;
    int restDaysInMonth;
    if (REFORM_DATES.get(this.country).get(BEFORE).get(DAYS) == null)
     {
      reformYear = REFORM_DATES.get(this.country).get(AFTER).get(YEAR).longValue();
      reformMonth = REFORM_DATES.get(this.country).get(AFTER).get(MONTH).intValue();
      restDaysInMonth = REFORM_DATES.get(this.country).get(AFTER).get(DAYS).intValue();
     }
    else
     {
      reformYear = REFORM_DATES.get(this.country).get(BEFORE).get(YEAR).longValue();
      reformMonth = REFORM_DATES.get(this.country).get(BEFORE).get(MONTH).intValue();
      restDaysInMonth = REFORM_DATES.get(this.country).get(BEFORE).get(DAYS).intValue();
     }
    if ((year.getYear() == reformYear) && (month.getMonth() == reformMonth)) // Depend on country
     {
      return restDaysInMonth;
     }

    return this.DAYS_IN_MONTH[month.getMonth()] + (((month.getMonth() == 2) && isLeapYear(year)) ? 1 : 0);
   }

 }
