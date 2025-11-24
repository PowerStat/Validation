/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Business Identifier Code (BIC) ISO 9362.
 *
 * Not DSGVO relevant.
 */
public final class BIC implements Comparable<BIC>, IValueObject
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<String, BIC> CACHE = new WeakHashMap<>();

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
    /*
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
    */
    return new BIC(bic);
   }


  /**
   * Returns the value of this BIC as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return bic;
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
    return bic.hashCode();
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
    if (!(obj instanceof final BIC other))
     {
      return false;
     }
    return bic.equals(other.bic);
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
    builder.append("BIC[bic=").append(bic).append(']'); //$NON-NLS-1$
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
    return bic.compareTo(obj.bic);
   }

 }
