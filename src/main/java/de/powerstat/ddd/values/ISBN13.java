/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values;


import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;
import de.powerstat.ddd.values.comm.Language;
import de.powerstat.ddd.values.geo.Country;
import de.powerstat.ddd.values.impl.ISBN13Publisher0;
import de.powerstat.ddd.values.impl.ISBN13Publisher1;
import de.powerstat.ddd.values.impl.ISBN13Publisher3;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * ISBN 13.
 *
 * Not DSGVO relevant.
 *
 * Can not be converted to a record because of cleanup during constructor.
 */
@ValueObject
public final class ISBN13 implements Comparable<ISBN13>, IValueObject
 {
  /**
   * ISBN separator regexp.
   */
  private static final Pattern ISBN_SEPARATOR_REGEXP = Pattern.compile("-| ");

  /**
   * ISBN separator.
   */
  private static final String ISBN_SEPARATOR = "-";

  /**
   * Mongolian.
   */
  private static final String MONGOLIAN = "mn";

  /**
   * Suaheli.
   */
  private static final String SUAHELI = "sw";

  /**
   * Albanian.
   */
  private static final String ALBANIAN = "sq";

  /**
   * Malay.
   */
  private static final String MALAY = "ms";

  /**
   * Dutch.
   */
  private static final String DUTCH = "nl";

  /**
   * Chinese.
   */
  private static final String CHINESE = "zh";

  /**
   * Thai.
   */
  private static final String THAI = "th";

  /**
   * Spanish.
   */
  private static final String SPANISH = "es";

  /**
   * Arabic.
   */
  private static final String ARABIC = "ar";

  /**
   * French.
   */
  private static final String FRENCH = "fr";

  /**
   * English.
   */
  private static final String ENGLISH = "en";

  /**
   * Mongolia.
   */
  private static final String MN = "MN";

  /**
   * Albania.
   */
  private static final String AL = "AL";

  /**
   * Bosnia and Herzegovina.
   */
  private static final String BA = "BA";

  /**
   * 979.
   */
  private static final String PREFIX_979 = "979";

  /**
   * 978.
   */
  private static final String PREFIX_978 = "978";

  /**
   * Mauritius.
   */
  private static final String MAURITIUS = "MU";

  /**
   * ISBN13 regexp.
   */
  @SuppressWarnings("java:S5867")
  private static final Pattern ISBN13_REGEXP = Pattern.compile("^97[89][- ]?\\d{1,5}[- ]?\\d{2,5}[- ]?\\d{3,6}[- ]?\\d$"); //$NON-NLS-1$
  // 978 und 979-1 bis 979-9
  // Gruppennummer 1-5 Stellig   Sprache|Land
  // Verlagsnummer 2-5 Stellig
  // Titelnummer   3-6 Stellig  (Zusammen mit Gruppe und Verlag = 9 Stellen)
  // Prüfziffer    1 Stellig

  /**
   * Country map for group 978.
   */
  private static final Map<String, Country> COUNTRY_MAP978 = new ConcurrentHashMap<>();

  /**
   * Country map for group 979.
   */
  private static final Map<String, Country> COUNTRY_MAP979 = new ConcurrentHashMap<>();

  /**
   * Language map for group 978.
   */
  private static final Map<String, Language> LANGUAGE_MAP978 = new ConcurrentHashMap<>();

  /**
   * Language map for group 979.
   */
  private static final Map<String, Language> LANGUAGE_MAP979 = new ConcurrentHashMap<>();

  /**
   * ISBN13.
   */
  private final String isbn13;


  /**
   * Static initialization.
   */
  static
   {
    COUNTRY_MAP978.put("0", Country.of("US"));
    COUNTRY_MAP978.put("1", Country.of("US"));
    COUNTRY_MAP978.put("2", Country.of("FR"));
    COUNTRY_MAP978.put("3", Country.of("DE"));
    COUNTRY_MAP978.put("4", Country.of("JP"));
    COUNTRY_MAP978.put("5", Country.of("RU"));
    COUNTRY_MAP978.put("600", Country.of("IR"));
    COUNTRY_MAP978.put("601", Country.of("KZ"));
    COUNTRY_MAP978.put("602", Country.of("ID"));
    COUNTRY_MAP978.put("603", Country.of("SA"));
    COUNTRY_MAP978.put("604", Country.of("VN"));
    COUNTRY_MAP978.put("605", Country.of("TR"));
    COUNTRY_MAP978.put("606", Country.of("RO"));
    COUNTRY_MAP978.put("607", Country.of("MX"));
    COUNTRY_MAP978.put("608", Country.of("MK"));
    COUNTRY_MAP978.put("609", Country.of("LT"));
    COUNTRY_MAP978.put("611", Country.of("TH"));
    COUNTRY_MAP978.put("612", Country.of("PE"));
    COUNTRY_MAP978.put("613", Country.of(MAURITIUS));
    COUNTRY_MAP978.put("614", Country.of("LB"));
    COUNTRY_MAP978.put("615", Country.of("HU"));
    COUNTRY_MAP978.put("616", Country.of("TH"));
    COUNTRY_MAP978.put("617", Country.of("UA"));
    COUNTRY_MAP978.put("618", Country.of("GR"));
    COUNTRY_MAP978.put("619", Country.of("BG"));
    COUNTRY_MAP978.put("620", Country.of(MAURITIUS));
    COUNTRY_MAP978.put("621", Country.of("PH"));
    COUNTRY_MAP978.put("7", Country.of("CN"));
    COUNTRY_MAP978.put("80", Country.of("CZ"));
    COUNTRY_MAP978.put("81", Country.of("IN"));
    COUNTRY_MAP978.put("82", Country.of("NO"));
    COUNTRY_MAP978.put("83", Country.of("PL"));
    COUNTRY_MAP978.put("84", Country.of("ES"));
    COUNTRY_MAP978.put("85", Country.of("BR"));
    COUNTRY_MAP978.put("86", Country.of("HR"));
    COUNTRY_MAP978.put("87", Country.of("DK"));
    COUNTRY_MAP978.put("88", Country.of("IT"));
    COUNTRY_MAP978.put("89", Country.of("KR"));
    COUNTRY_MAP978.put("90", Country.of("NL"));
    COUNTRY_MAP978.put("91", Country.of("SE"));
    // COUNTRY_MAP978.put("92", Country.of("")); // Internationale Verleger (UNO, UNESCO, EU usw.)
    COUNTRY_MAP978.put("93", Country.of("IN"));
    COUNTRY_MAP978.put("94", Country.of("NL"));
    COUNTRY_MAP978.put("950", Country.of("AR"));
    COUNTRY_MAP978.put("951", Country.of("FI"));
    COUNTRY_MAP978.put("952", Country.of("FI"));
    COUNTRY_MAP978.put("953", Country.of("HR"));
    COUNTRY_MAP978.put("954", Country.of("BG"));
    COUNTRY_MAP978.put("955", Country.of("LK"));
    COUNTRY_MAP978.put("956", Country.of("CL"));
    COUNTRY_MAP978.put("957", Country.of("TW"));
    COUNTRY_MAP978.put("958", Country.of("CO"));
    COUNTRY_MAP978.put("959", Country.of("CU"));
    COUNTRY_MAP978.put("960", Country.of("GR"));
    COUNTRY_MAP978.put("961", Country.of("SI"));
    COUNTRY_MAP978.put("962", Country.of("HK"));
    COUNTRY_MAP978.put("963", Country.of("HU"));
    COUNTRY_MAP978.put("964", Country.of("IR"));
    COUNTRY_MAP978.put("965", Country.of("IL"));
    COUNTRY_MAP978.put("966", Country.of("UA"));
    COUNTRY_MAP978.put("967", Country.of("MY"));
    COUNTRY_MAP978.put("968", Country.of("MX"));
    COUNTRY_MAP978.put("969", Country.of("PK"));
    COUNTRY_MAP978.put("970", Country.of("MX"));
    COUNTRY_MAP978.put("971", Country.of("PH"));
    COUNTRY_MAP978.put("972", Country.of("PT"));
    COUNTRY_MAP978.put("973", Country.of("RO"));
    COUNTRY_MAP978.put("974", Country.of("TH"));
    COUNTRY_MAP978.put("975", Country.of("TR"));
    COUNTRY_MAP978.put("976", Country.of("BQ"));
    COUNTRY_MAP978.put("977", Country.of("EG"));
    COUNTRY_MAP978.put(PREFIX_978, Country.of("NG"));
    COUNTRY_MAP978.put(PREFIX_979, Country.of("ID"));
    COUNTRY_MAP978.put("980", Country.of("VE"));
    COUNTRY_MAP978.put("981", Country.of("SG"));
    COUNTRY_MAP978.put("982", Country.of("UM")); // Südpazifik ?
    COUNTRY_MAP978.put("983", Country.of("MY"));
    COUNTRY_MAP978.put("984", Country.of("BD"));
    COUNTRY_MAP978.put("985", Country.of("BY"));
    COUNTRY_MAP978.put("986", Country.of("TW"));
    COUNTRY_MAP978.put("987", Country.of("AR"));
    COUNTRY_MAP978.put("988", Country.of("HK"));
    COUNTRY_MAP978.put("989", Country.of("PT"));
    COUNTRY_MAP978.put("9926", Country.of(BA));
    COUNTRY_MAP978.put("9927", Country.of("QA"));
    COUNTRY_MAP978.put("9928", Country.of(AL));
    COUNTRY_MAP978.put("9929", Country.of("GT"));
    COUNTRY_MAP978.put("9930", Country.of("CR"));
    COUNTRY_MAP978.put("9931", Country.of("DZ"));
    COUNTRY_MAP978.put("9932", Country.of("LA"));
    COUNTRY_MAP978.put("9933", Country.of("SY"));
    COUNTRY_MAP978.put("9934", Country.of("LV"));
    COUNTRY_MAP978.put("9935", Country.of("IS"));
    COUNTRY_MAP978.put("9936", Country.of("AF"));
    COUNTRY_MAP978.put("9937", Country.of("NP"));
    COUNTRY_MAP978.put("9938", Country.of("TN"));
    COUNTRY_MAP978.put("9939", Country.of("AM"));
    COUNTRY_MAP978.put("9940", Country.of("ME"));
    COUNTRY_MAP978.put("9941", Country.of("GE"));
    COUNTRY_MAP978.put("9942", Country.of("EC"));
    COUNTRY_MAP978.put("9943", Country.of("UZ"));
    COUNTRY_MAP978.put("9944", Country.of("TR"));
    COUNTRY_MAP978.put("9945", Country.of("DO"));
    COUNTRY_MAP978.put("9946", Country.of("KP"));
    COUNTRY_MAP978.put("9947", Country.of("DZ"));
    COUNTRY_MAP978.put("9948", Country.of("AE"));
    COUNTRY_MAP978.put("9949", Country.of("EE"));
    COUNTRY_MAP978.put("9950", Country.of("PS"));
    // COUNTRY_MAP978.put("9951", Country.of("XK")); // Kosovo
    COUNTRY_MAP978.put("9952", Country.of("AZ"));
    COUNTRY_MAP978.put("9953", Country.of("LB"));
    COUNTRY_MAP978.put("9954", Country.of("MA"));
    COUNTRY_MAP978.put("9955", Country.of("LT"));
    COUNTRY_MAP978.put("9956", Country.of("CM"));
    COUNTRY_MAP978.put("9957", Country.of("JO"));
    COUNTRY_MAP978.put("9958", Country.of(BA));
    COUNTRY_MAP978.put("9959", Country.of("LY"));
    COUNTRY_MAP978.put("9960", Country.of("SA"));
    COUNTRY_MAP978.put("9961", Country.of("DZ"));
    COUNTRY_MAP978.put("9962", Country.of("PA"));
    COUNTRY_MAP978.put("9963", Country.of("CY"));
    COUNTRY_MAP978.put("9964", Country.of("GH"));
    COUNTRY_MAP978.put("9965", Country.of("KZ"));
    COUNTRY_MAP978.put("9966", Country.of("KE"));
    COUNTRY_MAP978.put("9967", Country.of("KG"));
    COUNTRY_MAP978.put("9968", Country.of("CR"));
    // COUNTRY_MAP978.put("9969", Country.of("")); // Nicht vergeben?
    COUNTRY_MAP978.put("9970", Country.of("UG"));
    COUNTRY_MAP978.put("9971", Country.of("SG"));
    COUNTRY_MAP978.put("9972", Country.of("PE"));
    COUNTRY_MAP978.put("9973", Country.of("TN"));
    COUNTRY_MAP978.put("9974", Country.of("UY"));
    COUNTRY_MAP978.put("9975", Country.of("MD"));
    COUNTRY_MAP978.put("9976", Country.of("TZ"));
    COUNTRY_MAP978.put("9977", Country.of("CR"));
    COUNTRY_MAP978.put("9978", Country.of("EC"));
    COUNTRY_MAP978.put("9979", Country.of("IS"));
    COUNTRY_MAP978.put("9980", Country.of("PG"));
    COUNTRY_MAP978.put("9981", Country.of("MA"));
    COUNTRY_MAP978.put("9982", Country.of("ZM"));
    COUNTRY_MAP978.put("9983", Country.of("GM"));
    COUNTRY_MAP978.put("9984", Country.of("LV"));
    COUNTRY_MAP978.put("9985", Country.of("EE"));
    COUNTRY_MAP978.put("9986", Country.of("LT"));
    COUNTRY_MAP978.put("9987", Country.of("TZ"));
    COUNTRY_MAP978.put("9988", Country.of("GH"));
    COUNTRY_MAP978.put("9989", Country.of("MK"));
    COUNTRY_MAP978.put("99901", Country.of("BH"));
    COUNTRY_MAP978.put("99902", Country.of("GA"));
    COUNTRY_MAP978.put("99903", Country.of(MAURITIUS));
    COUNTRY_MAP978.put("99904", Country.of("CW"));
    COUNTRY_MAP978.put("99905", Country.of("BO"));
    COUNTRY_MAP978.put("99906", Country.of("KW"));
    // COUNTRY_MAP978.put("99907", Country.of("")); // Nicht vergeben?
    COUNTRY_MAP978.put("99908", Country.of("MW"));
    COUNTRY_MAP978.put("99909", Country.of("MT"));
    COUNTRY_MAP978.put("99910", Country.of("SL"));
    COUNTRY_MAP978.put("99911", Country.of("LS"));
    COUNTRY_MAP978.put("99912", Country.of("BW"));
    COUNTRY_MAP978.put("99913", Country.of("AD"));
    COUNTRY_MAP978.put("99914", Country.of("SR"));
    COUNTRY_MAP978.put("99915", Country.of("MV"));
    COUNTRY_MAP978.put("99916", Country.of("NA"));
    COUNTRY_MAP978.put("99917", Country.of("BN"));
    COUNTRY_MAP978.put("99918", Country.of("FO"));
    COUNTRY_MAP978.put("99919", Country.of("BJ"));
    COUNTRY_MAP978.put("99920", Country.of("AD"));
    COUNTRY_MAP978.put("99921", Country.of("QA"));
    COUNTRY_MAP978.put("99922", Country.of("GT"));
    COUNTRY_MAP978.put("99923", Country.of("SV"));
    COUNTRY_MAP978.put("99924", Country.of("NI"));
    COUNTRY_MAP978.put("99925", Country.of("PY"));
    COUNTRY_MAP978.put("99926", Country.of("HN"));
    COUNTRY_MAP978.put("99927", Country.of(AL));
    COUNTRY_MAP978.put("99928", Country.of("GE"));
    COUNTRY_MAP978.put("99929", Country.of(MN));
    COUNTRY_MAP978.put("99930", Country.of("AM"));
    COUNTRY_MAP978.put("99931", Country.of("SC"));
    COUNTRY_MAP978.put("99932", Country.of("MT"));
    COUNTRY_MAP978.put("99933", Country.of("NP"));
    COUNTRY_MAP978.put("99934", Country.of("DO"));
    COUNTRY_MAP978.put("99935", Country.of("HT"));
    COUNTRY_MAP978.put("99936", Country.of("BT"));
    COUNTRY_MAP978.put("99937", Country.of("MO"));
    COUNTRY_MAP978.put("99938", Country.of(BA));
    COUNTRY_MAP978.put("99939", Country.of("GT"));
    COUNTRY_MAP978.put("99940", Country.of("GE"));
    COUNTRY_MAP978.put("99941", Country.of("AM"));
    COUNTRY_MAP978.put("99942", Country.of("SD"));
    COUNTRY_MAP978.put("99943", Country.of(AL));
    COUNTRY_MAP978.put("99944", Country.of("ET"));
    COUNTRY_MAP978.put("99945", Country.of("NA"));
    COUNTRY_MAP978.put("99946", Country.of("NP"));
    COUNTRY_MAP978.put("99947", Country.of("TJ"));
    COUNTRY_MAP978.put("99948", Country.of("ER"));
    COUNTRY_MAP978.put("99949", Country.of(MAURITIUS));
    COUNTRY_MAP978.put("99950", Country.of("KH"));
    COUNTRY_MAP978.put("99951", Country.of("CD"));
    COUNTRY_MAP978.put("99952", Country.of("ML"));
    COUNTRY_MAP978.put("99953", Country.of("PY"));
    COUNTRY_MAP978.put("99954", Country.of("BO"));
    COUNTRY_MAP978.put("99955", Country.of(BA));
    COUNTRY_MAP978.put("99956", Country.of(AL));
    COUNTRY_MAP978.put("99957", Country.of("MT"));
    COUNTRY_MAP978.put("99958", Country.of("BH"));
    COUNTRY_MAP978.put("99959", Country.of("LU"));
    COUNTRY_MAP978.put("99960", Country.of("MW"));
    COUNTRY_MAP978.put("99961", Country.of("SV"));
    COUNTRY_MAP978.put("99962", Country.of(MN));
    COUNTRY_MAP978.put("99963", Country.of("KH"));
    COUNTRY_MAP978.put("99964", Country.of("NI"));
    COUNTRY_MAP978.put("99965", Country.of("MO"));
    COUNTRY_MAP978.put("99966", Country.of("KW"));
    COUNTRY_MAP978.put("99967", Country.of("PY"));
    COUNTRY_MAP978.put("99968", Country.of("BW"));
    COUNTRY_MAP978.put("99969", Country.of("OM"));
    COUNTRY_MAP978.put("99970", Country.of("HT"));
    COUNTRY_MAP978.put("99971", Country.of("MM"));
    COUNTRY_MAP978.put("99972", Country.of("FO"));
    COUNTRY_MAP978.put("99973", Country.of(MN));
    COUNTRY_MAP978.put("99974", Country.of("BO"));
    COUNTRY_MAP978.put("99975", Country.of("TJ"));
    COUNTRY_MAP978.put("99976", Country.of(BA));
    COUNTRY_MAP978.put("99977", Country.of("RW"));
    COUNTRY_MAP978.put("99978", Country.of(MN));
    COUNTRY_MAP978.put("99979", Country.of("HN"));

    COUNTRY_MAP979.put("8", Country.of("US"));
    COUNTRY_MAP979.put("9", Country.of("DE"));
    COUNTRY_MAP979.put("10", Country.of("FR"));
    COUNTRY_MAP979.put("11", Country.of("KR"));
    COUNTRY_MAP979.put("12", Country.of("IT"));

    LANGUAGE_MAP978.put("0", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("1", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("2", Language.of(FRENCH));
    LANGUAGE_MAP978.put("3", Language.of("de"));
    LANGUAGE_MAP978.put("4", Language.of("ja"));
    LANGUAGE_MAP978.put("5", Language.of("ru"));
    LANGUAGE_MAP978.put("600", Language.of("fa"));
    LANGUAGE_MAP978.put("601", Language.of("kk"));
    LANGUAGE_MAP978.put("602", Language.of("id"));
    LANGUAGE_MAP978.put("603", Language.of(ARABIC));
    LANGUAGE_MAP978.put("604", Language.of("vi"));
    LANGUAGE_MAP978.put("605", Language.of("tr"));
    LANGUAGE_MAP978.put("606", Language.of("ro"));
    LANGUAGE_MAP978.put("607", Language.of(SPANISH));
    LANGUAGE_MAP978.put("608", Language.of("mk"));
    LANGUAGE_MAP978.put("609", Language.of("lt"));
    // LANGUAGE_MAP978.put("610", Language.of("")); // Nicht vergeben?
    LANGUAGE_MAP978.put("611", Language.of(THAI));
    LANGUAGE_MAP978.put("612", Language.of(SPANISH));
    LANGUAGE_MAP978.put("613", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("614", Language.of(ARABIC));
    LANGUAGE_MAP978.put("615", Language.of("hu"));
    LANGUAGE_MAP978.put("616", Language.of(THAI));
    LANGUAGE_MAP978.put("617", Language.of("uk"));
    LANGUAGE_MAP978.put("618", Language.of("el"));
    LANGUAGE_MAP978.put("619", Language.of("bg"));
    LANGUAGE_MAP978.put("620", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("621", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("7", Language.of(CHINESE));
    LANGUAGE_MAP978.put("80", Language.of("cs"));
    LANGUAGE_MAP978.put("81", Language.of("hi"));
    LANGUAGE_MAP978.put("82", Language.of("no"));
    LANGUAGE_MAP978.put("83", Language.of("pl"));
    LANGUAGE_MAP978.put("84", Language.of(SPANISH));
    LANGUAGE_MAP978.put("85", Language.of("pt"));
    LANGUAGE_MAP978.put("86", Language.of("sl"));
    LANGUAGE_MAP978.put("87", Language.of("da"));
    LANGUAGE_MAP978.put("88", Language.of("it"));
    LANGUAGE_MAP978.put("89", Language.of("ko"));
    LANGUAGE_MAP978.put("90", Language.of(DUTCH));
    LANGUAGE_MAP978.put("91", Language.of("sv"));
    // LANGUAGE_MAP978.put("92", Language.of("")); // Internationale Verleger (UNO, UNESCO, EU usw.)
    LANGUAGE_MAP978.put("93", Language.of("hi"));
    LANGUAGE_MAP978.put("94", Language.of(DUTCH));
    LANGUAGE_MAP978.put("950", Language.of(SPANISH));
    LANGUAGE_MAP978.put("951", Language.of("fi"));
    LANGUAGE_MAP978.put("952", Language.of("fi"));
    LANGUAGE_MAP978.put("953", Language.of("hr"));
    LANGUAGE_MAP978.put("954", Language.of("bg"));
    LANGUAGE_MAP978.put("955", Language.of("si"));
    LANGUAGE_MAP978.put("956", Language.of(SPANISH));
    LANGUAGE_MAP978.put("957", Language.of(CHINESE));
    LANGUAGE_MAP978.put("958", Language.of(SPANISH));
    LANGUAGE_MAP978.put("959", Language.of(SPANISH));
    LANGUAGE_MAP978.put("960", Language.of("el"));
    LANGUAGE_MAP978.put("961", Language.of("sl"));
    LANGUAGE_MAP978.put("962", Language.of(CHINESE));
    LANGUAGE_MAP978.put("963", Language.of(THAI));
    LANGUAGE_MAP978.put("964", Language.of("fa"));
    LANGUAGE_MAP978.put("965", Language.of("he"));
    LANGUAGE_MAP978.put("966", Language.of("uk"));
    LANGUAGE_MAP978.put("967", Language.of(MALAY));
    LANGUAGE_MAP978.put("968", Language.of(SPANISH));
    LANGUAGE_MAP978.put("969", Language.of("ur"));
    LANGUAGE_MAP978.put("970", Language.of(SPANISH));
    LANGUAGE_MAP978.put("971", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("972", Language.of("pt"));
    LANGUAGE_MAP978.put("973", Language.of("ro"));
    LANGUAGE_MAP978.put("974", Language.of(THAI));
    LANGUAGE_MAP978.put("975", Language.of("tr"));
    LANGUAGE_MAP978.put("976", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("977", Language.of(ARABIC));
    LANGUAGE_MAP978.put(PREFIX_978, Language.of(ENGLISH));
    LANGUAGE_MAP978.put(PREFIX_979, Language.of("id"));
    LANGUAGE_MAP978.put("980", Language.of(SPANISH));
    LANGUAGE_MAP978.put("981", Language.of(MALAY));
    LANGUAGE_MAP978.put("982", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("983", Language.of(MALAY));
    LANGUAGE_MAP978.put("984", Language.of("bn"));
    LANGUAGE_MAP978.put("985", Language.of("be"));
    LANGUAGE_MAP978.put("986", Language.of(CHINESE));
    LANGUAGE_MAP978.put("987", Language.of(SPANISH));
    LANGUAGE_MAP978.put("988", Language.of(CHINESE));
    LANGUAGE_MAP978.put("989", Language.of("pt"));
    LANGUAGE_MAP978.put("9926", Language.of("bs"));
    LANGUAGE_MAP978.put("9927", Language.of(ARABIC));
    LANGUAGE_MAP978.put("9928", Language.of(ALBANIAN));
    LANGUAGE_MAP978.put("9929", Language.of(SPANISH));
    LANGUAGE_MAP978.put("9930", Language.of(SPANISH));
    LANGUAGE_MAP978.put("9931", Language.of(ARABIC));
    LANGUAGE_MAP978.put("9932", Language.of("lo"));
    LANGUAGE_MAP978.put("9933", Language.of(ARABIC));
    LANGUAGE_MAP978.put("9934", Language.of("lv"));
    LANGUAGE_MAP978.put("9935", Language.of("is"));
    LANGUAGE_MAP978.put("9936", Language.of("ps"));
    LANGUAGE_MAP978.put("9937", Language.of("ne"));
    LANGUAGE_MAP978.put("9938", Language.of(ARABIC));
    LANGUAGE_MAP978.put("9939", Language.of("hy"));
    // LANGUAGE_MAP978.put("9940", Language.of("")); // Montenegro
    LANGUAGE_MAP978.put("9941", Language.of("ka"));
    LANGUAGE_MAP978.put("9942", Language.of(SPANISH));
    LANGUAGE_MAP978.put("9943", Language.of("uz"));
    LANGUAGE_MAP978.put("9944", Language.of("tr"));
    LANGUAGE_MAP978.put("9945", Language.of(SPANISH));
    LANGUAGE_MAP978.put("9946", Language.of("ko"));
    LANGUAGE_MAP978.put("9947", Language.of(ARABIC));
    LANGUAGE_MAP978.put("9948", Language.of(ARABIC));
    LANGUAGE_MAP978.put("9949", Language.of("et"));
    LANGUAGE_MAP978.put("9950", Language.of(ARABIC));
    LANGUAGE_MAP978.put("9951", Language.of(ALBANIAN));
    LANGUAGE_MAP978.put("9952", Language.of("az"));
    LANGUAGE_MAP978.put("9953", Language.of(ARABIC));
    LANGUAGE_MAP978.put("9954", Language.of(ARABIC));
    LANGUAGE_MAP978.put("9955", Language.of("lt"));
    LANGUAGE_MAP978.put("9956", Language.of(FRENCH));
    LANGUAGE_MAP978.put("9957", Language.of(ARABIC));
    LANGUAGE_MAP978.put("9958", Language.of("bs"));
    LANGUAGE_MAP978.put("9959", Language.of(ARABIC));
    LANGUAGE_MAP978.put("9960", Language.of(ARABIC));
    LANGUAGE_MAP978.put("9961", Language.of(ARABIC));
    LANGUAGE_MAP978.put("9962", Language.of(SPANISH));
    LANGUAGE_MAP978.put("9963", Language.of("el"));
    LANGUAGE_MAP978.put("9964", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("9965", Language.of("kk"));
    LANGUAGE_MAP978.put("9966", Language.of(SUAHELI));
    LANGUAGE_MAP978.put("9967", Language.of("ky"));
    LANGUAGE_MAP978.put("9968", Language.of(SPANISH));
    // LANGUAGE_MAP978.put("9969", Language.of("")); // Nicht vergeben?
    LANGUAGE_MAP978.put("9970", Language.of(SUAHELI));
    LANGUAGE_MAP978.put("9971", Language.of(MALAY));
    LANGUAGE_MAP978.put("9972", Language.of(SPANISH));
    LANGUAGE_MAP978.put("9973", Language.of(ARABIC));
    LANGUAGE_MAP978.put("9974", Language.of(SPANISH));
    LANGUAGE_MAP978.put("9975", Language.of("ro"));
    LANGUAGE_MAP978.put("9976", Language.of(SUAHELI));
    LANGUAGE_MAP978.put("9977", Language.of(SPANISH));
    LANGUAGE_MAP978.put("9978", Language.of(SPANISH));
    LANGUAGE_MAP978.put("9979", Language.of("is"));
    LANGUAGE_MAP978.put("9980", Language.of("ho"));
    LANGUAGE_MAP978.put("9981", Language.of(ARABIC));
    LANGUAGE_MAP978.put("9982", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("9983", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("9984", Language.of("lv"));
    LANGUAGE_MAP978.put("9985", Language.of("et"));
    LANGUAGE_MAP978.put("9986", Language.of("lt"));
    LANGUAGE_MAP978.put("9987", Language.of(SUAHELI));
    LANGUAGE_MAP978.put("9988", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("9989", Language.of("mk"));
    LANGUAGE_MAP978.put("99901", Language.of(ARABIC));
    LANGUAGE_MAP978.put("99902", Language.of(FRENCH));
    LANGUAGE_MAP978.put("99903", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("99904", Language.of(DUTCH));
    LANGUAGE_MAP978.put("99905", Language.of(SPANISH));
    LANGUAGE_MAP978.put("99906", Language.of(ARABIC));
    // LANGUAGE_MAP978.put("99907", Language.of("")); // Nicht vergeben?
    LANGUAGE_MAP978.put("99908", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("99909", Language.of("mt"));
    LANGUAGE_MAP978.put("99910", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("99911", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("99912", Language.of("tn"));
    LANGUAGE_MAP978.put("99913", Language.of("ca"));
    LANGUAGE_MAP978.put("99914", Language.of(DUTCH));
    // LANGUAGE_MAP978.put("99915", Language.of("")); // Malediven
    LANGUAGE_MAP978.put("99916", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("99917", Language.of(MALAY));
    LANGUAGE_MAP978.put("99918", Language.of("fo"));
    LANGUAGE_MAP978.put("99919", Language.of(FRENCH));
    LANGUAGE_MAP978.put("99920", Language.of("ca"));
    LANGUAGE_MAP978.put("99921", Language.of(ARABIC));
    LANGUAGE_MAP978.put("99922", Language.of(SPANISH));
    LANGUAGE_MAP978.put("99923", Language.of(SPANISH));
    LANGUAGE_MAP978.put("99924", Language.of(SPANISH));
    LANGUAGE_MAP978.put("99925", Language.of("gn"));
    LANGUAGE_MAP978.put("99926", Language.of(SPANISH));
    LANGUAGE_MAP978.put("99927", Language.of(ALBANIAN));
    LANGUAGE_MAP978.put("99928", Language.of("ka"));
    LANGUAGE_MAP978.put("99929", Language.of(MONGOLIAN));
    LANGUAGE_MAP978.put("99930", Language.of("hy"));
    LANGUAGE_MAP978.put("99931", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("99932", Language.of("mt"));
    LANGUAGE_MAP978.put("99933", Language.of("ne"));
    LANGUAGE_MAP978.put("99934", Language.of(SPANISH));
    LANGUAGE_MAP978.put("99935", Language.of("ht"));
    LANGUAGE_MAP978.put("99936", Language.of("dz"));
    LANGUAGE_MAP978.put("99937", Language.of(CHINESE));
    LANGUAGE_MAP978.put("99938", Language.of("sr"));
    LANGUAGE_MAP978.put("99939", Language.of(SPANISH));
    LANGUAGE_MAP978.put("99940", Language.of("ka"));
    LANGUAGE_MAP978.put("99941", Language.of("hy"));
    LANGUAGE_MAP978.put("99942", Language.of(ARABIC));
    LANGUAGE_MAP978.put("99943", Language.of(ALBANIAN));
    LANGUAGE_MAP978.put("99944", Language.of("am"));
    LANGUAGE_MAP978.put("99945", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("99946", Language.of("ne"));
    LANGUAGE_MAP978.put("99947", Language.of("tg"));
    LANGUAGE_MAP978.put("99948", Language.of("ti"));
    LANGUAGE_MAP978.put("99949", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("99950", Language.of("km"));
    LANGUAGE_MAP978.put("99951", Language.of(FRENCH));
    LANGUAGE_MAP978.put("99952", Language.of("bm"));
    LANGUAGE_MAP978.put("99953", Language.of("gn"));
    LANGUAGE_MAP978.put("99954", Language.of(SPANISH));
    LANGUAGE_MAP978.put("99955", Language.of("sr"));
    LANGUAGE_MAP978.put("99956", Language.of(ALBANIAN));
    LANGUAGE_MAP978.put("99957", Language.of("mt"));
    LANGUAGE_MAP978.put("99958", Language.of(ARABIC));
    LANGUAGE_MAP978.put("99959", Language.of("lb"));
    LANGUAGE_MAP978.put("99960", Language.of(ENGLISH));
    LANGUAGE_MAP978.put("99961", Language.of(SPANISH));
    LANGUAGE_MAP978.put("99962", Language.of(MONGOLIAN));
    LANGUAGE_MAP978.put("99963", Language.of("km"));
    LANGUAGE_MAP978.put("99964", Language.of(SPANISH));
    LANGUAGE_MAP978.put("99965", Language.of(CHINESE));
    LANGUAGE_MAP978.put("99966", Language.of(ARABIC));
    LANGUAGE_MAP978.put("99967", Language.of("gn"));
    LANGUAGE_MAP978.put("99968", Language.of("tn"));
    LANGUAGE_MAP978.put("99969", Language.of(ARABIC));
    LANGUAGE_MAP978.put("99970", Language.of("ht"));
    LANGUAGE_MAP978.put("99971", Language.of("my"));
    LANGUAGE_MAP978.put("99972", Language.of("fo"));
    LANGUAGE_MAP978.put("99973", Language.of(MONGOLIAN));
    LANGUAGE_MAP978.put("99974", Language.of(SPANISH));
    LANGUAGE_MAP978.put("99975", Language.of("tg"));
    LANGUAGE_MAP978.put("99976", Language.of("sr"));
    LANGUAGE_MAP978.put("99977", Language.of("rw"));
    LANGUAGE_MAP978.put("99978", Language.of(MONGOLIAN));
    LANGUAGE_MAP978.put("99979", Language.of(SPANISH));

    LANGUAGE_MAP979.put("8", Language.of(ENGLISH));
    LANGUAGE_MAP979.put("9", Language.of("de"));
    LANGUAGE_MAP979.put("10", Language.of(FRENCH));
    LANGUAGE_MAP979.put("11", Language.of("ko"));
    LANGUAGE_MAP979.put("12", Language.of("it"));
   }


  /**
   * Constructor.
   *
   * @param isbn ISBN13
   * @throws NullPointerException if isbn is null
   * @throws IllegalArgumentException if isbn is not a correct isbn13
   */
  private ISBN13(final String isbn)
   {
    super();
    Objects.requireNonNull(isbn, "isbn"); //$NON-NLS-1$
    if ((isbn.length() != 13) && (isbn.length() != 17))
     {
      throw new IllegalArgumentException("ISBN13 with wrong length"); //$NON-NLS-1$
     }
    if (!ISBN13.ISBN13_REGEXP.matcher(isbn).matches())
     {
      throw new IllegalArgumentException("ISBN13 with wrong format"); //$NON-NLS-1$
     }
    final String cleanISBN = ISBN_SEPARATOR_REGEXP.matcher(isbn).replaceAll("");
    if (!verifyChecksum(cleanISBN))
     {
      throw new IllegalArgumentException("ISBN13 with wrong checksum"); //$NON-NLS-1$
     }
    /* final String pefix = */ prefix(cleanISBN);
    /* final String group = */ group(cleanISBN);
    try
     {
      /* final String publisher = */ publisher(cleanISBN);
     }
    catch (final IllegalArgumentException | UnsupportedOperationException e)
     {
      // ignore, because publisher is not fully implemented
     }
    /* final String title = */ title(cleanISBN);
    /* final String checksum = */ checksum(cleanISBN);
    isbn13 = cleanISBN;
   }


  /**
   * ISBN13 factory.
   *
   * @param isbn ISBN13
   * @return ISBN13 object
   */
  public static ISBN13 of(final String isbn)
   {
    return new ISBN13(isbn);
   }


  /**
   * Calculate checksum.
   *
   * @param isbn ISBN13
   * @return true when checksum is correct, false otherwise
   */
  private static boolean verifyChecksum(final String isbn)
   {
    final int z1 = Character.getNumericValue(isbn.charAt(0));
    final int z2 = Character.getNumericValue(isbn.charAt(1));
    final int z3 = Character.getNumericValue(isbn.charAt(2));
    final int z4 = Character.getNumericValue(isbn.charAt(3));
    final int z5 = Character.getNumericValue(isbn.charAt(4));
    final int z6 = Character.getNumericValue(isbn.charAt(5));
    final int z7 = Character.getNumericValue(isbn.charAt(6));
    final int z8 = Character.getNumericValue(isbn.charAt(7));
    final int z9 = Character.getNumericValue(isbn.charAt(8));
    final int z10 = Character.getNumericValue(isbn.charAt(9));
    final int z11 = Character.getNumericValue(isbn.charAt(10));
    final int z12 = Character.getNumericValue(isbn.charAt(11));
    final int z13 = Character.getNumericValue(isbn.charAt(12));
    final int check = (z1 + z3 + z5 + z7 + z9 + z11 + z13 + (3 * (z2 + z4 + z6 + z8 + z10 + z12))) % 10;
    return check == 0;
   }


  /**
   * Get prefix number.
   *
   * @param isbn ISBN13
   * @return prefix number
   */
  private static String prefix(final String isbn)
   {
    return isbn.substring(0, 3);
   }


  /**
   * Get group number.
   *
   * @param isbn ISBN13
   * @return group number
   * @throws IllegalArgumentException When prefix number is not 978|979 or illegal group number for prefix 978
   */
  @SuppressWarnings({"PMD.NPathComplexity"})
  private static String group(final String isbn)
   {
    final String prefix = prefix(isbn);
    final int first = Character.getNumericValue(isbn.charAt(3));
    if (PREFIX_978.equals(prefix))
     {
      if (((first >= 0) && (first <= 5)) || (first == 7))  // 1 Stellig // NO PITEST
       {
        return String.valueOf(first);
       }
      final int second = Character.getNumericValue(isbn.charAt(4));
      if ((first == 8) || ((first == 9) && ((second >= 0) && (second <= 4))))  // 80-94 // 2 Stellig // NO PITEST
       {
        return isbn.substring(3, 5);
       }
      if (((first == 6) && ((second >= 0) && (second <= 4))) || ((first == 9) && ((second >= 5) && (second <= 8)))) // 600-649, 950-989 // 3 Stellig  // NO PITEST
       {
        return isbn.substring(3, 6);
       }
      final int third = Character.getNumericValue(isbn.charAt(5));
      if ((first == 9) && (second == 9) && ((third >= 0) && (third <= 8))) // 9900-9989 // 4 Stellig // NO PITEST
       {
        return isbn.substring(3, 7);
       }
      else if ((first == 9) && (second == 9) && (third == 9)) // 99900-99999 // 5 Stellig // NO PITEST
       {
        return isbn.substring(3, 8);
       }
      else
       {
        throw new IllegalArgumentException("Illegal group nr for prefix 978");
       }
     }
    else if (PREFIX_979.equals(prefix))
     {
      if (first == 1) // NO PITEST
       {
        // 10 – Französisch (Belgien, Frankreich, Kanada, Luxemburg, Schweiz)
        // 11 – Südkorea
        // 12 – Italien
        return isbn.substring(3, 5);
       }
      else
       {
        // 8 – USA
        // 9 – Deutschland
        return String.valueOf(first);
       }
     }
    else
     {
      throw new IllegalArgumentException("Prefix nr not 978|979");
     }
   }


  /**
   * Get country.
   *
   * @param isbn ISBN13
   * @return Country or null
   */
  private static @Nullable Country country(final String isbn)
   {
    final String prefix = prefix(isbn);
    final String group = group(isbn);
    if (PREFIX_978.equals(prefix))
     {
      return COUNTRY_MAP978.get(group);
     }
    else if (PREFIX_979.equals(prefix))
     {
      return COUNTRY_MAP979.get(group);
     }
    else
     {
      return null;
     }
   }


  /**
   * Get language.
   *
   * @param isbn ISBN13
   * @return Language or null
   */
  private static @Nullable Language language(final String isbn)
   {
    final String prefix = prefix(isbn);
    final String group = group(isbn);
    if (PREFIX_978.equals(prefix))
     {
      return LANGUAGE_MAP978.get(group);
     }
    else if (PREFIX_979.equals(prefix))
     {
      return LANGUAGE_MAP979.get(group);
     }
    else
     {
      return null;
     }
   }


  /**
   * Get publisher number.
   *
   * @param isbn ISBN13
   * @return Publisher number
   * @throws IllegalArgumentException When an illegal character appears
   * @throws UnsupportedOperationException When a group or prefix is not supported yet
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  private static String publisher(final String isbn)
   {
    final String prefix = prefix(isbn);
    final String group = group(isbn);
    final String rest = isbn.substring(3 + group.length(), 13);
    // TODO 2-7 stellig
    if (PREFIX_978.equals(prefix))
     {
      if ("0".equals(group)) // english
       {
        return new ISBN13Publisher0().publisher(rest);
       }
      else if ("1".equals(group)) // english
       {
        return new ISBN13Publisher1().publisher(rest);
       }
      else if ("3".equals(group)) // german
       {
        return new ISBN13Publisher3().publisher(rest);
       }
      else
       {
        throw new UnsupportedOperationException("Unsupported group: 978-" + group);
       }
/* 978
  2 - Französisch
  4 – Japanisch
  5 – Russisch (Ehemalige Sowjetunion)
  600 – Iran
  601 – Kasachstan
  602 – Indonesien
  603 – Saudi-Arabien
  604 – Vietnam
  605 – Türkei
  606 – Rumänien
  607 – Mexiko
  608 – Mazedonien
  609 – Litauen
  611 – Thailand
  612 – Peru
  613 – Mauritius
  614 – Libanon
  615 – Ungarn
  616 – Thailand
  617 – Ukraine
  618 – Griechenland
  619 – Bulgarien
  620 – Mauritius
  621 – Philippinen
  7 – Volksrepublik China
  80 – Ehemalige Tschechoslowakei (Tschechien, Slowakei)
  81 – Indien
  82 – Norwegen
  83 – Polen
  84 – Spanien
  85 – Brasilien
  86 – Ehemaliges Jugoslawien (Serbien, Montenegro, Bosnien-Herzegowina, Kroatien, Slowenien, Mazedonien)
  87 – Dänemark
  88 – Italien (und Italienischsprachige Schweiz)
  89 – Südkorea
  90 – Niederlande
  91 – Schweden
  92 – Internationale Verleger (UNO, UNESCO, EU usw.)
  93 – Indien
  94 – Niederlande
  950 – Argentinien
  951 – Finnland
  952 – Finnland
  953 – Kroatien
  954 – Bulgarien
  955 – Sri Lanka
  956 – Chile
  957 – Taiwan
  958 – Kolumbien
  959 – Kuba
  960 – Griechenland
  961 – Slowenien
  962 – Hongkong
  963 – Ungarn
  964 – Iran
  965 – Israel
  966 – Ukraine
  967 – Malaysia
  968 – Mexiko
  969 – Pakistan
  970 – Mexiko
  971 – Philippinen
  972 – Portugal
  973 – Rumänien
  974 – Thailand
  975 – Türkei
  976 – Karibische Gemeinschaft
  977 – Ägypten
  978 – Nigeria
  979 – Indonesien
  980 – Venezuela
  981 – Singapur
  982 – Südpazifik
  983 – Malaysia
  984 – Bangladesch
  985 – Belarus
  986 – Taiwan
  987 – Argentinien
  988 – Hongkong
  989 – Portugal
  9926 – Bosnien und Herzegowina
  9927 – Katar
  9928 – Albanien
  9929 – Guatemala
  9930 – Costa Rica
  9931 – Algerien
  9932 – Laos
  9933 – Syrien
  9934 – Lettland
  9935 – Island
  9936 – Afghanistan
  9937 – Nepal
  9938 – Tunesien
  9939 – Armenien
  9940 – Montenegro
  9941 – Georgien
  9942 – Ecuador
  9943 – Usbekistan
  9944 – Türkei
  9945 – Dominikanische Republik
  9946 – Nordkorea
  9947 – Algerien
  9948 – Vereinigte Arabische Emirate
  9949 – Estland
  9950 – Palästinensische Autonomiegebiete
  9951 – Kosovo
  9952 – Aserbaidschan
  9953 – Libanon
  9954 – Marokko
  9955 – Litauen
  9956 – Kamerun
  9957 – Jordanien
  9958 – Bosnien und Herzegowina
  9959 – Libyen
  9960 – Saudi-Arabien
  9961 – Algerien
  9962 – Panama
  9963 – Zypern
  9964 – Ghana
  9965 – Kasachstan
  9966 – Kenia
  9967 – Kirgisistan
  9968 – Costa Rica
  9970 – Uganda
  9971 – Singapur
  9972 – Peru
  9973 – Tunesien
  9974 – Uruguay
  9975 – Republik Moldau
  9976 – Tansania
  9977 – Costa Rica
  9978 – Ecuador
  9979 – Island
  9980 – Papua-Neuguinea
  9981 – Marokko
  9982 – Sambia
  9983 – Gambia
  9984 – Lettland
  9985 – Estland
  9986 – Litauen
  9987 – Tansania
  9988 – Ghana
  9989 – Mazedonien
  99901 – Bahrain
  99902 – Gabun
  99903 – Mauritius
  99904 – Niederländische Antillen (Curaçao)
  99905 – Bolivien
  99906 – Kuwait
  99908 – Malawi
  99909 – Malta
  99910 – Sierra Leone
  99911 – Lesotho
  99912 – Botswana
  99913 – Andorra
  99914 – Suriname
  99915 – Malediven
  99916 – Namibia
  99917 – Brunei
  99918 – Färöer
  99919 – Benin
  99920 – Andorra
  99921 – Katar
  99922 – Guatemala
  99923 – El Salvador
  99924 – Nicaragua
  99925 – Paraguay
  99926 – Honduras
  99927 – Albanien
  99928 – Georgien
  99929 – Mongolei
  99930 – Armenien
  99931 – Seychellen
  99932 – Malta
  99933 – Nepal
  99934 – Dominikanische Republik
  99935 – Haiti
  99936 – Bhutan
  99937 – Macau
  99938 – Republika Srpska
  99939 – Guatemala
  99940 – Georgien
  99941 – Armenien
  99942 – Sudan
  99943 – Albanien
  99944 – Äthiopien
  99945 – Namibia
  99946 – Nepal
  99947 – Tadschikistan
  99948 – Eritrea
  99949 – Mauritius
  99950 – Kambodscha
  99951 – Demokratische Republik Kongo
  99952 – Mali
  99953 – Paraguay
  99954 – Bolivien
  99955 – Republika Srpska
  99956 – Albanien
  99957 – Malta
  99958 – Bahrain
  99959 – Luxemburg
  99960 – Malawi
  99961 – El Salvador
  99962 – Mongolei
  99963 – Kambodscha
  99964 – Nicaragua
  99965 – Macau
  99966 – Kuwait
  99967 – Paraguay
  99968 – Botswana
  99969 – Oman
  99970 – Haiti
  99971 – Myanmar
  99972 – Färöer
  99973 – Mongolei
  99974 – Bolivien
  99975 – Tadschikistan
  99976 – Republika Srpska
  99977 – Ruanda
  99978 – Mongolei
  99979 – Honduras
*/
     }
    else if (PREFIX_979.equals(prefix))
     {
      /* 979
      8 – USA
      9 – Deutschland
      10 – Französisch (Belgien, Frankreich, Kanada, Luxemburg, Schweiz)
      11 – Südkorea
      12 – Italien
      */
      throw new UnsupportedOperationException("Unsupported group: 979-" + group);
     }
    else
     {
      throw new UnsupportedOperationException("Unsupported prefix: " + prefix);
     }
   }


  /**
   * Get title number.
   *
   * @param isbn ISBN13
   * @return title number
   */
  @SuppressFBWarnings("USBR_UNNECESSARY_STORE_BEFORE_RETURN")
  private static String title(final String isbn)
   {
    final int groupLength = group(isbn).length();
    final int publisherLength = publisher(isbn).length();
    final String title = isbn.substring(3 + groupLength + publisherLength, 12);
    return title;
   }


  /**
   * Get checksum number.
   *
   * @param isbn ISBN13
   * @return checksum number
   */
  private static String checksum(final String isbn)
   {
    return isbn.substring(12);
   }


  /**
   * Returns the value of this ISBN13 as a string without hyphen.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return isbn13;
   }


  /**
   * Returns the value of this ISBN13 as a string with hyphen.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @SuppressFBWarnings("STT_STRING_PARSING_A_FIELD")
  public String stringHyphen()
   {
    final String prefix = prefix(isbn13);
    final String group = group(isbn13);
    final String publisher = publisher(isbn13);
    final String title = title(isbn13);
    final String checksum = isbn13.substring(12);
    return prefix + ISBN_SEPARATOR + group + ISBN_SEPARATOR + publisher + ISBN_SEPARATOR + title + ISBN_SEPARATOR + checksum;
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
    return isbn13.hashCode();
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
  public boolean equals(final @Nullable Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof final ISBN13 other))
     {
      return false;
     }
    return isbn13.equals(other.isbn13);
   }


  /**
   * Returns the string representation of this ISBN13.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "ISBN13[isbn13=9783866801929]"
   *
   * @return String representation of this ISBN13
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("ISBN13[isbn13=").append(isbn13).append(']'); //$NON-NLS-1$
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
  public int compareTo(final ISBN13 obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return isbn13.compareTo(obj.isbn13);
   }

 }
