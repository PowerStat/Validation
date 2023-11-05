/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

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
 * TODO millisecondsWithin = 1000
 * TODO min, max
 */
public record Second(int second) implements Comparable<Second>, IValueObject
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
    return String.valueOf(this.second);
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
    return Integer.compare(this.second, obj.second);
   }


  /**
   * Add seconds to this second.
   *
   * @param seconds Secondss to add to this second
   * @return New second after adding the seconds to this second
   * @throws ArithmeticException In case of an overflow
   */
  public Second add(final Seconds seconds)
   {
    final int newSecond = Math.toIntExact(Math.addExact(this.second, seconds.seconds()));
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
    final int newSecond = Math.toIntExact(Math.subtractExact(this.second, seconds.seconds()));
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
  public Second increment()
   {
    final int newSecond = Math.incrementExact(this.second);
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
    final int newSecond = Math.decrementExact(this.second);
    if (newSecond == -1)
     {
      // TODO Listener
      throw new ArithmeticException(Second.UNDERFLOW);
     }
    return Second.of(newSecond);
   }

 }
