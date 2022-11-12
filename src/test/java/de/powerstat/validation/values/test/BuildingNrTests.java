/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
public class BuildingNrTests
 {
  /**
   * Default constructor.
   */
  public BuildingNrTests()
   {
    super();
   }


  /**
   * Test correct BuildingNr.
   *
   * @param buildingNr BuildingNr
   */
  @ParameterizedTest
  @ValueSource(strings = {"9", "42", "42-44", "42/44", "42 a", "42 1/3", "42 1/3 a", "29998-29999 998/999 a", "29999", "42 4/4"})
  public void buildingNrCorrect(final String buildingNr)
   {
    final BuildingNr cleanBuildingNr = BuildingNr.of(buildingNr);
    assertEquals(buildingNr, cleanBuildingNr.getBuildingNr(), "BuildingNr not as expected"); //$NON-NLS-1$
   }


  /**
   * Test BuildingNr with wrong lengths.
   *
   * @param buildingNr Building number
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "1234567890123456789012"})
  public void buildingNrLength(final String buildingNr)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final BuildingNr cleanBuildingNr = */ BuildingNr.of(buildingNr);
     }, "Illegal argument exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test wrong BuildingNr.
   *
   * @param buildingNr Building number
   */
  @ParameterizedTest
  @ValueSource(strings = {"4a2", "30000", "43-42", "42-42", "42 5/4"})
  public void buidlingNrWrong(final String buildingNr)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final BuildingNr cleanBuildingNr = */ BuildingNr.of(buildingNr);
     }, "Illegal argument exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test get buildingNr.
   */
  @Test
  public void getBuildingNr()
   {
    final BuildingNr buildingNr = BuildingNr.of("42"); //$NON-NLS-1$
    assertEquals("42", buildingNr.getBuildingNr(), "BuildingNr not as expected"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final BuildingNr buildingNr1 = BuildingNr.of("23"); //$NON-NLS-1$
    final BuildingNr buildingNr2 = BuildingNr.of("23"); //$NON-NLS-1$
    final BuildingNr buildingNr3 = BuildingNr.of("42"); //$NON-NLS-1$
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(buildingNr1.hashCode(), buildingNr2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(buildingNr1.hashCode(), buildingNr3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final BuildingNr buildingNr1 = BuildingNr.of("23"); //$NON-NLS-1$
    final BuildingNr buildingNr2 = BuildingNr.of("23"); //$NON-NLS-1$
    final BuildingNr buildingNr3 = BuildingNr.of("42"); //$NON-NLS-1$
    final BuildingNr buildingNr4 = BuildingNr.of("23"); //$NON-NLS-1$
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(buildingNr1.equals(buildingNr1), "BuildingNr11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(buildingNr1.equals(buildingNr2), "BuildingNr12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(buildingNr2.equals(buildingNr1), "BuildingNr21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(buildingNr2.equals(buildingNr4), "BuildingNr24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(buildingNr1.equals(buildingNr4), "BuildingNr14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(buildingNr1.equals(buildingNr3), "BuildingNr13 are equal"), //$NON-NLS-1$
      () -> assertFalse(buildingNr3.equals(buildingNr1), "BuildingNr31 are equal"), //$NON-NLS-1$
      () -> assertFalse(buildingNr1.equals(null), "BuildingNr10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final BuildingNr buildingNr = BuildingNr.of("42"); //$NON-NLS-1$
    assertEquals("BuildingNr[buildingNr=42]", buildingNr.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final BuildingNr buildingNr1 = BuildingNr.of("23"); //$NON-NLS-1$
    final BuildingNr buildingNr2 = BuildingNr.of("23"); //$NON-NLS-1$
    final BuildingNr buildingNr3 = BuildingNr.of("42"); //$NON-NLS-1$
    final BuildingNr buildingNr4 = BuildingNr.of("99"); //$NON-NLS-1$
    final BuildingNr buildingNr5 = BuildingNr.of("23"); //$NON-NLS-1$
    assertAll("testCompareTo", //$NON-NLS-1$
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
  public void testCompareToOk()
   {
    final BuildingNr buildingNr1 = BuildingNr.of("23"); //$NON-NLS-1$
    final BuildingNr buildingNr2 = BuildingNr.of("23"); //$NON-NLS-1$
    final BuildingNr buildingNr3 = BuildingNr.of("23 1/4"); //$NON-NLS-1$
    final BuildingNr buildingNr4 = BuildingNr.of("23 1/4"); //$NON-NLS-1$
    final BuildingNr buildingNr5 = BuildingNr.of("23 2/4"); //$NON-NLS-1$
    final BuildingNr buildingNr6 = BuildingNr.of("23 a"); //$NON-NLS-1$
    final BuildingNr buildingNr7 = BuildingNr.of("23 b"); //$NON-NLS-1$
    final BuildingNr buildingNr8 = BuildingNr.of("23 1/4 a"); //$NON-NLS-1$
    final BuildingNr buildingNr9 = BuildingNr.of("23 1/4 b"); //$NON-NLS-1$
    assertAll("testCompareTo", //$NON-NLS-1$
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
  public void testCompareTowrong()
   {
    final BuildingNr buildingNr1 = BuildingNr.of("23 1/3"); //$NON-NLS-1$
    final BuildingNr buildingNr2 = BuildingNr.of("23 1/4"); //$NON-NLS-1$
    assertThrows(IllegalStateException.class, () ->
     {
      /* final int result = */ buildingNr1.compareTo(buildingNr2);
     }, "Illegal state exception expected" //$NON-NLS-1$
    );
   }

 }
