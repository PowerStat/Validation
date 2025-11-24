/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.validation.values.Username;
import de.powerstat.validation.values.strategies.IUsernameStrategy;
import de.powerstat.validation.values.strategies.UsernameDefaultStrategy;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Username tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class UsernameTests
 {
  /**
   * Username.
   */
  private static final String USERNAME = "username"; //$NON-NLS-1$

  /**
   * Username 2.
   */
  private static final String USERNAME22 = "username2"; //$NON-NLS-1$

  /**
   * Username kh.
   */
  private static final String USERNAME_KH = "kh"; //$NON-NLS-1$

  /**
   * Username not as expected constant.
   */
  private static final String USERNAME_NOT_AS_EXPECTED = "Username not as expected"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ UsernameTests()
   {
    super();
   }


  /**
   * Test Username with valid values.
   *
   * @param username Username
   */
  @ParameterizedTest
  @ValueSource(strings = {UsernameTests.USERNAME_KH, UsernameTests.USERNAME, "username@example.com", "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234"})
  /* default */ void testUsernameOk0(final String username)
   {
    final Username cleanUsername = Username.of(username);
    assertEquals(username, cleanUsername.stringValue(), UsernameTests.USERNAME_NOT_AS_EXPECTED);
   }


  /**
   * Test Username chaching.
   */
  @Test
  /* default */ void testUsernameCache()
   {
    final Username username1 = Username.of(UsernameDefaultStrategy.of(), UsernameTests.USERNAME_KH);
    final Username username2 = Username.of(UsernameDefaultStrategy.of(), UsernameTests.USERNAME_KH);
    assertEquals(username1, username2, UsernameTests.USERNAME_NOT_AS_EXPECTED);
   }


  /**
   * Test Username with username to short or long.
   *
   * @param username Username
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "k", "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345"})
  /* default */ void testUsernameLength(final String username)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Username cleanUsername = */ Username.of(username);
     }, UsernameTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test Username with illegal characters.
   */
  @Test
  /* default */ void testUsernameWithIllegalCharacters0()
   {
    final IUsernameStrategy strategy = UsernameDefaultStrategy.of();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Username cleanUsername = */ Username.of(strategy, "^!$%&(){}[]=?+*#´üöäÖÄÜß§;,:'\""); //$NON-NLS-1$
     }, UsernameTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test Username is empty.
   */
  @Test
  /* default */ void testUsernameEmpty()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Username cleanUsername = */ new Username(""); //$NON-NLS-1$
     }, UsernameTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Username username = Username.of(UsernameTests.USERNAME);
    assertEquals(UsernameTests.USERNAME, username.stringValue(), UsernameTests.USERNAME_NOT_AS_EXPECTED);
   }


  /**
   * Test get isEMail true.
   */
  @Test
  /* default */ void testGetisEmailTrue()
   {
    final Username username = Username.of(UsernameDefaultStrategy.of(), "username@example.com"); //$NON-NLS-1$
    assertTrue(username.isEMail(), "Username is not an email address"); //$NON-NLS-1$
   }


  /**
   * Test get isEMail false.
   */
  @Test
  /* default */ void testGetisEmailFalse()
   {
    final Username username = Username.of(UsernameDefaultStrategy.of(), UsernameTests.USERNAME);
    assertFalse(username.isEMail(), "Username is an email address"); //$NON-NLS-1$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Username username1 = Username.of(UsernameTests.USERNAME);
    final Username username2 = Username.of(UsernameTests.USERNAME);
    final Username username3 = Username.of(UsernameTests.USERNAME22);
    final Username username4 = Username.of("username3"); //$NON-NLS-1$
    final Username username5 = Username.of(UsernameTests.USERNAME);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(username1.compareTo(username2) == -username2.compareTo(username1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(username1.compareTo(username3) == -username3.compareTo(username1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((username4.compareTo(username3) > 0) && (username3.compareTo(username1) > 0) && (username4.compareTo(username1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((username1.compareTo(username2) == 0) && (Math.abs(username1.compareTo(username5)) == Math.abs(username2.compareTo(username5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((username1.compareTo(username2) == 0) && username1.equals(username2), "equals") //$NON-NLS-1$
    );
   }

 }
