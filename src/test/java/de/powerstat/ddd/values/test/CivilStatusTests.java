/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.powerstat.ddd.values.CivilStatus;


/**
 * CivilStatus tests.
 */
final class CivilStatusTests
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
  /* default */ CivilStatusTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(0, CivilStatus.of(UNKNOWN).getAction(), UNKNOWN_ACTION_NOT_AS_EXPECTED);
   }


  /**
   * Test getAction of CivilStatus.
   */
  @Test
  /* default */ void testGetAction()
   {
    assertAll("constructor", //$NON-NLS-1$
      () -> assertEquals(0, CivilStatus.UNKNOWN.getAction(), UNKNOWN_ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(1, CivilStatus.SINGLE.getAction(), "SINGLE action not as expected"), //$NON-NLS-1$
      () -> assertEquals(2, CivilStatus.MARRIED.getAction(), "MARRIED action not as expected"), //$NON-NLS-1$
      () -> assertEquals(3, CivilStatus.PARTNERSHIP.getAction(), "PARTNERSHIP action not as expected"), //$NON-NLS-1$
      () -> assertEquals(4, CivilStatus.SEPARATED.getAction(), "SEPARATED action not as expected"), //$NON-NLS-1$
      () -> assertEquals(5, CivilStatus.DIVORCED.getAction(), "DIVORCED action not as expected"), //$NON-NLS-1$
      () -> assertEquals(6, CivilStatus.WIDOWED.getAction(), "WIDOWED action not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final CivilStatus cstatus = CivilStatus.UNKNOWN;
    assertEquals(UNKNOWN, cstatus.stringValue(), "stringValue not as expected");
   }

 }
