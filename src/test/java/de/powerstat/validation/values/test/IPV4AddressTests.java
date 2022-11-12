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

import de.powerstat.validation.values.IPV4Address;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Tests for IP V4 address class.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class IPV4AddressTests
 {
  /**
   * Private ip address 192.168.1.1.
   */
  private static final String PRIVATE_IP_192_168_1_1 = "192.168.1.1"; //$NON-NLS-1$

  /**
   * Error message: address is not private.
   */
  private static final String ADDRESS_IS_NOT_PRIVATE = "Address is not private"; //$NON-NLS-1$

  /**
   * Error message: address is not special.
   */
  private static final String ADDRESS_IS_NOT_SPECIAL = "Address is not special"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public IPV4AddressTests()
   {
    super();
   }


  /**
   * Test constructor failure illegal argument.
   */
  @Test
  public void constructorFailure0()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPV4Address address = */ IPV4Address.of("256.0.0.0"); //$NON-NLS-1$
     }, "Illegal argument exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test constructor failure null pointer.
   */
  @Test
  public void constructorFailure1()
   {
    assertThrows(NullPointerException.class, () ->
     {
      /* final IPV4Address address = */ IPV4Address.of(null);
     }, "Null pointer exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test constructor failure illegal argument.
   */
  @Test
  public void constructorFailure2()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPV4Address address = */ IPV4Address.of("255.255.255.255."); //$NON-NLS-1$
     }, "Illegal argument exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test constructor failure illegal argument.
   */
  @Test
  public void constructorFailure3()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPV4Address address = */ IPV4Address.of("0.0.0."); //$NON-NLS-1$
     }, "Illegal argument exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test if ip v4 is private.
   *
   * @param ipv4 IP V4 address string
   */
  @ParameterizedTest
  @ValueSource(strings = {IPV4AddressTests.PRIVATE_IP_192_168_1_1, "10.0.0.1", "172.16.0.1", "172.31.0.1", "169.254.0.1"})
  public void isPrivate(final String ipv4)
   {
    final IPV4Address address = IPV4Address.of(ipv4);
    assertTrue(address.isPrivate(), IPV4AddressTests.ADDRESS_IS_NOT_PRIVATE);
   }


  /**
   * Test if ip v4 is special.
   *
   * @param ipv4 IP V4 address
   */
  @ParameterizedTest
  @ValueSource(strings = {"127.0.0.1", "0.0.0.1", "192.0.0.1", "192.0.2.1", "192.88.99.1", "198.18.0.1", "198.51.100.1", "203.0.113.1", "224.0.0.1", "240.0.0.1", "255.255.255.255", "100.64.0.1", "198.19.0.1", "100.127.0.1", "239.0.0.1"})
  public void isSpecial(final String ipv4)
   {
    final IPV4Address address = IPV4Address.of(ipv4);
    assertTrue(address.isSpecial(), IPV4AddressTests.ADDRESS_IS_NOT_SPECIAL);
   }


  /**
   * Test if ip v4 is public.
   */
  @Test
  public void isPublic0()
   {
    final IPV4Address address = IPV4Address.of("8.8.8.8"); //$NON-NLS-1$
    assertTrue(address.isPublic(), "Address is not public"); //$NON-NLS-1$
   }


  /**
   * Test if ip v4 is not public.
   */
  @Test
  public void isNotPublic0()
   {
    final IPV4Address address = IPV4Address.of("192.168.0.1"); //$NON-NLS-1$
    assertFalse(address.isPublic(), "Address is not public"); //$NON-NLS-1$
   }


  /**
   * Test get address.
   */
  @Test
  public void getAddress()
   {
    final IPV4Address address = IPV4Address.of(IPV4AddressTests.PRIVATE_IP_192_168_1_1);
    assertEquals(IPV4AddressTests.PRIVATE_IP_192_168_1_1, address.getAddress(), "Address not as expected"); //$NON-NLS-1$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final IPV4Address address1 = IPV4Address.of(IPV4AddressTests.PRIVATE_IP_192_168_1_1);
    final IPV4Address address2 = IPV4Address.of(IPV4AddressTests.PRIVATE_IP_192_168_1_1);
    final IPV4Address address3 = IPV4Address.of("192.168.1.2"); //$NON-NLS-1$
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
    final IPV4Address address1 = IPV4Address.of(IPV4AddressTests.PRIVATE_IP_192_168_1_1);
    final IPV4Address address2 = IPV4Address.of(IPV4AddressTests.PRIVATE_IP_192_168_1_1);
    final IPV4Address address3 = IPV4Address.of("192.168.1.2"); //$NON-NLS-1$
    final IPV4Address address4 = IPV4Address.of(IPV4AddressTests.PRIVATE_IP_192_168_1_1);
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
    final IPV4Address address = IPV4Address.of(IPV4AddressTests.PRIVATE_IP_192_168_1_1);
    assertEquals("IPV4Address[address=192.168.1.1]", address.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final IPV4Address address1 = IPV4Address.of(IPV4AddressTests.PRIVATE_IP_192_168_1_1);
    final IPV4Address address2 = IPV4Address.of(IPV4AddressTests.PRIVATE_IP_192_168_1_1);
    final IPV4Address address3 = IPV4Address.of("192.168.1.2"); //$NON-NLS-1$
    final IPV4Address address4 = IPV4Address.of("192.168.1.3"); //$NON-NLS-1$
    final IPV4Address address5 = IPV4Address.of(IPV4AddressTests.PRIVATE_IP_192_168_1_1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(address1.compareTo(address2) == -address2.compareTo(address1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(address1.compareTo(address3) == -address3.compareTo(address1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((address4.compareTo(address3) > 0) && (address3.compareTo(address1) > 0) && (address4.compareTo(address1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((address1.compareTo(address2) == 0) && (Math.abs(address1.compareTo(address5)) == Math.abs(address2.compareTo(address5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((address1.compareTo(address2) == 0) && address1.equals(address2), "equals") //$NON-NLS-1$
    );
   }

 }
