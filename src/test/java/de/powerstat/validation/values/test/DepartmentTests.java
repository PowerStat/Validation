/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.validation.values.Department;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Department tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class DepartmentTests
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
  public DepartmentTests()
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
  public void departmentCorrect(final String department)
   {
    final Department cleanDepartment = Department.of(department);
    assertEquals(department, cleanDepartment.stringValue(), DepartmentTests.DEPARTMENT_NOT_AS_EXPECTED);
   }


  /**
   * Test Department with wrong lengths.
   *
   * @param department Department
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "Abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklm"})
  public void departmentLength(final String department)
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
  public void departmentWrong(final String department)
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
  public void getDepartment()
   {
    final Department department = Department.of(DepartmentTests.RESEARCH);
    assertEquals(DepartmentTests.RESEARCH, department.stringValue(), DepartmentTests.DEPARTMENT_NOT_AS_EXPECTED);
   }


  /**
   * Test hash code.
   */
  @Test
  public void testHashCode()
   {
    final Department department1 = Department.of(DepartmentTests.RESEARCH);
    final Department department2 = Department.of(DepartmentTests.RESEARCH);
    final Department department3 = Department.of(DepartmentTests.TELECOMUNICATION);
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(department1.hashCode(), department2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(department1.hashCode(), department3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  public void testEquals()
   {
    final Department department1 = Department.of(DepartmentTests.RESEARCH);
    final Department department2 = Department.of(DepartmentTests.RESEARCH);
    final Department department3 = Department.of(DepartmentTests.TELECOMUNICATION);
    final Department department4 = Department.of(DepartmentTests.RESEARCH);
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(department1.equals(department1), "department11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(department1.equals(department2), "department12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(department2.equals(department1), "department21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(department2.equals(department4), "department24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(department1.equals(department4), "department14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(department1.equals(department3), "department13 are equal"), //$NON-NLS-1$
      () -> assertFalse(department3.equals(department1), "department31 are equal"), //$NON-NLS-1$
      () -> assertFalse(department1.equals(null), "department10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  public void testToString()
   {
    final Department department = Department.of(DepartmentTests.RESEARCH);
    assertEquals("Department[department=Research]", department.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
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
