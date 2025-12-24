/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.containers;


import java.util.Objects;


/**
 * N-Tuple 9.
 *
 * @param <T1> Type 1
 * @param <T2> Type 2
 * @param <T3> Type 3
 * @param <T4> Type 4
 * @param <T5> Type 5
 * @param <T6> Type 6
 * @param <T7> Type 7
 * @param <T8> Type 8
 * @param <T9> Type 9
 * @param obj1 Object 1 of type T1
 * @param obj2 Object 2 of Type T2
 * @param obj3 Object 3 of Type T3
 * @param obj4 Object 4 of type T4
 * @param obj5 Object 5 of Type T5
 * @param obj6 Object 6 of Type T6
 * @param obj7 Object 7 of type T7
 * @param obj8 Object 8 of Type T8
 * @param obj9 Object 9 of Type T9
 */
@SuppressWarnings({"checkstyle:ClassTypeParameterName", "checkstyle:MethodTypeParameterName", "checkstyle:NoWhitespaceBefore", "checkstyle:SeparatorWrap", "PMD.GenericsNaming"})
public record NTuple9<T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>, T4 extends Comparable<T4>, T5 extends Comparable<T5>, T6 extends Comparable<T6>, T7 extends Comparable<T7>, T8 extends Comparable<T8>, T9 extends Comparable<T9>>(T1 obj1, T2 obj2, T3 obj3, T4 obj4, T5 obj5, T6 obj6, T7 obj7, T8 obj8, T9 obj9) implements Comparable<NTuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>
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
   */
  public NTuple9
   {
    Objects.requireNonNull(obj1, "obj1 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj2, "obj2 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj3, "obj3 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj4, "obj4 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj5, "obj5 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj6, "obj6 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj7, "obj7 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj8, "obj8 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj9, "obj9 is null"); //$NON-NLS-1$
   }


  /**
   * NTuple9 factory.
   *
   * @param <T1> Type 1
   * @param <T2> Type 2
   * @param <T3> Type 3
   * @param <T4> Type 4
   * @param <T5> Type 5
   * @param <T6> Type 6
   * @param <T7> Type 7
   * @param <T8> Type 8
   * @param <T9> Type 9
   * @param obj1 Object 1 of type T1
   * @param obj2 Object 2 of Type T2
   * @param obj3 Object 3 of Type T3
   * @param obj4 Object 1 of type T4
   * @param obj5 Object 2 of Type T5
   * @param obj6 Object 3 of Type T6
   * @param obj7 Object 1 of type T7
   * @param obj8 Object 2 of Type T8
   * @param obj9 Object 3 of Type T9
   * @return NTuple9 object
   */
  public static <T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>, T4 extends Comparable<T4>, T5 extends Comparable<T5>, T6 extends Comparable<T6>, T7 extends Comparable<T7>, T8 extends Comparable<T8>, T9 extends Comparable<T9>> NTuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> of(final T1 obj1, final T2 obj2, final T3 obj3, final T4 obj4, final T5 obj5, final T6 obj6, final T7 obj7, final T8 obj8, final T9 obj9)
   {
    return new NTuple9<>(obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final NTuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = obj1.compareTo(obj.obj1);
    if (result == 0)
     {
      result = obj2.compareTo(obj.obj2);
      if (result == 0)
       {
        result = obj3.compareTo(obj.obj3);
        if (result == 0)
         {
          result = obj4.compareTo(obj.obj4);
          if (result == 0)
           {
            result = obj5.compareTo(obj.obj5);
            if (result == 0)
             {
              result = obj6.compareTo(obj.obj6);
              if (result == 0)
               {
                result = obj7.compareTo(obj.obj7);
                if (result == 0)
                 {
                  result = obj8.compareTo(obj.obj8);
                  if (result == 0)
                   {
                    result = obj9.compareTo(obj.obj9);
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
