/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Second.
 *
 * @param second Second 0-59/60
 *
 * Not DSGVO relevant.
 *
 * TODO Constructor with day, month, year, hour, minute
 * TODO Listener  (mod 60 = 0)
 */
@ValueObject
public record Second(int second) implements Comparable<Second>, IValueObject
 {
  /**
   * Minimum allowed value 0.
   */
  public static final int MIN_VALUE = 0;

  /**
   * Maximum allowed value 60.
   */
  public static final int MAX_VALUE = 60;

  /**
   * Milliseconds within a second.
   */
  public static final Milliseconds MILLISECONDS_WITHIN = Milliseconds.of(1000);

  /**
   * Overflow constant.
   */
  private static final String OVERFLOW = "Overflow"; //$NON-NLS-1$

  /**
   * Underflow constant.
   */
  private static final String UNDERFLOW = "Underflow"; //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param second Second 0-59/60
   * @throws IndexOutOfBoundsException When the second is less than 0 or greater than 59/60
   */
  public Second
   {
    if ((second < 0) || (second > 60))
     {
      throw new IndexOutOfBoundsException("Second number out of range (0-59/60)!"); //$NON-NLS-1$
     }
   }


  /**
   * Second factory.
   *
   * @param second Second 0-59/60
   * @return Second object
   */
  public static Second of(final int second)
   {
    return new Second(second);
   }


  /**
   * Second factory.
   *
   * @param value Second 0-59/60 string
   * @return Second object
   */
  public static Second of(final String value)
   {
    return of(Integer.parseInt(value));
   }


  /**
   * Returns the value of this Second as an String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(second);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Second obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(second, obj.second);
   }


  /**
   * Add seconds to this second.
   *
   * @param seconds Secondss to add to this second
   * @return New second after adding the seconds to this second
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Second add(final Seconds seconds)
   {
    final int newSecond = Math.toIntExact(Math.addExact(second, seconds.seconds()));
    if (newSecond > 59)
     {
      // TODO Listener
      throw new ArithmeticException(Second.OVERFLOW);
     }
    return Second.of(newSecond);
   }


  /**
   * Subtract seconds from this second.
   *
   * @param seconds Seconds to subtract from this second
   * @return New second after subtracting seconds from this second
   * @throws ArithmeticException In case of an underflow
   */
  public Second subtract(final Seconds seconds)
   {
    final int newSecond = Math.toIntExact(Math.subtractExact(second, seconds.seconds()));
    if (newSecond < 0)
     {
      // TODO Listener
      throw new ArithmeticException(Second.UNDERFLOW);
     }
    return Second.of(newSecond);
   }


  /**
   * Increment this second.
   *
   * @return New second after incrementing this second
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Second increment()
   {
    final int newSecond = Math.incrementExact(second);
    if (newSecond == 60)
     {
      // TODO Listener
      throw new ArithmeticException(Second.OVERFLOW);
     }
    return Second.of(newSecond);
   }


  /**
   * Decrement this second.
   *
   * @return New second after decrement this second
   * @throws ArithmeticException In case of an overflow
   */
  public Second decrement()
   {
    final int newSecond = Math.decrementExact(second);
    if (newSecond == -1)
     {
      // TODO Listener
      throw new ArithmeticException(Second.UNDERFLOW);
     }
    return Second.of(newSecond);
   }

 }
