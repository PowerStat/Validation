/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.containers;


import java.util.Objects;

import org.checkerframework.checker.nullness.qual.Nullable;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * N-Tuple 15.
 *
 * @param <T1> Type 1
 * @param <T2> Type 2 optional
 * @param <T3> Type 3 optional
 * @param <T4> Type 4 optional
 * @param <T5> Type 5 optional
 * @param <T6> Type 6 optional
 * @param <T7> Type 7 optional
 * @param <T8> Type 8 optional
 * @param <T9> Type 9 optional
 * @param <T10> Type 10 optional
 * @param <T11> Type 11 optional
 * @param <T12> Type 12 optional
 * @param <T13> Type 13 optional
 * @param <T14> Type 14 optional
 * @param <T15> Type 15 optional
 * @param obj1 Object 1 of type T1
 * @param obj2 Object 2 of Type T2
 * @param obj3 Object 3 of Type T3
 * @param obj4 Object 4 of type T4
 * @param obj5 Object 5 of Type T5
 * @param obj6 Object 6 of Type T6
 * @param obj7 Object 7 of type T7
 * @param obj8 Object 8 of Type T8
 * @param obj9 Object 9 of Type T9
 * @param obj10 Object 10 of Type T10
 * @param obj11 Object 11 of Type T11
 * @param obj12 Object 12 of Type T12
 * @param obj13 Object 13 of Type T13
 * @param obj14 Object 14 of Type T14
 * @param obj15 Object 15 of Type T15
 */
