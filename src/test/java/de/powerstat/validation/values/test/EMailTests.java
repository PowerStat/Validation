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

import de.powerstat.validation.values.EMail;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * EMail tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT"})
public class EMailTests
 {
  /**
   * EMail address for testing user1@example.com.
   */
  private static final String EMAIL_USER1_AT_EXAMPLE_COM = "user1@example.com"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public EMailTests()
   {
    super();
   }


  /**
   * Test EMail with valid email addresses.
   *
   * @param email Email
   */
  @ParameterizedTest
  @ValueSource(strings = {"u@example.com", "a@a.de", "user@[192.168.1.1]", "user@[ipv6:00fd:0000:0000:0000:0000:0000:0000:0000]", "1234567890123456789012345678901234567890123456789012345678901234@example.com", "a@abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcde.com"})
  public void emailOk0(final String email)
   {
    final EMail cleanEMail = EMail.of(email);
    assertEquals(email, cleanEMail.getEMail(), "EMail not as expected"); //$NON-NLS-1$
   }


  /**
   * Test EMail with email to short or long.
   *
   * @param email EMail
   */
  @ParameterizedTest
  @ValueSource(strings = {"a@a.d", "12345678901234567890123456789012345678901234567890123456789012345@example.com", "a@abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdef.com"})
  public void emailLength(final String email)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final EMail cleanEMail = */ EMail.of(email);
     }
    );
   }


  /**
   * Test EMail with missing @.
   */
  @Test
  public void emailWithMissingAt()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final EMail cleanEMail = */ EMail.of("example.com"); //$NON-NLS-1$
     }
    );
   }


  /**
   * Test EMail with ip and missing close square bracket.
   */
  @Test
  public void emailWithIpAndMissingCloseSquareBracket()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final EMail cleanEMail = */ EMail.of("user@[192.168.1.1"); //$NON-NLS-1$
     }
    );
   }


  /**
   * Test EMail with comments.
   */
  @Test
  public void emailWithComment0()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final EMail cleanEMail = */ EMail.of("(comment)user@example.com"); //$NON-NLS-1$
     }
    );
   }


  /**
   * Test EMail with comments.
   */
  @Test
  public void emailWithComment1()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final EMail cleanEMail = */ EMail.of("user(comment)@example.com"); //$NON-NLS-1$
     }
    );
   }


  /**
   * Test EMail with double quotes.
   */
  @Test
  public void emailWithDoubleQuotes()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final EMail cleanEMail = */ EMail.of("\"user\"@example.com"); //$NON-NLS-1$
     }
    );
   }


  /**
   * Test EMail with dot at start.
   */
  @Test
  public void emailWithDotAtStart()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final EMail cleanEMail = */ EMail.of(".user@example.com"); //$NON-NLS-1$
     }
    );
   }


  /**
   * Test EMail with dot at end.
   */
  @Test
  public void emailWithDotAtEnd()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final EMail cleanEMail = */ EMail.of("user.@example.com"); //$NON-NLS-1$
     }
    );
   }


  /**
   * Test EMail with double dot.
   */
  @Test
  public void emailWithDoubleDot()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final EMail cleanEMail = */ EMail.of("user..name@example.com"); //$NON-NLS-1$
     }
    );
   }


  /**
   * Test EMail with illegal characters.
   */
  @Test
  public void emailWithIllegalCharacters0()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final EMail cleanEMail = */ EMail.of("üöäÖÄÜß§;,:@example.com"); //$NON-NLS-1$
     }
    );
   }


  /**
   * Test get email.
   */
  @Test
  public void getEMail()
   {
    final EMail email = EMail.of("user@example.com"); //$NON-NLS-1$
    assertEquals("user@example.com", email.getEMail(), "EMail not as expected"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final EMail email1 = EMail.of(EMAIL_USER1_AT_EXAMPLE_COM);
    final EMail email2 = EMail.of(EMAIL_USER1_AT_EXAMPLE_COM);
    final EMail email3 = EMail.of("user2@example.com"); //$NON-NLS-1$
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(email1.hashCode(), email2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(email1.hashCode(), email3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final EMail email1 = EMail.of(EMAIL_USER1_AT_EXAMPLE_COM);
    final EMail email2 = EMail.of(EMAIL_USER1_AT_EXAMPLE_COM);
    final EMail email3 = EMail.of("user2@example.com"); //$NON-NLS-1$
    final EMail email4 = EMail.of(EMAIL_USER1_AT_EXAMPLE_COM);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(email1.equals(email1), "email11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(email1.equals(email2), "email12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(email2.equals(email1), "email21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(email2.equals(email4), "email24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(email1.equals(email4), "email14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(email1.equals(email3), "email13 are equal"), //$NON-NLS-1$
      () -> assertFalse(email3.equals(email1), "email31 are equal"), //$NON-NLS-1$
      () -> assertFalse(email1.equals(null), "email10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final EMail email = EMail.of(EMAIL_USER1_AT_EXAMPLE_COM);
    assertEquals("EMail[email=user1@example.com]", email.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final EMail email1 = EMail.of(EMAIL_USER1_AT_EXAMPLE_COM);
    final EMail email2 = EMail.of(EMAIL_USER1_AT_EXAMPLE_COM);
    final EMail email3 = EMail.of("user2@example.com"); //$NON-NLS-1$
    final EMail email4 = EMail.of("user3@example.com"); //$NON-NLS-1$
    final EMail email5 = EMail.of(EMAIL_USER1_AT_EXAMPLE_COM);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(email1.compareTo(email2) == -email2.compareTo(email1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(email1.compareTo(email3) == -email3.compareTo(email1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((email4.compareTo(email3) > 0) && (email3.compareTo(email1) > 0) && (email4.compareTo(email1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((email1.compareTo(email2) == 0) && (Math.abs(email1.compareTo(email5)) == Math.abs(email2.compareTo(email5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((email1.compareTo(email2) == 0) && email1.equals(email2), "equals") //$NON-NLS-1$
    );
   }

 }
