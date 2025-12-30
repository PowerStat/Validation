/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.impl.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.ddd.values.impl.ISBN13Publisher0;


/**
 * ISBN13 publisher 0 tests.
 */
final class ISBN13Publisher0Tests
 {
  /**
   * Result not as expected.
   */
  private static final String RESULT_NOT_AS_EXPECTED = "Result not as expected!";


  /**
   * Default Constructor.
   */
  /* default */ ISBN13Publisher0Tests()
   {
    super();
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testConstructor1()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    assertNotNull(publisher, "Publisher not as expected!");
   }


  /**
   * Test constructor.
   *
   * @param rest Rest of isbn number
   */
  @ParameterizedTest
  @ValueSource(strings = {"012", "112", "2123", "3123", "4123", "5123", "6123", "71234", "80123", "81123", "82123", "83123", "84123", "851234", "861234", "871234", "881234", "891234", "9012345", "9112345", "9212345", "9312345", "9412345", "95123456", "96123456", "97123456", "98123456", "99123456"})
  /* default */ void testPublisher1(final String rest)
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher(rest);
    assertEquals(rest.subSequence(0, rest.length() - 1), result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor failure.
   *
   * @param rest Rest of isbn number
   */
  @ParameterizedTest
  @ValueSource(strings = {"X", "8X", "9X"})
  /* default */ void testPublisher10(final String rest)
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher(rest);
     }, "IllegalArgumentException expected!"
    );
   }

 }
