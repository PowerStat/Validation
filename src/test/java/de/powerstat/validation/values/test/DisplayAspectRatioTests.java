/*
 * Copyright (C) 2021-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.DisplayAspectRatio;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Display aspect ratio tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
public class DisplayAspectRatioTests
 {
  /**
   * Test aspect ration constant.
   */
  private static final String TEST_ASPECT_RATIO = "testAspectRatio"; //$NON-NLS-1$

  /**
   * 1:1 constant.
   */
  private static final String ONE_TWO_ONE = "1:1"; //$NON-NLS-1$

  /**
   * Aspect ratio not as expected constant.
   */
  private static final String ASPECT_RATIO_NOT_AS_EXPECTED = "aspect ratio not as expected"; //$NON-NLS-1$

  /**
   * Index out of bounds exception comnstant.
   */
  private static final String INDEX_OUT_OF_BOUNDS_EXPECTED = "Index out of bounds exception expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public DisplayAspectRatioTests()
   {
    super();
   }


  /**
   * Is display aspect ratio.
   */
  @Test
  public void isDisplayAspectRatio()
   {
    final DisplayAspectRatio ratio = DisplayAspectRatio.of(1, 1);
    assertAll(DisplayAspectRatioTests.TEST_ASPECT_RATIO,
      () -> assertEquals(1, ratio.x(), "x ratio not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, ratio.y(), "y ratio not as expected"), //$NON-NLS-1$
      () -> assertEquals(DisplayAspectRatioTests.ONE_TWO_ONE, ratio.stringValue(), DisplayAspectRatioTests.ASPECT_RATIO_NOT_AS_EXPECTED)
    );
   }


  /**
   * Is not display aspect ratio.
   */
  @Test
  public void isNotADisplayAspectRatio1()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final DisplayAspectRatio ratio = */ DisplayAspectRatio.of(0, 0);
     }, DisplayAspectRatioTests.INDEX_OUT_OF_BOUNDS_EXPECTED
    );
   }


  /**
   * Is not display aspect ratio.
   */
  @Test
  public void isNotADisplayAspectRatio2()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final DisplayAspectRatio ratio = */ DisplayAspectRatio.of(73, 0);
     }, DisplayAspectRatioTests.INDEX_OUT_OF_BOUNDS_EXPECTED
    );
   }


  /**
   * Is not display aspect ratio.
   */
  @Test
  public void isNotADisplayAspectRatio3()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final DisplayAspectRatio ratio = */ DisplayAspectRatio.of(1, 36);
     }, DisplayAspectRatioTests.INDEX_OUT_OF_BOUNDS_EXPECTED
    );
   }


  /**
   * Is not display aspect ratio.
   */
  @Test
  public void isNotADisplayAspectRatio4()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final DisplayAspectRatio ratio = */ DisplayAspectRatio.of(1, 0);
     }, DisplayAspectRatioTests.INDEX_OUT_OF_BOUNDS_EXPECTED
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final DisplayAspectRatio ratio1 = DisplayAspectRatio.of(1, 1);
    final DisplayAspectRatio ratio2 = DisplayAspectRatio.of(1, 1);
    final DisplayAspectRatio ratio3 = DisplayAspectRatio.of(2, 2);
    final DisplayAspectRatio ratio4 = DisplayAspectRatio.of(3, 2);
    final DisplayAspectRatio ratio5 = DisplayAspectRatio.of(1, 1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(ratio1.compareTo(ratio2) == -ratio2.compareTo(ratio1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(ratio1.compareTo(ratio3) == -ratio3.compareTo(ratio1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((ratio4.compareTo(ratio3) > 0) && (ratio3.compareTo(ratio1) > 0) && (ratio4.compareTo(ratio1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((ratio1.compareTo(ratio2) == 0) && (Math.abs(ratio1.compareTo(ratio5)) == Math.abs(ratio2.compareTo(ratio5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((ratio1.compareTo(ratio2) == 0) && ratio1.equals(ratio2), "equals") //$NON-NLS-1$
    );
   }

 }
