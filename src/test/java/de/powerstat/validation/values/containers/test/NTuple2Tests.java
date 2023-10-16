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

import de.powerstat.validation.values.containers.NTuple2;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * NTuple2 tests.
 */
@SuppressFBWarnings({"CE_CLASS_ENVY", "RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR", "EC_NULL_ARG"})
final class NTuple2Tests
 {
  /**
   * Default constructor.
   */
  public NTuple2Tests()
   {
    super();
   }


  /**
   * Factory test.
   */
  @Test
  /* default */ void testOfInt()
   {
    final NTuple2<Integer, Integer> tuple = NTuple2.of(Integer.valueOf(1), Integer.valueOf(4711));
    assertAll("testGetValue", //$NON-NLS-1$
      () -> assertEquals(1, tuple.t1Value().intValue(), "t1 not as expected"), //$NON-NLS-1$
      () -> assertEquals(4711, tuple.t2Value().intValue(), "t2 not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test hash code.
   */
  @Test
  /* default */ void testHashCode()
   {
    final NTuple2<Integer, Integer> tuple1 = NTuple2.of(Integer.valueOf(1), Integer.valueOf(4711));
    final NTuple2<Integer, Integer> tuple2 = NTuple2.of(Integer.valueOf(1), Integer.valueOf(4711));
    final NTuple2<Integer, Integer> tuple3 = NTuple2.of(Integer.valueOf(2), Integer.valueOf(815));
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
    final NTuple2<Integer, Integer> tuple1 = NTuple2.of(Integer.valueOf(1), Integer.valueOf(4711));
    final NTuple2<Integer, Integer> tuple2 = NTuple2.of(Integer.valueOf(1), Integer.valueOf(4711));
    final NTuple2<Integer, Integer> tuple3 = NTuple2.of(Integer.valueOf(2), Integer.valueOf(815));
    final NTuple2<Integer, Integer> tuple4 = NTuple2.of(Integer.valueOf(1), Integer.valueOf(4711));
    assertAll("testEquals", //$NON-NLS-1$
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
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final NTuple2<Integer, Integer> tuple1 = NTuple2.of(Integer.valueOf(1), Integer.valueOf(4711));
    assertEquals("NTuple2[object1=1, object2=4711]", tuple1.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final NTuple2<Integer, Integer> tuple1 = NTuple2.of(Integer.valueOf(1), Integer.valueOf(4711));
    final NTuple2<Integer, Integer> tuple2 = NTuple2.of(Integer.valueOf(1), Integer.valueOf(4711));
    final NTuple2<Integer, Integer> tuple3 = NTuple2.of(Integer.valueOf(2), Integer.valueOf(815));
    final NTuple2<Integer, Integer> tuple4 = NTuple2.of(Integer.valueOf(3), Integer.valueOf(20221126));
    final NTuple2<Integer, Integer> tuple5 = NTuple2.of(Integer.valueOf(1), Integer.valueOf(4711));
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(tuple1.compareTo(tuple2) == -tuple2.compareTo(tuple1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(tuple1.compareTo(tuple3) == -tuple3.compareTo(tuple1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((tuple4.compareTo(tuple3) > 0) && (tuple3.compareTo(tuple1) > 0) && (tuple4.compareTo(tuple1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((tuple1.compareTo(tuple2) == 0) && (Math.abs(tuple1.compareTo(tuple5)) == Math.abs(tuple2.compareTo(tuple5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((tuple1.compareTo(tuple2) == 0) && tuple1.equals(tuple2), "equals") //$NON-NLS-1$
    );
   }

 }
