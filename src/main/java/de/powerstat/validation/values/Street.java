/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address Street.
 *
 * @param street Street name
 * 
 * Not DSGVO relevant.
 *
 * TODO Verify with openstreetmap
 */
public record Street(String street) implements Comparable<Street>, IValueObject
 {
  /**
   * Street regexp.
   */
  private static final Pattern STREET_REGEXP = Pattern.compile("^[\\p{L}][\\p{L}. -]*$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param street Street name
   * @throws NullPointerException if street is null
   * @throws IllegalArgumentException if street is not a correct Street name
   */
  public Street
   {
    Objects.requireNonNull(street, "street"); //$NON-NLS-1$
    if ((street.length() < 1) || (street.length() > 32))
     {
      throw new IllegalArgumentException("Street with wrong length"); //$NON-NLS-1$
     }
    if (!Street.STREET_REGEXP.matcher(street).matches())
     {
      throw new IllegalArgumentException("Street with wrong format"); //$NON-NLS-1$
     }
   }


  /**
   * Street factory.
   *
   * @param street Street
   * @return Street object
   */
  public static Street of(final String street)
   {
    return new Street(street);
   }


  /**
   * Returns the value of this Street as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.street;
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Street obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.street.compareTo(obj.street);
   }

 }
