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

import de.powerstat.validation.values.Language;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Language tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class LanguageTests
 {
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
  @ValueSource(strings = {"de"})
  public void languageOk0(final String code)
   {
    final Language cleanLanguage = Language.of(code);
    assertEquals(code, cleanLanguage.getLanguage(), "Language code not as expected"); //$NON-NLS-1$
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
     }
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
     }
    );
   }


  /**
   * Test get language code.
   */
  @Test
  public void getLanguage()
   {
    final Language language = Language.of("de"); //$NON-NLS-1$
    assertEquals("de", language.getLanguage(), "Language code not as expected"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Language language1 = Language.of("de"); //$NON-NLS-1$
    final Language language2 = Language.of("de"); //$NON-NLS-1$
    final Language language3 = Language.of("fr"); //$NON-NLS-1$
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
    final Language language1 = Language.of("de"); //$NON-NLS-1$
    final Language language2 = Language.of("de"); //$NON-NLS-1$
    final Language language3 = Language.of("fr"); //$NON-NLS-1$
    final Language language4 = Language.of("de"); //$NON-NLS-1$
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
    final Language language = Language.of("de"); //$NON-NLS-1$
    assertEquals("Language[code=de]", language.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Language language1 = Language.of("de"); //$NON-NLS-1$
    final Language language2 = Language.of("de"); //$NON-NLS-1$
    final Language language3 = Language.of("en"); //$NON-NLS-1$
    final Language language4 = Language.of("fr"); //$NON-NLS-1$
    final Language language5 = Language.of("de"); //$NON-NLS-1$
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(language1.compareTo(language2) == -language2.compareTo(language1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(language1.compareTo(language3) == -language3.compareTo(language1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((language4.compareTo(language3) > 0) && (language3.compareTo(language1) > 0) && (language4.compareTo(language1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((language1.compareTo(language2) == 0) && (Math.abs(language1.compareTo(language5)) == Math.abs(language2.compareTo(language5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((language1.compareTo(language2) == 0) && language1.equals(language2), "equals") //$NON-NLS-1$
    );
   }

 }
