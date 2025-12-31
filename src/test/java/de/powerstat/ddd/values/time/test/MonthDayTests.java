/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.time.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.powerstat.ddd.values.time.Day;
import de.powerstat.ddd.values.time.Days;
import de.powerstat.ddd.values.time.Month;
import de.powerstat.ddd.values.time.MonthDay;
import de.powerstat.ddd.values.time.Months;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Month day tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
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
   * Factory test.
   */
  @Test
  /* default */ void testOf6()
   {
    final MonthDay test = MonthDay.of(Month.of(2), Day.of(29));
    assertAll(TEST_OF,
      () -> assertEquals(2, test.month().month(), MONTH_NOT_AS_EXPECTED),
      () -> assertEquals(29, test.day().day(), DAY_NOT_AS_EXPECTED)
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
   * Test add months.
   */
  @Test
  /* default */ void testAddMonths1()
   {
    final MonthDay test1 = MonthDay.of(Month.of(11), Day.of(13));
    final MonthDay result = test1.add(Months.of(1));
    assertAll("add", //$NON-NLS-1$
      () -> assertEquals(12, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(13, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test add months.
   */
  @Test
  /* default */ void testAddMonths2()
   {
    final MonthDay test1 = MonthDay.of(Month.of(10), Day.of(13));
    final MonthDay result = test1.add(Months.of(3));
    assertAll("addMonths2", //$NON-NLS-1$
      () -> assertEquals(1, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(13, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test add months.
   */
  @Test
  /* default */ void testAddMonths3()
   {
    final MonthDay test1 = MonthDay.of(Month.of(3), Day.of(31));
    final MonthDay result = test1.add(Months.of(1));
    assertAll("addMonths3", //$NON-NLS-1$
      () -> assertEquals(4, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(30, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test subtract months.
   */
  @Test
  /* default */ void testSubtractMonths1()
   {
    final MonthDay test1 = MonthDay.of(Month.of(11), Day.of(30));
    final MonthDay result = test1.subtract(Months.of(1));
    assertAll("subtractMonths1", //$NON-NLS-1$
      () -> assertEquals(10, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(30, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test subtract months.
   */
  @Test
  /* default */ void testSubtractMonths2()
   {
    final MonthDay test1 = MonthDay.of(Month.of(11), Day.of(30));
    final MonthDay result = test1.subtract(Months.of(2));
    assertAll("subtractMonths2", //$NON-NLS-1$
      () -> assertEquals(9, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(30, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test subtract months.
   */
  @Test
  /* default */ void testSubtractMonths3()
   {
    final MonthDay test1 = MonthDay.of(Month.of(2), Day.of(13));
    final Months months = Months.of(2);
    final MonthDay result = test1.subtract(months);
    assertAll("subtractMonths2", //$NON-NLS-1$
      () -> assertEquals(12, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(13, result.day().day(), RESULT_NOT_AS_EXPECTED)
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
   * Test subtract months.
   */
  @Test
  /* default */ void testSubtractMonths4()
   {
    final MonthDay test1 = MonthDay.of(Month.of(1), Day.of(31));
    final MonthDay result = test1.subtract(Months.of(1));
    assertAll("subtractMonths3", //$NON-NLS-1$
      () -> assertEquals(12, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(31, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test increment month.
   */
  @Test
  /* default */ void testIncrementMonth1()
   {
    final MonthDay test1 = MonthDay.of(Month.of(10), Day.of(30));
    final MonthDay result = test1.incrementMonth();
    assertAll("incrementMonth1", //$NON-NLS-1$
      () -> assertEquals(11, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(30, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test increment month.
   */
  @Test
  /* default */ void testIncrementMonth2()
   {
    final MonthDay test1 = MonthDay.of(Month.of(12), Day.of(31));
    final MonthDay result = test1.incrementMonth();
    assertAll("incfrementMonth2", //$NON-NLS-1$
      () -> assertEquals(1, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(31, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test increment month.
   */
  @Test
  /* default */ void testIncrementMonth3()
   {
    final MonthDay test1 = MonthDay.of(Month.of(1), Day.of(31));
    final MonthDay result = test1.incrementMonth();
    assertAll("incrementMonth3", //$NON-NLS-1$
      () -> assertEquals(2, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(28, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test decrement month.
   */
  @Test
  /* default */ void testDecrementMonth1()
   {
    final MonthDay test1 = MonthDay.of(Month.of(12), Day.of(30));
    final MonthDay result = test1.decrementMonth();
    assertAll("add", //$NON-NLS-1$
      () -> assertEquals(11, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(30, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test decrement month.
   */
  @Test
  /* default */ void testDecrementMonth2()
   {
    final MonthDay test1 = MonthDay.of(Month.of(1), Day.of(31));
    final MonthDay result = test1.decrementMonth();
    assertAll("decrementMonth2", //$NON-NLS-1$
      () -> assertEquals(12, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(31, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test decrement month.
   */
  @Test
  /* default */ void testDecrementMonth3()
   {
    final MonthDay test1 = MonthDay.of(Month.of(12), Day.of(31));
    final MonthDay result = test1.decrementMonth();
    assertAll("decrementMonth3", //$NON-NLS-1$
      () -> assertEquals(11, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(30, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test add days.
   */
  @Test
  /* default */ void testAddDays1()
   {
    final MonthDay test1 = MonthDay.of(Month.of(11), Day.of(30));
    final MonthDay result = test1.add(Days.of(1));
    assertAll("addDays1", //$NON-NLS-1$
      () -> assertEquals(12, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(1, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test add days.
   */
  @Test
  /* default */ void testAddDays2()
   {
    final MonthDay test1 = MonthDay.of(Month.of(1), Day.of(31));
    final MonthDay result = test1.add(Days.of(1));
    assertAll("addDays2", //$NON-NLS-1$
      () -> assertEquals(2, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(1, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test add days.
   */
  @Test
  /* default */ void testAddDays3()
   {
    final MonthDay test1 = MonthDay.of(Month.of(12), Day.of(31));
    final MonthDay result = test1.add(Days.of(1));
    assertAll("addDays3", //$NON-NLS-1$
      () -> assertEquals(1, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(1, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test add days.
   */
  @Test
  /* default */ void testAddDays4()
   {
    final MonthDay test1 = MonthDay.of(Month.of(12), Day.of(30));
    final MonthDay result = test1.add(Days.of(1));
    assertAll("addDays3", //$NON-NLS-1$
      () -> assertEquals(12, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(31, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }

  /**
   * Test substract days.
   */
  @Test
  /* default */ void testSubtractDays1()
   {
    final MonthDay test1 = MonthDay.of(Month.of(1), Day.of(2));
    final MonthDay result = test1.subtract(Days.of(1));
    assertAll("subtractDays1", //$NON-NLS-1$
      () -> assertEquals(1, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(1, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test substract days.
   */
  @Test
  /* default */ void testSubtractDays2()
   {
    final MonthDay test1 = MonthDay.of(Month.of(2), Day.of(1));
    final MonthDay result = test1.subtract(Days.of(1));
    assertAll("subtractDays2", //$NON-NLS-1$
      () -> assertEquals(1, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(31, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test subtract days.
   */
  @Test
  /* default */ void testSubtractDays3()
   {
    final MonthDay test1 = MonthDay.of(Month.of(1), Day.of(1));
    final MonthDay result = test1.subtract(Days.of(1));
    assertAll("subtractDays3", //$NON-NLS-1$
      () -> assertEquals(12, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(31, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test increment day.
   */
  @Test
  /* default */ void testIncrementDay1()
   {
    final MonthDay test1 = MonthDay.of(Month.of(1), Day.of(1));
    final MonthDay result = test1.incrementDay();
    assertAll("incrementDay1", //$NON-NLS-1$
      () -> assertEquals(1, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(2, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test increment day.
   */
  @Test
  /* default */ void testIncrementDay2()
   {
    final MonthDay test1 = MonthDay.of(Month.of(1), Day.of(31));
    final MonthDay result = test1.incrementDay();
    assertAll("incrementDay2", //$NON-NLS-1$
      () -> assertEquals(2, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(1, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test increment day.
   */
  @Test
  /* default */ void testIncrementDay3()
   {
    final MonthDay test1 = MonthDay.of(Month.of(12), Day.of(31));
    final MonthDay result = test1.incrementDay();
    assertAll("incrementDay3", //$NON-NLS-1$
      () -> assertEquals(1, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(1, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test increment day.
   */
  @Test
  /* default */ void testIncrementDay4()
   {
    final MonthDay test1 = MonthDay.of(Month.of(11), Day.of(30));
    final MonthDay result = test1.incrementDay();
    assertAll("incrementDay3", //$NON-NLS-1$
      () -> assertEquals(12, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(1, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test increment day.
   */
  @Test
  /* default */ void testIncrementDay5()
   {
    final MonthDay test1 = MonthDay.of(Month.of(11), Day.of(29));
    final MonthDay result = test1.incrementDay();
    assertAll("incrementDay3", //$NON-NLS-1$
      () -> assertEquals(11, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(30, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test decrement day.
   */
  @Test
  /* default */ void testDecrementDay1()
   {
    final MonthDay test1 = MonthDay.of(Month.of(1), Day.of(2));
    final MonthDay result = test1.decrementDay();
    assertAll("decrementDay1", //$NON-NLS-1$
      () -> assertEquals(1, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(1, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test decrement day.
   */
  @Test
  /* default */ void testDecrementDay2()
   {
    final MonthDay test1 = MonthDay.of(Month.of(2), Day.of(1));
    final MonthDay result = test1.decrementDay();
    assertAll("decrementDay2", //$NON-NLS-1$
      () -> assertEquals(1, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(31, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test decrement day.
   */
  @Test
  /* default */ void testDecrementDay3()
   {
    final MonthDay test1 = MonthDay.of(Month.of(1), Day.of(1));
    final MonthDay result = test1.decrementDay();
    assertAll("decrementDay3", //$NON-NLS-1$
      () -> assertEquals(12, result.month().month(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(31, result.day().day(), RESULT_NOT_AS_EXPECTED)
    );
   }

 }
