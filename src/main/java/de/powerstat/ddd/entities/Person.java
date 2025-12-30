/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.entities;


import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jmolecules.ddd.annotation.Entity;

import de.powerstat.ddd.containers.HistoryOf;
import de.powerstat.ddd.interfaces.IEntity;
import de.powerstat.ddd.values.BloodGroup;
import de.powerstat.ddd.values.Firstname;
import de.powerstat.ddd.values.Gender;
import de.powerstat.ddd.values.Lastname;


/**
 * Person.
 *
 * DSGVO relevant.
 *
 * TODO birth place (optional)
 * TODO death place (optional)
 * TODO history of citizenships
 * TODO Identity card number at different times
 * TODO eye color
 * TODO Skin color
 * TODO body height at different times (24cm - 272cm)
 * TODO body weight at different times (212g - 635kg)
 * TODO body temperature at different times
 * TODO characteristics
 * TODO Zahnstatus at differet times
 * TODO DNA
 * TODO faceid, fingerid, eyeid at different times
 * TODO Signature(s)
 * TODO Namenszusätze: Adelstitel, Academic title since, Work titles/qualifications since
 * TODO ... Nicknames at different times
 *
 * TODO Address(es) at different times
 * TODO Communication typ(s) at different times
 * TODO photo(s) at different times
 * TODO voice recordings at different times
 * TODO ? marriage(s) / divorce(s) at different times
 * TODO relationship(s), children, parents, siblings, ... at different times
 * TODO languages (reading, writing, speeking, understanding, level) since
 * TODO ownership at different times
 * TODO knowledge since
 * TODO get vcard ?
 *
 * TODO Change DateTime of an entry to an earlier entry
 */
