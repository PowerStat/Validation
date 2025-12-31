/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
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
 * Canonical Media-Access-Control-Adresse (MAC).
 *
 * @param address MAC address
 *
 * TODO getManufacturer name http://standards-oui.ieee.org/oui/oui.csv
 * TODO Exists in network  (raw-socket)
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
   * UDP port 7 echo.
   */
  private static Port PORT_ECHO = Port.of(7);

  /**
   * UDP port 9 discard.
   */
  private static Port PORT_DISCARD = Port.of(9);

  /**
   * UDP ports list.
   */
  private static List<Port> WOL_PORTS = new ArrayList<>(Arrays.asList(PORT_ECHO, PORT_DISCARD));

  /**
   * Wake on lan magic package header.
   */
  private static byte[] MAGIC_HEADER = HexFormat.ofDelimiter(":").parseHex("ff:ff:ff:ff:ff:ff");

  /**
   * IPV4 limited broadcast address.
   */
  private static String IPV4_LIMITED_BROADCAST = "255.255.255.255";

  /**
   * IPv6-enabled nodes on the link.
   */
  private static String IPV6_LINK_LOCAL = "ff02::1";


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
   * Returns the value of this MACAdddress as a string with delimiter ':'.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return stringValue(MACAddress.SEPARATOR);
   }


  /**
   * Returns the value of this MacAddress as byte array.
   *
   * @return The text value represented by this object after conversion to type byte array.
   */
  public byte[] byteValue()
   {
    String[] parts = MACAddress.IPV6_SEPARATOR_REGEXP.split(address.toLowerCase(Locale.getDefault()));
    return HexFormat.of().parseHex(String.join("", parts));
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


  /*
  Die folgenden Adressbereiche sind lokal und können z. B. für virtuelle Maschinen verwendet werden:
  x2:xx:xx:xx:xx:xx
  x6:xx:xx:xx:xx:xx
  xA:xx:xx:xx:xx:xx
  xE:xx:xx:xx:xx:xx
  */


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
   * Send local wake on lan for mac address on IPV4 and IPV6.
   *
   * @throws IOException If an I/O error occurs.
   *
   * TODO directly over Ethernet using EtherType 0x0842.
   */
  public void sendLocalWakeOnLan() throws IOException
   {
    String[] parts = MACAddress.IPV6_SEPARATOR_REGEXP.split(address.toLowerCase(Locale.getDefault()));
    InetAddress ipv4address;
    InetAddress ipv6address;
    byte[] magicPackage;
    try
     {
      ipv4address = InetAddress.getByName(IPV4_LIMITED_BROADCAST);
     }
    catch (UnknownHostException e)
     {
      ipv4address = null;
     }
    try
     {
      ipv6address = InetAddress.getByName(IPV6_LINK_LOCAL);
     }
    catch (UnknownHostException e)
     {
      ipv6address = null;
     }
    ByteBuffer buffer = ByteBuffer.allocate(112).put(MAGIC_HEADER);
    for (int i = 0; i < 16; ++i)
     {
      buffer.put(HexFormat.of().parseHex(String.join("", parts)));
     }
    magicPackage = buffer.array();
    try (DatagramSocket socket = new DatagramSocket())
     {
      for (Port port : WOL_PORTS)
       {
        if (ipv4address != null)
         {
          DatagramPacket packetv4 = new DatagramPacket(magicPackage, magicPackage.length, ipv4address, port.port());
          socket.send(packetv4);
         }
        if (ipv6address != null)
         {
          DatagramPacket packetv6 = new DatagramPacket(magicPackage, magicPackage.length, ipv6address, port.port());
          socket.send(packetv6);
         }
       }
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
  public int compareTo(final MACAddress obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    String[] parts = MACAddress.IPV6_SEPARATOR_REGEXP.split(address.toLowerCase(Locale.getDefault()));
    String[] objparts = MACAddress.IPV6_SEPARATOR_REGEXP.split(obj.address.toLowerCase(Locale.getDefault()));
    return Arrays.compare(parts, objparts);
   }

 }
