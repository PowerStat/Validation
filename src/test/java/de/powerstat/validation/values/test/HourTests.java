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

import de.powerstat.validation.values.Hour;


/**
 * Hour tests.
 */
public class HourTests
 {
  /**
   * Default constructor.
   */
  public HourTests()
   {
    super();
   }


  /**
   * Is hour.
   *
   * @param hour Hour
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 23})
  public void isHour(final int hour)
   {
    assertEquals(hour, Hour.of(hour).getHour(), "Not a hour!"); //$NON-NLS-1$
   }


  /**
   * Is not a hour.
   *
   * @param hour Hour
   */
  @ParameterizedTest
  @ValueSource(ints = {-1, 24})
  public void isNotAHour(final int hour)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Hour hour = */ Hour.of(hour);
     }
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Hour hour1 = Hour.of(1);
    final Hour hour2 = Hour.of(1);
    final Hour hour3 = Hour.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(hour1.hashCode(), hour2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(hour1.hashCode(), hour3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Hour hour1 = Hour.of(1);
    final Hour hour2 = Hour.of(1);
    final Hour hour3 = Hour.of(2);
    final Hour hour4 = Hour.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(hour1.equals(hour1), "hour11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(hour1.equals(hour2), "hour12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(hour2.equals(hour1), "hour21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(hour2.equals(hour4), "hour24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(hour1.equals(hour4), "hour14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(hour1.equals(hour3), "hour13 are equal"), //$NON-NLS-1$
      () -> assertFalse(hour3.equals(hour1), "hour31 are equal"), //$NON-NLS-1$
      () -> assertFalse(hour1.equals(null), "hour10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Hour hour = Hour.of(1);
    assertEquals("Hour[hour=1]", hour.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Hour hour1 = Hour.of(1);
    final Hour hour2 = Hour.of(1);
    final Hour hour3 = Hour.of(2);
    final Hour hour4 = Hour.of(3);
    final Hour hour5 = Hour.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(hour1.compareTo(hour2) == -hour2.compareTo(hour1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(hour1.compareTo(hour3) == -hour3.compareTo(hour1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((hour4.compareTo(hour3) > 0) && (hour3.compareTo(hour1) > 0) && (hour4.compareTo(hour1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((hour1.compareTo(hour2) == 0) && (Math.abs(hour1.compareTo(hour5)) == Math.abs(hour2.compareTo(hour5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((hour1.compareTo(hour2) == 0) && hour1.equals(hour2), "equals") //$NON-NLS-1$
    );
   }

 }
