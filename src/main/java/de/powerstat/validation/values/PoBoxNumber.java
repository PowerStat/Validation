/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address Post office box number.
 *
 * @param poBoxNumber PO box number 1-..
 *
 * DSGVO relevant.
 */
public record PoBoxNumber(long poBoxNumber) implements Comparable<PoBoxNumber>, IValueObject
 {
  /**
   * Constructor.
   *
   * @param poBoxNumber PO box number 1-..
   * @throws IndexOutOfBoundsException When the poBoxNumber is less than 1
   */
  public PoBoxNumber
   {
    if (poBoxNumber < 1)
     {
      throw new IndexOutOfBoundsException("POBoxNumber number out of range (1-..)!"); //$NON-NLS-1$
     }
   }


  /**
   * PoBoxNumber factory.
   *
   * @param poBoxNumber PoBox number 1-..
   * @return PoBoxNumber object
   */
  public static PoBoxNumber of(final long poBoxNumber)
   {
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
