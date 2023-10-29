/*
 * Copyright (C) 2022-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.containers;


import java.util.Objects;


/**
 * N-Tuple 2.
 *
 * @param <T1> Type 1
 * @param <T2> Type 2
 */
@SuppressWarnings({"checkstyle:ClassTypeParameterName", "checkstyle:MethodTypeParameterName", "PMD.GenericsNaming"})
public final class NTuple2<T1 extends Comparable<T1>, T2 extends Comparable<T2>> implements Comparable<NTuple2<T1, T2>>
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<?, NTuple2<T1 extends Comparable<T1>, T2 extends Comparable<T2>>> CACHE = new ConcurrentHashMap<>();

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
  private NTuple2(final T1 obj1, final T2 obj2)
   {
    super();
    Objects.requireNonNull(obj1, "obj1 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj2, "obj2 is null"); //$NON-NLS-1$
    this.object1 = obj1;
    this.object2 = obj2;
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
   * Returns the first value of this NTuple2 as a T1.
   *
   * @return The T1 value represented by this object.
   */
  public T1 t1Value()
   {
    return this.object1;
   }


  /**
   * Returns the second value of this NTuple2 as a T2.
   *
   * @return The T2 value represented by this object.
   */
  public T2 t2Value()
   {
    return this.object2;
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
    return Objects.hash(this.object1, this.object2);
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof NTuple2))
     {
      return false;
     }
    final NTuple2<T1, T2> other = (NTuple2<T1, T2>)obj;
    boolean result = this.object1.equals(other.object1);
    if (result)
     {
      result = this.object2.equals(other.object2);
     }
    return result;
   }


  /**
   * Returns the string representation of this NTuple2.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "NTuple2[object1=..., object2=...]"
   *
   * @return String representation of this NTuple2
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(27);
    builder.append("NTuple2[object1=").append(this.object1).append(", object2=").append(this.object2).append(']'); //$NON-NLS-1$ //$NON-NLS-2$
    return builder.toString();
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
    int result = this.object1.compareTo(obj.object1);
    if (result == 0)
     {
      result = this.object2.compareTo(obj.object2);
     }
    return result;
   }

 }
