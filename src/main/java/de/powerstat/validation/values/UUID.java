/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Universally Unique Identifier.
 *
 * Possibly DSGVO relevant.
 */
@ValueObject
public final class UUID implements Comparable<UUID>, IValueObject
 {
  /**
   * UUID.
   */
  private final java.util.UUID uuid;


  /**
   * Default constructor.
   */
  private UUID()
   {
    super();
    uuid = java.util.UUID.randomUUID();
   }


  /**
   * Constructor.
   *
   * @param value UUID string value
   */
  private UUID(final String value)
   {
    super();
    uuid = java.util.UUID.fromString(value);
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
    return new UUID(value);
   }


  /**
   * Returns the value of this UUID as an String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(uuid.toString());
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
    return uuid.hashCode();
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @SuppressWarnings({"PMD.SimplifyBooleanReturns"})
  @Override
  public boolean equals(final @Nullable Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof final UUID other))
     {
      return false;
     }
    return uuid.equals(other.uuid);
   }


  /**
   * Returns the string representation of this UUID.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "UUID[uuid=e58ed763-928c-4155-bee9-fdbaaadc15f3]"
   *
   * @return String representation of this UUID
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("UUID[uuid=").append(uuid.toString()).append(']'); //$NON-NLS-1$
    return builder.toString();
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
    return uuid.compareTo(obj.uuid);
   }

 }
