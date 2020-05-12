/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Street number.
 *
 * Possibly DSGVO relevant.
 *
 * TODO optimize constructor/compareTo
 */
public class StreetNr implements Comparable<StreetNr>
 {
  /**
   * Logger.
   */
  private static final Logger LOGGER = LogManager.getLogger(StreetNr.class);

  /**
   * Regexp for street number formats.
   */
  private static final String STREET_NR_REGEXP = "^([0-9]{1,5})((-|/)([0-9]{1,5}))?( ([0-9]{1,3})/([0-9]{1,3}))?( ([a-z]))?$"; //$NON-NLS-1$

  /**
   * Maximum known street nr in the world.
   */
  private static final int MAX_KNOWN_STREET_NR = 29999;

  /**
   * Street number.
   */
  private final String streetNr;


  /**
   * Constructor.
   *
   * @param streetNr Street number
   * @throws NullPointerException if streetNr is null
   * @throws IllegalArgumentException if streetNr is not an correct streetNr
   */
  public StreetNr(final String streetNr)
   {
    super();
    Objects.requireNonNull(streetNr, "streetNr"); //$NON-NLS-1$
    if ((streetNr.length() < 1) || (streetNr.length() > 21))
     {
      throw new IllegalArgumentException("StreetNr with wrong length"); //$NON-NLS-1$
     }
    final Pattern pattern = Pattern.compile(STREET_NR_REGEXP);
    final Matcher matcher = pattern.matcher(streetNr);
    if (!matcher.matches())
     {
      throw new IllegalArgumentException("StreetNr with wrong format"); //$NON-NLS-1$
     }
    // group 1: house nr (from) 42:   42
    // group 4: house nr (to) 42-43:  43
    // group 6: numerator 3/4:         3
    // group 7: denominator 3/4:       4
    // group 8: alphabetic character:  a
    if (Integer.parseInt(matcher.group(1)) > MAX_KNOWN_STREET_NR)
     {
      throw new IllegalArgumentException("StreetNr > " + MAX_KNOWN_STREET_NR); //$NON-NLS-1$
     }
    if ((matcher.group(4) != null) && (Integer.compare(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(4))) >= 0))
     {
      throw new IllegalArgumentException("StreetNr from >= StreetNr to"); //$NON-NLS-1$
     }
    if ((matcher.group(7) != null) && (Integer.compare(Integer.parseInt(matcher.group(6)), Integer.parseInt(matcher.group(7))) > 0))
     {
      throw new IllegalArgumentException("StreetNr numerator > denominator"); //$NON-NLS-1$
     }
    this.streetNr = streetNr;
   }


  /**
   * StreetNr factory.
   *
   * @param streetNr StreetNr
   * @return StreetNr object
   */
  public static StreetNr of(final String streetNr)
   {
    return new StreetNr(streetNr);
   }


  /**
   * Get streetNr string.
   *
   * @return StreetNr string
   */
  public String getStreetNr()
   {
    return this.streetNr;
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
    return this.streetNr.hashCode();
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
    if (!(obj instanceof StreetNr))
     {
      return false;
     }
    final StreetNr other = (StreetNr)obj;
    return this.streetNr.equals(other.streetNr);
   }


  /**
   * Returns the string representation of this StreetNr.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "StreetNr[streetNr=42]"
   *
   * @return String representation of this StreetNr
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(19);
    builder.append("StreetNr[streetNr=").append(this.streetNr).append(']'); //$NON-NLS-1$
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
  public int compareTo(final StreetNr obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    final Pattern pattern = Pattern.compile(STREET_NR_REGEXP);
    final Matcher matcher1 = pattern.matcher(this.streetNr);
    final Matcher matcher2 = pattern.matcher(obj.streetNr);
    if (!matcher1.matches() || !matcher2.matches())
     {
      throw new IllegalStateException("One or both of the two streetNr objects does not match the streetNr pattern"); //$NON-NLS-1$
     }
    // group 1: house nr (from) 42:   42
    // group 4: house nr (to) 42-43:  43
    // group 6: numerator 3/4:         3
    // group 7: denominator 3/4:       4
    // group 8: alphabetic character:  a
    int result = Integer.compare(Integer.parseInt(matcher1.group(1)), Integer.parseInt(matcher2.group(1)));
    if (result == 0)
     {
      if ((matcher1.group(7) != null) || (matcher2.group(7) != null)) // 3/4
       {
        if (matcher1.group(7) == null)
         {
          return -1;
         }
        else if (matcher2.group(7) == null)
         {
          return 1;
         }
        else
         {
          if (matcher1.group(7).compareTo(matcher2.group(7)) != 0)
           {
            throw new IllegalStateException("StreetNrs do not have the same denominator"); //$NON-NLS-1$
           }
          result = Integer.compare(Integer.parseInt(matcher1.group(6)), Integer.parseInt(matcher2.group(6)));
          if (result != 0)
           {
            return result;
           }
         }
       }
      if ((matcher1.group(8) != null) || (matcher2.group(8) != null)) // a-z
       {
        if (matcher1.group(8) == null)
         {
          result = -1;
         }
        else if (matcher2.group(8) == null)
         {
          result = 1;
         }
        else
         {
          result = matcher1.group(8).compareTo(matcher2.group(8));
         }
       }
     }
    return result;
   }

 }
