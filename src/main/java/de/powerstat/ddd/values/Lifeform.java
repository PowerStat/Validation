/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values;


import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Life form.
 *
 * Not DSGVO relevant.
 */
@ValueObject
public enum Lifeform implements IValueObject
 {
  /**
   * Unknown/undefined life form.
   */
  UNKNOWN(0),

  /**
   * Bacterium.
   */
  BACTERIUM(1),

  /**
   * Virus.
   */
  VIRUS(2),

  /**
   * Plant.
   */
  PLANT(3),

  /**
   * Fungi.
   */
  FUNGI(4),

  /**
   * Animal.
   */
  ANIMAL(5),

  /**
   * Sapient.
   */
  SAPIENT(6);


  /**
   * Action number.
   */
  private final int action;


  /**
   * Ordinal constructor.
   *
   * @param action Action number
   */
  Lifeform(final int action)
   {
    this.action = action;
   }


  /**
   * Life form factory.
   *
   * @param value Life form name string
   * @return Lifeform object
   */
  public static Lifeform of(final String value)
   {
    return Lifeform.valueOf(value);
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
   * Returns the value of this Lifeform as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.name();
   }

 }
