/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.powerstat.ddd.values.MonthEnum;


/**
 * Month enum tests.
 */
final class MonthEnumTests
 {
  /**
   * January.
   */
  private static final String JANUARY = "JANUARY";

  /**
   * JANUARY action not as expected constant.
   */
  private static final String JANUARY_ACTION_NOT_AS_EXPECTED = "1 action not as expected";


  /**
   * Default constructor.
   */
  /* default */ MonthEnumTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(1, MonthEnum.of(JANUARY).getAction(), JANUARY_ACTION_NOT_AS_EXPECTED);
   }


  /**
   * Test getAction of Month.
   */
  @Test
  /* default */ void testGetAction()
   {
    assertAll("getAction", //$NON-NLS-1$
      () -> assertEquals(1, MonthEnum.JANUARY.getAction(), JANUARY_ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(2, MonthEnum.FEBRUARY.getAction(), "2 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(3, MonthEnum.MARCH.getAction(), "3 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(4, MonthEnum.APRIL.getAction(), "4 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(5, MonthEnum.MAY.getAction(), "5 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(6, MonthEnum.JUNE.getAction(), "6 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(7, MonthEnum.JULY.getAction(), "7 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(8, MonthEnum.AUGUST.getAction(), "8 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(9, MonthEnum.SEPTEMBER.getAction(), "9 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(10, MonthEnum.OCTOBER.getAction(), "10 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(11, MonthEnum.NOVEMBER.getAction(), "11 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(12, MonthEnum.DECEMBER.getAction(), "12 action not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final MonthEnum wd = MonthEnum.JANUARY;
    assertEquals(JANUARY, wd.stringValue(), "stringValue not as expected");
   }


 }
