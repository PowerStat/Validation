/*
 * Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Port.
 *
 * Not DSGVO relevant.
 */
public final class Port implements Comparable<Port>
 {
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
  public Port(final int port)
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
    return new Port(port);
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
   * Get port.
   *
   * @return Port
   */
  public int getPort()
   {
    return this.port;
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
    final StringBuilder builder = new StringBuilder();
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
