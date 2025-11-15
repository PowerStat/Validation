/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
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
import nl.jqno.equalsverifier.*;

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
   *
   * @param name Group name
   */
  @ParameterizedTest
  @ValueSource(strings = {"a", "abcdefghijklmnopqrstuvwxyzabcdefghijklmn", "developers"})
  /* default */ void testConstructor1(final String name)
   {
    final GroupOf<Person> groups = new GroupOf<>(name);
    assertAll("GroupOf constructor",
      () -> assertNotNull(groups, "Constructor failed!"), //$NON-NLS-1$
      () -> assertEquals(name, groups.name(), "Wrong group name") //$NON-NLS-1$
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
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(GroupOf.class).withNonnullFields("name", "group").verify();
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
  /* default */ void testSize1()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    assertEquals(0, developers.size(), "size() not equal");
   }


  /**
   * Test size.
   */
  @Test
  /* default */ void testSize2()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    developers.add(Person.of());
    assertEquals(1, developers.size(), "size() not equal");
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
  /* default */ void testContains1()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final Person person = Person.of(Lastname.of("Hofmann"), Gender.MALE);
    developers.add(person);
    assertTrue(developers.contains(person), "does not contain");
   }


  /**
   * Test contains.
   */
  @Test
  /* default */ void testContains2()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final Person person = Person.of(Lastname.of("Hofmann"), Gender.MALE);
    developers.add(person);
    assertFalse(developers.contains(Person.of()), "does contain");
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
  /* default */ void testAdd1()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    assertTrue(developers.add(Person.of(Lastname.of("Hofmann"), Gender.MALE)), "Not added");
    assertFalse(developers.isEmpty(), "is empty");
   }


  /**
   * Test add.
   */
  @Test
  /* default */ void testAdd2()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final Person person = Person.of(Lastname.of("Hofmann"), Gender.MALE);
    developers.add(person);
    assertFalse(developers.add(person), "Not added");
   }


  /**
   * Test remove.
   */
  @Test
  /* default */ void testRemove1()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final Person person = Person.of(Lastname.of("Hofmann"), Gender.MALE);
    developers.add(person);
    assertTrue(developers.remove(person), "Can not remove");
    assertTrue(developers.isEmpty(), "is empty");
   }


  /**
   * Test remove.
   */
  @Test
  /* default */ void testRemove2()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final Person person = Person.of(Lastname.of("Hofmann"), Gender.MALE);
    developers.add(person);
    developers.remove(person);
    assertFalse(developers.remove(person), "Not already removed");
    assertTrue(developers.isEmpty(), "is empty");
   }


  /**
   * Test containsAll.
   */
  @Test
  /* default */ void testContainsAll1()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final ArrayList<Person> list = new ArrayList<>();
    list.add(Person.of(Lastname.of("Hofmann"), Gender.MALE));
    developers.addAll(list);
    assertTrue(developers.containsAll(list), "is empty");
   }


  /**
   * Test containsAll.
   */
  @Test
  /* default */ void testContainsAll2()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final ArrayList<Person> list = new ArrayList<>();
    list.add(Person.of(Lastname.of("Hofmann"), Gender.MALE));
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
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final ArrayList<Person> list = new ArrayList<>();
    list.add(Person.of(Lastname.of("Hofmann"), Gender.MALE));
    assertTrue(developers.addAll(list), "Could not add");
    assertFalse(developers.isEmpty(), "is empty");
   }


  /**
   * Test addAll.
   */
  @Test
  /* default */ void testAddAll2()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final Person person = Person.of(Lastname.of("Hofmann"), Gender.MALE);
    developers.add(person);
    final ArrayList<Person> list = new ArrayList<>();
    list.add(person);
    assertFalse(developers.addAll(list), "Could not add");
   }


  /**
   * Test retainAll.
   */
  @Test
  /* default */ void testRetainAll1()
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
   * Test retainAll.
   */
  @Test
  /* default */ void testRetainAll2()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final Person person = Person.of(Lastname.of("Hofmann"), Gender.MALE);
    developers.add(person);
    final ArrayList<Person> list = new ArrayList<>();
    list.add(person);
    final boolean result = developers.retainAll(list);
    assertAll("testRetainAll", //$NON-NLS-1$
      () -> assertFalse(result, "changed"), //$NON-NLS-1$
      () -> assertFalse(developers.isEmpty(), "is not empty") //$NON-NLS-1$
    );
   }


  /**
   * Test removeAll.
   */
  @Test
  /* default */ void testRemoveAll1()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final ArrayList<Person> list = new ArrayList<>();
    list.add(Person.of(Lastname.of("Hofmann"), Gender.MALE));
    developers.addAll(list);
    assertTrue(developers.removeAll(list), "Could not remove all");
    assertTrue(developers.isEmpty(), "is not empty");
   }


  /**
   * Test removeAll.
   */
  @Test
  /* default */ void testRemoveAll2()
   {
    final GroupOf<Person> developers = new GroupOf<>("developers");
    final ArrayList<Person> list = new ArrayList<>();
    list.add(Person.of(Lastname.of("Hofmann"), Gender.MALE));
    developers.addAll(list);
    final ArrayList<Person> removeList = new ArrayList<>();
    removeList.add(Person.of(Lastname.of("Hofmann"), Gender.FEMALE));
    assertFalse(developers.removeAll(removeList), "Removed all");
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
