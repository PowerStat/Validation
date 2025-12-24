/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Civil/Personal/Family/Marital status.
 *
 * DSGVO relevant.
 */
@ValueObject
public enum CivilStatus implements IValueObject
 {
  /**
   * Unknown/undefined status.
   */
  UNKNOWN(0),

  /**
   * Single.
   */
  SINGLE(1),

  /**
   * Married.
   */
  MARRIED(2),

  /**
   * Civil/Registered/Domestic Partnership.
   */
  PARTNERSHIP(3),

  /**
   * Still married but separated going towards divorces.
   */
  SEPARATED(4),

  /**
   * Divorced.
   */
  DIVORCED(5),

  /**
   * Widowed, Surviving Civil Partner/Spouse.
   */
  WIDOWED(6);


  /**
   * Action number.
   */
  private final int action;


  /**
   * Ordinal constructor.
   *
   * @param action Action number
   */
  CivilStatus(final int action)
   {
    this.action = action;
   }


  /**
   * CivilStatus factory.
   *
   * @param value CivilStatus name string
   * @return CivilStatus object
   */
  public static CivilStatus of(final String value)
   {
    return CivilStatus.valueOf(value);
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
   * Returns the value of this CivilStatus as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.name();
   }

 }
