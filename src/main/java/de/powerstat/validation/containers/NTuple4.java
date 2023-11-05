/*
 * Copyright (C) 2022-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.containers;


import java.util.Objects;


/**
 * N-Tuple 4.
 *
 * @param <T1> Type 1
 * @param <T2> Type 2
 * @param <T3> Type 3
 * @param <T4> Type 4
 */
@SuppressWarnings({"checkstyle:ClassTypeParameterName", "checkstyle:MethodTypeParameterName", "checkstyle:NoWhitespaceBefore", "checkstyle:SeparatorWrap", "PMD.GenericsNaming"})
public final class NTuple4<T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>, T4 extends Comparable<T4>> implements Comparable<NTuple4<T1, T2, T3, T4>>
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<?, NTuple4<T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>, T4 extends Comparable<T4>>> CACHE = new ConcurrentHashMap<>();

  /**
   * Object1 of type T1.
   */
  private final T1 object1;

  /**
   * Object2 of type T2.
   */
  private final T2 object2;

  /**
   * Object3 of type T3.
   */
  private final T3 object3;

  /**
   * Object4 of type T4.
   */
  private final T4 object4;


  /**
   * Private constructor.
   *
   * @param obj1 Object 1 of type T1
   * @param obj2 Object 2 of Type T2
   * @param obj3 Object 3 of Type T3
   * @param obj4 Object 4 of Type T4
   */
  private NTuple4(final T1 obj1, final T2 obj2, final T3 obj3, final T4 obj4)
   {
    super();
    Objects.requireNonNull(obj1, "obj1 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj2, "obj2 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj3, "obj3 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj4, "obj4 is null"); //$NON-NLS-1$
    this.object1 = obj1;
    this.object2 = obj2;
    this.object3 = obj3;
    this.object4 = obj4;
   }


  /**
   * NTuple3 factory.
   *
   * @param <T1> Type 1
   * @param <T2> Type 2
   * @param <T3> Type 3
   * @param <T4> Type 4
   * @param obj1 Object 1 of type T1
   * @param obj2 Object 2 of Type T2
   * @param obj3 Object 3 of Type T3
   * @param obj4 Object 4 of Type T4
   * @return NTuple4 object
   */
  public static <T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>, T4 extends Comparable<T4>> NTuple4<T1, T2, T3, T4> of(final T1 obj1, final T2 obj2, final T3 obj3, final T4 obj4)
   {
    return new NTuple4<>(obj1, obj2, obj3, obj4);
   }



  /**
   * Returns the first value of this NTuple4 as a T1.
   *
   * @return The T1 value represented by this object.
   */
  public T1 t1Value()
   {
    return this.object1;
   }


  /**
   * Returns the second value of this NTuple4 as a T2.
   *
   * @return The T2 value represented by this object.
   */
  public T2 t2Value()
   {
    return this.object2;
   }


  /**
   * Returns the second value of this NTuple4 as a T3.
   *
   * @return The T3 value represented by this object.
   */
  public T3 t3Value()
   {
    return this.object3;
   }


  /**
   * Returns the second value of this NTuple4 as a T4.
   *
   * @return The T4 value represented by this object.
   */
  public T4 t4Value()
   {
    return this.object4;
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
    return Objects.hash(this.object1, this.object2, this.object3, this.object4);
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
    if (!(obj instanceof NTuple4))
     {
      return false;
     }
    final NTuple4<T1, T2, T3, T4> other = (NTuple4<T1, T2, T3, T4>)obj;
    boolean result = this.object1.equals(other.object1);
    if (result)
     {
      result = this.object2.equals(other.object2);
      if (result)
       {
        result = this.object3.equals(other.object3);
        if (result)
         {
          result = this.object4.equals(other.object4);
         }
       }
     }
    return result;
   }


  /**
   * Returns the string representation of this NTuple4.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "NTuple4[object1=..., object2=..., object3=..., object4=...]"
   *
   * @return String representation of this NTuple4
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(47);
    builder.append("NTuple4[object1=").append(this.object1) //$NON-NLS-1$
      .append(", object2=").append(this.object2) //$NON-NLS-1$
      .append(", object3=").append(this.object3) //$NON-NLS-1$
      .append(", object4=").append(this.object4) //$NON-NLS-1$
      .append(']');
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
  public int compareTo(final NTuple4<T1, T2, T3, T4> obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = this.object1.compareTo(obj.object1);
    if (result == 0)
     {
      result = this.object2.compareTo(obj.object2);
      if (result == 0)
       {
        result = this.object3.compareTo(obj.object3);
        if (result == 0)
         {
          result = this.object4.compareTo(obj.object4);
         }
       }
     }
    return result;
   }

 }
