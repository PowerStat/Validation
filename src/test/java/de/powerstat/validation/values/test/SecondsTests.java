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

import de.powerstat.validation.values.Seconds;


/**
 * Seconds tests,
 */
public class SecondsTests
 {
  /**
   * Default constructor.
   */
  public SecondsTests()
   {
    super();
   }


  /**
   * Is seconds.
   *
   * @param seconds Seconds
   */
  @ParameterizedTest
  @ValueSource(longs = {0, 120})
  public void isSeconds(final long seconds)
   {
    assertEquals(seconds, Seconds.of(seconds).getSeconds(), "Not a seconds!"); //$NON-NLS-1$
   }


  /**
   * Is not a seconds.
   *
   * @param seconds Seconds
   */
  @ParameterizedTest
  @ValueSource(longs = {-1})
  public void isNotASeconds(final long seconds)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Seconds seconds = */ Seconds.of(seconds);
     }
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Seconds seconds1 = new Seconds(1);
    final Seconds seconds2 = new Seconds(1);
    final Seconds seconds3 = new Seconds(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(seconds1.hashCode(), seconds2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(seconds1.hashCode(), seconds3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Seconds seconds1 = new Seconds(1);
    final Seconds seconds2 = new Seconds(1);
    final Seconds seconds3 = new Seconds(2);
    final Seconds seconds4 = new Seconds(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(seconds1.equals(seconds1), "seconds11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(seconds1.equals(seconds2), "seconds12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(seconds2.equals(seconds1), "seconds21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(seconds2.equals(seconds4), "seconds24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(seconds1.equals(seconds4), "seconds14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(seconds1.equals(seconds3), "seconds13 are equal"), //$NON-NLS-1$
      () -> assertFalse(seconds3.equals(seconds1), "seconds31 are equal"), //$NON-NLS-1$
      () -> assertFalse(seconds1.equals(null), "seconds10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Seconds seconds = new Seconds(1);
    assertEquals("Seconds[seconds=1]", seconds.toString(), "toString not equal"); //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Seconds seconds1 = new Seconds(1);
    final Seconds seconds2 = new Seconds(1);
    final Seconds seconds3 = new Seconds(2);
    final Seconds seconds4 = new Seconds(3);
    final Seconds seconds5 = new Seconds(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(seconds1.compareTo(seconds2) == -seconds2.compareTo(seconds1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(seconds1.compareTo(seconds3) == -seconds3.compareTo(seconds1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((seconds4.compareTo(seconds3) > 0) && (seconds3.compareTo(seconds1) > 0) && (seconds4.compareTo(seconds1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((seconds1.compareTo(seconds2) == 0) && (Math.abs(seconds1.compareTo(seconds5)) == Math.abs(seconds2.compareTo(seconds5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((seconds1.compareTo(seconds2) == 0) && seconds1.equals(seconds2), "equals") //$NON-NLS-1$
    );
   }

 }
