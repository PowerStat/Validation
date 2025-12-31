/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.time;


import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Supported calendar systems.
 *
 * Not DSGVO relevant.
 */
@ValueObject
public enum CalendarSystems implements IValueObject
 {
  /**
   * Julian calendar system.
   */
  JULIAN(0),

  /**
   * Gregorian calendar system.
   */
  GREGORIAN(1);

  // ISLAMIC(2)
  // JEWISH(3)
  // INDIAN(4)
  // CHINESE(5)


  /**
   * Action number.
   */
  private final int action;


  /**
   * Ordinal constructor.
   *
   * @param action Action number
   */
  CalendarSystems(final int action)
   {
    this.action = action;
   }


  /**
   * CalendarSystems factory.
   *
   * @param value CalendarSystems enum string
   * @return CalendarSystems enum
   */
  public static CalendarSystems of(final String value)
   {
    return CalendarSystems.valueOf(value);
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
   * Returns the value of this CalendarSystems as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.name();
   }

 }
