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

import de.powerstat.validation.values.Minute;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Minute tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT"})
public class MinuteTests
 {
  /**
   * Default constructor.
   */
  public MinuteTests()
   {
    super();
   }


  /**
   * Is minute.
   *
   * @param minute Minute
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 59})
  public void isMinute(final int minute)
   {
    assertEquals(minute, Minute.of(minute).getMinute(), "Not a minute!"); //$NON-NLS-1$
   }


  /**
   * Is not a minute.
   *
   * @param minute Minute
   */
  @ParameterizedTest
  @ValueSource(ints = {-1, 60})
  public void isNotAMinute(final int minute)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Minute minute = */ Minute.of(minute);
     }
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Minute minute1 = Minute.of(1);
    final Minute minute2 = Minute.of(1);
    final Minute minute3 = Minute.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(minute1.hashCode(), minute2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(minute1.hashCode(), minute3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Minute minute1 = Minute.of(1);
    final Minute minute2 = Minute.of(1);
    final Minute minute3 = Minute.of(2);
    final Minute minute4 = Minute.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(minute1.equals(minute1), "minute11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(minute1.equals(minute2), "minute12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(minute2.equals(minute1), "minute21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(minute2.equals(minute4), "minute24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(minute1.equals(minute4), "minute14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(minute1.equals(minute3), "minute13 are equal"), //$NON-NLS-1$
      () -> assertFalse(minute3.equals(minute1), "minute31 are equal"), //$NON-NLS-1$
      () -> assertFalse(minute1.equals(null), "minute10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Minute minute = Minute.of(1);
    assertEquals("Minute[minute=1]", minute.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Minute minute1 = Minute.of(1);
    final Minute minute2 = Minute.of(1);
    final Minute minute3 = Minute.of(2);
    final Minute minute4 = Minute.of(3);
    final Minute minute5 = Minute.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(minute1.compareTo(minute2) == -minute2.compareTo(minute1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(minute1.compareTo(minute3) == -minute3.compareTo(minute1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((minute4.compareTo(minute3) > 0) && (minute3.compareTo(minute1) > 0) && (minute4.compareTo(minute1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((minute1.compareTo(minute2) == 0) && (Math.abs(minute1.compareTo(minute5)) == Math.abs(minute2.compareTo(minute5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((minute1.compareTo(minute2) == 0) && minute1.equals(minute2), "equals") //$NON-NLS-1$
    );
   }

 }
