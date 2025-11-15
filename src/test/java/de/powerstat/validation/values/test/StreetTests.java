/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import nl.jqno.equalsverifier.*;
import de.powerstat.validation.values.Street;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Street tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class StreetTests
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
  /* default */ StreetTests()
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
  /* default */ void testStreetCorrect(final String street)
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
  /* default */ void testStreetLength(final String street)
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
  /* default */ void testStreetWrong(final String street)
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
  /* default */ void testStringValue()
   {
    final Street street = Street.of(StreetTests.HEMELINGER_HEERSTR);
    assertEquals(StreetTests.HEMELINGER_HEERSTR, street.stringValue(), StreetTests.STREET_NOT_AS_EXPECTED);
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(Street.class).withNonnullFields("street").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Street street = Street.of(StreetTests.HEMELINGER_HEERSTR);
    assertEquals("Street[street=Hemelinger Heerstr.]", street.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
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
