/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * SI derived units.
 *
 * @see <a href="https://en.wikipedia.org/wiki/International_System_of_Units">International System of Units</a>
 *
 * Not DSGVO relevant.
 */
@ValueObject
public enum SIDerivedUnits implements IValueObject
 {
  /**
   * Plane angle.
   */
  RADIAN("rad"),

  /**
   * Solid angle.
   */
  STERADIAN("sr"),

  /**
   * Frequency.
   */
  HERTZ("Hz"),

  /**
   * Force, weight.
   */
  NEWTON("N"),

  /**
   * Pressure, stress.
   */
  PASCAL("Pa"),

  /**
   * Energy, work, heat.
   */
  JOULE("J"),

  /**
   * Power, radiant flux.
   */
  WATT("W"),

  /**
   * Electric charge.
   */
  COULOMB("C"),

  /**
   * Electric potential, voltage, emf.
   */
  VOLT("V"),

  /**
   * Capacitance.
   */
  FARAD("F"),

  /**
   * Resistance, impedance, reactance.
   */
  OHM("Ω"),

  /**
   * Electrical conductance.
   */
  SIEMENS("S"),

  /**
   * Magnetic flux.
   */
  WEBER("Wb"),

  /**
   * Magnetic flux density.
   */
  TESLA("T"),

  /**
   * Inductance.
   */
  HENRY("H"),

  /**
   * Temperature relative to 273.15 K.
   */
  DEGREE_CELSIUS("°C"),

  /**
   * Luminous flux.
   */
  LUMEN("lm"),

  /**
   * Illuminance.
   */
  LUX("lx"),

  /**
   * Activity referred to a radionuclide (decays per unit time).
   */
  BECQUEREL("Bq"),

  /**
   * Absorbed dose (of ionising radiation).
   */
  GRAY("Gy"),

  /**
   * Equivalent dose (of ionising radiation).
   */
  SIEVERT("Sv"),

  /**
   * Catalytic activity.
   */
  KATAL("kat");


  /**
   * Unit symbol.
   */
  private final String symbol;


  /**
   * Ordinal constructor.
   *
   * @param symbol Unit symbol
   */
  SIDerivedUnits(final String symbol)
   {
    this.symbol = symbol;
   }


  /**
   * SIDerivedUnits factory.
   *
   * @param value Enum name string
   * @return SIDerivedUnits enum
   */
  public static SIDerivedUnits of(final String value)
   {
    return SIDerivedUnits.valueOf(value);
   }


  /**
   * Get unit symbol.
   *
   * @return Symbol
   */
  public String getSymbol()
   {
    return symbol;
   }


  /**
   * Returns the value of this SIDerivedUnits as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.name();
   }

 }
