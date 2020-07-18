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

import de.powerstat.validation.values.District;


/**
 * District tests.
 */
public class DistrictTests
 {
  /**
   * Default constructor.
   */
  public DistrictTests()
   {
    super();
   }


  /**
   * Test correct District.
   *
   * @param district District
   */
  @ParameterizedTest
  @ValueSource(strings = {"9", "Abcdefghijklmnopqr"})
  public void districtCorrect(final String district)
   {
    final District cleanDistrict = District.of(district);
    assertEquals(district, cleanDistrict.getDistrict(), "District not as expected"); //$NON-NLS-1$
   }


  /**
   * Test District with wrong lengths.
   *
   * @param district District
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "Abcdefghijklmnopqrs"})
  public void districtLength(final String district)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final District cleanDistrict = */ District.of(district);
     }
    );
   }


  /**
   * Test wrong District.
   *
   * @param district District
   */
  @ParameterizedTest
  @ValueSource(strings = {"abc_def"})
  public void districtWrong(final String district)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final District cleanDistrict = */ District.of(district);
     }
    );
   }


  /**
   * Test get district.
   */
  @Test
  public void getDistrict()
   {
    final District district = District.of("9"); //$NON-NLS-1$
    assertEquals("9", district.getDistrict(), "District not as expected"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final District district1 = District.of("9"); //$NON-NLS-1$
    final District district2 = District.of("9"); //$NON-NLS-1$
    final District district3 = District.of("abc"); //$NON-NLS-1$
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(district1.hashCode(), district2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(district1.hashCode(), district3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final District district1 = District.of("9"); //$NON-NLS-1$
    final District district2 = District.of("9"); //$NON-NLS-1$
    final District district3 = District.of("abc"); //$NON-NLS-1$
    final District district4 = District.of("9"); //$NON-NLS-1$
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(district1.equals(district1), "district11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(district1.equals(district2), "district12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(district2.equals(district1), "district21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(district2.equals(district4), "district24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(district1.equals(district4), "district14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(district1.equals(district3), "district13 are equal"), //$NON-NLS-1$
      () -> assertFalse(district3.equals(district1), "district31 are equal"), //$NON-NLS-1$
      () -> assertFalse(district1.equals(null), "district10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final District district = District.of("9");
    assertEquals("District[district=9]", district.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final District district1 = District.of("9"); //$NON-NLS-1$
    final District district2 = District.of("9"); //$NON-NLS-1$
    final District district3 = District.of("abc"); //$NON-NLS-1$
    final District district4 = District.of("def"); //$NON-NLS-1$
    final District district5 = District.of("9"); //$NON-NLS-1$
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(district1.compareTo(district2) == -district2.compareTo(district1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(district1.compareTo(district3) == -district3.compareTo(district1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((district4.compareTo(district3) > 0) && (district3.compareTo(district1) > 0) && (district4.compareTo(district1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((district1.compareTo(district2) == 0) && (Math.abs(district1.compareTo(district5)) == Math.abs(district2.compareTo(district5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((district1.compareTo(district2) == 0) && district1.equals(district2), "equals") //$NON-NLS-1$
    );
   }

 }
