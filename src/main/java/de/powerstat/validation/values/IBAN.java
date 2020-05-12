/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.math.BigInteger;
import java.util.Objects;

import de.powerstat.validation.values.impl.IBANVerifierAbstractFactory;


/**
 * IBAN.
 *
 * Probably DSGVO relevant.
 *
 * TODO https://openiban.com/
 * TODO Human format in/out
 */
public class IBAN implements Comparable<IBAN>
 {
  /**
   * IBAN.
   */
  private final String iban;


  /**
   * Constructor.
   *
   * @param iban IBAN
   * @throws NullPointerException if iban is null
   * @throws IllegalArgumentException if iban is not an correct iban
   */
  public IBAN(final String iban)
   {
    super();
    Objects.requireNonNull(iban, "iban"); //$NON-NLS-1$
    if ((iban.length() < 15) || (iban.length() > 34))
     {
      throw new IllegalArgumentException("IBAN with wrong length"); //$NON-NLS-1$
     }
    if (!iban.matches("^[A-Z]{2}[0-9]{2}[0-9A-Z]{11,30}$")) //$NON-NLS-1$
     {
      throw new IllegalArgumentException("IBAN with wrong format"); //$NON-NLS-1$
     }
    final Country country = Country.of(iban.substring(0, 2));
    final String checksum = iban.substring(2, 4);
    if ("00".equals(checksum) || "01".equals(checksum) || "99".equals(checksum)) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
     {
      throw new IllegalArgumentException("IBAN with illegal checksum"); //$NON-NLS-1$
     }
    if (!verifyChecksum(iban))
     {
      throw new IllegalArgumentException("IBAN with wrong checksum"); //$NON-NLS-1$
     }
    if (!IBANVerifierAbstractFactory.createIBANVerifier(country).verify(iban))
     {
      throw new IllegalArgumentException("IBAN not correct in country context: " + iban); //$NON-NLS-1$
     }
    this.iban = iban;
   }


  /**
   * Calculate ISO 7064 mod 97-10 checksum.
   *
   * @param iban IBAN
   * @return true when checksum is correct, false otherwise
   */
  private static boolean verifyChecksum(final String iban)
   {
    final String reordered = iban.substring(4) + iban.substring(0, 2) + iban.substring(2, 4);
    final String replacement = reordered.replaceAll("A", "10").replaceAll("B", "11").replaceAll("C", "12").replaceAll("D", "13").replaceAll("E", "14").replaceAll("F", "15").replaceAll("G", "16").replaceAll("H", "17").replaceAll("I", "18").replaceAll("J", "19").replaceAll("K", "20").replaceAll("L", "21").replaceAll("M", "22").replaceAll("N", "23").replaceAll("O", "24").replaceAll("P", "25").replaceAll("Q", "26").replaceAll("R", "27").replaceAll("S", "28").replaceAll("T", "29").replaceAll("U", "30").replaceAll("V", "31").replaceAll("W", "32").replaceAll("X", "33").replaceAll("Y", "34").replaceAll("Z", "35"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ //$NON-NLS-14$ //$NON-NLS-15$ //$NON-NLS-16$ //$NON-NLS-17$ //$NON-NLS-18$ //$NON-NLS-19$ //$NON-NLS-20$ //$NON-NLS-21$ //$NON-NLS-22$ //$NON-NLS-23$ //$NON-NLS-24$ //$NON-NLS-25$ //$NON-NLS-26$ //$NON-NLS-27$ //$NON-NLS-28$ //$NON-NLS-29$ //$NON-NLS-30$ //$NON-NLS-31$ //$NON-NLS-32$ //$NON-NLS-33$ //$NON-NLS-34$ //$NON-NLS-35$ //$NON-NLS-36$ //$NON-NLS-37$ //$NON-NLS-38$ //$NON-NLS-39$ //$NON-NLS-40$ //$NON-NLS-41$ //$NON-NLS-42$ //$NON-NLS-43$ //$NON-NLS-44$ //$NON-NLS-45$ //$NON-NLS-46$ //$NON-NLS-47$ //$NON-NLS-48$ //$NON-NLS-49$ //$NON-NLS-50$ //$NON-NLS-51$ //$NON-NLS-52$
    final BigInteger num = new BigInteger(replacement);
    final BigInteger result = num.remainder(BigInteger.valueOf(97));
    return result.longValue() == 1;
   }


  /**
   * IBAN factory.
   *
   * @param iban IBAN
   * @return IBAN object
   */
  public static IBAN of(final String iban)
   {
    return new IBAN(iban);
   }


  /**
   * Get iban string.
   *
   * @return IBAN string
   */
  public String getIBAN()
   {
    return this.iban;
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
    return this.iban.hashCode();
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof IBAN))
     {
      return false;
     }
    final IBAN other = (IBAN)obj;
    return this.iban.equals(other.iban);
   }


  /**
   * Returns the string representation of this IBAN.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "IBAN[iban=DE68210501700012345678]"
   *
   * @return String representation of this IBAN
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("IBAN[iban=").append(this.iban).append(']'); //$NON-NLS-1$
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
  public int compareTo(final IBAN obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.iban.compareTo(obj.iban);
   }

 }
