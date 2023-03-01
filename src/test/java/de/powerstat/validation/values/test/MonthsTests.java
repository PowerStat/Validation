/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.validation.values.Months;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Months tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
public class MonthsTests
 {
  /**
   * Not a months constant.
   */
  private static final String NOT_A_MONTHS = "Not a months!"; //$NON-NLS-1$

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
  public MonthsTests()
   {
    super();
   }


  /**
   * Is months.
   *
   * @param months Months
   */
  @ParameterizedTest
  @ValueSource(longs = {0, 1, 24})
  public void isMonths(final long months)
   {
    assertEquals(months, Months.of(months).months(), MonthsTests.NOT_A_MONTHS);
   }


  /**
   * Is not a months.
   *
   * @param months Months
   */
  @ParameterizedTest
  @ValueSource(longs = {-1})
  public void isNotAMonths(final long months)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Months months = */ Months.of(months);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * longValue.
   */
  @Test
  public void longValue()
   {
    assertEquals(10, Months.of(10).months(), MonthsTests.NOT_A_MONTHS);
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Months months1 = Months.of(1);
    final Months months2 = Months.of(1);
    final Months months3 = Months.of(2);
    final Months months4 = Months.of(3);
    final Months months5 = Months.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(months1.compareTo(months2) == -months2.compareTo(months1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(months1.compareTo(months3) == -months3.compareTo(months1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((months4.compareTo(months3) > 0) && (months3.compareTo(months1) > 0) && (months4.compareTo(months1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((months1.compareTo(months2) == 0) && (Math.abs(months1.compareTo(months5)) == Math.abs(months2.compareTo(months5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((months1.compareTo(months2) == 0) && months1.equals(months2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd1()
   {
    final Months months1 = Months.of(1);
    final Months months2 = Months.of(1);
    final Months monthsResult = months1.add(months2);
    assertEquals(2, monthsResult.months(), MonthsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd2()
   {
    final Months months1 = Months.of(Long.MAX_VALUE);
    final Months months2 = Months.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Months monthsResult = */ months1.add(months2);
     }, MonthsTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test substract.
   */
  @Test
  public void testSubstract1()
   {
    final Months months1 = Months.of(6);
    final Months months2 = Months.of(3);
    final Months monthsResult = months1.subtract(months2);
    assertEquals(3, monthsResult.months(), MonthsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  public void testSubstract2()
   {
    final Months months1 = Months.of(3);
    final Months months2 = Months.of(6);
    final Months monthsResult = months1.subtract(months2);
    assertEquals(3, monthsResult.months(), MonthsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  public void testMultiply1()
   {
    final Months months1 = Months.of(7);
    final Months monthsResult = months1.multiply(3);
    assertEquals(21, monthsResult.months(), MonthsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  public void testMultiply2()
   {
    final Months months1 = Months.of(Long.MAX_VALUE / 2);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Months monthsResult = */ months1.multiply(3);
     }, MonthsTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide1()
   {
    final Months months1 = Months.of(10);
    final Months monthsResult = months1.divide(2);
    assertEquals(5, monthsResult.months(), MonthsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide2()
   {
    final Months months1 = Months.of(10);
    final Months monthsResult = months1.divide(3);
    assertEquals(3, monthsResult.months(), MonthsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide3()
   {
    final Months months1 = Months.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Months yearsResult = */ months1.divide(0);
     }, MonthsTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo1()
   {
    final Months months1 = Months.of(10);
    final Months monthsResult = months1.modulo(2);
    assertEquals(0, monthsResult.months(), MonthsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo2()
   {
    final Months months1 = Months.of(10);
    final Months monthsResult = months1.modulo(3);
    assertEquals(1, monthsResult.months(), MonthsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo3()
   {
    final Months months1 = Months.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Months monthsResult = */ months1.modulo(0);
     }, MonthsTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
