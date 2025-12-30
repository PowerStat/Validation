/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.comparators;


import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

import de.powerstat.ddd.values.EMail;


/**
 * Comparator for EMail values by reverse domain and local part.
 */
public class ComparatorEMailByDomain implements Comparator<EMail>, Serializable
 {
  /**
   * Serial version unique identifier.
   */
  private static final long serialVersionUID = 1L;


  /**
   * Default constructor.
   */
  public ComparatorEMailByDomain()
   {
    super();
   }


  /**
   * Compare two EMail value objects.
   *
   * @param email1 Email 1
   * @param email2 Email 2
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
   */
  @Override
  public int compare(final EMail email1, final EMail email2)
   {
    Objects.requireNonNull(email1, "email1"); //$NON-NLS-1$
    Objects.requireNonNull(email2, "email2"); //$NON-NLS-1$
    int result = email1.getReverseDomainPart().compareTo(email2.getReverseDomainPart());
    if (result == 0)
     {
      result = email1.getLocalPart().compareTo(email2.getLocalPart());
     }
    return result;
   }

 }
