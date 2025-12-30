/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values;


import java.util.Objects;
import java.util.regex.Pattern;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Lastname.
 *
 * @param lastname Lastname
 *
 * DSGVO relevant.
 */
@ValueObject
public record Lastname(String lastname) implements Comparable<Lastname>, IValueObject
 {
  /**
   * Lastname regexp.
   */
  private static final Pattern LASTNAME_REGEXP = Pattern.compile("^[\\p{L}][\\p{L} -]*$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param lastname Lastname (maximum 40 characters)
   *
   * @throws NullPointerException if lastname is null
   * @throws IllegalArgumentException if lastname contains unsupported characters or is to long or short
   */
  public Lastname
   {
    Objects.requireNonNull(lastname, "lastname"); //$NON-NLS-1$
    if (lastname.isEmpty() || (lastname.length() > 40))
     {
      throw new IllegalArgumentException("Lastname with wrong length"); //$NON-NLS-1$
     }
    if (!Lastname.LASTNAME_REGEXP.matcher(lastname).matches())
     {
      throw new IllegalArgumentException("Lastname with wrong format"); //$NON-NLS-1$
     }
   }


  /**
   * Lastname factory.
   *
   * @param lastname Lastname
   * @return Lastname object
   */
  public static Lastname of(final String lastname)
   {
    return new Lastname(lastname);
   }


  /**
   * Returns the value of this Lastname as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return lastname;
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Lastname obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return lastname.compareTo(obj.lastname);
   }

 }
