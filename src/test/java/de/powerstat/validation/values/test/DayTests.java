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

import de.powerstat.validation.values.Day;
import de.powerstat.validation.values.Days;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Day tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class DayTests
 {
  /**
   * Result not as expected constant.
   */
  private static final String RESULT_NOT_AS_EXPECTED = "Result not as expected"; //$NON-NLS-1$

  /**
   * Arithmetic exception expected contant.
   */
  private static final String ARITHMETIC_EXCEPTION_EXPECTED = "Arithmetic exception expected"; //$NON-NLS-1$

  /**
   * 10 constant.
   */
  private static final String TEN = "10"; //$NON-NLS-1$

  /**
   * Not a day constant.
   */
  private static final String NOT_A_DAY = "Not a day!"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ DayTests()
   {
    super();
   }


  /**
   * Factory string gtest.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(10, Day.of(TEN).day(), NOT_A_DAY);
   }


  /**
   * day.
   */
  @Test
  /* default */ void testIntValue()
   {
    assertEquals(10, Day.of(10).day(), NOT_A_DAY);
   }


  /**
   * stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    assertEquals(TEN, Day.of(10).stringValue(), NOT_A_DAY);
   }


  /**
   * Is day.
   *
   * @param day Day
   */
  @ParameterizedTest
  @ValueSource(ints = {1, 31})
  /* default */ void testIsDay(final int day)
   {
    assertEquals(day, Day.of(day).day(), NOT_A_DAY);
   }


  /**
   * Is not a day.
   *
   * @param day Day
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 32})
  /* default */ void testIsNotADay(final int day)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Day day = */ Day.of(day);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Day day1 = Day.of(1);
    final Day day2 = Day.of(1);
    final Day day3 = Day.of(2);
    final Day day4 = Day.of(3);
    final Day day5 = Day.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(day1.compareTo(day2) == -day2.compareTo(day1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(day1.compareTo(day3) == -day3.compareTo(day1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((day4.compareTo(day3) > 0) && (day3.compareTo(day1) > 0) && (day4.compareTo(day1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((day1.compareTo(day2) == 0) && (Math.abs(day1.compareTo(day5)) == Math.abs(day2.compareTo(day5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((day1.compareTo(day2) == 0) && day1.equals(day2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd1()
   {
    final Day day = Day.of(30);
    final Days days = Days.of(1);
    final Day dayResult = day.add(days);
    assertEquals(31, dayResult.day(), DayTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd2()
   {
    final Day day = Day.of(31);
    final Days days = Days.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Day dayResult = */ day.add(days);
     }, DayTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract1()
   {
    final Day day = Day.of(2);
    final Days days = Days.of(1);
    final Day dayResult = day.subtract(days);
    assertEquals(1, dayResult.day(), DayTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract2()
   {
    final Day day = Day.of(1);
    final Days days = Days.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Day dayResult = */ day.subtract(days);
     }, DayTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrement1()
   {
    final Day day = Day.of(1);
    final Day dayResult = day.increment();
    assertEquals(2, dayResult.day(), DayTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrement2()
   {
    final Day day = Day.of(31);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Day dayResult = */ day.increment();
     }, DayTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrement1()
   {
    final Day day = Day.of(2);
    final Day dayResult = day.decrement();
    assertEquals(1, dayResult.day(), DayTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrement2()
   {
    final Day day = Day.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Day dayResult = */ day.decrement();
     }, DayTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
