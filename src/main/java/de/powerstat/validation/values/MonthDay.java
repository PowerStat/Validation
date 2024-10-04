/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * DayMonth.
 *
 * @param month Month
 * @param day Day
 *
 * Not DSGVO relevant.
 *
 * TODO LeapYear support
 * TODO min, max
 */
public record MonthDay(Month month, Day day) implements Comparable<MonthDay>, IValueObject
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
   * Constructor.
   *
   * @param month Month
   * @param day Day
   * @throws NullPointerException When month or day is null
   * @throws IndexOutOfBoundsException When the day is less than 1 or greater than 31 or the day is to large for the month.
   * @throws IllegalStateException When the month is in an illegal state
   */
  public MonthDay
   {
    Objects.requireNonNull(month, "month"); //$NON-NLS-1$
    Objects.requireNonNull(day, "day"); //$NON-NLS-1$
    switch (month.month())
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
        if (day.day() > 30)
         {
          throw new IndexOutOfBoundsException("Day number out of range for the month (31)!"); //$NON-NLS-1$
         }
        break;

      case 2:
        if (day.day() > 29)
         {
          throw new IndexOutOfBoundsException("Day number out of range for the month (30-31)!"); //$NON-NLS-1$
         }
        break;

      default:
        throw new IllegalStateException("Illegal month!"); //$NON-NLS-1$
     }
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
    return new MonthDay(month, day);
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
    final long newMonth = Math.toIntExact(Math.addExact(this.month.month(), months.months()));
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
    final long newMonth = Math.toIntExact(Math.subtractExact(this.month.month(), months.months()));
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
  public MonthDay incrementMonth()
   {
    final int newMonth = Math.incrementExact(this.month.month());
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
   * Decrement this MonthDay by one month.
   *
   * @return New MonthDay after decrement this MonthDay by one month
   * @throws ArithmeticException In case of an overflow
   */
  public MonthDay decrementMonth()
   {
    final int newMonth = Math.decrementExact(this.month.month());
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
