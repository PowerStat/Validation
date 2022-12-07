/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;


/**
 * Hour.
 *
 * Not DSGVO relevant.
 *
 * TODO Listener
 * TODO minutesWithin = 60
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class Hour implements Comparable<Hour>
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
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$

  /**
   * Cache for singletons.
   */
  private static final Map<Integer, Hour> CACHE = new WeakHashMap<>();

  /**
   * Hour.
   */
  private final int hour;


  /**
   * Constructor.
   *
   * @param hour Hour 0-23
   * @throws IndexOutOfBoundsException When the hour is less than 0 or greater than 23
   */
  private Hour(final int hour)
   {
    super();
    if ((hour < 0) || (hour > 23))
     {
      throw new IndexOutOfBoundsException("Hour number out of range (0-23)!"); //$NON-NLS-1$
     }
    this.hour = hour;
   }


  /**
   * Hour factory.
   *
   * @param hour Hour 0-23
   * @return Hour object
   */
  public static Hour of(final int hour)
   {
    synchronized (Hour.class)
    {
     Hour obj = Hour.CACHE.get(hour);
     if (obj != null)
      {
       return obj;
      }
     obj = new Hour(hour);
     Hour.CACHE.put(Integer.valueOf(hour), obj);
     return obj;
    }
   }


  /**
   * Get hour.
   *
   * @return Hour
   * @deprecated Use intValue() instead
   */
  @Deprecated(since = Hour.DEPRECATED_SINCE_3_0, forRemoval = false)
  public int getHour()
   {
    return this.hour;
   }


  /**
   * Returns the value of this Hour as an int.
   *
   * @return The numeric value represented by this object after conversion to type int.
   */
  public int intValue()
   {
    return this.hour;
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
    return Integer.hashCode(this.hour);
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
    if (!(obj instanceof Hour))
     {
      return false;
     }
    final Hour other = (Hour)obj;
    return false; // this.hour == other.hour;
    */
   }


  /**
   * Returns the string representation of this Hour.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Hour[hour=1]"
   *
   * @return String representation of this Hour
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Hour[hour=").append(this.hour).append(']'); //$NON-NLS-1$
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
    final int newHour = Math.toIntExact(Math.addExact(this.hour, hours.longValue()));
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
    final int newHour = Math.toIntExact(Math.subtractExact(this.hour, hours.longValue()));
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
