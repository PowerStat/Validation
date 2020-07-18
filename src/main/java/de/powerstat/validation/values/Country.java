/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.generated.GeneratedISO3166A2;


/**
 * Country - ISO 3166-1 codes.
 *
 * Not DSGVO relevant.
 *
 * TODO Translations
 */
public final class Country implements Comparable<Country>
 {
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
  public Country(final String alpha2)
   {
    super();
    Objects.requireNonNull(alpha2, "alpha2"); //$NON-NLS-1$
    if (alpha2.length() != 2)
     {
      throw new IllegalArgumentException("Length is not 2"); //$NON-NLS-1$
     }
    if (!alpha2.matches("^[A-Z]{2}$")) //$NON-NLS-1$
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
    return new Country(alpha2);
   }


  /**
   * Get country code string.
   *
   * @return Country code string
   */
  public String getCountry()
   {
    return this.alpha2;
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
    return this.alpha2.hashCode();
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
    if (!(obj instanceof Country))
     {
      return false;
     }
    final Country other = (Country)obj;
    return this.alpha2.equals(other.alpha2);
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
    final StringBuilder builder = new StringBuilder();
    builder.append("Country[alpha2=").append(this.alpha2).append(']'); //$NON-NLS-1$
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
    return this.alpha2.compareTo(obj.alpha2);
   }

 }
