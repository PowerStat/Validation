/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address Department.
 *
 * Not DSGVO relevant.
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings({"java:S5869", "PMD.UseConcurrentHashMap"})
public final class Department implements Comparable<Department>, IValueObject
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<String, Department> CACHE = new WeakHashMap<>();

  /**
   * Department regexp.
   */
  private static final Pattern DEPARTMENT_REGEXP = Pattern.compile("^[\\p{L}][\\p{L}\\\\p{Digi}.& -]*$"); //$NON-NLS-1$

  /**
   * Department.
   */
  private final String department;


  /**
   * Constructor.
   *
   * @param department Department name
   * @throws NullPointerException if department is null
   * @throws IllegalArgumentException if department is not a correct department name
   */
  private Department(final String department)
   {
    super();
    Objects.requireNonNull(department, "department"); //$NON-NLS-1$
    if ((department.length() < 1) || (department.length() > 64))
     {
      throw new IllegalArgumentException("Department with wrong length"); //$NON-NLS-1$
     }
    if (!Department.DEPARTMENT_REGEXP.matcher(department).matches())
     {
      throw new IllegalArgumentException("Department with wrong format"); //$NON-NLS-1$
     }
    this.department = department;
   }


  /**
   * Department factory.
   *
   * @param department Department name
   * @return Department object
   */
  public static Department of(final String department)
   {
    /*
    synchronized (Department.class)
     {
      Department obj = Department.CACHE.get(department);
      if (obj != null)
       {
        return obj;
       }
      obj = new Department(department);
      Department.CACHE.put(department, obj);
      return obj;
     }
    */
    return new Department(department);
   }


  /**
   * Returns the value of this Department as a string.
   *
   * @return he text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.department;
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
    return this.department.hashCode();
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
    if (!(obj instanceof Department))
     {
      return false;
     }
    final Department other = (Department)obj;
    return this.department.equals(other.department);
   }


  /**
   * Returns the string representation of this Department.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Department[department=Research]"
   *
   * @return String representation of this Department
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(23);
    builder.append("Department[department=").append(this.department).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Department obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.department.compareTo(obj.department);
   }

 }
