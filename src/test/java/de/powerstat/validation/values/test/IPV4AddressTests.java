/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import nl.jqno.equalsverifier.EqualsVerifier;
import de.powerstat.validation.values.IPV4Address;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Tests for IP V4 address class.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
@SuppressWarnings({"PMD.AvoidUsingHardCodedIP"})
final class IPV4AddressTests
 {
  /**
   * Private ip address 192.168.1.1.
   */
  private static final String PRIVATE_IP_192_168_1_1 = "192.168.1.1"; //$NON-NLS-1$

  /**
   * Private ip address 192.168.1.2.
   */
  private static final String PRIVATE_IP_192_168_1_2 = "192.168.1.2"; //$NON-NLS-1$

  /**
   * Error message: address is not private.
   */
  private static final String ADDRESS_IS_NOT_PRIVATE = "Address is not private"; //$NON-NLS-1$

  /**
   * Error message: address is not special.
   */
  private static final String ADDRESS_IS_NOT_SPECIAL = "Address is not special"; //$NON-NLS-1$

  /**
   * Address is not public.
   */
  private static final String ADDRESS_IS_NOT_PUBLIC = "Address is not public"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Address not as expected constant.
   */
  private static final String ADDRESS_NOT_AS_EXPECTED = "Address not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ IPV4AddressTests()
   {
    super();
   }


  /**
   * Test constructor failure illegal argument.
   */
  @Test
  /* default */ void testConstructorFailure0()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPV4Address address = */ IPV4Address.of("256.0.0.0"); //$NON-NLS-1$
     }, IPV4AddressTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test constructor failure null pointer.
   */
  @Test
  /* default */ void testConstructorFailure1()
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
  /* default */ void testConstructorFailure2()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPV4Address address = */ IPV4Address.of("255.255.255.255."); //$NON-NLS-1$
     }, IPV4AddressTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test constructor failure illegal argument.
   */
  @Test
  /* default */ void testConstructorFailure3()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPV4Address address = */ IPV4Address.of("0.0.0."); //$NON-NLS-1$
     }, IPV4AddressTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test if ip v4 is private.
   *
   * @param ipv4 IP V4 address string
   */
  @ParameterizedTest
  @ValueSource(strings = {IPV4AddressTests.PRIVATE_IP_192_168_1_1, "10.0.0.1", "172.16.0.1", "172.31.0.1", "169.254.0.1"})
  /* default */ void testIsPrivate(final String ipv4)
   {
    final IPV4Address address = IPV4Address.of(ipv4);
    assertTrue(address.isPrivate(), IPV4AddressTests.ADDRESS_IS_NOT_PRIVATE);
   }


  /**
   * Test if ip v4 is not private.
   *
   * @param ipv4 IP V4 address string
   */
  @ParameterizedTest
  @ValueSource(strings = {"172.15.0.0", "172.32.0.0", "192.167.0.0", "169.253.0.0"})
  /* default */ void testIsNotPrivate(final String ipv4)
   {
    final IPV4Address address = IPV4Address.of(ipv4);
    assertFalse(address.isPrivate(), "Address is private"); //$NON-NLS-1$
   }


  /**
   * Test if ip v4 is special.
   *
   * @param ipv4 IP V4 address
   */
  @ParameterizedTest
  @ValueSource(strings = {"127.0.0.1", "0.0.0.1", "192.0.0.1", "192.0.2.1", "192.88.99.1", "198.18.0.1", "198.51.100.1", "203.0.113.1", "224.0.0.1", "240.0.0.1", "255.255.255.255", "100.64.0.1", "198.19.0.1", "100.127.0.1", "239.0.0.1"})
  /* default */ void testIsSpecial(final String ipv4)
   {
    final IPV4Address address = IPV4Address.of(ipv4);
    assertTrue(address.isSpecial(), IPV4AddressTests.ADDRESS_IS_NOT_SPECIAL);
   }


  /**
   * Test if ip v4 is not special.
   *
   * @param ipv4 IP V4 address
   */
  @ParameterizedTest
  @ValueSource(strings = {"223.0.0.0", "198.17.0.0", "198.20.0.0", "100.63.0.0", "100.128.0.0", "192.0.1.0", "192.88.98.0", "198.51.99.0", "203.0.112.0", "203.1.113.0"})
  /* default */ void testIsNotSpecial(final String ipv4)
   {
    final IPV4Address address = IPV4Address.of(ipv4);
    assertFalse(address.isSpecial(), "Address is special"); //$NON-NLS-1$
   }


  /**
   * Test if ip v4 is public.
   */
  @Test
  /* default */ void testIsPublic0()
   {
    final IPV4Address address = IPV4Address.of("8.8.8.8"); //$NON-NLS-1$
    assertTrue(address.isPublic(), IPV4AddressTests.ADDRESS_IS_NOT_PUBLIC);
   }


  /**
   * Test if ip v4 is not public.
   *
   * @param adr IP V4 address
   */
  @ParameterizedTest
  @ValueSource(strings = {"192.168.0.1", "127.0.0.0"})
  /* default */ void testIsNotPublic0(final String adr)
   {
    final IPV4Address address = IPV4Address.of(adr);
    assertFalse(address.isPublic(), IPV4AddressTests.ADDRESS_IS_NOT_PUBLIC);
   }


  /**
   * Test get address.
   */
  @Test
  /* default */ void testStringValue()
   {
    final IPV4Address address = IPV4Address.of(IPV4AddressTests.PRIVATE_IP_192_168_1_1);
    assertEquals(IPV4AddressTests.PRIVATE_IP_192_168_1_1, address.stringValue(), IPV4AddressTests.ADDRESS_NOT_AS_EXPECTED);
   }


  /**
   * Equalsverifier.
   */
  @Test
  /* default */ void testEqualsContract()
   {
    EqualsVerifier.forClass(IPV4Address.class).withNonnullFields("address").withIgnoredFields("parts").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final IPV4Address address = IPV4Address.of(IPV4AddressTests.PRIVATE_IP_192_168_1_1);
    assertEquals("IPV4Address[address=192.168.1.1]", address.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final IPV4Address address1 = IPV4Address.of(IPV4AddressTests.PRIVATE_IP_192_168_1_1);
    final IPV4Address address2 = IPV4Address.of(IPV4AddressTests.PRIVATE_IP_192_168_1_1);
    final IPV4Address address3 = IPV4Address.of(IPV4AddressTests.PRIVATE_IP_192_168_1_2);
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
