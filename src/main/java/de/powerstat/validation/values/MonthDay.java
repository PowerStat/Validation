/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * DayMonth.
 *
 * Not DSGVO relevant.
 *
 * TODO LeapYear support
 */
public final class MonthDay implements Comparable<MonthDay>, IValueObject
 {
  /**
   * Overflow constant.
   */
  private static final String OVERFLOW = "Overflow"; //$NON-NLS-1$

  /**
   * Underflow constant.
   */
  private static final String UNDERFLOW = "Underflow"; //$NON-NLS-1$

  /**
   * Date separator.
   */
  private static final String DATE_SEP = "-"; //$NON-NLS-1$

  /**
   * Cache for singletons.
   */
  @SuppressWarnings("PMD.UseConcurrentHashMap")
  private static final Map<Integer, MonthDay> CACHE = new WeakHashMap<>();

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
   * @param month Month
   * @param day Day
   * @throws NullPointerException When month or day is null
   * @throws IndexOutOfBoundsException When the day is less than 1 or greater than 31 or the day is to large for the month.
   * @throws IllegalStateException When the month is in an illegal state
   */
  private MonthDay(final Month month, final Day day)
   {
    super();
    Objects.requireNonNull(month, "month"); //$NON-NLS-1$
    Objects.requireNonNull(day, "day"); //$NON-NLS-1$
    switch (month.intValue())
     {
      case 1:
      case 3:
      case 5:
      case 7:
      case 8:
      case 10:
      case 12:
        break;

      case 4:
      case 6:
      case 9:
      case 11:
        if (day.intValue() > 30)
         {
          throw new IndexOutOfBoundsException("Day number out of range for the month (31)!"); //$NON-NLS-1$
         }
        break;

      case 2:
        if (day.intValue() > 29)
         {
          throw new IndexOutOfBoundsException("Day number out of range for the month (30-31)!"); //$NON-NLS-1$
         }
        break;

      default:
        throw new IllegalStateException("Illegal month!"); //$NON-NLS-1$
     }
    this.month = month;
    this.day = day;
   }


  /**
   * DayMonth factory.
   *
   * @param month Month 1-12
   * @param day Day 1-31
   * @return DayMonth object
   */
  public static MonthDay of(final Month month, final Day day)
   {
    synchronized (MonthDay.class)
     {
      MonthDay obj = MonthDay.CACHE.get((month.intValue() * 100) + day.intValue());
      if (obj != null)
       {
        return obj;
       }
      obj = new MonthDay(month, day);
      MonthDay.CACHE.put(Integer.valueOf((month.intValue() * 100) + day.intValue()), obj);
      return obj;
     }
   }


  /**
   * DayMonth factory.
   *
   * @param value ISO8601 format [m]m-[d]d
   * @return DayMonth object
   */
  public static MonthDay of(final String value)
   {
    final String[] values = value.split(DATE_SEP);
    if (values.length != 2)
     {
      throw new IllegalArgumentException("value not of required format");
     }
    return of(Month.of(values[0]), Day.of(values[1]));
   }


  /**
   * Returns the month value of this DayMonth.
   *
   * @return The month value represented by this object.
   */
  public Month monthValue()
   {
    return this.month;
   }


  /**
   * Returns the day value of this DayMonth.
   *
   * @return The day value represented by this object.
   */
  public Day dayValue()
   {
    return this.day;
   }


  /**
   * Returns the String value of this DayMonth in ISO8601 format.
   *
   * @return The String value represented by this object ([m]m-[d]d).
   */
  @Override
  public String stringValue()
   {
    return this.month.stringValue() + DATE_SEP + this.day.stringValue();
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
    return Objects.hash(this.month, this.day);
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
    if ((obj == null) || (this.getClass() != obj.getClass()))
    // if (!(obj instanceof DayMonth))
     {
      return false;
     }
    final MonthDay other = (MonthDay)obj;
    boolean result = this.month.equals(other.month);
    if (result)
     {
      result = this.day.equals(other.day);
     }
    return result;
   }


  /**
   * Returns the string representation of this DayMonth.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "DayMonth[month=1, day=1]"
   *
   * @return String representation of this DayMonth
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(22);
    builder.append("MonthDay[month=").append(this.month).append(", day=").append(this.day).append(']'); //$NON-NLS-1$
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
  public int compareTo(final MonthDay obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = this.month.compareTo(obj.month);
    if (result == 0)
     {
      result = this.day.compareTo(obj.day);
     }
    return result;
   }


  /**
   * Add months to this MonthDay.
   *
   * @param months Months to add to this MonthDay
   * @return New MonthDay after adding the months to this MonthDay
   * @throws ArithmeticException In case of an overflow
   */
  public MonthDay add(final Months months)
   {
    final long newMonth = Math.toIntExact(Math.addExact(this.month.intValue(), months.longValue()));
    if (newMonth > 12) // while (newMonth > 12)
     {
      // TODO Listener
      // newMonthDay -= 12;
      // incrementYear();
      throw new ArithmeticException(MonthDay.OVERFLOW);
     }
    return MonthDay.of(Month.of(Math.toIntExact(newMonth)), this.day);
   }


  /**
   * Subtract months from this MonthDay.
   *
   * @param months Months to subtract from this MonthDay
   * @return New MonthDay after subtracting months from this MonthDay
   * @throws ArithmeticException In case of an underflow
   */
  public MonthDay subtract(final Months months)
   {
    final long newMonth = Math.toIntExact(Math.subtractExact(this.month.intValue(), months.longValue()));
    if (newMonth <= 0) // while (newMonth <= 0)
     {
      // TODO Listener
      // newMonth += 12;
      // decrementYear();
      throw new ArithmeticException(MonthDay.UNDERFLOW);
     }
    return MonthDay.of(Month.of(Math.toIntExact(newMonth)), this.day);
   }


  /**
   * Increment this MonthDay by one month.
   *
   * @return New MonthDay after incrementing this MonthDay by one month
   * @throws ArithmeticException In case of an overflow
   */
  public MonthDay increment()
   {
    final int newMonth = Math.incrementExact(this.month.intValue());
    if (newMonth == 13)
     {
      // TODO Listener
      // newMonth = 1;
      // incrementYear();
      throw new ArithmeticException(MonthDay.OVERFLOW);
     }
    return MonthDay.of(Month.of(newMonth), this.day);
   }


  /**
   * Decrement this MonthDay.
   *
   * @return New MonthDay after decrement this MonthDay by one month
   * @throws ArithmeticException In case of an overflow
   */
  public MonthDay decrement()
   {
    final int newMonth = Math.decrementExact(this.month.intValue());
    if (newMonth == 0)
     {
      // TODO Listener
      // newMonth = 12;
      // decrementYear();
      throw new ArithmeticException(MonthDay.UNDERFLOW);
     }
    return MonthDay.of(Month.of(newMonth), this.day);
   }


  // TODO add days (leap year)
  // TODO subtract days (leap year)
  // TODO increment day (leap year)
  // TODO decrement day (leap year)

 }
