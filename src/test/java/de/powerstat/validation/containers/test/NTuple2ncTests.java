/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.containers.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import de.powerstat.validation.containers.NTuple2nc;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * NTuple2nc tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class NTuple2ncTests
 {
  /**
   * Default constructor.
   */
  /* default */ NTuple2ncTests()
   {
    super();
   }


  /**
   * Factory test.
   */
  @Test
  /* default */ void testOfInt()
   {
    final NTuple2nc<Integer, Integer> tuple = NTuple2nc.of(Integer.valueOf(1), Integer.valueOf(4711));
    assertAll("testGetValue", //$NON-NLS-1$
      () -> assertEquals(1, tuple.obj1().intValue(), "obj1 not as expected"), //$NON-NLS-1$
      () -> assertEquals(4711, tuple.obj2().intValue(), "obj2 not as expected") //$NON-NLS-1$
    );
   }

 }
