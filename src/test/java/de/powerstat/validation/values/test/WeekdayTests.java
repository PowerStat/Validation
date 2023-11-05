/*
 * Copyright (C) 2022-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.Weekday;


/**
 * Weekday tests.
 */
final class WeekdayTests
 {
  /**
   * Monday action not as expected constant.
   */
  private static final String MONDAY_ACTION_NOT_AS_EXPECTED = "1 action not as expected";


  /**
   * Default constructor.
   */
  /* default */ WeekdayTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(1, Weekday.of("MONDAY").getAction(), MONDAY_ACTION_NOT_AS_EXPECTED); //$NON-NLS-1$
   }


  /**
   * Test getAction of Weekday.
   */
  @Test
  /* default */ void testGetAction()
   {
    assertAll("getAction", //$NON-NLS-1$
      () -> assertEquals(1, Weekday.MONDAY.getAction(), MONDAY_ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(2, Weekday.TUESDAY.getAction(), "2 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(3, Weekday.WEDNESDAY.getAction(), "3 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(4, Weekday.THURSDAY.getAction(), "4 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(5, Weekday.FRIDAY.getAction(), "5 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(6, Weekday.SATURDAY.getAction(), "6 action not as expected"), //$NON-NLS-1$
      () -> assertEquals(7, Weekday.SUNDAY.getAction(), "7 action not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Weekday wd = Weekday.MONDAY;
    assertEquals("MONDAY", wd.stringValue(), "stringValue not as expected");
   }


 }
