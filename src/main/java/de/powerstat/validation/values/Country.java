/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.generated.GeneratedISO3166A2;
import de.powerstat.validation.interfaces.IValueObject;


/**
 * Country - ISO 3166-1 codes.
 *
 * @param alpha2 Alpha-2 code
 * 
 * Not DSGVO relevant.
 *
 * TODO Translations
 */
public record Country(String alpha2) implements Comparable<Country>, IValueObject
 {
  /**
   * Country regexp.
   */
  @SuppressWarnings("java:S5867")
  private static final Pattern COUNTRY_REGEXP = Pattern.compile("^[A-Z]{2}$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param alpha2 Alpha-2 code
   * @throws NullPointerException if code is null
   * @throws IllegalArgumentException if code is not a known alpha-2 code
   */
  public Country
   {
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
   }


  /**
   * Country factory.
   *
   * @param alpha2 Alpha-2 code
   * @return Country object
   */
  public static Country of(final String alpha2)
   {
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
    return this.alpha2;
   }


  /**
   * Get country name in english language.
   *
   * @return Country name in english language
   */
  public String getEnglishCountryName()
   {
    return GeneratedISO3166A2.getName(this.alpha2);
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
    return this.alpha2.compareTo(obj.alpha2);
   }

 }
