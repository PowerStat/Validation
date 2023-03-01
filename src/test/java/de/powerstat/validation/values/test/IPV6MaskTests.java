/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.IPV6Mask;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * IP V6 mask tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
public class IPV6MaskTests
 {
  /**
   * Length is not equal constant.
   */
  private static final String LENGTH_IS_NOT_EQUAL = "length is not equal"; //$NON-NLS-1$

  /**
   * Index out of bounds exception expected constant.
   */
  private static final String INDEX_OUT_OF_BOUNDS = "Index out of bounds exception expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public IPV6MaskTests()
   {
    super();
   }


  /**
   * Test constructor failure.
   */
  @Test
  public void constructorFailure0()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final IPV6Mask mask = */ IPV6Mask.of(-1);
     }, IPV6MaskTests.INDEX_OUT_OF_BOUNDS
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  public void constructorFailure1()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final IPV6Mask mask = */ IPV6Mask.of(129);
     }, IPV6MaskTests.INDEX_OUT_OF_BOUNDS
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  public void constructorSuccess0()
   {
    final IPV6Mask mask = IPV6Mask.of(0);
    assertAll("constructorSuccess0", //$NON-NLS-1$
      () -> assertEquals(0, mask.length(), IPV6MaskTests.LENGTH_IS_NOT_EQUAL)
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  public void constructorSuccess1()
   {
    final IPV6Mask mask = IPV6Mask.of(128);
    assertAll("constructorSuccess1", //$NON-NLS-1$
      () -> assertEquals(128, mask.length(), IPV6MaskTests.LENGTH_IS_NOT_EQUAL)
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final IPV6Mask mask1 = IPV6Mask.of(16);
    final IPV6Mask mask2 = IPV6Mask.of(16);
    final IPV6Mask mask3 = IPV6Mask.of(32);
    final IPV6Mask mask4 = IPV6Mask.of(48);
    final IPV6Mask mask5 = IPV6Mask.of(16);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(mask1.compareTo(mask2) == -mask2.compareTo(mask1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(mask1.compareTo(mask3) == -mask3.compareTo(mask1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((mask4.compareTo(mask3) > 0) && (mask3.compareTo(mask1) > 0) && (mask4.compareTo(mask1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((mask1.compareTo(mask2) == 0) && (Math.abs(mask1.compareTo(mask5)) == Math.abs(mask2.compareTo(mask5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((mask1.compareTo(mask2) == 0) && mask1.equals(mask2), "equals") //$NON-NLS-1$
    );
   }

 }
