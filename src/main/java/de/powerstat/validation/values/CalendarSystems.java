/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import de.powerstat.validation.interfaces.IValueObject;


/**
 * Supported calendar systems.
 */
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
   * Get action number.
   *
   * @return Action number
   */
  public int getAction()
   {
    return this.action;
   }

 }
