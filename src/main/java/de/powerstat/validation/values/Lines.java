/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address Lines.
 *
 * @param lines Lines (1-5)
 * 
 * Not DSGVO relevant.
 */
public record Lines(String lines) implements Comparable<Lines>, IValueObject
 {
  /**
   * Lines fregexp.
   */
  @SuppressWarnings("java:S6035")
  private static final Pattern LINES_REGEXP = Pattern.compile("^([\\p{L}\\p{Digit},.& -]|\\R)*+$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param lines Lines (1-5)
   * @throws NullPointerException if lines is null
   * @throws IllegalArgumentException if lines is not a correct Lines
   */
  public Lines
   {
    Objects.requireNonNull(lines, "lines"); //$NON-NLS-1$
    if ((lines.length() < 1) || (lines.length() > 200))
     {
      throw new IllegalArgumentException("Lines with wrong length"); //$NON-NLS-1$
     }
    if (!Lines.LINES_REGEXP.matcher(lines).matches())
     {
      throw new IllegalArgumentException("Lines with wrong format"); //$NON-NLS-1$
     }
    if (lines.lines().count() > 5)
     {
      throw new IllegalArgumentException("Do not use more than 5 lines"); //$NON-NLS-1$
     }
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


