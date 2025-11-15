/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.validation.values.Minute;
import de.powerstat.validation.values.Minutes;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Minute tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class MinuteTests
 {
  /**
   * Not a minute constant.
   */
  private static final String NOT_A_MINUTE = "Not a minute!"; //$NON-NLS-1$

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
  /* default */ MinuteTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(0, Minute.of("0").minute(), MinuteTests.NOT_A_MINUTE);
   }


  /**
   * Is minute.
   *
   * @param minute Minute
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 59})
  /* default */ void testIsMinute(final int minute)
   {
    assertEquals(minute, Minute.of(minute).minute(), MinuteTests.NOT_A_MINUTE);
   }


  /**
   * Is not a minute.
   *
   * @param minute Minute
   */
  @ParameterizedTest
  @ValueSource(ints = {-1, 60})
  /* default */ void testIsNotAMinute(final int minute)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Minute minute = */ Minute.of(minute);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * minute.
   */
  @Test
  /* default */ void testIntValue()
   {
    assertEquals(10, Minute.of(10).minute(), MinuteTests.NOT_A_MINUTE);
   }


  /**
   * stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    assertEquals("10", Minute.of(10).stringValue(), MinuteTests.NOT_A_MINUTE);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
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


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd1()
   {
    final Minute minute = Minute.of(58);
    final Minutes minutes = Minutes.of(1);
    final Minute minuteResult = minute.add(minutes);
    assertEquals(59, minuteResult.minute(), MinuteTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd2()
   {
    final Minute minute = Minute.of(59);
    final Minutes minutes = Minutes.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Minute minuteResult = */ minute.add(minutes);
     }, MinuteTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract1()
   {
    final Minute minute = Minute.of(1);
    final Minutes minutes = Minutes.of(1);
    final Minute minuteResult = minute.subtract(minutes);
    assertEquals(0, minuteResult.minute(), MinuteTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract2()
   {
    final Minute minute = Minute.of(0);
    final Minutes minutes = Minutes.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Minute minuteResult = */ minute.subtract(minutes);
     }, MinuteTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrement1()
   {
    final Minute minute = Minute.of(1);
    final Minute minuteResult = minute.increment();
    assertEquals(2, minuteResult.minute(), MinuteTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrement2()
   {
    final Minute minute = Minute.of(59);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Minute minuteResult = */ minute.increment();
     }, MinuteTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrement1()
   {
    final Minute minute = Minute.of(2);
    final Minute minuteResult = minute.decrement();
    assertEquals(1, minuteResult.minute(), MinuteTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrement2()
   {
    final Minute minute = Minute.of(0);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Minute minuteResult = */ minute.decrement();
     }, MinuteTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
