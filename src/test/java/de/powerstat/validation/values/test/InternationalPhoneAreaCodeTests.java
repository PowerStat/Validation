/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.validation.values.InternationalPhoneAreaCode;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * InternationalPhoneAreaCode tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class InternationalPhoneAreaCodeTests
 {
  /**
   * Illegal argument exception expected.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Area code not as expected.
   */
  private static final String CODE_NOT_AS_EXPECTED = "International phone area code not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ InternationalPhoneAreaCodeTests()
   {
    super();
   }


  /**
   * Test InternationalPhoneAreaCode with valid codes.
   *
   * @param code International phone area code
   */
  @ParameterizedTest
  @ValueSource(strings = {"49"})
  /* default */ void testCodeOk0(final String code)
   {
    final InternationalPhoneAreaCode cleanCountry = InternationalPhoneAreaCode.of(code);
    assertEquals(code, cleanCountry.code(), InternationalPhoneAreaCodeTests.CODE_NOT_AS_EXPECTED);
   }


  /**
   * Test InternationalPhoneAreaCode with codes to short or long.
   *
   * @param code International phone area code
   */
  @ParameterizedTest
  @ValueSource(strings = {"D", "DEA"})
  /* default */ void testCountryLength(final String code)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final InternationalPhoneAreaCode cleanCode = */ InternationalPhoneAreaCode.of(code);
     }, InternationalPhoneAreaCodeTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test InternationalPhoneAreaCode with illegal parameters.
   *
   * @param code International phone area code
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "123456"})
  /* default */ void testCountryIllegalParameters(final String code)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Country cleanCountry = */ InternationalPhoneAreaCode.of(code);
     }, InternationalPhoneAreaCodeTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get code.
   */
  @Test
  /* default */ void testStringValue()
   {
    final InternationalPhoneAreaCode code = InternationalPhoneAreaCode.of("49");
    assertEquals("49", code.stringValue(), InternationalPhoneAreaCodeTests.CODE_NOT_AS_EXPECTED);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final InternationalPhoneAreaCode code1 = InternationalPhoneAreaCode.of("49");
    final InternationalPhoneAreaCode code2 = InternationalPhoneAreaCode.of("49");
    final InternationalPhoneAreaCode code3 = InternationalPhoneAreaCode.of("55");
    final InternationalPhoneAreaCode code4 = InternationalPhoneAreaCode.of("66"); //$NON-NLS-1$
    final InternationalPhoneAreaCode code5 = InternationalPhoneAreaCode.of("49");
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(code1.compareTo(code2) == -code2.compareTo(code1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(code1.compareTo(code3) == -code3.compareTo(code1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((code4.compareTo(code3) > 0) && (code3.compareTo(code1) > 0) && (code4.compareTo(code1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((code1.compareTo(code2) == 0) && (Math.abs(code1.compareTo(code5)) == Math.abs(code2.compareTo(code5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((code1.compareTo(code2) == 0) && code1.equals(code2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test getName.
   */
  @Test
  /* default */ void testGetName()
   {
    final InternationalPhoneAreaCode code = InternationalPhoneAreaCode.of("49");
    final String name = code.getEnglishCountryName();
    assertEquals("", name, "getEnglishCountryName not as expected"); //$NON-NLS-1$ //$NON-NLS-2$
   }

 }
