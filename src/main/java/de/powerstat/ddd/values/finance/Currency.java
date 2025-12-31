/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.finance;


import java.util.Objects;
import java.util.regex.Pattern;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.generated.GeneratedISO4217;
import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Currency ISO 4217 codes.
 *
 * @param code ISO 4217 code
 *
 * Not DSGVO relevant.
 *
 * TODO Translations
 */
@ValueObject
public record Currency(String code) implements Comparable<Currency>, IValueObject
 {
  /**
   * Currency regexp.
   */
  @SuppressWarnings("java:S5867")
  private static final Pattern CURRENCY_REGEXP = Pattern.compile("^[A-Z]{3}$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param code ISO 4217 code
   * @throws NullPointerException if code is null
   * @throws IllegalArgumentException if code is not a known 4217 code
   */
  @SuppressWarnings({"PMD.AvoidLiteralsInIfCondition"})
  public Currency
   {
    Objects.requireNonNull(code, "code"); //$NON-NLS-1$
    if (code.length() != 3)
     {
      throw new IllegalArgumentException("Length is not 3"); //$NON-NLS-1$
     }
    if (!Currency.CURRENCY_REGEXP.matcher(code).matches())
     {
      throw new IllegalArgumentException("Code contains illegal character"); //$NON-NLS-1$
     }
    if (!GeneratedISO4217.contains(code))
     {
      throw new IllegalArgumentException("Unknown ISO4217 code: " + code); //$NON-NLS-1$
     }
   }


  /**
   * Currency factory.
   *
   * @param code 4217 code
   * @return Currency object
   */
  public static Currency of(final String code)
   {
    return new Currency(code);
   }


  /**
   * Returns the value of this Currency as a ISO 4217 string.
   *
   * @return The text value represented by this object after conversion to type string.
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
  public int compareTo(final Currency obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return code.compareTo(obj.code);
   }

 }
