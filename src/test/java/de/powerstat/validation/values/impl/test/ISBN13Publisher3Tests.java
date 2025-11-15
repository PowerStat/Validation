/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.impl.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.impl.ISBN13Publisher3;


/**
 * ISBN13 publisher 0 tests.
 */
final class ISBN13Publisher3Tests
 {
  /**
   * Default Constructor.
   */
  ISBN13Publisher3Tests()
   {
    super();
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testConstructor1()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    assertNotNull(publisher, "Publisher not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("001");
    assertEquals("00", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1a()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("021");
    assertEquals("02", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1b()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("041");
    assertEquals("04", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1c()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("051");
    assertEquals("05", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1d()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("061");
    assertEquals("06", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1e()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("071");
    assertEquals("07", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1f()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("081");
    assertEquals("08", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1g()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("091");
    assertEquals("09", result, "Result not as expected!");
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher1h()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("0X");
     }, "IllegalArgumentException expected!"
    );
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1i()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("0301");
    assertEquals("030", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1j()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("0311");
    assertEquals("031", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1k()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("0321");
    assertEquals("032", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1l()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("0331");
    assertEquals("033", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1m()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("03412");
    assertEquals("0341", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1n()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("03512");
    assertEquals("0351", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1o()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("03612");
    assertEquals("0361", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1p()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("037123");
    assertEquals("03712", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1q()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("038123");
    assertEquals("03812", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1r()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("039123");
    assertEquals("03912", result, "Result not as expected!");
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher1s()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("03X");
     }, "IllegalArgumentException expected!"
    );
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher2()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("112");
    assertEquals("11", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher3()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("2123");
    assertEquals("212", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher4()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("3123");
    assertEquals("312", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher6()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("4123");
    assertEquals("412", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher7()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("5123");
    assertEquals("512", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher8()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("6123");
    assertEquals("612", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("71234");
    assertEquals("7123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9a()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("80123");
    assertEquals("8012", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9b()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("81123");
    assertEquals("8112", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9c()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("82123");
    assertEquals("8212", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9d()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("83123");
    assertEquals("8312", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9e()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("84123");
    assertEquals("8412", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9f()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("851234");
    assertEquals("85123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9fa()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("861234");
    assertEquals("86123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9g()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("871234");
    assertEquals("87123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9h()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("881234");
    assertEquals("88123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9i()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("891234");
    assertEquals("89123", result, "Result not as expected!");
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher9j()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
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
  /* default */ void testPublisher9k()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("9012345");
    assertEquals("901234", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9l()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("9112345");
    assertEquals("911234", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9m()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("9212345");
    assertEquals("921234", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9n()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("9312345");
    assertEquals("931234", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9o()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("9412345");
    assertEquals("941234", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9oa()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("95012345");
    assertEquals("9501234", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9ob()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("95112345");
    assertEquals("9511234", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9oc()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("95212345");
    assertEquals("9521234", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9od()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("95312345");
    assertEquals("9531234", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9oe()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("954123");
    assertEquals("95412", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9of()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("955123");
    assertEquals("95512", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9og()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("956123");
    assertEquals("95612", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9oh()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("957123");
    assertEquals("95712", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9oi()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("958123");
    assertEquals("95812", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9oj()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("959123");
    assertEquals("95912", result, "Result not as expected!");
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher9ok()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("95X");
     }, "IllegalArgumentException expected!"
    );
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9q()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("961234");
    assertEquals("96123", result, "Result not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9r()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("97123456");
    assertEquals("9712345", result, "Result not as expected!");
   }

  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9s()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("98123456");
    assertEquals("9812345", result, "Result not as expected!");
   }

  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9t()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    String result = publisher.publisher("991234");
    assertEquals("99123", result, "Result not as expected!");
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher9u()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("9X");
     }, "IllegalArgumentException expected!"
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher10()
   {
    ISBN13Publisher3 publisher = new ISBN13Publisher3();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("X");
     }, "IllegalArgumentException expected!"
    );
   }

 }
