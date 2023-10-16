/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.strategies.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.strategies.IUsernameStrategy;
import de.powerstat.validation.values.strategies.UsernameConfigurableStrategy;
import de.powerstat.validation.values.strategies.UsernameConfigurableStrategy.HandleEMail;


/**
 * Username configurable strategy tests.
 */
final class UsernameConfigurableStrategyTests
 {
  /**
   * Match pattern 1.
   */
  private static final String PATTERN1 = "^[@./_0-9a-zA-Z-]+$"; //$NON-NLS-1$

  /**
   * Match pattern 2.
   */
  private static final String PATTERN2 = "^[@./_0-9a-zA-Z-]*$"; //$NON-NLS-1$

  /**
   * Username constant.
   */
  private static final String USERNAME = "username"; //$NON-NLS-1$

  /**
   * EMail address constant.
   */
  private static final String USERNAME_EXAMPLE_COM = "username@example.com"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT_EXCEPTION = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * cleanStrategy not as expected constant.
   */
  private static final String CLEAN_STRATEGY_NOT_AS_EXPECTED = "cleanStrategy not as expected"; //$NON-NLS-1$

  /**
   * Null pointer exception constanr.
   */
  private static final String NULL_POINTER_EXCEPTION = "Null pointer exception"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public UsernameConfigurableStrategyTests()
   {
    super();
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testConstructor1()
   {
    assertThrows(NullPointerException.class, () ->
     {
      /* final IUsernameStrategy cleanStrategy = */ UsernameConfigurableStrategy.of(0, 254, null, HandleEMail.EMAIL_POSSIBLE);
     }, UsernameConfigurableStrategyTests.NULL_POINTER_EXCEPTION
    );
   }


  /**
   * Test constructor.
   */
  @Test
  /* default */ void testConstructor2()
   {
    assertThrows(NullPointerException.class, () ->
     {
      /* final IUsernameStrategy cleanStrategy = */ UsernameConfigurableStrategy.of(0, 254, UsernameConfigurableStrategyTests.PATTERN2, null);
     }, UsernameConfigurableStrategyTests.NULL_POINTER_EXCEPTION
    );
   }


  /**
   * Test strategy with minLength to short.
   */
  @Test
  /* default */ void testMinLengthToShort()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IUsernameStrategy cleanStrategy = */ UsernameConfigurableStrategy.of(-1, 254, UsernameConfigurableStrategyTests.PATTERN2, HandleEMail.EMAIL_POSSIBLE);
     }, UsernameConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with minLength zero.
   */
  @Test
  /* default */ void testMinLengthZero()
   {
    final IUsernameStrategy cleanStrategy = UsernameConfigurableStrategy.of(0, 254, UsernameConfigurableStrategyTests.PATTERN2, HandleEMail.EMAIL_POSSIBLE);
    assertNotNull(cleanStrategy, UsernameConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with maxLength &lt; minLength.
   */
  @Test
  /* default */ void testMaxSmallerThanMinLength()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IUsernameStrategy cleanStrategy = */ UsernameConfigurableStrategy.of(10, 9, UsernameConfigurableStrategyTests.PATTERN1, HandleEMail.EMAIL_POSSIBLE);
     }, UsernameConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with maxLength = minLength.
   */
  @Test
  /* default */ void testMaxEqualMinLength()
   {
    final IUsernameStrategy cleanStrategy = UsernameConfigurableStrategy.of(10, 10, UsernameConfigurableStrategyTests.PATTERN1, HandleEMail.EMAIL_POSSIBLE);
    assertNotNull(cleanStrategy, UsernameConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with wrong regexp.
   */
  @Test
  /* default */ void testRegexpWrong1()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final IUsernameStrategy cleanStrategy = */ UsernameConfigurableStrategy.of(1, 254, "[@./_0-9a-zA-Z-]+", HandleEMail.EMAIL_REQUIRED); //$NON-NLS-1$
     }, UsernameConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
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
      /* final IUsernameStrategy cleanStrategy = */ UsernameConfigurableStrategy.of(1, 254, "^[@./_0-9a-zA-Z-]+", HandleEMail.EMAIL_REQUIRED); //$NON-NLS-1$
     }, UsernameConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with email denied.
   */
  @Test
  /* default */ void testUsernameEMailDenied1()
   {
    final IUsernameStrategy cleanStrategy = UsernameConfigurableStrategy.of(1, 254, UsernameConfigurableStrategyTests.PATTERN1, HandleEMail.EMAIL_DENIED);
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* boolean email = */ cleanStrategy.validationStrategy(UsernameConfigurableStrategyTests.USERNAME_EXAMPLE_COM);
     }, UsernameConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with email denied.
   */
  @Test
  /* default */ void testUsernameEMailDenied2()
   {
    final IUsernameStrategy cleanStrategy = UsernameConfigurableStrategy.of(1, 254, UsernameConfigurableStrategyTests.PATTERN1, HandleEMail.EMAIL_DENIED);
    final boolean email = cleanStrategy.validationStrategy(UsernameConfigurableStrategyTests.USERNAME);
    assertFalse(email, "email validated"); //$NON-NLS-1$
   }


  /**
   * Test strategy with email required.
   */
  @Test
  /* default */ void testUsernameEMailRequired1()
   {
    final IUsernameStrategy cleanStrategy = UsernameConfigurableStrategy.of(1, 254, UsernameConfigurableStrategyTests.PATTERN1, HandleEMail.EMAIL_REQUIRED);
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* boolean email = */ cleanStrategy.validationStrategy(UsernameConfigurableStrategyTests.USERNAME);
     }, UsernameConfigurableStrategyTests.ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Test strategy with email required.
   */
  @Test
  /* default */ void testUsernameEMailRequired2()
   {
    final IUsernameStrategy cleanStrategy = UsernameConfigurableStrategy.of(1, 254, UsernameConfigurableStrategyTests.PATTERN1, HandleEMail.EMAIL_REQUIRED);
    final boolean email = cleanStrategy.validationStrategy(UsernameConfigurableStrategyTests.USERNAME_EXAMPLE_COM);
    assertTrue(email, "email not validated"); //$NON-NLS-1$
   }


  /**
   * Test getAction of HandleEMail.
   */
  @Test
  /* default */ void testGetAction()
   {
    assertEquals(1, HandleEMail.EMAIL_REQUIRED.getAction(), "Action not as expected"); //$NON-NLS-1$
   }

 }
