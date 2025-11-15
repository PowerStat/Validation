/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import nl.jqno.equalsverifier.*;

import de.powerstat.validation.values.Country;
import de.powerstat.validation.values.Day;
import de.powerstat.validation.values.GregorianCalendar;
import de.powerstat.validation.values.Month;
import de.powerstat.validation.values.MonthDay;
import de.powerstat.validation.values.Year;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Gregorian calendar tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class GregorianCalendarTests
 {
  /**
   * Test is leap year constant.
   */
  private static final String TEST_IS_LEAP_YEAR = "testIsLeapYear"; //$NON-NLS-1$

  /**
   * DE germany.
   */
  private static final String DE = "DE"; //$NON-NLS-1$

  /**
   * IT italy.
   */
  private static final String IT = "IT"; //$NON-NLS-1$

  /**
   * RU russia.
   */
  private static final String RU = "RU"; //$NON-NLS-1$

  /**
   * Calendar not as expected constant.
   */
  private static final String CALENDAR_NOT_AS_EXPECTED = "Calendar not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ GregorianCalendarTests()
   {
    super();
   }


  /**
   * Test correct GregorianCalendar.
   *
   * @param country Country name
   */
  @ParameterizedTest
  @ValueSource(strings = {GregorianCalendarTests.IT})
  /* default */ void testCalendarCorrect(final String country)
   {
    final GregorianCalendar cleanCalendar = GregorianCalendar.of(Country.of(country));
    assertEquals(country, cleanCalendar.getCountry().stringValue(), CALENDAR_NOT_AS_EXPECTED);
   }


  /**
   * Test factory.
   *
   * @param country Country name
   */
  @ParameterizedTest
  @ValueSource(strings = {GregorianCalendarTests.IT})
  /* default */ void testOf(final String country)
   {
    final GregorianCalendar cleanCalendar = GregorianCalendar.of(country);
    assertEquals(country, cleanCalendar.getCountry().stringValue(), CALENDAR_NOT_AS_EXPECTED);
   }


  /**
   * Test string value.
   */
  @Test
  /* default */ void testStringValue()
   {
    final GregorianCalendar cal = GregorianCalendar.of(Country.of(DE));
    assertEquals(DE, cal.stringValue(), "Calendar country not as expected");
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(GregorianCalendar.class).withNonnullFields("country").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final GregorianCalendar calendar = GregorianCalendar.of(Country.of(GregorianCalendarTests.IT));
    assertEquals("GregorianCalendar[country=IT]", calendar.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final GregorianCalendar calendar1 = GregorianCalendar.of(Country.of(GregorianCalendarTests.IT));
    final GregorianCalendar calendar2 = GregorianCalendar.of(Country.of(GregorianCalendarTests.IT));
    final GregorianCalendar calendar3 = GregorianCalendar.of(Country.of(GregorianCalendarTests.DE));
    final GregorianCalendar calendar4 = GregorianCalendar.of(Country.of("US")); //$NON-NLS-1$
    final GregorianCalendar calendar5 = GregorianCalendar.of(Country.of(GregorianCalendarTests.IT));
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(calendar1.compareTo(calendar2) == -calendar2.compareTo(calendar1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(calendar1.compareTo(calendar3) == -calendar3.compareTo(calendar1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((calendar4.compareTo(calendar3) > 0) && (calendar3.compareTo(calendar1) > 0) && (calendar4.compareTo(calendar1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((calendar1.compareTo(calendar2) == 0) && (Math.abs(calendar1.compareTo(calendar5)) == Math.abs(calendar2.compareTo(calendar5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((calendar1.compareTo(calendar2) == 0) && calendar1.equals(calendar2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test isLeapYear.
   */
  @Test
  /* default */ void testIsLeapYear1()
   {
    final GregorianCalendar calendarIT = GregorianCalendar.of(Country.of(GregorianCalendarTests.IT));
    final GregorianCalendar calendarDE = GregorianCalendar.of(Country.of(GregorianCalendarTests.DE));
    final GregorianCalendar calendarRU = GregorianCalendar.of(Country.of(GregorianCalendarTests.RU));
    assertAll(GregorianCalendarTests.TEST_IS_LEAP_YEAR,
      () -> assertFalse(calendarIT.isLeapYear(Year.of(1900)), "1900 is not a leap year"), //$NON-NLS-1$
      () -> assertTrue(calendarIT.isLeapYear(Year.of(2000)), "2000 is a leap year"), //$NON-NLS-1$
      () -> assertTrue(calendarIT.isLeapYear(Year.of(2020)), "2020 is a leap year"), //$NON-NLS-1$
      () -> assertFalse(calendarIT.isLeapYear(Year.of(2019)), "2019 is not a leap year"), //$NON-NLS-1$
      () -> assertFalse(calendarIT.isLeapYear(Year.of(1582)), "1582 is not a leap year"), //$NON-NLS-1$
      () -> assertTrue(calendarIT.isLeapYear(Year.of(1580)), "1580 is a leap year"), //$NON-NLS-1$
      () -> assertTrue(calendarDE.isLeapYear(Year.of(1580)), "1700 is a leap year"), //$NON-NLS-1$
      () -> assertTrue(calendarRU.isLeapYear(Year.of(1920)), "1920 is a leap year"), //$NON-NLS-1$
      () -> assertTrue(calendarRU.isLeapYear(Year.of(1900)), "1900 is a leap year") //$NON-NLS-1$
     );
   }


  /**
   * Test isLeapYear.
   */
  @Test
  /* default */ void testIsLeapYear2()
   {
    final GregorianCalendar calendar = GregorianCalendar.of(Country.of("UA"));
    assertFalse(calendar.isLeapYear(Year.of(1900)), "1900 is not a leap year");
   }


  /**
   * Test isLeapYear.
   */
  @Test
  /* default */ void testIsLeapYear3()
   {
    final GregorianCalendar calendarIT = GregorianCalendar.of(Country.of(GregorianCalendarTests.IT));
    assertFalse(calendarIT.isLeapYear(Year.of(1582)), "1582 is not a leap year");
   }


  /**
   * Test daysInMonth.
   */
  @Test
  /* default */ void testDaysInMonth()
   {
    final GregorianCalendar calendarIT = GregorianCalendar.of(Country.of(GregorianCalendarTests.IT));
    final GregorianCalendar calendarRU = GregorianCalendar.of(Country.of(GregorianCalendarTests.RU));
    assertAll(GregorianCalendarTests.TEST_IS_LEAP_YEAR,
      () -> assertEquals(31, calendarIT.daysInMonth(Year.of(2020), Month.of(1)).longValue(), "January should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(29, calendarIT.daysInMonth(Year.of(2020), Month.of(2)).longValue(), "February should have 29 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendarIT.daysInMonth(Year.of(2020), Month.of(3)).longValue(), "March should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(30, calendarIT.daysInMonth(Year.of(2020), Month.of(4)).longValue(), "April should have 30 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendarIT.daysInMonth(Year.of(2020), Month.of(5)).longValue(), "May should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(30, calendarIT.daysInMonth(Year.of(2020), Month.of(6)).longValue(), "June should have 30 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendarIT.daysInMonth(Year.of(2020), Month.of(7)).longValue(), "July should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendarIT.daysInMonth(Year.of(2020), Month.of(8)).longValue(), "August should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(30, calendarIT.daysInMonth(Year.of(2020), Month.of(9)).longValue(), "September should have 30 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendarIT.daysInMonth(Year.of(2020), Month.of(10)).longValue(), "October should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(30, calendarIT.daysInMonth(Year.of(2020), Month.of(11)).longValue(), "November should have 30 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendarIT.daysInMonth(Year.of(2020), Month.of(12)).longValue(), "December should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(28, calendarIT.daysInMonth(Year.of(2019), Month.of(2)).longValue(), "February should have 28 days"), //$NON-NLS-1$
      () -> assertEquals(21, calendarIT.daysInMonth(Year.of(1582), Month.of(10)).longValue(), "October 1582 should have 21 days"), //$NON-NLS-1$
      () -> assertEquals(15, calendarRU.daysInMonth(Year.of(1918), Month.of(2)).longValue(), "February 1918 should have 15 days"), //$NON-NLS-1$
      () -> assertEquals(30, calendarIT.daysInMonth(Year.of(1582), Month.of(9)).longValue(), "September 1582 should have 30 days") //$NON-NLS-1$
     );
   }


  /**
   * Test daysInYear.
   */
  @Test
  /* default */ void testDaysInYear()
   {
    final GregorianCalendar calendar = GregorianCalendar.of();
    assertAll(GregorianCalendarTests.TEST_IS_LEAP_YEAR,
      () -> assertEquals(365, calendar.daysInYear(Year.of(1900)).longValue(), "1900 should have 366 days"), //$NON-NLS-1$
      () -> assertEquals(366, calendar.daysInYear(Year.of(2000)).longValue(), "2000 should have 366 days"), //$NON-NLS-1$
      () -> assertEquals(365, calendar.daysInYear(Year.of(2019)).longValue(), "2019 should have 365 days"), //$NON-NLS-1$
      () -> assertEquals(355, calendar.daysInYear(Year.of(1582)).longValue(), "1582 should have 355 days") //$NON-NLS-1$
     );
   }


  /**
   * Test easterInYear.
   */
  @Test
  /* default */ void testEasterInYear()
   {
    final GregorianCalendar calendar = GregorianCalendar.of();
    assertAll(GregorianCalendarTests.TEST_IS_LEAP_YEAR,
      () -> assertEquals(MonthDay.of(Month.of(3), Day.of(31)), calendar.easterInYear(Year.of(2024)), "2024 should be 31.03.") //$NON-NLS-1$
     );
   }

 }
