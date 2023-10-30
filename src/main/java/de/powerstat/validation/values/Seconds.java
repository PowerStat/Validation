/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Seconds.
 *
 * Not DSGVO relevant.
 *
 * TODO inMinutes()
 */
public final class Seconds implements Comparable<Seconds>, IValueObject
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<Long, Seconds> CACHE = new WeakHashMap<>();

  /**
   * Seconds.
   */
  private final long seconds;


  /**
   * Constructor.
   *
   * @param seconds Seconds 0-..
   * @throws IndexOutOfBoundsException When the seconds is less than 0
   */
  private Seconds(final long seconds)
   {
    super();
    if (seconds < 0)
     {
      throw new IndexOutOfBoundsException("Negative seconds are not allowed"); //$NON-NLS-1$
     }
    this.seconds = seconds;
   }


  /**
   * Seconds factory.
   *
   * @param seconds Seconds 0-..
   * @return Seconds object
   */
  public static Seconds of(final long seconds)
   {
    /*
    synchronized (Seconds.class)
     {
      Seconds obj = Seconds.CACHE.get(seconds);
      if (obj != null)
       {
        return obj;
       }
      obj = new Seconds(seconds);
      Seconds.CACHE.put(Long.valueOf(seconds), obj);
      return obj;
     }
    */
    return new Seconds(seconds);
   }


  /**
   * Seconds factory.
   *
   * @param value Seconds 0-.. string
   * @return Seconds object
   */
  public static Seconds of(final String value)
   {
    return of(Long.parseLong(value));
   }


  /**
   * Returns the value of this Seconds as a long.
   *
   * @return The numeric value represented by this object after conversion to type long.
   */
  public long longValue()
   {
    return this.seconds;
   }


  /**
   * Returns the value of this Seconds as a String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(this.seconds);
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
    return Long.hashCode(this.seconds);
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
    if (!(obj instanceof Seconds))
     {
      return false;
     }
    final Seconds other = (Seconds)obj;
    return this.seconds == other.seconds;
   }


  /**
   * Returns the string representation of this Seconds.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Seconds[seconds=1]"
   *
   * @return String representation of this Seconds
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(17);
    builder.append("Seconds[seconds=").append(this.seconds).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Seconds obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.seconds, obj.seconds);
   }


  /**
   * Add other seconds to this seconds.
   *
   * @param other Other seconds to add to this seconds
   * @return New seconds after adding other seconds to this seconds
   * @throws ArithmeticException In case of an overflow
   */
  public Seconds add(final Seconds other)
   {
    return Seconds.of(Math.addExact(this.seconds, other.seconds));
   }


  /**
   * Subtract other seconds from this seconds.
   *
   * @param other Other seconds to subtract from this one
   * @return Absolute new seconds after subtracting other seconds from this seconds
   */
  public Seconds subtract(final Seconds other)
   {
    if (other.seconds > this.seconds)
     {
      return Seconds.of(other.seconds - this.seconds);
     }
    return Seconds.of(this.seconds - other.seconds);
   }


  /**
   * Multiply seconds with a multiplier.
   *
   * @param multiplier Multiplier to multiply with
   * @return New seconds that is a multiplication of this seconds with the multiplier
   * @throws ArithmeticException In case of an overflow
   */
  public Seconds multiply(final long multiplier)
   {
    return Seconds.of(Math.multiplyExact(this.seconds, multiplier));
   }


  /**
   * Divide seconds by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The largest (closest to positive infinity) long value that is less than or equal to the algebraic quotient.
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Seconds divide(final long divisor)
   {
    return Seconds.of(Math.floorDiv(this.seconds, divisor));
   }


  /**
   * Floor modulo seconds by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The floor modulus Seconds - (floorDiv(Seconds, divisor) * divisor)
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Seconds modulo(final long divisor)
   {
    return Seconds.of(Math.floorMod(this.seconds, divisor));
   }

 }
