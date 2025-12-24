/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.containers;


import java.util.Objects;


/**
 * N-Tuple 3.
 *
 * @param <T1> Type 1
 * @param <T2> Type 2
 * @param <T3> Type 3
 * @param obj1 Object 1 of type T1
 * @param obj2 Object 2 of Type T2
 * @param obj3 Object 3 of Type T3
 */
@SuppressWarnings({"checkstyle:ClassTypeParameterName", "checkstyle:MethodTypeParameterName", "PMD.GenericsNaming"})
public record NTuple3<T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>>(T1 obj1, T2 obj2, T3 obj3) implements Comparable<NTuple3<T1, T2, T3>>
 {
  /**
   * Constructor.
   *
   * @param obj1 Object 1 of type T1
   * @param obj2 Object 2 of Type T2
   * @param obj3 Object 3 of Type T3
   */
  public NTuple3
   {
    Objects.requireNonNull(obj1, "obj1 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj2, "obj2 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj3, "obj3 is null"); //$NON-NLS-1$
   }


  /**
   * NTuple3 factory.
   *
   * @param <T1> Type 1
   * @param <T2> Type 2
   * @param <T3> Type 3
   * @param obj1 Object 1 of type T1
   * @param obj2 Object 2 of Type T2
   * @param obj3 Object 3 of Type T3
   * @return NTuple3 object
   */
  public static <T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>> NTuple3<T1, T2, T3> of(final T1 obj1, final T2 obj2, final T3 obj3)
   {
    return new NTuple3<>(obj1, obj2, obj3);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final NTuple3<T1, T2, T3> obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = obj1.compareTo(obj.obj1);
    if (result == 0)
     {
      result = obj2.compareTo(obj.obj2);
      if (result == 0)
       {
        result = obj3.compareTo(obj.obj3);
       }
     }
    return result;
   }

 }
