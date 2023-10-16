/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Business Identifier Code (BIC) ISO 9362.
 *
 * Not DSGVO relevant.
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class BIC implements Comparable<BIC>, IValueObject
 {
  /**
   * Cache for singletons.
   */
  private static final Map<String, BIC> CACHE = new WeakHashMap<>();

  /**
   * BIC regexp.
   */
  @SuppressWarnings("java:S5867")
  private static final Pattern BIC_REGEXP = Pattern.compile("^[A-Z0-9]{4}[A-Z]{2}[A-Z2-9][0-9A-NP-Z](XXX|[0-9A-WY-Z][0-9A-Z]{2})?$"); //$NON-NLS-1$

  /**
   * BIC.
   */
  private final String bic;


  /**
   * Constructor.
   *
   * @param bic BIC
   * @throws NullPointerException if bic is null
   * @throws IllegalArgumentException if bic is not a correct bic
   */
  private BIC(final String bic)
   {
    super();
    Objects.requireNonNull(bic, "bic"); //$NON-NLS-1$
    if ((bic.length() != 8) && (bic.length() != 11))
     {
      throw new IllegalArgumentException("BIC with wrong length"); //$NON-NLS-1$
     }
    if (!BIC.BIC_REGEXP.matcher(bic).matches())
     {
      throw new IllegalArgumentException("BIC with wrong format"); //$NON-NLS-1$
     }
    /* final Country country = */ Country.of(bic.substring(4, 6));
    this.bic = bic;
   }


  /**
   * BIC factory.
   *
   * @param bic BIC
   * @return BIC object
   */
  public static BIC of(final String bic)
   {
    synchronized (BIC.class)
     {
      BIC obj = BIC.CACHE.get(bic);
      if (obj != null)
       {
        return obj;
       }
      obj = new BIC(bic);
      BIC.CACHE.put(bic, obj);
      return obj;
     }
   }


  /**
   * Returns the value of this BIC as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.bic;
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
    return this.bic.hashCode();
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
    if (!(obj instanceof BIC))
     {
      return false;
     }
    final BIC other = (BIC)obj;
    return this.bic.equals(other.bic);
   }


  /**
   * Returns the string representation of this BIC.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "BIC[bic=BELADEBEXXX]"
   *
   * @return String representation of this BIC
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("BIC[bic=").append(this.bic).append(']'); //$NON-NLS-1$
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
  public int compareTo(final BIC obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.bic.compareTo(obj.bic);
   }

 }
