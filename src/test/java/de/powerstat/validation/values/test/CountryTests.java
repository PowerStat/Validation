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
import de.powerstat.validation.values.City;
import de.powerstat.validation.values.Country;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Country tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class CountryTests
 {
  /**
   * FR france.
   */
  private static final String FR = "FR"; //$NON-NLS-1$

  /**
   * DE germany.
   */
  private static final String DE = "DE"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Country code not as expected.
   */
  private static final String COUNTRY_CODE_NOT_AS_EXPECTED = "Country code not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ CountryTests()
   {
    super();
   }


  /**
   * Test Country with valid country codes.
   *
   * @param alpha2 Alpha-2 code
   */
  @ParameterizedTest
  @ValueSource(strings = {CountryTests.DE})
  /* default */ void testCountryOk0(final String alpha2)
   {
    final Country cleanCountry = Country.of(alpha2);
    assertEquals(alpha2, cleanCountry.stringValue(), CountryTests.COUNTRY_CODE_NOT_AS_EXPECTED);
   }


  /**
   * Test Country with country codes to short or long.
   *
   * @param alpha2 Alpha-2 codes
   */
  @ParameterizedTest
  @ValueSource(strings = {"D", "DEA"})
  /* default */ void testCountryLength(final String alpha2)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Country cleanCountry = */ Country.of(alpha2);
     }, CountryTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test Country with illegal parameters.
   *
   * @param alpha2 Alpha-2 code
   */
  @ParameterizedTest
  @ValueSource(strings = {"D~", "ZZ"})
  /* default */ void testCountryIllegalParameters(final String alpha2)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Country cleanCountry = */ Country.of(alpha2);
     }, CountryTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get country code.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Country country = Country.of(CountryTests.DE);
    assertEquals(CountryTests.DE, country.stringValue(), CountryTests.COUNTRY_CODE_NOT_AS_EXPECTED);
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(Country.class).withNonnullFields("alpha2").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Country country = Country.of(CountryTests.DE);
    assertEquals("Country[alpha2=DE]", country.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Country country1 = Country.of(CountryTests.DE);
    final Country country2 = Country.of(CountryTests.DE);
    final Country country3 = Country.of(CountryTests.FR);
    final Country country4 = Country.of("GB"); //$NON-NLS-1$
    final Country country5 = Country.of(CountryTests.DE);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(country1.compareTo(country2) == -country2.compareTo(country1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(country1.compareTo(country3) == -country3.compareTo(country1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((country4.compareTo(country3) > 0) && (country3.compareTo(country1) > 0) && (country4.compareTo(country1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((country1.compareTo(country2) == 0) && (Math.abs(country1.compareTo(country5)) == Math.abs(country2.compareTo(country5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((country1.compareTo(country2) == 0) && country1.equals(country2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test getName.
   */
  @Test
  /* default */ void testGetName()
   {
    final Country country = Country.of(CountryTests.DE);
    String name = country.getEnglishCountryName();
    assertEquals("", name, "getEnglishCountryName as expected"); //$NON-NLS-1$ //$NON-NLS-2$
   }

 }
