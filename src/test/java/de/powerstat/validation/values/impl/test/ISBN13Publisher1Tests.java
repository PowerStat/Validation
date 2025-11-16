/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.impl.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.impl.ISBN13Publisher1;


/**
 * ISBN13 publisher 0 tests.
 */
final class ISBN13Publisher1Tests
 {
  /**
   * Illegal argument exception expected.
   */
  private static final String ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED = "IllegalArgumentException expected!";

  /**
   * Result not as expected.
   */
  private static final String RESULT_NOT_AS_EXPECTED = "Result not as expected!";


  /**
   * Default Constructor.
   */
  /* default */ ISBN13Publisher1Tests()
   {
    super();
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testConstructor1()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    assertNotNull(publisher, "Publisher not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("012");
    assertEquals("01", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher2()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("1123");
    assertEquals("112", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher3()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("2123");
    assertEquals("212", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher4()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("3123");
    assertEquals("312", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher6()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("41234");
    assertEquals("4123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher7()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("50123");
    assertEquals("5012", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher8()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("51123");
    assertEquals("5112", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("52123");
    assertEquals("5212", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9a()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("53123");
    assertEquals("5312", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9b()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("54123");
    assertEquals("5412", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9c()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("551234");
    assertEquals("55123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9d()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("561234");
    assertEquals("56123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9e()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("571234");
    assertEquals("57123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9f()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("581234");
    assertEquals("58123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9g()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("591234");
    assertEquals("59123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher10()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("5X");
     }, ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher11()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("612345");
    assertEquals("61234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher12()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("701234");
    assertEquals("70123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher13()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("801234");
    assertEquals("80123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher14()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("811234");
    assertEquals("81123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher15()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("821234");
    assertEquals("82123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher16()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("831234");
    assertEquals("83123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher17()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("841234");
    assertEquals("84123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher18()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("851234");
    assertEquals("85123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher19()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("8712345");
    assertEquals("871234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher20()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("8812345");
    assertEquals("881234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher20a()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("8912345");
    assertEquals("891234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher21()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("8X");
     }, ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher22()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("860123");
    assertEquals("86012", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher23()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("861123");
    assertEquals("86112", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher24()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("862123");
    assertEquals("86212", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher25()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("863123");
    assertEquals("86312", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher26()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("864123");
    assertEquals("86412", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher27()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("865123");
    assertEquals("86512", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher28()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("866123");
    assertEquals("86612", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher29()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("867123");
    assertEquals("86712", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher29a()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("868123");
    assertEquals("86812", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("869012");
    assertEquals("86901", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30a()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("869112");
    assertEquals("86911", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30b()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("869212");
    assertEquals("86921", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30c()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("869312");
    assertEquals("86931", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30d()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("869412");
    assertEquals("86941", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30e()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("869512");
    assertEquals("86951", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30f()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("869612");
    assertEquals("86961", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30g()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("869712");
    assertEquals("86971", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30h()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("8698123");
    assertEquals("869812", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30i()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("8699123");
    assertEquals("869912", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30ia()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("869112");
    assertEquals("86911", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30ib()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("869212");
    assertEquals("86921", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30ic()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("869312");
    assertEquals("86931", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30id()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("869412");
    assertEquals("86941", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30ie()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("869512");
    assertEquals("86951", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30if()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("869612");
    assertEquals("86961", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30ig()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("869712");
    assertEquals("86971", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30ih()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("8698123");
    assertEquals("869812", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30ii()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    final String result = publisher.publisher("8699123");
    assertEquals("869912", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher30ij()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("869X");
     }, ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher31()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("86X");
     }, ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher32()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("9");
     }, ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher33()
   {
    final ISBN13Publisher1 publisher = new ISBN13Publisher1();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("X");
     }, ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED
    );
   }

 }
