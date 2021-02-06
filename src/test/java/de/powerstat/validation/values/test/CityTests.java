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

import de.powerstat.validation.values.City;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * City tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT"})
public class CityTests
 {
  /**
   * Bremen.
   */
  private static final String BREMEN = "Bremen"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public CityTests()
   {
    super();
   }


  /**
   * Test correct City.
   *
   * @param city City
   */
  @ParameterizedTest
  @ValueSource(strings = {BREMEN, "A", "Abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg"})
  public void cityCorrect(final String city)
   {
    final City cleanCity = City.of(city);
    assertEquals(city, cleanCity.getCity(), "City not as expected"); //$NON-NLS-1$
   }


  /**
   * Test City with wrong lengths.
   *
   * @param city City
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "Abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefgh"})
  public void cityLength(final String city)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final City cleanCity = */ City.of(city);
     }
    );
   }


  /**
   * Test wrong City.
   *
   * @param city City
   */
  @ParameterizedTest
  @ValueSource(strings = {"Bremen0815", "abc_def"})
  public void cityWrong(final String city)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final City cleanCity = */ City.of(city);
     }
    );
   }


  /**
   * Test get city.
   */
  @Test
  public void getCity()
   {
    final City city = City.of(BREMEN);
    assertEquals(BREMEN, city.getCity(), "City not as expected"); //$NON-NLS-1$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final City city1 = City.of(BREMEN);
    final City city2 = City.of(BREMEN);
    final City city3 = City.of("Hannover"); //$NON-NLS-1$
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(city1.hashCode(), city2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(city1.hashCode(), city3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final City city1 = City.of(BREMEN);
    final City city2 = City.of(BREMEN);
    final City city3 = City.of("Hannover"); //$NON-NLS-1$
    final City city4 = City.of(BREMEN);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(city1.equals(city1), "city11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(city1.equals(city2), "city12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(city2.equals(city1), "city21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(city2.equals(city4), "city24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(city1.equals(city4), "city14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(city1.equals(city3), "city13 are equal"), //$NON-NLS-1$
      () -> assertFalse(city3.equals(city1), "city31 are equal"), //$NON-NLS-1$
      () -> assertFalse(city1.equals(null), "city10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final City city = City.of(BREMEN);
    assertEquals("City[city=Bremen]", city.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final City city1 = City.of(BREMEN);
    final City city2 = City.of(BREMEN);
    final City city3 = City.of("Hamburg"); //$NON-NLS-1$
    final City city4 = City.of("Hannover"); //$NON-NLS-1$
    final City city5 = City.of(BREMEN);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(city1.compareTo(city2) == -city2.compareTo(city1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(city1.compareTo(city3) == -city3.compareTo(city1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((city4.compareTo(city3) > 0) && (city3.compareTo(city1) > 0) && (city4.compareTo(city1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((city1.compareTo(city2) == 0) && (Math.abs(city1.compareTo(city5)) == Math.abs(city2.compareTo(city5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((city1.compareTo(city2) == 0) && city1.equals(city2), "equals") //$NON-NLS-1$
    );
   }

 }
