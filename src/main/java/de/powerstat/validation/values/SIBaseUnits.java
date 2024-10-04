/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import de.powerstat.validation.interfaces.IValueObject;


/**
 * SI base units.
 *
 * @see <a href="https://en.wikipedia.org/wiki/International_System_of_Units">International System of Units</a>
 *
 * Not DSGVO relevant.
 */
public enum SIBaseUnits implements IValueObject
 {
  /**
   * Time in seconds.
   */
  SECOND("s"),

  /**
   * Length in metre.
   */
  METRE("m"),

  /**
   * Mass in kilogram.
   */
  KILOGRAM("kg"),

  /**
   * Wlectric current in ampere.
   */
  AMPERE("A"),

  /**
   * thermodynamic temperature in kelvin.
   */
  KELVIN("K"),

  /**
   * Amount of substance in mole.
   */
  MOLE("mol"),

  /**
   * Luminous intensity in candela.
   */
  CANDELA("cd");


  /**
   * Unit symbol.
   */
  private final String symbol;


  /**
   * Ordinal constructor.
   *
   * @param symbol Unit symbol
   */
  SIBaseUnits(final String symbol)
   {
    this.symbol = symbol;
   }


  /**
   * SIBaseUnits factory.
   *
   * @param value Enum name string
   * @return SIBaseUnits enum
   */
  public static SIBaseUnits of(final String value)
   {
    return SIBaseUnits.valueOf(value);
   }


  /**
   * Get unit symbol.
   *
   * @return Symbol
   */
  public String getSymbol()
   {
    return this.symbol;
   }


  /**
   * Returns the value of this SIBaseUnits as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.name();
   }

 }
