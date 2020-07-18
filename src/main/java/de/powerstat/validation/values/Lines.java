/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Address Lines.
 *
 * Not DSGVO relevant.
 */
public final class Lines implements Comparable<Lines>
 {
  /**
   * Lines.
   */
  private final String lines;


  /**
   * Constructor.
   *
   * @param lines Lines (1-5)
   * @throws NullPointerException if lines is null
   * @throws IllegalArgumentException if lines is not a correct Lines
   */
  public Lines(final String lines)
   {
    super();
    Objects.requireNonNull(lines, "lines"); //$NON-NLS-1$
    if ((lines.length() < 1) || (lines.length() > 200))
     {
      throw new IllegalArgumentException("Lines with wrong length"); //$NON-NLS-1$
     }
    if (!lines.matches("^([\\p{L}\\p{Digit},.& -]|\\R)*$")) //$NON-NLS-1$
     {
      throw new IllegalArgumentException("Lines with wrong format"); //$NON-NLS-1$
     }
    if (lines.lines().count() > 5)
     {
      throw new IllegalArgumentException("Do not use more than 5 lines"); //$NON-NLS-1$
     }
    this.lines = lines;
   }


  /**
   * Lines factory.
   *
   * @param lines Lines
   * @return Lines object
   */
  public static Lines of(final String lines)
   {
    return new Lines(lines);
   }


  /**
   * Get lines string.
   *
   * @return Lines string
   */
  public String getLines()
   {
    return this.lines;
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
    return this.lines.hashCode();
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
    if (!(obj instanceof Lines))
     {
      return false;
     }
    final Lines other = (Lines)obj;
    return this.lines.equals(other.lines);
   }


  /**
   * Returns the string representation of this Lines.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Lines[lines=Example1]"
   *
   * @return String representation of this Lines
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Lines[lines=").append(this.lines.replaceAll("\n", "\\\\n").replaceAll("\r", "\\\\r")).append(']'); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
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
  public int compareTo(final Lines obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.lines.compareTo(obj.lines);
   }

 }


