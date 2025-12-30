/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values;


import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.ddd.interfaces.IValueObject;


/**
 * Relationship.
 *
 * DSGVO relevant.
 *
 * Types:
 * Family relationships
 * Friendships
 * Sexual relationships
 * Social relationships
 * Online relationships
 * Working relationship
 * TODO: Therapeutic relationships
 */
@ValueObject
public enum Relationship implements IValueObject
 {
  /**
   * Unknown/undefined relationship.
   */
  UNKNOWN(0),

  // Type: Family relationships

  /**
   * Myself.
   */
  MYSELF(1),

  /**
   * Parent (mother/father).
   */
  PARENT(2),

  /**
   * Stepparent.
   */
  STEPPARENT(3),

  /**
   * Adoptive parent.
   */
  ADOPTIVE_PARENT(4),

  /**
   * Foster parent.
   */
  FOSTER_PARENT(5),

  /**
   * Godparent.
   */
  GODPARENT(6),

  /**
   * Parents-in-law - parents of spouse.
   */
  PARENTS_IN_lAW(7),

  /**
   * Sibling (brother, sister).
   */
  SIBLING(8),

  /**
   * Half sibling.
   */
  HALF_SIBLING(9),

  /**
   * Adopted sibling.
   */
  ADOPTED_SIBLING(10),

  /**
   * Child (daughter, son)
   */
  CHILD(11),

  /**
   * Stepchild.
   */
  STEPCHILD(12),

  /**
   * Adopted child.
   */
  ADOPTED_CHILD(13),

  /**
   * Godchild.
   */
  GODCHILD(14),

  /**
   * Grandparent.
   */
  GRANDPARENT(15),

  /**
   * Grandchild.
   */
  GRANDCHILD(16),

  /**
   * Great grandparent.
   */
  GREAT_GRANDPARENT(17),

  /**
   * Great grandchild.
   */
  GREAT_GRANDCHILD(18),

  /**
   * Spouse (Husband or Wife).
   */
  SPOUSE(19),

  /**
   * Ex-spouse.
   */
  EX_SPOUSE(20),

  /**
   * Aunt or uncle.
   */
  AUNT_OR_UNCLE(21),

  /**
   * Cousin.
   */
  COUSIN(22),

  /**
   * Nieces and nephews.
   */
  NIECES_AND_NEPHEWS(23),

  /**
   * Kin.
   */
  KIN(24),

  // Type: Friendships

  /**
   * Friend.
   */
  FRIEND(25),

  // Type: Social relationships

  /**
   * Acquaintance.
   */
  ACQUAINTANCE(26),

  /**
   * Neighbor.
   */
  NEIGHBOR(27),

  /**
   * Co-resident.
   */
  CO_RESDDENT(28),

  /**
   * Met.
   */
  MET(29),

  /**
   * Schoolmate.
   */
  SCHOOLMATE(30),

  /**
   * Uiversity friend.
   */
  UNIVERSITY_FRIEND(31),

  /**
   * Teacher.
   */
  TEACHER(32),

  /**
   * Professor.
   */
  PROFESSOR(33),

  /**
   * Mentor.
   */
  MENTOR(34),

  /**
   * Club member.
   */
  CLUB_MEMBER(35),

  // Type: Online relationships

  /**
   * Virtual.
   */
  VIRTUAL(36),

  // Type: Working relationship

  /**
   * Colleague.
   */
  COLLEAGUE(37),

  /**
   * Former colleague.
   */
  FORMER_COLLEAGUE(38),

  /**
   * Co-worker.
   */
  CO_WORKER(39),

  /**
   * Agent.
   */
  AGENT(40),

  /**
   * Customer.
   */
  CUSTOMER(41),

  /**
   * Provider.
   */
  PROVIDER(42),

  // TODO Type: Therapeutic relationships

  /**
   * Other.
   */
  OTHER(99);


  /**
   * Action number.
   */
  private final int action;


  /**
   * Ordinal constructor.
   *
   * @param action Action number
   */
  Relationship(final int action)
   {
    this.action = action;
   }


  /**
   * Relationship factory.
   *
   * @param value Relationship name string
   * @return Relationship object
   */
  public static Relationship of(final String value)
   {
    return Relationship.valueOf(value);
   }


  /**
   * Get action number.
   *
   * @return Action number
   */
  public int getAction()
   {
    return action;
   }


  /**
   * Returns the value of this Relationship as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.name();
   }

 }
