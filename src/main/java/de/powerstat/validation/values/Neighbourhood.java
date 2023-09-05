/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address Neighbourhood.
 *
 * Not DSGVO relevant.
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class Neighbourhood implements Comparable<Neighbourhood>, IValueObject
 {
  /**
   * Cache for singletons.
   */
  private static final Map<String, Neighbourhood> CACHE = new WeakHashMap<>();

  /**
   * Neighbourhood fregexp.
   */
  private static final Pattern NEIGHBOURHOOD_REGEXP = Pattern.compile("^[\\p{L}][\\p{L}\\p{Digit}. -]*$"); //$NON-NLS-1$

  /**
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$

  /**
   * Neighbourhood.
   */
  private final String neighbourhood;


  /**
   * Constructor.
   *
   * @param neighbourhood Neighbourhood
   * @throws NullPointerException if neighbourhood is null
   * @throws IllegalArgumentException if neighbourhood is not a correct neighbourhood
   */
  private Neighbourhood(final String neighbourhood)
   {
    super();
    Objects.requireNonNull(neighbourhood, "neighbourhood"); //$NON-NLS-1$
    if ((neighbourhood.length() < 1) || (neighbourhood.length() > 64))
     {
      throw new IllegalArgumentException("Neighbourhood with wrong length"); //$NON-NLS-1$
     }
    if (!Neighbourhood.NEIGHBOURHOOD_REGEXP.matcher(neighbourhood).matches())
     {
      throw new IllegalArgumentException("Neighbourhood with wrong format"); //$NON-NLS-1$
     }
    this.neighbourhood = neighbourhood;
   }


  /**
   * Neighbourhood factory.
   *
   * @param neighbourhood Neighbourhood
   * @return Neighbourhood object
   */
  public static Neighbourhood of(final String neighbourhood)
   {
    synchronized (Neighbourhood.class)
     {
      Neighbourhood obj = Neighbourhood.CACHE.get(neighbourhood);
      if (obj != null)
       {
        return obj;
       }
      obj = new Neighbourhood(neighbourhood);
      Neighbourhood.CACHE.put(neighbourhood, obj);
      return obj;
     }
   }


  /**
   * Get neighbourhood string.
   *
   * @return Neighbourhood string
   * @deprecated Use stringValue() instead
   */
  @Deprecated(since = Neighbourhood.DEPRECATED_SINCE_3_0, forRemoval = false)
  public String getNeighbourhood()
   {
    return this.neighbourhood;
   }


  /**
   * Returns the value of this Neighbourhood as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  public String stringValue()
   {
    return this.neighbourhood;
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
    return this.neighbourhood.hashCode();
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
    if (!(obj instanceof Neighbourhood))
     {
      return false;
     }
    final Neighbourhood other = (Neighbourhood)obj;
    return this.neighbourhood.equals(other.neighbourhood);
   }


  /**
   * Returns the string representation of this Neighbourhood.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Neighbourhood[neighbourhood=...]"
   *
   * @return String representation of this Neighbourhood
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(29);
    builder.append("Neighbourhood[neighbourhood=").append(this.neighbourhood).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Neighbourhood obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.neighbourhood.compareTo(obj.neighbourhood);
   }

 }
