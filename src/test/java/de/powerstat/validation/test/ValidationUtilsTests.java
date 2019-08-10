/*
 * Copyright (C) 2019 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
  private static final Logger LOGGER = LogManager.getLogger(ValidationUtilsTests.class);

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
   */
  @ParameterizedTest
  @ValueSource(strings = {"www.powerstat.de", "a.bc", "www.powerstat012345678901234567890123456789012345678901234567890123.de", "abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghijklmnopqrstuvwxyz.abcdefghij"})
  public void checkHostnameOk(final String hostname)
   {
    final String cleanHostname = ValidationUtils.checkHostname(hostname);
    assertEquals(hostname, cleanHostname, HOSTNAME_NOT_AS_EXPECTED);
   }


  /**
   * Test checkHostname with hostname to short or long, part to long.
   *
   * @param hostname Hostname
   */
  @ParameterizedTest
  @ValueSource(strings = {"p.d", "www..de", "www.powerstat0123456789012345678901234567890123456789012345678901234.de", "www.powerstat1234123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234.de"})
  public void checkHostnameLength(final String hostname)
   {
    assertThrows(StringIndexOutOfBoundsException.class, () ->
     {
      /* final String cleanHostname = */ ValidationUtils.checkHostname(hostname);
     }
    );
   }


  /**
   * Test checkHostname with illegal character in hostname.
   */
  @Test
  public void checkHostnameIllegalCharacter()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final String cleanHostname = */ ValidationUtils.checkHostname("www.power_stat.de"); //$NON-NLS-1$
     }
    );
   }

  /**
   * Test checkPort with valid ports.
   *
   * @param port Port
   */
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
   */
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
   */
  @Test
  public void sanitizeUrlPathOk()
   {
    final String url = "/ValidationUtils"; //$NON-NLS-1$
    final String resultUrl = ValidationUtils.sanitizeUrlPath(url);
    assertEquals(url, resultUrl, "Url path not as expected!"); //$NON-NLS-1$
   }


  /**
   * Test sanitizeUrlPath with invalid url.
   */
  @Test
  public void sanitizeUrlPathInvalid()
   {
    final String resultUrl = ValidationUtils.sanitizeUrlPath("ValidationUtils"); //$NON-NLS-1$
    assertEquals("/ValidationUtils", resultUrl, "Url path not as expected!"); //$NON-NLS-1$ //$NON-NLS-2$
   }

 }
