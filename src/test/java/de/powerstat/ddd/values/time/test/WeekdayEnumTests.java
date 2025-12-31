/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.time.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.powerstat.ddd.values.time.WeekdayEnum;


/**
 * Weekday tests.
 */
final class WeekdayEnumTests
 {
  /**
   * Monday.
   */
  private static final String MONDAY = "MONDAY";

  /**
   * Monday action not as expected constant.
   */
  private static final String MONDAY_ACTION_NOT_AS_EXPECTED = "1 action not as expected";


  /**
   * Default constructor.
   */
  /* default */ WeekdayEnumTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(1, WeekdayEnum.of(MONDAY).getAction(), MONDAY_ACTION_NOT_AS_EXPECTED);
   }


  /**
   * Test getAction of Weekday.
   */
  @Test
  /* default */ void testGetAction()
   {
    assertAll("getAction", //$NON-NLS-1$
      () -> assertEquals(1, WeekdayEnum.MONDAY.getAction(), MONDAY_ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(2, WeekdayEnum.TUESDAY.getAction(), "2 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(3, WeekdayEnum.WEDNESDAY.getAction(), "3 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(4, WeekdayEnum.THURSDAY.getAction(), "4 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(5, WeekdayEnum.FRIDAY.getAction(), "5 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(6, WeekdayEnum.SATURDAY.getAction(), "6 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(7, WeekdayEnum.SUNDAY.getAction(), "7 action not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final WeekdayEnum wd = WeekdayEnum.MONDAY;
    assertEquals(MONDAY, wd.stringValue(), "stringValue not as expected");
   }


 }
