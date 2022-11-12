/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Gregorian calendar date.
 *
 * Not DSGVO relevant.
 *
 * TODO next day
 * TODO previous day
 * TODO add x days
 * TODO sub x days
 * TODO add days, months, years
 * TODO sub days, months, years
 * TODO getJD
 * TODO getMJD
 * TODO getWeekday
 * TODO date - date = days
 * TODO date - date = days, months, years
 * TODO get WeekNr
 * TODO format date
 * TODO parse date
 */
public final class GregorianDate implements Comparable<GregorianDate>
 {
  /**
   * Gregorian calendar.
   */
  private final GregorianCalendar calendar;

  /**
   * Year.
   */
  private final Year year;

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
   * @param calendar Gregorian calendar
   * @param year Year
   * @param month Month
   * @param day Day
   */
  public GregorianDate(final GregorianCalendar calendar, final Year year, final Month month, final Day day)
   {
    super();
    Objects.requireNonNull(calendar, "calendar"); //$NON-NLS-1$
    Objects.requireNonNull(year, "year"); //$NON-NLS-1$
    Objects.requireNonNull(month, "month"); //$NON-NLS-1$
    Objects.requireNonNull(day, "day"); //$NON-NLS-1$
    if (day.getDay() > calendar.daysInMonth(year, month)) // TODO Does not work for gregorian reform month
     {
      throw new IllegalArgumentException("Day does not exists in month"); //$NON-NLS-1$
     }
    this.calendar = calendar;
    this.year = year;
    this.month = month;
    this.day = day;
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
    return new GregorianDate(GregorianCalendar.of(new Country("IT")), year, month, day); //$NON-NLS-1$
   }


  /**
   * Get date string ISO8601 format.
   *
   * @return GregorianDate string in ISO8601 format with - as separator
   */
  public String getDate()
   {
    return String.format("%04d", this.year.getYear()) + "-" + String.format("%02d", this.month.getMonth()) + "-" + String.format("%02d", this.day.getDay()); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
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
    // TODO calendar
    return Objects.hash(this.year, this.month, this.day);
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
    if (!(obj instanceof GregorianDate))
     {
      return false;
     }
    final GregorianDate other = (GregorianDate)obj;
    // TODO calendar
    boolean result = this.year.equals(other.year);
    if (result)
     {
      result = this.month.equals(other.month);
      if (result)
       {
        result = this.day.equals(other.day);
       }
     }
    return result;
   }


  /**
   * Returns the string representation of this GregorianDate.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "GregorianDate[country=IT, date=2020-07-06]"
   *
   * @return String representation of this GregorianDate
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(30);
    builder.append("GregorianDate[country=").append(this.calendar.getCountry().getCountry()).append(", date=").append(getDate()).append(']'); //$NON-NLS-1$ //$NON-NLS-2$
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
  public int compareTo(final GregorianDate obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    // TODO calendar
    int result = this.year.compareTo(obj.year);
    if (result == 0)
     {
      result = this.month.compareTo(obj.month);
      if (result == 0)
       {
        result = this.day.compareTo(obj.day);
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
  public static GregorianDate easter(final GregorianCalendar calendar, final Year year)
   {
    final long a = year.getYear() % 19;
    final long b = year.getYear() / 100;
    final long c = year.getYear() % 100;
    final long d = ((((19 * a) + b) - (b / 4) - (((b - ((b + 8) / 25)) + 1) / 3)) + 15) % 30;
    final long e  = ((32 + (2 * (b % 4)) + (2 * (c / 4))) - d - (c % 4)) % 7;
    final long f = ((d + e) - (7 * ((a + (11 * d) + (22 * e)) / 451))) + 114;
    final Day day = Day.of(((int)f % 31) + 1);
    final Month month = Month.of((int)(f / 31));
    return GregorianDate.of(calendar, year, month, day);
   }

 }
