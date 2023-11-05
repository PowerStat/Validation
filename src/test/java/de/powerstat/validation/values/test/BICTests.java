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

import de.powerstat.validation.values.BIC;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * BIC Tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class BICTests
 {
  /**
   * Illegal argument exception expected.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * BIC not as expected.
   */
  private static final String BIC_NOT_AS_EXPECTED = "BIC not as expected"; //$NON-NLS-1$

  /**
   * BIC for tests.
   */
  private static final String BIC_BELADEBEXXX = "BELADEBEXXX"; //$NON-NLS-1$

  /**
   * BIC for tests.
   */
  private static final String BIC_RZTIAT22263 = "RZTIAT22263"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ BICTests()
   {
    super();
   }


  /**
   * Test correct BIC.
   *
   * @param bic BIC
   */
  @ParameterizedTest
  @ValueSource(strings = {"POWSDE30XXX", "POWSDE30"})
  /* default */ void testBicCorrect(final String bic)
   {
    final BIC cleanBic = BIC.of(bic);
    assertEquals(bic, cleanBic.bic(), BICTests.BIC_NOT_AS_EXPECTED);
   }


  /**
   * Test BIC with wrong lengths.
   *
   * @param bic BIC
   */
  @ParameterizedTest
  @ValueSource(strings = {"POWSDE0", "POWSDE30X", "POWSDE30XX", "POWSDE30XXXX"})
  /* default */ void testBicLength(final String bic)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final BIC cleanBic = */ BIC.of(bic);
     }, BICTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test wrong BIC.
   *
   * @param bic BIC
   */
  @ParameterizedTest
  @ValueSource(strings = {"POWSDE10XXX", "POWSZZ30XXX"})
  /* default */ void testBicWrong(final String bic)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final BIC cleanBic = */ BIC.of(bic);
     }, BICTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test string value.
   */
  @Test
  /* default */ void testStringValue()
   {
    final BIC bic = BIC.of(BICTests.BIC_BELADEBEXXX);
    assertEquals(BICTests.BIC_BELADEBEXXX, bic.stringValue(), BICTests.BIC_NOT_AS_EXPECTED);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final BIC bic1 = BIC.of(BICTests.BIC_BELADEBEXXX);
    final BIC bic2 = BIC.of(BICTests.BIC_BELADEBEXXX);
    final BIC bic3 = BIC.of(BICTests.BIC_RZTIAT22263);
    final BIC bic4 = BIC.of("UBSWCHZH80A"); //$NON-NLS-1$
    final BIC bic5 = BIC.of(BICTests.BIC_BELADEBEXXX);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(bic1.compareTo(bic2) == -bic2.compareTo(bic1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(bic1.compareTo(bic3) == -bic3.compareTo(bic1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((bic4.compareTo(bic3) > 0) && (bic3.compareTo(bic1) > 0) && (bic4.compareTo(bic1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((bic1.compareTo(bic2) == 0) && (Math.abs(bic1.compareTo(bic5)) == Math.abs(bic2.compareTo(bic5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((bic1.compareTo(bic2) == 0) && bic1.equals(bic2), "equals") //$NON-NLS-1$
    );
   }

 }
