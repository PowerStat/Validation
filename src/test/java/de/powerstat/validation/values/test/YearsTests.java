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

import de.powerstat.validation.values.Years;

/**
 * Years tests.
 */
public class YearsTests
 {
  /**
   * Default constructor.
   */
  public YearsTests()
   {
    super();
   }


  /**
   * Is years.
   *
   * @param years Years
   */
  @ParameterizedTest
  @ValueSource(longs = {0, 20})
  public void isYears(final long years)
   {
    assertEquals(years, Years.of(years).getYears(), "Not a years!"); //$NON-NLS-1$
   }


  /**
   * Is not a years.
   *
   * @param years Years
   */
  @ParameterizedTest
  @ValueSource(longs = {-1})
  public void isNotAYears(final long years)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Years years = */ Years.of(years);
     }
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Years years1 = new Years(1);
    final Years years2 = new Years(1);
    final Years years3 = new Years(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(years1.hashCode(), years2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(years1.hashCode(), years3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Years years1 = new Years(1);
    final Years years2 = new Years(1);
    final Years years3 = new Years(2);
    final Years years4 = new Years(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(years1.equals(years1), "years11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(years1.equals(years2), "years12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(years2.equals(years1), "years21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(years2.equals(years4), "years24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(years1.equals(years4), "years14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(years1.equals(years3), "years13 are equal"), //$NON-NLS-1$
      () -> assertFalse(years3.equals(years1), "years31 are equal"), //$NON-NLS-1$
      () -> assertFalse(years1.equals(null), "years10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Years years = new Years(1);
    assertEquals("Years[years=1]", years.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Years years1 = new Years(1);
    final Years years2 = new Years(1);
    final Years years3 = new Years(2);
    final Years years4 = new Years(3);
    final Years years5 = new Years(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(years1.compareTo(years2) == -years2.compareTo(years1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(years1.compareTo(years3) == -years3.compareTo(years1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((years4.compareTo(years3) > 0) && (years3.compareTo(years1) > 0) && (years4.compareTo(years1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((years1.compareTo(years2) == 0) && (Math.abs(years1.compareTo(years5)) == Math.abs(years2.compareTo(years5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((years1.compareTo(years2) == 0) && years1.equals(years2), "equals") //$NON-NLS-1$
    );
   }

 }
