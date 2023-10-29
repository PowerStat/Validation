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
 * Not DSGVO relevant.
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class City implements Comparable<City>, IValueObject
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<String, City> CACHE = new WeakHashMap<>();

  /**
   * City name regexp.
   */
  private static final Pattern CITY_REGEXP = Pattern.compile("^[\\p{L}][\\p{L} -]*$"); //$NON-NLS-1$

  /**
   * City.
   */
  private final String city;


  /**
   * Constructor.
   *
   * @param city City name
   * @throws NullPointerException if city is null
   * @throws IllegalArgumentException if city is not a correct City name
   */
  private City(final String city)
   {
    super();
    Objects.requireNonNull(city, "city"); //$NON-NLS-1$
    if ((city.length() < 1) || (city.length() > 85))
     {
      throw new IllegalArgumentException("City with wrong length"); //$NON-NLS-1$
     }
    if (!City.CITY_REGEXP.matcher(city).matches())
     {
      throw new IllegalArgumentException("City with wrong format"); //$NON-NLS-1$
     }
    this.city = city;
   }


  /**
   * City factory.
   *
   * @param city City
   * @return City object
   */
  public static City of(final String city)
   {
    /*
    synchronized (City.class)
     {
      City obj = City.CACHE.get(city);
      if (obj != null)
       {
        return obj;
       }
      obj = new City(city);
      City.CACHE.put(city, obj);
      return obj;
     }
    */
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
    return this.city;
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
    return this.city.hashCode();
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
    if (!(obj instanceof City))
     {
      return false;
     }
    final City other = (City)obj;
    return this.city.equals(other.city);
   }


  /**
   * Returns the string representation of this City.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "City[city=Bremen]"
   *
   * @return String representation of this City
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("City[city=").append(this.city).append(']'); //$NON-NLS-1$
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
  public int compareTo(final City obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.city.compareTo(obj.city);
   }

 }
