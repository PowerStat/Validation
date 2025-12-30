/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.strategies;


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
  boolean validationStrategy(String username);

 }
