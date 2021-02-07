/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.strategies;


import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


/**
 * Configurable password strategy.
 *
 * TODO rainbow tables
 * TODO https://haveibeenpwned.com/
 *
 * TODO struct parameter
 *
 * TODO chain strategy
 */
public class PasswordConfigurableStrategy implements IPasswordStrategy
 {
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
   * Minimum number of required numeric characters.
   */
  private final int minNumeric;

  /**
   * Minimum number of lower case characters.
   */
  private final int minLower;

  /**
   * Minimum number of upper case characters.
   */
  private final int minUpper;

  /**
   * Minimum number of special characters.
   */
  private final int minSpecial;

  /**
   * Minimum number of unique characters.
   */
  private final int minUnique;

  /**
   * Maximum number of allowed repeated characters after each other.
   */
  private final int maxRepeated;


  /**
   * Constructor.
   *
   * @param minLength Minimum allowed username length, must be &gt;= 1
   * @param maxLength Maximum allowed username length, must be &gt;= minLength and &lt;= INTEGER.MAX_VALUE
   * @param regexp Regular expression for matching characters. Must start with ^ and end with $. Example: ^[@./_0-9a-zA-Z-]+$
   * @param minNumeric Minimum required numeric characters
   * @param minLower Minimum required lower case characters
   * @param minUpper Minimum required upper case characters
   * @param minSpecial Minimum required special characters
   * @param minUnique Minimum required unique characters
   * @param maxRepeated Maximum number of allowed repeated characters after each other
   * @throws IllegalArgumentException If arguments are not as required
   * @throws NullPointerException If regexp is null
   * TODO parameters via struct
   */
  public PasswordConfigurableStrategy(final int minLength, final int maxLength, final String regexp, final int minNumeric, final int minLower, final int minUpper, final int minSpecial, final int minUnique, final int maxRepeated)
   {
    super();
    Objects.requireNonNull(regexp, "regexp"); //$NON-NLS-1$
    if (minLength <= 0)
     {
      throw new IllegalArgumentException("minLength must be >= 1"); //$NON-NLS-1$
     }
    if (maxLength < minLength)
     {
      throw new IllegalArgumentException("maxLength >= minLength"); //$NON-NLS-1$
     }
    if ((regexp.charAt(0) != '^') || !regexp.endsWith("$")) //$NON-NLS-1$
     {
      throw new IllegalArgumentException("regexp does not start with ^ or ends with $"); //$NON-NLS-1$
     }
    if ((minNumeric < 0) || (minNumeric > maxLength))
     {
      throw new IllegalArgumentException("minNumeric must be >= 0 && <= maxLength"); //$NON-NLS-1$
     }
    if ((minLower < 0) || (minLower > maxLength))
     {
      throw new IllegalArgumentException("minLower must be >= 0 && <= maxLength"); //$NON-NLS-1$
     }
    if ((minUpper < 0) || (minUpper > maxLength))
     {
      throw new IllegalArgumentException("minUpper must be >= 0 && <= maxLength"); //$NON-NLS-1$
     }
    if ((minSpecial < 0) || (minSpecial > maxLength))
     {
      throw new IllegalArgumentException("minSpecial must be >= 0 && <= maxLength"); //$NON-NLS-1$
     }
    if ((minNumeric + minLower + minUpper + minSpecial) > maxLength)
     {
      throw new IllegalArgumentException("minNumeric + minLower + minUpper + minSpecial > maxLength"); //$NON-NLS-1$
     }
    if ((minUnique < 0) || (minUnique > maxLength))
     {
      throw new IllegalArgumentException("minUnique must be >= 0 && <= maxLength"); //$NON-NLS-1$
     }
    if ((maxRepeated < 0) || (maxRepeated > maxLength))
     {
      throw new IllegalArgumentException("minUnique must be >= 0 && <= maxLength"); //$NON-NLS-1$
     }
    this.minLength = minLength;
    this.maxLength = maxLength;
    this.regexp = regexp;
    this.minNumeric = minNumeric;
    this.minLower = minLower;
    this.minUpper = minUpper;
    this.minSpecial = minSpecial;
    this.minUnique = minUnique;
    this.maxRepeated = maxRepeated;
   }


  /**
   * Password validation strategy factory.
   *
   * @param minLength Minimum allowed username length, must be &gt;= 1
   * @param maxLength Maximum allowed username length, must be &gt;= minLength and &lt;= INTEGER.MAX_VALUE
   * @param regexp Regular expression for matching characters. Must start with ^ and end with $. Example: ^[@./_0-9a-zA-Z-]+$
   * @param minNumeric Minimum required numeric characters
   * @param minLower Minimum required lower case characters
   * @param minUpper Minimum required upper case characters
   * @param minSpecial Minimum required special characters
   * @param minUnique Minimum required unique characters
   * @param maxRepeated Maximum number of allowed repeated characters after each other
   * @return UsernameStrategy object
   * @throws IllegalArgumentException If arguments
   * @throws NullPointerException If regexp is null
   */
  public static IPasswordStrategy of(final int minLength, final int maxLength, final String regexp, final int minNumeric, final int minLower, final int minUpper, final int minSpecial, final int minUnique, final int maxRepeated)
   {
    return new PasswordConfigurableStrategy(minLength, maxLength, regexp, minNumeric, minLower, minUpper, minSpecial, minUnique, maxRepeated);
   }


  /**
   * Validation strategy.
   *
   * @param password Password
   * @throws IllegalArgumentException If the password does not match the configured parameters
   */
  @Override
  public void validationStrategy(final String password)
   {
    if ((password.length() < this.minLength) || (password.length() > this.maxLength))
     {
      throw new IllegalArgumentException("To short or long for a password"); //$NON-NLS-1$
     }
    if (!password.matches(this.regexp))
     {
      throw new IllegalArgumentException("Password contains illegal character"); //$NON-NLS-1$
     }
    int upper = 0;
    int lower = 0;
    int numeric = 0;
    int special = 0;
    int same = 1;
    char lastChar = '\0';
    final Set<Character> cset = new HashSet<>(password.length());
    for (int i = 0; i < password.length(); ++i)
     {
      final char chr = password.charAt(i);
      cset.add(chr);
      if (Character.isUpperCase(chr))
       {
        ++upper;
       }
      else if (Character.isLowerCase(chr))
       {
        ++lower;
       }
      else if (Character.isDigit(chr))
       {
        ++numeric;
       }
      else
       {
        ++special;
       }
      if (chr == lastChar)
       {
        ++same;
        if ((this.maxRepeated != 0) && (same > this.maxRepeated))
         {
          throw new IllegalArgumentException("To much repeated characters after each other in password"); //$NON-NLS-1$
         }
       }
      else
       {
        same = 1;
        lastChar = chr;
       }
     }
    if (numeric < this.minNumeric)
     {
      throw new IllegalArgumentException("Not enougth numeric characters in password"); //$NON-NLS-1$
     }
    if (lower < this.minLower)
     {
      throw new IllegalArgumentException("Not enougth lower case characters in password"); //$NON-NLS-1$
     }
    if (upper < this.minUpper)
     {
      throw new IllegalArgumentException("Not enougth upper case characters in password"); //$NON-NLS-1$
     }
    if (special < this.minSpecial)
     {
      throw new IllegalArgumentException("Not enougth special characters in password"); //$NON-NLS-1$
     }
    if (cset.size() < this.minUnique)
     {
      throw new IllegalArgumentException("Not enougth unique characters in password"); //$NON-NLS-1$
     }
    }

 }
