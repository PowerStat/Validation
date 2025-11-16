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
  /* default */ ISBN13Publisher3Tests()
   {
    super();
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testConstructor1()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    assertNotNull(publisher, "Publisher not as expected!");
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("001");
    assertEquals("00", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1a()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("021");
    assertEquals("02", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1b()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("041");
    assertEquals("04", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1c()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("051");
    assertEquals("05", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1d()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("061");
    assertEquals("06", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1e()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("071");
    assertEquals("07", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1f()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("081");
    assertEquals("08", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1g()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("091");
    assertEquals("09", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher1h()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("0X");
     }, ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1i()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("0301");
    assertEquals("030", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1j()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("0311");
    assertEquals("031", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1k()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("0321");
    assertEquals("032", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1l()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("0331");
    assertEquals("033", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1m()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("03412");
    assertEquals("0341", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1n()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("03512");
    assertEquals("0351", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1o()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("03612");
    assertEquals("0361", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1p()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("037123");
    assertEquals("03712", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1q()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("038123");
    assertEquals("03812", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher1r()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("039123");
    assertEquals("03912", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher1s()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("03X");
     }, ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher2()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("112");
    assertEquals("11", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher3()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("2123");
    assertEquals("212", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher4()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("3123");
    assertEquals("312", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher6()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("4123");
    assertEquals("412", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher7()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("5123");
    assertEquals("512", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher8()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("6123");
    assertEquals("612", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("71234");
    assertEquals("7123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9a()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("80123");
    assertEquals("8012", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9b()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("81123");
    assertEquals("8112", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9c()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("82123");
    assertEquals("8212", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9d()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("83123");
    assertEquals("8312", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9e()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("84123");
    assertEquals("8412", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9f()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("851234");
    assertEquals("85123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9fa()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("861234");
    assertEquals("86123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9g()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("871234");
    assertEquals("87123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9h()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("881234");
    assertEquals("88123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9i()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("891234");
    assertEquals("89123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher9j()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
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
  /* default */ void testPublisher9k()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("9012345");
    assertEquals("901234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9l()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("9112345");
    assertEquals("911234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9m()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("9212345");
    assertEquals("921234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9n()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("9312345");
    assertEquals("931234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9o()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("9412345");
    assertEquals("941234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9oa()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("95012345");
    assertEquals("9501234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9ob()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("95112345");
    assertEquals("9511234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9oc()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("95212345");
    assertEquals("9521234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9od()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("95312345");
    assertEquals("9531234", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9oe()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("954123");
    assertEquals("95412", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9of()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("955123");
    assertEquals("95512", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9og()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("956123");
    assertEquals("95612", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9oh()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("957123");
    assertEquals("95712", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9oi()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("958123");
    assertEquals("95812", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9oj()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("959123");
    assertEquals("95912", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher9ok()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("95X");
     }, ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9q()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("961234");
    assertEquals("96123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9r()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("97123456");
    assertEquals("9712345", result, RESULT_NOT_AS_EXPECTED);
   }

  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9s()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("98123456");
    assertEquals("9812345", result, RESULT_NOT_AS_EXPECTED);
   }

  /**
   * Test constructor.
   */
  @Test
  /* default */ void testPublisher9t()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    final String result = publisher.publisher("991234");
    assertEquals("99123", result, RESULT_NOT_AS_EXPECTED);
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher9u()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("9X");
     }, ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED
    );
   }


  /**
   * Test constructor failure.
   */
  @Test
  /* default */ void testPublisher10()
   {
    final ISBN13Publisher3 publisher = new ISBN13Publisher3();
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* String result = */ publisher.publisher("X");
     }, ILLEGAL_ARGUMENT_EXCEPTION_EXPECTED
    );
   }

 }
