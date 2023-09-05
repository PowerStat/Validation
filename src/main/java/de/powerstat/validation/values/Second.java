/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Second.
   *
 * Not DSGVO relevant.
 *
   * TODO Constructor with day, month, year, hour, minute
 * TODO Listener  (mod 60 = 0)
 * TODO millisecondsWithin = 1000
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class Second implements Comparable<Second>, IValueObject
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
   * Cache for singletons.
   */
  private static final Map<Integer, Second> CACHE = new WeakHashMap<>();

  /**
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$

  /**
   * Second.
   */
  private final int second;


  /**
   * Constructor.
   *
   * @param second Second 0-59/60
   * @throws IndexOutOfBoundsException When the second is less than 0 or greater than 59/60
   */
  private Second(final int second)
   {
    super();
    if ((second < 0) || (second > 60))
     {
      throw new IndexOutOfBoundsException("Second number out of range (0-59/60)!"); //$NON-NLS-1$
     }
    this.second = second;
   }


  /**
   * Second factory.
   *
   * @param second Second 0-59/60
   * @return Second object
   */
  public static Second of(final int second)
   {
    synchronized (Second.class)
     {
      Second obj = Second.CACHE.get(second);
      if (obj != null)
       {
        return obj;
       }
      obj = new Second(second);
      Second.CACHE.put(Integer.valueOf(second), obj);
      return obj;
     }
   }


  /**
   * Get second.
   *
   * @return Second
   * @deprecated Use intValue() instead
   */
  @Deprecated(since = Second.DEPRECATED_SINCE_3_0, forRemoval = false)
  public int getSecond()
   {
    return this.second;
   }


  /**
   * Returns the value of this Second as an int.
   *
   * @return The numeric value represented by this object after conversion to type int.
   */
  public int intValue()
   {
    return this.second;
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
    return Integer.hashCode(this.second);
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj)
   {
    return this == obj;
    /*
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof Second))
     {
      return false;
     }
    final Second other = (Second)obj;
    return false; // this.second == other.second;
    */
   }


  /**
   * Returns the string representation of this Second.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Second[second=1]"
   *
   * @return String representation of this Second
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Second[second=").append(this.second).append(']'); //$NON-NLS-1$
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
    final int newSecond = Math.toIntExact(Math.addExact(this.second, seconds.longValue()));
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
    final int newSecond = Math.toIntExact(Math.subtractExact(this.second, seconds.longValue()));
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
