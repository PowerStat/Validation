/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address District.
 *
 * @param district District name
 * 
 * Not DSGVO relevant.
 */
public record District(String district) implements Comparable<District>, IValueObject
 {
  /**
   * District egexp.
   */
  private static final Pattern DISTRICT_REGEXP = Pattern.compile("^[\\p{L}\\p{Digit}][\\p{L}\\p{Digit} -]*$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param district District name
   * @throws NullPointerException if district is null
   * @throws IllegalArgumentException if district is not a correct district name
   */
  public District
   {
    Objects.requireNonNull(district, "district"); //$NON-NLS-1$
    if ((district.length() < 1) || (district.length() > 18))
     {
      throw new IllegalArgumentException("District with wrong length"); //$NON-NLS-1$
     }
    if (!District.DISTRICT_REGEXP.matcher(district).matches())
     {
      throw new IllegalArgumentException("District with wrong format"); //$NON-NLS-1$
     }
   }


  /**
   * District factory.
   *
   * @param district District
   * @return District object
   */
  public static District of(final String district)
   {
    return new District(district);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final District obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.district.compareTo(obj.district);
   }

 }
