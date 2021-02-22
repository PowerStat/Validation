/*
 * Copyright (C) 2021 Dipl.-Inform. Kai Hofmann. All rights reserved!
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

import de.powerstat.validation.values.Milliseconds;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Milliseconds tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class MillisecondsTests
 {
  /**
   * Default constructor.
   */
  public MillisecondsTests()
   {
    super();
   }


  /**
   * Is milliseconds.
   *
   * @param milliseconds Milliseconds
   */
  @ParameterizedTest
  @ValueSource(longs = {0, 2147483647})
  public void isMilliseconds(final long milliseconds)
   {
    assertEquals(milliseconds, Milliseconds.of(milliseconds).getMilliseconds(), "Not milliseconds!"); //$NON-NLS-1$
   }

  /**
   * Is not a milliseconds.
   *
   * @param milliseconds Milliseconds
   */
  @ParameterizedTest
  @ValueSource(longs = {-1})
  public void isNotAMilliseconds(final long milliseconds)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Milliseconds milliseconds = */ Milliseconds.of(milliseconds);
     }
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Milliseconds milliseconds1 = Milliseconds.of(0);
    final Milliseconds milliseconds2 = Milliseconds.of(0);
    final Milliseconds milliseconds3 = Milliseconds.of(1);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(milliseconds1.hashCode(), milliseconds2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(milliseconds1.hashCode(), milliseconds3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Milliseconds milliseconds1 = Milliseconds.of(0);
    final Milliseconds milliseconds2 = Milliseconds.of(0);
    final Milliseconds milliseconds3 = Milliseconds.of(1);
    final Milliseconds milliseconds4 = Milliseconds.of(0);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(milliseconds1.equals(milliseconds1), "milliseconds11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(milliseconds1.equals(milliseconds2), "milliseconds12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(milliseconds2.equals(milliseconds1), "milliseconds21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(milliseconds2.equals(milliseconds4), "milliseconds24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(milliseconds1.equals(milliseconds4), "milliseconds14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(milliseconds1.equals(milliseconds3), "milliseconds13 are equal"), //$NON-NLS-1$
      () -> assertFalse(milliseconds3.equals(milliseconds1), "milliseconds31 are equal"), //$NON-NLS-1$
      () -> assertFalse(milliseconds1.equals(null), "milliseconds10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Milliseconds milliseconds = Milliseconds.of(0);
    assertEquals("Milliseconds[milliseconds=0]", milliseconds.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Milliseconds milliseconds1 = Milliseconds.of(1);
    final Milliseconds milliseconds2 = Milliseconds.of(1);
    final Milliseconds milliseconds3 = Milliseconds.of(2);
    final Milliseconds milliseconds4 = Milliseconds.of(3);
    final Milliseconds milliseconds5 = Milliseconds.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(milliseconds1.compareTo(milliseconds2) == -milliseconds2.compareTo(milliseconds1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(milliseconds1.compareTo(milliseconds3) == -milliseconds3.compareTo(milliseconds1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((milliseconds4.compareTo(milliseconds3) > 0) && (milliseconds3.compareTo(milliseconds1) > 0) && (milliseconds4.compareTo(milliseconds1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((milliseconds1.compareTo(milliseconds2) == 0) && (Math.abs(milliseconds1.compareTo(milliseconds5)) == Math.abs(milliseconds2.compareTo(milliseconds5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((milliseconds1.compareTo(milliseconds2) == 0) && milliseconds1.equals(milliseconds2), "equals") //$NON-NLS-1$
    );
   }

 }
