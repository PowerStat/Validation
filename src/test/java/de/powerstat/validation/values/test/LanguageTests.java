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

import de.powerstat.validation.values.Language;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Language tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class LanguageTests
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
  public LanguageTests()
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
  public void languageOk0(final String code)
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
  public void languageLength(final String code)
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
  public void countryIllegalParameters(final String code)
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
  public void getLanguage()
   {
    final Language language = Language.of(LanguageTests.DE);
    assertEquals(LanguageTests.DE, language.stringValue(), LanguageTests.LANGUAGE_CODE_NOT_AS_EXPECTED);
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Language language1 = Language.of(LanguageTests.DE);
    final Language language2 = Language.of(LanguageTests.DE);
    final Language language3 = Language.of(LanguageTests.FR);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(language1.hashCode(), language2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(language1.hashCode(), language3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Language language1 = Language.of(LanguageTests.DE);
    final Language language2 = Language.of(LanguageTests.DE);
    final Language language3 = Language.of(LanguageTests.FR);
    final Language language4 = Language.of(LanguageTests.DE);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(language1.equals(language1), "language11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(language1.equals(language2), "language12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(language2.equals(language1), "language21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(language2.equals(language4), "language24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(language1.equals(language4), "language14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(language1.equals(language3), "language13 are equal"), //$NON-NLS-1$
      () -> assertFalse(language3.equals(language1), "language31 are equal"), //$NON-NLS-1$
      () -> assertFalse(language1.equals(null), "language10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Language language = Language.of(LanguageTests.DE);
    assertEquals("Language[code=de]", language.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
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
