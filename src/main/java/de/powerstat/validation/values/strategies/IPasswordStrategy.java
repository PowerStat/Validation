/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
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
