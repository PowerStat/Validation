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
public class CalendarSystemsTests
 {
  /**
   * Default constructor.
   */
  public CalendarSystemsTests()
   {
    super();
   }


  /**
   * Test getAction of CalendarSystems.
   */
  @Test
  public void getAction()
   {
    assertAll("constructor", //$NON-NLS-1$
      () -> assertEquals(0, CalendarSystems.JULIAN.getAction(), "Julian action not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, CalendarSystems.GREGORIAN.getAction(), "Gregorian action not as expected") //$NON-NLS-1$
    );
   }

 }