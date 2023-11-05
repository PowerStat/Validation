/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * IP V6 mask.
 *
 * @param length Prefix length (0-128)
 * 
 * Not DSGVO relevant.
 */
public record IPV6Mask(int length) implements Comparable<IPV6Mask>, IValueObject
 {
  /**
   * Constructor.
   *
   * @param length Prefix length (0-128)
   * @throws IndexOutOfBoundsException if the prefix length is &lt; 0 or &gt; 128
   */
  public IPV6Mask
   {
    if ((length < 0) || (length > 128))
     {
      throw new IndexOutOfBoundsException("Netmask prefix < 0 or > 128"); //$NON-NLS-1$
     }
   }


  /**
   * IPV6Mask factory.
   *
   * @param length IP V6 prefix length (0-128)
   * @return IPV6Mask object
   */
  public static IPV6Mask of(final int length)
   {
    return new IPV6Mask(length);
   }


  /**
   * IPV6Mask factory.
   *
   * @param value IP V6 prefix length string (0-128)
   * @return IPV6Mask object
   */
  public static IPV6Mask of(final String value)
   {
    return of(Integer.parseInt(value));
   }


  /**
   * Returns the value of this IPV6Mask as an String.
   *
   * @return The numeric value represented by this object after conversion to type String (0-128).
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(this.length);
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
