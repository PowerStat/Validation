/*
 * Copyright (C) 2024-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values;


import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Percent 0-100.
 *
 * @param percent Percent 0-100
 *
 * Not DSGVO relevant.
 */
@ValueObject
public record Percent(int percent) implements Comparable<Percent>, IValueObject
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
   * Constructor.
   *
   * @param percent Percent 0-100
   * @throws IndexOutOfBoundsException When the percent is less than 0 or greater than 100
   */
  public Percent
   {
    if ((percent < 0) || (percent > 100))
     {
      throw new IndexOutOfBoundsException("Percent number out of range (0-100)!"); //$NON-NLS-1$
     }
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
