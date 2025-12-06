/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address Sub building.
 *
 * @param subBuilding Sub building description
 *
 * Possibly DSGVO relevant.
 */
@ValueObject
public record SubBuilding(String subBuilding) implements Comparable<SubBuilding>, IValueObject
 {
  /**
   * Subbuilding regexp.
   */
  private static final Pattern SUBBUILDING_REGEXP = Pattern.compile("^[\\p{L}][\\p{L}\\p{Digit}., -]*$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param subBuilding Sub building description
   * @throws NullPointerException if subBuilding is null
   * @throws IllegalArgumentException if subBuilding is not correct
   */
  public SubBuilding
   {
    Objects.requireNonNull(subBuilding, "subBuilding"); //$NON-NLS-1$
    if (subBuilding.isEmpty() || (subBuilding.length() > 32))
     {
      throw new IllegalArgumentException("SubBuilding with wrong length"); //$NON-NLS-1$
     }
    if (!SubBuilding.SUBBUILDING_REGEXP.matcher(subBuilding).matches())
     {
      throw new IllegalArgumentException("SubBuilding with wrong format"); //$NON-NLS-1$
     }
   }


  /**
   * SubBuilding factory.
   *
   * @param subBuilding Sub building
   * @return SubBuilding object
   */
  public static SubBuilding of(final String subBuilding)
   {
    return new SubBuilding(subBuilding);
   }


  /**
   * Returns the value of this SubBuilding as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return subBuilding;
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final SubBuilding obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return subBuilding.compareTo(obj.subBuilding);
   }

 }
