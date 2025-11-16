/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.impl.test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.impl.IBANVerifier;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * IBAN verifier tests.
 */
final class IBANVerifierTests
 {
  /**
   * Result not as expected.
   */
  private static final String RESULT_NOT_AS_EXPECTED = "result not as expected";

  /**
   * IBAN DE pattern.
   */
  private static final String IBAN_DE_PATTERN = "^DE[0-9]{2}[0-9]{29}$";

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT_EXCEPTION = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * German IBAN regexp.
   */
  private static final String IBAN_DE_REGEXP = "^DE[0-9]{2}[0-9]{17}$"; //$NON-NLS-1$


  /**
   * Default Constructor.
   */
  /* default */ IBANVerifierTests()
   {
    super();
   }


  /**
   * Test constructor with illegal length.
   */
  @Test
  /* default */ void testConstructor1()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      IBANVerifier.of(14, IBANVerifierTests.IBAN_DE_REGEXP);
     }, IBANVerifierTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test constructor with illegal regexp.
   */
  @Test
  /* default */ void testConstructor2()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      IBANVerifier.of(15, "DE[0-9]{2}[0-9]{11}$"); //$NON-NLS-1$
     }, IBANVerifierTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test constructor with illegal length.
   */
  @Test
  /* default */ void testConstructor3()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      IBANVerifier.of(35, IBANVerifierTests.IBAN_DE_REGEXP);
     }, IBANVerifierTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test constructor with illegal regexp.
   */
  @Test
  /* default */ void testConstructor4()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      IBANVerifier.of(15, "^DE[0-9]{2}[0-9]{11}"); //$NON-NLS-1$
     }, IBANVerifierTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test constructor with minimal length.
   */
  @Test
  /* default */ void testConstructor5()
   {
    final IBANVerifier iv = IBANVerifier.of(15, "^DE[0-9]{2}[0-9]{11}$");
    assertNotNull(iv, "Verifier not as expected");
   }


  /**
   * Test constructor with maximal length.
   */
  @Test
  /* default */ void testConstructor6()
   {
    final IBANVerifier iv = IBANVerifier.of(34, "^DE[0-9]{2}[0-9]{30}$");
    assertNotNull(iv, "Verifier not as expected");
   }


  /**
   * Test constructor with maximal length.
   */
  @SuppressFBWarnings("PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS")
  @Test
  /* default */ void testConstructor7()
   {
    final IBANVerifier iv1 = IBANVerifier.of(33, IBAN_DE_PATTERN);
    final IBANVerifier iv2 = IBANVerifier.of(33, IBAN_DE_PATTERN);
    assertNotNull(iv1, "Verifier1 not as expected");
    assertNotNull(iv2, "Verifier2 not as expected");
    assertSame(iv1, iv2, "Not the same");
   }


  /**
   * Testverify.
   */
  @Test
  /* default */ void testVerify1()
   {
    final IBANVerifier iv = IBANVerifier.of(21, IBANVerifierTests.IBAN_DE_REGEXP);
    final boolean result = iv.verify("DE68210501700012345678"); //$NON-NLS-1$
    assertFalse(result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Testverify.
   */
  @Test
  /* default */ void testVerify2()
   {
    final IBANVerifier iv = IBANVerifier.of(21, IBANVerifierTests.IBAN_DE_REGEXP);
    final boolean result = iv.verify("EN6821050170001234567"); //$NON-NLS-1$
    assertFalse(result, RESULT_NOT_AS_EXPECTED);
   }

 }
