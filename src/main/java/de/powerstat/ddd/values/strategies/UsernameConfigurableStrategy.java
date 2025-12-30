/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.strategies;


import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import de.powerstat.ddd.containers.NTuple4;
import de.powerstat.ddd.values.EMail;


/**
 * Configurable username validation strategy.
 */
public class UsernameConfigurableStrategy implements IUsernameStrategy
 {
  /* *
   * Logger.
   */
  // private static final Logger LOGGER = LogManager.getLogger(UsernameConfigurableStrategy.class);

  /**
   * Cache for singletons.
   */
  private static final Map<NTuple4<Integer, Integer, String, HandleEMail>, UsernameConfigurableStrategy> CACHE = new ConcurrentHashMap<>();

  /**
   * Minimum allowed username length.
   */
  private final int minLength;

  /**
   * Maximum allowed username length.
   */
  private final int maxLength;

  /**
   * Regular expression for matching allowed characters.
   */
  private final String regexp;

  /**
   * EMail handling.
   *
   * Could be EMAIL_DENIED, EMAIL_REQUIRED or EMAIL_POSSIBLE
   */
  private final HandleEMail emailHandling;


  /**
   * Enum for handling of email addresses.
   */
  public enum HandleEMail
   {
    /**
     * No email address is denied as username.
     */
    EMAIL_DENIED(0),

    /**
     * Username must be an email address.
     */
    EMAIL_REQUIRED(1),

    /**
     * Username can be an email address, but it's not required.
     */
    EMAIL_POSSIBLE(2);


    /**
     * Action number.
     */
    private final int action;


    /**
     * Ordinal constructor.
     *
     * @param action Action number
     */
    HandleEMail(final int action)
     {
      this.action = action;
     }


    /**
     * Get action number.
     *
     * @return Action number
     */
    public int getAction()
     {
      return action;
     }

   }


  /**
   * Constructor.
   *
   * @param minLength Minimum allowed username length, must be &gt;= 1
   * @param maxLength Maximum allowed username length, must be &gt;= minLength and &lt;= INTEGER.MAX_VALUE
   * @param regexp Regular expression for matching characters. Must start with ^ and end with $. Example: ^[@./_0-9a-zA-Z-]+$
   * @param emailHandling How email addresses as username should be handled: EMAIL_DENIED, EMAIL_REQUIRED or EMAIL_POSSIBLE
   * @throws IllegalArgumentException If arguments are not as required
   * @throws NullPointerException If regexp or emailHandling is null
   */
  protected UsernameConfigurableStrategy(final int minLength, final int maxLength, final String regexp, final HandleEMail emailHandling)
   {
    super();
    Objects.requireNonNull(regexp, "regexp"); //$NON-NLS-1$
    Objects.requireNonNull(emailHandling, "emailHandling"); //$NON-NLS-1$
    if (minLength < 0)
     {
      throw new IllegalArgumentException("minLength must be >= 0"); //$NON-NLS-1$
     }
    if (maxLength < minLength)
     {
      throw new IllegalArgumentException("maxLength >= minLength"); //$NON-NLS-1$
     }
    if ((regexp.charAt(0) != '^') || !regexp.endsWith("$")) //$NON-NLS-1$
     {
      throw new IllegalArgumentException("regexp does not start with ^ or ends with $"); //$NON-NLS-1$
     }
    this.minLength = minLength;
    this.maxLength = maxLength;
    this.regexp = regexp;
    this.emailHandling = emailHandling;
   }


  /**
   * Username validation strategy factory.
   *
   * @param minLength Minimum allowed username length, must be &gt;= 1
   * @param maxLength Maximum allowed username length, must be &gt;= minLength and &lt;= INTEGER.MAX_VALUE
   * @param regexp Regular expression for matching characters. Must start with ^ and end with $. Example: ^[@./_0-9a-zA-Z-]+$
   * @param emailHandling How email addresses as username should be handled: EMAIL_DENIED, EMAIL_REQUIRED or EMAIL_POSSIBLE
   * @return UsernameStrategy object
   * @throws IllegalArgumentException If arguments
   * @throws NullPointerException If regexp or emailHandling is null
   */
  public static IUsernameStrategy of(final int minLength, final int maxLength, final String regexp, final HandleEMail emailHandling)
   {
    final NTuple4<Integer, Integer, String, HandleEMail> tuple = NTuple4.of(minLength, maxLength, regexp, emailHandling);
    synchronized (UsernameConfigurableStrategy.class)
     {
      UsernameConfigurableStrategy obj = UsernameConfigurableStrategy.CACHE.get(tuple);
      if (obj != null)
       {
        return obj;
       }
      obj = new UsernameConfigurableStrategy(minLength, maxLength, regexp, emailHandling);
      UsernameConfigurableStrategy.CACHE.put(tuple, obj);
      return obj;
     }
   }


  /**
   * Validation strategy.
   *
   * @param username Username
   * @return true: if username is an email, false otherwise
   * @throws IllegalArgumentException If the username does not match the configured parameters
   */
  @Override
  public boolean validationStrategy(final String username)
   {
    if ((username.length() < minLength) || (username.length() > maxLength))
     {
      throw new IllegalArgumentException("To short or long for an username"); //$NON-NLS-1$
     }
    if (!username.matches(regexp))
     {
      throw new IllegalArgumentException("Username contains illegal character"); //$NON-NLS-1$
     }
    // Must or must not be an email address?
    boolean checkEMail = false;
    try
     {
      /* final EMail email = */ EMail.of(username);
      checkEMail = true;
     }
    catch (final IllegalArgumentException ignore)
     {
      // LOGGER.debug("IllegalArgumentException", ignore);
     }
    if ((emailHandling == HandleEMail.EMAIL_REQUIRED) && !checkEMail)
     {
      throw new IllegalArgumentException("Username must be an email address"); //$NON-NLS-1$
     }
    if ((emailHandling == HandleEMail.EMAIL_DENIED) && checkEMail)
     {
      throw new IllegalArgumentException("EMail address is not allowed as username"); //$NON-NLS-1$
     }
    return checkEMail;
   }

 }
