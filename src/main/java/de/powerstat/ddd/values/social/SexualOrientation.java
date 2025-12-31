/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.social;


import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Sexual orientation.
 *
 * This is my own derivation of different source all over the internet.
 *
 * DSGVO relevant.
 */
@ValueObject
public enum SexualOrientation implements IValueObject
 {
  /**
   * Unknown/undefined orientation.
   */
  UNKNOWN(0),

  /**
   * Indetermined.
   */
  INDETERMINED(1),

  /**
   * Hetero, interested in the opposite gender as oneself.
   */
  HETERO(2),

  /**
   * Homo, interested in the same gender as oneself.
   */
  HOMO(3),

  /**
   * Bi, interested in same and opposite gender as oneself.
   */
  BI(4),

  /**
   * Auto, only interested in themself.
   */
  AUTO(5),

  /**
   * A, so sexual interests.
   */
  A(6),

  /**
   * Pan, interest independend of gender.
   */
  PAN(7),

  /**
   * Omni, interested in all genders but with preferences.
   */
  OMNI(8),

  /**
   * Demi, requires intensive emotional partnerschip.
   */
  DEMI(9),

  /**
   * Object, interested in objects, not in persons.
   */
  OBJECT(10),

  /**
   * Skolio, interested in persons with unclear gender/orientation.
   */
  SKOLIO(11),

  /**
   * Grey, near Asexual, not permanently interested, only doing it for the other person.
   */
  GREY(12),

  /**
   * Andro, interested in male, independend of gender (trans, ...).
   */
  ANDRO(13),

  /**
   * Gyno, interedted in female, independend of gender (trans, ...).
   */
  GYNO(14);


  /**
   * Action number.
   */
  private final int action;


  /**
   * Ordinal constructor.
   *
   * @param action Action number
   */
  SexualOrientation(final int action)
   {
    this.action = action;
   }


  /**
   * Gender factory.
   *
   * @param value Gender name string
   * @return Gender object
   */
  public static SexualOrientation of(final String value)
   {
    return SexualOrientation.valueOf(value);
   }


  /**
   * Get action number.
   *
   * @return Action number
   */
  public int getAction()
   {
    return action;
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
