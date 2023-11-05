/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address Neighbourhood.
 *
 * @param neighbourhood Neighbourhood
 * 
 * Not DSGVO relevant.
 */
public record Neighbourhood(String neighbourhood) implements Comparable<Neighbourhood>, IValueObject
 {
  /**
   * Neighbourhood fregexp.
   */
  private static final Pattern NEIGHBOURHOOD_REGEXP = Pattern.compile("^[\\p{L}][\\p{L}\\p{Digit}. -]*$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param neighbourhood Neighbourhood
   * @throws NullPointerException if neighbourhood is null
   * @throws IllegalArgumentException if neighbourhood is not a correct neighbourhood
   */
  public Neighbourhood
   {
    Objects.requireNonNull(neighbourhood, "neighbourhood"); //$NON-NLS-1$
    if ((neighbourhood.length() < 1) || (neighbourhood.length() > 64))
     {
      throw new IllegalArgumentException("Neighbourhood with wrong length"); //$NON-NLS-1$
     }
    if (!Neighbourhood.NEIGHBOURHOOD_REGEXP.matcher(neighbourhood).matches())
     {
      throw new IllegalArgumentException("Neighbourhood with wrong format"); //$NON-NLS-1$
     }
   }


  /**
   * Neighbourhood factory.
   *
   * @param neighbourhood Neighbourhood
   * @return Neighbourhood object
   */
  public static Neighbourhood of(final String neighbourhood)
   {
    return new Neighbourhood(neighbourhood);
   }


  /**
   * Returns the value of this Neighbourhood as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.neighbourhood;
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
