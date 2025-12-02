/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Arrays;
import java.util.Formatter;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Address.
 *
 * DSGVO relevant.
 *
 * TODO COUNTRYNAME - English country names
 * TODO vcard, hcard, ldap, vcard+xml -&gt; Data mappings/converter
 * TODO Get/cache GPS posiion for address
 */
// @SuppressFBWarnings{("CC_CYCLOMATIC_COMPLEXITY", "PMB_POSSIBLE_MEMORY_BLOAT"})
@SuppressWarnings({"java:S923", "java:S3776", "PMD.ExcessiveClassLength"})
@ValueObject
public class Address implements Comparable<Address>, IValueObject
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<NTuple15<Country, PostalCode, City, Province, District, Street, BuildingNr, BuildingName, SubBuilding, PoBoxNumber, Department, Neighbourhood, Block, BFPONumber, Lines>, Address> CACHE = new WeakHashMap<>();

  /**
   * NPath complexity.
   */
  private static final String PMD_N_PATH_COMPLEXITY = "PMD.NPathComplexity";

  /**
   * Address formats for countries.
   */
  private static final Map<String, String> ADDRESS_FORMATS = new ConcurrentHashMap<>();

  /**
   * Address format 1.
   */
  private static final String FORMAT1 = "%2$s%n%16$s%n%4$s%n%3$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 2.
   */
  private static final String FORMAT2 = "%2$s%n%10$s%n%9$s%n%8$s %7$s%n%6$s%nBP %11$s%n%3$s %4$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 3.
   */
  private static final String FORMAT3 = "%2$s%nBP %11$s%n%4$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 4.
   */
  private static final String FORMAT4 = "%2$s%n%8$s %7$s%n%4$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 5.
   */
  private static final String FORMAT5 = "%2$s%n%16$s%n%4$s %5$s %3$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 6.
   */
  private static final String FORMAT6 = "%2$s%n%7$s %8$s%n%3$s %4$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 7.
   */
  private static final String FORMAT7 = "%2$s%nP.O. Box %11$s%n%4$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 8.
   */
  private static final String FORMAT8 = "%2$s%n%8$s %7$s%n%4$s %5$s %3$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 9.
   */
  private static final String FORMAT9 = "%2$s%n%8$s, %7$s%n%3$s %4$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 10.
   */
  private static final String FORMAT10 = "%2$s%n%7$s %8$s%n%4$s %5$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 11.
   */
  private static final String FORMAT11 = "%2$s%n%7$s %8$s %10$s%n%3$s %4$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 12.
   */
  private static final String FORMAT12 = "%2$s%nB.P. %11$s%n%4$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 13.
   */
  private static final String FORMAT13 = "%2$s%n%10$s%n%9$s%n%8$s %7$s%n%6$s%n%4$s%n%3$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 14.
   */
  private static final String FORMAT14 = "%2$s%n%8$s %7$s, %6$s%n%3$s %4$s%n%1$s%n";

  /**
   * Address format 15.
   */
  private static final String FORMAT15 = "%2$s%nPostboks %11$s%n%7$s %8$s, %6$s%n%3$s %4$s%n%1$s%n";

  /**
   * Address format 16.
   */
  private static final String FORMAT16 = "%2$s%n%7$s %8$s%n%4$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 17.
   */
  private static final String FORMAT17 = "%2$s%n%9$s%n%7$s %8$s%n%6$s%n%3$s %4$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 18.
   */
  private static final String FORMAT18 = "%2$s%n%7$s %8$s%n%6$s%n%3$s %4$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 19.
   */
  private static final String FORMAT19 = "%2$s%nBP %11$s%n%8$s %7$s%n%3$s %4$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 20.
   */
  private static final String FORMAT20 = "%2$s%nP.O. Box %11$s%n%7$s %8$s%n%3$s %4$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 21.
   */
  private static final String FORMAT21 = "%2$s%n%7$s %8$s%n%6$s%n%4$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 22.
   */
  private static final String FORMAT22 = "%2$s%n%16$s%n%4$s %3$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 23.
   */
  private static final String FORMAT23 = "%2$s%nPostboks %11$s%n%7$s %8$s%n%3$s %4$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * Address format 24.
   */
  private static final String FORMAT24 = "%2$s%nP.O. Box %11$s%n%4$s%n%5$s%n%1$s%n"; //$NON-NLS-1$

  /**
   * No optinals regexp.
   */
  @SuppressWarnings("java:S5857")
  private static final Pattern NOOPTIONALS_REGEXP = Pattern.compile("\\[.*?\\]"); //$NON-NLS-1$

  /**
   * Country.
   */
  private final Country country;

  /**
   * Postal code.
   */
  private final @Nullable PostalCode postalCode;

  /**
   * City.
   */
  private final @Nullable City city;

  /**
   * Province.
   */
  private final @Nullable Province province;

  /**
   * District.
   */
  private final @Nullable District district;

  /**
   * Street.
   */
  private final @Nullable Street street;

  /**
   * Building number.
   */
  private final @Nullable BuildingNr buildingNr;

  /**
   * Building name.
   */
  private final @Nullable BuildingName buildingName;

  /**
   * Sub building.
   */
  private final @Nullable SubBuilding subBuilding;

  /**
   * Post office box number.
   */
  private final @Nullable PoBoxNumber poBoxNumber;

  /**
   * Department.
   */
  private final @Nullable Department department;

  /**
   * Neighborhood.
   */
  private final @Nullable Neighbourhood neighbourhood;

  /**
   * Block.
   */
  private final @Nullable Block block;

  /**
   * British Forces Post Office number.
   */
  private final @Nullable BFPONumber bFPONumber;

  /**
   * Lines 1-5.
   */
  private final @Nullable Lines lines;


  /* *
   * Static initialization.
   *
   * 01: COUNTRYNAME
   * 02: Company
   * 03: POSTALCODE
   * 04: City
   * 05: Province
   * 06: District
   * 07: Street
   * 08: BuildingNumber
   * 09: BuildingName
   * 10: SubBuilding
   * 11: PoBoxNumber
   * 12: Department
   * 13: Neighbourhood
   * 14: Block
   * 15: BFPONUMBER
   * 16: Line1-5
   */
  static
   {
    Address.ADDRESS_FORMATS.put("AF", "%2$s%n%6$s, %7$s%nHouse No. %8$s%nP.O. Box %11$s%n%4$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("AX", "%2$s%n%7$s %8$s%nAX-%3$s %4$s%nÅLAND%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("AL", "%2$s%n%7$s%n%8$s, %10$s, %9$s%n%3$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("DZ", Address.FORMAT9); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("AS", Address.FORMAT8); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("AD", "%2$s%n%7$s, %8$s %10$s %9$s%n%3$s %5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("AO", "%2$s%n%7$s %8$s%nBP %11$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("AI", Address.FORMAT7); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("AQ", ""); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("AG", Address.FORMAT7); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("AR", Address.FORMAT6); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("AM", "%2$s%n%7$s %8$s %10$s %9$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("AW", "%2$s%n%7$s # %8$s%n%10$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("AU", Address.FORMAT5); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("AT", Address.FORMAT6); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("AZ", Address.FORMAT6); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("BS", "%2$s%n%9$s%n%7$s%nP.O. Box N %11$s%n%4$s BS %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("BH", "%2$s%n%7$s %8$s%nP.O. Box %11$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("BD", "%2$s%n%9$s%n%7$s %8$s%n%4$s - %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("BB", "%2$s%n%9$s%n%7$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("BY", "%2$s%n%7$s %8$s %9$s %10$s%n%3$s %4$s%n%6$s%n%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("BE", Address.FORMAT6); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("BZ", Address.FORMAT4); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("BJ", Address.FORMAT3); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("BM", "%2$s%n%9$s%n%8$s %7$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("BT", "%2$s%n%9$s%nHouse No. %8$s%nP.O Box %11$s%n%6$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("BO", "%2$s%n%7$s %8$s%nPO BOX %11$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("BQ", Address.FORMAT10); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("BA", Address.FORMAT6); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("BW", Address.FORMAT7); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("BV", ""); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("BR", "%2$s%n%7$s, %8$s%n%4$s - %5$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("IO", Address.FORMAT13); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("BN", "%2$s%n%8$s %10$s %9$s, %7$s%n%4$s%n%5$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("BG", Address.FORMAT11); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("BF", "%2$s%nBP %11$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("BI", Address.FORMAT3); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("KH", Address.FORMAT8); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("CM", Address.FORMAT3); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("CA", Address.FORMAT5); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("CV", "%2$s%nC.P. %11$s%n%7$s %8$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("KY", "%2$s%nP.O. Box %11$s%n%5$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("CF", Address.FORMAT3); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("TD", Address.FORMAT3); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("CL", "%2$s%n%7$s %8$s%n%3$s %4$s%n%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("CN", Address.FORMAT14); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("CX", Address.FORMAT8); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("CC", Address.FORMAT8); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("CO", "%2$s%n%7$s %8$s%n%4$s[-%5$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("KM", Address.FORMAT3); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("CG", "%2$s%nBP %11$s%n%8$s, %7$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("CD", Address.FORMAT12); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("CK", "%2$s%n%8$s %7$s%n%6$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("CR", "%2$s%n%7$s # %8$s%n%6$s, %4$s, %5$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("CI", "%2$s%n%9$s%n%7$s%nB.P. %11$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("HR", "%2$s%n%7$s %8$s%nP.P. %11$s%nHR-%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("CU", "%2$s%n%7$s %8$s%n%6$s%nCP %3$s %4$s %5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("CW", Address.FORMAT10); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("CY", "%2$s%nP.O. Box %11$s%n%7$s %8$s%nCY-%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("CZ", "%2$s%n%9$s%n%7$s %8$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("DK", Address.FORMAT15); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("DJ", Address.FORMAT3); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("DM", "%2$s%n%9$s%n%8$s %7$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("DO", "%2$s%n%7$s # %8$s %10$s%n%6$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("EC", "%2$s%n%7$s %8$s%n%3$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("EG", "%2$s%n%8$s, %7$s%n%6$s%n%4$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("SV", "%2$s%n%7$s #%8$s%nCP %3$s - %4$s%n%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("GQ", Address.FORMAT16); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("ER", "%2$s%nPO Box %11$s%n%7$s %8$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("EE", Address.FORMAT17); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("ET", "%2$s%nP.O. Box %11$s%n%9$s%n%7$s %8$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("FK", "%2$s%n%9$s%n%8$s %7$s%n%4$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("FO", "%2$s%n%7$s %8$s%nPO%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("FJ", "%2$s%nPO BOX %11$s%n%8$s %7$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("FI", "%2$s%nPL %11$s%n%7$s %8$s%nFI-%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("FR", Address.FORMAT2); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("GF", Address.FORMAT2); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("PF", Address.FORMAT2); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("TF", Address.FORMAT2); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("GA", "%2$s%nBP %11$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("GM", Address.FORMAT4); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("GE", Address.FORMAT6); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("DE", "%2$s%n[Postfach %11$s%n][%7$s %8$s%n]%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("GH", "%2$s%nP.O. Box %11$s%n%4$s - %5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("GI", "%2$s%n%10$s%n%9$s%n%8$s %7$s%nPO Box %11$s%nGibraltar%nGX11 1AA%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("GR", "%2$s%n%8$s %7$s%nP.O. Box %11$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("GL", Address.FORMAT15); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("GD", "%2$s%n%7$s%nP.O. BOX %11$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("GP", Address.FORMAT2); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("GU", Address.FORMAT5); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("GT", "%2$s%n%9$s%n%8$s %7$s%n%3$s-]%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("GG", Address.FORMAT1); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("GN", "%2$s%n%3$s BP %11$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("GW", Address.FORMAT6); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("GY", Address.FORMAT8); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("HT", "%2$s%n%9$s%n%7$s %8$s%nHT%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("HM", ""); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("VA", "%2$s%n%7$s %8$s%n%3$s %4$s %5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("HN", "%2$s%n%7$s %8$s%n%3$s %4$s, %5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("HK", "%2$s%n%10$s%n%9$s%n%8$s %7$s%nP.O. Box %11$s%n%6$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("HU", "%2$s%n%4$s%n%7$s %8$s%nPF. %11$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("IS", Address.FORMAT6); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("IN", "%2$s%n%10$s %9$s%n%8$s, %7$s%n%4$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("ID", "%2$s%n%9$s%n%7$s No. %8$s, %10$s%n%6$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("IR", "%2$s%n%4$s, %6$s%n%7$s%n%9$s No. %8$s, %10$s%n%5$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("IQ", "%2$s%nP.O. box %11$s%n%8$s %7$s%n%4$s, %5$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("IE", "%2$s%n%12$s%n%16$s%n%4$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("IM", Address.FORMAT13); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("IL", "%2$s%n%9$s%n%10$s%n%8$s, %7$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("IT", "%2$s%n%7$s %8$s %10$s%n%3$s %4$s %5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("JM", "%2$s%nP.O. Box %11$s%n%8$s %7$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("JP", "%2$s%n%9$s%8$s %14$s, %13$s%n%6$s, %4$s, %5$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("JE", Address.FORMAT1); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("JO", "%2$s%n%5$s%n%6$s%n%7$s%n%8$s %10$s%nPO Box %11$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("KZ", "%2$s%n%7$s, %8$s, %10$s%n%4$s %6$s%n%1$s%n%3$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("KE", "%2$s%n%9$s%n%7$s%nP O Box %11$s%n%4$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("KI", "%2$s%nPO Box %11$s%n%8$s %7$s%n%4$s%n%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("KP", "%2$s%n%7$s %8$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("KR", "%2$s%n%9$s%n%8$s, %7$s%n%5$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("KW", "%2$s%nB.P. %11$s %6$s%n%7$s %8$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("KG", "%2$s%n%8$s, %7$s, %10$s%n%3$s %4$s%n%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("LA", Address.FORMAT9); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("LV", "%2$s%n%7$s %8$s, %10$s%n%4$s, %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("LB", "%2$s%nP.O. Box %11$s%n%8$s %7$s. %10$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("LS", "%2$s%nP.O. Box %11$s%n%7$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("LR", "%2$s%n%7$s%n%3$s %4$s %5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("LY", Address.FORMAT16); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("LI", Address.FORMAT11); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("LT", Address.FORMAT18); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("LU", Address.FORMAT19); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("MO", "%2$s%nP.O. Box %11$s%n%7$s %8$s, %10$s%n%6$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("MK", Address.FORMAT20); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("MG", "%2$s%nB.P. %11$s%n%8$s %7$s %6$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("MW", "%2$s%n%7$s%nP.O. Box %11$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("MY", "%2$s%n%10$s %9$s%n%8$s, %7$s%n%6$s%n%3$s %4$s%n%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("MV", "%2$s%n%8$s, %7$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("ML", Address.FORMAT21); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("MT", "%2$s%nKaxxa Postali %11$s%n%8$s %7$s%n%4$s%n%5$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("MH", Address.FORMAT8); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("MQ", Address.FORMAT2); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("MR", Address.FORMAT12); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("MU", "%2$s%n%8$s, %7$s%n%6$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("YT", Address.FORMAT2); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("MX", "%2$s%n%7$s %8$s - %10$s%n%6$s%n%3$s %4$s, %5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("FM", Address.FORMAT8); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("MD", "%2$s%n%8$s %7$s, %10$s%nMD-%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("MC", Address.FORMAT2); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("MN", "%2$s%nPO Box %11$s%n%10$s, %7$s %8$s%n%6$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("ME", Address.FORMAT6); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("MS", Address.FORMAT1); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("MA", "%2$s%nP.O %11$s%n%10$s%n%9$s%8$s %7$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("MZ", "%2$s%nP.O %11$s%n%7$s %8$s, %10$s%n%3$s %4$s%n%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("MM", "%2$s%nNo. %8$s %7$s%n%6$s%n%4$s, %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("NA", Address.FORMAT7); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("NR", "%2$s%n%9$s%n%11$s%n%6$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("NP", "%2$s%n%7$s, %8$s%n%6$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("NL", "%2$s%n%10$s%n%9$s%n%7$s %8$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("NC", "%2$s%n%10$s%n%9$s%n%8$s %7$s%n%6$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("NZ", Address.FORMAT22); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("NI", "%2$s%n%9$s %7$s %8$s%n%6$s%n%3$s%n%4$s, %5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("NE", Address.FORMAT19); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("NG", "%2$s%nP.O. Box %11$s%n%8$s %7$s, %6$s%n%4$s %3$s%n%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("NU", Address.FORMAT22); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("NF", Address.FORMAT5); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("MP", Address.FORMAT8); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("NO", Address.FORMAT23); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("OM", "%2$s%nBP %11$s%n%3$s%n%4$s%n%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("PK", "%2$s%n%9$s%n%8$s %7$s%n%6$s%n%4$s-%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("PW", Address.FORMAT5); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("PS", ""); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("PA", "%2$s%n%7$s %8$s%n%3$s, %4$s%n%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("PG", "%2$s%nP.O. Box %11$s%n%4$s %3$s %5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("PY", Address.FORMAT6); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("PE", "%2$s%n%7$s %8$s, %6$s%n%3$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("PH", "%2$s%nP.O. Box %11$s%n%9$s%n%8$s %7$s, %6$s%n%4$s%n%3$s %5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("PN", Address.FORMAT1); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("PL", Address.FORMAT6); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("PT", Address.FORMAT17); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("PR", Address.FORMAT5); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("QA", "%2$s%n%9$s%nP.O. Box %11$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("RE", Address.FORMAT2); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("RO", Address.FORMAT18); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("RU", "%2$s%n%7$s%na/ya %11$s%n%8$s, %10$s%n%4$s%n%6$s%n%5$s%n%1$s%n%3$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("RW", Address.FORMAT12); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("BL", Address.FORMAT2); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("SH", Address.FORMAT1); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("KN", "%2$s%n%8$s %7$s%n%4$s%n%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("LC", Address.FORMAT4); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("MF", Address.FORMAT2); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("PM", Address.FORMAT2); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("VC", "%2$s%nP.O. Box %11$s%n%8$s %7$s%n%4$s VC%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("WS", "%2$s%nP.O Box %11$s%n%8$s %7$s%n%6$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("SM", Address.FORMAT6); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("ST", "%2$s%n%7$s %8$s, %10$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("SA", "%2$s%n%11$s%n%8$s %7$s, %6$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("SN", "%2$s%n%10$s%n%9$s%n%8$s %7$s%nBP %11$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("RS", "%2$s%nPP %11$s%n%7$s %8$s /%10$s%n%4$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("SC", "%2$s%nP.O. Box %11$s %4$s%n%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("SL", Address.FORMAT4); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("SG", "%2$s%n%8$s %7$s%n%10$s %9$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("SX", Address.FORMAT10); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("SK", Address.FORMAT20); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("SI", "%2$s%np.p. %11$s%n%7$s %8$s%nSI-%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("SB", Address.FORMAT24); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("SO", "%2$s%nP.O. Box %11$s%n%8$s %7$s%n%4$s, %5$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("ZA", "%2$s%nPO Box %11$s%n%10$s %9$s%n%8$s %7$s%n%6$s%n%4$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("GS", Address.FORMAT1); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("SS", "%2$s%nPOST OFFICE BOX %11$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("ES", "%2$s%nApartado %11$s%n%9$s%n%7$s %8$s, %10$s%n%3$s %4$s%n%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("LK", "%2$s%n%8$s %7$s%n%6$s%n%4$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("SD", "%2$s%n%9$s%nB.P. %11$s%n%3$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("SR", Address.FORMAT21); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("SJ", Address.FORMAT23); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("SZ", "%2$s%nP.O. Box %11$s%n%4$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("SE", "%2$s%nBOX %11$s%n%7$s %8$s%nSE-%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("CH", "%2$s%n%7$s %8$s%nCase postale %11$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("SY", "%2$s%n%7$s, %8$s%n%6$s%n%3$s %4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("TW", Address.FORMAT14); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("TJ", Address.FORMAT6); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("TZ", "%2$s%nP.O. Box %11$s%n%10$s%n%8$s %7$s%n%3$s %4$s%n%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("TH", "%2$s%n%8$s %7$s%n%6$s, %4$s, %5$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("TL", "%2$s%n%8$s %7$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("TG", "%2$s%n%7$s %8$s%nB.P. %11$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("TK", ""); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("TO", "%2$s%nPO BOX %11$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("TT", "%2$s%n%9$s%n%8$s %7$s %10$s%nP.O. Box %11$s%n%4$s, %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("TN", "%2$s%n%8$s %7$s%n%3$s %4$s %5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("TR", "%2$s%n%6$s Mh.%n%7$s %8$s%n%9$s%nPK %11$s%n%3$s %4$s/%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("TM", Address.FORMAT9); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("TC", Address.FORMAT1); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("TV", Address.FORMAT24); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("UG", Address.FORMAT7); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("UA", "%2$s%n%7$s, %8$s, %10$s%n%4$s, %6$s%n%5$s%n%3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("AE", "%2$s%nB.P. %11$s%n%4$s%n%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("GB", "%2$s%n%12$s%n%16$s%n%4$s%n%3$s%n%15$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("US", Address.FORMAT5); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("UM", ""); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("UY", Address.FORMAT11); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("UZ", "%2$s%n%7$s %8$s, %10$s%na/ya %11$s%n%4$s%n%1$s%n%3$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("VU", Address.FORMAT7); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("VE", "%2$s%n%6$s%n%7$s%n%9$s%n%10$s%n%4$s %3$s, %5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("VN", "%2$s%nP.O Box %11$s%n%10$s%nNo %8$s, %7$s%n%6$s, %4$s%n%5$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("VG", Address.FORMAT1); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("VI", Address.FORMAT5); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("WF", Address.FORMAT2); //$NON-NLS-1$
    Address.ADDRESS_FORMATS.put("EH", ""); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("YE", "%2$s%nB.P. %11$s%n%8$s %7$s%n%4$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("ZM", "%2$s%nP.O. Box %11$s%n%8$s %7$s%n%6$s%n%4$s %3$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
    Address.ADDRESS_FORMATS.put("ZW", "%2$s%nP.O. Box %11$s%n%8$s %7$s%n%4$s%n%5$s%n%1$s%n"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Constructor.
   *
   * @param country Country
   * @param postalCode Postal code
   * @param city City
   * @param province Province
   * @param district District
   * @param street Street
   * @param buildingNr Bulding number
   * @param buildingName Building name
   * @param subBuilding Sub building
   * @param poBoxNumber Post office box number
   * @param department Department
   * @param neighbourhood Neighbourhood
   * @param block Block
   * @param bFPONumber British Forces Post Office Number
   * @param lines Lines 1-5
   * @throws NullPointerException When country or some other required field is null.
   */
  @SuppressWarnings({PMD_N_PATH_COMPLEXITY})
  protected Address(final Country country, final @Nullable PostalCode postalCode, final @Nullable City city, final @Nullable Province province, final @Nullable District district, final @Nullable Street street, final @Nullable BuildingNr buildingNr, final @Nullable BuildingName buildingName, final @Nullable SubBuilding subBuilding, final @Nullable PoBoxNumber poBoxNumber, final @Nullable Department department, final @Nullable Neighbourhood neighbourhood, final @Nullable Block block, final @Nullable BFPONumber bFPONumber, final @Nullable Lines lines)
   {
    super();
    Objects.requireNonNull(country, "country"); //$NON-NLS-1$
    final String format = Address.ADDRESS_FORMATS.get(country.stringValue());
    Objects.requireNonNull(format, "format: " + country.stringValue()); //$NON-NLS-1$
    final String formatWithoutOptionals = Address.NOOPTIONALS_REGEXP.matcher(format).replaceAll(""); //$NON-NLS-1$
    if (formatWithoutOptionals.contains("%3$")) //$NON-NLS-1$
     {
      Objects.requireNonNull(postalCode, "postalCode"); //$NON-NLS-1$
     }
    if (formatWithoutOptionals.contains("%4$")) //$NON-NLS-1$
     {
      Objects.requireNonNull(city, "City"); //$NON-NLS-1$
     }
    if (formatWithoutOptionals.contains("%5$")) //$NON-NLS-1$
     {
      Objects.requireNonNull(province, "Province"); //$NON-NLS-1$
     }
    if (formatWithoutOptionals.contains("%6$")) //$NON-NLS-1$
     {
      Objects.requireNonNull(district, "District"); //$NON-NLS-1$
     }
    if (formatWithoutOptionals.contains("%7$")) //$NON-NLS-1$
     {
      Objects.requireNonNull(street, "Street"); //$NON-NLS-1$
     }
    if (formatWithoutOptionals.contains("%8$")) //$NON-NLS-1$
     {
      Objects.requireNonNull(buildingNr, "BuildingNr"); //$NON-NLS-1$
     }
    if (formatWithoutOptionals.contains("%9$")) //$NON-NLS-1$
     {
      Objects.requireNonNull(buildingName, "buildingName"); //$NON-NLS-1$
     }
    if (formatWithoutOptionals.contains("%10$")) //$NON-NLS-1$
     {
      Objects.requireNonNull(subBuilding, "subBuilding"); //$NON-NLS-1$
     }
    if (formatWithoutOptionals.contains("%11$")) //$NON-NLS-1$
     {
      Objects.requireNonNull(poBoxNumber, "poBoxNumber"); //$NON-NLS-1$
     }
    if (formatWithoutOptionals.contains("%12$")) //$NON-NLS-1$
     {
      Objects.requireNonNull(department, "department"); //$NON-NLS-1$
     }
    if (formatWithoutOptionals.contains("%13$")) //$NON-NLS-1$
     {
      Objects.requireNonNull(neighbourhood, "neighbourhood"); //$NON-NLS-1$
     }
    if (formatWithoutOptionals.contains("%14$")) //$NON-NLS-1$
     {
      Objects.requireNonNull(block, "block"); //$NON-NLS-1$
     }
    if (formatWithoutOptionals.contains("%15$")) //$NON-NLS-1$
     {
      Objects.requireNonNull(bFPONumber, "bFPONumber"); //$NON-NLS-1$
     }
    if (formatWithoutOptionals.contains("%16$")) //$NON-NLS-1$
     {
      Objects.requireNonNull(lines, "lines"); //$NON-NLS-1$
     }
    this.country = country;
    this.postalCode = postalCode;
    this.city = city;
    this.province = province;
    this.district = district;
    this.street = street;
    this.buildingNr = buildingNr;
    this.buildingName = buildingName;
    this.subBuilding = subBuilding;
    this.poBoxNumber = poBoxNumber;
    this.department = department;
    this.neighbourhood = neighbourhood;
    this.block = block;
    this.bFPONumber = bFPONumber;
    this.lines = lines;
   }


  /**
   * Address factory.
   *
   * @param country Country
   * @param postalCode Postal code
   * @param city City
   * @param province Province
   * @param district District
   * @param street Street
   * @param buildingNr Bulding number
   * @param buildingName Building name
   * @param subBuilding Sub building
   * @param poBoxNumber Post office box number
   * @param department Department
   * @param neighbourhood Neighbourhood
   * @param block Block
   * @param bFPONumber British Forces Post Office Number
   * @param lines Lines 1-5
   * @return Address object
   * @throws NullPointerException When country or some other required field is null.
   */
  public static Address of(final Country country, final @Nullable PostalCode postalCode, final @Nullable City city, final @Nullable Province province, final @Nullable District district, final @Nullable Street street, final @Nullable BuildingNr buildingNr, final @Nullable BuildingName buildingName, final @Nullable SubBuilding subBuilding, final @Nullable PoBoxNumber poBoxNumber, final @Nullable Department department, final @Nullable Neighbourhood neighbourhood, final @Nullable Block block, final @Nullable BFPONumber bFPONumber, final @Nullable Lines lines)
   {
    /*
    final NTuple15<Country, PostalCode, City, Province, District, Street, BuildingNr, BuildingName, SubBuilding, PoBoxNumber, Department, Neighbourhood, Block, BFPONumber, Lines> tuple = NTuple15.of(country, postalCode, city, province, district, street, buildingNr, buildingName, subBuilding, poBoxNumber, department, neighbourhood, block, bFPONumber, lines);
    synchronized (Address.class)
     {
      Address obj = Address.CACHE.get(tuple);
      if (obj != null)
       {
        return obj;
       }
      obj = new Address(country, postalCode, city, province, district, street, buildingNr, buildingName, subBuilding, poBoxNumber, department, neighbourhood, block, bFPONumber, lines);
      Address.CACHE.put(tuple, obj);
      return obj;
     }
    */
    return new Address(country, postalCode, city, province, district, street, buildingNr, buildingName, subBuilding, poBoxNumber, department, neighbourhood, block, bFPONumber, lines);
   }


  /**
   * Address factory.
   *
   * @param value country,postalcode,city,province,district,street,buildingnr,buildingname,subbuilding,poboxnumber,department,neighbourhood,block,bfponumber,lines
   * @return Address object
   * @throws NullPointerException When value, country or some other required field is null.
   */
  @SuppressFBWarnings("CLI_CONSTANT_LIST_INDEX")
  @SuppressWarnings({PMD_N_PATH_COMPLEXITY, "PMD.AvoidLiteralsInIfCondition"})
  public static Address of(final String value)
   {
    Objects.requireNonNull(value, "value"); //$NON-NLS-1$
    String[] values = value.split(",");
    if ((values.length < 3) || (values.length > 15))
     {
      throw new IllegalArgumentException("value not in expected format: " + values.length);
     }
    if (values.length < 15) // NO PITEST
     {
      values = Arrays.copyOf(values, 15);
      for (int i = 1; i < 15; ++i)
       {
        if (values[i] == null)
         {
          values[i] = "";
         }
       }
     }
    final var country = Country.of(values[0]);
    final PostalCode postalCode = values[1].isEmpty() ? null : PostalCode.of(values[1]);
    final City city = values[2].isEmpty() ? null : City.of(values[2]);
    final Province province = values[3].isEmpty() ? null : Province.of(values[3]);
    final District district = values[4].isEmpty() ? null : District.of(values[4]);
    final Street street = values[5].isEmpty() ? null : Street.of(values[5]);
    final BuildingNr buildingNr = values[6].isEmpty() ? null : BuildingNr.of(values[6]);
    final BuildingName buildingName = values[7].isEmpty() ? null : BuildingName.of(values[7]);
    final SubBuilding subBuilding = values[8].isEmpty() ? null : SubBuilding.of(values[8]);
    final PoBoxNumber poBoxNumber = values[9].isEmpty() ? null : PoBoxNumber.of(values[9]);
    final Department department = values[10].isEmpty() ? null : Department.of(values[10]);
    final Neighbourhood neighbourhood = values[11].isEmpty() ? null : Neighbourhood.of(values[11]);
    final Block block = values[12].isEmpty() ? null : Block.of(values[12]);
    final BFPONumber bFPONumber = values[13].isEmpty() ? null : BFPONumber.of(values[13]);
    final Lines lines = values[14].isEmpty() ? null : Lines.of(values[14]);
    return of(country, postalCode, city, province, district, street, buildingNr, buildingName, subBuilding, poBoxNumber, department, neighbourhood, block, bFPONumber, lines);
   }


  /**
   * Returns the value of this Address as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return getFormattedAddress("");
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
    return Objects.hash(country, postalCode, city, province, district, street, buildingNr, buildingName, subBuilding, poBoxNumber, department, neighbourhood, block, bFPONumber, lines);
   }


  /**
   * Equal fields.
   *
   * @param <T> Field type
   * @param obj1 Field 1 (this)
   * @param obj2 Field 2 (other)
   * @return true: equal; false: not equal
   */
  private static <T> boolean equalField(final @Nullable T obj1, final @Nullable T obj2)
   {
    return (obj1 == null) ? (obj2 == null) : obj1.equals(obj2);
   }


  /**
   * Can equal.
   *
   * @param other Other object
   * @return true if it can be equal; false otherwise
   */
  public boolean canEqual(final Object other)
   {
    return (other instanceof Address);
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @SuppressWarnings({"PMD.AvoidDeeplyNestedIfStmts"})
  @Override
  public boolean equals(final @Nullable Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    // if ((obj == null) || (this.getClass() != obj.getClass()))
    if (!(obj instanceof final Address other))
     {
      return false;
     }
    boolean result = other.canEqual(this);
    if (result)
     {
      result = country.equals(other.country);
      if (result)
       {
        result = equalField(postalCode, other.postalCode);
        if (result)
         {
          result = equalField(city, other.city);
          if (result)
           {
            result = equalField(province, other.province);
            if (result)
             {
              result = equalField(district, other.district);
              if (result)
               {
                result = equalField(street, other.street);
                if (result)
                 {
                  result = equalField(buildingNr, other.buildingNr);
                  if (result)
                   {
                    result = equalField(buildingName, other.buildingName);
                    if (result)
                     {
                      result = equalField(subBuilding, other.subBuilding);
                      if (result)
                       {
                        result = equalField(poBoxNumber, other.poBoxNumber);
                        if (result)
                         {
                          result = equalField(department, other.department);
                          if (result)
                           {
                            result = equalField(neighbourhood, other.neighbourhood);
                            if (result)
                             {
                              result = equalField(block, other.block);
                              if (result)
                               {
                                result = equalField(bFPONumber, other.bFPONumber);
                                if (result)
                                 {
                                  result = equalField(lines, other.lines);
                                 }
                               }
                             }
                           }
                         }
                       }
                     }
                   }
                 }
               }
             }
           }
         }
       }
     }
    return result;
   }


  /**
   * Returns the string representation of this Address.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Address[country=DE, postalCode=28000, city=Bremen, province=, district=, street=Hemelinger Heerstr., buildingNr=4711, buildingName=Rathaus, subBuiding=Floor 13, Apart. 0815, poBoxNumber=4711, department=Research, neighbourhood=, block=A, bFPONumber=2, lines=]"
   *
   * @return String representation of this Address
   * @see java.lang.Object#toString()
   */
  @SuppressWarnings({PMD_N_PATH_COMPLEXITY})
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(182);
    builder.append("Address[country=").append(country.stringValue()); //$NON-NLS-1$
    if (postalCode != null)
     {
      builder.append(", postalCode=").append(postalCode.stringValue()); //$NON-NLS-1$
     }
    if (city != null)
     {
      builder.append(", city=").append(city.stringValue()); //$NON-NLS-1$
     }
    if (province != null)
     {
      builder.append(", province=").append(province.stringValue()); //$NON-NLS-1$
     }
    if (district != null)
     {
      builder.append(", district=").append(district.stringValue()); //$NON-NLS-1$
     }
    if (street != null)
     {
      builder.append(", street=").append(street.stringValue()); //$NON-NLS-1$
     }
    if (buildingNr != null)
     {
      builder.append(", buildingNr=").append(buildingNr.stringValue()); //$NON-NLS-1$
     }
    if (buildingName != null)
     {
      builder.append(", buildingName=").append(buildingName.stringValue()); //$NON-NLS-1$
     }
    if (subBuilding != null)
     {
      builder.append(", subBuilding=").append(subBuilding.stringValue()); //$NON-NLS-1$
     }
    if (poBoxNumber != null)
     {
      builder.append(", poBoxNumber=").append(poBoxNumber.longValue()); //$NON-NLS-1$
     }
    if (department != null)
     {
      builder.append(", department=").append(department.stringValue()); //$NON-NLS-1$
     }
    if (neighbourhood != null)
     {
      builder.append(", neighbourhood=").append(neighbourhood.stringValue()); //$NON-NLS-1$
     }
    if (block != null)
     {
      builder.append(", block=").append(block.stringValue()); //$NON-NLS-1$
     }
    if (bFPONumber != null)
     {
      builder.append(", bFPONumber=").append(bFPONumber.intValue()); //$NON-NLS-1$
     }
    if (lines != null)
     {
      builder.append(", lines=").append(lines.stringValue()); //$NON-NLS-1$
     }
    builder.append(']');
    return builder.toString();
   }


  /**
   * Compare fields.
   *
   * @param <T> Field type
   * @param obj1 Field 1 (this)
   * @param obj2 Field 2 (other)
   * @return 0: equal; 1 field 1 greater than field 2; -1 field 1 smaller than field 2
   */
  private static <T extends Comparable<T>> int compareField(final @Nullable T obj1, final @Nullable T obj2)
   {
    return (obj1 == null) ? ((obj2 == null) ? 0 : -1) : ((obj2 == null) ? 1 : obj1.compareTo(obj2));
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Address obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = country.compareTo(obj.country);
    if (result == 0)
     {
      result = compareField(postalCode, obj.postalCode);
      if (result == 0)
       {
        result = compareField(city, obj.city);
        if (result == 0)
         {
          result = compareField(province, obj.province);
          if (result == 0)
           {
            result = compareField(district, obj.district);
            if (result == 0)
             {
              result = compareField(street, obj.street);
              if (result == 0)
               {
                result = compareField(buildingNr, obj.buildingNr);
                if (result == 0)
                 {
                  result = compareField(buildingName, obj.buildingName);
                  if (result == 0)
                   {
                    result = compareField(subBuilding, obj.subBuilding);
                    if (result == 0)
                     {
                      result = compareField(poBoxNumber, obj.poBoxNumber);
                      if (result == 0)
                       {
                        result = compareField(department, obj.department);
                        if (result == 0)
                         {
                          result = compareField(neighbourhood, obj.neighbourhood);
                          if (result == 0)
                           {
                            result = compareField(block, obj.block);
                            if (result == 0)
                             {
                              result = compareField(bFPONumber, obj.bFPONumber);
                              if (result == 0)
                               {
                                result = compareField(lines, obj.lines);
                               }
                             }
                           }
                         }
                       }
                     }
                   }
                 }
               }
             }
           }
         }
       }
     }
    return result;
   }


  /**
   * Process format blocks.
   *
   * @param formatStr Format string
   * @param vars Format variables (16)
   * 01: COUNTRYNAME
   * 02: Company
   * 03: POSTALCODE
   * 04: City
   * 05: Province
   * 06: District
   * 07: Street
   * 08: BuildingNumber
   * 09: BuildingName
   * 10: SubBuilding
   * 11: PoBoxNumber
   * 12: Department
   * 13: Neighbourhood
   * 14: Block
   * 15: BFPONUMBER
   * 16: Line1-5
   * @return Format with removed blocks for non existing parameters
   */
  @SuppressWarnings({"PMD.AvoidLiteralsInIfCondition"})
  private String processBlocks(final String formatStr, final String... vars)
   {
    // assert (formatStr != null) && !formatStr.isBlank();
    // assert vars.length == 16;
    String format = formatStr;
    int pos = 0;
    while (pos < format.length())
     {
      final int posStartBlock = format.indexOf('[', pos);
      if (posStartBlock == -1)
       {
        pos = format.length();
       }
      else
       {
        final int posEndBlock = format.indexOf(']', posStartBlock + 1);
        if (posEndBlock == -1)
         {
          throw new IllegalArgumentException("Block without end found in: " + country.stringValue()); //$NON-NLS-1$
         }
        pos = posEndBlock + 1;
        final var blk = format.substring(posStartBlock + 1, posEndBlock);
        boolean removedBlock = false;
        int fieldPos = 0;
        while (fieldPos < blk.length())
         {
          final int posFieldStart = blk.indexOf('%', fieldPos);
          if (posFieldStart == -1)
           {
            fieldPos = blk.length();
           }
          else if (blk.charAt(posFieldStart + 1) == 'n')
           {
            fieldPos = posFieldStart + 2;
           }
          else
           {
            final int posFieldEnd = blk.indexOf('$', posFieldStart);
            if (posFieldEnd == -1)
             {
              throw new IllegalArgumentException("Unsupported field format code found in: " + country.stringValue()); //$NON-NLS-1$
             }
            final int fieldNr = Integer.parseInt(blk.substring(posFieldStart + 1, posFieldEnd));
            fieldPos = posFieldEnd + 1;
            if ((fieldNr < 1) || (fieldNr > 16))
             {
              throw new IllegalArgumentException("Illegal field number (1-16): " + fieldNr); //$NON-NLS-1$
             }
            if ((vars[fieldNr - 1] == null) || vars[fieldNr - 1].isBlank()) // Remove block if var does not exist
             {
              final String newFormat = format.substring(0, posStartBlock) + (((posEndBlock + 1) > format.length()) ? "" : format.substring(posEndBlock + 1)); //$NON-NLS-1$
              format = newFormat;
              removedBlock = true;
              pos = posStartBlock;
              fieldPos = blk.length();
             }
           }
         }
        if (!removedBlock)
         {
          final String newFormat = format.substring(0, posStartBlock) + blk + (((posEndBlock + 1) > format.length()) ? "" : format.substring(posEndBlock + 1)); //$NON-NLS-1$
          format = newFormat;
          pos -= 2;
         }
       }
     }
    return format;
   }


  /**
   * Get address format depending on country.
   *
   * @param vars 16 Strings
   * @return Java formatter string
   * 01: COUNTRYNAME
   * 02: Company
   * 03: POSTALCODE
   * 04: City
   * 05: Province
   * 06: District
   * 07: Street
   * 08: BuildingNumber
   * 09: BuildingName
   * 10: SubBuilding
   * 11: PoBoxNumber
   * 12: Department
   * 13: Neighbourhood
   * 14: Block
   * 15: BFPONUMBER
   * 16: Line1-5
   */
  private String getAddressFormat(final String... vars)
   {
    // assert vars.length == 16;
    final String format = Address.ADDRESS_FORMATS.get(country.stringValue());
    return processBlocks(format, vars);
   }


  /**
   * Get formatted address string.
   *
   * @param recipientName Company or person name
   * @return Formatted address string
   * @throws NullPointerException If recipientName is null
   */
  @SuppressWarnings({PMD_N_PATH_COMPLEXITY})
  public String getFormattedAddress(final String recipientName)
   {
    Objects.requireNonNull(recipientName, "recipientName"); //$NON-NLS-1$
    final var builder = new StringBuilder();
    try (var formatter = new Formatter(builder, Locale.getDefault()))
     {
      final String tmpPostalCode = postalCode == null ? null : postalCode.stringValue();
      final String tmpCity = city == null ? null : city.stringValue();
      final String tmpProvince = province == null ? null : province.stringValue();
      final String tmpDistrict = district == null ? null : district.stringValue();
      final String tmpStreet = street == null ? null : street.stringValue();
      final String tmpBuildingNr = buildingNr == null ? null : buildingNr.stringValue();
      final String tmpBuildingName = buildingName == null ? null : buildingName.stringValue();
      final String tmpSubBuilding = subBuilding == null ? null : subBuilding.stringValue();
      final String tmpPoBoxNumber = poBoxNumber == null ? null : poBoxNumber.stringValue();
      final String tmpDepartment = department == null ? null : department.stringValue();
      final String tmpNeighbourhood = neighbourhood == null ? null : neighbourhood.stringValue();
      final String tmpBlock = block == null ? null : block.stringValue();
      final String tmpBFPONumber = bFPONumber == null ? null : bFPONumber.stringValue();
      final String tmpLines = lines == null ? null : lines.stringValue();
      final String format = getAddressFormat(country.getEnglishCountryName(), recipientName, tmpPostalCode, tmpCity, tmpProvince, tmpDistrict, tmpStreet, tmpBuildingNr, tmpBuildingName, tmpSubBuilding, tmpPoBoxNumber, tmpDepartment, tmpNeighbourhood, tmpBlock, tmpBFPONumber, tmpLines);
      formatter.format(format, country.getEnglishCountryName(), recipientName, tmpPostalCode, tmpCity, tmpProvince, tmpDistrict, tmpStreet, tmpBuildingNr, tmpBuildingName, tmpSubBuilding, tmpPoBoxNumber, tmpDepartment, tmpNeighbourhood, tmpBlock, tmpBFPONumber, tmpLines);
     }
    return builder.toString();
   }


  /**
   * Get country.
   *
   * @return The country
   */
  public Country getCountry()
   {
    return country;
   }


  /**
   * Get postalCode.
   *
   * @return The postalCode
   */
  public PostalCode getPostalCode()
   {
    return postalCode;
   }


  /**
   * Get city.
   *
   * @return The city
   */
  public City getCity()
   {
    return city;
   }


  /**
   * Get province.
   *
   * @return The province
   */
  public Province getProvince()
   {
    return province;
   }


  /**
   * Get district.
   *
   * @return The district
   */
  public District getDistrict()
   {
    return district;
   }


  /**
   * Get street.
   *
   * @return The street
   */
  public Street getStreet()
   {
    return street;
   }


  /**
   * Get buildingNr.
   *
   * @return The buildingNr
   */
  public BuildingNr getBuildingNr()
   {
    return buildingNr;
   }


  /**
   * Get buildingName.
   *
   * @return The buildingName
   */
  public BuildingName getBuildingName()
   {
    return buildingName;
   }


  /**
   * Get subBuilding.
   *
   * @return The subBuilding
   */
  public SubBuilding getSubBuilding()
   {
    return subBuilding;
   }


  /**
   * Get poBoxNumber.
   *
   * @return The poBoxNumber
   */
  public PoBoxNumber getPoBoxNumber()
   {
    return poBoxNumber;
   }


  /**
   * Get department.
   *
   * @return The department
   */
  public Department getDepartment()
   {
    return department;
   }


  /**
   * Get neighbourhood.
   *
   * @return The neighbourhood
   */
  public Neighbourhood getNeighbourhood()
   {
    return neighbourhood;
   }


  /**
   * Get block.
   *
   * @return The block
   */
  public Block getBlock()
   {
    return block;
   }


  /**
   * Get bFPONumber.
   *
   * @return The bFPONumber
   */
  public BFPONumber getBFPONumber()
   {
    return bFPONumber;
   }


  /**
   * Get lines.
   *
   * @return The lines
   */
  public Lines getLines()
   {
    return lines;
   }

 }
