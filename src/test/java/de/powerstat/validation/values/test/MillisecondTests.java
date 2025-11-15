/*
 * Copyright (C) 2021-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.validation.values.Millisecond;
import de.powerstat.validation.values.Milliseconds;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Millisecond tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class MillisecondTests
 {
  /**
   * Not millisecond constant.
   */
  private static final String NOT_MILLISECOND = "Not millisecond!"; //$NON-NLS-1$

  /**
   * Result not as expected constant.
   */
  private static final String RESULT_NOT_AS_EXPECTED = "Result not as expected"; //$NON-NLS-1$

  /**
   * Arithmetic exception expected constant.
   */
  private static final String ARITHMETIC_EXCEPTION_EXPECTED = "Arithmetic exception expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ MillisecondTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFatory1()
   {
    assertEquals(0, Millisecond.of("0").millisecond(), MillisecondTests.NOT_MILLISECOND);
   }


  /**
   * Is millisecond.
   *
   * @param millisecond Millisecond
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 999})
  /* default */ void testIsMilliseconds(final int millisecond)
   {
    assertEquals(millisecond, Millisecond.of(millisecond).millisecond(), MillisecondTests.NOT_MILLISECOND);
   }


  /**
   * Is not a millisecond.
   *
   * @param millisecond Millisecond
   */
  @ParameterizedTest
  @ValueSource(ints = {-1, 1000})
  /* default */ void testIsNotAMillisecond(final int millisecond)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Millisecond millisecond = */ Millisecond.of(millisecond);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * intValue.
   */
  @Test
  /* default */ void testIntValue()
   {
    assertEquals(10, Millisecond.of(10).millisecond(), MillisecondTests.NOT_MILLISECOND);
   }


  /**
   * stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    assertEquals("10", Millisecond.of(10).stringValue(), MillisecondTests.NOT_MILLISECOND);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
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


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd1()
   {
    final Millisecond millisecond = Millisecond.of(998);
    final Milliseconds milliseconds = Milliseconds.of(1);
    final Millisecond millisecondResult = millisecond.add(milliseconds);
    assertEquals(999, millisecondResult.millisecond(), MillisecondTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd2()
   {
    final Millisecond millisecond = Millisecond.of(999);
    final Milliseconds milliseconds = Milliseconds.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Millisecond millisecondResult = */ millisecond.add(milliseconds);
     }, MillisecondTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract1()
   {
    final Millisecond millisecond = Millisecond.of(1);
    final Milliseconds milliseconds = Milliseconds.of(1);
    final Millisecond millisecondResult = millisecond.subtract(milliseconds);
    assertEquals(0, millisecondResult.millisecond(), MillisecondTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract2()
   {
    final Millisecond millisecond = Millisecond.of(0);
    final Milliseconds milliseconds = Milliseconds.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Millisecond millisecondResult = */ millisecond.subtract(milliseconds);
     }, MillisecondTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testIncrement1()
   {
    final Millisecond millisecond = Millisecond.of(0);
    final Millisecond millisecondResult = millisecond.increment();
    assertEquals(1, millisecondResult.millisecond(), MillisecondTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testIncrement2()
   {
    final Millisecond millisecond = Millisecond.of(999);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Millisecond millisecondResult = */ millisecond.increment();
     }, MillisecondTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testDecrement1()
   {
    final Millisecond millisecond = Millisecond.of(2);
    final Millisecond millisecondResult = millisecond.decrement();
    assertEquals(1, millisecondResult.millisecond(), MillisecondTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testDecrement2()
   {
    final Millisecond millisecond = Millisecond.of(0);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Millisecond millisecondResult = */ millisecond.decrement();
     }, MillisecondTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
