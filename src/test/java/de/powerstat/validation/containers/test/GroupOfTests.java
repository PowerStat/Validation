/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.containers.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import nl.jqno.equalsverifier.EqualsVerifier;

import de.powerstat.validation.containers.GroupOf;
import de.powerstat.validation.entities.Person;
import de.powerstat.validation.values.Gender;
import de.powerstat.validation.values.Lastname;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * GroupOf tests.
 */
@SuppressWarnings({"PMD.LooseCoupling"})
final class GroupOfTests
 {
  /**
   * Could not add.
   */
  private static final String COULD_NOT_ADD = "Could not add";

  /**
   * Is empty.
   */
  private static final String IS_EMPTY = "is empty";

  /**
   * Not added.
   */
  private static final String NOT_ADDED = "Not added";

  /**
   * Array length != 1.
   */
  private static final String ARRAY_LENGTH_NOT_1 = "array != 1";

  /**
   * Is not empty.
   */
  private static final String IS_NOT_EMPTY = "is not empty";

  /**
   * size() not equal.
   */
  private static final String SIZE_NOT_EQUAL = "size() not equal";

  /**
   * Hofmann.
   */
  private static final String HOFMANN = "Hofmann";

  /**
   * toString() not equal.
   */
  private static final String TO_STRING_NOT_EQUAL = "toString() not equal";

  /**
   * Developers.
   */
  private static final String DEVELOPERS = "developers";

  /**
   * Wrong group name.
   */
  private static final String WRONG_GROUP_NAME = "Wrong group name";


  /**
   * Default constructor.
   */
  /* default */ GroupOfTests()
   {
    super();
   }


  /**
   * Constructor test.
   *
   * @param name Group name
   */
  @ParameterizedTest
  @ValueSource(strings = {"a", "abcdefghijklmnopqrstuvwxyzabcdefghijklmn", DEVELOPERS})
  /* default */ void testConstructor1(final String name)
   {
    final GroupOf<Person> groups = new GroupOf<>(name);
    assertAll("GroupOf constructor",
      () -> assertNotNull(groups, "Constructor failed!"), //$NON-NLS-1$
      () -> assertEquals(name, groups.name(), WRONG_GROUP_NAME)
    );
   }


  /**
   * Constructor test.
   */
  @SuppressFBWarnings("SEC_SIDE_EFFECT_CONSTRUCTOR")
  @Test
  /* default */ void testConstructor2()
   {
    assertThrows(NullPointerException.class, () ->
     {
      /* final GroupOf<Person> groups = */ new GroupOf<>(null);
     }, "Null pointer exception"
    );
   }


  /**
   * Test constructor.
   *
   * @param name Group name
   */
  @SuppressFBWarnings("SEC_SIDE_EFFECT_CONSTRUCTOR")
  @ParameterizedTest
  @ValueSource(strings = {"", "12345678901234567890123456789012345678901", "!!!"})
  /* default */ void testConstructor3(final String name)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final GroupOf<Person> groups = */ new GroupOf<>(name);
     }, "Illegal argument exception"
    );
   }


  /**
   * Test name.
   */
  @Test
  /* default */ void testName()
   {
    final GroupOf<Person> groups = new GroupOf<>(DEVELOPERS);
    assertEquals(DEVELOPERS, groups.name(), WRONG_GROUP_NAME);
   }


  /**
   * Equalsverifier.
   */
  @Test
  /* default */ void testEqualsContract()
   {
    EqualsVerifier.forClass(GroupOf.class).withNonnullFields("name", "group").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString1()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    assertEquals("GroupOf<>[name=developers]", developers.toString(), TO_STRING_NOT_EQUAL);
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString2()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    developers.add(Person.of(Lastname.of(HOFMANN), Gender.MALE));
    assertEquals("GroupOf<>[name=developers, Person[lastname=Lastname[lastname=Hofmann], gender=MALE]]", developers.toString(), TO_STRING_NOT_EQUAL);
   }


  /**
   * Test size.
   */
  @Test
  /* default */ void testSize1()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    assertEquals(0, developers.size(), SIZE_NOT_EQUAL);
   }


  /**
   * Test size.
   */
  @Test
  /* default */ void testSize2()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    developers.add(Person.of());
    assertEquals(1, developers.size(), SIZE_NOT_EQUAL);
   }


  /**
   * Test isEmpty.
   */
  @Test
  /* default */ void testIsEmpty()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    assertTrue(developers.isEmpty(), IS_NOT_EMPTY);
   }


  /**
   * Test contains.
   */
  @Test
  /* default */ void testContains1()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    final Person person = Person.of(Lastname.of(HOFMANN), Gender.MALE);
    developers.add(person);
    assertTrue(developers.contains(person), "does not contain");
   }


  /**
   * Test contains.
   */
  @Test
  /* default */ void testContains2()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    final Person person = Person.of(Lastname.of(HOFMANN), Gender.MALE);
    developers.add(person);
    assertFalse(developers.contains(Person.of()), "does contain");
   }


  /**
   * Test iterator.
   */
  @Test
  /* default */ void testIterator()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    developers.add(Person.of(Lastname.of(HOFMANN), Gender.MALE));
    final Iterator<Person> iter = developers.iterator();
    assertTrue(iter.hasNext(), "iter has no next");
   }


  /**
   * Test toArray.
   */
  @Test
  /* default */ void testToArray1()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    developers.add(Person.of(Lastname.of(HOFMANN), Gender.MALE));
    final Object[] arr = developers.toArray();
    assertEquals(1, arr.length, ARRAY_LENGTH_NOT_1);
   }


  /**
   * Test toArray.
   */
  @SuppressWarnings("PMD.OptimizableToArrayCall")
  @Test
  /* default */ void testToArray2()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    developers.add(Person.of(Lastname.of(HOFMANN), Gender.MALE));
    final Person[] arr = developers.toArray(new Person[1]);
    assertEquals(1, arr.length, ARRAY_LENGTH_NOT_1);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd1()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    assertTrue(developers.add(Person.of(Lastname.of(HOFMANN), Gender.MALE)), NOT_ADDED);
    assertFalse(developers.isEmpty(), IS_EMPTY);
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd2()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    final Person person = Person.of(Lastname.of(HOFMANN), Gender.MALE);
    developers.add(person);
    assertFalse(developers.add(person), NOT_ADDED);
   }


  /**
   * Test remove.
   */
  @Test
  /* default */ void testRemove1()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    final Person person = Person.of(Lastname.of(HOFMANN), Gender.MALE);
    developers.add(person);
    assertTrue(developers.remove(person), "Can not remove");
    assertTrue(developers.isEmpty(), IS_EMPTY);
   }


  /**
   * Test remove.
   */
  @Test
  /* default */ void testRemove2()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    final Person person = Person.of(Lastname.of(HOFMANN), Gender.MALE);
    developers.add(person);
    developers.remove(person);
    assertFalse(developers.remove(person), "Not already removed");
    assertTrue(developers.isEmpty(), IS_EMPTY);
   }


  /**
   * Test containsAll.
   */
  @Test
  /* default */ void testContainsAll1()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    final ArrayList<Person> list = new ArrayList<>();
    list.add(Person.of(Lastname.of(HOFMANN), Gender.MALE));
    developers.addAll(list);
    assertTrue(developers.containsAll(list), IS_EMPTY);
   }


  /**
   * Test containsAll.
   */
  @Test
  /* default */ void testContainsAll2()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    final ArrayList<Person> list = new ArrayList<>();
    list.add(Person.of(Lastname.of(HOFMANN), Gender.MALE));
    developers.addAll(list);
    list.add(Person.of(Lastname.of("HofmannB"), Gender.FEMALE));
    assertFalse(developers.containsAll(list), "does contain all");
   }


  /**
   * Test addAll.
   */
  @Test
  /* default */ void testAddAll1()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    final ArrayList<Person> list = new ArrayList<>();
    list.add(Person.of(Lastname.of(HOFMANN), Gender.MALE));
    assertTrue(developers.addAll(list), COULD_NOT_ADD);
    assertFalse(developers.isEmpty(), IS_EMPTY);
   }


  /**
   * Test addAll.
   */
  @Test
  /* default */ void testAddAll2()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    final Person person = Person.of(Lastname.of(HOFMANN), Gender.MALE);
    developers.add(person);
    final ArrayList<Person> list = new ArrayList<>();
    list.add(person);
    assertFalse(developers.addAll(list), COULD_NOT_ADD);
   }


  /**
   * Test retainAll.
   */
  @Test
  /* default */ void testRetainAll1()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    developers.add(Person.of(Lastname.of(HOFMANN), Gender.MALE));
    final boolean result = developers.retainAll(new ArrayList<>());
    assertAll("testRetainAll1", //$NON-NLS-1$
      () -> assertTrue(result, "not changed"), //$NON-NLS-1$
      () -> assertTrue(developers.isEmpty(), IS_NOT_EMPTY)
    );
   }


  /**
   * Test retainAll.
   */
  @Test
  /* default */ void testRetainAll2()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    final Person person = Person.of(Lastname.of(HOFMANN), Gender.MALE);
    developers.add(person);
    final ArrayList<Person> list = new ArrayList<>();
    list.add(person);
    final boolean result = developers.retainAll(list);
    assertAll("testRetainAll2", //$NON-NLS-1$
      () -> assertFalse(result, "changed"), //$NON-NLS-1$
      () -> assertFalse(developers.isEmpty(), IS_NOT_EMPTY)
    );
   }


  /**
   * Test removeAll.
   */
  @Test
  /* default */ void testRemoveAll1()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    final ArrayList<Person> list = new ArrayList<>();
    list.add(Person.of(Lastname.of(HOFMANN), Gender.MALE));
    developers.addAll(list);
    assertTrue(developers.removeAll(list), "Could not remove all");
    assertTrue(developers.isEmpty(), IS_NOT_EMPTY);
   }


  /**
   * Test removeAll.
   */
  @Test
  /* default */ void testRemoveAll2()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    final ArrayList<Person> list = new ArrayList<>();
    list.add(Person.of(Lastname.of(HOFMANN), Gender.MALE));
    developers.addAll(list);
    final ArrayList<Person> removeList = new ArrayList<>();
    removeList.add(Person.of(Lastname.of(HOFMANN), Gender.FEMALE));
    assertFalse(developers.removeAll(removeList), "Removed all");
   }


  /**
   * Test clear.
   */
  @Test
  /* default */ void testClear()
   {
    final GroupOf<Person> developers = new GroupOf<>(DEVELOPERS);
    developers.add(Person.of(Lastname.of(HOFMANN), Gender.MALE));
    developers.clear();
    assertTrue(developers.isEmpty(), IS_NOT_EMPTY);
   }

 }
