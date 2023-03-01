/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Address Post office box number.
 *
 * @param poBoxNumber PO box number 1-..
 * 
 * DSGVO relevant.
 */
public record PoBoxNumber(long poBoxNumber) implements Comparable<PoBoxNumber>
 {
  /**
   * Constructor.
   *
   * @throws IndexOutOfBoundsException When the poBoxNumber is less than 1
   */
  public PoBoxNumber
   {
    if (poBoxNumber < 1)
     {
      throw new IndexOutOfBoundsException("POBoxNumber number out of range (1-..)!"); //$NON-NLS-1$
     }
   }


  /**
   * PoBoxNumber factory.
   *
   * @param poBoxNumber Day 1-31
   * @return PoBoxNumber object
   */
  public static PoBoxNumber of(final long poBoxNumber)
   {
    return new PoBoxNumber(poBoxNumber);
   }


  /**
   * Returns the value of this PoBoNumber as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  public String stringValue()
   {
    return Long.toString(this.poBoxNumber);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final PoBoxNumber obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.poBoxNumber, obj.poBoxNumber);
   }

 }
