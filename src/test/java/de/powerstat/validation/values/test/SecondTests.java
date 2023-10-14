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

import de.powerstat.validation.values.Second;
import de.powerstat.validation.values.Seconds;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Second tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
public class SecondTests
 {
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
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public SecondTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  public void factory1()
   {
    assertEquals(0, Second.of("0").intValue(), SecondTests.NOT_A_SECOND);
   }


  /**
   * Is second.
   *
   * @param second Second
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 59, 60})
  public void isSecond(final int second)
   {
    assertEquals(second, Second.of(second).intValue(), SecondTests.NOT_A_SECOND);
   }


  /**
   * Is not a second.
   *
   * @param second Second
   */
  @ParameterizedTest
  @ValueSource(ints = {-1, 61})
  public void isNotASecond(final int second)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Second second = */ Second.of(second);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * getSecond.
   *
   * @deprecated Old version of intValue()
   */
  @Deprecated(since = SecondTests.DEPRECATED_SINCE_3_0, forRemoval = false)
  @Test
  public void getSecond()
   {
    assertEquals(10, Second.of(10).getSecond(), SecondTests.NOT_A_SECOND);
   }


  /**
   * intValue.
   */
  @Test
  public void intValue()
   {
    assertEquals(10, Second.of(10).intValue(), SecondTests.NOT_A_SECOND);
   }


  /**
   * stringValue.
   */
  @Test
  public void stringValue()
   {
    assertEquals("10", Second.of(10).stringValue(), SecondTests.NOT_A_SECOND);
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Second second1 = Second.of(1);
    final Second second2 = Second.of(1);
    final Second second3 = Second.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(second1.hashCode(), second2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(second1.hashCode(), second3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Second second1 = Second.of(1);
    final Second second2 = Second.of(1);
    final Second second3 = Second.of(2);
    final Second second4 = Second.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(second1.equals(second1), "second11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(second1.equals(second2), "second12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(second2.equals(second1), "second21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(second2.equals(second4), "second24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(second1.equals(second4), "second14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(second1.equals(second3), "second13 are equal"), //$NON-NLS-1$
      () -> assertFalse(second3.equals(second1), "second31 are equal"), //$NON-NLS-1$
      () -> assertFalse(second1.equals(null), "second10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Second second = Second.of(1);
    assertEquals("Second[second=1]", second.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
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
  public void testAdd1()
   {
    final Second second = Second.of(1);
    final Seconds seconds = Seconds.of(1);
    final Second secondResult = second.add(seconds);
    assertEquals(2, secondResult.intValue(), SecondTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd2()
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
  public void testSubtract1()
   {
    final Second second = Second.of(2);
    final Seconds seconds = Seconds.of(1);
    final Second secondResult = second.subtract(seconds);
    assertEquals(1, secondResult.intValue(), SecondTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @Test
  public void testSubtract2()
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
  public void testIncrement1()
   {
    final Second second = Second.of(1);
    final Second secondResult = second.increment();
    assertEquals(2, secondResult.intValue(), SecondTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @Test
  public void testIncrement2()
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
  public void testDecrement1()
   {
    final Second second = Second.of(2);
    final Second secondResult = second.decrement();
    assertEquals(1, secondResult.intValue(), SecondTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @Test
  public void testDecrement2()
   {
    final Second second = Second.of(0);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Second secondResult = */ second.decrement();
     }, SecondTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
