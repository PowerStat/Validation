/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address Post office box number.
 *
 * DSGVO relevant.
 */
@ValueObject
public final class PoBoxNumber implements Comparable<PoBoxNumber>, IValueObject
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<Long, PoBoxNumber> CACHE = new WeakHashMap<>();

  /**
   * Post office box number.
   */
  private final long poBoxNumber;


  /**
   * Constructor.
   *
   * @param poBoxNumber PO box number 1-..
   * @throws IndexOutOfBoundsException When the poBoxNumber is less than 1
   */
  private PoBoxNumber(final long poBoxNumber)
   {
    super();
    if (poBoxNumber < 1)
     {
      throw new IndexOutOfBoundsException("POBoxNumber number out of range (1-..)!"); //$NON-NLS-1$
     }
    this.poBoxNumber = poBoxNumber;
   }


  /**
   * PoBoxNumber factory.
   *
   * @param poBoxNumber PoBox number 1-..
   * @return PoBoxNumber object
   */
  public static PoBoxNumber of(final long poBoxNumber)
   {
    /*
    synchronized (PoBoxNumber.class)
     {
      PoBoxNumber obj = PoBoxNumber.CACHE.get(poBoxNumber);
      if (obj != null)
       {
        return obj;
       }
      obj = new PoBoxNumber(poBoxNumber);
      PoBoxNumber.CACHE.put(Long.valueOf(poBoxNumber), obj);
      return obj;
     }
    */
    return new PoBoxNumber(poBoxNumber);
   }


  /**
   * PoBoxNumber factory.
   *
   * @param value PoBox number 1-.. string
   * @return PoBoxNumber object
   */
  public static PoBoxNumber of(final String value)
   {
    return of(Long.parseLong(value));
   }


  /**
   * Returns the value of this BFPONumber as a long.
   *
   * @return The numeric value represented by this object after conversion to type long.
   */
  public long longValue()
   {
    return poBoxNumber;
   }


  /**
   * Returns the value of this PoBoNumber as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return Long.toString(poBoxNumber);
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
    return Long.hashCode(poBoxNumber);
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final @Nullable Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof final PoBoxNumber other))
     {
      return false;
     }
    return poBoxNumber == other.poBoxNumber;
   }


  /**
   * Returns the string representation of this PoBoxNumber.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "PoBoxNumber[poBoxNumber=4711]"
   *
   * @return String representation of this PoBoxNumber
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(25);
    builder.append("PoBoxNumber[poBoxNumber=").append(poBoxNumber).append(']'); //$NON-NLS-1$
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
  public int compareTo(final PoBoxNumber obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(poBoxNumber, obj.poBoxNumber);
   }

 }
