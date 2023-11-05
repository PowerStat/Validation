/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
final class NeighbourhoodTests
 {
  /**
   * Unknown.
   */
  private static final String UNKNOWN = "Unknown"; //$NON-NLS-1$

  /**
   * Unknown 2.
   */
  private static final String UNKNOWN2 = "Unknown2"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Neighbourhood not as expected constant.
   */
  private static final String NEIGHBOURHOOD_NOT_AS_EXPECTED = "Neighbourhood not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ NeighbourhoodTests()
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
  /* default */ void testNeighbourhoodCorrect(final String neighbourhood)
   {
    final Neighbourhood cleanNeighbourhood = Neighbourhood.of(neighbourhood);
    assertEquals(neighbourhood, cleanNeighbourhood.neighbourhood(), NeighbourhoodTests.NEIGHBOURHOOD_NOT_AS_EXPECTED);
   }


  /**
   * Test Neighbourhood with wrong lengths.
   *
   * @param neighbourhood Neighbourhood
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "Abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklm"})
  /* default */ void testNeighbourhoodLength(final String neighbourhood)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Neighbourhood cleanNeighbourhood = */ Neighbourhood.of(neighbourhood);
     }, NeighbourhoodTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test wrong Neighbourhood.
   *
   * @param neighbourhood Neighbourhood
   */
  @ParameterizedTest
  @ValueSource(strings = {"abc_def"})
  /* default */ void testNeighbourhoodWrong(final String neighbourhood)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Neighbourhood cleanNeighbourhood = */ Neighbourhood.of(neighbourhood);
     }, NeighbourhoodTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get Neighbourhood.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Neighbourhood neighbourhood = Neighbourhood.of(NeighbourhoodTests.UNKNOWN);
    assertEquals(NeighbourhoodTests.UNKNOWN, neighbourhood.stringValue(), NeighbourhoodTests.NEIGHBOURHOOD_NOT_AS_EXPECTED);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Neighbourhood neighbourhood1 = Neighbourhood.of(NeighbourhoodTests.UNKNOWN);
    final Neighbourhood neighbourhood2 = Neighbourhood.of(NeighbourhoodTests.UNKNOWN);
    final Neighbourhood neighbourhood3 = Neighbourhood.of(NeighbourhoodTests.UNKNOWN2);
    final Neighbourhood neighbourhood4 = Neighbourhood.of("Unknown3r"); //$NON-NLS-1$
    final Neighbourhood neighbourhood5 = Neighbourhood.of(NeighbourhoodTests.UNKNOWN);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(neighbourhood1.compareTo(neighbourhood2) == -neighbourhood2.compareTo(neighbourhood1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(neighbourhood1.compareTo(neighbourhood3) == -neighbourhood3.compareTo(neighbourhood1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((neighbourhood4.compareTo(neighbourhood3) > 0) && (neighbourhood3.compareTo(neighbourhood1) > 0) && (neighbourhood4.compareTo(neighbourhood1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((neighbourhood1.compareTo(neighbourhood2) == 0) && (Math.abs(neighbourhood1.compareTo(neighbourhood5)) == Math.abs(neighbourhood2.compareTo(neighbourhood5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((neighbourhood1.compareTo(neighbourhood2) == 0) && neighbourhood1.equals(neighbourhood2), "equals") //$NON-NLS-1$
    );
   }

 }
