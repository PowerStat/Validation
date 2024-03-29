/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.strategies;


/**
 * Password default validation strategy.
 */
public final class PasswordDefaultStrategy extends PasswordConfigurableStrategy
 {
  /**
   * Cache for singleton.
   */
  private static final PasswordDefaultStrategy CACHE = new PasswordDefaultStrategy();


  /**
   * Default Constructor.
   */
  private PasswordDefaultStrategy()
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
    return PasswordDefaultStrategy.CACHE;
   }

 }
