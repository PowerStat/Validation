/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.math.BigInteger;
import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;
import de.powerstat.validation.values.impl.IBANVerifierAbstractFactory;


/**
 * IBAN.
 *
 * @param iban IBAN
 * 
 * Probably DSGVO relevant.
 *
 * TODO https://openiban.com/
 * TODO Human format in/out
 */
public record IBAN(String iban) implements Comparable<IBAN>, IValueObject
 {
  /**
   * IBAN regexp.
   */
  private static final Pattern IBAN_REGEXP = Pattern.compile("^[A-Z]{2}[0-9]{2}[0-9A-Z]{11,30}$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param iban IBAN
   * @throws NullPointerException if iban is null
   * @throws IllegalArgumentException if iban is not an correct iban
   */
  public IBAN
   {
    Objects.requireNonNull(iban, "iban"); //$NON-NLS-1$
    if ((iban.length() < 15) || (iban.length() > 34))
     {
      throw new IllegalArgumentException("IBAN with wrong length"); //$NON-NLS-1$
     }
    if (!IBAN.IBAN_REGEXP.matcher(iban).matches())
     {
      throw new IllegalArgumentException("IBAN with wrong format"); //$NON-NLS-1$
     }
    final var checksum = iban.substring(2, 4);
    if ("00".equals(checksum) || "01".equals(checksum) || "99".equals(checksum)) //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
     {
      throw new IllegalArgumentException("IBAN with illegal checksum"); //$NON-NLS-1$
     }
    if (!verifyChecksum(iban))
     {
      throw new IllegalArgumentException("IBAN with wrong checksum"); //$NON-NLS-1$
     }
    final var country = Country.of(iban.substring(0, 2));
    if (!IBANVerifierAbstractFactory.createIBANVerifier(country).verify(iban))
     {
      throw new IllegalArgumentException("IBAN not correct in country context: " + iban); //$NON-NLS-1$
     }
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
    final String replacement = reordered.replace("A", "10").replace("B", "11").replace("C", "12").replace("D", "13").replace("E", "14").replace("F", "15").replace("G", "16").replace("H", "17").replace("I", "18").replace("J", "19").replace("K", "20").replace("L", "21").replace("M", "22").replace("N", "23").replace("O", "24").replace("P", "25").replace("Q", "26").replace("R", "27").replace("S", "28").replace("T", "29").replace("U", "30").replace("V", "31").replace("W", "32").replace("X", "33").replace("Y", "34").replace("Z", "35"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$ //$NON-NLS-7$ //$NON-NLS-8$ //$NON-NLS-9$ //$NON-NLS-10$ //$NON-NLS-11$ //$NON-NLS-12$ //$NON-NLS-13$ //$NON-NLS-14$ //$NON-NLS-15$ //$NON-NLS-16$ //$NON-NLS-17$ //$NON-NLS-18$ //$NON-NLS-19$ //$NON-NLS-20$ //$NON-NLS-21$ //$NON-NLS-22$ //$NON-NLS-23$ //$NON-NLS-24$ //$NON-NLS-25$ //$NON-NLS-26$ //$NON-NLS-27$ //$NON-NLS-28$ //$NON-NLS-29$ //$NON-NLS-30$ //$NON-NLS-31$ //$NON-NLS-32$ //$NON-NLS-33$ //$NON-NLS-34$ //$NON-NLS-35$ //$NON-NLS-36$ //$NON-NLS-37$ //$NON-NLS-38$ //$NON-NLS-39$ //$NON-NLS-40$ //$NON-NLS-41$ //$NON-NLS-42$ //$NON-NLS-43$ //$NON-NLS-44$ //$NON-NLS-45$ //$NON-NLS-46$ //$NON-NLS-47$ //$NON-NLS-48$ //$NON-NLS-49$ //$NON-NLS-50$ //$NON-NLS-51$ //$NON-NLS-52$
    final var num = new BigInteger(replacement);
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
   * Returns the value of this IBAN as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.iban;
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
