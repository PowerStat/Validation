/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * Address Building number.
 *
 * Possibly DSGVO relevant.
 *
 * TODO optimize constructor/compareTo
 */
public final class BuildingNr implements Comparable<BuildingNr>
 {
  /**
   * Logger.
   */
  private static final Logger LOGGER = LogManager.getLogger(BuildingNr.class);

  /**
   * Regexp for buidling number formats.
   */
  private static final String BUILDING_NR_REGEXP = "^([0-9]{1,5})((-|/)([0-9]{1,5}))?( ([0-9]{1,3})/([0-9]{1,3}))?( ([a-z]))?$"; //$NON-NLS-1$

  /**
   * Maximum known building nr in the world.
   */
  private static final int MAX_KNOWN_BUILDING_NR = 29999;

  /**
   * Building number.
   */
  private final String buildingNr;


  /**
   * Constructor.
   *
   * @param buildingNr Building number
   * @throws NullPointerException if buildingNr is null
   * @throws IllegalArgumentException if buildingNr is not an correct buildingNr
   */
  public BuildingNr(final String buildingNr)
   {
    super();
    Objects.requireNonNull(buildingNr, "buildingNr"); //$NON-NLS-1$
    if ((buildingNr.length() < 1) || (buildingNr.length() > 21))
     {
      throw new IllegalArgumentException("BuildingNr with wrong length"); //$NON-NLS-1$
     }
    final Pattern pattern = Pattern.compile(BUILDING_NR_REGEXP);
    final Matcher matcher = pattern.matcher(buildingNr);
    if (!matcher.matches())
     {
      throw new IllegalArgumentException("BuildingNr with wrong format"); //$NON-NLS-1$
     }
    // group 1: building nr (from) 42:   42
    // group 4: building nr (to) 42-43:  43
    // group 6: numerator 3/4:         3
    // group 7: denominator 3/4:       4
    // group 8: alphabetic character:  a
    if (Integer.parseInt(matcher.group(1)) > MAX_KNOWN_BUILDING_NR)
     {
      throw new IllegalArgumentException("BuildingNr > " + MAX_KNOWN_BUILDING_NR); //$NON-NLS-1$
     }
    if ((matcher.group(4) != null) && (Integer.compare(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(4))) >= 0))
     {
      throw new IllegalArgumentException("BuildingNr from >= BuildingNr to"); //$NON-NLS-1$
     }
    if ((matcher.group(7) != null) && (Integer.compare(Integer.parseInt(matcher.group(6)), Integer.parseInt(matcher.group(7))) > 0))
     {
      throw new IllegalArgumentException("BuildingNr numerator > denominator"); //$NON-NLS-1$
     }
    this.buildingNr = buildingNr;
   }


  /**
   * BuildingNr factory.
   *
   * @param buildingNr Building number
   * @return BuildingNr object
   */
  public static BuildingNr of(final String buildingNr)
   {
    return new BuildingNr(buildingNr);
   }


  /**
   * Get buildingNr string.
   *
   * @return BuildingNr string
   */
  public String getBuildingNr()
   {
    return this.buildingNr;
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
    return this.buildingNr.hashCode();
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
    if (!(obj instanceof BuildingNr))
     {
      return false;
     }
    final BuildingNr other = (BuildingNr)obj;
    return this.buildingNr.equals(other.buildingNr);
   }


  /**
   * Returns the string representation of this BuildingNr.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "BuildingNr[buildingNr=42]"
   *
   * @return String representation of this BuildingNr
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(19);
    builder.append("BuildingNr[buildingNr=").append(this.buildingNr).append(']'); //$NON-NLS-1$
    return builder.toString();
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   *
   * TODO optimize (do regexp in constructor)
   */
  @Override
  public int compareTo(final BuildingNr obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    final Pattern pattern = Pattern.compile(BUILDING_NR_REGEXP);
    final Matcher matcher1 = pattern.matcher(this.buildingNr);
    final Matcher matcher2 = pattern.matcher(obj.buildingNr);
    if (!matcher1.matches() || !matcher2.matches())
     {
      throw new IllegalStateException("One or both of the two buildingNr objects does not match the buildingNr pattern"); //$NON-NLS-1$
     }
    // group 1: building nr (from) 42:   42
    // group 4: building nr (to) 42-43:  43
    // group 6: numerator 3/4:         3
    // group 7: denominator 3/4:       4
    // group 8: alphabetic character:  a
    int result = Integer.compare(Integer.parseInt(matcher1.group(1)), Integer.parseInt(matcher2.group(1)));
    if (result == 0)
     {
      if ((matcher1.group(7) != null) || (matcher2.group(7) != null)) // 3/4
       {
        if (matcher1.group(7) == null)
         {
          return -1;
         }
        else if (matcher2.group(7) == null)
         {
          return 1;
         }
        else
         {
          if (matcher1.group(7).compareTo(matcher2.group(7)) != 0)
           {
            throw new IllegalStateException("BuildingNrs do not have the same denominator"); //$NON-NLS-1$
           }
          result = Integer.compare(Integer.parseInt(matcher1.group(6)), Integer.parseInt(matcher2.group(6)));
          if (result != 0)
           {
            return result;
           }
         }
       }
      if ((matcher1.group(8) != null) || (matcher2.group(8) != null)) // a-z
       {
        if (matcher1.group(8) == null)
         {
          result = -1;
         }
        else if (matcher2.group(8) == null)
         {
          result = 1;
         }
        else
         {
          result = matcher1.group(8).compareTo(matcher2.group(8));
         }
       }
     }
    return result;
   }

 }
