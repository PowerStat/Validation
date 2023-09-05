/*
 * Copyright (C) 2021-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Screen size.
 *
 * @param width Screen width in pixel (1-8192)
 * @param height Screen height in pixel (1-8192)
 * @param name Screen size name
 */
public record ScreenSize(int width, int height, String name) implements Comparable<ScreenSize>, IValueObject
 {
  /**
   * Constructor.
   *
   * @param width Screen width in pixel (1-8192)
   * @param height Screen height in pixel (1-8192)
   * @param name Screen size name
   * @throws IndexOutOfBoundsException If width or height is out of range
   */
  public ScreenSize
   {
    if ((width < 1) || (width > 8192.0))
     {
      throw new IndexOutOfBoundsException("Width out of range (1-8192)"); //$NON-NLS-1$
     }
    if ((height < 1) || (height > 8192.0))
     {
      throw new IndexOutOfBoundsException("Height out of range (1-8192)"); //$NON-NLS-1$
     }
    Objects.requireNonNull(name);
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
   * Returns the value of this ScreenSize as a string.
   *
   * @return The text value represented by this object after conversion to type string format 320x200.
   */
  public String stringValue()
   {
    return String.valueOf(this.width) + 'x' + this.height;
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
