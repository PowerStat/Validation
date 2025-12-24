/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address Department.
 *
 * Not DSGVO relevant.
 */
@ValueObject
public record Department(String department) implements Comparable<Department>, IValueObject
 {
  /**
   * Department regexp.
   */
  private static final Pattern DEPARTMENT_REGEXP = Pattern.compile("^[\\p{L}][\\p{L}\\\\p{Digi}.& -]*$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param department Department name
   * @throws NullPointerException if department is null
   * @throws IllegalArgumentException if department is not a correct department name
   */
  public Department
   {
    Objects.requireNonNull(department, "department"); //$NON-NLS-1$
    if (department.isEmpty() || (department.length() > 64))
     {
      throw new IllegalArgumentException("Department with wrong length"); //$NON-NLS-1$
     }
    if (!Department.DEPARTMENT_REGEXP.matcher(department).matches())
     {
      throw new IllegalArgumentException("Department with wrong format"); //$NON-NLS-1$
     }
   }


  /**
   * Department factory.
   *
   * @param department Department name
   * @return Department object
   */
  public static Department of(final String department)
   {
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
    return department;
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
    return department.compareTo(obj.department);
   }

 }
