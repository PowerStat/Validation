/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
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
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public DaysTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  public void factory1()
   {
    assertEquals(0, Days.of("0").longValue(), DaysTests.NOT_A_DAYS);
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
    assertEquals(days, Days.of(days).longValue(), DaysTests.NOT_A_DAYS);
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
   * getDays.
   *
   * @deprecated Old Version of longValue()
   */
  @Deprecated(since = DaysTests.DEPRECATED_SINCE_3_0, forRemoval = false)
  @Test
  public void getDays()
   {
    assertEquals(10, Days.of(10).getDays(), DaysTests.NOT_A_DAYS);
   }


  /**
   * longValue.
   */
  @Test
  public void longValue()
   {
    assertEquals(10, Days.of(10).longValue(), DaysTests.NOT_A_DAYS);
   }


  /**
   * stringValue.
   */
  @Test
  public void stringValue()
   {
    assertEquals("10", Days.of(10).stringValue(), DaysTests.NOT_A_DAYS);
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Days days1 = Days.of(1);
    final Days days2 = Days.of(1);
    final Days days3 = Days.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(days1.hashCode(), days2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(days1.hashCode(), days3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Days days1 = Days.of(1);
    final Days days2 = Days.of(1);
    final Days days3 = Days.of(2);
    final Days days4 = Days.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(days1.equals(days1), "days11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(days1.equals(days2), "days12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(days2.equals(days1), "days21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(days2.equals(days4), "days24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(days1.equals(days4), "days14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(days1.equals(days3), "days13 are equal"), //$NON-NLS-1$
      () -> assertFalse(days3.equals(days1), "days31 are equal"), //$NON-NLS-1$
      () -> assertFalse(days1.equals(null), "days10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Days days = Days.of(1);
    assertEquals("Days[days=1]", days.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
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
    assertEquals(2, daysResult.longValue(), DaysTests.RESULT_NOT_AS_EXPECTED);
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
    assertEquals(3, daysResult.longValue(), DaysTests.RESULT_NOT_AS_EXPECTED);
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
    assertEquals(3, daysResult.longValue(), DaysTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  public void testMultiply1()
   {
    final Days days1 = Days.of(7);
    final Days daysResult = days1.multiply(3);
    assertEquals(21, daysResult.longValue(), DaysTests.RESULT_NOT_AS_EXPECTED);
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
    assertEquals(5, daysResult.longValue(), DaysTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide2()
   {
    final Days days1 = Days.of(10);
    final Days daysResult = days1.divide(3);
    assertEquals(3, daysResult.longValue(), DaysTests.RESULT_NOT_AS_EXPECTED);
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
    assertEquals(0, daysResult.longValue(), DaysTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo2()
   {
    final Days days1 = Days.of(10);
    final Days daysResult = days1.modulo(3);
    assertEquals(1, daysResult.longValue(), DaysTests.RESULT_NOT_AS_EXPECTED);
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
