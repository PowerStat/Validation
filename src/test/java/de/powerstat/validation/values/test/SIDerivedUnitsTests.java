/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.SIDerivedUnits;


/**
 * SI derived units tests.
 */
final class SIDerivedUnitsTests
 {
  /**
   * Default constructor.
   */
  /* default */ SIDerivedUnitsTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    final SIDerivedUnits result = SIDerivedUnits.of("HERTZ");
    assertNotNull(result, "No derived unit");
   }


  /**
   * Factory string value test.
   */
  @Test
  /* default */ void testStringValue1()
   {
    final SIDerivedUnits result = SIDerivedUnits.of("HERTZ");
    assertEquals("HERTZ", result.stringValue(), "No derived unit");
   }


  /**
   * Test getSymbol of SIBaseUnits.
   */
  @Test
  /* default */ void testGetSymbol()
   {
    assertAll("getSymbol", //$NON-NLS-1$
      () -> assertEquals("Bq", SIDerivedUnits.BECQUEREL.getSymbol(), "BECQUEREL symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("C", SIDerivedUnits.COULOMB.getSymbol(), "COULOMB symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("F", SIDerivedUnits.FARAD.getSymbol(), "FARAD symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("Gy", SIDerivedUnits.GRAY.getSymbol(), "GRAY symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("H", SIDerivedUnits.HENRY.getSymbol(), "HENRY symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("Hz", SIDerivedUnits.HERTZ.getSymbol(), "HERTZ symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("J", SIDerivedUnits.JOULE.getSymbol(), "JOULE symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("lm", SIDerivedUnits.LUMEN.getSymbol(), "LUMEN symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("lx", SIDerivedUnits.LUX.getSymbol(), "LUX symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("N", SIDerivedUnits.NEWTON.getSymbol(), "NEWTON symbol not as expected"), //$NON-NLS-1$
      // () -> assertEquals("Ω", SIDerivedUnits.OHM.getSymbol(), "OHM symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("Pa", SIDerivedUnits.PASCAL.getSymbol(), "PASCAL symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("S", SIDerivedUnits.SIEMENS.getSymbol(), "SIEMENS symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("Sv", SIDerivedUnits.SIEVERT.getSymbol(), "SIEVERT symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("T", SIDerivedUnits.TESLA.getSymbol(), "TESLA symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("V", SIDerivedUnits.VOLT.getSymbol(), "VOLT symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("W", SIDerivedUnits.WATT.getSymbol(), "WATT symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("Wb", SIDerivedUnits.WEBER.getSymbol(), "WEBER symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("rad", SIDerivedUnits.RADIAN.getSymbol(), "RADIAN symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("sr", SIDerivedUnits.STERADIAN.getSymbol(), "STERADIAN symbol not as expected"), //$NON-NLS-1$
      // () -> assertEquals("°C", SIDerivedUnits.DEGREE_CELSIUS.getSymbol(), "DEGREE_CELSIUS symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("kat", SIDerivedUnits.KATAL.getSymbol(), "KATAL symbol not as expected") //$NON-NLS-1$
    );
   }

 }
