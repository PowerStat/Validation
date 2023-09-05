/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address Building name.
 *
 * @param buildingName Building name
 *
 * Not DSGVO relevant.
 */
public record BuildingName(String buildingName) implements Comparable<BuildingName>, IValueObject
 {
  /**
   * Building name regexp.
   */
  private static final Pattern BUILDNINGNAME_REGEXP = Pattern.compile("^[\\p{L}][\\p{L} -]*$");


  /**
   * Constructor.
   *
   * @param buildingName Building name
   * @throws NullPointerException if buildingName is null
   * @throws IllegalArgumentException if buildingName is not a correct building name
   */
  public BuildingName
   {
    Objects.requireNonNull(buildingName, "buildingName"); //$NON-NLS-1$
    if ((buildingName.length() < 1) || (buildingName.length() > 32))
     {
      throw new IllegalArgumentException("Building name with wrong length"); //$NON-NLS-1$
     }
    if (!BuildingName.BUILDNINGNAME_REGEXP.matcher(buildingName).matches())
     {
      throw new IllegalArgumentException("Building name with wrong format"); //$NON-NLS-1$
     }
   }


  /**
   * BuildingName factory.
   *
   * @param buildingName Building name
   * @return BuildingName object
   */
  public static BuildingName of(final String buildingName)
   {
    return new BuildingName(buildingName);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final BuildingName obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.buildingName.compareTo(obj.buildingName);
   }

 }
