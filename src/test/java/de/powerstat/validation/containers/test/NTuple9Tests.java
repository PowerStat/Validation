/*
 * Copyright (C) 2022-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.containers.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.containers.NTuple9;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * NTuple9 tests.
 */
@SuppressFBWarnings({"CE_CLASS_ENVY", "RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR", "EC_NULL_ARG"})
final class NTuple9Tests
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
   * Default constructor.
   */
  public NTuple9Tests()
   {
    super();
   }


  /**
   * Factory test.
   */
  @Test
  /* default */ void testOfInt()
   {
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple = NTuple9.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(815), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    assertAll("testGetValue", //$NON-NLS-1$
      () -> assertEquals(1, tuple.t1Value().intValue(), "t1 not as expected"), //$NON-NLS-1$
      () -> assertEquals(4711, tuple.t2Value().intValue(), "t2 not as expected"), //$NON-NLS-1$
      () -> assertEquals(815, tuple.t3Value().intValue(), "t3 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t4Value().intValue(), "t4 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t5Value().intValue(), "t5 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t6Value().intValue(), "t6 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t7Value().intValue(), "t7 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t8Value().intValue(), "t8 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.t9Value().intValue(), "t9 not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test hash code.
   */
  @Test
  /* default */ void testHashCode()
   {
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple2 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple3 = NTuple9.of(Integer.valueOf(2), Integer.valueOf(815), Integer.valueOf(815), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
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
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple2 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple3 = NTuple9.of(Integer.valueOf(2), Integer.valueOf(815), Integer.valueOf(815), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple4 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    assertAll(NTuple9Tests.TEST_EQUALS,
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
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple2 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple3 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple4 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple5 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple6 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple7 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
    assertAll(NTuple9Tests.TEST_EQUALS,
      () -> assertFalse(tuple1.equals(tuple2), NTuple9Tests.TUPLE12_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple3), NTuple9Tests.TUPLE13_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple4), NTuple9Tests.TUPLE14_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple5), NTuple9Tests.TUPLE15_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple6), NTuple9Tests.TUPLE16_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple7), NTuple9Tests.TUPLE17_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple8), NTuple9Tests.TUPLE18_IS_EQUAL)
    );
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(815), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    assertEquals("NTuple9[object1=1, object2=4711, object3=815, object4=1, object5=1, object6=1, object7=1, object8=1, object9=1]", tuple1.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple2 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple3 = NTuple9.of(Integer.valueOf(2), Integer.valueOf(815), Integer.valueOf(815), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple4 = NTuple9.of(Integer.valueOf(3), Integer.valueOf(20221127), Integer.valueOf(20221127), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple5 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    assertAll(NTuple9Tests.TEST_COMPARE_TO,
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
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple1 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple2 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple3 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple4 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple5 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple6 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple7 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple9<Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer, Integer> tuple8 = NTuple9.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
    assertAll(NTuple9Tests.TEST_COMPARE_TO,
      () -> assertTrue(tuple1.compareTo(tuple2) != 0, NTuple9Tests.TUPLE12_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple3) != 0, NTuple9Tests.TUPLE13_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple4) != 0, NTuple9Tests.TUPLE14_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple5) != 0, NTuple9Tests.TUPLE15_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple6) != 0, NTuple9Tests.TUPLE16_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple7) != 0, NTuple9Tests.TUPLE17_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple8) != 0, NTuple9Tests.TUPLE18_IS_EQUAL)
    );
   }

 }
