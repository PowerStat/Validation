/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.strategies;


/**
 * Username default validation strategy.
 *
 * Minimum 2 characters, maximum 254 characters, can be an email address.
 * Allowed characters: @./_0-9a-zA-Z-
 */
public class UsernameDefaultStrategy extends UsernameConfigurableStrategy
 {
  /**
   * Default Constructor.
   */
  public UsernameDefaultStrategy()
   {
    super(2, 254, "^[@./_0-9a-zA-Z-]+$", HandleEMail.EMAIL_POSSIBLE); //$NON-NLS-1$
   }


  /**
   * Username validation strategy factory.
   *
   * @return UsernameStrategy object
   */
  public static IUsernameStrategy of()
   {
    return new UsernameDefaultStrategy();
   }

 }
