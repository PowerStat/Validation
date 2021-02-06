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

import de.powerstat.validation.values.Day;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Day tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT"})
public class DayTests
 {
  /**
   * Default constructor.
   */
  public DayTests()
   {
    super();
   }


  /**
   * Is day.
   *
   * @param day Day
   */
  @ParameterizedTest
  @ValueSource(ints = {1, 31})
  public void isDay(final int day)
   {
    assertEquals(day, Day.of(day).getDay(), "Not a day!"); //$NON-NLS-1$
   }


  /**
   * Is not a day.
   *
   * @param day Day
   */
  @ParameterizedTest
  @ValueSource(ints = {0, 32})
  public void isNotADay(final int day)
   {
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      /* final Day day = */ Day.of(day);
     }
    );
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Day day1 = Day.of(1);
    final Day day2 = Day.of(1);
    final Day day3 = Day.of(2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(day1.hashCode(), day2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(day1.hashCode(), day3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Day day1 = Day.of(1);
    final Day day2 = Day.of(1);
    final Day day3 = Day.of(2);
    final Day day4 = Day.of(1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(day1.equals(day1), "day11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(day1.equals(day2), "day12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(day2.equals(day1), "day21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(day2.equals(day4), "day24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(day1.equals(day4), "day14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(day1.equals(day3), "day13 are equal"), //$NON-NLS-1$
      () -> assertFalse(day3.equals(day1), "day31 are equal"), //$NON-NLS-1$
      () -> assertFalse(day1.equals(null), "day10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Day day = Day.of(1);
    assertEquals("Day[day=1]", day.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Day day1 = Day.of(1);
    final Day day2 = Day.of(1);
    final Day day3 = Day.of(2);
    final Day day4 = Day.of(3);
    final Day day5 = Day.of(1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(day1.compareTo(day2) == -day2.compareTo(day1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(day1.compareTo(day3) == -day3.compareTo(day1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((day4.compareTo(day3) > 0) && (day3.compareTo(day1) > 0) && (day4.compareTo(day1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((day1.compareTo(day2) == 0) && (Math.abs(day1.compareTo(day5)) == Math.abs(day2.compareTo(day5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((day1.compareTo(day2) == 0) && day1.equals(day2), "equals") //$NON-NLS-1$
    );
   }

 }
