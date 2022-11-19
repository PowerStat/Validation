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

import de.powerstat.validation.values.Username;
import de.powerstat.validation.values.strategies.UsernameDefaultStrategy;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Username tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class UsernameTests
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
  public UsernameTests()
   {
    super();
   }


  /**
   * Test Username with valid values.
   *
   * @param username Username
   */
  @ParameterizedTest
  @ValueSource(strings = {"kh", UsernameTests.USERNAME, "username@example.com", "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234"})
  public void usernameOk0(final String username)
   {
    final Username cleanUsername = Username.of(username);
    assertEquals(username, cleanUsername.getUsername(), UsernameTests.USERNAME_NOT_AS_EXPECTED);
   }


  /**
   * Test Username with username to short or long.
   *
   * @param username Username
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "k", "123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345"})
  public void usernameLength(final String username)
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
  public void usernameWithIllegalCharacters0()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Username cleanUsername = */ Username.of(UsernameDefaultStrategy.of(), "^!$%&(){}[]=?+*#´üöäÖÄÜß§;,:'\""); //$NON-NLS-1$
     }, UsernameTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get username.
   */
  @Test
  public void getUsername()
   {
    final Username username = Username.of(UsernameTests.USERNAME);
    assertEquals(UsernameTests.USERNAME, username.getUsername(), UsernameTests.USERNAME_NOT_AS_EXPECTED);
   }


  /**
   * Test get isEMail true.
   */
  @Test
  public void getisEmailTrue()
   {
    final Username username = Username.of(UsernameDefaultStrategy.of(), "username@example.com"); //$NON-NLS-1$
    assertTrue(username.isEMail(), "Username is not an email address"); //$NON-NLS-1$
   }


  /**
   * Test get isEMail false.
   */
  @Test
  public void getisEmailFalse()
   {
    final Username username = Username.of(UsernameDefaultStrategy.of(), UsernameTests.USERNAME);
    assertFalse(username.isEMail(), "Username is an email address"); //$NON-NLS-1$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Username username1 = Username.of(UsernameTests.USERNAME);
    final Username username2 = Username.of(UsernameTests.USERNAME);
    final Username username3 = Username.of(UsernameTests.USERNAME22);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(username1.hashCode(), username2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(username1.hashCode(), username3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Username username1 = Username.of(UsernameTests.USERNAME);
    final Username username2 = Username.of(UsernameTests.USERNAME);
    final Username username3 = Username.of(UsernameTests.USERNAME22);
    final Username username4 = Username.of(UsernameTests.USERNAME);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(username1.equals(username1), "username11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(username1.equals(username2), "username12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(username2.equals(username1), "username21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(username2.equals(username4), "username24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(username1.equals(username4), "username14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(username1.equals(username3), "username13 are equal"), //$NON-NLS-1$
      () -> assertFalse(username3.equals(username1), "username31 are equal"), //$NON-NLS-1$
      () -> assertFalse(username1.equals(null), "username10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Username username = Username.of(UsernameTests.USERNAME);
    assertEquals("Username[username=username]", username.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
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
