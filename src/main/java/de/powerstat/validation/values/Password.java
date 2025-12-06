/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;
import de.powerstat.validation.values.strategies.IPasswordStrategy;
import de.powerstat.validation.values.strategies.PasswordDefaultStrategy;


/**
 * Password.
 *
 * @param passwd Password
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
@ValueObject
public record Password(String passwd) implements Comparable<Password>, IValueObject
 {
  /**
   * Hidden password.
   */
  @SuppressWarnings("java:S2068")
  private static final String SECRET_PASSWORD = "********"; //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param passwd Password
   * @throws NullPointerException if password is null
   * @throws IllegalArgumentException if password is empty
   *
   * Prefer using the factory methods.
   */
  public Password
   {
    Objects.requireNonNull(passwd, "passwd"); //$NON-NLS-1$
    if (passwd.isEmpty())
     {
      throw new IllegalArgumentException("passwd is empty"); //$NON-NLS-1$
     }
   }


  /**
   * Password factory with PasswordDefaultStrategy.
   *
   * @param password Password
   * @return Password object
   * @throws NullPointerException if password or validationStrategy is null
   * @throws IllegalArgumentException if password contains unsupported characters or is to long or short etc.
   */
  public static Password of(final String password)
   {
    Objects.requireNonNull(password, "password"); //$NON-NLS-1$
    IPasswordStrategy strategy = PasswordDefaultStrategy.of();
    strategy.validationStrategy(password);
    return new Password(password);
   }


  /**
   * Password factory.
   *
   * @param validationStrategy Validation strategy
   * @param password Password
   * @return Password object
   * @throws NullPointerException if password or validationStrategy is null
   * @throws IllegalArgumentException if password contains unsupported characters or is to long or short etc.
   */
  public static Password of(final IPasswordStrategy validationStrategy, final String password)
   {
    Objects.requireNonNull(validationStrategy, "validationStrategy"); //$NON-NLS-1$
    Objects.requireNonNull(password, "password"); //$NON-NLS-1$
    validationStrategy.validationStrategy(password);
    return new Password(password);
   }


  /**
   * Accessor.
   *
   * @return Hidden password as ********
   */
  public String passwd()
   {
    return SECRET_PASSWORD;
   }


  /**
   * Returns the value of this Password as a string of ********.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return SECRET_PASSWORD;
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
