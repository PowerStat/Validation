/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values;


import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Address types.
 *
 * DSGVO relevant.
 */
@ValueObject
public enum AddressType implements IValueObject
 {
  /**
   * Unknown/undefined gender.
   */
  UNKNOWN(0),

  /**
   * Residential.
   */
  RESIDENTIAL(1),

  /**
   * Second residential.
   */
  SECOND_RESIDENTIAL(2),

  /**
   * Business.
   */
  BUSINESS(3),

  /**
   * Vacation.
   */
  VACATION(4),

  /**
   * PO Box.
   */
  PO_BOX(5),

  /**
   * Freight station.
   */
  FREIGHT_STATION(6),

  /**
   * Parcel shop.
   */
  PARCEL_SHOP(7);


  /**
   * Action number.
   */
  private final int action;


  /**
   * Ordinal constructor.
   *
   * @param action Action number
   */
  AddressType(final int action)
   {
    this.action = action;
   }


  /**
   * AddressType factory.
   *
   * @param value AddressType name string
   * @return AddressType object
   */
  public static AddressType of(final String value)
   {
    return AddressType.valueOf(value);
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
