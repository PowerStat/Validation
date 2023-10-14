/*
 * Copyright (C) 2021-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
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

import de.powerstat.validation.values.Millisecond;
import de.powerstat.validation.values.Milliseconds;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Millisecond tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
public class MillisecondTests
 {
  /**
   * Not millisecond constant.
   */
  private static final String NOT_MILLISECOND = "Not millisecond!"; //$NON-NLS-1$

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
  public MillisecondTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  public void fatory1()
   {
    assertEquals(0, Millisecond.of("0").intValue(), MillisecondTests.NOT_MILLISECOND);
   }


  /**
   * Is millisecond.
   *
   * @param millisecond Millisecond
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 999})
  public void isMilliseconds(final int millisecond)
   {
    assertEquals(millisecond, Millisecond.of(millisecond).intValue(), MillisecondTests.NOT_MILLISECOND);
   }

  /**
   * Is not a millisecond.
   *
   * @param millisecond Millisecond
   */
  @ParameterizedTest
  @ValueSource(ints = {-1, 1000})
  public void isNotAMillisecond(final int millisecond)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Millisecond millisecond = */ Millisecond.of(millisecond);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * getMillisecond.
   *
   * @deprecated Old version of intValue()
   */
  @Deprecated(since = MillisecondTests.DEPRECATED_SINCE_3_0, forRemoval = false)
  @Test
  public void getMillisecond()
   {
    assertEquals(10, Millisecond.of(10).getMillisecond(), MillisecondTests.NOT_MILLISECOND);
   }


  /**
   * intValue.
   */
  @Test
  public void intValue()
   {
    assertEquals(10, Millisecond.of(10).intValue(), MillisecondTests.NOT_MILLISECOND);
   }


  /**
   * stringValue.
   */
  @Test
  public void stringValue()
   {
    assertEquals("10", Millisecond.of(10).stringValue(), MillisecondTests.NOT_MILLISECOND);
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Millisecond millisecond1 = Millisecond.of(0);
    final Millisecond millisecond2 = Millisecond.of(0);
    final Millisecond millisecond3 = Millisecond.of(1);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(millisecond1.hashCode(), millisecond2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(millisecond1.hashCode(), millisecond3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Millisecond millisecond1 = Millisecond.of(0);
    final Millisecond millisecond2 = Millisecond.of(0);
    final Millisecond millisecond3 = Millisecond.of(1);
    final Millisecond millisecond4 = Millisecond.of(0);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(millisecond1.equals(millisecond1), "millisecond11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(millisecond1.equals(millisecond2), "millisecond12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(millisecond2.equals(millisecond1), "millisecond21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(millisecond2.equals(millisecond4), "millisecond24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(millisecond1.equals(millisecond4), "millisecons14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(millisecond1.equals(millisecond3), "millisecond13 are equal"), //$NON-NLS-1$
      () -> assertFalse(millisecond3.equals(millisecond1), "millisecond31 are equal"), //$NON-NLS-1$
      () -> assertFalse(millisecond1.equals(null), "millisecond10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Millisecond millisecond = Millisecond.of(0);
    assertEquals("Millisecond[millisecond=0]", millisecond.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Millisecond millisecond1 = Millisecond.of(1);
    final Millisecond millisecond2 = Millisecond.of(1);
    final Millisecond millisecond3 = Millisecond.of(2);
    final Millisecond millisecond4 = Millisecond.of(3);
    final Millisecond millisecond5 = Millisecond.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(millisecond1.compareTo(millisecond2) == -millisecond2.compareTo(millisecond1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(millisecond1.compareTo(millisecond3) == -millisecond3.compareTo(millisecond1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((millisecond4.compareTo(millisecond3) > 0) && (millisecond3.compareTo(millisecond1) > 0) && (millisecond4.compareTo(millisecond1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((millisecond1.compareTo(millisecond2) == 0) && (Math.abs(millisecond1.compareTo(millisecond5)) == Math.abs(millisecond2.compareTo(millisecond5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((millisecond1.compareTo(millisecond2) == 0) && millisecond1.equals(millisecond2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd1()
   {
    final Millisecond millisecond = Millisecond.of(0);
    final Milliseconds milliseconds = Milliseconds.of(1);
    final Millisecond millisecondResult = millisecond.add(milliseconds);
    assertEquals(1, millisecondResult.intValue(), MillisecondTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd2()
   {
    final Millisecond millisecond = Millisecond.of(999);
    final Milliseconds milliseconds = Milliseconds.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Millisecond millisecondResult = */ millisecond.add(milliseconds);
     }, MillisecondTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test subtract.
   */
  @Test
  public void testSubtract1()
   {
    final Millisecond millisecond = Millisecond.of(2);
    final Milliseconds milliseconds = Milliseconds.of(1);
    final Millisecond millisecondResult = millisecond.subtract(milliseconds);
    assertEquals(1, millisecondResult.intValue(), MillisecondTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @Test
  public void testSubtract2()
   {
    final Millisecond millisecond = Millisecond.of(0);
    final Milliseconds milliseconds = Milliseconds.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Millisecond millisecondResult = */ millisecond.subtract(milliseconds);
     }, MillisecondTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test add.
   */
  @Test
  public void testIncrement1()
   {
    final Millisecond millisecond = Millisecond.of(0);
    final Millisecond millisecondResult = millisecond.increment();
    assertEquals(1, millisecondResult.intValue(), MillisecondTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  public void testIncrement2()
   {
    final Millisecond millisecond = Millisecond.of(999);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Millisecond millisecondResult = */ millisecond.increment();
     }, MillisecondTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test add.
   */
  @Test
  public void testDecrement1()
   {
    final Millisecond millisecond = Millisecond.of(2);
    final Millisecond millisecondResult = millisecond.decrement();
    assertEquals(1, millisecondResult.intValue(), MillisecondTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  public void testDecrement2()
   {
    final Millisecond millisecond = Millisecond.of(0);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Millisecond millisecondResult = */ millisecond.decrement();
     }, MillisecondTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
