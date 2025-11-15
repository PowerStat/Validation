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
 * @param topLevelDomain Top level domain name (without dot)
 * 
 * Not DSGVO relevant.
 */
public record TopLevelDomain(String topLevelDomain) implements Comparable<TopLevelDomain>, IValueObject
 {
  /**
   * Top level domain regexp.
   */
  private static final Pattern TOPLEVELDOMAIN_REGEXP = Pattern.compile("^[0-9a-zA-Z-]+$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param topLevelDomain Top level domain name (without dot)
   * @throws NullPointerException if top level domain is null
   * @throws IllegalArgumentException if top level domain is not a known top level domain
   */
  public TopLevelDomain
   {
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
   }


  /**
   * TopLevelDomain factory.
   *
   * @param topLevelDomain TopLevelDomain
   * @return TopLevelDomain object
   */
  public static TopLevelDomain of(final String topLevelDomain)
   {
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
