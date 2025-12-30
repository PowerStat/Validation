/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.ddd.values.Department;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Department tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class DepartmentTests
 {
  /**
   * Reasearch.
   */
  private static final String RESEARCH = "Research"; //$NON-NLS-1$

  /**
   * Telecomunication.
   */
  private static final String TELECOMUNICATION = "Telecomunication"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Department not as expected.
   */
  private static final String DEPARTMENT_NOT_AS_EXPECTED = "Department not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ DepartmentTests()
   {
    super();
   }


  /**
   * Test correct Department.
   *
   * @param department Department
   */
  @ParameterizedTest
  @ValueSource(strings = {DepartmentTests.RESEARCH, "A", "Abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijkl"})
  /* default */ void testDepartmentCorrect(final String department)
   {
    final Department cleanDepartment = Department.of(department);
    assertEquals(department, cleanDepartment.department(), DepartmentTests.DEPARTMENT_NOT_AS_EXPECTED);
   }


  /**
   * Test Department with wrong lengths.
   *
   * @param department Department
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "Abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklm"})
  /* default */ void testDepartmentLength(final String department)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Department cleanDepartment = */ Department.of(department);
     }, DepartmentTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test wrong Department.
   *
   * @param department Department
   */
  @ParameterizedTest
  @ValueSource(strings = {"abc_def"})
  /* default */ void testDepartmentWrong(final String department)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Department cleanDepartment = */ Department.of(department);
     }, DepartmentTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get department.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Department department = Department.of(DepartmentTests.RESEARCH);
    assertEquals(DepartmentTests.RESEARCH, department.stringValue(), DepartmentTests.DEPARTMENT_NOT_AS_EXPECTED);
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Department department1 = Department.of(DepartmentTests.RESEARCH);
    final Department department2 = Department.of(DepartmentTests.RESEARCH);
    final Department department3 = Department.of(DepartmentTests.TELECOMUNICATION);
    final Department department4 = Department.of("World wide sells"); //$NON-NLS-1$
    final Department department5 = Department.of(DepartmentTests.RESEARCH);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(department1.compareTo(department2) == -department2.compareTo(department1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(department1.compareTo(department3) == -department3.compareTo(department1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((department4.compareTo(department3) > 0) && (department3.compareTo(department1) > 0) && (department4.compareTo(department1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((department1.compareTo(department2) == 0) && (Math.abs(department1.compareTo(department5)) == Math.abs(department2.compareTo(department5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((department1.compareTo(department2) == 0) && department1.equals(department2), "equals") //$NON-NLS-1$
    );
   }

 }
