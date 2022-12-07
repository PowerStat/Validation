/*
 * Copyright (C) 2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.regex.Pattern;


/**
 * Firstname.
 *
 * DSGVO relevant.
 *
 * @see <a href="https://de.wikipedia.org/wiki/Vorname_(Deutschland)">Vorname</a>
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class Firstname implements Comparable<Firstname>
 {
  /**
   * Cache for singletons.
   */
  private static final Map<String, Firstname> CACHE = new WeakHashMap<>();

  /**
   * Firstname regexp.
   */
  private static final Pattern FIRSTNAME_REGEXP = Pattern.compile("^[\\p{L}][\\p{L}-]*$"); //$NON-NLS-1$

  /**
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$

  /**
   * Firstname.
   */
  private final String firstname;


  /**
   * Constructor.
   *
   * @param firstname Firstname
   *
   * @throws NullPointerException if firstname is null
   * @throws IllegalArgumentException if firstname contains unsupported characters or is to long or short
   */
  private Firstname(final String firstname)
   {
    super();
    Objects.requireNonNull(firstname, "firstname"); //$NON-NLS-1$
    if ((firstname.length() < 1) || (firstname.length() > 32))
     {
      throw new IllegalArgumentException("Firstname with wrong length"); //$NON-NLS-1$
     }
    if (!Firstname.FIRSTNAME_REGEXP.matcher(firstname).matches())
     {
      throw new IllegalArgumentException("Firstname with wrong format"); //$NON-NLS-1$
     }
    this.firstname = firstname;
   }


  /**
   * Firstname factory.
   *
   * @param firstname Firstname
   * @return Firstname object
   */
  public static Firstname of(final String firstname)
   {
    synchronized (Firstname.class)
     {
      Firstname obj = Firstname.CACHE.get(firstname);
      if (obj != null)
       {
        return obj;
       }
      obj = new Firstname(firstname);
      Firstname.CACHE.put(firstname, obj);
      return obj;
     }
   }


  /**
   * Get firstname string.
   *
   * @return Firstname string
   * @deprecated Use stringValue() instead
   */
  @Deprecated(since = Firstname.DEPRECATED_SINCE_3_0, forRemoval = false)
  public String getFirstname()
   {
    return this.firstname;
   }


  /**
   * Returns the value of this Firstname as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  public String stringValue()
   {
    return this.firstname;
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
    return this.firstname.hashCode();
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
    if (!(obj instanceof Firstname))
     {
      return false;
     }
    final Firstname other = (Firstname)obj;
    return this.firstname.equals(other.firstname);
   }


  /**
   * Returns the string representation of this Firstname.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Firstname[firstname=Kai]"
   *
   * @return String representation of this Firstname
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(21);
    builder.append("Firstname[firstname=").append(this.firstname).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Firstname obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.firstname.compareTo(obj.firstname);
   }

 }
