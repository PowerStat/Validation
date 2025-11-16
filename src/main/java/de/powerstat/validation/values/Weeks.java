/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Weeks.
 *
 * Not DSGVO relevant.
 */
public final class Weeks implements Comparable<Weeks>, IValueObject
 {
  /**
   * Minimum allowed value 0.
   */
  public static final long MIN_VALUE = 0;

  /**
   * Maximum allowed value Long.MAX_VALUE.
   */
  public static final long MAX_VALUE = Long.MAX_VALUE;

  /* *
   * Cache for singletons.
   */
  // private static final Map<Long, Weeks> CACHE = new WeakHashMap<>();

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
    /*
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
    */
    return new Weeks(weeks);
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
   * Returns the value of this Weeks as an long.
   *
   * @return The numeric value represented by this object after conversion to type long.
   */
  public long longValue()
   {
    return weeks;
   }


  /**
   * Returns the value of this Weeks as a String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(weeks);
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
    return Long.hashCode(weeks);
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
    if (!(obj instanceof final Weeks other))
     {
      return false;
     }
    return (weeks == other.weeks);
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
    final var builder = new StringBuilder();
    builder.append("Weeks[weeks=").append(weeks).append(']'); //$NON-NLS-1$
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
    return Long.compare(weeks, obj.weeks);
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
    return Weeks.of(Math.addExact(weeks, other.weeks));
   }


  /**
   * Subtract other weeks from this weeks.
   *
   * @param other Other weeks to subtract from this one
   * @return Absolute new weeks after subtracting other weeks from this weeks
   */
  public Weeks subtract(final Weeks other)
   {
    if (other.weeks > weeks) // NO PITEST
     {
      return Weeks.of(other.weeks - weeks);
     }
    return Weeks.of(weeks - other.weeks);
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
    return Weeks.of(Math.multiplyExact(weeks, multiplier));
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
    return Weeks.of(Math.floorDiv(weeks, divisor));
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
    return Weeks.of(Math.floorMod(weeks, divisor));
   }

 }
