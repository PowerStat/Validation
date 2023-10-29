/*
 * Copyright (C) 2019-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */


/**
 * Validation module.
 */
module de.powerstat.validation
 {
  exports de.powerstat.validation;
  exports de.powerstat.validation.comparators;
  exports de.powerstat.validation.entities;
  exports de.powerstat.validation.interfaces;
  exports de.powerstat.validation.values;
  exports de.powerstat.validation.values.containers;
  exports de.powerstat.validation.values.strategies;

  requires org.apache.logging.log4j;
  requires org.apache.commons.net;
  requires com.github.spotbugs.annotations;

 }
