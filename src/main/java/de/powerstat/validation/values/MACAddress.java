/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.regex.Pattern;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Canonical Media-Access-Control-Adresse (MAC).
 *
 * @param address MAC address
 *
 * TODO getManufacturer name
 * TODO Exists in network
 * http://standards-oui.ieee.org/oui/oui.csv
 */
@ValueObject
public record MACAddress(String address) implements Comparable<MACAddress>, IValueObject
 {
  /**
   * Suppress warning constant.
   */
  private static final String CLI_CONSTANT_LIST_INDEX = "CLI_CONSTANT_LIST_INDEX";

  /**
   * Hex 00.
   */
  private static final String H00 = "00"; //$NON-NLS-1$

  /**
   * Hex 01.
   */
  private static final String H01 = "01"; //$NON-NLS-1$

  /**
   * Hex 33.
   */
  private static final String H33 = "33"; //$NON-NLS-1$

  /**
   * Hex 5e.
   */
  private static final String H5E = "5e"; //$NON-NLS-1$

  /**
   * Hex ff.
   */
  private static final String HFF = "ff"; //$NON-NLS-1$

  /**
   * Byte separator.
   */
  private static final String SEPARATOR = ":"; //$NON-NLS-1$

  /**
   * Delimiter.
   */
  private static final String DELIMITER = "-"; //$NON-NLS-1$

  /**
   * Delimiter constant.
   */
  private static final String DELIMITER_TXT = "delimiter"; //$NON-NLS-1$

  /**
   * Illegal delimiter length constant.
   */
  private static final String ILLEGAL_DELIMITER_LENGTH = "Illegal delimiter length"; //$NON-NLS-1$

  /**
   * Illegal delimiter character constant.
   */
  private static final String ILLEGAL_DELIMITER_CHARACTER = "Illegal delimiter character"; //$NON-NLS-1$

  /**
   * IP V6 regexp.
   */
  private static final Pattern IPV6_REGEXP = Pattern.compile("^[0-9a-f]{2}([:-]?[0-9a-f]{2}){5}$"); //$NON-NLS-1$

  /**
   * IP V6 separator regexp.
   */
  private static final Pattern IPV6_SEPARATOR_REGEXP = Pattern.compile("[:-]"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param address MAC address
   * @throws NullPointerException if address is null
   * @throws IllegalArgumentException if address is not a mac address
   */
  public MACAddress
   {
    Objects.requireNonNull(address, "address"); //$NON-NLS-1$
    if ((address.length() != 12) && (address.length() != 17))
     {
      throw new IllegalArgumentException("To short or long for a mac address"); //$NON-NLS-1$
     }
    if (!MACAddress.IPV6_REGEXP.matcher(address.toLowerCase(Locale.getDefault())).matches())
     {
      throw new IllegalArgumentException("Not a mac address"); //$NON-NLS-1$
     }
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
   * Returns the value of this MACAddress as a string.
   *
   * @param delimiter Delimiter could be empty, : or -
   * @return The text value represented by this object after conversion to type string.
   */
  public String stringValue(final String delimiter)
   {
    Objects.requireNonNull(delimiter, MACAddress.DELIMITER_TXT);
    if (delimiter.length() > 1)
     {
      throw new IllegalArgumentException(MACAddress.ILLEGAL_DELIMITER_LENGTH);
     }
    if (!delimiter.isEmpty() && !MACAddress.SEPARATOR.equals(delimiter) && !MACAddress.DELIMITER.equals(delimiter))
     {
      throw new IllegalArgumentException(MACAddress.ILLEGAL_DELIMITER_CHARACTER);
     }
    String[] parts = MACAddress.IPV6_SEPARATOR_REGEXP.split(address.toLowerCase(Locale.getDefault()));
    return String.join(delimiter, parts);
   }


  /**
   * Returns the value of this MACADdress as a string with delimiter ':'.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return stringValue(MACAddress.SEPARATOR);
   }


  /**
   * Is broadcast address.
   *
   * @return true if broadcast address, false otherwise
   */
  @SuppressFBWarnings(CLI_CONSTANT_LIST_INDEX)
  public boolean isBroadcast()
   {
  	String[] parts = MACAddress.IPV6_SEPARATOR_REGEXP.split(address.toLowerCase(Locale.getDefault()));
    return MACAddress.HFF.equals(parts[0]) && MACAddress.HFF.equals(parts[1]) && MACAddress.HFF.equals(parts[2]) && MACAddress.HFF.equals(parts[3]) && MACAddress.HFF.equals(parts[4]) && MACAddress.HFF.equals(parts[5]);
   }


  /**
   * Is group.
   *
   * @return true: group, false: individual
   */
  public boolean isGroup()
   {
    String[] parts = MACAddress.IPV6_SEPARATOR_REGEXP.split(address.toLowerCase(Locale.getDefault()));
    return (Integer.parseInt(parts[0], 16) & 0x01) != 0;
   }


  /**
   * Is local.
   *
   * @return true: local, false: universal
   */
  public boolean isLocal()
   {
    String[] parts = MACAddress.IPV6_SEPARATOR_REGEXP.split(address.toLowerCase(Locale.getDefault()));
    return (Integer.parseInt(parts[0], 16) & 0x02) != 0;
   }


  /**
   * Is IP v4 multicast mac.
   *
   * @return true if mac is an ip v4 multicast address, false otherwise
   */
  @SuppressFBWarnings(CLI_CONSTANT_LIST_INDEX)
  public boolean isIPV4Multicast()
   {
    String[] parts = MACAddress.IPV6_SEPARATOR_REGEXP.split(address.toLowerCase(Locale.getDefault()));
    return MACAddress.H01.equals(parts[0]) && MACAddress.H00.equals(parts[1]) && MACAddress.H5E.equals(parts[2]) && ((Integer.parseInt(parts[3], 16) & 0x80) == 0);
   }


  /**
   * Is IP v6 multicast mac.
   *
   * @return true if mac is an ip v6 multicast address, false otherwise
   */
  @SuppressFBWarnings(CLI_CONSTANT_LIST_INDEX)
  public boolean isIPV6Multicast()
   {
    String[] parts = MACAddress.IPV6_SEPARATOR_REGEXP.split(address.toLowerCase(Locale.getDefault()));
    return MACAddress.H33.equals(parts[0]) && MACAddress.H33.equals(parts[1]);
   }


  /**
   * Is VRRP mac (Virtual Router Redundancy Protocol).
   *
   * @return true if mac is a vrrp address, false otherwise
   */
  @SuppressFBWarnings(CLI_CONSTANT_LIST_INDEX)
  public boolean isVRRP()
   {
    String[] parts = MACAddress.IPV6_SEPARATOR_REGEXP.split(address.toLowerCase(Locale.getDefault()));
    return MACAddress.H00.equals(parts[0]) && MACAddress.H00.equals(parts[1]) && MACAddress.H5E.equals(parts[2]) && MACAddress.H00.equals(parts[3]) && MACAddress.H01.equals(parts[4]);
   }


  /**
   * Get OUI (Organizationally Unique Identifier).
   *
   * @return OUI (MA-L) string 000000
   *
   * TODO OUI-28 (MA-M), OUI-36 (MA-S)
   */
  @SuppressFBWarnings(CLI_CONSTANT_LIST_INDEX)
  public String getOUI()
   {
    String[] parts = MACAddress.IPV6_SEPARATOR_REGEXP.split(address.toLowerCase(Locale.getDefault()));
    return String.format("%1$02X", Integer.parseInt(parts[0], 16) & 0xfc) + parts[1].toUpperCase(Locale.getDefault()) + parts[2].toUpperCase(Locale.getDefault()); //$NON-NLS-1$
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
    String[] parts = MACAddress.IPV6_SEPARATOR_REGEXP.split(address.toLowerCase(Locale.getDefault()));
    String[] objparts = MACAddress.IPV6_SEPARATOR_REGEXP.split(obj.address.toLowerCase(Locale.getDefault()));
    return Arrays.compare(parts, objparts);
   }

 }
