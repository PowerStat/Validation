/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.powerstat.ddd.values.AddressType;


/**
 * AddressType tests.
 */
final class AddressTypeTests
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
  /* default */ AddressTypeTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(0, AddressType.of(UNKNOWN).getAction(), UNKNOWN_ACTION_NOT_AS_EXPECTED);
   }


  /**
   * Test getAction of Gender.
   */
  @Test
  /* default */ void testGetAction()
   {
    assertAll("constructor", //$NON-NLS-1$
      () -> assertEquals(0, AddressType.UNKNOWN.getAction(), UNKNOWN_ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(1, AddressType.RESIDENTIAL.getAction(), "RESIDENTIAL action not as expected"), //$NON-NLS-1$
      () -> assertEquals(2, AddressType.SECOND_RESIDENTIAL.getAction(), "SECOND_RESIDENTIAL action not as expected"), //$NON-NLS-1$
      () -> assertEquals(3, AddressType.BUSINESS.getAction(), "BUSINESS action not as expected"), //$NON-NLS-1$
      () -> assertEquals(4, AddressType.VACATION.getAction(), "VACATION action not as expected"), //$NON-NLS-1$
      () -> assertEquals(5, AddressType.PO_BOX.getAction(), "PO_BOX action not as expected"), //$NON-NLS-1$
      () -> assertEquals(6, AddressType.FREIGHT_STATION.getAction(), "FREIGHT_STATION action not as expected"), //$NON-NLS-1$
      () -> assertEquals(7, AddressType.PARCEL_SHOP.getAction(), "PARCEL_SHOP action not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final AddressType type = AddressType.UNKNOWN;
    assertEquals(UNKNOWN, type.stringValue(), "stringValue not as expected");
   }

 }
