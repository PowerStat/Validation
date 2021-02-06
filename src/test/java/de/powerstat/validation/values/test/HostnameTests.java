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

import de.powerstat.validation.values.Hostname;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Hostname tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT"})
public class HostnameTests
 {
  /**
   * Private ip address 192.168.1.1.
   */
  private static final String PRIVATE_IP_192_168_1_1 = "192.168.1.1"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public HostnameTests()
   {
    super();
   }


  /**
   * Test Hostname with valid hostnames.
   *
   * @param hostname Hostname
   */
  @ParameterizedTest
  @ValueSource(strings = {"www.powerstat.de", "a.de", "www.powerstat012345678901234567890123456789012345678901234567890123.de", "abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdef.com", "192.168.0.1", "00fe:0080:0000:0000:0000:0000:0000:0000"})
  public void hostnameOk0(final String hostname)
   {
    final Hostname cleanHostname = Hostname.of(hostname);
    assertEquals(hostname, cleanHostname.getHostname(), "Hostname not as expected"); //$NON-NLS-1$
   }


  /**
   * Test Hostname with valid hostname.
   */
  @Test
  public void hostnameOk1()
   {
    final Hostname cleanHostname = Hostname.of("::"); //$NON-NLS-1$
    assertEquals("0000:0000:0000:0000:0000:0000:0000:0000", cleanHostname.getHostname(), "Hostname not as expected"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test Hostname with hostname to short or long, part to long.
   *
   * @param hostname Hostname
   */
  @ParameterizedTest
  @ValueSource(strings = {"p", "www..de", "www.powerstat0123456789012345678901234567890123456789012345678901234.de", "www.powerstat1234123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234.de"})
  public void hostnameLength(final String hostname)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Hostname cleanHostname = */ Hostname.of(hostname);
     }
    );
   }


  /**
   * Test Hostname with illegal parameters.
   *
   * @param hostname Hostname
   */
  @ParameterizedTest
  @ValueSource(strings = {"www.power~stat.de", "www.powerstat.unknown", "ACCOUNTANT", "www.-powerstat.de", "www.powerstat-.de"})
  public void hostnameIllegalParameters(final String hostname)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Hostname cleanHostname = */ Hostname.of(hostname);
     }
    );
   }


  /**
   * Test get hostname.
   */
  @Test
  public void getHostname()
   {
    final Hostname hostname = Hostname.of(PRIVATE_IP_192_168_1_1);
    assertEquals(PRIVATE_IP_192_168_1_1, hostname.getHostname(), "Hostname not as expected"); //$NON-NLS-1$
   }


  /**
   * Exists hostname in DNS.
   */
  @Test
  public void exist()
   {
    assertTrue(Hostname.of("www.powerstat.de").exist(), "Should be an existing hostname"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Exists hostname in DNS.
   */
  @Test
  public void existFalse()
   {
    assertFalse(Hostname.of("nonexistant.example.com").exist(), "Should not be an existing hostname"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Hostname hostname1 = Hostname.of(PRIVATE_IP_192_168_1_1);
    final Hostname hostname2 = Hostname.of(PRIVATE_IP_192_168_1_1);
    final Hostname hostname3 = Hostname.of("192.168.1.2"); //$NON-NLS-1$
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(hostname1.hashCode(), hostname2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(hostname1.hashCode(), hostname3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Hostname hostname1 = Hostname.of(PRIVATE_IP_192_168_1_1);
    final Hostname hostname2 = Hostname.of(PRIVATE_IP_192_168_1_1);
    final Hostname hostname3 = Hostname.of("192.168.1.2"); //$NON-NLS-1$
    final Hostname hostname4 = Hostname.of(PRIVATE_IP_192_168_1_1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(hostname1.equals(hostname1), "hostname11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(hostname1.equals(hostname2), "hostname12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(hostname2.equals(hostname1), "hostname21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(hostname2.equals(hostname4), "hostname24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(hostname1.equals(hostname4), "hostname14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(hostname1.equals(hostname3), "hostname13 are equal"), //$NON-NLS-1$
      () -> assertFalse(hostname3.equals(hostname1), "hostname31 are equal"), //$NON-NLS-1$
      () -> assertFalse(hostname1.equals(null), "hostname10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Hostname hostname = Hostname.of(PRIVATE_IP_192_168_1_1);
    assertEquals("Hostname[hostname=192.168.1.1]", hostname.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Hostname hostname1 = Hostname.of(PRIVATE_IP_192_168_1_1);
    final Hostname hostname2 = Hostname.of(PRIVATE_IP_192_168_1_1);
    final Hostname hostname3 = Hostname.of("192.168.1.2"); //$NON-NLS-1$
    final Hostname hostname4 = Hostname.of("192.168.1.3"); //$NON-NLS-1$
    final Hostname hostname5 = Hostname.of(PRIVATE_IP_192_168_1_1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(hostname1.compareTo(hostname2) == -hostname2.compareTo(hostname1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(hostname1.compareTo(hostname3) == -hostname3.compareTo(hostname1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((hostname4.compareTo(hostname3) > 0) && (hostname3.compareTo(hostname1) > 0) && (hostname4.compareTo(hostname1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((hostname1.compareTo(hostname2) == 0) && (Math.abs(hostname1.compareTo(hostname5)) == Math.abs(hostname2.compareTo(hostname5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((hostname1.compareTo(hostname2) == 0) && hostname1.equals(hostname2), "equals") //$NON-NLS-1$
    );
   }

 }
