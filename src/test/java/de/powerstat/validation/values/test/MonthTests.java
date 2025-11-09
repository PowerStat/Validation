/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
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
import nl.jqno.equalsverifier.*;

import de.powerstat.validation.values.Month;
import de.powerstat.validation.values.Months;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Month tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class MonthTests
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
  private static final String TEN = "10"; //$NON-NLS-1$

  /**
   * Not a month constant.
   */
  private static final String NOT_A_MONTH = "Not a month!"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ MonthTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(10, Month.of(TEN).intValue(), NOT_A_MONTH);
   }


  /**
   * intValue.
   */
  @Test
  /* default */ void testIntValue()
   {
    assertEquals(10, Month.of(10).intValue(), NOT_A_MONTH);
   }


  /**
   * stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    assertEquals(TEN, Month.of(10).stringValue(), NOT_A_MONTH);
   }


  /**
   * Is month.
   *
   * @param month Month
   */
  @ParameterizedTest
  @ValueSource(ints = {1, 12})
  /* default */ void testIsMonth(final int month)
   {
    assertEquals(month, Month.of(month).intValue(), NOT_A_MONTH);
   }


  /**
   * Is not a month.
   *
   * @param month Month
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 13})
  /* default */ void testIsNotAMonth(final int month)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Month month = */ Month.of(month);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(Month.class).verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Month month = Month.of(1);
    assertEquals("Month[month=1]", month.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Month month1 = Month.of(1);
    final Month month2 = Month.of(1);
    final Month month3 = Month.of(2);
    final Month month4 = Month.of(3);
    final Month month5 = Month.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(month1.compareTo(month2) == -month2.compareTo(month1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(month1.compareTo(month3) == -month3.compareTo(month1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((month4.compareTo(month3) > 0) && (month3.compareTo(month1) > 0) && (month4.compareTo(month1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((month1.compareTo(month2) == 0) && (Math.abs(month1.compareTo(month5)) == Math.abs(month2.compareTo(month5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((month1.compareTo(month2) == 0) && month1.equals(month2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd1()
   {
    final Month month = Month.of(11);
    final Months months = Months.of(1);
    final Month monthResult = month.add(months);
    assertEquals(12, monthResult.intValue(), MonthTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd2()
   {
    final Month month = Month.of(12);
    final Months months = Months.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Month monthResult = */ month.add(months);
     }, MonthTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract1()
   {
    final Month month = Month.of(2);
    final Months months = Months.of(1);
    final Month monthResult = month.subtract(months);
    assertEquals(1, monthResult.intValue(), MonthTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract2()
   {
    final Month month = Month.of(1);
    final Months months = Months.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Month monthResult = */ month.subtract(months);
     }, MonthTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrement1()
   {
    final Month month = Month.of(1);
    final Month monthResult = month.increment();
    assertEquals(2, monthResult.intValue(), MonthTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrement2()
   {
    final Month month = Month.of(12);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Month monthResult = */ month.increment();
     }, MonthTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrement1()
   {
    final Month month = Month.of(2);
    final Month monthResult = month.decrement();
    assertEquals(1, monthResult.intValue(), MonthTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrement2()
   {
    final Month month = Month.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Month monthResult = */ month.decrement();
     }, MonthTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
