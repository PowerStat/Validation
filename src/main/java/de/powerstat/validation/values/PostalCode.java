/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;


/**
 * Address Postal code.
 *
 * @param postalCode Postal code
 * 
 * Not DSGVO relevant.
 *
 * https://en.wikipedia.org/wiki/List_of_postal_codes
 * https://de.wikipedia.org/wiki/Liste_der_Postleitsysteme
 *
 * TODO Country specific
 */
public record PostalCode(String postalCode) implements Comparable<PostalCode>
 {
  /**
   * Postal code regexp.
   */
  private static final Pattern POSTALCODE_REGEXP = Pattern.compile("^[0-9A-Z -]{3,11}$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @throws NullPointerException if postalCode is null
   * @throws IllegalArgumentException if postalCode is not a correct postalCode
   */
  public PostalCode
   {
    Objects.requireNonNull(postalCode, "postalCode"); //$NON-NLS-1$
    if ((postalCode.length() < 3) || (postalCode.length() > 11))
     {
      throw new IllegalArgumentException("postalCode with wrong length"); //$NON-NLS-1$
     }
    if (!PostalCode.POSTALCODE_REGEXP.matcher(postalCode).matches())
     {
      throw new IllegalArgumentException("postalCode with wrong format"); //$NON-NLS-1$
     }
   }


  /**
   * PostalCode factory.
   *
   * @param postalCode Postal code
   * @return PostalCode object
   */
  public static PostalCode of(final String postalCode)
   {
    return new PostalCode(postalCode);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final PostalCode obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.postalCode.compareTo(obj.postalCode);
   }

 }
