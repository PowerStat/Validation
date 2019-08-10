/*
 * Copyright (C) 2018-2019 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation;


import java.util.Objects;


/**
 * General validation utilities.
 *
 * @author Kai Hofmann
 */
public final class ValidationUtils
 {
  /**
   * URI separator.
   */
  private static final char URI_SEPARATOR = '/';


  /**
   * Private default constructor.
   */
  private ValidationUtils()
   {
    super();
   }


  /**
   * Check hostname and give it back or throw Exceptions.
   *
   * @param hostname Hostname to check
   * @return Clean hostname
   * @throws StringIndexOutOfBoundsException When the hostname is less than 4 characters or greater than 253 characters, or when a hostname part is empty or greater than 63 characters
   * @throws IllegalArgumentException When the hostname contains illegal characters
   * @throws NullPointerException when hostname is null
   */
  public static String checkHostname(final String hostname)
   {
    Objects.requireNonNull(hostname, "hostname"); //$NON-NLS-1$
    if ((hostname.length() < 4) || (hostname.length() > 253))
     {
      throw new StringIndexOutOfBoundsException("Hostname to short/long!"); //$NON-NLS-1$
     }
    if (!hostname.matches("^[.0-9a-zA-Z-]+$")) //$NON-NLS-1$
     {
      throw new IllegalArgumentException("Hostname contains illegal character!"); //$NON-NLS-1$
     }
    final String[] parts = hostname.split("[.]"); //$NON-NLS-1$
    for (final String part : parts)
     {
      if (part.isEmpty() || (part.length() > 63))
       {
        throw new StringIndexOutOfBoundsException("Hostname part empty or to long!"); //$NON-NLS-1$
       }
     }
    return hostname;
   }


  /**
   * Check port number or throw Exception.
   *
   * @param port Port number
   * @return Port number when it's ok
   * @throws IndexOutOfBoundsException When the port is less than 0 or greater than 65535
   */
  public static int checkPort(final int port)
   {
    if ((port < 0) || (port > 65535))
     {
      throw new IndexOutOfBoundsException("Port number out of range (0-65535)!"); //$NON-NLS-1$
     }
    // 0-1023 System ports
    // 1024-49151 registered ports
    // 49152-65535 dynamic ports
    return port;
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
    if (!urlPath.isEmpty())
     {
      if (urlPath.charAt(0) != URI_SEPARATOR)
       {
        result.append(URI_SEPARATOR);
       }
      // TODO check illegal characters(?) and sanitize them.
     }
    result.append(urlPath);
    return result.toString();
   }

 }
