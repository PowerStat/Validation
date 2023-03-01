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

import de.powerstat.validation.values.Days;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Days tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
public class DaysTests
 {
  /**
   * Not a days constant.
   */
  private static final String NOT_A_DAYS = "Not a days!"; //$NON-NLS-1$

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
  public DaysTests()
   {
    super();
   }


  /**
   * Is days.
   *
   * @param days Days
   */
  @ParameterizedTest
  @ValueSource(longs = {0, 1, 7, 30, 365})
  public void isDays(final long days)
   {
    assertEquals(days, Days.of(days).days(), DaysTests.NOT_A_DAYS);
   }


  /**
   * Is not a days.
   *
   * @param days Days
   */
  @ParameterizedTest
  @ValueSource(longs = {-1, -7, -30, -365})
  public void isNotADays(final long days)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Days days = */ Days.of(days);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Days days1 = Days.of(1);
    final Days days2 = Days.of(1);
    final Days days3 = Days.of(2);
    final Days days4 = Days.of(3);
    final Days days5 = Days.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(days1.compareTo(days2) == -days2.compareTo(days1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(days1.compareTo(days3) == -days3.compareTo(days1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((days4.compareTo(days3) > 0) && (days3.compareTo(days1) > 0) && (days4.compareTo(days1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((days1.compareTo(days2) == 0) && (Math.abs(days1.compareTo(days5)) == Math.abs(days2.compareTo(days5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((days1.compareTo(days2) == 0) && days1.equals(days2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd1()
   {
    final Days days1 = Days.of(1);
    final Days days2 = Days.of(1);
    final Days daysResult = days1.add(days2);
    assertEquals(2, daysResult.days(), DaysTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd2()
   {
    final Days days1 = Days.of(Long.MAX_VALUE);
    final Days days2 = Days.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Days daysResult = */ days1.add(days2);
     }, DaysTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test substract.
   */
  @Test
  public void testSubstract1()
   {
    final Days days1 = Days.of(6);
    final Days days2 = Days.of(3);
    final Days daysResult = days1.subtract(days2);
    assertEquals(3, daysResult.days(), DaysTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  public void testSubstract2()
   {
    final Days days1 = Days.of(3);
    final Days days2 = Days.of(6);
    final Days daysResult = days1.subtract(days2);
    assertEquals(3, daysResult.days(), DaysTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  public void testMultiply1()
   {
    final Days days1 = Days.of(7);
    final Days daysResult = days1.multiply(3);
    assertEquals(21, daysResult.days(), DaysTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  public void testMultiply2()
   {
    final Days days1 = Days.of(Long.MAX_VALUE / 2);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Days daysResult = */ days1.multiply(3);
     }, DaysTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide1()
   {
    final Days days1 = Days.of(10);
    final Days daysResult = days1.divide(2);
    assertEquals(5, daysResult.days(), DaysTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide2()
   {
    final Days days1 = Days.of(10);
    final Days daysResult = days1.divide(3);
    assertEquals(3, daysResult.days(), DaysTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide3()
   {
    final Days days1 = Days.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Days daysResult = */ days1.divide(0);
     }, DaysTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo1()
   {
    final Days days1 = Days.of(10);
    final Days daysResult = days1.modulo(2);
    assertEquals(0, daysResult.days(), DaysTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo2()
   {
    final Days days1 = Days.of(10);
    final Days daysResult = days1.modulo(3);
    assertEquals(1, daysResult.days(), DaysTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo3()
   {
    final Days days1 = Days.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Days daysResult = */ days1.modulo(0);
     }, DaysTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
