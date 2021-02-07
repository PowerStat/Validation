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

import de.powerstat.validation.values.BuildingName;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Building name tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class BuildingNameTests
 {
  /**
   * City hall.
   */
  private static final String RATHAUS = "Rathaus"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public BuildingNameTests()
   {
    super();
   }


  /**
   * Test correct BuildingName.
   *
   * @param buildingName Building name
   */
  @ParameterizedTest
  @ValueSource(strings = {RATHAUS, "A", "Abcdefghijklmnopqrstuvwxyzabcdef"})
  public void buildingNameCorrect(final String buildingName)
   {
    final BuildingName cleanBuildingName = BuildingName.of(buildingName);
    assertEquals(buildingName, cleanBuildingName.getBuildingName(), "BuildingName not as expected"); //$NON-NLS-1$
   }


  /**
   * Test BuildingName with wrong lengths.
   *
   * @param buildingName Building name
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "Abcdefghijklmnopqrstuvwxyzabcdefg"})
  public void buildingNameLength(final String buildingName)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final BuildingName cleanBuildingName = */ BuildingName.of(buildingName);
     }
    );
   }


  /**
   * Test wrong BuildingName.
   *
   * @param buildingName Building name
   */
  @ParameterizedTest
  @ValueSource(strings = {"Bremen0815", "abc_def"})
  public void buildingNameWrong(final String buildingName)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final BuildingName cleanBuildingName = */ BuildingName.of(buildingName);
     }
    );
   }


  /**
   * Test get building name.
   */
  @Test
  public void getBuildingName()
   {
    final BuildingName buildingName = BuildingName.of(RATHAUS);
    assertEquals(RATHAUS, buildingName.getBuildingName(), "BuildingName not as expected"); //$NON-NLS-1$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final BuildingName buildingName1 = BuildingName.of(RATHAUS);
    final BuildingName buildingName2 = BuildingName.of(RATHAUS);
    final BuildingName buildingName3 = BuildingName.of("Stadtwaage"); //$NON-NLS-1$
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(buildingName1.hashCode(), buildingName2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(buildingName1.hashCode(), buildingName3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final BuildingName name1 = BuildingName.of(RATHAUS);
    final BuildingName name2 = BuildingName.of(RATHAUS);
    final BuildingName name3 = BuildingName.of("Stadtwaage"); //$NON-NLS-1$
    final BuildingName name4 = BuildingName.of(RATHAUS);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(name1.equals(name1), "name11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(name1.equals(name2), "name12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(name2.equals(name1), "name21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(name2.equals(name4), "name24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(name1.equals(name4), "name14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(name1.equals(name3), "name13 are equal"), //$NON-NLS-1$
      () -> assertFalse(name3.equals(name1), "name31 are equal"), //$NON-NLS-1$
      () -> assertFalse(name1.equals(null), "name10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final BuildingName buildingName = BuildingName.of(RATHAUS);
    assertEquals("BuildingName[buildingName=Rathaus]", buildingName.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final BuildingName name1 = BuildingName.of(RATHAUS);
    final BuildingName name2 = BuildingName.of(RATHAUS);
    final BuildingName name3 = BuildingName.of("Stadtwaage"); //$NON-NLS-1$
    final BuildingName name4 = BuildingName.of("Torhaus"); //$NON-NLS-1$
    final BuildingName name5 = BuildingName.of(RATHAUS);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(name1.compareTo(name2) == -name2.compareTo(name1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(name1.compareTo(name3) == -name3.compareTo(name1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((name4.compareTo(name3) > 0) && (name3.compareTo(name1) > 0) && (name4.compareTo(name1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((name1.compareTo(name2) == 0) && (Math.abs(name1.compareTo(name5)) == Math.abs(name2.compareTo(name5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((name1.compareTo(name2) == 0) && name1.equals(name2), "equals") //$NON-NLS-1$
    );
   }

 }
