/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.Day;
import de.powerstat.validation.values.Month;
import de.powerstat.validation.values.MonthDay;
import de.powerstat.validation.values.Months;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Month day tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class MonthDayTests
 {
  /**
   * Month not as expected constant.
   */
  private static final String MONTH_NOT_AS_EXPECTED = "Month not as expected";

  /**
   * Day not as expected constant.
   */
  private static final String DAY_NOT_AS_EXPECTED = "Day not as expected";

  /**
   * Day month constant.
   */
  private static final String DAYMONTH_10_13 = "10-13";

  /**
   * Result not as expected constant.
   */
  private static final String RESULT_NOT_AS_EXPECTED = "result not as expected";

  /**
   * Test of constant.
   */
  private static final String TEST_OF = "testOf";


  /**
   * Default constructor.
   */
  /* default */ MonthDayTests()
   {
    super();
   }


  /**
   * Factory test.
   */
  @Test
  /* default */ void testOf1()
   {
    final MonthDay test = MonthDay.of(Month.of(10), Day.of(13));
    assertAll(TEST_OF,
      () -> assertEquals(10, test.month().month(), MONTH_NOT_AS_EXPECTED),
      () -> assertEquals(13, test.day().day(), DAY_NOT_AS_EXPECTED)
    );
   }


  /**
   * Factory test.
   */
  @Test
  /* default */ void testOf2()
   {
    final MonthDay test = MonthDay.of(DAYMONTH_10_13);
    assertAll(TEST_OF,
      () -> assertEquals(10, test.month().month(), MONTH_NOT_AS_EXPECTED),
      () -> assertEquals(13, test.day().day(), DAY_NOT_AS_EXPECTED)
    );
   }


  /**
   * Factory test.
   */
  @Test
  /* default */ void testOf3()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final MonthDay test = */ MonthDay.of("10");
     }, "Illegal argument exception"
    );
   }


  /**
   * Factory test.
   */
  @Test
  /* default */ void testOf4()
   {
    final MonthDay test = MonthDay.of(Month.of(2), Day.of(1));
    assertAll(TEST_OF,
      () -> assertEquals(2, test.month().month(), MONTH_NOT_AS_EXPECTED),
      () -> assertEquals(1, test.day().day(), DAY_NOT_AS_EXPECTED)
    );
   }


  /**
   * Factory test.
   */
  @Test
  /* default */ void testOf5()
   {
    final Month month = Month.of(2);
    final Day day = Day.of(30);
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final MonthDay test = */ MonthDay.of(month, day);
     }, "Index out of bounds exception"
    );
   }


  /**
   * stringValue test.
   */
  @Test
  /* default */ void testStringValue()
   {
    final MonthDay test = MonthDay.of(DAYMONTH_10_13);
    assertEquals(DAYMONTH_10_13, test.stringValue(), MONTH_NOT_AS_EXPECTED);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final MonthDay test1 = MonthDay.of(Month.of(10), Day.of(13));
    final MonthDay test2 = MonthDay.of(Month.of(10), Day.of(13));
    final MonthDay test3 = MonthDay.of(Month.of(10), Day.of(14));
    final MonthDay test4 = MonthDay.of(Month.of(11), Day.of(13));
    final MonthDay test5 = MonthDay.of(Month.of(10), Day.of(13));
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(test1.compareTo(test2) == -test2.compareTo(test1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(test1.compareTo(test3) == -test3.compareTo(test1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((test4.compareTo(test3) > 0) && (test3.compareTo(test1) > 0) && (test4.compareTo(test1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((test1.compareTo(test2) == 0) && (Math.abs(test1.compareTo(test5)) == Math.abs(test2.compareTo(test5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((test1.compareTo(test2) == 0) && test1.equals(test2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd1()
   {
    final MonthDay test1 = MonthDay.of(Month.of(10), Day.of(13));
    final MonthDay result = test1.add(Months.of(1));
    assertAll("add", //$NON-NLS-1$
      () -> assertEquals(11, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(13, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd2()
   {
    final MonthDay test1 = MonthDay.of(Month.of(10), Day.of(13));
    final Months months = Months.of(3);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final MonthDay result = */ test1.add(months);
     }, "Arithmetic exception"
    );
   }


  /**
   * Test sutract.
   */
  @Test
  /* default */ void testSubtract1()
   {
    final MonthDay test1 = MonthDay.of(Month.of(10), Day.of(13));
    final MonthDay result = test1.subtract(Months.of(1));
    assertAll("subtract", //$NON-NLS-1$
      () -> assertEquals(9, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(13, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract2()
   {
    final MonthDay test1 = MonthDay.of(Month.of(2), Day.of(13));
    final Months months = Months.of(2);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final MonthDay result = */ test1.subtract(months);
     }, "Arithmetic exception"
    );
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrement1()
   {
    final MonthDay test1 = MonthDay.of(Month.of(10), Day.of(13));
    final MonthDay result = test1.incrementMonth();
    assertAll("add", //$NON-NLS-1$
      () -> assertEquals(11, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(13, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrement2()
   {
    final MonthDay test1 = MonthDay.of(Month.of(12), Day.of(13));
    assertThrows(ArithmeticException.class, () ->
     {
      /* final MonthDay result = */ test1.incrementMonth();
     }, "Arithmetic exception"
    );
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrement1()
   {
    final MonthDay test1 = MonthDay.of(Month.of(10), Day.of(13));
    final MonthDay result = test1.decrementMonth();
    assertAll("add", //$NON-NLS-1$
      () -> assertEquals(9, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(13, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrement2()
   {
    final MonthDay test1 = MonthDay.of(Month.of(1), Day.of(13));
    assertThrows(ArithmeticException.class, () ->
     {
      /* final MonthDay result = */ test1.decrementMonth();
     }, "Arithmetic exception"
    );
   }

 }
