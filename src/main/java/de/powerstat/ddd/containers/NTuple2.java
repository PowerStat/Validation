/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.containers;


import java.util.Objects;

import org.checkerframework.checker.nullness.qual.Nullable;


/**
 * N-Tuple 2.
 *
 * @param <T1> Type 1
 * @param <T2> Type 2
 * @param obj1 Object 1 of type T1
 * @param obj2 Object 2 of Type T2
 */
@SuppressWarnings({"checkstyle:ClassTypeParameterName", "checkstyle:MethodTypeParameterName", "PMD.GenericsNaming"})
public record NTuple2<T1 extends Comparable<T1>, T2 extends Comparable<T2>>(T1 obj1, T2 obj2) implements Comparable<NTuple2<T1, T2>>
 {
  /**
   * Constructor.
   *
   * @param obj1 Object 1 of type T1
   * @param obj2 Object 2 of Type T2
   */
  public NTuple2
   {
    Objects.requireNonNull(obj1, "obj1 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj2, "obj2 is null"); //$NON-NLS-1$
   }


  /**
   * NTuple2 factory.
   *
   * @param <T1> Type 1
   * @param <T2> Type 2
   * @param obj1 Object 1 of type T1
   * @param obj2 Object 2 of Type T2
   * @return NTuple2 object
   */
  public static <T1 extends Comparable<T1>, T2 extends Comparable<T2>> NTuple2<T1, T2> of(final T1 obj1, final T2 obj2)
   {
    return new NTuple2<>(obj1, obj2);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final NTuple2<T1, T2> obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = obj1.compareTo(obj.obj1);
    if (result == 0)
     {
      result = obj2.compareTo(obj.obj2);
     }
    return result;
   }

 }
