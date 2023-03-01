/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
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

import de.powerstat.validation.values.Hostname;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Hostname tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class HostnameTests
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
   * IPV6 0000:0000:0000:0000:0000:0000:0000:0000.
   */
  private static final String IPV6ZERO = "::"; //$NON-NLS-1$

  /**
   * IPV6 FD.
   */
  private static final String FD00 = "fd00:0000:0000:0000:0000:0000:0000:0000"; //$NON-NLS-1$

  /**
   * www.powerstat.de constant.
   */
  private static final String WWW_POWERSTAT_DE = "www.powerstat.de"; //$NON-NLS-1$

  /**
   * nonexistant.example.com.
   */
  private static final String NONEXISTANT_EXAMPLE_COM = "nonexistant.example.com"; //$NON-NLS-1$

  /**
   * Hostname not as expected constant.
   */
  private static final String HOSTNAME_NOT_AS_EXPECTED = "Hostname not as expected"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$


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
  @ValueSource(strings = {HostnameTests.WWW_POWERSTAT_DE, "a.de", "www.powerstat012345678901234567890123456789012345678901234567890123.de", "abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdef.com", "192.168.0.1", "00fe:0080:0000:0000:0000:0000:0000:0000"})
  public void hostnameOk0(final String hostname)
   {
    final Hostname cleanHostname = Hostname.of(hostname);
    assertEquals(hostname, cleanHostname.hostname(), HostnameTests.HOSTNAME_NOT_AS_EXPECTED);
   }


  /**
   * Test Hostname with valid hostname.
   */
  @Test
  public void hostnameOk1()
   {
    final Hostname cleanHostname = Hostname.of(IPV6ZERO); //$NON-NLS-1$
    assertEquals(IPV6ZERO, cleanHostname.hostname(), HostnameTests.HOSTNAME_NOT_AS_EXPECTED); //$NON-NLS-1$
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
     }, HostnameTests.ILLEGAL_ARGUMENT
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
     }, HostnameTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get reverse hostname.
   */
  @Test
  public void getReverseHostname1()
   {
    final Hostname hostname = Hostname.of(HostnameTests.PRIVATE_IP_192_168_1_1);
    assertEquals("1.1.168.192", hostname.getReverseHostname(), HostnameTests.HOSTNAME_NOT_AS_EXPECTED); //$NON-NLS-1$
   }


  /**
   * Test get reverse hostname.
   */
  @Test
  public void getReverseHostname2()
   {
    final Hostname hostname = Hostname.of(HostnameTests.FD00);
    assertEquals(HostnameTests.FD00, hostname.getReverseHostname(), HostnameTests.HOSTNAME_NOT_AS_EXPECTED);
   }


  /**
   * Test get reverse hostname.
   */
  @Test
  public void getReverseHostname3()
   {
    final Hostname hostname = Hostname.of("www.example.com"); //$NON-NLS-1$
    assertEquals("com.example.www", hostname.getReverseHostname(), HostnameTests.HOSTNAME_NOT_AS_EXPECTED); //$NON-NLS-1$
   }


  /**
   * Exists hostname in DNS.
   */
  @Test
  public void exist()
   {
    assertTrue(Hostname.of(HostnameTests.WWW_POWERSTAT_DE).exist(), "Should be an existing hostname"); //$NON-NLS-1$
   }


  /**
   * Exists hostname in DNS.
   */
  @Test
  public void existFalse()
   {
    assertFalse(Hostname.of(HostnameTests.NONEXISTANT_EXAMPLE_COM).exist(), "Should not be an existing hostname"); //$NON-NLS-1$
   }


  /**
   * Reachable hostname.
   */
  @Test
  public void isReachable()
   {
    assertTrue(Hostname.of(HostnameTests.WWW_POWERSTAT_DE).isReachable(1000), "Should be a reachable hostname"); //$NON-NLS-1$
   }


  /**
   * Non reachable hostname.
   */
  @Test
  public void isReachableFalse()
   {
    assertFalse(Hostname.of(HostnameTests.NONEXISTANT_EXAMPLE_COM).isReachable(1000), "Should not be a reachable hostname"); //$NON-NLS-1$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Hostname hostname1 = Hostname.of(HostnameTests.PRIVATE_IP_192_168_1_1);
    final Hostname hostname2 = Hostname.of(HostnameTests.PRIVATE_IP_192_168_1_1);
    final Hostname hostname3 = Hostname.of(HostnameTests.PRIVATE_IP_192_168_1_2);
    final Hostname hostname4 = Hostname.of("192.168.1.3"); //$NON-NLS-1$
    final Hostname hostname5 = Hostname.of(HostnameTests.PRIVATE_IP_192_168_1_1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(hostname1.compareTo(hostname2) == -hostname2.compareTo(hostname1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(hostname1.compareTo(hostname3) == -hostname3.compareTo(hostname1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((hostname4.compareTo(hostname3) > 0) && (hostname3.compareTo(hostname1) > 0) && (hostname4.compareTo(hostname1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((hostname1.compareTo(hostname2) == 0) && (Math.abs(hostname1.compareTo(hostname5)) == Math.abs(hostname2.compareTo(hostname5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((hostname1.compareTo(hostname2) == 0) && hostname1.equals(hostname2), "equals") //$NON-NLS-1$
    );
   }

 }
