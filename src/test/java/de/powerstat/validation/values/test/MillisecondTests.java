/*
 * Copyright (C) 2021-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
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

import de.powerstat.validation.values.Millisecond;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Millisecond tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class MillisecondTests
 {
  /**
   * Default constructor.
   */
  public MillisecondTests()
   {
    super();
   }


  /**
   * Is millisecond.
   *
   * @param millisecond Millisecond
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 999})
  public void isMilliseconds(final int millisecond)
   {
    assertEquals(millisecond, Millisecond.of(millisecond).intValue(), "Not millisecond!"); //$NON-NLS-1$
   }

  /**
   * Is not a millisecond.
   *
   * @param millisecond Millisecond
   */
  @ParameterizedTest
  @ValueSource(ints = {-1, 1000})
  public void isNotAMillisecond(final int millisecond)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Millisecond millisecond = */ Millisecond.of(millisecond);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Millisecond millisecond1 = Millisecond.of(0);
    final Millisecond millisecond2 = Millisecond.of(0);
    final Millisecond millisecond3 = Millisecond.of(1);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(millisecond1.hashCode(), millisecond2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(millisecond1.hashCode(), millisecond3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Millisecond millisecond1 = Millisecond.of(0);
    final Millisecond millisecond2 = Millisecond.of(0);
    final Millisecond millisecond3 = Millisecond.of(1);
    final Millisecond millisecond4 = Millisecond.of(0);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(millisecond1.equals(millisecond1), "millisecond11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(millisecond1.equals(millisecond2), "millisecond12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(millisecond2.equals(millisecond1), "millisecond21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(millisecond2.equals(millisecond4), "millisecond24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(millisecond1.equals(millisecond4), "millisecons14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(millisecond1.equals(millisecond3), "millisecond13 are equal"), //$NON-NLS-1$
      () -> assertFalse(millisecond3.equals(millisecond1), "millisecond31 are equal"), //$NON-NLS-1$
      () -> assertFalse(millisecond1.equals(null), "millisecond10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Millisecond millisecond = Millisecond.of(0);
    assertEquals("Millisecond[millisecond=0]", millisecond.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Millisecond millisecond1 = Millisecond.of(1);
    final Millisecond millisecond2 = Millisecond.of(1);
    final Millisecond millisecond3 = Millisecond.of(2);
    final Millisecond millisecond4 = Millisecond.of(3);
    final Millisecond millisecond5 = Millisecond.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(millisecond1.compareTo(millisecond2) == -millisecond2.compareTo(millisecond1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(millisecond1.compareTo(millisecond3) == -millisecond3.compareTo(millisecond1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((millisecond4.compareTo(millisecond3) > 0) && (millisecond3.compareTo(millisecond1) > 0) && (millisecond4.compareTo(millisecond1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((millisecond1.compareTo(millisecond2) == 0) && (Math.abs(millisecond1.compareTo(millisecond5)) == Math.abs(millisecond2.compareTo(millisecond5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((millisecond1.compareTo(millisecond2) == 0) && millisecond1.equals(millisecond2), "equals") //$NON-NLS-1$
    );
   }

 }
