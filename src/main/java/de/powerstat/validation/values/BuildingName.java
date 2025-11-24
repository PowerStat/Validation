/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
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
    if (buildingName.isEmpty() || (buildingName.length() > 32))
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
   * Returns the value of this BuildingName as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return buildingName;
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
    return buildingName.compareTo(obj.buildingName);
   }

 }
