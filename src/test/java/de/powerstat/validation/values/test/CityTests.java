/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import nl.jqno.equalsverifier.EqualsVerifier;
import de.powerstat.validation.values.City;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * City tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class CityTests
 {
  /**
   * Bremen.
   */
  private static final String BREMEN = "Bremen"; //$NON-NLS-1$

  /**
   * Hannover.
   */
  private static final String HANNOVER = "Hannover"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * City not as expected.
   */
  private static final String CITY_NOT_AS_EXPECTED = "City not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ CityTests()
   {
    super();
   }


  /**
   * Test correct City.
   *
   * @param city City
   */
  @ParameterizedTest
  @ValueSource(strings = {CityTests.BREMEN, "A", "Abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg"})
  /* default */ void testCityCorrect(final String city)
   {
    final City cleanCity = City.of(city);
    assertEquals(city, cleanCity.stringValue(), CityTests.CITY_NOT_AS_EXPECTED);
   }


  /**
   * Test City with wrong lengths.
   *
   * @param city City
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "Abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefgh"})
  /* default */ void testCityLength(final String city)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final City cleanCity = */ City.of(city);
     }, CityTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test wrong City.
   *
   * @param city City
   */
  @ParameterizedTest
  @ValueSource(strings = {"Bremen0815", "abc_def"})
  /* default */ void testCityWrong(final String city)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final City cleanCity = */ City.of(city);
     }, CityTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get city.
   */
  @Test
  /* default */ void testStringValue()
   {
    final City city = City.of(CityTests.BREMEN);
    assertEquals(CityTests.BREMEN, city.stringValue(), CityTests.CITY_NOT_AS_EXPECTED);
   }


  /**
   * Equalsverifier.
   */
  @Test
  /* default */ void testEqualsContract()
   {
    EqualsVerifier.forClass(City.class).withNonnullFields("city").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final City city = City.of(CityTests.BREMEN);
    assertEquals("City[city=Bremen]", city.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final City city1 = City.of(CityTests.BREMEN);
    final City city2 = City.of(CityTests.BREMEN);
    final City city3 = City.of("Hamburg"); //$NON-NLS-1$
    final City city4 = City.of(CityTests.HANNOVER);
    final City city5 = City.of(CityTests.BREMEN);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(city1.compareTo(city2) == -city2.compareTo(city1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(city1.compareTo(city3) == -city3.compareTo(city1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((city4.compareTo(city3) > 0) && (city3.compareTo(city1) > 0) && (city4.compareTo(city1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((city1.compareTo(city2) == 0) && (Math.abs(city1.compareTo(city5)) == Math.abs(city2.compareTo(city5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((city1.compareTo(city2) == 0) && city1.equals(city2), "equals") //$NON-NLS-1$
    );
   }

 }
