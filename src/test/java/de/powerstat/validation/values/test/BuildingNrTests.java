/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import de.powerstat.validation.values.BuildingNr;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Building number tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "CE_CLASS_ENVY"})
final class BuildingNrTests
 {
  /**
   * Test compare to.
   */
  private static final String TEST_COMPARE_TO = "testCompareTo"; //$NON-NLS-1$

  /**
   * Building nr 23.
   */
  private static final String BUILDINGNR23 = "23"; //$NON-NLS-1$

  /**
   * Building nr 23 1/4.
   */
  private static final String BUILDINGNR23_1_4 = "23 1/4"; //$NON-NLS-1$

  /**
   * Building nr 42.
   */
  private static final String BUILDINGNR42 = "42"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * BuildingNr not as expected.
   */
  private static final String BUILDING_NR_NOT_AS_EXPECTED = "BuildingNr not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ BuildingNrTests()
   {
    super();
   }


  /**
   * Test correct BuildingNr.
   *
   * @param buildingNr BuildingNr
   */
  @ParameterizedTest
  @ValueSource(strings = {"9", BuildingNrTests.BUILDINGNR42, "42-44", "42/44", "42 a", "42 1/3", "42 1/3 a", "29998-29999 998/999 a", "29999", "42 4/4"})
  /* default */ void testBuildingNrCorrect(final String buildingNr)
   {
    final BuildingNr cleanBuildingNr = BuildingNr.of(buildingNr);
    assertEquals(buildingNr, cleanBuildingNr.buildingNr(), BuildingNrTests.BUILDING_NR_NOT_AS_EXPECTED);
   }


  /**
   * Test BuildingNr with wrong lengths.
   *
   * @param buildingNr Building number
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "1234567890123456789012"})
  /* default */ void testBuildingNrLength(final String buildingNr)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final BuildingNr cleanBuildingNr = */ BuildingNr.of(buildingNr);
     }, BuildingNrTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test wrong BuildingNr.
   *
   * @param buildingNr Building number
   */
  @ParameterizedTest
  @ValueSource(strings = {"4a2", "30000", "43-42", "42-42", "42 5/4"})
  /* default */ void testBuidlingNrWrong(final String buildingNr)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final BuildingNr cleanBuildingNr = */ BuildingNr.of(buildingNr);
     }, BuildingNrTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get buildingNr.
   */
  @Test
  /* default */ void testStringValue()
   {
    final BuildingNr buildingNr = BuildingNr.of(BuildingNrTests.BUILDINGNR42);
    assertEquals(BuildingNrTests.BUILDINGNR42, buildingNr.stringValue(), BuildingNrTests.BUILDING_NR_NOT_AS_EXPECTED);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final BuildingNr buildingNr1 = BuildingNr.of(BuildingNrTests.BUILDINGNR23);
    final BuildingNr buildingNr2 = BuildingNr.of(BuildingNrTests.BUILDINGNR23);
    final BuildingNr buildingNr3 = BuildingNr.of(BuildingNrTests.BUILDINGNR42);
    final BuildingNr buildingNr4 = BuildingNr.of("99"); //$NON-NLS-1$
    final BuildingNr buildingNr5 = BuildingNr.of(BuildingNrTests.BUILDINGNR23);
    assertAll(BuildingNrTests.TEST_COMPARE_TO,
      () -> assertTrue(buildingNr1.compareTo(buildingNr2) == -buildingNr2.compareTo(buildingNr1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(buildingNr1.compareTo(buildingNr3) == -buildingNr3.compareTo(buildingNr1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((buildingNr4.compareTo(buildingNr3) > 0) && (buildingNr3.compareTo(buildingNr1) > 0) && (buildingNr4.compareTo(buildingNr1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((buildingNr1.compareTo(buildingNr2) == 0) && (Math.abs(buildingNr1.compareTo(buildingNr5)) == Math.abs(buildingNr2.compareTo(buildingNr5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((buildingNr1.compareTo(buildingNr2) == 0) && buildingNr1.equals(buildingNr2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test compareTo ok.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareToOk()
   {
    final BuildingNr buildingNr1 = BuildingNr.of(BuildingNrTests.BUILDINGNR23);
    final BuildingNr buildingNr2 = BuildingNr.of(BuildingNrTests.BUILDINGNR23);
    final BuildingNr buildingNr3 = BuildingNr.of(BuildingNrTests.BUILDINGNR23_1_4);
    final BuildingNr buildingNr4 = BuildingNr.of(BuildingNrTests.BUILDINGNR23_1_4);
    final BuildingNr buildingNr5 = BuildingNr.of("23 2/4"); //$NON-NLS-1$
    final BuildingNr buildingNr6 = BuildingNr.of("23 a"); //$NON-NLS-1$
    final BuildingNr buildingNr7 = BuildingNr.of("23 b"); //$NON-NLS-1$
    final BuildingNr buildingNr8 = BuildingNr.of("23 1/4 a"); //$NON-NLS-1$
    final BuildingNr buildingNr9 = BuildingNr.of("23 1/4 b"); //$NON-NLS-1$
    assertAll(BuildingNrTests.TEST_COMPARE_TO,
      () -> assertTrue(buildingNr1.compareTo(buildingNr2) == 0, "equal1"), //$NON-NLS-1$
      () -> assertTrue(buildingNr1.compareTo(buildingNr3) < 0, "23 < 23 1/4"), //$NON-NLS-1$
      () -> assertTrue(buildingNr3.compareTo(buildingNr1) > 0, "23 1/4 > 23"), //$NON-NLS-1$
      () -> assertTrue(buildingNr3.compareTo(buildingNr4) == 0, "equal2"), //$NON-NLS-1$
      () -> assertTrue(buildingNr4.compareTo(buildingNr5) < 0, "23 1/4 < 23 2/4"), //$NON-NLS-1$
      () -> assertTrue(buildingNr1.compareTo(buildingNr6) < 0, "23 < 23 a"), //$NON-NLS-1$
      () -> assertTrue(buildingNr6.compareTo(buildingNr1) > 0, "23 a > 23"), //$NON-NLS-1$
      () -> assertTrue(buildingNr6.compareTo(buildingNr7) < 0, "23 a < 23 b"), //$NON-NLS-1$
      () -> assertTrue(buildingNr8.compareTo(buildingNr9) < 0, "23 1/4 a < 23 1/4 b") //$NON-NLS-1$
    );
   }


  /**
   * Test compareTo wrong.
   */
  @Test
  /* default */ void testCompareToWrong1()
   {
    final BuildingNr buildingNr1 = BuildingNr.of("23 1/3"); //$NON-NLS-1$
    final BuildingNr buildingNr2 = BuildingNr.of(BuildingNrTests.BUILDINGNR23_1_4);
    assertThrows(IllegalStateException.class, () ->
     {
      /* final int result = */ buildingNr1.compareTo(buildingNr2);
     }, "Illegal state exception expected" //$NON-NLS-1$
    );
   }

 }
