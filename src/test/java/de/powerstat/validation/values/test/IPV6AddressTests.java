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

import de.powerstat.validation.values.IPV6Address;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * IP V6 tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class IPV6AddressTests
 {
  /**
   * IP V6 test address.
   */
  private static final String IPV6_FD00 = "fd00::"; //$NON-NLS-1$

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
  public IPV6AddressTests()
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
      /* final IPV6Address address = */ IPV6Address.of(":"); //$NON-NLS-1$
     }, IPV6AddressTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test constructor failure illegal argument.
   */
  @Test
  public void constructorFailure1()
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
  public void constructorFailure2()
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
  public void constructorFailure3()
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
  public void constructorSuccess0()
   {
    final IPV6Address address = IPV6Address.of("::"); //$NON-NLS-1$
    assertEquals("0000:0000:0000:0000:0000:0000:0000:0000", address.stringValue(), IPV6AddressTests.ADDRESS_NOT_AS_EXPECTED); //$NON-NLS-1$
   }


  /**
   * Test constructor success.
   */
  @Test
  public void constructorSuccess1()
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
  public void isPrivate(final String ipv6)
   {
    final IPV6Address address = IPV6Address.of(ipv6);
    assertTrue(address.isPrivate(), IPV6AddressTests.ADDRESS_IS_NOT_PRIVATE);
   }


  /**
   * Test if ip v6 is private.
   */
  @Test
  public void isPrivate3()
   {
    final IPV6Address address = IPV6Address.of("00fe::"); //$NON-NLS-1$
    assertFalse(address.isPrivate(), IPV6AddressTests.ADDRESS_IS_NOT_PRIVATE);
   }


  /**
   * Test if ip v6 is special.
   */
  @Test
  public void isSpecial0()
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
  public void isSpecial1(final String ipv6)
   {
    final IPV6Address address = IPV6Address.of(ipv6);
    assertTrue(address.isSpecial(), "Address is not special"); //$NON-NLS-1$
   }


  /**
   * Test if ip v6 is public.
   */
  @Test
  public void isPublic0()
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
  public void isNotPublic0(final String ipv6)
   {
    final IPV6Address address = IPV6Address.of(ipv6);
    assertFalse(address.isPublic(), IPV6AddressTests.ADDRESS_IS_NOT_PUBLIC);
   }


  /**
   * Test get address.
   */
  @Test
  public void getAddress()
   {
    final IPV6Address address = IPV6Address.of(IPV6AddressTests.IPV6_FD00);
    assertEquals("fd00:0000:0000:0000:0000:0000:0000:0000", address.stringValue(), IPV6AddressTests.ADDRESS_NOT_AS_EXPECTED); //$NON-NLS-1$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final IPV6Address address1 = IPV6Address.of(IPV6AddressTests.IPV6_FD00);
    final IPV6Address address2 = IPV6Address.of(IPV6AddressTests.IPV6_FD00);
    final IPV6Address address3 = IPV6Address.of(IPV6AddressTests.FD00_1);
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
    final IPV6Address address1 = IPV6Address.of(IPV6AddressTests.IPV6_FD00);
    final IPV6Address address2 = IPV6Address.of(IPV6AddressTests.IPV6_FD00);
    final IPV6Address address3 = IPV6Address.of(IPV6AddressTests.FD00_1);
    final IPV6Address address4 = IPV6Address.of(IPV6AddressTests.IPV6_FD00);
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
    final IPV6Address address = IPV6Address.of(IPV6AddressTests.IPV6_FD00);
    assertEquals("IPV6Address[address=fd00:0000:0000:0000:0000:0000:0000:0000]", address.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
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
