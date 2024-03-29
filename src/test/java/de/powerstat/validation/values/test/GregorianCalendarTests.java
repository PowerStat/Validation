/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.validation.values.Country;
import de.powerstat.validation.values.GregorianCalendar;
import de.powerstat.validation.values.Month;
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
   * Test hash code.
   */
  @Test
  /* default */ void testHashCode()
   {
    final GregorianCalendar calendar1 = GregorianCalendar.of(Country.of(GregorianCalendarTests.IT));
    final GregorianCalendar calendar2 = GregorianCalendar.of(Country.of(GregorianCalendarTests.IT));
    final GregorianCalendar calendar3 = GregorianCalendar.of(Country.of(GregorianCalendarTests.DE));
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(calendar1.hashCode(), calendar2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(calendar1.hashCode(), calendar3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testEquals()
   {
    final GregorianCalendar calendar1 = GregorianCalendar.of(Country.of(GregorianCalendarTests.IT));
    final GregorianCalendar calendar2 = GregorianCalendar.of(Country.of(GregorianCalendarTests.IT));
    final GregorianCalendar calendar3 = GregorianCalendar.of(Country.of(GregorianCalendarTests.DE));
    final GregorianCalendar calendar4 = GregorianCalendar.of(Country.of(GregorianCalendarTests.IT));
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(calendar1.equals(calendar1), "calendar11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(calendar1.equals(calendar2), "calendar12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(calendar2.equals(calendar1), "calendar21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(calendar2.equals(calendar4), "calendar24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(calendar1.equals(calendar4), "calendar14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(calendar1.equals(calendar3), "calendar13 are equal"), //$NON-NLS-1$
      () -> assertFalse(calendar3.equals(calendar1), "calendar31 are equal"), //$NON-NLS-1$
      () -> assertFalse(calendar1.equals(null), "calendar10 is equal") //$NON-NLS-1$
    );
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
  /* default */ void testIsLeapYear()
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
      () -> assertTrue(calendarDE.isLeapYear(Year.of(1580)), "1700 is not a leap year"), //$NON-NLS-1$
      () -> assertTrue(calendarRU.isLeapYear(Year.of(1920)), "1920 is a leap year"), //$NON-NLS-1$
      () -> assertTrue(calendarRU.isLeapYear(Year.of(1900)), "1900 is a leap year") //$NON-NLS-1$
     );
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
      () -> assertEquals(31, calendarIT.daysInMonth(Year.of(2020), Month.of(1)), "January should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(29, calendarIT.daysInMonth(Year.of(2020), Month.of(2)), "February should have 29 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendarIT.daysInMonth(Year.of(2020), Month.of(3)), "March should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(30, calendarIT.daysInMonth(Year.of(2020), Month.of(4)), "April should have 30 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendarIT.daysInMonth(Year.of(2020), Month.of(5)), "May should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(30, calendarIT.daysInMonth(Year.of(2020), Month.of(6)), "June should have 30 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendarIT.daysInMonth(Year.of(2020), Month.of(7)), "July should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendarIT.daysInMonth(Year.of(2020), Month.of(8)), "August should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(30, calendarIT.daysInMonth(Year.of(2020), Month.of(9)), "September should have 30 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendarIT.daysInMonth(Year.of(2020), Month.of(10)), "October should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(30, calendarIT.daysInMonth(Year.of(2020), Month.of(11)), "November should have 30 days"), //$NON-NLS-1$
      () -> assertEquals(31, calendarIT.daysInMonth(Year.of(2020), Month.of(12)), "December should have 31 days"), //$NON-NLS-1$
      () -> assertEquals(28, calendarIT.daysInMonth(Year.of(2019), Month.of(2)), "February should have 28 days"), //$NON-NLS-1$
      () -> assertEquals(21, calendarIT.daysInMonth(Year.of(1582), Month.of(10)), "October 1582 should have 21 days"), //$NON-NLS-1$
      () -> assertEquals(15, calendarRU.daysInMonth(Year.of(1918), Month.of(2)), "February 1918 should have 15 days"), //$NON-NLS-1$
      () -> assertEquals(30, calendarIT.daysInMonth(Year.of(1582), Month.of(9)), "September 1582 should have 30 days") //$NON-NLS-1$
     );
   }

 }
