/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;


/**
 * Canonical Media-Access-Control-Adresse (MAC).
 *
 * TODO Wake on lan (WOL)  https://gist.github.com/jumar/9200840
 * TODO getManufacturer name
 *
 * https://de.wikipedia.org/wiki/MAC-Adresse
 * http://standards-oui.ieee.org/oui/oui.csv
 */
public final class MACAddress implements Comparable<MACAddress>
 {
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
  public MACAddress(final String address)
   {
    super();
    Objects.requireNonNull(address, "address"); //$NON-NLS-1$
    if ((address.length() != 12) && (address.length() != 17))
     {
      throw new IllegalArgumentException("To short or long for a mac address"); //$NON-NLS-1$
     }
    if (!address.toLowerCase(Locale.getDefault()).matches("^[0-9a-f]{2}((:|-)?[0-9a-f]{2}){5}$")) //$NON-NLS-1$
     {
      throw new IllegalArgumentException("Not a mac address"); //$NON-NLS-1$
     }
    this.parts = address.toLowerCase(Locale.getDefault()).split(":|-"); //$NON-NLS-1$
   }


  /**
   * MACAddress factory.
   *
   * @param address MAC address
   * @return MACAddress object
   */
  public static MACAddress of(final String address)
   {
    return new MACAddress(address);
   }


  /**
   * Get mac address string.
   *
   * @param delimiter Delimiter could be empty, : or -
   * @return MACAddress string
   */
  public String getAddress(final String delimiter)
   {
    Objects.requireNonNull(delimiter, "delimiter"); //$NON-NLS-1$
    if (delimiter.length() > 1)
     {
      throw new IllegalArgumentException("Illegal delimiter length"); //$NON-NLS-1$
     }
    if (!delimiter.isEmpty() && !":".equals(delimiter) && !"-".equals(delimiter)) //$NON-NLS-1$ //$NON-NLS-2$
     {
      throw new IllegalArgumentException("Illegal delimiter character"); //$NON-NLS-1$
     }
    return String.join(delimiter, this.parts);
   }


  /**
   * Is broadcast address.
   *
   * @return true if broadcast address, false otherwise
   */
  public boolean isBroadcast()
   {
    return "ff".equals(this.parts[0]) && "ff".equals(this.parts[1]) && "ff".equals(this.parts[2]) && "ff".equals(this.parts[3]) && "ff".equals(this.parts[4]) && "ff".equals(this.parts[5]); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
   }


  /**
   * Is group.
   *
   * @return true: group, false: individual
   */
  public boolean isGroup()
   {
    return (Integer.parseInt(this.parts[0], 16) & 0x01) > 0;
   }


  /**
   * Is local.
   *
   * @return true: local, false: universal
   */
  public boolean isLocal()
   {
    return (Integer.parseInt(this.parts[0], 16) & 0x02) > 0;
   }


  /**
   * Is IP v4 multicast mac.
   *
   * @return true if mac is an ip v4 multicast address, false otherwise
   */
  public boolean isIPV4Multicast()
   {
    return "01".equals(this.parts[0]) && "00".equals(this.parts[1]) &&  "5e".equals(this.parts[2]) && ((Integer.parseInt(this.parts[3], 16) & 0x80) == 0); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
   }


  /**
   * Is IP v6 multicast mac.
   *
   * @return true if mac is an ip v6 multicast address, false otherwise
   */
  public boolean isIPV6Multicast()
   {
    return "33".equals(this.parts[0]) && "33".equals(this.parts[1]); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Is VRRP mac (Virtual Router Redundancy Protocol).
   *
   * @return true if mac is a vrrp address, false otherwise
   */
  public boolean isVRRP()
   {
    return "00".equals(this.parts[0]) && "00".equals(this.parts[1]) && "5e".equals(this.parts[2]) && "00".equals(this.parts[3]) && "01".equals(this.parts[4]); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
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
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof MACAddress))
     {
      return false;
     }
    final MACAddress other = (MACAddress)obj;
    return Arrays.equals(this.parts, other.parts);
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
    final StringBuilder builder = new StringBuilder(21);
    builder.append("MACAddress[address=").append(String.join(":", this.parts)).append(']'); //$NON-NLS-1$ //$NON-NLS-2$
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
