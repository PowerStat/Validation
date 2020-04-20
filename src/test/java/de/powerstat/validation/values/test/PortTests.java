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

import de.powerstat.validation.values.Port;


/**
 * Tests for Port value class.
 */
public class PortTests
 {
  /**
   * Default constructor.
   */
  public PortTests()
   {
    super();
   }


  /**
   * Is port.
   */
  @Test
  public void isPort()
   {
    final Port port = Port.of(49152);
    assertEquals(49152, port.getPort(), "Port shoukd be 49152!"); //$NON-NLS-1$
   }


  /**
   * Is not a port.
   */
  @Test
  public void isPortFalse()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      final Port port = Port.of(65536);
     }
    );
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
   */
  @Test
  public void isRegisteredFalse()
   {
    assertFalse(Port.of(1023).isRegistered(), "Should not be a registered port!"); //$NON-NLS-1$
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
    final Port port1 = new Port(1024);
    final Port port2 = new Port(1024);
    final Port port3 = new Port(1025);
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
    final Port port1 = new Port(1024);
    final Port port2 = new Port(1024);
    final Port port3 = new Port(1025);
    final Port port4 = new Port(1024);
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
    final Port port = new Port(49152);
    assertEquals("Port[port=49152]", port.toString(), "toString not equal"); //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Port port1 = new Port(1024);
    final Port port2 = new Port(1024);
    final Port port3 = new Port(1025);
    final Port port4 = new Port(1026);
    final Port port5 = new Port(1024);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(port1.compareTo(port2) == -port2.compareTo(port1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(port1.compareTo(port3) == -port3.compareTo(port1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((port4.compareTo(port3) > 0) && (port3.compareTo(port1) > 0) && (port4.compareTo(port1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((port1.compareTo(port2) == 0) && (Math.abs(port1.compareTo(port5)) == Math.abs(port2.compareTo(port5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((port1.compareTo(port2) == 0) && port1.equals(port2), "equals") //$NON-NLS-1$
    );
   }

 }
