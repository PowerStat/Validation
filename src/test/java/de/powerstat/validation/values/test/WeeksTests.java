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

import de.powerstat.validation.values.Weeks;

/**
 * Weeks tests.
 */
public class WeeksTests
 {
  /**
   * Default constructor.
   */
  public WeeksTests()
   {
    super();
   }


  /**
   * Is weeks.
   *
   * @param weeks Weeks
   */
  @ParameterizedTest
  @ValueSource(longs = {0, 1, 104})
  public void isWeeks(final long weeks)
   {
    assertEquals(weeks, Weeks.of(weeks).getWeeks(), "Not a weeks!"); //$NON-NLS-1$
   }


  /**
   * Is not a weeks.
   *
   * @param weeks Weeks
   */
  @ParameterizedTest
  @ValueSource(longs = {-1})
  public void isNotAWeeks(final long weeks)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Weeks weeks = */ Weeks.of(weeks);
     }
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Weeks weeks1 = Weeks.of(1);
    final Weeks weeks2 = Weeks.of(1);
    final Weeks weeks3 = Weeks.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(weeks1.hashCode(), weeks2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(weeks1.hashCode(), weeks3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Weeks weeks1 = Weeks.of(1);
    final Weeks weeks2 = Weeks.of(1);
    final Weeks weeks3 = Weeks.of(2);
    final Weeks weeks4 = Weeks.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(weeks1.equals(weeks1), "weeks11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(weeks1.equals(weeks2), "weeks12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(weeks2.equals(weeks1), "weeks21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(weeks2.equals(weeks4), "weeks24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(weeks1.equals(weeks4), "weeks14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(weeks1.equals(weeks3), "weeks13 are equal"), //$NON-NLS-1$
      () -> assertFalse(weeks3.equals(weeks1), "weeks31 are equal"), //$NON-NLS-1$
      () -> assertFalse(weeks1.equals(null), "weeks10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Weeks weeks = Weeks.of(1);
    assertEquals("Weeks[weeks=1]", weeks.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Weeks weeks1 = Weeks.of(1);
    final Weeks weeks2 = Weeks.of(1);
    final Weeks weeks3 = Weeks.of(2);
    final Weeks weeks4 = Weeks.of(3);
    final Weeks weeks5 = Weeks.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(weeks1.compareTo(weeks2) == -weeks2.compareTo(weeks1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(weeks1.compareTo(weeks3) == -weeks3.compareTo(weeks1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((weeks4.compareTo(weeks3) > 0) && (weeks3.compareTo(weeks1) > 0) && (weeks4.compareTo(weeks1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((weeks1.compareTo(weeks2) == 0) && (Math.abs(weeks1.compareTo(weeks5)) == Math.abs(weeks2.compareTo(weeks5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((weeks1.compareTo(weeks2) == 0) && weeks1.equals(weeks2), "equals") //$NON-NLS-1$
    );
   }

 }
