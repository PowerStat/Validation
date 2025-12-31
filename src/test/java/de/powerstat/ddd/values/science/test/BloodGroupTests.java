/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.science.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.powerstat.ddd.values.science.BloodGroup;


/**
 * BloodGroup tests.
 */
final class BloodGroupTests
 {
  /**
   * Compatible blood groups.
   */
  private static final String BG_ABPABP_OK = "AB+ with AB+ should be ok"; //$NON-NLS-1$

  /**
   * Compatible blood groups.
   */
  private static final String BG_ABNABP_OK = "AB- with AB+ should be ok"; //$NON-NLS-1$

  /**
   * Compatible blood groups.
   */
  private static final String BG_ABNABN_OK = "AB- with AB- should be ok"; //$NON-NLS-1$

  /**
   * Compatible blood groups.
   */
  private static final String BG_APAP_OK = "A+ with A+ should be ok"; //$NON-NLS-1$

  /**
   * Compatible blood groups.
   */
  private static final String BG_ANAN_OK = "A- with A- should be ok"; //$NON-NLS-1$

  /**
   * Compatible blood groups.
   */
  private static final String BG_BPBP_OK = "B+ with B+ should be ok"; //$NON-NLS-1$

  /**
   * Compatible blood groups.
   */
  private static final String BG_BNBN_OK = "B- with B- should be ok"; //$NON-NLS-1$

  /**
   * Compatible blood groups.
   */
  private static final String BG_0P0P_OK = "0+ with 0+ should be ok"; //$NON-NLS-1$

  /**
   * Compatible blood groups.
   */
  private static final String BG_0N0N_OK = "0- with 0- should be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_ABNAP_NOT_OK = "AB- with A+ should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_ABNBP_NOT_OK = "AB- with B+ should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_ABN0P_NOT_OK = "AB- with 0+ should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_APABN_NOT_OK = "A+ with AB- should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_APBP_NOT_OK = "A+ with B+ should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_APBN_NOT_OK = "A+ with B- should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_ANBP_NOT_OK = "A- with B+ should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_ANBN_NOT_OK = "A- with B- should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_AN0P_NOT_OK = "A- with 0+ should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_BPABN_NOT_OK = "B+ with AB- should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_BPAP_NOT_OK = "B+ with A+ should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_BPAN_NOT_OK = "B+ with A- should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_BNAP_NOT_OK = "B- with A+ should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_BNAN_NOT_OK = "B- with A- should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_BN0P_NOT_OK = "B- with 0+ should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_0PABN_NOT_OK = "0+ with AB- should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_0PAN_NOT_OK = "0+ with A- should not be ok"; //$NON-NLS-1$

  /**
   * Incompatible bllod groups.
   */
  private static final String BG_0PBN_NOT_OK = "0+ with B- should not be ok"; //$NON-NLS-1$

  /**
   * ON constant.
   */
  private static final String ON = "ON"; //$NON-NLS-1$

  /**
   * 0- action not as expected constant.
   */
  private static final String ZERO_NEGATIVE_ACTION_NOT_AS_EXPECTED = "0- action not as expected";


  /**
   * Default constructor.
   */
  /* default */ BloodGroupTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(0, BloodGroup.of(ON).getAction(), ZERO_NEGATIVE_ACTION_NOT_AS_EXPECTED);
   }


  /**
   * Test getAction of BloodGroup.
   */
  @Test
  /* default */ void testGetAction()
   {
    assertAll("getAction", //$NON-NLS-1$
      () -> assertEquals(0, BloodGroup.ON.getAction(), ZERO_NEGATIVE_ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(1, BloodGroup.OP.getAction(), "0+ action not as expected"), //$NON-NLS-1$
      () -> assertEquals(2, BloodGroup.AN.getAction(), "A- action not as expected"), //$NON-NLS-1$
      () -> assertEquals(3, BloodGroup.AP.getAction(), "A+ action not as expected"), //$NON-NLS-1$
      () -> assertEquals(4, BloodGroup.BN.getAction(), "B- action not as expected"), //$NON-NLS-1$
      () -> assertEquals(5, BloodGroup.BP.getAction(), "B+ action not as expected"), //$NON-NLS-1$
      () -> assertEquals(6, BloodGroup.ABN.getAction(), "AB- action not as expected"), //$NON-NLS-1$
      () -> assertEquals(7, BloodGroup.ABP.getAction(), "AB+ action not as expected") //$NON-NLS-1$
    );
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final BloodGroup group = BloodGroup.ON;
    assertEquals(ON, group.stringValue(), "stringValue not as expected");
   }


  /**
   * Test could donate to.
   */
  @SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts")
  @Test
  /* default */ void testCouldDonateTo()
   {
    assertAll("couldDonateTo", //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldDonateTo(BloodGroup.ON), BloodGroupTests.BG_0N0N_OK),
      () -> assertTrue(BloodGroup.ON.couldDonateTo(BloodGroup.OP), "0- with 0+ should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldDonateTo(BloodGroup.BN), "0- with B- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldDonateTo(BloodGroup.BP), "0- with B+ should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldDonateTo(BloodGroup.AN), "0- with A- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldDonateTo(BloodGroup.AP), "0- with A+ should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldDonateTo(BloodGroup.ABN), "0- with AB- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldDonateTo(BloodGroup.ABP), "0- with AB+ should be ok"), //$NON-NLS-1$

      () -> assertFalse(BloodGroup.OP.couldDonateTo(BloodGroup.ON), "0+ with 0- should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.OP.couldDonateTo(BloodGroup.OP), BloodGroupTests.BG_0P0P_OK),
      () -> assertFalse(BloodGroup.OP.couldDonateTo(BloodGroup.BN), BloodGroupTests.BG_0PBN_NOT_OK),
      () -> assertTrue(BloodGroup.OP.couldDonateTo(BloodGroup.BP), "0+ with B+ should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.OP.couldDonateTo(BloodGroup.AN), BloodGroupTests.BG_0PAN_NOT_OK),
      () -> assertTrue(BloodGroup.OP.couldDonateTo(BloodGroup.AP), "0+ with A+ should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.OP.couldDonateTo(BloodGroup.ABN), BloodGroupTests.BG_0PABN_NOT_OK),
      () -> assertTrue(BloodGroup.OP.couldDonateTo(BloodGroup.ABP), "0+ with AB+ should be ok"), //$NON-NLS-1$

      () -> assertFalse(BloodGroup.BN.couldDonateTo(BloodGroup.ON), "B- with 0- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BN.couldDonateTo(BloodGroup.OP), BloodGroupTests.BG_BN0P_NOT_OK),
      () -> assertTrue(BloodGroup.BN.couldDonateTo(BloodGroup.BN), BloodGroupTests.BG_BNBN_OK),
      () -> assertTrue(BloodGroup.BN.couldDonateTo(BloodGroup.BP), "B- with B+ should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BN.couldDonateTo(BloodGroup.AN), BloodGroupTests.BG_BNAN_NOT_OK),
      () -> assertFalse(BloodGroup.BN.couldDonateTo(BloodGroup.AP), BloodGroupTests.BG_BNAP_NOT_OK),
      () -> assertTrue(BloodGroup.BN.couldDonateTo(BloodGroup.ABN), "B- with AB- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.BN.couldDonateTo(BloodGroup.ABP), "B- with AB+ should be ok"), //$NON-NLS-1$

      () -> assertFalse(BloodGroup.BP.couldDonateTo(BloodGroup.ON), "B+ with 0- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BP.couldDonateTo(BloodGroup.OP), "B+ with 0+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BP.couldDonateTo(BloodGroup.BN), "B+ with B- should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.BP.couldDonateTo(BloodGroup.BP), BloodGroupTests.BG_BPBP_OK),
      () -> assertFalse(BloodGroup.BP.couldDonateTo(BloodGroup.AN), BloodGroupTests.BG_BPAN_NOT_OK),
      () -> assertFalse(BloodGroup.BP.couldDonateTo(BloodGroup.AP), BloodGroupTests.BG_BPAP_NOT_OK),
      () -> assertFalse(BloodGroup.BP.couldDonateTo(BloodGroup.ABN), BloodGroupTests.BG_BPABN_NOT_OK),
      () -> assertTrue(BloodGroup.BP.couldDonateTo(BloodGroup.ABP), "B+ with AB+ should be ok"), //$NON-NLS-1$

      () -> assertFalse(BloodGroup.AN.couldDonateTo(BloodGroup.ON), "A- with 0- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AN.couldDonateTo(BloodGroup.OP), BloodGroupTests.BG_AN0P_NOT_OK),
      () -> assertFalse(BloodGroup.AN.couldDonateTo(BloodGroup.BN), BloodGroupTests.BG_ANBN_NOT_OK),
      () -> assertFalse(BloodGroup.AN.couldDonateTo(BloodGroup.BP), BloodGroupTests.BG_ANBP_NOT_OK),
      () -> assertTrue(BloodGroup.AN.couldDonateTo(BloodGroup.AN), BloodGroupTests.BG_ANAN_OK),
      () -> assertTrue(BloodGroup.AN.couldDonateTo(BloodGroup.AP), "A- with A+ should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.AN.couldDonateTo(BloodGroup.ABN), "A- with AB- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.AN.couldDonateTo(BloodGroup.ABP), "A- with AB+ should be ok"), //$NON-NLS-1$

      () -> assertFalse(BloodGroup.AP.couldDonateTo(BloodGroup.ON), "A+ with 0- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AP.couldDonateTo(BloodGroup.OP), "A+ with 0+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AP.couldDonateTo(BloodGroup.BN), BloodGroupTests.BG_APBN_NOT_OK),
      () -> assertFalse(BloodGroup.AP.couldDonateTo(BloodGroup.BP), BloodGroupTests.BG_APBP_NOT_OK),
      () -> assertFalse(BloodGroup.AP.couldDonateTo(BloodGroup.AN), "A+ with A- should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.AP.couldDonateTo(BloodGroup.AP), BloodGroupTests.BG_APAP_OK),
      () -> assertFalse(BloodGroup.AP.couldDonateTo(BloodGroup.ABN), BloodGroupTests.BG_APABN_NOT_OK),
      () -> assertTrue(BloodGroup.AP.couldDonateTo(BloodGroup.ABP), "A+ with AB+ should be ok"), //$NON-NLS-1$

      () -> assertFalse(BloodGroup.ABN.couldDonateTo(BloodGroup.ON), "AB- with 0- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABN.couldDonateTo(BloodGroup.OP), BloodGroupTests.BG_ABN0P_NOT_OK),
      () -> assertFalse(BloodGroup.ABN.couldDonateTo(BloodGroup.BN), "AB- with B- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABN.couldDonateTo(BloodGroup.BP), BloodGroupTests.BG_ABNBP_NOT_OK),
      () -> assertFalse(BloodGroup.ABN.couldDonateTo(BloodGroup.AN), "AB- with A- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABN.couldDonateTo(BloodGroup.AP), BloodGroupTests.BG_ABNAP_NOT_OK),
      () -> assertTrue(BloodGroup.ABN.couldDonateTo(BloodGroup.ABN), BloodGroupTests.BG_ABNABN_OK),
      () -> assertTrue(BloodGroup.ABN.couldDonateTo(BloodGroup.ABP), BloodGroupTests.BG_ABNABP_OK),

      () -> assertFalse(BloodGroup.ABP.couldDonateTo(BloodGroup.ON), "AB+ with 0- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABP.couldDonateTo(BloodGroup.OP), "AB+ with 0+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABP.couldDonateTo(BloodGroup.BN), "AB+ with B- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABP.couldDonateTo(BloodGroup.BP), "AB+ with B+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABP.couldDonateTo(BloodGroup.AN), "AB+ with A- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABP.couldDonateTo(BloodGroup.AP), "AB+ with A+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABP.couldDonateTo(BloodGroup.ABN), "AB+ with AB- should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABP.couldDonateTo(BloodGroup.ABP), BloodGroupTests.BG_ABPABP_OK)
    );
   }


  /**
   * Test could receive from.
   */
  @SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts")
  @Test
  /* default */ void testCouldReceiveFrom()
   {
    assertAll("couldReceiveFrom", //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldReceiveFrom(BloodGroup.ON), BloodGroupTests.BG_0N0N_OK),
      () -> assertFalse(BloodGroup.ON.couldReceiveFrom(BloodGroup.OP), "0- with 0+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ON.couldReceiveFrom(BloodGroup.BN), "0- with B- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ON.couldReceiveFrom(BloodGroup.BP), "0- with B+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ON.couldReceiveFrom(BloodGroup.AN), "0- with A- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ON.couldReceiveFrom(BloodGroup.AP), "0- with A+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ON.couldReceiveFrom(BloodGroup.ABN), "0- with AB- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ON.couldReceiveFrom(BloodGroup.ABP), "0- with AB+ should not be ok"), //$NON-NLS-1$

      () -> assertTrue(BloodGroup.OP.couldReceiveFrom(BloodGroup.ON), "0+ with 0- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.OP.couldReceiveFrom(BloodGroup.OP), BloodGroupTests.BG_0P0P_OK),
      () -> assertFalse(BloodGroup.OP.couldReceiveFrom(BloodGroup.BN), BloodGroupTests.BG_0PBN_NOT_OK),
      () -> assertFalse(BloodGroup.OP.couldReceiveFrom(BloodGroup.BP), "0+ with B+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.OP.couldReceiveFrom(BloodGroup.AN), BloodGroupTests.BG_0PAN_NOT_OK),
      () -> assertFalse(BloodGroup.OP.couldReceiveFrom(BloodGroup.AP), "0+ with A+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.OP.couldReceiveFrom(BloodGroup.ABN), BloodGroupTests.BG_0PABN_NOT_OK),
      () -> assertFalse(BloodGroup.OP.couldReceiveFrom(BloodGroup.ABP), "0+ with AB+ should not be ok"), //$NON-NLS-1$

      () -> assertTrue(BloodGroup.BN.couldReceiveFrom(BloodGroup.ON), "B- with 0- should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BN.couldReceiveFrom(BloodGroup.OP), BloodGroupTests.BG_BN0P_NOT_OK),
      () -> assertTrue(BloodGroup.BN.couldReceiveFrom(BloodGroup.BN), BloodGroupTests.BG_BNBN_OK),
      () -> assertFalse(BloodGroup.BN.couldReceiveFrom(BloodGroup.BP), "B- with B+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BN.couldReceiveFrom(BloodGroup.AN), BloodGroupTests.BG_BNAN_NOT_OK),
      () -> assertFalse(BloodGroup.BN.couldReceiveFrom(BloodGroup.AP), BloodGroupTests.BG_BNAP_NOT_OK),
      () -> assertFalse(BloodGroup.BN.couldReceiveFrom(BloodGroup.ABN), "B- with AB- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BN.couldReceiveFrom(BloodGroup.ABP), "B- with AB+ should not be ok"), //$NON-NLS-1$

      () -> assertTrue(BloodGroup.BP.couldReceiveFrom(BloodGroup.ON), "B+ with 0- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.BP.couldReceiveFrom(BloodGroup.OP), "B+ with 0+ should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.BP.couldReceiveFrom(BloodGroup.BN), "B+ with B- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.BP.couldReceiveFrom(BloodGroup.BP), BloodGroupTests.BG_BPBP_OK),
      () -> assertFalse(BloodGroup.BP.couldReceiveFrom(BloodGroup.AN), BloodGroupTests.BG_BPAN_NOT_OK),
      () -> assertFalse(BloodGroup.BP.couldReceiveFrom(BloodGroup.AP), BloodGroupTests.BG_BPAP_NOT_OK),
      () -> assertFalse(BloodGroup.BP.couldReceiveFrom(BloodGroup.ABN), BloodGroupTests.BG_BPABN_NOT_OK),
      () -> assertFalse(BloodGroup.BP.couldReceiveFrom(BloodGroup.ABP), "B+ with AB+ should not be ok"), //$NON-NLS-1$

      () -> assertTrue(BloodGroup.AN.couldReceiveFrom(BloodGroup.ON), "A- with 0- should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AN.couldReceiveFrom(BloodGroup.OP), BloodGroupTests.BG_AN0P_NOT_OK),
      () -> assertFalse(BloodGroup.AN.couldReceiveFrom(BloodGroup.BN), BloodGroupTests.BG_ANBN_NOT_OK),
      () -> assertFalse(BloodGroup.AN.couldReceiveFrom(BloodGroup.BP), BloodGroupTests.BG_ANBP_NOT_OK),
      () -> assertTrue(BloodGroup.AN.couldReceiveFrom(BloodGroup.AN), BloodGroupTests.BG_ANAN_OK),
      () -> assertFalse(BloodGroup.AN.couldReceiveFrom(BloodGroup.AP), "A- with A+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AN.couldReceiveFrom(BloodGroup.ABN), "A- with AB- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AN.couldReceiveFrom(BloodGroup.ABP), "A- with AB+ should not be ok"), //$NON-NLS-1$

      () -> assertTrue(BloodGroup.AP.couldReceiveFrom(BloodGroup.ON), "A+ with 0- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.AP.couldReceiveFrom(BloodGroup.OP), "A+ with 0+ should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AP.couldReceiveFrom(BloodGroup.BN), BloodGroupTests.BG_APBN_NOT_OK),
      () -> assertFalse(BloodGroup.AP.couldReceiveFrom(BloodGroup.BP), BloodGroupTests.BG_APBP_NOT_OK),
      () -> assertTrue(BloodGroup.AP.couldReceiveFrom(BloodGroup.AN), "A+ with A- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.AP.couldReceiveFrom(BloodGroup.AP), BloodGroupTests.BG_APAP_OK),
      () -> assertFalse(BloodGroup.AP.couldReceiveFrom(BloodGroup.ABN), BloodGroupTests.BG_APABN_NOT_OK),
      () -> assertFalse(BloodGroup.AP.couldReceiveFrom(BloodGroup.ABP), "A+ with AB+ should not be ok"), //$NON-NLS-1$

      () -> assertTrue(BloodGroup.ABN.couldReceiveFrom(BloodGroup.ON), "AB- with 0- should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABN.couldReceiveFrom(BloodGroup.OP), BloodGroupTests.BG_ABN0P_NOT_OK),
      () -> assertTrue(BloodGroup.ABN.couldReceiveFrom(BloodGroup.BN), "AB- with B- should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABN.couldReceiveFrom(BloodGroup.BP), BloodGroupTests.BG_ABNBP_NOT_OK),
      () -> assertTrue(BloodGroup.ABN.couldReceiveFrom(BloodGroup.AN), "AB- with A- should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABN.couldReceiveFrom(BloodGroup.AP), BloodGroupTests.BG_ABNAP_NOT_OK),
      () -> assertTrue(BloodGroup.ABN.couldReceiveFrom(BloodGroup.ABN), BloodGroupTests.BG_ABNABN_OK),
      () -> assertFalse(BloodGroup.ABN.couldReceiveFrom(BloodGroup.ABP), "AB- with AB+ should not be ok"), //$NON-NLS-1$

      () -> assertTrue(BloodGroup.ABP.couldReceiveFrom(BloodGroup.ON), "AB+ with 0- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABP.couldReceiveFrom(BloodGroup.OP), "AB+ with 0+ should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABP.couldReceiveFrom(BloodGroup.BN), "AB+ with B- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABP.couldReceiveFrom(BloodGroup.BP), "AB+ with B+ should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABP.couldReceiveFrom(BloodGroup.AN), "AB+ with A- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABP.couldReceiveFrom(BloodGroup.AP), "AB+ with A+ should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABP.couldReceiveFrom(BloodGroup.ABN), "AB+ with AB- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABP.couldReceiveFrom(BloodGroup.ABP), BloodGroupTests.BG_ABPABP_OK)
    );
   }

 }
