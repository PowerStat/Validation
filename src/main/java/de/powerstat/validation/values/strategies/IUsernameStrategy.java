/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.strategies;


/**
 * Username strategy interface.
 */
public interface IUsernameStrategy
 {
  /**
   * Validation strategy.
   *
   * @param username Username
   * @return true: if username is an email, false otherwise
   * @throws IllegalArgumentException If the username does not match the configured parameters
   */
  boolean validationStrategy(final String username);

 }
