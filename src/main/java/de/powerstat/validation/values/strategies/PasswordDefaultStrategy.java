/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.strategies;

/**
 * Password default validation strategy.
 */
public class PasswordDefaultStrategy extends PasswordConfigurableStrategy
 {
  /**
   * Default Constructor.
   */
  public PasswordDefaultStrategy()
   {
    super(8, 254, "^[!§$%&/()=?öäüÖÄÜ,.:;_@0-9a-zA-Z-]+$", 0, 1, 0, 0, 0, 3); //$NON-NLS-1$
   }


  /**
   * Password validation strategy factory.
   *
   * @return PasswordStrategy object
   */
  public static IPasswordStrategy of()
   {
    return new PasswordDefaultStrategy();
   }

 }
