/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
   * Block a.
   */
  private static final String BLOCKA = "A"; //$NON-NLS-1$

  /**
   * Block b.
   */
  private static final String BLOCKB = "B"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Block not as expected.
   */
  private static final String BLOCK_NOT_AS_EXPECTED = "Block not as expected"; //$NON-NLS-1$


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
  @ValueSource(strings = {"1", BlockTests.BLOCKA, "Abcdefghijklmnop"})
  public void blockCorrect(final String block)
   {
    final Block cleanBlock = Block.of(block);
    assertEquals(block, cleanBlock.block(), BlockTests.BLOCK_NOT_AS_EXPECTED);
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
     }, BlockTests.ILLEGAL_ARGUMENT
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
     }, BlockTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Block block1 = Block.of(BlockTests.BLOCKA);
    final Block block2 = Block.of(BlockTests.BLOCKA);
    final Block block3 = Block.of(BlockTests.BLOCKB);
    final Block block4 = Block.of("C"); //$NON-NLS-1$
    final Block block5 = Block.of(BlockTests.BLOCKA);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(block1.compareTo(block2) == -block2.compareTo(block1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(block1.compareTo(block3) == -block3.compareTo(block1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((block4.compareTo(block3) > 0) && (block3.compareTo(block1) > 0) && (block4.compareTo(block1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((block1.compareTo(block2) == 0) && (Math.abs(block1.compareTo(block5)) == Math.abs(block2.compareTo(block5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((block1.compareTo(block2) == 0) && block1.equals(block2), "equals") //$NON-NLS-1$
    );
   }

 }

