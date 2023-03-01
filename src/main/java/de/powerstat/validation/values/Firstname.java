/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;


/**
 * Firstname.
 *
 * DSGVO relevant.
 *
 * @see <a href="https://de.wikipedia.org/wiki/Vorname_(Deutschland)">Vorname</a>
 */
public record Firstname(String firstname) implements Comparable<Firstname>
 {
  /**
   * Firstname regexp.
   */
  private static final Pattern FIRSTNAME_REGEXP = Pattern.compile("^[\\p{L}][\\p{L}-]*$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param firstname Firstname
   *
   * @throws NullPointerException if firstname is null
   * @throws IllegalArgumentException if firstname contains unsupported characters or is to long or short
   */
  public Firstname
   {
    Objects.requireNonNull(firstname, "firstname"); //$NON-NLS-1$
    if ((firstname.length() < 1) || (firstname.length() > 32))
     {
      throw new IllegalArgumentException("Firstname with wrong length"); //$NON-NLS-1$
     }
    if (!Firstname.FIRSTNAME_REGEXP.matcher(firstname).matches())
     {
      throw new IllegalArgumentException("Firstname with wrong format"); //$NON-NLS-1$
     }
   }


  /**
   * Firstname factory.
   *
   * @param firstname Firstname
   * @return Firstname object
   */
  public static Firstname of(final String firstname)
   {
    return new Firstname(firstname);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Firstname obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.firstname.compareTo(obj.firstname);
   }

 }
