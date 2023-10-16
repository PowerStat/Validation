/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.CalendarSystems;


/**
 * Calendar systems tests.
 */
final class CalendarSystemsTests
 {
  /**
   * Julian action not as expected constant.
   */
  private static final String JULIAN_ACTION_NOT_AS_EXPECTED = "Julian action not as expected";


  /**
   * Default constructor.
   */
  public CalendarSystemsTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(0, CalendarSystems.of("JULIAN").getAction(), JULIAN_ACTION_NOT_AS_EXPECTED); //$NON-NLS-1$
   }


  /**
   * Test getAction of CalendarSystems.
   */
  @Test
  /* default */ void testGetAction()
   {
    assertAll("constructor", //$NON-NLS-1$
      () -> assertEquals(0, CalendarSystems.JULIAN.getAction(), JULIAN_ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(1, CalendarSystems.GREGORIAN.getAction(), "Gregorian action not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final CalendarSystems system = CalendarSystems.GREGORIAN;
    assertEquals("GREGORIAN", system.stringValue(), "stringValue not as expected");
   }

 }
