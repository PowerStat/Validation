/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
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

import de.powerstat.validation.values.Port;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Tests for Port value class.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
public class PortTests
 {
  /**
   * Port should be 49152 constant.
   */
  private static final String PORT_SHOULD_BE_49152 = "Port should be 49152!"; //$NON-NLS-1$

  /**
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$

  /**
   * Port 49152 constant.
   */
  private static final String PORT_49152 = "49152"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public PortTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  public void factory1()
   {
    assertEquals(49152, Port.of(PORT_49152).intValue(), PortTests.PORT_SHOULD_BE_49152);
   }


  /**
   * Is port.
   */
  @Test
  public void isPort()
   {
    final Port port = Port.of(49152);
    assertEquals(49152, port.intValue(), PortTests.PORT_SHOULD_BE_49152);
   }


  /**
   * Is not a port.
   *
   * @param port Port
   */
  @ParameterizedTest
  @ValueSource(ints = {65536, -1})
  public void isPortFalse(final int port)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Port port = */ Port.of(port);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test getPort.
   *
   * @deprecated Old version of intValue()
   */
  @Deprecated(since = PortTests.DEPRECATED_SINCE_3_0, forRemoval = false)
  @Test
  public void getPort()
   {
    final Port port = Port.of(49152);
    assertEquals(49152, port.getPort(), PortTests.PORT_SHOULD_BE_49152);
   }


  /**
   * Test intValue.
   */
  @Test
  public void intValue()
   {
    final Port port = Port.of(49152);
    assertEquals(49152, port.intValue(), PortTests.PORT_SHOULD_BE_49152);
   }


  /**
   * Test stringValue.
   */
  @Test
  public void stringValue()
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
  public void isSystem(final int port)
   {
    assertTrue(Port.of(port).isSystem(), "Should be a system port!"); //$NON-NLS-1$
   }


  /**
   * Is not a system port.
   */
  @Test
  public void isSystemFalse()
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
  public void isRegistered(final int port)
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
  public void isRegisteredFalse(final int port)
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
  public void isDynamic(final int port)
   {
    assertTrue(Port.of(port).isDynamic(), "Should be a dynamic port!"); //$NON-NLS-1$
   }


  /**
   * Is not a dynamic port.
   */
  @Test
  public void isDynamicFalse()
   {
    assertFalse(Port.of(1023).isDynamic(), "Should not be a dynamic port!"); //$NON-NLS-1$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Port port1 = Port.of(1024);
    final Port port2 = Port.of(1024);
    final Port port3 = Port.of(1025);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(port1.hashCode(), port2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(port1.hashCode(), port3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Port port1 = Port.of(1024);
    final Port port2 = Port.of(1024);
    final Port port3 = Port.of(1025);
    final Port port4 = Port.of(1024);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(port1.equals(port1), "port11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(port1.equals(port2), "port12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(port2.equals(port1), "port21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(port2.equals(port4), "port24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(port1.equals(port4), "port14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(port1.equals(port3), "port13 are equal"), //$NON-NLS-1$
      () -> assertFalse(port3.equals(port1), "port31 are equal"), //$NON-NLS-1$
      () -> assertFalse(port1.equals(null), "port10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Port port = Port.of(49152);
    assertEquals("Port[port=49152]", port.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
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
