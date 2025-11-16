/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import nl.jqno.equalsverifier.EqualsVerifier;

import de.powerstat.validation.values.Days;
import de.powerstat.validation.values.Weekday;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Weekday tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class WeekdayTests
 {
  /**
   * Result not as expected constant.
   */
  private static final String RESULT_NOT_AS_EXPECTED = "Result not as expected"; //$NON-NLS-1$

  /**
   * Arithmetic exception expected constant.
   */
  private static final String ARITHMETIC_EXCEPTION_EXPECTED = "Arithmetic exception expected"; //$NON-NLS-1$

  /**
   * 10 constant.
   */
  private static final String SIX = "6"; //$NON-NLS-1$

  /**
   * Not a weekday constant.
   */
  private static final String NOT_A_WEEKDAY = "Not a weekday!"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ WeekdayTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(6, Weekday.of(SIX).intValue(), NOT_A_WEEKDAY);
   }


  /**
   * intValue.
   */
  @Test
  /* default */ void testIntValue()
   {
    assertEquals(6, Weekday.of(6).intValue(), NOT_A_WEEKDAY);
   }


  /**
   * stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    assertEquals(SIX, Weekday.of(6).stringValue(), NOT_A_WEEKDAY);
   }


  /**
   * Is weekday.
   *
   * @param weekday Weekday
   */
  @ParameterizedTest
  @ValueSource(ints = {1, 7})
  /* default */ void testIsWeekday(final int weekday)
   {
    assertEquals(weekday, Weekday.of(weekday).intValue(), NOT_A_WEEKDAY);
   }


  /**
   * Is not a weekday.
   *
   * @param weekday Weekday
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 8})
  /* default */ void testIsNotAWeekday(final int weekday)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Weekday weekday = */ Weekday.of(weekday);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(Weekday.class).verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Weekday weekday = Weekday.of(1);
    assertEquals("Weekday[weekday=1]", weekday.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Weekday weekday1 = Weekday.of(1);
    final Weekday weekday2 = Weekday.of(1);
    final Weekday weekday3 = Weekday.of(2);
    final Weekday weekday4 = Weekday.of(3);
    final Weekday weekday5 = Weekday.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(weekday1.compareTo(weekday2) == -weekday2.compareTo(weekday1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(weekday1.compareTo(weekday3) == -weekday3.compareTo(weekday1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((weekday4.compareTo(weekday3) > 0) && (weekday3.compareTo(weekday1) > 0) && (weekday4.compareTo(weekday1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((weekday1.compareTo(weekday2) == 0) && (Math.abs(weekday1.compareTo(weekday5)) == Math.abs(weekday2.compareTo(weekday5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((weekday1.compareTo(weekday2) == 0) && weekday1.equals(weekday2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd1()
   {
    final Weekday weekday = Weekday.of(6);
    final Days days = Days.of(1);
    final Weekday weekdayResult = weekday.add(days);
    assertEquals(7, weekdayResult.intValue(), WeekdayTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @SuppressFBWarnings("RV_RETURN_VALUE_IGNORED_INFERRED")
  @Test
  /* default */ void testAdd2()
   {
    final Weekday weekday = Weekday.of(7);
    final Days days = Days.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Weekday weekdayResult = */ weekday.add(days);
     }, WeekdayTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract1()
   {
    final Weekday weekday = Weekday.of(2);
    final Days days = Days.of(1);
    final Weekday weekdayResult = weekday.subtract(days);
    assertEquals(1, weekdayResult.intValue(), WeekdayTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @SuppressFBWarnings("RV_RETURN_VALUE_IGNORED_INFERRED")
  @Test
  /* default */ void testSubtract2()
   {
    final Weekday weekday = Weekday.of(1);
    final Days days = Days.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Weekday weekdayResult = */ weekday.subtract(days);
     }, WeekdayTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrement1()
   {
    final Weekday weekday = Weekday.of(1);
    final Weekday weekdayResult = weekday.increment();
    assertEquals(2, weekdayResult.intValue(), WeekdayTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @SuppressFBWarnings("RV_RETURN_VALUE_IGNORED_INFERRED")
  @Test
  /* default */ void testIncrement2()
   {
    final Weekday weekday = Weekday.of(7);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Weekday weekdayResult = */ weekday.increment();
     }, WeekdayTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrement1()
   {
    final Weekday weekday = Weekday.of(2);
    final Weekday weekdayResult = weekday.decrement();
    assertEquals(1, weekdayResult.intValue(), WeekdayTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @SuppressFBWarnings("RV_RETURN_VALUE_IGNORED_INFERRED")
  @Test
  /* default */ void testDecrement2()
   {
    final Weekday weekday = Weekday.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Weekday weekdayResult = */ weekday.decrement();
     }, WeekdayTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
