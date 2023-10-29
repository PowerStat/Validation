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
      () -> assertEquals(10, test.monthValue().intValue(), MONTH_NOT_AS_EXPECTED),
      () -> assertEquals(13, test.dayValue().intValue(), DAY_NOT_AS_EXPECTED)
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
      () -> assertEquals(10, test.monthValue().intValue(), MONTH_NOT_AS_EXPECTED),
      () -> assertEquals(13, test.dayValue().intValue(), DAY_NOT_AS_EXPECTED)
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
      () -> assertEquals(2, test.monthValue().intValue(), MONTH_NOT_AS_EXPECTED),
      () -> assertEquals(1, test.dayValue().intValue(), DAY_NOT_AS_EXPECTED)
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
   * Test hash code.
   */
  @Test
  /* default */ void testHashCode()
   {
    final MonthDay test1 = MonthDay.of(Month.of(10), Day.of(13));
    final MonthDay test2 = MonthDay.of(Month.of(10), Day.of(13));
    final MonthDay test3 = MonthDay.of(Month.of(10), Day.of(14));
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(test1.hashCode(), test2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(test1.hashCode(), test3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testEquals()
   {
    final MonthDay test1 = MonthDay.of(Month.of(10), Day.of(13));
    final MonthDay test2 = MonthDay.of(Month.of(10), Day.of(13));
    final MonthDay test3 = MonthDay.of(Month.of(10), Day.of(14));
    final MonthDay test4 = MonthDay.of(Month.of(10), Day.of(13));
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(test1.equals(test1), "test11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(test1.equals(test2), "test12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(test2.equals(test1), "test21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(test2.equals(test4), "test24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(test1.equals(test4), "test14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(test1.equals(test3), "test13 are equal"), //$NON-NLS-1$
      () -> assertFalse(test3.equals(test1), "test31 are equal"), //$NON-NLS-1$
      () -> assertFalse(test1.equals(null), "test10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * toString test.
   */
  @Test
  /* default */ void testToString()
   {
    final MonthDay test = MonthDay.of(DAYMONTH_10_13);
    assertEquals("MonthDay[month=Month[month=10], day=Day[day=13]]", test.toString(), "toString not as expected");
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
      () -> assertEquals(11, result.monthValue().intValue(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(13, result.dayValue().intValue(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testSubtract1()
   {
    final MonthDay test1 = MonthDay.of(Month.of(10), Day.of(13));
    final MonthDay result = test1.subtract(Months.of(1));
    assertAll("subtract", //$NON-NLS-1$
      () -> assertEquals(9, result.monthValue().intValue(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(13, result.dayValue().intValue(), RESULT_NOT_AS_EXPECTED)
    );
   }

 }
