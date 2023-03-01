/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
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

import de.powerstat.validation.values.Year;
import de.powerstat.validation.values.Years;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Year tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
public class YearTests
 {
  /**
   * Result nor as expecte constant.
   */
  private static final String RESULT_NOT_AS_EXPECTED = "Result not as expected"; //$NON-NLS-1$

  /**
   * Arithmetic exception expected constant.
   */
  private static final String ARITHMETIC_EXCEPTION_EXPECTED = "Arithmetic exception expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public YearTests()
   {
    super();
   }


  /**
   * Is year.
   *
   * @param year Year
   */
  @ParameterizedTest
  @ValueSource(longs = {-1, 1, 2020})
  public void isYear(final long year)
   {
    assertEquals(year, Year.of(year).year(), "Not a year!"); //$NON-NLS-1$
   }


  /**
   * Is not a year.
   *
   * @param year Year
   */
  @ParameterizedTest
  @ValueSource(longs = {0})
  public void isNotAYear(final long year)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Year year = */ Year.of(year);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Year year1 = Year.of(1);
    final Year year2 = Year.of(1);
    final Year year3 = Year.of(2);
    final Year year4 = Year.of(3);
    final Year year5 = Year.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(year1.compareTo(year2) == -year2.compareTo(year1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(year1.compareTo(year3) == -year3.compareTo(year1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((year4.compareTo(year3) > 0) && (year3.compareTo(year1) > 0) && (year4.compareTo(year1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((year1.compareTo(year2) == 0) && (Math.abs(year1.compareTo(year5)) == Math.abs(year2.compareTo(year5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((year1.compareTo(year2) == 0) && year1.equals(year2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd1()
   {
    final Year year = Year.of(2022);
    final Years years = Years.of(1);
    final Year yearResult = year.add(years);
    assertEquals(2023, yearResult.year(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd2()
   {
    final Year year = Year.of(-1);
    final Years years = Years.of(1);
    final Year yearResult = year.add(years);
    assertEquals(1, yearResult.year(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd3()
   {
    final Year year = Year.of(Long.MAX_VALUE);
    final Years years = Years.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Year yearResult = */ year.add(years);
     }, YearTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test add.
   */
  @Test
  public void testAdd4()
   {
    final Year year = Year.of(-2);
    final Years years = Years.of(1);
    final Year yearResult = year.add(years);
    assertEquals(-1, yearResult.year(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @Test
  public void testSubtract1()
   {
    final Year year = Year.of(2022);
    final Years years = Years.of(1);
    final Year yearResult = year.subtract(years);
    assertEquals(2021, yearResult.year(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @Test
  public void testSubtract2()
   {
    final Year year = Year.of(1);
    final Years years = Years.of(1);
    final Year yearResult = year.subtract(years);
    assertEquals(-1, yearResult.year(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test subtract.
   */
  @Test
  public void testSubtract3()
   {
    final Year year = Year.of(Long.MIN_VALUE);
    final Years years = Years.of(1);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Year yearResult = */ year.subtract(years);
     }, YearTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test subtract.
   */
  @Test
  public void testSubtract4()
   {
    final Year year = Year.of(-1);
    final Years years = Years.of(1);
    final Year yearResult = year.subtract(years);
    assertEquals(-2, yearResult.year(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test incfrement.
   */
  @Test
  public void testIncrement1()
   {
    final Year year = Year.of(2022);
    final Year yearResult = year.increment();
    assertEquals(2023, yearResult.year(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @Test
  public void testIncrement2()
   {
    final Year year = Year.of(-1);
    final Year yearResult = year.increment();
    assertEquals(1, yearResult.year(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test increment.
   */
  @Test
  public void testIncrement3()
   {
    final Year year = Year.of(Long.MAX_VALUE);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Year yearResult = */ year.increment();
     }, YearTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test decrement.
   */
  @Test
  public void testDecrement1()
   {
    final Year year = Year.of(2022);
    final Year yearResult = year.decrement();
    assertEquals(2021, yearResult.year(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @Test
  public void testDecrement2()
   {
    final Year year = Year.of(1);
    final Year yearResult = year.decrement();
    assertEquals(-1, yearResult.year(), YearTests.RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test decrement.
   */
  @Test
  public void testDecrement3()
   {
    final Year year = Year.of(Long.MIN_VALUE);
    assertThrows(ArithmeticException.class, () ->
     {
      /* final Year yearResult = */ year.decrement();
     }, YearTests.ARITHMETIC_EXCEPTION_EXPECTED
    );
   }

 }
