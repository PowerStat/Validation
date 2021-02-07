/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class PasswordTests
 {
  /**
   * Password.
   */
  private static final String PASSWORD = "password"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public PasswordTests()
   {
    super();
   }


  /**
   * Test Password with valid values.
   *
   * @param password Password
   */
  @ParameterizedTest
  @ValueSource(strings = {"username", "username@example.com", "a2345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234"})
  public void passwordOk0(final String password)
   {
    final Password cleanPassword = Password.of(password);
    assertTrue(cleanPassword.verifyPassword(password), "Password not as expected"); //$NON-NLS-1$
   }


  /**
   * Test Password with wrong vaidation.
   */
  @Test
  public void passwordWrongValidation()
   {
    final Password cleanPassword = Password.of(PASSWORD);
    assertFalse(cleanPassword.verifyPassword("wrongPassword"), "Password verification not as expected"); //$NON-NLS-1$
   }


  /**
   * Test Password with password to short or long.
   *
   * @param password Password
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "a234567", "a23456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345"})
  public void passwordLength(final String password)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Password cleanPassword = */ Password.of(password);
     }
    );
   }


  /**
   * Test Password with illegal characters.
   */
  @Test
  public void passwordWithIllegalCharacters0()
   {
    final IPasswordStrategy strategy = PasswordConfigurableStrategy.of(2, 254, "^[!§$%&/()=?öäüÖÄÜ,.:;_@0-9a-zA-Z-]+$", 0 , 0, 0, 0, 0, 0); //$NON-NLS-1$
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Password cleanPassword = */ Password.of(strategy, "\"€"); //$NON-NLS-1$
     }
    );
   }


  /**
   * Test get password.
   */
  @Test
  public void getPassword()
   {
    final Password password = Password.of(PASSWORD);
    assertEquals(PASSWORD, password.getPassword(), "Password not as expected"); //$NON-NLS-1$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Password password1 = Password.of(PASSWORD);
    final Password password2 = Password.of(PASSWORD);
    final Password password3 = Password.of("password2"); //$NON-NLS-1$
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(password1.hashCode(), password2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(password1.hashCode(), password3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Password password1 = Password.of(PASSWORD);
    final Password password2 = Password.of(PASSWORD);
    final Password password3 = Password.of("password2"); //$NON-NLS-1$
    final Password password4 = Password.of(PASSWORD);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(password1.equals(password1), "password11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(password1.equals(password2), "password12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(password2.equals(password1), "password21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(password2.equals(password4), "password24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(password1.equals(password4), "password14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(password1.equals(password3), "password13 are equal"), //$NON-NLS-1$
      () -> assertFalse(password3.equals(password1), "password31 are equal"), //$NON-NLS-1$
      () -> assertFalse(password1.equals(null), "password10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Password password = Password.of(PASSWORD);
    assertEquals("Password[password=********]", password.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Password password1 = Password.of(PASSWORD);
    final Password password2 = Password.of(PASSWORD);
    final Password password3 = Password.of("password2"); //$NON-NLS-1$
    final Password password4 = Password.of("password3"); //$NON-NLS-1$
    final Password password5 = Password.of(PASSWORD);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(password1.compareTo(password2) == -password2.compareTo(password1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(password1.compareTo(password3) == -password3.compareTo(password1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((password4.compareTo(password3) > 0) && (password3.compareTo(password1) > 0) && (password4.compareTo(password1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((password1.compareTo(password2) == 0) && (Math.abs(password1.compareTo(password5)) == Math.abs(password2.compareTo(password5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((password1.compareTo(password2) == 0) && password1.equals(password2), "equals") //$NON-NLS-1$
    );
   }

 }
