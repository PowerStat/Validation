/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.ddd.values.TopLevelDomain;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Top level domain tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class TopLevelDomainTests
 {
  /**
   * FR - france.
   */
  private static final String FR = "FR"; //$NON-NLS-1$

  /**
   * DE germany.
   */
  private static final String DE = "DE"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * TopLevelDomain not as expected constant.
   */
  private static final String TLD_NOT_AS_EXPECTED = "TopLevelDomain not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ TopLevelDomainTests()
   {
    super();
   }


  /**
   * Test TopLevelDomain with valid top level domains.
   *
   * @param topLevelDomain TopLevelDomain
   */
  @ParameterizedTest
  @ValueSource(strings = {"de", "XN--VERMGENSBERATUNG-PWB"}) // , "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJK"
  /* default */ void testTopLevelDomainOk0(final String topLevelDomain)
   {
    final TopLevelDomain cleanTopLevelDomain = TopLevelDomain.of(topLevelDomain);
    assertEquals(topLevelDomain, cleanTopLevelDomain.topLevelDomain(), TopLevelDomainTests.TLD_NOT_AS_EXPECTED);
   }


  /**
   * Test TopLevelDomain with top level domain to short or long.
   *
   * @param topLevelDomain TopLevelDomain
   */
  @ParameterizedTest
  @ValueSource(strings = {"A", "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKL"})
  /* default */ void testTopLevelDomainLength(final String topLevelDomain)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final TopLevelDomain cleanTopLevelDomain = */ TopLevelDomain.of(topLevelDomain);
     }, TopLevelDomainTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test TopLevelDomain with illegal parameters.
   *
   * @param topLevelDomain TopLevelDomain
   */
  @ParameterizedTest
  @ValueSource(strings = {".DE", "-DE", "DE-", "D~E", "ZZ"})
  /* default */ void testTopLevelDomainIllegalParameters(final String topLevelDomain)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final TopLevelDomain cleanTopLevelDomain = */ TopLevelDomain.of(topLevelDomain);
     }, TopLevelDomainTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get topLevelDomain.
   */
  @Test
  /* default */ void testStringValue()
   {
    final TopLevelDomain topLevelDomain = TopLevelDomain.of(TopLevelDomainTests.DE);
    assertEquals(TopLevelDomainTests.DE, topLevelDomain.stringValue(), TopLevelDomainTests.TLD_NOT_AS_EXPECTED);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final TopLevelDomain topLevelDomain1 = TopLevelDomain.of(TopLevelDomainTests.DE);
    final TopLevelDomain topLevelDomain2 = TopLevelDomain.of(TopLevelDomainTests.DE);
    final TopLevelDomain topLevelDomain3 = TopLevelDomain.of(TopLevelDomainTests.FR);
    final TopLevelDomain topLevelDomain4 = TopLevelDomain.of("GB"); //$NON-NLS-1$
    final TopLevelDomain topLevelDomain5 = TopLevelDomain.of(TopLevelDomainTests.DE);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(topLevelDomain1.compareTo(topLevelDomain2) == -topLevelDomain2.compareTo(topLevelDomain1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(topLevelDomain1.compareTo(topLevelDomain3) == -topLevelDomain3.compareTo(topLevelDomain1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((topLevelDomain4.compareTo(topLevelDomain3) > 0) && (topLevelDomain3.compareTo(topLevelDomain1) > 0) && (topLevelDomain4.compareTo(topLevelDomain1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((topLevelDomain1.compareTo(topLevelDomain2) == 0) && (Math.abs(topLevelDomain1.compareTo(topLevelDomain5)) == Math.abs(topLevelDomain2.compareTo(topLevelDomain5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((topLevelDomain1.compareTo(topLevelDomain2) == 0) && topLevelDomain1.equals(topLevelDomain2), "equals") //$NON-NLS-1$
    );
   }

 }
