/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
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
public class UsernameConfigurableStrategyTests
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
  public void constructor1()
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
  public void constructor2()
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
  public void minLengthToShort()
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
  public void minLengthZero()
   {
    final IUsernameStrategy cleanStrategy = UsernameConfigurableStrategy.of(0, 254, UsernameConfigurableStrategyTests.PATTERN2, HandleEMail.EMAIL_POSSIBLE);
    assertNotNull(cleanStrategy, UsernameConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with maxLength &lt; minLength.
   */
  @Test
  public void maxSmallerThanMinLength()
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
  public void maxEqualMinLength()
   {
    final IUsernameStrategy cleanStrategy = UsernameConfigurableStrategy.of(10, 10, UsernameConfigurableStrategyTests.PATTERN1, HandleEMail.EMAIL_POSSIBLE);
    assertNotNull(cleanStrategy, UsernameConfigurableStrategyTests.CLEAN_STRATEGY_NOT_AS_EXPECTED);
   }


  /**
   * Test strategy with wrong regexp.
   */
  @Test
  public void regexpWrong1()
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
  public void regexpWrong2()
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
  public void usernameEMailDenied1()
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
  public void usernameEMailDenied2()
   {
    final IUsernameStrategy cleanStrategy = UsernameConfigurableStrategy.of(1, 254, UsernameConfigurableStrategyTests.PATTERN1, HandleEMail.EMAIL_DENIED);
    final boolean email = cleanStrategy.validationStrategy(UsernameConfigurableStrategyTests.USERNAME);
    assertFalse(email, "email validated"); //$NON-NLS-1$
   }


  /**
   * Test strategy with email required.
   */
  @Test
  public void usernameEMailRequired1()
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
  public void usernameEMailRequired2()
   {
    final IUsernameStrategy cleanStrategy = UsernameConfigurableStrategy.of(1, 254, UsernameConfigurableStrategyTests.PATTERN1, HandleEMail.EMAIL_REQUIRED);
    final boolean email = cleanStrategy.validationStrategy(UsernameConfigurableStrategyTests.USERNAME_EXAMPLE_COM);
    assertTrue(email, "email not validated"); //$NON-NLS-1$
   }


  /**
   * Test getAction of HandleEMail.
   */
  @Test
  public void getAction()
   {
    assertEquals(1, HandleEMail.EMAIL_REQUIRED.getAction(), "Action not as expected"); //$NON-NLS-1$
   }

 }
