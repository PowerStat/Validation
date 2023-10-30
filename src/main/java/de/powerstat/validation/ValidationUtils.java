/*
 * Copyright (C) 2018-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


/**
 * General validation utilities.
 *
 * @author Kai Hofmann
 */
// @SuppressFBWarnings({"CLI_CONSTANT_LIST_INDEX", "DCN_NULLPOINTER_EXCEPTION", "EXS_EXCEPTION_SOFTENING_RETURN_FALSE"})
@SuppressWarnings("java:S1696")
public final class ValidationUtils
 {
  /* *
   * Logger.
   */
  // private static final Logger LOGGER = LogManager.getLogger(ValidationUtils.class);

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
   * Sanitize url path.
   *
   * @param urlPath URL path
   * @return Sanitized url path
   * @throws NullPointerException when urlPath is null
   */
  public static String sanitizeUrlPath(final String urlPath)
   {
    Objects.requireNonNull(urlPath, "urlPath"); //$NON-NLS-1$
    final var result = new StringBuilder(urlPath.length() + 1);
    if (urlPath.isEmpty()) // absolute vs relative ?
     {
      result.append(ValidationUtils.URI_SEPARATOR);
     }
    else
     {
      if (urlPath.charAt(0) != ValidationUtils.URI_SEPARATOR)
       {
        result.append(ValidationUtils.URI_SEPARATOR);
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
