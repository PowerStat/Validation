/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.generated.GeneratedTlds;
import de.powerstat.validation.interfaces.IValueObject;


/**
 * Top level domain.
 *
 * Not DSGVO relevant.
 */
public final class TopLevelDomain implements Comparable<TopLevelDomain>, IValueObject
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<String, TopLevelDomain> CACHE = new WeakHashMap<>();

  /**
   * Top level domain regexp.
   */
  private static final Pattern TOPLEVELDOMAIN_REGEXP = Pattern.compile("^[0-9a-zA-Z-]+$"); //$NON-NLS-1$

  /**
   * Top level domain.
   */
  private final String topLevelDomain;


  /**
   * Constructor.
   *
   * @param topLevelDomain Top level domain name (without dot)
   * @throws NullPointerException if top level domain is null
   * @throws IllegalArgumentException if top level domain is not a known top level domain
   */
  private TopLevelDomain(final String topLevelDomain)
   {
    super();
    Objects.requireNonNull(topLevelDomain, "topLevelDomain"); //$NON-NLS-1$
    if ((topLevelDomain.length() < 2) || (topLevelDomain.length() > 63)) // actual (2020) longest in use is 24  // NO PITEST
     {
      throw new IllegalArgumentException("To short or long for a top level domain"); //$NON-NLS-1$
     }
    if ((topLevelDomain.charAt(0) == '-') || (topLevelDomain.charAt(topLevelDomain.length() - 1) == '-'))
     {
      throw new IllegalArgumentException("Illegal character '-' at name start or end"); //$NON-NLS-1$
     }
    if (!TopLevelDomain.TOPLEVELDOMAIN_REGEXP.matcher(topLevelDomain).matches())
     {
      throw new IllegalArgumentException("Top level domain contains illegal character"); //$NON-NLS-1$
     }
    if (!GeneratedTlds.contains(topLevelDomain))
     {
      throw new IllegalArgumentException("Unknown top level domain"); //$NON-NLS-1$
     }
    this.topLevelDomain = topLevelDomain;
   }


  /**
   * TopLevelDomain factory.
   *
   * @param topLevelDomain TopLevelDomain
   * @return TopLevelDomain object
   */
  public static TopLevelDomain of(final String topLevelDomain)
   {
    /*
    synchronized (TopLevelDomain.class)
     {
      TopLevelDomain obj = TopLevelDomain.CACHE.get(topLevelDomain);
      if (obj != null)
       {
        return obj;
       }
      obj = new TopLevelDomain(topLevelDomain);
      TopLevelDomain.CACHE.put(topLevelDomain, obj);
      return obj;
     }
    */
    return new TopLevelDomain(topLevelDomain);
   }


  /**
   * Returns the value of this TopLevelDomain as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.topLevelDomain;
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
    return this.topLevelDomain.hashCode();
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
    if (!(obj instanceof final TopLevelDomain other))
     {
      return false;
     }
    return this.topLevelDomain.equals(other.topLevelDomain);
   }


  /**
   * Returns the string representation of this TopLevelDomain.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "TopLevelDomain[topLevelDomain=de]"
   *
   * @return String representation of this TopLevelDomain
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(31);
    builder.append("TopLevelDomain[topLevelDomain=").append(this.topLevelDomain).append(']'); //$NON-NLS-1$
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
  public int compareTo(final TopLevelDomain obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.topLevelDomain.compareTo(obj.topLevelDomain);
   }

 }
