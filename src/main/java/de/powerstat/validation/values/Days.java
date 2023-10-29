/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Days.
 *
 * Not DSGVO relevant.
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class Days implements Comparable<Days>, IValueObject
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<Long, Days> CACHE = new WeakHashMap<>();

  /**
   * Days.
   */
  private final long days;


  /**
   * Constructor.
   *
   * @param days Days 0-..
   * @throws IndexOutOfBoundsException When the day is less than 0
   */
  private Days(final long days)
   {
    super();
    if (days < 0)
     {
      throw new IndexOutOfBoundsException("Negative days are not allowed"); //$NON-NLS-1$
     }
    this.days = days;
   }


  /**
   * Days factory.
   *
   * @param days Days 0-..
   * @return Days object
   */
  public static Days of(final long days)
   {
    /*
    synchronized (Days.class)
     {
      Days obj = Days.CACHE.get(days);
      if (obj != null)
       {
        return obj;
       }
      obj = new Days(days);
      Days.CACHE.put(Long.valueOf(days), obj);
      return obj;
     }
    */
    return new Days(days);
   }


  /**
   * Days factory.
   *
   * @param value String value
   * @return Days object
   */
  public static Days of(final String value)
   {
    return of(Long.parseLong(value));
   }


  /**
   * Returns the value of this Days as a long.
   *
   * @return The numeric value represented by this object after conversion to type long.
   */
  public long longValue()
   {
    return this.days;
   }


  /**
   * Returns the value of this Days as a String.
   *
   * @return The numeric value represented by this object after conversion to type STring.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(this.days);
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
    return Long.hashCode(this.days);
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
    if (!(obj instanceof Days))
     {
      return false;
     }
    final Days other = (Days)obj;
    return this.days == other.days;
   }


  /**
   * Returns the string representation of this Days.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Days[days=1]"
   *
   * @return String representation of this Days
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("Days[days=").append(this.days).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Days obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.days, obj.days);
   }


  /**
   * Add other days to this days.
   *
   * @param other Other days to add to this days
   * @return New days after adding other days to this days
   * @throws ArithmeticException In case of an overflow
   */
  public Days add(final Days other)
   {
    return Days.of(Math.addExact(this.days, other.days));
   }


  /**
   * Subtract other days from this days.
   *
   * @param other Other days to subtract from this one
   * @return Absolute new days after subtracting other days from this days
   */
  public Days subtract(final Days other)
   {
    if (other.days > this.days)
     {
      return Days.of(other.days - this.days);
     }
    return Days.of(this.days - other.days);
   }


  /**
   * Multiply days with a multiplier.
   *
   * @param multiplier Multiplier to multiply with
   * @return New days that is a multiplication of this days with the multiplier
   * @throws ArithmeticException In case of an overflow
   */
  public Days multiply(final long multiplier)
   {
    return Days.of(Math.multiplyExact(this.days, multiplier));
   }


  /**
   * Divide days by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The largest (closest to positive infinity) long value that is less than or equal to the algebraic quotient.
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Days divide(final long divisor)
   {
    return Days.of(Math.floorDiv(this.days, divisor));
   }


  /**
   * Floor modulo days by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The floor modulus Days - (floorDiv(Days, divisor) * divisor)
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Days modulo(final long divisor)
   {
    return Days.of(Math.floorMod(this.days, divisor));
   }

 }
