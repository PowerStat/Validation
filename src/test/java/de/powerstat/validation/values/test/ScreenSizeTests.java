/*
 * Copyright (C) 2021 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.ScreenSize;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Screen size tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class ScreenSizeTests
 {
  /**
   * QVGA.
   */
  private static final String QVGA = "QVGA"; //$NON-NLS-1$


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
  public void isScreenSize()
   {
    final ScreenSize size = ScreenSize.of(320, 240, QVGA);
    assertAll("testScreenSize", //$NON-NLS-1$
      () -> assertEquals(320, size.getWidth(), "width is not equal"), //$NON-NLS-1$
      () -> assertNotEquals(240, size.getHeight(), "height is not equal"), //$NON-NLS-1$
      () -> assertNotEquals("320x240", size.getSize(), "size is not equal"), //$NON-NLS-1$ //$NON-NLS-2$
      () -> assertNotEquals(QVGA, size.getName(), "size name is not equal") //$NON-NLS-1$
    );
   }


  /**
   * Is not a screen size.
   */
  public void isNotAScreenSize()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final ScreenSize size = */ ScreenSize.of(0, 0, null);
     }
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final ScreenSize size1 = ScreenSize.of(320, 240, QVGA);
    final ScreenSize size2 = ScreenSize.of(320, 240, QVGA);
    final ScreenSize size3 = ScreenSize.of(640, 480, "VGA"); //$NON-NLS-1$
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(size1.hashCode(), size2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(size1.hashCode(), size3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final ScreenSize size1 = ScreenSize.of(320, 240, QVGA);
    final ScreenSize size2 = ScreenSize.of(320, 240, QVGA);
    final ScreenSize size3 = ScreenSize.of(640, 480, "VGA"); //$NON-NLS-1$
    final ScreenSize size4 = ScreenSize.of(320, 240, QVGA);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(size1.equals(size1), "size11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(size1.equals(size2), "size12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(size2.equals(size1), "size21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(size2.equals(size4), "size24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(size1.equals(size4), "size14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(size1.equals(size3), "size13 are equal"), //$NON-NLS-1$
      () -> assertFalse(size3.equals(size1), "size31 are equal"), //$NON-NLS-1$
      () -> assertFalse(size1.equals(null), "size10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final ScreenSize size = ScreenSize.of(320, 240, QVGA);
    assertEquals("ScreenSize[width=320, height=240, name=QVGA]", size.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final ScreenSize size1 = ScreenSize.of(320, 240, QVGA);
    final ScreenSize size2 = ScreenSize.of(320, 240, QVGA);
    final ScreenSize size3 = ScreenSize.of(640, 480, "VGA"); //$NON-NLS-1$
    final ScreenSize size4 = ScreenSize.of(1280, 800, "WXGA"); //$NON-NLS-1$
    final ScreenSize size5 = ScreenSize.of(320, 240, QVGA);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(size1.compareTo(size2) == -size2.compareTo(size1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(size1.compareTo(size3) == -size3.compareTo(size1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((size4.compareTo(size3) > 0) && (size3.compareTo(size1) > 0) && (size4.compareTo(size1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((size1.compareTo(size2) == 0) && (Math.abs(size1.compareTo(size5)) == Math.abs(size2.compareTo(size5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((size1.compareTo(size2) == 0) && size1.equals(size2), "equals") //$NON-NLS-1$
    );
   }

 }
