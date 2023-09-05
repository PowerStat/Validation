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
 * @param province Province name
 *
 * Not DSGVO relevant.
 */
public record Province(String province) implements Comparable<Province>, IValueObject
 {
  /**
   * Province regexp.
   */
  private static final Pattern PROVINCE_REGEXP = Pattern.compile("^[\\p{L}][\\p{L} -]*$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param province Province name
   * @throws NullPointerException if province is null
   * @throws IllegalArgumentException if province is not a correct province name
   */
  public Province
   {
    Objects.requireNonNull(province, "province"); //$NON-NLS-1$
    if ((province.length() < 1) || (province.length() > 18))
     {
      throw new IllegalArgumentException("Province with wrong length"); //$NON-NLS-1$
     }
    if (!Province.PROVINCE_REGEXP.matcher(province).matches())
     {
      throw new IllegalArgumentException("Province with wrong format"); //$NON-NLS-1$
     }
   }


  /**
   * Province factory.
   *
   * @param province Province
   * @return Province object
   */
  public static Province of(final String province)
   {
    return new Province(province);
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
