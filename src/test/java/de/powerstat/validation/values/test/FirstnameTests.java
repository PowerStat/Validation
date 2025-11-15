/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
final class FirstnameTests
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
   * Default constructor.
   */
  /* default */ FirstnameTests()
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
  /* default */ void testFirstnameOk0(final String firstname)
   {
    final Firstname cleanFirstname = Firstname.of(firstname);
    assertEquals(firstname, cleanFirstname.firstname(), FirstnameTests.FIRSTNAME_NOT_AS_EXPECTED);
   }


  /**
   * Test Firstname with firstname to short or long.
   *
   * @param firstname Firstname
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "AbcdefghijklmnopqrstuvwxyzäöüßABC"})
  /* default */ void testFirstnameLength(final String firstname)
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
  /* default */ void testFirstnameWithIllegalCharacters0()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Firstname cleanFirstname = */ Firstname.of("^!$%&(){}[]=?+*#´§;,:'\""); //$NON-NLS-1$
     }, FirstnameTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Firstname firstname = Firstname.of(FirstnameTests.FIRSTNAME);
    assertEquals(FirstnameTests.FIRSTNAME, firstname.stringValue(), FirstnameTests.FIRSTNAME_NOT_AS_EXPECTED);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
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
