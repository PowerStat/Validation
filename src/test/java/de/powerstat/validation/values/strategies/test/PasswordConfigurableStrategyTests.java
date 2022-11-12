/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.strategies.test;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.strategies.IPasswordStrategy;
import de.powerstat.validation.values.strategies.PasswordConfigurableStrategy;


/**
 * Password configurable strategy tests.
 */
public class PasswordConfigurableStrategyTests
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
   * Default constructor.
   */
  public PasswordConfigurableStrategyTests()
   {
    super();
   }


  /**
   * Test strategy with minLength to short.
   */
  @Test
  public void minLengthToShort()
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
  public void maxSmallerThanMinLength()
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
  public void maxEqualMinLength()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(10, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 0, 0);
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with wrong regexp.
   */
  @Test
  public void regexpWrong()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IPasswordStrategy cleanStrategy = */ PasswordConfigurableStrategy.of(1, 254, "[@./_0-9a-zA-Z-]+", 0, 0, 0, 0, 0, 0); //$NON-NLS-1$
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minNumeric negative.
   */
  @Test
  public void minNumericNegative()
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
  public void minNumericMaximum()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(8, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 10, 0, 0, 0, 0, 0);
    cleanStrategy.validationStrategy(PasswordConfigurableStrategyTests.PWD_1234567890);
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with minNumeric failure.
   */
  @Test
  public void numericFailure()
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
  public void minLowerNegative()
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
  public void minLowerMaximum()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(1, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 10, 0, 0, 0, 0);
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with minLower failure.
   */
  @Test
  public void lowerFailure()
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
  public void minUpperNegative()
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
  public void minUpperMaximum()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(1, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 10, 0, 0, 0);
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with minUpper failure.
   */
  @Test
  public void upperFailure()
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
  public void minSpecialNegative()
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
  public void minSpecialMaximum()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(1, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 10, 0, 0);
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with minSpecial failure.
   */
  @Test
  public void specialFailure()
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
  public void minUnqiueNegative()
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
  public void minUnqiueMaximum()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(1, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 10, 0);
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with minUnique failure.
   */
  @Test
  public void uniqueFailure()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(8, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 2, 0);
    assertThrows(IllegalArgumentException.class, () ->
     {
      cleanStrategy.validationStrategy("1111111111"); //$NON-NLS-1$
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with maxRepeated negative.
   */
  @Test
  public void maxRepeatedNegative()
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
  public void maxRepeatedMaximum()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(1, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 0, 10);
    cleanStrategy.validationStrategy("1111111111"); //$NON-NLS-1$
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with (minNumeric + minLower + minUpper + minSpecial) > maxLength.
   */
  @Test
  public void sumWrong()
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
  public void sumMaximum()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(1, 12, PasswordConfigurableStrategyTests.PWD_PATTERN, 3, 3, 3, 3, 0, 0);
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy.
   */
  @Test
  public void success()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(8, 12, PasswordConfigurableStrategyTests.PWD_PATTERN, 1, 1, 1, 1, 4, 1);
    cleanStrategy.validationStrategy("1aA@1aA@"); //$NON-NLS-1$
    assertNotNull(cleanStrategy, PasswordConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with repeated characters.
   */
  @Test
  public void repeatedCharacters()
   {
    final IPasswordStrategy cleanStrategy = PasswordConfigurableStrategy.of(8, 10, PasswordConfigurableStrategyTests.PWD_PATTERN, 0, 0, 0, 0, 0, 2);
    assertThrows(IllegalArgumentException.class, () ->
     {
      cleanStrategy.validationStrategy("aaaaaaaa"); //$NON-NLS-1$
     }, PasswordConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }

 }
