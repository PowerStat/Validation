/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.regex.Pattern;

import de.powerstat.validation.generated.GeneratedISO4217;
import de.powerstat.validation.interfaces.IValueObject;


/**
 * Currency ISO 4217 codes.
 *
 * Not DSGVO relevant.
 *
 * TODO Translations
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class Currency implements Comparable<Currency>, IValueObject
 {
  /**
   * Cache for singletons.
   */
  private static final Map<String, Currency> CACHE = new WeakHashMap<>();

  /**
   * Currency regexp.
   */
  private static final Pattern CURRENCY_REGEXP = Pattern.compile("^[A-Z]{3}$"); //$NON-NLS-1$

  /**
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$

  /**
   * ISO 4217 currency code.
   */
  private final String code;


  /**
   * Constructor.
   *
   * @param code ISO 4217 code
   * @throws NullPointerException if code is null
   * @throws IllegalArgumentException if code is not a known 4217 code
   */
  private Currency(final String code)
   {
    super();
    Objects.requireNonNull(code, "code"); //$NON-NLS-1$
    if (code.length() != 3)
     {
      throw new IllegalArgumentException("Length is not 3"); //$NON-NLS-1$
     }
    if (!Currency.CURRENCY_REGEXP.matcher(code).matches())
     {
      throw new IllegalArgumentException("Code contains illegal character"); //$NON-NLS-1$
     }
    if (!GeneratedISO4217.contains(code))
     {
      throw new IllegalArgumentException("Unknown ISO4217 code: " + code); //$NON-NLS-1$
     }
    this.code = code;
   }


  /**
   * Currency factory.
   *
   * @param code 4217 code
   * @return Currency object
   */
  public static Currency of(final String code)
   {
    synchronized (Currency.class)
     {
      Currency obj = Currency.CACHE.get(code);
      if (obj != null)
       {
        return obj;
       }
      obj = new Currency(code);
      Currency.CACHE.put(code, obj);
      return obj;
     }
   }


  /**
   * Get currency code string.
   *
   * @return Currency code string
   * @deprecated Use stringValue() instead
   */
  @Deprecated(since = Currency.DEPRECATED_SINCE_3_0, forRemoval = false)
  public String getCurrency()
   {
    return this.code;
   }


  /**
   * Returns the value of this Currency as a ISO 4217 string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  public String stringValue()
   {
    return this.code;
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
    return this.code.hashCode();
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
    if (!(obj instanceof Currency))
     {
      return false;
     }
    final Currency other = (Currency)obj;
    return this.code.equals(other.code);
   }


  /**
   * Returns the string representation of this Currency.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Currency[code=EUR]"
   *
   * @return String representation of this Currency
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Currency[code=").append(this.code).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Currency obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.code.compareTo(obj.code);
   }

 }
