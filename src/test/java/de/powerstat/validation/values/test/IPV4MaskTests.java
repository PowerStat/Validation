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

import de.powerstat.validation.values.IPV4Mask;

/**
 * IP V4 mask tests.
 */
public class IPV4MaskTests
 {
  /**
   * Default constructor.
   */
  public IPV4MaskTests()
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
      final IPV4Mask mask = IPV4Mask.of(-1);
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
      final IPV4Mask mask = IPV4Mask.of(33);
     }
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  public void constructorFailure2()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      final IPV4Mask mask = IPV4Mask.of("255.255.129.0");
     }
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  public void constructorFailure3()
   {
    assertThrows(NullPointerException.class, () ->
     {
      final IPV4Mask mask = IPV4Mask.of(null);
     }
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  public void constructorFailure4()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      final IPV4Mask mask = IPV4Mask.of("255.255.255.255.");
     }
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  public void constructorFailure5()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      final IPV4Mask mask = IPV4Mask.of("0.0.0.");
     }
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  public void constructorSuccess0()
   {
    final IPV4Mask mask = IPV4Mask.of(0);
    assertAll("constructorSuccess0", //$NON-NLS-1$
      () -> assertEquals(0, mask.getLength(), "length is not equal"), //$NON-NLS-1$
      () -> assertEquals("0.0.0.0", mask.getMask(), "mask is not equal") //$NON-NLS-1$
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  public void constructorSuccess1()
   {
    final IPV4Mask mask = IPV4Mask.of(32);
    assertAll("constructorSuccess1", //$NON-NLS-1$
      () -> assertEquals(32, mask.getLength(), "length is not equal"), //$NON-NLS-1$
      () -> assertEquals("255.255.255.255", mask.getMask(), "mask is not equal") //$NON-NLS-1$
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  public void constructorSuccess2()
   {
    final IPV4Mask mask = IPV4Mask.of("0.0.0.0"); //$NON-NLS-1$
    assertAll("constructorSuccess2", //$NON-NLS-1$
      () -> assertEquals(0, mask.getLength(), "length is not equal"), //$NON-NLS-1$
      () -> assertEquals("0.0.0.0", mask.getMask(), "mask is not equal") //$NON-NLS-1$ //$NON-NLS-2$
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  public void constructorSuccess3()
   {
    final IPV4Mask mask = IPV4Mask.of("255.255.255.255"); //$NON-NLS-1$
    assertAll("constructorSuccess3", //$NON-NLS-1$
      () -> assertEquals(32, mask.getLength(), "length is not equal"), //$NON-NLS-1$
      () -> assertEquals("255.255.255.255", mask.getMask(), "mask is not equal") //$NON-NLS-1$ //$NON-NLS-2$
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  public void constructorSuccess4()
   {
    final IPV4Mask mask = IPV4Mask.of(8);
    assertAll("constructorSuccess4", //$NON-NLS-1$
      () -> assertEquals(8, mask.getLength(), "length is not equal"), //$NON-NLS-1$
      () -> assertEquals("255.0.0.0", mask.getMask(), "mask is not equal") //$NON-NLS-1$
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  public void constructorSuccess5()
   {
    final IPV4Mask mask = IPV4Mask.of(16);
    assertAll("constructorSuccess5", //$NON-NLS-1$
      () -> assertEquals(16, mask.getLength(), "length is not equal"), //$NON-NLS-1$
      () -> assertEquals("255.255.0.0", mask.getMask(), "mask is not equal") //$NON-NLS-1$
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  public void constructorSuccess6()
   {
    final IPV4Mask mask = IPV4Mask.of(24);
    assertAll("constructorSuccess6", //$NON-NLS-1$
      () -> assertEquals(24, mask.getLength(), "length is not equal"), //$NON-NLS-1$
      () -> assertEquals("255.255.255.0", mask.getMask(), "mask is not equal") //$NON-NLS-1$
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  public void constructorSuccess7()
   {
    final IPV4Mask mask = IPV4Mask.of("255.255.255.0"); //$NON-NLS-1$
    assertAll("constructorSuccess7", //$NON-NLS-1$
      () -> assertEquals(24, mask.getLength(), "length is not equal"), //$NON-NLS-1$
      () -> assertEquals("255.255.255.0", mask.getMask(), "mask is not equal") //$NON-NLS-1$ //$NON-NLS-2$
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  public void constructorSuccess8()
   {
    final IPV4Mask mask = IPV4Mask.of("255.255.0.0"); //$NON-NLS-1$
    assertAll("constructorSuccess8", //$NON-NLS-1$
      () -> assertEquals(16, mask.getLength(), "length is not equal"), //$NON-NLS-1$
      () -> assertEquals("255.255.0.0", mask.getMask(), "mask is not equal") //$NON-NLS-1$ //$NON-NLS-2$
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  public void constructorSuccess9()
   {
    final IPV4Mask mask = IPV4Mask.of("255.0.0.0"); //$NON-NLS-1$
    assertAll("constructorSuccess9", //$NON-NLS-1$
      () -> assertEquals(8, mask.getLength(), "length is not equal"), //$NON-NLS-1$
      () -> assertEquals("255.0.0.0", mask.getMask(), "mask is not equal") //$NON-NLS-1$ //$NON-NLS-2$
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  public void constructorSuccess10()
   {
    final IPV4Mask mask = IPV4Mask.of(9);
    assertAll("constructorSuccess10", //$NON-NLS-1$
      () -> assertEquals(9, mask.getLength(), "length is not equal"), //$NON-NLS-1$
      () -> assertEquals("255.128.0.0", mask.getMask(), "mask is not equal") //$NON-NLS-1$
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  public void constructorSuccess11()
   {
    final IPV4Mask mask = IPV4Mask.of(17);
    assertAll("constructorSuccess11", //$NON-NLS-1$
      () -> assertEquals(17, mask.getLength(), "length is not equal"), //$NON-NLS-1$
      () -> assertEquals("255.255.128.0", mask.getMask(), "mask is not equal") //$NON-NLS-1$
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  public void constructorSuccess12()
   {
    final IPV4Mask mask = IPV4Mask.of(25);
    assertAll("constructorSuccess12", //$NON-NLS-1$
      () -> assertEquals(25, mask.getLength(), "length is not equal"), //$NON-NLS-1$
      () -> assertEquals("255.255.255.128", mask.getMask(), "mask is not equal") //$NON-NLS-1$
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final IPV4Mask mask1 = new IPV4Mask("255.255.255.0"); //$NON-NLS-1$
    final IPV4Mask mask2 = new IPV4Mask("255.255.255.0"); //$NON-NLS-1$
    final IPV4Mask mask3 = new IPV4Mask("255.255.0.0"); //$NON-NLS-1$
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
    final IPV4Mask mask1 = new IPV4Mask("255.255.255.0"); //$NON-NLS-1$
    final IPV4Mask mask2 = new IPV4Mask("255.255.255.0"); //$NON-NLS-1$
    final IPV4Mask mask3 = new IPV4Mask("255.255.0.0"); //$NON-NLS-1$
    final IPV4Mask mask4 = new IPV4Mask("255.255.255.0"); //$NON-NLS-1$
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
    final IPV4Mask mask = new IPV4Mask("255.255.255.0"); //$NON-NLS-1$
    assertEquals("IPV4Mask[length=24, mask=255.255.255.0]", mask.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final IPV4Mask mask1 = new IPV4Mask("255.0.0.0"); //$NON-NLS-1$
    final IPV4Mask mask2 = new IPV4Mask("255.0.0.0"); //$NON-NLS-1$
    final IPV4Mask mask3 = new IPV4Mask("255.255.0.0"); //$NON-NLS-1$
    final IPV4Mask mask4 = new IPV4Mask("255.255.255.0"); //$NON-NLS-1$
    final IPV4Mask mask5 = new IPV4Mask("255.0.0.0"); //$NON-NLS-1$
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(mask1.compareTo(mask2) == -mask2.compareTo(mask1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(mask1.compareTo(mask3) == -mask3.compareTo(mask1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((mask4.compareTo(mask3) > 0) && (mask3.compareTo(mask1) > 0) && (mask4.compareTo(mask1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((mask1.compareTo(mask2) == 0) && (Math.abs(mask1.compareTo(mask5)) == Math.abs(mask2.compareTo(mask5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((mask1.compareTo(mask2) == 0) && mask1.equals(mask2), "equals") //$NON-NLS-1$
    );
   }

 }
