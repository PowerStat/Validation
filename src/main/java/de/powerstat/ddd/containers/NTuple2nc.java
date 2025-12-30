/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.containers;


import java.util.Objects;


/**
 * N-Tuple 2 not comparable.
 *
 * @param <T1> Type 1
 * @param <T2> Type 2
 * @param obj1 Object 1 of type T1
 * @param obj2 Object 2 of Type T2
 */
@SuppressWarnings({"checkstyle:ClassTypeParameterName", "checkstyle:MethodTypeParameterName", "PMD.GenericsNaming"})
public record NTuple2nc<T1, T2>(T1 obj1, T2 obj2)
 {
  /**
   * Constructor.
   *
   * @param obj1 Object 1 of type T1
   * @param obj2 Object 2 of Type T2
   * @throws NullPointerException if obj1 or obj2 is null
   */
  public NTuple2nc
   {
    Objects.requireNonNull(obj1, "obj1 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj2, "obj2 is null"); //$NON-NLS-1$
   }


  /**
   * NTuple2nc factory.
   *
   * @param <T1> Type 1
   * @param <T2> Type 2
   * @param obj1 Object 1 of type T1
   * @param obj2 Object 2 of Type T2
   * @return NTuple2 object
   */
  public static <T1, T2> NTuple2nc<T1, T2> of(final T1 obj1, final T2 obj2)
   {
    return new NTuple2nc<>(obj1, obj2);
   }

 }
