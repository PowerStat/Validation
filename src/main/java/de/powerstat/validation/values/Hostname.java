/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.generated.GeneratedTlds;


/**
 * Hostname.
 *
 * Probably DSGVO relevant.
 *
 * TODO Verify TopLevelDomain
 * TODO ping ok?
 */
// @SuppressFBWarnings("EXS_EXCEPTION_SOFTENING_RETURN_FALSE")
public final class Hostname implements Comparable<Hostname>
 {
  /**
   * Hostname regexp.
   */
  private static final Pattern HOSTNAME_REGEXP = Pattern.compile("^[.0-9a-zA-Z-]+$"); //$NON-NLS-1$

  /**
   * Hostname.
   */
  private final String hostname;

  /**
   * Reverse hostname.
   */
  @SuppressWarnings("PMD.AvoidFieldNameMatchingMethodName")
  private final String reverseHostname;


  /**
   * Constructor.
   *
   * @param hostname Hostname
   * @throws NullPointerException if hostname is null
   * @throws IllegalArgumentException if hostname is not a hostname
   */
  public Hostname(final String hostname)
   {
    super();
    Objects.requireNonNull(hostname, "hostname"); //$NON-NLS-1$
    if ((hostname.length() < 2) || (hostname.length() > 253))
     {
      throw new IllegalArgumentException("To short or long for a hostname"); //$NON-NLS-1$
     }
    String tempHostname = ""; //$NON-NLS-1$
    try
     {
      tempHostname = new IPV4Address(hostname).getAddress();
     }
    catch (final IllegalArgumentException ignored)
     {
      // ignore
     }
    try
     {
      if (tempHostname.isEmpty())
       {
        tempHostname = new IPV6Address(hostname).getAddress();
       }
     }
    catch (final IllegalArgumentException ignored)
     {
      // ignore
     }
    if (tempHostname.isEmpty())
     {
      tempHostname = checkHostname(hostname);
      this.reverseHostname = reverseHostname(tempHostname);
     }
    else
     {
      this.reverseHostname = tempHostname;
     }
    this.hostname = tempHostname;
   }


  /**
   * Check hostname.
   *
   * @param hostname Hostname
   * @return Hostname
   */
  private static String checkHostname(final String hostname)
   {
    if (!Hostname.HOSTNAME_REGEXP.matcher(hostname).matches())
     {
      throw new IllegalArgumentException("Hostname contains illegal character"); //$NON-NLS-1$
     }
    final String[] parts = hostname.split("\\."); //$NON-NLS-1$
    if (parts.length < 2)
     {
      throw new IllegalArgumentException("Hostname must be at a minimum consist of subdomain.topleveldomain"); //$NON-NLS-1$
     }
    for (final String part : parts)
     {
      if (part.isEmpty() || (part.length() > 63))
       {
        throw new IllegalArgumentException("Hostname part empty or to long"); //$NON-NLS-1$
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
   * Reverse hostname.
   *
   * @param hostname Hostname
   * @return Reversed hostname.
   */
  private static String reverseHostname(final String hostname)
   {
    final String[] parts = hostname.split("\\."); //$NON-NLS-1$
    final StringBuilder buffer = new StringBuilder(hostname.length());
    for (int i = parts.length - 1; i >= 0; --i)
     {
      if (buffer.length() != 0)
       {
        buffer.append('.');
       }
      buffer.append(parts[i]);
     }
    return buffer.toString();
   }


  /**
   * Hostname factory.
   *
   * @param hostname Hostname
   * @return Hostname object
   */
  public static Hostname of(final String hostname)
   {
    return new Hostname(hostname);
   }


  /**
   * Get hostname string.
   *
   * @return Hostname string
   */
  public String getHostname()
   {
    return this.hostname;
   }


  /**
   * Get reverse hostname string.
   *
   * @return Reverse hostname string
   */
  public String getReverseHostname()
   {
    return this.reverseHostname;
   }


  /**
   * Exist hostname.
   *
   * @return true if hostname was found, false otherwise
   */
  public boolean exist()
   {
    try
     {
      /* final InetAddress address = */ InetAddress.getByName(this.hostname);
     }
    catch (final UnknownHostException ignored)
     {
      return false;
     }
    return true;
   }


  /**
   * Is hostname reachable.
   *
   * @param timeout Timeout in milliseconds.
   * @return true: Hostname is reachable; false otherwise
   */
  public boolean isReachable(final int timeout)
   {
    try
     {
      final InetAddress address = InetAddress.getByName(this.hostname);
      return address.isReachable(timeout);
     }
    catch (final IOException ignored)
     {
      return false;
     }
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
    return this.hostname.hashCode();
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
    if (!(obj instanceof Hostname))
     {
      return false;
     }
    final Hostname other = (Hostname)obj;
    return this.hostname.equals(other.hostname);
   }


  /**
   * Returns the string representation of this Hostname.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Hostname[hostname=192.168.0.0]"
   *
   * @return String representation of this Hostname
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(19);
    builder.append("Hostname[hostname=").append(this.hostname).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Hostname obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.hostname.compareTo(obj.hostname);
   }

 }
