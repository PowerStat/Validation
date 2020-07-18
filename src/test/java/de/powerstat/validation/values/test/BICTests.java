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

import de.powerstat.validation.values.BIC;


/**
 * BIC Tests.
 */
public class BICTests
 {
  /**
   * BIC for tests.
   */
  private static final String BIC_BELADEBEXXX = "BELADEBEXXX"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public BICTests()
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
  public void bicCorrect(final String bic)
   {
    final BIC cleanBic = BIC.of(bic);
    assertEquals(bic, cleanBic.getBIC(), "BIC not as expected"); //$NON-NLS-1$
   }


  /**
   * Test BIC with wrong lengths.
   *
   * @param bic BIC
   */
  @ParameterizedTest
  @ValueSource(strings = {"POWSDE0", "POWSDE30X", "POWSDE30XX", "POWSDE30XXXX"})
  public void bicLength(final String bic)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final BIC cleanBic = */ BIC.of(bic);
     }
    );
   }


  /**
   * Test wrong BIC.
   *
   * @param bic BIC
   */
  @ParameterizedTest
  @ValueSource(strings = {"POWSDE10XXX", "POWSZZ30XXX"})
  public void bicWrong(final String bic)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final BIC cleanBic = */ BIC.of(bic);
     }
    );
   }


  /**
   * Test get bic.
   */
  @Test
  public void getBic()
   {
    final BIC bic = BIC.of(BIC_BELADEBEXXX);
    assertEquals(BIC_BELADEBEXXX, bic.getBIC(), "BIC not as expected"); //$NON-NLS-1$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final BIC bic1 = BIC.of(BIC_BELADEBEXXX);
    final BIC bic2 = BIC.of(BIC_BELADEBEXXX);
    final BIC bic3 = BIC.of("RZTIAT22263"); //$NON-NLS-1$
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(bic1.hashCode(), bic2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(bic1.hashCode(), bic3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final BIC bic1 = BIC.of(BIC_BELADEBEXXX);
    final BIC bic2 = BIC.of(BIC_BELADEBEXXX);
    final BIC bic3 = BIC.of("RZTIAT22263"); //$NON-NLS-1$
    final BIC bic4 = BIC.of(BIC_BELADEBEXXX);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(bic1.equals(bic1), "bic11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(bic1.equals(bic2), "bic12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(bic2.equals(bic1), "bic21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(bic2.equals(bic4), "bic24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(bic1.equals(bic4), "bic14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(bic1.equals(bic3), "bic13 are equal"), //$NON-NLS-1$
      () -> assertFalse(bic3.equals(bic1), "bic31 are equal"), //$NON-NLS-1$
      () -> assertFalse(bic1.equals(null), "bic10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final BIC bic = BIC.of(BIC_BELADEBEXXX);
    assertEquals("BIC[bic=BELADEBEXXX]", bic.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final BIC bic1 = BIC.of(BIC_BELADEBEXXX);
    final BIC bic2 = BIC.of(BIC_BELADEBEXXX);
    final BIC bic3 = BIC.of("RZTIAT22263"); //$NON-NLS-1$
    final BIC bic4 = BIC.of("UBSWCHZH80A"); //$NON-NLS-1$
    final BIC bic5 = BIC.of(BIC_BELADEBEXXX);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(bic1.compareTo(bic2) == -bic2.compareTo(bic1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(bic1.compareTo(bic3) == -bic3.compareTo(bic1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((bic4.compareTo(bic3) > 0) && (bic3.compareTo(bic1) > 0) && (bic4.compareTo(bic1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((bic1.compareTo(bic2) == 0) && (Math.abs(bic1.compareTo(bic5)) == Math.abs(bic2.compareTo(bic5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((bic1.compareTo(bic2) == 0) && bic1.equals(bic2), "equals") //$NON-NLS-1$
    );
   }

 }
