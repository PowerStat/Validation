/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Address Postal code.
 *
 * Not DSGVO relevant.
 *
 * https://en.wikipedia.org/wiki/List_of_postal_codes
 * https://de.wikipedia.org/wiki/Liste_der_Postleitsysteme
 *
 * TODO Country specific
 */
public final class PostalCode implements Comparable<PostalCode>
 {
  /**
   * Postal code.
   */
  private final String postalCode;


  /**
   * Constructor.
   *
   * @param postalCode Postal code
   * @throws NullPointerException if postalCode is null
   * @throws IllegalArgumentException if postalCode is not a correct postalCode
   */
  public PostalCode(final String postalCode)
   {
    super();
    Objects.requireNonNull(postalCode, "postalCode"); //$NON-NLS-1$
    if ((postalCode.length() < 3) || (postalCode.length() > 11))
     {
      throw new IllegalArgumentException("postalCode with wrong length"); //$NON-NLS-1$
     }
    if (!postalCode.matches("^[0-9A-Z -]{3,11}$")) //$NON-NLS-1$
     {
      throw new IllegalArgumentException("postalCode with wrong format"); //$NON-NLS-1$
     }
    this.postalCode = postalCode;
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
   * Get PostalCode string.
   *
   * @return PostalCode string
   */
  public String getPostalCode()
   {
    return this.postalCode;
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
    return this.postalCode.hashCode();
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
    if (!(obj instanceof PostalCode))
     {
      return false;
     }
    final PostalCode other = (PostalCode)obj;
    return this.postalCode.equals(other.postalCode);
   }


  /**
   * Returns the string representation of this PostalCode.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "PostalCode[postalCode=28000]"
   *
   * @return String representation of this PostalCode
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("PostalCode[postalCode=").append(this.postalCode).append(']'); //$NON-NLS-1$
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
  public int compareTo(final PostalCode obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.postalCode.compareTo(obj.postalCode);
   }

 }
