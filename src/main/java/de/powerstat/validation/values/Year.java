/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;
import de.powerstat.validation.values.containers.NTuple2;


/**
 * Year.
 *
 * @param calendarSystem Calendar system: julian, gregorian
 * @param year Year != 0
 * 
 * Not DSGVO relevant.
 *
 * TODO Weeks weeksWithin() = (50, 51,) 52, 53 (CalendarSystem, Country dependend ISO vs US)
 */
public record Year(CalendarSystems calendarSystem, long year) implements Comparable<Year>, IValueObject
 {
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
   * Returns the value of this Year as an long.
   *
   * @return The numeric value represented by this object after conversion to type long.
   */
  public long longValue()
   {
    return this.year;
   }


  /**
   * Months within year.
   *
   * @return Months (12) within year
   */
  public Months monthsWithin()
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
        throw new IllegalStateException("Unsupported calendar system!");
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
        return Days.of(365 + (this.isLeapYear() ? 1 : 0));
      case GREGORIAN:
        if (this.year == BEFORE_GREGORIAN_YEAR) // Country dependend
         {
          return Days.of(365 - 10); // Country dependend
         }
        return Days.of(365 + (this.isLeapYear() ? 1 : 0));
      default:
        throw new IllegalStateException("Unsupported calendar system!");
    }
   }


  /**
   * Compare fields.
   *
   * @param <T> Field type
   * @param obj1 Field 1 (this)
   * @param obj2 Field 2 (other)
   * @return 0: equal; 1 field 1 greater than field 2; -1 field 1 smaller than field 2
   */
  private static <T extends Comparable<T>> int compareField(final T obj1, final T obj2)
   {
    return (obj1 == null) ? ((obj2 == null) ? 0 : -1) : ((obj2 == null) ? 1 : obj1.compareTo(obj2));
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
    return compareField(this.year, obj.year);
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
    long newYear = Math.addExact(this.year, years.years());
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
    long newYear = Math.subtractExact(this.year, years.years());
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
