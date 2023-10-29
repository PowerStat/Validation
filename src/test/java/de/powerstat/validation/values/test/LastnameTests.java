/*
 * Copyright (C) 2022-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
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

import de.powerstat.validation.values.Lastname;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Lastname tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class LastnameTests
 {
  /**
   * Lastname.
   */
  private static final String LASTNAME = "lastname"; //$NON-NLS-1$

  /**
   * Lastname z.
   */
  private static final String LASTNAMEZ = "lastnamez"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Lastname not as expected constant.
   */
  private static final String LASTNAME_NOT_AS_EXPECTED = "Lastname not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ LastnameTests()
   {
    super();
   }


  /**
   * Test Lastname with valid values.
   *
   * @param lastname Lastname
   */
  @ParameterizedTest
  @ValueSource(strings = {"H", "Hofmann", LastnameTests.LASTNAME, "AbcdefghijklmnopqrstuvwxyzäöüßABCDEFGHIJ"})
  /* default */ void testLastnameOk0(final String lastname)
   {
    final Lastname cleanLastname = Lastname.of(lastname);
    assertEquals(lastname, cleanLastname.stringValue(), LastnameTests.LASTNAME_NOT_AS_EXPECTED);
   }


  /**
   * Test Lastname with lastname to short or long.
   *
   * @param lastname Lastname
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "AbcdefghijklmnopqrstuvwxyzäöüßABCDEFGHIJK"})
  /* default */ void testLastnameLength(final String lastname)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Lastname cleanLastname = */ Lastname.of(lastname);
     }, LastnameTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test Lastname with illegal characters.
   */
  @Test
  /* default */ void testLastnameWithIllegalCharacters0()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Lastname cleanLastname = */ Lastname.of("^!$%&(){}[]=?+*#´§;,:'\""); //$NON-NLS-1$
     }, LastnameTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get lastname.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Lastname lastname = Lastname.of(LastnameTests.LASTNAME);
    assertEquals(LastnameTests.LASTNAME, lastname.stringValue(), LastnameTests.LASTNAME_NOT_AS_EXPECTED);
   }


  /**
   * Test hash code.
   */
  @Test
  /* default */ void testHashCode()
   {
    final Lastname lastname1 = Lastname.of(LastnameTests.LASTNAME);
    final Lastname lastname2 = Lastname.of(LastnameTests.LASTNAME);
    final Lastname lastname3 = Lastname.of(LastnameTests.LASTNAMEZ);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(lastname1.hashCode(), lastname2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(lastname1.hashCode(), lastname3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testEquals()
   {
    final Lastname lastname1 = Lastname.of(LastnameTests.LASTNAME);
    final Lastname lastname2 = Lastname.of(LastnameTests.LASTNAME);
    final Lastname lastname3 = Lastname.of(LastnameTests.LASTNAMEZ);
    final Lastname lastname4 = Lastname.of(LastnameTests.LASTNAME);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(lastname1.equals(lastname1), "lastname11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(lastname1.equals(lastname2), "lastname12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(lastname2.equals(lastname1), "lastname21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(lastname2.equals(lastname4), "lastname24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(lastname1.equals(lastname4), "lastname14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(lastname1.equals(lastname3), "lastname13 are equal"), //$NON-NLS-1$
      () -> assertFalse(lastname3.equals(lastname1), "lastname31 are equal"), //$NON-NLS-1$
      () -> assertFalse(lastname1.equals(null), "lastname10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Lastname lastname = Lastname.of(LastnameTests.LASTNAME);
    assertEquals("Lastname[lastname=lastname]", lastname.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Lastname lastname1 = Lastname.of(LastnameTests.LASTNAME);
    final Lastname lastname2 = Lastname.of(LastnameTests.LASTNAME);
    final Lastname lastname3 = Lastname.of("lastnamey"); //$NON-NLS-1$
    final Lastname lastname4 = Lastname.of(LastnameTests.LASTNAMEZ);
    final Lastname lastname5 = Lastname.of(LastnameTests.LASTNAME);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(lastname1.compareTo(lastname2) == -lastname2.compareTo(lastname1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(lastname1.compareTo(lastname3) == -lastname3.compareTo(lastname1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((lastname4.compareTo(lastname3) > 0) && (lastname3.compareTo(lastname1) > 0) && (lastname4.compareTo(lastname1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((lastname1.compareTo(lastname2) == 0) && (Math.abs(lastname1.compareTo(lastname5)) == Math.abs(lastname2.compareTo(lastname5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((lastname1.compareTo(lastname2) == 0) && lastname1.equals(lastname2), "equals") //$NON-NLS-1$
    );
   }

 }
