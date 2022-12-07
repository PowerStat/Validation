/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.strategies;


/**
 * Username default validation strategy.
 *
 * Minimum 2 characters, maximum 254 characters, can be an email address.
 * Allowed characters: @./_0-9a-zA-Z-
 */
public final class UsernameDefaultStrategy extends UsernameConfigurableStrategy
 {
  /**
   * Cache for singleton.
   */
  private static final UsernameDefaultStrategy CACHE = new UsernameDefaultStrategy();


  /**
   * Default Constructor.
   */
  private UsernameDefaultStrategy()
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
    return UsernameDefaultStrategy.CACHE;
   }

 }
