/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.UUID;


/**
 * UUID tests.
 */
public class UUIDTests
 {
  /**
   * Default constructor.
   */
  /* default */ UUIDTests()
   {
    super();
   }


  /**
   * Factory test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(36, UUID.of().stringValue().length(), "Result not as expected");
   }


  /**
   * Factory test.
   */
  @Test
  /* default */ void testFactory2()
   {
    assertEquals("a5409f2d-983d-438c-bfdd-308feff7fb1f", UUID.of("a5409f2d-983d-438c-bfdd-308feff7fb1f").stringValue(), "Result not as expected");
   }


  /**
   * Test hash code.
   */
  @Test
  /* default */ void testHashCode()
   {
    final UUID uuid1 = UUID.of("a5409f2d-983d-438c-bfdd-308feff7fb1f");
    final UUID uuid2 = UUID.of("a5409f2d-983d-438c-bfdd-308feff7fb1f");
    final UUID uuid3 = UUID.of("67803e53-28f7-42d1-910f-b01dd3fe2d48");
    assertAll("testHashCode", //$NON-NLS-1$
      () -> assertEquals(uuid1.hashCode(), uuid2.hashCode(), "hashCodes are not equal"), //$NON-NLS-1$
      () -> assertNotEquals(uuid1.hashCode(), uuid3.hashCode(), "hashCodes are equal") //$NON-NLS-1$
    );
   }


  /**
   * Test equals.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testEquals()
   {
    final UUID uuid1 = UUID.of("a5409f2d-983d-438c-bfdd-308feff7fb1f");
    final UUID uuid2 = UUID.of("a5409f2d-983d-438c-bfdd-308feff7fb1f");
    final UUID uuid3 = UUID.of("67803e53-28f7-42d1-910f-b01dd3fe2d48");
    final UUID uuid4 = UUID.of("a5409f2d-983d-438c-bfdd-308feff7fb1f");
    assertAll("testEquals", //$NON-NLS-1$
      () -> assertTrue(uuid1.equals(uuid1), "uuid11 is not equal"), //$NON-NLS-1$
      () -> assertTrue(uuid1.equals(uuid2), "uuid12 are not equal"), //$NON-NLS-1$
      () -> assertTrue(uuid2.equals(uuid1), "uuid21 are not equal"), //$NON-NLS-1$
      () -> assertTrue(uuid2.equals(uuid4), "uuid24 are not equal"), //$NON-NLS-1$
      () -> assertTrue(uuid1.equals(uuid4), "uuid14 are not equal"), //$NON-NLS-1$
      () -> assertFalse(uuid1.equals(uuid3), "uuid13 are equal"), //$NON-NLS-1$
      () -> assertFalse(uuid3.equals(uuid1), "uuid31 are equal"), //$NON-NLS-1$
      () -> assertFalse(uuid1.equals(null), "uuid10 is equal") //$NON-NLS-1$
    );
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final UUID uuid = UUID.of("a5409f2d-983d-438c-bfdd-308feff7fb1f");
    assertEquals("UUID[uuid=a5409f2d-983d-438c-bfdd-308feff7fb1f]", uuid.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final UUID uuid1 = UUID.of("a5409f2d-983d-438c-bfdd-308feff7fb1f");
    final UUID uuid2 = UUID.of("a5409f2d-983d-438c-bfdd-308feff7fb1f");
    final UUID uuid3 = UUID.of("67803e53-28f7-42d1-910f-b01dd3fe2d48");
    final UUID uuid4 = UUID.of("758b3027-cecd-4aae-b76b-543b8439db10");
    final UUID uuid5 = UUID.of("a5409f2d-983d-438c-bfdd-308feff7fb1f");
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(uuid1.compareTo(uuid2) == -uuid2.compareTo(uuid1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(uuid1.compareTo(uuid3) == -uuid3.compareTo(uuid1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((uuid4.compareTo(uuid3) > 0) && (uuid3.compareTo(uuid1) > 0) && (uuid4.compareTo(uuid1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((uuid1.compareTo(uuid2) == 0) && (Math.abs(uuid1.compareTo(uuid5)) == Math.abs(uuid2.compareTo(uuid5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((uuid1.compareTo(uuid2) == 0) && uuid1.equals(uuid2), "equals") //$NON-NLS-1$
    );
   }

 }
