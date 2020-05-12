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

import de.powerstat.validation.values.StreetNr;


/**
 * Street number tests.
 */
public class StreetNrTests
 {
  /**
   * Default constructor.
   */
  public StreetNrTests()
   {
    super();
   }


  /**
   * Test correct StreetNr.
   *
   * @param streetNr StreetNr
   */
  @ParameterizedTest
  @ValueSource(strings = {"9", "42", "42-44", "42/44", "42 a", "42 1/3", "42 1/3 a", "29998-29999 998/999 a", "29999", "42 4/4"})
  public void streetNrCorrect(final String streetNr)
   {
    final StreetNr cleanStreetNr = StreetNr.of(streetNr);
    assertEquals(streetNr, cleanStreetNr.getStreetNr(), "StreetNr not as expected"); //$NON-NLS-1$
   }


  /**
   * Test StreetNr with wrong lengths.
   *
   * @param streetNr StreetNr
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "1234567890123456789012"})
  public void streetNrLength(final String streetNr)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final StreetNr cleanStreetNr = */ StreetNr.of(streetNr);
     }
    );
   }


  /**
   * Test wrong StreetNr.
   *
   * @param streetNr StreetNr
   */
  @ParameterizedTest
  @ValueSource(strings = {"4a2", "30000", "43-42", "42-42", "42 5/4"})
  public void streetNrWrong(final String streetNr)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final StreetNr cleanStreetNr = */ StreetNr.of(streetNr);
     }
    );
   }


  /**
   * Test get streetNr.
   */
  @Test
  public void getStreetNr()
   {
    final StreetNr streetNr = StreetNr.of("42"); //$NON-NLS-1$
    assertEquals("42", streetNr.getStreetNr(), "StreetNr not as expected"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final StreetNr streetNr1 = new StreetNr("23"); //$NON-NLS-1$
    final StreetNr streetNr2 = new StreetNr("23"); //$NON-NLS-1$
    final StreetNr streetNr3 = new StreetNr("42"); //$NON-NLS-1$
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(streetNr1.hashCode(), streetNr2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(streetNr1.hashCode(), streetNr3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final StreetNr iban1 = new StreetNr("23"); //$NON-NLS-1$
    final StreetNr iban2 = new StreetNr("23"); //$NON-NLS-1$
    final StreetNr iban3 = new StreetNr("42"); //$NON-NLS-1$
    final StreetNr iban4 = new StreetNr("23"); //$NON-NLS-1$
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(iban1.equals(iban1), "StreetNr11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(iban1.equals(iban2), "StreetNr12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(iban2.equals(iban1), "StreetNr21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(iban2.equals(iban4), "StreetNr24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(iban1.equals(iban4), "StreetNr14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(iban1.equals(iban3), "StreetNr13 are equal"), //$NON-NLS-1$
      () -> assertFalse(iban3.equals(iban1), "StreetNr31 are equal"), //$NON-NLS-1$
      () -> assertFalse(iban1.equals(null), "StreetNr10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final StreetNr streetNr = new StreetNr("42"); //$NON-NLS-1$
    assertEquals("StreetNr[streetNr=42]", streetNr.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final StreetNr streetNr1 = new StreetNr("23"); //$NON-NLS-1$
    final StreetNr streetNr2 = new StreetNr("23"); //$NON-NLS-1$
    final StreetNr streetNr3 = new StreetNr("42"); //$NON-NLS-1$
    final StreetNr streetNr4 = new StreetNr("99"); //$NON-NLS-1$
    final StreetNr streetNr5 = new StreetNr("23"); //$NON-NLS-1$
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(streetNr1.compareTo(streetNr2) == -streetNr2.compareTo(streetNr1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(streetNr1.compareTo(streetNr3) == -streetNr3.compareTo(streetNr1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((streetNr4.compareTo(streetNr3) > 0) && (streetNr3.compareTo(streetNr1) > 0) && (streetNr4.compareTo(streetNr1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((streetNr1.compareTo(streetNr2) == 0) && (Math.abs(streetNr1.compareTo(streetNr5)) == Math.abs(streetNr2.compareTo(streetNr5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((streetNr1.compareTo(streetNr2) == 0) && streetNr1.equals(streetNr2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test compareTo ok.
   */
  @Test
  public void testCompareToOk()
   {
    final StreetNr streetNr1 = new StreetNr("23"); //$NON-NLS-1$
    final StreetNr streetNr2 = new StreetNr("23"); //$NON-NLS-1$
    final StreetNr streetNr3 = new StreetNr("23 1/4"); //$NON-NLS-1$
    final StreetNr streetNr4 = new StreetNr("23 1/4"); //$NON-NLS-1$
    final StreetNr streetNr5 = new StreetNr("23 2/4"); //$NON-NLS-1$
    final StreetNr streetNr6 = new StreetNr("23 a"); //$NON-NLS-1$
    final StreetNr streetNr7 = new StreetNr("23 b"); //$NON-NLS-1$
    final StreetNr streetNr8 = new StreetNr("23 1/4 a"); //$NON-NLS-1$
    final StreetNr streetNr9 = new StreetNr("23 1/4 b"); //$NON-NLS-1$
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(streetNr1.compareTo(streetNr2) == 0, "equal1"), //$NON-NLS-1$
      () -> assertTrue(streetNr1.compareTo(streetNr3) < 0, "23 < 23 1/4"), //$NON-NLS-1$
      () -> assertTrue(streetNr3.compareTo(streetNr1) > 0, "23 1/4 > 23"), //$NON-NLS-1$
      () -> assertTrue(streetNr3.compareTo(streetNr4) == 0, "equal2"), //$NON-NLS-1$
      () -> assertTrue(streetNr4.compareTo(streetNr5) < 0, "23 1/4 < 23 2/4"), //$NON-NLS-1$
      () -> assertTrue(streetNr1.compareTo(streetNr6) < 0, "23 < 23 a"), //$NON-NLS-1$
      () -> assertTrue(streetNr6.compareTo(streetNr1) > 0, "23 a > 23"), //$NON-NLS-1$
      () -> assertTrue(streetNr6.compareTo(streetNr7) < 0, "23 a < 23 b"), //$NON-NLS-1$
      () -> assertTrue(streetNr8.compareTo(streetNr9) < 0, "23 1/4 a < 23 1/4 b") //$NON-NLS-1$
    );
   }


  /**
   * Test compareTo wrong.
   */
  @Test
  public void testCompareTowrong()
   {
    final StreetNr streetNr1 = new StreetNr("23 1/3"); //$NON-NLS-1$
    final StreetNr streetNr2 = new StreetNr("23 1/4"); //$NON-NLS-1$
    assertThrows(IllegalStateException.class, () ->
     {
      /* final int result = */ streetNr1.compareTo(streetNr2);
     }
    );
   }

 }
