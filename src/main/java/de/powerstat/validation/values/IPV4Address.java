/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * IP V4 address.
 *
 * @param address IP V4 address
 * 
 * DSGVO relevant.
 *
 * TODO convert to IP V6 format
 * TODO https://datahub.io/core/geoip2-ipv4/r/geoip2-ipv4.csv
 * TODO ping ok?
 */
public record IPV4Address(String address) implements Comparable<IPV4Address>, IValueObject
 {
  /**
   * IPV4 separator.
   */
  private static final String SEPARATOR = "\\."; //$NON-NLS-1$

  /**
   * Class c 192.
   */
  private static final String CLASS_C_192 = "192"; //$NON-NLS-1$

  /**
   * 100.
   */
  private static final String C100 = "100"; //$NON-NLS-1$

  /**
   * 198.
   */
  private static final String C198 = "198"; //$NON-NLS-1$

  /**
   * 0.
   */
  private static final String ZERO = "0"; //$NON-NLS-1$

  /**
   * IP V4 regexp.
   */
  private static final Pattern IPV4_REGEXP = Pattern.compile("^((25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]\\d|\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]\\d|\\d)$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param address IP V4 address
   * @throws NullPointerException if address is null
   * @throws IllegalArgumentException if address is not an ip v4 address
   */
  public IPV4Address
   {
    Objects.requireNonNull(address, "address"); //$NON-NLS-1$
    if ((address.length() < 7) || (address.length() > 15))
     {
      throw new IllegalArgumentException("To short or long for an IP V4 address"); //$NON-NLS-1$
     }
    if (!IPV4Address.IPV4_REGEXP.matcher(address).matches())
     {
      throw new IllegalArgumentException("Not an IP V4 address"); //$NON-NLS-1$
     }
   }


  /**
   * IPV4Address factory.
   *
   * @param address IP V4 address
   * @return IPV4Address object
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
    final String[] parts = this.address.split(SEPARATOR); //$NON-NLS-1$
    if ("10".equals(parts[0]) || (IPV4Address.CLASS_C_192.equals(parts[0]) && "168".equals(parts[1])) || ("169".equals(parts[0]) && "254".equals(parts[1]))) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
     {
      return true;
     }
    if ("172".equals(parts[0])) //$NON-NLS-1$
     {
      final int block2 = Integer.parseInt(parts[1]);
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
    final String[] parts = this.address.split(SEPARATOR); //$NON-NLS-1$
    if (IPV4Address.ZERO.equals(parts[0]) ||
        "127".equals(parts[0]) || //$NON-NLS-1$
        (IPV4Address.CLASS_C_192.equals(parts[0]) && IPV4Address.ZERO.equals(parts[1]) && IPV4Address.ZERO.equals(parts[2])) ||
        (IPV4Address.CLASS_C_192.equals(parts[0]) && IPV4Address.ZERO.equals(parts[1]) && "2".equals(parts[2])) || //$NON-NLS-1$
        (IPV4Address.CLASS_C_192.equals(parts[0]) && "88".equals(parts[1]) && "99".equals(parts[2])) || //$NON-NLS-1$ //$NON-NLS-2$
        (IPV4Address.C198.equals(parts[0]) && "51".equals(parts[1]) && IPV4Address.C100.equals(parts[2])) || //$NON-NLS-1$
        ("203".equals(parts[0]) && IPV4Address.ZERO.equals(parts[1]) && "113".equals(parts[2])) //$NON-NLS-1$ //$NON-NLS-2$
       )
     {
      return true;
     }
    if (IPV4Address.C100.equals(parts[0]))
     {
      final int block2 = Integer.parseInt(parts[1]);
      if ((block2 >= 64) && (block2 <= 127))
       {
        return true;
       }
     }
    if (IPV4Address.C198.equals(parts[0]))
     {
      final int block2 = Integer.parseInt(parts[1]);
      if ((block2 >= 18) && (block2 <= 19))
       {
        return true;
       }
     }
    final int block1 = Integer.parseInt(parts[0]);
    return (block1 >= 224);
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
   * Returns the value of this IPV4Address as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.address;
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
