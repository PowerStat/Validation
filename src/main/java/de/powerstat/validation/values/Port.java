/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Port.
 *
 * Not DSGVO relevant.
 *
 * TODO min, max?
 */
public final class Port implements Comparable<Port>, IValueObject
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<Integer, Port> CACHE = new WeakHashMap<>();

  /**
   * Port.
   */
  private final int port;


  /**
   * Constructor.
   *
   * @param port Port 0-65535
   * @throws IndexOutOfBoundsException When the port is less than 0 or greater than 65535
   */
  private Port(final int port)
   {
    super();
    if ((port < 0) || (port > 65535))
     {
      throw new IndexOutOfBoundsException("Port number out of range (0-65535)!"); //$NON-NLS-1$
     }
    this.port = port;
   }


  /**
   * Port factory.
   *
   * @param port Port 0-65535
   * @return Port object
   */
  public static Port of(final int port)
   {
    /*
    synchronized (Port.class)
     {
      Port obj = Port.CACHE.get(port);
      if (obj != null)
       {
        return obj;
       }
      obj = new Port(port);
      Port.CACHE.put(Integer.valueOf(port), obj);
      return obj;
     }
    */
    return new Port(port);
   }


  /**
   * Port factory.
   *
   * @param port Port 0-65535
   * @return Port object
   */
  public static Port of(final String port)
   {
    return of(Integer.parseInt(port));
   }


  /**
   * Is system port (0-1023).
   *
   * @return true: system port, otherwise false
   */
  public boolean isSystem()
   {
    return this.port <= 1023;
   }


  /**
   * Is registered port (1024-49151).
   *
   * @return true: registered port, otherwise false
   */
  public boolean isRegistered()
   {
    return (this.port >= 1024) && (this.port <= 49151);
   }


  /**
   * Is dynamic port (49152-65535).
   *
   * @return true: dynamic port, otherwise false
   */
  public boolean isDynamic()
   {
    return (this.port >= 49152);
   }


  /**
   * Returns the value of this Port as an int.
   *
   * @return The numeric value represented by this object after conversion to type int.
   */
  public int intValue()
   {
    return this.port;
   }


  /**
   * Returns the value of this Port as an String.
   *
   * @return The numeric value represented by this object after conversion to type String.
   */
  @Override
  public String stringValue()
   {
    return String.valueOf(this.port);
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
    return Integer.hashCode(this.port);
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
    if (!(obj instanceof Port))
     {
      return false;
     }
    final Port other = (Port)obj;
    return this.port == other.port;
   }


  /**
   * Returns the string representation of this Port.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Port[port=0]"
   *
   * @return String representation of this Port
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("Port[port=").append(this.port).append(']'); //$NON-NLS-1$
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
  public int compareTo(final Port obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(this.port, obj.port);
   }

 }
