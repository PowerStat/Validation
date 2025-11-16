/*
 * Copyright (C) 2021-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Display aspect ratio.
 *
 * 1:1 2.1:1 3:1 3:2 4:3 5:3 5:4 8:5 9:5 10:6 15:9 16:9 16:10 17:10 25:12 25:16 60:29 64:35 72:35
 */
@SuppressWarnings({"PMD.ShortVariable"})
public final class DisplayAspectRatio implements Comparable<DisplayAspectRatio>, IValueObject
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<NTuple2<Integer, Integer>, DisplayAspectRatio> CACHE = new WeakHashMap<>();

  /**
   * Display x size (1-72).
   */
  private final int x;

  /**
   * Display y size (1-35).
   */
  private final int y;


  /**
   * Constructor.
   *
   * @param x Display x site (1-72)
   * @param y Display y size (1-35)
   */
  private DisplayAspectRatio(final int x, final int y)
   {
    super();
    if ((x <= 0) || (x > 72))
     {
      throw new IndexOutOfBoundsException("x out of range (1-72)"); //$NON-NLS-1$
     }
    if ((y <= 0) || (y > 35))
     {
      throw new IndexOutOfBoundsException("y out of range (1-35)"); //$NON-NLS-1$
     }
    // verify existing aspect ratios
    this.x = x;
    this.y = y;
   }


  /**
   * Display aspect ration factory.
   *
   * @param x Display x site (1-72)
   * @param y Display y size (1-35)
   * @return DisplayAspectRatio object
   */
  public static DisplayAspectRatio of(final int x, final int y)
   {
    /*
    final NTuple2<Integer, Integer> tuple = NTuple2.of(x, y);
    synchronized (DisplayAspectRatio.class)
     {
      DisplayAspectRatio obj = DisplayAspectRatio.CACHE.get(tuple);
      if (obj != null)
       {
        return obj;
       }
      obj = new DisplayAspectRatio(x, y);
      DisplayAspectRatio.CACHE.put(tuple, obj);
      return obj;
     }
    */
    return new DisplayAspectRatio(x, y);
   }


  /**
   * Display aspect ration factory.
   *
   * @param value String value of type x:y
   * @return DisplayAspectRatio object
   * @throws IllegalArgumentException If not of correct format
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public static DisplayAspectRatio of(final String value)
   {
    final String[] values = value.split(":");
    if (values.length != 2)
     {
      throw new IllegalArgumentException("Not of format x:y");
     }
    return of(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
   }


  /**
   * Get display x size.
   *
   * @return X size
   */
  public int getX()
   {
    return x;
   }


  /**
   * Get display y size.
   *
   * @return Y size
   */
  public int getY()
   {
    return y;
   }


  /**
   * Returns the value of this DisplayAspectRatio as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(x) + ':' + y;
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
    final int result = Integer.hashCode(x);
    return (31 * result) + Integer.hashCode(y);
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
    if (!(obj instanceof final DisplayAspectRatio other))
     {
      return false;
     }
    return (x == other.x) && (y == other.y);
   }


  /**
   * Returns the string representation of this DisplayAspectRatio.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "DisplayAspectRatio[x=1, y=1]"
   *
   * @return String representation of this DisplayAspectRatio
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(30);
    builder.append("DisplayAspectRatio[x=").append(x).append(", y=").append(y).append(']'); //$NON-NLS-1$ //$NON-NLS-2$
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
  public int compareTo(final DisplayAspectRatio obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = Integer.compare(x, obj.x);
    if (result == 0)
     {
      result = Integer.compare(y, obj.y);
     }
    return result;
   }

 }
