/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.finance;


import java.util.Objects;
import java.util.regex.Pattern;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;
import de.powerstat.ddd.values.geo.Country;


/**
 * Business Identifier Code (BIC) ISO 9362.
 *
 * @param bic Business Identifier Code
 *
 * Not DSGVO relevant.
 */
@ValueObject
public record BIC(String bic) implements Comparable<BIC>, IValueObject
 {
  /**
   * BIC regexp.
   */
  @SuppressWarnings("java:S5867")
  private static final Pattern BIC_REGEXP = Pattern.compile("^[A-Z0-9]{4}[A-Z]{2}[A-Z2-9][0-9A-NP-Z](XXX|[0-9A-WY-Z][0-9A-Z]{2})?$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param bic Business Identifier Code
   * @throws NullPointerException if bic is null
   * @throws IllegalArgumentException if bic is not a correct bic
   */
  public BIC
   {
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
   }


  /**
   * BIC factory.
   *
   * @param bic BIC
   * @return BIC object
   */
  public static BIC of(final String bic)
   {
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
