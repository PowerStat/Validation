/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.generated;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


/**
 * Unit test for country names.
 */
final class GeneratedISO3166A2Tests
 {
  /* default */ GeneratedISO3166A2Tests()
   {
    super();
   }


  /**
   * Constructor/factory test.
   */
  @Test
  /* default */ void testGetName1()
   {
    final String countryName = GeneratedISO3166A2.getName("DE");
    assertAll("constructor", //$NON-NLS-1$
      () -> assertEquals("", countryName, "Country name is not equal") //$NON-NLS-1$
    );
   }

 }
