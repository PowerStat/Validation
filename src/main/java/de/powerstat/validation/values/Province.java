/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address Province.
 *
 * @param province Province name
 *
 * Not DSGVO relevant.
 */
@ValueObject
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
    if (province.isEmpty() || (province.length() > 18))
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
   * Returns the value of this Province as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return province;
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
    return province.compareTo(obj.province);
   }

 }
