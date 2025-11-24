/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
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
  String publisher(String rest);

 }
