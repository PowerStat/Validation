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
 * Address Sub building.
 *
 * Possibly DSGVO relevant.
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class SubBuilding implements Comparable<SubBuilding>, IValueObject
 {
  /**
   * Cache for singletons.
   */
  private static final Map<String, SubBuilding> CACHE = new WeakHashMap<>();

  /**
   * Subbuilding regexp.
   */
  private static final Pattern SUBBUILDING_REGEXP = Pattern.compile("^[\\p{L}][\\p{L}\\p{Digit}., -]*$"); //$NON-NLS-1$

  /**
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$

  /**
   * Sub building.
   */
  private final String subBuilding;


  /**
   * Constructor.
   *
   * @param subBuilding Sub building description
   * @throws NullPointerException if subBuilding is null
   * @throws IllegalArgumentException if subBuilding is not correct
   */
  private SubBuilding(final String subBuilding)
   {
    super();
    Objects.requireNonNull(subBuilding, "subBuilding"); //$NON-NLS-1$
    if ((subBuilding.length() < 1) || (subBuilding.length() > 32))
     {
      throw new IllegalArgumentException("SubBuilding with wrong length"); //$NON-NLS-1$
     }
    if (!SubBuilding.SUBBUILDING_REGEXP.matcher(subBuilding).matches())
     {
      throw new IllegalArgumentException("SubBuilding with wrong format"); //$NON-NLS-1$
     }
    this.subBuilding = subBuilding;
   }


  /**
   * SubBuilding factory.
   *
   * @param subBuilding Sub building
   * @return SubBuilding object
   */
  public static SubBuilding of(final String subBuilding)
   {
    synchronized (SubBuilding.class)
     {
      SubBuilding obj = SubBuilding.CACHE.get(subBuilding);
      if (obj != null)
       {
        return obj;
       }
      obj = new SubBuilding(subBuilding);
      SubBuilding.CACHE.put(subBuilding, obj);
      return obj;
     }
   }


  /**
   * Get subBuilding string.
   *
   * @return SubBuilding string
   * @deprecated Use stringValue() instead
   */
  @Deprecated(since = SubBuilding.DEPRECATED_SINCE_3_0, forRemoval = false)
  public String getSubBuilding()
   {
    return this.subBuilding;
   }


  /**
   * Returns the value of this SubBuilding as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.subBuilding;
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
    return this.subBuilding.hashCode();
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
    if (!(obj instanceof SubBuilding))
     {
      return false;
     }
    final SubBuilding other = (SubBuilding)obj;
    return this.subBuilding.equals(other.subBuilding);
   }


  /**
   * Returns the string representation of this SubBuilding.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "SubBuilding[subBuilding=Floor 13, Apart. 0815]"
   *
   * @return String representation of this SubBuilding
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(25);
    builder.append("SubBuilding[subBuilding=").append(this.subBuilding).append(']'); //$NON-NLS-1$
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
  public int compareTo(final SubBuilding obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.subBuilding.compareTo(obj.subBuilding);
   }

 }
