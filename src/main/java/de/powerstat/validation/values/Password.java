/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.values.strategies.IPasswordStrategy;
import de.powerstat.validation.values.strategies.PasswordDefaultStrategy;


/**
 * Password.
 *
 * DSGVO relevant.
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
 */
public final class Password implements Comparable<Password>
 {
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
  public Password(final IPasswordStrategy validationStrategy, final String password)
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
    return new Password(validationStrategy, password);
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
   */
  public String getPassword()
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
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
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
