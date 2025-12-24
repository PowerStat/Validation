/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.containers;


import java.util.Objects;


/**
 * N-Tuple 5 not comparable.
 *
 * @param <T1> Type 1
 * @param <T2> Type 2
 * @param <T3> Type 3
 * @param <T4> Type 4
 * @param <T5> Type 5
 * @param obj1 Object 1 of type T1
 * @param obj2 Object 2 of Type T2
 * @param obj3 Object 3 of Type T3
 * @param obj4 Object 4 of Type T4
 * @param obj5 Object 5 of Type T5
 */
@SuppressWarnings({"checkstyle:ClassTypeParameterName", "checkstyle:MethodTypeParameterName", "checkstyle:NoWhitespaceBefore", "checkstyle:SeparatorWrap", "PMD.GenericsNaming"})
public record NTuple5nc<T1, T2, T3, T4, T5>(T1 obj1, T2 obj2, T3 obj3, T4 obj4, T5 obj5)
 {
  /**
   * Private constructor.
   *
   * @param obj1 Object 1 of type T1
   * @param obj2 Object 2 of Type T2
   * @param obj3 Object 3 of Type T3
   * @param obj4 Object 4 of Type T4
   * @param obj5 Object 5 of Type T5
   * @throws NullPointerException if one of obj1-5 is null
   */
  public NTuple5nc
   {
    Objects.requireNonNull(obj1, "obj1 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj2, "obj2 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj3, "obj3 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj4, "obj4 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj5, "obj5 is null"); //$NON-NLS-1$
   }


  /**
   * NTuple5nc factory.
   *
   * @param <T1> Type 1
   * @param <T2> Type 2
   * @param <T3> Type 3
   * @param <T4> Type 4
   * @param <T5> Type 5
   * @param obj1 Object 1 of type T1
   * @param obj2 Object 2 of Type T2
   * @param obj3 Object 3 of Type T3
   * @param obj4 Object 4 of Type T4
   * @param obj5 Object 5 of Type T5
   * @return NTuple5 object
   */
  public static <T1, T2, T3, T4, T5> NTuple5nc<T1, T2, T3, T4, T5> of(final T1 obj1, final T2 obj2, final T3 obj3, final T4 obj4, final T5 obj5)
   {
    return new NTuple5nc<>(obj1, obj2, obj3, obj4, obj5);
   }

 }
