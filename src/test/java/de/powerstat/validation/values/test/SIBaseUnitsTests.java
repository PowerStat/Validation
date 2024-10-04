/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
