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

import de.powerstat.validation.values.Seconds;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Seconds tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
public class SecondsTests
 {
  /**
   * Not a seconds constant.
   */
  private static final String NOT_A_SECONDS = "Not a seconds!"; //$NON-NLS-1$

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
  public SecondsTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  public void factory1()
   {
    assertEquals(0, Seconds.of("0").longValue(), SecondsTests.NOT_A_SECONDS);
   }


  /**
   * Is seconds.
   *
   * @param seconds Seconds
   */
  @ParameterizedTest
  @ValueSource(longs = {0, 120})
  public void isSeconds(final long seconds)
   {
    assertEquals(seconds, Seconds.of(seconds).longValue(), SecondsTests.NOT_A_SECONDS);
   }


  /**
   * Is not a seconds.
   *
   * @param seconds Seconds
   */
  @ParameterizedTest
  @ValueSource(longs = {-1})
  public void isNotASeconds(final long seconds)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Seconds seconds = */ Seconds.of(seconds);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * getSeconds.
   *
   * @deprecated Old version of longValue()
   */
  @Deprecated(since = SecondsTests.DEPRECATED_SINCE_3_0, forRemoval = false)
  @Test
  public void getSeconds()
   {
    assertEquals(10, Seconds.of(10).getSeconds(), SecondsTests.NOT_A_SECONDS);
   }


  /**
   * longValue.
   */
  @Test
  public void longValue()
   {
    assertEquals(10, Seconds.of(10).longValue(), SecondsTests.NOT_A_SECONDS);
   }


  /**
   * stringValue.
   */
  @Test
  public void stringValue()
   {
    assertEquals("10", Seconds.of(10).stringValue(), SecondsTests.NOT_A_SECONDS);
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Seconds seconds1 = Seconds.of(1);
    final Seconds seconds2 = Seconds.of(1);
    final Seconds seconds3 = Seconds.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(seconds1.hashCode(), seconds2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(seconds1.hashCode(), seconds3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Seconds seconds1 = Seconds.of(1);
    final Seconds seconds2 = Seconds.of(1);
    final Seconds seconds3 = Seconds.of(2);
    final Seconds seconds4 = Seconds.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(seconds1.equals(seconds1), "seconds11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(seconds1.equals(seconds2), "seconds12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(seconds2.equals(seconds1), "seconds21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(seconds2.equals(seconds4), "seconds24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(seconds1.equals(seconds4), "seconds14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(seconds1.equals(seconds3), "seconds13 are equal"), //$NON-NLS-1$
      () -> assertFalse(seconds3.equals(seconds1), "seconds31 are equal"), //$NON-NLS-1$
      () -> assertFalse(seconds1.equals(null), "seconds10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Seconds seconds = Seconds.of(1);
    assertEquals("Seconds[seconds=1]", seconds.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Seconds seconds1 = Seconds.of(1);
    final Seconds seconds2 = Seconds.of(1);
    final Seconds seconds3 = Seconds.of(2);
    final Seconds seconds4 = Seconds.of(3);
    final Seconds seconds5 = Seconds.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(seconds1.compareTo(seconds2) == -seconds2.compareTo(seconds1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(seconds1.compareTo(seconds3) == -seconds3.compareTo(seconds1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((seconds4.compareTo(seconds3) > 0) && (seconds3.compareTo(seconds1) > 0) && (seconds4.compareTo(seconds1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((seconds1.compareTo(seconds2) == 0) && (Math.abs(seconds1.compareTo(seconds5)) == Math.abs(seconds2.compareTo(seconds5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((seconds1.compareTo(seconds2) == 0) && seconds1.equals(seconds2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd1()
   {
    final Seconds seconds1 = Seconds.of(1);
    final Seconds seconds2 = Seconds.of(1);
    final Seconds secondsResult = seconds1.add(seconds2);
    assertEquals(2, secondsResult.longValue(), SecondsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd2()
   {
    final Seconds seconds1 = Seconds.of(Long.MAX_VALUE);
    final Seconds seconds2 = Seconds.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Seconds secondsResult = */ seconds1.add(seconds2);
     }, SecondsTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test substract.
   */
  @Test
  public void testSubstract1()
   {
    final Seconds seconds1 = Seconds.of(6);
    final Seconds seconds2 = Seconds.of(3);
    final Seconds secondsResult = seconds1.subtract(seconds2);
    assertEquals(3, secondsResult.longValue(), SecondsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  public void testSubstract2()
   {
    final Seconds seconds1 = Seconds.of(3);
    final Seconds seconds2 = Seconds.of(6);
    final Seconds secondsResult = seconds1.subtract(seconds2);
    assertEquals(3, secondsResult.longValue(), SecondsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  public void testMultiply1()
   {
    final Seconds seconds1 = Seconds.of(7);
    final Seconds secondsResult = seconds1.multiply(3);
    assertEquals(21, secondsResult.longValue(), SecondsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  public void testMultiply2()
   {
    final Seconds seconds1 = Seconds.of(Long.MAX_VALUE / 2);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Seconds yearsResult = */ seconds1.multiply(3);
     }, SecondsTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide1()
   {
    final Seconds seconds1 = Seconds.of(10);
    final Seconds secondsResult = seconds1.divide(2);
    assertEquals(5, secondsResult.longValue(), SecondsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide2()
   {
    final Seconds seconds1 = Seconds.of(10);
    final Seconds secondsResult = seconds1.divide(3);
    assertEquals(3, secondsResult.longValue(), SecondsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide3()
   {
    final Seconds seconds1 = Seconds.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Seconds yearsResult = */ seconds1.divide(0);
     }, SecondsTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo1()
   {
    final Seconds seconds1 = Seconds.of(10);
    final Seconds secondsResult = seconds1.modulo(2);
    assertEquals(0, secondsResult.longValue(), SecondsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo2()
   {
    final Seconds seconds1 = Seconds.of(10);
    final Seconds secondsResult = seconds1.modulo(3);
    assertEquals(1, secondsResult.longValue(), SecondsTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo3()
   {
    final Seconds seconds1 = Seconds.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Seconds secondsResult = */ seconds1.modulo(0);
     }, SecondsTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
