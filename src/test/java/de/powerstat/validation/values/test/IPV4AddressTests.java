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

import de.powerstat.validation.values.IPV4Address;


/**
 * Tests for IP V4 address class.
 */
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
     }
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
     }
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
     }
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
     }
    );
   }


  /**
   * Test if ip v4 is private.
   */
  @Test
  public void isPrivate0()
   {
    final IPV4Address address = IPV4Address.of(PRIVATE_IP_192_168_1_1);
    assertTrue(address.isPrivate(), ADDRESS_IS_NOT_PRIVATE);
   }


  /**
   * Test if ip v4 is private.
   */
  @Test
  public void isPrivate1()
   {
    final IPV4Address address = IPV4Address.of("10.0.0.1"); //$NON-NLS-1$
    assertTrue(address.isPrivate(), ADDRESS_IS_NOT_PRIVATE);
   }


  /**
   * Test if ip v4 is private.
   */
  @Test
  public void isPrivate2()
   {
    final IPV4Address address = IPV4Address.of("172.16.0.1"); //$NON-NLS-1$
    assertTrue(address.isPrivate(), ADDRESS_IS_NOT_PRIVATE);
   }


  /**
   * Test if ip v4 is private.
   */
  @Test
  public void isPrivate3()
   {
    final IPV4Address address = IPV4Address.of("172.31.0.1"); //$NON-NLS-1$
    assertTrue(address.isPrivate(), ADDRESS_IS_NOT_PRIVATE);
   }


  /**
   * Test if ip v4 is private.
   */
  @Test
  public void isPrivate4()
   {
    final IPV4Address address = IPV4Address.of("169.254.0.1"); //$NON-NLS-1$
    assertTrue(address.isPrivate(), ADDRESS_IS_NOT_PRIVATE);
   }


  /**
   * Test if ip v4 is special.
   */
  @Test
  public void isSpecial0()
   {
    final IPV4Address address = IPV4Address.of("127.0.0.1"); //$NON-NLS-1$
    assertTrue(address.isSpecial(), ADDRESS_IS_NOT_SPECIAL);
   }


  /**
   * Test if ip v4 is special.
   */
  @Test
  public void isSpecial1()
   {
    final IPV4Address address = IPV4Address.of("0.0.0.1"); //$NON-NLS-1$
    assertTrue(address.isSpecial(), ADDRESS_IS_NOT_SPECIAL);
   }


  /**
   * Test if ip v4 is special.
   */
  @Test
  public void isSpecial2()
   {
    final IPV4Address address = IPV4Address.of("192.0.0.1"); //$NON-NLS-1$
    assertTrue(address.isSpecial(), ADDRESS_IS_NOT_SPECIAL);
   }


  /**
   * Test if ip v4 is special.
   */
  @Test
  public void isSpecial3()
   {
    final IPV4Address address = IPV4Address.of("192.0.2.1"); //$NON-NLS-1$
    assertTrue(address.isSpecial(), ADDRESS_IS_NOT_SPECIAL);
   }


  /**
   * Test if ip v4 is special.
   */
  @Test
  public void isSpecial4()
   {
    final IPV4Address address = IPV4Address.of("192.88.99.1"); //$NON-NLS-1$
    assertTrue(address.isSpecial(), ADDRESS_IS_NOT_SPECIAL);
   }


  /**
   * Test if ip v4 is special.
   */
  @Test
  public void isSpecial5()
   {
    final IPV4Address address = IPV4Address.of("198.18.0.1"); //$NON-NLS-1$
    assertTrue(address.isSpecial(), ADDRESS_IS_NOT_SPECIAL);
   }


  /**
   * Test if ip v4 is special.
   */
  @Test
  public void isSpecial6()
   {
    final IPV4Address address = IPV4Address.of("198.51.100.1"); //$NON-NLS-1$
    assertTrue(address.isSpecial(), ADDRESS_IS_NOT_SPECIAL);
   }


  /**
   * Test if ip v4 is special.
   */
  @Test
  public void isSpecial7()
   {
    final IPV4Address address = IPV4Address.of("203.0.113.1"); //$NON-NLS-1$
    assertTrue(address.isSpecial(), ADDRESS_IS_NOT_SPECIAL);
   }


  /**
   * Test if ip v4 is special.
   */
  @Test
  public void isSpecial8()
   {
    final IPV4Address address = IPV4Address.of("224.0.0.1"); //$NON-NLS-1$
    assertTrue(address.isSpecial(), ADDRESS_IS_NOT_SPECIAL);
   }


  /**
   * Test if ip v4 is special.
   */
  @Test
  public void isSpecial9()
   {
    final IPV4Address address = IPV4Address.of("240.0.0.1"); //$NON-NLS-1$
    assertTrue(address.isSpecial(), ADDRESS_IS_NOT_SPECIAL);
   }


  /**
   * Test if ip v4 is special.
   */
  @Test
  public void isSpecial10()
   {
    final IPV4Address address = IPV4Address.of("255.255.255.255"); //$NON-NLS-1$
    assertTrue(address.isSpecial(), ADDRESS_IS_NOT_SPECIAL);
   }


  /**
   * Test if ip v4 is special.
   */
  @Test
  public void isSpecial11()
   {
    final IPV4Address address = IPV4Address.of("100.64.0.1"); //$NON-NLS-1$
    assertTrue(address.isSpecial(), ADDRESS_IS_NOT_SPECIAL);
   }


  /**
   * Test if ip v4 is special.
   */
  @Test
  public void isSpecial12()
   {
    final IPV4Address address = IPV4Address.of("198.19.0.1"); //$NON-NLS-1$
    assertTrue(address.isSpecial(), ADDRESS_IS_NOT_SPECIAL);
   }


  /**
   * Test if ip v4 is special.
   */
  @Test
  public void isSpecial13()
   {
    final IPV4Address address = IPV4Address.of("100.127.0.1"); //$NON-NLS-1$
    assertTrue(address.isSpecial(), ADDRESS_IS_NOT_SPECIAL);
   }


  /**
   * Test if ip v4 is special.
   */
  @Test
  public void isSpecial14()
   {
    final IPV4Address address = IPV4Address.of("239.0.0.1"); //$NON-NLS-1$
    assertTrue(address.isSpecial(), ADDRESS_IS_NOT_SPECIAL);
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
    final IPV4Address address = new IPV4Address(PRIVATE_IP_192_168_1_1);
    assertEquals(PRIVATE_IP_192_168_1_1, address.getAddress(), "Address not as expected"); //$NON-NLS-1$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final IPV4Address address1 = new IPV4Address(PRIVATE_IP_192_168_1_1);
    final IPV4Address address2 = new IPV4Address(PRIVATE_IP_192_168_1_1);
    final IPV4Address address3 = new IPV4Address("192.168.1.2"); //$NON-NLS-1$
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
    final IPV4Address address1 = new IPV4Address(PRIVATE_IP_192_168_1_1);
    final IPV4Address address2 = new IPV4Address(PRIVATE_IP_192_168_1_1);
    final IPV4Address address3 = new IPV4Address("192.168.1.2"); //$NON-NLS-1$
    final IPV4Address address4 = new IPV4Address(PRIVATE_IP_192_168_1_1);
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
    final IPV4Address address = new IPV4Address(PRIVATE_IP_192_168_1_1);
    assertEquals("IPV4Address[address=192.168.1.1]", address.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final IPV4Address address1 = new IPV4Address(PRIVATE_IP_192_168_1_1);
    final IPV4Address address2 = new IPV4Address(PRIVATE_IP_192_168_1_1);
    final IPV4Address address3 = new IPV4Address("192.168.1.2"); //$NON-NLS-1$
    final IPV4Address address4 = new IPV4Address("192.168.1.3"); //$NON-NLS-1$
    final IPV4Address address5 = new IPV4Address(PRIVATE_IP_192_168_1_1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(address1.compareTo(address2) == -address2.compareTo(address1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(address1.compareTo(address3) == -address3.compareTo(address1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((address4.compareTo(address3) > 0) && (address3.compareTo(address1) > 0) && (address4.compareTo(address1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((address1.compareTo(address2) == 0) && (Math.abs(address1.compareTo(address5)) == Math.abs(address2.compareTo(address5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((address1.compareTo(address2) == 0) && address1.equals(address2), "equals") //$NON-NLS-1$
    );
   }

 }
