/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.strategies.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
   * Default constructor.
   */
  public UsernameConfigurableStrategyTests()
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
      /* final IUsernameStrategy cleanStrategy = */ UsernameConfigurableStrategy.of(0, 254, "^[@./_0-9a-zA-Z-]+$", HandleEMail.EMAIL_POSSIBLE); //$NON-NLS-1$
     }
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
      /* final IUsernameStrategy cleanStrategy = */ UsernameConfigurableStrategy.of(10, 9, "^[@./_0-9a-zA-Z-]+$", HandleEMail.EMAIL_POSSIBLE); //$NON-NLS-1$
     }
    );
   }


  /**
   * Test strategy with maxLength = minLength.
   */
  @Test
  public void maxEqualMinLength()
   {
    final IUsernameStrategy cleanStrategy =  UsernameConfigurableStrategy.of(10, 10, "^[@./_0-9a-zA-Z-]+$", HandleEMail.EMAIL_POSSIBLE); //$NON-NLS-1$
    assertNotNull(cleanStrategy, "cleanStrategy not as expected"); //$NON-NLS-1$
   }


  /**
   * Test strategy with email denied.
   */
  @Test
  public void usernameEMailDenied()
   {
    final IUsernameStrategy cleanStrategy = UsernameConfigurableStrategy.of(1, 254, "^[@./_0-9a-zA-Z-]+$", HandleEMail.EMAIL_DENIED); //$NON-NLS-1$
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* boolean email = */ cleanStrategy.validationStrategy("username@example.com"); //$NON-NLS-1$
     }
    );
   }


  /**
   * Test strategy with email required.
   */
  @Test
  public void usernameEMailRequired()
   {
    final IUsernameStrategy cleanStrategy = UsernameConfigurableStrategy.of(1, 254, "^[@./_0-9a-zA-Z-]+$", HandleEMail.EMAIL_REQUIRED); //$NON-NLS-1$
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* boolean email = */ cleanStrategy.validationStrategy("username"); //$NON-NLS-1$
     }
    );
   }


  /**
   * Test strategy with wrong regexp.
   */
  @Test
  public void regexpWrong()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      final IUsernameStrategy cleanStrategy = UsernameConfigurableStrategy.of(1, 254, "[@./_0-9a-zA-Z-]+", HandleEMail.EMAIL_REQUIRED); //$NON-NLS-1$
     }
    );
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
