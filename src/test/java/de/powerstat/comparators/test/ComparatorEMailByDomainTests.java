/**
 * Copyright (C) 2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.comparators.test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.comparators.ComparatorEMailByDomain;
import de.powerstat.validation.values.EMail;


/**
 * ComparatorEMailByDomain tests.
 */
public class ComparatorEMailByDomainTests
 {
  /**
   * Default constructor.
   */
  public ComparatorEMailByDomainTests()
   {
    super();
   }


  /**
   * Constructor test.
   */
  @Test
  public void constructor1()
   {
    final ComparatorEMailByDomain comp = new ComparatorEMailByDomain();
    assertNotNull(comp, "Constructor failed!"); //$NON-NLS-1$
   }


  /**
   * Test compare.
   */
  @Test
  public void compare1()
   {
    final ComparatorEMailByDomain comp = new ComparatorEMailByDomain();
    final EMail email = EMail.of("user1@example.com"); //$NON-NLS-1$
    assertThrows(NullPointerException.class, () ->
     {
      /* final int result = */ comp.compare(null, email);
     }
    );
   }


  /**
   * Test compare.
   */
  @Test
  public void compare2()
   {
    final ComparatorEMailByDomain comp = new ComparatorEMailByDomain();
    final EMail email = EMail.of("user1@example.com"); //$NON-NLS-1$
    assertThrows(NullPointerException.class, () ->
     {
      /* final int result = */ comp.compare(email, null);
     }
    );
   }


  /**
   * Test compare.
   */
  @Test
  public void compare3()
   {
    final ComparatorEMailByDomain comp = new ComparatorEMailByDomain();
    final EMail email = EMail.of("user1@example.com"); //$NON-NLS-1$
    final int result = comp.compare(email, email);
    assertEquals(0, result, "Compare not equal!"); //$NON-NLS-1$
   }


  /**
   * Test compare.
   */
  @Test
  public void compare4()
   {
    final ComparatorEMailByDomain comp = new ComparatorEMailByDomain();
    final EMail email1 = EMail.of("user1@example.com"); //$NON-NLS-1$
    final EMail email2 = EMail.of("user2@example.com"); //$NON-NLS-1$
    final int result = comp.compare(email1, email2);
    assertTrue(result < 0, "Compare not smaller!"); //$NON-NLS-1$
   }


  /**
   * Test compare.
   */
  @Test
  public void compare5()
   {
    final ComparatorEMailByDomain comp = new ComparatorEMailByDomain();
    final EMail email1 = EMail.of("user1@example.com"); //$NON-NLS-1$
    final EMail email2 = EMail.of("user2@example.com"); //$NON-NLS-1$
    final int result = comp.compare(email2, email1);
    assertTrue(result > 0, "Compare not greater!"); //$NON-NLS-1$
   }


  /**
   * Test compare.
   */
  @Test
  public void compare6()
   {
    final ComparatorEMailByDomain comp = new ComparatorEMailByDomain();
    final EMail email1 = EMail.of("user1@example.com"); //$NON-NLS-1$
    final EMail email2 = EMail.of("user1@powerstat.de"); //$NON-NLS-1$
    final int result = comp.compare(email1, email2);
    assertTrue(result < 0, "Compare not smaller!"); //$NON-NLS-1$
   }


  /**
   * Test compare.
   */
  @Test
  public void compare7()
   {
    final ComparatorEMailByDomain comp = new ComparatorEMailByDomain();
    final EMail email1 = EMail.of("user1@example.com"); //$NON-NLS-1$
    final EMail email2 = EMail.of("user1@powerstat.de"); //$NON-NLS-1$
    final int result = comp.compare(email2, email1);
    assertTrue(result > 0, "Compare not greater!"); //$NON-NLS-1$
   }

 }
