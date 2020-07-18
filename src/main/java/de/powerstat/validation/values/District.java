/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Address District.
 *
 * Not DSGVO relevant.
 */
public final class District implements Comparable<District>
 {
  /**
   * District.
   */
  private final String district;


  /**
   * Constructor.
   *
   * @param district District name
   * @throws NullPointerException if district is null
   * @throws IllegalArgumentException if district is not a correct district name
   */
  public District(final String district)
   {
    super();
    Objects.requireNonNull(district, "district"); //$NON-NLS-1$
    if ((district.length() < 1) || (district.length() > 18))
     {
      throw new IllegalArgumentException("District with wrong length"); //$NON-NLS-1$
     }
    if (!district.matches("^[\\p{L}\\p{Digit}][\\p{L}\\p{Digit} -]*$")) //$NON-NLS-1$
     {
      throw new IllegalArgumentException("District with wrong format"); //$NON-NLS-1$
     }
    this.district = district;
   }


  /**
   * District factory.
   *
   * @param district District
   * @return District object
   */
  public static District of(final String district)
   {
    return new District(district);
   }


  /**
   * Get district string.
   *
   * @return District string
   */
  public String getDistrict()
   {
    return this.district;
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
    return this.district.hashCode();
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
    if (!(obj instanceof District))
     {
      return false;
     }
    final District other = (District)obj;
    return this.district.equals(other.district);
   }


  /**
   * Returns the string representation of this District.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "District[district=9]"
   *
   * @return String representation of this District
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("District[district=").append(this.district).append(']'); //$NON-NLS-1$
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
  public int compareTo(final District obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.district.compareTo(obj.district);
   }

 }
