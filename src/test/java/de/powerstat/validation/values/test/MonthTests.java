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

import de.powerstat.validation.values.Month;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Month tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class MonthTests
 {
  /**
   * Default constructor.
   */
  public MonthTests()
   {
    super();
   }


  /**
   * Is month.
   *
   * @param month Month
   */
  @ParameterizedTest
  @ValueSource(ints = {1, 12})
  public void isMonth(final int month)
   {
    assertEquals(month, Month.of(month).getMonth(), "Not a month!"); //$NON-NLS-1$
   }


  /**
   * Is not a month.
   *
   * @param month Month
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 13})
  public void isNotAMonth(final int month)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Month month = */ Month.of(month);
     }
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Month month1 = Month.of(1);
    final Month month2 = Month.of(1);
    final Month month3 = Month.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(month1.hashCode(), month2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(month1.hashCode(), month3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Month month1 = Month.of(1);
    final Month month2 = Month.of(1);
    final Month month3 = Month.of(2);
    final Month month4 = Month.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(month1.equals(month1), "month11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(month1.equals(month2), "month12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(month2.equals(month1), "month21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(month2.equals(month4), "month24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(month1.equals(month4), "month14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(month1.equals(month3), "month13 are equal"), //$NON-NLS-1$
      () -> assertFalse(month3.equals(month1), "month31 are equal"), //$NON-NLS-1$
      () -> assertFalse(month1.equals(null), "month10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Month month = Month.of(1);
    assertEquals("Month[month=1]", month.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Month month1 = Month.of(1);
    final Month month2 = Month.of(1);
    final Month month3 = Month.of(2);
    final Month month4 = Month.of(3);
    final Month month5 = Month.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(month1.compareTo(month2) == -month2.compareTo(month1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(month1.compareTo(month3) == -month3.compareTo(month1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((month4.compareTo(month3) > 0) && (month3.compareTo(month1) > 0) && (month4.compareTo(month1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((month1.compareTo(month2) == 0) && (Math.abs(month1.compareTo(month5)) == Math.abs(month2.compareTo(month5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((month1.compareTo(month2) == 0) && month1.equals(month2), "equals") //$NON-NLS-1$
    );
   }

 }
