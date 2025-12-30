/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values;


import java.util.Objects;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Minute.
 *
 * Not DSGVO relevant.
 *
 * @param minute Minute 0-59
 *
 * TODO Listener
 */
@ValueObject
public record Minute(int minute) implements Comparable<Minute>, IValueObject
 {
  /**
   * Minimum allowed value 0.
   */
  public static final int MIN_VALUE = 0;

  /**
   * Maximum allowed value 59.
   */
  public static final int MAX_VALUE = 59;

  /**
   * Seconds within a minute.
   */
  public static final Seconds SECONDS_WITHIN = Seconds.of(60);

  /**
   * Overlfow constant.
   */
  private static final String OVERFLOW = "Overflow"; //$NON-NLS-1$

  /**
   * Underflow constant.
   */
  private static final String UNDERFLOW = "Underflow"; //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param minute Minute 0-59
   * @throws IndexOutOfBoundsException When the minute is less than 0 or greater than 59
   */
  public Minute
   {
    if ((minute < 0) || (minute > 59))
     {
      throw new IndexOutOfBoundsException("Minute number out of range (0-59)!"); //$NON-NLS-1$
     }
   }


  /**
   * Minute factory.
   *
   * @param minute Minute 0-59
   * @return Minute object
   */
  public static Minute of(final int minute)
   {
    return new Minute(minute);
   }


  /**
   * Minute factory.
   *
   * @param value Minute 0-59 string
   * @return Minute object
   */
  public static Minute of(final String value)
   {
    return of(Integer.parseInt(value));
   }


  /**
   * Returns the value of this Minute as an String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(minute);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Minute obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(minute, obj.minute);
   }


  /**
   * Add minutes to this minute.
   *
   * @param minutes Minutes to add to this minute
   * @return New minute after adding the minutes to this minute
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Minute add(final Minutes minutes)
   {
    final int newMinute = Math.toIntExact(Math.addExact(minute, minutes.minutes()));
    if (newMinute > 59)
     {
      // TODO Listener
      throw new ArithmeticException(Minute.OVERFLOW);
     }
    return Minute.of(newMinute);
   }


  /**
   * Subtract minutes from this minute.
   *
   * @param minutes Minutes to subtract from this minute
   * @return New minute after subtracting minutes from this minute
   * @throws ArithmeticException In case of an underflow
   */
  public Minute subtract(final Minutes minutes)
   {
    final int newMinute = Math.toIntExact(Math.subtractExact(minute, minutes.minutes()));
    if (newMinute < 0)
     {
      // TODO Listener
      throw new ArithmeticException(Minute.UNDERFLOW);
     }
    return Minute.of(newMinute);
   }


  /**
   * Increment this minute.
   *
   * @return New minute after incrementing this minute
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Minute increment()
   {
    final int newMinute = Math.incrementExact(minute);
    if (newMinute == 60)
     {
      // TODO Listener
      throw new ArithmeticException(Minute.OVERFLOW);
     }
    return Minute.of(newMinute);
   }


  /**
   * Decrement this minute.
   *
   * @return New minute after decrement this minute
   * @throws ArithmeticException In case of an overflow
   */
  public Minute decrement()
   {
    final int newMinute = Math.decrementExact(minute);
    if (newMinute == -1)
     {
      // TODO Listener
      throw new ArithmeticException(Minute.UNDERFLOW);
     }
    return Minute.of(newMinute);
   }

 }
