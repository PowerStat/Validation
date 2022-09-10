/*
 * Copyright (C) 2021 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Screen size.
 */
public final class ScreenSize implements Comparable<ScreenSize>
 {
  /**
   * Screen width (1-8192).
   */
  private final int width;

  /**
   * Screen height (1-8192).
   */
  private final int height;

  /**
   * Screen size name.
   */
  private final String name;


  /**
   * Constructor.
   *
   * @param width Screen width in pixel (1-8192)
   * @param height Screen height in pixel (1-8192)
   * @param name Screen size name
   */
  public ScreenSize(final int width, final int height, final String name)
   {
    super();
    if ((width < 1) || (width > 8192.0))
     {
      throw new IndexOutOfBoundsException("Width out of range (1-8192)"); //$NON-NLS-1$
     }
    if ((height < 1) || (height > 8192.0))
     {
      throw new IndexOutOfBoundsException("Height out of range (1-8192)"); //$NON-NLS-1$
     }
    Objects.requireNonNull(name);
    this.width = width;
    this.height = height;
    this.name = name;
   }


  /**
   * ScreenSize factory.
   *
   * @param width Screen width in pixel (1-8192)
   * @param height Screen heightin pixel (1-8192)
   * @param name Screen size name
   * @return ScreenSize
   */
  public static ScreenSize of(final int width, final int height, final String name)
   {
    return new ScreenSize(width, height, name);
   }


  /**
   * Get screen width.
   *
   * @return Screen width in pixel
   */
  public int getWidth()
   {
    return this.width;
   }


  /**
   * Get screen height.
   *
   * @return Screen height in pixel
   */
  public int getHeight()
   {
    return this.height;
   }


  /**
   * Get size string.
   *
   * @return Size string format 1x1
   */
  public String getSize()
   {
    return String.valueOf(this.width) + 'x' + this.height;
   }


  /**
   * Get screen size name.
   *
   * @return Screen size name
   */
  public String getName()
   {
    return this.name;
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
    int result = Integer.hashCode(this.width);
    result = (31 * result) + Integer.hashCode(this.height);
    return (31 * result) + this.name.hashCode();
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
    if (!(obj instanceof ScreenSize))
     {
      return false;
     }
    final ScreenSize other = (ScreenSize)obj;
    if ((this.width == other.width) && (this.height == other.height))
     {
      return this.name.equals(other.name);
     }
    return false;
   }


  /**
   * Returns the string representation of this ScreenSize.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "ScreenSize[width=320, height=200, name=QVGA]"
   *
   * @return String representation of this ScreenSize
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(47);
    builder.append("ScreenSize[width=").append(this.width).append(", height=").append(this.height).append(", name=").append(this.name).append(']'); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
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
  public int compareTo(final ScreenSize obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = Integer.compare(this.width, obj.width);
    if (result == 0)
     {
      result = Integer.compare(this.height, obj.height);
      if (result == 0)
       {
        result = this.name.compareTo(obj.name);
       }
     }
    return result;
   }

 }