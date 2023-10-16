/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
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

import de.powerstat.validation.values.Lines;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Lines tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class LinesTests
 {
  /**
   * Example 1.
   */
  private static final String EXAMPLE1 = "Example1"; //$NON-NLS-1$

  /**
   * Example 2.
   */
  private static final String EXAMPLE2 = "Example2"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Lines not as expected constant.
   */
  private static final String LINES_NOT_AS_EXPECTED = "Lines not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public LinesTests()
   {
    super();
   }


  /**
   * Test correct Lines.
   *
   * @param lines Lines
   */
  @ParameterizedTest
  @ValueSource(strings = {"A", "AbcdefghijklmnopqrstuvwxyzAbcdefghijklmnopqrstuvwxyzAbcdefghijklmnopqrstuvwxyzAbcdefghijklmnopqrstuvwxyzAbcdefghijklmnopqrstuvwxyzAbcdefghijklmnopqrstuvwxyzAbcdefghijklmnopqrstuvwxyzAbcdefghijklmnopqr", "1\n2\n3\n4\n5"})
  /* default */ void testLinesCorrect(final String lines)
   {
    final Lines cleanLines = Lines.of(lines);
    assertEquals(lines, cleanLines.stringValue(), LinesTests.LINES_NOT_AS_EXPECTED);
   }


  /**
   * Test Lines with wrong lengths.
   *
   * @param lines Lines
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "AbcdefghijklmnopqrstuvwxyzAbcdefghijklmnopqrstuvwxyzAbcdefghijklmnopqrstuvwxyzAbcdefghijklmnopqrstuvwxyzAbcdefghijklmnopqrstuvwxyzAbcdefghijklmnopqrstuvwxyzAbcdefghijklmnopqrstuvwxyzAbcdefghijklmnopqrs", "1\n2\n3\n4\n5\n6"})
  /* default */ void testLinesLength(final String lines)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Lines cleanLines = */ Lines.of(lines);
     }, LinesTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test wrong Lines.
   *
   * @param lines Lines
   */
  @ParameterizedTest
  @ValueSource(strings = {"abc_def"})
  /* default */ void testLinesWrong(final String lines)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Lines cleanLines = */ Lines.of(lines);
     }, LinesTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get lines.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Lines lines = Lines.of(LinesTests.EXAMPLE1);
    assertEquals(LinesTests.EXAMPLE1, lines.stringValue(), LinesTests.LINES_NOT_AS_EXPECTED);
   }


  /**
   * Test hash code.
   */
  @Test
  /* default */ void testHashCode()
   {
    final Lines lines1 = Lines.of(LinesTests.EXAMPLE1);
    final Lines lines2 = Lines.of(LinesTests.EXAMPLE1);
    final Lines lines3 = Lines.of(LinesTests.EXAMPLE2);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(lines1.hashCode(), lines2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(lines1.hashCode(), lines3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testEquals()
   {
    final Lines lines1 = Lines.of(LinesTests.EXAMPLE1);
    final Lines lines2 = Lines.of(LinesTests.EXAMPLE1);
    final Lines lines3 = Lines.of(LinesTests.EXAMPLE2);
    final Lines lines4 = Lines.of(LinesTests.EXAMPLE1);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(lines1.equals(lines1), "lines11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(lines1.equals(lines2), "lines12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(lines2.equals(lines1), "lines21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(lines2.equals(lines4), "lines24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(lines1.equals(lines4), "lines14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(lines1.equals(lines3), "lines13 are equal"), //$NON-NLS-1$
      () -> assertFalse(lines3.equals(lines1), "lines31 are equal"), //$NON-NLS-1$
      () -> assertFalse(lines1.equals(null), "lines10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Lines lines = Lines.of(LinesTests.EXAMPLE1);
    assertEquals("Lines[lines=Example1]", lines.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Lines lines1 = Lines.of(LinesTests.EXAMPLE1);
    final Lines lines2 = Lines.of(LinesTests.EXAMPLE1);
    final Lines lines3 = Lines.of(LinesTests.EXAMPLE2);
    final Lines lines4 = Lines.of("Example3"); //$NON-NLS-1$
    final Lines lines5 = Lines.of(LinesTests.EXAMPLE1);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(lines1.compareTo(lines2) == -lines2.compareTo(lines1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(lines1.compareTo(lines3) == -lines3.compareTo(lines1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((lines4.compareTo(lines3) > 0) && (lines3.compareTo(lines1) > 0) && (lines4.compareTo(lines1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((lines1.compareTo(lines2) == 0) && (Math.abs(lines1.compareTo(lines5)) == Math.abs(lines2.compareTo(lines5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((lines1.compareTo(lines2) == 0) && lines1.equals(lines2), "equals") //$NON-NLS-1$
    );
   }

 }

