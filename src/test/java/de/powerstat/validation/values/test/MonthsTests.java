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

import de.powerstat.validation.values.Months;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Months tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class MonthsTests
 {
  /**
   * Default constructor.
   */
  public MonthsTests()
   {
    super();
   }


  /**
   * Is months.
   *
   * @param months Months
   */
  @ParameterizedTest
  @ValueSource(longs = {0, 1, 24})
  public void isMonths(final long months)
   {
    assertEquals(months, Months.of(months).getMonths(), "Not a months!"); //$NON-NLS-1$
   }


  /**
   * Is not a months.
   *
   * @param months Months
   */
  @ParameterizedTest
  @ValueSource(longs = {-1})
  public void isNotAMonths(final long months)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Months months = */ Months.of(months);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Months months1 = Months.of(1);
    final Months months2 = Months.of(1);
    final Months months3 = Months.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(months1.hashCode(), months2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(months1.hashCode(), months3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Months months1 = Months.of(1);
    final Months months2 = Months.of(1);
    final Months months3 = Months.of(2);
    final Months months4 = Months.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(months1.equals(months1), "months11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(months1.equals(months2), "months12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(months2.equals(months1), "months21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(months2.equals(months4), "months24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(months1.equals(months4), "months14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(months1.equals(months3), "months13 are equal"), //$NON-NLS-1$
      () -> assertFalse(months3.equals(months1), "months31 are equal"), //$NON-NLS-1$
      () -> assertFalse(months1.equals(null), "months10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Months months = Months.of(1);
    assertEquals("Months[months=1]", months.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Months months1 = Months.of(1);
    final Months months2 = Months.of(1);
    final Months months3 = Months.of(2);
    final Months months4 = Months.of(3);
    final Months months5 = Months.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(months1.compareTo(months2) == -months2.compareTo(months1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(months1.compareTo(months3) == -months3.compareTo(months1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((months4.compareTo(months3) > 0) && (months3.compareTo(months1) > 0) && (months4.compareTo(months1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((months1.compareTo(months2) == 0) && (Math.abs(months1.compareTo(months5)) == Math.abs(months2.compareTo(months5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((months1.compareTo(months2) == 0) && months1.equals(months2), "equals") //$NON-NLS-1$
    );
   }

 }
