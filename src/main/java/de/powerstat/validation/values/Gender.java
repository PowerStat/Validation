/*
 * Copyright (C) 2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;

import de.powerstat.validation.interfaces.IValueObject;

/**
 * Gender/Sex.
 *
 * This is my own derivation of the following website:
 * https://at.wikimannia.org/60_Geschlechtsidentit%C3%A4ten
 * From my point of view trans-gender is not a gender - it is a change of the gender over time.
 * For example when someone is born as male he will become a female after a transformation.
 * During the transformation BOTH or VARIABLE might be used.
 * This will be handled in the Person class by a history of the gender.
 *
 * @see <a href="https://at.wikimannia.org/60_Geschlechtsidentitäten">Geschlechtsidentitäten</a>
 */
public enum Gender implements IValueObject
 {
  /**
   * Unknown/undefined gender.
   */
  UNKNOWN(0),

  /**
   * Female.
   */
  FEMALE(1),

  /**
   * Male.
   */
  MALE(2),

  /**
   * Both female and male at the same time.
   */
  BOTH(3),

  /**
   * Variable, female today, male tomorrow for example (not trans).
   */
  VARIABLE(4),

  /**
   * Without a gender/sex.
   */
  NEUTRAL(5),

  /**
   * Other not here named gender.
   */
  OTHER(6);


  /**
   * Action number.
   */
  private final int action;


  /**
   * Ordinal constructor.
   *
   * @param action Action number
   */
  Gender(final int action)
   {
    this.action = action;
   }


  /**
   * Gender factory.
   *
   * @param value Gender name string
   * @return Gender object
   */
  public static Gender of(final String value)
   {
    return Gender.valueOf(value);
   }


  /**
   * Get action number.
   *
   * @return Action number
   */
  public int getAction()
   {
    return this.action;
   }


  /**
   * Returns the value of this Gender as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.name();
   }

 }
