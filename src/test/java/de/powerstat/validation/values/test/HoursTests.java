/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
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
import nl.jqno.equalsverifier.*;
import de.powerstat.validation.values.Hostname;
import de.powerstat.validation.values.Hours;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Hours tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class HoursTests
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
   * Default constructor.
   */
  /* default */ HoursTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
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
  /* default */ void testIsHours(final long hours)
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
  /* default */ void testIsNotAHours(final long hours)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Hours hours = */ Hours.of(hours);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * longValue.
   */
  @Test
  /* default */ void testLongValue()
   {
    assertEquals(10, Hours.of(10).longValue(), HoursTests.NOT_A_HOURS);
   }


  /**
   * stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    assertEquals("10", Hours.of(10).stringValue(), HoursTests.NOT_A_HOURS);
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(Hours.class).verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Hours hours = Hours.of(1);
    assertEquals("Hours[hours=1]", hours.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
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
  /* default */ void testAdd1()
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
  /* default */ void testAdd2()
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
  /* default */ void testSubstract1()
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
  /* default */ void testSubstract2()
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
  /* default */ void testMultiply1()
   {
    final Hours hours1 = Hours.of(7);
    final Hours hoursResult = hours1.multiply(3);
    assertEquals(21, hoursResult.longValue(), HoursTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test multiply.
   */
  @Test
  /* default */ void testMultiply2()
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
  /* default */ void testDivide1()
   {
    final Hours hours1 = Hours.of(10);
    final Hours hoursResult = hours1.divide(2);
    assertEquals(5, hoursResult.longValue(), HoursTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testDivide2()
   {
    final Hours hours1 = Hours.of(10);
    final Hours hoursResult = hours1.divide(3);
    assertEquals(3, hoursResult.longValue(), HoursTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testDivide3()
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
  /* default */ void testModulo1()
   {
    final Hours hours1 = Hours.of(10);
    final Hours hoursResult = hours1.modulo(2);
    assertEquals(0, hoursResult.longValue(), HoursTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testModulo2()
   {
    final Hours hours1 = Hours.of(10);
    final Hours hoursResult = hours1.modulo(3);
    assertEquals(1, hoursResult.longValue(), HoursTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test divide.
   */
  @Test
  /* default */ void testModulo3()
   {
    final Hours hours1 = Hours.of(10);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Hours hoursResult = */ hours1.modulo(0);
     }, HoursTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
