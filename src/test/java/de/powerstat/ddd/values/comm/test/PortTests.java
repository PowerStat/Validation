/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.comm.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.ddd.values.comm.Port;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Tests for Port value class.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class PortTests
 {
  /**
   * Port should be 49152 constant.
   */
  private static final String PORT_SHOULD_BE_49152 = "Port should be 49152!"; //$NON-NLS-1$

  /**
   * Port 49152 constant.
   */
  private static final String PORT_49152 = "49152"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ PortTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(49152, Port.of(PORT_49152).port(), PortTests.PORT_SHOULD_BE_49152);
   }


  /**
   * Is port.
   */
  @Test
  /* default */ void testIsPort()
   {
    final Port port = Port.of(49152);
    assertEquals(49152, port.port(), PortTests.PORT_SHOULD_BE_49152);
   }


  /**
   * Is not a port.
   *
   * @param port Port
   */
  @ParameterizedTest
  @ValueSource(ints = {65536, -1})
  /* default */ void testIsPortFalse(final int port)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Port port = */ Port.of(port);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test port.
   */
  @Test
  /* default */ void testIntValue()
   {
    final Port port = Port.of(49152);
    assertEquals(49152, port.port(), PortTests.PORT_SHOULD_BE_49152);
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Port port = Port.of(49152);
    assertEquals(PORT_49152, port.stringValue(), PortTests.PORT_SHOULD_BE_49152);
   }


  /**
   * Is system port.
   *
   * @param port Port
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 1023})
  /* default */ void testIsSystem(final int port)
   {
    assertTrue(Port.of(port).isSystem(), "Should be a system port!"); //$NON-NLS-1$
   }


  /**
   * Is not a system port.
   */
  @Test
  /* default */ void testIsSystemFalse()
   {
    assertFalse(Port.of(49152).isSystem(), "Should not be a system port!"); //$NON-NLS-1$
   }


  /**
   * Is registered port.
   *
   * @param port Port
   */
  @ParameterizedTest
  @ValueSource(ints = {1024, 49151})
  /* default */ void testIsRegistered(final int port)
   {
    assertTrue(Port.of(port).isRegistered(), "Should be a registered port!"); //$NON-NLS-1$
   }


  /**
   * Is not a registered port.
   *
   * @param port Port
   */
  @ParameterizedTest
  @ValueSource(ints = {1023, 49152})
  /* default */ void testIsRegisteredFalse(final int port)
   {
    assertFalse(Port.of(port).isRegistered(), "Should not be a registered port!"); //$NON-NLS-1$
   }


  /**
   * Is dynamic port.
   *
   * @param port Port
   */
  @ParameterizedTest
  @ValueSource(ints = {49152, 65535})
  /* default */ void testIsDynamic(final int port)
   {
    assertTrue(Port.of(port).isDynamic(), "Should be a dynamic port!"); //$NON-NLS-1$
   }


  /**
   * Is not a dynamic port.
   */
  @Test
  /* default */ void testIsDynamicFalse()
   {
    assertFalse(Port.of(1023).isDynamic(), "Should not be a dynamic port!"); //$NON-NLS-1$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Port port1 = Port.of(1024);
    final Port port2 = Port.of(1024);
    final Port port3 = Port.of(1025);
    final Port port4 = Port.of(1026);
    final Port port5 = Port.of(1024);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(port1.compareTo(port2) == -port2.compareTo(port1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(port1.compareTo(port3) == -port3.compareTo(port1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((port4.compareTo(port3) > 0) && (port3.compareTo(port1) > 0) && (port4.compareTo(port1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((port1.compareTo(port2) == 0) && (Math.abs(port1.compareTo(port5)) == Math.abs(port2.compareTo(port5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((port1.compareTo(port2) == 0) && port1.equals(port2), "equals") //$NON-NLS-1$
    );
   }

 }
