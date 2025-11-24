/*
 * Copyright (C) 2021-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.EqualsVerifier;

import de.powerstat.validation.values.WGS84Position;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * WGS84 position tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class WGS84PositionTests
 {
  /**
   * Index out of bounds exception expected constant.
   */
  private static final String INDEX_OUT_OF_BOUNDS_EXPECTED = "Index out of bounds exception expected"; //$NON-NLS-1$

  /**
   * Zero position constant.
   */
  private static final String ZERO = "0.0 0.0 0.0"; //$NON-NLS-1$

  /**
   * Latitute error constant.
   */
  private static final String LATITUTE_ERROR = "Latitute error!"; //$NON-NLS-1$

  /**
   * Longitute error constant.
   */
  private static final String LONGITUTE_ERROR = "Longitute error!"; //$NON-NLS-1$

  /**
   * Altitude error constant.
   */
  private static final String ALTITUDE_ERROR = "Altitude error!"; //$NON-NLS-1$

  /**
   * Suppress sonarqube warning.
   */
  private static final String JAVA_S5785 = "java:S5785"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ WGS84PositionTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    final WGS84Position pos = WGS84Position.of(ZERO);
    assertAll("factory1", //$NON-NLS-1$
      () -> assertEquals(0.0, pos.getLatitude(), LATITUTE_ERROR),
      () -> assertEquals(0.0, pos.getLongitude(), LONGITUTE_ERROR),
      () -> assertEquals(0.0, pos.getAltitude(), ALTITUDE_ERROR)
    );
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory2()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final WGS84Position pos = */ WGS84Position.of("0.0");
     }, "Illegal argument excption"
    );
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory3()
   {
    final WGS84Position pos = WGS84Position.of("-90.0 -180.0 7.0");
    assertAll("factory3", //$NON-NLS-1$
      () -> assertEquals(-90.0, pos.getLatitude(), LATITUTE_ERROR),
      () -> assertEquals(-180.0, pos.getLongitude(), LONGITUTE_ERROR),
      () -> assertEquals(7.0, pos.getAltitude(), ALTITUDE_ERROR)
    );
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory4()
   {
    final WGS84Position pos = WGS84Position.of("90.0 180.0 9.0");
    assertAll("factory4", //$NON-NLS-1$
      () -> assertEquals(90.0, pos.getLatitude(), LATITUTE_ERROR),
      () -> assertEquals(180.0, pos.getLongitude(), LONGITUTE_ERROR),
      () -> assertEquals(9.0, pos.getAltitude(), ALTITUDE_ERROR)
    );
   }


  /**
   * Is WGS84 position.
   */
  @Test
  /* default */ void testIsWGS84Position()
   {
    final WGS84Position pos = WGS84Position.of(0.0, 0.0, 0.0);
    assertAll("testIsPosition", //$NON-NLS-1$
      () -> assertEquals(0.0, pos.getLatitude(), LATITUTE_ERROR),
      () -> assertEquals(0.0, pos.getLongitude(), LONGITUTE_ERROR),
      () -> assertEquals(0.0, pos.getAltitude(), ALTITUDE_ERROR)
    );
   }


  /**
   * Is not a WGS84 position.
   */
  @Test
  /* default */ void testIsNotWGS84Position1()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final WGS84Position pos = */ WGS84Position.of(-90.1, 0.0, 0.0);
     }, WGS84PositionTests.INDEX_OUT_OF_BOUNDS_EXPECTED
    );
   }


  /**
   * Is not a WGS84 position.
   */
  @Test
  /* default */ void testIsNotWGS84Position2()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final WGS84Position pos = */ WGS84Position.of(90.1, 0.0, 0.0);
     }, WGS84PositionTests.INDEX_OUT_OF_BOUNDS_EXPECTED
    );
   }


  /**
   * Is not a WGS84 position.
   */
  @Test
  /* default */ void testIsNotWGS84Position3()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final WGS84Position pos = */ WGS84Position.of(0.0, -180.1, 0.0);
     }, WGS84PositionTests.INDEX_OUT_OF_BOUNDS_EXPECTED
    );
   }


  /**
   * Is not a WGS84 position.
   */
  @Test
  /* default */ void testIsNotWGS84Position4()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final WGS84Position pos = */ WGS84Position.of(0.0, 180.1, 0.0);
     }, WGS84PositionTests.INDEX_OUT_OF_BOUNDS_EXPECTED
    );
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    assertEquals(ZERO, WGS84Position.of(0.0, 0.0, 0.0).stringValue(), "Result not as expected");
   }


  /**
   * Equalsverifier.
   */
  @Test
  /* default */ void testEqualsContract()
   {
    EqualsVerifier.forClass(WGS84Position.class).withNonnullFields("latitude").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final WGS84Position pos = WGS84Position.of(0.0, 0.0, 0.0);
    assertEquals("WGS84Position[latitude=0.0, longitude=0.0, altitude=0.0]", pos.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings(JAVA_S5785)
  /* default */ void testCompareTo()
   {
    final WGS84Position pos1 = WGS84Position.of(0.0, 0.0, 0.0);
    final WGS84Position pos2 = WGS84Position.of(0.0, 0.0, 0.0);
    final WGS84Position pos3 = WGS84Position.of(10.0, 10.0, 0.0);
    final WGS84Position pos4 = WGS84Position.of(20.0, 20.0, 0.0);
    final WGS84Position pos5 = WGS84Position.of(0.0, 0.0, 0.0);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(pos1.compareTo(pos2) == -pos2.compareTo(pos1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(pos1.compareTo(pos3) == -pos3.compareTo(pos1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((pos4.compareTo(pos3) > 0) && (pos3.compareTo(pos1) > 0) && (pos4.compareTo(pos1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((pos1.compareTo(pos2) == 0) && (Math.abs(pos1.compareTo(pos5)) == Math.abs(pos2.compareTo(pos5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((pos1.compareTo(pos2) == 0) && pos1.equals(pos2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test not compareTo.
   */
  @Test
  @SuppressWarnings(JAVA_S5785)
  /* default */ void testNotCompareTo()
   {
    final WGS84Position pos1 = WGS84Position.of(0.0, 0.0, 0.0);
    final WGS84Position pos2 = WGS84Position.of(0.0, 150.0, 0.0);
    assertAll("testNotCompareTo", //$NON-NLS-1$
      () -> assertTrue(pos1.compareTo(pos2) != 0, "equal") //$NON-NLS-1$
    );
   }

 }
