/*
 * Copyright (C) 2026 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.time.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.ddd.values.time.Hours;
import de.powerstat.ddd.values.time.Minutes;
import de.powerstat.ddd.values.time.Seconds;
import de.powerstat.ddd.values.time.TimeDuration;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * TimeDuration tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class TimeDurationTests
 {
  /**
   * Not a hours constant.
   */
  private static final String NOT_A_TIMEDURATION = "Not a timeduration!"; //$NON-NLS-1$

  /**
   * Result nor as expected constant.
   */
  private static final String RESULT_NOT_AS_EXPECTED = "Result not as expected"; //$NON-NLS-1$

  /**
   * Arithmetic exception expected constant.
   */
  private static final String ARITHMETIC_EXCEPTION_EXPECTED = "Arithmetic exception expected"; //$NON-NLS-1$

  /**
   * Warning constant.
   */
  private static final String RV_RETURN_VALUE_IGNORED_INFERRED = "RV_RETURN_VALUE_IGNORED_INFERRED";


  /**
   * Default constructor.
   */
  /* default */ TimeDurationTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals("PT0H0M0S", TimeDuration.of("PT0H0M0S").stringValue(), TimeDurationTests.NOT_A_TIMEDURATION);
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory2()
   {
    assertEquals("PT0H0M0S", TimeDuration.of(Hours.of(0), Minutes.of(0), Seconds.of(0)).stringValue(), TimeDurationTests.NOT_A_TIMEDURATION);
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory3()
   {
    assertEquals("PT0H1M0S", TimeDuration.of(Hours.of(0), Minutes.of(0), Seconds.of(60)).stringValue(), TimeDurationTests.NOT_A_TIMEDURATION);
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory4()
   {
    assertEquals("PT1H0M0S", TimeDuration.of(Hours.of(0), Minutes.of(60), Seconds.of(0)).stringValue(), TimeDurationTests.NOT_A_TIMEDURATION);
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory5()
   {
    assertEquals("PT0H1M0S", TimeDuration.of(0, 0, 60).stringValue(), TimeDurationTests.NOT_A_TIMEDURATION);
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory6()
   {
    assertEquals("PT1H0M0S", TimeDuration.of(0, 60, 0).stringValue(), TimeDurationTests.NOT_A_TIMEDURATION);
   }


  /**
   * stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    assertEquals("PT0H0M0S", TimeDuration.of("PT0H0M0S").stringValue(), TimeDurationTests.NOT_A_TIMEDURATION);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final TimeDuration duration1 = TimeDuration.of("PT0H0M0S");
    final TimeDuration duration2 = TimeDuration.of("PT0H0M0S");
    final TimeDuration duration3 = TimeDuration.of("PT0H0M1S");
    final TimeDuration duration4 = TimeDuration.of("PT0H1M0S");
    final TimeDuration duration5 = TimeDuration.of("PT0H0M0S");
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(duration1.compareTo(duration2) == -duration2.compareTo(duration1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(duration1.compareTo(duration3) == -duration3.compareTo(duration1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((duration4.compareTo(duration3) > 0) && (duration3.compareTo(duration1) > 0) && (duration4.compareTo(duration1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((duration1.compareTo(duration2) == 0) && (Math.abs(duration1.compareTo(duration5)) == Math.abs(duration2.compareTo(duration5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((duration1.compareTo(duration2) == 0) && duration1.equals(duration2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd1()
   {
    final TimeDuration duration1 = TimeDuration.of(1, 0, 0);
    final Hours hours2 = Hours.of(1);
    final TimeDuration result = duration1.add(hours2);
    assertEquals(2, result.hours().hours(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd2()
   {
    final TimeDuration duration1 = TimeDuration.of(Long.MAX_VALUE, 0, 0);
    final Hours hours2 = Hours.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final TimeDuration result = */ duration1.add(hours2);
     }, ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd3()
   {
    final TimeDuration duration1 = TimeDuration.of(0, 1, 0);
    final Minutes minutes2 = Minutes.of(1);
    final TimeDuration result = duration1.add(minutes2);
    assertEquals(2, result.mins().minutes(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd4()
   {
    final TimeDuration duration1 = TimeDuration.of(Long.MAX_VALUE, 59, 0);
    final Minutes minutes2 = Minutes.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final TimeDuration result = */ duration1.add(minutes2);
     }, ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd5()
   {
    final TimeDuration duration1 = TimeDuration.of(0, 0, 1);
    final Seconds seconds2 = Seconds.of(1);
    final TimeDuration result = duration1.add(seconds2);
    assertEquals(2, result.secs().seconds(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd6()
   {
    final TimeDuration duration1 = TimeDuration.of(Long.MAX_VALUE, 59, 59);
    final Seconds seconds2 = Seconds.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final TimeDuration result = */ duration1.add(seconds2);
     }, ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd7()
   {
    final TimeDuration duration1 = TimeDuration.of(1, 1, 1);
    final TimeDuration duration2 = TimeDuration.of(2, 2, 2);
    final TimeDuration result = duration1.add(duration2);
    assertAll("testAdd7", //$NON-NLS-1$
      () -> assertEquals(3, result.hours().hours(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(3, result.mins().minutes(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(3, result.secs().seconds(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd8()
   {
    final TimeDuration duration1 = TimeDuration.of(Long.MAX_VALUE, 58, 59);
    final TimeDuration duration2 = TimeDuration.of(0, 1, 1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final TimeDuration result = */ duration1.add(duration2);
     }, ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract1()
   {
    final TimeDuration duration1 = TimeDuration.of(6, 0, 0);
    final Hours hours2 = Hours.of(3);
    final TimeDuration result = duration1.subtract(hours2);
    assertEquals(3, result.hours().hours(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract2()
   {
    final TimeDuration duration1 = TimeDuration.of(3, 0, 0);
    final Hours hours2 = Hours.of(6);
    final TimeDuration result = duration1.subtract(hours2);
    assertEquals(3, result.hours().hours(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract3()
   {
    final TimeDuration duration1 = TimeDuration.of(0, 6, 0);
    final Minutes minutes2 = Minutes.of(3);
    final TimeDuration result = duration1.subtract(minutes2);
    assertEquals(3, result.mins().minutes(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract4()
   {
    final TimeDuration duration1 = TimeDuration.of(0, 3, 0);
    final Minutes minutes2 = Minutes.of(6);
    final TimeDuration result = duration1.subtract(minutes2);
    assertEquals(3, result.mins().minutes(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract5()
   {
    final TimeDuration duration1 = TimeDuration.of(1, 3, 0);
    final Minutes minutes2 = Minutes.of(6);
    final TimeDuration result = duration1.subtract(minutes2);
    assertAll("testSubtract5", //$NON-NLS-1$
      () -> assertEquals(57, result.mins().minutes(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(0, result.hours().hours(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract6()
   {
    final TimeDuration duration1 = TimeDuration.of(0, 0, 6);
    final Seconds seconds2 = Seconds.of(3);
    final TimeDuration result = duration1.subtract(seconds2);
    assertEquals(3, result.secs().seconds(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract7()
   {
    final TimeDuration duration1 = TimeDuration.of(0, 0, 3);
    final Seconds seconds2 = Seconds.of(6);
    final TimeDuration result = duration1.subtract(seconds2);
    assertEquals(3, result.secs().seconds(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract8()
   {
    final TimeDuration duration1 = TimeDuration.of(0, 1, 3);
    final Seconds seconds2 = Seconds.of(6);
    final TimeDuration result = duration1.subtract(seconds2);
    assertAll("testSubtract8", //$NON-NLS-1$
      () -> assertEquals(57, result.secs().seconds(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(0, result.mins().minutes(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract9()
   {
    final TimeDuration duration1 = TimeDuration.of(6, 6, 6);
    final TimeDuration duration2 = TimeDuration.of(3, 3, 3);
    final TimeDuration result = duration1.subtract(duration2);
    assertAll("testSubtract9", //$NON-NLS-1$
      () -> assertEquals(3, result.secs().seconds(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(3, result.mins().minutes(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(3, result.hours().hours(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract10()
   {
    final TimeDuration duration1 = TimeDuration.of(3, 3, 3);
    final TimeDuration duration2 = TimeDuration.of(6, 6, 6);
    final TimeDuration result = duration1.subtract(duration2);
    assertAll("testSubtract10", //$NON-NLS-1$
      () -> assertEquals(3, result.secs().seconds(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(3, result.mins().minutes(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(3, result.hours().hours(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract11()
   {
    final TimeDuration duration1 = TimeDuration.of(1, 1, 1);
    final TimeDuration duration2 = TimeDuration.of(0, 59, 2);
    final TimeDuration result = duration1.subtract(duration2);
    assertAll("testSubtract11", //$NON-NLS-1$
      () -> assertEquals(59, result.secs().seconds(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(1, result.mins().minutes(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(0, result.hours().hours(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test multiply.
   */
  @Test
  /* default */ void testMultiply1()
   {
    final TimeDuration duration1 = TimeDuration.of(21, 21, 21);
    final TimeDuration result = duration1.multiply(3);
    assertAll("testMultiply1", //$NON-NLS-1$
      () -> assertEquals(3, result.secs().seconds(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(4, result.mins().minutes(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(64, result.hours().hours(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test multiply.
   */
  @Test
  /* default */ void testMultiply2()
   {
    final TimeDuration duration1 = TimeDuration.of(Long.MAX_VALUE / 2, 0, 0);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final TimeDuration result = */ duration1.multiply(3);
     }, ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testDivide1()
   {
    final TimeDuration duration1 = TimeDuration.of(10, 10, 10);
    final TimeDuration result = duration1.divide(2);
    assertAll("testDivide1", //$NON-NLS-1$
      () -> assertEquals(5, result.hours().hours(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(5, result.mins().minutes(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(5, result.secs().seconds(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testDivide2()
   {
    final TimeDuration duration1 = TimeDuration.of(10, 10, 10);
    final TimeDuration result = duration1.divide(3);
    assertAll("testDivide2", //$NON-NLS-1$
      () -> assertEquals(3, result.hours().hours(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(23, result.mins().minutes(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(23, result.secs().seconds(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testDivide3()
   {
    final TimeDuration duration1 = TimeDuration.of(10, 10, 10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final TimeDuration result = */ duration1.divide(0);
     }, ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test modulo.
   */
  @Test
  /* default */ void testModulo1()
   {
    final TimeDuration duration1 = TimeDuration.of(10, 10, 10);
    final TimeDuration result = duration1.modulo(2);
    assertEquals(0, result.secs().seconds(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test modulo.
   */
  @Test
  /* default */ void testModulo2()
   {
    final TimeDuration duration1 = TimeDuration.of(10, 10, 10);
    final TimeDuration result = duration1.modulo(3);
    assertEquals(1, result.secs().seconds(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test modulo.
   */
  @Test
  /* default */ void testModulo3()
   {
    final TimeDuration duration1 = TimeDuration.of(10, 10, 10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final TimeDuration result = */ duration1.modulo(0);
     }, ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrementHours1()
   {
    final TimeDuration duration = TimeDuration.of(0, 0, 0);
    final TimeDuration result = duration.incrementHours();
    assertEquals(1, result.hours().hours(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testIncrementHours2()
   {
    final TimeDuration duration = TimeDuration.of(Long.MAX_VALUE, 0, 0);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final TimeDuration result = */ duration.incrementHours();
     }, ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrementHours1()
   {
    final TimeDuration duration = TimeDuration.of(1, 0, 0);
    final TimeDuration result = duration.decrementHours();
    assertEquals(0, result.hours().hours(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testDecrementHours2()
   {
    final TimeDuration duration = TimeDuration.of(0, 0, 0);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final TimeDuration result = */ duration.decrementHours();
     }, ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrementMins1()
   {
    final TimeDuration duration = TimeDuration.of(0, 0, 0);
    final TimeDuration result = duration.incrementMins();
    assertEquals(1, result.mins().minutes(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testIncrementMins2()
   {
    final TimeDuration duration = TimeDuration.of(Long.MAX_VALUE, 59, 0);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final TimeDuration result = */ duration.incrementMins();
     }, ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrementMins1()
   {
    final TimeDuration duration = TimeDuration.of(0, 1, 0);
    final TimeDuration result = duration.decrementMins();
    assertEquals(0, result.mins().minutes(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testDecrementMins2()
   {
    final TimeDuration duration = TimeDuration.of(0, 0, 0);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final TimeDuration result = */ duration.decrementMins();
     }, ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrementSecs1()
   {
    final TimeDuration duration = TimeDuration.of(0, 0, 0);
    final TimeDuration result = duration.incrementSecs();
    assertEquals(1, result.secs().seconds(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testIncrementSecs2()
   {
    final TimeDuration duration = TimeDuration.of(Long.MAX_VALUE, 59, 59);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final TimeDuration result = */ duration.incrementSecs();
     }, ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrementSecs1()
   {
    final TimeDuration duration = TimeDuration.of(0, 0, 1);
    final TimeDuration result = duration.decrementSecs();
    assertEquals(0, result.secs().seconds(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testDecrementSecs2()
   {
    final TimeDuration duration = TimeDuration.of(0, 0, 0);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final TimeDuration result = */ duration.decrementSecs();
     }, ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
