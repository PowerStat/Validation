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

import de.powerstat.ddd.values.impl.ISBN13Publisher1;


/**
 * ISBN13 publisher 0 tests.
 */
final class ISBN13Publisher1Tests
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
  /* default */ ISBN13Publisher1Tests()
   {
    super();
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testConstructor1()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    assertNotNull(publisher, "Publisher not as expected!");
   }


  /**
   * Test constructor.
   *
   * @param rest Rest of ISBN
   */
  @ParameterizedTest
  @ValueSource(strings = {"012", "1123", "2123", "3123", "41234", "50123", "51123", "52123", "53123", "54123", "551234", "561234", "571234", "581234", "591234", "612345", "701234", "801234", "811234", "821234", "831234", "841234", "851234", "8712345", "8812345", "8912345", "860123", "861123", "862123", "863123", "864123", "865123", "866123", "867123", "868123", "869012", "869112", "869212", "869312", "869412", "869512", "869612", "869712", "8698123", "8699123", "869112", "869212", "869312", "869412", "869512", "869612", "869712", "8698123", "8699123"})
  /* default */ void testPublisher1(final String rest)
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher(rest);
    assertEquals(rest.subSequence(0, rest.length() - 1), result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor failure.
   *
   * @param rest Rest of ISBN
   */
  @ParameterizedTest
  @ValueSource(strings = {"5X", "8X", "869X", "86X", "9", "X"})
  /* default */ void testPublisher10(final String rest)
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher(rest);
     }, ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED
    );
   }

 }
