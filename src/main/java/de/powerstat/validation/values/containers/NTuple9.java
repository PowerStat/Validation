/*
 * Copyright (C) 2022-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.containers;


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
 */
@SuppressWarnings({"checkstyle:ClassTypeParameterName", "checkstyle:MethodTypeParameterName", "checkstyle:NoWhitespaceBefore", "checkstyle:SeparatorWrap", "PMD.GenericsNaming"})
public final class NTuple9<T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>, T4 extends Comparable<T4>, T5 extends Comparable<T5>, T6 extends Comparable<T6>, T7 extends Comparable<T7>, T8 extends Comparable<T8>, T9 extends Comparable<T9>> implements Comparable<NTuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>>
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<?, NTuple3<T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>>> CACHE = new ConcurrentHashMap<>();

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
   * Object5 of type T5.
   */
  private final T5 object5;

  /**
   * Object6 of type T6.
   */
  private final T6 object6;

  /**
   * Object7 of type T7.
   */
  private final T7 object7;

  /**
   * Object8 of type T8.
   */
  private final T8 object8;

  /**
   * Object9 of type T9.
   */
  private final T9 object9;


  /**
   * Private constructor.
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
  private NTuple9(final T1 obj1, final T2 obj2, final T3 obj3, final T4 obj4, final T5 obj5, final T6 obj6, final T7 obj7, final T8 obj8, final T9 obj9)
   {
    super();
    Objects.requireNonNull(obj1, "obj1 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj2, "obj2 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj3, "obj3 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj4, "obj4 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj5, "obj5 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj6, "obj6 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj7, "obj7 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj8, "obj8 is null"); //$NON-NLS-1$
    Objects.requireNonNull(obj9, "obj9 is null"); //$NON-NLS-1$
    this.object1 = obj1;
    this.object2 = obj2;
    this.object3 = obj3;
    this.object4 = obj4;
    this.object5 = obj5;
    this.object6 = obj6;
    this.object7 = obj7;
    this.object8 = obj8;
    this.object9 = obj9;
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
   * Returns the first value of this NTuple9 as a T1.
   *
   * @return The T1 value represented by this object.
   */
  public T1 t1Value()
   {
    return this.object1;
   }


  /**
   * Returns the second value of this NTuple9 as a T2.
   *
   * @return The T2 value represented by this object.
   */
  public T2 t2Value()
   {
    return this.object2;
   }


  /**
   * Returns the second value of this NTuple9 as a T3.
   *
   * @return The T3 value represented by this object.
   */
  public T3 t3Value()
   {
    return this.object3;
   }


  /**
   * Returns the second value of this NTuple9 as a T4.
   *
   * @return The T4 value represented by this object.
   */
  public T4 t4Value()
   {
    return this.object4;
   }


  /**
   * Returns the second value of this NTuple9 as a T5.
   *
   * @return The T5 value represented by this object.
   */
  public T5 t5Value()
   {
    return this.object5;
   }


  /**
   * Returns the second value of this NTuple9 as a T6.
   *
   * @return The T6 value represented by this object.
   */
  public T6 t6Value()
   {
    return this.object6;
   }


  /**
   * Returns the second value of this NTuple9 as a T7.
   *
   * @return The T7 value represented by this object.
   */
  public T7 t7Value()
   {
    return this.object7;
   }


  /**
   * Returns the second value of this NTuple9 as a T8.
   *
   * @return The T8 value represented by this object.
   */
  public T8 t8Value()
   {
    return this.object8;
   }


  /**
   * Returns the second value of this NTuple9 as a T9.
   *
   * @return The T9 value represented by this object.
   */
  public T9 t9Value()
   {
    return this.object9;
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
    return Objects.hash(this.object1, this.object2, this.object3, this.object4, this.object5, this.object6, this.object7, this.object8, this.object9);
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
    if (!(obj instanceof NTuple9))
     {
      return false;
     }
    final NTuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> other = (NTuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9>)obj;
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
          if (result)
           {
            result = this.object5.equals(other.object5);
            if (result)
             {
              result = this.object6.equals(other.object6);
              if (result)
               {
                result = this.object7.equals(other.object7);
                if (result)
                 {
                  result = this.object8.equals(other.object8);
                  if (result)
                   {
                    result = this.object9.equals(other.object9);
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


  /**
   * Returns the string representation of this NTuple9.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "NTuple9[object1=..., object2=..., object3=..., object34=..., object5=..., object6=..., object7=..., object8=..., object9=...]"
   *
   * @return String representation of this NTuple9
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(97);
    builder.append("NTuple9[object1=").append(this.object1) //$NON-NLS-1$
      .append(", object2=").append(this.object2) //$NON-NLS-1$
      .append(", object3=").append(this.object3) //$NON-NLS-1$
      .append(", object4=").append(this.object4) //$NON-NLS-1$
      .append(", object5=").append(this.object5) //$NON-NLS-1$
      .append(", object6=").append(this.object6) //$NON-NLS-1$
      .append(", object7=").append(this.object7) //$NON-NLS-1$
      .append(", object8=").append(this.object8) //$NON-NLS-1$
      .append(", object9=").append(this.object9) //$NON-NLS-1$
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
  public int compareTo(final NTuple9<T1, T2, T3, T4, T5, T6, T7, T8, T9> obj)
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
          if (result == 0)
           {
            result = this.object5.compareTo(obj.object5);
            if (result == 0)
             {
              result = this.object6.compareTo(obj.object6);
              if (result == 0)
               {
                result = this.object7.compareTo(obj.object7);
                if (result == 0)
                 {
                  result = this.object8.compareTo(obj.object8);
                  if (result == 0)
                   {
                    result = this.object9.compareTo(obj.object9);
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
