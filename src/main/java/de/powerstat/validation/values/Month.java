/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Month.
 *
 * Not DSGVO relevant.
 *
 * TODO constructor with year ?
 * TODO Listener for over-/underflow
 * TODO Translations short/long name
 */
public final class Month implements Comparable<Month>, IValueObject
 {
  /**
   * Minimum allowed value 1.
   */
  public static final int MIN_VALUE = 1;

  /**
   * Maximum allowed value 12.
   */
  public static final int MAX_VALUE = 12;

  /**
   * Minimum days within a month.
   */
  public static final Days MIN_DAYS_WITHIN = Days.of(28);

  /**
   * Maximum days within a month.
   */
  public static final Days MAX_DAYS_WITHIN = Days.of(31);

  /* *
   * Cache for singletons.
   */
  // private static final Map<Integer, Month> CACHE = new WeakHashMap<>();

  /**
   * Overflow constant.
   */
  private static final String OVERFLOW = "Overflow"; //$NON-NLS-1$

  /**
   * Underflow constant.
   */
  private static final String UNDERFLOW = "Underflow"; //$NON-NLS-1$

  /**
   * Days per month.
   */
  private static final int[] DAYS_IN_MONTH = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

  /**
   * Month.
   */
  private final int month;


  /**
   * Constructor.
   *
   * @param month Month 1-12
   * @throws IndexOutOfBoundsException When the month is less than 1 or greater than 12
   */
  private Month(final int month)
   {
    super();
    if ((month < 1) || (month > 12))
     {
      throw new IndexOutOfBoundsException("Month number out of range (1-12)!"); //$NON-NLS-1$
     }
    this.month = month;
   }


  /**
   * Month factory.
   *
   * @param month Month 1-12
   * @return Month object
   * @throws IndexOutOfBoundsException When the month is less than 1 or greater than 12
   */
  public static Month of(final int month)
   {
    /*
    synchronized (Month.class)
     {
      Month obj = Month.CACHE.get(month);
      if (obj != null)
       {
        return obj;
       }
      obj = new Month(month);
      Month.CACHE.put(Integer.valueOf(month), obj);
      return obj;
     }
    */
    return new Month(month);
   }


  /**
   * Month factory.
   *
   * @param value Month 1-12 string
   * @return Month object
   * @throws IndexOutOfBoundsException When the month is less than 1 or greater than 12
   */
  public static Month of(final String value)
   {
    return of(Integer.parseInt(value));
   }


  /**
   * Returns the value of this Month as an int.
   *
   * @return The numeric value represented by this object after conversion to type int.
   */
  public int intValue()
   {
    return month;
   }


  /**
   * Returns the value of this Month as an String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(month);
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
    return Integer.hashCode(month);
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @SuppressWarnings({"PMD.SimplifyBooleanReturns"})
  @Override
  public boolean equals(final Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof final Month other))
     {
      return false;
     }
    return (month == other.month);
   }


  /**
   * Returns the string representation of this Month.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Month[month=1]"
   *
   * @return String representation of this Month
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("Month[month=").append(month).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Month obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(month, obj.month);
   }


  /**
   * Get days in month.
   *
   * @return Days (28-31)
   */
  public Days daysInMonth()
   {
    return Days.of(DAYS_IN_MONTH[month]); // TODO depends on year == leapYear for february
   }


  /**
   * Add months to this month.
   *
   * @param months Months to add to this month
   * @return New month after adding the months to this month
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Month add(final Months months)
   {
    final long newMonth = Math.toIntExact(Math.addExact(month, months.longValue()));
    if (newMonth > 12) // while (newMonth > 12)
     {
      // TODO Listener
      // newMonth -= 12;
      // incrementYear();
      throw new ArithmeticException(Month.OVERFLOW);
     }
    return Month.of(Math.toIntExact(newMonth));
   }


  /**
   * Subtract months from this month.
   *
   * @param months Months to subtract from this month
   * @return New month after subtracting months from this month
   * @throws ArithmeticException In case of an underflow
   */
  public Month subtract(final Months months)
   {
    final long newMonth = Math.toIntExact(Math.subtractExact(month, months.longValue()));
    if (newMonth <= 0) // while (newMonth <= 0)
     {
      // TODO Listener
      // newMonth += 12;
      // decrementYear();
      throw new ArithmeticException(Month.UNDERFLOW);
     }
    return Month.of(Math.toIntExact(newMonth));
   }


  /**
   * Increment this month.
   *
   * @return New month after incrementing this month
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Month increment()
   {
    final int newMonth = Math.incrementExact(month);
    if (newMonth == 13)
     {
      // TODO Listener
      // newMonth = 1;
      // incrementYear();
      throw new ArithmeticException(Month.OVERFLOW);
     }
    return Month.of(newMonth);
   }


  /**
   * Decrement this month.
   *
   * @return New month after decrement this month
   * @throws ArithmeticException In case of an overflow
   */
  public Month decrement()
   {
    final int newMonth = Math.decrementExact(month);
    if (newMonth == 0)
     {
      // TODO Listener
      // newMonth = 12;
      // decrementYear();
      throw new ArithmeticException(Month.UNDERFLOW);
     }
    return Month.of(newMonth);
   }

 }
