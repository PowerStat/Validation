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

import de.powerstat.validation.values.Country;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Country tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class CountryTests
 {
  /**
   * Default constructor.
   */
  public CountryTests()
   {
    super();
   }


  /**
   * Test Country with valid country codes.
   *
   * @param alpha2 Alpha-2 code
   */
  @ParameterizedTest
  @ValueSource(strings = {"DE"})
  public void countryOk0(final String alpha2)
   {
    final Country cleanCountry = Country.of(alpha2);
    assertEquals(alpha2, cleanCountry.getCountry(), "Country code not as expected"); //$NON-NLS-1$
   }


  /**
   * Test Country with country codes to short or long.
   *
   * @param alpha2 Alpha-2 codes
   */
  @ParameterizedTest
  @ValueSource(strings = {"D", "DEA"})
  public void countryLength(final String alpha2)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Country cleanCountry = */ Country.of(alpha2);
     }
    );
   }


  /**
   * Test Country with illegal parameters.
   *
   * @param alpha2 Alpha-2 code
   */
  @ParameterizedTest
  @ValueSource(strings = {"D~", "ZZ"})
  public void countryIllegalParameters(final String alpha2)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Country cleanCountry = */ Country.of(alpha2);
     }
    );
   }


  /**
   * Test get country code.
   */
  @Test
  public void getCountry()
   {
    final Country country = Country.of("DE"); //$NON-NLS-1$
    assertEquals("DE", country.getCountry(), "Country code not as expected"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Country country1 = Country.of("DE"); //$NON-NLS-1$
    final Country country2 = Country.of("DE"); //$NON-NLS-1$
    final Country country3 = Country.of("FR"); //$NON-NLS-1$
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(country1.hashCode(), country2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(country1.hashCode(), country3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Country country1 = Country.of("DE"); //$NON-NLS-1$
    final Country country2 = Country.of("DE"); //$NON-NLS-1$
    final Country country3 = Country.of("FR"); //$NON-NLS-1$
    final Country country4 = Country.of("DE"); //$NON-NLS-1$
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(country1.equals(country1), "country11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(country1.equals(country2), "country12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(country2.equals(country1), "country21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(country2.equals(country4), "country24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(country1.equals(country4), "country14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(country1.equals(country3), "country13 are equal"), //$NON-NLS-1$
      () -> assertFalse(country3.equals(country1), "country31 are equal"), //$NON-NLS-1$
      () -> assertFalse(country1.equals(null), "country10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Country country = Country.of("DE"); //$NON-NLS-1$
    assertEquals("Country[alpha2=DE]", country.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Country country1 = Country.of("DE"); //$NON-NLS-1$
    final Country country2 = Country.of("DE"); //$NON-NLS-1$
    final Country country3 = Country.of("FR"); //$NON-NLS-1$
    final Country country4 = Country.of("GB"); //$NON-NLS-1$
    final Country country5 = Country.of("DE"); //$NON-NLS-1$
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(country1.compareTo(country2) == -country2.compareTo(country1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(country1.compareTo(country3) == -country3.compareTo(country1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((country4.compareTo(country3) > 0) && (country3.compareTo(country1) > 0) && (country4.compareTo(country1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((country1.compareTo(country2) == 0) && (Math.abs(country1.compareTo(country5)) == Math.abs(country2.compareTo(country5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((country1.compareTo(country2) == 0) && country1.equals(country2), "equals") //$NON-NLS-1$
    );
   }

 }
