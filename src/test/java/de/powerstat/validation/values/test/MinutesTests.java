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

import de.powerstat.validation.values.Minutes;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Minutes tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class MinutesTests
 {
  /**
   * Default constructor.
   */
  public MinutesTests()
   {
    super();
   }


  /**
   * Is minutes.
   *
   * @param minutes Minutes
   */
  @ParameterizedTest
  @ValueSource(longs = {0, 120})
  public void isMinutes(final long minutes)
   {
    assertEquals(minutes, Minutes.of(minutes).getMinutes(), "Not a minutes!"); //$NON-NLS-1$
   }


  /**
   * Is not a minutes.
   *
   * @param minutes Minutes
   */
  @ParameterizedTest
  @ValueSource(longs = {-1})
  public void isNotAMinutes(final long minutes)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Minutes minutes = */ Minutes.of(minutes);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Minutes minutes1 = Minutes.of(1);
    final Minutes minutes2 = Minutes.of(1);
    final Minutes minutes3 = Minutes.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(minutes1.hashCode(), minutes2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(minutes1.hashCode(), minutes3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Minutes minutes1 = Minutes.of(1);
    final Minutes minutes2 = Minutes.of(1);
    final Minutes minutes3 = Minutes.of(2);
    final Minutes minutes4 = Minutes.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(minutes1.equals(minutes1), "minutes11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(minutes1.equals(minutes2), "minutes12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(minutes2.equals(minutes1), "minutes21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(minutes2.equals(minutes4), "minutes24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(minutes1.equals(minutes4), "minutes14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(minutes1.equals(minutes3), "minutes13 are equal"), //$NON-NLS-1$
      () -> assertFalse(minutes3.equals(minutes1), "minutes31 are equal"), //$NON-NLS-1$
      () -> assertFalse(minutes1.equals(null), "minutes10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Minutes minutes = Minutes.of(1);
    assertEquals("Minutes[minutes=1]", minutes.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Minutes minutes1 = Minutes.of(1);
    final Minutes minutes2 = Minutes.of(1);
    final Minutes minutes3 = Minutes.of(2);
    final Minutes minutes4 = Minutes.of(3);
    final Minutes minutes5 = Minutes.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(minutes1.compareTo(minutes2) == -minutes2.compareTo(minutes1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(minutes1.compareTo(minutes3) == -minutes3.compareTo(minutes1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((minutes4.compareTo(minutes3) > 0) && (minutes3.compareTo(minutes1) > 0) && (minutes4.compareTo(minutes1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((minutes1.compareTo(minutes2) == 0) && (Math.abs(minutes1.compareTo(minutes5)) == Math.abs(minutes2.compareTo(minutes5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((minutes1.compareTo(minutes2) == 0) && minutes1.equals(minutes2), "equals") //$NON-NLS-1$
    );
   }

 }
