/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.impl;


import java.util.Objects;


/**
 * IBAN verifier.
 */
public final class IBANVerifier
 {
  /**
   * IBAN length.
   */
  private final int length;

  /**
   * IBAN regexp.
   */
  private final String regexp;


  /**
   * Constructor.
   *
   * @param length Country specific maximum IBAN length.
   * @param regexp Country specific regular expression
   */
  public IBANVerifier(final int length, final String regexp)
   {
    super();
    if ((length < 15) || (length > 34))
     {
      throw new IllegalArgumentException("Wrong length, must be between 15 and 34"); //$NON-NLS-1$
     }
    Objects.requireNonNull(regexp, "regexp"); //$NON-NLS-1$
    // TODO test regexp length and allowed characters
    if ((regexp.charAt(0) != '^') || (regexp.charAt(regexp.length() - 1) != '$'))
     {
      throw new IllegalArgumentException("Regexp does not start with ^ or ends with $"); //$NON-NLS-1$
     }
    this.length = length;
    this.regexp = regexp;
   }


  /**
   * IBAN verifier factory.
   *
   * @param length Country specific maximum IBAN length.
   * @param regexp Country specific regular expression
   * @return IBAN verifier object
   */
  public static IBANVerifier of(final int length, final String regexp)
   {
    return new IBANVerifier(length, regexp);
   }


  /**
   * Verify country specific iban.
   *
   * @param iban IBAN
   * @return true when IBAN is ok, false otherwise
   */
  public boolean verify(final String iban)
   {
    Objects.requireNonNull(iban, "iban"); //$NON-NLS-1$
    return ((iban.length() == this.length) && iban.matches(this.regexp));
   }

 }
