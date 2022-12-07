/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;


/**
 * Address BFPONumber.
 *
 * Not DSGVO relevant.
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class BFPONumber implements Comparable<BFPONumber>
 {
  /**
   * Cache for singletons.
   */
  private static final Map<Integer, BFPONumber> CACHE = new WeakHashMap<>();

  /**
   * Deprecated since version 3.0 constant.
   */
  private static final String DEPRECATED_SINCE_3_0 = "3.0"; //$NON-NLS-1$

  /**
   * BFPONumber.
   */
  private final int bFPONumber;


  /**
   * Constructor.
   *
   * @param bFPONumber BFPONumber
   * @throws IndexOutOfBoundsException When the bFPONumber is out of bounds
   */
  private BFPONumber(final int bFPONumber)
   {
    super();
    if ((bFPONumber < 1) || (bFPONumber > 2035))
     {
      throw new IndexOutOfBoundsException("BFPONumber illegal value!!"); //$NON-NLS-1$
     }
    this.bFPONumber = bFPONumber;
   }


  /**
   * BFPONumber factory.
   *
   * @param bFPONumber BFPONumber
   * @return BFPONumber object
   */
  public static BFPONumber of(final int bFPONumber)
   {
    synchronized (BFPONumber.class)
     {
      BFPONumber obj = BFPONumber.CACHE.get(bFPONumber);
      if (obj != null)
       {
        return obj;
       }
      obj = new BFPONumber(bFPONumber);
      BFPONumber.CACHE.put(Integer.valueOf(bFPONumber), obj);
      return obj;
     }
   }


  /**
   * Get bFPONumber.
   *
   * @return BFPONumber
   * @deprecated Use intValue() instead.
   */
  @Deprecated(since = BFPONumber.DEPRECATED_SINCE_3_0, forRemoval = false)
  public int getBFPONumber()
   {
    return this.bFPONumber;
   }


  /**
   * Returns the value of this BFPONumber as an int.
   *
   * @return The numeric value represented by this object after conversion to type int.
   */
  public int intValue()
   {
    return this.bFPONumber;
   }


  /**
   * Get bFPONumber as string.
   *
   * @return BFPONumber as string
   * @deprecated Use stringValue() instead.
   */
  @Deprecated(since = BFPONumber.DEPRECATED_SINCE_3_0, forRemoval = false)
  public String getBFPONumberStr()
   {
    return Integer.toString(this.bFPONumber);
   }


  /**
   * Returns the value of this BFPONumber as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  public String stringValue()
   {
    return Integer.toString(this.bFPONumber);
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
    return Integer.hashCode(this.bFPONumber);
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
    return this == obj;
    /*
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof BFPONumber))
     {
      return false;
     }
    final BFPONumber other = (BFPONumber)obj;
    return false; // this.bFPONumber == other.bFPONumber;
    */
   }


  /**
   * Returns the string representation of this BFPONumber.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "BFPONumber[bFPONumber=2]"
   *
   * @return String representation of this BFPONumber
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(23);
    builder.append("BFPONumber[bFPONumber=").append(this.bFPONumber).append(']'); //$NON-NLS-1$
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
  public int compareTo(final BFPONumber obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(this.bFPONumber, obj.bFPONumber);
   }

 }

