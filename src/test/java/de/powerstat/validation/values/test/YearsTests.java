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

import de.powerstat.validation.values.Years;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Years tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
public class YearsTests
 {
  /**
   * Not a years constant.
   */
  private static final String NOT_A_YEARS = "Not a years!"; //$NON-NLS-1$

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
  public YearsTests()
   {
    super();
   }


  /**
   * Is years.
   *
   * @param years Years
   */
  @ParameterizedTest
  @ValueSource(longs = {0, 20})
  public void isYears(final long years)
   {
    assertEquals(years, Years.of(years).longValue(), YearsTests.NOT_A_YEARS);
   }


  /**
   * Is not a years.
   *
   * @param years Years
   */
  @ParameterizedTest
  @ValueSource(longs = {-1})
  public void isNotAYears(final long years)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Years years = */ Years.of(years);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * getYears.
   *
   * @deprecated Old version of longValue()
   */
  @Deprecated(since = YearsTests.DEPRECATED_SINCE_3_0, forRemoval = false)
  @Test
  public void getYears()
   {
    assertEquals(10, Years.of(10).getYears(), YearsTests.NOT_A_YEARS);
   }


  /**
   * longValue.
   */
  @Test
  public void longValue()
   {
    assertEquals(10, Years.of(10).longValue(), YearsTests.NOT_A_YEARS);
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Years years1 = Years.of(1);
    final Years years2 = Years.of(1);
    final Years years3 = Years.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(years1.hashCode(), years2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(years1.hashCode(), years3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Years years1 = Years.of(1);
    final Years years2 = Years.of(1);
    final Years years3 = Years.of(2);
    final Years years4 = Years.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(years1.equals(years1), "years11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(years1.equals(years2), "years12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(years2.equals(years1), "years21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(years2.equals(years4), "years24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(years1.equals(years4), "years14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(years1.equals(years3), "years13 are equal"), //$NON-NLS-1$
      () -> assertFalse(years3.equals(years1), "years31 are equal"), //$NON-NLS-1$
      () -> assertFalse(years1.equals(null), "years10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Years years = Years.of(1);
    assertEquals("Years[years=1]", years.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Years years1 = Years.of(1);
    final Years years2 = Years.of(1);
    final Years years3 = Years.of(2);
    final Years years4 = Years.of(3);
    final Years years5 = Years.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(years1.compareTo(years2) == -years2.compareTo(years1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(years1.compareTo(years3) == -years3.compareTo(years1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((years4.compareTo(years3) > 0) && (years3.compareTo(years1) > 0) && (years4.compareTo(years1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((years1.compareTo(years2) == 0) && (Math.abs(years1.compareTo(years5)) == Math.abs(years2.compareTo(years5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((years1.compareTo(years2) == 0) && years1.equals(years2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd1()
   {
    final Years years1 = Years.of(1);
    final Years years2 = Years.of(1);
    final Years yearsResult = years1.add(years2);
    assertEquals(2, yearsResult.longValue(), YearsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd2()
   {
    final Years years1 = Years.of(Long.MAX_VALUE);
    final Years years2 = Years.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Years yearsResult = */ years1.add(years2);
     }, YearsTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test substract.
   */
  @Test
  public void testSubstract1()
   {
    final Years years1 = Years.of(6);
    final Years years2 = Years.of(3);
    final Years yearsResult = years1.subtract(years2);
    assertEquals(3, yearsResult.longValue(), YearsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  public void testSubstract2()
   {
    final Years years1 = Years.of(3);
    final Years years2 = Years.of(6);
    final Years yearsResult = years1.subtract(years2);
    assertEquals(3, yearsResult.longValue(), YearsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  public void testMultiply1()
   {
    final Years years1 = Years.of(7);
    final Years yearsResult = years1.multiply(3);
    assertEquals(21, yearsResult.longValue(), YearsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  public void testMultiply2()
   {
    final Years years1 = Years.of(Long.MAX_VALUE / 2);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Years yearsResult = */ years1.multiply(3);
     }, YearsTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide1()
   {
    final Years years1 = Years.of(10);
    final Years yearsResult = years1.divide(2);
    assertEquals(5, yearsResult.longValue(), YearsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide2()
   {
    final Years years1 = Years.of(10);
    final Years yearsResult = years1.divide(3);
    assertEquals(3, yearsResult.longValue(), YearsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide3()
   {
    final Years years1 = Years.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Years yearsResult = */ years1.divide(0);
     }, YearsTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo1()
   {
    final Years years1 = Years.of(10);
    final Years yearsResult = years1.modulo(2);
    assertEquals(0, yearsResult.longValue(), YearsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo2()
   {
    final Years years1 = Years.of(10);
    final Years yearsResult = years1.modulo(3);
    assertEquals(1, yearsResult.longValue(), YearsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo3()
   {
    final Years years1 = Years.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Years yearsResult = */ years1.modulo(0);
     }, YearsTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
