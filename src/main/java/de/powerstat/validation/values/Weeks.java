/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Weeks.
 *
 * Not DSGVO relevant.
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class Weeks implements Comparable<Weeks>, IValueObject
 {
  /**
   * Cache for singletons.
   */
  private static final Map<Long, Weeks> CACHE = new WeakHashMap<>();

  /**
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$

  /**
   * Weeks.
   */
  private final long weeks;


  /**
   * Constructor.
   *
   * @param weeks Weeks 0-..
   * @throws IndexOutOfBoundsException When the week is less than 0
   */
  private Weeks(final long weeks)
   {
    super();
    if (weeks < 0)
     {
      throw new IndexOutOfBoundsException("Negative weeks are not allowed"); //$NON-NLS-1$
     }
    this.weeks = weeks;
   }


  /**
   * Weeks factory.
   *
   * @param weeks Weeks 0-..
   * @return Weeks object
   */
  public static Weeks of(final long weeks)
   {
    synchronized (Weeks.class)
     {
      Weeks obj = Weeks.CACHE.get(weeks);
      if (obj != null)
       {
        return obj;
       }
      obj = new Weeks(weeks);
      Weeks.CACHE.put(Long.valueOf(weeks), obj);
      return obj;
     }
   }


  /**
   * Weeks factory.
   *
   * @param value Weeks 0-.. string
   * @return Weeks object
   */
  public static Weeks of(final String value)
   {
    return of(Long.parseLong(value));
   }


  /**
   * Get weeks.
   *
   * @return Weeks
   * @deprecated Use longValue() instead
   */
  @Deprecated(since = Weeks.DEPRECATED_SINCE_3_0, forRemoval = false)
  public long getWeeks()
   {
    return this.weeks;
   }


  /**
   * Returns the value of this Weeks as an long.
   *
   * @return The numeric value represented by this object after conversion to type long.
   */
  public long longValue()
   {
    return this.weeks;
   }


  /**
   * Returns the value of this Weeks as a String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(this.weeks);
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
    return Long.hashCode(this.weeks);
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
    if (!(obj instanceof Weeks))
     {
      return false;
     }
    final Weeks other = (Weeks)obj;
    return false; // this.weeks == other.weeks;
    */
   }


  /**
   * Returns the string representation of this Weeks.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Weeks[weeks=1]"
   *
   * @return String representation of this Weeks
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Weeks[weeks=").append(this.weeks).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Weeks obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.weeks, obj.weeks);
   }


  /**
   * Add other weeks to this years.
   *
   * @param other Other weeks to add to this weeks
   * @return New weeks after adding other weeks to this weeks
   * @throws ArithmeticException In case of an overflow
   */
  public Weeks add(final Weeks other)
   {
    return Weeks.of(Math.addExact(this.weeks, other.weeks));
   }


  /**
   * Subtract other weeks from this weeks.
   *
   * @param other Other weeks to subtract from this one
   * @return Absolute new weeks after subtracting other weeks from this weeks
   */
  public Weeks subtract(final Weeks other)
   {
    if (other.weeks > this.weeks)
     {
      return Weeks.of(other.weeks - this.weeks);
     }
    return Weeks.of(this.weeks - other.weeks);
   }


  /**
   * Multiply weeks with a multiplier.
   *
   * @param multiplier Multiplier to multiply with
   * @return New weeks that is a multiplication of this weeks with the multiplier
   * @throws ArithmeticException In case of an overflow
   */
  public Weeks multiply(final long multiplier)
   {
    return Weeks.of(Math.multiplyExact(this.weeks, multiplier));
   }


  /**
   * Divide weeks by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The largest (closest to positive infinity) long value that is less than or equal to the algebraic quotient.
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Weeks divide(final long divisor)
   {
    return Weeks.of(Math.floorDiv(this.weeks, divisor));
   }


  /**
   * Floor modulo weeks by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The floor modulus Weeks - (floorDiv(Weeks, divisor) * divisor)
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Weeks modulo(final long divisor)
   {
    return Weeks.of(Math.floorMod(this.weeks, divisor));
   }

 }
