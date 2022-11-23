/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Address Post office box number.
 *
 * DSGVO relevant.
 */
public final class PoBoxNumber implements Comparable<PoBoxNumber>
 {
  /**
   * Post office box number.
   */
  private final long poBoxNumber;


  /**
   * Constructor.
   *
   * @param poBoxNumber PO box number 1-..
   * @throws IndexOutOfBoundsException When the poBoxNumber is less than 1
   */
  public PoBoxNumber(final long poBoxNumber)
   {
    super();
    if (poBoxNumber < 1)
     {
      throw new IndexOutOfBoundsException("POBoxNumber number out of range (1-..)!"); //$NON-NLS-1$
     }
    this.poBoxNumber = poBoxNumber;
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
   * Get PO box number.
   *
   * @return PO box number
   * @deprecated Use longValue() instead
   */
  @Deprecated
  public long getPoBoxNumber()
   {
    return this.poBoxNumber;
   }


  /**
   * Returns the value of this BFPONumber as a long.
   *
   * @return The numeric value represented by this object after conversion to type long.
   */
  public long longValue()
   {
    return this.poBoxNumber;
   }


  /**
   * Get PO box number string.
   *
   * @return PO box number as string
   * @deprecated Use stringValue() instead
   */
  @Deprecated
  public String getPoBoxNumberStr()
   {
    return Long.toString(this.poBoxNumber);
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
   * Calculate hash code.
   *
   * @return Hash
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
   {
    return Long.hashCode(this.poBoxNumber);
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
    if (!(obj instanceof PoBoxNumber))
     {
      return false;
     }
    final PoBoxNumber other = (PoBoxNumber)obj;
    return this.poBoxNumber == other.poBoxNumber;
   }


  /**
   * Returns the string representation of this PoBoxNumber.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "PoBoxNumber[poBoxNumber=4711]"
   *
   * @return String representation of this PoBoxNumber
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(25);
    builder.append("PoBoxNumber[poBoxNumber=").append(this.poBoxNumber).append(']'); //$NON-NLS-1$
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
  public int compareTo(final PoBoxNumber obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Long.compare(this.poBoxNumber, obj.poBoxNumber);
   }

 }
