/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Minute.
 *
 * Not DSGVO relevant.
 *
 * @param minute Minute 0-59
 * 
 * TODO Listener
 * TODO secondsWithin = 60
 */
public record Minute(int minute) implements Comparable<Minute>, IValueObject
 {
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
    return Integer.compare(this.minute, obj.minute);
   }


  /**
   * Add minutes to this minute.
   *
   * @param minutes Minutes to add to this minute
   * @return New minute after adding the minutes to this minute
   * @throws ArithmeticException In case of an overflow
   */
  public Minute add(final Minutes minutes)
   {
    final int newMinute = Math.toIntExact(Math.addExact(this.minute, minutes.minutes()));
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
    final int newMinute = Math.toIntExact(Math.subtractExact(this.minute, minutes.minutes()));
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
  public Minute increment()
   {
    final int newMinute = Math.incrementExact(this.minute);
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
    final int newMinute = Math.decrementExact(this.minute);
    if (newMinute == -1)
     {
      // TODO Listener
      throw new ArithmeticException(Minute.UNDERFLOW);
     }
    return Minute.of(newMinute);
   }

 }
