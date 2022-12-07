/*
 * Copyright (C) 2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.containers;


import java.util.Objects;


/**
 * N-Tuple 16.
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
 * @param <T16> Type 16
 */
// @SuppressFBWarnings("CC_CYCLOMATIC_COMPLEXITY")
@SuppressWarnings({"checkstyle:ClassTypeParameterName", "checkstyle:MethodTypeParameterName", "checkstyle:NoWhitespaceBefore", "checkstyle:SeparatorWrap", "PMD.GenericsNaming", "PMD.CommentSize", "PMD.TooManyFields", "java:S3776", "java:S1541"})
public final class NTuple16<T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>, T4 extends Comparable<T4>, T5 extends Comparable<T5>, T6 extends Comparable<T6>, T7 extends Comparable<T7>, T8 extends Comparable<T8>, T9 extends Comparable<T9>, T10 extends Comparable<T10>, T11 extends Comparable<T11>, T12 extends Comparable<T12>, T13 extends Comparable<T13>, T14 extends Comparable<T14>, T15 extends Comparable<T15>, T16 extends Comparable<T16>> implements Comparable<NTuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>>
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<?, NTuple15<T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>, T4 extends Comparable<T4>, T5 extends Comparable<T5>, T6 extends Comparable<T6>, T7 extends Comparable<T7>, T8 extends Comparable<T8>, T9 extends Comparable<T9>, T10 extends Comparable<T10>, T11 extends Comparable<T11>, T12 extends Comparable<T12>, T13 extends Comparable<T13>, T14 extends Comparable<T14>, T15 extends Comparable<T15>, T16 extends Comparable<T16>>> CACHE = new ConcurrentHashMap<>();

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
   * Object10 of type T10.
   */
  private final T10 object10;

  /**
   * Object11 of type T11.
   */
  private final T11 object11;

  /**
   * Object12 of type T12.
   */
  private final T12 object12;

  /**
   * Object13 of type T13.
   */
  private final T13 object13;

  /**
   * Object14 of type T14.
   */
  private final T14 object14;

  /**
   * Object15 of type T15.
   */
  private final T15 object15;

  /**
   * Object16 of type T16.
   */
  private final T16 object16;


  /**
   * Private constructor.
   *
   * @param obj1 Object 1 of type T1
   * @param obj2 Object 2 of Type T2 optional
   * @param obj3 Object 3 of Type T3 optional
   * @param obj4 Object 4 of type T4 optional
   * @param obj5 Object 5 of Type T5 optional
   * @param obj6 Object 6 of Type T6 optional
   * @param obj7 Object 7 of type T7 optional
   * @param obj8 Object 8 of Type T8 optional
   * @param obj9 Object 9 of Type T9 optional
   * @param obj10 Object 10 of Type T10 optional
   * @param obj11 Object 11 of type T11 optional
   * @param obj12 Object 12 of Type T12 optional
   * @param obj13 Object 13 of Type T13 optional
   * @param obj14 Object 14 of type T14 optional
   * @param obj15 Object 15 of Type T15 optional
   * @param obj16 Object 16 of Type T16
   */
  private NTuple16(final T1 obj1, final T2 obj2, final T3 obj3, final T4 obj4, final T5 obj5, final T6 obj6, final T7 obj7, final T8 obj8, final T9 obj9, final T10 obj10, final T11 obj11, final T12 obj12, final T13 obj13, final T14 obj14, final T15 obj15, final T16 obj16)
   {
    super();
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
    Objects.requireNonNull(obj16, "obj16 is null"); //$NON-NLS-1$
    this.object1 = obj1;
    this.object2 = obj2;
    this.object3 = obj3;
    this.object4 = obj4;
    this.object5 = obj5;
    this.object6 = obj6;
    this.object7 = obj7;
    this.object8 = obj8;
    this.object9 = obj9;
    this.object10 = obj10;
    this.object11 = obj11;
    this.object12 = obj12;
    this.object13 = obj13;
    this.object14 = obj14;
    this.object15 = obj15;
    this.object16 = obj16;
   }


  /**
   * NTuple16 factory.
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
   * @param <T16> Type 16
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
   * @param obj16 Object 16 of Type T16
   * @return NTuple16 object
   */
  public static <T1 extends Comparable<T1>, T2 extends Comparable<T2>, T3 extends Comparable<T3>, T4 extends Comparable<T4>, T5 extends Comparable<T5>, T6 extends Comparable<T6>, T7 extends Comparable<T7>, T8 extends Comparable<T8>, T9 extends Comparable<T9>, T10 extends Comparable<T10>, T11 extends Comparable<T11>, T12 extends Comparable<T12>, T13 extends Comparable<T13>, T14 extends Comparable<T14>, T15 extends Comparable<T15>, T16 extends Comparable<T16>> NTuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> of(final T1 obj1, final T2 obj2, final T3 obj3, final T4 obj4, final T5 obj5, final T6 obj6, final T7 obj7, final T8 obj8, final T9 obj9, final T10 obj10, final T11 obj11, final T12 obj12, final T13 obj13, final T14 obj14, final T15 obj15, final T16 obj16)
   {
    return new NTuple16<>(obj1, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
   }



  /**
   * Returns the first value of this NTuple16 as a T1.
   *
   * @return The T1 value represented by this object.
   */
  public T1 t1Value()
   {
    return this.object1;
   }


  /**
   * Returns the second value of this NTuple16 as a T2.
   *
   * @return The T2 value represented by this object.
   */
  public T2 t2Value()
   {
    return this.object2;
   }


  /**
   * Returns the second value of this NTuple16 as a T3.
   *
   * @return The T3 value represented by this object.
   */
  public T3 t3Value()
   {
    return this.object3;
   }


  /**
   * Returns the second value of this NTuple16 as a T4.
   *
   * @return The T4 value represented by this object.
   */
  public T4 t4Value()
   {
    return this.object4;
   }


  /**
   * Returns the second value of this NTuple16 as a T5.
   *
   * @return The T5 value represented by this object.
   */
  public T5 t5Value()
   {
    return this.object5;
   }


  /**
   * Returns the second value of this NTuple16 as a T6.
   *
   * @return The T6 value represented by this object.
   */
  public T6 t6Value()
   {
    return this.object6;
   }


  /**
   * Returns the second value of this NTuple16 as a T7.
   *
   * @return The T7 value represented by this object.
   */
  public T7 t7Value()
   {
    return this.object7;
   }


  /**
   * Returns the second value of this NTuple16 as a T8.
   *
   * @return The T8 value represented by this object.
   */
  public T8 t8Value()
   {
    return this.object8;
   }


  /**
   * Returns the second value of this NTuple16 as a T9.
   *
   * @return The T9 value represented by this object.
   */
  public T9 t9Value()
   {
    return this.object9;
   }


  /**
   * Returns the second value of this NTuple16 as a T10.
   *
   * @return The T10 value represented by this object.
   */
  public T10 t10Value()
   {
    return this.object10;
   }


  /**
   * Returns the second value of this NTuple16 as a T11.
   *
   * @return The T11 value represented by this object.
   */
  public T11 t11Value()
   {
    return this.object11;
   }


  /**
   * Returns the second value of this NTuple16 as a T12.
   *
   * @return The T12 value represented by this object.
   */
  public T12 t12Value()
   {
    return this.object12;
   }


  /**
   * Returns the second value of this NTuple16 as a T13.
   *
   * @return The T13 value represented by this object.
   */
  public T13 t13Value()
   {
    return this.object13;
   }


  /**
   * Returns the second value of this NTuple16 as a T14.
   *
   * @return The T14 value represented by this object.
   */
  public T14 t14Value()
   {
    return this.object14;
   }


  /**
   * Returns the second value of this NTuple16 as a T15.
   *
   * @return The T15 value represented by this object.
   */
  public T15 t15Value()
   {
    return this.object15;
   }


  /**
   * Returns the second value of this NTuple16 as a T16.
   *
   * @return The T16 value represented by this object.
   */
  public T16 t16Value()
   {
    return this.object16;
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
    return Objects.hash(this.object1, this.object2, this.object3, this.object4, this.object5, this.object6, this.object7, this.object8, this.object9, this.object10, this.object11, this.object12, this.object13, this.object14, this.object15, this.object16);
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @SuppressWarnings("PMD.AvoidDeeplyNestedIfStmts")
  @Override
  public boolean equals(final Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof NTuple16))
     {
      return false;
     }
    final NTuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> other = (NTuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16>)obj;
    boolean result = this.object1.equals(other.object1);
    if (result)
     {
      result = (this.object2 == null) ? (other.object2 == null) : this.object2.equals(other.object2);
      if (result)
       {
        result = (this.object3 == null) ? (other.object3 == null) : this.object3.equals(other.object3);
        if (result)
         {
          result = (this.object4 == null) ? (other.object4 == null) : this.object4.equals(other.object4);
          if (result)
           {
            result = (this.object5 == null) ? (other.object5 == null) : this.object5.equals(other.object5);
            if (result)
             {
              result = (this.object6 == null) ? (other.object6 == null) : this.object6.equals(other.object6);
              if (result)
               {
                result = (this.object7 == null) ? (other.object7 == null) : this.object7.equals(other.object7);
                if (result)
                 {
                  result = (this.object8 == null) ? (other.object8 == null) : this.object8.equals(other.object8);
                  if (result)
                   {
                    result = (this.object9 == null) ? (other.object9 == null) : this.object9.equals(other.object9);
                    if (result)
                     {
                      result = (this.object10 == null) ? (other.object10 == null) : this.object10.equals(other.object10);
                      if (result)
                       {
                        result = (this.object11 == null) ? (other.object11 == null) : this.object11.equals(other.object11);
                        if (result)
                         {
                          result = (this.object12 == null) ? (other.object12 == null) : this.object12.equals(other.object12);
                          if (result)
                           {
                            result = (this.object13 == null) ? (other.object13 == null) : this.object13.equals(other.object13);
                            if (result)
                             {
                              result = (this.object14 == null) ? (other.object14 == null) : this.object14.equals(other.object14);
                              if (result)
                               {
                                result = (this.object15 == null) ? (other.object15 == null) : this.object15.equals(other.object15);
                                if (result)
                                 {
                                  result = this.object16.equals(other.object16);
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
     }
    return result;
   }


  /**
   * Returns the string representation of this NTuple16.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "NTuple16[object1=..., object2=..., object3=..., object34=..., object5=..., object6=..., object7=..., object8=..., object9=..., object10=..., object11=..., object12=..., object13=..., object14=..., object15=..., object16=...]"
   *
   * @return String representation of this NTuple15
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder(175);
    builder.append("NTuple16[object1=").append(this.object1) //$NON-NLS-1$
      .append(", object2=").append(this.object2) //$NON-NLS-1$
      .append(", object3=").append(this.object3) //$NON-NLS-1$
      .append(", object4=").append(this.object4) //$NON-NLS-1$
      .append(", object5=").append(this.object5) //$NON-NLS-1$
      .append(", object6=").append(this.object6) //$NON-NLS-1$
      .append(", object7=").append(this.object7) //$NON-NLS-1$
      .append(", object8=").append(this.object8) //$NON-NLS-1$
      .append(", object9=").append(this.object9) //$NON-NLS-1$
      .append(", object10=").append(this.object10) //$NON-NLS-1$
      .append(", object11=").append(this.object11) //$NON-NLS-1$
      .append(", object12=").append(this.object12) //$NON-NLS-1$
      .append(", object13=").append(this.object13) //$NON-NLS-1$
      .append(", object14=").append(this.object14) //$NON-NLS-1$
      .append(", object15=").append(this.object15) //$NON-NLS-1$
      .append(", object16=").append(this.object16) //$NON-NLS-1$
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
  @SuppressWarnings("PMD.AvoidDeeplyNestedIfStmts")
  @Override
  public int compareTo(final NTuple16<T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16> obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = this.object1.compareTo(obj.object1);
    if (result == 0)
     {
      result = (this.object2 == null) ? ((obj.object2 == null) ? 0 : -1) : ((obj.object2 == null) ? 1 : this.object2.compareTo(obj.object2));
      if (result == 0)
       {
        result = (this.object3 == null) ? ((obj.object3 == null) ? 0 : -1) : ((obj.object3 == null) ? 1 : this.object3.compareTo(obj.object3));
        if (result == 0)
         {
          result = (this.object4 == null) ? ((obj.object4 == null) ? 0 : -1) : ((obj.object4 == null) ? 1 : this.object4.compareTo(obj.object4));
          if (result == 0)
           {
            result = (this.object5 == null) ? ((obj.object5 == null) ? 0 : -1) : ((obj.object5 == null) ? 1 : this.object5.compareTo(obj.object5));
            if (result == 0)
             {
              result = (this.object6 == null) ? ((obj.object6 == null) ? 0 : -1) : ((obj.object6 == null) ? 1 : this.object6.compareTo(obj.object6));
              if (result == 0)
               {
                result = (this.object7 == null) ? ((obj.object7 == null) ? 0 : -1) : ((obj.object7 == null) ? 1 : this.object7.compareTo(obj.object7));
                if (result == 0)
                 {
                  result = (this.object8 == null) ? ((obj.object8 == null) ? 0 : -1) : ((obj.object8 == null) ? 1 : this.object8.compareTo(obj.object8));
                  if (result == 0)
                   {
                    result = (this.object9 == null) ? ((obj.object9 == null) ? 0 : -1) : ((obj.object9 == null) ? 1 : this.object9.compareTo(obj.object9));
                    if (result == 0)
                     {
                      result = (this.object10 == null) ? ((obj.object10 == null) ? 0 : -1) : ((obj.object10 == null) ? 1 : this.object10.compareTo(obj.object10));
                      if (result == 0)
                       {
                        result = (this.object11 == null) ? ((obj.object11 == null) ? 0 : -1) : ((obj.object11 == null) ? 1 : this.object11.compareTo(obj.object11));
                        if (result == 0)
                         {
                          result = (this.object12 == null) ? ((obj.object12 == null) ? 0 : -1) : ((obj.object12 == null) ? 1 : this.object12.compareTo(obj.object12));
                          if (result == 0)
                           {
                            result = (this.object13 == null) ? ((obj.object13 == null) ? 0 : -1) : ((obj.object13 == null) ? 1 : this.object13.compareTo(obj.object13));
                            if (result == 0)
                             {
                              result = (this.object14 == null) ? ((obj.object14 == null) ? 0 : -1) : ((obj.object14 == null) ? 1 : this.object14.compareTo(obj.object14));
                              if (result == 0)
                               {
                                result = (this.object15 == null) ? ((obj.object15 == null) ? 0 : -1) : ((obj.object15 == null) ? 1 : this.object15.compareTo(obj.object15));
                                if (result == 0)
                                 {
                                  result = this.object16.compareTo(obj.object16);
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
     }
    return result;
   }

 }
