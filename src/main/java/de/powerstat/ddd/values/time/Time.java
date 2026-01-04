/*
 * Copyright (C) 2026 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.time;


import java.util.Objects;
import java.util.regex.Pattern;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;
import de.powerstat.ddd.values.finance.BIC;


/**
 * Time.
 *
 * @param hour Hour
 * @param min Minute
 * @param sec Second
 *
 * Not DSGVO relevant.
 *
 * TODO Listener
 */
@ValueObject
public record Time(Hour hour, Minute min, Second sec) implements Comparable<Time>, IValueObject
 {
  /**
   * Time regexp.
   */
  @SuppressWarnings("java:S5867")
  private static final Pattern TIME_REGEXP = Pattern.compile("^((0?[0-9])|(1[0-9])|(2[0-3]))(:((0?[0-9])|([1-5][0-9]))(:((0?[0-9])|([1-5][0-9])))?)?$"); //$NON-NLS-1$


  /**
   * Overflow constant.
   */
  private static final String OVERFLOW = "Overflow"; //$NON-NLS-1$

  /**
   * Underflow contant.
   */
  private static final String UNDERFLOW = "Underflow"; //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param hour Hour
   * @param min Minute
   * @param sec Second
   */
  public Time
   {
   }


  /**
   * Time factory.
   *
   * @param hour Hour
   * @param min Minute
   * @param sec Second
   * @return Time object
   */
  public static Time of(final Hour hour, final Minute min, final Second sec)
   {
    return new Time(hour, min, sec);
   }


  /**
   * Time factory.
   *
   * @param hour Hour 0-23
   * @param min Minute 0-59
   * @param sec Second 0-59
   * @return Time object
   */
  public static Time of(final int hour, final int min, final int sec)
   {
    return new Time(Hour.of(hour), Minute.of(min), Second.of(sec));
   }


  /**
   * Time factory.
   *
   * @param value Time string of format hh[:mm[:ss]]
   * @return Time object
   */
  public static Time of(final String value)
   {
    Objects.requireNonNull(value, "value"); //$NON-NLS-1$
    if ((value.length() < 1) || (value.length() > 8))
     {
      throw new IllegalArgumentException("Time value with wrong length"); //$NON-NLS-1$
     }
    if (!Time.TIME_REGEXP.matcher(value).matches())
     {
      throw new IllegalArgumentException("Time value with wrong format, must be hh[:mm[:ss]]"); //$NON-NLS-1$
     }
    final String[] parts = value.split(":");
    return of(Hour.of(parts[0]), Minute.of((parts.length > 1) ? parts[1] : "0"), Second.of((parts.length > 2) ? parts[2] : "0"));
   }


  /**
   * Returns the value of this Time as a String of format hh:mm:ss.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.format("%1$02d:%2$02d:%3$02d", hour.hour(), min.minute(), sec.second());
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Time obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int ret = hour.compareTo(obj.hour);
    if (ret == 0)
     {
      ret = min.compareTo(obj.min);
      if (ret == 0)
       {
        ret = sec.compareTo(obj.sec);
       }
     }
    return ret;
   }


  /**
   * Add hours to this time.
   *
   * @param other Hours to add to this time
   * @return New Time after adding hours to this one
   * @throws ArithmeticException In case of an overflow
   */
  public Time add(final Hours other)
   {
    long h = Math.addExact(hour.hour(), other.hours());
    int newHour = (int)(h % 24);
    if (h > 23)
     {
      // TODO overflow(s)
     }
    return Time.of(Hour.of(newHour), min, sec);
   }


  /**
   * Add minutes to this time.
   *
   * @param other Minutes to add to this time
   * @return New time after adding minutes to this one
   * @throws ArithmeticException In case of an overflow
   */
  public Time add(final Minutes other)
   {
    long m = Math.addExact(min.minute(), other.minutes());
    int newMin = (int)(m % 60);
    int newHour = hour.hour();
    if (m > 59)
     {
      ++newHour;
      if (newHour == 24)
       {
        newHour = 0;
        // TODO overflow
       }
     }
    return Time.of(Hour.of(newHour), Minute.of(newMin), sec);
   }


  /**
   * Add seconds to this time.
   *
   * @param other Seconds to add to this time
   * @return New time after adding seconds to this one
   * @throws ArithmeticException In case of an overflow
   */
  public Time add(final Seconds other)
   {
    long s = Math.addExact(sec.second(), other.seconds());
    int newSec = (int)(s % 60);
    int newMin = min.minute();
    int newHour = hour.hour();
    if (s > 59)
     {
      ++newMin;
      if (newMin == 60)
       {
        newMin = 0;
        ++newHour;
        if (newHour == 24)
         {
          newHour = 0;
          // TODO overflow
         }
       }
     }
    return Time.of(Hour.of(newHour), Minute.of(newMin), Second.of(newSec));
   }


  /**
   * Add time duration to this time.
   *
   * @param other Time duration to add to this time
   * @return New time after adding time duration to this one
   * @throws ArithmeticException In case of an overflow
   */
  public Time add(final TimeDuration other)
   {
    long s = Math.addExact(sec.second(), other.secs().seconds());
    int newSec = (int)(s % 60);
    int newMin = min.minute();
    int newHour = hour.hour();
    if (s > 59)
     {
      ++newMin;
      if (newMin == 60)
       {
        newMin = 0;
        ++newHour;
        if (newHour == 24)
         {
          newHour = 0;
          // TODO overflow
         }
       }
     }
    long m = Math.addExact(newMin, other.mins().minutes());
    newMin = (int)(m % 60);
    if (m > 59)
     {
      ++newHour;
      if (newHour == 24)
       {
        newHour = 0;
        // TODO overflow
       }
     }
    long h = Math.addExact(newHour, other.hours().hours());
    newHour = (int)(h % 24);
    if (h > 23)
     {
      // TODO overflow(s)
     }
    return Time.of(Hour.of(newHour), Minute.of(newMin), Second.of(newSec));
   }


  /**
   * Subtract hours from this time.
   *
   * @param other Hours to subtract from this time
   * @return Absolute new time after subtracting other hours from this one
   */
  public Time subtract(final Hours other)
   {
    long h = Math.subtractExact(hour.hour(), other.hours());
    while (h < 0)
     {
      h += 24;
      // TODO underflow(s)
     }
    int newHour = (int)h;
    return Time.of(Hour.of(newHour), min, sec);
   }


  /**
   * Subtract minutes from this time.
   *
   * @param other Minutes to subtract from this time
   * @return Absolute new time after subtracting other minutes from this one
   */
  public Time subtract(final Minutes other)
   {
    int newHour = hour.hour();
    long m = Math.subtractExact(min.minute(), other.minutes());
    while (m < 0)
     {
      m += 60;
      --newHour;
      if (newHour < 0)
       {
        newHour = 23;
        // TODO underflow
       }
     }
    int newMin = (int)m;
    return Time.of(Hour.of(newHour), Minute.of(newMin), sec);
   }


  /**
   * Subtract seconds from this time.
   *
   * @param other Seconds to subtract from this time
   * @return Absolute new time after subtracting other seconds from this one
   */
  public Time subtract(final Seconds other)
   {
    int newHour = hour.hour();
    int newMin = min.minute();
    long s = Math.subtractExact(sec.second(), other.seconds());
    while (s < 0)
     {
      s += 60;
      --newMin;
      if (newMin < 0)
       {
        newMin = 59;
        --newHour;
        if (newHour < 0)
         {
          newHour = 23;
          // TODO underflow
         }
       }
     }
    int newSec = (int)s;
    return Time.of(Hour.of(newHour), Minute.of(newMin), Second.of(newSec));
   }


  /**
   * Subtract time duration from this time.
   *
   * @param other Time duration to subtract from this time
   * @return Absolute new time duration after subtracting other time duration from this one
   */
  public Time subtract(final TimeDuration other)
   {
    int newHour = hour.hour();
    int newMin = min.minute();
    long s = Math.subtractExact(sec.second(), other.secs().seconds());
    if (s < 0)
     {
      s += 60;
      --newMin;
      if (newMin < 0)
       {
        newMin = 59;
        --newHour;
        if (newHour < 0)
         {
          newHour = 23;
          // TODO underflow
         }
       }
     }
    int newSec = (int)s;
    long m = Math.subtractExact(newMin, other.mins().minutes());
    if (m < 0)
     {
      m += 60;
      --newHour;
      if (newHour < 0)
       {
        newHour = 23;
        // TODO underflow
       }
     }
    newMin = (int)m;
    long h = Math.subtractExact(newHour, other.hours().hours());
    if (h < 0)
     {
      h += 24;
      // TODO underflow
     }
    newHour = (int)h;
    return Time.of(Hour.of(newHour), Minute.of(newMin), Second.of(newSec));
   }


  /**
   * Increment hour.
   *
   * @return New time after incrementing
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Time incrementHour()
   {
    int newHour = Math.incrementExact(hour.hour());
    if (newHour == 24)
     {
      newHour = 0;
      // TODO overflow
     }
    return Time.of(Hour.of(newHour), min, sec);
   }


  /**
   * Decrement hour.
   *
   * @return New time after decrementing
   * @throws ArithmeticException In case of an underflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Time decrementHour()
   {
    int newHour = Math.decrementExact(hour.hour());
    if (newHour == -1)
     {
      newHour = 23;
      // TODO underflow
     }
    return Time.of(Hour.of(newHour), min, sec);
   }


  /**
   * Increment minute.
   *
   * @return New time after incrementing
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Time incrementMin()
   {
    int newHour = hour.hour();
    int newMin = Math.incrementExact(min.minute());
    if (newMin == 60)
     {
      newMin = 0;
      newHour = Math.incrementExact(newHour);
      if (newHour == 24)
       {
        newHour = 0;
        // TODO overflow
       }
     }
    return Time.of(newHour, newMin, sec.second());
   }


  /**
   * Decrement minute.
   *
   * @return New time after decrementing
   * @throws ArithmeticException In case of an underflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Time decrementMin()
   {
    int newHour = hour.hour();
    int newMin = Math.decrementExact(min.minute());
    if (newMin == -1)
     {
      newMin = 59;
      newHour = Math.decrementExact(newHour);
      if (newHour == -1)
       {
        newHour = 23;
        // TODO underflow
       }
     }
    return Time.of(newHour, newMin, sec.second());
   }


  /**
   * Increment second.
   *
   * @return New time after incrementing
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Time incrementSec()
   {
    int newHour = hour.hour();
    int newMin = min.minute();
    int newSec = Math.incrementExact(sec.second());
    if (newSec == 60)
     {
      newSec = 0;
      ++newMin;
      if (newMin == 60)
       {
        newMin = 0;
        ++newHour;
        if (newHour == 24)
         {
          newHour = 0;
          // TODO overflow
         }
       }
     }
    return Time.of(newHour, newMin, newSec);
   }


  /**
   * Decrement second.
   *
   * @return New time after decrementing
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Time decrementSec()
   {
    int newHour = hour.hour();
    int newMin = min.minute();
    int newSec = Math.decrementExact(sec.second());
    if (newSec == -1)
     {
      newSec = 59;
      --newMin;
      if (newMin == -1)
       {
        newMin = 59;
        --newHour;
        if (newHour == -1)
         {
          newHour = 23;
          // TODO underflow
         }
       }
     }
    return Time.of(newHour, newMin, newSec);
   }

 }
