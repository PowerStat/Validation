/*
 * Copyright (C) 2018-2019 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import de.powerstat.validation.generated.GeneratedTlds;


/**
 * General validation utilities.
 *
 * @author Kai Hofmann
 */
public final class ValidationUtils
 {
  /**
   * Logger.
   */
  // private static final Logger LOGGER = LogManager.getLogger(ValidationUtils.class);

  /**
   * URI separator.
   */
  private static final char URI_SEPARATOR = '/';

  /**
   * Deprecated since version 2.0 constant.
   */
  private static final String DEPRECATED_SINCE_2_0 = "2.0"; //$NON-NLS-1$

  /**
   * Escaped dot.
   */
  private static final String ESC_DOT = "\\."; //$NON-NLS-1$

  /**
   * Class c network 192.
   */
  private static final String C192 = "192"; //$NON-NLS-1$


  /**
   * Private default constructor.
   */
  private ValidationUtils()
   {
    super();
   }


  /**
   * Is IP V4 address.
   *
   * @param address IP V4 address
   * @return true when IP V4 address, false otherwise
   * @throws NullPointerException If address is null
   * @deprecated Use de.powerstat.validation.values.IPV4Address instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static boolean isIPV4(final String address)
   {
    Objects.requireNonNull(address, "address"); //$NON-NLS-1$
    return address.matches("^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9])$"); //$NON-NLS-1$
   }


  /**
   * Check if hostname is an IP V4 address.
   *
   * @param address IPV4 address
   * @return IP V4 address
   * @throws NullPointerException If address is null
   * @throws IllegalArgumentException If not an IP V4 address
   * @deprecated Use de.powerstat.validation.values.IPV4Address instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static String checkIPV4(final String address)
   {
    Objects.requireNonNull(address, "address"); //$NON-NLS-1$
    if (!isIPV4(address))
     {
      throw new IllegalArgumentException("Not an IP V4 address"); //$NON-NLS-1$
     }
    return address;
   }


  /**
   * Is an IP V4 private address.
   *
   * 10.0.0.0–10.255.255.255     private,      1  8-Bit-Net  10.0.0.0/8     RFC 1918
   * 172.16.0.0–172.31.255.255   private,     16 16-Bit-Nets 172.16.0.0/12  RFC 1918
   * 192.168.0.0–192.168.255.255 private,    256 24-Bit-Nets 192.168.0.0/16 RFC 1918
   * 169.254.0.0–169.254.255.255 link local,   1 16-Bit-Net  169.254.0.0/16 RFC 3927
   *
   * @param address IP V4 address
   * @return true when private address, otherwise false
   * @throws NullPointerException If address is null
   * @throws IllegalArgumentException If not an IP V4 address
   * @deprecated Use de.powerstat.validation.values.IPV4Address.isPrivate() instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static boolean isIPV4private(final String address)
   {
    /* String checkedAddress = */ checkIPV4(address);
    final String[] parts = address.split(ESC_DOT);
    if ("10".equals(parts[0]) || (C192.equals(parts[0]) && "168".equals(parts[1])) || ("169".equals(parts[0]) && "254".equals(parts[1]))) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$
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
   * @param address IP V4 address
   * @return true when special address, otherwise false
   * @throws NullPointerException If address is null
   * @throws IllegalArgumentException If not an IP V4 address
   * @deprecated Use de.powerstat.validation.values.IPV4Address.isSpecial() instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static boolean isIPV4special(final String address)
   {
    /* String checkedAddress = */ checkIPV4(address);
    final String[] parts = address.split(ESC_DOT);
    if ("0".equals(parts[0]) || //$NON-NLS-1$
        "127".equals(parts[0]) || //$NON-NLS-1$
        (C192.equals(parts[0]) && "0".equals(parts[1]) && "0".equals(parts[2])) || //$NON-NLS-1$ //$NON-NLS-2$
        (C192.equals(parts[0]) && "0".equals(parts[1]) && "2".equals(parts[2])) || //$NON-NLS-1$ //$NON-NLS-2$
        (C192.equals(parts[0]) && "88".equals(parts[1]) && "99".equals(parts[2])) || //$NON-NLS-1$ //$NON-NLS-2$
        ("198".equals(parts[0]) && "51".equals(parts[1]) && "100".equals(parts[2])) || //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
        ("203".equals(parts[0]) && "0".equals(parts[1]) && "113".equals(parts[2])) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
       )
     {
      return true;
     }
    if ("100".equals(parts[0])) //$NON-NLS-1$
     {
      final int block2 = Integer.parseInt(parts[1]);
      if ((block2 >= 64) && (block2 <= 127))
       {
        return true;
       }
     }
    if ("198".equals(parts[0])) //$NON-NLS-1$
     {
      final int block2 = Integer.parseInt(parts[1]);
      if ((block2 >= 18) && (block2 <= 19))
       {
        return true;
       }
     }
    final int block1 = Integer.parseInt(parts[0]);
    return (((block1 >= 224) && (block1 <= 239)) || ((block1 >= 240) && (block1 <= 255)));
   }


  /**
   * Is an IP V4 public address.
   *
   * @param address IP V4 address
   * @return true when public address, otherwise false
   * @throws NullPointerException If address is null
   * @throws IllegalArgumentException If not an IP V4 address
   * @deprecated Use de.powerstat.validation.values.IPV4Address.isPublic() instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static boolean isIPV4public(final String address)
   {
    return !isIPV4private(address) && !isIPV4special(address);
   }


  /**
   * Is IP V4 netmask prefix length.
   *
   * @param mask Netmask prefix length 0-32
   * @return true if prefix length, false otherwise
   * @deprecated Use de.powerstat.validation.values.IPV4Mask instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static boolean isIPV4prefixLength(final int mask)
   {
    return (mask >= 0) && (mask <= 32);
   }


  /**
   * Check IP V4 netmask prefix length.
   *
   * @param mask Netmask prefix length 0-32
   * @return Netmask prefix length
   * @throws IndexOutOfBoundsException If mask is outside 0-32 range
   * @deprecated Use de.powerstat.validation.values.IPV4Mask instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static int checkIPV4prefixLength(final int mask)
   {
    if (!isIPV4prefixLength(mask))
     {
      throw new IndexOutOfBoundsException("Netmask prefix < 0 or > 32"); //$NON-NLS-1$
     }
    return mask;
   }


  /**
   * Is IP V6 netmask prefix length.
   *
   * @param mask Netmask prefix length 0-128
   * @return true if prefix length, false otherwise
   * @deprecated Use de.powerstat.validation.values.IPV6Mask instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static boolean isIPV6prefixLength(final int mask)
   {
    return (mask >= 0) && (mask <= 128);
   }


  /**
   * Check IP V6 netmask prefix length.
   *
   * @param mask Netmask prefix length 0-128
   * @return Netmask prefix length
   * @throws IndexOutOfBoundsException If mask is outside 0-128 range
   * @deprecated Use de.powerstat.validation.values.IPV6Mask instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static int checkIPV6prefixLength(final int mask)
   {
    if (!isIPV4prefixLength(mask))
     {
      throw new IndexOutOfBoundsException("Netmask prefix < 0 or > 128"); //$NON-NLS-1$
     }
    return mask;
   }


  /**
   * Check if address is an IP V6 address and normalize.
   *
   * Normalize reduced blocks "::" and convert IP V4 part to hex.
   *
   * Network                  Subnet    Device
   * [8 16] [24 32] [40 48]   [56 64]   [72 80] [88 96] [104 112] [120 128]
   *
   * @param address IPV6 address
   * @return IPV6 address
   * @throws NullPointerException If address is null
   * @throws IllegalArgumentException If not an IP V6 address
   * @deprecated Use de.powerstat.validation.values.IPV6Address instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static String checkIPV6(final String address)
   {
    Objects.requireNonNull(address, "address"); //$NON-NLS-1$
    String expandedAddress = address.toLowerCase(Locale.getDefault());
    expandedAddress = expandIPV4Address(expandedAddress);
    expandedAddress = expandExpansionBlock(expandedAddress);
    if (!expandedAddress.matches("^([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$")) //$NON-NLS-1$
     {
      throw new IllegalArgumentException("Not an IP V6 address"); //$NON-NLS-1$
     }
    return normalizeIPV6Address(expandedAddress);
   }


  /**
   * Expand a possibly embedded IP V4 address.
   *
   * @param address IP V6 address
   * @return IP V6 address
   * @deprecated Only used by deprecated methods
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  private static String expandIPV4Address(final String address)
   {
    assert address != null;
    final int ipv4pos = address.indexOf('.');
    if (ipv4pos == -1)
     {
      return address;
     }
    final int blockStart = address.lastIndexOf(':', ipv4pos);
    final String ipv4 = address.substring(blockStart + 1);
    if (!isIPV4(ipv4))
     {
      throw new IllegalArgumentException("Not an IP V6 address (incorrect ip v4 address embedded)"); //$NON-NLS-1$
     }
    final String newAddress = address.substring(0, blockStart + 1);
    final String[] parts = ipv4.split(ESC_DOT);
    final int block1 = Integer.parseInt(parts[0]);
    final int block2 = Integer.parseInt(parts[1]);
    final int block3 = Integer.parseInt(parts[2]);
    final int block4 = Integer.parseInt(parts[3]);
    return newAddress + Integer.toHexString(block1) + String.format("%02x", block2) + ':' + Integer.toHexString(block3) + String.format("%02x", block4); //$NON-NLS-1$ //$NON-NLS-2$
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
    assert address != null;
    final int expPos = address.indexOf("::"); //$NON-NLS-1$
    if ((expPos == -1))
     {
      return address;
     }
    if (address.indexOf("::", expPos + 1) != -1) //$NON-NLS-1$
     {
      throw new IllegalArgumentException("Not an IP V6 address (more than one expansion block)"); //$NON-NLS-1$
     }
    final String start = address.substring(0, expPos);
    final String end = address.substring(expPos + 2);
    int blocks = 8;
    if (start.length() > 0)
     {
      blocks -= countColons(start) + 1;
     }
    if (end.length() > 0)
     {
      blocks -= countColons(end) + 1;
     }
    final StringBuilder replace = new StringBuilder();
    if (start.length() > 0)
       {
      replace.append(':');
       }
    while (blocks > 0)
       {
      replace.append("0000"); //$NON-NLS-1$
        --blocks;
      if (blocks > 0)
       {
        replace.append(':');
       }
       }
    if (end.length() > 0)
       {
      replace.append(':');
       }
    return start + replace.toString() + end;
     }


  /**
   * Normalize IP V6 address.
   *
   * @param address IP V6 address
   * @return Normalized IP V6 address
   */
  private static String normalizeIPV6Address(final String address)
     {
    assert address != null;
    final String[] parts = address.split(":"); //$NON-NLS-1$
    final StringBuilder normalizedAddress = new StringBuilder();
    for (final String part : parts)
     {
      normalizedAddress.append("0000".substring(part.length())).append(part).append(':'); //$NON-NLS-1$
     }
    normalizedAddress.setLength(normalizedAddress.length() - 1);
    return normalizedAddress.toString();
   }


  /**
   * Is IP V6 address.
   *
   * @param address IP V6 address
   * @return true when IP V6 address, false otherwise
   * @deprecated Use de.powerstat.validation.values.IPV6Address instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static boolean isIPV6(final String address)
   {
    try
     {
      /* final String expandedAddress = */ checkIPV6(address);
     }
    catch (final NullPointerException | IllegalArgumentException ignored)
     {
      return false;
     }
    return true;
   }


  /**
   * Is an IP V6 private address.
   *
   * fc Unique Local Unicast
   * fd Unique Local Unicast
   * fe:80:00:00:00:00:00:00 Link-Local
   *
   * @param address IP V6 address
   * @return true if private, false otherwise
   * @throws NullPointerException If address is null
   * @throws IllegalArgumentException If not an IP V6 address
   * @deprecated Use de.powerstat.validation.values.IPV6Address.isPrivate() instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static boolean isIPV6private(final String address)
   {
    final String expandedAddress = checkIPV6(address);
    if ("00fe:0080:0000:0000:0000:0000:0000:0000".equals(expandedAddress)) // Link-Local //$NON-NLS-1$
     {
      return true;
     }
    final String[] blocks = expandedAddress.split(":"); //$NON-NLS-1$
    return ("00fc".equals(blocks[0]) || "00fd".equals(blocks[0])); // Unique Local Unicast //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Is an IP V6 special address.
   *
   * 0:0:0:0:0:0:0:0 default route
   * 0:0:0:0:0:0:0:1 loopback
   * ff Multicast
   *
   * @param address IP V6 address
   * @return true if special, false otherwise
   * @throws NullPointerException If address is null
   * @throws IllegalArgumentException If not an IP V6 address
   * @deprecated Use de.powerstat.validation.values.IPV6Address.isSpecial() instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static boolean isIPV6special(final String address)
   {
    final String expandedAddress = checkIPV6(address);
    if ("0000:0000:0000:0000:0000:0000:0000:0000".equals(expandedAddress) || "0000:0000:0000:0000:0000:0000:0000:0001".equals(expandedAddress)) // default route, loopback //$NON-NLS-1$ //$NON-NLS-2$
     {
      return true;
     }
    final String[] blocks = expandedAddress.split(":"); //$NON-NLS-1$
    return ("00ff".equals(blocks[0])); // Multicast //$NON-NLS-1$
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
   * @param address IP V6 address
   * @return true when public address, otherwise false
   * @throws NullPointerException If address is null
   * @throws IllegalArgumentException If not an IP V6 address
   * @deprecated Use de.powerstat.validation.values.IPV6Address.isPublic() instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static boolean isIPV6public(final String address)
   {
    return !isIPV6private(address) && !isIPV6special(address);
   }


  /**
   * Check hostname and give it back or throw exception.
   *
   * @param hostname Hostname to check
   * @return Clean hostname, IP v4 or IP V6 address
   * @throws NullPointerException when hostname is null
   * @throws StringIndexOutOfBoundsException When the hostname is less than 4 characters or greater than 253 characters, or when a hostname part is empty or greater than 63 characters
   * @throws IllegalArgumentException When the hostname contains illegal characters or is not a minimum of 'subdomain.topleveldomain', or has a '-' character in as subdomain start/end character, or if the top level domain is unknown
   * @deprecated Use de.powerstat.validation.values.Hostname instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static String checkHostname(final String hostname)
   {
    Objects.requireNonNull(hostname, "hostname"); //$NON-NLS-1$
    if ((hostname.length() < 2) || (hostname.length() > 253))
     {
      throw new StringIndexOutOfBoundsException("Hostname to short/long"); //$NON-NLS-1$
     }
    if (isIPV4(hostname) || isIPV6(hostname))
     {
      return hostname;
     }
    if (!hostname.matches("^[.0-9a-zA-Z-]+$")) //$NON-NLS-1$
     {
      throw new IllegalArgumentException("Hostname contains illegal character"); //$NON-NLS-1$
     }
    final String[] parts = hostname.split(ESC_DOT);
    if (parts.length < 2)
     {
      throw new IllegalArgumentException("Hostname must be at a minimum consist of subdomain.topleveldomain"); //$NON-NLS-1$
     }
    for (final String part : parts)
     {
      if (part.isEmpty() || (part.length() > 63))
       {
        throw new StringIndexOutOfBoundsException("Hostname part empty or to long"); //$NON-NLS-1$
       }
      if ((part.charAt(0) == '-') || (part.charAt(part.length() - 1) == '-'))
       {
        throw new IllegalArgumentException("Illegal character '-' at name start or end"); //$NON-NLS-1$
       }
     }
    if (!GeneratedTlds.contains(parts[parts.length - 1]))
     {
      throw new IllegalArgumentException("Unknown top level domain in hostname"); //$NON-NLS-1$
     }
    return hostname;
   }


  /**
   * Is hostname.
   *
   * @param hostname Hostname
   * @return true: hostname, otherwise false
   * @deprecated Use de.powerstat.validation.values.Hostname instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static boolean isHostname(final String hostname)
   {
    try
     {
      /* final String checkedHostname = */ checkHostname(hostname);
       }
    catch (final StringIndexOutOfBoundsException | IllegalArgumentException | NullPointerException ignored)
     {
      return false;
     }
    return true;
   }


  /**
   * Check port number or throw Exception.
   *
   * @param port Port number
   * @return Port number when it's ok
   * @throws IndexOutOfBoundsException When the port is less than 0 or greater than 65535
   * @deprecated Use de.powerstat.validation.values.Port instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static int checkPort(final int port)
   {
    if ((port < 0) || (port > 65535))
     {
      throw new IndexOutOfBoundsException("Port number out of range (0-65535)!"); //$NON-NLS-1$
     }
    return port;
   }


  /**
   * Is port.
   *
   * @param port Port number
   * @return true: legal port number, otherwise false
   * @deprecated Use de.powerstat.validation.values.Port instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static boolean isPort(final int port)
   {
    try
     {
      /* final int checkedPort = */ checkPort(port);
     }
    catch (final IndexOutOfBoundsException ignored)
     {
      return false;
     }
    return true;
   }


  /**
   * Is system port (0-1023).
   *
   * @param port Port number
   * @return true: system port number, otherwise false
   * @deprecated Use de.powerstat.validation.values.Port.isSystem() instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static boolean isSystemPort(final int port)
   {
    try
     {
      /* final int checkedPort = */ checkPort(port);
     }
    catch (final IndexOutOfBoundsException ignored)
     {
      return false;
     }
    return port <= 1023;
   }


  /**
   * Is registered port (1024-49151).
   *
   * @param port Port number
   * @return true: registered port number, otherwise false
   * @deprecated Use de.powerstat.validation.values.Port.isRegistered() instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static boolean isRegisteredPort(final int port)
   {
    try
     {
      /* final int checkedPort = */ checkPort(port);
     }
    catch (final IndexOutOfBoundsException ignored)
     {
      return false;
     }
    return (port >= 1024) && (port <= 49151);
   }


  /**
   * Is dynamic port (49152-65535).
   *
   * @param port Port number
   * @return true: dynamic port number, otherwise false
   * @deprecated Use de.powerstat.validation.values.Port.isDynamic() instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static boolean isDynamicPort(final int port)
   {
    try
     {
      /* final int checkedPort = */ checkPort(port);
     }
    catch (final IndexOutOfBoundsException ignored)
     {
      return false;
     }
    return (port >= 49152);
   }


  /**
   * Exist hostname.
   *
   * @param hostname Hostname, IP V4 or IP V6 address
   * @return true if hostname was found, false otherwise
   * @deprecated Use de.powerstat.validation.values.Hostname.exist() instead.
   */
  @Deprecated(since = DEPRECATED_SINCE_2_0, forRemoval = false)
  public static boolean existHostname(final String hostname)
   {
    try
     {
      /* final InetAddress address = */ InetAddress.getByName(hostname);
     }
    catch (final UnknownHostException ignored)
     {
      return false;
     }
    return true;
   }


  /**
   * Sanitize url path.
   *
   * @param urlPath URL path
   * @return Sanitized url path
   * @throws NullPointerException when urlPath is null
   */
  public static String sanitizeUrlPath(final String urlPath)
   {
    Objects.requireNonNull(urlPath, "urlPath"); //$NON-NLS-1$
    final StringBuilder result = new StringBuilder(urlPath.length() + 1);
    if (urlPath.isEmpty()) // absolute vs relative ?
     {
      result.append(URI_SEPARATOR);
     }
    else
     {
      if (urlPath.charAt(0) != URI_SEPARATOR)
       {
        result.append(URI_SEPARATOR);
       }
      // TODO check illegal characters(?) and sanitize them.
      // /urlpath + ? param=value & param=value
      // ? & = # % +
      // https://de.wikipedia.org/wiki/URL-Encoding
      // reserviert: : / ? # [ ] @ ! $ & ' ( ) * + , ; =
      // nicht reserviert: A–Z, a–z, 0-9, - . _ ~
      result.append(urlPath);
     }
    return result.toString();
   }


  /**
   * Split hostname and port.
   *
   * @param hostnamePort "hostname:port", "ipv4:port", "[ipv6]:port"
   * @return String List 0: hostname; 1: port
   * @throws NullPointerException If hostnamePort is null
   * @throws IllegalArgumentException If it is not a host:port combination
   */
  public static List<String> splitHostnamePort(final String hostnamePort)
   {
    Objects.requireNonNull(hostnamePort, "hostnamePort"); //$NON-NLS-1$
    final int pos = hostnamePort.lastIndexOf(':');
    if (pos == -1)
     {
      throw new IllegalArgumentException("Not a host:port combination!"); //$NON-NLS-1$
     }
    final List<String> result = new ArrayList<>();
    if (hostnamePort.contains("[")) // hostname/IP V4/IP V6 //$NON-NLS-1$
     {
      result.add(hostnamePort.substring(1, pos - 1)); // remove [] from IP V6 address
     }
    else
     {
      result.add(hostnamePort.substring(0, pos));
     }
    result.add(hostnamePort.substring(pos + 1)); // port
    return result;
   }

 }
