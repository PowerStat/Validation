/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address Province.
 *
 * Not DSGVO relevant.
 */
public final class Province implements Comparable<Province>, IValueObject
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<String, Province> CACHE = new WeakHashMap<>();

  /**
   * Province regexp.
   */
  private static final Pattern PROVINCE_REGEXP = Pattern.compile("^[\\p{L}][\\p{L} -]*$"); //$NON-NLS-1$

  /**
   * Province.
   */
  private final String province;


  /**
   * Constructor.
   *
   * @param province Province name
   * @throws NullPointerException if province is null
   * @throws IllegalArgumentException if province is not a correct province name
   */
  private Province(final String province)
   {
    super();
    Objects.requireNonNull(province, "province"); //$NON-NLS-1$
    if ((province.length() < 1) || (province.length() > 18))
     {
      throw new IllegalArgumentException("Province with wrong length"); //$NON-NLS-1$
     }
    if (!Province.PROVINCE_REGEXP.matcher(province).matches())
     {
      throw new IllegalArgumentException("Province with wrong format"); //$NON-NLS-1$
     }
    this.province = province;
   }


  /**
   * Province factory.
   *
   * @param province Province
   * @return Province object
   */
  public static Province of(final String province)
   {
    /*
    synchronized (Province.class)
     {
      Province obj = Province.CACHE.get(province);
      if (obj != null)
       {
        return obj;
       }
      obj = new Province(province);
      Province.CACHE.put(province, obj);
      return obj;
     }
    */
    return new Province(province);
   }


  /**
   * Returns the value of this Province as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.province;
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
    return this.province.hashCode();
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
    if (!(obj instanceof Province))
     {
      return false;
     }
    final Province other = (Province)obj;
    return this.province.equals(other.province);
   }


  /**
   * Returns the string representation of this Province.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Province[province=]"
   *
   * @return String representation of this Province
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(19);
    builder.append("Province[province=").append(this.province).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Province obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.province.compareTo(obj.province);
   }

 }
