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

import de.powerstat.validation.values.Week;
import de.powerstat.validation.values.Weeks;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Week tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
public class WeekTests
 {
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
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public WeekTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  public void factory1()
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
  public void isWeek(final int week)
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
  public void isNotAWeek(final int week)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Week week = */ Week.of(week);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * getWeek.
   *
   * @deprecated Old version of intValue()
   */
  @Deprecated(since = WeekTests.DEPRECATED_SINCE_3_0, forRemoval = false)
  @Test
  public void getWeek()
   {
    assertEquals(10, Week.of(10).getWeek(), WeekTests.NOT_A_WEEK);
   }


  /**
   * intValue.
   */
  @Test
  public void intValue()
   {
    assertEquals(10, Week.of(10).intValue(), WeekTests.NOT_A_WEEK);
   }


  /**
   * stringValue.
   */
  @Test
  public void stringValue()
   {
    assertEquals("10", Week.of(10).stringValue(), WeekTests.NOT_A_WEEK);
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Week week1 = Week.of(1);
    final Week week2 = Week.of(1);
    final Week week3 = Week.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(week1.hashCode(), week2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(week1.hashCode(), week3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Week week1 = Week.of(1);
    final Week week2 = Week.of(1);
    final Week week3 = Week.of(2);
    final Week week4 = Week.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(week1.equals(week1), "week11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(week1.equals(week2), "week12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(week2.equals(week1), "week21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(week2.equals(week4), "week24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(week1.equals(week4), "week14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(week1.equals(week3), "week13 are equal"), //$NON-NLS-1$
      () -> assertFalse(week3.equals(week1), "week31 are equal"), //$NON-NLS-1$
      () -> assertFalse(week1.equals(null), "week10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Week week = Week.of(1);
    assertEquals("Week[week=1]", week.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
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
  public void testAdd1()
   {
    final Week week = Week.of(1);
    final Weeks weeks = Weeks.of(1);
    final Week weekResult = week.add(weeks);
    assertEquals(2, weekResult.intValue(), WeekTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd2()
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
  public void testSubtract1()
   {
    final Week week = Week.of(2);
    final Weeks weeks = Weeks.of(1);
    final Week weekResult = week.subtract(weeks);
    assertEquals(1, weekResult.intValue(), WeekTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @Test
  public void testSubtract2()
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
  public void testIncrement1()
   {
    final Week week = Week.of(1);
    final Week weekResult = week.increment();
    assertEquals(2, weekResult.intValue(), WeekTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @Test
  public void testIncrement2()
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
  public void testDecrement1()
   {
    final Week week = Week.of(2);
    final Week weekResult = week.decrement();
    assertEquals(1, weekResult.intValue(), WeekTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @Test
  public void testDecrement2()
   {
    final Week week = Week.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Week weekResult = */ week.decrement();
     }, WeekTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
