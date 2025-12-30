/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.containers.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import de.powerstat.ddd.containers.NTuple5nc;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * NTuple5nc tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class NTuple5ncTests
 {
  /**
   * Default constructor.
   */
  /* default */ NTuple5ncTests()
   {
    super();
   }


  /**
   * Factory test.
   */
  @Test
  /* default */ void testOfInt()
   {
    final NTuple5nc<Integer, Integer, Integer, Integer, Integer> tuple = NTuple5nc.of(Integer.valueOf(1), Integer.valueOf(4711), Integer.valueOf(815), Integer.valueOf(4), Integer.valueOf(5));
    assertAll("testGetValue", //$NON-NLS-1$
      () -> assertEquals(1, tuple.obj1().intValue(), "t1 not as expected"), //$NON-NLS-1$
      () -> assertEquals(4711, tuple.obj2().intValue(), "t2 not as expected"), //$NON-NLS-1$
      () -> assertEquals(815, tuple.obj3().intValue(), "t3 not as expected"), //$NON-NLS-1$
      () -> assertEquals(4, tuple.obj4().intValue(), "t4 not as expected"), //$NON-NLS-1$
      () -> assertEquals(5, tuple.obj5().intValue(), "t5 not as expected") //$NON-NLS-1$
    );
   }

 }
