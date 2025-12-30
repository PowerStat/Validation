/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values;


import java.util.Objects;
import java.util.regex.Pattern;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.generated.GeneratedURISchemeNames;
import de.powerstat.ddd.interfaces.IValueObject;


/**
 * URI scheme names.
 *
 * @param name URI scheme name
 *
 * Not DSGVO relevant.
 */
@ValueObject
public record URISchemeName(String name) implements Comparable<URISchemeName>, IValueObject
 {
  /**
   * URI scheme name regexp.
   */
  @SuppressWarnings("java:S5867")
  private static final Pattern SCHEME_REGEXP = Pattern.compile("^[a-zA-Z0-9+-]{2,35}$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param name URI scheme name
   * @throws NullPointerException if name is null
   * @throws IllegalArgumentException if name is not a known URI scheme name
   */
  @SuppressWarnings({"PMD.AvoidLiteralsInIfCondition"})
  public URISchemeName
   {
    Objects.requireNonNull(name, "name"); //$NON-NLS-1$
    if ((name.length() < 2) || (name.length() > 35))
     {
      throw new IllegalArgumentException("Length is not between 2 and 35"); //$NON-NLS-1$
     }
    if (!URISchemeName.SCHEME_REGEXP.matcher(name).matches())
     {
      throw new IllegalArgumentException("name contains illegal character"); //$NON-NLS-1$
     }
    if (!GeneratedURISchemeNames.contains(name))
     {
      throw new IllegalArgumentException("Unknown URI scheme name: " + name); //$NON-NLS-1$
     }
   }


  /**
   * URISchemeName factory.
   *
   * @param name URI scheme name
   * @return URISchemeName object
   */
  public static URISchemeName of(final String name)
   {
    return new URISchemeName(name);
   }


  /**
   * Returns the value of this URISchemeName as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return name;
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final URISchemeName obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return name.compareTo(obj.name);
   }

 }
