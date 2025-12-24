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

import de.powerstat.validation.values.URISchemeName;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * URISchemaName tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class URISchemeNameTests
 {
  /**
   * Illegal argument exception expected.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * URI scheme name not as expected.
   */
  private static final String URI_SCHEME_NAME_NOT_AS_EXPECTED = "URI scheme name not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ URISchemeNameTests()
   {
    super();
   }


  /**
   * Test URISchemeName with valid scheme names.
   *
   * @param name URI Scheme name
   */
  @ParameterizedTest
  @ValueSource(strings = {"https"})
  /* default */ void testSchemeOk0(final String name)
   {
    final URISchemeName cleanName = URISchemeName.of(name);
    assertEquals(name, cleanName.name(), URISchemeNameTests.URI_SCHEME_NAME_NOT_AS_EXPECTED);
   }


  /**
   * Test URISchemeName with schame names to short or long.
   *
   * @param name URI scheme name
   */
  @ParameterizedTest
  @ValueSource(strings = {"1", "123456789012345678901234567890123456"})
  /* default */ void testNameLength(final String name)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final URISchemeName cleanName = */ URISchemeName.of(name);
     }, URISchemeNameTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test URISChemeName with illegal parameters.
   *
   * @param name URI scheme name
   */
  @ParameterizedTest
  @ValueSource(strings = {"D~"})
  /* default */ void testNameIllegalParameters(final String name)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final URISchemeName cleanName = */ URISchemeName.of(name);
     }, URISchemeNameTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get URI scheme name.
   */
  @Test
  /* default */ void testStringValue()
   {
    final URISchemeName name = URISchemeName.of("https");
    assertEquals("https", name.stringValue(), URISchemeNameTests.URI_SCHEME_NAME_NOT_AS_EXPECTED);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final URISchemeName name1 = URISchemeName.of("https");
    final URISchemeName name2 = URISchemeName.of("https");
    final URISchemeName name3 = URISchemeName.of("smtp");
    final URISchemeName name4 = URISchemeName.of("webcal"); //$NON-NLS-1$
    final URISchemeName name5 = URISchemeName.of("https");
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(name1.compareTo(name2) == -name2.compareTo(name1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(name1.compareTo(name3) == -name3.compareTo(name1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((name4.compareTo(name3) > 0) && (name3.compareTo(name1) > 0) && (name4.compareTo(name1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((name1.compareTo(name2) == 0) && (Math.abs(name1.compareTo(name5)) == Math.abs(name2.compareTo(name5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((name1.compareTo(name2) == 0) && name1.equals(name2), "equals") //$NON-NLS-1$
    );
   }

 }
