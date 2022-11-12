/*
 * Copyright (C) 2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.BloodGroup;


/**
 * Gender tests.
 */
public class BloodGroupTests
 {
  /**
   * Default constructor.
   */
  public BloodGroupTests()
   {
    super();
   }


  /**
   * Test getAction of Gender.
   */
  @Test
  public void getAction()
   {
    assertAll("constructor", //$NON-NLS-1$
      () -> assertEquals(0, BloodGroup.ON.getAction(), "0- action not as expected"), //$NON-NLS-1$
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
   * Test could donate to.
   */
  @SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts")
  @Test
  public void couldDonateTo()
   {
    assertAll("couldDonateTo", //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldDonateTo(BloodGroup.ON), "0- with 0- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldDonateTo(BloodGroup.OP), "0- with 0+ should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldDonateTo(BloodGroup.BN), "0- with B- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldDonateTo(BloodGroup.BP), "0- with B+ should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldDonateTo(BloodGroup.AN), "0- with A- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldDonateTo(BloodGroup.AP), "0- with A+ should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldDonateTo(BloodGroup.ABN), "0- with AB- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldDonateTo(BloodGroup.ABP), "0- with AB+ should be ok"), //$NON-NLS-1$

      () -> assertFalse(BloodGroup.OP.couldDonateTo(BloodGroup.ON), "0+ with 0- should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.OP.couldDonateTo(BloodGroup.OP), "0+ with 0+ should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.OP.couldDonateTo(BloodGroup.BN), "0+ with B- should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.OP.couldDonateTo(BloodGroup.BP), "0+ with B+ should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.OP.couldDonateTo(BloodGroup.AN), "0+ with A- should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.OP.couldDonateTo(BloodGroup.AP), "0+ with A+ should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.OP.couldDonateTo(BloodGroup.ABN), "0+ with AB- should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.OP.couldDonateTo(BloodGroup.ABP), "0+ with AB+ should be ok"), //$NON-NLS-1$

      () -> assertFalse(BloodGroup.BN.couldDonateTo(BloodGroup.ON), "B- with 0- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BN.couldDonateTo(BloodGroup.OP), "B- with 0+ should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.BN.couldDonateTo(BloodGroup.BN), "B- with B- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.BN.couldDonateTo(BloodGroup.BP), "B- with B+ should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BN.couldDonateTo(BloodGroup.AN), "B- with A- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BN.couldDonateTo(BloodGroup.AP), "B- with A+ should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.BN.couldDonateTo(BloodGroup.ABN), "B- with AB- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.BN.couldDonateTo(BloodGroup.ABP), "B- with AB+ should be ok"), //$NON-NLS-1$

      () -> assertFalse(BloodGroup.BP.couldDonateTo(BloodGroup.ON), "B+ with 0- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BP.couldDonateTo(BloodGroup.OP), "B+ with 0+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BP.couldDonateTo(BloodGroup.BN), "B+ with B- should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.BP.couldDonateTo(BloodGroup.BP), "B+ with B+ should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BP.couldDonateTo(BloodGroup.AN), "B+ with A- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BP.couldDonateTo(BloodGroup.AP), "B+ with A+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BP.couldDonateTo(BloodGroup.ABN), "B+ with AB- should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.BP.couldDonateTo(BloodGroup.ABP), "B+ with AB+ should be ok"), //$NON-NLS-1$

      () -> assertFalse(BloodGroup.AN.couldDonateTo(BloodGroup.ON), "A- with 0- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AN.couldDonateTo(BloodGroup.OP), "A- with 0+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AN.couldDonateTo(BloodGroup.BN), "A- with B- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AN.couldDonateTo(BloodGroup.BP), "A- with B+ should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.AN.couldDonateTo(BloodGroup.AN), "A- with A- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.AN.couldDonateTo(BloodGroup.AP), "A- with A+ should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.AN.couldDonateTo(BloodGroup.ABN), "A- with AB- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.AN.couldDonateTo(BloodGroup.ABP), "A- with AB+ should be ok"), //$NON-NLS-1$

      () -> assertFalse(BloodGroup.AP.couldDonateTo(BloodGroup.ON), "A+ with 0- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AP.couldDonateTo(BloodGroup.OP), "A+ with 0+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AP.couldDonateTo(BloodGroup.BN), "A+ with B- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AP.couldDonateTo(BloodGroup.BP), "A+ with B+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AP.couldDonateTo(BloodGroup.AN), "A+ with A- should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.AP.couldDonateTo(BloodGroup.AP), "A+ with A+ should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AP.couldDonateTo(BloodGroup.ABN), "A+ with AB- should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.AP.couldDonateTo(BloodGroup.ABP), "A+ with AB+ should be ok"), //$NON-NLS-1$

      () -> assertFalse(BloodGroup.ABN.couldDonateTo(BloodGroup.ON), "AB- with 0- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABN.couldDonateTo(BloodGroup.OP), "AB- with 0+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABN.couldDonateTo(BloodGroup.BN), "AB- with B- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABN.couldDonateTo(BloodGroup.BP), "AB- with B+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABN.couldDonateTo(BloodGroup.AN), "AB- with A- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABN.couldDonateTo(BloodGroup.AP), "AB- with A+ should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABN.couldDonateTo(BloodGroup.ABN), "AB- with AB- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABN.couldDonateTo(BloodGroup.ABP), "AB- with AB+ should be ok"), //$NON-NLS-1$

      () -> assertFalse(BloodGroup.ABP.couldDonateTo(BloodGroup.ON), "AB+ with 0- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABP.couldDonateTo(BloodGroup.OP), "AB+ with 0+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABP.couldDonateTo(BloodGroup.BN), "AB+ with B- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABP.couldDonateTo(BloodGroup.BP), "AB+ with B+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABP.couldDonateTo(BloodGroup.AN), "AB+ with A- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABP.couldDonateTo(BloodGroup.AP), "AB+ with A+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABP.couldDonateTo(BloodGroup.ABN), "AB+ with AB- should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABP.couldDonateTo(BloodGroup.ABP), "AB+ with AB+ should be ok") //$NON-NLS-1$
    );
   }


  /**
   * Test could receive from.
   */
  @SuppressWarnings("PMD.JUnitTestContainsTooManyAsserts")
  @Test
  public void couldReceiveFrom()
   {
    assertAll("couldReceiveFrom", //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ON.couldReceiveFrom(BloodGroup.ON), "0- with 0- should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ON.couldReceiveFrom(BloodGroup.OP), "0- with 0+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ON.couldReceiveFrom(BloodGroup.BN), "0- with B- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ON.couldReceiveFrom(BloodGroup.BP), "0- with B+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ON.couldReceiveFrom(BloodGroup.AN), "0- with A- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ON.couldReceiveFrom(BloodGroup.AP), "0- with A+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ON.couldReceiveFrom(BloodGroup.ABN), "0- with AB- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ON.couldReceiveFrom(BloodGroup.ABP), "0- with AB+ should not be ok"), //$NON-NLS-1$

      () -> assertTrue(BloodGroup.OP.couldReceiveFrom(BloodGroup.ON), "0+ with 0- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.OP.couldReceiveFrom(BloodGroup.OP), "0+ with 0+ should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.OP.couldReceiveFrom(BloodGroup.BN), "0+ with B- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.OP.couldReceiveFrom(BloodGroup.BP), "0+ with B+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.OP.couldReceiveFrom(BloodGroup.AN), "0+ with A- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.OP.couldReceiveFrom(BloodGroup.AP), "0+ with A+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.OP.couldReceiveFrom(BloodGroup.ABN), "0+ with AB- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.OP.couldReceiveFrom(BloodGroup.ABP), "0+ with AB+ should not be ok") ,//$NON-NLS-1$

      () -> assertTrue(BloodGroup.BN.couldReceiveFrom(BloodGroup.ON), "B- with 0- should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BN.couldReceiveFrom(BloodGroup.OP), "B- with 0+ should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.BN.couldReceiveFrom(BloodGroup.BN), "B- with B- should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BN.couldReceiveFrom(BloodGroup.BP), "B- with B+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BN.couldReceiveFrom(BloodGroup.AN), "B- with A- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BN.couldReceiveFrom(BloodGroup.AP), "B- with A+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BN.couldReceiveFrom(BloodGroup.ABN), "B- with AB- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BN.couldReceiveFrom(BloodGroup.ABP), "B- with AB+ should not be ok"), //$NON-NLS-1$

      () -> assertTrue(BloodGroup.BP.couldReceiveFrom(BloodGroup.ON), "B+ with 0- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.BP.couldReceiveFrom(BloodGroup.OP), "B+ with 0+ should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.BP.couldReceiveFrom(BloodGroup.BN), "B+ with B- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.BP.couldReceiveFrom(BloodGroup.BP), "B+ with B+ should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BP.couldReceiveFrom(BloodGroup.AN), "B+ with A- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BP.couldReceiveFrom(BloodGroup.AP), "B+ with A+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BP.couldReceiveFrom(BloodGroup.ABN), "B+ with AB- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.BP.couldReceiveFrom(BloodGroup.ABP), "B+ with AB+ should not be ok"), //$NON-NLS-1$

      () -> assertTrue(BloodGroup.AN.couldReceiveFrom(BloodGroup.ON), "A- with 0- should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AN.couldReceiveFrom(BloodGroup.OP), "A- with 0+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AN.couldReceiveFrom(BloodGroup.BN), "A- with B- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AN.couldReceiveFrom(BloodGroup.BP), "A- with B+ should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.AN.couldReceiveFrom(BloodGroup.AN), "A- with A- should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AN.couldReceiveFrom(BloodGroup.AP), "A- with A+ should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AN.couldReceiveFrom(BloodGroup.ABN), "A- with AB- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AN.couldReceiveFrom(BloodGroup.ABP), "A- with AB+ should not be ok"), //$NON-NLS-1$

      () -> assertTrue(BloodGroup.AP.couldReceiveFrom(BloodGroup.ON), "A+ with 0- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.AP.couldReceiveFrom(BloodGroup.OP), "A+ with 0+ should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AP.couldReceiveFrom(BloodGroup.BN), "A+ with B- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AP.couldReceiveFrom(BloodGroup.BP), "A+ with B+ should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.AP.couldReceiveFrom(BloodGroup.AN), "A+ with A- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.AP.couldReceiveFrom(BloodGroup.AP), "A+ with A+ should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AP.couldReceiveFrom(BloodGroup.ABN), "A+ with AB- should not be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.AP.couldReceiveFrom(BloodGroup.ABP), "A+ with AB+ should not be ok"), //$NON-NLS-1$

      () -> assertTrue(BloodGroup.ABN.couldReceiveFrom(BloodGroup.ON), "AB- with 0- should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABN.couldReceiveFrom(BloodGroup.OP), "AB- with 0+ should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABN.couldReceiveFrom(BloodGroup.BN), "AB- with B- should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABN.couldReceiveFrom(BloodGroup.BP), "AB- with B+ should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABN.couldReceiveFrom(BloodGroup.AN), "AB- with A- should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABN.couldReceiveFrom(BloodGroup.AP), "AB- with A+ should not be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABN.couldReceiveFrom(BloodGroup.ABN), "AB- with AB- should be ok"), //$NON-NLS-1$
      () -> assertFalse(BloodGroup.ABN.couldReceiveFrom(BloodGroup.ABP), "AB- with AB+ should not be ok"), //$NON-NLS-1$

      () -> assertTrue(BloodGroup.ABP.couldReceiveFrom(BloodGroup.ON), "AB+ with 0- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABP.couldReceiveFrom(BloodGroup.OP), "AB+ with 0+ should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABP.couldReceiveFrom(BloodGroup.BN), "AB+ with B- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABP.couldReceiveFrom(BloodGroup.BP), "AB+ with B+ should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABP.couldReceiveFrom(BloodGroup.AN), "AB+ with A- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABP.couldReceiveFrom(BloodGroup.AP), "AB+ with A+ should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABP.couldReceiveFrom(BloodGroup.ABN), "AB+ with AB- should be ok"), //$NON-NLS-1$
      () -> assertTrue(BloodGroup.ABP.couldReceiveFrom(BloodGroup.ABP), "AB+ with AB+ should be ok") //$NON-NLS-1$
    );
   }

 }
