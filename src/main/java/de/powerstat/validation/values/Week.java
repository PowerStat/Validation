/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Week.
 *
 * Not DSGVO relevant.
 *
 * TODO Constructor with year
 * TODO Listener
 * TODO daysWithin = 7
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class Week implements Comparable<Week>, IValueObject
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
  private static final Map<Integer, Week> CACHE = new WeakHashMap<>();

  /**
   * Week.
   */
  private final int week;


  /**
   * Constructor.
   *
   * @param week Week 1-53
   * @throws IndexOutOfBoundsException When the week is less than 1 or greater than 53
   */
  private Week(final int week)
   {
    super();
    if ((week < 1) || (week > 53))
     {
      throw new IndexOutOfBoundsException("Week number out of range (1-53)!"); //$NON-NLS-1$
     }
    this.week = week;
   }


  /**
   * Week factory.
   *
   * @param week Week 1-53
   * @return Week object
   */
  public static Week of(final int week)
   {
    synchronized (Week.class)
     {
      Week obj = Week.CACHE.get(week);
      if (obj != null)
       {
        return obj;
       }
      obj = new Week(week);
      Week.CACHE.put(Integer.valueOf(week), obj);
      return obj;
     }
   }


  /**
   * Week factory.
   *
   * @param value Week 1-53 string
   * @return Week object
   */
  public static Week of(final String value)
   {
    return of(Integer.parseInt(value));
   }


  /**
   * Returns the value of this Week as an int.
   *
   * @return The numeric value represented by this object after conversion to type int.
   */
  public int intValue()
   {
    return this.week;
   }


  /**
   * Returns the value of this Week as an String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(this.week);
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
    return Integer.hashCode(this.week);
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
    if (!(obj instanceof Week))
     {
      return false;
     }
    final Week other = (Week)obj;
    return false; // this.week == other.week;
    */
   }


  /**
   * Returns the string representation of this Week.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Week[week=1]"
   *
   * @return String representation of this Week
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("Week[week=").append(this.week).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Week obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(this.week, obj.week);
   }


  /**
   * Add weeks to this week.
   *
   * @param weeks Weeks to add to this week
   * @return New week after adding the weeks to this week
   * @throws ArithmeticException In case of an overflow
   */
  public Week add(final Weeks weeks)
   {
    final int newWeek = Math.toIntExact(Math.addExact(this.week, weeks.longValue()));
    if (newWeek > 53) // TODO 52 depends on year
     {
      // TODO Listener
      throw new ArithmeticException(Week.OVERFLOW);
     }
    return Week.of(newWeek);
   }


  /**
   * Subtract weeks from this week.
   *
   * @param weeks Weeks to subtract from this week
   * @return New week after subtracting weeks from this week
   * @throws ArithmeticException In case of an underflow
   */
  public Week subtract(final Weeks weeks)
   {
    final int newWeek = Math.toIntExact(Math.subtractExact(this.week, weeks.longValue()));
    if (newWeek <= 0)
     {
      // TODO Listener
      throw new ArithmeticException(Week.UNDERFLOW);
     }
    return Week.of(newWeek);
   }


  /**
   * Increment this week.
   *
   * @return New week after incrementing this week
   * @throws ArithmeticException In case of an overflow
   */
  public Week increment()
   {
    final int newWeek = Math.incrementExact(this.week);
    if (newWeek == 54) // TODO 53 depending on year
     {
      // TODO Listener
      throw new ArithmeticException(Week.OVERFLOW);
     }
    return Week.of(newWeek);
   }


  /**
   * Decrement this week.
   *
   * @return New week after decrement this week
   * @throws ArithmeticException In case of an overflow
   */
  public Week decrement()
   {
    final int newWeek = Math.decrementExact(this.week);
    if (newWeek == 0)
     {
      // TODO Listener
      throw new ArithmeticException(Week.UNDERFLOW);
     }
    return Week.of(newWeek);
   }

 }
