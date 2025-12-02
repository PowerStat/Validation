/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.generated.GeneratedISO3166A2;
import de.powerstat.validation.interfaces.IValueObject;


/**
 * Country - ISO 3166-1 codes.
 *
 * Not DSGVO relevant.
 *
 * TODO Translations
 */
@ValueObject
public final class Country implements Comparable<Country>, IValueObject
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<String, Country> CACHE = new WeakHashMap<>();

  /**
   * Country regexp.
   */
  @SuppressWarnings("java:S5867")
  private static final Pattern COUNTRY_REGEXP = Pattern.compile("^[A-Z]{2}$"); //$NON-NLS-1$

  /**
   * Alpha-2 country code.
   */
  private final String alpha2;


  /**
   * Constructor.
   *
   * @param alpha2 Alpha-2 code
   * @throws NullPointerException if code is null
   * @throws IllegalArgumentException if code is not a known alpha-2 code
   */
  @SuppressWarnings({"PMD.AvoidLiteralsInIfCondition"})
  private Country(final String alpha2)
   {
    super();
    Objects.requireNonNull(alpha2, "alpha2"); //$NON-NLS-1$
    if (alpha2.length() != 2)
     {
      throw new IllegalArgumentException("Length is not 2"); //$NON-NLS-1$
     }
    if (!Country.COUNTRY_REGEXP.matcher(alpha2).matches())
     {
      throw new IllegalArgumentException("alpha2 contains illegal character"); //$NON-NLS-1$
     }
    if (!GeneratedISO3166A2.contains(alpha2))
     {
      throw new IllegalArgumentException("Unknown ISO3166 Alpha-2 code: " + alpha2); //$NON-NLS-1$
     }
    this.alpha2 = alpha2;
   }


  /**
   * Country factory.
   *
   * @param alpha2 Alpha-2 code
   * @return Country object
   */
  public static Country of(final String alpha2)
   {
    /*
    synchronized (Country.class)
     {
      Country obj = Country.CACHE.get(alpha2);
      if (obj != null)
       {
        return obj;
       }
      obj = new Country(alpha2);
      Country.CACHE.put(alpha2, obj);
      return obj;
     }
    */
    return new Country(alpha2);
   }


  /**
   * Returns the value of this Country as a ISO 3166-1 string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return alpha2;
   }


  /**
   * Get country name in english language.
   *
   * @return Country name in english language
   */
  public String getEnglishCountryName()
   {
    return GeneratedISO3166A2.getName(alpha2);
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
    return alpha2.hashCode();
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @SuppressWarnings("PMD.SimplifyBooleanReturns")
  @Override
  public boolean equals(final @Nullable Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof final Country other))
     {
      return false;
     }
    return alpha2.equals(other.alpha2);
   }


  /**
   * Returns the string representation of this Country.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Country[alpha=DE]"
   *
   * @return String representation of this Country
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("Country[alpha2=").append(alpha2).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Country obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return alpha2.compareTo(obj.alpha2);
   }

 }
