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

import de.powerstat.validation.values.SubBuilding;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Sub building tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class SubBuildingTests
 {
  /**
   * Floor 13 apartment 0815.
   */
  private static final String FLOOR_13_APART_0815 = "Floor 13, Apart. 0815"; //$NON-NLS-1$

  /**
   * Floor 99.
   */
  private static final String FLOOR_99 = "Floor 99"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * SubBuilding not as expected constant.
   */
  private static final String SUB_BUILDING_NOT_AS_EXPECTED = "SubBuilding not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public SubBuildingTests()
   {
    super();
   }


  /**
   * Test correct SubBuilding.
   *
   * @param subBuilding Sub building
   */
  @ParameterizedTest
  @ValueSource(strings = {SubBuildingTests.FLOOR_13_APART_0815, "A", "Abcdefghijklmnopqrstuvwxyzabcdef"})
  public void subBuildingCorrect(final String subBuilding)
   {
    final SubBuilding cleanSubBuilding = SubBuilding.of(subBuilding);
    assertEquals(subBuilding, cleanSubBuilding.getSubBuilding(), SubBuildingTests.SUB_BUILDING_NOT_AS_EXPECTED);
   }


  /**
   * Test SubBuilding with wrong lengths.
   *
   * @param subBuilding Sub building
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "Abcdefghijklmnopqrstuvwxyzabcdefg"})
  public void subBuildingLength(final String subBuilding)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final SubBuilding cleanSubBuilding = */ SubBuilding.of(subBuilding);
     }, SubBuildingTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test wrong SubBuilding.
   *
   * @param subBuilding Sub building
   */
  @ParameterizedTest
  @ValueSource(strings = {"abc_def"})
  public void subBuildingWrong(final String subBuilding)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final SubBuilding cleanSubBuilding = */ SubBuilding.of(subBuilding);
     }, SubBuildingTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get subBuilding.
   */
  @Test
  public void getSubBuilding()
   {
    final SubBuilding subBuilding = SubBuilding.of(SubBuildingTests.FLOOR_13_APART_0815);
    assertEquals(SubBuildingTests.FLOOR_13_APART_0815, subBuilding.getSubBuilding(), SubBuildingTests.SUB_BUILDING_NOT_AS_EXPECTED);
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final SubBuilding subBuilding1 = SubBuilding.of(SubBuildingTests.FLOOR_13_APART_0815);
    final SubBuilding subBuilding2 = SubBuilding.of(SubBuildingTests.FLOOR_13_APART_0815);
    final SubBuilding subBuilding3 = SubBuilding.of(SubBuildingTests.FLOOR_99);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(subBuilding1.hashCode(), subBuilding2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(subBuilding1.hashCode(), subBuilding3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final SubBuilding subBuilding1 = SubBuilding.of(SubBuildingTests.FLOOR_13_APART_0815);
    final SubBuilding subBuilding2 = SubBuilding.of(SubBuildingTests.FLOOR_13_APART_0815);
    final SubBuilding subBuilding3 = SubBuilding.of(SubBuildingTests.FLOOR_99);
    final SubBuilding subBuilding4 = SubBuilding.of(SubBuildingTests.FLOOR_13_APART_0815);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(subBuilding1.equals(subBuilding1), "subBulding11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(subBuilding1.equals(subBuilding2), "subBulding12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(subBuilding2.equals(subBuilding1), "subBulding21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(subBuilding2.equals(subBuilding4), "subBulding24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(subBuilding1.equals(subBuilding4), "subBulding14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(subBuilding1.equals(subBuilding3), "subBulding13 are equal"), //$NON-NLS-1$
      () -> assertFalse(subBuilding3.equals(subBuilding1), "subBulding31 are equal"), //$NON-NLS-1$
      () -> assertFalse(subBuilding1.equals(null), "subBulding10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final SubBuilding subBuilding = SubBuilding.of(SubBuildingTests.FLOOR_13_APART_0815);
    assertEquals("SubBuilding[subBuilding=Floor 13, Apart. 0815]", subBuilding.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final SubBuilding subBuilding1 = SubBuilding.of(SubBuildingTests.FLOOR_13_APART_0815);
    final SubBuilding subBuilding2 = SubBuilding.of(SubBuildingTests.FLOOR_13_APART_0815);
    final SubBuilding subBuilding3 = SubBuilding.of(SubBuildingTests.FLOOR_99);
    final SubBuilding subBuilding4 = SubBuilding.of("Floor XIII"); //$NON-NLS-1$
    final SubBuilding subBuilding5 = SubBuilding.of(SubBuildingTests.FLOOR_13_APART_0815);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(subBuilding1.compareTo(subBuilding2) == -subBuilding2.compareTo(subBuilding1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(subBuilding1.compareTo(subBuilding3) == -subBuilding3.compareTo(subBuilding1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((subBuilding4.compareTo(subBuilding3) > 0) && (subBuilding3.compareTo(subBuilding1) > 0) && (subBuilding4.compareTo(subBuilding1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((subBuilding1.compareTo(subBuilding2) == 0) && (Math.abs(subBuilding1.compareTo(subBuilding5)) == Math.abs(subBuilding2.compareTo(subBuilding5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((subBuilding1.compareTo(subBuilding2) == 0) && subBuilding1.equals(subBuilding2), "equals") //$NON-NLS-1$
    );
   }

 }
