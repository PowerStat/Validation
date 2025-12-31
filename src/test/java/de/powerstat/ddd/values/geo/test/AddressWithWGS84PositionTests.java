/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values.geo.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import de.powerstat.ddd.values.geo.AddressWithWGS84Position;
import de.powerstat.ddd.values.geo.BuildingNr;
import de.powerstat.ddd.values.geo.City;
import de.powerstat.ddd.values.geo.Country;
import de.powerstat.ddd.values.geo.PoBoxNumber;
import de.powerstat.ddd.values.geo.PostalCode;
import de.powerstat.ddd.values.geo.Street;
import de.powerstat.ddd.values.geo.WGS84Position;


/**
 * AddressWithWGS84Position tests.
 */
final class AddressWithWGS84PositionTests
 {
  /**
   * Line break unix.
   */
  private static final String LINEBREAK_UNIX = "\n"; //$NON-NLS-1$

  /**
   * Line break windows.
   */
  private static final String LINEBREAK_WIN = "\r\n"; //$NON-NLS-1$

  /**
   * DE germany.
   */
  private static final String DE = "DE"; //$NON-NLS-1$

  /**
   * Postal code.
   */
  private static final String POSTALCODE28307 = "28307"; //$NON-NLS-1$

  /**
   * City name.
   */
  private static final String BREMEN = "Bremen"; //$NON-NLS-1$

  /**
   * Street name.
   */
  private static final String ARBERGER_HEERSTR = "Arberger Heerstr."; //$NON-NLS-1$

  /**
   * Building nr 92.
   */
  private static final String BUILDINGNR92 = "92"; //$NON-NLS-1$

  /**
   * Test constant.
   */
  private static final String TEST = "Test"; //$NON-NLS-1$

  /**
   * Constructor constant.
   */
  private static final String CONSTRUCTOR = "constructor"; //$NON-NLS-1$

  /**
   * Address with wgs84 position is null constant.
   */
  private static final String ADDRESS_WITH_WGS84_POSITION_IS_NULL = "AddressWithWGS84Position is null"; //$NON-NLS-1$

  /**
   * Wrong country constant.
   */
  private static final String WRONG_COUNTRY = "Wrong country"; //$NON-NLS-1$

  /**
   * Wrong postal code constant.
   */
  private static final String WRONG_POSTAL_CODE = "Wrong postal code"; //$NON-NLS-1$

  /**
   * Wrong city constant.
   */
  private static final String WRONG_CITY = "Wrong city"; //$NON-NLS-1$

  /**
   * Illegal argument exception constant.
   */
  private static final String ILLEGAL_ARGUMENT_EXCEPTION = "Illegal argument exception"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ AddressWithWGS84PositionTests()
   {
    super();
   }


  /**
   * Constructor/factory test.
   */
  @Test
  /* default */ void testConstructor1()
   {
    final AddressWithWGS84Position address = AddressWithWGS84Position.of(Country.of(AddressWithWGS84PositionTests.DE), PostalCode.of(AddressWithWGS84PositionTests.POSTALCODE28307), City.of(AddressWithWGS84PositionTests.BREMEN), null, null, Street.of(AddressWithWGS84PositionTests.ARBERGER_HEERSTR), BuildingNr.of(AddressWithWGS84PositionTests.BUILDINGNR92), null, null, null, null, null, null, null, null, WGS84Position.of(0.0, 0.0, 0.0));
    assertAll(CONSTRUCTOR,
      () -> assertNotNull(address, ADDRESS_WITH_WGS84_POSITION_IS_NULL)
    );
   }


  /**
   * Constructor/Factory test.
   */
  @Test
  /* default */ void testConstructor2()
   {
    // Country, PostalCode, City, Province, District, Street, BuildingNr, BuildingName, SubBuilding, PoBoxNumber, Department, Neighbourhood, Block, BFPONumber, Lines, WGS84Position
    final AddressWithWGS84Position address = AddressWithWGS84Position.of("DE,28307,Bremen,,,,,,,12345,,,,,,0.0 0.0 0.0");
    assertAll(CONSTRUCTOR,
      () -> assertNotNull(address, ADDRESS_WITH_WGS84_POSITION_IS_NULL),
      () -> assertEquals(AddressWithWGS84PositionTests.DE, address.address().country().stringValue(), WRONG_COUNTRY),
      () -> assertEquals(AddressWithWGS84PositionTests.POSTALCODE28307, address.address().postalCode().stringValue(), WRONG_POSTAL_CODE),
      () -> assertEquals(AddressWithWGS84PositionTests.BREMEN, address.address().city().stringValue(), WRONG_CITY),
      () -> assertEquals(12345, address.address().poBoxNumber().poBoxNumber(), "Wrong pobox number")
      // address.getPosition().getLatitude()
      // address.getPosition().getLongitude()
      // address.getPosition().getAltitude()
    );
   }


  /**
   * Constructor/factory test.
   */
  @Test
  /* default */ void testConstructor3()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final AddressWithWGS84Position address = */ AddressWithWGS84Position.of("");
     }, ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Constructor/factory test.
   */
  @Test
  /* default */ void testConstructor4()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final AddressWithWGS84Position address = */ AddressWithWGS84Position.of("DE,28307,Bremen,,,,,,,12345,,,,,,0.0 0.0 0.0,1");
     }, ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Constructor/factory test.
   */
  @Test
  /* default */ void testConstructor5()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final AddressWithWGS84Position address = */ AddressWithWGS84Position.of("DE,28307,Bremen,,,,,,,12345");
     }, ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Constructor/Factory test.
   */
  @Test
  /* default */ void testConstructor6()
   {
    // Country, PostalCode, City, Province, District, Street, BuildingNr, BuildingName, SubBuilding, PoBoxNumber, Department, Neighbourhood, Block, BFPONumber, Lines, WGS84Position
    final AddressWithWGS84Position address = AddressWithWGS84Position.of("DE,28307,Bremen,Bremen,9,,,Home,SubB,,Software Quality,Friendly,Block,1,Lines,0.0 0.0 0.0");
    assertAll(CONSTRUCTOR,
      () -> assertNotNull(address, ADDRESS_WITH_WGS84_POSITION_IS_NULL),
      () -> assertEquals(AddressWithWGS84PositionTests.DE, address.address().country().stringValue(), WRONG_COUNTRY),
      () -> assertEquals(AddressWithWGS84PositionTests.POSTALCODE28307, address.address().postalCode().stringValue(), WRONG_POSTAL_CODE),
      () -> assertEquals(AddressWithWGS84PositionTests.BREMEN, address.address().city().stringValue(), WRONG_CITY)
      // Province
      // District
      // BuildingName
      // SubBuilding
      // Department
      // Neighbourhood
      // Block
      // BFPONumber
      // Lines
    );
   }


  /**
   * Test string value.
   */
  @Test
  /* default */ void testStringValue()
   {
    final WGS84Position pos = WGS84Position.of(0.0, 0.0, 0.0);
    final AddressWithWGS84Position address = AddressWithWGS84Position.of(Country.of(AddressWithWGS84PositionTests.DE), PostalCode.of(AddressWithWGS84PositionTests.POSTALCODE28307), City.of(AddressWithWGS84PositionTests.BREMEN), null, null, null, null, null, null, PoBoxNumber.of(12345), null, null, null, null, null, pos);
    assertEquals("\nPostfach 12345\n28307 Bremen\n\n0.0 0.0 0.0", address.stringValue().replace(AddressWithWGS84PositionTests.LINEBREAK_WIN, AddressWithWGS84PositionTests.LINEBREAK_UNIX).replace('\r', '\n'), "AddressWithWGS84Position not as expected");
   }

 }
