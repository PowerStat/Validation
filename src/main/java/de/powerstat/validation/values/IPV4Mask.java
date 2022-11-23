/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;


/**
 * IP V4 mask.
 *
 * Not DSGVO relevant.
 *
 * TODO IPV4Address filterMin(IPV4Address)      0
 * TODO IPV4Address filterMax(IPV4Address)      255
 */
public final class IPV4Mask implements Comparable<IPV4Mask>
 {
  /**
   * 0.
   */
  private static final String ZERO = "0"; //$NON-NLS-1$

  /**
   * Bitmask array.
   */
  private static final String[] BITMASKS = {IPV4Mask.ZERO, "128", "192", "224", "240", "248", "252", "254", "255"}; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$

  /**
   * IP V4 mask regexp.
   */
  private static final Pattern IPV4_MASK_REGEXP = Pattern.compile("^(((255\\.){3}(255|254|252|248|240|224|192|128|0))|((255\\.){2}(254|252|248|240|224|192|128|0)\\.0)|((255\\.)(254|252|248|240|224|192|128|0)(\\.0){2})|((254|252|248|240|224|192|128|0)(\\.0){3}))$"); //$NON-NLS-1$

  /**
   * Prefix length.
   */
  private final int length;

  /**
   * Mask.
   */
  private final String mask;


  /**
   * Constructor.
   *
   * @param length Prefix length (0-32)
   * @throws IndexOutOfBoundsException if the prefix length is &lt; 0 or &gt; 32
   */
  public IPV4Mask(final int length)
   {
    super();
    if ((length < 0) || (length > 32))
     {
      throw new IndexOutOfBoundsException("Netmask prefix < 0 or > 32"); //$NON-NLS-1$
     }
    this.length = length;
    if (length < 9)
     {
      this.mask = IPV4Mask.BITMASKS[length] + ".0.0.0"; //$NON-NLS-1$
     }
    else if (length < 17)
     {
      this.mask = "255." + IPV4Mask.BITMASKS[length - 8] + ".0.0"; //$NON-NLS-1$ //$NON-NLS-2$
     }
    else if (length < 25)
     {
      this.mask = "255.255." + IPV4Mask.BITMASKS[length - 16] + ".0"; //$NON-NLS-1$ //$NON-NLS-2$
     }
    else
     {
      this.mask = "255.255.255." + IPV4Mask.BITMASKS[length - 24]; //$NON-NLS-1$
     }
   }


  /**
   * Constructor.
   *
   * @param mask Mask in the form like 255.255.255.0
   * @throws NullPointerException if mask is null
   * @throws IllegalArgumentException If mask is not an IP V4 network mask
   */
  public IPV4Mask(final String mask)
   {
    super();
    Objects.requireNonNull(mask, "mask"); //$NON-NLS-1$
    if ((mask.length() < 7) || (mask.length() > 15))
     {
      throw new IllegalArgumentException("To long for an IP V4 network mask"); //$NON-NLS-1$
     }
    if (!IPV4Mask.IPV4_MASK_REGEXP.matcher(mask).matches())
     {
      throw new IllegalArgumentException("Not an IP V4 network mask"); //$NON-NLS-1$
     }
    this.mask = mask;

    final String[] parts = mask.split("\\."); //$NON-NLS-1$
    for (int part = 3; part >= 0; --part)
     {
      if (IPV4Mask.ZERO.equals(parts[part]))
       {
        continue;
       }
      for (int pos = 1; pos < IPV4Mask.BITMASKS.length; ++pos)
       {
        if (parts[part].equals(IPV4Mask.BITMASKS[pos]))
         {
          this.length = (8 * part) + pos;
          return;
         }
       }
     }
    this.length = 0;
   }


  /**
   * IPV4Mask factory.
   *
   * @param length IP V4 prefix length
   * @return IPV4Mask object
   */
  public static IPV4Mask of(final int length)
   {
    return new IPV4Mask(length);
   }


  /**
   * IPV4Mask factory.
   *
   * @param mask IP V4 network mask in format like 255.255.255.0
   * @return IPV4Mask object
   */
  public static IPV4Mask of(final String mask)
   {
    return new IPV4Mask(mask);
   }


  /**
   * Get prefix length.
   *
   * @return Prefix length (0-32)
   * @deprecated Use intValue() instead
   */
  @Deprecated
  public int getLength()
   {
    return this.length;
   }


  /**
   * Returns the value of this IPV4Mask as an int.
   *
   * @return The numeric value represented by this object after conversion to type int (0-32).
   */
  public int intValue()
   {
    return this.length;
   }


  /**
   * Get network mask.
   *
   * @return Network mask of format 255.255.255.0
   * @deprecated Use stringValue() instead
   */
  @Deprecated
  public String getMask()
   {
    return this.mask;
   }


  /**
   * Returns the value of this IPV4Mask as a string.
   *
   * @return The text value represented by this object after conversion to type string of format 255.255.255.0.
   */
  public String stringValue()
   {
    return this.mask;
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
    if (!(obj instanceof IPV4Mask))
     {
      return false;
     }
    final IPV4Mask other = (IPV4Mask)obj;
    return this.length == other.length;
   }


  /**
   * Returns the string representation of this IPV4Address.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "IPV4Mask[length=24, mask=255.255.255.0]"
   *
   * @return String representation of this IPV4Mask
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(24);
    builder.append("IPV4Mask[length=").append(this.length).append(", mask=").append(this.mask).append(']'); //$NON-NLS-1$ //$NON-NLS-2$
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
  public int compareTo(final IPV4Mask obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(this.length, obj.length);
   }

 }
