/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.impl.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.impl.ISBN13Publisher0;


/**
 * ISBN13 publisher 0 tests.
 */
final class ISBN13Publisher0Tests
 {
  /**
   * Result not as expected.
   */
  private static final String RESULT_NOT_AS_EXPECTED = "Result not as expected!";


  /**
   * Default Constructor.
   */
  /* default */ ISBN13Publisher0Tests()
   {
    super();
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testConstructor1()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    assertNotNull(publisher, "Publisher not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("012");
    assertEquals("01", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher2()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("112");
    assertEquals("11", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher3()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("2123");
    assertEquals("212", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher4()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("3123");
    assertEquals("312", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher6()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("4123");
    assertEquals("412", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher7()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("5123");
    assertEquals("512", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher8()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("6123");
    assertEquals("612", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("71234");
    assertEquals("7123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher10()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("X");
     }, "IllegalArgumentException expected!"
    );
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher11()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("80123");
    assertEquals("8012", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher12()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("81123");
    assertEquals("8112", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher13()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("82123");
    assertEquals("8212", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher14()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("83123");
    assertEquals("8312", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher15()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("84123");
    assertEquals("8412", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher16()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("851234");
    assertEquals("85123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher17()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("861234");
    assertEquals("86123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher18()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("861234");
    assertEquals("86123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher19()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("871234");
    assertEquals("87123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher20()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("881234");
    assertEquals("88123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher21()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("891234");
    assertEquals("89123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher22()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("8X");
     }, "IllegalArgumentException expected!"
    );
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher23()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("9012345");
    assertEquals("901234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher24()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("9112345");
    assertEquals("911234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher25()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("9212345");
    assertEquals("921234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher26()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("9312345");
    assertEquals("931234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher27()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("9412345");
    assertEquals("941234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher28()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("95123456");
    assertEquals("9512345", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher29()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("96123456");
    assertEquals("9612345", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("97123456");
    assertEquals("9712345", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher31()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("98123456");
    assertEquals("9812345", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher32()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    final String result = publisher.publisher("99123456");
    assertEquals("9912345", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher33()
   {
    final ISBN13Publisher0 publisher = new ISBN13Publisher0();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("9X");
     }, "IllegalArgumentException expected!"
    );
   }

 }
