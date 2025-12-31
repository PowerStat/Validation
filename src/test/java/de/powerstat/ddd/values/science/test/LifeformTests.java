/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.science.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.powerstat.ddd.values.science.Lifeform;


/**
 * Lifeform tests.
 */
final class LifeformTests
 {
  /**
   * Unknown constant.
   */
  private static final String UNKNOWN = "UNKNOWN";

  /**
   * Unknown action not as expected contant.
   */
  private static final String UNKNOWN_ACTION_NOT_AS_EXPECTED = "UNKNOWN action not as expected";


  /**
   * Default constructor.
   */
  /* default */ LifeformTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(0, Lifeform.of(UNKNOWN).getAction(), UNKNOWN_ACTION_NOT_AS_EXPECTED);
   }


  /**
   * Test getAction of Lifeform.
   */
  @Test
  /* default */ void testGetAction()
   {
    assertAll("constructor", //$NON-NLS-1$
      () -> assertEquals(0, Lifeform.UNKNOWN.getAction(), UNKNOWN_ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(1, Lifeform.BACTERIUM.getAction(), "BACTERIUM action not as expected"), //$NON-NLS-1$
      () -> assertEquals(2, Lifeform.VIRUS.getAction(), "VIRUS action not as expected"), //$NON-NLS-1$
      () -> assertEquals(3, Lifeform.PLANT.getAction(), "PLANT action not as expected"), //$NON-NLS-1$
      () -> assertEquals(4, Lifeform.FUNGI.getAction(), "FUNGI action not as expected"), //$NON-NLS-1$
      () -> assertEquals(5, Lifeform.ANIMAL.getAction(), "ANIMAL action not as expected"), //$NON-NLS-1$
      () -> assertEquals(6, Lifeform.SAPIENT.getAction(), "SAPIENT action not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Lifeform lifeform = Lifeform.UNKNOWN;
    assertEquals(UNKNOWN, lifeform.stringValue(), "stringValue not as expected");
   }

 }
