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
 * Address City.
 *
 * @param city City name
 *
 * Not DSGVO relevant.
 */
@ValueObject
public record City(String city) implements Comparable<City>, IValueObject
 {
  /**
   * City name regexp.
   */
  private static final Pattern CITY_REGEXP = Pattern.compile("^[\\p{L}][\\p{L} -]*$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param city City name
   * @throws NullPointerException if city is null
   * @throws IllegalArgumentException if city is not a correct City name
   */
  public City
   {
    Objects.requireNonNull(city, "city"); //$NON-NLS-1$
    if (city.isEmpty() || (city.length() > 85))
     {
      throw new IllegalArgumentException("City with wrong length"); //$NON-NLS-1$
     }
    if (!City.CITY_REGEXP.matcher(city).matches())
     {
      throw new IllegalArgumentException("City with wrong format"); //$NON-NLS-1$
     }
   }


  /**
   * City factory.
   *
   * @param city City
   * @return City object
   */
  public static City of(final String city)
   {
    return new City(city);
   }


  /**
   * Returns the value of this City as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return city;
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final City obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return city.compareTo(obj.city);
   }

 }
