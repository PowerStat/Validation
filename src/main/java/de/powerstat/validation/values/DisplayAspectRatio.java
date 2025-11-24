/*
 * Copyright (C) 2021-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Display aspect ratio.
 *
 * @param x Display x site (1-72)
 * @param y Display y size (1-35)
 *
 * 1:1 2.1:1 3:1 3:2 4:3 5:3 5:4 8:5 9:5 10:6 15:9 16:9 16:10 17:10 25:12 25:16 60:29 64:35 72:35
 */
@SuppressWarnings({"PMD.ShortVariable"})
public record DisplayAspectRatio(int x, int y) implements Comparable<DisplayAspectRatio>, IValueObject
 {
  /**
   * Constructor.
   *
   * @param x Display x site (1-72)
   * @param y Display y size (1-35)
   * @throws IndexOutOfBoundsException When x or y is out of range
   */
  public DisplayAspectRatio
   {
    if ((x <= 0) || (x > 72))
     {
      throw new IndexOutOfBoundsException("x out of range (1-72)"); //$NON-NLS-1$
     }
    if ((y <= 0) || (y > 35))
     {
      throw new IndexOutOfBoundsException("y out of range (1-35)"); //$NON-NLS-1$
     }
    // verify existing aspect ratios
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
