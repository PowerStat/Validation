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
import de.powerstat.validation.values.PostalCode;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Postal codes tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class PostalCodeTests
 {
  /**
   * Post code 28000.
   */
  private static final String POSTCODE_28000 = "28000"; //$NON-NLS-1$

  /**
   * Post code 30000.
   */
  private static final String POSTCODE_30000 = "30000"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * PostalCode not as expected constant.
   */
  private static final String POSTAL_CODE_NOT_AS_EXPECTED = "PostalCode not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ PostalCodeTests()
   {
    super();
   }


  /**
   * Test correct PostalCode.
   *
   * @param postalCode Postal code
   */
  @ParameterizedTest
  @ValueSource(strings = {PostalCodeTests.POSTCODE_28000, "123", "1234567-890", "AD123"})
  /* default */ void testPostalCodeCorrect(final String postalCode)
   {
    final PostalCode cleanBic = PostalCode.of(postalCode);
    assertEquals(postalCode, cleanBic.stringValue(), PostalCodeTests.POSTAL_CODE_NOT_AS_EXPECTED);
   }


  /**
   * Test PostalCode with wrong lengths.
   *
   * @param postalCode Postal code
   */
  @ParameterizedTest
  @ValueSource(strings = {"12", "123456789012"})
  /* default */ void testPostalCodeLength(final String postalCode)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final PostalCode cleanPostalCode = */ PostalCode.of(postalCode);
     }, PostalCodeTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test wrong PostalCode.
   *
   * @param postalCode PostalCode
   */
  @ParameterizedTest
  @ValueSource(strings = {"123_45"})
  /* default */ void testPostalCodeWrong(final String postalCode)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final PostalCode cleanPostalCode = */ PostalCode.of(postalCode);
     }, PostalCodeTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get postalCode.
   */
  @Test
  /* default */ void testStringValue()
   {
    final PostalCode postalCode = PostalCode.of(PostalCodeTests.POSTCODE_28000);
    assertEquals(PostalCodeTests.POSTCODE_28000, postalCode.stringValue(), PostalCodeTests.POSTAL_CODE_NOT_AS_EXPECTED);
   }


  /**
   * Equalsverifier.
   */
  @Test
  /* default */ void testEqualsContract()
   {
    EqualsVerifier.forClass(PostalCode.class).withNonnullFields("postalCode").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final PostalCode postalCode = PostalCode.of(PostalCodeTests.POSTCODE_28000);
    assertEquals("PostalCode[postalCode=28000]", postalCode.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final PostalCode bic1 = PostalCode.of(PostalCodeTests.POSTCODE_28000);
    final PostalCode bic2 = PostalCode.of(PostalCodeTests.POSTCODE_28000);
    final PostalCode bic3 = PostalCode.of(PostalCodeTests.POSTCODE_30000);
    final PostalCode bic4 = PostalCode.of("80000"); //$NON-NLS-1$
    final PostalCode bic5 = PostalCode.of(PostalCodeTests.POSTCODE_28000);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(bic1.compareTo(bic2) == -bic2.compareTo(bic1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(bic1.compareTo(bic3) == -bic3.compareTo(bic1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((bic4.compareTo(bic3) > 0) && (bic3.compareTo(bic1) > 0) && (bic4.compareTo(bic1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((bic1.compareTo(bic2) == 0) && (Math.abs(bic1.compareTo(bic5)) == Math.abs(bic2.compareTo(bic5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((bic1.compareTo(bic2) == 0) && bic1.equals(bic2), "equals") //$NON-NLS-1$
    );
   }

 }
