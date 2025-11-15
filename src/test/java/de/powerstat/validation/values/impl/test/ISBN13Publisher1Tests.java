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
   * Default Constructor.
   */
  ISBN13Publisher1Tests()
   {
    super();
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testConstructor1()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    assertNotNull(publisher, "Publisher not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("012");
    assertEquals("01", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher2()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("1123");
    assertEquals("112", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher3()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("2123");
    assertEquals("212", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher4()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("3123");
    assertEquals("312", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher6()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("41234");
    assertEquals("4123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher7()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("50123");
    assertEquals("5012", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher8()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("51123");
    assertEquals("5112", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("52123");
    assertEquals("5212", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9a()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("53123");
    assertEquals("5312", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9b()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("54123");
    assertEquals("5412", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9c()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("551234");
    assertEquals("55123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9d()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("561234");
    assertEquals("56123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9e()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("571234");
    assertEquals("57123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9f()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("581234");
    assertEquals("58123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9g()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("591234");
    assertEquals("59123", result, "Result not as expected!");
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher10()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("5X");
     }, "IllegalArgumentException expected!"
    );
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher11()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("612345");
    assertEquals("61234", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher12()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("701234");
    assertEquals("70123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher13()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("801234");
    assertEquals("80123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher14()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("811234");
    assertEquals("81123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher15()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("821234");
    assertEquals("82123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher16()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("831234");
    assertEquals("83123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher17()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("841234");
    assertEquals("84123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher18()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("851234");
    assertEquals("85123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher19()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("8712345");
    assertEquals("871234", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher20()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("8812345");
    assertEquals("881234", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher20a()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("8912345");
    assertEquals("891234", result, "Result not as expected!");
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher21()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
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
  /* default */ void testPublisher22()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("860123");
    assertEquals("86012", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher23()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("861123");
    assertEquals("86112", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher24()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("862123");
    assertEquals("86212", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher25()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("863123");
    assertEquals("86312", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher26()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("864123");
    assertEquals("86412", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher27()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("865123");
    assertEquals("86512", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher28()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("866123");
    assertEquals("86612", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher29()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("867123");
    assertEquals("86712", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher29a()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("868123");
    assertEquals("86812", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("869012");
    assertEquals("86901", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30a()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("869112");
    assertEquals("86911", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30b()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("869212");
    assertEquals("86921", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30c()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("869312");
    assertEquals("86931", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30d()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("869412");
    assertEquals("86941", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30e()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("869512");
    assertEquals("86951", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30f()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("869612");
    assertEquals("86961", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30g()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("869712");
    assertEquals("86971", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30h()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("8698123");
    assertEquals("869812", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30i()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("8699123");
    assertEquals("869912", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30ia()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("869112");
    assertEquals("86911", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30ib()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("869212");
    assertEquals("86921", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30ic()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("869312");
    assertEquals("86931", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30id()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("869412");
    assertEquals("86941", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30ie()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("869512");
    assertEquals("86951", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30if()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("869612");
    assertEquals("86961", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30ig()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("869712");
    assertEquals("86971", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30ih()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("8698123");
    assertEquals("869812", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher30ii()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    String result = publisher.publisher("8699123");
    assertEquals("869912", result, "Result not as expected!");
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher30ij()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("869X");
     }, "IllegalArgumentException expected!"
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher31()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("86X");
     }, "IllegalArgumentException expected!"
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher32()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("9");
     }, "IllegalArgumentException expected!"
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher33()
   {
    ISBN13Publisher1 publisher = new ISBN13Publisher1();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("X");
     }, "IllegalArgumentException expected!"
    );
   }

 }
