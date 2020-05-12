/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.generated.GeneratedISO6391;


/**
 * Language ISO 639-1.
 *
 * Not DSGVO relevant.
 *
 * TODO Translations
 */
public class Language implements Comparable<Language>
 {
  /**
   * ISO 639-1 language code.
   */
  private final String code;


  /**
   * Constructor.
   *
   * @param code ISO 639-1 code
   * @throws NullPointerException if code is null
   * @throws IllegalArgumentException if code is not a known 639-1 code
   */
  public Language(final String code)
   {
    super();
    Objects.requireNonNull(code, "code"); //$NON-NLS-1$
    if (code.length() != 2)
     {
      throw new IllegalArgumentException("Length is not 2"); //$NON-NLS-1$
     }
    if (!code.matches("^[a-z]{2}$")) //$NON-NLS-1$
     {
      throw new IllegalArgumentException("code contains illegal character"); //$NON-NLS-1$
     }
    if (!GeneratedISO6391.contains(code))
     {
      throw new IllegalArgumentException("Unknown ISO639-1 code: " + code); //$NON-NLS-1$
     }
    this.code = code;
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
   * Get language code string.
   *
   * @return Language code string
   */
  public String getLanguage()
   {
    return this.code;
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
    return this.code.hashCode();
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
    if (!(obj instanceof Language))
     {
      return false;
     }
    final Language other = (Language)obj;
    return this.code.equals(other.code);
   }


  /**
   * Returns the string representation of this Language.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Language[code=de]"
   *
   * @return String representation of this Language
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Language[code=").append(this.code).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Language obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.code.compareTo(obj.code);
   }

 }
