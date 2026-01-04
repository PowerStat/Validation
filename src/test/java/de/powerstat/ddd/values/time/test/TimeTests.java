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

import de.powerstat.ddd.values.time.Hour;
import de.powerstat.ddd.values.time.Hours;
import de.powerstat.ddd.values.time.Minute;
import de.powerstat.ddd.values.time.Minutes;
import de.powerstat.ddd.values.time.Second;
import de.powerstat.ddd.values.time.Seconds;
import de.powerstat.ddd.values.time.Time;
import de.powerstat.ddd.values.time.TimeDuration;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Hour tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class TimeTests
 {
  /**
   * Warning constant.
   */
  private static final String RV_RETURN_VALUE_IGNORED_INFERRED = "RV_RETURN_VALUE_IGNORED_INFERRED";

  /**
   * Not a hour constant.
   */
  private static final String NOT_A_TIME = "Not a time!"; //$NON-NLS-1$

  /**
   * Result nor as expected constant.
   */
  private static final String RESULT_NOT_AS_EXPECTED = "Result not as expected"; //$NON-NLS-1$

  /**
   * Arithmetic exception expected constant.
   */
  private static final String ARITHMETIC_EXCEPTION_EXPECTED = "Arithmetic exception expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ TimeTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals("00:00:00", Time.of(Hour.of(0), Minute.of(0), Second.of(0)).stringValue(), TimeTests.NOT_A_TIME);
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory2()
   {
    assertEquals("00:00:00", Time.of(0, 0, 0).stringValue(), TimeTests.NOT_A_TIME);
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory3()
   {
    assertEquals("00:00:00", Time.of("00:00:00").stringValue(), TimeTests.NOT_A_TIME);
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory4()
   {
    assertThrows(NullPointerException.class, () ->
     {
      /* final Time time = */ Time.of(null);
     }, "Null pointer exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory5()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Time time = */ Time.of("");
     }, "Illegal argument exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory6()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Time time = */ Time.of("00:00:001");
     }, "Illegal argument exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory7()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Time time = */ Time.of("24:61:61");
     }, "Illegal argument exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory8()
   {
    assertEquals("01:00:00", Time.of("1").stringValue(), TimeTests.NOT_A_TIME);
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory9()
   {
    assertEquals("01:01:00", Time.of("1:1").stringValue(), TimeTests.NOT_A_TIME);
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory10()
   {
    assertEquals("01:01:01", Time.of("1:1:1").stringValue(), TimeTests.NOT_A_TIME);
   }


  /**
   * stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    assertEquals("15:35:00", Time.of("15:35:00").stringValue(), TimeTests.NOT_A_TIME);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Time time1 = Time.of("01:00:00");
    final Time time2 = Time.of("01:00:00");
    final Time time3 = Time.of("02:00:00");
    final Time time4 = Time.of("03:00:00");
    final Time time5 = Time.of("01:00:00");
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(time1.compareTo(time2) == -time2.compareTo(time1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(time1.compareTo(time3) == -time3.compareTo(time1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((time4.compareTo(time3) > 0) && (time3.compareTo(time1) > 0) && (time4.compareTo(time1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((time1.compareTo(time2) == 0) && (Math.abs(time1.compareTo(time5)) == Math.abs(time2.compareTo(time5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((time1.compareTo(time2) == 0) && time1.equals(time2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd1()
   {
    final Time time1 = Time.of(0, 0, 0);
    final Hours hours2 = Hours.of(1);
    final Time result = time1.add(hours2);
    assertEquals(1, result.hour().hour(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd2()
   {
    final Time time1 = Time.of(23, 0, 0);
    final Hours hours2 = Hours.of(1);
    final Time result = time1.add(hours2);
    assertEquals(0, result.hour().hour(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd3()
   {
    final Time time1 = Time.of(0, 0, 0);
    final Minutes minutes2 = Minutes.of(1);
    final Time result = time1.add(minutes2);
    assertEquals(1, result.min().minute(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd4()
   {
    final Time time1 = Time.of(23, 59, 0);
    final Minutes minutes2 = Minutes.of(1);
    final Time result = time1.add(minutes2);
    assertAll("testAdd4", //$NON-NLS-1$
      () -> assertEquals(0, result.min().minute(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(0, result.hour().hour(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd5()
   {
    final Time time1 = Time.of(0, 0, 0);
    final Seconds seconds2 = Seconds.of(1);
    final Time result = time1.add(seconds2);
    assertEquals(1, result.sec().second(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd6()
   {
    final Time time1 = Time.of(23, 59, 59);
    final Seconds seconds2 = Seconds.of(1);
    final Time result = time1.add(seconds2);
    assertAll("testAdd6", //$NON-NLS-1$
      () -> assertEquals(0, result.sec().second(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(0, result.min().minute(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(0, result.hour().hour(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd7()
   {
    final Time time1 = Time.of(0, 0, 0);
    final TimeDuration duration2 = TimeDuration.of(1, 1, 1);
    final Time result = time1.add(duration2);
    assertAll("testAdd7", //$NON-NLS-1$
      () -> assertEquals(1, result.hour().hour(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(1, result.min().minute(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(1, result.sec().second(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd8()
   {
    final Time time1 = Time.of(22, 58, 59);
    final TimeDuration duration2 = TimeDuration.of(1, 1, 1);
    final Time result = time1.add(duration2);
    assertAll("testAdd8", //$NON-NLS-1$
      () -> assertEquals(0, result.hour().hour(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(0, result.min().minute(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(0, result.sec().second(), RESULT_NOT_AS_EXPECTED)
    );
   }

  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract1()
   {
    final Time time1 = Time.of(1, 0, 0);
    final Hours hours2 = Hours.of(1);
    final Time result = time1.subtract(hours2);
    assertEquals(0, result.hour().hour(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract2()
   {
    final Time time1 = Time.of(0, 0, 0);
    final Hours hours2 = Hours.of(1);
    final Time result = time1.subtract(hours2);
    assertEquals(23, result.hour().hour(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract3()
   {
    final Time time1 = Time.of(0, 1, 0);
    final Minutes minutes2 = Minutes.of(1);
    final Time result = time1.subtract(minutes2);
    assertEquals(0, result.min().minute(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract4()
   {
    final Time time1 = Time.of(0, 0, 0);
    final Minutes minutes2 = Minutes.of(1);
    final Time result = time1.subtract(minutes2);
    assertAll("testSubtract4", //$NON-NLS-1$
      () -> assertEquals(59, result.min().minute(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(23, result.hour().hour(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract5()
   {
    final Time time1 = Time.of(0, 0, 1);
    final Seconds seconds2 = Seconds.of(1);
    final Time result = time1.subtract(seconds2);
    assertEquals(0, result.sec().second(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract6()
   {
    final Time time1 = Time.of(0, 0, 0);
    final Seconds seconds2 = Seconds.of(1);
    final Time result = time1.subtract(seconds2);
    assertAll("testSubtract6", //$NON-NLS-1$
      () -> assertEquals(59, result.sec().second(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(59, result.min().minute(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(23, result.hour().hour(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract7()
   {
    final Time time1 = Time.of(1, 1, 1);
    final TimeDuration duration2 = TimeDuration.of(1, 1, 1);
    final Time result = time1.subtract(duration2);
    assertAll("testSubtract7", //$NON-NLS-1$
      () -> assertEquals(0, result.sec().second(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(0, result.min().minute(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(0, result.hour().hour(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test substract.
   */
  @Test
  /* default */ void testSubstract8()
   {
    final Time time1 = Time.of(0, 0, 0);
    final TimeDuration duration2 = TimeDuration.of(1, 1, 1);
    final Time result = time1.subtract(duration2);
    assertAll("testSubtract8", //$NON-NLS-1$
      () -> assertEquals(59, result.sec().second(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(58, result.min().minute(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(22, result.hour().hour(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrementHour1()
   {
    final Time time = Time.of(0, 0, 0);
    final Time result = time.incrementHour();
    assertEquals(1, result.hour().hour(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testIncrementHour2()
   {
    final Time time = Time.of(23, 0, 0);
    final Time result = time.incrementHour();
    assertEquals(0, result.hour().hour(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrementHour1()
   {
    final Time time = Time.of(1, 0, 0);
    final Time result = time.decrementHour();
    assertEquals(0, result.hour().hour(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testDecrementHour2()
   {
    final Time time = Time.of(0, 0, 0);
    final Time result = time.decrementHour();
    assertEquals(23, result.hour().hour(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrementMin1()
   {
    final Time time = Time.of(0, 0, 0);
    final Time result = time.incrementMin();
    assertEquals(1, result.min().minute(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testIncrementMin2()
   {
    final Time time = Time.of(23, 59, 0);
    final Time result = time.incrementMin();
    assertAll("testIncrementMin2", //$NON-NLS-1$
      () -> assertEquals(0, result.min().minute(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(0, result.hour().hour(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrementMin1()
   {
    final Time time = Time.of(0, 1, 0);
    final Time result = time.decrementMin();
    assertEquals(0, result.min().minute(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testDecrementMin2()
   {
    final Time time = Time.of(0, 0, 0);
    final Time result = time.decrementMin();
    assertAll("testDerementMin2", //$NON-NLS-1$
      () -> assertEquals(59, result.min().minute(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(23, result.hour().hour(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIcrementSec1()
   {
    final Time time = Time.of(0, 0, 0);
    final Time result = time.incrementSec();
    assertEquals(1, result.sec().second(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testIncrementSec2()
   {
    final Time time = Time.of(23, 59, 59);
    final Time result = time.incrementSec();
    assertAll("testIncrementMin2", //$NON-NLS-1$
      () -> assertEquals(0, result.sec().second(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(0, result.min().minute(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(0, result.hour().hour(), RESULT_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrementSec1()
   {
    final Time time = Time.of(0, 0, 1);
    final Time result = time.decrementSec();
    assertEquals(0, result.sec().second(), RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testDecrementSec2()
   {
    final Time time = Time.of(0, 0, 0);
    final Time result = time.decrementSec();
    assertAll("testDerementMin2", //$NON-NLS-1$
      () -> assertEquals(59, result.sec().second(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(59, result.min().minute(), RESULT_NOT_AS_EXPECTED),
      () -> assertEquals(23, result.hour().hour(), RESULT_NOT_AS_EXPECTED)
    );
   }

 }
