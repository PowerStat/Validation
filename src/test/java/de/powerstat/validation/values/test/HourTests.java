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

import de.powerstat.validation.values.Hour;
import de.powerstat.validation.values.Hours;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Hour tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class HourTests
 {
  /**
   * Not a hour constant.
   */
  private static final String NOT_A_HOUR = "Not a hour!"; //$NON-NLS-1$

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
  /* default */ HourTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(0, Hour.of("0").hour(), HourTests.NOT_A_HOUR);
   }


  /**
   * Is hour.
   *
   * @param hour Hour
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 23})
  /* default */ void testIsHour(final int hour)
   {
    assertEquals(hour, Hour.of(hour).hour(), HourTests.NOT_A_HOUR);
   }


  /**
   * Is not a hour.
   *
   * @param hour Hour
   */
  @ParameterizedTest
  @ValueSource(ints = {-1, 24})
  /* default */ void testIsNotAHour(final int hour)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Hour hour = */ Hour.of(hour);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    assertEquals("10", Hour.of(10).stringValue(), HourTests.NOT_A_HOUR);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
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


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd1()
   {
    final Hour hour = Hour.of(22);
    final Hours hours = Hours.of(1);
    final Hour hourResult = hour.add(hours);
    assertEquals(23, hourResult.hour(), HourTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd2()
   {
    final Hour hour = Hour.of(23);
    final Hours hours = Hours.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Hour hourResult = */ hour.add(hours);
     }, HourTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract1()
   {
    final Hour hour = Hour.of(1);
    final Hours hours = Hours.of(1);
    final Hour hourResult = hour.subtract(hours);
    assertEquals(0, hourResult.hour(), HourTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract2()
   {
    final Hour hour = Hour.of(0);
    final Hours hours = Hours.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Hour hourResult = */ hour.subtract(hours);
     }, HourTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test incement.
   */
  @Test
  /* default */ void testIncrement1()
   {
    final Hour hour = Hour.of(0);
    final Hour hourResult = hour.increment();
    assertEquals(1, hourResult.hour(), HourTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrement2()
   {
    final Hour hour = Hour.of(23);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Hour hourResult = */ hour.increment();
     }, HourTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrement1()
   {
    final Hour hour = Hour.of(1);
    final Hour hourResult = hour.decrement();
    assertEquals(0, hourResult.hour(), HourTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrement2()
   {
    final Hour hour = Hour.of(0);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Hour hourResult = */ hour.decrement();
     }, HourTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
