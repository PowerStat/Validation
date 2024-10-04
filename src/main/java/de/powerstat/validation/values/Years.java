/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Years.
 *
 * Not DSGVO relevant.
 *
 * TODO min, max
 */
public final class Years implements Comparable<Years>, IValueObject
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<Long, Years> CACHE = new WeakHashMap<>();

  /**
   * Years.
   */
  private final long years;


  /**
   * Constructor.
   *
   * @param years Years &gt;= 0
   * @throws IndexOutOfBoundsException When the year is smaller than 0
   */
  private Years(final long years)
   {
    super();
    if (years < 0)
     {
      throw new IndexOutOfBoundsException("Negative years are not allowed"); //$NON-NLS-1$
     }
    this.years = years;
   }


  /**
   * Years factory.
   *
   * @param years Years &gt;= 0
   * @return Years object
   */
  public static Years of(final long years)
   {
    /*
    synchronized (Years.class)
     {
      Years obj = Years.CACHE.get(years);
      if (obj != null)
       {
        return obj;
       }
      obj = new Years(years);
      Years.CACHE.put(Long.valueOf(years), obj);
      return obj;
     }
    */
    return new Years(years);
   }


  /**
   * Years factory.
   *
   * @param value Years &gt;= 0 string
   * @return Years object
   */
  public static Years of(final String value)
   {
    return of(Long.parseLong(value));
   }


  /**
   * Returns the value of this Years as an long.
   *
   * @return The numeric value represented by this object after conversion to type long.
   */
  public long longValue()
   {
    return this.years;
   }


  /**
   * Returns the value of this Years as an String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(this.years);
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
    return Long.hashCode(this.years);
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
    if (!(obj instanceof Years))
     {
      return false;
     }
    final Years other = (Years)obj;
    return this.years == other.years;
   }


  /**
   * Returns the string representation of this Years.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Years[years=20]"
   *
   * @return String representation of this Years
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("Years[years=").append(this.years).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Years obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.years, obj.years);
   }


  /**
   * Add other years to this years.
   *
   * @param other Other years to add to this years
   * @return New years after adding other years to this years
   * @throws ArithmeticException In case of an overflow
   */
  public Years add(final Years other)
   {
    return Years.of(Math.addExact(this.years, other.years));
   }


  /**
   * Subtract other years from this years.
   *
   * @param other Other years to subtract from this one
   * @return Absolute new years after subtracting other years from this years
   */
  public Years subtract(final Years other)
   {
    if (other.years > this.years)
     {
      return Years.of(other.years - this.years);
     }
    return Years.of(this.years - other.years);
   }


  /**
   * Multiply years with a multiplier.
   *
   * @param multiplier Multiplier to multiply with
   * @return New years that is a multiplication of this years with the multiplier
   * @throws ArithmeticException In case of an overflow
   */
  public Years multiply(final long multiplier)
   {
    return Years.of(Math.multiplyExact(this.years, multiplier));
   }


  /**
   * Divide years by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The largest (closest to positive infinity) long value that is less than or equal to the algebraic quotient.
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Years divide(final long divisor)
   {
    return Years.of(Math.floorDiv(this.years, divisor));
   }


  /**
   * Floor modulo years by a divisor.
   *
   * @param divisor Divisor to divide by
   * @return The floor modulus Years - (floorDiv(Years, divisor) * divisor)
   * @throws ArithmeticException In case the divisor is 0.
   */
  public Years modulo(final long divisor)
   {
    return Years.of(Math.floorMod(this.years, divisor));
   }

 }
