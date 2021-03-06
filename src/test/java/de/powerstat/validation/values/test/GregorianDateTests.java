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

import de.powerstat.validation.values.Country;
import de.powerstat.validation.values.Day;
import de.powerstat.validation.values.GregorianCalendar;
import de.powerstat.validation.values.GregorianDate;
import de.powerstat.validation.values.Month;
import de.powerstat.validation.values.Year;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Gregorian date tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class GregorianDateTests
 {
  /**
   * Default constructor.
   */
  public GregorianDateTests()
   {
    super();
   }


  /**
   * Test correct GregorianDate.
   *
   * @param date ISO8601 date string
   */
  @ParameterizedTest
  @ValueSource(strings = {"2020-07-14", "2020-06-30", "2020-02-29", "2020-02-28", "2020-01-29", "2019-02-28", "2019-01-29"})
  public void dateCorrect(final String date)
   {
    final String[] dateParts = date.split("-"); //$NON-NLS-1$
    final GregorianDate cleanDate = GregorianDate.of(Year.of(Long.parseLong(dateParts[0])), Month.of(Integer.parseInt(dateParts[1])), Day.of(Integer.parseInt(dateParts[2])));
    assertEquals(date, cleanDate.getDate(), "Date not as expected"); //$NON-NLS-1$
   }


  /**
   * Test wrong date.
   *
   * @param date ISO8601 date string
   */
  @ParameterizedTest
  @ValueSource(strings = {"2019-02-29", "2020-04-31"})
  public void dateWrong(final String date)
   {
    final String[] dateParts = date.split("-"); //$NON-NLS-1$
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final GregorianDate cleanDate = */ GregorianDate.of(Year.of(Long.parseLong(dateParts[0])), Month.of(Integer.parseInt(dateParts[1])), Day.of(Integer.parseInt(dateParts[2])));
     }
    );
   }


  /**
   * Test get date.
   */
  @Test
  public void getDate()
   {
    final GregorianDate date = GregorianDate.of(Year.of(2020), Month.of(7), Day.of(14));
    assertEquals("2020-07-14", date.getDate(), "Date not as expected"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final GregorianDate date1 = GregorianDate.of(Year.of(2020), Month.of(7), Day.of(14));
    final GregorianDate date2 = GregorianDate.of(Year.of(2020), Month.of(7), Day.of(14));
    final GregorianDate date3 = GregorianDate.of(Year.of(2021), Month.of(8), Day.of(15));
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(date1.hashCode(), date2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(date1.hashCode(), date3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final GregorianDate date1 = GregorianDate.of(Year.of(2020), Month.of(7), Day.of(14));
    final GregorianDate date2 = GregorianDate.of(Year.of(2020), Month.of(7), Day.of(14));
    final GregorianDate date3 = GregorianDate.of(Year.of(2021), Month.of(7), Day.of(14));
    final GregorianDate date4 = GregorianDate.of(Year.of(2020), Month.of(7), Day.of(14));
    final GregorianDate date5 = GregorianDate.of(Year.of(2020), Month.of(8), Day.of(14));
    final GregorianDate date6 = GregorianDate.of(Year.of(2020), Month.of(7), Day.of(15));
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(date1.equals(date1), "date11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(date1.equals(date2), "date12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(date2.equals(date1), "date21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(date2.equals(date4), "date24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(date1.equals(date4), "date14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(date1.equals(date3), "date13 are equal"), //$NON-NLS-1$
      () -> assertFalse(date3.equals(date1), "date31 are equal"), //$NON-NLS-1$
      () -> assertFalse(date1.equals(null), "date10 is equal"), //$NON-NLS-1$
      () -> assertFalse(date1.equals(date5), "date15 are equal"), //$NON-NLS-1$
      () -> assertFalse(date1.equals(date6), "date16 are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final GregorianDate date = GregorianDate.of(Year.of(2020), Month.of(7), Day.of(14));
    assertEquals("GregorianDate[country=IT, date=2020-07-14]", date.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final GregorianDate date1 = GregorianDate.of(Year.of(2020), Month.of(7), Day.of(14));
    final GregorianDate date2 = GregorianDate.of(Year.of(2020), Month.of(7), Day.of(14));
    final GregorianDate date3 = GregorianDate.of(Year.of(2021), Month.of(7), Day.of(14));
    final GregorianDate date4 = GregorianDate.of(Year.of(2021), Month.of(8), Day.of(14));
    final GregorianDate date5 = GregorianDate.of(Year.of(2020), Month.of(7), Day.of(14));
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(date1.compareTo(date2) == -date2.compareTo(date1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(date1.compareTo(date3) == -date3.compareTo(date1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((date4.compareTo(date3) > 0) && (date3.compareTo(date1) > 0) && (date4.compareTo(date1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((date1.compareTo(date2) == 0) && (Math.abs(date1.compareTo(date5)) == Math.abs(date2.compareTo(date5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((date1.compareTo(date2) == 0) && date1.equals(date2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test easter calculation.
   */
  @Test
  public void testEaster()
   {
    final GregorianDate easter2020 = GregorianDate.easter(GregorianCalendar.of(Country.of("IT")), Year.of(2020)); //$NON-NLS-1$
    final GregorianDate easter2018 = GregorianDate.easter(GregorianCalendar.of(Country.of("IT")), Year.of(2018)); //$NON-NLS-1$
    final GregorianDate easter2015 = GregorianDate.easter(GregorianCalendar.of(Country.of("IT")), Year.of(2015)); //$NON-NLS-1$
    final GregorianDate easter2014 = GregorianDate.easter(GregorianCalendar.of(Country.of("IT")), Year.of(2014)); //$NON-NLS-1$
    final GregorianDate easter2011 = GregorianDate.easter(GregorianCalendar.of(Country.of("IT")), Year.of(2011)); //$NON-NLS-1$
    final GregorianDate easter2008 = GregorianDate.easter(GregorianCalendar.of(Country.of("IT")), Year.of(2008)); //$NON-NLS-1$
    final GregorianDate easter2005 = GregorianDate.easter(GregorianCalendar.of(Country.of("IT")), Year.of(2005)); //$NON-NLS-1$
    final GregorianDate easter1997 = GregorianDate.easter(GregorianCalendar.of(Country.of("IT")), Year.of(1997)); //$NON-NLS-1$
    final GregorianDate easter1991 = GregorianDate.easter(GregorianCalendar.of(Country.of("IT")), Year.of(1991)); //$NON-NLS-1$
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertEquals(GregorianDate.of(Year.of(2020), Month.of(4), Day.of(12)), easter2020, "Easter 2020 on wrong date"), //$NON-NLS-1$
      () -> assertEquals(GregorianDate.of(Year.of(2018), Month.of(4), Day.of(1)), easter2018, "Easter 2018 on wrong date"), //$NON-NLS-1$
      () -> assertEquals(GregorianDate.of(Year.of(2015), Month.of(4), Day.of(5)), easter2015, "Easter 2015 on wrong date"), //$NON-NLS-1$
      () -> assertEquals(GregorianDate.of(Year.of(2014), Month.of(4), Day.of(20)), easter2014, "Easter 2014 on wrong date"), //$NON-NLS-1$
      () -> assertEquals(GregorianDate.of(Year.of(2011), Month.of(4), Day.of(24)), easter2011, "Easter 2011 on wrong date"), //$NON-NLS-1$
      () -> assertEquals(GregorianDate.of(Year.of(2008), Month.of(3), Day.of(23)), easter2008, "Easter 2008 on wrong date"), //$NON-NLS-1$
      () -> assertEquals(GregorianDate.of(Year.of(2005), Month.of(3), Day.of(27)), easter2005, "Easter 2005 on wrong date"), //$NON-NLS-1$
      () -> assertEquals(GregorianDate.of(Year.of(1997), Month.of(3), Day.of(30)), easter1997, "Easter 1997 on wrong date"), //$NON-NLS-1$
      () -> assertEquals(GregorianDate.of(Year.of(1991), Month.of(3), Day.of(31)), easter1991, "Easter 1991 on wrong date") //$NON-NLS-1$
    );
   }

 }
