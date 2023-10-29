/*
 * Copyright (C) 2022-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.containers.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.containers.HistoryOf;
import de.powerstat.validation.values.Lastname;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * HistoryOf tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR", "CE_CLASS_ENVY"})
@SuppressWarnings("java:S2925")
final class HistoryOfTests
 {
  /**
   * Lastname constant.
   */
  private static final String HOFMANN = "Hofmann"; //$NON-NLS-1$

  /**
   * Lastname constant.
   */
  private static final String LASTNAME = "Lastname"; //$NON-NLS-1$

  /**
   * Test has code constant.
   */
  private static final String TEST_HASH_CODE = "testHashCode"; //$NON-NLS-1$

  /**
   * toString not equal constant.
   */
  private static final String TO_STRING_NOT_EQUAL = "toString not equal"; //$NON-NLS-1$

  /**
   * Null pointer exception expected constant.
   */
  private static final String NULL_POINTER_EXCEPTION = "Null pointer exception expected"; //$NON-NLS-1$

  /**
   * No such element exception expected constant.
   */
  private static final String NO_SUCH_ELEMENT_EXCEPTION = "No such element exception expected"; //$NON-NLS-1$

  /**
   * History of value constant.
   */
  private static final String HISTORY_OF1 = "HistoryOf<>[2022-01-13T20:25:00+01:00=Lastname[lastname=Hofmann]]"; //$NON-NLS-1$

  /**
   * GetFirstEntry result is wrong constant.
   */
  private static final String GET_FIRST_ENTRY = "GetFirstEntry result is wrong!"; //$NON-NLS-1$

  /**
   * GetLatestEntry result is wrong constant.
   */
  private static final String GET_LATEST_ENTRY = "GetLatestEntry result is wrong!"; //$NON-NLS-1$

  /**
   * GetPreviousEntry result is wrong constant.
   */
  private static final String GET_PREVIOUS_ENTRY = "GetPreviousEntry result is wrong!"; //$NON-NLS-1$

  /**
   * History not as expected constant.
   */
  private static final String HISTORY_NOT_AS_EXPECTED = "History not as expected!"; //$NON-NLS-1$

  /**
   * History correct constant.
   */
  private static final String HISTORY_CORRECT = "History correct!"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public HistoryOfTests()
   {
    super();
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testConstructor1()
   {
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    assertNotNull(lastname, "Constructor failed!"); //$NON-NLS-1$
   }


  /**
   * Hash code test.
   */
  @Test
  /* default */ void testHashCode1()
   {
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    final int hc1 = lastname.hashCode();
    lastname.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.HOFMANN));
    final int hc2 = lastname.hashCode();
    assertAll(HistoryOfTests.TEST_HASH_CODE,
      () -> assertEquals(0, hc1, "hc1 not as expected"), //$NON-NLS-1$
      () -> assertEquals(-1543832814, hc2, "hc2 not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Hash code test.
   */
  @Test
  /* default */ void testHashCode2()
   {
    final HistoryOf<Lastname> lastname1 = new HistoryOf<>();
    lastname1.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.HOFMANN));
    final HistoryOf<Lastname> lastname2 = new HistoryOf<>();
    lastname2.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.HOFMANN));
    final HistoryOf<Lastname> lastname3 = new HistoryOf<>();
    lastname3.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.LASTNAME));
    assertAll(HistoryOfTests.TEST_HASH_CODE,
      () -> assertEquals(lastname1.hashCode(), lastname2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(lastname1.hashCode(), lastname3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testEquals()
   {
    final HistoryOf<Lastname> lastname1 = new HistoryOf<>();
    lastname1.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.HOFMANN));
    final HistoryOf<Lastname> lastname2 = new HistoryOf<>();
    lastname2.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.HOFMANN));
    final HistoryOf<Lastname> lastname3 = new HistoryOf<>();
    lastname3.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.LASTNAME));
    final HistoryOf<Lastname> lastname4 = new HistoryOf<>();
    lastname4.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.HOFMANN));
    final HistoryOf<Lastname> lastname5 = new HistoryOf<>();
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(lastname1.equals(lastname1), "lastname11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(lastname1.equals(lastname2), "lastname12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(lastname2.equals(lastname1), "lastname21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(lastname2.equals(lastname4), "lastname24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(lastname1.equals(lastname4), "lastname14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(lastname1.equals(lastname3), "lastname13 are equal"), //$NON-NLS-1$
      () -> assertFalse(lastname3.equals(lastname1), "lastname31 are equal"), //$NON-NLS-1$
      () -> assertFalse(lastname1.equals(null), "lastname10 is equal"), //$NON-NLS-1$
      () -> assertFalse(lastname1.equals(new Object()), "lastname1obj is equal"), //$NON-NLS-1$
      () -> assertFalse(lastname1.equals(lastname5), "lastname15 is equal"), //$NON-NLS-1$
      () -> assertFalse(lastname5.equals(lastname1), "lastname51 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    final OffsetDateTime datetime = OffsetDateTime.of(2022, 1, 13, 20, 25, 0, 0, ZoneOffset.ofHours(1));
    lastname.addEntry(datetime, Lastname.of(HistoryOfTests.HOFMANN));
    assertEquals(HistoryOfTests.HISTORY_OF1, lastname.toString(), HistoryOfTests.TO_STRING_NOT_EQUAL);
   }


  /**
   * Test addEntry.
   */
  @Test
  /* default */ void testAddEntry1()
   {
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    final OffsetDateTime datetime = OffsetDateTime.of(2022, 1, 13, 20, 25, 0, 0, ZoneOffset.ofHours(1));
    lastname.addEntry(datetime, Lastname.of(HistoryOfTests.HOFMANN));
    assertEquals(HistoryOfTests.HISTORY_OF1, lastname.toString(), HistoryOfTests.TO_STRING_NOT_EQUAL);
   }


  /**
   * Test addEntry.
   */
  @Test
  /* default */ void testAddEntry2()
   {
    final HistoryOf<Lastname> lastnameHistory = new HistoryOf<>();
    final Lastname lastname = Lastname.of(HistoryOfTests.HOFMANN);
    assertThrows(NullPointerException.class, () ->
     {
      lastnameHistory.addEntry(null, lastname);
     }, HistoryOfTests.NULL_POINTER_EXCEPTION
    );
   }


  /**
   * Test addEntry.
   */
  @Test
  /* default */ void testAddEntry3()
   {
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    final OffsetDateTime now = OffsetDateTime.now();
    assertThrows(NullPointerException.class, () ->
     {
      lastname.addEntry(now, null);
     }, HistoryOfTests.NULL_POINTER_EXCEPTION
    );
   }


  /**
   * Test addEntry.
   */
  @Test
  /* default */ void testAddEntry4()
   {
    final HistoryOf<Lastname> lastnameHistory = new HistoryOf<>();
    final OffsetDateTime nowPlusOneDay = OffsetDateTime.now().plusDays(1);
    final Lastname lastname = Lastname.of(HistoryOfTests.HOFMANN);
    assertThrows(IndexOutOfBoundsException.class, () ->
     {
      lastnameHistory.addEntry(nowPlusOneDay, lastname);
     }, "Index out of bounds exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test addEntry.
   */
  @Test
  /* default */ void testAddEntry5()
   {
    final HistoryOf<Lastname> lastnameHistory = new HistoryOf<>();
    lastnameHistory.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.HOFMANN));
    final OffsetDateTime now = OffsetDateTime.now();
    final Lastname lastname = Lastname.of(HistoryOfTests.HOFMANN);
    assertThrows(IllegalArgumentException.class, () ->
     {
      lastnameHistory.addEntry(now, lastname);
     }, "Illegal argument exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test getFirstEntry.
   */
  @Test
  /* default */ void testGetFirstEntry1()
   {
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    lastname.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.HOFMANN));
    final Lastname name = lastname.getFirstEntry();
    assertEquals(HistoryOfTests.HOFMANN, name.stringValue(), HistoryOfTests.GET_FIRST_ENTRY);
   }


  /**
   * Test getFirstEntry.
   *
   * @throws InterruptedException Interrupted sleep
   */
  @Test
  /* default */ void testGetFirstEntry2() throws InterruptedException
   {
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    lastname.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.LASTNAME));
    TimeUnit.MICROSECONDS.sleep(1);
    lastname.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.HOFMANN));
    final Lastname name = lastname.getFirstEntry();
    assertEquals(HistoryOfTests.LASTNAME, name.stringValue(), HistoryOfTests.GET_FIRST_ENTRY);
   }


  /**
   * Test getFirstEntry.
   */
  @Test
  /* default */ void testGetFirstEntry3()
   {
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    assertThrows(NoSuchElementException.class, () ->
     {
      /* final Lastname name = */ lastname.getFirstEntry();
     }, HistoryOfTests.NO_SUCH_ELEMENT_EXCEPTION
    );
   }


  /**
   * Test getLastEntry.
   */
  @Test
  /* default */ void testGetLatestEntry1()
   {
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    lastname.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.HOFMANN));
    final Lastname name = lastname.getLatestEntry();
    assertEquals(HistoryOfTests.HOFMANN, name.stringValue(), HistoryOfTests.GET_LATEST_ENTRY);
   }


  /**
   * Test getLatestEntry.
   *
   * @throws InterruptedException Interrupted sleep
   */
  @Test
  /* default */ void testGetLatestEntry2() throws InterruptedException
   {
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    lastname.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.LASTNAME));
    TimeUnit.MICROSECONDS.sleep(1);
    lastname.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.HOFMANN));
    final Lastname name = lastname.getLatestEntry();
    assertEquals(HistoryOfTests.HOFMANN, name.stringValue(), HistoryOfTests.GET_LATEST_ENTRY);
   }


  /**
   * Test getLatestEntry.
   */
  @Test
  /* default */ void testGetLatestEntry3()
   {
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    assertThrows(NoSuchElementException.class, () ->
     {
      /* final Lastname name = */ lastname.getLatestEntry();
     }, HistoryOfTests.NO_SUCH_ELEMENT_EXCEPTION
    );
   }


  /**
   * Test getPreviousEntry.
   */
  @Test
  /* default */ void testGetPreviousEntry1()
   {
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    lastname.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.HOFMANN));
    final Lastname name = lastname.getPreviousEntry();
    assertEquals(HistoryOfTests.HOFMANN, name.stringValue(), HistoryOfTests.GET_PREVIOUS_ENTRY);
   }


  /**
   * Test getPreviousEntry.
   *
   * @throws InterruptedException Interrupted sleep
   */
  @Test
  /* default */ void testGetPreviousEntry2() throws InterruptedException
   {
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    lastname.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.LASTNAME));
    TimeUnit.MICROSECONDS.sleep(1);
    lastname.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.HOFMANN));
    final Lastname name = lastname.getPreviousEntry();
    assertEquals(HistoryOfTests.LASTNAME, name.stringValue(), HistoryOfTests.GET_PREVIOUS_ENTRY);
   }


  /**
   * Test getPreviousEntry.
   */
  @Test
  /* default */ void testGetPreviousEntry3()
   {
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    assertThrows(NoSuchElementException.class, () ->
     {
      /* final Lastname name = */ lastname.getPreviousEntry();
     }, HistoryOfTests.NO_SUCH_ELEMENT_EXCEPTION
    );
   }


  /**
   * Test getHistory.
   */
  @Test
  /* default */ void testGetHistory1()
   {
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    final SortedMap<OffsetDateTime, Lastname> history = lastname.getHistory();
    assertTrue(history.isEmpty(), "History not empty!"); //$NON-NLS-1$
   }


  /**
   * Test getHistory.
   */
  @Test
  /* default */ void testGetHistory2()
   {
    final List<Lastname> expected = new ArrayList<>();
    expected.add(Lastname.of(HistoryOfTests.HOFMANN));
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    lastname.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.HOFMANN));
    final SortedMap<OffsetDateTime, Lastname> history = lastname.getHistory();
    assertEquals(1, history.size(), HistoryOfTests.HISTORY_CORRECT);
    assertIterableEquals(expected, history.values(), HistoryOfTests.HISTORY_NOT_AS_EXPECTED);
   }


  /**
   * Test getHistory.
   *
   * @throws InterruptedException Interrupted sleep
   */
  @Test
  /* default */ void testGetHistory3() throws InterruptedException
   {
    final List<Lastname> expected = new ArrayList<>();
    expected.add(Lastname.of(HistoryOfTests.HOFMANN));
    expected.add(Lastname.of(HistoryOfTests.LASTNAME));
    final HistoryOf<Lastname> lastname = new HistoryOf<>();
    lastname.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.HOFMANN));
    TimeUnit.MICROSECONDS.sleep(1);
    lastname.addEntry(OffsetDateTime.now(), Lastname.of(HistoryOfTests.LASTNAME));
    final SortedMap<OffsetDateTime, Lastname> history = lastname.getHistory();
    assertEquals(2, history.size(), HistoryOfTests.HISTORY_CORRECT);
    assertIterableEquals(expected, history.values(), HistoryOfTests.HISTORY_NOT_AS_EXPECTED);
   }

 }
