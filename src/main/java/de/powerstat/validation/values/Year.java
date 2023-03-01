/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Year.
 *
 * @param year Year != 0
 * 
 * Not DSGVO relevant.
 *
 * TODO isLeapYear (calendar specific)
 * TODO weeksWithin() = 52, 53, n
 * TODO daysWithin() = 365, 366, n
 * TODO monthsWith() = 12
 */
public record Year(long year) implements Comparable<Year>
 {
  /**
   * Constructor.
   *
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
   * @param year Year != 0
   * @return Year object
   */
  public static Year of(final long year)
   {
    return new Year(year);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Year obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.year, obj.year);
   }


  /**
   * Add years to this year.
   *
   * @param years Years to add to this year
   * @return New year after adding the years to this year
   * @throws ArithmeticException In case of an overflow
   */
  public Year add(final Years years)
   {
    long newYear = Math.addExact(this.year, years.years());
    if ((this.year < 0) && (newYear >= 0))
     {
      newYear = Math.incrementExact(newYear); // Because there is no year 0!
     }
    return Year.of(newYear);
   }


  /**
   * Subtract years from this year.
   *
   * @param years Years to subtract from this year
   * @return New year after subtracting years from this year
   * @throws ArithmeticException In case of an underflow
   */
  public Year subtract(final Years years)
   {
    long newYear = Math.subtractExact(this.year, years.years());
    if ((this.year > 0) && (newYear <= 0))
     {
      newYear = Math.decrementExact(newYear); // Because there is no year 0!
     }
    return Year.of(newYear);
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
