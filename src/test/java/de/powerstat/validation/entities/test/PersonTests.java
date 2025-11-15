/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.entities.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.*;

import de.powerstat.validation.entities.Person;
import de.powerstat.validation.values.BloodGroup;
import de.powerstat.validation.values.Firstname;
import de.powerstat.validation.values.Gender;
import de.powerstat.validation.values.Lastname;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Person tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
@SuppressWarnings("java:S2925")
final class PersonTests
 {
  /**
   * Lastname constant.
   */
  private static final String HOFMANN = "Hofmann"; //$NON-NLS-1$

  /**
   * Lastname constant.
   */
  private static final String LASTNAME = "Lastname"; //$NON-NLS-1$

  /**
   * Firstname constant.
   */
  private static final String KAI = "Kai"; //$NON-NLS-1$

  /**
   * Firstname constant.
   */
  private static final String SECONDNAME = "Secondname"; //$NON-NLS-1$

  /**
   * Firstnames constant.
   */
  private static final String KAI_SECONDNAME = "Kai Secondname"; //$NON-NLS-1$

  /**
   * Firstname constant.
   */
  private static final String THIRDNAME = "Thirdname"; //$NON-NLS-1$

  /**
   * Middlename constant.
   */
  private static final String MIDDLENAME = "Middlename"; //$NON-NLS-1$

  /**
   * Birthname constant.
   */
  private static final String BIRTHNAME = "Birthname"; //$NON-NLS-1$

  /**
   * Birthday.
   */
  private static final String BIRTHDAY = "1970-09-18T00:00+01:00"; //$NON-NLS-1$

  /**
   * 1971.
   */
  private static final String Y1971_01_01T00_00_01_00 = "1971-01-01T00:00+01:00"; //$NON-NLS-1$

  /**
   * Unknown constant.
   */
  private static final String UNKNOWN = "Unknown"; //$NON-NLS-1$

  /**
   * Space.
   */
  private static final String SPACE = " "; //$NON-NLS-1$

  /**
   * Lastname not as expected message.
   */
  private static final String LASTNAME_NOT_AS_EXPECTED = "Lastname not as expected!"; //$NON-NLS-1$

  /**
   * Gender not as expected message.
   */
  private static final String GENDER_NOT_AS_EXPECTED = "Gender not as expected!"; //$NON-NLS-1$

  /**
   * Firstnames not as expected message.
   */
  private static final String FIRSTNAMES_NOT_AS_EXPECTED = "Firstnames not as expected!"; //$NON-NLS-1$

  /**
   * Wrong date constant.
   */
  private static final String WRONG_DATE = "Wrong date!"; //$NON-NLS-1$

  /**
   * Wrong blood group constant.
   */
  private static final String WRONG_BLOOD_GROUP = "Wrong blood group!"; //$NON-NLS-1$

  /**
   * Is not empty constant.
   */
  private static final String IS_NOT_EMPTY = "Is not empty"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ PersonTests()
   {
    super();
   }


  /**
   * Constructor/factory test.
   */
  @Test
  /* default */ void testConstructor1()
   {
    final Person person = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    assertAll("constructor", //$NON-NLS-1$
      () -> assertNotNull(person, "Person is null") //$NON-NLS-1$
    );
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(Person.class).suppress(Warning.NONFINAL_FIELDS).withNonnullFields("lastname", "sex", "firstnames", "birthday", "deathdate", "bloodGroup").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Person person = Person.of();
    person.addLastname(OffsetDateTime.of(2022, 1, 16, 11, 38, 0, 0, ZoneOffset.ofHours(1)), Lastname.of(PersonTests.HOFMANN));
    person.addGender(OffsetDateTime.of(2022, 1, 16, 11, 38, 0, 0, ZoneOffset.ofHours(1)), Gender.MALE);
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.KAI));
    person.addFirstnames(OffsetDateTime.of(2022, 1, 16, 11, 38, 0, 0, ZoneOffset.ofHours(1)), firstnames);
    person.setBirthday(OffsetDateTime.of(1970, 9, 18, 0, 0, 0, 0, ZoneOffset.ofHours(1)));
    person.setDeathdate(OffsetDateTime.of(2037, 9, 25, 0, 0, 0, 0, ZoneOffset.ofHours(1)));
    person.setBloodGroup(BloodGroup.OP);
    assertEquals("Person[lastname=Lastname[lastname=Hofmann], gender=MALE, firstnames=[Firstname[firstname=Kai]], birthday=Optional[1970-09-18T00:00+01:00], deathdate=Optional[2037-09-25T00:00+01:00], bloodGroup=Optional[OP]]", person.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Person person = Person.of();
    person.addLastname(OffsetDateTime.of(2022, 1, 16, 11, 38, 0, 0, ZoneOffset.ofHours(1)), Lastname.of(PersonTests.HOFMANN));
    person.addGender(OffsetDateTime.of(2022, 1, 16, 11, 38, 0, 0, ZoneOffset.ofHours(1)), Gender.MALE);
    assertEquals("HistoryOf<>[2022-01-16T11:38:00+01:00=Lastname[lastname=Hofmann]], HistoryOf<>[]", person.stringValue(), "stringValue not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Person person1 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final Person person2 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final Person person3 = Person.of(Lastname.of(PersonTests.LASTNAME), Gender.UNKNOWN);
    final Person person4 = Person.of(Lastname.of(PersonTests.MIDDLENAME), Gender.UNKNOWN);
    final Person person5 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(person1.compareTo(person2) == -person2.compareTo(person1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(person1.compareTo(person3) == -person3.compareTo(person1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((person4.compareTo(person3) > 0) && (person3.compareTo(person1) > 0) && (person4.compareTo(person1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((person1.compareTo(person2) == 0) && (Math.abs(person1.compareTo(person5)) == Math.abs(person2.compareTo(person5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((person1.compareTo(person2) == 0) && person1.equals(person2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo2()
   {
    final Person person1 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final Person person2 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.FEMALE);
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.KAI));
    final Person person3 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE, firstnames, OffsetDateTime.of(1970, 9, 18, 0, 0, 0, 0, ZoneOffset.ofHours(1)));
    final Person person4 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE, firstnames, OffsetDateTime.of(1971, 9, 18, 0, 0, 0, 0, ZoneOffset.ofHours(1)));
    final Person person5 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE, firstnames);
    final Person person6 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    person6.setDeathdate(OffsetDateTime.of(1971, 9, 18, 0, 0, 0, 0, ZoneOffset.ofHours(1)));
    final Person person7 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    person7.setBloodGroup(BloodGroup.ON);
    assertAll("testCompareTo2", //$NON-NLS-1$
      () -> assertTrue(person1.compareTo(person2) != 0, "equal12"), //$NON-NLS-1$
      () -> assertTrue(person1.compareTo(person3) != 0, "equal13"), //$NON-NLS-1$
      () -> assertTrue(person3.compareTo(person3) == 0, "not equal33"), //$NON-NLS-1$
      () -> assertTrue(person3.compareTo(person4) != 0, "equal34"), //$NON-NLS-1$
      () -> assertTrue(person3.compareTo(person5) != 0, "equal35"), //$NON-NLS-1$
      () -> assertTrue(person5.compareTo(person3) != 0, "equal53"), //$NON-NLS-1$
      () -> assertTrue(person6.compareTo(person6) == 0, "equal66"), //$NON-NLS-1$
      () -> assertTrue(person6.compareTo(person1) != 0, "equal61"), //$NON-NLS-1$
      () -> assertTrue(person1.compareTo(person6) != 0, "equal16"), //$NON-NLS-1$
      () -> assertTrue(person7.compareTo(person7) == 0, "equal77"), //$NON-NLS-1$
      () -> assertTrue(person7.compareTo(person1) != 0, "equal71"), //$NON-NLS-1$
      () -> assertTrue(person1.compareTo(person7) != 0, "equal17") //$NON-NLS-1$
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  /* default */ void testCompareTo3()
   {
    final Person person1 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final Person person2 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.KAI));
    person1.addFirstnames(OffsetDateTime.now(), firstnames);
    person2.addFirstnames(OffsetDateTime.now(), firstnames);
    person1.setBirthday(OffsetDateTime.of(1970, 9, 18, 0, 0, 0, 0, ZoneOffset.ofHours(1)));
    assertTrue(person1.compareTo(person2) > 0, "not greater");
   }


  /**
   * Test compareTo.
   */
  @Test
  /* default */ void testCompareTo4()
   {
    final Person person1 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final Person person2 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.KAI));
    person1.addFirstnames(OffsetDateTime.now(), firstnames);
    person2.addFirstnames(OffsetDateTime.now(), firstnames);
    person2.setBirthday(OffsetDateTime.of(1970, 9, 18, 0, 0, 0, 0, ZoneOffset.ofHours(1)));
    assertTrue(person1.compareTo(person2) < 0, "not smaller");
   }


  /**
   * Test compareTo.
   */
  @Test
  /* default */ void testCompareTo5()
   {
    final Person person1 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final Person person2 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.KAI));
    person1.addFirstnames(OffsetDateTime.now(), firstnames);
    person2.addFirstnames(OffsetDateTime.now(), firstnames);
    person1.setDeathdate(OffsetDateTime.of(2037, 9, 25, 0, 0, 0, 0, ZoneOffset.ofHours(1)));
    assertTrue(person1.compareTo(person2) > 0, "not greater");
   }


  /**
   * Test compareTo.
   */
  @Test
  /* default */ void testCompareTo6()
   {
    final Person person1 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final Person person2 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.KAI));
    person1.addFirstnames(OffsetDateTime.now(), firstnames);
    person2.addFirstnames(OffsetDateTime.now(), firstnames);
    person2.setDeathdate(OffsetDateTime.of(2037, 9, 25, 0, 0, 0, 0, ZoneOffset.ofHours(1)));
    assertTrue(person1.compareTo(person2) < 0, "not smaller");
   }


  /**
   * Test compareTo.
   */
  @Test
  /* default */ void testCompareTo7()
   {
    final Person person1 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final Person person2 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.KAI));
    person1.addFirstnames(OffsetDateTime.now(), firstnames);
    person2.addFirstnames(OffsetDateTime.now(), firstnames);
    person1.setBloodGroup(BloodGroup.OP);
    assertTrue(person1.compareTo(person2) > 0, "not greater");
   }


  /**
   * Test compareTo.
   */
  @Test
  /* default */ void testCompareTo8()
   {
    final Person person1 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final Person person2 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.KAI));
    person1.addFirstnames(OffsetDateTime.now(), firstnames);
    person2.addFirstnames(OffsetDateTime.now(), firstnames);
    person2.setBloodGroup(BloodGroup.OP);
    assertTrue(person1.compareTo(person2) < 0, "not smaller");
   }


  /**
   * Test compareTo.
   */
  @Test
  /* default */ void testCompareTo9()
   {
    final Person person1 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final Person person2 = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final List<Firstname> firstnames1 = new ArrayList<>();
    final List<Firstname> firstnames2 = new ArrayList<>();
    firstnames1.add(Firstname.of(PersonTests.KAI));
    firstnames2.add(Firstname.of("Elke"));
    person1.addFirstnames(OffsetDateTime.now(), firstnames1);
    person2.addFirstnames(OffsetDateTime.now(), firstnames2);
    assertTrue(person1.compareTo(person2) != 0, "equal");
   }


  /**
   * Get lastname at birth test.
   *
   * @throws InterruptedException Interrupted sleep
   */
  @Test
  /* default */ void testGetLastnameAtBirth() throws InterruptedException
   {
    final Person person = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    TimeUnit.MICROSECONDS.sleep(1);
    person.addLastname(OffsetDateTime.now(), Lastname.of(PersonTests.MIDDLENAME));
    TimeUnit.MICROSECONDS.sleep(1);
    person.addLastname(OffsetDateTime.now(), Lastname.of(PersonTests.LASTNAME));
    final Lastname name = person.getLastnameAtBirth();
    assertEquals(PersonTests.HOFMANN, name.lastname(), PersonTests.LASTNAME_NOT_AS_EXPECTED);
   }


  /**
   * Get lastname actual test.
   */
  @Test
  /* default */ void testGetLastnameActual()
   {
    final Person person = Person.of(Lastname.of(PersonTests.LASTNAME), Gender.MALE);
    person.addLastname(OffsetDateTime.now(), Lastname.of(PersonTests.HOFMANN));
    final Lastname name = person.getLastnameActual();
    assertEquals(PersonTests.HOFMANN, name.lastname(), PersonTests.LASTNAME_NOT_AS_EXPECTED);
   }


  /**
   * Get lastname previous test.
   *
   * @throws InterruptedException Interrupted sleep
   */
  @Test
  /* default */ void testGetLastnamePrevious() throws InterruptedException
   {
    final Person person = Person.of(Lastname.of(PersonTests.BIRTHNAME), Gender.UNKNOWN);
    TimeUnit.MICROSECONDS.sleep(1);
    person.addLastname(OffsetDateTime.now(), Lastname.of(PersonTests.HOFMANN));
    TimeUnit.MICROSECONDS.sleep(1);
    person.addLastname(OffsetDateTime.now(), Lastname.of(PersonTests.LASTNAME));
    final Lastname name = person.getLastnamePrevious();
    assertEquals(PersonTests.HOFMANN, name.lastname(), PersonTests.LASTNAME_NOT_AS_EXPECTED);
   }


  /**
   * Add lastname test.
   */
  @Test
  /* default */ void testAddLastname()
   {
    final Person person = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final Lastname name = person.getLastnameActual();
    assertEquals(PersonTests.HOFMANN, name.lastname(), PersonTests.LASTNAME_NOT_AS_EXPECTED);
   }


  /**
   * Get gender at birth test.
   *
   * @throws InterruptedException Interrupted sleep
   */
  @Test
  /* default */ void testGetGenderAtBirth() throws InterruptedException
   {
    final Person person = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    TimeUnit.MICROSECONDS.sleep(1);
    person.addGender(OffsetDateTime.now(), Gender.NEUTRAL);
    final Gender gender = person.getGenderAtBirth();
    assertEquals(Gender.MALE, gender, PersonTests.GENDER_NOT_AS_EXPECTED);
   }


  /**
   * Get gender actual test.
   */
  @Test
  /* default */ void testGetGenderActual()
   {
    final Person person = Person.of(Lastname.of(PersonTests.LASTNAME), Gender.MALE);
    person.addGender(OffsetDateTime.now(), Gender.NEUTRAL);
    final Gender gender = person.getGenderActual();
    assertEquals(Gender.NEUTRAL, gender, PersonTests.GENDER_NOT_AS_EXPECTED);
   }


  /**
   * Get gender previous test.
   *
   * @throws InterruptedException Interrupted sleep
   */
  @Test
  /* default */ void testGetGenderPrevious() throws InterruptedException
   {
    final Person person = Person.of(Lastname.of(PersonTests.BIRTHNAME), Gender.UNKNOWN);
    TimeUnit.MICROSECONDS.sleep(1);
    person.addGender(OffsetDateTime.now(), Gender.FEMALE);
    TimeUnit.MICROSECONDS.sleep(1);
    person.addGender(OffsetDateTime.now(), Gender.NEUTRAL);
    final Gender gender = person.getGenderPrevious();
    assertEquals(Gender.FEMALE, gender, PersonTests.GENDER_NOT_AS_EXPECTED);
   }


  /**
   * Add gender test.
   */
  @Test
  /* default */ void testAddGender()
   {
    final Person person = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE);
    final Gender gender = person.getGenderActual();
    assertEquals(Gender.MALE, gender, PersonTests.GENDER_NOT_AS_EXPECTED);
   }


  /**
   * Get firstname at birth test.
   *
   * @throws InterruptedException Interrupted sleep
   */
  @Test
  /* default */ void testGetFirstnamesAtBirth() throws InterruptedException
   {
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.KAI));
    firstnames.add(Firstname.of(PersonTests.SECONDNAME));
    final Person person = Person.of(Lastname.of(PersonTests.BIRTHNAME), Gender.UNKNOWN, firstnames);
    TimeUnit.MICROSECONDS.sleep(1);
    final List<Firstname> firstnames2 = new ArrayList<>();
    firstnames2.add(Firstname.of(PersonTests.THIRDNAME));
    person.addFirstnames(OffsetDateTime.now(), firstnames2);
    final List<Firstname> names = person.getFirstnamesAtBirth();
    assertEquals(PersonTests.KAI_SECONDNAME, names.stream().map(Firstname::firstname).collect(Collectors.joining(PersonTests.SPACE)), PersonTests.FIRSTNAMES_NOT_AS_EXPECTED);
   }


  /**
   * Get firstnames actual test.
   */
  @Test
  /* default */ void testGetFirstnamesActual()
   {
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.KAI));
    firstnames.add(Firstname.of(PersonTests.SECONDNAME));
    final Person person = Person.of(Lastname.of(PersonTests.BIRTHNAME), Gender.UNKNOWN, firstnames);
    final List<Firstname> firstnames2 = new ArrayList<>();
    firstnames2.add(Firstname.of(PersonTests.THIRDNAME));
    person.addFirstnames(OffsetDateTime.now(), firstnames2);
    final List<Firstname> names = person.getFirstnamesActual();
    assertEquals(PersonTests.THIRDNAME, names.stream().map(Firstname::firstname).collect(Collectors.joining(PersonTests.SPACE)), PersonTests.FIRSTNAMES_NOT_AS_EXPECTED);
   }


  /**
   * Get firstnames previous test.
   *
   * @throws InterruptedException Interrupted sleep
   */
  @Test
  /* default */ void testGetFirstnamesPrevious() throws InterruptedException
   {
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.KAI));
    firstnames.add(Firstname.of(PersonTests.SECONDNAME));
    final Person person = Person.of(Lastname.of(PersonTests.BIRTHNAME), Gender.UNKNOWN, firstnames);
    TimeUnit.MICROSECONDS.sleep(1);
    final List<Firstname> firstnames2 = new ArrayList<>();
    firstnames2.add(Firstname.of(PersonTests.THIRDNAME));
    person.addFirstnames(OffsetDateTime.now(), firstnames2);
    final List<Firstname> names = person.getFirstnamesPrevious();
    assertEquals(PersonTests.KAI_SECONDNAME, names.stream().map(Firstname::firstname).collect(Collectors.joining(PersonTests.SPACE)), PersonTests.FIRSTNAMES_NOT_AS_EXPECTED);
   }


  /**
   * Add firstnames test.
   */
  @Test
  /* default */ void testAddFirstnames()
   {
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.KAI));
    firstnames.add(Firstname.of(PersonTests.SECONDNAME));
    final Person person = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE, firstnames);
    final List<Firstname> names = person.getFirstnamesActual();
    assertEquals(PersonTests.KAI_SECONDNAME, names.stream().map(Firstname::firstname).collect(Collectors.joining(PersonTests.SPACE)), PersonTests.FIRSTNAMES_NOT_AS_EXPECTED);
   }


  /**
   * Set birthday test.
   */
  @Test
  /* default */ void testSetBirthday()
   {
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.KAI));
    final Person person = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE, firstnames);
    person.setBirthday(OffsetDateTime.of(1970, 9, 18, 0, 0, 0, 0, ZoneOffset.ofHours(1)));
    assertEquals(PersonTests.BIRTHDAY, person.getBirthday().get().toString(), PersonTests.WRONG_DATE);
   }


  /**
   * Get birthday test.
   */
  @Test
  /* default */ void testGetBirthday()
   {
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.KAI));
    final Person person = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE, firstnames, OffsetDateTime.of(1970, 9, 18, 0, 0, 0, 0, ZoneOffset.ofHours(1)));
    assertEquals(PersonTests.BIRTHDAY, person.getBirthday().get().toString(), PersonTests.WRONG_DATE);
   }


  /**
   * Get birthday test.
   */
  @Test
  /* default */ void testGetBirthdayUnset()
   {
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.KAI));
    final Person person = Person.of(Lastname.of(PersonTests.HOFMANN), Gender.MALE, firstnames);
    assertTrue(person.getBirthday().isEmpty(), PersonTests.IS_NOT_EMPTY);
   }


  /**
   * Set death date test.
   */
  @Test
  /* default */ void testSetDeathdate1()
   {
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.UNKNOWN));
    final Person person = Person.of(Lastname.of(PersonTests.UNKNOWN), Gender.MALE, firstnames);
    person.setDeathdate(OffsetDateTime.of(1971, 1, 1, 0, 0, 0, 0, ZoneOffset.ofHours(1)));
    assertEquals(PersonTests.Y1971_01_01T00_00_01_00, person.getDeathdate().get().toString(), PersonTests.WRONG_DATE);
   }


  /**
   * Set death date test.
   */
  @Test
  /* default */ void testSetDeathdate2()
   {
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.UNKNOWN));
    final Person person = Person.of(Lastname.of(PersonTests.UNKNOWN), Gender.MALE, firstnames, OffsetDateTime.of(1972, 1, 1, 0, 0, 0, 0, ZoneOffset.ofHours(1)));
    final OffsetDateTime deathdate = OffsetDateTime.of(1971, 1, 1, 0, 0, 0, 0, ZoneOffset.ofHours(1));
    assertThrows(IllegalArgumentException.class, () ->
     {
      person.setDeathdate(deathdate);
     }, "Illegal argument exception expected" //$NON-NLS-1$
    );
   }


  /**
   * Get death date test.
   */
  @Test
  /* default */ void testGetDeathdate()
   {
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.UNKNOWN));
    final Person person = Person.of(Lastname.of(PersonTests.UNKNOWN), Gender.MALE, firstnames, OffsetDateTime.of(1971, 1, 1, 0, 0, 0, 0, ZoneOffset.ofHours(1)));
    person.setDeathdate(OffsetDateTime.of(1971, 1, 1, 0, 0, 0, 0, ZoneOffset.ofHours(1)));
    assertEquals(PersonTests.Y1971_01_01T00_00_01_00, person.getDeathdate().get().toString(), PersonTests.WRONG_DATE);
   }


  /**
   * Get death date test.
   */
  @Test
  /* default */ void testGetDeathdateUnset()
   {
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.UNKNOWN));
    final Person person = Person.of(Lastname.of(PersonTests.UNKNOWN), Gender.MALE, firstnames, OffsetDateTime.of(1971, 1, 1, 0, 0, 0, 0, ZoneOffset.ofHours(1)));
    assertTrue(person.getDeathdate().isEmpty(), PersonTests.IS_NOT_EMPTY);
   }


  /**
   * Set blood group test.
   */
  @Test
  /* default */ void testSetBloodGroup()
   {
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.UNKNOWN));
    final Person person = Person.of(Lastname.of(PersonTests.UNKNOWN), Gender.MALE, firstnames);
    person.setBloodGroup(BloodGroup.OP);
    assertEquals("Optional[OP]", person.getBloodGroup().toString(), PersonTests.WRONG_BLOOD_GROUP); //$NON-NLS-1$
   }


  /**
   * Get blood group test.
   */
  @Test
  /* default */ void testGetBloodGroup()
   {
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.UNKNOWN));
    final Person person = Person.of(Lastname.of(PersonTests.UNKNOWN), Gender.MALE, firstnames);
    person.setBloodGroup(BloodGroup.AP);
    assertEquals("Optional[AP]", person.getBloodGroup().toString(), PersonTests.WRONG_BLOOD_GROUP); //$NON-NLS-1$
   }


  /**
   * Get blood group test.
   */
  @Test
  /* default */ void testGetBloodGroupUnset()
   {
    final List<Firstname> firstnames = new ArrayList<>();
    firstnames.add(Firstname.of(PersonTests.UNKNOWN));
    final Person person = Person.of(Lastname.of(PersonTests.UNKNOWN), Gender.MALE, firstnames);
    assertTrue(person.getBloodGroup().isEmpty(), PersonTests.IS_NOT_EMPTY);
   }

 }
