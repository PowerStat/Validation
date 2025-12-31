/*
 * Copyright (C) 2024-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.science.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.ddd.values.science.Percent;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Tests for Percent value class.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class PercentTests
 {
  /**
   * 50.
   */
  private static final String PERCENT_50 = "50";

  /**
   * Percent should be 50.
   */
  private static final String PERCENT_SHOULD_BE_50 = "Percent should be 50";


  /**
   * Default constructor.
   */
  /* default */ PercentTests()
   {
    super();
   }


  /**
   * Is percent.
   *
   * @param percent Percent
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 100})
  /* default */ void testIsPercent(final int percent)
   {
    final Percent result = Percent.of(percent);
    assertEquals(percent, result.percent(), "Percent should be " + percent);
   }


  /**
   * Is not a percent.
   *
   * @param percent Percent
   */
  @ParameterizedTest
  @ValueSource(ints = {101, -1})
  /* default */ void testIsPercentFalse(final int percent)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Percent percent = */ Percent.of(percent);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(50, Percent.of("50").percent(), "Percent should be 50");
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Percent percent = Percent.of(50);
    assertEquals(PERCENT_50, percent.stringValue(), PERCENT_SHOULD_BE_50);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Percent percent1 = Percent.of(50);
    final Percent percent2 = Percent.of(50);
    final Percent percent3 = Percent.of(51);
    final Percent percent4 = Percent.of(52);
    final Percent percent5 = Percent.of(50);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(percent1.compareTo(percent2) == -percent2.compareTo(percent1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(percent1.compareTo(percent3) == -percent3.compareTo(percent1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((percent4.compareTo(percent3) > 0) && (percent3.compareTo(percent1) > 0) && (percent4.compareTo(percent1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((percent1.compareTo(percent2) == 0) && (Math.abs(percent1.compareTo(percent5)) == Math.abs(percent2.compareTo(percent5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((percent1.compareTo(percent2) == 0) && percent1.equals(percent2), "equals") //$NON-NLS-1$
    );
   }

 }
