/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;
import de.powerstat.validation.values.strategies.IPasswordStrategy;
import de.powerstat.validation.values.strategies.PasswordDefaultStrategy;


/**
 * Password.
 *
 * DSGVO relevant.
 *
 * TODO memory protection
 *
 * TODO encryption algorithm (hashtypes)
 * TODO salt
 *
 * TODO Disallow email address    via verifyPassword
 * TODO Disallow user name (case) via verifyPassword
 * TODO Disallow user ID          via verifyPassword
 *
 * TODO password age in days
 *
 * TODO Repeated/Reversed history length via verifyPassword
 *
 * TODO validation chain
 *
 * TODO Password generator
 *
 * TODO Verify that password is not in:
 *      https://www.datendieter.de/item/Haeufige_Passwoerter
 *      https://www.passwortfuchs.de/passwortliste.php
 *      https://crackstation.net/crackstation-wordlist-password-cracking-dictionary.htm
 *      https://github.com/danielmiessler/SecLists/tree/master/Passwords
 *      https://weakpass.com/wordlist
 *      https://wiki.skullsecurity.org/Passwords
 *      https://thehacktoday.com/password-cracking-dictionarys-download-for-free/
 */
public final class Password implements Comparable<Password>, IValueObject
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<String, Password> CACHE = new WeakHashMap<>();

  /**
   * Hidden password.
   */
  @SuppressWarnings("java:S2068")
  private static final String SECRET_PASSWORD = "********"; //$NON-NLS-1$

  /**
   * Password.
   */
  private final String passwd;

  /**
   * Password could be read via stringValue() if true.
   */
  private final boolean read;


  /**
   * Constructor.
   *
   * @param validationStrategy Validation strategy
   * @param password Password
   * @param noRead true: password could not be read via stringValue(); false: password could be read
   * @throws NullPointerException if password or validationStrategy is null
   * @throws IllegalArgumentException if password contains unsupported characters or is to long or short etc.
   */
  private Password(final IPasswordStrategy validationStrategy, final String password, final boolean noRead)
   {
    super();
    Objects.requireNonNull(validationStrategy, "validationStrategy"); //$NON-NLS-1$
    Objects.requireNonNull(password, "password"); //$NON-NLS-1$
    validationStrategy.validationStrategy(password);
    passwd = password;
    read = !noRead;
   }


  /**
   * Password factory.
   *
   * @param validationStrategy Validation strategy
   * @param password Password
   * @param noRead true: password could not be read via stringValue(); false: password could be read
   * @return Password object
   */
  public static Password of(final IPasswordStrategy validationStrategy, final String password, final boolean noRead)
   {
    /*
    synchronized (Password.class)
     {
      Password obj = Password.CACHE.get(password);
      if (obj != null)
       {
        validationStrategy.validationStrategy(password);
        return obj;
       }
      obj = new Password(validationStrategy, password, noRead);
      Password.CACHE.put(password, obj);
      return obj;
     }
    */
    return new Password(validationStrategy, password, noRead);
   }


  /**
   * Password factory.
   *
   * @param validationStrategy Validation strategy
   * @param password Password
   * @return Password object
   */
  public static Password of(final IPasswordStrategy validationStrategy, final String password)
   {
    return of(validationStrategy, password, false);
   }


  /**
   * Password factory with PasswordDefaultStrategy.
   *
   * @param password Password
   * @param noRead true: password could not be read via stringValue(); false: password could be read
   * @return Password object
   */
  public static Password of(final String password, final boolean noRead)
   {
    return of(PasswordDefaultStrategy.of(), password, noRead);
   }


  /**
   * Password factory with PasswordDefaultStrategy.
   *
   * @param password Password
   * @return Password object
   */
  public static Password of(final String password)
   {
    return of(PasswordDefaultStrategy.of(), password, false);
   }


  /**
   * Returns the value of this Password as a string or ******** if noRead was set during object creation.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return read ? passwd : SECRET_PASSWORD;
   }


  /**
   * Verify password.
   *
   * @param password Password string to verify against this Password object
   * @return true when password has been successfully verified, false otherwise
   *
   * TODO encryption
   */
  public boolean verifyPassword(final String password)
   {
    return passwd.equals(password);
   }


  /**
   * Calculate hash code.
   *
   * @return Hash
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
   {
    return passwd.hashCode();
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof final Password other))
     {
      return false;
     }
    return passwd.equals(other.passwd);
   }


  /**
   * Returns the string representation of this Password.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Password[password=********]"
   *
   * @return String representation of this Password
   * @see java.lang.Object#toString()
   */
  @SuppressWarnings("java:S2068")
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(27);
    builder.append("Password[password=********]"); //$NON-NLS-1$
    return builder.toString();
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Password obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return passwd.compareTo(obj.passwd);
   }

 }
