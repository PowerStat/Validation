/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.comparators.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.powerstat.ddd.comparators.ComparatorEMailByDomain;
import de.powerstat.ddd.values.EMail;


/**
 * ComparatorEMailByDomain tests.
 */
final class ComparatorEMailByDomainTests
 {
  /**
   * User1@example.com constant.
   */
  private static final String USER1_EXAMPLE_COM = "user1@example.com"; //$NON-NLS-1$

  /**
   * User2@example.com constant.
   */
  private static final String USER2_EXAMPLE_COM = "user2@example.com"; //$NON-NLS-1$

  /**
   * User1@powerstat.de
   */
  private static final String USER1_POWERSTAT_DE = "user1@powerstat.de"; //$NON-NLS-1$

  /**
   * Null pointer exception expected constant.
   */
  private static final String NULL_POINTER_EXCEPTION = "Null pointer exception expected"; //$NON-NLS-1$

  /**
   * Compare not smaller constant.
   */
  private static final String COMPARE_NOT_SMALLER = "Compare not smaller!"; //$NON-NLS-1$

  /**
   * Compare not greater constant.
   */
  private static final String COMPARE_NOT_GREATER = "Compare not greater!"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ ComparatorEMailByDomainTests()
   {
    super();
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testConstructor1()
   {
    final ComparatorEMailByDomain comp = new ComparatorEMailByDomain();
    assertNotNull(comp, "Constructor failed!"); //$NON-NLS-1$
   }


  /**
   * Test compare.
   */
  @Test
  /* default */ void testCompare1()
   {
    final ComparatorEMailByDomain comp = new ComparatorEMailByDomain();
    final EMail email = EMail.of(ComparatorEMailByDomainTests.USER1_EXAMPLE_COM);
    assertThrows(NullPointerException.class, () ->
     {
      /* final int result = */ comp.compare(null, email);
     }, ComparatorEMailByDomainTests.NULL_POINTER_EXCEPTION
    );
   }


  /**
   * Test compare.
   */
  @Test
  /* default */ void testCompare2()
   {
    final ComparatorEMailByDomain comp = new ComparatorEMailByDomain();
    final EMail email = EMail.of(ComparatorEMailByDomainTests.USER1_EXAMPLE_COM);
    assertThrows(NullPointerException.class, () ->
     {
      /* final int result = */ comp.compare(email, null);
     }, ComparatorEMailByDomainTests.NULL_POINTER_EXCEPTION
    );
   }


  /**
   * Test compare.
   */
  @Test
  /* default */ void testCompare3()
   {
    final ComparatorEMailByDomain comp = new ComparatorEMailByDomain();
    final EMail email = EMail.of(ComparatorEMailByDomainTests.USER1_EXAMPLE_COM);
    final int result = comp.compare(email, email);
    assertEquals(0, result, "Compare not equal!"); //$NON-NLS-1$
   }


  /**
   * Test compare.
   */
  @Test
  /* default */ void testCompare4()
   {
    final ComparatorEMailByDomain comp = new ComparatorEMailByDomain();
    final EMail email1 = EMail.of(ComparatorEMailByDomainTests.USER1_EXAMPLE_COM);
    final EMail email2 = EMail.of(ComparatorEMailByDomainTests.USER2_EXAMPLE_COM);
    final int result = comp.compare(email1, email2);
    assertTrue(result < 0, ComparatorEMailByDomainTests.COMPARE_NOT_SMALLER);
   }


  /**
   * Test compare.
   */
  @Test
  /* default */ void testCompare5()
   {
    final ComparatorEMailByDomain comp = new ComparatorEMailByDomain();
    final EMail email1 = EMail.of(ComparatorEMailByDomainTests.USER1_EXAMPLE_COM);
    final EMail email2 = EMail.of(ComparatorEMailByDomainTests.USER2_EXAMPLE_COM);
    final int result = comp.compare(email2, email1);
    assertTrue(result > 0, ComparatorEMailByDomainTests.COMPARE_NOT_GREATER);
   }


  /**
   * Test compare.
   */
  @Test
  /* default */ void testCompare6()
   {
    final ComparatorEMailByDomain comp = new ComparatorEMailByDomain();
    final EMail email1 = EMail.of(ComparatorEMailByDomainTests.USER1_EXAMPLE_COM);
    final EMail email2 = EMail.of(ComparatorEMailByDomainTests.USER1_POWERSTAT_DE);
    final int result = comp.compare(email1, email2);
    assertTrue(result < 0, ComparatorEMailByDomainTests.COMPARE_NOT_SMALLER);
   }


  /**
   * Test compare.
   */
  @Test
  /* default */ void testCompare7()
   {
    final ComparatorEMailByDomain comp = new ComparatorEMailByDomain();
    final EMail email1 = EMail.of(ComparatorEMailByDomainTests.USER1_EXAMPLE_COM);
    final EMail email2 = EMail.of(ComparatorEMailByDomainTests.USER1_POWERSTAT_DE);
    final int result = comp.compare(email2, email1);
    assertTrue(result > 0, ComparatorEMailByDomainTests.COMPARE_NOT_GREATER);
   }

 }
