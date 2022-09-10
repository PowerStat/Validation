/*
 * Copyright (C) 2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Lastname.
 *
 * DSGVO relevant.
 */
public class Lastname implements Comparable<Lastname>
 {
  /**
   * Lastname.
   */
  private final String lastname;


  /**
   * Constructor.
   *
   * @param lastname Lastname
   *
   * @throws NullPointerException if lastname is null
   * @throws IllegalArgumentException if lastname contains unsupported characters or is to long or short
   */
  public Lastname(final String lastname)
   {
    super();
    Objects.requireNonNull(lastname, "lastname"); //$NON-NLS-1$
    if ((lastname.length() < 1) || (lastname.length() > 40))
     {
      throw new IllegalArgumentException("Lastname with wrong length"); //$NON-NLS-1$
     }
    if (!lastname.matches("^[\\p{L}][\\p{L} -]*$")) //$NON-NLS-1$
     {
      throw new IllegalArgumentException("Lastname with wrong format"); //$NON-NLS-1$
     }
    this.lastname = lastname;
   }


  /**
   * Lastname factory.
   *
   * @param lastname Lastname
   * @return Lastname object
   */
  public static Lastname of(final String lastname)
   {
    return new Lastname(lastname);
   }


  /**
   * Get lastname string.
   *
   * @return Lastname string
   */
  public String getLastname()
   {
    return this.lastname;
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
    return this.lastname.hashCode();
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
    if (!(obj instanceof Lastname))
     {
      return false;
     }
    final Lastname other = (Lastname)obj;
    return this.lastname.equals(other.lastname);
   }


  /**
   * Returns the string representation of this Lastname.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Lastname[lastname=Hofmann]"
   *
   * @return String representation of this Lastname
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Lastname[lastname=").append(this.lastname).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Lastname obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.lastname.compareTo(obj.lastname);
   }

 }
