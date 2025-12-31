/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
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

import de.powerstat.ddd.values.comm.MACAddress;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * MAC address tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class MACAddressTests
 {
  /**
   * MAC address 00:00:00:00:00:00.
   */
  private static final String MAC_00_00_00_00_00_00 = "00:00:00:00:00:00"; //$NON-NLS-1$

  /**
   * MAC address 00-00-00-00-00-00.
   */
  private static final String MACM_00_00_00_00_00_00 = "00-00-00-00-00-00"; //$NON-NLS-1$

  /**
   * Mac address.
   */
  private static final String MAC_ZERO = "000000000000"; //$NON-NLS-1$

  /**
   * Mac address.
   */
  private static final String MAC_ONE = "00:00:00:00:00:01"; //$NON-NLS-1$

  /**
   * Separator.
   */
  private static final String SEPARATOR = "-"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Address not as expected.
   */
  private static final String ADDRESS_NOT_AS_EXPECTED = "Address not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ MACAddressTests()
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
      /* final MACAddress address = */ MACAddress.of(null);
     }, "Null pointer exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test constructor failure illegal argument.
   *
   * @param mac MAC address
   */
  @ParameterizedTest
  @ValueSource(strings = {"00:00:00:00:00:0g", "00:00:00:00:00:00:", "00:00:00:00:00:0"})
  /* default */ void testConstructorFailure1(final String mac)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final MACAddress address = */ MACAddress.of(mac);
     }, MACAddressTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test constructor successfully.
   *
   * @param mac MAC address
   */
  @ParameterizedTest
  @ValueSource(strings = {MACAddressTests.MAC_00_00_00_00_00_00, MACAddressTests.MACM_00_00_00_00_00_00, MACAddressTests.MAC_ZERO})
  /* default */ void testConstructorSuccess(final String mac)
   {
    final MACAddress address = MACAddress.of(mac);
    assertNotNull(address, MACAddressTests.ADDRESS_NOT_AS_EXPECTED);
   }


  /**
   * Test get address.
   */
  @Test
  /* default */ void testStringValue1()
   {
    final MACAddress address = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertEquals(MACAddressTests.MAC_00_00_00_00_00_00, address.stringValue(), MACAddressTests.ADDRESS_NOT_AS_EXPECTED);
   }


  /**
   * Test get address.
   */
  @Test
  /* default */ void testStringValue2()
   {
    final MACAddress address = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertEquals(MACAddressTests.MACM_00_00_00_00_00_00, address.stringValue(MACAddressTests.SEPARATOR), MACAddressTests.ADDRESS_NOT_AS_EXPECTED);
   }


  /**
   * Test get address.
   */
  @Test
  /* default */ void testStringValue3()
   {
    final MACAddress address = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertEquals(MACAddressTests.MAC_ZERO, address.stringValue(""), MACAddressTests.ADDRESS_NOT_AS_EXPECTED); //$NON-NLS-1$
   }


  /**
   * Test get address.
   */
  @Test
  /* default */ void testByteValue1()
   {
    byte[] expected = new byte[] {0, 0, 0, 0, 0, 0};
    final MACAddress address = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertArrayEquals(expected, address.byteValue(), MACAddressTests.ADDRESS_NOT_AS_EXPECTED);
   }


  /**
   * Test get address failure.
   *
   * @param delimiter Delimiters
   */
  @ParameterizedTest
  @ValueSource(strings = {"::", ","})
  /* default */ void testGetAddressFailure(final String delimiter)
   {
    final MACAddress address = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ address.stringValue(delimiter);
     }, MACAddressTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test if mac is a broadcast address.
   */
  @Test
  /* default */ void testIsBroadcastTrue()
   {
    final MACAddress address = MACAddress.of("ff:ff:ff:ff:ff:ff"); //$NON-NLS-1$
    assertTrue(address.isBroadcast(), "Is not a broadcast address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is not a broadcast address.
   *
   * @param mac MAC
   */
  @ParameterizedTest
  @ValueSource(strings = {"ff:ff:ff:ff:ff:fe", "ff:ff:ff:ff:fe:ff", "ff:ff:ff:fe:ff:ff", "ff:ff:fe:ff:ff:ff", "ff:fe:ff:ff:ff:ff", "fe:ff:ff:ff:ff:ff"})
  /* default */ void testIsBroadcastFalse(final String mac)
   {
    final MACAddress address = MACAddress.of(mac);
    assertFalse(address.isBroadcast(), "Is a broadcast address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is a group address.
   */
  @Test
  /* default */ void testIsGroupTrue()
   {
    final MACAddress address = MACAddress.of("01:00:00:00:00:00"); //$NON-NLS-1$
    assertTrue(address.isGroup(), "Is not a group address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is not a group address.
   */
  @Test
  /* default */ void testIsGroupFalse()
   {
    final MACAddress address = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertFalse(address.isGroup(), "Is a group address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is a local address.
   */
  @Test
  /* default */ void testIsLocalTrue()
   {
    final MACAddress address = MACAddress.of("02:00:00:00:00:00"); //$NON-NLS-1$
    assertTrue(address.isLocal(), "Is not a local address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is not a local address.
   */
  @Test
  /* default */ void testIsLocalFalse()
   {
    final MACAddress address = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertFalse(address.isLocal(), "Is a local address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is an ip v4 multicast address.
   */
  @Test
  /* default */ void testIsIPV4MulticastTrue()
   {
    final MACAddress address = MACAddress.of("01:00:5e:7f:00:00"); //$NON-NLS-1$
    assertTrue(address.isIPV4Multicast(), "Is not a ip v4 multicast address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is not an ip v4 multicast address.
   *
   * @param mac MAC
   */
  @ParameterizedTest
  @ValueSource(strings = {"01:00:5e:80:00:00", "01:00:00:00:00:00", "01:01:00:00:00:00", "00:00:00:00:00:00"})
  /* default */ void testIsIPV4MulticastFalse(final String mac)
   {
    final MACAddress address = MACAddress.of(mac);
    assertFalse(address.isIPV4Multicast(), "Is a ip v4 multicast address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is an ip v6 multicast address.
   */
  @Test
  /* default */ void testIsIPV6MulticastTrue()
   {
    final MACAddress address = MACAddress.of("33:33:00:00:00:00"); //$NON-NLS-1$
    assertTrue(address.isIPV6Multicast(), "Is not a ip v6 multicast address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is not an ip v6 multicast address.
   *
   * @param mac MAC
   */
  @ParameterizedTest
  @ValueSource(strings = {"33:00:00:00:00:00", "00:33:00:00:00:00"})
  /* default */ void testIsIPV6MulticastFalse(final String mac)
   {
    final MACAddress address = MACAddress.of(mac);
    assertFalse(address.isIPV6Multicast(), "Is a ip v6 multicast address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is a vrrp address.
   */
  @Test
  /* default */ void testIsVRRPTrue()
   {
    final MACAddress address = MACAddress.of("00:00:5e:00:01:00"); //$NON-NLS-1$
    assertTrue(address.isVRRP(), "Is not a vrrp address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is not a vrrp address.
   *
   * @param mac MAC
   */
  @ParameterizedTest
  @ValueSource(strings = {MACAddressTests.MAC_00_00_00_00_00_00, "00:00:5e:00:00:00", "00:00:5e:01:00:00", "00:01:00:00:00:00", "01:00:00:00:00:00"})
  /* default */ void testIsVRRPFalse(final String mac)
   {
    final MACAddress address = MACAddress.of(mac);
    assertFalse(address.isVRRP(), "Is a vrrp address"); //$NON-NLS-1$
   }


  /**
   * Test getOUI.
   */
  @Test
  /* default */ void testGetOUI()
   {
    final MACAddress address = MACAddress.of("00:07:e9:00:00:00"); //$NON-NLS-1$
    assertEquals("0007E9", address.getOUI(), "OUI is not as expected"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test sendlocalWakeOnLan.
   *
   * @throws IOException On IOExceptions
   */
  @Test
  /* default */ void testSendWakeOnLan() throws IOException
   {
    final MACAddress address = MACAddress.of("00:07:e9:00:00:00"); //$NON-NLS-1$
    address.sendLocalWakeOnLan(); // TODO assert
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final MACAddress address1 = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    final MACAddress address2 = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    final MACAddress address3 = MACAddress.of(MACAddressTests.MAC_ONE);
    final MACAddress address4 = MACAddress.of("00:00:00:00:00:02"); //$NON-NLS-1$
    final MACAddress address5 = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(address1.compareTo(address2) == -address2.compareTo(address1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(address1.compareTo(address3) == -address3.compareTo(address1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((address4.compareTo(address3) > 0) && (address3.compareTo(address1) > 0) && (address4.compareTo(address1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((address1.compareTo(address2) == 0) && (Math.abs(address1.compareTo(address5)) == Math.abs(address2.compareTo(address5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((address1.compareTo(address2) == 0) && address1.equals(address2), "equals") //$NON-NLS-1$
    );
   }

 }
