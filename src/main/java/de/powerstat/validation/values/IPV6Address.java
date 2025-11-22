/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * IP V6 address.
 *
 * DSGVO relevant.
 *
 * TODO ping ok?
 */
public final class IPV6Address implements Comparable<IPV6Address>, IValueObject
 {
  /* *
   * Logger.
   */
  // private static final Logger LOGGER = LogManager.getLogger(IPV6Address.class);

  /* *
   * Cache for singletons.
   */
  // private static final Map<String, IPV6Address> CACHE = new WeakHashMap<>();

  /**
   * IP V6 regexp.
   */
  private static final Pattern IPV6_REGEXP = Pattern.compile("^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$"); //$NON-NLS-1$

  /**
   * IPV6 zero block.
   */
  private static final String BLOCK_ZERO = "0000"; //$NON-NLS-1$

  /**
   * Hex output format.
   */
  private static final String HEX_OUTPUT = "%02x"; //$NON-NLS-1$

  /**
   * IPV6 block expansion.
   */
  private static final String IPV6_EXP = "::"; //$NON-NLS-1$

  /**
   * IPV6 block separator.
   */
  private static final String IV6_SEP = ":"; //$NON-NLS-1$

  /**
   * IP V6 address.
   */
  private final String address;

  /**
   * IP V6 address parts.
   */
  private final String[] blocks;


  /**
   * Constructor.
   *
   * @param address IP V6 address
   * @throws NullPointerException if address is null
   * @throws IllegalArgumentException if address is not an ip v6 address
   */
  private IPV6Address(final String address)
   {
    super();
    Objects.requireNonNull(address, "address"); //$NON-NLS-1$
    if ((address.length() < 2) || (address.length() > 45)) // 39, ipv4 embedding
     {
      throw new IllegalArgumentException("To short or long for an IP V6 address"); //$NON-NLS-1$
     }
    String expandedAddress = address.toLowerCase(Locale.getDefault());
    expandedAddress = expandIPV4Address(expandedAddress);
    expandedAddress = expandExpansionBlock(expandedAddress);
    if (!IPV6Address.IPV6_REGEXP.matcher(expandedAddress).matches())
     {
      throw new IllegalArgumentException("Not an IP V6 address"); //$NON-NLS-1$
     }
    expandedAddress = normalizeIPV6Address(expandedAddress);
    this.address = expandedAddress;
    blocks = expandedAddress.split(IPV6Address.IV6_SEP);
   }


  /**
   * Expand a possibly embedded IP V4 address.
   *
   * @param address IP V6 address
   * @return IP V6 address
   * @throws NullPointerException if address is null
   * @throws IllegalArgumentException if address is not an ip v4 address
   */
  private static String expandIPV4Address(final String address)
   {
    final int ipv4pos = address.indexOf('.');
    if (ipv4pos == -1)
     {
      return address;
     }
    final int blockStart = address.lastIndexOf(':', ipv4pos);
    final var ipv4 = address.substring(blockStart + 1);
    /* final IPV4Address ipv4address = */ IPV4Address.of(ipv4); // TODO use IPV4Address to ip v6 conversion method
    final var newAddress = address.substring(0, blockStart + 1);
    final String[] parts = ipv4.split("\\."); //$NON-NLS-1$
    final int block1 = Integer.parseInt(parts[0]);
    final int block2 = Integer.parseInt(parts[1]);
    final int block3 = Integer.parseInt(parts[2]);
    final int block4 = Integer.parseInt(parts[3]);
    return newAddress + Integer.toHexString(block1) + String.format(IPV6Address.HEX_OUTPUT, block2) + ':' + Integer.toHexString(block3) + String.format(IPV6Address.HEX_OUTPUT, block4);
   }


  /**
   * Count colons.
   *
   * @param str String to count coolons in
   * @return Numbe rof colons found
   */
  private static int countColons(final String str)
   {
    int colons = 0;
    int expPos = -1;
    do
     {
      expPos = str.indexOf(':', expPos + 1);
      if (expPos > -1)
       {
        ++colons;
       }
     }
    while (expPos > -1);
    return colons;
   }


  /**
   * Expand possible expansion block.
   *
   * @param address IP V6 address
   * @return IP V6 address
   */
  private static String expandExpansionBlock(final String address)
   {
    final int expPos = address.indexOf(IPV6Address.IPV6_EXP);
    if ((expPos == -1))
     {
      return address;
     }
    if (address.indexOf(IPV6Address.IPV6_EXP, expPos + 1) != -1)
     {
      throw new IllegalArgumentException("Not an IP V6 address (more than one expansion block)"); //$NON-NLS-1$
     }
    final var start = address.substring(0, expPos);
    final var end = address.substring(expPos + 2);
    int blocks = 8;
    if (!start.isEmpty())
     {
      blocks -= countColons(start) + 1;
     }
    if (!end.isEmpty())
     {
      blocks -= countColons(end) + 1;
     }
    final var replace = new StringBuilder();
    if (!start.isEmpty())
     {
      replace.append(':');
     }
    while (blocks > 0)
     {
      replace.append(IPV6Address.BLOCK_ZERO);
      --blocks;
      if (blocks > 0)
       {
        replace.append(':');
       }
     }
    if (!end.isEmpty())
     {
      replace.append(':');
     }
    replace.append(end);
    replace.insert(0, start);
    return replace.toString();
   }


  /**
   * Normalize IP V6 address.
   *
   * @param address IP V6 address
   * @return Normalized IP V6 address
   */
  private static String normalizeIPV6Address(final String address)
   {
    final String[] parts = address.split(IPV6Address.IV6_SEP);
    final var normalizedAddress = new StringBuilder();
    for (final String part : parts)
     {
      normalizedAddress.append(IPV6Address.BLOCK_ZERO.substring(part.length())).append(part).append(':');
     }
    normalizedAddress.setLength(normalizedAddress.length() - 1);
    return normalizedAddress.toString();
   }


  /**
   * IPV6Address factory.
   *
   * @param address IP V6 address
   * @return IPV6address object
   */
  public static IPV6Address of(final String address)
   {
    /*
    synchronized (IPV6Address.class)
     {
      IPV6Address obj = IPV6Address.CACHE.get(address);
      if (obj != null)
       {
        return obj;
       }
      obj = new IPV6Address(address);
      IPV6Address.CACHE.put(address, obj);
      return obj;
     }
    */
    return new IPV6Address(address);
   }


  /**
   * Is an IP V6 private address.
   *
   * fc Unique Local Unicast
   * fd Unique Local Unicast
   * fe:80:00:00:00:00:00:00 Link-Local
   *
   * @return true if private, false otherwise
   */
  @SuppressWarnings({"java:S1313", "PMD.AvoidLiteralsInIfCondition", "PMD.AvoidUsingHardCodedIP"})
  public boolean isPrivate()
   {
    return ("00fe:0080:0000:0000:0000:0000:0000:0000".equals(address) || // Link-Local //$NON-NLS-1$
            "00fc".equals(blocks[0]) || "00fd".equals(blocks[0]) // Unique Local Unicast //$NON-NLS-1$ //$NON-NLS-2$
           );
   }


  /**
   * Is an IP V6 special address.
   *
   * 0:0:0:0:0:0:0:0 default route
   * 0:0:0:0:0:0:0:1 loopback
   * ff Multicast
   *
   * @return true if special, false otherwise
   */
  @SuppressWarnings({"PMD.AvoidLiteralsInIfCondition", "PMD.AvoidUsingHardCodedIP"})
  public boolean isSpecial()
   {
    return ("0000:0000:0000:0000:0000:0000:0000:0000".equals(address) || "0000:0000:0000:0000:0000:0000:0000:0001".equals(address) || // default route, loopback //$NON-NLS-1$ //$NON-NLS-2$
            "00ff".equals(blocks[0]) // Multicast //$NON-NLS-1$
           );
   }


  /**
   * Is an IP V6 public address.
   *
   * 0:0:0:0:0:ffff::/96 IPv4 mapped (abgebildete) IPv6 Adressen
   * 2000::/3 IANA vergebenen globalen Unicast
   * 2001 Provider area
   * 2001:0: Toredo
   * 2001:0db8::/32 Documentation purposes
   * 2002 6to4 tunnel
   * 2003, 0240, 0260, 0261, 0262, 0280, 02a0, 02b0 und 02c0 Regional Internet Registries (RIRs)
   * 0064:ff9b::/96 NAT64
   *
   * @return true when public address, otherwise false
   */
  public boolean isPublic()
   {
    return !isPrivate() && !isSpecial();
   }


  /**
   * Returns the value of this IPV6Address as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return address;
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
    return address.hashCode();
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @SuppressWarnings({"PMD.SimplifyBooleanReturns"})
  @Override
  public boolean equals(final Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof final IPV6Address other))
     {
      return false;
     }
    return address.equals(other.address);
   }


  /**
   * Returns the string representation of this IPV6Address.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "IPV6Address[address=ffff:ffff:ffff:ffff:ffff:ffff:ffff:ffff]"
   *
   * @return String representation of this IPV6Address
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(21);
    builder.append("IPV6Address[address=").append(address).append(']'); //$NON-NLS-1$
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
  public int compareTo(final IPV6Address obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return address.compareTo(obj.address);
   }

 }
