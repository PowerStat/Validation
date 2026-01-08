/*
 * Copyright (C) 2019-2026 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */


/**
 * DDD module.
 */
module de.powerstat.ddd
 {
  exports de.powerstat.ddd;
  exports de.powerstat.ddd.comparators;
  exports de.powerstat.ddd.containers;
  exports de.powerstat.ddd.entities;
  exports de.powerstat.ddd.interfaces;
  exports de.powerstat.ddd.values;
  exports de.powerstat.ddd.values.comm;
  exports de.powerstat.ddd.values.finance;
  exports de.powerstat.ddd.values.geo;
  exports de.powerstat.ddd.values.science;
  exports de.powerstat.ddd.values.social;
  exports de.powerstat.ddd.values.strategies;
  exports de.powerstat.ddd.values.time;

  requires org.apache.logging.log4j;
  requires org.apache.commons.net;
  requires com.github.spotbugs.annotations;
  requires org.checkerframework.checker.qual;
  requires org.jmolecules.ddd;

 }
