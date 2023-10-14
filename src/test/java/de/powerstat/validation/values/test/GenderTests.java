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
  public GenderTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  public void factory1()
   {
    assertEquals(0, Gender.of(UNKNOWN).getAction(), UNKNOWN_ACTION_NOT_AS_EXPECTED);
   }


  /**
   * Test getAction of Gender.
   */
  @Test
  public void getAction()
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
  public void stringValue()
   {
    final Gender gender = Gender.UNKNOWN;
    assertEquals(UNKNOWN, gender.stringValue(), "stringValue not as expected");
   }

 }
