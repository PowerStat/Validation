/*
 * Copyright (C) 2026 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.comm;


import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HexFormat;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Service Set Identifier (SSID).
 *
 * @param ssid SSID
 */
@ValueObject
public record SSID(String ssid) implements Comparable<SSID>, IValueObject
 {
  /**
   * SSID regexp.
   */
  private static final Pattern SSID_REGEXP = Pattern.compile("^[\\\\ a-zA-Z0-9\"\\[\\]!#$%&'()*+,./:;<=>?@^_|~`{}-]{0,32}$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param ssid SSID
   * @throws NullPointerException if ssid is null
   * @throws IllegalArgumentException if ssid is not a ssid
   */
  public SSID
   {
    Objects.requireNonNull(ssid, "ssid"); //$NON-NLS-1$
    if (ssid.length() > 32)
     {
      throw new IllegalArgumentException("To long for a ssid"); //$NON-NLS-1$
     }
    if (!SSID.SSID_REGEXP.matcher(ssid).matches())
     {
      throw new IllegalArgumentException("Not a ssid"); //$NON-NLS-1$
     }
    if ((ssid.length() > 0) && ((ssid.charAt(0) == ' ') || (ssid.charAt(ssid.length() - 1) == ' ')))
     {
      throw new IllegalArgumentException("Not a ssid"); //$NON-NLS-1$
     }
   }


  /**
   * SSID factory.
   *
   * @param ssid SSID
   * @return SSID object
   */
  public static SSID of(final String ssid)
   {
    return new SSID(ssid);
   }


  /**
   * Returns the value of this SSID as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return ssid;
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final SSID obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return ssid.compareTo(obj.ssid);
   }

 }
