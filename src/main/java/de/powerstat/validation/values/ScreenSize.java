/*
 * Copyright (C) 2021-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
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
 *
 * Not DSGVO relevant.
 *
 * TODO min, max
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
    if ((width < 1) || (width > 8192))
     {
      throw new IndexOutOfBoundsException("Width out of range (1-8192)"); //$NON-NLS-1$
     }
    if ((height < 1) || (height > 8192))
     {
      throw new IndexOutOfBoundsException("Height out of range (1-8192)"); //$NON-NLS-1$
     }
    Objects.requireNonNull(name);
   }


  /**
   * ScreenSize factory.
   *
   * @param width Screen width in pixel (1-8192)
   * @param height Screen height in pixel (1-8192)
   * @param name Screen size name
   * @return ScreenSize
   */
  public static ScreenSize of(final int width, final int height, final String name)
   {
    return new ScreenSize(width, height, name);
   }


  /**
   * ScreenSize factory.
   *
   * @param value width (1-8192) x height (1-8192)
   * @return ScreenSize
   */
  @SuppressWarnings("PMD.AvoidLiteralsInIfCondition")
  public static ScreenSize of(final String value)
   {
    final String[] values = value.split("x");
    if (values.length != 2)
     {
      throw new IllegalArgumentException("value not of expected format");
     }
    return of(Integer.parseInt(values[0]), Integer.parseInt(values[1]), "");
   }


  /**
   * Returns the value of this ScreenSize as a string.
   *
   * @return The text value represented by this object after conversion to type string format 320x200.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(width) + 'x' + height;
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
    int result = Integer.compare(width, obj.width);
    if (result == 0)
     {
      result = Integer.compare(height, obj.height);
      if (result == 0)
       {
        result = name.compareTo(obj.name);
       }
     }
    return result;
   }

 }
