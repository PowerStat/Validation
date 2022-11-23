/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;


/**
 * Address Street.
 *
 * Not DSGVO relevant.
 *
 * TODO Verify with openstreetmap
 */
public final class Street implements Comparable<Street>
 {
  /**
   * Street regexp.
   */
  private static final Pattern STREET_REGEXP = Pattern.compile("^[\\p{L}][\\p{L}. -]*$"); //$NON-NLS-1$

  /**
   * Street.
   */
  private final String street;


  /**
   * Constructor.
   *
   * @param street Street name
   * @throws NullPointerException if street is null
   * @throws IllegalArgumentException if street is not a correct Street name
   */
  public Street(final String street)
   {
    super();
    Objects.requireNonNull(street, "street"); //$NON-NLS-1$
    if ((street.length() < 1) || (street.length() > 32))
     {
      throw new IllegalArgumentException("Street with wrong length"); //$NON-NLS-1$
     }
    if (!Street.STREET_REGEXP.matcher(street).matches())
     {
      throw new IllegalArgumentException("Street with wrong format"); //$NON-NLS-1$
     }
    this.street = street;
   }


  /**
   * Street factory.
   *
   * @param street Street
   * @return Street object
   */
  public static Street of(final String street)
   {
    return new Street(street);
   }


  /**
   * Get street string.
   *
   * @return Street string
   * @deprecated Use stringValue() instead
   */
  @Deprecated
  public String getStreet()
   {
    return this.street;
   }


  /**
   * Returns the value of this Street as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  public String stringValue()
   {
    return this.street;
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
    return this.street.hashCode();
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
    if (!(obj instanceof Street))
     {
      return false;
     }
    final Street other = (Street)obj;
    return this.street.equals(other.street);
   }


  /**
   * Returns the string representation of this Street.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Street[street=Hemelinger Heerstraße]"
   *
   * @return String representation of this Street
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Street[street=").append(this.street).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Street obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.street.compareTo(obj.street);
   }

 }
