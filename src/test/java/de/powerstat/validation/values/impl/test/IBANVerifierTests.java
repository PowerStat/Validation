/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.impl.test;


import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.impl.IBANVerifier;


/**
 * IBAN verifier tests.
 */
public class IBANVerifierTests
 {
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
     }
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
     }
    );
   }

 }
