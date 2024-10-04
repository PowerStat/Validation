/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
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

import de.powerstat.validation.containers.GroupOf;
import de.powerstat.validation.entities.Person;
import de.powerstat.validation.values.Gender;
import de.powerstat.validation.values.Lastname;


/**
 * GroupOf tests.
 */
public class GroupOfTests
 {
  /**
   * Default constructor.
   */
  /* default */ GroupOfTests()
   {
    super();
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testConstructor1()
   {
    final GroupOf<Person> groups = new GroupOf<>("developers");
    assertAll("GroupOf constructor",
      () -> assertNotNull(groups, "Constructor failed!"), //$NON-NLS-1$
      () -> assertEquals("developers", groups.name(), "Wrong group name") //$NON-NLS-1$
    );
   }


  /**
   * Constructor test.
   */
  @Test
  /* default */ void testConstructor2()
   {
    assertThrows(NullPointerException.class, () ->
     {
      final GroupOf<Person> groups = new GroupOf<>(null);
     }, "Null pointer exception"
    );
   }


  /**
   * Test constructor.
   *
   * @param name Group name
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "12345678901234567890123456789012345678901", "!!!"})
  /* default */ void testConstructor3(final String name)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      final GroupOf<Person> groups = new GroupOf<>(name);
     }, "Illegal argument exception"
    );
   }


  /**
   * Test name.
   */
  @Test
  /* default */ void testName()
   {
    final GroupOf<Person> groups = new GroupOf<>("developers");
    assertEquals("developers", groups.name(), "Wrong group name");
   }


  /**
   * Hash code test.
   */
  @Test
  /* default */ void testHashCode()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final int hc1 = developers.hashCode();
    assertAll("HashCode",
      () -> assertEquals(-225038600, hc1, "hc1 not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testEquals()
   {
    final GroupOf<Person> group1 = new GroupOf<>("developers");
    final GroupOf<Person> group2 = new GroupOf<>("developers");
    group2.add(Person.of());
    final GroupOf<Person> group3 = new GroupOf<>("family");
    final GroupOf<Person> group4 = new GroupOf<>("family");
    group4.add(Person.of());
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(group1.equals(group1), "group11 is not equal"), //$NON-NLS-1$
      () -> assertFalse(group1.equals(group2), "group12 are not equal"), //$NON-NLS-1$
      () -> assertFalse(group2.equals(group1), "group21 are not equal"), //$NON-NLS-1$
      () -> assertFalse(group2.equals(group4), "group24 are not equal"), //$NON-NLS-1$
      () -> assertFalse(group1.equals(group4), "group14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(group1.equals(group3), "group13 are equal"), //$NON-NLS-1$
      () -> assertFalse(group3.equals(group1), "group31 are equal"), //$NON-NLS-1$
      () -> assertFalse(group1.equals(null), "group10 is equal"), //$NON-NLS-1$
      () -> assertFalse(group1.equals(new Object()), "group1obj is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString1()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    assertEquals("GroupOf<>[name=developers]", developers.toString(), "toString() not equal");
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString2()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    developers.add(Person.of(Lastname.of("Hofmann"), Gender.MALE));
    assertEquals("GroupOf<>[name=developers, Person[lastname=Lastname[lastname=Hofmann], gender=MALE]]", developers.toString(), "toString() not equal");
   }


  /**
   * Test size.
   */
  @Test
  /* default */ void testSize()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    assertEquals(0, developers.size(), "size() not equal");
   }


  /**
   * Test isEmpty.
   */
  @Test
  /* default */ void testIsEmpty()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    assertTrue(developers.isEmpty(), "is not empty");
   }


  /**
   * Test contains.
   */
  @Test
  /* default */ void testContains()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final Person person = Person.of(Lastname.of("Hofmann"), Gender.MALE);
    developers.add(person);
    assertTrue(developers.contains(person), "does not contain");
   }


  /**
   * Test iterator.
   */
  @Test
  /* default */ void testIterator()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    developers.add(Person.of(Lastname.of("Hofmann"), Gender.MALE));
    final Iterator<Person> iter = developers.iterator();
    assertTrue(iter.hasNext(), "iter has no next");
   }


  /**
   * Test toArray.
   */
  @Test
  /* default */ void testToArray1()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    developers.add(Person.of(Lastname.of("Hofmann"), Gender.MALE));
    final Object[] arr = developers.toArray();
    assertEquals(1, arr.length, "array != 1");
   }


  /**
   * Test toArray.
   */
  @Test
  /* default */ void testToArray2()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    developers.add(Person.of(Lastname.of("Hofmann"), Gender.MALE));
    final Person[] arr = developers.toArray(new Person[1]);
    assertEquals(1, arr.length, "array != 1");
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    developers.add(Person.of(Lastname.of("Hofmann"), Gender.MALE));
    assertFalse(developers.isEmpty(), "is empty");
   }


  /**
   * Test remove.
   */
  @Test
  /* default */ void testRemove()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final Person person = Person.of(Lastname.of("Hofmann"), Gender.MALE);
    developers.add(person);
    developers.remove(person);
    assertTrue(developers.isEmpty(), "is empty");
   }


  /**
   * Test containsAll.
   */
  @Test
  /* default */ void testContainsAll()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final ArrayList<Person> list = new ArrayList<>();
    list.add(Person.of(Lastname.of("Hofmann"), Gender.MALE));
    developers.addAll(list);
    assertTrue(developers.containsAll(list), "is empty");
   }


  /**
   * Test addAll.
   */
  @Test
  /* default */ void testAddAll()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final ArrayList<Person> list = new ArrayList<>();
    list.add(Person.of(Lastname.of("Hofmann"), Gender.MALE));
    developers.addAll(list);
    assertFalse(developers.isEmpty(), "is empty");
   }


  /**
   * Test retainAll.
   */
  @Test
  /* default */ void testRetainAll()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    developers.add(Person.of(Lastname.of("Hofmann"), Gender.MALE));
    final boolean result = developers.retainAll(new ArrayList<>());
    assertAll("testRetainAll", //$NON-NLS-1$
      () -> assertTrue(result, "not changed"), //$NON-NLS-1$
      () -> assertTrue(developers.isEmpty(), "is not empty") //$NON-NLS-1$
    );
   }


  /**
   * Test removeAll.
   */
  @Test
  /* default */ void testRemoveAll()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final ArrayList<Person> list = new ArrayList<>();
    list.add(Person.of(Lastname.of("Hofmann"), Gender.MALE));
    developers.addAll(list);
    developers.removeAll(list);
    assertTrue(developers.isEmpty(), "is not empty");
   }


  /**
   * Test clear.
   */
  @Test
  /* default */ void testClear()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    developers.add(Person.of(Lastname.of("Hofmann"), Gender.MALE));
    developers.clear();
    assertTrue(developers.isEmpty(), "is not empty");
   }

 }
