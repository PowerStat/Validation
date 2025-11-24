/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address District.
 *
 * Not DSGVO relevant.
 */
public final class District implements Comparable<District>, IValueObject
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<String, District> CACHE = new WeakHashMap<>();

  /**
   * District egexp.
   */
  private static final Pattern DISTRICT_REGEXP = Pattern.compile("^[\\p{L}\\p{Digit}][\\p{L}\\p{Digit} -]*$"); //$NON-NLS-1$

  /**
   * District.
   */
  private final String district;


  /**
   * Constructor.
   *
   * @param district District name
   * @throws NullPointerException if district is null
   * @throws IllegalArgumentException if district is not a correct district name
   */
  private District(final String district)
   {
    super();
    Objects.requireNonNull(district, "district"); //$NON-NLS-1$
    if (district.isEmpty() || (district.length() > 18))
     {
      throw new IllegalArgumentException("District with wrong length"); //$NON-NLS-1$
     }
    if (!District.DISTRICT_REGEXP.matcher(district).matches())
     {
      throw new IllegalArgumentException("District with wrong format"); //$NON-NLS-1$
     }
    this.district = district;
   }


  /**
   * District factory.
   *
   * @param district District
   * @return District object
   */
  public static District of(final String district)
   {
    /*
    synchronized (District .class)
     {
      District obj = District.CACHE.get(district);
      if (obj != null)
       {
        return obj;
       }
      obj = new District(district);
      District .CACHE.put(district, obj);
      return obj;
     }
    */
    return new District(district);
   }


  /**
   * Returns the value of this District as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return district;
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
    return district.hashCode();
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
    if (!(obj instanceof final District other))
     {
      return false;
     }
    return district.equals(other.district);
   }


  /**
   * Returns the string representation of this District.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "District[district=9]"
   *
   * @return String representation of this District
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(19);
    builder.append("District[district=").append(district).append(']'); //$NON-NLS-1$
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
  public int compareTo(final District obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return district.compareTo(obj.district);
   }

 }
