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

import de.powerstat.validation.values.WGS84Position;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * WGS84 position tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class WGS84PositionTests
 {
  /**
   * Default constructor.
   */
  public WGS84PositionTests()
   {
    super();
   }


  /**
   * Is WGS84 position.
   */
  @Test
  public void isWGS84Position()
   {
    final WGS84Position pos = WGS84Position.of(0.0, 0.0, 0.0);
    assertAll("testIsPosition", //$NON-NLS-1$
      () -> assertEquals(0.0, pos.getLatitude(), "Latitute error!"), //$NON-NLS-1$
      () -> assertEquals(0.0, pos.getLongitude(), "Longitute error!"), //$NON-NLS-1$
      () -> assertEquals(0.0, pos.getAltitude(), "Altitude error!") //$NON-NLS-1$
    );
   }


  /**
   * Is not a WGS84 position.
   */
  @Test
  public void isNotWGS84Position1()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final WGS84Position pos = */ WGS84Position.of(-90.1, 0.0, 0.0);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Is not a WGS84 position.
   */
  @Test
  public void isNotWGS84Position2()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final WGS84Position pos = */ WGS84Position.of(90.1, 0.0, 0.0);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Is not a WGS84 position.
   */
  @Test
  public void isNotWGS84Position3()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final WGS84Position pos = */ WGS84Position.of(0.0, -180.1, 0.0);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Is not a WGS84 position.
   */
  @Test
  public void isNotWGS84Position4()
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final WGS84Position pos = */ WGS84Position.of(0.0, 180.1, 0.0);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final WGS84Position pos1 = WGS84Position.of(0.0, 0.0, 0.0);
    final WGS84Position pos2 = WGS84Position.of(0.0, 0.0, 0.0);
    final WGS84Position pos3 = WGS84Position.of(10.0, 10.0, 0.0);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(pos1.hashCode(), pos2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(pos1.hashCode(), pos3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final WGS84Position pos1 = WGS84Position.of(0.0, 0.0, 0.0);
    final WGS84Position pos2 = WGS84Position.of(0.0, 0.0, 0.0);
    final WGS84Position pos3 = WGS84Position.of(10.0, 10.0, 0.0);
    final WGS84Position pos4 = WGS84Position.of(0.0, 0.0, 0.0);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(pos1.equals(pos1), "pos11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(pos1.equals(pos2), "pos12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(pos2.equals(pos1), "pos21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(pos2.equals(pos4), "pos24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(pos1.equals(pos4), "pos14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(pos1.equals(pos3), "pos13 are equal"), //$NON-NLS-1$
      () -> assertFalse(pos3.equals(pos1), "pos31 are equal"), //$NON-NLS-1$
      () -> assertFalse(pos1.equals(null), "pos10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test not equals.
   */
  @Test
  public void testNotEquals()
   {
    final WGS84Position pos1 = WGS84Position.of(0.0, 0.0, 0.0);
    final WGS84Position pos2 = WGS84Position.of(0.0, 0.0, 0.1);
    final WGS84Position pos3 = WGS84Position.of(0.0, 0.1, 0.0);
    assertAll("testNotEquals", //$NON-NLS-1$
      () -> assertFalse(pos1.equals(pos2), "pos12 is equal"), //$NON-NLS-1$
      () -> assertFalse(pos1.equals(pos3), "pos13 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final WGS84Position pos = WGS84Position.of(0.0, 0.0, 0.0);
    assertEquals("WGS84Position[latitude=0.0, longitude=0.0, altitude=0.0]", pos.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final WGS84Position pos1 = WGS84Position.of(0.0, 0.0, 0.0);
    final WGS84Position pos2 = WGS84Position.of(0.0, 0.0, 0.0);
    final WGS84Position pos3 = WGS84Position.of(10.0, 10.0, 0.0);
    final WGS84Position pos4 = WGS84Position.of(20.0, 20.0, 0.0);
    final WGS84Position pos5 = WGS84Position.of(0.0, 0.0, 0.0);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(pos1.compareTo(pos2) == -pos2.compareTo(pos1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(pos1.compareTo(pos3) == -pos3.compareTo(pos1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((pos4.compareTo(pos3) > 0) && (pos3.compareTo(pos1) > 0) && (pos4.compareTo(pos1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((pos1.compareTo(pos2) == 0) && (Math.abs(pos1.compareTo(pos5)) == Math.abs(pos2.compareTo(pos5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((pos1.compareTo(pos2) == 0) && pos1.equals(pos2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test not compareTo.
   */
  @Test
  public void testNotCompareTo()
   {
    final WGS84Position pos1 = WGS84Position.of(0.0, 0.0, 0.0);
    final WGS84Position pos2 = WGS84Position.of(0.0, 150.0, 0.0);
    assertAll("testNotCompareTo", //$NON-NLS-1$
      () -> assertTrue(pos1.compareTo(pos2) != 0, "equal") //$NON-NLS-1$
    );
   }

 }
