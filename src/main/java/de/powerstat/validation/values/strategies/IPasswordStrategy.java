/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.strategies;


/**
 * Password strategy interface.
 */
public interface IPasswordStrategy
 {
  /**
   * Validation strategy.
   *
   * @param password Password
   * @throws IllegalArgumentException If the password does not match the configured parameters
   */
  void validationStrategy(String password);

 }
