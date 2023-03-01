/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Port.
 *
 * @param port Port 0-65535
 * 
 * Not DSGVO relevant.
 */
public record Port(int port) implements Comparable<Port>
 {
  /**
   * Constructor.
   *
   * @throws IndexOutOfBoundsException When the port is less than 0 or greater than 65535
   */
  public Port
   {
    if ((port < 0) || (port > 65535))
     {
      throw new IndexOutOfBoundsException("Port number out of range (0-65535)!"); //$NON-NLS-1$
     }
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
