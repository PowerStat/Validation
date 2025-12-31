/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.social.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.powerstat.ddd.values.social.Relationship;


/**
 * Relationship tests.
 */
final class RelationshipTests
 {
  /**
   * Unknown constant.
   */
  private static final String UNKNOWN = "UNKNOWN";

  /**
   * Unknown action not as expected contant.
   */
  private static final String UNKNOWN_ACTION_NOT_AS_EXPECTED = "UNKNOWN action not as expected";


  /**
   * Default constructor.
   */
  /* default */ RelationshipTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(0, Relationship.of(UNKNOWN).getAction(), UNKNOWN_ACTION_NOT_AS_EXPECTED);
   }


  /**
   * Test getAction of Relationship.
   */
  @Test
  /* default */ void testGetAction()
   {
    assertAll("constructor", //$NON-NLS-1$
      () -> assertEquals(0, Relationship.UNKNOWN.getAction(), UNKNOWN_ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(1, Relationship.MYSELF.getAction(), "MYSELF action not as expected"), //$NON-NLS-1$
      () -> assertEquals(2, Relationship.PARENT.getAction(), "PARENT action not as expected"), //$NON-NLS-1$
      () -> assertEquals(3, Relationship.STEPPARENT.getAction(), "STEPPARENT action not as expected"), //$NON-NLS-1$
      () -> assertEquals(4, Relationship.ADOPTIVE_PARENT.getAction(), "ADOPTIVE_PARENT action not as expected"), //$NON-NLS-1$
      () -> assertEquals(5, Relationship.FOSTER_PARENT.getAction(), "FOSTER_PARENT action not as expected"), //$NON-NLS-1$
      () -> assertEquals(6, Relationship.GODPARENT.getAction(), "GODPARENT action not as expected"), //$NON-NLS-1$
      () -> assertEquals(7, Relationship.PARENTS_IN_lAW.getAction(), "PARENTS_IN_lAW action not as expected"), //$NON-NLS-1$
      () -> assertEquals(8, Relationship.SIBLING.getAction(), "SIBLING action not as expected"), //$NON-NLS-1$
      () -> assertEquals(9, Relationship.HALF_SIBLING.getAction(), "HALF_SIBLING action not as expected"), //$NON-NLS-1$
      () -> assertEquals(10, Relationship.ADOPTED_SIBLING.getAction(), "ADOPTED_SIBLING action not as expected"), //$NON-NLS-1$
      () -> assertEquals(11, Relationship.CHILD.getAction(), "CHILD action not as expected"), //$NON-NLS-1$
      () -> assertEquals(12, Relationship.STEPCHILD.getAction(), "STEPCHILD action not as expected"), //$NON-NLS-1$
      () -> assertEquals(13, Relationship.ADOPTED_CHILD.getAction(), "ADOPTED_CHILD action not as expected"), //$NON-NLS-1$
      () -> assertEquals(14, Relationship.GODCHILD.getAction(), "GODCHILD action not as expected"), //$NON-NLS-1$
      () -> assertEquals(15, Relationship.GRANDPARENT.getAction(), "GRANDPARENT action not as expected"), //$NON-NLS-1$
      () -> assertEquals(16, Relationship.GRANDCHILD.getAction(), "GRANDCHILD action not as expected"), //$NON-NLS-1$
      () -> assertEquals(17, Relationship.GREAT_GRANDPARENT.getAction(), "GREAT_GRANDPARENT action not as expected"), //$NON-NLS-1$
      () -> assertEquals(18, Relationship.GREAT_GRANDCHILD.getAction(), "GREAT_GRANDCHILD action not as expected"), //$NON-NLS-1$
      () -> assertEquals(19, Relationship.SPOUSE.getAction(), "SPOUSE action not as expected"), //$NON-NLS-1$
      () -> assertEquals(20, Relationship.EX_SPOUSE.getAction(), "EX_SPOUSE action not as expected"), //$NON-NLS-1$
      () -> assertEquals(21, Relationship.AUNT_OR_UNCLE.getAction(), "AUNT_OR_UNCLE action not as expected"), //$NON-NLS-1$
      () -> assertEquals(22, Relationship.COUSIN.getAction(), "COUSIN action not as expected"), //$NON-NLS-1$
      () -> assertEquals(23, Relationship.NIECES_AND_NEPHEWS.getAction(), "NIECES_AND_NEPHEWS action not as expected"), //$NON-NLS-1$
      () -> assertEquals(24, Relationship.KIN.getAction(), "KIN action not as expected"), //$NON-NLS-1$
      () -> assertEquals(25, Relationship.FRIEND.getAction(), "FRIEND action not as expected"), //$NON-NLS-1$
      () -> assertEquals(26, Relationship.ACQUAINTANCE.getAction(), "ACQUAINTANCE action not as expected"), //$NON-NLS-1$
      () -> assertEquals(27, Relationship.NEIGHBOR.getAction(), "NEIGHBOR action not as expected"), //$NON-NLS-1$
      () -> assertEquals(28, Relationship.CO_RESDDENT.getAction(), "CO_RESDDENT action not as expected"), //$NON-NLS-1$
      () -> assertEquals(29, Relationship.MET.getAction(), "MET action not as expected"), //$NON-NLS-1$
      () -> assertEquals(30, Relationship.SCHOOLMATE.getAction(), "SCHOOLMATE action not as expected"), //$NON-NLS-1$
      () -> assertEquals(31, Relationship.UNIVERSITY_FRIEND.getAction(), "UNIVERSITY_FRIEND action not as expected"), //$NON-NLS-1$
      () -> assertEquals(32, Relationship.TEACHER.getAction(), "TEACHER action not as expected"), //$NON-NLS-1$
      () -> assertEquals(33, Relationship.PROFESSOR.getAction(), "PROFESSOR action not as expected"), //$NON-NLS-1$
      () -> assertEquals(34, Relationship.MENTOR.getAction(), "MENTOR action not as expected"), //$NON-NLS-1$
      () -> assertEquals(35, Relationship.CLUB_MEMBER.getAction(), "CLUB_MEMBER action not as expected"), //$NON-NLS-1$
      () -> assertEquals(36, Relationship.VIRTUAL.getAction(), "VIRTUAL action not as expected"), //$NON-NLS-1$
      () -> assertEquals(37, Relationship.COLLEAGUE.getAction(), "COLLEAGUE action not as expected"), //$NON-NLS-1$
      () -> assertEquals(38, Relationship.FORMER_COLLEAGUE.getAction(), "FORMER_COLLEAGUE action not as expected"), //$NON-NLS-1$
      () -> assertEquals(39, Relationship.CO_WORKER.getAction(), "CO_WORKER action not as expected"), //$NON-NLS-1$
      () -> assertEquals(40, Relationship.AGENT.getAction(), "AGENT action not as expected"), //$NON-NLS-1$
      () -> assertEquals(41, Relationship.CUSTOMER.getAction(), "CUSTOMER action not as expected"), //$NON-NLS-1$
      () -> assertEquals(42, Relationship.PROVIDER.getAction(), "PROVIDER action not as expected"), //$NON-NLS-1$
      () -> assertEquals(99, Relationship.OTHER.getAction(), "OTHER action not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Relationship relation = Relationship.UNKNOWN;
    assertEquals(UNKNOWN, relation.stringValue(), "stringValue not as expected");
   }

 }
