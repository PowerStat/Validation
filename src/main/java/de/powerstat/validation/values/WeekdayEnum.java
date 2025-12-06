/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * WeekdayEnum.
 *
 * Not DSGVO relevant.
 *
 * TODO: getShortName (language)
 * TODO: getName (language)
 * TODO: FirstWeekday: set, get (country dependend) Monday, Sunday, Saturday
 * TODO: increment (weekStart Listener)
 * TODO: decrement (weekStart Listener)
 * TODO: days between weekdays (weekday - weekday)
 * TODO: add days mod 7 (weekday + 2)
 * TODO: subtract days mod 7 (weekday - 2)
 * TODO: iterate from first to last weekday dependend on FirstWeekday ???
 */
@ValueObject
public enum WeekdayEnum implements IValueObject
 {
  /**
   * Monday.
   */
  MONDAY(1),

  /**
   * Tuesday.
   */
  TUESDAY(2),

  /**
   * Wednesday.
   */
  WEDNESDAY(3),

  /**
   * Thursday.
   */
  THURSDAY(4),

  /**
   * Friday.
   */
  FRIDAY(5),

  /**
   * Saturday.
   */
  SATURDAY(6),

  /**
   * Sunday.
   */
  SUNDAY(7);


  /**
   * Action number.
   */
  private final int action;


  /**
   * Ordinal constructor.
   *
   * @param action Action number
   */
  WeekdayEnum(final int action)
   {
    this.action = action;
   }


  /**
   * Weekday factory.
   *
   * @param value Weekday enum string
   * @return Weekday enum
   */
  public static WeekdayEnum of(final String value)
   {
    return WeekdayEnum.valueOf(value);
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
   * Returns the value of this Weekday as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.name();
   }

 }
