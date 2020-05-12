/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * IP V6 mask.
 *
 * Not DSGVO relevant.
 */
public final class IPV6Mask implements Comparable<IPV6Mask>
 {
  /**
   * Prefix length.
   */
  private final int length;


  /**
   * Constructor.
   *
   * @param length Prefix length (0-128)
   * @throws IndexOutOfBoundsException if the prefix length is < 0 or > 128
   */
  public IPV6Mask(final int length)
   {
    super();
    if ((length < 0) || (length > 128))
     {
      throw new IndexOutOfBoundsException("Netmask prefix < 0 or > 128"); //$NON-NLS-1$
     }
    this.length = length;
   }


  /**
   * IPV6Mask factory.
   *
   * @param length IP V6 prefix length
   * @return IPV6Mask object
   */
  public static IPV6Mask of(final int length)
   {
    return new IPV6Mask(length);
   }


  /**
   * Get prefix length.
   *
   * @return Prefix length (0-128)
   */
  public int getLength()
   {
    return this.length;
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
    return Integer.hashCode(this.length);
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
    if (!(obj instanceof IPV6Mask))
     {
      return false;
     }
    final IPV6Mask other = (IPV6Mask)obj;
    return this.length == other.length;
   }


  /**
   * Returns the string representation of this IPV4Address.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "IPV6Mask[length=128, mask=]"
   *
   * @return String representation of this IPV4Mask
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("IPV6Mask[length=").append(this.length).append(']'); //$NON-NLS-1$
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
  public int compareTo(final IPV6Mask obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(this.length, obj.length);
   }

 }
