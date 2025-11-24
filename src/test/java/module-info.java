/*
 * Copyright (C) 2019-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */


/**
 * Validation module in test.
 */
open module de.powerstat.validation
 {
  exports de.powerstat.validation;
  exports de.powerstat.validation.comparators;
  exports de.powerstat.validation.containers;
  exports de.powerstat.validation.entities;
  exports de.powerstat.validation.interfaces;
  exports de.powerstat.validation.values;
  exports de.powerstat.validation.values.strategies;

  requires org.apache.logging.log4j;
  requires org.apache.commons.net;

  requires com.github.spotbugs.annotations;
  requires org.junit.jupiter.api;
  requires org.junit.jupiter.params;
  requires org.junit.platform.launcher;
  requires org.junit.platform.suite.api;
  requires nl.jqno.equalsverifier;
  // requires io.cucumber.java;
  // requires io.cucumber.junit.platform.engine;

 }
