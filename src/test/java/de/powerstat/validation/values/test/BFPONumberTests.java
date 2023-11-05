/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.validation.values.BFPONumber;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * BFPONumber tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class BFPONumberTests
 {
  /**
   * Not a BFPONumber constant.
   */
  private static final String NOT_A_BFPO_NUMBER = "Not a BFPONumber!"; //$NON-NLS-1$

  /**
   * 1 constant.
   */
  private static final String ONE = "1"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ BFPONumberTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(1, BFPONumber.of(ONE).bFPONumber(), BFPONumberTests.NOT_A_BFPO_NUMBER);
   }


  /**
   * Is bFPONumber.
   *
   * @param bFPONumber BFPONumber
   */
  @ParameterizedTest
  @ValueSource(ints = {1, 2035})
  /* default */ void testIsBFPONumber(final int bFPONumber)
   {
    assertEquals(bFPONumber, BFPONumber.of(bFPONumber).bFPONumber(), BFPONumberTests.NOT_A_BFPO_NUMBER);
   }


  /**
   * Is bFPONumber string.
   *
   * @param bFPONumber BFPONumber
   */
  @ParameterizedTest
  @ValueSource(ints = {1, 2035})
  /* default */ void testIsBFPONumberStr(final int bFPONumber)
   {
    assertEquals(Integer.toString(bFPONumber), BFPONumber.of(bFPONumber).stringValue(), BFPONumberTests.NOT_A_BFPO_NUMBER);
   }


  /**
   * Is not a BFPONumber.
   *
   * @param bFPONumber BFPONumber
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 2036})
  /* default */ void testIsNotABFPONumber(final int bFPONumber)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final BFPONumber bFPONumber = */ BFPONumber.of(bFPONumber);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final BFPONumber bFPONumber1 = BFPONumber.of(1);
    final BFPONumber bFPONumber2 = BFPONumber.of(1);
    final BFPONumber bFPONumber3 = BFPONumber.of(2);
    final BFPONumber bFPONumber4 = BFPONumber.of(3);
    final BFPONumber bFPONumber5 = BFPONumber.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(bFPONumber1.compareTo(bFPONumber2) == -bFPONumber2.compareTo(bFPONumber1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(bFPONumber1.compareTo(bFPONumber3) == -bFPONumber3.compareTo(bFPONumber1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((bFPONumber4.compareTo(bFPONumber3) > 0) && (bFPONumber3.compareTo(bFPONumber1) > 0) && (bFPONumber4.compareTo(bFPONumber1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((bFPONumber1.compareTo(bFPONumber2) == 0) && (Math.abs(bFPONumber1.compareTo(bFPONumber5)) == Math.abs(bFPONumber2.compareTo(bFPONumber5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((bFPONumber1.compareTo(bFPONumber2) == 0) && bFPONumber1.equals(bFPONumber2), "equals") //$NON-NLS-1$
    );
   }

 }

