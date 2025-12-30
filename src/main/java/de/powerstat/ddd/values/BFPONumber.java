/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values;


import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Address BFPONumber.
 *
 * @param bFPONumber BFPONumber bFPONumber
 *
 * Not DSGVO relevant.
 */
@ValueObject
public record BFPONumber(int bFPONumber) implements Comparable<BFPONumber>, IValueObject
 {
  /**
   * Constructor.
   *
   * @param bFPONumber BFPONumber bFPONumber
   * @throws IndexOutOfBoundsException When the bFPONumber is out of bounds
   */
  public BFPONumber
   {
    if ((bFPONumber < 1) || (bFPONumber > 2035))
     {
      throw new IndexOutOfBoundsException("BFPONumber illegal value!!"); //$NON-NLS-1$
     }
   }


  /**
   * BFPONumber factory.
   *
   * @param bFPONumber BFPONumber
   * @return BFPONumber object
   */
  public static BFPONumber of(final int bFPONumber)
   {
    return new BFPONumber(bFPONumber);
   }


  /**
   * Factory for string values.
   *
   * @param value String value
   * @return BFPONumber object
   */
  public static BFPONumber of(final String value)
   {
    return of(Integer.parseInt(value));
   }


  /**
   * Returns the value of this BFPONumber as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return Integer.toString(bFPONumber);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final BFPONumber obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(bFPONumber, obj.bFPONumber);
   }

 }

