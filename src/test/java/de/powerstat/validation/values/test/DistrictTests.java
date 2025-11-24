/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
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
import nl.jqno.equalsverifier.EqualsVerifier;
import de.powerstat.validation.values.District;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * District tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class DistrictTests
 {
  /**
   * District abc.
   */
  private static final String DISTRICTABC = "abc"; //$NON-NLS-1$

  /**
   * District 9.
   */
  private static final String DISTRICT9 = "9"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * District not as expected.
   */
  private static final String DISTRICT_NOT_AS_EXPECTED = "District not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ DistrictTests()
   {
    super();
   }


  /**
   * Test correct District.
   *
   * @param district District
   */
  @ParameterizedTest
  @ValueSource(strings = {DistrictTests.DISTRICT9, "Abcdefghijklmnopqr"})
  /* default */ void testDistrictCorrect(final String district)
   {
    final District cleanDistrict = District.of(district);
    assertEquals(district, cleanDistrict.stringValue(), DistrictTests.DISTRICT_NOT_AS_EXPECTED);
   }


  /**
   * Test District with wrong lengths.
   *
   * @param district District
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "Abcdefghijklmnopqrs"})
  /* default */ void testDistrictLength(final String district)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final District cleanDistrict = */ District.of(district);
     }, DistrictTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test wrong District.
   *
   * @param district District
   */
  @ParameterizedTest
  @ValueSource(strings = {"abc_def"})
  /* default */ void testDistrictWrong(final String district)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final District cleanDistrict = */ District.of(district);
     }, DistrictTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get district.
   */
  @Test
  /* default */ void testStringValue()
   {
    final District district = District.of(DistrictTests.DISTRICT9);
    assertEquals(DistrictTests.DISTRICT9, district.stringValue(), DistrictTests.DISTRICT_NOT_AS_EXPECTED);
   }


  /**
   * Equalsverifier.
   */
  @Test
  /* default */ void testEqualsContract()
   {
    EqualsVerifier.forClass(District.class).withNonnullFields("district").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final District district = District.of(DistrictTests.DISTRICT9);
    assertEquals("District[district=9]", district.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final District district1 = District.of(DistrictTests.DISTRICT9);
    final District district2 = District.of(DistrictTests.DISTRICT9);
    final District district3 = District.of(DistrictTests.DISTRICTABC);
    final District district4 = District.of("def"); //$NON-NLS-1$
    final District district5 = District.of(DistrictTests.DISTRICT9);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(district1.compareTo(district2) == -district2.compareTo(district1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(district1.compareTo(district3) == -district3.compareTo(district1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((district4.compareTo(district3) > 0) && (district3.compareTo(district1) > 0) && (district4.compareTo(district1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((district1.compareTo(district2) == 0) && (Math.abs(district1.compareTo(district5)) == Math.abs(district2.compareTo(district5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((district1.compareTo(district2) == 0) && district1.equals(district2), "equals") //$NON-NLS-1$
    );
   }

 }
