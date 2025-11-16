/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.EqualsVerifier;

import de.powerstat.validation.values.Day;
import de.powerstat.validation.values.JulianCalendar;
import de.powerstat.validation.values.Month;
import de.powerstat.validation.values.MonthDay;
import de.powerstat.validation.values.Year;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Julian calendar tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class JulianCalendarTests
 {
  /**
   * 1900 is a leap year.
   */
  private static final String YEAR_1900_IS_A_LEAP_YEAR = "1900 is a leap year";

  /**
   * Test is leap year constant.
   */
  private static final String TEST_IS_LEAP_YEAR = "testIsLeapYear"; //$NON-NLS-1$

  /**
   * Calendar not as expected constant.
   */
  private static final String CALENDAR_NOT_AS_EXPECTED = "Calendar not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ JulianCalendarTests()
   {
    super();
   }


  /**
   * Test correct JulianCalendar.
   */
  @Test
  /* default */ void testCalendarCorrect()
   {
    final JulianCalendar cleanCalendar = JulianCalendar.of();
    assertEquals("", cleanCalendar.stringValue(), CALENDAR_NOT_AS_EXPECTED);
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(JulianCalendar.class).verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final JulianCalendar calendar = JulianCalendar.of();
    assertEquals("JulianCalendar[]", calendar.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final JulianCalendar calendar1 = JulianCalendar.of();
    final JulianCalendar calendar2 = JulianCalendar.of();
    final JulianCalendar calendar3 = JulianCalendar.of();
    final JulianCalendar calendar4 = JulianCalendar.of();
    final JulianCalendar calendar5 = JulianCalendar.of();
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(calendar1.compareTo(calendar2) == -calendar2.compareTo(calendar1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(calendar1.compareTo(calendar3) == -calendar3.compareTo(calendar1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((calendar4.compareTo(calendar3) >= 0) && (calendar3.compareTo(calendar1) >= 0) && (calendar4.compareTo(calendar1) >= 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((calendar1.compareTo(calendar2) == 0) && (Math.abs(calendar1.compareTo(calendar5)) == Math.abs(calendar2.compareTo(calendar5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((calendar1.compareTo(calendar2) == 0) && calendar1.equals(calendar2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test isLeapYear.
   */
  @Test
  /* default */ void testIsLeapYear()
   {
    final JulianCalendar calendarIT = JulianCalendar.of();
    final JulianCalendar calendarDE = JulianCalendar.of();
    final JulianCalendar calendarRU = JulianCalendar.of();
    assertAll(JulianCalendarTests.TEST_IS_LEAP_YEAR,
      () -> assertTrue(calendarIT.isLeapYear(Year.of(1900)), YEAR_1900_IS_A_LEAP_YEAR),
      () -> assertTrue(calendarIT.isLeapYear(Year.of(2000)), "2000 is a leap year"), //$NON-NLS-1$
      () -> assertTrue(calendarIT.isLeapYear(Year.of(2020)), "2020 is a leap year"), //$NON-NLS-1$
      () -> assertFalse(calendarIT.isLeapYear(Year.of(2019)), "2019 is not a leap year"), //$NON-NLS-1$
      () -> assertFalse(calendarIT.isLeapYear(Year.of(1582)), "1582 is not a leap year"), //$NON-NLS-1$
      () -> assertTrue(calendarIT.isLeapYear(Year.of(1580)), "1580 is a leap year"), //$NON-NLS-1$
      () -> assertTrue(calendarDE.isLeapYear(Year.of(1580)), "1700 is a leap year"), //$NON-NLS-1$
      () -> assertTrue(calendarRU.isLeapYear(Year.of(1920)), "1920 is a leap year"), //$NON-NLS-1$
      () -> assertTrue(calendarRU.isLeapYear(Year.of(1900)), YEAR_1900_IS_A_LEAP_YEAR)
     );
   }


  /**
   * Test daysInMonth.
   */
  @Test
  /* default */ void testDaysInMonth()
   {
    final JulianCalendar calendar = JulianCalendar.of();
    assertAll(JulianCalendarTests.TEST_IS_LEAP_YEAR,
      () -> assertEquals(31, calendar.daysInMonth(Year.of(2020), Month.of(1)).longValue(), "January should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(29, calendar.daysInMonth(Year.of(2020), Month.of(2)).longValue(), "February should have 29 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendar.daysInMonth(Year.of(2020), Month.of(3)).longValue(), "March should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(30, calendar.daysInMonth(Year.of(2020), Month.of(4)).longValue(), "April should have 30 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendar.daysInMonth(Year.of(2020), Month.of(5)).longValue(), "May should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(30, calendar.daysInMonth(Year.of(2020), Month.of(6)).longValue(), "June should have 30 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendar.daysInMonth(Year.of(2020), Month.of(7)).longValue(), "July should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendar.daysInMonth(Year.of(2020), Month.of(8)).longValue(), "August should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(30, calendar.daysInMonth(Year.of(2020), Month.of(9)).longValue(), "September should have 30 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendar.daysInMonth(Year.of(2020), Month.of(10)).longValue(), "October should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(30, calendar.daysInMonth(Year.of(2020), Month.of(11)).longValue(), "November should have 30 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendar.daysInMonth(Year.of(2020), Month.of(12)).longValue(), "December should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(28, calendar.daysInMonth(Year.of(2019), Month.of(2)).longValue(), "February should have 28 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendar.daysInMonth(Year.of(1582), Month.of(10)).longValue(), "October 1582 should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(30, calendar.daysInMonth(Year.of(1582), Month.of(9)).longValue(), "September 1582 should have 30 days") //$NON-NLS-1$
     );
   }


  /**
   * Test daysInYear.
   */
  @Test
  /* default */ void testDaysInYear()
   {
    final JulianCalendar calendar = JulianCalendar.of();
    assertAll(JulianCalendarTests.TEST_IS_LEAP_YEAR,
      () -> assertEquals(366, calendar.daysInYear(Year.of(1900)).longValue(), "1900 should have 366 days"), //$NON-NLS-1$
      () -> assertEquals(366, calendar.daysInYear(Year.of(2000)).longValue(), "2000 should have 366 days"), //$NON-NLS-1$
      () -> assertEquals(365, calendar.daysInYear(Year.of(2019)).longValue(), "2019 should have 365 days"), //$NON-NLS-1$
      () -> assertEquals(365, calendar.daysInYear(Year.of(1582)).longValue(), "1582 should have 366 days") //$NON-NLS-1$
     );
   }


  /**
   * Test easterInYear.
   */
  @Test
  /* default */ void testEasterInYear()
   {
    final JulianCalendar calendar = JulianCalendar.of();
    assertAll(JulianCalendarTests.TEST_IS_LEAP_YEAR,
      () -> assertEquals(MonthDay.of(Month.of(4), Day.of(8)), calendar.easterInYear(Year.of(8)), "8 should be 08.04.") //$NON-NLS-1$
     );
   }

 }
