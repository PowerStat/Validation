/*
 * Copyright (C) 2024 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Percent 0-100.
 *
 * Not DSGVO relevant.
 */
public final class Percent implements Comparable<Percent>, IValueObject
 {
  /**
   * Minimum allowed value 0.
   */
  public static final int MIN_VALUE = 0;

  /**
   * Maximum allowed value 100.
   */
  public static final int MAX_VALUE = 100;

  /**
   * Percent.
   */
  private final int percent;


  /**
   * Constructor.
   *
   * @param percent Percent 0-100
   * @throws IndexOutOfBoundsException When the percent is less than 0 or greater than 100
   */
  private Percent(final int percent)
   {
    super();
    if ((percent < 0) || (percent > 100))
     {
      throw new IndexOutOfBoundsException("Percent number out of range (0-100)!"); //$NON-NLS-1$
     }
    this.percent = percent;
   }


  /**
   * Percent factory.
   *
   * @param percent Percent 0-100
   * @return Percent object
   */
  public static Percent of(final int percent)
   {
    return new Percent(percent);
   }


  /**
   * Percent factory.
   *
   * @param percent Percent 0-100
   * @return Percent object
   */
  public static Percent of(final String percent)
   {
    return of(Integer.parseInt(percent));
   }


  /**
   * Returns the value of this Percent as an int.
   *
   * @return The numeric value represented by this object after conversion to type int.
   */
  public int intValue()
   {
    return percent;
   }


  /**
   * Returns the value of this Percent as an String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(percent);
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
    return Integer.hashCode(percent);
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
    if (!(obj instanceof final Percent other))
     {
      return false;
     }
    return (percent == other.percent);
   }


  /**
   * Returns the string representation of this Percent.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Percent[percent=0]"
   *
   * @return String representation of this Percent
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(17);
    builder.append("Percent[percent=").append(percent).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Percent obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(percent, obj.percent);
   }

 }
