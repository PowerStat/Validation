/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

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
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class Password implements Comparable<Password>, IValueObject
 {
  /**
   * Cache for singletons.
   */
  private static final Map<String, Password> CACHE = new WeakHashMap<>();

  /**
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$

  /**
   * Password.
   */
  private final String passwd;


  /**
   * Constructor.
   *
   * @param validationStrategy Validation strategy
   * @param password Password
   *
   * @throws NullPointerException if password or validationStrategy is null
   * @throws IllegalArgumentException if password contains unsupported characters or is to long or short etc.
   */
  private Password(final IPasswordStrategy validationStrategy, final String password)
   {
    super();
    Objects.requireNonNull(validationStrategy, "validationStrategy"); //$NON-NLS-1$
    Objects.requireNonNull(password, "password"); //$NON-NLS-1$
    validationStrategy.validationStrategy(password);
    this.passwd = password;
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
    synchronized (Password.class)
     {
      Password obj = Password.CACHE.get(password);
      if (obj != null)
       {
        validationStrategy.validationStrategy(password);
        return obj;
       }
      obj = new Password(validationStrategy, password);
      Password.CACHE.put(password, obj);
      return obj;
     }
   }


  /**
   * Password factory with PasswordDefaultStrategy.
   *
   * @param password Password
   * @return Password object
   */
  public static Password of(final String password)
   {
    return of(PasswordDefaultStrategy.of(), password);
   }


  /**
   * Get password string.
   *
   * @return Password string
   * @deprecated Use stringValue() instead
   */
  @Deprecated(since = Password.DEPRECATED_SINCE_3_0, forRemoval = false)
  public String getPassword()
   {
    return this.passwd;
   }


  /**
   * Returns the value of this Password as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  public String stringValue()
   {
    return this.passwd;
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
    return this.passwd.equals(password);
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
    return this.passwd.hashCode();
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
    if (!(obj instanceof Password))
     {
      return false;
     }
    final Password other = (Password)obj;
    return this.passwd.equals(other.passwd);
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
    final StringBuilder builder = new StringBuilder(27);
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
    return this.passwd.compareTo(obj.passwd);
   }

 }
