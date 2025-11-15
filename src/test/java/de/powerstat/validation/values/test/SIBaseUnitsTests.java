/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.SIBaseUnits;


/**
 * SI base units tests.
 */
final class SIBaseUnitsTests
 {
  /**
   * Default constructor.
   */
  /* default */ SIBaseUnitsTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    SIBaseUnits result =  SIBaseUnits.of("SECOND");
    assertNotNull(result, "No base unit");
   }


  /**
   * Factory string value test.
   */
  @Test
  /* default */ void testStringValue1()
   {
    SIBaseUnits result =  SIBaseUnits.of("SECOND");
    assertEquals("SECOND", result.stringValue(), "No base unit");
   }


  /**
   * Test getSymbol of SIBaseUnits.
   */
  @Test
  /* default */ void testGetSymbol()
   {
    assertAll("getSymbol", //$NON-NLS-1$
      () -> assertEquals("kg", SIBaseUnits.KILOGRAM.getSymbol(), "KILOGRAM symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("m", SIBaseUnits.METRE.getSymbol(), "METRE symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("s", SIBaseUnits.SECOND.getSymbol(), "SECOND symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("K", SIBaseUnits.KELVIN.getSymbol(), "KELVIN symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("mol", SIBaseUnits.MOLE.getSymbol(), "MOLE symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("A", SIBaseUnits.AMPERE.getSymbol(), "AMPERE symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("cd", SIBaseUnits.CANDELA.getSymbol(), "CANDELA symbol not as expected") //$NON-NLS-1$
    );
   }

 }
