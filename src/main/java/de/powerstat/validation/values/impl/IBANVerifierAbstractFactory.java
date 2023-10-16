/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.impl;


import de.powerstat.validation.values.Country;
// import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Abstract factory for country specific IBAN verifiers.
 *
 * TODO Generate this class
 */
// @SuppressFBWarnings({"CC_CYCLOMATIC_COMPLEXITY", "CE_CLASS_ENVY"})
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
  @SuppressWarnings("java:S1479")
  public static IBANVerifier createIBANVerifier(final Country country)
   {
    switch (country.stringValue())
     {
      case "EG": //$NON-NLS-1$
        return IBANVerifier.of(27, "^EG[0-9]{2}[0-9]{23}$"); //$NON-NLS-1$
      case "AL": //$NON-NLS-1$
        return IBANVerifier.of(28, "^AL[0-9]{2}[0-9]{7}[0-9A-Z][0-9]{16}$"); //$NON-NLS-1$
      case "DZ": //$NON-NLS-1$
        return IBANVerifier.of(24, "^DZ[0-9]{2}[0-9]{18}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "AD": //$NON-NLS-1$
        return IBANVerifier.of(24, "^AD[0-9]{2}[0-9]{20}$"); //$NON-NLS-1$
      case "AO": //$NON-NLS-1$
        return IBANVerifier.of(25, "^AO[0-9]{2}[0-9]{19}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "AZ": //$NON-NLS-1$
        return IBANVerifier.of(28, "^AZ[0-9]{2}[0-9]{24}$"); //$NON-NLS-1$
      case "BH": //$NON-NLS-1$
        return IBANVerifier.of(22, "^BH[0-9]{2}[0-9]{18}$"); //$NON-NLS-1$
      case "BE": //$NON-NLS-1$
        return IBANVerifier.of(16, "^BE[0-9]{2}[0-9]{10}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "BJ": //$NON-NLS-1$
        return IBANVerifier.of(28, "^BJ[0-9]{2}[0-9]{22}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "BA": //$NON-NLS-1$
        return IBANVerifier.of(20, "^BA[0-9]{2}[0-9]{14}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "BR": //$NON-NLS-1$
        return IBANVerifier.of(29, "^BR[0-9]{2}[0-9]{25}$"); //$NON-NLS-1$
      case "VG": //$NON-NLS-1$
        return IBANVerifier.of(24, "^VG[0-9]{2}[0-9]{20}$"); //$NON-NLS-1$
      case "BG": //$NON-NLS-1$
        return IBANVerifier.of(22, "^BG[0-9]{2}[0-9]{18}$"); //$NON-NLS-1$
      case "BF": //$NON-NLS-1$
        return IBANVerifier.of(27, "^BF[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "BI": //$NON-NLS-1$
        return IBANVerifier.of(16, "^BI[0-9]{2}[0-9]{12}$"); //$NON-NLS-1$
      case "CR": //$NON-NLS-1$
        return IBANVerifier.of(22, "^CR[0-9]{2}0[0-9]{17}$"); //$NON-NLS-1$
      case "CI": //$NON-NLS-1$
        return IBANVerifier.of(28, "^CI[0-9]{2}[0-9]{22}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "DK": //$NON-NLS-1$
        return IBANVerifier.of(18, "^DK[0-9]{2}[0-9]{13}[0-9A-Z]$"); //$NON-NLS-1$
      case "DE": //$NON-NLS-1$
        return IBANVerifier.of(22, "^DE[0-9]{2}[0-9]{18}$"); //$NON-NLS-1$
      case "DO": //$NON-NLS-1$
        return IBANVerifier.of(28, "^DO[0-9]{2}[0-9]{24}$"); //$NON-NLS-1$
      case "SV": //$NON-NLS-1$
        return IBANVerifier.of(28, "^SV[0-9]{2}[0-9]{24}$"); //$NON-NLS-1$
      case "EE": //$NON-NLS-1$
        return IBANVerifier.of(20, "^EE[0-9]{2}[0-9]{15}[0-9A-Z]$"); //$NON-NLS-1$
      case "FO": //$NON-NLS-1$
        return IBANVerifier.of(18, "^FO[0-9]{2}[0-9]{13}[0-9A-Z]$"); //$NON-NLS-1$
      case "FI": //$NON-NLS-1$
        return IBANVerifier.of(18, "^FI[0-9]{2}[0-9]{13}[0-9A-Z]$"); //$NON-NLS-1$
      case "FR": //$NON-NLS-1$
        return IBANVerifier.of(27, "^FR[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "GA": //$NON-NLS-1$
        return IBANVerifier.of(27, "^GA[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "GE": //$NON-NLS-1$
        return IBANVerifier.of(22, "^GE[0-9]{2}[0-9]{18}$"); //$NON-NLS-1$
      case "GI": //$NON-NLS-1$
        return IBANVerifier.of(23, "^GI[0-9]{2}[0-9]{19}$"); //$NON-NLS-1$
      case "GR": //$NON-NLS-1$
        return IBANVerifier.of(27, "^GR[0-9]{2}[0-9]{23}$"); //$NON-NLS-1$
      case "GL": //$NON-NLS-1$
        return IBANVerifier.of(18, "^GL[0-9]{2}[0-9]{13}[0-9A-Z]$"); //$NON-NLS-1$
      case "GT": //$NON-NLS-1$
        return IBANVerifier.of(28, "^GT[0-9]{2}[0-9]{24}$"); //$NON-NLS-1$
      case "IQ": //$NON-NLS-1$
        return IBANVerifier.of(23, "^IQ[0-9]{2}[0-9]{19}$"); //$NON-NLS-1$
      case "IR": //$NON-NLS-1$
        return IBANVerifier.of(26, "^IR[0-9]{2}[0-9]{22}$"); //$NON-NLS-1$
      case "IE": //$NON-NLS-1$
        return IBANVerifier.of(22, "^IE[0-9]{2}[0-9]{18}$"); //$NON-NLS-1$
      case "IS": //$NON-NLS-1$
        return IBANVerifier.of(26, "^IS[0-9]{2}[0-9]{12}XXXXXXXXXX$"); //$NON-NLS-1$
      case "IL": //$NON-NLS-1$
        return IBANVerifier.of(23, "^IL[0-9]{2}[0-9]{19}$"); //$NON-NLS-1$
      case "IT": //$NON-NLS-1$
        return IBANVerifier.of(27, "^IT[0-9]{2}[0-9A-Z][0-9]{22}$"); //$NON-NLS-1$
      case "JO": //$NON-NLS-1$
        return IBANVerifier.of(30, "^JO[0-9]{2}[0-9]{26}$"); //$NON-NLS-1$
      case "CM": //$NON-NLS-1$
        return IBANVerifier.of(27, "^CM[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "CV": //$NON-NLS-1$
        return IBANVerifier.of(25, "^CV[0-9]{2}[0-9]{19}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "KZ": //$NON-NLS-1$
        return IBANVerifier.of(20, "^KZ[0-9]{2}[0-9]{16}$"); //$NON-NLS-1$
      case "QA": //$NON-NLS-1$
        return IBANVerifier.of(29, "^QA[0-9]{2}[0-9]{25}$"); //$NON-NLS-1$
      case "CG": //$NON-NLS-1$
        return IBANVerifier.of(27, "^CG[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "XK": //$NON-NLS-1$ // Not an ISO3166 alpha 2 code
        return IBANVerifier.of(20, "^XK[0-9]{2}[0-9]{16}$"); //$NON-NLS-1$
      case "HR": //$NON-NLS-1$
        return IBANVerifier.of(21, "^HR[0-9]{2}[0-9]{17}$"); //$NON-NLS-1$
      case "KW": //$NON-NLS-1$
        return IBANVerifier.of(30, "^KW[0-9]{2}[0-9]{26}$"); //$NON-NLS-1$
      case "LV": //$NON-NLS-1$
        return IBANVerifier.of(21, "^LV[0-9]{2}[0-9]{17}$"); //$NON-NLS-1$
      case "LB": //$NON-NLS-1$
        return IBANVerifier.of(28, "^LB[0-9]{2}[0-9]{24}$"); //$NON-NLS-1$
      case "LI": //$NON-NLS-1$
        return IBANVerifier.of(21, "^LI[0-9]{2}[0-9]{17}$"); //$NON-NLS-1$
      case "LT": //$NON-NLS-1$
        return IBANVerifier.of(20, "^LT[0-9]{2}[0-9]{16}$"); //$NON-NLS-1$
      case "LU": //$NON-NLS-1$
        return IBANVerifier.of(20, "^LU[0-9]{2}[0-9]{16}$"); //$NON-NLS-1$
      case "MG": //$NON-NLS-1$
        return IBANVerifier.of(27, "^MG[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "ML": //$NON-NLS-1$
        return IBANVerifier.of(28, "^ML[0-9]{2}[0-9]{22}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "MT": //$NON-NLS-1$
        return IBANVerifier.of(31, "^MT[0-9]{2}[0-9]{27}$"); //$NON-NLS-1$
      case "MR": //$NON-NLS-1$
        return IBANVerifier.of(27, "^MR[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "MU": //$NON-NLS-1$
        return IBANVerifier.of(30, "^MU[0-9]{2}[0-9]{23}[0-9A-Z]{3}$"); //$NON-NLS-1$
      case "MD": //$NON-NLS-1$
        return IBANVerifier.of(24, "^MD[0-9]{2}[0-9]{20}$"); //$NON-NLS-1$
      case "MC": //$NON-NLS-1$
        return IBANVerifier.of(27, "^MC[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "ME": //$NON-NLS-1$
        return IBANVerifier.of(22, "^ME[0-9]{2}[0-9]{16}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "MZ": //$NON-NLS-1$
        return IBANVerifier.of(25, "^MZ[0-9]{2}[0-9]{19}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "NL": //$NON-NLS-1$
        return IBANVerifier.of(18, "^NL[0-9]{2}[0-9]{14}$"); //$NON-NLS-1$
      case "MK": //$NON-NLS-1$
        return IBANVerifier.of(19, "^MK[0-9]{2}[0-9]{13}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "NO": //$NON-NLS-1$
        return IBANVerifier.of(15, "^NO[0-9]{2}[0-9]{10}[0-9A-Z]$"); //$NON-NLS-1$
      case "AT": //$NON-NLS-1$
        return IBANVerifier.of(20, "^AT[0-9]{2}[0-9]{16}$"); //$NON-NLS-1$
      case "TL": //$NON-NLS-1$
        return IBANVerifier.of(23, "^TL[0-9]{2}[0-9]{17}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "PK": //$NON-NLS-1$
        return IBANVerifier.of(24, "^PK[0-9]{2}[0-9]{20}$"); //$NON-NLS-1$
      case "PS": //$NON-NLS-1$
        return IBANVerifier.of(29, "^PS[0-9]{2}[0-9]{25}$"); //$NON-NLS-1$
      case "PL": //$NON-NLS-1$
        return IBANVerifier.of(28, "^PL[0-9]{2}[0-9]{7}[0-9A-Z][0-9]{16}$"); //$NON-NLS-1$
      case "PT": //$NON-NLS-1$
        return IBANVerifier.of(25, "^PT[0-9]{2}[0-9]{19}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "RO": //$NON-NLS-1$
        return IBANVerifier.of(24, "^RO[0-9]{2}[0-9]{20}$"); //$NON-NLS-1$
      case "SM": //$NON-NLS-1$
        return IBANVerifier.of(27, "^SM[0-9]{2}[0-9A-Z][0-9]{22}$"); //$NON-NLS-1$
      case "ST": //$NON-NLS-1$
        return IBANVerifier.of(25, "^ST[0-9]{2}[0-9]{19}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "SA": //$NON-NLS-1$
        return IBANVerifier.of(24, "^SA[0-9]{2}[0-9]{20}$"); //$NON-NLS-1$
      case "SE": //$NON-NLS-1$
        return IBANVerifier.of(24, "^SE[0-9]{2}[0-9]{19}[0-9A-Z]$"); //$NON-NLS-1$
      case "CH": //$NON-NLS-1$
        return IBANVerifier.of(21, "^CH[0-9]{2}[0-9]{17}$"); //$NON-NLS-1$
      case "SN": //$NON-NLS-1$
        return IBANVerifier.of(28, "^SN[0-9]{2}[0-9]{22}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "RS": //$NON-NLS-1$
        return IBANVerifier.of(22, "^RS[0-9]{2}[0-9]{16}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "SC": //$NON-NLS-1$
        return IBANVerifier.of(31, "^SC[0-9]{2}[0-9]{24}XXX$"); //$NON-NLS-1$
      case "SK": //$NON-NLS-1$
        return IBANVerifier.of(24, "^SK[0-9]{2}[0-9]{20}$"); //$NON-NLS-1$
      case "SI": //$NON-NLS-1$
        return IBANVerifier.of(19, "^SI[0-9]{2}[0-9]{13}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "ES": //$NON-NLS-1$
        return IBANVerifier.of(24, "^ES[0-9]{2}[0-9]{8}[0-9A-Z]{2}[0-9]{10}$"); //$NON-NLS-1$
      case "LC": //$NON-NLS-1$
        return IBANVerifier.of(32, "^LC[0-9]{2}[0-9]{28}$"); //$NON-NLS-1$
      case "CZ": //$NON-NLS-1$
        return IBANVerifier.of(24, "^CZ[0-9]{2}[0-9]{20}$"); //$NON-NLS-1$
      case "TN": //$NON-NLS-1$
        return IBANVerifier.of(24, "^TN[0-9]{2}[0-9]{18}[0-9A-Z]{2}$"); //$NON-NLS-1$
      case "TR": //$NON-NLS-1$
        return IBANVerifier.of(26, "^TR[0-9]{2}[0-9]{22}$"); //$NON-NLS-1$
      case "UA": //$NON-NLS-1$
        return IBANVerifier.of(29, "^UA[0-9]{2}[0-9]{25}$"); //$NON-NLS-1$
      case "HU": //$NON-NLS-1$
        return IBANVerifier.of(28, "^HU[0-9]{2}[0-9]{7}[0-9A-Z][0-9]{15}[0-9A-Z]$"); //$NON-NLS-1$
      case "VA": //$NON-NLS-1$
        return IBANVerifier.of(26, "^VA[0-9]{2}[0-9]{22}$"); //$NON-NLS-1$
      case "AE": //$NON-NLS-1$
        return IBANVerifier.of(23, "^AE[0-9]{2}[0-9]{19}$"); //$NON-NLS-1$
      case "GB": //$NON-NLS-1$
        return IBANVerifier.of(22, "^GB[0-9]{2}[0-9]{18}$"); //$NON-NLS-1$
      case "BY": //$NON-NLS-1$
        return IBANVerifier.of(28, "^BY[0-9]{2}[0-9]{24}$"); //$NON-NLS-1$
      case "CY": //$NON-NLS-1$
        return IBANVerifier.of(28, "^CY[0-9]{2}[0-9]{24}$"); //$NON-NLS-1$
      case "CF": //$NON-NLS-1$
        return IBANVerifier.of(27, "^CF[0-9]{2}[0-9]{21}[0-9A-Z]{2}$"); //$NON-NLS-1$

      default:
        return IBANVerifier.of(34, "^[A-Z]{2}[0-9]{2}[0-9]{11,30}$"); //$NON-NLS-1$
     }
   }

 }
