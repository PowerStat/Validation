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
import nl.jqno.equalsverifier.EqualsVerifier;

import de.powerstat.validation.values.Week;
import de.powerstat.validation.values.Weeks;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Week tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class WeekTests
 {
  /**
   * Warning constant.
   */
  private static final String RV_RETURN_VALUE_IGNORED_INFERRED = "RV_RETURN_VALUE_IGNORED_INFERRED";

  /**
   * Not a week constant.
   */
  private static final String NOT_A_WEEK = "Not a week!"; //$NON-NLS-1$

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
  /* default */ WeekTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(1, Week.of("1").intValue(), WeekTests.NOT_A_WEEK);
   }


  /**
   * Is week.
   *
   * @param week Week
   */
  @ParameterizedTest
  @ValueSource(ints = {1, 53})
  /* default */ void testIsWeek(final int week)
   {
    assertEquals(week, Week.of(week).intValue(), WeekTests.NOT_A_WEEK);
   }


  /**
   * Is not a week.
   *
   * @param week Week
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 54})
  /* default */ void testIsNotAWeek(final int week)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Week week = */ Week.of(week);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * intValue.
   */
  @Test
  /* default */ void testIntValue()
   {
    assertEquals(10, Week.of(10).intValue(), WeekTests.NOT_A_WEEK);
   }


  /**
   * stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    assertEquals("10", Week.of(10).stringValue(), WeekTests.NOT_A_WEEK);
   }


  /**
   * Equalsverifier.
   */
  @Test
  /* default */ void testEqualsContract()
   {
    EqualsVerifier.forClass(Week.class).verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Week week = Week.of(1);
    assertEquals("Week[week=1]", week.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Week week1 = Week.of(1);
    final Week week2 = Week.of(1);
    final Week week3 = Week.of(2);
    final Week week4 = Week.of(3);
    final Week week5 = Week.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(week1.compareTo(week2) == -week2.compareTo(week1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(week1.compareTo(week3) == -week3.compareTo(week1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((week4.compareTo(week3) > 0) && (week3.compareTo(week1) > 0) && (week4.compareTo(week1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((week1.compareTo(week2) == 0) && (Math.abs(week1.compareTo(week5)) == Math.abs(week2.compareTo(week5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((week1.compareTo(week2) == 0) && week1.equals(week2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd1()
   {
    final Week week = Week.of(52);
    final Weeks weeks = Weeks.of(1);
    final Week weekResult = week.add(weeks);
    assertEquals(53, weekResult.intValue(), WeekTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testAdd2()
   {
    final Week week = Week.of(53);
    final Weeks weeks = Weeks.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Week weekResult = */ week.add(weeks);
     }, WeekTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test subtract.
   */
  @Test
  /* default */ void testSubtract1()
   {
    final Week week = Week.of(2);
    final Weeks weeks = Weeks.of(1);
    final Week weekResult = week.subtract(weeks);
    assertEquals(1, weekResult.intValue(), WeekTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testSubtract2()
   {
    final Week week = Week.of(1);
    final Weeks weeks = Weeks.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Week weekResult = */ week.subtract(weeks);
     }, WeekTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test increment.
   */
  @Test
  /* default */ void testIncrement1()
   {
    final Week week = Week.of(1);
    final Week weekResult = week.increment();
    assertEquals(2, weekResult.intValue(), WeekTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testIncrement2()
   {
    final Week week = Week.of(53);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Week weekResult = */ week.increment();
     }, WeekTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test decrement.
   */
  @Test
  /* default */ void testDecrement1()
   {
    final Week week = Week.of(2);
    final Week weekResult = week.decrement();
    assertEquals(1, weekResult.intValue(), WeekTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @SuppressFBWarnings(RV_RETURN_VALUE_IGNORED_INFERRED)
  @Test
  /* default */ void testDecrement2()
   {
    final Week week = Week.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Week weekResult = */ week.decrement();
     }, WeekTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
