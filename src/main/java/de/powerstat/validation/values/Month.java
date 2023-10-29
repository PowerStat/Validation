/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Month.
 *
 * Not DSGVO relevant.
 *
 * TODO constructor with year
 * TODO daysWithin() = 31, 30, 29, 28, n (Year specific for february, or october 1582)
 * TODO Listener
 * TODO Translations short/long
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class Month implements Comparable<Month>, IValueObject
 {
  /**
   * Cache for singletons.
   */
  private static final Map<Integer, Month> CACHE = new WeakHashMap<>();

  /**
   * Overflow constant.
   */
  private static final String OVERFLOW = "Overflow"; //$NON-NLS-1$

  /**
   * Underflow constant.
   */
  private static final String UNDERFLOW = "Underflow"; //$NON-NLS-1$

  /**
   * Month.
   */
  private final int month;


  /**
   * Constructor.
   *
   * @param month Month 1-12
   * @throws IndexOutOfBoundsException When the month is less than 1 or greater than 12
   */
  private Month(final int month)
   {
    super();
    if ((month < 1) || (month > 12))
     {
      throw new IndexOutOfBoundsException("Month number out of range (1-12)!"); //$NON-NLS-1$
     }
    this.month = month;
   }


  /**
   * Month factory.
   *
   * @param month Month 1-12
   * @return Month object
   * @throws IndexOutOfBoundsException When the month is less than 1 or greater than 12
   */
  public static Month of(final int month)
   {
    synchronized (Month.class)
     {
      Month obj = Month.CACHE.get(month);
      if (obj != null)
       {
        return obj;
       }
      obj = new Month(month);
      Month.CACHE.put(Integer.valueOf(month), obj);
      return obj;
     }
   }


  /**
   * Month factory.
   *
   * @param value Month 1-12 string
   * @return Month object
   * @throws IndexOutOfBoundsException When the month is less than 1 or greater than 12
   */
  public static Month of(final String value)
   {
    return of(Integer.parseInt(value));
   }


  /**
   * Returns the value of this Month as an int.
   *
   * @return The numeric value represented by this object after conversion to type int.
   */
  public int intValue()
   {
    return this.month;
   }


  /**
   * Returns the value of this Month as an String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(this.month);
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
    return Integer.hashCode(this.month);
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
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof Month))
     {
      return false;
     }
    final Month other = (Month)obj;
    return this.month == other.month;
   }


  /**
   * Returns the string representation of this Month.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Month[month=1]"
   *
   * @return String representation of this Month
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("Month[month=").append(this.month).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Month obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(this.month, obj.month);
   }


  /**
   * Add months to this month.
   *
   * @param months Months to add to this month
   * @return New month after adding the months to this month
   * @throws ArithmeticException In case of an overflow
   */
  public Month add(final Months months)
   {
    final long newMonth = Math.toIntExact(Math.addExact(this.month, months.longValue()));
    if (newMonth > 12) // while (newMonth > 12)
     {
      // TODO Listener
      // newMonth -= 12;
      // incrementYear();
      throw new ArithmeticException(Month.OVERFLOW);
     }
    return Month.of(Math.toIntExact(newMonth));
   }


  /**
   * Subtract months from this month.
   *
   * @param months Months to subtract from this month
   * @return New month after subtracting months from this month
   * @throws ArithmeticException In case of an underflow
   */
  public Month subtract(final Months months)
   {
    final long newMonth = Math.toIntExact(Math.subtractExact(this.month, months.longValue()));
    if (newMonth <= 0) // while (newMonth <= 0)
     {
      // TODO Listener
      // newMonth += 12;
      // decrementYear();
      throw new ArithmeticException(Month.UNDERFLOW);
     }
    return Month.of(Math.toIntExact(newMonth));
   }


  /**
   * Increment this month.
   *
   * @return New month after incrementing this month
   * @throws ArithmeticException In case of an overflow
   */
  public Month increment()
   {
    final int newMonth = Math.incrementExact(this.month);
    if (newMonth == 13)
     {
      // TODO Listener
      // newMonth = 1;
      // incrementYear();
      throw new ArithmeticException(Month.OVERFLOW);
     }
    return Month.of(newMonth);
   }


  /**
   * Decrement this month.
   *
   * @return New month after decrement this month
   * @throws ArithmeticException In case of an overflow
   */
  public Month decrement()
   {
    final int newMonth = Math.decrementExact(this.month);
    if (newMonth == 0)
     {
      // TODO Listener
      // newMonth = 12;
      // decrementYear();
      throw new ArithmeticException(Month.UNDERFLOW);
     }
    return Month.of(newMonth);
   }

 }
