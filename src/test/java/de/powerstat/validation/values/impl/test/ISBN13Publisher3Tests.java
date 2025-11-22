/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.impl.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.validation.values.impl.ISBN13Publisher3;


/**
 * ISBN13 publisher 0 tests.
 */
final class ISBN13Publisher3Tests
 {
  /**
   * Illegal argument exception expected.
   */
  private static final String ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED = "IllegalArgumentException expected!";

  /**
   * Result not as expected.
   */
  private static final String RESULT_NOT_AS_EXPECTED = "Result not as expected!";


  /**
   * Default Constructor.
   */
  /* default */ ISBN13Publisher3Tests()
   {
    super();
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testConstructor1()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    assertNotNull(publisher, "Publisher not as expected!");
   }


  /**
   * Test constructor.
   *
   * @param rest Rest ISBN
   */
  @ParameterizedTest
  @ValueSource(strings = {"001", "021", "041", "051", "061", "071", "081", "091", "0301", "0311", "0321", "0331", "03412", "03512", "03612", "037123", "038123", "039123", "112", "2123", "3123", "4123", "5123", "6123", "71234", "80123", "81123", "82123", "83123", "84123", "851234", "861234", "871234", "881234", "891234","9012345", "9112345", "9212345", "9312345", "9412345", "95012345", "95112345", "95212345", "95312345", "954123", "955123", "956123", "957123", "958123", "959123", "961234", "97123456", "98123456", "991234"})
  /* default */ void testPublisher1(final String rest)
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher(rest);
    assertEquals(rest.subSequence(0, rest.length() - 1), result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor failure.
   *
   * @param rest Rest ISBN
   */
  @ParameterizedTest
  @ValueSource(strings = {"0X", "03X", "8X", "95X", "9X", "X"})
  /* default */ void testPublisher1h(final String rest)
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher(rest);
     }, ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED
    );
   }

 }
