/*
 * Copyright (C) 2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.Gender;


/**
 * Gender tests.
 */
public class GenderTests
 {
  /**
   * Default constructor.
   */
  public GenderTests()
   {
    super();
   }


  /**
   * Test getAction of Gender.
   */
  @Test
  public void getAction()
   {
    assertAll("constructor", //$NON-NLS-1$
      () -> assertEquals(0, Gender.UNKNOWN.getAction(), "UNKNOWN action not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, Gender.FEMALE.getAction(), "FEMALE action not as expected"), //$NON-NLS-1$
      () -> assertEquals(2, Gender.MALE.getAction(), "MALE action not as expected"), //$NON-NLS-1$
      () -> assertEquals(3, Gender.BOTH.getAction(), "BOTH action not as expected"), //$NON-NLS-1$
      () -> assertEquals(4, Gender.VARIABLE.getAction(), "VARIABLE action not as expected"), //$NON-NLS-1$
      () -> assertEquals(5, Gender.NEUTRAL.getAction(), "NEUTRAL action not as expected"), //$NON-NLS-1$
      () -> assertEquals(6, Gender.OTHER.getAction(), "OTHER action not as expected") //$NON-NLS-1$
    );
   }

 }
