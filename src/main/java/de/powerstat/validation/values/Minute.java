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
 * TODO Listener
 */
public final class Minute implements Comparable<Minute>, IValueObject
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

  /* *
   * Cache for singletons.
   */
  // private static final Map<Integer, Minute> CACHE = new WeakHashMap<>();

  /**
   * Minute.
   */
  private final int minute;


  /**
   * Constructor.
   *
   * @param minute Minute 0-59
   * @throws IndexOutOfBoundsException When the minute is less than 0 or greater than 59
   */
  private Minute(final int minute)
   {
    super();
    if ((minute < 0) || (minute > 59))
     {
      throw new IndexOutOfBoundsException("Minute number out of range (0-59)!"); //$NON-NLS-1$
     }
    this.minute = minute;
   }


  /**
   * Minute factory.
   *
   * @param minute Minute 0-59
   * @return Minute object
   */
  public static Minute of(final int minute)
   {
    /*
    synchronized (Minute.class)
     {
      Minute obj = Minute.CACHE.get(minute);
      if (obj != null)
       {
        return obj;
       }
      obj = new Minute(minute);
      Minute.CACHE.put(Integer.valueOf(minute), obj);
      return obj;
     }
    */
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
   * Returns the value of this Minute as an int.
   *
   * @return The numeric value represented by this object after conversion to type int.
   */
  public int intValue()
   {
    return minute;
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
   * Calculate hash code.
   *
   * @return Hash
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
   {
    return Integer.hashCode(minute);
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
    if (!(obj instanceof final Minute other))
     {
      return false;
     }
    return (minute == other.minute);
   }


  /**
   * Returns the string representation of this Minute.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Minute[minute=1]"
   *
   * @return String representation of this Minute
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("Minute[minute=").append(minute).append(']'); //$NON-NLS-1$
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
    final int newMinute = Math.toIntExact(Math.addExact(minute, minutes.longValue()));
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
    final int newMinute = Math.toIntExact(Math.subtractExact(minute, minutes.longValue()));
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
