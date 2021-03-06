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

import de.powerstat.validation.values.Neighbourhood;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Neighbourhood tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class NeighbourhoodTests
 {
  /**
   * Unknown.
   */
  private static final String UNKNOWN = "Unknown"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public NeighbourhoodTests()
   {
    super();
   }


  /**
   * Test correct Neighbourhood.
   *
   * @param neighbourhood Neighbourhood
   */
  @ParameterizedTest
  @ValueSource(strings = {"A", "Abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijkl"})
  public void neighbourhoodCorrect(final String neighbourhood)
   {
    final Neighbourhood cleanNeighbourhood = Neighbourhood.of(neighbourhood);
    assertEquals(neighbourhood, cleanNeighbourhood.getNeighbourhood(), "Neighbourhood not as expected"); //$NON-NLS-1$
   }


  /**
   * Test Neighbourhood with wrong lengths.
   *
   * @param neighbourhood Neighbourhood
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "Abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklm"})
  public void neighbourhoodLength(final String neighbourhood)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Neighbourhood cleanNeighbourhood = */ Neighbourhood.of(neighbourhood);
     }
    );
   }


  /**
   * Test wrong Neighbourhood.
   *
   * @param neighbourhood Neighbourhood
   */
  @ParameterizedTest
  @ValueSource(strings = {"abc_def"})
  public void neighbourhoodWrong(final String neighbourhood)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Neighbourhood cleanNeighbourhood = */ Neighbourhood.of(neighbourhood);
     }
    );
   }


  /**
   * Test get Neighbourhood.
   */
  @Test
  public void getNeighbourhood()
   {
    final Neighbourhood neighbourhood = Neighbourhood.of(UNKNOWN);
    assertEquals(UNKNOWN, neighbourhood.getNeighbourhood(), "Neighbourhood not as expected"); //$NON-NLS-1$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Neighbourhood neighbourhood1 = Neighbourhood.of(UNKNOWN);
    final Neighbourhood neighbourhood2 = Neighbourhood.of(UNKNOWN);
    final Neighbourhood neighbourhood3 = Neighbourhood.of("Unknown2"); //$NON-NLS-1$
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(neighbourhood1.hashCode(), neighbourhood2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(neighbourhood1.hashCode(), neighbourhood3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Neighbourhood neighbourhood1 = Neighbourhood.of(UNKNOWN);
    final Neighbourhood neighbourhood2 = Neighbourhood.of(UNKNOWN);
    final Neighbourhood neighbourhood3 = Neighbourhood.of("Unknown2"); //$NON-NLS-1$
    final Neighbourhood neighbourhood4 = Neighbourhood.of(UNKNOWN);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(neighbourhood1.equals(neighbourhood1), "neighbourhood11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(neighbourhood1.equals(neighbourhood2), "neighbourhood12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(neighbourhood2.equals(neighbourhood1), "neighbourhood21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(neighbourhood2.equals(neighbourhood4), "neighbourhood24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(neighbourhood1.equals(neighbourhood4), "neighbourhood14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(neighbourhood1.equals(neighbourhood3), "neighbourhood13 are equal"), //$NON-NLS-1$
      () -> assertFalse(neighbourhood3.equals(neighbourhood1), "neighbourhood31 are equal"), //$NON-NLS-1$
      () -> assertFalse(neighbourhood1.equals(null), "neighbourhood10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Neighbourhood neighbourhood = Neighbourhood.of(UNKNOWN);
    assertEquals("Neighbourhood[neighbourhood=Unknown]", neighbourhood.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Neighbourhood neighbourhood1 = Neighbourhood.of(UNKNOWN);
    final Neighbourhood neighbourhood2 = Neighbourhood.of(UNKNOWN);
    final Neighbourhood neighbourhood3 = Neighbourhood.of("Unknown2"); //$NON-NLS-1$
    final Neighbourhood neighbourhood4 = Neighbourhood.of("Unknown3r"); //$NON-NLS-1$
    final Neighbourhood neighbourhood5 = Neighbourhood.of(UNKNOWN);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(neighbourhood1.compareTo(neighbourhood2) == -neighbourhood2.compareTo(neighbourhood1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(neighbourhood1.compareTo(neighbourhood3) == -neighbourhood3.compareTo(neighbourhood1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((neighbourhood4.compareTo(neighbourhood3) > 0) && (neighbourhood3.compareTo(neighbourhood1) > 0) && (neighbourhood4.compareTo(neighbourhood1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((neighbourhood1.compareTo(neighbourhood2) == 0) && (Math.abs(neighbourhood1.compareTo(neighbourhood5)) == Math.abs(neighbourhood2.compareTo(neighbourhood5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((neighbourhood1.compareTo(neighbourhood2) == 0) && neighbourhood1.equals(neighbourhood2), "equals") //$NON-NLS-1$
    );
   }

 }
