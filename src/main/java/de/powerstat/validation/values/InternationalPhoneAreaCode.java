/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.generated.GeneratedInternationalPhoneAreaCodes;
import de.powerstat.validation.interfaces.IValueObject;


/**
 * InternationalPhoneAreaCode.
 *
 * @param code International phone area code
 *
 * Not DSGVO relevant.
 *
 * TODO Related countries
 */
@ValueObject
public record InternationalPhoneAreaCode(String code) implements Comparable<InternationalPhoneAreaCode>, IValueObject
 {
  /**
   * Phone area code regexp.
   */
  @SuppressWarnings("java:S5867")
  private static final Pattern PHONE_AREA_CODE_REGEXP = Pattern.compile("^[0-9-]{1,5}$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param code International phone area code
   * @throws NullPointerException if code is null
   * @throws IllegalArgumentException if code is not a known international phone area code
   */
  @SuppressWarnings({"PMD.AvoidLiteralsInIfCondition"})
  public InternationalPhoneAreaCode
   {
    Objects.requireNonNull(code, "code"); //$NON-NLS-1$
    if ((code.length() < 1) || (code.length() > 5))
     {
      throw new IllegalArgumentException("Length is between 1 and 5"); //$NON-NLS-1$
     }
    if (!InternationalPhoneAreaCode.PHONE_AREA_CODE_REGEXP.matcher(code).matches())
     {
      throw new IllegalArgumentException("code contains illegal character"); //$NON-NLS-1$
     }
    if (!GeneratedInternationalPhoneAreaCodes.contains(code))
     {
      throw new IllegalArgumentException("Unknown international phone area code: " + code); //$NON-NLS-1$
     }
   }


  /**
   * InternationalPhoneAreaCode factory.
   *
   * @param code International phone area code
   * @return InternationalPhoneAreaCode object
   */
  public static InternationalPhoneAreaCode of(final String code)
   {
    return new InternationalPhoneAreaCode(code);
   }


  /**
   * Returns the value of this InternationalPhoneAreaCode as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return code;
   }


  /**
   * Get country name in english language.
   *
   * @return Country name in english language
   */
  public String getEnglishCountryName()
   {
    return GeneratedInternationalPhoneAreaCodes.getName(code);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final InternationalPhoneAreaCode obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return code.compareTo(obj.code);
   }

 }
