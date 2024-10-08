/*
 * Copyright (C) 2024 Dipl.-Inform. Kai Hofmann. All rights reserved!
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

import de.powerstat.validation.values.Percent;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Tests for Percent value class.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class PercentTests
 {
  /**
   * Default constructor.
   */
  /* default */ PercentTests()
   {
    super();
   }


  /**
   * Is percent.
   */
  @Test
  /* default */ void testIsPercent()
   {
    final Percent percent = Percent.of(50);
    assertEquals(50, percent.intValue(), "Percent should be 50");
   }


  /**
   * Is not a percent.
   *
   * @param percent Percent
   */
  @ParameterizedTest
  @ValueSource(ints = {101, -1})
  /* default */ void testIsPercentFalse(final int percent)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Percent percent = */ Percent.of(percent);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(50, Percent.of("50").intValue(), "Percent should be 50");
   }


  /**
   * Test intValue.
   */
  @Test
  /* default */ void testIntValue()
   {
    final Percent percent = Percent.of(50);
    assertEquals(50, percent.intValue(), "Percent should be 50");
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Percent percent = Percent.of(50);
    assertEquals("50", percent.stringValue(), "Percent should be 50");
   }


  /**
   * Test hash code.
   */
  @Test
  /* default */ void testHashCode()
   {
    final Percent percent1 = Percent.of(50);
    final Percent percent2 = Percent.of(50);
    final Percent percent3 = Percent.of(51);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(percent1.hashCode(), percent2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(percent1.hashCode(), percent3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testEquals()
   {
    final Percent percent1 = Percent.of(50);
    final Percent percent2 = Percent.of(50);
    final Percent percent3 = Percent.of(51);
    final Percent percent4 = Percent.of(50);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(percent1.equals(percent1), "percent11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(percent1.equals(percent2), "percent12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(percent2.equals(percent1), "percent21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(percent2.equals(percent4), "percent24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(percent1.equals(percent4), "percent14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(percent1.equals(percent3), "percent13 are equal"), //$NON-NLS-1$
      () -> assertFalse(percent3.equals(percent1), "percent31 are equal"), //$NON-NLS-1$
      () -> assertFalse(percent1.equals(null), "percent10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Percent percent = Percent.of(50);
    assertEquals("Percent[percent=50]", percent.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Percent percent1 = Percent.of(50);
    final Percent percent2 = Percent.of(50);
    final Percent percent3 = Percent.of(51);
    final Percent percent4 = Percent.of(52);
    final Percent percent5 = Percent.of(50);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(percent1.compareTo(percent2) == -percent2.compareTo(percent1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(percent1.compareTo(percent3) == -percent3.compareTo(percent1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((percent4.compareTo(percent3) > 0) && (percent3.compareTo(percent1) > 0) && (percent4.compareTo(percent1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((percent1.compareTo(percent2) == 0) && (Math.abs(percent1.compareTo(percent5)) == Math.abs(percent2.compareTo(percent5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((percent1.compareTo(percent2) == 0) && percent1.equals(percent2), "equals") //$NON-NLS-1$
    );
   }

 }
