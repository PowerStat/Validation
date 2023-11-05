/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Universally Unique Identifier.
 *
 * @param uuid UUID
 *
 * Possibly DSGVO relevant.
 */
public record UUID(java.util.UUID uuid) implements Comparable<UUID>, IValueObject
 {
  /**
   * Constructor.
   *
   * @param uuid UUID
   */
  public UUID
   {
   }


  /**
   * Default constructor.
   */
  public UUID()
   {
    this(java.util.UUID.randomUUID());
   }


  /**
   * UUID factory.
   *
   * @return UUID object
   */
  public static UUID of()
   {
    return new UUID();
   }


  /**
   * UUID factory.
   *
   * @param value UUID string
   * @return UUID object
   */
  public static UUID of(final String value)
   {
    return new UUID(java.util.UUID.fromString(value));
   }


  /**
   * Returns the value of this UUID as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.uuid.toString();
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final UUID obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.uuid.compareTo(obj.uuid);
   }

 }
