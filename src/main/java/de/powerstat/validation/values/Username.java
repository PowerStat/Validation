/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.values.strategies.IUsernameStrategy;
import de.powerstat.validation.values.strategies.UsernameDefaultStrategy;


/**
 * Username.
 *
 * DSGVO relevant.
 *
 * TODO Already existing user?
 * TODO case sensitive or insensitive?
 * TODO Comparable&lt;EMail&gt;
 */
public final class Username implements Comparable<Username>
 {
  /**
   * Username.
   */
  private final String username;

  /**
   * Does the username conforms to an email address format.
   */
  private final boolean conformsToEMailAddressFormat;


  /**
   * Constructor.
   *
   * @param validationStrategy Validation strategy
   * @param username Username
   *
   * @throws NullPointerException if username or validationStrategy is null
   * @throws IllegalArgumentException if username contains unsupported characters or is to long or short
   */
  public Username(final IUsernameStrategy validationStrategy, final String username)
   {
    super();
    Objects.requireNonNull(validationStrategy, "validationStrategy"); //$NON-NLS-1$
    Objects.requireNonNull(username, "username"); //$NON-NLS-1$
    this.conformsToEMailAddressFormat = validationStrategy.validationStrategy(username);
    this.username = username;
   }


  /**
   * Username factory.
   *
   * @param validationStrategy Validation strategy
   * @param username Username
   * @return Username object
   */
  public static Username of(final IUsernameStrategy validationStrategy, final String username)
   {
    return new Username(validationStrategy, username);
   }


  /**
   * Username factory with UsernameMin2Max254CanBeEMailStrategy.
   *
   * @param username Username
   * @return Username object
   */
  public static Username of(final String username)
   {
    return new Username(UsernameDefaultStrategy.of(), username);
   }


  /**
   * Get username string.
   *
   * @return Username string
   */
  public String getUsername()
   {
    return this.username;
   }


  /**
   * Is username an email address.
   *
   * @return true when username is an email address, false otherwise
   */
  public boolean isEMail()
   {
    return this.conformsToEMailAddressFormat;
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
    return this.username.hashCode();
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
    if (!(obj instanceof Username))
     {
      return false;
     }
    final Username other = (Username)obj;
    return this.username.equals(other.username);
   }


  /**
   * Returns the string representation of this Username.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Username[username=user@example.com]"
   *
   * @return String representation of this Username
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Username[username=").append(this.username).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Username obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.username.compareTo(obj.username);
   }

 }
