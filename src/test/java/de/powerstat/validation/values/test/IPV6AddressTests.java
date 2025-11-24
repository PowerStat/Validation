/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
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
import de.powerstat.validation.values.IPV6Address;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * IP V6 tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
@SuppressWarnings({"PMD.AvoidUsingHardCodedIP"})
final class IPV6AddressTests
 {
  /**
   * IP V6 test address.
   */
  private static final String IPV6_FD00 = "fd00::"; //$NON-NLS-1$

  /**
   * IP V6 test address.
   */
  private static final String FD00_0000 = "fd00:0000:0000:0000:0000:0000:0000:0000"; //$NON-NLS-1$

  /**
   * IP V6 test address.
   */
  private static final String FD00_1 = "fd00::1"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT_EXCEPTION = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Address is not public constant.
   */
  private static final String ADDRESS_IS_NOT_PUBLIC = "Address is not public"; //$NON-NLS-1$

  /**
   * Address is not private constant.
   */
  private static final String ADDRESS_IS_NOT_PRIVATE = "Address is not private"; //$NON-NLS-1$

  /**
   * Address not as expected constant.
   */
  private static final String ADDRESS_NOT_AS_EXPECTED = "Address not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ IPV6AddressTests()
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
      /* final IPV6Address address = */ IPV6Address.of(":"); //$NON-NLS-1$
     }, IPV6AddressTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test constructor failure illegal argument.
   */
  @Test
  /* default */ void testConstructorFailure1()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPV6Address address = */ IPV6Address.of("fd00:0000:0000:0000:0000:0000:255.255.255.255:"); //$NON-NLS-1$
     }, IPV6AddressTests.ILLEGAL_ARGUMENT_EXCEPTION
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
      /* final IPV6Address address = */ IPV6Address.of("fg00:0000:0000:0000:0000:0000:0000:0000"); //$NON-NLS-1$
     }, IPV6AddressTests.ILLEGAL_ARGUMENT_EXCEPTION
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
      /* final IPV6Address address = */ IPV6Address.of("fd00::0001::"); //$NON-NLS-1$
     }, IPV6AddressTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  /* default */ void testConstructorSuccess0()
   {
    final IPV6Address address = IPV6Address.of("::"); //$NON-NLS-1$
    assertEquals("0000:0000:0000:0000:0000:0000:0000:0000", address.stringValue(), IPV6AddressTests.ADDRESS_NOT_AS_EXPECTED); //$NON-NLS-1$
   }


  /**
   * Test constructor success.
   */
  @Test
  /* default */ void testConstructorSuccess1()
   {
    final IPV6Address address = IPV6Address.of("fd00:0000:0000:0000:0000:0000:255.255.255.255"); //$NON-NLS-1$
    assertEquals("fd00:0000:0000:0000:0000:0000:ffff:ffff", address.stringValue(), IPV6AddressTests.ADDRESS_NOT_AS_EXPECTED); //$NON-NLS-1$
   }


  /**
   * Test if ip v6 is private.
   *
   * @param ipv6 IP V6 address string
   */
  @ParameterizedTest
  @ValueSource(strings = {"00fe:0080::", "00fc::", "00fd::"})
  /* default */ void testIsPrivate(final String ipv6)
   {
    final IPV6Address address = IPV6Address.of(ipv6);
    assertTrue(address.isPrivate(), IPV6AddressTests.ADDRESS_IS_NOT_PRIVATE);
   }


  /**
   * Test if ip v6 is private.
   */
  @Test
  /* default */ void testIsPrivate3()
   {
    final IPV6Address address = IPV6Address.of("00fe::"); //$NON-NLS-1$
    assertFalse(address.isPrivate(), IPV6AddressTests.ADDRESS_IS_NOT_PRIVATE);
   }


  /**
   * Test if ip v6 is special.
   */
  @Test
  /* default */ void testIsSpecial0()
   {
    final IPV6Address address = IPV6Address.of("00fd::"); //$NON-NLS-1$
    assertFalse(address.isSpecial(), "Address is special"); //$NON-NLS-1$
   }


  /**
   * Test if ip v6 is special.
   *
   * @param ipv6 IP V6 address string
   */
  @ParameterizedTest
  @ValueSource(strings = {"::", "::1", "ff::"})
  /* default */ void testIsSpecial1(final String ipv6)
   {
    final IPV6Address address = IPV6Address.of(ipv6);
    assertTrue(address.isSpecial(), "Address is not special"); //$NON-NLS-1$
   }


  /**
   * Test if ip v6 is public.
   */
  @Test
  /* default */ void testIsPublic0()
   {
    final IPV6Address address = IPV6Address.of("00c0::"); //$NON-NLS-1$
    assertTrue(address.isPublic(), IPV6AddressTests.ADDRESS_IS_NOT_PUBLIC);
   }


  /**
   * Test if ip v6 is not public.
   *
   * @param ipv6 IP V6 address string
   */
  @ParameterizedTest
  @ValueSource(strings = {"00fc::", "ff::"})
  /* default */ void testIsNotPublic0(final String ipv6)
   {
    final IPV6Address address = IPV6Address.of(ipv6);
    assertFalse(address.isPublic(), IPV6AddressTests.ADDRESS_IS_NOT_PUBLIC);
   }


  /**
   * Test get address.
   */
  @Test
  /* default */ void testStringValue()
   {
    final IPV6Address address = IPV6Address.of(IPV6AddressTests.IPV6_FD00);
    assertEquals(IPV6AddressTests.FD00_0000, address.stringValue(), IPV6AddressTests.ADDRESS_NOT_AS_EXPECTED);
   }


  /**
   * Equalsverifier.
   */
  @Test
  /* default */ void testEqualsContract()
   {
    EqualsVerifier.forClass(IPV6Address.class).withNonnullFields("address").withIgnoredFields("blocks").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final IPV6Address address = IPV6Address.of(IPV6AddressTests.IPV6_FD00);
    assertEquals("IPV6Address[address=fd00:0000:0000:0000:0000:0000:0000:0000]", address.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final IPV6Address address1 = IPV6Address.of(IPV6AddressTests.IPV6_FD00);
    final IPV6Address address2 = IPV6Address.of(IPV6AddressTests.IPV6_FD00);
    final IPV6Address address3 = IPV6Address.of(IPV6AddressTests.FD00_1);
    final IPV6Address address4 = IPV6Address.of("fd00::2"); //$NON-NLS-1$
    final IPV6Address address5 = IPV6Address.of(IPV6AddressTests.IPV6_FD00);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(address1.compareTo(address2) == -address2.compareTo(address1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(address1.compareTo(address3) == -address3.compareTo(address1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((address4.compareTo(address3) > 0) && (address3.compareTo(address1) > 0) && (address4.compareTo(address1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((address1.compareTo(address2) == 0) && (Math.abs(address1.compareTo(address5)) == Math.abs(address2.compareTo(address5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((address1.compareTo(address2) == 0) && address1.equals(address2), "equals") //$NON-NLS-1$
    );
   }

 }
