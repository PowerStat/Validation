/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Day within month.
 *
 * @param month Month
 * @param day Day
 *
 * Not DSGVO relevant.
 *
 * TODO LeapYear support
 * TODO min, max  01.01.    31.12.
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
   * Fix day if necessary (day > lastDayInMonth).
   *
   * @param month Month
   * @return Fixed day
   */
  private int fixDay(Month month)
   {
    long lastDayInMonth = month.daysInMonth().days();
    int newDay = this.day.day();
    if (this.day.day() > lastDayInMonth) // NO PITEST
     {
      newDay = (int)lastDayInMonth;
     }
    return newDay;
   }


  /**
   * Add months to this MonthDay.
   *
   * @param months Months to add to this MonthDay
   * @return New MonthDay after adding the months to this MonthDay
   */
  public MonthDay add(final Months months)
   {
    long newMonth = Math.toIntExact(Math.addExact(this.month.month(), months.months()));
    while (newMonth > 12)
     {
      // TODO Listener year
      newMonth -= 12;
      // incrementYear();
     }
    Month month = Month.of(Math.toIntExact(newMonth));
    int newDay = fixDay(month);
    return MonthDay.of(month, Day.of(newDay));
   }


  /**
   * Subtract months from this MonthDay.
   *
   * @param months Months to subtract from this MonthDay
   * @return New MonthDay after subtracting months from this MonthDay
   */
  public MonthDay subtract(final Months months)
   {
    long newMonth = Math.toIntExact(Math.subtractExact(this.month.month(), months.months()));
    while (newMonth <= 0)
     {
      // TODO Listener year
      newMonth += 12;
      // decrementYear();
     }
    Month month = Month.of(Math.toIntExact(newMonth));
    int newDay = fixDay(month);
    return MonthDay.of(month, Day.of(newDay));
   }


  /**
   * Increment this MonthDay by one month.
   *
   * @return New MonthDay after incrementing this MonthDay by one month
   */
  public MonthDay incrementMonth()
   {
    int newMonth = Math.incrementExact(this.month.month());
    if (newMonth == 13)
     {
      // TODO Listener year
      newMonth = 1;
      // incrementYear();
     }
    Month month = Month.of(Math.toIntExact(newMonth));
    int newDay = fixDay(month);
    return MonthDay.of(month, Day.of(newDay));
   }


  /**
   * Decrement this MonthDay by one month.
   *
   * @return New MonthDay after decrement this MonthDay by one month
   */
  public MonthDay decrementMonth()
   {
    int newMonth = Math.decrementExact(this.month.month());
    if (newMonth == 0)
     {
      // TODO Listener year
      newMonth = 12;
      // decrementYear();
     }
    Month month = Month.of(Math.toIntExact(newMonth));
    int newDay = fixDay(month);
    return MonthDay.of(month, Day.of(newDay));
   }


  /**
   * Add days to this MonthDay.
   *
   * @param days Days to add to this MonthDay
   * @return New MonthDay after adding the days to this MonthDay
   */
  public MonthDay add(final Days days)
   {
    long newDay = Math.toIntExact(Math.addExact(this.day.day(), days.days()));
    int newMonth = this.month.month();
    while (newDay > Month.of(newMonth).daysInMonth().days())
     {
      newDay -= Month.of(newMonth).daysInMonth().days();
      ++newMonth;
      if (newMonth > 12)
       {
        newMonth = 1;
        // incrementYear()
        // TODO Listener Year
       }
     }
    return MonthDay.of(Month.of(newMonth), Day.of(Math.toIntExact(newDay)));
   }


  /**
   * Subtract days from this MonthDay.
   *
   * @param days Days to subtract from this MonthDay
   * @return New MonthDay after subtrating the days from this MonthDay
   */
  public MonthDay subtract(final Days days)
   {
    long newDay = Math.toIntExact(Math.subtractExact(this.day.day(), days.days()));
    int newMonth = this.month.month();
    while (newDay < 1)
     {
      --newMonth;
      if (newMonth < 1)
       {
        newMonth = 12;
        // decrementYear()
        // TODO Listener Year
       }
      newDay += Month.of(newMonth).daysInMonth().days();
     }
    return MonthDay.of(Month.of(newMonth), Day.of(Math.toIntExact(newDay)));
   }


  /**
   * Increment this MonthDay by one day.
   *
   * @return New MonthDay after incrementing this MonthDay by one day
   */
  public MonthDay incrementDay()
   {
    int newMonth = this.month.month();
    int newDay = Math.incrementExact(this.day.day());
    if (newDay > this.month.daysInMonth().days())
     {
      newDay -= this.month.daysInMonth().days();
      // TODO Listener month
      ++newMonth;
      if (newMonth > 12)
       {
        newMonth = 1;
        // TODO Listener year
        // incrementYear();
       }
     }
    return MonthDay.of(Month.of(Math.toIntExact(newMonth)), Day.of(newDay));
   }


  /**
   * Decrement this MonthDay by one day.
   *
   * @return New MonthDay after decrementing this MonthDay by one day
   */
  public MonthDay decrementDay()
   {
    int newMonth = this.month.month();
    int newDay = Math.decrementExact(this.day.day());
    if (newDay < 1)
     {
      // TODO Listener month
      --newMonth;
      if (newMonth < 1)
       {
        newMonth = 12;
        // TODO Listener year
        // incrementYear();
       }
      newDay += Month.of(newMonth).daysInMonth().days();
     }
    return MonthDay.of(Month.of(Math.toIntExact(newMonth)), Day.of(newDay));
   }

 }
