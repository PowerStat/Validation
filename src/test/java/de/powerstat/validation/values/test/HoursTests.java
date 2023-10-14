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

import de.powerstat.validation.values.Hours;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Hours tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
public class HoursTests
 {
  /**
   * Not a hours constant.
   */
  private static final String NOT_A_HOURS = "Not a hours!"; //$NON-NLS-1$

  /**
   * Result nor as expected constant.
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
  public HoursTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  public void factory1()
   {
    assertEquals(0, Hours.of("0").longValue(), HoursTests.NOT_A_HOURS);
   }


  /**
   * Is hours.
   *
   * @param hours Hours
   */
  @ParameterizedTest
  @ValueSource(longs = {0, 48})
  public void isHours(final long hours)
   {
    assertEquals(hours, Hours.of(hours).longValue(), HoursTests.NOT_A_HOURS);
   }


  /**
   * Is not a hours.
   *
   * @param hours Hours
   */
  @ParameterizedTest
  @ValueSource(longs = {-1})
  public void isNotAHours(final long hours)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Hours hours = */ Hours.of(hours);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * getHours.
   *
   * @deprecated Old version of longValue()
   */
  @Deprecated(since = HoursTests.DEPRECATED_SINCE_3_0, forRemoval = false)
  @Test
  public void getHours()
   {
    assertEquals(10, Hours.of(10).getHours(), HoursTests.NOT_A_HOURS);
   }


  /**
   * longValue.
   */
  @Test
  public void longValue()
   {
    assertEquals(10, Hours.of(10).longValue(), HoursTests.NOT_A_HOURS);
   }


  /**
   * stringValue.
   */
  @Test
  public void stringValue()
   {
    assertEquals("10", Hours.of(10).stringValue(), HoursTests.NOT_A_HOURS);
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Hours hours1 = Hours.of(1);
    final Hours hours2 = Hours.of(1);
    final Hours hours3 = Hours.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(hours1.hashCode(), hours2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(hours1.hashCode(), hours3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Hours hours1 = Hours.of(1);
    final Hours hours2 = Hours.of(1);
    final Hours hours3 = Hours.of(2);
    final Hours hours4 = Hours.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(hours1.equals(hours1), "hours11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(hours1.equals(hours2), "hours12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(hours2.equals(hours1), "hours21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(hours2.equals(hours4), "hours24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(hours1.equals(hours4), "hours14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(hours1.equals(hours3), "housr13 are equal"), //$NON-NLS-1$
      () -> assertFalse(hours3.equals(hours1), "hours31 are equal"), //$NON-NLS-1$
      () -> assertFalse(hours1.equals(null), "hours10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Hours hours = Hours.of(1);
    assertEquals("Hours[hours=1]", hours.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Hours hours1 = Hours.of(1);
    final Hours hours2 = Hours.of(1);
    final Hours hours3 = Hours.of(2);
    final Hours hours4 = Hours.of(3);
    final Hours hours5 = Hours.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(hours1.compareTo(hours2) == -hours2.compareTo(hours1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(hours1.compareTo(hours3) == -hours3.compareTo(hours1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((hours4.compareTo(hours3) > 0) && (hours3.compareTo(hours1) > 0) && (hours4.compareTo(hours1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((hours1.compareTo(hours2) == 0) && (Math.abs(hours1.compareTo(hours5)) == Math.abs(hours2.compareTo(hours5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((hours1.compareTo(hours2) == 0) && hours1.equals(hours2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd1()
   {
    final Hours hours1 = Hours.of(1);
    final Hours hours2 = Hours.of(1);
    final Hours hoursResult = hours1.add(hours2);
    assertEquals(2, hoursResult.longValue(), HoursTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd2()
   {
    final Hours hours1 = Hours.of(Long.MAX_VALUE);
    final Hours hours2 = Hours.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Hours hoursResult = */ hours1.add(hours2);
     }, HoursTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test substract.
   */
  @Test
  public void testSubstract1()
   {
    final Hours hours1 = Hours.of(6);
    final Hours hours2 = Hours.of(3);
    final Hours hoursResult = hours1.subtract(hours2);
    assertEquals(3, hoursResult.longValue(), HoursTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  public void testSubstract2()
   {
    final Hours hours1 = Hours.of(3);
    final Hours hours2 = Hours.of(6);
    final Hours hoursResult = hours1.subtract(hours2);
    assertEquals(3, hoursResult.longValue(), HoursTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  public void testMultiply1()
   {
    final Hours hours1 = Hours.of(7);
    final Hours hoursResult = hours1.multiply(3);
    assertEquals(21, hoursResult.longValue(), HoursTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  public void testMultiply2()
   {
    final Hours hours1 = Hours.of(Long.MAX_VALUE / 2);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Hours hoursResult = */ hours1.multiply(3);
     }, HoursTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide1()
   {
    final Hours hours1 = Hours.of(10);
    final Hours hoursResult = hours1.divide(2);
    assertEquals(5, hoursResult.longValue(), HoursTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide2()
   {
    final Hours hours1 = Hours.of(10);
    final Hours hoursResult = hours1.divide(3);
    assertEquals(3, hoursResult.longValue(), HoursTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testDivide3()
   {
    final Hours hours1 = Hours.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Hours hoursResult = */ hours1.divide(0);
     }, HoursTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo1()
   {
    final Hours hours1 = Hours.of(10);
    final Hours hoursResult = hours1.modulo(2);
    assertEquals(0, hoursResult.longValue(), HoursTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo2()
   {
    final Hours hours1 = Hours.of(10);
    final Hours hoursResult = hours1.modulo(3);
    assertEquals(1, hoursResult.longValue(), HoursTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  public void testModulo3()
   {
    final Hours hours1 = Hours.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Hours hoursResult = */ hours1.modulo(0);
     }, HoursTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
