/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.ddd.values.Second;
import de.powerstat.ddd.values.Seconds;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Second tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class SecondTests
 {
  /**
   * Warning constant.
   */
  private static final String RV_RETURN_VALUE_IGNORED_INFERRED = "RV_RETURN_VALUE_IGNORED_INFERRED";

  /**
   * Not a second constant.
   */
  private static final String NOT_A_SECOND = "Not a second!"; //$NON-NLS-1$

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
  /* default */ SecondTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(0, Second.of("0").second(), SecondTests.NOT_A_SECOND);
   }


  /**
   * Is second.
   *
   * @param second Second
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 59, 60})
  /* default */ void testIsSecond(final int second)
   {
    assertEquals(second, Second.of(second).second(), SecondTests.NOT_A_SECOND);
   }


  /**
   * Is not a second.
   *
   * @param second Second
   */
  @ParameterizedTest
  @ValueSource(ints = {-1, 61})
  /* default */ void testIsNotASecond(final int second)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Second second = */ Second.of(second);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * intValue.
   */
  @Test
  /* default */ void testIntValue()
   {
    assertEquals(10, Second.of(10).second(), SecondTests.NOT_A_SECOND);
   }


  /**
   * stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    assertEquals("10", Second.of(10).stringValue(), SecondTests.NOT_A_SECOND);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Second second1 = Second.of(1);
    final Second second2 = Second.of(1);
    final Second second3 = Second.of(2);
    final Second second4 = Second.of(3);
    final Second second5 = Second.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(second1.compareTo(second2) == -second2.compareTo(second1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(second1.compareTo(second3) == -second3.compareTo(second1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((second4.compareTo(second3) > 0) && (second3.compareTo(second1) > 0) && (second4.compareTo(second1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((second1.compareTo(second2) == 0) && (Math.abs(second1.compareTo(second5)) == Math.abs(second2.compareTo(second5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((second1.compareTo(second2) == 0) && second1.equals(second2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd1()
   {
    final Second second = Second.of(58);
    final Seconds seconds = Seconds.of(1);
    final Second secondResult = second.add(seconds);
    assertEquals(59, secondResult.second(), SecondTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testAdd2()
   {
    final Second second = Second.of(59);
    final Seconds seconds = Seconds.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Second secondResult = */ second.add(seconds);
     }, SecondTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract1()
   {
    final Second second = Second.of(1);
    final Seconds seconds = Seconds.of(1);
    final Second secondResult = second.subtract(seconds);
    assertEquals(0, secondResult.second(), SecondTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testSubtract2()
   {
    final Second second = Second.of(0);
    final Seconds seconds = Seconds.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Second secondResult = */ second.subtract(seconds);
     }, SecondTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrement1()
   {
    final Second second = Second.of(1);
    final Second secondResult = second.increment();
    assertEquals(2, secondResult.second(), SecondTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testIncrement2()
   {
    final Second second = Second.of(59);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Second secondResult = */ second.increment();
     }, SecondTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrement1()
   {
    final Second second = Second.of(2);
    final Second secondResult = second.decrement();
    assertEquals(1, secondResult.second(), SecondTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testDecrement2()
   {
    final Second second = Second.of(0);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Second secondResult = */ second.decrement();
     }, SecondTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
