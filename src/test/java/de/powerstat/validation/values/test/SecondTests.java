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

import de.powerstat.validation.values.Second;


/**
 * Second tests.
 */
public class SecondTests
 {
  /**
   * Default constructor.
   */
  public SecondTests()
   {
    super();
   }


  /**
   * Is second.
   *
   * @param second Second
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 59, 60})
  public void isSecond(final int second)
   {
    assertEquals(second, Second.of(second).getSecond(), "Not a second!"); //$NON-NLS-1$
   }


  /**
   * Is not a second.
   *
   * @param second Second
   */
  @ParameterizedTest
  @ValueSource(ints = {-1, 61})
  public void isNotASecond(final int second)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Second second = */ Second.of(second);
     }
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Second second1 = new Second(1);
    final Second second2 = new Second(1);
    final Second second3 = new Second(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(second1.hashCode(), second2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(second1.hashCode(), second3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Second second1 = new Second(1);
    final Second second2 = new Second(1);
    final Second second3 = new Second(2);
    final Second second4 = new Second(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(second1.equals(second1), "second11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(second1.equals(second2), "second12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(second2.equals(second1), "second21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(second2.equals(second4), "second24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(second1.equals(second4), "second14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(second1.equals(second3), "second13 are equal"), //$NON-NLS-1$
      () -> assertFalse(second3.equals(second1), "second31 are equal"), //$NON-NLS-1$
      () -> assertFalse(second1.equals(null), "second10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Second second = new Second(1);
    assertEquals("Second[second=1]", second.toString(), "toString not equal"); //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Second second1 = new Second(1);
    final Second second2 = new Second(1);
    final Second second3 = new Second(2);
    final Second second4 = new Second(3);
    final Second second5 = new Second(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(second1.compareTo(second2) == -second2.compareTo(second1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(second1.compareTo(second3) == -second3.compareTo(second1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((second4.compareTo(second3) > 0) && (second3.compareTo(second1) > 0) && (second4.compareTo(second1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((second1.compareTo(second2) == 0) && (Math.abs(second1.compareTo(second5)) == Math.abs(second2.compareTo(second5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((second1.compareTo(second2) == 0) && second1.equals(second2), "equals") //$NON-NLS-1$
    );
   }

 }
