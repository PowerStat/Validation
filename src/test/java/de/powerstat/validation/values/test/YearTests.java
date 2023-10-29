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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.validation.values.CalendarSystems;
import de.powerstat.validation.values.Days;
import de.powerstat.validation.values.Months;
import de.powerstat.validation.values.Year;
import de.powerstat.validation.values.Years;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Year tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class YearTests
 {
  /**
   * Result nor as expecte constant.
   */
  private static final String RESULT_NOT_AS_EXPECTED = "Result not as expected"; //$NON-NLS-1$

  /**
   * Arithmetic exception expected constant.
   */
  private static final String ARITHMETIC_EXCEPTION_EXPECTED = "Arithmetic exception expected"; //$NON-NLS-1$

  /**
   * 10 constant.
   */
  private static final String TEN = "10"; //$NON-NLS-1$

  /**
   * Not a year constant.
   */
  private static final String NOT_A_YEAR = "Not a year!"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ YearTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(10, Year.of(TEN).longValue(), NOT_A_YEAR);
   }


  /**
   * longValue.
   */
  @Test
  /* default */ void testLongValue()
   {
    assertEquals(10, Year.of(10).longValue(), NOT_A_YEAR);
   }


  /**
   * stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    assertEquals(TEN, Year.of(10).stringValue(), NOT_A_YEAR);
   }


  /**
   * Is year.
   *
   * @param year Year
   */
  @ParameterizedTest
  @ValueSource(longs = {-1, 1, 2020})
  /* default */ void testIsYear(final long year)
   {
    assertEquals(year, Year.of(year).longValue(), NOT_A_YEAR);
   }


  /**
   * Is not a year.
   *
   * @param year Year
   */
  @ParameterizedTest
  @ValueSource(longs = {0})
  /* default */ void testIsNotAYear(final long year)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Year year = */ Year.of(year);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test hash code.
   */
  @Test
  /* default */ void testHashCode()
   {
    final Year year1 = Year.of(1);
    final Year year2 = Year.of(1);
    final Year year3 = Year.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(year1.hashCode(), year2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(year1.hashCode(), year3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testEquals()
   {
    final Year year1 = Year.of(1);
    final Year year2 = Year.of(1);
    final Year year3 = Year.of(2);
    final Year year4 = Year.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(year1.equals(year1), "year11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(year1.equals(year2), "year12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(year2.equals(year1), "year21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(year2.equals(year4), "year24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(year1.equals(year4), "year14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(year1.equals(year3), "year13 are equal"), //$NON-NLS-1$
      () -> assertFalse(year3.equals(year1), "year31 are equal"), //$NON-NLS-1$
      () -> assertFalse(year1.equals(null), "year10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Year year = Year.of(1);
    assertEquals("Year[calendarSystem=GREGORIAN, year=1]", year.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo1()
   {
    final Year year1 = Year.of(1);
    final Year year2 = Year.of(1);
    final Year year3 = Year.of(2);
    final Year year4 = Year.of(3);
    final Year year5 = Year.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(year1.compareTo(year2) == -year2.compareTo(year1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(year1.compareTo(year3) == -year3.compareTo(year1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((year4.compareTo(year3) > 0) && (year3.compareTo(year1) > 0) && (year4.compareTo(year1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((year1.compareTo(year2) == 0) && (Math.abs(year1.compareTo(year5)) == Math.abs(year2.compareTo(year5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((year1.compareTo(year2) == 0) && year1.equals(year2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo2()
   {
    final Year year1 = Year.of(CalendarSystems.JULIAN, 1582);
    final Year year2 = Year.of(CalendarSystems.GREGORIAN, 1582);
    assertThrows(IllegalStateException.class, () ->
     {
      year1.compareTo(year2);
     }, "Illegal state exception"
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd1()
   {
    final Year year = Year.of(2022);
    final Years years = Years.of(1);
    final Year yearResult = year.add(years);
    assertEquals(2023, yearResult.longValue(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd2()
   {
    final Year year = Year.of(-1);
    final Years years = Years.of(1);
    final Year yearResult = year.add(years);
    assertEquals(1, yearResult.longValue(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd3()
   {
    final Year year = Year.of(Long.MAX_VALUE);
    final Years years = Years.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Year yearResult = */ year.add(years);
     }, YearTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd4()
   {
    final Year year = Year.of(-2);
    final Years years = Years.of(1);
    final Year yearResult = year.add(years);
    assertEquals(-1, yearResult.longValue(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract1()
   {
    final Year year = Year.of(2022);
    final Years years = Years.of(1);
    final Year yearResult = year.subtract(years);
    assertEquals(2021, yearResult.longValue(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract2()
   {
    final Year year = Year.of(1);
    final Years years = Years.of(1);
    final Year yearResult = year.subtract(years);
    assertEquals(-1, yearResult.longValue(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract3()
   {
    final Year year = Year.of(Long.MIN_VALUE);
    final Years years = Years.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Year yearResult = */ year.subtract(years);
     }, YearTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract4()
   {
    final Year year = Year.of(-1);
    final Years years = Years.of(1);
    final Year yearResult = year.subtract(years);
    assertEquals(-2, yearResult.longValue(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test incfrement.
   */
  @Test
  /* default */ void testIncrement1()
   {
    final Year year = Year.of(2022);
    final Year yearResult = year.increment();
    assertEquals(2023, yearResult.longValue(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrement2()
   {
    final Year year = Year.of(-1);
    final Year yearResult = year.increment();
    assertEquals(1, yearResult.longValue(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrement3()
   {
    final Year year = Year.of(Long.MAX_VALUE);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Year yearResult = */ year.increment();
     }, YearTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrement1()
   {
    final Year year = Year.of(2022);
    final Year yearResult = year.decrement();
    assertEquals(2021, yearResult.longValue(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrement2()
   {
    final Year year = Year.of(1);
    final Year yearResult = year.decrement();
    assertEquals(-1, yearResult.longValue(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrement3()
   {
    final Year year = Year.of(Long.MIN_VALUE);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Year yearResult = */ year.decrement();
     }, YearTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test monthsWithin.
   */
  @Test
  /* default */ void testMonthWithin()
   {
    final Year year = Year.of(1);
    final Months result = year.monthsWithin();
    assertEquals(12, result.longValue(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test isLepaYear.
   */
  @Test
  /* default */ void testIsLeapYear1()
   {
    final Year year = Year.of(CalendarSystems.JULIAN, 4);
    final boolean result = year.isLeapYear();
    assertTrue(result, YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test isLepaYear.
   *
   * @param pYear Year
   */
  @ParameterizedTest
  @ValueSource(longs = {2000, 1500, 2004})
  /* default */ void testIsLeapYear2(final long pYear)
   {
    final Year year = Year.of(CalendarSystems.GREGORIAN, pYear);
    final boolean result = year.isLeapYear();
    assertTrue(result, YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test isLepaYear.
   */
  @Test
  /* default */ void testIsLeapYear5()
   {
    final Year year = Year.of(CalendarSystems.GREGORIAN, 2001);
    final boolean result = year.isLeapYear();
    assertFalse(result, YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test isLepaYear.
   */
  @Test
  /* default */ void testIsLeapYear7()
   {
    final Year year = Year.of(CalendarSystems.JULIAN, -1);
    final boolean result = year.isLeapYear();
    assertTrue(result, YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test isLepaYear.
   */
  @Test
  /* default */ void testIsLeapYear8()
   {
    final Year year = Year.of(CalendarSystems.JULIAN, -2);
    final boolean result = year.isLeapYear();
    assertFalse(result, YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test daysWithin.
   *
   * @param pYear Year
   * @param pDays Number of days in year
   */
  @ParameterizedTest
  @CsvSource({"2000,366", "2001,365", "1582,355"})
  /* default */ void testDaysWithin1(final long pYear, final long pDays)
   {
    final Year year = Year.of(CalendarSystems.GREGORIAN, pYear);
    final Days days = year.daysWithin();
    assertEquals(pDays, days.longValue(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test daysWithin.
   */
  @Test
  /* default */ void testDaysWithin4()
   {
    final Year year = Year.of(CalendarSystems.JULIAN, 2000);
    final Days days = year.daysWithin();
    assertEquals(366, days.longValue(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test daysWithin.
   */
  @Test
  /* default */ void testDaysWithin5()
   {
    final Year year = Year.of(CalendarSystems.JULIAN, 2001);
    final Days days = year.daysWithin();
    assertEquals(365, days.longValue(), YearTests.RESULT_NOT_AS_EXPECTED);
   }

 }
