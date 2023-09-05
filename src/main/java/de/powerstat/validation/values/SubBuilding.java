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
 * @param subBuilding Sub building description
 * 
 * Possibly DSGVO relevant.
 */
public record SubBuilding(String subBuilding) implements Comparable<SubBuilding>, IValueObject
 {
  /**
   * Subbuilding regexp.
   */
  private static final Pattern SUBBUILDING_REGEXP = Pattern.compile("^[\\p{L}][\\p{L}\\p{Digit}., -]*$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param subBuilding Sub building description
   * @throws NullPointerException if subBuilding is null
   * @throws IllegalArgumentException if subBuilding is not correct
   */
  public SubBuilding
   {
    Objects.requireNonNull(subBuilding, "subBuilding"); //$NON-NLS-1$
    if ((subBuilding.length() < 1) || (subBuilding.length() > 32))
     {
      throw new IllegalArgumentException("SubBuilding with wrong length"); //$NON-NLS-1$
     }
    if (!SubBuilding.SUBBUILDING_REGEXP.matcher(subBuilding).matches())
     {
      throw new IllegalArgumentException("SubBuilding with wrong format"); //$NON-NLS-1$
     }
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
