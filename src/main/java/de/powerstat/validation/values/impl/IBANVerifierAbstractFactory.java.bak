/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values.impl;


import de.powerstat.validation.values.Country;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
// import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Abstract factory for country specific IBAN verifiers.
 *
 * TODO Generate this class
 */
@SuppressFBWarnings({"CE_CLASS_ENVY"})
@SuppressWarnings({"java:S1541", "java:S3242"})
public final class IBANVerifierAbstractFactory
 {
  /**
   * Private constructor.
   */
  private IBANVerifierAbstractFactory()
   {
    super();
   }


  /**
   * Create IBAN verifier for country.
   *
   * @param country Country
   * @return IBANVerifier object for country
   */
  @SuppressFBWarnings({"CC_CYCLOMATIC_COMPLEXITY", "OCP_OVERLY_CONCRETE_PARAMETER", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
  @SuppressWarnings({"java:S1479", "PMD.CyclomaticComplexity"})
  public static IBANVerifier createIBANVerifier(final Country country)
   {
    return switch (country.stringValue())
     {
      case "EG" -> IBANVerifier.of(27, "^EG[0-9]{2}[0-9]{23}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "AL" -> IBANVerifier.of(28, "^AL[0-9]{2}[0-9]{7}[0-9A-Z][0-9]{16}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "DZ" -> IBANVerifier.of(24, "^DZ[0-9]{2}[0-9]{18}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "AD" -> IBANVerifier.of(24, "^AD[0-9]{2}[0-9]{20}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "AO" -> IBANVerifier.of(25, "^AO[0-9]{2}[0-9]{19}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "AZ" -> IBANVerifier.of(28, "^AZ[0-9]{2}[0-9]{24}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "BH" -> IBANVerifier.of(22, "^BH[0-9]{2}[0-9]{18}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "BE" -> IBANVerifier.of(16, "^BE[0-9]{2}[0-9]{10}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "BJ" -> IBANVerifier.of(28, "^BJ[0-9]{2}[0-9]{22}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "BA" -> IBANVerifier.of(20, "^BA[0-9]{2}[0-9]{14}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "BR" -> IBANVerifier.of(29, "^BR[0-9]{2}[0-9]{25}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "VG" -> IBANVerifier.of(24, "^VG[0-9]{2}[0-9]{20}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "BG" -> IBANVerifier.of(22, "^BG[0-9]{2}[0-9]{18}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "BF" -> IBANVerifier.of(27, "^BF[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "BI" -> IBANVerifier.of(16, "^BI[0-9]{2}[0-9]{12}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "CR" -> IBANVerifier.of(22, "^CR[0-9]{2}0[0-9]{17}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "CI" -> IBANVerifier.of(28, "^CI[0-9]{2}[0-9]{22}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "DK" -> IBANVerifier.of(18, "^DK[0-9]{2}[0-9]{13}[0-9A-Z]$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "DE" -> IBANVerifier.of(22, "^DE[0-9]{2}[0-9]{18}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "DO" -> IBANVerifier.of(28, "^DO[0-9]{2}[0-9]{24}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "SV" -> IBANVerifier.of(28, "^SV[0-9]{2}[0-9]{24}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "EE" -> IBANVerifier.of(20, "^EE[0-9]{2}[0-9]{15}[0-9A-Z]$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "FO" -> IBANVerifier.of(18, "^FO[0-9]{2}[0-9]{13}[0-9A-Z]$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "FI" -> IBANVerifier.of(18, "^FI[0-9]{2}[0-9]{13}[0-9A-Z]$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "FR" -> IBANVerifier.of(27, "^FR[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "GA" -> IBANVerifier.of(27, "^GA[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "GE" -> IBANVerifier.of(22, "^GE[0-9]{2}[0-9]{18}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "GI" -> IBANVerifier.of(23, "^GI[0-9]{2}[0-9]{19}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "GR" -> IBANVerifier.of(27, "^GR[0-9]{2}[0-9]{23}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "GL" -> IBANVerifier.of(18, "^GL[0-9]{2}[0-9]{13}[0-9A-Z]$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "GT" -> IBANVerifier.of(28, "^GT[0-9]{2}[0-9]{24}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "IQ" -> IBANVerifier.of(23, "^IQ[0-9]{2}[0-9]{19}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "IR" -> IBANVerifier.of(26, "^IR[0-9]{2}[0-9]{22}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "IE" -> IBANVerifier.of(22, "^IE[0-9]{2}[0-9]{18}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "IS" -> IBANVerifier.of(26, "^IS[0-9]{2}[0-9]{12}XXXXXXXXXX$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "IL" -> IBANVerifier.of(23, "^IL[0-9]{2}[0-9]{19}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "IT" -> IBANVerifier.of(27, "^IT[0-9]{2}[0-9A-Z][0-9]{22}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "JO" -> IBANVerifier.of(30, "^JO[0-9]{2}[0-9]{26}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "CM" -> IBANVerifier.of(27, "^CM[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "CV" -> IBANVerifier.of(25, "^CV[0-9]{2}[0-9]{19}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "KZ" -> IBANVerifier.of(20, "^KZ[0-9]{2}[0-9]{16}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "QA" -> IBANVerifier.of(29, "^QA[0-9]{2}[0-9]{25}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "CG" -> IBANVerifier.of(27, "^CG[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "XK" -> IBANVerifier.of(20, "^XK[0-9]{2}[0-9]{16}$"); //$NON-NLS-1$ //$NON-NLS-2$ // NO PITEST
      case "HR" -> IBANVerifier.of(21, "^HR[0-9]{2}[0-9]{17}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "KW" -> IBANVerifier.of(30, "^KW[0-9]{2}[0-9]{26}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "LV" -> IBANVerifier.of(21, "^LV[0-9]{2}[0-9]{17}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "LB" -> IBANVerifier.of(28, "^LB[0-9]{2}[0-9]{24}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "LI" -> IBANVerifier.of(21, "^LI[0-9]{2}[0-9]{17}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "LT" -> IBANVerifier.of(20, "^LT[0-9]{2}[0-9]{16}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "LU" -> IBANVerifier.of(20, "^LU[0-9]{2}[0-9]{16}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "MG" -> IBANVerifier.of(27, "^MG[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "ML" -> IBANVerifier.of(28, "^ML[0-9]{2}[0-9]{22}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "MT" -> IBANVerifier.of(31, "^MT[0-9]{2}[0-9]{27}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "MR" -> IBANVerifier.of(27, "^MR[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "MU" -> IBANVerifier.of(30, "^MU[0-9]{2}[0-9]{23}[0-9A-Z]{3}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "MD" -> IBANVerifier.of(24, "^MD[0-9]{2}[0-9]{20}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "MC" -> IBANVerifier.of(27, "^MC[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "ME" -> IBANVerifier.of(22, "^ME[0-9]{2}[0-9]{16}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "MZ" -> IBANVerifier.of(25, "^MZ[0-9]{2}[0-9]{19}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "NL" -> IBANVerifier.of(18, "^NL[0-9]{2}[0-9]{14}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "MK" -> IBANVerifier.of(19, "^MK[0-9]{2}[0-9]{13}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "NO" -> IBANVerifier.of(15, "^NO[0-9]{2}[0-9]{10}[0-9A-Z]$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "AT" -> IBANVerifier.of(20, "^AT[0-9]{2}[0-9]{16}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "TL" -> IBANVerifier.of(23, "^TL[0-9]{2}[0-9]{17}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "PK" -> IBANVerifier.of(24, "^PK[0-9]{2}[0-9]{20}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "PS" -> IBANVerifier.of(29, "^PS[0-9]{2}[0-9]{25}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "PL" -> IBANVerifier.of(28, "^PL[0-9]{2}[0-9]{7}[0-9A-Z][0-9]{16}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "PT" -> IBANVerifier.of(25, "^PT[0-9]{2}[0-9]{19}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "RO" -> IBANVerifier.of(24, "^RO[0-9]{2}[0-9]{20}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "SM" -> IBANVerifier.of(27, "^SM[0-9]{2}[0-9A-Z][0-9]{22}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "ST" -> IBANVerifier.of(25, "^ST[0-9]{2}[0-9]{19}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "SA" -> IBANVerifier.of(24, "^SA[0-9]{2}[0-9]{20}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "SE" -> IBANVerifier.of(24, "^SE[0-9]{2}[0-9]{19}[0-9A-Z]$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "CH" -> IBANVerifier.of(21, "^CH[0-9]{2}[0-9]{17}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "SN" -> IBANVerifier.of(28, "^SN[0-9]{2}[0-9]{22}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "RS" -> IBANVerifier.of(22, "^RS[0-9]{2}[0-9]{16}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "SC" -> IBANVerifier.of(31, "^SC[0-9]{2}[0-9]{24}XXX$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "SK" -> IBANVerifier.of(24, "^SK[0-9]{2}[0-9]{20}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "SI" -> IBANVerifier.of(19, "^SI[0-9]{2}[0-9]{13}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "ES" -> IBANVerifier.of(24, "^ES[0-9]{2}[0-9]{8}[0-9A-Z]{2}[0-9]{10}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "LC" -> IBANVerifier.of(32, "^LC[0-9]{2}[0-9]{28}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "CZ" -> IBANVerifier.of(24, "^CZ[0-9]{2}[0-9]{20}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "TN" -> IBANVerifier.of(24, "^TN[0-9]{2}[0-9]{18}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "TR" -> IBANVerifier.of(26, "^TR[0-9]{2}[0-9]{22}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "UA" -> IBANVerifier.of(29, "^UA[0-9]{2}[0-9]{25}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "HU" -> IBANVerifier.of(28, "^HU[0-9]{2}[0-9]{7}[0-9A-Z][0-9]{15}[0-9A-Z]$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "VA" -> IBANVerifier.of(26, "^VA[0-9]{2}[0-9]{22}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "AE" -> IBANVerifier.of(23, "^AE[0-9]{2}[0-9]{19}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "GB" -> IBANVerifier.of(22, "^GB[0-9]{2}[0-9]{18}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "BY" -> IBANVerifier.of(28, "^BY[0-9]{2}[0-9]{24}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "CY" -> IBANVerifier.of(28, "^CY[0-9]{2}[0-9]{24}$"); //$NON-NLS-1$ //$NON-NLS-2$
      case "CF" -> IBANVerifier.of(27, "^CF[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$ //$NON-NLS-2$

      default -> IBANVerifier.of(34, "^[A-Z]{2}[0-9]{2}[0-9]{11,30}$"); //$NON-NLS-1$
     };
   }

 }
