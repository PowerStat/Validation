/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.containers.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.EqualsVerifier;

import de.powerstat.validation.containers.NTuple9;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * NTuple9 tests.
 */
@SuppressFBWarnings({"CE_CLASS_ENVY", "RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class NTuple9Tests
 {
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
   * Suppress sonarqube warning.
   */
  private static final String JAVA_S5785 = "java:S5785"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ NTuple9Tests()
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
      () -> assertEquals(1, tuple.obj1().intValue(), "obj1 not as expected"), //$NON-NLS-1$
      () -> assertEquals(4711, tuple.obj2().intValue(), "obj2 not as expected"), //$NON-NLS-1$
      () -> assertEquals(815, tuple.obj3().intValue(), "obj3 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.obj4().intValue(), "obj4 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.obj5().intValue(), "obj5 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.obj6().intValue(), "obj6 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.obj7().intValue(), "obj7 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.obj8().intValue(), "obj8 not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, tuple.obj9().intValue(), "obj9 not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings(JAVA_S5785)
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
  @SuppressWarnings(JAVA_S5785)
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
