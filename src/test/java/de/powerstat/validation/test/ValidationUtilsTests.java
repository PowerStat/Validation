/*
 * Copyright (C) 2019 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.validation.ValidationUtils;


/**
 * Validation utility tests.
 */
public final class ValidationUtilsTests
 {
  /**
   * Logger.
   */
  // private static final Logger LOGGER = LogManager.getLogger(ValidationUtilsTests.class);

  /**
   * Hostname not as expected constant.
   */
  private static final String HOSTNAME_NOT_AS_EXPECTED = "Hostname not as expected!"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public ValidationUtilsTests()
   {
    super();
   }


  /**
   * Test checkHostname with valid hostnames.
   *
   * @param hostname Hostname
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(strings = {"www.powerstat.de", "a.de", "www.powerstat012345678901234567890123456789012345678901234567890123.de", "abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.ACCOUNTANT", "192.168.0.1", "fe:80::"})
  public void checkHostnameOk(final String hostname)
   {
    final String cleanHostname = ValidationUtils.checkHostname(hostname);
    assertEquals(hostname, cleanHostname, HOSTNAME_NOT_AS_EXPECTED);
   }


  /**
   * Test checkHostname with hostname to short or long, part to long.
   *
   * @param hostname Hostname
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(strings = {"p", "www..de", "www.powerstat0123456789012345678901234567890123456789012345678901234.de", "www.powerstat1234123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234.de"})
  public void checkHostnameLength(final String hostname)
   {
    assertThrows(StringIndexOutOfBoundsException.class, () ->
     {
      /* final String cleanHostname = */ ValidationUtils.checkHostname(hostname);
     }
    );
   }


  /**
   * Test checkHostname with illegal parameters.
   *
   * @param hostname Hostname
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(strings = {"www.power~stat.de", "www.powerstat.unknown", "ACCOUNTANT", "www.-powerstat.de", "www.powerstat-.de"})
  public void checkHostnameIllegalParameters(final String hostname)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final String cleanHostname = */ ValidationUtils.checkHostname(hostname);
     }
    );
   }


  /**
   * Test checkPort with valid ports.
   *
   * @param port Port
   * @deprecated  Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(ints = {1023, 0, 65535})
  public void checkPortOk(final int port)
   {
    final int resultPort = ValidationUtils.checkPort(port);
    assertEquals(port, resultPort, "Port not as expected!"); //$NON-NLS-1$
   }


  /**
   * Test checkPort with out of range port numbers.
   *
   * @param port Port
   * @deprecated  Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(ints = {-1, 65536})
  public void checkPortOutOfRange(final int port)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final int resultPort = */ ValidationUtils.checkPort(port);
     }
    );
   }


  /**
   * Test sanitizeUrlPath with valid url.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void sanitizeUrlPathO()
   {
    final String url = "/ValidationUtils"; //$NON-NLS-1$
    final String resultUrl = ValidationUtils.sanitizeUrlPath(url);
    assertEquals(url, resultUrl, "Url path not as expected!"); //$NON-NLS-1$
   }


  /**
   * Test sanitizeUrlPath with valid url.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void sanitizeUrlPathEmpty()
   {
    final String url = ""; //$NON-NLS-1$
    final String resultUrl = ValidationUtils.sanitizeUrlPath(url);
    assertEquals("/", resultUrl, "Url path not as expected!"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test sanitizeUrlPath with invalid url.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void sanitizeUrlPathInvalid()
   {
    final String resultUrl = ValidationUtils.sanitizeUrlPath("ValidationUtils"); //$NON-NLS-1$
    assertEquals("/ValidationUtils", resultUrl, "Url path not as expected!"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Is IP V4 address with null.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void isIPV4Null()
   {
    assertThrows(NullPointerException.class, () ->
     {
      ValidationUtils.isIPV4(null);
     }
    );
   }


  /**
   * Check valid IP V4 address.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void checkIPV4()
   {
    final String address = "192.168.0.1"; //$NON-NLS-1$
    final String validAddress = ValidationUtils.checkIPV4(address);
    assertEquals(address, validAddress, "IP V4 address not as expected!"); //$NON-NLS-1$
   }


  /**
   * Check valid IP V4 address.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void checkNoneIPV4()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final String validAddress = */ ValidationUtils.checkIPV4("192.168.256.1"); //$NON-NLS-1$
     }
    );
   }


  /**
   * Is IP V4 a private address.
   *
   * @param address IP V4 address
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(strings = {"192.168.0.1", "10.0.0.1", "169.254.0.1", "172.16.0.1", "172.31.0.1"})
  public void isIPV4private(final String address)
   {
    assertTrue(ValidationUtils.isIPV4private(address), "Should be a private IP V4 address"); //$NON-NLS-1$
   }


  /**
   * Is ip v4 address not private.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void isIPV4NonePrivate()
   {
    assertFalse(ValidationUtils.isIPV4private("8.8.8.8"), "Should not be a private IP V4 address"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Is IP V4 a private address.
   *
   * @param address IP V4 address
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(strings = {"0.0.0.0", "127.0.0.1", "192.0.0.1", "192.0.2.1", "192.88.99.1", "198.51.100.1", "203.0.113.1", "100.64.0.1", "100.127.0.1", "198.18.0.1", "198.19.0.1", "224.0.0.1", "239.0.0.1", "240.0.0.1", "255.0.0.1"})
  public void isIPV4special(final String address)
   {
    assertTrue(ValidationUtils.isIPV4special(address), "Should be an special IP V4 address!"); //$NON-NLS-1$
   }


  /**
   * Is IP V4 public address.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void isIPV4public()
   {
    assertTrue(ValidationUtils.isIPV4public("8.8.8.8"), "Should be an IP V4 public address!"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Is IP V4 prefix length.
   *
   * @param mask Prefix mask length 0-32
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(ints = {0, 32})
  public void isIPV4prefixLength(final int mask)
   {
    assertTrue(ValidationUtils.isIPV4prefixLength(mask), "Is not a mask between 0-32!"); //$NON-NLS-1$
   }


  /**
   * Check IP V4 prefix length.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void checkIPV4prefixLength()
   {
    final int mask = 24;
    final int checkedPort = ValidationUtils.checkIPV4prefixLength(mask);
    assertEquals(mask, checkedPort, "Mask is not equal!"); //$NON-NLS-1$
   }


  /**
   * Check IP V4 prefix length.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void checkIPV4prefixLengthException()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final int checkedPort = */ ValidationUtils.checkIPV4prefixLength(33);
     }
    );
   }


  /**
   * Is IP V6 prefix length.
   *
   * @param mask Prefix mask length 0-128
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(ints = {0, 128})
  public void isIPV6prefixLength(final int mask)
   {
    assertTrue(ValidationUtils.isIPV6prefixLength(mask), "Is not a mask between 0-128!"); //$NON-NLS-1$
   }


  /**
   * Check IP V6 prefix length.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void checkIPV6prefixLength()
   {
    final int mask = 24;
    final int checkedPort = ValidationUtils.checkIPV6prefixLength(mask);
    assertEquals(mask, checkedPort, "Mask is not equal!"); //$NON-NLS-1$
   }


  /**
   * Check IP V6 prefix length.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void checkIPV6prefixLengthException()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final int checkedPort = */ ValidationUtils.checkIPV6prefixLength(129);
     }
    );
   }


  /**
   * Check valid IP V6 addresses.
   *
   * @param address IP V6 address
   * @param expandedAddress Expanded IP V6 address
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @CsvSource({"'fe:80::', '00fe:0080:0000:0000:0000:0000:0000:0000'", "'fe:80::192.168.0.1', '00fe:0080:0000:0000:0000:0000:c0a8:0001'"})
  public void checkIPV6(final String address, final String expandedAddress)
   {
    final String checkedAddress = ValidationUtils.checkIPV6(address);
    assertEquals(expandedAddress, checkedAddress, "Different IP V6 address!"); //$NON-NLS-1$
   }


  /**
   * Check valid IP V6 addresses.
   *
   * @param address IP V6 address
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(strings = {"fe:80::11::"})
  public void checkIPV6Failure(final String address)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final String checkedAddress = */ ValidationUtils.checkIPV6(address);
     }
    );
   }


  /**
   * Is IP V6 address.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void isIPV6()
   {
    assertTrue(ValidationUtils.isIPV6("fe:80::"), "Should be an IP V6 address!"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Is IP V6 private address.
   *
   * @param address IP V6 private address
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(strings = {"fe:80:00:00:00:00:00:00", "fc::", "fd::"})
  public void isIPV6private(final String address)
   {
    assertTrue(ValidationUtils.isIPV6private(address), "Should be an IP V6 private address!"); //$NON-NLS-1$
   }


  /**
   * Is not an IP V6 private address.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void isIPV6NonePrivate()
   {
    assertFalse(ValidationUtils.isIPV6private("2000::"), "Should not be an IP V6 private address!"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Is IP V6 special address.
   *
   * @param address IP V6 special address
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(strings = {"0000:0000:0000:0000:0000:0000:0000:0000", "0000:0000:0000:0000:0000:0000:0000:0001", "00ff::"})
  public void isIPV6special(final String address)
   {
    assertTrue(ValidationUtils.isIPV6special(address), "Should be an IP V6 special address!"); //$NON-NLS-1$
   }


  /**
   * Is not an IP V6 special address.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void isIPV6NoneSpecial()
   {
    assertFalse(ValidationUtils.isIPV6special("2000::"), "Should not be an IP V6 special address!"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Is an IP V6 public address.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void isIPV6Public()
   {
    assertTrue(ValidationUtils.isIPV6public("2000::"), "Should be an IP V6 public address!"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Is not an IP V6 public address.
   *
   * @param address IP V6 none public address
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(strings = {"00ff::", "fd::"})
  public void isIPV6NonePublic(final String address)
   {
    assertFalse(ValidationUtils.isIPV6public(address), "Should not be an IP V6 special address!"); //$NON-NLS-1$
   }


  /**
   * Is hostname.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void isHostname()
   {
    assertTrue(ValidationUtils.isHostname("www.example.com"), "Should be a hostname!"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Is not a hostname.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void isHostnameFalse()
   {
    assertFalse(ValidationUtils.isHostname(".example.com"), "Should be a hostname!"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Is port.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void isPort()
   {
    assertTrue(ValidationUtils.isPort(49152), "Should be a port!"); //$NON-NLS-1$
   }


  /**
   * Is not a port.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void isPortFalse()
   {
    assertFalse(ValidationUtils.isPort(65536), "Should not be a port!"); //$NON-NLS-1$
   }


  /**
   * Is system port.
   *
   * @param port Port
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(ints = {0, 1023})
  public void isSystemPort(final int port)
   {
    assertTrue(ValidationUtils.isSystemPort(port), "Should be a system port!"); //$NON-NLS-1$
   }


  /**
   * Is not a system port.
   *
   * @param port Port
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(ints = {49152, 65536})
  public void isSystemPortFalse(final int port)
   {
    assertFalse(ValidationUtils.isSystemPort(port), "Should not be a system port!"); //$NON-NLS-1$
   }


  /**
   * Is registered port.
   *
   * @param port Port
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(ints = {1024, 49151})
  public void isRegisteredPort(final int port)
   {
    assertTrue(ValidationUtils.isRegisteredPort(port), "Should be a registered port!"); //$NON-NLS-1$
   }


  /**
   * Is not a registered port.
   *
   * @param port Port
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(ints = {1023, 65536})
  public void isRegisteredPortFalse(final int port)
   {
    assertFalse(ValidationUtils.isRegisteredPort(port), "Should not be a registered port!"); //$NON-NLS-1$
   }


  /**
   * Is dynamic port.
   *
   * @param port Port
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(ints = {49152, 65535})
  public void isDynamicPort(final int port)
   {
    assertTrue(ValidationUtils.isDynamicPort(port), "Should be a dynamic port!"); //$NON-NLS-1$
   }


  /**
   * Is not a dynamic port.
   *
   * @param port Port
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @ParameterizedTest
  @ValueSource(ints = {1023, 65536})
  public void isDynamicPortFalse(final int port)
   {
    assertFalse(ValidationUtils.isDynamicPort(port), "Should not be a dynamic port!"); //$NON-NLS-1$
   }


  /**
   * Exists hostname in DNS.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void existHostname()
   {
    assertTrue(ValidationUtils.existHostname("www.powerstat.de"), "Should be an existing hostname"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Exists hostname in DNS.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void existHostnameFalse()
   {
    assertFalse(ValidationUtils.existHostname("nonexistant.example.com"), "Should not be an existing hostname"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Split hostname port.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void splitHostnamePortOk1()
   {
    final List<String> hostnamePort = ValidationUtils.splitHostnamePort("www.powerstat.de:80"); //$NON-NLS-1$
    assertAll(
      () -> assertEquals("www.powerstat.de", hostnamePort.get(0), "Wrong hostname!"), //$NON-NLS-1$ //$NON-NLS-2$
      () -> assertEquals("80", hostnamePort.get(1), "Wrong port!")  //$NON-NLS-1$ //$NON-NLS-2$
    );
   }


  /**
   * Split hostname port.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void splitHostnamePortOk2()
   {
    final List<String> hostnamePort = ValidationUtils.splitHostnamePort("[fe:80::]:80"); //$NON-NLS-1$
    assertAll(
      () -> assertEquals("fe:80::", hostnamePort.get(0), "Wrong hostname!"), //$NON-NLS-1$ //$NON-NLS-2$
      () -> assertEquals("80", hostnamePort.get(1), "Wrong port!")  //$NON-NLS-1$ //$NON-NLS-2$
    );
   }


  /**
   * Split hostname port with error.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated
  @Test
  public void splitHostnamePortWrong()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final List<String> hostnamePort = */ ValidationUtils.splitHostnamePort("www.powerstat.de"); //$NON-NLS-1$
     }
    );
   }

 }
