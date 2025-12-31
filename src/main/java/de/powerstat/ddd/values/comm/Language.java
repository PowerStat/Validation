/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.comm;


import java.util.Objects;
import java.util.regex.Pattern;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.generated.GeneratedISO6391;
import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Language ISO 639-1.
 *
 * @param code ISO 639-1 code
 *
 * Not DSGVO relevant.
 *
 * TODO Languages names in english
 * TODO Translations
 */
@ValueObject
public record Language(String code) implements Comparable<Language>, IValueObject
 {
  /**
   * Language regexp.
   */
  @SuppressWarnings("java:S5867")
  private static final Pattern LANGUAGE_REGEXP = Pattern.compile("^[a-z]{2}$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param code ISO 639-1 code
   * @throws NullPointerException if code is null
   * @throws IllegalArgumentException if code is not a known 639-1 code
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public Language
   {
    Objects.requireNonNull(code, "code"); //$NON-NLS-1$
    if (code.length() != 2)
     {
      throw new IllegalArgumentException("Length is not 2"); //$NON-NLS-1$
     }
    if (!Language.LANGUAGE_REGEXP.matcher(code).matches())
     {
      throw new IllegalArgumentException("code contains illegal character"); //$NON-NLS-1$
     }
    if (!GeneratedISO6391.contains(code))
     {
      throw new IllegalArgumentException("Unknown ISO639-1 code: " + code); //$NON-NLS-1$
     }
   }


  /**
   * Language factory.
   *
   * @param code 639-1 code
   * @return Language object
   */
  public static Language of(final String code)
   {
    return new Language(code);
   }


  /**
   * Returns the value of this Language as a string.
   *
   * @return The text value represented by this object after conversion to type string (ISO 639-1).
   */
  @Override
  public String stringValue()
   {
    return code;
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Language obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return code.compareTo(obj.code);
   }

 }
