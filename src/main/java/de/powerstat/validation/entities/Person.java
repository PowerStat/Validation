/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.entities;


import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import de.powerstat.validation.entities.impl.HistoryOf;
import de.powerstat.validation.interfaces.IEntity;
import de.powerstat.validation.values.BloodGroup;
import de.powerstat.validation.values.Firstname;
import de.powerstat.validation.values.Gender;
import de.powerstat.validation.values.Lastname;


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
 * TODO body height at different times
 * TODO characteristics
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
public final class Person implements Comparable<Person>, IEntity
 {
  /**
   * Logger.
   */
  private static final Logger LOGGER = LogManager.getLogger(Person.class);

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
  private final HistoryOf<Integer> callname = new HistoryOf<>();

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
    person.addLastname(OffsetDateTime.now(), lastname);
    person.addGender(OffsetDateTime.now(), gender);
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
    person.addFirstnames(OffsetDateTime.now(), firstnames);
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
   * Calculate hash code.
   *
   * @return Hash
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
   {
    return Objects.hash(this.lastname, this.sex, this.firstnames, this.birthday, this.deathdate, this.bloodGroup);
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
    if (!(obj instanceof Person))
     {
      return false;
     }
    final Person other = (Person)obj;
    boolean result = this.lastname.equals(other.lastname);
    if (result)
     {
      result = this.sex.equals(other.sex);
      if (result)
       {
        result = this.firstnames.equals(other.firstnames);
        if (result)
         {
          result = this.birthday.equals(other.birthday);
          if (result)
           {
            result = this.deathdate.equals(other.deathdate);
            if (result)
             {
              result = this.bloodGroup.equals(other.bloodGroup);
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
    builder.append("Person[lastname=").append(this.lastname).append(", gender=").append(this.sex).append(", firstnames=").append(this.firstnames).append(", birthday=").append(this.birthday).append(", deathdate=").append(this.deathdate).append(", bloodGroup=").append(this.bloodGroup).append(']'); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$ //$NON-NLS-4$ //$NON-NLS-5$ //$NON-NLS-6$
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
      return firstnames.getLatestEntry().stream().map(Firstname::stringValue).collect(Collectors.joining(" ")); //$NON-NLS-1$
     }
    catch (final NoSuchElementException e)
     {
      if (LOGGER.isDebugEnabled())
       {
        LOGGER.debug("NoSuchElementException", e);
       }
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
  @SuppressWarnings("PMD.ConfusingTernary")
  @Override
  public int compareTo(final Person obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    int result = this.lastname.getLatestEntry().compareTo(obj.lastname.getLatestEntry());
    if (result == 0)
     {
      result = this.sex.getLatestEntry().compareTo(obj.sex.getLatestEntry());
      if (result == 0)
       {
        final String thisName = Person.getFirstnames(this.firstnames);
        final String thatName = Person.getFirstnames(obj.firstnames);
        result = thisName.compareTo(thatName);
        if (result == 0)
         {
          if (this.birthday.isPresent() && obj.birthday.isPresent())
           {
            result = this.birthday.get().compareTo(obj.birthday.get());
           }
          else if (!this.birthday.isPresent() && !obj.birthday.isPresent())
           {
            result = 0;
           }
          else
           {
            result = this.birthday.isPresent() ? 1 : -1;
           }
          if (result == 0)
           {
            if (this.deathdate.isPresent() && obj.deathdate.isPresent())
             {
              result = this.deathdate.get().compareTo(obj.deathdate.get());
             }
            else if (!this.deathdate.isPresent() && !obj.deathdate.isPresent())
             {
              result = 0;
             }
            else
             {
              result = this.deathdate.isPresent() ? 1 : -1;
             }
            if (result == 0)
             {
              if (this.bloodGroup.isPresent() && obj.bloodGroup.isPresent())
               {
                result = this.bloodGroup.get().compareTo(obj.bloodGroup.get());
               }
              else if (!this.bloodGroup.isPresent() && !obj.bloodGroup.isPresent())
               {
                result = 0;
               }
              else
               {
                result = this.bloodGroup.isPresent() ? 1 : -1;
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
    return this.lastname.getFirstEntry();
   }


  /**
   * Get actual lastname.
   *
   * @return Last known lastname
   */
  public Lastname getLastnameActual()
   {
    return this.lastname.getLatestEntry();
   }


  /**
   * Get previous lastname.
   *
   * @return Previous lastname or actual lastname/lastname at birth
   */
  public Lastname getLastnamePrevious()
   {
    return this.lastname.getPreviousEntry();
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
    this.lastname.addEntry(since, name);
   }


  /**
   * Get gender at birth.
   *
   * @return First known gender
   */
  public Gender getGenderAtBirth()
   {
    return this.sex.getFirstEntry();
   }


  /**
   * Get actual gender.
   *
   * @return Last known gender
   */
  public Gender getGenderActual()
   {
    return this.sex.getLatestEntry();
   }


  /**
   * Get previous gender.
   *
   * @return Previous gender or actual gender/gender at birth
   */
  public Gender getGenderPrevious()
   {
    return this.sex.getPreviousEntry();
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
    this.sex.addEntry(since, gender);
   }


  /**
   * Get firstnames at birth.
   *
   * @return List og first known firstnames
   */
  public List<Firstname> getFirstnamesAtBirth()
   {
    return new ArrayList<>(this.firstnames.getFirstEntry());
   }


  /**
   * Get actual firstnames.
   *
   * @return List pf last known firstnames
   */
  public List<Firstname> getFirstnamesActual()
   {
    return new ArrayList<>(this.firstnames.getLatestEntry());
   }


  /**
   * Get previous firstnames.
   *
   * @return Previous firstnames or actual firstnames/firstnames at birth
   */
  public List<Firstname> getFirstnamesPrevious()
   {
    return new ArrayList<>(this.firstnames.getPreviousEntry());
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
    this.firstnames.addEntry(since, new ArrayList<>(names));
   }


  /**
   * Set birthday.
   *
   * @param date Birthday date with 00:00:00 or with exact birth time or null.
   */
  public void setBirthday(final OffsetDateTime date)
   {
    this.birthday = Optional.ofNullable(date);
   }


  /**
   * Get birthday.
   *
   * @return Optional OffsetDateTime
   */
  @SuppressWarnings("PMD.NullAssignment")
  public Optional<OffsetDateTime> getBirthday()
   {
    return Optional.ofNullable(this.birthday.isPresent() ? this.birthday.get() : null);
   }


  /**
   * Set death date.
   *
   * @param date Death date date with 00:00:00 or with exact death time or null.
   * @throws IllegalArgumentException If birthday &gt; death date
   */
  public void setDeathdate(final OffsetDateTime date)
   {
    if (this.birthday.isPresent() && this.birthday.get().isAfter(date))
     {
      throw new IllegalArgumentException("birthday > deathdate"); //$NON-NLS-1$
     }
    this.deathdate = Optional.ofNullable(date);
   }


  /**
   * Get death date.
   *
   * @return Optional OffsetDateTime
   */
  @SuppressWarnings("PMD.NullAssignment")
  public Optional<OffsetDateTime> getDeathdate()
   {
    return Optional.ofNullable(this.deathdate.isPresent() ? this.deathdate.get() : null);
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
    return Optional.ofNullable(this.bloodGroup.isPresent() ? this.bloodGroup.get() : null);
   }

 }
