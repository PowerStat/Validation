/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address City.
 *
 * @param city City name
 * 
 * Not DSGVO relevant.
 */
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
    if ((city.length() < 1) || (city.length() > 85))
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
    return this.city.compareTo(obj.city);
   }

 }
