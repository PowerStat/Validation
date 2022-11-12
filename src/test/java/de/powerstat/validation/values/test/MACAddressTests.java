/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.validation.values.MACAddress;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * MAC address tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class MACAddressTests
 {
  /**
   * MAC address 00:00:00:00:00:00.
   */
  private static final String MAC_00_00_00_00_00_00 = "00:00:00:00:00:00";

  /**
   * Address not as expected.
   */
  private static final String ADDRESS_NOT_AS_EXPECTED = "Address not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public MACAddressTests()
   {
    super();
   }


  /**
   * Test constructor failure null pointer.
   */
  @Test
  public void constructorFailureNull()
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
  public void constructorFailure1(final String mac)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final MACAddress address = */ MACAddress.of(mac);
     }, "Illegal argument exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test constructor successfully.
   *
   * @param mac MAC address
   */
  @ParameterizedTest
  @ValueSource(strings = {MACAddressTests.MAC_00_00_00_00_00_00, "00-00-00-00-00-00", "000000000000"})
  public void constructorSuccess(final String mac)
   {
    final MACAddress address = MACAddress.of(mac);
    assertNotNull(address, MACAddressTests.ADDRESS_NOT_AS_EXPECTED);
   }


  /**
   * Test get address.
   */
  @Test
  public void getAddress1()
   {
    final MACAddress address = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertEquals(MACAddressTests.MAC_00_00_00_00_00_00, address.getAddress(":"), MACAddressTests.ADDRESS_NOT_AS_EXPECTED); //$NON-NLS-1$
   }


  /**
   * Test get address.
   */
  @Test
  public void getAddress2()
   {
    final MACAddress address = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertEquals("00-00-00-00-00-00", address.getAddress("-"), MACAddressTests.ADDRESS_NOT_AS_EXPECTED); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test get address.
   */
  @Test
  public void getAddress3()
   {
    final MACAddress address = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertEquals("000000000000", address.getAddress(""), MACAddressTests.ADDRESS_NOT_AS_EXPECTED); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test get address failure.
   *
   * @param delimiter Delimiters
   */
  @ParameterizedTest
  @ValueSource(strings = {"::", ","})
  public void getAddressFailure(final String delimiter)
   {
    final MACAddress address = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertThrows(IllegalArgumentException.class, () ->
     {
      assertEquals("000000000000", address.getAddress(delimiter), MACAddressTests.ADDRESS_NOT_AS_EXPECTED); //$NON-NLS-1$
     }, "Illegal argument exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test if mac is a broadcast address.
   */
  @Test
  public void isBroadcastTrue()
   {
    final MACAddress address = MACAddress.of("ff:ff:ff:ff:ff:ff"); //$NON-NLS-1$
    assertTrue(address.isBroadcast(), "Is not a broadcast address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is not a broadcast address.
   */
  @Test
  public void isBroadcastFalse()
   {
    final MACAddress address = MACAddress.of("ff:ff:ff:ff:ff:fe"); //$NON-NLS-1$
    assertFalse(address.isBroadcast(), "Is a broadcast address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is a group address.
   */
  @Test
  public void isGroupTrue()
   {
    final MACAddress address = MACAddress.of("01:00:00:00:00:00"); //$NON-NLS-1$
    assertTrue(address.isGroup(), "Is not a group address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is not a group address.
   */
  @Test
  public void isGroupFalse()
   {
    final MACAddress address = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertFalse(address.isGroup(), "Is a group address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is a local address.
   */
  @Test
  public void isLocalTrue()
   {
    final MACAddress address = MACAddress.of("02:00:00:00:00:00"); //$NON-NLS-1$
    assertTrue(address.isLocal(), "Is not a local address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is not a local address.
   */
  @Test
  public void isLocalFalse()
   {
    final MACAddress address = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertFalse(address.isLocal(), "Is a local address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is an ip v4 multicast address.
   */
  @Test
  public void isIPV4MulticastTrue()
   {
    final MACAddress address = MACAddress.of("01:00:5e:7f:00:00"); //$NON-NLS-1$
    assertTrue(address.isIPV4Multicast(), "Is not a ip v4 multicast address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is not an ip v4 multicast address.
   */
  @Test
  public void isIPV4MulticastFalse()
   {
    final MACAddress address = MACAddress.of("01:00:5e:80:00:00"); //$NON-NLS-1$
    assertFalse(address.isIPV4Multicast(), "Is a ip v4 multicast address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is an ip v6 multicast address.
   */
  @Test
  public void isIPV6MulticastTrue()
   {
    final MACAddress address = MACAddress.of("33:33:00:00:00:00"); //$NON-NLS-1$
    assertTrue(address.isIPV6Multicast(), "Is not a ip v6 multicast address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is not an ip v6 multicast address.
   */
  @Test
  public void isIPV6MulticastFalse()
   {
    final MACAddress address = MACAddress.of("33:00:00:00:00:00"); //$NON-NLS-1$
    assertFalse(address.isIPV6Multicast(), "Is a ip v6 multicast address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is a vrrp address.
   */
  @Test
  public void isVRRPTrue()
   {
    final MACAddress address = MACAddress.of("00:00:5e:00:01:00"); //$NON-NLS-1$
    assertTrue(address.isVRRP(), "Is not a vrrp address"); //$NON-NLS-1$
   }


  /**
   * Test if mac is not a vrrp address.
   */
  @Test
  public void isVRRPFalse()
   {
    final MACAddress address = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertFalse(address.isVRRP(), "Is a vrrp address"); //$NON-NLS-1$
   }


  /**
   * Test getOUI.
   */
  @Test
  public void getOUI()
   {
    final MACAddress address = MACAddress.of("00:07:e9:00:00:00"); //$NON-NLS-1$
    assertEquals("0007E9", address.getOUI(), "OUI is not as expected"); //$NON-NLS-1$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final MACAddress address1 = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    final MACAddress address2 = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    final MACAddress address3 = MACAddress.of("00:00:00:00:00:01"); //$NON-NLS-1$
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(address1.hashCode(), address2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(address1.hashCode(), address3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final MACAddress address1 = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    final MACAddress address2 = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    final MACAddress address3 = MACAddress.of("00:00:00:00:00:01"); //$NON-NLS-1$
    final MACAddress address4 = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(address1.equals(address1), "address11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(address1.equals(address2), "address12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(address2.equals(address1), "address21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(address2.equals(address4), "address24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(address1.equals(address4), "address14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(address1.equals(address3), "address13 are equal"), //$NON-NLS-1$
      () -> assertFalse(address3.equals(address1), "address31 are equal"), //$NON-NLS-1$
      () -> assertFalse(address1.equals(null), "address10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final MACAddress address = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    assertEquals("MACAddress[address=00:00:00:00:00:00]", address.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final MACAddress address1 = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    final MACAddress address2 = MACAddress.of(MACAddressTests.MAC_00_00_00_00_00_00);
    final MACAddress address3 = MACAddress.of("00:00:00:00:00:01"); //$NON-NLS-1$
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
