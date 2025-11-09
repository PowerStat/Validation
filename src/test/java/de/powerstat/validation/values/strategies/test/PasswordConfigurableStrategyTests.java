/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.strategies.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.strategies.IPasswordStrategy;
import de.powerstat.validation.values.strategies.PasswordConfigurableStrategy;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Password configurable strategy tests.
 */
@SuppressFBWarnings("PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS")
final class PasswordConfigurableStrategyTests
 {
  /**
   * Password pattern.
   */
  private static final String PWD_PATTERN = "^[@./_0-9a-zA-Z-]+$";

  /**
   * Password.
   */
  private static final String PWD_1234567890 = "1234567890";

  /**
   * Clean strategy not as expected.
   */
  private static final String CLEAN_STRATEGY_NOT_AS_EXPECTED = "cleanStrategy not as expected";

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT_EXCEPTION = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Dummy value 1.
   */
  private static final String DUMMY1 = "1111111111"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ PasswordConfigurableStrategyTests()
   {
    super();
   }


  /**
   * Test factory.
   */
  @Test
  /* default */ void testOf1()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(10, 13, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 0, 0);
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with minLength to short.
   */
  @Test
  /* default */ void testMinLengthToShort()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(0, 254, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 0, 0);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with maxLength &lt; minLength.
   */
  @Test
  /* default */ void testMaxSmallerThanMinLength()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(10, 9, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 0, 0);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with maxLength = minLength.
   */
  @Test
  /* default */ void testMaxEqualMinLength()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(10, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 0, 0);
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with caching.
   */
  @Test
  /* default */ void testCache()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(10, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 0, 0);
    final IPasswordStrategy cleanStrategy2 = PasswordConfigurableStrategy.of(10, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 0, 0);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED),
      () -> assertNotNull(cleanStrategy2, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test strategy with wrong regexp.
   */
  @Test
  /* default */ void testRegexpWrong1()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(1, 254, "[@./_0-9a-zA-Z-]+", 0, 0, 0, 0, 0, 0); //$NON-NLS-1$
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with wrong regexp.
   */
  @Test
  /* default */ void testRegexpWrong2()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(1, 254, "^[@./_0-9a-zA-Z-]+", 0, 0, 0, 0, 0, 0); //$NON-NLS-1$
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minNumeric negative.
   */
  @Test
  /* default */ void testMinNumericNegative()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(1, 254, PasswordConfigurableStrategyTests.PWD_PATTERN, -1, 0, 0, 0, 0, 0);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minNumeric maximum.
   */
  @Test
  /* default */ void testMinNumericMaximum()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(8, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 10, 0, 0, 0, 0, 0);
    cleanStrategy.validationStrategy(PasswordConfigurableStrategyTests.PWD_1234567890);
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with minNumeric greater than maxLength.
   */
  @Test
  /* default */ void testMinNumericGreaterMaxLength()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(8, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 11, 0, 0, 0, 0, 0);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minLower greater than maxLength.
   */
  @Test
  /* default */ void testMinLowerGreaterMaxLength()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(8, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 11, 0, 0, 0, 0);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minUpper greater than maxLength.
   */
  @Test
  /* default */ void testMinUpperGreaterMaxLength()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(8, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 11, 0, 0, 0);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minSpecial greater than maxLength.
   */
  @Test
  /* default */ void testMinSpecialGreaterMaxLength()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(8, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 11, 0, 0);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minUniue greater than maxLength.
   */
  @Test
  /* default */ void testMinUnqiueGreaterMaxLength()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(8, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 11, 0);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with maxRepeated greater than maxLength.
   */
  @Test
  /* default */ void testMaxRepeatedGreaterMaxLength()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(8, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 0, 11);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minNumeric failure.
   */
  @Test
  /* default */ void testNumericFailure()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(8, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 1, 0, 0, 0, 0, 0);
    assertThrows(IllegalArgumentException.class, () ->
     {
      cleanStrategy.validationStrategy("abcdefghij"); //$NON-NLS-1$
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minLower negative.
   */
  @Test
  /* default */ void testMinLowerNegative()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(1, 254, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, -1, 0, 0, 0, 0);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minLower maximum.
   */
  @Test
  /* default */ void testMinLowerMaximum()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(1, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 10, 0, 0, 0, 0);
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with minLower failure.
   */
  @Test
  /* default */ void testLowerFailure()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(8, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 1, 0, 0, 0, 0);
    assertThrows(IllegalArgumentException.class, () ->
     {
      cleanStrategy.validationStrategy(PasswordConfigurableStrategyTests.PWD_1234567890);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minUpper negative.
   */
  @Test
  /* default */ void testMinUpperNegative()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(1, 254, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, -1, 0, 0, 0);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minUpper maximum.
   */
  @Test
  /* default */ void testMinUpperMaximum()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(1, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 10, 0, 0, 0);
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with minUpper failure.
   */
  @Test
  /* default */ void testUpperFailure()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(8, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 1, 0, 0, 0);
    assertThrows(IllegalArgumentException.class, () ->
     {
      cleanStrategy.validationStrategy(PasswordConfigurableStrategyTests.PWD_1234567890);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minSpecial negative.
   */
  @Test
  /* default */ void testMinSpecialNegative()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(1, 254, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, -1, 0, 0);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minSpecial maximum.
   */
  @Test
  /* default */ void testMinSpecialMaximum()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(1, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 10, 0, 0);
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with minSpecial failure.
   */
  @Test
  /* default */ void testSpecialFailure()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(8, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 1, 0, 0);
    assertThrows(IllegalArgumentException.class, () ->
     {
      cleanStrategy.validationStrategy(PasswordConfigurableStrategyTests.PWD_1234567890);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minUnique negative.
   */
  @Test
  /* default */ void testMinUnqiueNegative()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(1, 254, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, -1, 0);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minUnique maximum.
   */
  @Test
  /* default */ void testMinUnqiueMaximum()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(1, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 10, 0);
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with minUnique failure.
   */
  @Test
  /* default */ void testUniqueFailure()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(8, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 2, 0);
    assertThrows(IllegalArgumentException.class, () ->
     {
      cleanStrategy.validationStrategy(PasswordConfigurableStrategyTests.DUMMY1);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with maxRepeated negative.
   */
  @Test
  /* default */ void testMaxRepeatedNegative()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(1, 254, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 0, -1);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with maxRepeated maximum.
   */
  @Test
  /* default */ void testMaxRepeatedMaximum()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(1, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 0, 10);
    cleanStrategy.validationStrategy(PasswordConfigurableStrategyTests.DUMMY1);
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with (minNumeric + minLower + minUpper + minSpecial) > maxLength.
   */
  @Test
  /* default */ void testSumWrong()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(1, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 3, 3, 3, 3, 0, 0);
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with (minNumeric + minLower + minUpper + minSpecial) == maxLength.
   */
  @Test
  /* default */ void testSumMaximum()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(1, 12, PasswordConfigurableStrategyTests.PWD_PATTERN, 3, 3, 3, 3, 0, 0);
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy.
   */
  @Test
  /* default */ void testSuccess()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(8, 12, PasswordConfigurableStrategyTests.PWD_PATTERN, 1, 1, 1, 1, 4, 1);
    cleanStrategy.validationStrategy("1aA@1aA@"); //$NON-NLS-1$
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with repeated characters.
   */
  @Test
  /* default */ void testRepeatedCharacters()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(8, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 0, 2);
    assertThrows(IllegalArgumentException.class, () ->
     {
      cleanStrategy.validationStrategy("aaaaaaaa"); //$NON-NLS-1$
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }

 }
