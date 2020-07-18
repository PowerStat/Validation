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

import de.powerstat.validation.values.PoBoxNumber;

/**
 * Post office  box number tests.
 */
public class PoBoxNumberTests
 {
  /**
   * Default constructor.
   */
  public PoBoxNumberTests()
   {
    super();
   }


  /**
   * Is po box number.
   *
   * @param poBoxNumber PO box number
   */
  @ParameterizedTest
  @ValueSource(longs = {1, 99999})
  public void isPoBoxNumber(final long poBoxNumber)
   {
    assertEquals(poBoxNumber, PoBoxNumber.of(poBoxNumber).getPoBoxNumber(), "Not a po box number!"); //$NON-NLS-1$
   }


  /**
   * Is po box number string.
   *
   * @param poBoxNumber PO box number
   */
  @ParameterizedTest
  @ValueSource(strings = {"1", "99999"})
  public void isPoBoxNumberStr(final String poBoxNumber)
   {
    assertEquals(poBoxNumber, PoBoxNumber.of(Long.valueOf(poBoxNumber)).getPoBoxNumberStr(), "Not a po box number!"); //$NON-NLS-1$
   }


  /**
   * Is not a po box number.
   *
   * @param poBoxNumber PO box number
   */
  @ParameterizedTest
  @ValueSource(longs = {0})
  public void isNotAPoBoxNumber(final long poBoxNumber)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final PoBoxNumber poBoxNumber = */ PoBoxNumber.of(poBoxNumber);
     }
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final PoBoxNumber poBoxNumber1 = PoBoxNumber.of(1);
    final PoBoxNumber poBoxNumber2 = PoBoxNumber.of(1);
    final PoBoxNumber poBoxNumber3 = PoBoxNumber.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(poBoxNumber1.hashCode(), poBoxNumber2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(poBoxNumber1.hashCode(), poBoxNumber3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final PoBoxNumber poBoxNumber1 = PoBoxNumber.of(1);
    final PoBoxNumber poBoxNumber2 = PoBoxNumber.of(1);
    final PoBoxNumber poBoxNumber3 = PoBoxNumber.of(2);
    final PoBoxNumber poBoxNumber4 = PoBoxNumber.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(poBoxNumber1.equals(poBoxNumber1), "poBox11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(poBoxNumber1.equals(poBoxNumber2), "poBox12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(poBoxNumber2.equals(poBoxNumber1), "poBox21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(poBoxNumber2.equals(poBoxNumber4), "poBox24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(poBoxNumber1.equals(poBoxNumber4), "poBox14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(poBoxNumber1.equals(poBoxNumber3), "poBox13 are equal"), //$NON-NLS-1$
      () -> assertFalse(poBoxNumber3.equals(poBoxNumber1), "poBox31 are equal"), //$NON-NLS-1$
      () -> assertFalse(poBoxNumber1.equals(null), "poBox10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final PoBoxNumber poBoxNumber = PoBoxNumber.of(1);
    assertEquals("PoBoxNumber[poBoxNumber=1]", poBoxNumber.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final PoBoxNumber pobox1 = PoBoxNumber.of(1);
    final PoBoxNumber pobox2 = PoBoxNumber.of(1);
    final PoBoxNumber pobox3 = PoBoxNumber.of(2);
    final PoBoxNumber pobox4 = PoBoxNumber.of(3);
    final PoBoxNumber pobox5 = PoBoxNumber.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(pobox1.compareTo(pobox2) == -pobox2.compareTo(pobox1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(pobox1.compareTo(pobox3) == -pobox3.compareTo(pobox1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((pobox4.compareTo(pobox3) > 0) && (pobox3.compareTo(pobox1) > 0) && (pobox4.compareTo(pobox1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((pobox1.compareTo(pobox2) == 0) && (Math.abs(pobox1.compareTo(pobox5)) == Math.abs(pobox2.compareTo(pobox5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((pobox1.compareTo(pobox2) == 0) && pobox1.equals(pobox2), "equals") //$NON-NLS-1$
    );
   }

 }
