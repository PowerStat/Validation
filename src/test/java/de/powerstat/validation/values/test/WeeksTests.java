/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import nl.jqno.equalsverifier.EqualsVerifier;
import de.powerstat.validation.values.Weeks;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Weeks tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class WeeksTests
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
   * Default constructor.
   */
  /* default */ WeeksTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
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
  /* default */ void testIsWeeks(final long weeks)
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
  /* default */ void testIsNotAWeeks(final long weeks)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Weeks weeks = */ Weeks.of(weeks);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test longValue.
   */
  @Test
  /* default */ void testLongValue()
   {
    assertEquals(1, Weeks.of(1).longValue(), WeeksTests.NOT_A_WEEKS);
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    assertEquals("1", Weeks.of(1).stringValue(), WeeksTests.NOT_A_WEEKS);
   }


  /**
   * Equalsverifier.
   */
  @Test
  /* default */ void testEqualsContract()
   {
    EqualsVerifier.forClass(Weeks.class).verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Weeks weeks = Weeks.of(1);
    assertEquals("Weeks[weeks=1]", weeks.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
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
  /* default */ void testAdd1()
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
  /* default */ void testAdd2()
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
  /* default */ void testSubstract1()
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
  /* default */ void testSubstract2()
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
  /* default */ void testMultiply1()
   {
    final Weeks weeks1 = Weeks.of(7);
    final Weeks weeksResult = weeks1.multiply(3);
    assertEquals(21, weeksResult.longValue(), WeeksTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  /* default */ void testMultiply2()
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
  /* default */ void testDivide1()
   {
    final Weeks weeks1 = Weeks.of(10);
    final Weeks weeksResult = weeks1.divide(2);
    assertEquals(5, weeksResult.longValue(), WeeksTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testDivide2()
   {
    final Weeks weeks1 = Weeks.of(10);
    final Weeks weeksResult = weeks1.divide(3);
    assertEquals(3, weeksResult.longValue(), WeeksTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testDivide3()
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
  /* default */ void testModulo1()
   {
    final Weeks weeks1 = Weeks.of(10);
    final Weeks weeksResult = weeks1.modulo(2);
    assertEquals(0, weeksResult.longValue(), WeeksTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testModulo2()
   {
    final Weeks weeks1 = Weeks.of(10);
    final Weeks weeksResult = weeks1.modulo(3);
    assertEquals(1, weeksResult.longValue(), WeeksTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testModulo3()
   {
    final Weeks weeks1 = Weeks.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Weeks weeksResult = */ weeks1.modulo(0);
     }, WeeksTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
