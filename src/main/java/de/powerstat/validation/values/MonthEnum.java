/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * MonthEnum.
 *
 * Not DSGVO relevant.
 *
 * TODO: getShortName (language)
 * TODO: getName (language)
 * TODO: increment
 * TODO: decrement
 * TODO: months between months (month - month)
 * TODO: add month mod 12 (month + 2)
 * TODO: subtract months mod 12 (month - 2)
 * TODO: iterate from first to last month
 */
@ValueObject
public enum MonthEnum implements IValueObject
 {
  /**
   * January.
   */
  JANUARY(1),

  /**
   * February.
   */
  FEBRUARY(2),

  /**
   * March.
   */
  MARCH(3),

  /**
   * April.
   */
  APRIL(4),

  /**
   * May.
   */
  MAY(5),

  /**
   * June.
   */
  JUNE(6),

  /**
   * July.
   */
  JULY(7),

  /**
   * August.
   */
  AUGUST(8),

  /**
   * September.
   */
  SEPTEMBER(9),

  /**
   * October.
   */
  OCTOBER(10),

  /**
   * November.
   */
  NOVEMBER(11),

  /**
   * December.
   */
  DECEMBER(12);


  /**
   * Action number.
   */
  private final int action;


  /**
   * Ordinal constructor.
   *
   * @param action Action number
   */
  MonthEnum(final int action)
   {
    this.action = action;
   }


  /**
   * Month factory.
   *
   * @param value Month enum string
   * @return Month enum
   */
  public static MonthEnum of(final String value)
   {
    return MonthEnum.valueOf(value);
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
   * Returns the value of this Month as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.name();
   }

 }
