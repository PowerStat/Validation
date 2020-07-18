/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.IPV6Mask;


/**
 * IP V6 mask tests.
 */
public class IPV6MaskTests
 {
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
     }
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
     }
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
      () -> assertEquals(0, mask.getLength(), "length is not equal") //$NON-NLS-1$
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
      () -> assertEquals(128, mask.getLength(), "length is not equal") //$NON-NLS-1$
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final IPV6Mask mask1 = IPV6Mask.of(112);
    final IPV6Mask mask2 = IPV6Mask.of(112);
    final IPV6Mask mask3 = IPV6Mask.of(96);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(mask1.hashCode(), mask2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(mask1.hashCode(), mask3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final IPV6Mask mask1 = IPV6Mask.of(112);
    final IPV6Mask mask2 = IPV6Mask.of(112);
    final IPV6Mask mask3 = IPV6Mask.of(96);
    final IPV6Mask mask4 = IPV6Mask.of(112);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(mask1.equals(mask1), "mask11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(mask1.equals(mask2), "mask12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(mask2.equals(mask1), "mask21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(mask2.equals(mask4), "mask24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(mask1.equals(mask4), "mask14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(mask1.equals(mask3), "mask13 are equal"), //$NON-NLS-1$
      () -> assertFalse(mask3.equals(mask1), "mask31 are equal"), //$NON-NLS-1$
      () -> assertFalse(mask1.equals(null), "mask10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final IPV6Mask mask = IPV6Mask.of(112);
    assertEquals("IPV6Mask[length=112]", mask.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
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
