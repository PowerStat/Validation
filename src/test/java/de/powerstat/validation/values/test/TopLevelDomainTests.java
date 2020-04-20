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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.validation.values.TopLevelDomain;

/**
 * Top level domain tests.
 */
public class TopLevelDomainTests
 {
  /**
   * Default constructor.
   */
  public TopLevelDomainTests()
   {
    super();
   }


  /**
   * Test TopLevelDomain with valid top level domains.
   *
   * @param topLevelDomain TopLevelDomain
   */
  @ParameterizedTest
  @ValueSource(strings = {"de", "XN--VERMGENSBERATUNG-PWB"})
  public void topLevelDomainOk0(final String topLevelDomain)
   {
    final TopLevelDomain cleanTopLevelDomain = TopLevelDomain.of(topLevelDomain);
    assertEquals(topLevelDomain, cleanTopLevelDomain.getTopLevelDomain(), "TopLevelDomain not as expected"); //$NON-NLS-1$
   }


  /**
   * Test TopLevelDomain with top level domain to short or long.
   *
   * @param topLevelDomain TopLevelDomain
   */
  @ParameterizedTest
  @ValueSource(strings = {"A", "ABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKLMNOPQRSTUVWXYZABCDEFGHIJKL"})
  public void topLevelDomainLength(final String topLevelDomain)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final TopLevelDomain cleanTopLevelDomain = */ TopLevelDomain.of(topLevelDomain);
     }
    );
   }


  /**
   * Test TopLevelDomain with illegal parameters.
   *
   * @param topLevelDomain TopLevelDomain
   */
  @ParameterizedTest
  @ValueSource(strings = {".DE", "-DE", "DE-", "D~E", "ZZ"})
  public void topLÖevelDomainIllegalParameters(final String topLevelDomain)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final TopLevelDomain cleanTopLevelDomain = */ TopLevelDomain.of(topLevelDomain);
     }
    );
   }


  /**
   * Test get topLevelDomain.
   */
  @Test
  public void getTopLevelDomain()
   {
    final TopLevelDomain topLevelDomain = TopLevelDomain.of("DE"); //$NON-NLS-1$
    assertEquals("DE", topLevelDomain.getTopLevelDomain(), "TopLevelDomain not as expected"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final TopLevelDomain topLevelDomain1 = new TopLevelDomain("DE"); //$NON-NLS-1$
    final TopLevelDomain topLevelDomain2 = new TopLevelDomain("DE"); //$NON-NLS-1$
    final TopLevelDomain topLevelDomain3 = new TopLevelDomain("FR"); //$NON-NLS-1$
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(topLevelDomain1.hashCode(), topLevelDomain2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(topLevelDomain1.hashCode(), topLevelDomain3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final TopLevelDomain topLevelDomain1 = new TopLevelDomain("DE"); //$NON-NLS-1$
    final TopLevelDomain topLevelDomain2 = new TopLevelDomain("DE"); //$NON-NLS-1$
    final TopLevelDomain topLevelDomain3 = new TopLevelDomain("FR"); //$NON-NLS-1$
    final TopLevelDomain topLevelDomain4 = new TopLevelDomain("DE"); //$NON-NLS-1$
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(topLevelDomain1.equals(topLevelDomain1), "topLevelDomain11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(topLevelDomain1.equals(topLevelDomain2), "topLevelDomain12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(topLevelDomain2.equals(topLevelDomain1), "topLevelDomain21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(topLevelDomain2.equals(topLevelDomain4), "topLevelDomain24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(topLevelDomain1.equals(topLevelDomain4), "topLevelDomain14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(topLevelDomain1.equals(topLevelDomain3), "topLevelDomain13 are equal"), //$NON-NLS-1$
      () -> assertFalse(topLevelDomain3.equals(topLevelDomain1), "topLevelDomain31 are equal"), //$NON-NLS-1$
      () -> assertFalse(topLevelDomain1.equals(null), "topLevelDomain10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final TopLevelDomain topLevelDomain = new TopLevelDomain("DE"); //$NON-NLS-1$
    assertEquals("TopLevelDomain[topLevelDomain=DE]", topLevelDomain.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final TopLevelDomain topLevelDomain1 = new TopLevelDomain("DE"); //$NON-NLS-1$
    final TopLevelDomain topLevelDomain2 = new TopLevelDomain("DE"); //$NON-NLS-1$
    final TopLevelDomain topLevelDomain3 = new TopLevelDomain("FR"); //$NON-NLS-1$
    final TopLevelDomain topLevelDomain4 = new TopLevelDomain("GB"); //$NON-NLS-1$
    final TopLevelDomain topLevelDomain5 = new TopLevelDomain("DE"); //$NON-NLS-1$
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(topLevelDomain1.compareTo(topLevelDomain2) == -topLevelDomain2.compareTo(topLevelDomain1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(topLevelDomain1.compareTo(topLevelDomain3) == -topLevelDomain3.compareTo(topLevelDomain1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((topLevelDomain4.compareTo(topLevelDomain3) > 0) && (topLevelDomain3.compareTo(topLevelDomain1) > 0) && (topLevelDomain4.compareTo(topLevelDomain1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((topLevelDomain1.compareTo(topLevelDomain2) == 0) && (Math.abs(topLevelDomain1.compareTo(topLevelDomain5)) == Math.abs(topLevelDomain2.compareTo(topLevelDomain5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((topLevelDomain1.compareTo(topLevelDomain2) == 0) && topLevelDomain1.equals(topLevelDomain2), "equals") //$NON-NLS-1$
    );
   }

 }
