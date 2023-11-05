/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Objects;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.powerstat.validation.generated.GeneratedTlds;
import de.powerstat.validation.interfaces.IValueObject;


/**
 * Hostname.
 *
 * @param hostname Hostname
 * 
 * Probably DSGVO relevant.
 *
 * TODO Verify TopLevelDomain
 * TODO ping ok?
 */
public record Hostname(String hostname) implements Comparable<Hostname>, IValueObject
 {
  /**
   * Hostname regexp.
   */
  private static final Pattern HOSTNAME_REGEXP = Pattern.compile("^[.0-9a-zA-Z-]+$"); //$NON-NLS-1$

  /**
   * Escaped dot.
   */
  private static final String ESC_DOT = "\\."; //$NON-NLS-1$

  /**
   * Hostname by dots regexp.
   */
  private static final Pattern HOSTNAME_BY_DOTS = Pattern.compile(Hostname.ESC_DOT);


  /**
   * Constructor.
   *
   * @param hostname Hostname
   * @throws NullPointerException if hostname is null
   * @throws IllegalArgumentException if hostname is not a hostname
   */
  public Hostname
   {
    Objects.requireNonNull(hostname, "hostname"); //$NON-NLS-1$
    if ((hostname.length() < 2) || (hostname.length() > 253))
     {
      throw new IllegalArgumentException("To short or long for a hostname"); //$NON-NLS-1$
     }
    var tempHostname = ""; //$NON-NLS-1$
    try
     {
      tempHostname = IPV4Address.of(hostname).address();
     }
    catch (final IllegalArgumentException ignored)
     {
      // LOGGER.debug("IllegalArgumentException", ignored);
     }
    try
     {
      if (tempHostname.isEmpty())
       {
        tempHostname = IPV6Address.of(hostname).stringValue();
       }
     }
    catch (final IllegalArgumentException ignored)
     {
      // LOGGER.debug("IllegalArgumentException", ignored);
     }
    if (tempHostname.isEmpty())
     {
      tempHostname = checkHostname(hostname);
     }
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
    final String[] parts = HOSTNAME_BY_DOTS.split(hostname, 0);
    // final String[] parts = hostname.split(Hostname.ESC_DOT);
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
    final String[] parts = HOSTNAME_BY_DOTS.split(hostname, 0);
    // final String[] parts = hostname.split(Hostname.ESC_DOT);
    final var buffer = new StringBuilder(hostname.length());
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
   * Returns the value of this Hostname as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
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
    return reverseHostname(hostname);
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
      // LOGGER.debug("UnknownHostException", ignored);
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
      final var address = InetAddress.getByName(this.hostname);
      return address.isReachable(timeout);
     }
    catch (final IOException ignored)
     {
      // LOGGER.debug("IOException", ignored);
      return false;
     }
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
