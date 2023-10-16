/*
 * Copyright (C) 2021-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
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
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class MillisecondsTests
 {
  /**
   * Not milliseconds constant.
   */
  private static final String NOT_MILLISECONDS = "Not milliseconds!"; //$NON-NLS-1$

  /**
   * Result nor as expected constant.
   */
  private static final String RESULT_NOT_AS_EXPECTED = "Result not as expected"; //$NON-NLS-1$

  /**
   * Arithmetic exception expected constant.
   */
  private static final String ARITHMETIC_EXCEPTION_EXPECTED = "Arithmetic exception expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public MillisecondsTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(0, Milliseconds.of("0").longValue(), MillisecondsTests.NOT_MILLISECONDS);
   }


  /**
   * Is milliseconds.
   *
   * @param milliseconds Milliseconds
   */
  @ParameterizedTest
  @ValueSource(longs = {0, 2147483647})
  /* default */ void testIsMilliseconds(final long milliseconds)
   {
    assertEquals(milliseconds, Milliseconds.of(milliseconds).longValue(), MillisecondsTests.NOT_MILLISECONDS);
   }


  /**
   * Is not a milliseconds.
   *
   * @param milliseconds Milliseconds
   */
  @ParameterizedTest
  @ValueSource(longs = {-1})
  /* default */ void testIsNotAMilliseconds(final long milliseconds)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Milliseconds milliseconds = */ Milliseconds.of(milliseconds);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * longValue.
   */
  @Test
  /* default */ void testLongValue()
   {
    assertEquals(10, Milliseconds.of(10).longValue(), MillisecondsTests.NOT_MILLISECONDS);
   }


  /**
   * stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    assertEquals("10", Milliseconds.of(10).stringValue(), MillisecondsTests.NOT_MILLISECONDS);
   }


  /**
   * Test hash code.
   */
  @Test
  /* default */ void testHashCode()
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
  @SuppressWarnings("java:S5785")
  /* default */ void testEquals()
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
  /* default */ void testToString()
   {
    final Milliseconds milliseconds = Milliseconds.of(0);
    assertEquals("Milliseconds[milliseconds=0]", milliseconds.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
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


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd1()
   {
    final Milliseconds milliseconds1 = Milliseconds.of(1);
    final Milliseconds milliseconds2 = Milliseconds.of(1);
    final Milliseconds millisecondsResult = milliseconds1.add(milliseconds2);
    assertEquals(2, millisecondsResult.longValue(), MillisecondsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd2()
   {
    final Milliseconds milliseconds1 = Milliseconds.of(Long.MAX_VALUE);
    final Milliseconds milliseconds2 = Milliseconds.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Milliseconds millisecondsResult = */ milliseconds1.add(milliseconds2);
     }, MillisecondsTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract1()
   {
    final Milliseconds milliseconds1 = Milliseconds.of(6);
    final Milliseconds milliseconds2 = Milliseconds.of(3);
    final Milliseconds millisecondsResult = milliseconds1.subtract(milliseconds2);
    assertEquals(3, millisecondsResult.longValue(), MillisecondsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract2()
   {
    final Milliseconds milliseconds1 = Milliseconds.of(3);
    final Milliseconds milliseconds2 = Milliseconds.of(6);
    final Milliseconds millisecondsResult = milliseconds1.subtract(milliseconds2);
    assertEquals(3, millisecondsResult.longValue(), MillisecondsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  /* default */ void testMultiply1()
   {
    final Milliseconds milliseconds1 = Milliseconds.of(7);
    final Milliseconds millisecondsResult = milliseconds1.multiply(3);
    assertEquals(21, millisecondsResult.longValue(), MillisecondsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  /* default */ void testMultiply2()
   {
    final Milliseconds milliseconds1 = Milliseconds.of(Long.MAX_VALUE / 2);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Milliseconds millisecondsResult = */ milliseconds1.multiply(3);
     }, MillisecondsTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testDivide1()
   {
    final Milliseconds milliseconds1 = Milliseconds.of(10);
    final Milliseconds millisecondsResult = milliseconds1.divide(2);
    assertEquals(5, millisecondsResult.longValue(), MillisecondsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testDivide2()
   {
    final Milliseconds milliseconds1 = Milliseconds.of(10);
    final Milliseconds millisecondsResult = milliseconds1.divide(3);
    assertEquals(3, millisecondsResult.longValue(), MillisecondsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testDivide3()
   {
    final Milliseconds milliseconds1 = Milliseconds.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Milliseconds millisecondsResult = */ milliseconds1.divide(0);
     }, MillisecondsTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testModulo1()
   {
    final Milliseconds milliseconds1 = Milliseconds.of(10);
    final Milliseconds millisecondsResult =milliseconds1.modulo(2);
    assertEquals(0, millisecondsResult.longValue(), MillisecondsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testModulo2()
   {
    final Milliseconds milliseconds1 = Milliseconds.of(10);
    final Milliseconds millisecondsResult = milliseconds1.modulo(3);
    assertEquals(1, millisecondsResult.longValue(), MillisecondsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testModulo3()
   {
    final Milliseconds milliseconds1 = Milliseconds.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Milliseconds millisecondsResult = */ milliseconds1.modulo(0);
     }, MillisecondsTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
