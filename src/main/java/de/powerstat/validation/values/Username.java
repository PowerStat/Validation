/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;
import de.powerstat.validation.values.strategies.IUsernameStrategy;
import de.powerstat.validation.values.strategies.UsernameDefaultStrategy;


/**
 * Username.
 *
 * @param username Username
 *
 * DSGVO relevant.
 *
 * TODO Already existing user?
 * TODO case sensitive or insensitive?
 * TODO Comparable&lt;EMail&gt;
 */
@ValueObject
public record Username(String username) implements Comparable<Username>, IValueObject
 {
  /**
   * Constructor.
   *
   * @param username Username
   * @throws NullPointerException if username is null
   * @throws IllegalArgumentException if username is empty
   *
   * Prefer using factory methods!
   */
  public Username
   {
    Objects.requireNonNull(username, "username"); //$NON-NLS-1$
    if (username.isEmpty())
     {
      throw new IllegalArgumentException("username is empty"); //$NON-NLS-1$
     }
   }


  /**
   * Username factory using UsernameDefaultStrategy.
   *
   * @param username Username
   * @return Username object
   * @throws NullPointerException if username is null
   * @throws IllegalArgumentException if username does not conform to UsernameDefaultStrategy
   */
  public static Username of(final String username)
   {
    Objects.requireNonNull(username, "username"); //$NON-NLS-1$
    IUsernameStrategy strategy = UsernameDefaultStrategy.of();
    /* boolean result = */ strategy.validationStrategy(username);
    return new Username(username);
   }


  /**
   * Username factory.
   *
   * @param validationStrategy Validation strategy
   * @param username Username
   * @return Username object
   * @throws NullPointerException if username or validationStrategy is null
   * @throws IllegalArgumentException if username idoes not confiorms to the validationStrategy
   */
  public static Username of(final IUsernameStrategy validationStrategy, final String username)
   {
    Objects.requireNonNull(username, "username"); //$NON-NLS-1$
    Objects.requireNonNull(validationStrategy, "validationStrategy"); //$NON-NLS-1$
    /* boolean conformsToEMailAddressFormat = */ validationStrategy.validationStrategy(username);
    return new Username(username);
   }


  /**
   * Returns the value of this Username as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return username;
   }


  /**
   * Is username an email address.
   *
   * @return true when username is an email address, false otherwise
   */
  public boolean isEMail()
   {
    try
     {
      /* EMail email = */ new EMail(username);
     }
    catch (IllegalArgumentException ignore)
     {
      return false;
     }
    return true;
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Username obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return username.compareTo(obj.username);
   }

 }
