/*
 * Copyright (C) 2021-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.ScreenSize;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Screen size tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
public class ScreenSizeTests
 {
  /**
   * QVGA.
   */
  private static final String QVGA = "QVGA"; //$NON-NLS-1$

  /**
   * 320x240.
   */
  private static final String QVGA320X240 = "320x240"; //$NON-NLS-1$

  /**
   * VGA.
   */
  private static final String VGA = "VGA"; //$NON-NLS-1$

  /**
   * Size is not equal constant.
   */
  private static final String SIZE_IS_NOT_EQUAL = "Size is not equal"; //$NON-NLS-1$

  /**
   * Index out of bounds exception expected constant.
   */
  private static final String INDEX_OUT_OF_BOUNDS_EXPECTED = "Index out of bounds exception expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public ScreenSizeTests()
   {
    super();
   }


  /**
   * Is screen size.
   */
  @Test
  public void isScreenSize()
   {
    final ScreenSize size = ScreenSize.of(320, 240, ScreenSizeTests.QVGA);
    assertAll("testScreenSize", //$NON-NLS-1$
      () -> assertEquals(320, size.width(), "width is not equal"), //$NON-NLS-1$
      () -> assertEquals(240, size.height(), "height is not equal"), //$NON-NLS-1$
      () -> assertEquals(ScreenSizeTests.QVGA320X240, size.stringValue(), ScreenSizeTests.SIZE_IS_NOT_EQUAL),
      () -> assertEquals(ScreenSizeTests.QVGA, size.name(), "size name is not equal") //$NON-NLS-1$
    );
   }


  /**
   * Is not a screen size.
   */
  @Test
  public void isNotAScreenSize1()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final ScreenSize size = */ ScreenSize.of(0, 0, null);
     }, ScreenSizeTests.INDEX_OUT_OF_BOUNDS_EXPECTED
    );
   }


  /**
   * Is not a screen size.
   */
  @Test
  public void isNotAScreenSize2()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final ScreenSize size = */ ScreenSize.of(8193, 0, null);
     }, ScreenSizeTests.INDEX_OUT_OF_BOUNDS_EXPECTED
    );
   }


  /**
   * Is not a screen size.
   */
  @Test
  public void isNotAScreenSize3()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final ScreenSize size = */ ScreenSize.of(1, 8193, null);
     }, ScreenSizeTests.INDEX_OUT_OF_BOUNDS_EXPECTED
    );
   }


  /**
   * Is not a screen size.
   */
  @Test
  public void isNotAScreenSize4()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final ScreenSize size = */ ScreenSize.of(1, 0, null);
     }, ScreenSizeTests.INDEX_OUT_OF_BOUNDS_EXPECTED
    );
   }


  /**
   * Test not equals.
   */
  @Test
  public void testNotEquals()
   {
    final ScreenSize size1 = ScreenSize.of(320, 240, ScreenSizeTests.QVGA);
    final ScreenSize size2 = ScreenSize.of(320, 241, ScreenSizeTests.QVGA);
    assertAll("testNotEquals", //$NON-NLS-1$
      () -> assertFalse(size1.equals(size2), "size12 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final ScreenSize size1 = ScreenSize.of(320, 240, ScreenSizeTests.QVGA);
    final ScreenSize size2 = ScreenSize.of(320, 240, ScreenSizeTests.QVGA);
    final ScreenSize size3 = ScreenSize.of(640, 480, ScreenSizeTests.VGA);
    final ScreenSize size4 = ScreenSize.of(1280, 800, "WXGA"); //$NON-NLS-1$
    final ScreenSize size5 = ScreenSize.of(320, 240, ScreenSizeTests.QVGA);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(size1.compareTo(size2) == -size2.compareTo(size1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(size1.compareTo(size3) == -size3.compareTo(size1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((size4.compareTo(size3) > 0) && (size3.compareTo(size1) > 0) && (size4.compareTo(size1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((size1.compareTo(size2) == 0) && (Math.abs(size1.compareTo(size5)) == Math.abs(size2.compareTo(size5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((size1.compareTo(size2) == 0) && size1.equals(size2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test compareTo2.
   */
  @Test
  public void testCompareTo2()
   {
    final ScreenSize size1 = ScreenSize.of(320, 240, ScreenSizeTests.QVGA);
    final ScreenSize size2 = ScreenSize.of(320, 241, ScreenSizeTests.QVGA);
    assertAll("testCompareTo2", //$NON-NLS-1$
      () -> assertTrue(size1.compareTo(size2) != 0, "equal") //$NON-NLS-1$
    );
   }

 }
