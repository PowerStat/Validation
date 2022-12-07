/*
 * Copyright (C) 2021-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;


/**
 * Milliseconds.
 *
 * Not DSGVO relevant.
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class Milliseconds implements Comparable<Milliseconds>
 {
  /**
   * Cache for singletons.
   */
  private static final Map<Long, Milliseconds> CACHE = new WeakHashMap<>();

  /**
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$

  /**
   * Milliseonds.
   */
  private final long milliseconds;


  /**
   * Constructor.
   *
   * @param milliseconds Milliseconds &gt;= 0
   * @throws IndexOutOfBoundsException When the milliseonds is less than 0
   */
  private Milliseconds(final long milliseconds)
   {
    super();
    if (milliseconds < 0)
     {
      throw new IndexOutOfBoundsException("Milliseconds out of range (0-Long.MAX_VALUE)!"); //$NON-NLS-1$
     }
    this.milliseconds = milliseconds;
   }


  /**
   * Milliseconds factory.
   *
   * @param milliseconds Milliseconds 0-[Long.MAX_VALUE]
   * @return Milliseconds object
   */
  public static Milliseconds of(final long milliseconds)
   {
    synchronized (Milliseconds.class)
     {
      Milliseconds obj = Milliseconds.CACHE.get(milliseconds);
      if (obj != null)
       {
        return obj;
       }
      obj = new Milliseconds(milliseconds);
      Milliseconds.CACHE.put(Long.valueOf(milliseconds), obj);
      return obj;
     }
   }


  /**
   * Get milliseconds.
   *
   * @return Milliseconds (0-Long.MAX_VALUE)
   * @deprecated Use longValue() instead
   */
  @Deprecated(since = Milliseconds.DEPRECATED_SINCE_3_0, forRemoval = false)
  public long getMilliseconds()
   {
    return this.milliseconds;
   }


  /**
   * Returns the value of this Milliseconds as a long.
   *
   * @return The numeric value represented by this object after conversion to type long (0-Long.MAX_VALUE).
   */
  public long longValue()
   {
    return this.milliseconds;
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
    return Long.hashCode(this.milliseconds);
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
    if (!(obj instanceof Milliseconds))
     {
      return false;
     }
    final Milliseconds other = (Milliseconds)obj;
    return false; // this.milliseconds == other.milliseconds;
    */
   }


  /**
   * Returns the string representation of this Milliseconds.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Milliseconds[milliseconds=0]"
   *
   * @return String representation of this Milliseconds
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(27);
    builder.append("Milliseconds[milliseconds=").append(this.milliseconds).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Milliseconds obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.milliseconds, obj.milliseconds);
   }


  /**
   * Add other milliseconds to this milliseconds.
   *
   * @param other Other milliseconds to add to this milliseconds
   * @return New milliseconds after adding other milliseconds to this milliseconds
   * @throws ArithmeticException In case of an overflow
   */
  public Milliseconds add(final Milliseconds other)
   {
    return Milliseconds.of(Math.addExact(this.milliseconds, other.milliseconds));
   }


  /**
   * Subtract other milliseconds from this milliseconds.
   *
   * @param other Other milliseconds to subtract from this one
   * @return Absolute new milliseconds after subtracting other milliseconds from this Milliseconds
   */
  public Milliseconds subtract(final Milliseconds other)
   {
    if (other.milliseconds > this.milliseconds)
     {
      return Milliseconds.of(other.milliseconds - this.milliseconds);
     }
    return Milliseconds.of(this.milliseconds - other.milliseconds);
   }


  /**
   * Multiply milliseconds with a multiplier.
   *
   * @param multiplier Multiplier to multiply with
   * @return New milliseconds that is a multiplication of this milliseconds with the multiplier
   * @throws ArithmeticException In case of an overflow
   */
  public Milliseconds multiply(final long multiplier)
   {
    return Milliseconds.of(Math.multiplyExact(this.milliseconds, multiplier));
   }


  /**
   * Divide milliseconds by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The largest (closest to positive infinity) long value that is less than or equal to the algebraic quotient.
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Milliseconds divide(final long divisor)
   {
    return Milliseconds.of(Math.floorDiv(this.milliseconds, divisor));
   }


  /**
   * Floor modulo milliseconds by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The floor modulus Milliseconds - (floorDiv(Milliseconds, divisor) * divisor)
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Milliseconds modulo(final long divisor)
   {
    return Milliseconds.of(Math.floorMod(this.milliseconds, divisor));
   }

 }
