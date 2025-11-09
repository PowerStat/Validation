/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.impl;


/**
 * ISBN13 publisher interface.
 */
public interface IISBN13Publisher
 {
  /**
   * Publisher.
   *
   * @param rest Rest of isbn number
   * @return Publisher number (variable length)
   * @throws IllegalArgumentException When an illegal character appears
   */
  public String publisher(final String rest);

 }
