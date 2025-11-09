/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import nl.jqno.equalsverifier.*;
import de.powerstat.validation.values.IPV6Mask;
import de.powerstat.validation.values.ISBN13;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * ISBN13 tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class ISBN13Tests
 {
  /**
   * Default constructor.
   */
  /* default */ ISBN13Tests()
   {
    super();
   }


  /**
   * Test correct ISBN13.
   *
   * @param isbn ISBN13
   */
  @ParameterizedTest
  @ValueSource(strings = {"9783836272773", "9781617294105"}) // "979-8-3291-7678-0"
  /* default */ void testIsbn13Correct(final String isbn)
   {
    final ISBN13 cleanIsbn = ISBN13.of(isbn);
    assertEquals(isbn, cleanIsbn.stringValue(), "ISBN13 not as expected");
   }


  /**
   * Test correct ISBN13.
   *
   * @param isbn ISBN13
   */
  @ParameterizedTest
  @ValueSource(strings = {"978-3-8362-7277-3", "978-1-61729-410-5"}) // "979-8-3291-7678-0"
  /* default */ void testIsbn13CorrectWithHyphen(final String isbn)
   {
    final ISBN13 cleanIsbn = ISBN13.of(isbn);
    assertEquals(isbn, cleanIsbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test correct ISBN13.
   *
   * @param isbn ISBN13
   */
  @ParameterizedTest
  @ValueSource(strings = {"978 3 8362 7277 3", "978 1 61729 410 5"}) // "979-8-3291-7678-0"
  /* default */ void testIsbn13CorrectWithSpace(final String isbn)
   {
    final ISBN13 cleanIsbn = ISBN13.of(isbn);
    assertEquals(isbn, cleanIsbn.stringHyphen().replace('-', ' '), "ISBN13 not as expected");
   }


  /**
   * Test correct ISBN13.
   */
  @Test
  /* default */ void testIsbn13IncorrectWithNull()
   {
    assertThrows(NullPointerException.class, () ->
     {
      /* final ISBN13 cleanIsbn = */ ISBN13.of(null);
     }, "Null pointer expected"
    );
   }


  /**
   * Test ISBN13 with wrong lengths.
   *
   * @param isbn ISBN13
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "9", "97", "978", "9783", "97838", "978383", "9783836", "97838362", "978383627", "9783836272", "97838362727", "978383627277", "978-3836272773", "978-3-836272773", "978-3-8362-72773"}) // 13 | 17
  /* default */ void testIsbnLength(final String isbn)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final ISBN13 cleanIsbn = */ ISBN13.of(isbn);
     }, "Wrong length expected"
    );
   }


  /**
   * Test wrong ISBN13.
   *
   * @param isbn ISBN13
   */
  @ParameterizedTest
  @ValueSource(strings = {"978383627277X", "978-3-8362-7A77-3", "978_3_8362_7277_3"})
  /* default */ void testIsbnWrongChars(final String isbn)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final ISBN13 cleanIsbn = */ ISBN13.of(isbn);
     }, "Illegal argument expected"
    );
   }


  /**
   * Test wrong ISBN13.
   *
   * @param isbn ISBN13
   */
  @ParameterizedTest
  @ValueSource(strings = {"978-3-8362-7277-0", "978-1-61729-410-9"})
  /* default */ void testIsbnWrongChecksum(final String isbn)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final ISBN13 cleanIsbn = */ ISBN13.of(isbn);
     }, "Illegal argument expected"
    );
   }


  /**
   * Test wrong ISBN13.
   *
   * @param isbn ISBN13
   */
  @ParameterizedTest
  @ValueSource(strings = {"977-3-8362-7277-4",})
  /* default */ void testIsbnWrongPrefix(final String isbn)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final ISBN13 cleanIsbn = */ ISBN13.of(isbn);
     }, "Illegal argument expected"
    );
   }


  /**
   * Test string value.
   */
  @Test
  /* default */ void testStringValue()
   {
    final ISBN13 isbn = ISBN13.of("978-3-8362-7277-3");
    assertEquals("9783836272773", isbn.stringValue(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  /* default */ void testStringWithHypenValue1()
   {
    final ISBN13 isbn = ISBN13.of("9783836272773");
    assertEquals("978-3-8362-7277-3", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  /* default */ void testStringWithHypenValue2()
   {
    final ISBN13 isbn = ISBN13.of("9780836272772");
    assertEquals("978-0-8362-7277-2", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  @Disabled("Unused at the moment")
  /* default */ void testStringWithHypenValue3()
   {
    final ISBN13 isbn = ISBN13.of("9785836272777");
    assertEquals("978-5-8362-7277-7", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  @Disabled("Unused at the moment")
  /* default */ void testStringWithHypenValue4()
   {
    final ISBN13 isbn = ISBN13.of("9787836272771");
    assertEquals("978-7-8362-7277-1", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  @Disabled("Unused at the moment")
  /* default */ void testStringWithHypenValue5()
   {
    final ISBN13 isbn = ISBN13.of("9788036272776");
    assertEquals("978-8-0362-7277-6", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  @Disabled("Unused at the moment")
  /* default */ void testStringWithHypenValue6()
   {
    final ISBN13 isbn = ISBN13.of("9788436272772");
    assertEquals("978-8-4362-7277-2", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  @Disabled("Unused at the moment")
  /* default */ void testStringWithHypenValue7()
   {
    final ISBN13 isbn = ISBN13.of("9789036272773");
    assertEquals("978-9-0362-7277-3", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  @Disabled("Unused at the moment")
  /* default */ void testStringWithHypenValue8()
   {
    final ISBN13 isbn = ISBN13.of("9789436272779");
    assertEquals("978-9-4362-7277-9", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  @Disabled("Unused at the moment")
  /* default */ void testStringWithHypenValue9()
   {
    final ISBN13 isbn = ISBN13.of("9786036272772");
    assertEquals("978-6-0362-7277-2", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  @Disabled("Unused at the moment")
  /* default */ void testStringWithHypenValue10()
   {
    final ISBN13 isbn = ISBN13.of("9786436272778");
    assertEquals("978-6-4362-7277-8", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  @Disabled("Unused at the moment")
  /* default */ void testStringWithHypenValue11()
   {
    final ISBN13 isbn = ISBN13.of("9789536272778");
    assertEquals("978-9-5362-7277-8", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  @Disabled("Unused at the moment")
  /* default */ void testStringWithHypenValue12()
   {
    final ISBN13 isbn = ISBN13.of("9789836272775");
    assertEquals("978-9-8362-7277-5", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  @Disabled("Unused at the moment")
  /* default */ void testStringWithHypenValue13()
   {
    final ISBN13 isbn = ISBN13.of("9789906272773");
    assertEquals("978-9-9062-7277-3", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  @Disabled("Unused at the moment")
  /* default */ void testStringWithHypenValue14()
   {
    final ISBN13 isbn = ISBN13.of("9789986272779");
    assertEquals("978-9-9862-7277-9", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  @Disabled("Unused at the moment")
  /* default */ void testStringWithHypenValue15()
   {
    final ISBN13 isbn = ISBN13.of("9789996272776");
    assertEquals("978-9-9962-7277-6", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  @Disabled("Unused at the moment")
  /* default */ void testStringWithHypenValue16()
   {
    final ISBN13 isbn = ISBN13.of("9791996272779");
    assertEquals("979-1-9962-7277-9", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Test string with hyphen value.
   */
  @Test
  @Disabled("Unused at the moment")
  /* default */ void testStringWithHypenValue17()
   {
    final ISBN13 isbn = ISBN13.of("9792996272776");
    assertEquals("979-2-9962-7277-6", isbn.stringHyphen(), "ISBN13 not as expected");
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(ISBN13.class).withNonnullFields("isbn13").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final ISBN13 isbn = ISBN13.of("978-3-8362-7277-3");
    assertEquals("ISBN13[isbn13=9783836272773]", isbn.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final ISBN13 isbn1 = ISBN13.of("978-1-61729-410-5");
    final ISBN13 isbn2 = ISBN13.of("978-1-61729-410-5");
    final ISBN13 isbn3 = ISBN13.of("978-3-8362-7277-3");
    final ISBN13 isbn4 = ISBN13.of("978-3-89650-485-2"); //$NON-NLS-1$
    final ISBN13 isbn5 = ISBN13.of("978-1-61729-410-5");
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(isbn1.compareTo(isbn2) == -isbn2.compareTo(isbn1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(isbn1.compareTo(isbn3) == -isbn3.compareTo(isbn1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((isbn4.compareTo(isbn3) > 0) && (isbn3.compareTo(isbn1) > 0) && (isbn4.compareTo(isbn1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((isbn1.compareTo(isbn2) == 0) && (Math.abs(isbn1.compareTo(isbn5)) == Math.abs(isbn2.compareTo(isbn5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((isbn1.compareTo(isbn2) == 0) && isbn1.equals(isbn2), "equals") //$NON-NLS-1$
    );
   }

 }
