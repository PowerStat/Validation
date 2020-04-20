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

import de.powerstat.validation.values.Hours;

/**
 * Hours tests.
 */
public class HoursTests
 {
  /**
   * Default constructor.
   */
  public HoursTests()
   {
    super();
   }


  /**
   * Is hours.
   *
   * @param hours Hours
   */
  @ParameterizedTest
  @ValueSource(longs = {0, 48})
  public void isHours(final long hours)
   {
    assertEquals(hours, Hours.of(hours).getHours(), "Not a hours!"); //$NON-NLS-1$
   }


  /**
   * Is not a hours.
   *
   * @param hour Hours
   */
  @ParameterizedTest
  @ValueSource(longs = {-1})
  public void isNotAHours(final long hours)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Hours hours = */ Hours.of(hours);
     }
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Hours hours1 = new Hours(1);
    final Hours hours2 = new Hours(1);
    final Hours hours3 = new Hours(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(hours1.hashCode(), hours2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(hours1.hashCode(), hours3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Hours hours1 = new Hours(1);
    final Hours hours2 = new Hours(1);
    final Hours hours3 = new Hours(2);
    final Hours hours4 = new Hours(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(hours1.equals(hours1), "hours11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(hours1.equals(hours2), "hours12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(hours2.equals(hours1), "hours21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(hours2.equals(hours4), "hours24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(hours1.equals(hours4), "hours14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(hours1.equals(hours3), "housr13 are equal"), //$NON-NLS-1$
      () -> assertFalse(hours3.equals(hours1), "hours31 are equal"), //$NON-NLS-1$
      () -> assertFalse(hours1.equals(null), "hours10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Hours hours = new Hours(1);
    assertEquals("Hours[hours=1]", hours.toString(), "toString not equal"); //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Hours hours1 = new Hours(1);
    final Hours hours2 = new Hours(1);
    final Hours hours3 = new Hours(2);
    final Hours hours4 = new Hours(3);
    final Hours hours5 = new Hours(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(hours1.compareTo(hours2) == -hours2.compareTo(hours1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(hours1.compareTo(hours3) == -hours3.compareTo(hours1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((hours4.compareTo(hours3) > 0) && (hours3.compareTo(hours1) > 0) && (hours4.compareTo(hours1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((hours1.compareTo(hours2) == 0) && (Math.abs(hours1.compareTo(hours5)) == Math.abs(hours2.compareTo(hours5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((hours1.compareTo(hours2) == 0) && hours1.equals(hours2), "equals") //$NON-NLS-1$
    );
   }

 }