// @SuppressFBWarnings("CC_CYCLOMATIC_COMPLEXITY")
@SuppressWarnings({"checkstyle:ClassTypeParameterName", "checkstyle:MethodTypeParameterName", "checkstyle:NoWhitespaceBefore", "checkstyle:SeparatorWrap", "PMD.GenericsNaming", "PMD.CommentSize", "PMD.CouplingBetweenObjects", "java:S3776", "java:S1541"})
public record NTuple15<T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>, T4 extends Comparable<T4>, T5 extends Comparable<T5>, T6 extends Comparable<T6>, T7 extends Comparable<T7>, T8 extends Comparable<T8>, T9 extends Comparable<T9>, T10 extends Comparable<T10>, T11 extends Comparable<T11>, T12 extends Comparable<T12>, T13 extends Comparable<T13>, T14 extends Comparable<T14>, T15 extends Comparable<T15>>(T1 obj1, T2 obj2, T3 obj3, T4 obj4, T5 obj5, T6 obj6, T7 obj7, T8 obj8, T9 obj9, T10 obj10, T11 obj11, T12 obj12, T13 obj13, T14 obj14, T15 obj15) implements Comparable<NTuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15>>
 {
  /**
   * Constructor.
   *
   * @param obj1 Object 1 of type T1
   * @param obj2 Object 2 of Type T2
   * @param obj3 Object 3 of Type T3
   * @param obj4 Object 4 of type T4
   * @param obj5 Object 5 of Type T5
   * @param obj6 Object 6 of Type T6
   * @param obj7 Object 7 of type T7
   * @param obj8 Object 8 of Type T8
   * @param obj9 Object 9 of Type T9
   * @param obj10 Object 10 of Type T10
   * @param obj11 Object 11 of Type T11
   * @param obj12 Object 12 of Type T12
   * @param obj13 Object 13 of Type T13
   * @param obj14 Object 14 of Type T14
   * @param obj15 Object 15 of Type T15
   */
  public NTuple15
   {
    Objects.requireNonNull(obj1, "obj1 is null"); //$NON-NLS-1$
    /*
    Objects.requireNonNull(obj2, "obj2 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj3, "obj3 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj4, "obj4 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj5, "obj5 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj6, "obj6 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj7, "obj7 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj8, "obj8 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj9, "obj9 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj10, "obj10 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj11, "obj11 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj12, "obj12 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj13, "obj13 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj14, "obj14 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj15, "obj15 is null"); //$NON-NLS-1$
    */
   }


  /**
   * NTuple15 factory.
   *
   * @param <T1> Type 1
   * @param <T2> Type 2 optional
   * @param <T3> Type 3 optional
   * @param <T4> Type 4 optional
   * @param <T5> Type 5 optional
   * @param <T6> Type 6 optional
   * @param <T7> Type 7 optional
   * @param <T8> Type 8 optional
   * @param <T9> Type 9 optional
   * @param <T10> Type 10 optional
   * @param <T11> Type 11 optional
   * @param <T12> Type 12 optional
   * @param <T13> Type 13 optional
   * @param <T14> Type 14 optional
   * @param <T15> Type 15 optional
   * @param obj1 Object 1 of type T1
   * @param obj2 Object 2 of Type T2 optional
   * @param obj3 Object 3 of Type T3 optional
   * @param obj4 Object 1 of type T4 optional
   * @param obj5 Object 2 of Type T5 optional
   * @param obj6 Object 3 of Type T6 optional
   * @param obj7 Object 1 of type T7 optional
   * @param obj8 Object 2 of Type T8 optional
   * @param obj9 Object 3 of Type T9 optional
   * @param obj10 Object 10 of Type T10 optional
   * @param obj11 Object 11 of Type T11 optional
   * @param obj12 Object 12 of Type T12 optional
   * @param obj13 Object 13 of Type T13 optional
   * @param obj14 Object 14 of Type T14 optional
   * @param obj15 Object 15 of Type T15 optional
   * @return NTuple15 object
   */
  public static <T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>, T4 extends Comparable<T4>, T5 extends Comparable<T5>, T6 extends Comparable<T6>, T7 extends Comparable<T7>, T8 extends Comparable<T8>, T9 extends Comparable<T9>, T10 extends Comparable<T10>, T11 extends Comparable<T11>, T12 extends Comparable<T12>, T13 extends Comparable<T13>, T14 extends Comparable<T14>, T15 extends Comparable<T15>> NTuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> of(final T1 obj1, final T2 obj2, final T3 obj3, final T4 obj4, final T5 obj5, final T6 obj6, final T7 obj7, final T8 obj8, final T9 obj9, final T10 obj10, final T11 obj11, final T12 obj12, final T13 obj13, final T14 obj14, final T15 obj15)
   {
    return new NTuple15<>(obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @SuppressFBWarnings("CC_CYCLOMATIC_COMPLEXITY")
  @SuppressWarnings({"PMD.CyclomaticComplexity", "PMD.NPathComplexity"})
  @Override
  public int compareTo(final NTuple15<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15> obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = obj1.compareTo(obj.obj1);
    if (result == 0)
     {
      result = (obj2 == null) ? ((obj.obj2 == null) ? 0 : -1) : ((obj.obj2 == null) ? 1 : obj2.compareTo(obj.obj2));
      if (result == 0)
       {
        result = (obj3 == null) ? ((obj.obj3 == null) ? 0 : -1) : ((obj.obj3 == null) ? 1 : obj3.compareTo(obj.obj3));
        if (result == 0)
         {
          result = (obj4 == null) ? ((obj.obj4 == null) ? 0 : -1) : ((obj.obj4 == null) ? 1 : obj4.compareTo(obj.obj4));
          if (result == 0)
           {
            result = (obj5 == null) ? ((obj.obj5 == null) ? 0 : -1) : ((obj.obj5 == null) ? 1 : obj5.compareTo(obj.obj5));
            if (result == 0)
             {
              result = (obj6 == null) ? ((obj.obj6 == null) ? 0 : -1) : ((obj.obj6 == null) ? 1 : obj6.compareTo(obj.obj6));
              if (result == 0)
               {
                result = (obj7 == null) ? ((obj.obj7 == null) ? 0 : -1) : ((obj.obj7 == null) ? 1 : obj7.compareTo(obj.obj7));
                if (result == 0)
                 {
                  result = (obj8 == null) ? ((obj.obj8 == null) ? 0 : -1) : ((obj.obj8 == null) ? 1 : obj8.compareTo(obj.obj8));
                  if (result == 0)
                   {
                    result = (obj9 == null) ? ((obj.obj9 == null) ? 0 : -1) : ((obj.obj9 == null) ? 1 : obj9.compareTo(obj.obj9));
                    if (result == 0)
                     {
                      result = (obj10 == null) ? ((obj.obj10 == null) ? 0 : -1) : ((obj.obj10 == null) ? 1 : obj10.compareTo(obj.obj10));
                      if (result == 0)
                       {
                        result = (obj11 == null) ? ((obj.obj11 == null) ? 0 : -1) : ((obj.obj11 == null) ? 1 : obj11.compareTo(obj.obj11));
                        if (result == 0)
                         {
                          result = (obj12 == null) ? ((obj.obj12 == null) ? 0 : -1) : ((obj.obj12 == null) ? 1 : obj12.compareTo(obj.obj12));
                          if (result == 0)
                           {
                            result = (obj13 == null) ? ((obj.obj13 == null) ? 0 : -1) : ((obj.obj13 == null) ? 1 : obj13.compareTo(obj.obj13));
                            if (result == 0)
                             {
                              result = (obj14 == null) ? ((obj.obj14 == null) ? 0 : -1) : ((obj.obj14 == null) ? 1 : obj14.compareTo(obj.obj14));
                              if (result == 0)
                               {
                                result = (obj15 == null) ? ((obj.obj15 == null) ? 0 : -1) : ((obj.obj15 == null) ? 1 : obj15.compareTo(obj.obj15));
                               }
                             }
                           }
                         }
                       }
                     }
                   }
                 }
               }
             }
           }
         }
       }
     }
    return result;
   }

 }
