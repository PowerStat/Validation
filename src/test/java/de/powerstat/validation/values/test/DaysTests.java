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

import de.powerstat.validation.values.Days;


/**
 * Days tests.
 */
public class DaysTests
 {
  /**
   * Default constructor.
   */
  public DaysTests()
   {
    super();
   }


  /**
   * Is days.
   *
   * @param days Days
   */
  @ParameterizedTest
  @ValueSource(longs = {0, 1, 7, 30, 365})
  public void isDays(final long days)
   {
    assertEquals(days, Days.of(days).getDays(), "Not a days!"); //$NON-NLS-1$
   }


  /**
   * Is not a days.
   *
   * @param days Days
   */
  @ParameterizedTest
  @ValueSource(longs = {-1, -7, -30, -365})
  public void isNotADays(final long days)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Days days = */ Days.of(days);
     }
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Days days1 = new Days(1);
    final Days days2 = new Days(1);
    final Days days3 = new Days(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(days1.hashCode(), days2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(days1.hashCode(), days3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Days days1 = new Days(1);
    final Days days2 = new Days(1);
    final Days days3 = new Days(2);
    final Days days4 = new Days(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(days1.equals(days1), "days11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(days1.equals(days2), "days12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(days2.equals(days1), "days21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(days2.equals(days4), "days24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(days1.equals(days4), "days14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(days1.equals(days3), "days13 are equal"), //$NON-NLS-1$
      () -> assertFalse(days3.equals(days1), "days31 are equal"), //$NON-NLS-1$
      () -> assertFalse(days1.equals(null), "days10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Days days = new Days(1);
    assertEquals("Days[days=1]", days.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Days days1 = new Days(1);
    final Days days2 = new Days(1);
    final Days days3 = new Days(2);
    final Days days4 = new Days(3);
    final Days days5 = new Days(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(days1.compareTo(days2) == -days2.compareTo(days1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(days1.compareTo(days3) == -days3.compareTo(days1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((days4.compareTo(days3) > 0) && (days3.compareTo(days1) > 0) && (days4.compareTo(days1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((days1.compareTo(days2) == 0) && (Math.abs(days1.compareTo(days5)) == Math.abs(days2.compareTo(days5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((days1.compareTo(days2) == 0) && days1.equals(days2), "equals") //$NON-NLS-1$
    );
   }

 }
