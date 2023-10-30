/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Year.
 *
 * Not DSGVO relevant.
 *
 * TODO Weeks weeksWithin() = (50, 51,) 52, 53 (CalendarSystem, Country dependend ISO vs US)
 */
public final class Year implements Comparable<Year>, IValueObject
 {
  /**
   * Unsupported calendar system constant.
   */
  private static final String UNSUPPORTED_CALENDAR_SYSTEM = "Unsupported calendar system!";

  /* *
   * Cache for singletons.
   */
  // private static final Map<NTuple2<CalendarSystems, Long>, Year> CACHE = new WeakHashMap<>();

  /**
   * Year of Gregorian calendar reform.
   *
   * TODO Country dependend.
   */
  private static final long BEFORE_GREGORIAN_YEAR = 1582;

  /**
   * Calendar system.
   */
  private final CalendarSystems calendarSystem;

  /**
   * Year.
   */
  private final long year;


  /**
   * Constructor.
   *
   * @param calendarSystem Calendar system
   * @param year Year != 0
   * @throws NullPointerException When calendarSystem is null
   * @throws IndexOutOfBoundsException When the year is 0
   */
  private Year(final CalendarSystems calendarSystem, final long year)
   {
    super();
    Objects.requireNonNull(calendarSystem, "calendarSystem"); //$NON-NLS-1$
    if (year == 0)
     {
      throw new IndexOutOfBoundsException("Year 0 does not exist!"); //$NON-NLS-1$
     }
    this.calendarSystem = calendarSystem;
    this.year = year;
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
    /*
    final NTuple2<CalendarSystems, Long> tuple = NTuple2.of(calendarSystem, year);
    synchronized (Year.class)
     {
      Year obj = Year.CACHE.get(tuple);
      if (obj != null)
       {
        return obj;
       }
      obj = new Year(calendarSystem, year);
      Year.CACHE.put(tuple, obj);
      return obj;
     }
    */
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
   * Returns the value of this Year as an long.
   *
   * @return The numeric value represented by this object after conversion to type long.
   */
  public long longValue()
   {
    return this.year;
   }


  /**
   * Returns the value of this Year as an String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(this.year);
   }


  /**
   * Months within year.
   *
   * @return Months (12) within year
   */
  public static Months monthsWithin()
   {
    return Months.of(12);
   }


  /**
   * Is julian calendar leap year.
   *
   * @param year Julian calendar year
   * @return true: is leap year; false otherwise
   */
  private static boolean isJulianLeapYear(final long year)
   {
    if (year <= 0)
     {
      return ((-year) % 4) == 1;
     }
    else
     {
      return (year % 4) == 0;
     }
   }


  /**
   * Is gregorian calendar leap year.
   *
   * @param year Gregorian calendar year
   * @return  true: is leap year; false otherwise
   */
  private static boolean isGregorianLeapYear(final long year)
   {
    return (((year % 4) == 0) && (((year % 100) > 0) || ((year % 400) == 0)));
   }


  /**
   * Calendar system dependent leap year.
   *
   * @return true: is leap year; false otherwise
   * @throws IllegalStateException When an unsupported calendar system is used
   */
  public boolean isLeapYear()
   {
    switch (this.calendarSystem)
     {
      case JULIAN:
        return isJulianLeapYear(this.year);
      case GREGORIAN:
        if (this.year < BEFORE_GREGORIAN_YEAR) // Country dependend
         {
          return isJulianLeapYear(this.year);
         }
        else
         {
          return isGregorianLeapYear(this.year);
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
    switch (this.calendarSystem)
     {
      case JULIAN:
        return Days.of(365L + (this.isLeapYear() ? 1 : 0));
      case GREGORIAN:
        if (this.year == BEFORE_GREGORIAN_YEAR) // Country dependend
         {
          return Days.of(365L - 10); // Country dependend
         }
        return Days.of(365L + (this.isLeapYear() ? 1 : 0));
      default:
        throw new IllegalStateException(UNSUPPORTED_CALENDAR_SYSTEM);
    }
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
    return Objects.hash(this.calendarSystem, this.year);
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
    if (!(obj instanceof Year))
     {
      return false;
     }
    final Year other = (Year)obj;
    return this.year == other.year;
   }


  /**
   * Returns the string representation of this Year.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Year[calendarSystem=GREGORIAN, year=2020]"
   *
   * @return String representation of this Year
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(28);
    builder.append("Year[calendarSystem=").append(this.calendarSystem).append(", year=").append(this.year).append(']'); //$NON-NLS-1$
    return builder.toString();
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
    if (this.calendarSystem.compareTo(obj.calendarSystem) != 0)
     {
      throw new IllegalStateException("CalendarSystems are not equal!");
     }
    return Long.compare(this.year, obj.year);
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
    long newYear = Math.addExact(this.year, years.longValue());
    if ((this.year < 0) && (newYear >= 0))
     {
      newYear = Math.incrementExact(newYear); // Because there is no year 0!
     }
    return Year.of(this.calendarSystem, newYear);
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
    long newYear = Math.subtractExact(this.year, years.longValue());
    if ((this.year > 0) && (newYear <= 0))
     {
      newYear = Math.decrementExact(newYear); // Because there is no year 0!
     }
    return Year.of(this.calendarSystem, newYear);
   }


  /**
   * Increment this year.
   *
   * @return New year after incrementing this year
   * @throws ArithmeticException In case of an overflow
   */
  public Year increment()
   {
    long newYear = Math.incrementExact(this.year);
    if (this.year == -1)
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
    long newYear = Math.decrementExact(this.year);
    if (this.year == 1)
     {
      newYear = Math.decrementExact(newYear); // Because there is no year 0!
     }
    return Year.of(newYear);
   }

 }
