/*
 * Copyright (C) 2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
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

import de.powerstat.validation.values.Firstname;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Firstname tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class FirstnameTests
 {
  /**
   * Firstname.
   */
  private static final String FIRSTNAME = "firstname"; //$NON-NLS-1$

  /**
   * Firstname z.
   */
  private static final String FIRSTNAMEZ = "firstnamez"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Firstname not as expected.
   */
  private static final String FIRSTNAME_NOT_AS_EXPECTED = "Firstname not as expected"; //$NON-NLS-1$

  /**
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public FirstnameTests()
   {
    super();
   }


  /**
   * Test Firstname with valid values.
   *
   * @param firstname Firstname
   */
  @ParameterizedTest
  @ValueSource(strings = {"K", "Kai", FirstnameTests.FIRSTNAME, "AbcdefghijklmnopqrstuvwxyzäöüßAB"})
  public void firstnameOk0(final String firstname)
   {
    final Firstname cleanFirstname = Firstname.of(firstname);
    assertEquals(firstname, cleanFirstname.stringValue(), FirstnameTests.FIRSTNAME_NOT_AS_EXPECTED);
   }


  /**
   * Test Firstname with firstname to short or long.
   *
   * @param firstname Firstname
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "AbcdefghijklmnopqrstuvwxyzäöüßABC"})
  public void firstnameLength(final String firstname)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Firstname cleanFirstname = */ Firstname.of(firstname);
     }, FirstnameTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test Firstname with illegal characters.
   */
  @Test
  public void firstnameWithIllegalCharacters0()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Firstname cleanFirstname = */ Firstname.of("^!$%&(){}[]=?+*#´§;,:'\""); //$NON-NLS-1$
     }, FirstnameTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get firstname.
   *
   * @deprecated Old version of stringValue()
   */
  @Deprecated(since = FirstnameTests.DEPRECATED_SINCE_3_0, forRemoval = false)
  @Test
  public void getFirstname()
   {
    final Firstname firstname = Firstname.of(FirstnameTests.FIRSTNAME);
    assertEquals(FirstnameTests.FIRSTNAME, firstname.getFirstname(), FirstnameTests.FIRSTNAME_NOT_AS_EXPECTED);
   }


  /**
   * Test stringValue.
   */
  @Test
  public void stringValue()
   {
    final Firstname firstname = Firstname.of(FirstnameTests.FIRSTNAME);
    assertEquals(FirstnameTests.FIRSTNAME, firstname.stringValue(), FirstnameTests.FIRSTNAME_NOT_AS_EXPECTED);
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Firstname firstname1 = Firstname.of(FirstnameTests.FIRSTNAME);
    final Firstname firstname2 = Firstname.of(FirstnameTests.FIRSTNAME);
    final Firstname firstname3 = Firstname.of(FirstnameTests.FIRSTNAMEZ);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(firstname1.hashCode(), firstname2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(firstname1.hashCode(), firstname3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Firstname firstname1 = Firstname.of(FirstnameTests.FIRSTNAME);
    final Firstname firstname2 = Firstname.of(FirstnameTests.FIRSTNAME);
    final Firstname firstname3 = Firstname.of(FirstnameTests.FIRSTNAMEZ);
    final Firstname firstname4 = Firstname.of(FirstnameTests.FIRSTNAME);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(firstname1.equals(firstname1), "firstname11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(firstname1.equals(firstname2), "firstname12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(firstname2.equals(firstname1), "firstname21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(firstname2.equals(firstname4), "firstname24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(firstname1.equals(firstname4), "firstname14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(firstname1.equals(firstname3), "firstname13 are equal"), //$NON-NLS-1$
      () -> assertFalse(firstname3.equals(firstname1), "firstname31 are equal"), //$NON-NLS-1$
      () -> assertFalse(firstname1.equals(null), "firstname10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Firstname firstname = Firstname.of(FirstnameTests.FIRSTNAME);
    assertEquals("Firstname[firstname=firstname]", firstname.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Firstname firstname1 = Firstname.of(FirstnameTests.FIRSTNAME);
    final Firstname firstname2 = Firstname.of(FirstnameTests.FIRSTNAME);
    final Firstname firstname3 = Firstname.of("firstnamey"); //$NON-NLS-1$
    final Firstname firstname4 = Firstname.of(FirstnameTests.FIRSTNAMEZ);
    final Firstname firstname5 = Firstname.of(FirstnameTests.FIRSTNAME);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(firstname1.compareTo(firstname2) == -firstname2.compareTo(firstname1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(firstname1.compareTo(firstname3) == -firstname3.compareTo(firstname1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((firstname4.compareTo(firstname3) > 0) && (firstname3.compareTo(firstname1) > 0) && (firstname4.compareTo(firstname1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((firstname1.compareTo(firstname2) == 0) && (Math.abs(firstname1.compareTo(firstname5)) == Math.abs(firstname2.compareTo(firstname5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((firstname1.compareTo(firstname2) == 0) && firstname1.equals(firstname2), "equals") //$NON-NLS-1$
    );
   }

 }
