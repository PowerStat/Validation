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
import de.powerstat.validation.values.JulianCalendar;
import de.powerstat.validation.values.Language;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Language tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class LanguageTests
 {
  /**
   * FR france.
   */
  private static final String FR = "fr"; //$NON-NLS-1$

  /**
   * DE germany.
   */
  private static final String DE = "de"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Language code not as expected constant.
   */
  private static final String LANGUAGE_CODE_NOT_AS_EXPECTED = "Language code not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ LanguageTests()
   {
    super();
   }


  /**
   * Test Language with valid language codes.
   *
   * @param code 639-1 code
   */
  @ParameterizedTest
  @ValueSource(strings = {LanguageTests.DE})
  /* default */ void testLanguageOk0(final String code)
   {
    final Language cleanLanguage = Language.of(code);
    assertEquals(code, cleanLanguage.stringValue(), LanguageTests.LANGUAGE_CODE_NOT_AS_EXPECTED);
   }


  /**
   * Test Language with language codes to short or long.
   *
   * @param code 639-1 codes
   */
  @ParameterizedTest
  @ValueSource(strings = {"d", "dea"})
  /* default */ void testLanguageLength(final String code)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Language cleanLanguage = */ Language.of(code);
     }, LanguageTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test Language with illegal parameters.
   *
   * @param code 639-1 code
   */
  @ParameterizedTest
  @ValueSource(strings = {"d~", "zz"})
  /* default */ void testCountryIllegalParameters(final String code)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Language cleanLanguage = */ Language.of(code);
     }, LanguageTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get language code.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Language language = Language.of(LanguageTests.DE);
    assertEquals(LanguageTests.DE, language.stringValue(), LanguageTests.LANGUAGE_CODE_NOT_AS_EXPECTED);
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(Language.class).withNonnullFields("code").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Language language = Language.of(LanguageTests.DE);
    assertEquals("Language[code=de]", language.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Language language1 = Language.of(LanguageTests.DE);
    final Language language2 = Language.of(LanguageTests.DE);
    final Language language3 = Language.of("en"); //$NON-NLS-1$
    final Language language4 = Language.of(LanguageTests.FR);
    final Language language5 = Language.of(LanguageTests.DE);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(language1.compareTo(language2) == -language2.compareTo(language1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(language1.compareTo(language3) == -language3.compareTo(language1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((language4.compareTo(language3) > 0) && (language3.compareTo(language1) > 0) && (language4.compareTo(language1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((language1.compareTo(language2) == 0) && (Math.abs(language1.compareTo(language5)) == Math.abs(language2.compareTo(language5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((language1.compareTo(language2) == 0) && language1.equals(language2), "equals") //$NON-NLS-1$
    );
   }

 }
