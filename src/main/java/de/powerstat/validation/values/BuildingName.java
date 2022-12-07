/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.regex.Pattern;


/**
 * Address Building name.
 *
 * Not DSGVO relevant.
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class BuildingName implements Comparable<BuildingName>
 {
  /**
   * Cache for singletons.
   */
  private static final Map<String, BuildingName> CACHE = new WeakHashMap<>();

  /**
   * Building name regexp.
   */
  private static final Pattern BUILDNINGNAME_REGEXP = Pattern.compile("^[\\p{L}][\\p{L} -]*$");

  /**
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$

  /**
   * Building name.
   */
  private final String buildingName;


  /**
   * Constructor.
   *
   * @param buildingName Building name
   * @throws NullPointerException if buildingName is null
   * @throws IllegalArgumentException if buildingName is not a correct building name
   */
  private BuildingName(final String buildingName)
   {
    super();
    Objects.requireNonNull(buildingName, "buildingName"); //$NON-NLS-1$
    if ((buildingName.length() < 1) || (buildingName.length() > 32))
     {
      throw new IllegalArgumentException("Building name with wrong length"); //$NON-NLS-1$
     }
    if (!BuildingName.BUILDNINGNAME_REGEXP.matcher(buildingName).matches())
     {
      throw new IllegalArgumentException("Building name with wrong format"); //$NON-NLS-1$
     }
    this.buildingName = buildingName;
   }


  /**
   * BuildingName factory.
   *
   * @param buildingName Building name
   * @return BuildingName object
   */
  public static BuildingName of(final String buildingName)
   {
    synchronized (BuildingName.class)
     {
      BuildingName obj = BuildingName.CACHE.get(buildingName);
      if (obj != null)
       {
        return obj;
       }
      obj = new BuildingName(buildingName);
      BuildingName.CACHE.put(buildingName, obj);
      return obj;
     }
   }


  /**
   * Get building name string.
   *
   * @return BuildingName string
   * @deprecated Use stringValue() instead
   */
  @Deprecated(since = BuildingName.DEPRECATED_SINCE_3_0, forRemoval = false)
  public String getBuildingName()
   {
    return this.buildingName;
   }


  /**
   * Returns the value of this BuildingName as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  public String stringValue()
   {
    return this.buildingName;
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
    return this.buildingName.hashCode();
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
    if (!(obj instanceof BuildingName))
     {
      return false;
     }
    final BuildingName other = (BuildingName)obj;
    return this.buildingName.equals(other.buildingName);
   }


  /**
   * Returns the string representation of this BuildingName.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "BuildingName[buildingName=Rathaus]"
   *
   * @return String representation of this BuildingName
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(27);
    builder.append("BuildingName[buildingName=").append(this.buildingName).append(']'); //$NON-NLS-1$
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
  public int compareTo(final BuildingName obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.buildingName.compareTo(obj.buildingName);
   }

 }
