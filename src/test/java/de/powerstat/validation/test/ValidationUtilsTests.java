/*
 * Copyright (C) 2019-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.ValidationUtils;


/**
 * Validation utility tests.
 */
final class ValidationUtilsTests
 {
  /* *
   * Logger.
   */
  // private static final Logger LOGGER = LogManager.getLogger(ValidationUtilsTests.class);

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT_EXCEPTION = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Url path not as expected constant.
   */
  private static final String URL_PATH_NOT_AS_EXPECTED = "Url path not as expected!"; //$NON-NLS-1$

  /**
   * Wrong hostname constant.
   */
  private static final String WRONG_HOSTNAME = "Wrong hostname!"; //$NON-NLS-1$

  /**
   * Wrong port constant.
   */
  private static final String WRONG_PORT = "Wrong port!"; //$NON-NLS-1$

  /**
   * ValidationUtils path constant.
   */
  private static final String VALIDATION_UTILS = "/ValidationUtils"; //$NON-NLS-1$

  /**
   * HTTP port.
   */
  private static final String HTTP = "80"; //$NON-NLS-1$

  /**
   * Hostname.
   */
  private static final String WWW_POWERSTAT_DE = "www.powerstat.de"; //$NON-NLS-1$

  /**
   * FE80.
   */
  @SuppressWarnings({"PMD.AvoidUsingHardCodedIP"})
  private static final String FE80 = "fe:80::"; //$NON-NLS-1$

  /**
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_2_0 = "2.0"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ ValidationUtilsTests()
   {
    super();
   }


  /**
   * Test sanitizeUrlPath with valid url.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated(since = ValidationUtilsTests.DEPRECATED_SINCE_2_0, forRemoval = true)
  @Test
  /* default */ void testSanitizeUrlPathO()
   {
    final String url = ValidationUtilsTests.VALIDATION_UTILS;
    final String resultUrl = ValidationUtils.sanitizeUrlPath(url);
    assertEquals(url, resultUrl, ValidationUtilsTests.URL_PATH_NOT_AS_EXPECTED);
   }


  /**
   * Test sanitizeUrlPath with valid url.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated(since = ValidationUtilsTests.DEPRECATED_SINCE_2_0, forRemoval = true)
  @Test
  /* default */ void testSanitizeUrlPathEmpty()
   {
    final String url = ""; //$NON-NLS-1$
    final String resultUrl = ValidationUtils.sanitizeUrlPath(url);
    assertEquals("/", resultUrl, ValidationUtilsTests.URL_PATH_NOT_AS_EXPECTED); //$NON-NLS-1$
   }


  /**
   * Test sanitizeUrlPath with invalid url.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated(since = ValidationUtilsTests.DEPRECATED_SINCE_2_0, forRemoval = true)
  @Test
  /* default */ void testSanitizeUrlPathInvalid()
   {
    final String resultUrl = ValidationUtils.sanitizeUrlPath("ValidationUtils"); //$NON-NLS-1$
    assertEquals(ValidationUtilsTests.VALIDATION_UTILS, resultUrl, ValidationUtilsTests.URL_PATH_NOT_AS_EXPECTED);
   }


  /**
   * Split hostname port.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated(since = ValidationUtilsTests.DEPRECATED_SINCE_2_0, forRemoval = true)
  @Test
  /* default */ void testSplitHostnamePortOk1()
   {
    final List<String> hostnamePort = ValidationUtils.splitHostnamePort("www.powerstat.de:80"); //$NON-NLS-1$
    assertAll(
      () -> assertEquals(ValidationUtilsTests.WWW_POWERSTAT_DE, hostnamePort.get(0), ValidationUtilsTests.WRONG_HOSTNAME),
      () -> assertEquals(ValidationUtilsTests.HTTP, hostnamePort.get(1), ValidationUtilsTests.WRONG_PORT)
    );
   }


  /**
   * Split hostname port.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated(since = ValidationUtilsTests.DEPRECATED_SINCE_2_0, forRemoval = true)
  @Test
  /* default */ void testSplitHostnamePortOk2()
   {
    final List<String> hostnamePort = ValidationUtils.splitHostnamePort("[fe:80::]:80"); //$NON-NLS-1$
    assertAll(
      () -> assertEquals(ValidationUtilsTests.FE80, hostnamePort.get(0), ValidationUtilsTests.WRONG_HOSTNAME),
      () -> assertEquals(ValidationUtilsTests.HTTP, hostnamePort.get(1), ValidationUtilsTests.WRONG_PORT)
    );
   }


  /**
   * Split hostname port with error.
   *
   * @deprecated Use de.powerstat.validation.values.test.* instead.
   */
  @Deprecated(since = ValidationUtilsTests.DEPRECATED_SINCE_2_0, forRemoval = true)
  @Test
  /* default */ void testSplitHostnamePortWrong()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final List<String> hostnamePort = */ ValidationUtils.splitHostnamePort(ValidationUtilsTests.WWW_POWERSTAT_DE);
     }, ValidationUtilsTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }

 }
