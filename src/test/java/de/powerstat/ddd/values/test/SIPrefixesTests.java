/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import de.powerstat.ddd.values.SIPrefixes;


/**
 * SI prefixes tests.
 */
final class SIPrefixesTests
 {
  /**
   * Default constructor.
   */
  /* default */ SIPrefixesTests()
   {
    super();
   }


  /**
   * Factory string value test.
   */
  @Test
  /* default */ void testStringValue1()
   {
    assertEquals("GIGA", SIPrefixes.GIGA.stringValue(), "No prefix");
   }


  /**
   * Test getBase of SIPrefixes.
   */
  @Test
  /* default */ void testGetBase()
   {
    assertAll("constructor", //$NON-NLS-1$
      () -> assertEquals(-30, SIPrefixes.QUECTO.getBase(), "QUECTO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(-27, SIPrefixes.RONTO.getBase(), "RONTO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(-24, SIPrefixes.YOCTO.getBase(), "YOCTO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(-21, SIPrefixes.ZEPTO.getBase(), "ZEPTO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(-18, SIPrefixes.ATTO.getBase(), "ATTO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(-15, SIPrefixes.FEMTO.getBase(), "FEMTO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(-12, SIPrefixes.PICO.getBase(), "PICO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(-9, SIPrefixes.NANO.getBase(), "NANO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(-6, SIPrefixes.MICRO.getBase(), "MICRO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(-3, SIPrefixes.MILLI.getBase(), "MILLI base not as expected"), //$NON-NLS-1$
      () -> assertEquals(-2, SIPrefixes.CENTI.getBase(), "CENTI base not as expected"), //$NON-NLS-1$
      () -> assertEquals(-1, SIPrefixes.DECI.getBase(), "DECI base not as expected"), //$NON-NLS-1$
      () -> assertEquals(0, SIPrefixes.ZERO.getBase(), "ZERO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(1, SIPrefixes.DECA.getBase(), "DECA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(2, SIPrefixes.HECTO.getBase(), "HECTO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(3, SIPrefixes.KILO.getBase(), "KILO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(6, SIPrefixes.MEGA.getBase(), "MEGA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(9, SIPrefixes.GIGA.getBase(), "GIGA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(12, SIPrefixes.TERA.getBase(), "TERA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(15, SIPrefixes.PETA.getBase(), "PETA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(18, SIPrefixes.EXA.getBase(), "EXA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(21, SIPrefixes.ZETTA.getBase(), "ZETTA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(24, SIPrefixes.YOTTA.getBase(), "YOTTA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(27, SIPrefixes.RONNA.getBase(), "RONNA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(30, SIPrefixes.QUETTA.getBase(), "QUETTA base not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test hasNext of SIPrefixes.
   */
  @Test
  /* default */ void testHasNext()
   {
    assertAll("hasNext", //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.QUECTO.hasNext(), "QUECTO hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.RONTO.hasNext(), "RONTO hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.YOCTO.hasNext(), "YOCTO hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.ZEPTO.hasNext(), "ZEPTO hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.ATTO.hasNext(), "ATTO hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.FEMTO.hasNext(), "FEMTO hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.PICO.hasNext(), "PICO hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.NANO.hasNext(), "NANO hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.MICRO.hasNext(), "MICRO hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.MILLI.hasNext(), "MILLI hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.CENTI.hasNext(), "CENTI hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.DECI.hasNext(), "DECI hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.ZERO.hasNext(), "ZERO hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.DECA.hasNext(), "DECA hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.HECTO.hasNext(), "HECTO hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.KILO.hasNext(), "KILO hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.MEGA.hasNext(), "MEGA hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.GIGA.hasNext(), "GIGA hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.TERA.hasNext(), "TERA hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.PETA.hasNext(), "PETA hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.EXA.hasNext(), "EXA hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.ZETTA.hasNext(), "ZETTA hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.YOTTA.hasNext(), "YOTTA hasNext not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.RONNA.hasNext(), "RONNA hasNext not as expected"), //$NON-NLS-1$
      () -> assertFalse(SIPrefixes.QUETTA.hasNext(), "QUETTA hasNext not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test hasPrevious of SIPrefixes.
   */
  @Test
  /* default */ void testHasPrevious()
   {
    assertAll("hasPrevious", //$NON-NLS-1$
      () -> assertFalse(SIPrefixes.QUECTO.hasPrevious(), "QUECTO hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.RONTO.hasPrevious(), "RONTO hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.YOCTO.hasPrevious(), "YOCTO hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.ZEPTO.hasPrevious(), "ZEPTO hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.ATTO.hasPrevious(), "ATTO hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.FEMTO.hasPrevious(), "FEMTO hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.PICO.hasPrevious(), "PICO hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.NANO.hasPrevious(), "NANO hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.MICRO.hasPrevious(), "MICRO hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.MILLI.hasPrevious(), "MILLI hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.CENTI.hasPrevious(), "CENTI hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.DECI.hasPrevious(), "DECI hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.ZERO.hasPrevious(), "ZERO hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.DECA.hasPrevious(), "DECA hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.HECTO.hasPrevious(), "HECTO hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.KILO.hasPrevious(), "KILO hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.MEGA.hasPrevious(), "MEGA hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.GIGA.hasPrevious(), "GIGA hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.TERA.hasPrevious(), "TERA hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.PETA.hasPrevious(), "PETA hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.EXA.hasPrevious(), "EXA hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.ZETTA.hasPrevious(), "ZETTA hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.YOTTA.hasPrevious(), "YOTTA hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.RONNA.hasPrevious(), "RONNA hasPrevious not as expected"), //$NON-NLS-1$
      () -> assertTrue(SIPrefixes.QUETTA.hasPrevious(), "QUETTA hasPrevious not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test next overrun.
   */
  @Test
  /* default */ void testNextOverrun()
   {
    assertThrows(NoSuchElementException.class, () ->
     {
      SIPrefixes.QUETTA.next();
     }, "No such element exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test previous underrun.
   */
  @Test
  /* default */ void testPreviousUnderrun()
   {
    assertThrows(NoSuchElementException.class, () ->
     {
      SIPrefixes.QUECTO.previous();
     }, "No such element exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test next of SIPrefixes.
   */
  @Test
  /* default */ void testNext()
   {
    assertAll("next", //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.RONTO, SIPrefixes.QUECTO.next(), "QUECTO next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.YOCTO, SIPrefixes.RONTO.next(), "RONTO next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.ZEPTO, SIPrefixes.YOCTO.next(), "YOCTO next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.ATTO, SIPrefixes.ZEPTO.next(), "ZEPTO next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.FEMTO, SIPrefixes.ATTO.next(), "ATTO next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.PICO, SIPrefixes.FEMTO.next(), "FEMTO next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.NANO, SIPrefixes.PICO.next(), "PICO next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.MICRO, SIPrefixes.NANO.next(), "NANO next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.MILLI, SIPrefixes.MICRO.next(), "MICRO next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.CENTI, SIPrefixes.MILLI.next(), "MILLI next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.DECI, SIPrefixes.CENTI.next(), "CENTI next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.ZERO, SIPrefixes.DECI.next(), "DECI next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.DECA, SIPrefixes.ZERO.next(), "ZERO next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.HECTO, SIPrefixes.DECA.next(), "DECA next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.KILO, SIPrefixes.HECTO.next(), "HECTO next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.MEGA, SIPrefixes.KILO.next(), "KILO next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.GIGA, SIPrefixes.MEGA.next(), "MEGA next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.TERA, SIPrefixes.GIGA.next(), "GIGA next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.PETA, SIPrefixes.TERA.next(), "TERA next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.EXA, SIPrefixes.PETA.next(), "PETA next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.ZETTA, SIPrefixes.EXA.next(), "EXA next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.YOTTA, SIPrefixes.ZETTA.next(), "ZETTA next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.RONNA, SIPrefixes.YOTTA.next(), "YOTTA next not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.QUETTA, SIPrefixes.RONNA.next(), "RONNA next not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test previous of SIPrefixes.
   */
  @Test
  /* default */ void testPrevious()
   {
    assertAll("previous", //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.QUECTO, SIPrefixes.RONTO.previous(), "RONTO previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.RONTO, SIPrefixes.YOCTO.previous(), "YOCTO previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.YOCTO, SIPrefixes.ZEPTO.previous(), "ZEPTO previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.ZEPTO, SIPrefixes.ATTO.previous(), "ATTO previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.ATTO, SIPrefixes.FEMTO.previous(), "FEMTO previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.FEMTO, SIPrefixes.PICO.previous(), "PICO previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.PICO, SIPrefixes.NANO.previous(), "NANO previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.NANO, SIPrefixes.MICRO.previous(), "MICRO previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.MICRO, SIPrefixes.MILLI.previous(), "MILLI previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.MILLI, SIPrefixes.CENTI.previous(), "CENTI previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.CENTI, SIPrefixes.DECI.previous(), "DECI previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.DECI, SIPrefixes.ZERO.previous(), "ZERO previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.ZERO, SIPrefixes.DECA.previous(), "DECA previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.DECA, SIPrefixes.HECTO.previous(), "HECTO previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.HECTO, SIPrefixes.KILO.previous(), "KILO previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.KILO, SIPrefixes.MEGA.previous(), "MEGA previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.MEGA, SIPrefixes.GIGA.previous(), "GIGA previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.GIGA, SIPrefixes.TERA.previous(), "TERA previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.TERA, SIPrefixes.PETA.previous(), "PETA previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.PETA, SIPrefixes.EXA.previous(), "EXA previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.EXA, SIPrefixes.ZETTA.previous(), "ZETTA previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.ZETTA, SIPrefixes.YOTTA.previous(), "YOTTA previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.YOTTA, SIPrefixes.RONNA.previous(), "RONNA previous not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.RONNA, SIPrefixes.QUETTA.previous(), "QUETTA previous not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test first of SIPrefixes.
   */
  @Test
  /* default */ void testFirst()
   {
    assertEquals(SIPrefixes.QUECTO, SIPrefixes.first(), "first not as expected"); //$NON-NLS-1$
   }


  /**
   * Test last of SIPrefixes.
   */
  @Test
  /* default */ void testLast()
   {
    assertEquals(SIPrefixes.QUETTA, SIPrefixes.last(), "last not as expected"); //$NON-NLS-1$
   }


  /**
   * Test base of SIPrefixes.
   */
  @Test
  /* default */ void testBase()
   {
    assertEquals(SIPrefixes.ZERO, SIPrefixes.base(), "base not as expected"); //$NON-NLS-1$
   }


  /**
   * Test getName of SIPrefixes.
   */
  @Test
  /* default */ void testGetName()
   {
    assertAll("getName", //$NON-NLS-1$
      () -> assertEquals("quecto", SIPrefixes.QUECTO.getName(), "QUECTO name not as expected"), //$NON-NLS-1$
      () -> assertEquals("ronto", SIPrefixes.RONTO.getName(), "RONTO name not as expected"), //$NON-NLS-1$
      () -> assertEquals("yocto", SIPrefixes.YOCTO.getName(), "YOCTO name not as expected"), //$NON-NLS-1$
      () -> assertEquals("zepto", SIPrefixes.ZEPTO.getName(), "ZEPTO name not as expected"), //$NON-NLS-1$
      () -> assertEquals("atto", SIPrefixes.ATTO.getName(), "ATTO name not as expected"), //$NON-NLS-1$
      () -> assertEquals("femto", SIPrefixes.FEMTO.getName(), "FEMTO name not as expected"), //$NON-NLS-1$
      () -> assertEquals("pico", SIPrefixes.PICO.getName(), "PICO name not as expected"), //$NON-NLS-1$
      () -> assertEquals("nano", SIPrefixes.NANO.getName(), "NANO name not as expected"), //$NON-NLS-1$
      () -> assertEquals("micro", SIPrefixes.MICRO.getName(), "MICRO name not as expected"), //$NON-NLS-1$
      () -> assertEquals("milli", SIPrefixes.MILLI.getName(), "MILLI name not as expected"), //$NON-NLS-1$
      () -> assertEquals("centi", SIPrefixes.CENTI.getName(), "CENTI name not as expected"), //$NON-NLS-1$
      () -> assertEquals("deci", SIPrefixes.DECI.getName(), "DECI name not as expected"), //$NON-NLS-1$
      () -> assertEquals("", SIPrefixes.ZERO.getName(), "ZERO name not as expected"), //$NON-NLS-1$
      () -> assertEquals("deca", SIPrefixes.DECA.getName(), "DECA name not as expected"), //$NON-NLS-1$
      () -> assertEquals("hecto", SIPrefixes.HECTO.getName(), "HECTO name not as expected"), //$NON-NLS-1$
      () -> assertEquals("kilo", SIPrefixes.KILO.getName(), "KILO name not as expected"), //$NON-NLS-1$
      () -> assertEquals("mega", SIPrefixes.MEGA.getName(), "MEGA name not as expected"), //$NON-NLS-1$
      () -> assertEquals("giga", SIPrefixes.GIGA.getName(), "GIGA name not as expected"), //$NON-NLS-1$
      () -> assertEquals("tera", SIPrefixes.TERA.getName(), "TERA name not as expected"), //$NON-NLS-1$
      () -> assertEquals("peta", SIPrefixes.PETA.getName(), "PETA name not as expected"), //$NON-NLS-1$
      () -> assertEquals("exa", SIPrefixes.EXA.getName(), "EXA name not as expected"), //$NON-NLS-1$
      () -> assertEquals("zetta", SIPrefixes.ZETTA.getName(), "ZETTA name not as expected"), //$NON-NLS-1$
      () -> assertEquals("yotta", SIPrefixes.YOTTA.getName(), "YOTTA name not as expected"), //$NON-NLS-1$
      () -> assertEquals("ronna", SIPrefixes.RONNA.getName(), "RONNA name not as expected"), //$NON-NLS-1$
      () -> assertEquals("quetta", SIPrefixes.QUETTA.getName(), "QUETTA name not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test getSymbol of SIPrefixes.
   */
  @Test
  /* default */ void testGetSymbol()
   {
    assertAll("getSymbol", //$NON-NLS-1$
      () -> assertEquals("q", SIPrefixes.QUECTO.getSymbol(), "QUECTO symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("r", SIPrefixes.RONTO.getSymbol(), "RONTO symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("y", SIPrefixes.YOCTO.getSymbol(), "YOCTO symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("z", SIPrefixes.ZEPTO.getSymbol(), "ZEPTO symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("a", SIPrefixes.ATTO.getSymbol(), "ATTO symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("f", SIPrefixes.FEMTO.getSymbol(), "FEMTO symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("p", SIPrefixes.PICO.getSymbol(), "PICO symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("n", SIPrefixes.NANO.getSymbol(), "NANO symbol not as expected"), //$NON-NLS-1$
      // () -> assertEquals("μ", SIPrefixes.MICRO.getSymbol(), "MICRO symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("m", SIPrefixes.MILLI.getSymbol(), "MILLI symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("c", SIPrefixes.CENTI.getSymbol(), "CENTI symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("d", SIPrefixes.DECI.getSymbol(), "DECI symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("", SIPrefixes.ZERO.getSymbol(), "ZERO symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("da", SIPrefixes.DECA.getSymbol(), "DECA symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("h", SIPrefixes.HECTO.getSymbol(), "HECTO symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("k", SIPrefixes.KILO.getSymbol(), "KILO symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("M", SIPrefixes.MEGA.getSymbol(), "MEGA symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("G", SIPrefixes.GIGA.getSymbol(), "GIGA symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("T", SIPrefixes.TERA.getSymbol(), "TERA symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("P", SIPrefixes.PETA.getSymbol(), "PETA symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("E", SIPrefixes.EXA.getSymbol(), "EXA symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("Z", SIPrefixes.ZETTA.getSymbol(), "ZETTA symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("Y", SIPrefixes.YOTTA.getSymbol(), "YOTTA symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("R", SIPrefixes.RONNA.getSymbol(), "RONNA symbol not as expected"), //$NON-NLS-1$
      () -> assertEquals("Q", SIPrefixes.QUETTA.getSymbol(), "QUETTA symbol not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test byBase exception.
   */
  @Test
  /* default */ void testByBaseException()
   {
    assertThrows(NoSuchElementException.class, () ->
     {
      SIPrefixes.byBase(-4);
     }, "No such element exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test byBase of SIPrefixes.
   */
  @Test
  /* default */ void testByBase()
   {
    assertAll("byBase", //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.QUECTO, SIPrefixes.byBase(-30), "QUECTO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.RONTO, SIPrefixes.byBase(-27), "RONTO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.YOCTO, SIPrefixes.byBase(-24), "YOCTO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.ZEPTO, SIPrefixes.byBase(-21), "ZEPTO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.ATTO, SIPrefixes.byBase(-18), "ATTO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.FEMTO, SIPrefixes.byBase(-15), "FEMTO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.PICO, SIPrefixes.byBase(-12), "PICO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.NANO, SIPrefixes.byBase(-9), "NANO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.MICRO, SIPrefixes.byBase(-6), "MICRO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.MILLI, SIPrefixes.byBase(-3), "MILLI base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.CENTI, SIPrefixes.byBase(-2), "CENTI base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.DECI, SIPrefixes.byBase(-1), "DECI base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.ZERO, SIPrefixes.byBase(0), "ZERO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.DECA, SIPrefixes.byBase(1), "DECA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.HECTO, SIPrefixes.byBase(2), "HECTO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.KILO, SIPrefixes.byBase(3), "KILO base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.MEGA, SIPrefixes.byBase(6), "MEGA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.GIGA, SIPrefixes.byBase(9), "GIGA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.TERA, SIPrefixes.byBase(12), "TERA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.PETA, SIPrefixes.byBase(15), "PETA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.EXA, SIPrefixes.byBase(18), "EXA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.ZETTA, SIPrefixes.byBase(21), "ZETTA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.YOTTA, SIPrefixes.byBase(24), "YOTTA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.RONNA, SIPrefixes.byBase(27), "RONNA base not as expected"), //$NON-NLS-1$
      () -> assertEquals(SIPrefixes.QUETTA, SIPrefixes.byBase(30), "QUETTA base not as expected") //$NON-NLS-1$
    );
   }

 }
