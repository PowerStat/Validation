/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.validation.values.Password;
import de.powerstat.validation.values.strategies.IPasswordStrategy;
import de.powerstat.validation.values.strategies.PasswordConfigurableStrategy;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Password tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class PasswordTests
 {
  /**
   * Username.
   */
  private static final String USERNAME = "username";

  /**
   * Password.
   */
  private static final String PASSWORD = "password"; //$NON-NLS-1$

  /**
   * Password 2.
   */
  private static final String PASSWORD2 = "password2"; //$NON-NLS-1$

  /**
   * Password 3 - only for stringValueNoRead() test.
   */
  private static final String PASSWORD3 = "password4"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Password not as expected constant.
   */
  private static final String PASSWORD_NOT_AS_EXPECTED = "Password not as expected"; //$NON-NLS-1$

  /**
   * Hidden password constant.
   */
  private static final String SECRET_PASSWORD = "********"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ PasswordTests()
   {
    super();
   }


  /**
   * Test Password with valid values.
   *
   * @param password Password
   */
  @ParameterizedTest
  @ValueSource(strings = {USERNAME, "username@example.com", "a2345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234"})
  /* default */ void testPasswordOk0(final String password)
   {
    final Password cleanPassword = Password.of(password);
    assertTrue(cleanPassword.verifyPassword(password), PasswordTests.PASSWORD_NOT_AS_EXPECTED);
   }


  /**
   * Test Password with valid values.
   */
  @Test
  /* default */ void testPasswordOk1()
   {
    final IPasswordStrategy strategy = PasswordConfigurableStrategy.of(2, 254, "^[!§$%&/()=?öäüÖÄÜ,.:;_@0-9a-zA-Z-]+$", 0, 0, 0, 0, 0, 0); //$NON-NLS-1$
    final Password cleanPassword = Password.of(strategy, "username"); //$NON-NLS-1$
    assertNotNull(cleanPassword, PasswordTests.PASSWORD_NOT_AS_EXPECTED);
   }


  /**
   * Test Password with wrong vaidation.
   */
  @Test
  /* default */ void testPasswordWrongValidation()
   {
    final Password cleanPassword = Password.of(PasswordTests.PASSWORD);
    assertFalse(cleanPassword.verifyPassword("wrongPassword"), "Password verification not as expected"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test Password is empty.
   */
  @Test
  /* default */ void testPasswordEmpty()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Password cleanPassword = */ new Password("");
     }, PasswordTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test Password with password to short or long.
   *
   * @param password Password
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "a234567", "a23456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345"})
  /* default */ void testPasswordLength(final String password)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Password cleanPassword = */ Password.of(password);
     }, PasswordTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test Password with illegal characters.
   */
  @Test
  /* default */ void testPasswordWithIllegalCharacters0()
   {
    final IPasswordStrategy strategy = PasswordConfigurableStrategy.of(2, 254, "^[!§$%&/()=?öäüÖÄÜ,.:;_@0-9a-zA-Z-]+$", 0, 0, 0, 0, 0, 0); //$NON-NLS-1$
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Password cleanPassword = */ Password.of(strategy, "\"€"); //$NON-NLS-1$
     }, PasswordTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get password.
   */
  @Test
  /* default */ void testStringValueNoRead()
   {
    final Password password = Password.of(PasswordTests.PASSWORD3);
    assertEquals(SECRET_PASSWORD, password.stringValue(), PasswordTests.PASSWORD_NOT_AS_EXPECTED);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Password password1 = Password.of(PasswordTests.PASSWORD);
    final Password password2 = Password.of(PasswordTests.PASSWORD);
    final Password password3 = Password.of(PasswordTests.PASSWORD2);
    final Password password4 = Password.of("password3"); //$NON-NLS-1$
    final Password password5 = Password.of(PasswordTests.PASSWORD);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(password1.compareTo(password2) == -password2.compareTo(password1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(password1.compareTo(password3) == -password3.compareTo(password1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((password4.compareTo(password3) > 0) && (password3.compareTo(password1) > 0) && (password4.compareTo(password1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((password1.compareTo(password2) == 0) && (Math.abs(password1.compareTo(password5)) == Math.abs(password2.compareTo(password5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((password1.compareTo(password2) == 0) && password1.equals(password2), "equals") //$NON-NLS-1$
    );
   }

 }
