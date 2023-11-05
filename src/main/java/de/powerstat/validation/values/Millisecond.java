/*
 * Copyright (C) 2021-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Millisecond.
 *
 * @param millisecond Millisecond 0-999
 * 
 * Not DSGVO relevant.
 *
 * TODO Listener
 * TODO min, max
 */
public record Millisecond(int millisecond) implements Comparable<Millisecond>, IValueObject
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
   * @param millisecond Millisecond 0-999
   * @throws IndexOutOfBoundsException When the milliseond is less than 0 or greater than 999
   */
  public Millisecond
   {
    if ((millisecond < 0) || (millisecond > 999))
     {
      throw new IndexOutOfBoundsException("Millisecond out of range (0-999)!"); //$NON-NLS-1$
     }
   }


  /**
   * Millisecond factory.
   *
   * @param millisecond Millisecond 0-999
   * @return Millisecond object
   */
  public static Millisecond of(final int millisecond)
   {
    return new Millisecond(millisecond);
   }


  /**
   * Millisecond factory.
   *
   * @param value Millisecond string 0-999
   * @return Millisecond object
   */
  public static Millisecond of(final String value)
   {
    return of(Integer.parseInt(value));
   }


  /**
   * Returns the value of this Millisecond as an String.
   *
   * @return The numeric value represented by this object after conversion to type String (0-999).
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(this.millisecond);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Millisecond obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(this.millisecond, obj.millisecond);
   }


  /**
   * Add milliseconds to this millisecond.
   *
   * @param milliseconds Milliseconds to add to this millisecond
   * @return New millisecond after adding the milliseconds to this millisecond
   * @throws ArithmeticException In case of an overflow
   */
  public Millisecond add(final Milliseconds milliseconds)
   {
    final int newMillisecond = Math.toIntExact(Math.addExact(this.millisecond, milliseconds.milliseconds()));
    if (newMillisecond > 999)
     {
      // TODO Listener
      throw new ArithmeticException(Millisecond.OVERFLOW);
     }
    return Millisecond.of(newMillisecond);
   }


  /**
   * Subtract milliseconds from this millisecond.
   *
   * @param milliseconds Milliseconds to subtract from this millisecond
   * @return New millisecond after subtracting milliseconds from this millisecond
   * @throws ArithmeticException In case of an underflow
   */
  public Millisecond subtract(final Milliseconds milliseconds)
   {
    final int newMillisecond = Math.toIntExact(Math.subtractExact(this.millisecond, milliseconds.milliseconds()));
    if (newMillisecond < 0)
     {
      // TODO Listener
      throw new ArithmeticException(Millisecond.UNDERFLOW);
     }
    return Millisecond.of(newMillisecond);
   }


  /**
   * Increment this millisecond.
   *
   * @return New millisecond after incrementing this millisecond
   * @throws ArithmeticException In case of an overflow
   */
  public Millisecond increment()
   {
    final int newMillisecond = Math.incrementExact(this.millisecond);
    if (newMillisecond == 1000)
     {
      // TODO Listener
      throw new ArithmeticException(Millisecond.OVERFLOW);
     }
    return Millisecond.of(newMillisecond);
   }


  /**
   * Decrement this millisecond.
   *
   * @return New millisecond after decrement this millisecond
   * @throws ArithmeticException In case of an overflow
   */
  public Millisecond decrement()
   {
    final int newMillisecond = Math.decrementExact(this.millisecond);
    if (newMillisecond == -1)
     {
      // TODO Listener
      throw new ArithmeticException(Millisecond.UNDERFLOW);
     }
    return Millisecond.of(newMillisecond);
   }

 }
