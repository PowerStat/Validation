/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
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
    assertEquals(subBuilding, cleanSubBuilding.subBuilding(), SubBuildingTests.SUB_BUILDING_NOT_AS_EXPECTED);
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
