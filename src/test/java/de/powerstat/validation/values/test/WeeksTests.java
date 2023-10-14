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

import de.powerstat.validation.values.Weeks;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Weeks tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
public class WeeksTests
 {
  /**
   * Not a weeks constant.
   */
  private static final String NOT_A_WEEKS = "Not a weeks!"; //$NON-NLS-1$

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
  public WeeksTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  public void factory1()
   {
    assertEquals(0, Weeks.of("0").longValue(), WeeksTests.NOT_A_WEEKS);
   }


  /**
   * Is weeks.
   *
   * @param weeks Weeks
   */
  @ParameterizedTest
  @ValueSource(longs = {0, 1, 104})
  public void isWeeks(final long weeks)
   {
    assertEquals(weeks, Weeks.of(weeks).longValue(), WeeksTests.NOT_A_WEEKS);
   }


  /**
   * Is not a weeks.
   *
   * @param weeks Weeks
   */
  @ParameterizedTest
  @ValueSource(longs = {-1})
  public void isNotAWeeks(final long weeks)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Weeks weeks = */ Weeks.of(weeks);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test getWeeks.
   *
   * @deprecated Old version of longValue()
   */
  @Deprecated(since = WeeksTests.DEPRECATED_SINCE_3_0, forRemoval = false)
  @Test
  public void getWeeks()
   {
    assertEquals(1, Weeks.of(1).getWeeks(), WeeksTests.NOT_A_WEEKS);
   }


  /**
   * Test longValue.
   */
  @Test
  public void longValue()
   {
    assertEquals(1, Weeks.of(1).longValue(), WeeksTests.NOT_A_WEEKS);
   }


  /**
   * Test stringValue.
   */
  @Test
  public void stringValue()
   {
    assertEquals("1", Weeks.of(1).stringValue(), WeeksTests.NOT_A_WEEKS);
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Weeks weeks1 = Weeks.of(1);
    final Weeks weeks2 = Weeks.of(1);
    final Weeks weeks3 = Weeks.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(weeks1.hashCode(), weeks2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(weeks1.hashCode(), weeks3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Weeks weeks1 = Weeks.of(1);
    final Weeks weeks2 = Weeks.of(1);
    final Weeks weeks3 = Weeks.of(2);
    final Weeks weeks4 = Weeks.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(weeks1.equals(weeks1), "weeks11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(weeks1.equals(weeks2), "weeks12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(weeks2.equals(weeks1), "weeks21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(weeks2.equals(weeks4), "weeks24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(weeks1.equals(weeks4), "weeks14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(weeks1.equals(weeks3), "weeks13 are equal"), //$NON-NLS-1$
      () -> assertFalse(weeks3.equals(weeks1), "weeks31 are equal"), //$NON-NLS-1$
      () -> assertFalse(weeks1.equals(null), "weeks10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Weeks weeks = Weeks.of(1);
    assertEquals("Weeks[weeks=1]", weeks.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Weeks weeks1 = Weeks.of(1);
    final Weeks weeks2 = Weeks.of(1);
    final Weeks weeks3 = Weeks.of(2);
    final Weeks weeks4 = Weeks.of(3);
    final Weeks weeks5 = Weeks.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(weeks1.compareTo(weeks2) == -weeks2.compareTo(weeks1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(weeks1.compareTo(weeks3) == -weeks3.compareTo(weeks1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((weeks4.compareTo(weeks3) > 0) && (weeks3.compareTo(weeks1) > 0) && (weeks4.compareTo(weeks1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((weeks1.compareTo(weeks2) == 0) && (Math.abs(weeks1.compareTo(weeks5)) == Math.abs(weeks2.compareTo(weeks5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((weeks1.compareTo(weeks2) == 0) && weeks1.equals(weeks2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd1()
   {
    final Weeks weeks1 = Weeks.of(1);
    final Weeks weeks2 = Weeks.of(1);
    final Weeks weeksResult = weeks1.add(weeks2);
    assertEquals(2, weeksResult.longValue(), WeeksTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd2()
   {
    final Weeks weeks1 = Weeks.of(Long.MAX_VALUE);
    final Weeks weeks2 = Weeks.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Weeks yearsResult = */ weeks1.add(weeks2);
     }, WeeksTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test substract.
   */
  @Test
  public void testSubstract1()
   {
    final Weeks weeks1 = Weeks.of(6);
    final Weeks weeks2 = Weeks.of(3);
    final Weeks weeksResult = weeks1.subtract(weeks2);
    assertEquals(3, weeksResult.longValue(), WeeksTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  public void testSubstract2()
   {
    final Weeks weeks1 = Weeks.of(3);
    final Weeks weeks2 = Weeks.of(6);
    final Weeks weeksResult = weeks1.subtract(weeks2);
    assertEquals(3, weeksResult.longValue(), WeeksTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  public void testMultiply1()
   {
    final Weeks weeks1 = Weeks.of(7);
    final Weeks weeksResult = weeks1.multiply(3);
    assertEquals(21, weeksResult.longValue(), WeeksTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  public void testMultiply2()
   {
    final Weeks weeks1 = Weeks.of(Long.MAX_VALUE / 2);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Weeks weeksResult = */ weeks1.multiply(3);
     }, WeeksTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide1()
   {
    final Weeks weeks1 = Weeks.of(10);
    final Weeks weeksResult = weeks1.divide(2);
    assertEquals(5, weeksResult.longValue(), WeeksTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide2()
   {
    final Weeks weeks1 = Weeks.of(10);
    final Weeks weeksResult = weeks1.divide(3);
    assertEquals(3, weeksResult.longValue(), WeeksTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide3()
   {
    final Weeks weeks1 = Weeks.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Weeks weeksResult = */ weeks1.divide(0);
     }, WeeksTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo1()
   {
    final Weeks weeks1 = Weeks.of(10);
    final Weeks weeksResult = weeks1.modulo(2);
    assertEquals(0, weeksResult.longValue(), WeeksTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo2()
   {
    final Weeks weeks1 = Weeks.of(10);
    final Weeks weeksResult = weeks1.modulo(3);
    assertEquals(1, weeksResult.longValue(), WeeksTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo3()
   {
    final Weeks weeks1 = Weeks.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Weeks weeksResult = */ weeks1.modulo(0);
     }, WeeksTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
