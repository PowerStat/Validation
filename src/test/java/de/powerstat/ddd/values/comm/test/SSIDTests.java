/*
 * Copyright (C) 2026 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.comm.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.ddd.values.comm.SSID;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * SSID tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class SSIDTests
 {
  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * SSID not as expected.
   */
  private static final String SSID_NOT_AS_EXPECTED = "SSID not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ SSIDTests()
   {
    super();
   }


  /**
   * Test constructor failure null pointer.
   */
  @Test
  /* default */ void testConstructorFailureNull()
   {
    assertThrows(NullPointerException.class, () ->
     {
      /* final SSID ssid = */ SSID.of(null);
     }, "Null pointer exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test constructor failure illegal argument.
   *
   * @param ssid SSID
   */
  @ParameterizedTest
  @ValueSource(strings = {"ü", " ", "test ", " test", " test "})
  /* default */ void testConstructorFailure1(final String ssid)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final SSID ssid = */ SSID.of(ssid);
     }, SSIDTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test constructor successfully.
   *
   * @param ssidstr SSID
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "test123", "\"", "!", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", ".", "/", ":", ";", "<", "=", ">", "?", "@", "^", "_", "|", "~", "`", "{", "}", "-", "\\", "[", "]"})
  /* default */ void testConstructorSuccess(final String ssidstr)
   {
    final SSID ssid = SSID.of(ssidstr);
    assertEquals(ssidstr, ssid.ssid(), SSIDTests.SSID_NOT_AS_EXPECTED);
   }


  /**
   * Test get address.
   */
  @Test
  /* default */ void testStringValue1()
   {
    final SSID ssid = SSID.of("test");
    assertEquals("test", ssid.stringValue(), SSIDTests.SSID_NOT_AS_EXPECTED);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final SSID ssid1 = SSID.of("test");
    final SSID ssid2 = SSID.of("test");
    final SSID ssid3 = SSID.of("test2");
    final SSID ssid4 = SSID.of("test3"); //$NON-NLS-1$
    final SSID ssid5 = SSID.of("test");
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(ssid1.compareTo(ssid2) == -ssid2.compareTo(ssid1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(ssid1.compareTo(ssid3) == -ssid3.compareTo(ssid1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((ssid4.compareTo(ssid3) > 0) && (ssid3.compareTo(ssid1) > 0) && (ssid4.compareTo(ssid1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((ssid1.compareTo(ssid2) == 0) && (Math.abs(ssid1.compareTo(ssid5)) == Math.abs(ssid2.compareTo(ssid5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((ssid1.compareTo(ssid2) == 0) && ssid1.equals(ssid2), "equals") //$NON-NLS-1$
    );
   }

 }
