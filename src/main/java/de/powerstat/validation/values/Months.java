/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Months.
 *
 * Not DSGVO relevant.
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class Months implements Comparable<Months>, IValueObject
 {
  /**
   * Cache for singletons.
   */
  private static final Map<Long, Months> CACHE = new WeakHashMap<>();

  /**
   * Month.
   */
  private final long months;


  /**
   * Constructor.
   *
   * @param months Months 0-..
   * @throws IndexOutOfBoundsException When the months is less than 0
   */
  private Months(final long months)
   {
    super();
    if (months < 0)
     {
      throw new IndexOutOfBoundsException("Negative months are not allowed"); //$NON-NLS-1$
     }
    this.months = months;
   }


  /**
   * Months factory.
   *
   * @param months Months 0-..
   * @return Months object
   */
  public static Months of(final long months)
   {
    synchronized (Months.class)
     {
      Months obj = Months.CACHE.get(months);
      if (obj != null)
       {
        return obj;
       }
      obj = new Months(months);
      Months.CACHE.put(Long.valueOf(months), obj);
      return obj;
     }
   }


  /**
   * Months factory.
   *
   * @param value Months 0-.. string
   * @return Months object
   */
  public static Months of(final String value)
   {
    return of(Long.parseLong(value));
   }


  /**
   * Returns the value of this Months as a long.
   *
   * @return The numeric value represented by this object after conversion to type long.
   */
  public long longValue()
   {
    return this.months;
   }


  /**
   * Returns the value of this Months as a String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(this.months);
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
    return Long.hashCode(this.months);
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
    if (!(obj instanceof Months))
     {
      return false;
     }
    final Months other = (Months)obj;
    return this.months == other.months;
   }


  /**
   * Returns the string representation of this Months.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Months[months=1]"
   *
   * @return String representation of this Months
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("Months[months=").append(this.months).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Months obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.months, obj.months);
   }


  /**
   * Add other months to this months.
   *
   * @param other Other months to add to this months
   * @return New months after adding other months to this months
   * @throws ArithmeticException In case of an overflow
   */
  public Months add(final Months other)
   {
    return Months.of(Math.addExact(this.months, other.months));
   }


  /**
   * Subtract other months from this months.
   *
   * @param other Other months to subtract from this one
   * @return Absolute new months after subtracting other months from this months
   */
  public Months subtract(final Months other)
   {
    if (other.months > this.months)
     {
      return Months.of(other.months - this.months);
     }
    return Months.of(this.months - other.months);
   }


  /**
   * Multiply months with a multiplier.
   *
   * @param multiplier Multiplier to multiply with
   * @return New months that is a multiplication of this months with the multiplier
   * @throws ArithmeticException In case of an overflow
   */
  public Months multiply(final long multiplier)
   {
    return Months.of(Math.multiplyExact(this.months, multiplier));
   }


  /**
   * Divide months by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The largest (closest to positive infinity) long value that is less than or equal to the algebraic quotient.
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Months divide(final long divisor)
   {
    return Months.of(Math.floorDiv(this.months, divisor));
   }


  /**
   * Floor modulo months by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The floor modulus Months - (floorDiv(Months, divisor) * divisor)
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Months modulo(final long divisor)
   {
    return Months.of(Math.floorMod(this.months, divisor));
   }

 }
