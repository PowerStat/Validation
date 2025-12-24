/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.SexualOrientation;


/**
 * Sexual orientation tests.
 */
final class SexualOrientationTests
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
  /* default */ SexualOrientationTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(0, SexualOrientation.of(UNKNOWN).getAction(), UNKNOWN_ACTION_NOT_AS_EXPECTED);
   }


  /**
   * Test getAction of SexualOrientation.
   */
  @Test
  /* default */ void testGetAction()
   {
    assertAll("constructor", //$NON-NLS-1$
      () -> assertEquals(0, SexualOrientation.UNKNOWN.getAction(), UNKNOWN_ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(1, SexualOrientation.INDETERMINED.getAction(), "INDETERMINED action not as expected"), //$NON-NLS-1$
      () -> assertEquals(2, SexualOrientation.HETERO.getAction(), "HETERO action not as expected"), //$NON-NLS-1$
      () -> assertEquals(3, SexualOrientation.HOMO.getAction(), "HOMO action not as expected"), //$NON-NLS-1$
      () -> assertEquals(4, SexualOrientation.BI.getAction(), "BI action not as expected"), //$NON-NLS-1$
      () -> assertEquals(5, SexualOrientation.AUTO.getAction(), "AUTO action not as expected"), //$NON-NLS-1$
      () -> assertEquals(6, SexualOrientation.A.getAction(), "A action not as expected"), //$NON-NLS-1$
      () -> assertEquals(7, SexualOrientation.PAN.getAction(), "PAN action not as expected"), //$NON-NLS-1$
      () -> assertEquals(8, SexualOrientation.OMNI.getAction(), "OMNI action not as expected"), //$NON-NLS-1$
      () -> assertEquals(9, SexualOrientation.DEMI.getAction(), "DEMI action not as expected"), //$NON-NLS-1$
      () -> assertEquals(10, SexualOrientation.OBJECT.getAction(), "OBJECT action not as expected"), //$NON-NLS-1$
      () -> assertEquals(11, SexualOrientation.SKOLIO.getAction(), "SKOLIO action not as expected"), //$NON-NLS-1$
      () -> assertEquals(12, SexualOrientation.GREY.getAction(), "GREY action not as expected"), //$NON-NLS-1$
      () -> assertEquals(13, SexualOrientation.ANDRO.getAction(), "ANDRO action not as expected"), //$NON-NLS-1$
      () -> assertEquals(14, SexualOrientation.GYNO.getAction(), "GYNO action not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final SexualOrientation orientation = SexualOrientation.UNKNOWN;
    assertEquals(UNKNOWN, orientation.stringValue(), "stringValue not as expected");
   }

 }
