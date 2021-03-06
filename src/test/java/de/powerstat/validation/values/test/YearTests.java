/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
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
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Year tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class YearTests
 {
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
    assertEquals(year, Year.of(year).getYear(), "Not a year!"); //$NON-NLS-1$
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
     }
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Year year1 = Year.of(1);
    final Year year2 = Year.of(1);
    final Year year3 = Year.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(year1.hashCode(), year2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(year1.hashCode(), year3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Year year1 = Year.of(1);
    final Year year2 = Year.of(1);
    final Year year3 = Year.of(2);
    final Year year4 = Year.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(year1.equals(year1), "year11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(year1.equals(year2), "year12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(year2.equals(year1), "year21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(year2.equals(year4), "year24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(year1.equals(year4), "year14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(year1.equals(year3), "year13 are equal"), //$NON-NLS-1$
      () -> assertFalse(year3.equals(year1), "year31 are equal"), //$NON-NLS-1$
      () -> assertFalse(year1.equals(null), "year10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Year year = Year.of(1);
    assertEquals("Year[year=1]", year.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
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

 }
