/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.impl.test;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.impl.IBANVerifier;


/**
 * IBAN verifier tests.
 */
public class IBANVerifierTests
 {
  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT_EXCEPTION = "Illegal argument exception expected"; //$NON-NLS-1$


  /**
   * Default Constructor.
   */
  public IBANVerifierTests()
   {
    super();
   }


  /**
   * Test constructor with illegal length.
   */
  @Test
  public void constructor1()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      IBANVerifier.of(14, "^DE[0-9]{2}[0-9]{18}$"); //$NON-NLS-1$
     }, IBANVerifierTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test constructor with illegal regexp.
   */
  @Test
  public void constructor2()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      IBANVerifier.of(15, "DE[0-9]{2}[0-9]{18}"); //$NON-NLS-1$
     }, IBANVerifierTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test constructor with illegal length.
   */
  @Test
  public void constructor3()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      IBANVerifier.of(35, "^DE[0-9]{2}[0-9]{18}$"); //$NON-NLS-1$
     }, IBANVerifierTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test constructor with illegal regexp.
   */
  @Test
  public void constructor4()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      IBANVerifier.of(15, "^DE[0-9]{2}[0-9]{18}"); //$NON-NLS-1$
     }, IBANVerifierTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Testverify.
   */
  @Test
  public void verify1()
   {
    final IBANVerifier iv = IBANVerifier.of(21, "^DE[0-9]{2}[0-9]{18}$"); //$NON-NLS-1$
    final boolean result = iv.verify("DE68210501700012345678"); //$NON-NLS-1$
    assertFalse(result, "result not as expected"); //$NON-NLS-1$
   }

 }
