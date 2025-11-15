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
import nl.jqno.equalsverifier.*;
import de.powerstat.validation.values.Days;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Days tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class DaysTests
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
  /* default */ DaysTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
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
  /* default */ void testIsDays(final long days)
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
  /* default */ void testIsNotADays(final long days)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Days days = */ Days.of(days);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * longValue.
   */
  @Test
  /* default */ void testLongValue()
   {
    assertEquals(10, Days.of(10).longValue(), DaysTests.NOT_A_DAYS);
   }


  /**
   * stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    assertEquals("10", Days.of(10).stringValue(), DaysTests.NOT_A_DAYS);
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(Days.class).verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Days days = Days.of(1);
    assertEquals("Days[days=1]", days.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
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
  /* default */ void testAdd1()
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
  /* default */ void testAdd2()
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
  /* default */ void testSubstract1()
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
  /* default */ void testSubstract2()
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
  /* default */ void testMultiply1()
   {
    final Days days1 = Days.of(7);
    final Days daysResult = days1.multiply(3);
    assertEquals(21, daysResult.longValue(), DaysTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  /* default */ void testMultiply2()
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
  /* default */ void testDivide1()
   {
    final Days days1 = Days.of(10);
    final Days daysResult = days1.divide(2);
    assertEquals(5, daysResult.longValue(), DaysTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testDivide2()
   {
    final Days days1 = Days.of(10);
    final Days daysResult = days1.divide(3);
    assertEquals(3, daysResult.longValue(), DaysTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testDivide3()
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
  /* default */ void testModulo1()
   {
    final Days days1 = Days.of(10);
    final Days daysResult = days1.modulo(2);
    assertEquals(0, daysResult.longValue(), DaysTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testModulo2()
   {
    final Days days1 = Days.of(10);
    final Days daysResult = days1.modulo(3);
    assertEquals(1, daysResult.longValue(), DaysTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testModulo3()
   {
    final Days days1 = Days.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Days daysResult = */ days1.modulo(0);
     }, DaysTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
