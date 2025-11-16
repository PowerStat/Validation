/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.EqualsVerifier;
import de.powerstat.validation.values.IPV4Mask;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * IP V4 mask tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
@SuppressWarnings({"PMD.AvoidUsingHardCodedIP"})
final class IPV4MaskTests
 {
  /**
   * IP address mask 255.0.0.0.
   */
  private static final String IPMASK_255_0_0_0 = "255.0.0.0"; //$NON-NLS-1$

  /**
   * IP address mask 255.255.0.0.
   */
  private static final String IPMASK_255_255_0_0 = "255.255.0.0"; //$NON-NLS-1$

  /**
   * IP address mask 255.255.255.0.
   */
  private static final String IPMASK_255_255_255_0 = "255.255.255.0"; //$NON-NLS-1$

  /**
   * IP address mask 255.255.255.255.
   */
  private static final String IP255 = "255.255.255.255"; //$NON-NLS-1$

  /**
   * P address mask 0.0.0.0.
   */
  private static final String IP_ZERO = "0.0.0.0"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Index out of bounds exception expected constant.
   */
  private static final String INDEX_OUT_OF_BOUNDS = "Index out of bounds exception expected"; //$NON-NLS-1$

  /**
   * Error message: length is not equal.
   */
  private static final String LENGTH_IS_NOT_EQUAL = "length is not equal"; //$NON-NLS-1$

  /**
   * Error message: mask is not equal.
   */
  private static final String MASK_IS_NOT_EQUAL = "mask is not equal"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ IPV4MaskTests()
   {
    super();
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testConstructorFailure0()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final IPV4Mask mask = */ IPV4Mask.of(-1);
     }, IPV4MaskTests.INDEX_OUT_OF_BOUNDS
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testConstructorFailure1()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final IPV4Mask mask = */ IPV4Mask.of(33);
     }, IPV4MaskTests.INDEX_OUT_OF_BOUNDS
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testConstructorFailure2()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPV4Mask mask = */ IPV4Mask.of("255.255.129.0"); //$NON-NLS-1$
     }, IPV4MaskTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testConstructorFailure3()
   {
    assertThrows(NullPointerException.class, () ->
     {
      /* final IPV4Mask mask = */ IPV4Mask.of(null);
     }, "Null pointer exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testCnstructorFailure4()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPV4Mask mask = */ IPV4Mask.of("255.255.255.255."); //$NON-NLS-1$
     }, IPV4MaskTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testConstructorFailure5()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPV4Mask mask = */ IPV4Mask.of("0.0.0."); //$NON-NLS-1$
     }, IPV4MaskTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  /* default */ void testConstructorSuccess0()
   {
    final IPV4Mask mask = IPV4Mask.of(0);
    assertAll("constructorSuccess0", //$NON-NLS-1$
      () -> assertEquals(0, mask.intValue(), IPV4MaskTests.LENGTH_IS_NOT_EQUAL),
      () -> assertEquals(IPV4MaskTests.IP_ZERO, mask.stringValue(), IPV4MaskTests.MASK_IS_NOT_EQUAL)
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  /* default */ void testConstructorSuccess1()
   {
    final IPV4Mask mask = IPV4Mask.of(32);
    assertAll("constructorSuccess1", //$NON-NLS-1$
      () -> assertEquals(32, mask.intValue(), IPV4MaskTests.LENGTH_IS_NOT_EQUAL),
      () -> assertEquals(IPV4MaskTests.IP255, mask.stringValue(), IPV4MaskTests.MASK_IS_NOT_EQUAL)
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  /* default */ void testConstructorSuccess2()
   {
    final IPV4Mask mask = IPV4Mask.of(IPV4MaskTests.IP_ZERO);
    assertAll("constructorSuccess2", //$NON-NLS-1$
      () -> assertEquals(0, mask.intValue(), IPV4MaskTests.LENGTH_IS_NOT_EQUAL),
      () -> assertEquals(IPV4MaskTests.IP_ZERO, mask.stringValue(), IPV4MaskTests.MASK_IS_NOT_EQUAL)
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  /* default */ void testConstructorSuccess3()
   {
    final IPV4Mask mask = IPV4Mask.of(IPV4MaskTests.IP255);
    assertAll("constructorSuccess3", //$NON-NLS-1$
      () -> assertEquals(32, mask.intValue(), IPV4MaskTests.LENGTH_IS_NOT_EQUAL),
      () -> assertEquals(IPV4MaskTests.IP255, mask.stringValue(), IPV4MaskTests.MASK_IS_NOT_EQUAL)
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  /* default */ void testConstructorSuccess4()
   {
    final IPV4Mask mask = IPV4Mask.of(8);
    assertAll("constructorSuccess4", //$NON-NLS-1$
      () -> assertEquals(8, mask.intValue(), IPV4MaskTests.LENGTH_IS_NOT_EQUAL),
      () -> assertEquals(IPV4MaskTests.IPMASK_255_0_0_0, mask.stringValue(), IPV4MaskTests.MASK_IS_NOT_EQUAL)
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  /* default */ void testConstructorSuccess5()
   {
    final IPV4Mask mask = IPV4Mask.of(16);
    assertAll("constructorSuccess5", //$NON-NLS-1$
      () -> assertEquals(16, mask.intValue(), IPV4MaskTests.LENGTH_IS_NOT_EQUAL),
      () -> assertEquals(IPV4MaskTests.IPMASK_255_255_0_0, mask.stringValue(), IPV4MaskTests.MASK_IS_NOT_EQUAL)
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  /* default */ void testConstructorSuccess6()
   {
    final IPV4Mask mask = IPV4Mask.of(24);
    assertAll("constructorSuccess6", //$NON-NLS-1$
      () -> assertEquals(24, mask.intValue(), IPV4MaskTests.LENGTH_IS_NOT_EQUAL),
      () -> assertEquals(IPV4MaskTests.IPMASK_255_255_255_0, mask.stringValue(), IPV4MaskTests.MASK_IS_NOT_EQUAL)
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  /* default */ void testConstructorSuccess7()
   {
    final IPV4Mask mask = IPV4Mask.of(IPV4MaskTests.IPMASK_255_255_255_0);
    assertAll("constructorSuccess7", //$NON-NLS-1$
      () -> assertEquals(24, mask.intValue(), IPV4MaskTests.LENGTH_IS_NOT_EQUAL),
      () -> assertEquals(IPV4MaskTests.IPMASK_255_255_255_0, mask.stringValue(), IPV4MaskTests.MASK_IS_NOT_EQUAL)
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  /* default */ void testConstructorSuccess8()
   {
    final IPV4Mask mask = IPV4Mask.of(IPV4MaskTests.IPMASK_255_255_0_0);
    assertAll("constructorSuccess8", //$NON-NLS-1$
      () -> assertEquals(16, mask.intValue(), IPV4MaskTests.LENGTH_IS_NOT_EQUAL),
      () -> assertEquals(IPV4MaskTests.IPMASK_255_255_0_0, mask.stringValue(), IPV4MaskTests.MASK_IS_NOT_EQUAL)
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  /* default */ void testConstructorSuccess9()
   {
    final IPV4Mask mask = IPV4Mask.of(IPV4MaskTests.IPMASK_255_0_0_0);
    assertAll("constructorSuccess9", //$NON-NLS-1$
      () -> assertEquals(8, mask.intValue(), IPV4MaskTests.LENGTH_IS_NOT_EQUAL),
      () -> assertEquals(IPV4MaskTests.IPMASK_255_0_0_0, mask.stringValue(), IPV4MaskTests.MASK_IS_NOT_EQUAL)
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  /* default */ void testConstructorSuccess10()
   {
    final IPV4Mask mask = IPV4Mask.of(9);
    assertAll("constructorSuccess10", //$NON-NLS-1$
      () -> assertEquals(9, mask.intValue(), IPV4MaskTests.LENGTH_IS_NOT_EQUAL),
      () -> assertEquals("255.128.0.0", mask.stringValue(), IPV4MaskTests.MASK_IS_NOT_EQUAL) //$NON-NLS-1$
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  /* default */ void testConstructorSuccess11()
   {
    final IPV4Mask mask = IPV4Mask.of(17);
    assertAll("constructorSuccess11", //$NON-NLS-1$
      () -> assertEquals(17, mask.intValue(), IPV4MaskTests.LENGTH_IS_NOT_EQUAL),
      () -> assertEquals("255.255.128.0", mask.stringValue(), IPV4MaskTests.MASK_IS_NOT_EQUAL) //$NON-NLS-1$
    );
   }


  /**
   * Test constructor success.
   */
  @Test
  /* default */ void testConstructorSuccess12()
   {
    final IPV4Mask mask = IPV4Mask.of(25);
    assertAll("constructorSuccess12", //$NON-NLS-1$
      () -> assertEquals(25, mask.intValue(), IPV4MaskTests.LENGTH_IS_NOT_EQUAL),
      () -> assertEquals("255.255.255.128", mask.stringValue(), IPV4MaskTests.MASK_IS_NOT_EQUAL) //$NON-NLS-1$
    );
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(IPV4Mask.class).withIgnoredFields("mask").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final IPV4Mask mask = IPV4Mask.of(IPV4MaskTests.IPMASK_255_255_255_0);
    assertEquals("IPV4Mask[length=24, mask=255.255.255.0]", mask.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final IPV4Mask mask1 = IPV4Mask.of(IPV4MaskTests.IPMASK_255_0_0_0);
    final IPV4Mask mask2 = IPV4Mask.of(IPV4MaskTests.IPMASK_255_0_0_0);
    final IPV4Mask mask3 = IPV4Mask.of(IPV4MaskTests.IPMASK_255_255_0_0);
    final IPV4Mask mask4 = IPV4Mask.of(IPV4MaskTests.IPMASK_255_255_255_0);
    final IPV4Mask mask5 = IPV4Mask.of(IPV4MaskTests.IPMASK_255_0_0_0);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(mask1.compareTo(mask2) == -mask2.compareTo(mask1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(mask1.compareTo(mask3) == -mask3.compareTo(mask1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((mask4.compareTo(mask3) > 0) && (mask3.compareTo(mask1) > 0) && (mask4.compareTo(mask1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((mask1.compareTo(mask2) == 0) && (Math.abs(mask1.compareTo(mask5)) == Math.abs(mask2.compareTo(mask5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((mask1.compareTo(mask2) == 0) && mask1.equals(mask2), "equals") //$NON-NLS-1$
    );
   }

 }
