/*
 * Copyright (C) 2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.containers.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.containers.NTuple4;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * NTuple4 tests.
 */
@SuppressFBWarnings({"CE_CLASS_ENVY", "RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR", "EC_NULL_ARG"})
public class NTuple4Tests
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
   * tuple is equal constant.
   */
  private static final String TUPLE12_IS_EQUAL = "tuple12 is equal"; //$NON-NLS-1$

  /**
   * tuple is equal constant.
   */
  private static final String TUPLE13_IS_EQUAL = "tuple13 is equal"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public NTuple4Tests()
   {
    super();
   }


  /**
   * Factory test.
   */
  @Test
  public void ofIntInt()
   {
    final NTuple4<Integer, Integer, Integer, Integer> tuple = NTuple4.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(815), Integer.valueOf(4));
    assertAll("testGetValue", //$NON-NLS-1$
      () -> assertEquals(1, tuple.t1Value().intValue(), "t1 not as expected"), //$NON-NLS-1$
      () -> assertEquals(4711, tuple.t2Value().intValue(), "t2 not as expected"), //$NON-NLS-1$
      () -> assertEquals(815, tuple.t3Value().intValue(), "t3 not as expected"), //$NON-NLS-1$
      () -> assertEquals(4, tuple.t4Value().intValue(), "t4 not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final NTuple4<Integer, Integer, Integer, Integer> tuple1 = NTuple4.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(4));
    final NTuple4<Integer, Integer, Integer, Integer> tuple2 = NTuple4.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(4));
    final NTuple4<Integer, Integer, Integer, Integer> tuple3 = NTuple4.of(Integer.valueOf(2), Integer.valueOf(815), Integer.valueOf(815), Integer.valueOf(4));
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(tuple1.hashCode(), tuple2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(tuple1.hashCode(), tuple3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final NTuple4<Integer, Integer, Integer, Integer> tuple1 = NTuple4.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(4));
    final NTuple4<Integer, Integer, Integer, Integer> tuple2 = NTuple4.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(4));
    final NTuple4<Integer, Integer, Integer, Integer> tuple3 = NTuple4.of(Integer.valueOf(2), Integer.valueOf(815), Integer.valueOf(815), Integer.valueOf(4));
    final NTuple4<Integer, Integer, Integer, Integer> tuple4 = NTuple4.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(4));
    assertAll(NTuple4Tests.TEST_EQUALS,
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
  public void testEquals2()
   {
    final NTuple4<Integer, Integer, Integer, Integer> tuple1 = NTuple4.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple4<Integer, Integer, Integer, Integer> tuple2 = NTuple4.of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple4<Integer, Integer, Integer, Integer> tuple3 = NTuple4.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
    assertAll(NTuple4Tests.TEST_EQUALS,
      () -> assertFalse(tuple1.equals(tuple2), NTuple4Tests.TUPLE12_IS_EQUAL),
      () -> assertFalse(tuple1.equals(tuple3), NTuple4Tests.TUPLE13_IS_EQUAL)
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final NTuple4<Integer, Integer, Integer, Integer> tuple1 = NTuple4.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(815), Integer.valueOf(4));
    assertEquals("NTuple4[object1=1, object2=4711, object3=815, object4=4]", tuple1.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final NTuple4<Integer, Integer, Integer, Integer> tuple1 = NTuple4.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(4));
    final NTuple4<Integer, Integer, Integer, Integer> tuple2 = NTuple4.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(4));
    final NTuple4<Integer, Integer, Integer, Integer> tuple3 = NTuple4.of(Integer.valueOf(2), Integer.valueOf(815), Integer.valueOf(815), Integer.valueOf(4));
    final NTuple4<Integer, Integer, Integer, Integer> tuple4 = NTuple4.of(Integer.valueOf(3), Integer.valueOf(20221127), Integer.valueOf(20221127), Integer.valueOf(4));
    final NTuple4<Integer, Integer, Integer, Integer> tuple5 = NTuple4.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711), Integer.valueOf(4));
    assertAll(NTuple4Tests.TEST_COMPARE_TO,
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
  public void testCompareTo2()
   {
    final NTuple4<Integer, Integer, Integer, Integer> tuple1 = NTuple4.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple4<Integer, Integer, Integer, Integer> tuple2 = NTuple4.of(Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(1));
    final NTuple4<Integer, Integer, Integer, Integer> tuple3 = NTuple4.of(Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(1));
    assertAll(NTuple4Tests.TEST_COMPARE_TO,
      () -> assertTrue(tuple1.compareTo(tuple2) != 0, NTuple4Tests.TUPLE12_IS_EQUAL),
      () -> assertTrue(tuple1.compareTo(tuple3) != 0, NTuple4Tests.TUPLE13_IS_EQUAL)
    );
   }

 }