@Entity
public final class Person implements Comparable<Person>, IEntity
 {
  /**
   * Logger.
   */
  // private static final Logger LOGGER = LogManager.getLogger(Person.class);

  /**
   * Universally Unique Identifier.
   */
  // private final UUID uuid = UUID.of();

  /**
   * Lastnames at different times.
   */
  private final HistoryOf<Lastname> lastname = new HistoryOf<>();

  /**
   * Gender/sex at different times.
   */
  private final HistoryOf<Gender> sex = new HistoryOf<>();

  /**
   * First names at different times.
   */
  private final HistoryOf<List<Firstname>> firstnames = new HistoryOf<>();

  /**
   * Call name at different times.
   */
  // private final HistoryOf<Integer> callname = new HistoryOf<>();

  /**
   * Birthday if known with time or 00:00:00.
   */
  private Optional<OffsetDateTime> birthday = Optional.empty();

  /**
   * Death date if not still alive, with time or 00:00:00.
   */
  private Optional<OffsetDateTime> deathdate = Optional.empty();

  /**
   * Blood group.
   */
  private Optional<BloodGroup> bloodGroup = Optional.empty();


  /**
   * Private default constructor.
   */
  private Person()
   {
    super();
   }


  /**
   * Person factory.
   *
   * @return Person object
   */
  public static Person of()
   {
    return new Person();
   }


  /**
   * Person factory.
   *
   * @param lastname Lastname
   * @param gender Gender
   * @return Person object
   */
  public static Person of(final Lastname lastname, final Gender gender)
   {
    final var person = Person.of();
    person.addLastname(OffsetDateTime.now(ZoneId.systemDefault()), lastname);
    person.addGender(OffsetDateTime.now(ZoneId.systemDefault()), gender);
    return person;
   }


  /**
   * Person factory.
   *
   * @param lastname Lastname
   * @param gender Gender
   * @param firstnames Firstnames
   * @return Person object
   */
  public static Person of(final Lastname lastname, final Gender gender, final List<Firstname> firstnames)
   {
    final var person = Person.of(lastname, gender);
    person.addFirstnames(OffsetDateTime.now(ZoneId.systemDefault()), firstnames);
    return person;
   }


  /**
   * Person factory.
   *
   * @param lastname Lastname
   * @param gender Gender
   * @param firstnames Firstnames
   * @param birthdate Birthdate
   * @return Person object
   */
  public static Person of(final Lastname lastname, final Gender gender, final List<Firstname> firstnames, final OffsetDateTime birthdate)
   {
    final var person = Person.of(lastname, gender, firstnames);
    person.setBirthday(birthdate);
    return person;
   }


  /**
   * Returns the value of this Person as a string.
   *
   * @return The text value represented by this object after conversion to type string (lastname, firstnames).
   */
  @Override
  public String stringValue()
   {
    final var builder = new StringBuilder(75);
    builder.append(lastname).append(", ").append(firstnames); //$NON-NLS-1$
    return builder.toString();
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
    return Objects.hash(lastname.getLatestEntry(), sex.getLatestEntry(), firstnames.getLatestEntry(), birthday, deathdate, bloodGroup);
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final @Nullable Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof final Person other))
     {
      return false;
     }
    boolean result = lastname.getLatestEntry().equals(other.lastname.getLatestEntry());
    if (result)
     {
      result = sex.getLatestEntry().equals(other.sex.getLatestEntry());
      if (result)
       {
        result = (firstnames.isEmpty() == other.firstnames.isEmpty());
        if (result)
         {
          if (!firstnames.isEmpty() && !other.firstnames.isEmpty())
           {
            result = firstnames.getLatestEntry().equals(other.firstnames.getLatestEntry());
           }
          if (result)
           {
            result = birthday.equals(other.birthday);
            if (result)
             {
              result = deathdate.equals(other.deathdate);
              if (result)
               {
                result = bloodGroup.equals(other.bloodGroup);
               }
             }
           }
         }
       }
     }
    return result;
   }


  /**
   * Returns the string representation of this Person.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Person[person=]"
   *
   * @return String representation of this Person
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(75);
    builder.append("Person[lastname=").append(lastname.getLatestEntry()).append(", gender=").append(sex.getLatestEntry());
    if (!firstnames.isEmpty())
     {
      builder.append(", firstnames=").append(firstnames.getLatestEntry());
     }
    if (birthday.isPresent())
     {
      builder.append(", birthday=").append(birthday);
     }
    if (deathdate.isPresent())
     {
      builder.append(", deathdate=").append(deathdate);
     }
    if (bloodGroup.isPresent())
     {
      builder.append(", bloodGroup=").append(bloodGroup);
     }
    builder.append(']');
    return builder.toString();
   }


  /**
   * Get firstnames as string.
   *
   * @param firstnames Firstnames
   * @return Firstnames as string
   */
  private static String getFirstnames(final HistoryOf<List<Firstname>> firstnames)
   {
    try
     {
      return firstnames.getLatestEntry().stream().map(Firstname::firstname).collect(Collectors.joining(" ")); //$NON-NLS-1$
     }
    catch (final NoSuchElementException e)
     {
      // LOGGER.debug("NoSuchElementException", e);
      return ""; //$NON-NLS-1$
     }
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @SuppressWarnings({"PMD.ConfusingTernary", "PMD.NPathComplexity"})
  @Override
  public int compareTo(final Person obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = (!lastname.isEmpty() && !obj.lastname.isEmpty()) ? lastname.getLatestEntry().compareTo(obj.lastname.getLatestEntry()) : Boolean.compare(lastname.isEmpty(), obj.lastname.isEmpty());
    if (result == 0)
     {
      result = (!sex.isEmpty() && !obj.sex.isEmpty()) ? sex.getLatestEntry().compareTo(obj.sex.getLatestEntry()) : Boolean.compare(sex.isEmpty(), obj.sex.isEmpty());
      if (result == 0)
       {
        final String thisName = Person.getFirstnames(firstnames);
        final String thatName = Person.getFirstnames(obj.firstnames);
        result = thisName.compareTo(thatName);
        if (result == 0)
         {
          if (birthday.isPresent() && obj.birthday.isPresent())
           {
            result = birthday.get().compareTo(obj.birthday.get());
           }
          else if (!birthday.isPresent() && !obj.birthday.isPresent())
           {
            result = 0;
           }
          else
           {
            result = birthday.isPresent() ? 1 : -1;
           }
          if (result == 0)
           {
            if (deathdate.isPresent() && obj.deathdate.isPresent())
             {
              result = deathdate.get().compareTo(obj.deathdate.get());
             }
            else if (!deathdate.isPresent() && !obj.deathdate.isPresent())
             {
              result = 0;
             }
            else
             {
              result = deathdate.isPresent() ? 1 : -1;
             }
            if (result == 0)
             {
              if (bloodGroup.isPresent() && obj.bloodGroup.isPresent())
               {
                result = bloodGroup.get().compareTo(obj.bloodGroup.get());
               }
              else if (!bloodGroup.isPresent() && !obj.bloodGroup.isPresent())
               {
                result = 0;
               }
              else
               {
                result = bloodGroup.isPresent() ? 1 : -1;
               }

             }
           }
         }
       }
     }
    return result;
   }


  /**
   * Get lastname at birth.
   *
   * @return First known lastname
   */
  public Lastname getLastnameAtBirth()
   {
    return lastname.getFirstEntry();
   }


  /**
   * Get actual lastname.
   *
   * @return Last known lastname
   */
  public Lastname getLastnameActual()
   {
    return lastname.getLatestEntry();
   }


  /**
   * Get previous lastname.
   *
   * @return Previous lastname or actual lastname/lastname at birth
   */
  public Lastname getLastnamePrevious()
   {
    return lastname.getPreviousEntry();
   }


  /**
   * Add lastname.
   *
   * @param since Since datetime
   * @param name Lastname
   * @throws NullPointerException If since and/or lastname is/are null
   * @throws IndexOutOfBoundsException If since lies in the future
   * @throws IllegalArgumentException If lastname is larger than 40 characters or includes illegal characters
   */
  public void addLastname(final OffsetDateTime since, final Lastname name)
   {
    lastname.addEntry(since, name);
   }


  /**
   * Get gender at birth.
   *
   * @return First known gender
   */
  public Gender getGenderAtBirth()
   {
    return sex.getFirstEntry();
   }


  /**
   * Get actual gender.
   *
   * @return Last known gender
   */
  public Gender getGenderActual()
   {
    return sex.getLatestEntry();
   }


  /**
   * Get previous gender.
   *
   * @return Previous gender or actual gender/gender at birth
   */
  public Gender getGenderPrevious()
   {
    return sex.getPreviousEntry();
   }


  /**
   * Add gender.
   *
   * @param since Since datetime
   * @param gender Gender
   * @throws IndexOutOfBoundsException If since lies in the future
   */
  public void addGender(final OffsetDateTime since, final Gender gender)
   {
    sex.addEntry(since, gender);
   }


  /**
   * Get firstnames at birth.
   *
   * @return List og first known firstnames
   */
  public List<Firstname> getFirstnamesAtBirth()
   {
    return new ArrayList<>(firstnames.getFirstEntry());
   }


  /**
   * Get actual firstnames.
   *
   * @return List pf last known firstnames
   */
  public List<Firstname> getFirstnamesActual()
   {
    return new ArrayList<>(firstnames.getLatestEntry());
   }


  /**
   * Get previous firstnames.
   *
   * @return Previous firstnames or actual firstnames/firstnames at birth
   */
  public List<Firstname> getFirstnamesPrevious()
   {
    return new ArrayList<>(firstnames.getPreviousEntry());
   }


  /**
   * Add firstnames.
   *
   * @param since Since datetime
   * @param names Firstnames
   * @throws NullPointerException If since and/or firstnames is/are null
   * @throws IndexOutOfBoundsException If since lies in the future
   * @throws IllegalArgumentException If firstnames is larger than 32 characters or includes illegal characters
   */
  public void addFirstnames(final OffsetDateTime since, final List<Firstname> names)
   {
    firstnames.addEntry(since, new ArrayList<>(names));
   }


  /**
   * Set birthday.
   *
   * @param date Birthday date with 00:00:00 or with exact birth time or null.
   */
  public void setBirthday(final OffsetDateTime date)
   {
    birthday = Optional.ofNullable(date);
   }


  /**
   * Get birthday.
   *
   * @return Optional OffsetDateTime
   */
  @SuppressWarnings("PMD.NullAssignment")
  public Optional<OffsetDateTime> getBirthday()
   {
    return Optional.ofNullable(birthday.isPresent() ? birthday.get() : null);
   }


  /**
   * Set death date.
   *
   * @param date Death date date with 00:00:00 or with exact death time or null.
   * @throws IllegalArgumentException If birthday &gt; death date
   */
  public void setDeathdate(final OffsetDateTime date)
   {
    if (birthday.isPresent() && birthday.get().isAfter(date))
     {
      throw new IllegalArgumentException("birthday > deathdate"); //$NON-NLS-1$
     }
    deathdate = Optional.ofNullable(date);
   }


  /**
   * Get death date.
   *
   * @return Optional OffsetDateTime
   */
  @SuppressWarnings("PMD.NullAssignment")
  public Optional<OffsetDateTime> getDeathdate()
   {
    return Optional.ofNullable(deathdate.isPresent() ? deathdate.get() : null);
   }


  /**
   * Set blood group.
   *
   * @param bloodGroup Blood group
   */
  public void setBloodGroup(final BloodGroup bloodGroup)
   {
    this.bloodGroup = Optional.ofNullable(bloodGroup);
   }


  /**
   * Get blood group.
   *
   * @return Optional BloodGroup
   */
  @SuppressWarnings("PMD.NullAssignment")
  public Optional<BloodGroup> getBloodGroup()
   {
    return Optional.ofNullable(bloodGroup.isPresent() ? bloodGroup.get() : null);
   }

 }
