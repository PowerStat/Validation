/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Canonical Media-Access-Control-Adresse (MAC).
 *
 * TODO getManufacturer name
 * TODO Exists in network
 * http://standards-oui.ieee.org/oui/oui.csv
 */
// @SuppressFBWarnings({"CLI_CONSTANT_LIST_INDEX", "PMB_POSSIBLE_MEMORY_BLOAT"})
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class MACAddress implements Comparable<MACAddress>, IValueObject
 {
  /**
   * Cache for singletons.
   */
  private static final Map<String, MACAddress> CACHE = new WeakHashMap<>();

  /**
   * Hex 00.
   */
  private static final String H00 = "00"; //$NON-NLS-1$

  /**
   * Hex 01.
   */
  private static final String H01 = "01"; //$NON-NLS-1$

  /**
   * Hex 33.
   */
  private static final String H33 = "33"; //$NON-NLS-1$

  /**
   * Hex 5e.
   */
  private static final String H5E = "5e"; //$NON-NLS-1$

  /**
   * Hex ff.
   */
  private static final String HFF = "ff"; //$NON-NLS-1$

  /**
   * Byte separator.
   */
  private static final String SEPARATOR = ":"; //$NON-NLS-1$

  /**
   * Delimiter.
   */
  private static final String DELIMITER = "-"; //$NON-NLS-1$

  /**
   * Delimiter constant.
   */
  private static final String DELIMITER_TXT = "delimiter"; //$NON-NLS-1$

  /**
   * Illegal delimiter length constant.
   */
  private static final String ILLEGAL_DELIMITER_LENGTH = "Illegal delimiter length"; //$NON-NLS-1$

  /**
   * Illegal delimiter character constant.
   */
  private static final String ILLEGAL_DELIMITER_CHARACTER = "Illegal delimiter character"; //$NON-NLS-1$

  /**
   * IP V6 regexp.
   */
  private static final Pattern IPV6_REGEXP = Pattern.compile("^[0-9a-f]{2}([:-]?[0-9a-f]{2}){5}$"); //$NON-NLS-1$

  /**
   * IP V6 separator regexp.
   */
  private static final Pattern IPV6_SEPARATOR_REGEXP = Pattern.compile("[:-]"); //$NON-NLS-1$

  /**
   * MAC address parts.
   */
  private final String[] parts;


  /**
   * Constructor.
   *
   * @param address MAC address
   * @throws NullPointerException if address is null
   * @throws IllegalArgumentException if address is not a mac address
   */
  private MACAddress(final String address)
   {
    super();
    Objects.requireNonNull(address, "address"); //$NON-NLS-1$
    if ((address.length() != 12) && (address.length() != 17))
     {
      throw new IllegalArgumentException("To short or long for a mac address"); //$NON-NLS-1$
     }
    if (!MACAddress.IPV6_REGEXP.matcher(address.toLowerCase(Locale.getDefault())).matches())
     {
      throw new IllegalArgumentException("Not a mac address"); //$NON-NLS-1$
     }
    this.parts = MACAddress.IPV6_SEPARATOR_REGEXP.split(address.toLowerCase(Locale.getDefault()));
   }


  /**
   * MACAddress factory.
   *
   * @param address MAC address
   * @return MACAddress object
   */
  public static MACAddress of(final String address)
   {
    synchronized (MACAddress.class)
     {
      MACAddress obj = MACAddress.CACHE.get(address);
      if (obj != null)
       {
        return obj;
       }
      obj = new MACAddress(address);
      MACAddress.CACHE.put(address, obj);
      return obj;
     }
   }


  /**
   * Returns the value of this MACAddress as a string.
   *
   * @param delimiter Delimiter could be empty, : or -
   * @return The text value represented by this object after conversion to type string.
   */
  public String stringValue(final String delimiter)
   {
    Objects.requireNonNull(delimiter, MACAddress.DELIMITER_TXT);
    if (delimiter.length() > 1)
     {
      throw new IllegalArgumentException(MACAddress.ILLEGAL_DELIMITER_LENGTH);
     }
    if (!delimiter.isEmpty() && !MACAddress.SEPARATOR.equals(delimiter) && !MACAddress.DELIMITER.equals(delimiter))
     {
      throw new IllegalArgumentException(MACAddress.ILLEGAL_DELIMITER_CHARACTER);
     }
    return String.join(delimiter, this.parts);
   }


  /**
   * Returns the value of this MACADdress as a string with delimiter ':'.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return stringValue(MACAddress.SEPARATOR);
   }


  /**
   * Is broadcast address.
   *
   * @return true if broadcast address, false otherwise
   */
  public boolean isBroadcast()
   {
    return MACAddress.HFF.equals(this.parts[0]) && MACAddress.HFF.equals(this.parts[1]) && MACAddress.HFF.equals(this.parts[2]) && MACAddress.HFF.equals(this.parts[3]) && MACAddress.HFF.equals(this.parts[4]) && MACAddress.HFF.equals(this.parts[5]);
   }


  /**
   * Is group.
   *
   * @return true: group, false: individual
   */
  public boolean isGroup()
   {
    return (Integer.parseInt(this.parts[0], 16) & 0x01) != 0;
   }


  /**
   * Is local.
   *
   * @return true: local, false: universal
   */
  public boolean isLocal()
   {
    return (Integer.parseInt(this.parts[0], 16) & 0x02) != 0;
   }


  /**
   * Is IP v4 multicast mac.
   *
   * @return true if mac is an ip v4 multicast address, false otherwise
   */
  public boolean isIPV4Multicast()
   {
    return MACAddress.H01.equals(this.parts[0]) && MACAddress.H00.equals(this.parts[1]) && MACAddress.H5E.equals(this.parts[2]) && ((Integer.parseInt(this.parts[3], 16) & 0x80) == 0);
   }


  /**
   * Is IP v6 multicast mac.
   *
   * @return true if mac is an ip v6 multicast address, false otherwise
   */
  public boolean isIPV6Multicast()
   {
    return MACAddress.H33.equals(this.parts[0]) && MACAddress.H33.equals(this.parts[1]);
   }


  /**
   * Is VRRP mac (Virtual Router Redundancy Protocol).
   *
   * @return true if mac is a vrrp address, false otherwise
   */
  public boolean isVRRP()
   {
    return MACAddress.H00.equals(this.parts[0]) && MACAddress.H00.equals(this.parts[1]) && MACAddress.H5E.equals(this.parts[2]) && MACAddress.H00.equals(this.parts[3]) && MACAddress.H01.equals(this.parts[4]);
   }


  /**
   * Get OUI (Organizationally Unique Identifier).
   *
   * @return OUI (MA-L) string 000000
   *
   * TODO OUI-28 (MA-M), OUI-36 (MA-S)
   */
  public String getOUI()
   {
    return String.format("%1$02X", Integer.parseInt(this.parts[0], 16) & 0xfc) + this.parts[1].toUpperCase(Locale.getDefault()) + this.parts[2].toUpperCase(Locale.getDefault()); //$NON-NLS-1$
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
    return Arrays.hashCode(this.parts);
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
    return this == obj;
    /*
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof MACAddress))
     {
      return false;
     }
    final MACAddress other = (MACAddress)obj;
    return false; // Arrays.equals(this.parts, other.parts);
    */
   }


  /**
   * Returns the string representation of this MACAddress.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "MACAddress[address=00:00:00:00:00:00]"
   *
   * @return String representation of this MACAddress
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(21);
    builder.append("MACAddress[address=").append(String.join(MACAddress.SEPARATOR, this.parts)).append(']'); //$NON-NLS-1$
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
  public int compareTo(final MACAddress obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Arrays.compare(this.parts, obj.parts);
   }

 }
