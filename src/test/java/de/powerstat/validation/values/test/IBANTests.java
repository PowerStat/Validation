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

import de.powerstat.validation.values.IBAN;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * IBAN tests.
 *
 * TODO Human formatted output
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class IBANTests
 {
  /**
   * Test iban.
   */
  private static final String IBAN_DE07123412341234123412 = "DE07123412341234123412"; //$NON-NLS-1$

  /**
   * Test iban.
   */
  private static final String IBAN_DE68210501700012345678 = "DE68210501700012345678"; //$NON-NLS-1$

  /**
   * IBAN not as expected constant.
   */
  private static final String IBAN_NOT_AS_EXPECTED = "IBAN not as expected"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public IBANTests()
   {
    super();
   }


  /**
   * Test correct IBAN.
   *
   * @param iban IBAN
   */
  @ParameterizedTest
  @ValueSource(strings = {IBANTests.IBAN_DE68210501700012345678, IBANTests.IBAN_DE07123412341234123412, "NO2156789012345", "LC965678901234567890123456789012", "TT83567890123456789012345678901234",
    "EG5156789012345678901234567", "AL185678901A3456789012345678", "DZ79567890123456789012AB", "AD0556789012345678901234", "AO455678901234567890123AB", "AZ84567890123456789012345678", "BH72567890123456789012", "BE365678901234AB", "BJ705678901234567890123456AB", "BA0456789012345678AB", "BR305678901234567890123456789", "VG9856789012345678901234", "BG75567890123456789012", "BF96567890123456789012345AB", "BI57567890123456", "CR82056789012345678901", "CI645678901234567890123456AB", "DK195678901234567A", "DO90567890123456789012345678", "SV31567890123456789012345678", "EE54567890123456789A", "FO865678901234567A", "FI075678901234567A", "FR24567890123456789012345AB", "GA66567890123456789012345AB", "GE36567890123456789012", "GI895678901234567890123", "GR9756789012345678901234567", "GL865678901234567A", "GT48567890123456789012345678", "IQ475678901234567890123", "IR035678901234567890123456", "IE18567890123456789012", "IS08567890123456XXXXXXXXXX", "IL625678901234567890123", "IT37A5678901234567890123456", "JO0556789012345678901234567890", "CM66567890123456789012345AB", "CV065678901234567890123AB", "KZ275678901234567890", "QA435678901234567890123456789", "CG84567890123456789012345AB",
    // "XK525678901234567890", // Not an ISO3166 alpha 2 code
    "HR3756789012345678901", "KW6956789012345678901234567890", "LV8656789012345678901", "LB57567890123456789012345678", "LI2856789012345678901", "LT365678901234567890", "LU335678901234567890", "MG91567890123456789012345AB", "ML625678901234567890123456AB", "MT25567890123456789012345678901", "MR58567890123456789012345AB", "MU7956789012345678901234567ABC", "MD9156789012345678901234", "MC06567890123456789012345AB", "ME955678901234567890AB", "MZ985678901234567890123AB", "NL9556789012345678", "MK315678901234567AB", "AT385678901234567890", "TL3056789012345678901AB", "PK4356789012345678901234", "PS955678901234567890123456789", "PL775678901A3456789012345678", "PT895678901234567890123AB", "RO1356789012345678901234", "SM24A6789012345678901234567", "ST625678901234567890123AB", "SA4656789012345678901234", "CH1556789012345678901", "SN025678901234567890123456AB", "RS085678901234567890AB", "SC98567890123456789012345678XXX", "SK1656789012345678901234", "SI805678901234567AB", "ES4456789012AB5678901234", "CZ1856789012345678901234", "TN68567890123456789012AB", "TR985678901234567890123456", "UA075678901234567890123456789", "HU505678901A345678901234567A", "VA345678901234567890123456", "AE585678901234567890123", "GB45567890123456789012", "BY78567890123456789012345678", "CY69567890123456789012345678", "CF87567890123456789012345AB"
   })
  public void ibanCorrect(final String iban)
   {
    final IBAN cleanIban = IBAN.of(iban);
    assertEquals(iban, cleanIban.stringValue(), IBANTests.IBAN_NOT_AS_EXPECTED);
   }


  /**
   * Test IBAN with wrong lengths.
   *
   * @param iban IBAN
   */
  @ParameterizedTest
  @ValueSource(strings = {"DE345678901234", "DE345678901234567890123456789012345"})
  public void ibanLength(final String iban)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IBAN cleanIban = */ IBAN.of(iban);
     }, IBANTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test wrong IBAN.
   *
   * @param iban IBAN
   */
  @ParameterizedTest
  @ValueSource(strings = {"ZZ0056789012345", "DE0156789012345", "DE9956789012345", "DE025678A012345", "DE67210501700012345678", "DE7321050170001234567X", "DE0021050170001234567Ä"})
  public void ibanWrong(final String iban)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IBAN cleanIban = */ IBAN.of(iban);
     }, IBANTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get iban.
   *
   * @deprecated Old version of stringValue()
   */
  @Deprecated(since = IBANTests.DEPRECATED_SINCE_3_0, forRemoval = false)
  @Test
  public void getIban()
   {
    final IBAN iban = IBAN.of(IBANTests.IBAN_DE68210501700012345678);
    assertEquals(IBANTests.IBAN_DE68210501700012345678, iban.getIBAN(), IBANTests.IBAN_NOT_AS_EXPECTED);
   }


  /**
   * Test get iban.
   */
  @Test
  public void stringValue()
   {
    final IBAN iban = IBAN.of(IBANTests.IBAN_DE68210501700012345678);
    assertEquals(IBANTests.IBAN_DE68210501700012345678, iban.stringValue(), IBANTests.IBAN_NOT_AS_EXPECTED);
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final IBAN iban1 = IBAN.of(IBANTests.IBAN_DE07123412341234123412);
    final IBAN iban2 = IBAN.of(IBANTests.IBAN_DE07123412341234123412);
    final IBAN iban3 = IBAN.of(IBANTests.IBAN_DE68210501700012345678);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(iban1.hashCode(), iban2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(iban1.hashCode(), iban3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final IBAN iban1 = IBAN.of(IBANTests.IBAN_DE07123412341234123412);
    final IBAN iban2 = IBAN.of(IBANTests.IBAN_DE07123412341234123412);
    final IBAN iban3 = IBAN.of(IBANTests.IBAN_DE68210501700012345678);
    final IBAN iban4 = IBAN.of(IBANTests.IBAN_DE07123412341234123412);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(iban1.equals(iban1), "iban11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(iban1.equals(iban2), "iban12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(iban2.equals(iban1), "iban21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(iban2.equals(iban4), "iban24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(iban1.equals(iban4), "iban14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(iban1.equals(iban3), "iban13 are equal"), //$NON-NLS-1$
      () -> assertFalse(iban3.equals(iban1), "iban31 are equal"), //$NON-NLS-1$
      () -> assertFalse(iban1.equals(null), "iban10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final IBAN iban = IBAN.of(IBANTests.IBAN_DE68210501700012345678);
    assertEquals("IBAN[iban=DE68210501700012345678]", iban.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final IBAN iban1 = IBAN.of(IBANTests.IBAN_DE07123412341234123412);
    final IBAN iban2 = IBAN.of(IBANTests.IBAN_DE07123412341234123412);
    final IBAN iban3 = IBAN.of(IBANTests.IBAN_DE68210501700012345678);
    final IBAN iban4 = IBAN.of("SE3550000000054910000003"); //$NON-NLS-1$
    final IBAN iban5 = IBAN.of(IBANTests.IBAN_DE07123412341234123412);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(iban1.compareTo(iban2) == -iban2.compareTo(iban1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(iban1.compareTo(iban3) == -iban3.compareTo(iban1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((iban4.compareTo(iban3) > 0) && (iban3.compareTo(iban1) > 0) && (iban4.compareTo(iban1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((iban1.compareTo(iban2) == 0) && (Math.abs(iban1.compareTo(iban5)) == Math.abs(iban2.compareTo(iban5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((iban1.compareTo(iban2) == 0) && iban1.equals(iban2), "equals") //$NON-NLS-1$
    );
   }

 }
