/*
 * Copyright (C) 2022-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.containers.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.*;
import de.powerstat.validation.containers.NTuple3;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * NTuple3 tests.
 */
@SuppressFBWarnings({"CE_CLASS_ENVY", "RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR", "EC_NULL_ARG"})
final class NTuple3Tests
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
   * Suppress sonarqube warning.
   */
  private static final String JAVA_S5785 = "java:S5785"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ NTuple3Tests()
   {
    super();
   }


  /**
   * Factory test.
   */
  @Test
  /* default */ void testOfInt()
   {
    final NTuple3<Integer, Integer, Integer> tuple = NTuple3.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(815));
    assertAll("testGetValue", //$NON-NLS-1$
      () -> assertEquals(1, tuple.t1Value().intValue(), "t1 not as expected"), //$NON-NLS-1$
      () -> assertEquals(4711, tuple.t2Value().intValue(), "t2 not as expected"), //$NON-NLS-1$
      () -> assertEquals(815, tuple.t3Value().intValue(), "t3 not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(NTuple3.class).withNonnullFields("object1", "object2", "object3").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final NTuple3<Integer, Integer, Integer> tuple1 = NTuple3.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(815));
    assertEquals("NTuple3[object1=1, object2=4711, object3=815]", tuple1.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings(JAVA_S5785)
  /* default */ void testCompareTo()
   {
    final NTuple3<Integer, Integer, Integer> tuple1 = NTuple3.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711));
    final NTuple3<Integer, Integer, Integer> tuple2 = NTuple3.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711));
    final NTuple3<Integer, Integer, Integer> tuple3 = NTuple3.of(Integer.valueOf(2), Integer.valueOf(815), Integer.valueOf(815));
    final NTuple3<Integer, Integer, Integer> tuple4 = NTuple3.of(Integer.valueOf(3), Integer.valueOf(20221127), Integer.valueOf(20221127));
    final NTuple3<Integer, Integer, Integer> tuple5 = NTuple3.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(4711));
    assertAll(NTuple3Tests.TEST_COMPARE_TO,
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
    final NTuple3<Integer, Integer, Integer> tuple1 = NTuple3.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(1));
    final NTuple3<Integer, Integer, Integer> tuple2 = NTuple3.of(Integer.valueOf(1), Integer.valueOf(815), Integer.valueOf(1));
    assertAll(NTuple3Tests.TEST_COMPARE_TO,
      () -> assertTrue(tuple1.compareTo(tuple2) != 0, "tuple1 == tuple2") //$NON-NLS-1$
    );
   }

 }
