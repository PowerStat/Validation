/*
 * Copyright (C) 2021 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Display aspect ratio.
 *
 * 1:1 2.1:1 3:1 3:2 4:3 5:3 5:4 8:5 9:5 10:6 15:9 16:9 16:10 17:10 25:12 25:16 60:29 64:35 72:35
 */
public final class DisplayAspectRatio implements Comparable<DisplayAspectRatio>
 {
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
  public DisplayAspectRatio(final int x, final int y)
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
    return new DisplayAspectRatio(x, y);
   }


  /**
   * Get display x size.
   *
   * @return X size
   */
  public int getX()
   {
    return this.x;
   }


  /**
   * Get display y size.
   *
   * @return Y size
   */
  public int getY()
   {
    return this.y;
   }


  /**
   * Get aspect ratio string (x:y).
   *
   * @return Aspect ration string (x:y)
   */
  public String getAspectRatio()
   {
    return String.valueOf(this.x) + ':' + this.y;
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
    final int result = Integer.hashCode(this.x);
    return (31 * result) + Integer.hashCode(this.y);
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
    if (!(obj instanceof DisplayAspectRatio))
     {
      return false;
     }
    final DisplayAspectRatio other = (DisplayAspectRatio)obj;
    if (this.x == other.x)
     {
      return this.y == other.y;
     }
    return false;
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
    final StringBuilder builder = new StringBuilder(30);
    builder.append("DisplayAspectRatio[x=").append(this.x).append(", y=").append(this.y).append(']'); //$NON-NLS-1$ //$NON-NLS-2$
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
    int result = Integer.compare(this.x, obj.x);
    if (result == 0)
     {
      result = Integer.compare(this.y, obj.y);
     }
    return result;
   }

 }