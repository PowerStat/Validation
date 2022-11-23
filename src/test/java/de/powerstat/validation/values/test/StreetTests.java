/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
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

import de.powerstat.validation.values.Street;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Street tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class StreetTests
 {
  /**
   * Street name.
   */
  private static final String ARBERGER_HEERSTR = "Arberger Heerstr."; //$NON-NLS-1$

  /**
   * Street name.
   */
  private static final String HEMELINGER_HEERSTR = "Hemelinger Heerstr."; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Street not as expected constant.
   */
  private static final String STREET_NOT_AS_EXPECTED = "Street not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public StreetTests()
   {
    super();
   }


  /**
   * Test correct Street.
   *
   * @param street Street
   */
  @ParameterizedTest
  @ValueSource(strings = {"Hemelinger Heerstraße", "A", "abcdefghijklmnopqrstuvwxyz abcde"})
  public void streetCorrect(final String street)
   {
    final Street cleanStreet = Street.of(street);
    assertEquals(street, cleanStreet.stringValue(), StreetTests.STREET_NOT_AS_EXPECTED);
   }


  /**
   * Test Street with wrong lengths.
   *
   * @param street Street
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "Abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefgh"})
  public void streetLength(final String street)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Street cleanStreet = */ Street.of(street);
     }, StreetTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test wrong Street.
   *
   * @param street Street
   */
  @ParameterizedTest
  @ValueSource(strings = {"abc_def"})
  public void streetWrong(final String street)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Street cleanStreet = */ Street.of(street);
     }, StreetTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get street.
   */
  @Test
  public void getStreet()
   {
    final Street street = Street.of(StreetTests.HEMELINGER_HEERSTR);
    assertEquals(StreetTests.HEMELINGER_HEERSTR, street.stringValue(), StreetTests.STREET_NOT_AS_EXPECTED);
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Street street1 = Street.of(StreetTests.ARBERGER_HEERSTR);
    final Street street2 = Street.of(StreetTests.ARBERGER_HEERSTR);
    final Street street3 = Street.of(StreetTests.HEMELINGER_HEERSTR);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(street1.hashCode(), street2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(street1.hashCode(), street3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Street street1 = Street.of(StreetTests.ARBERGER_HEERSTR);
    final Street street2 = Street.of(StreetTests.ARBERGER_HEERSTR);
    final Street street3 = Street.of(StreetTests.HEMELINGER_HEERSTR);
    final Street street4 = Street.of(StreetTests.ARBERGER_HEERSTR);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(street1.equals(street1), "street11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(street1.equals(street2), "street12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(street2.equals(street1), "street21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(street2.equals(street4), "street24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(street1.equals(street4), "street14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(street1.equals(street3), "street13 are equal"), //$NON-NLS-1$
      () -> assertFalse(street3.equals(street1), "street31 are equal"), //$NON-NLS-1$
      () -> assertFalse(street1.equals(null), "street10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Street street = Street.of(StreetTests.HEMELINGER_HEERSTR);
    assertEquals("Street[street=Hemelinger Heerstr.]", street.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Street street1 = Street.of(StreetTests.ARBERGER_HEERSTR);
    final Street street2 = Street.of(StreetTests.ARBERGER_HEERSTR);
    final Street street3 = Street.of(StreetTests.HEMELINGER_HEERSTR);
    final Street street4 = Street.of("Mahndorfer Heerstr."); //$NON-NLS-1$
    final Street street5 = Street.of(StreetTests.ARBERGER_HEERSTR);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(street1.compareTo(street2) == -street2.compareTo(street1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(street1.compareTo(street3) == -street3.compareTo(street1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((street4.compareTo(street3) > 0) && (street3.compareTo(street1) > 0) && (street4.compareTo(street1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((street1.compareTo(street2) == 0) && (Math.abs(street1.compareTo(street5)) == Math.abs(street2.compareTo(street5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((street1.compareTo(street2) == 0) && street1.equals(street2), "equals") //$NON-NLS-1$
    );
   }

 }
