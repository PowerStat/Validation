/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.EnumSet;
import java.util.Locale;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.TreeSet;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * SI prefixes.
 *
 * https://en.wikipedia.org/wiki/Metric_prefix
 */
@SuppressWarnings("PMD.AvoidFieldNameMatchingMethodName")
public enum SIPrefixes implements IValueObject
 {
  /**
   * Quecto.
   */
  QUECTO(-30, "q"),

  /**
   * Ronto.
   */
  RONTO(-27, "r"),

  /**
   * Yocto.
   */
  YOCTO(-24, "y"),

  /**
   * Zepto.
   */
  ZEPTO(-21, "z"),

  /**
   * Atto.
   */
  ATTO(-18, "a"),

  /**
   * Femto.
   */
  FEMTO(-15, "f"),

  /**
   * Pico.
   */
  PICO(-12, "p"),

  /**
   * Nano.
   */
  NANO(-9, "n"),

  /**
   * Micro.
   */
  MICRO(-6, "μ"),

  /**
   * Milli.
   */
  MILLI(-3, "m"),

  /**
   * Centi.
   */
  CENTI(-2, "c"),

  /**
   * Deci.
   */
  DECI(-1, "d"),

  /**
   * Zero.
   */
  ZERO(0, ""),

  /**
   * Deca.
   */
  DECA(1, "da"),

  /**
   * Hecto.
   */
  HECTO(2, "h"),

  /**
   * Kilo.
   */
  KILO(3, "k"),

  /**
   * Mega.
   */
  MEGA(6, "M"),

  /**
   * Giga.
   */
  GIGA(9, "G"),

  /**
   * Tera.
   */
  TERA(12, "T"),

  /**
   * Peta.
   */
  PETA(15, "P"),

  /**
   * Exa.
   */
  EXA(18, "E"),

  /**
   * Zetta.
   */
  ZETTA(21, "Z"),

  /**
   * Yotta.
   */
  YOTTA(24, "Y"),

  /**
   * Ronna.
   */
  RONNA(27, "R"),

  /**
   * Quetta.
   */
  QUETTA(30, "Q");


  /**
   * Ordered enum constants.
   */
  private static final NavigableSet<SIPrefixes> ORDERED_ENUM_CONSTANTS = new TreeSet<>(EnumSet.allOf(SIPrefixes.class));

  /**
   * Base 10 number.
   */
  private final int base;

  /**
   * Symbol.
   */
  private final String symbol;


  /**
   * Constructor.
   *
   * @param base Base 10 number
   * @param symbol Symbol
   */
  SIPrefixes(final int base, final String symbol)
   {
    this.base = base;
    this.symbol = symbol;
   }


  /**
   * Get first (lowest) prefix.
   *
   * @return first (lowest) prefix
   */
  public static SIPrefixes first()
   {
    return QUECTO;
   }


  /**
   * Get last (highest) prefix.
   *
   * @return last (highest) prefix
   */
  public static SIPrefixes last()
   {
    return QUETTA;
   }


  /**
   * Get base (0) prefix.
   *
   * @return Base (0) prefix
   */
  public static SIPrefixes base()
   {
    return ZERO;
   }


  /**
   * Get SIPrefixes by base.
   *
   * @param base Base 10
   * @return SIPrefixes
   * @throws NoSuchElementException If there is no prefix with the given base
   */
  public static SIPrefixes byBase(final int base)
   {
    for (final SIPrefixes prefix : ORDERED_ENUM_CONSTANTS)
     {
      if (prefix.base == base)
       {
        return prefix;
       }
     }
    throw new NoSuchElementException("No SIPrefixes with given base found");
   }


  /**
   * Get base number.
   *
   * @return Base number
   */
  public int getBase()
   {
    return this.base;
   }


  /**
   * Has next.
   *
   * @return true: if there is a higher value; false otherwise
   */
  public boolean hasNext()
   {
    return this != QUETTA;
   }


  /**
   * Has previous.
   *
   * @return true: if there is a lower value; false otherwise
   */
  public boolean hasPrevious()
   {
    return this != QUECTO;
   }


  /**
   * Get next prefix.
   *
   * @return Next higher prefix
   * @throws NoSuchElementException If there is no higher prefix
   */
  public SIPrefixes next()
   {
    if (this == QUETTA)
     {
      throw new NoSuchElementException("There is no higher prefix than YOTTA");
     }
    return ORDERED_ENUM_CONSTANTS.higher(this);
   }


  /**
   * Get previous prefix.
   *
   * @return Previous lower prefix
   * @throws NoSuchElementException If there is no lower prefix
   */
  public SIPrefixes previous()
   {
    if (this == QUECTO)
     {
      throw new NoSuchElementException("There is no lower prefix than YOCTO");
     }
    return ORDERED_ENUM_CONSTANTS.lower(this);
   }


  /**
   * Get prefix name.
   *
   * @return Prefix name
   */
  public String getName()
   {
    return (this == ZERO) ? "" : this.name().toLowerCase(Locale.getDefault());
   }


  /**
   * Get prefix symbol.
   *
   * @return Prefix symbol
   */
  public String getSymbol()
   {
    return this.symbol;
   }


  /**
   * Returns the value of this SIPrefixes as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.name();
   }

 }
