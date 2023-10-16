/*
 * Copyright (C) 2022-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.containers.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.containers.NTuple16;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * NTuple16 tests.
 */
@SuppressFBWarnings({"CE_CLASS_ENVY", "RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR", "EC_NULL_ARG"})
final class NTuple16Tests
 {
  /**
   * Test equals constant.
   */
  private static final String TEST_EQUALS = "testEquals"; //$NON-NLS-1$

  /**
   * Test compare to constant.
   */
  private static final String TEST_COMPARE_TO = "testCompareTo"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE12_IS_EQUAL = "tuple12 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE13_IS_EQUAL = "tuple13 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE14_IS_EQUAL = "tuple14 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE15_IS_EQUAL = "tuple15 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE16_IS_EQUAL = "tuple16 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE17_IS_EQUAL = "tuple17 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE18_IS_EQUAL = "tuple18 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE19_IS_EQUAL = "tuple19 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE110_IS_EQUAL = "tuple110 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE111_IS_EQUAL = "tuple111 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE112_IS_EQUAL = "tuple112 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE113_IS_EQUAL = "tuple113 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE114_IS_EQUAL = "tuple114 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE115_IS_EQUAL = "tuple115 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE116_IS_EQUAL = "tuple116 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE21_IS_EQUAL = "tuple21 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE31_IS_EQUAL = "tuple31 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE41_IS_EQUAL = "tuple41 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE51_IS_EQUAL = "tuple51 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE61_IS_EQUAL = "tuple61 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE71_IS_EQUAL = "tuple71 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE81_IS_EQUAL = "tuple81 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE91_IS_EQUAL = "tuple91 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE101_IS_EQUAL = "tuple101 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE121_IS_EQUAL = "tuple121 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE131_IS_EQUAL = "tuple131 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE141_IS_EQUAL = "tuple141 is equal"; //$NON-NLS-1$

  /**
   * Tuple is equal constant.
   */
  private static final String TUPLE151_IS_EQUAL = "tuple151 is equal"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public NTuple16Tests()
   {
    super();
   }


  /**
   * Factory test.
   */
  @Test
  /* default */ void testOfInt()
   {
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = NTuple16.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(815), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    assertAll("testGetValue", //$NON-NLS-1$
      () -> assertEquals(1, tuple.t1Value().intValue(), "t1 not as expected"), //$NON-NLS-1$
      () -> assertEquals(4711, tuple.t2Value().intValue(), "t2 not as expected"), //$NON-NLS-1$
      () -> assertEquals(815, tuple.t3Value().intValue(), "t3 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t4Value().intValue(), "t4 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t5Value().intValue(), "t5 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t6Value().intValue(), "t6 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t7Value().intValue(), "t7 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t8Value().intValue(), "t8 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t9Value().intValue(), "t9 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t10Value().intValue(), "t10 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t11Value().intValue(), "t11 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t12Value().intValue(), "t12 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t13Value().intValue(), "t13 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t14Value().intValue(), "t14 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t15Value().intValue(), "t15 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t16Value().intValue(), "t16 not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test hash code.
   */
  @Test
  /* default */ void testHashCode()
   {
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple2 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple3 = NTuple16.of(Integer.valueOf(2), Integer.valueOf(815), Integer.valueOf(815), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(tuple1.hashCode(), tuple2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(tuple1.hashCode(), tuple3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testEquals()
   {
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple2 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple3 = NTuple16.of(Integer.valueOf(2), Integer.valueOf(815), Integer.valueOf(815), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple4 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    assertAll(NTuple16Tests.TEST_EQUALS,
      () -> assertTrue(tuple1.equals(tuple1), "tuple11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(tuple1.equals(tuple2), "tuple12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(tuple2.equals(tuple1), "tuple21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(tuple2.equals(tuple4), "tuple24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(tuple1.equals(tuple4), "tuple14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(tuple1.equals(tuple3), "tuple13 are equal"), //$NON-NLS-1$
      () -> assertFalse(tuple3.equals(tuple1), "tuple31 are equal"), //$NON-NLS-1$
      () -> assertFalse(tuple1.equals(null), "tuple10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testEquals2()
   {
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));

    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple2 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple3 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple4 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple5 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple6 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple7 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple9 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple10 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple11 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple12 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple13 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple14 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple15 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple16 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2));
    assertAll(NTuple16Tests.TEST_EQUALS,
      () -> assertFalse(tuple1.equals(tuple2), NTuple16Tests.TUPLE12_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple3), NTuple16Tests.TUPLE13_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple4), NTuple16Tests.TUPLE14_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple5), NTuple16Tests.TUPLE15_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple6), NTuple16Tests.TUPLE16_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple7), NTuple16Tests.TUPLE17_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple8), NTuple16Tests.TUPLE18_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple9), NTuple16Tests.TUPLE19_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple10), NTuple16Tests.TUPLE110_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple11), NTuple16Tests.TUPLE111_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple12), NTuple16Tests.TUPLE112_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple13), NTuple16Tests.TUPLE113_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple14), NTuple16Tests.TUPLE114_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple15), NTuple16Tests.TUPLE115_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple16), NTuple16Tests.TUPLE116_IS_EQUAL)
    );
   }


  /**
   * Test equals.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testEquals3()
   {
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));

    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple2 = NTuple16.of(Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple3 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple4 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple5 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple6 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple7 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple9 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple10 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple11 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple12 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple13 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple14 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple15 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple16 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    assertAll(NTuple16Tests.TEST_EQUALS,
      () -> assertFalse(tuple2.equals(tuple1), NTuple16Tests.TUPLE21_IS_EQUAL),
      () -> assertFalse(tuple3.equals(tuple1), NTuple16Tests.TUPLE31_IS_EQUAL),
      () -> assertFalse(tuple4.equals(tuple1), NTuple16Tests.TUPLE41_IS_EQUAL),
      () -> assertFalse(tuple5.equals(tuple1), NTuple16Tests.TUPLE51_IS_EQUAL),
      () -> assertFalse(tuple6.equals(tuple1), NTuple16Tests.TUPLE61_IS_EQUAL),
      () -> assertFalse(tuple7.equals(tuple1), NTuple16Tests.TUPLE71_IS_EQUAL),
      () -> assertFalse(tuple8.equals(tuple1), NTuple16Tests.TUPLE81_IS_EQUAL),
      () -> assertFalse(tuple9.equals(tuple1), NTuple16Tests.TUPLE91_IS_EQUAL),
      () -> assertFalse(tuple10.equals(tuple1), NTuple16Tests.TUPLE101_IS_EQUAL),
      () -> assertFalse(tuple11.equals(tuple1), NTuple16Tests.TUPLE111_IS_EQUAL),
      () -> assertFalse(tuple12.equals(tuple1), NTuple16Tests.TUPLE121_IS_EQUAL),
      () -> assertFalse(tuple13.equals(tuple1), NTuple16Tests.TUPLE131_IS_EQUAL),
      () -> assertFalse(tuple14.equals(tuple1), NTuple16Tests.TUPLE141_IS_EQUAL),
      () -> assertFalse(tuple15.equals(tuple1), NTuple16Tests.TUPLE151_IS_EQUAL),
      () -> assertTrue(tuple16.equals(tuple1), "tuple161 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testEquals4()
   {
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1a = NTuple16.of(Integer.valueOf(1), null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1b = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1c = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1d = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1e = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1f = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1g = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1h = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1i = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1j = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1k = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1l = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1m = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1n = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1));

    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple2 = NTuple16.of(Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple3 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple4 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple5 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple6 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple7 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple9 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple10 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple11 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple12 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple13 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple14 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple15 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1));
    assertAll(NTuple16Tests.TEST_EQUALS,
      () -> assertFalse(tuple2.equals(tuple1a), "tuple21 is not equal"), //$NON-NLS-1$
      () -> assertFalse(tuple3.equals(tuple1b), "tuple31 is not equal"), //$NON-NLS-1$
      () -> assertFalse(tuple4.equals(tuple1c), "tuple41 is not equal"), //$NON-NLS-1$
      () -> assertFalse(tuple5.equals(tuple1d), "tuple51 is not equal"), //$NON-NLS-1$
      () -> assertFalse(tuple6.equals(tuple1e), "tuple61 is not equal"), //$NON-NLS-1$
      () -> assertFalse(tuple7.equals(tuple1f), "tuple71 is not equal"), //$NON-NLS-1$
      () -> assertFalse(tuple8.equals(tuple1g), "tuple81 is not equal"), //$NON-NLS-1$
      () -> assertFalse(tuple9.equals(tuple1h), "tuple91 is not equal"), //$NON-NLS-1$
      () -> assertFalse(tuple10.equals(tuple1i), "tuple101 is not equal"), //$NON-NLS-1$
      () -> assertFalse(tuple11.equals(tuple1j), "tuple111 is not equal"), //$NON-NLS-1$
      () -> assertFalse(tuple12.equals(tuple1k), "tuple121 is not equal"), //$NON-NLS-1$
      () -> assertFalse(tuple13.equals(tuple1l), "tuple131 is not equal"), //$NON-NLS-1$
      () -> assertFalse(tuple14.equals(tuple1m), "tuple141 is not equal"), //$NON-NLS-1$
      () -> assertTrue(tuple15.equals(tuple1n), "tuple151 is not equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(815), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    assertEquals("NTuple16[object1=1, object2=4711, object3=815, object4=1, object5=1, object6=1, object7=1, object8=1, object9=1, object10=1, object11=1, object12=1, object13=1, object14=1, object15=1, object16=1]", tuple1.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple2 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple3 = NTuple16.of(Integer.valueOf(2), Integer.valueOf(815), Integer.valueOf(815), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple4 = NTuple16.of(Integer.valueOf(3), Integer.valueOf(20221127), Integer.valueOf(20221127), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple5 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    assertAll(NTuple16Tests.TEST_COMPARE_TO,
      () -> assertTrue(tuple1.compareTo(tuple2) == -tuple2.compareTo(tuple1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(tuple1.compareTo(tuple3) == -tuple3.compareTo(tuple1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((tuple4.compareTo(tuple3) > 0) && (tuple3.compareTo(tuple1) > 0) && (tuple4.compareTo(tuple1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((tuple1.compareTo(tuple2) == 0) && (Math.abs(tuple1.compareTo(tuple5)) == Math.abs(tuple2.compareTo(tuple5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((tuple1.compareTo(tuple2) == 0) && tuple1.equals(tuple2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo2()
   {
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));

    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple2 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple3 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple4 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple5 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple6 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple7 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple9 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple10 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple11 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple12 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple13 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple14 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple15 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple16 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2));
    assertAll(NTuple16Tests.TEST_COMPARE_TO,
      () -> assertTrue(tuple1.compareTo(tuple2) != 0, NTuple16Tests.TUPLE12_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple3) != 0, NTuple16Tests.TUPLE13_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple4) != 0, NTuple16Tests.TUPLE14_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple5) != 0, NTuple16Tests.TUPLE15_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple6) != 0, NTuple16Tests.TUPLE16_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple7) != 0, NTuple16Tests.TUPLE17_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple8) != 0, NTuple16Tests.TUPLE18_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple9) != 0, NTuple16Tests.TUPLE19_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple10) != 0, NTuple16Tests.TUPLE110_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple11) != 0, NTuple16Tests.TUPLE111_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple12) != 0, NTuple16Tests.TUPLE112_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple13) != 0, NTuple16Tests.TUPLE113_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple14) != 0, NTuple16Tests.TUPLE114_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple15) != 0, NTuple16Tests.TUPLE115_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple16) != 0, NTuple16Tests.TUPLE116_IS_EQUAL)
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo3()
   {
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));

    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple2 = NTuple16.of(Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple3 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple4 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple5 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple6 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple7 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple9 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple10 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple11 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple12 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple13 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple14 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple15 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1));
    assertAll(NTuple16Tests.TEST_COMPARE_TO,
      () -> assertTrue(tuple2.compareTo(tuple1) != 0, NTuple16Tests.TUPLE21_IS_EQUAL),
      () -> assertTrue(tuple3.compareTo(tuple1) != 0, NTuple16Tests.TUPLE31_IS_EQUAL),
      () -> assertTrue(tuple4.compareTo(tuple1) != 0, NTuple16Tests.TUPLE41_IS_EQUAL),
      () -> assertTrue(tuple5.compareTo(tuple1) != 0, NTuple16Tests.TUPLE51_IS_EQUAL),
      () -> assertTrue(tuple6.compareTo(tuple1) != 0, NTuple16Tests.TUPLE61_IS_EQUAL),
      () -> assertTrue(tuple7.compareTo(tuple1) != 0, NTuple16Tests.TUPLE71_IS_EQUAL),
      () -> assertTrue(tuple8.compareTo(tuple1) != 0, NTuple16Tests.TUPLE81_IS_EQUAL),
      () -> assertTrue(tuple9.compareTo(tuple1) != 0, NTuple16Tests.TUPLE91_IS_EQUAL),
      () -> assertTrue(tuple10.compareTo(tuple1) != 0, NTuple16Tests.TUPLE101_IS_EQUAL),
      () -> assertTrue(tuple11.compareTo(tuple1) != 0, NTuple16Tests.TUPLE111_IS_EQUAL),
      () -> assertTrue(tuple12.compareTo(tuple1) != 0, NTuple16Tests.TUPLE121_IS_EQUAL),
      () -> assertTrue(tuple13.compareTo(tuple1) != 0, NTuple16Tests.TUPLE131_IS_EQUAL),
      () -> assertTrue(tuple14.compareTo(tuple1) != 0, NTuple16Tests.TUPLE141_IS_EQUAL),
      () -> assertTrue(tuple15.compareTo(tuple1) != 0, NTuple16Tests.TUPLE151_IS_EQUAL)
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo4()
   {
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1a = NTuple16.of(Integer.valueOf(1), null, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1b = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1c = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1d = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1e = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1f = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1g = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1h = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1i = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1j = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1k = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1l = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1m = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1n = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1));

    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple2 = NTuple16.of(Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple3 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple4 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple5 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple6 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple7 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple9 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple10 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple11 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple12 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple13 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple14 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple15 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1));
    assertAll(NTuple16Tests.TEST_COMPARE_TO,
      () -> assertTrue(tuple2.compareTo(tuple1a) != 0, NTuple16Tests.TUPLE21_IS_EQUAL),
      () -> assertTrue(tuple3.compareTo(tuple1b) != 0, NTuple16Tests.TUPLE31_IS_EQUAL),
      () -> assertTrue(tuple4.compareTo(tuple1c) != 0, NTuple16Tests.TUPLE41_IS_EQUAL),
      () -> assertTrue(tuple5.compareTo(tuple1d) != 0, NTuple16Tests.TUPLE51_IS_EQUAL),
      () -> assertTrue(tuple6.compareTo(tuple1e) != 0, NTuple16Tests.TUPLE61_IS_EQUAL),
      () -> assertTrue(tuple7.compareTo(tuple1f) != 0, NTuple16Tests.TUPLE71_IS_EQUAL),
      () -> assertTrue(tuple8.compareTo(tuple1g) != 0, NTuple16Tests.TUPLE81_IS_EQUAL),
      () -> assertTrue(tuple9.compareTo(tuple1h) != 0, NTuple16Tests.TUPLE91_IS_EQUAL),
      () -> assertTrue(tuple10.compareTo(tuple1i) != 0, NTuple16Tests.TUPLE101_IS_EQUAL),
      () -> assertTrue(tuple11.compareTo(tuple1j) != 0, NTuple16Tests.TUPLE111_IS_EQUAL),
      () -> assertTrue(tuple12.compareTo(tuple1k) != 0, NTuple16Tests.TUPLE121_IS_EQUAL),
      () -> assertTrue(tuple13.compareTo(tuple1l) != 0, NTuple16Tests.TUPLE131_IS_EQUAL),
      () -> assertTrue(tuple14.compareTo(tuple1m) != 0, NTuple16Tests.TUPLE141_IS_EQUAL),
      () -> assertFalse(tuple15.compareTo(tuple1n) != 0, NTuple16Tests.TUPLE151_IS_EQUAL)
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo5()
   {
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1a = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1b = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1c = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1d = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1e = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1f = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1g = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1h = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1i = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1j = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1k = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1l = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1m = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1n = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));

    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple2 = NTuple16.of(Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple3 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple4 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple5 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple6 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple7 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple9 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple10 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple11 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple12 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple13 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple14 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1), Integer.valueOf(1));
    final NTuple16<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple15 = NTuple16.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), null, Integer.valueOf(1));
    assertAll(NTuple16Tests.TEST_COMPARE_TO,
      () -> assertTrue(tuple1a.compareTo(tuple2) != 0, NTuple16Tests.TUPLE21_IS_EQUAL),
      () -> assertTrue(tuple1b.compareTo(tuple3) != 0, NTuple16Tests.TUPLE31_IS_EQUAL),
      () -> assertTrue(tuple1c.compareTo(tuple4) != 0, NTuple16Tests.TUPLE41_IS_EQUAL),
      () -> assertTrue(tuple1d.compareTo(tuple5) != 0, NTuple16Tests.TUPLE51_IS_EQUAL),
      () -> assertTrue(tuple1e.compareTo(tuple6) != 0, NTuple16Tests.TUPLE61_IS_EQUAL),
      () -> assertTrue(tuple1f.compareTo(tuple7) != 0, NTuple16Tests.TUPLE71_IS_EQUAL),
      () -> assertTrue(tuple1g.compareTo(tuple8) != 0, NTuple16Tests.TUPLE81_IS_EQUAL),
      () -> assertTrue(tuple1h.compareTo(tuple9) != 0, NTuple16Tests.TUPLE91_IS_EQUAL),
      () -> assertTrue(tuple1i.compareTo(tuple10) != 0, NTuple16Tests.TUPLE101_IS_EQUAL),
      () -> assertTrue(tuple1j.compareTo(tuple11) != 0, NTuple16Tests.TUPLE111_IS_EQUAL),
      () -> assertTrue(tuple1k.compareTo(tuple12) != 0, NTuple16Tests.TUPLE121_IS_EQUAL),
      () -> assertTrue(tuple1l.compareTo(tuple13) != 0, NTuple16Tests.TUPLE131_IS_EQUAL),
      () -> assertTrue(tuple1m.compareTo(tuple14) != 0, NTuple16Tests.TUPLE141_IS_EQUAL),
      () -> assertTrue(tuple1n.compareTo(tuple15) != 0, NTuple16Tests.TUPLE151_IS_EQUAL)
    );
   }

 }
