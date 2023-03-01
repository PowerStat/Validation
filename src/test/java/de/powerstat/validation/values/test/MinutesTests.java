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

import de.powerstat.validation.values.Minutes;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Minutes tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
public class MinutesTests
 {
  /**
   * Not a minutes constant.
   */
  private static final String NOT_A_MINUTES = "Not a minutes!"; //$NON-NLS-1$

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
  public MinutesTests()
   {
    super();
   }


  /**
   * Is minutes.
   *
   * @param minutes Minutes
   */
  @ParameterizedTest
  @ValueSource(longs = {0, 120})
  public void isMinutes(final long minutes)
   {
    assertEquals(minutes, Minutes.of(minutes).minutes(), MinutesTests.NOT_A_MINUTES);
   }


  /**
   * Is not a minutes.
   *
   * @param minutes Minutes
   */
  @ParameterizedTest
  @ValueSource(longs = {-1})
  public void isNotAMinutes(final long minutes)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Minutes minutes = */ Minutes.of(minutes);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Minutes minutes1 = Minutes.of(1);
    final Minutes minutes2 = Minutes.of(1);
    final Minutes minutes3 = Minutes.of(2);
    final Minutes minutes4 = Minutes.of(3);
    final Minutes minutes5 = Minutes.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(minutes1.compareTo(minutes2) == -minutes2.compareTo(minutes1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(minutes1.compareTo(minutes3) == -minutes3.compareTo(minutes1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((minutes4.compareTo(minutes3) > 0) && (minutes3.compareTo(minutes1) > 0) && (minutes4.compareTo(minutes1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((minutes1.compareTo(minutes2) == 0) && (Math.abs(minutes1.compareTo(minutes5)) == Math.abs(minutes2.compareTo(minutes5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((minutes1.compareTo(minutes2) == 0) && minutes1.equals(minutes2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd1()
   {
    final Minutes minutes1 = Minutes.of(1);
    final Minutes minutes2 = Minutes.of(1);
    final Minutes minutesResult = minutes1.add(minutes2);
    assertEquals(2, minutesResult.minutes(), MinutesTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd2()
   {
    final Minutes minutes1 = Minutes.of(Long.MAX_VALUE);
    final Minutes minutes2 = Minutes.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Minutes yearsResult = */ minutes1.add(minutes2);
     }, MinutesTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test substract.
   */
  @Test
  public void testSubstract1()
   {
    final Minutes minutes1 = Minutes.of(6);
    final Minutes minutes2 = Minutes.of(3);
    final Minutes minutesResult = minutes1.subtract(minutes2);
    assertEquals(3, minutesResult.minutes(), MinutesTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  public void testSubstract2()
   {
    final Minutes minutes1 = Minutes.of(3);
    final Minutes minutes2 = Minutes.of(6);
    final Minutes minutesResult = minutes1.subtract(minutes2);
    assertEquals(3, minutesResult.minutes(), MinutesTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  public void testMultiply1()
   {
    final Minutes minutes1 = Minutes.of(7);
    final Minutes minutesResult = minutes1.multiply(3);
    assertEquals(21, minutesResult.minutes(), MinutesTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  public void testMultiply2()
   {
    final Minutes minutes1 = Minutes.of(Long.MAX_VALUE / 2);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Minutes minutesResult = */ minutes1.multiply(3);
     }, MinutesTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide1()
   {
    final Minutes minutes1 = Minutes.of(10);
    final Minutes minutesResult = minutes1.divide(2);
    assertEquals(5, minutesResult.minutes(), MinutesTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide2()
   {
    final Minutes minutes1 = Minutes.of(10);
    final Minutes minutesResult = minutes1.divide(3);
    assertEquals(3, minutesResult.minutes(), MinutesTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide3()
   {
    final Minutes minutes1 = Minutes.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Minutes minutesResult = */ minutes1.divide(0);
     }, MinutesTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo1()
   {
    final Minutes minutes1 = Minutes.of(10);
    final Minutes minutesResult = minutes1.modulo(2);
    assertEquals(0, minutesResult.minutes(), MinutesTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo2()
   {
    final Minutes minutes1 = Minutes.of(10);
    final Minutes minutesResult = minutes1.modulo(3);
    assertEquals(1, minutesResult.minutes(), MinutesTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo3()
   {
    final Minutes minutes1 = Minutes.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Minutes minutesResult = */ minutes1.modulo(0);
     }, MinutesTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
