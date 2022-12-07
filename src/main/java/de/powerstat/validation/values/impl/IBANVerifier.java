/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.impl;


import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import de.powerstat.validation.values.containers.NTuple2;


/**
 * IBAN verifier.
 */
public final class IBANVerifier
 {
  /**
   * Cache for singletons.
   */
  private static final Map<NTuple2<Integer, String>, IBANVerifier> CACHE = new ConcurrentHashMap<>();

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
  private IBANVerifier(final int length, final String regexp)
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
    final NTuple2<Integer, String> tuple = NTuple2.of(length, regexp);
    synchronized (IBANVerifier.class)
     {
      IBANVerifier obj = IBANVerifier.CACHE.get(tuple);
      if (obj != null)
       {
        return obj;
       }
      obj = new IBANVerifier(length, regexp);
      IBANVerifier.CACHE.put(tuple, obj);
      return obj;
     }
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
