/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address Sub building.
 *
 * Possibly DSGVO relevant.
 */
public final class SubBuilding implements Comparable<SubBuilding>, IValueObject
 {
  /**
   * Subbuilding regexp.
   */
  private static final Pattern SUBBUILDING_REGEXP = Pattern.compile("^[\\p{L}][\\p{L}\\p{Digit}., -]*$"); //$NON-NLS-1$

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
    if (subBuilding.isEmpty() || (subBuilding.length() > 32))
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
    return new SubBuilding(subBuilding);
   }


  /**
   * Returns the value of this SubBuilding as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return subBuilding;
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
    return subBuilding.hashCode();
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
    if (!(obj instanceof final SubBuilding other))
     {
      return false;
     }
    return subBuilding.equals(other.subBuilding);
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
    final var builder = new StringBuilder(25);
    builder.append("SubBuilding[subBuilding=").append(subBuilding).append(']'); //$NON-NLS-1$
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
    return subBuilding.compareTo(obj.subBuilding);
   }

 }
