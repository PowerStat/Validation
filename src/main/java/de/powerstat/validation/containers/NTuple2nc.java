/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.containers;


import java.util.Objects;

import org.checkerframework.checker.nullness.qual.Nullable;


/**
 * N-Tuple 2 not comparable.
 *
 * @param <T1> Type 1
 * @param <T2> Type 2
 */
@SuppressWarnings({"checkstyle:ClassTypeParameterName", "checkstyle:MethodTypeParameterName", "PMD.GenericsNaming"})
public final class NTuple2nc<T1, T2>
 {
  /**
   * Object1 of type T1.
   */
  private final T1 object1;

  /**
   * Object2 of type T2.
   */
  private final T2 object2;


  /**
   * Private constructor.
   *
   * @param obj1 Object 1 of type T1
   * @param obj2 Object 2 of Type T2
   */
  private NTuple2nc(final T1 obj1, final T2 obj2)
   {
    super();
    Objects.requireNonNull(obj1, "obj1 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj2, "obj2 is null"); //$NON-NLS-1$
    object1 = obj1;
    object2 = obj2;
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



  /**
   * Returns the first value of this NTuple2nc as a T1.
   *
   * @return The T1 value represented by this object.
   */
  public T1 t1Value()
   {
    return object1;
   }


  /**
   * Returns the second value of this NTuple2nc as a T2.
   *
   * @return The T2 value represented by this object.
   */
  public T2 t2Value()
   {
    return object2;
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
    return Objects.hash(object1, object2);
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final @Nullable Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof NTuple2nc))
     {
      return false;
     }
    final NTuple2nc<T1, T2> other = (NTuple2nc<T1, T2>)obj;
    boolean result = object1.equals(other.object1);
    if (result)
     {
      result = object2.equals(other.object2);
     }
    return result;
   }


  /**
   * Returns the string representation of this NTuple2nc.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "NTuple2nc[object1=..., object2=...]"
   *
   * @return String representation of this NTuple2nc
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(27);
    builder.append("NTuple2nc[object1=").append(object1).append(", object2=").append(object2).append(']'); //$NON-NLS-1$ //$NON-NLS-2$
    return builder.toString();
   }

 }
