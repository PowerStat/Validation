/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.strategies;


/**
 * Username validation strategy.
 *
 * Minimum 2 characters, maximum 254 characters, can be an email address.
 * Allowed characters: @./_0-9a-zA-Z-
 */
public class UsernameMin2Max254CanBeEMailStrategy extends UsernameConfigurableStrategy
 {
  /**
   * Default Constructor.
   */
  public UsernameMin2Max254CanBeEMailStrategy()
   {
    super(2, 254, "^[@./_0-9a-zA-Z-]+$", HandleEMail.EMAIL_POSSIBLE);
   }


  /**
   * Username validation strategy factory.
   *
   * @return UsernameStrategy object
   */
  public static IUsernameStrategy of()
   {
    return new UsernameMin2Max254CanBeEMailStrategy();
   }

 }
