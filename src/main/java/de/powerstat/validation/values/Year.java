/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;


/**
 * Year.
 *
 * Not DSGVO relevant.
 *
 * TODO isLeapYear (calendar specific)
 * TODO weeksWithin() = 52, 53, n
 * TODO daysWithin() = 365, 366, n
 * TODO monthsWith() = 12
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class Year implements Comparable<Year>
 {
  /**
   * Cache for singletons.
   */
  private static final Map<Long, Year> CACHE = new WeakHashMap<>();

  /**
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$

  /**
   * Year.
   */
  private final long year;


  /**
   * Constructor.
   *
   * @param year Year != 0
   * @throws IndexOutOfBoundsException When the year is 0
   */
  private Year(final long year)
   {
    super();
    if (year == 0)
     {
      throw new IndexOutOfBoundsException("Year 0 does not exist!"); //$NON-NLS-1$
     }
    this.year = year;
   }


  /**
   * Year factory.
   *
   * @param year Year != 0
   * @return Year object
   */
  public static Year of(final long year)
   {
    synchronized (Year.class)
     {
      Year obj = Year.CACHE.get(year);
      if (obj != null)
       {
        return obj;
       }
      obj = new Year(year);
      Year.CACHE.put(Long.valueOf(year), obj);
      return obj;
     }
   }


  /**
   * Get year.
   *
   * @return Year
   * @deprecated Use longValue() instead
   */
  @Deprecated(since = Year.DEPRECATED_SINCE_3_0, forRemoval = false)
  public long getYear()
   {
    return this.year;
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
   * Calculate hash code.
   *
   * @return Hash
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
   {
    return Long.hashCode(this.year);
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
    return this == obj;
    /*
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof Year))
     {
      return false;
     }
    final Year other = (Year)obj;
    return false; // this.year == other.year;
    */
   }


  /**
   * Returns the string representation of this Year.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Year[year=2020]"
   *
   * @return String representation of this Year
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Year[year=").append(this.year).append(']'); //$NON-NLS-1$
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
    long newYear = Math.addExact(this.year, years.longValue());
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
    long newYear = Math.subtractExact(this.year, years.longValue());
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
