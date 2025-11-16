/*
 * Copyright (C) 2021-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Millisecond.
 *
 * Not DSGVO relevant.
 *
 * TODO Listener
 */
public final class Millisecond implements Comparable<Millisecond>, IValueObject
 {
  /**
   * Minimum allowed value 0.
   */
  public static final int MIN_VALUE = 0;

  /**
   * Maximum allowed value 999.
   */
  public static final int MAX_VALUE = 999;

  /* *
   * Cache for singletons.
   */
  // private static final Map<Integer, Millisecond> CACHE = new WeakHashMap<>();

  /**
   * Overflow constant.
   */
  private static final String OVERFLOW = "Overflow"; //$NON-NLS-1$

  /**
   * Underflow constant.
   */
  private static final String UNDERFLOW = "Underflow"; //$NON-NLS-1$

  /**
   * Milliseond.
   */
  private final int millisecond;


  /**
   * Constructor.
   *
   * @param millisecond Millisecond 0-999
   * @throws IndexOutOfBoundsException When the milliseond is less than 0 or greater than 999
   */
  private Millisecond(final int millisecond)
   {
    super();
    if ((millisecond < 0) || (millisecond > 999))
     {
      throw new IndexOutOfBoundsException("Millisecond out of range (0-999)!"); //$NON-NLS-1$
     }
    this.millisecond = millisecond;
   }


  /**
   * Millisecond factory.
   *
   * @param millisecond Millisecond 0-999
   * @return Millisecond object
   */
  public static Millisecond of(final int millisecond)
   {
    /*
    synchronized (Millisecond.class)
     {
      Millisecond obj = Millisecond.CACHE.get(millisecond);
      if (obj != null)
       {
        return obj;
       }
      obj = new Millisecond(millisecond);
      Millisecond.CACHE.put(Integer.valueOf(millisecond), obj);
      return obj;
     }
    */
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
   * Returns the value of this Millisecond as an int.
   *
   * @return The numeric value represented by this object after conversion to type int (0-999).
   */
  public int intValue()
   {
    return millisecond;
   }


  /**
   * Returns the value of this Millisecond as an String.
   *
   * @return The numeric value represented by this object after conversion to type String (0-999).
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(millisecond);
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
    return Integer.hashCode(millisecond);
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
    if (!(obj instanceof final Millisecond other))
     {
      return false;
     }
    return (millisecond == other.millisecond);
   }


  /**
   * Returns the string representation of this Millisecond.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Millisecond[millisecond=0]"
   *
   * @return String representation of this Millisecond
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(25);
    builder.append("Millisecond[millisecond=").append(millisecond).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Millisecond obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(millisecond, obj.millisecond);
   }


  /**
   * Add milliseconds to this millisecond.
   *
   * @param milliseconds Milliseconds to add to this millisecond
   * @return New millisecond after adding the milliseconds to this millisecond
   * @throws ArithmeticException In case of an overflow
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Millisecond add(final Milliseconds milliseconds)
   {
    final int newMillisecond = Math.toIntExact(Math.addExact(millisecond, milliseconds.longValue()));
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
    final int newMillisecond = Math.toIntExact(Math.subtractExact(millisecond, milliseconds.longValue()));
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
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Millisecond increment()
   {
    final int newMillisecond = Math.incrementExact(millisecond);
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
    final int newMillisecond = Math.decrementExact(millisecond);
    if (newMillisecond == -1)
     {
      // TODO Listener
      throw new ArithmeticException(Millisecond.UNDERFLOW);
     }
    return Millisecond.of(newMillisecond);
   }

 }
