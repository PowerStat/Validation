/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.generated.GeneratedISO4217;


/**
 * Currency ISO 4217 codes.
 *
 * @param code ISO 4217 code
 * 
 * Not DSGVO relevant.
 *
 * TODO Translations
 */
public record Currency(String code) implements Comparable<Currency>
 {
  /**
   * Currency regexp.
   */
  private static final Pattern CURRENCY_REGEXP = Pattern.compile("^[A-Z]{3}$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @throws NullPointerException if code is null
   * @throws IllegalArgumentException if code is not a known 4217 code
   */
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
    return this.code.compareTo(obj.code);
   }

 }
