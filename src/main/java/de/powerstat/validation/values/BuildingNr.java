/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address Building number.
 *
 * @param buildingNr Building number
 *
 * Possibly DSGVO relevant.
 *
 * TODO optimize constructor/compareTo
 */
@ValueObject
public record BuildingNr(String buildingNr) implements Comparable<BuildingNr>, IValueObject
 {
  /* *
   * Logger.
   */
  // private static final Logger LOGGER = LogManager.getLogger(BuildingNr.class);

  /**
   * Building nr regexp.
   */
  private static final Pattern BUILDINGNR_REGEXP = Pattern.compile("^(\\d{1,5})(([-/])(\\d{1,5}))?( (\\d{1,3})/(\\d{1,3}))?( ([a-z]))?$"); //$NON-NLS-1$

  /**
   * Maximum known building nr in the world.
   */
  private static final int MAX_KNOWN_BUILDING_NR = 29999;


  /**
   * Constructor.
   *
   * @param buildingNr Building number
   * @throws NullPointerException if buildingNr is null
   * @throws IllegalArgumentException if buildingNr is not an correct buildingNr
   */
  public BuildingNr
   {
    Objects.requireNonNull(buildingNr, "buildingNr"); //$NON-NLS-1$
    if (buildingNr.isEmpty() || (buildingNr.length() > 21))
     {
      throw new IllegalArgumentException("BuildingNr with wrong length"); //$NON-NLS-1$
     }
    final var matcher = BuildingNr.BUILDINGNR_REGEXP.matcher(buildingNr);
    if (!matcher.matches())
     {
      throw new IllegalArgumentException("BuildingNr with wrong format"); //$NON-NLS-1$
     }
    // group 1: building nr (from) 42:   42
    // group 4: building nr (to) 42-43:  43
    // group 6: numerator 3/4:         3
    // group 7: denominator 3/4:       4
    // group 8: alphabetic character:  a
    if ((matcher.group(1) != null) && (Integer.parseInt(matcher.group(1)) > BuildingNr.MAX_KNOWN_BUILDING_NR))
     {
      throw new IllegalArgumentException("BuildingNr > " + BuildingNr.MAX_KNOWN_BUILDING_NR); //$NON-NLS-1$
     }
    if ((matcher.group(1) != null) && (matcher.group(4) != null) && (Integer.compare(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(4))) >= 0))
     {
      throw new IllegalArgumentException("BuildingNr from >= BuildingNr to"); //$NON-NLS-1$
     }
    if ((matcher.group(6) != null) && (matcher.group(7) != null) && (Integer.compare(Integer.parseInt(matcher.group(6)), Integer.parseInt(matcher.group(7))) > 0))
     {
      throw new IllegalArgumentException("BuildingNr numerator > denominator"); //$NON-NLS-1$
     }
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
   * Returns the value of this BuildingNr as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return buildingNr;
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
    final var matcher1 = BuildingNr.BUILDINGNR_REGEXP.matcher(buildingNr);
    final var matcher2 = BuildingNr.BUILDINGNR_REGEXP.matcher(obj.buildingNr);
    /* boolean result1 = */ matcher1.matches();
    /* boolean result2 = */ matcher2.matches();
    // group 1: building nr (from) 42:   42
    // group 4: building nr (to) 42-43:  43
    // group 6: numerator 3/4:         3
    // group 7: denominator 3/4:       4
    // group 8: alphabetic character:  a
    final String bnr1 = matcher1.group(1);
    final String bnr2 = matcher2.group(1);
    int result = Integer.compare(Integer.parseInt(bnr1), Integer.parseInt(bnr2));
    if (result == 0)
     {
      if ((matcher1.group(7) != null) || (matcher2.group(7) != null)) // 3/4
       {
        if (matcher1.group(7) == null)
         {
          return -1;
         }
        if (matcher2.group(7) == null)
         {
          return 1;
         }
        if ((matcher1.group(7) != null) && (matcher2.group(7) != null) && (matcher1.group(7).compareTo(matcher2.group(7)) != 0))
         {
          throw new IllegalStateException("BuildingNrs do not have the same denominator"); //$NON-NLS-1$
         }
        result = Integer.compare(Integer.parseInt(matcher1.group(6)), Integer.parseInt(matcher2.group(6)));
        if (result != 0)
         {
          return result;
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
