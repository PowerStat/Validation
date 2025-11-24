/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.Gender;


/**
 * Gender tests.
 */
final class GenderTests
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
  /* default */ GenderTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(0, Gender.of(UNKNOWN).getAction(), UNKNOWN_ACTION_NOT_AS_EXPECTED);
   }


  /**
   * Test getAction of Gender.
   */
  @Test
  /* default */ void testGetAction()
   {
    assertAll("constructor", //$NON-NLS-1$
      () -> assertEquals(0, Gender.UNKNOWN.getAction(), UNKNOWN_ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(1, Gender.FEMALE.getAction(), "FEMALE action not as expected"), //$NON-NLS-1$
      () -> assertEquals(2, Gender.MALE.getAction(), "MALE action not as expected"), //$NON-NLS-1$
      () -> assertEquals(3, Gender.BOTH.getAction(), "BOTH action not as expected"), //$NON-NLS-1$
      () -> assertEquals(4, Gender.VARIABLE.getAction(), "VARIABLE action not as expected"), //$NON-NLS-1$
      () -> assertEquals(5, Gender.NEUTRAL.getAction(), "NEUTRAL action not as expected"), //$NON-NLS-1$
      () -> assertEquals(6, Gender.OTHER.getAction(), "OTHER action not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Gender gender = Gender.UNKNOWN;
    assertEquals(UNKNOWN, gender.stringValue(), "stringValue not as expected");
   }

 }
