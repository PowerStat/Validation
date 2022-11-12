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

import de.powerstat.validation.values.Block;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Block tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class BlockTests
 {
  /**
   * Default constructor.
   */
  public BlockTests()
   {
    super();
   }


  /**
   * Test correct Block.
   *
   * @param block Block
   */
  @ParameterizedTest
  @ValueSource(strings = {"1", "A", "Abcdefghijklmnop"})
  public void blockCorrect(final String block)
   {
    final Block cleanBlock = Block.of(block);
    assertEquals(block, cleanBlock.getBlock(), "Block not as expected"); //$NON-NLS-1$
   }


  /**
   * Test Block with wrong lengths.
   *
   * @param block Block
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "Abcdefghijklmnopq"})
  public void blockLength(final String block)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Block cleanBlock = */ Block.of(block);
     }, "Illegal argument exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test wrong Block.
   *
   * @param block Block
   */
  @ParameterizedTest
  @ValueSource(strings = {"abc_def"})
  public void blockWrong(final String block)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Block cleanBlock = */ Block.of(block);
     }, "Illegal argument exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Test get block.
   */
  @Test
  public void getBlock()
   {
    final Block block = Block.of("A"); //$NON-NLS-1$
    assertEquals("A", block.getBlock(), "Block not as expected"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Block block1 = Block.of("A"); //$NON-NLS-1$
    final Block block2 = Block.of("A"); //$NON-NLS-1$
    final Block block3 = Block.of("B"); //$NON-NLS-1$
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(block1.hashCode(), block2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(block1.hashCode(), block3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Block block1 = Block.of("A"); //$NON-NLS-1$
    final Block block2 = Block.of("A"); //$NON-NLS-1$
    final Block block3 = Block.of("B"); //$NON-NLS-1$
    final Block block4 = Block.of("A"); //$NON-NLS-1$
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(block1.equals(block1), "block11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(block1.equals(block2), "block12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(block2.equals(block1), "block21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(block2.equals(block4), "block24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(block1.equals(block4), "block14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(block1.equals(block3), "block13 are equal"), //$NON-NLS-1$
      () -> assertFalse(block3.equals(block1), "block31 are equal"), //$NON-NLS-1$
      () -> assertFalse(block1.equals(null), "block10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Block block = Block.of("A");
    assertEquals("Block[block=A]", block.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Block block1 = Block.of("A"); //$NON-NLS-1$
    final Block block2 = Block.of("A"); //$NON-NLS-1$
    final Block block3 = Block.of("B"); //$NON-NLS-1$
    final Block block4 = Block.of("C"); //$NON-NLS-1$
    final Block block5 = Block.of("A"); //$NON-NLS-1$
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(block1.compareTo(block2) == -block2.compareTo(block1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(block1.compareTo(block3) == -block3.compareTo(block1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((block4.compareTo(block3) > 0) && (block3.compareTo(block1) > 0) && (block4.compareTo(block1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((block1.compareTo(block2) == 0) && (Math.abs(block1.compareTo(block5)) == Math.abs(block2.compareTo(block5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((block1.compareTo(block2) == 0) && block1.equals(block2), "equals") //$NON-NLS-1$
    );
   }

 }

