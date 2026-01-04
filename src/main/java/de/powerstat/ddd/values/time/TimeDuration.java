/*
 * Copyright (C) 2026 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.time;


import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;


/**
 * TimeDuration.
 *
 * @param hours Hours 0-..
 * @param mins Minutes 0-.. (59)
 * @param secs Seconds 0-.. (59)
 *
 * Not DSGVO relevant.
 */
@ValueObject
public record TimeDuration(Hours hours, Minutes mins, Seconds secs) implements Comparable<TimeDuration>, IValueObject
 {
  /**
   * Time regexp.
   */
  @SuppressWarnings("java:S5867")
  private static final Pattern TIMEDURATION_REGEXP = Pattern.compile("^PT([0-9]+H)?([0-9]+M)?([0-9]+S)?$"); //$NON-NLS-1$

  /**
   * Underflow contant.
   */
  private static final String UNDERFLOW = "Underflow"; //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param hours Hours 0-..
   * @param mins Minutes 0-.. (59)
   * @param secs Seconds 0-.. (59)
   */
  public TimeDuration
   {
    // TODO normalize
   }


  /**
   * TimeDuration factory.
   *
   * @param hours Hours 0-..
   * @param mins Minutes 0-.. (59)
   * @param secs Seconds 0-.. (59)
   * @return TimeDuration object
   */
  public static TimeDuration of(final Hours hours, final Minutes mins, final Seconds secs)
   {
    Hours h = hours;
    Minutes m = mins;
    Seconds s = secs;
    while (s.compareTo(Seconds.of(59)) > 0)
     {
      s = s.subtract(Seconds.of(60));
      m = m.add(Minutes.of(1)); // TODO increment
     }
    while (m.compareTo(Minutes.of(59)) > 0)
     {
      m = m.subtract(Minutes.of(60));
      h = h.add(Hours.of(1)); // TODO increment
     }
    return new TimeDuration(h, m, s);
   }


  /**
   * TimeDuration factory.
   *
   * @param hours Hours 0-..
   * @param mins Minutes 0-.. (59)
   * @param secs Seconds 0-.. (59)
   * @return TimeDuration object
   */
  public static TimeDuration of(final long hours, final long mins, final long secs)
   {
    long h = hours;
    long m = mins;
    long s = secs;
    while (s > 59)
     {
      s -= 60;
      ++m;
     }
    while (m > 59)
     {
      m -= 60;
      ++h;
     }
    return new TimeDuration(Hours.of(h), Minutes.of(m), Seconds.of(s));
   }


  /**
   * TimeDuration factory.
   *
   * @param value Time string of format PT[xH][xM][xS]
   * @return TimeDuration object
   */
  public static TimeDuration of(final String value)
   {
    Objects.requireNonNull(value, "value"); //$NON-NLS-1$
    if ((value.length() < 4) || (value.length() > 14))
     {
      throw new IllegalArgumentException("TimeDuration value with wrong length"); //$NON-NLS-1$
     }
    if (!TIMEDURATION_REGEXP.matcher(value).matches())
     {
      throw new IllegalArgumentException("TimeDuration value with wrong format, must be PT[xH][xM][xS]"); //$NON-NLS-1$
     }
    long h = 0;
    long m = 0;
    long s = 0;
    Matcher matcher = TIMEDURATION_REGEXP.matcher(value);
    /* boolean success = */ matcher.matches();
    for (int i = 1; i <= matcher.groupCount(); ++i)
     {
      final String match = matcher.group(i);
      final long val = Long.parseLong(match.substring(0, match.length() - 1));
      String type = match.substring(match.length() - 1);
      if ("H".equals(type))
       {
        h = val;
       }
      else if ("M".equals(type))
       {
        m = val;
       }
      else if ("S".equals(type))
       {
        s = val;
       }
     }
    return of(h, m, s);
   }


  /**
   * Returns the value of this TimeDuration as a String of format PTxHxMxS.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return "PT" + hours.hours() + "H" + mins.minutes() + "M" + secs.seconds() + "S";
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final TimeDuration obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int ret = hours.compareTo(obj.hours);
    if (ret == 0)
     {
      ret = mins.compareTo(obj.mins);
      if (ret == 0)
       {
        ret = secs.compareTo(obj.secs);
       }
     }
    return ret;
   }


  /**
   * Add hours to this time duration.
   *
   * @param other Other hours to add to this time duration
   * @return New TimeDuration after adding other hours to this one
   * @throws ArithmeticException In case of an overflow
   */
  public TimeDuration add(final Hours other)
   {
    return TimeDuration.of(Hours.of(Math.addExact(hours.hours(), other.hours())), mins, secs);
   }


  /**
   * Add minutes to this time duration.
   *
   * @param other Other minutes to add to this time duration
   * @return New time duration after adding other minutes to this one
   * @throws ArithmeticException In case of an overflow
   */
  public TimeDuration add(final Minutes other)
   {
    return TimeDuration.of(hours, Minutes.of(Math.addExact(mins.minutes(), other.minutes())), secs);
   }


  /**
   * Add other seconds to this time duration.
   *
   * @param other Other seconds to add to this time duration
   * @return New time duration after adding other seconds to this one
   * @throws ArithmeticException In case of an overflow
   */
  public TimeDuration add(final Seconds other)
   {
    return TimeDuration.of(hours, mins, Seconds.of(Math.addExact(secs.seconds(), other.seconds())));
   }


  /**
   * Add other time duration to this time duration.
   *
   * @param other Other time duration to add to this time duration
   * @return New time duration after adding another to this one
   * @throws ArithmeticException In case of an overflow
   */
  public TimeDuration add(final TimeDuration other)
   {
    return TimeDuration.of(hours.add(other.hours), mins.add(other.mins), secs.add(other.secs));
   }


  /**
   * Subtract other hours from this time duration.
   *
   * @param other Other hours to subtract from this time duration
   * @return Absolute new time duration after subtracting other hours from this one
   */
  public TimeDuration subtract(final Hours other)
   {
    if (other.hours() > hours.hours()) // NO PITEST
     {
      return TimeDuration.of(Hours.of(other.hours() - hours.hours()), mins, secs); // TODO overflow
     }
    return TimeDuration.of(Hours.of(hours.hours() - other.hours()), mins, secs);
   }


  /**
   * Subtract other minutes from this time duration.
   *
   * @param other Other minutes to subtract from this time duration
   * @return Absolute new time duration after subtracting other minutes from this one
   */
  public TimeDuration subtract(final Minutes other)
   {
    if (other.minutes() > mins.minutes()) // NO PITEST
     {
      long newMins = 60 - (other.minutes() - mins.minutes());
      long newHours = hours.hours() - 1;
      if (newHours < 0)
       {
        newHours = 0;
        newMins = other.minutes() - mins.minutes();
       }
      return TimeDuration.of(newHours, newMins, secs.seconds());
     }
    return TimeDuration.of(hours, Minutes.of(mins.minutes() - other.minutes()), secs);
   }


  /**
   * Subtract other seconds from this time duration.
   *
   * @param other Other seconds to subtract from this time duration
   * @return Absolute new time duration after subtracting other seconds from this one
   */
  public TimeDuration subtract(final Seconds other)
   {
    if (other.seconds() > secs.seconds()) // NO PITEST
     {
      long newSecs = 60 - (other.seconds() - secs.seconds());
      long newMins = mins.minutes() - 1;
      long newHours = hours.hours();
      if (newMins < 0)
       {
        newMins = 60 + newMins;
        --newHours;
        if (newHours < 0)
         {
          newHours = 0;
          newMins = 0;
          newSecs = other.seconds() - secs.seconds();
         }
       }
      return TimeDuration.of(newHours, newMins, newSecs);
     }
    return TimeDuration.of(hours, mins, Seconds.of(secs.seconds() - other.seconds()));
   }


  /**
   * Subtract other time duration from this time duration.
   *
   * @param other Other time duration to subtract from this time duration
   * @return Absolute new time duration after subtracting other time duration from this one
   */
  public TimeDuration subtract(final TimeDuration other)
   {
    long newSecs;
    long newMins;
    long newHours;
    long carryMins = 0;
    long carryHours = 0;
    if (this.compareTo(other) < 0) // NO PITEST
     {
      newSecs = other.secs.subtract(secs).seconds();
      if (other.secs.compareTo(secs) < 0)
       {
        newSecs = 60 - newSecs;
        carryMins = 1;
       }
      newMins = other.mins.subtract(Minutes.of(mins.minutes() + carryMins)).minutes();
      if (other.mins.compareTo(mins) < 0)
       {
        newMins = 60 - newMins;
        carryHours = 1;
       }
      newHours = other.hours.subtract(Hours.of(hours.hours() + carryHours)).hours();
     }
    else
     {
      newSecs = secs.subtract(other.secs).seconds();
      if (secs.compareTo(other.secs) < 0)
       {
        newSecs = 60 - newSecs;
        carryMins = 1;
       }
      newMins = mins.subtract(Minutes.of(other.mins.minutes() + carryMins)).minutes();
      if (mins.compareTo(other.mins) < 0)
       {
        newMins = 60 - newMins;
        carryHours = 1;
       }
      newHours = hours.subtract(Hours.of(other.hours.hours() + carryHours)).hours();
     }
    return TimeDuration.of(newHours, newMins, newSecs);
   }


  /**
   * Multiply time duration with a multiplier.
   *
   * @param multiplier Multiplier to multiply with
   * @return New time duration that is a multiplication of this time duration with the multiplier
   * @throws ArithmeticException In case of an overflow
   */
  public TimeDuration multiply(final long multiplier)
   {
    return TimeDuration.of(Math.multiplyExact(hours.hours(), multiplier), Math.multiplyExact(mins.minutes(), multiplier), Math.multiplyExact(secs.seconds(), multiplier));
   }


  /**
   * Divide time duration by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The largest (closest to positive infinity) long value that is less than or equal to the algebraic quotient.
   * @throws ArithmeticException In case the divisor is 0.
   */
  public TimeDuration divide(final long divisor)
   {
    long seconds = Math.floorDiv(secs.seconds() + (60 * mins.minutes()) + (3600 * hours.hours()), divisor);
    long h = Math.floorDiv(seconds, 3600);
    seconds -= (h * 3600);
    long m = Math.floorDiv(seconds, 60);
    seconds -= (m * 60);
    long s = seconds;
    return TimeDuration.of(h, m, s);
   }


  /**
   * Floor modulo time duration by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The floor modulus TimeDuration - (floorDiv(TimeDuration, divisor) * divisor)
   * @throws ArithmeticException In case the divisor is 0.
   */
  public TimeDuration modulo(final long divisor)
   {
    long seconds = Math.floorMod(secs.seconds() + (60 * mins.minutes()) + (3600 * hours.hours()), divisor);
    return TimeDuration.of(0, 0, seconds);
   }


  /**
   * Increment hours.
   *
   * @return New hours after incrementing
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public TimeDuration incrementHours()
   {
    final long newHours = Math.incrementExact(hours.hours());
    return TimeDuration.of(newHours, mins.minutes(), secs.seconds());
   }


  /**
   * Decrement hours.
   *
   * @return New hours after decrementing
   * @throws ArithmeticException In case of an overflow
   */
  public TimeDuration decrementHours()
   {
    final long newHours = Math.decrementExact(hours.hours());
    if (newHours == -1)
     {
      // TODO Listener
      throw new ArithmeticException(UNDERFLOW);
     }
    return TimeDuration.of(newHours, mins.minutes(), secs.seconds());
   }


  /**
   * Increment mins.
   *
   * @return New minutes after incrementing
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public TimeDuration incrementMins()
   {
    long newHours = hours.hours();
    long newMins = Math.incrementExact(mins.minutes());
    if (newMins == 60)
     {
      newMins = 0;
      newHours = Math.incrementExact(newHours);
     }
    return TimeDuration.of(newHours, newMins, secs.seconds());
   }


  /**
   * Decrement mins.
   *
   * @return New minutes after decrementing
   * @throws ArithmeticException In case of an overflow
   */
  public TimeDuration decrementMins()
   {
    long newHours = hours.hours();
    long newMins = Math.decrementExact(mins.minutes());
    if (newMins == -1)
     {
      newMins = 59;
      newHours = Math.decrementExact(newHours);
      if (newHours == -1)
       {
        // TODO Listener
        throw new ArithmeticException(UNDERFLOW);
       }
     }
    return TimeDuration.of(newHours, newMins, secs.seconds());
   }


  /**
   * Increment secs.
   *
   * @return New seconds after incrementing
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public TimeDuration incrementSecs()
   {
    long newHours = hours.hours();
    long newMins = mins.minutes();
    long newSecs = Math.incrementExact(secs.seconds());
    if (newSecs == 60)
     {
      newSecs = 0;
      newMins = Math.incrementExact(newMins);
      if (newMins == 60)
       {
        newMins = 0;
        newHours = Math.incrementExact(newHours);
       }
     }
    return TimeDuration.of(newHours, newMins, newSecs);
   }


  /**
   * Decrement secs.
   *
   * @return New seconds after decrementing
   * @throws ArithmeticException In case of an overflow
   */
  public TimeDuration decrementSecs()
   {
    long newHours = hours.hours();
    long newMins = mins.minutes();
    long newSecs = Math.decrementExact(secs.seconds());
    if (newSecs == -1)
     {
      newSecs = 59;
      newMins = Math.decrementExact(newMins);
      if (newMins == -1)
       {
        newMins = 59;
        newHours = Math.decrementExact(newHours);
        if (newHours == -1)
         {
          // TODO Listener
          throw new ArithmeticException(UNDERFLOW);
         }
       }
     }
    return TimeDuration.of(newHours, newMins, newSecs);
   }

 }
