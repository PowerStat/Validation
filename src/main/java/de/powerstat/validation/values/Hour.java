/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Hour.
 *
 * @param hour Hour 0-23
 * 
 * Not DSGVO relevant.
 *
 * TODO Listener
 * TODO minutesWithin = 60
 */
public record Hour(int hour) implements Comparable<Hour>
 {
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
   * @throws IndexOutOfBoundsException When the hour is less than 0 or greater than 23
   */
  public Hour
   {
    if ((hour < 0) || (hour > 23))
     {
      throw new IndexOutOfBoundsException("Hour number out of range (0-23)!"); //$NON-NLS-1$
     }
   }


  /**
   * Hour factory.
   *
   * @param hour Hour 0-23
   * @return Hour object
   */
  public static Hour of(final int hour)
   {
    return new Hour(hour);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Hour obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(this.hour, obj.hour);
   }


  /**
   * Add hours to this hour.
   *
   * @param hours Hours to add to this hour
   * @return New hour after adding the hours to this hour
   * @throws ArithmeticException In case of an overflow
   */
  public Hour add(final Hours hours)
   {
    final int newHour = Math.toIntExact(Math.addExact(this.hour, hours.hours()));
    if (newHour > 23)
     {
      // TODO Listener
      throw new ArithmeticException(Hour.OVERFLOW);
     }
    return Hour.of(newHour);
   }


  /**
   * Subtract hours from this hour.
   *
   * @param hours Hours to subtract from this hour
   * @return New hour after subtracting hours from this hour
   * @throws ArithmeticException In case of an underflow
   */
  public Hour subtract(final Hours hours)
   {
    final int newHour = Math.toIntExact(Math.subtractExact(this.hour, hours.hours()));
    if (newHour < 0)
     {
      // TODO Listener
      throw new ArithmeticException(Hour.UNDERFLOW);
     }
    return Hour.of(newHour);
   }


  /**
   * Increment this hour.
   *
   * @return New hour after incrementing this hour
   * @throws ArithmeticException In case of an overflow
   */
  public Hour increment()
   {
    final int newHour = Math.incrementExact(this.hour);
    if (newHour == 24)
     {
      // TODO Listener
      throw new ArithmeticException(Hour.OVERFLOW);
     }
    return Hour.of(newHour);
   }


  /**
   * Decrement this hour.
   *
   * @return New hour after decrement this hour
   * @throws ArithmeticException In case of an overflow
   */
  public Hour decrement()
   {
    final int newHour = Math.decrementExact(this.hour);
    if (newHour == -1)
     {
      // TODO Listener
      throw new ArithmeticException(Hour.UNDERFLOW);
     }
    return Hour.of(newHour);
   }

 }
