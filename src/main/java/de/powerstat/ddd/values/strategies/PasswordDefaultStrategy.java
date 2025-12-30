/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.strategies;


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
