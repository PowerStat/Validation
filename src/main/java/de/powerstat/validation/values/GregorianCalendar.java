/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


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
  private static final Map<Country, Map<String, Map<String, Long>>> REFORM_DATES = new HashMap<>();

  /**
   * Country of gregorian calendar reform.
   */
  private final Country country;


  /**
   * Static initialization.
   */
  static
   {
    final Map<String, Long> it_before = new HashMap<>();
    it_before.put("year", Long.valueOf(1582)); //$NON-NLS-1$
    it_before.put("month", Long.valueOf(10)); //$NON-NLS-1$
    it_before.put("day", Long.valueOf(4)); //$NON-NLS-1$
    it_before.put("days", Long.valueOf(21)); //$NON-NLS-1$
    final Map<String, Long> it_after = new HashMap<>();
    it_after.put("year", Long.valueOf(1582)); //$NON-NLS-1$
    it_after.put("month", Long.valueOf(10)); //$NON-NLS-1$
    it_after.put("day", Long.valueOf(15)); //$NON-NLS-1$
    final Map <String, Map<String, Long>> it = new HashMap<>();
    it.put("before", it_before); //$NON-NLS-1$
    it.put("after", it_after); //$NON-NLS-1$
    REFORM_DATES.put(Country.of("IT"), it); //$NON-NLS-1$

    final Map<String, Long> be_before = new HashMap<>();
    be_before.put("year", Long.valueOf(1582)); //$NON-NLS-1$
    be_before.put("month", Long.valueOf(12)); //$NON-NLS-1$
    be_before.put("day", Long.valueOf(21)); //$NON-NLS-1$
    be_before.put("days", Long.valueOf(21)); //$NON-NLS-1$
    final Map<String, Long> be_after = new HashMap<>();
    be_after.put("year", Long.valueOf(1583)); //$NON-NLS-1$
    be_after.put("month", Long.valueOf(1)); //$NON-NLS-1$
    be_after.put("day", Long.valueOf(1)); //$NON-NLS-1$
    final Map <String, Map<String, Long>> be = new HashMap<>();
    be.put("before", be_before); //$NON-NLS-1$
    be.put("after", be_after); //$NON-NLS-1$
    REFORM_DATES.put(Country.of("BE"), be); //$NON-NLS-1$

    final Map<String, Long> de_before = new HashMap<>();
    de_before.put("year", Long.valueOf(1700)); //$NON-NLS-1$
    de_before.put("month", Long.valueOf(2)); //$NON-NLS-1$
    de_before.put("day", Long.valueOf(18)); //$NON-NLS-1$
    de_before.put("days", Long.valueOf(18)); //$NON-NLS-1$
    final Map<String, Long> de_after = new HashMap<>();
    de_after.put("year", Long.valueOf(1700)); //$NON-NLS-1$
    de_after.put("month", Long.valueOf(3)); //$NON-NLS-1$
    de_after.put("day", Long.valueOf(1)); //$NON-NLS-1$
    final Map <String, Map<String, Long>> de = new HashMap<>();
    de.put("before", de_before); //$NON-NLS-1$
    de.put("after", de_after); //$NON-NLS-1$
    REFORM_DATES.put(Country.of("DE"), de); //$NON-NLS-1$
    REFORM_DATES.put(Country.of("CH"), de); //$NON-NLS-1$
    REFORM_DATES.put(Country.of("DK"), de); //$NON-NLS-1$

    final Map<String, Long> us_before = new HashMap<>();
    us_before.put("year", Long.valueOf(1752)); //$NON-NLS-1$
    us_before.put("month", Long.valueOf(9)); //$NON-NLS-1$
    us_before.put("day", Long.valueOf(2)); //$NON-NLS-1$
    us_before.put("days", Long.valueOf(19)); //$NON-NLS-1$
    final Map<String, Long> us_after = new HashMap<>();
    us_after.put("year", Long.valueOf(1752)); //$NON-NLS-1$
    us_after.put("month", Long.valueOf(9)); //$NON-NLS-1$
    us_after.put("day", Long.valueOf(14)); //$NON-NLS-1$
    final Map <String, Map<String, Long>> us = new HashMap<>();
    us.put("before", us_before); //$NON-NLS-1$
    us.put("after", us_after); //$NON-NLS-1$
    REFORM_DATES.put(Country.of("US"), us); //$NON-NLS-1$
    REFORM_DATES.put(Country.of("GB"), us); //$NON-NLS-1$

    final Map<String, Long> se_before = new HashMap<>();
    se_before.put("year", Long.valueOf(1753)); //$NON-NLS-1$
    se_before.put("month", Long.valueOf(2)); //$NON-NLS-1$
    se_before.put("day", Long.valueOf(17)); //$NON-NLS-1$
    se_before.put("days", Long.valueOf(17)); //$NON-NLS-1$
    final Map<String, Long> se_after = new HashMap<>();
    se_after.put("year", Long.valueOf(1753)); //$NON-NLS-1$
    se_after.put("month", Long.valueOf(3)); //$NON-NLS-1$
    se_after.put("day", Long.valueOf(1)); //$NON-NLS-1$
    final Map <String, Map<String, Long>> se = new HashMap<>();
    se.put("before", se_before); //$NON-NLS-1$
    se.put("after", se_after); //$NON-NLS-1$
    REFORM_DATES.put(Country.of("SE"), se); //$NON-NLS-1$

    final Map<String, Long> ru_before = new HashMap<>();
    ru_before.put("year", Long.valueOf(1918)); //$NON-NLS-1$
    ru_before.put("month", Long.valueOf(1)); //$NON-NLS-1$
    ru_before.put("day", Long.valueOf(31)); //$NON-NLS-1$
    final Map<String, Long> ru_after = new HashMap<>();
    ru_after.put("year", Long.valueOf(1918)); //$NON-NLS-1$
    ru_after.put("month", Long.valueOf(2)); //$NON-NLS-1$
    ru_after.put("day", Long.valueOf(14)); //$NON-NLS-1$
    ru_after.put("days", Long.valueOf(15)); //$NON-NLS-1$
    final Map <String, Map<String, Long>> ru = new HashMap<>();
    ru.put("before", ru_before); //$NON-NLS-1$
    ru.put("after", ru_after); //$NON-NLS-1$
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
    int result = REFORM_DATES.get(this.country).get("before").get("year").compareTo(REFORM_DATES.get(obj.country).get("before").get("year")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
    if (result == 0)
     {
      result = REFORM_DATES.get(this.country).get("before").get("month").compareTo(REFORM_DATES.get(obj.country).get("before").get("month")); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
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
    Objects.requireNonNull(year, "year"); //$NON-NLS-1$

    long reformYear;
    if (REFORM_DATES.get(this.country).get("before").get("days") != null) //$NON-NLS-1$ //$NON-NLS-2$
     {
      reformYear = REFORM_DATES.get(this.country).get("before").get("year").longValue(); //$NON-NLS-1$ //$NON-NLS-2$
     }
    else
     {
      reformYear = REFORM_DATES.get(this.country).get("after").get("year").longValue(); //$NON-NLS-1$ //$NON-NLS-2$
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
    Objects.requireNonNull(year, "year"); //$NON-NLS-1$
    Objects.requireNonNull(month, "month"); //$NON-NLS-1$

    long reformYear;
    int reformMonth;
    int restDaysInMonth;
    if (REFORM_DATES.get(this.country).get("before").get("days") != null) //$NON-NLS-1$ //$NON-NLS-2$
     {
      reformYear = REFORM_DATES.get(this.country).get("before").get("year").longValue(); //$NON-NLS-1$ //$NON-NLS-2$
      reformMonth = REFORM_DATES.get(this.country).get("before").get("month").intValue(); //$NON-NLS-1$ //$NON-NLS-2$
      restDaysInMonth = REFORM_DATES.get(this.country).get("before").get("days").intValue(); //$NON-NLS-1$ //$NON-NLS-2$
     }
    else
     {
      reformYear = REFORM_DATES.get(this.country).get("after").get("year").longValue(); //$NON-NLS-1$ //$NON-NLS-2$
      reformMonth = REFORM_DATES.get(this.country).get("after").get("month").intValue(); //$NON-NLS-1$ //$NON-NLS-2$
      restDaysInMonth = REFORM_DATES.get(this.country).get("after").get("days").intValue(); //$NON-NLS-1$ //$NON-NLS-2$
     }
    if ((year.getYear() == reformYear) && (month.getMonth() == reformMonth)) // Depend on country
     {
      return restDaysInMonth;
     }

    return this.DAYS_IN_MONTH[month.getMonth()] + (((month.getMonth() == 2) && isLeapYear(year)) ? 1 : 0);
   }

 }
