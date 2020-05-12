/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * IP V4 address.
 *
 * DSGVO relevant.
 *
 * TODO convert to IP V6 format
 * TODO https://datahub.io/core/geoip2-ipv4/r/geoip2-ipv4.csv
 */
public final class IPV4Address implements Comparable<IPV4Address>
 {
  /**
   * IP V4 address.
   */
  private final String address;

  /**
   * IP V4 address parts.
   */
  private final String[] parts;


  /**
   * Constructor.
   *
   * @param address IP V4 address
   * @throws NullPointerException if address is null
   * @throws IllegalArgumentException if address is not an ip v4 address
   */
  public IPV4Address(final String address)
   {
    super();
    Objects.requireNonNull(address, "address"); //$NON-NLS-1$
    if ((address.length() < 7) || (address.length() > 15))
     {
      throw new IllegalArgumentException("To short or long for an IP V4 address"); //$NON-NLS-1$
     }
    if (!address.matches("^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])$")) //$NON-NLS-1$
     {
      throw new IllegalArgumentException("Not an IP V4 address"); //$NON-NLS-1$
     }
    this.address = address;
    this.parts = address.split("\\."); //$NON-NLS-1$
   }


  /**
   * IPV4Address factory.
   *
   * @param address IP V4 address
   * @return IPV4address object
   */
  public static IPV4Address of(final String address)
   {
    return new IPV4Address(address);
   }


  /**
   * Is an IP V4 private address.
   *
   * 10.0.0.0–10.255.255.255     private,      1  8-Bit-Net  10.0.0.0/8     RFC 1918
   * 172.16.0.0–172.31.255.255   private,     16 16-Bit-Nets 172.16.0.0/12  RFC 1918
   * 192.168.0.0–192.168.255.255 private,    256 24-Bit-Nets 192.168.0.0/16 RFC 1918
   * 169.254.0.0–169.254.255.255 link local,   1 16-Bit-Net  169.254.0.0/16 RFC 3927
   *
   * @return true when private address, otherwise false
   */
  public boolean isPrivate()
   {
    if ("10".equals(this.parts[0]) || ("192".equals(this.parts[0]) && "168".equals(this.parts[1])) || ("169".equals(this.parts[0]) && "254".equals(this.parts[1]))) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$
     {
      return true;
     }
    if ("172".equals(this.parts[0])) //$NON-NLS-1$
     {
      final int block2 = Integer.parseInt(this.parts[1]);
      if ((block2 >= 16) && (block2 <= 31))
       {
        return true;
       }
     }
    return false;
   }


  /**
   * Is an IP V4 special address.
   *
   * 0.0.0.0/8           Das vorliegende Netzwerk       RFC 1122
   * 127.0.0.0/8         Loopback                       RFC 1122
   * 100.64.0.0/10       Shared Transition Space        RFC 6598
   * 192.0.0.0/24        IETF Protocol Assignments      RFC 6890
   * 192.0.2.0/24        Test-Netzwerke                 RFC 6890
   * 192.88.99.0/24      IPv6 zu IPv4 Relay (Veraltet)  RFC 7526
   * 198.18.0.0/15       Netzwerk-Benchmark-Tests       RFC 2544
   * 198.51.100.0/24     Test-Netzwerke                 RFC 6890
   * 203.0.113.0/24      Test-Netzwerke                 RFC 6890
   * 224.0.0.0/4         Multicasts                     RFC 5771
   * 240.0.0.0/4         Reserviert                     RFC 1700
   * 255.255.255.255/32  Limited Broadcast              RFC 919, RFC 922
   *
   * @return true when special address, otherwise false
   */
  public boolean isSpecial()
   {
    if ("0".equals(this.parts[0]) || //$NON-NLS-1$
        "127".equals(this.parts[0]) || //$NON-NLS-1$
        ("192".equals(this.parts[0]) && "0".equals(this.parts[1]) && "0".equals(this.parts[2])) || //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ("192".equals(this.parts[0]) && "0".equals(this.parts[1]) && "2".equals(this.parts[2])) || //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ("192".equals(this.parts[0]) && "88".equals(this.parts[1]) && "99".equals(this.parts[2])) || //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ("198".equals(this.parts[0]) && "51".equals(this.parts[1]) && "100".equals(this.parts[2])) || //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ("203".equals(this.parts[0]) && "0".equals(this.parts[1]) && "113".equals(this.parts[2])) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
       )
     {
      return true;
     }
    if ("100".equals(this.parts[0])) //$NON-NLS-1$
     {
      final int block2 = Integer.parseInt(this.parts[1]);
      if ((block2 >= 64) && (block2 <= 127))
       {
        return true;
       }
     }
    if ("198".equals(this.parts[0])) //$NON-NLS-1$
     {
      final int block2 = Integer.parseInt(this.parts[1]);
      if ((block2 >= 18) && (block2 <= 19))
       {
        return true;
       }
     }
    final int block1 = Integer.parseInt(this.parts[0]);
    return (((block1 >= 224) && (block1 <= 239)) || ((block1 >= 240) && (block1 <= 255)));
   }


  /**
   * Is an IP V4 public address.
   *
   * @return true when public address, otherwise false
   */
  public boolean isPublic()
   {
    return !isPrivate() && !isSpecial();
   }


  /**
   * Get ip V4 address string.
   *
   * @return IPV4Address string
   */
  public String getAddress()
   {
    return this.address;
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
    return this.address.hashCode();
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
    if (!(obj instanceof IPV4Address))
     {
      return false;
     }
    final IPV4Address other = (IPV4Address)obj;
    return this.address.equals(other.address);
   }


  /**
   * Returns the string representation of this IPV4Address.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "IPV4Address[address=192.168.0.0]"
   *
   * @return String representation of this IPV4Address
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(21);
    builder.append("IPV4Address[address=").append(this.address).append(']'); //$NON-NLS-1$
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
  public int compareTo(final IPV4Address obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.address.compareTo(obj.address);
   }

 }
