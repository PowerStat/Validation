/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import nl.jqno.equalsverifier.EqualsVerifier;
import de.powerstat.validation.values.Address;
import de.powerstat.validation.values.AddressWithWGS84Position;
import de.powerstat.validation.values.BFPONumber;
import de.powerstat.validation.values.Block;
import de.powerstat.validation.values.BuildingName;
import de.powerstat.validation.values.BuildingNr;
import de.powerstat.validation.values.City;
import de.powerstat.validation.values.Country;
import de.powerstat.validation.values.Department;
import de.powerstat.validation.values.District;
import de.powerstat.validation.values.Lines;
import de.powerstat.validation.values.Neighbourhood;
import de.powerstat.validation.values.PoBoxNumber;
import de.powerstat.validation.values.PostalCode;
import de.powerstat.validation.values.Province;
import de.powerstat.validation.values.Street;
import de.powerstat.validation.values.SubBuilding;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Address tests.
 */
@SuppressFBWarnings({"RV_NEGATING_RESULT_OF_COMPARETO", "SPP_USE_ZERO_WITH_COMPARATOR", "PRMC_POSSIBLY_REDUNDANT_METHOD_CALLS"})
final class AddressTests
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
   * Street name.
   */
  private static final String ARBERGER_HEERSTR = "Arberger Heerstr."; //$NON-NLS-1$

  /**
   * Street name.
   */
  private static final String BIBLIOTHEKSTRASSE = "Bibliothekstraße"; //$NON-NLS-1$

  /**
   * Test street.
   */
  private static final String TEST_STR = "Test str."; //$NON-NLS-1$

  /**
   * City name.
   */
  private static final String BREMEN = "Bremen"; //$NON-NLS-1$

  /**
   * City name.
   */
  private static final String HANNOVER = "Hannover"; //$NON-NLS-1$

  /**
   * City name.
   */
  private static final String AICHI = "AICHI"; //$NON-NLS-1$

  /**
   * City name.
   */
  private static final String BEDFORDSHIRE = "Bedfordshire"; //$NON-NLS-1$

  /**
   * Postal code.
   */
  private static final String POSTALCODE28307 = "28307"; //$NON-NLS-1$

  /**
   * Postal code.
   */
  private static final String POSTALCODE28359 = "28359"; //$NON-NLS-1$

  /**
   * Postal code.
   */
  private static final String POSTALCODE_GB = "AL3 8QE"; //$NON-NLS-1$

  /**
   * Postal code.
   */
  private static final String POSTALCODE_JP = "4434567"; //$NON-NLS-1$

  /**
   * Postal code.
   */
  private static final String POSTALCODE_HK = "12345"; //$NON-NLS-1$

  /**
   * Building nr.
   */
  private static final String BUILDINGNR0815 = "0815"; //$NON-NLS-1$

  /**
   * Postal code.
   */
  private static final String POSTALCODE4711 = "4711"; //$NON-NLS-1$

  /**
   * Test city.
   */
  private static final String TESTCITY = "Testcity"; //$NON-NLS-1$

  /**
   * Test building.
   */
  private static final String TESTBUILDING = "Testbuilding"; //$NON-NLS-1$

  /**
   * Test building.
   */
  private static final String TEST_BUILDING = "TestBuilding"; //$NON-NLS-1$

  /**
   * Building.
   */
  private static final String BUILDING = "Building"; //$NON-NLS-1$

  /**
   * Test sub building.
   */
  private static final String TEST_SUB_BUILDING = "TestSubBuilding"; //$NON-NLS-1$

  /**
   * Sub building.
   */
  private static final String SUBBUILDING = "SubB"; //$NON-NLS-1$

  /**
   * Test province.
   */
  private static final String TESTPROVINCE = "Testprovince"; //$NON-NLS-1$

  /**
   * District 9.
   */
  private static final String DISTRICT = "9"; //$NON-NLS-1$

  /**
   * Test block 13.
   */
  private static final String TESTBLOCK13 = "Testblock13"; //$NON-NLS-1$

  /**
   * Block.
   */
  private static final String BLK = "blk"; //$NON-NLS-1$

  /**
   * Test district.
   */
  private static final String TESTDISTRICT = "Testdistrict"; //$NON-NLS-1$

  /**
   * Test neighbour.
   */
  private static final String TESTNEIGHBOUR = "Testneighbour"; //$NON-NLS-1$

  /**
   * Neighbour.
   */
  private static final String NEIGHBOUR = "neighbour"; //$NON-NLS-1$

  /**
   * Test department.
   */
  private static final String TESTDEPARTMENT = "Testdepartment"; //$NON-NLS-1$

  /**
   * Test lines.
   */
  private static final String TESTLINES = "Testlines"; //$NON-NLS-1$

  /**
   * Test.
   */
  private static final String TEST = "test"; //$NON-NLS-1$

  /**
   * Test.
   */
  private static final String TEST2 = "Test"; //$NON-NLS-1$

  /**
   * Kai Hofmann.
   */
  private static final String KAI_HOFMANN = "Kai Hofmann"; //$NON-NLS-1$

  /**
   * Address is null constant.
   */
  private static final String ADDRESS_IS_NULL = "Address is null"; //$NON-NLS-1$

  /**
   * Constructor constant.
   */
  private static final String CONSTRUCTOR = "constructor"; //$NON-NLS-1$

  /**
   * Building nr 92.
   */
  private static final String BUILDINGNR92 = "92"; //$NON-NLS-1$

  /**
   * Building nr 1.
   */
  private static final String BUIDINGNR1 = "1"; //$NON-NLS-1$

  /**
   * DE germany.
   */
  private static final String DE = "DE"; //$NON-NLS-1$

  /**
   * GB great britain.
   */
  private static final String GB = "GB"; //$NON-NLS-1$

  /**
   * JP japan.
   */
  private static final String JP = "JP"; //$NON-NLS-1$

  /**
   * HK hong kong.
   */
  private static final String HK = "HK"; //$NON-NLS-1$

  /**
   * "Wrong buildingNr constant.
   */
  private static final String WRONG_BUILDING_NR = "Wrong buildingNr"; //$NON-NLS-1$

  /**
   * Wrong street constant.
   */
  private static final String WRONG_STREET = "Wrong street"; //$NON-NLS-1$

  /**
   * Wrong city constant.
   */
  private static final String WRONG_CITY = "Wrong city"; //$NON-NLS-1$

  /**
   * Wrong postalCode constant.
   */
  private static final String WRONG_POSTAL_CODE = "Wrong postalCode"; //$NON-NLS-1$

  /**
   * Wrong country constant.
   */
  private static final String WRONG_COUNTRY = "Wrong country"; //$NON-NLS-1$

  /**
   * Wrong po box number constant.
   */
  private static final String WRONG_PO_BOX_NUMBER = "Wrong poBoxNumber"; //$NON-NLS-1$

  /**
   * Wrong address constant.
   */
  private static final String WRONG_ADDRESS = "Wrong address"; //$NON-NLS-1$

  /**
   * Test equals constant.
   */
  private static final String TEST_EQUALS = "testEquals"; //$NON-NLS-1$

  /**
   * ToString not equal constant.
   */
  private static final String TO_STRING_NOT_EQUAL = "toString not equal"; //$NON-NLS-1$

  /**
   * Illegal argument exception constant.
   */
  private static final String ILLEGAL_ARGUMENT_EXCEPTION = "Illegal argument exception"; //$NON-NLS-1$

  /**
   * Suppress sonarqube warning.
   */
  private static final String JAVA_S5785 = "java:S5785"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ AddressTests()
   {
    super();
   }


  /**
   * Constructor/factory test.
   */
  @Test
  /* default */ void testConstructor1()
   {
    final Address address = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, Street.of(AddressTests.ARBERGER_HEERSTR), BuildingNr.of(AddressTests.BUILDINGNR92), null, null, null, null, null, null, null, null);
    assertAll(AddressTests.CONSTRUCTOR,
      () -> assertNotNull(address, AddressTests.ADDRESS_IS_NULL),
      () -> assertEquals(AddressTests.DE, address.getCountry().stringValue(), AddressTests.WRONG_COUNTRY),
      () -> assertEquals(AddressTests.POSTALCODE28307, address.getPostalCode().stringValue(), AddressTests.WRONG_POSTAL_CODE),
      () -> assertEquals(AddressTests.BREMEN, address.getCity().stringValue(), AddressTests.WRONG_CITY),
      () -> assertEquals(AddressTests.ARBERGER_HEERSTR, address.getStreet().stringValue(), AddressTests.WRONG_STREET),
      () -> assertEquals(AddressTests.BUILDINGNR92, address.getBuildingNr().stringValue(), AddressTests.WRONG_BUILDING_NR)
    );
   }


  /**
   * Constructor/Factory test.
   */
  @Test
  /* default */ void testConstructor2()
   {
    // Province province, District district, ,, BuildingName buildingName, SubBuilding subBuilding, PoBoxNumber poBoxNumber, Department department, Neighbourhood neighbourhood, Block block, BFPONumber bFPONumber, Lines lines
    final Address address = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, null, null, null, null, PoBoxNumber.of(12345), null, null, null, null, null);
    assertAll(AddressTests.CONSTRUCTOR,
      () -> assertNotNull(address, AddressTests.ADDRESS_IS_NULL),
      () -> assertEquals(AddressTests.DE, address.getCountry().stringValue(), AddressTests.WRONG_COUNTRY),
      () -> assertEquals(AddressTests.POSTALCODE28307, address.getPostalCode().stringValue(), AddressTests.WRONG_POSTAL_CODE),
      () -> assertEquals(AddressTests.BREMEN, address.getCity().stringValue(), AddressTests.WRONG_CITY),
      () -> assertEquals(12345, address.getPoBoxNumber().longValue(), AddressTests.WRONG_PO_BOX_NUMBER)
    );
   }


  /**
   * Constructor/Factory test.
   */
  @Test
  /* default */ void testConstructor3()
   {
    // Province province, District district, ,, BuildingName buildingName, SubBuilding subBuilding, PoBoxNumber poBoxNumber, Department department, Neighbourhood neighbourhood, Block block, BFPONumber bFPONumber, Lines lines
    final Address address = Address.of("DE,28307,Bremen,,,,,,,12345,,,,,");
    assertAll(AddressTests.CONSTRUCTOR,
      () -> assertNotNull(address, AddressTests.ADDRESS_IS_NULL),
      () -> assertEquals(AddressTests.DE, address.getCountry().stringValue(), AddressTests.WRONG_COUNTRY),
      () -> assertEquals(AddressTests.POSTALCODE28307, address.getPostalCode().stringValue(), AddressTests.WRONG_POSTAL_CODE),
      () -> assertEquals(AddressTests.BREMEN, address.getCity().stringValue(), AddressTests.WRONG_CITY),
      () -> assertEquals(12345, address.getPoBoxNumber().longValue(), AddressTests.WRONG_PO_BOX_NUMBER)
    );
   }


  /**
   * Constructor/Factory test.
   */
  @Test
  /* default */ void testConstructor4()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      // Province province, District district, ,, BuildingName buildingName, SubBuilding subBuilding, PoBoxNumber poBoxNumber, Department department, Neighbourhood neighbourhood, Block block, BFPONumber bFPONumber, Lines lines
      /* final Address address = */ Address.of("");
     }, ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Constructor/Factory test.
   */
  @Test
  /* default */ void testCnstructor5()
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      // Province province, District district, ,, BuildingName buildingName, SubBuilding subBuilding, PoBoxNumber poBoxNumber, Department department, Neighbourhood neighbourhood, Block block, BFPONumber bFPONumber, Lines lines
      /* final Address address = */ Address.of("DE,28307,Bremen,,,,,,,12345,,,,,,1");
     }, ILLEGAL_ARGUMENT_EXCEPTION
    );
   }


  /**
   * Constructor/Factory test.
   */
  @Test
  /* default */ void testConstructor6()
   {
    // Province province, District district, ,, BuildingName buildingName, SubBuilding subBuilding, PoBoxNumber poBoxNumber, Department department, Neighbourhood neighbourhood, Block block, BFPONumber bFPONumber, Lines lines
    final Address address = Address.of("DE,28307,Bremen,,,,,,,12345,,,,,Lines");
    assertAll(AddressTests.CONSTRUCTOR,
      () -> assertNotNull(address, AddressTests.ADDRESS_IS_NULL),
      () -> assertEquals(AddressTests.DE, address.getCountry().stringValue(), AddressTests.WRONG_COUNTRY),
      () -> assertEquals(AddressTests.POSTALCODE28307, address.getPostalCode().stringValue(), AddressTests.WRONG_POSTAL_CODE),
      () -> assertEquals(AddressTests.BREMEN, address.getCity().stringValue(), AddressTests.WRONG_CITY),
      () -> assertEquals(12345, address.getPoBoxNumber().longValue(), AddressTests.WRONG_PO_BOX_NUMBER)
      // Lines
    );
   }


  /**
   * Constructor/Factory test.
   */
  @Test
  /* default */ void testConstructor7()
   {
    final Address address = Address.of("DE,28307,Bremen");
    assertAll(AddressTests.CONSTRUCTOR,
      () -> assertNotNull(address, AddressTests.ADDRESS_IS_NULL),
      () -> assertEquals(AddressTests.DE, address.getCountry().stringValue(), AddressTests.WRONG_COUNTRY),
      () -> assertEquals(AddressTests.POSTALCODE28307, address.getPostalCode().stringValue(), AddressTests.WRONG_POSTAL_CODE),
      () -> assertEquals(AddressTests.BREMEN, address.getCity().stringValue(), AddressTests.WRONG_CITY)
    );
   }


  /**
   * Test string value.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Address address = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, null, null, null, null, PoBoxNumber.of(12345), null, null, null, null, null);
    assertEquals("\nPostfach 12345\n28307 Bremen\n\n", address.stringValue().replace(AddressTests.LINEBREAK_WIN, AddressTests.LINEBREAK_UNIX).replace('\r', '\n'), "Address not as expected");
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(Address.class).withRedefinedSubclass(AddressWithWGS84Position.class).withNonnullFields("country").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString1()
   {
    final Address address = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), Province.of(AddressTests.TEST2), District.of(AddressTests.DISTRICT), Street.of(AddressTests.ARBERGER_HEERSTR), BuildingNr.of(AddressTests.BUILDINGNR92), BuildingName.of(AddressTests.TEST_BUILDING), SubBuilding.of(AddressTests.SUBBUILDING), PoBoxNumber.of(4711), Department.of(AddressTests.TEST2), Neighbourhood.of(AddressTests.NEIGHBOUR), Block.of(AddressTests.BLK), BFPONumber.of(1), Lines.of(AddressTests.TEST2));
    assertEquals("Address[country=DE, postalCode=28307, city=Bremen, province=Test, district=9, street=Arberger Heerstr., buildingNr=92, buildingName=TestBuilding, subBuilding=SubB, poBoxNumber=4711, department=Test, neighbourhood=neighbour, block=blk, bFPONumber=1, lines=Test]", address.toString(), AddressTests.TO_STRING_NOT_EQUAL); //$NON-NLS-1$
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString2()
   {
    final Address address = Address.of(Country.of(AddressTests.GB), PostalCode.of(AddressTests.POSTALCODE_GB), City.of(AddressTests.BEDFORDSHIRE), null, null, null, null, null, null, null, Department.of(AddressTests.TEST), null, null, BFPONumber.of(1), Lines.of(AddressTests.TEST2));
    assertEquals("Address[country=GB, postalCode=AL3 8QE, city=Bedfordshire, department=test, bFPONumber=1, lines=Test]", address.toString(), AddressTests.TO_STRING_NOT_EQUAL); //$NON-NLS-1$
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString3()
   {
    final Address address = Address.of(Country.of(AddressTests.HK), null, null, null, District.of(AddressTests.DISTRICT), Street.of(AddressTests.TEST_STR), BuildingNr.of(AddressTests.POSTALCODE4711), BuildingName.of(AddressTests.TEST_BUILDING), SubBuilding.of(AddressTests.SUBBUILDING), PoBoxNumber.of(1), null, null, null, null, null);
    assertEquals("Address[country=HK, district=9, street=Test str., buildingNr=4711, buildingName=TestBuilding, subBuilding=SubB, poBoxNumber=1]", address.toString(), AddressTests.TO_STRING_NOT_EQUAL); //$NON-NLS-1$
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString4()
   {
    final Address address = Address.of(Country.of(AddressTests.JP), PostalCode.of(AddressTests.POSTALCODE_JP), City.of(AddressTests.AICHI), Province.of(AddressTests.TEST2), District.of(AddressTests.DISTRICT), null, BuildingNr.of(AddressTests.POSTALCODE4711), BuildingName.of(AddressTests.BUILDING), null, null, null, Neighbourhood.of(AddressTests.NEIGHBOUR), Block.of(AddressTests.BLK), null, null);
    assertEquals("Address[country=JP, postalCode=4434567, city=AICHI, province=Test, district=9, buildingNr=4711, buildingName=Building, neighbourhood=neighbour, block=blk]", address.toString(), AddressTests.TO_STRING_NOT_EQUAL); //$NON-NLS-1$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings(JAVA_S5785)
  /* default */ void testCompareTo()
   {
    final Address address1 = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, Street.of(AddressTests.ARBERGER_HEERSTR), BuildingNr.of(AddressTests.BUILDINGNR92), null, null, null, null, null, null, null, null);
    final Address address2 = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, Street.of(AddressTests.ARBERGER_HEERSTR), BuildingNr.of(AddressTests.BUILDINGNR92), null, null, null, null, null, null, null, null);
    final Address address3 = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28359), City.of(AddressTests.BREMEN), null, null, Street.of(AddressTests.BIBLIOTHEKSTRASSE), BuildingNr.of(AddressTests.BUIDINGNR1), null, null, null, null, null, null, null, null);
    final Address address4 = Address.of(Country.of(AddressTests.DE), PostalCode.of("28757"), City.of(AddressTests.BREMEN), null, null, Street.of("Gerhard-Rohlfs-Straße"), BuildingNr.of("62"), null, null, null, null, null, null, null, null); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    final Address address5 = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, Street.of(AddressTests.ARBERGER_HEERSTR), BuildingNr.of(AddressTests.BUILDINGNR92), null, null, null, null, null, null, null, null);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(address1.compareTo(address2) == -address2.compareTo(address1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(address1.compareTo(address3) == -address3.compareTo(address1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((address4.compareTo(address3) > 0) && (address3.compareTo(address1) > 0) && (address4.compareTo(address1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((address1.compareTo(address2) == 0) && (Math.abs(address1.compareTo(address5)) == Math.abs(address2.compareTo(address5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((address1.compareTo(address2) == 0) && address1.equals(address2), "equals") //$NON-NLS-1$
    );
   }


  /**
   * Test not compareTo.
   */
  @Test
  @SuppressWarnings(JAVA_S5785)
  /* default */ void testNotCompareTo()
   {
    final Address address1 = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, Street.of(AddressTests.ARBERGER_HEERSTR), BuildingNr.of(AddressTests.BUILDINGNR92), null, null, null, null, null, null, null, null);
    final Address address2 = Address.of(Country.of(AddressTests.GB), PostalCode.of(AddressTests.POSTALCODE_GB), City.of(AddressTests.BEDFORDSHIRE), null, null, null, null, null, null, null, Department.of(AddressTests.TEST), null, null, BFPONumber.of(1), Lines.of(AddressTests.TEST2));
    final Address address3 = Address.of(Country.of(AddressTests.HK), PostalCode.of(AddressTests.POSTALCODE_HK), null, null, District.of(AddressTests.DISTRICT), Street.of(AddressTests.TEST_STR), BuildingNr.of(AddressTests.POSTALCODE4711), BuildingName.of(AddressTests.TEST_BUILDING), SubBuilding.of(AddressTests.SUBBUILDING), PoBoxNumber.of(1), null, null, null, null, null);
    final Address address4 = Address.of(Country.of(AddressTests.HK), null, null, null, District.of(AddressTests.DISTRICT), Street.of(AddressTests.TEST_STR), BuildingNr.of(AddressTests.POSTALCODE4711), BuildingName.of(AddressTests.TEST_BUILDING), SubBuilding.of(AddressTests.SUBBUILDING), PoBoxNumber.of(1), null, null, null, null, null);
    final Address address5 = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.HANNOVER), null, null, Street.of(AddressTests.ARBERGER_HEERSTR), BuildingNr.of(AddressTests.BUILDINGNR92), null, null, null, null, null, null, null, null);
    final Address address6 = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, Street.of("Bibliotheksstr."), BuildingNr.of(AddressTests.BUILDINGNR92), null, null, null, null, null, null, null, null); //$NON-NLS-1$
    final Address address7 = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, Street.of(AddressTests.ARBERGER_HEERSTR), BuildingNr.of(AddressTests.BUIDINGNR1), null, null, null, null, null, null, null, null);
    final Address address8 = Address.of(Country.of(AddressTests.GB), PostalCode.of(AddressTests.POSTALCODE_GB), City.of(AddressTests.BEDFORDSHIRE), null, null, null, null, null, null, null, Department.of("testa"), null, null, BFPONumber.of(1), Lines.of(AddressTests.TEST2)); //$NON-NLS-1$
    final Address address9 = Address.of(Country.of(AddressTests.GB), PostalCode.of(AddressTests.POSTALCODE_GB), City.of(AddressTests.BEDFORDSHIRE), null, null, null, null, null, null, null, Department.of(AddressTests.TEST), null, null, BFPONumber.of(2), Lines.of(AddressTests.TEST2));
    final Address address10 = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), Province.of(AddressTests.TESTPROVINCE), null, Street.of(AddressTests.ARBERGER_HEERSTR), BuildingNr.of(AddressTests.BUILDINGNR92), null, null, null, null, null, null, null, null);
    final Address address11 = Address.of(Country.of(AddressTests.HK), PostalCode.of(AddressTests.POSTALCODE_HK), null, null, District.of("13"), Street.of(AddressTests.TEST_STR), BuildingNr.of(AddressTests.POSTALCODE4711), BuildingName.of(AddressTests.TEST_BUILDING), SubBuilding.of(AddressTests.SUBBUILDING), PoBoxNumber.of(1), null, null, null, null, null);   //$NON-NLS-1$
    final Address address12 = Address.of(Country.of(AddressTests.HK), PostalCode.of(AddressTests.POSTALCODE_HK), null, null, District.of(AddressTests.DISTRICT), Street.of(AddressTests.TEST_STR), BuildingNr.of(AddressTests.POSTALCODE4711), BuildingName.of(AddressTests.BUILDING), SubBuilding.of(AddressTests.SUBBUILDING), PoBoxNumber.of(1), null, null, null, null, null);
    final Address address13 = Address.of(Country.of(AddressTests.HK), PostalCode.of(AddressTests.POSTALCODE_HK), null, null, District.of(AddressTests.DISTRICT), Street.of(AddressTests.TEST_STR), BuildingNr.of(AddressTests.POSTALCODE4711), BuildingName.of(AddressTests.TEST_BUILDING), SubBuilding.of("SubC"), PoBoxNumber.of(1), null, null, null, null, null);   //$NON-NLS-1$
    final Address address14 = Address.of(Country.of(AddressTests.HK), PostalCode.of(AddressTests.POSTALCODE_HK), null, null, District.of(AddressTests.DISTRICT), Street.of(AddressTests.TEST_STR), BuildingNr.of(AddressTests.POSTALCODE4711), BuildingName.of(AddressTests.TEST_BUILDING), SubBuilding.of(AddressTests.SUBBUILDING), PoBoxNumber.of(2), null, null, null, null, null);
    final Address address15 = Address.of(Country.of(AddressTests.JP), PostalCode.of(AddressTests.POSTALCODE_JP), City.of(AddressTests.AICHI), Province.of(AddressTests.TEST2), District.of(AddressTests.DISTRICT), null, BuildingNr.of(AddressTests.POSTALCODE4711), BuildingName.of(AddressTests.BUILDING), null, null, null, Neighbourhood.of(AddressTests.NEIGHBOUR), Block.of(AddressTests.BLK), null, null);
    final Address address16 = Address.of(Country.of(AddressTests.JP), PostalCode.of(AddressTests.POSTALCODE_JP), City.of(AddressTests.AICHI), Province.of(AddressTests.TEST2), District.of(AddressTests.DISTRICT), null, BuildingNr.of(AddressTests.POSTALCODE4711), BuildingName.of(AddressTests.BUILDING), null, null, null, Neighbourhood.of("neighbour2"), Block.of(AddressTests.BLK), null, null); //$NON-NLS-1$
    final Address address17 = Address.of(Country.of(AddressTests.JP), PostalCode.of(AddressTests.POSTALCODE_JP), City.of(AddressTests.AICHI), Province.of(AddressTests.TEST2), District.of(AddressTests.DISTRICT), null, BuildingNr.of(AddressTests.POSTALCODE4711), BuildingName.of(AddressTests.BUILDING), null, null, null, Neighbourhood.of(AddressTests.NEIGHBOUR), Block.of("blk2"), null, null); //$NON-NLS-1$
    assertAll("testNotCompareTo", //$NON-NLS-1$
      () -> assertTrue(address1.compareTo(address2) != 0, "address12 equal"), //$NON-NLS-1$
      () -> assertTrue(address3.compareTo(address4) != 0, "address34 equal"), //$NON-NLS-1$
      () -> assertTrue(address4.compareTo(address3) != 0, "address43 equal"), //$NON-NLS-1$
      () -> assertTrue(address1.compareTo(address5) != 0, "address15 equal"), //$NON-NLS-1$
      () -> assertTrue(address1.compareTo(address6) != 0, "address16 equal"), //$NON-NLS-1$
      () -> assertTrue(address1.compareTo(address7) != 0, "address17 equal"), //$NON-NLS-1$
      () -> assertTrue(address2.compareTo(address8) != 0, "address18 equal"), //$NON-NLS-1$
      () -> assertTrue(address2.compareTo(address9) != 0, "address19 equal"), //$NON-NLS-1$
      () -> assertTrue(address1.compareTo(address10) != 0, "address1a equal"), //$NON-NLS-1$
      () -> assertTrue(address3.compareTo(address11) != 0, "address3b equal"), //$NON-NLS-1$
      () -> assertTrue(address3.compareTo(address12) != 0, "address3c equal"), //$NON-NLS-1$
      () -> assertTrue(address3.compareTo(address13) != 0, "address3d equal"), //$NON-NLS-1$
      () -> assertTrue(address3.compareTo(address14) != 0, "address3e equal"), //$NON-NLS-1$
      () -> assertTrue(address15.compareTo(address16) != 0, "address0f10 equal"), //$NON-NLS-1$
      () -> assertTrue(address15.compareTo(address17) != 0, "address0f11 equal") //$NON-NLS-1$
    );
   }


  /**
   * Get formatted address test.
   */
  @Test
  /* default */ void testGetFormattedAddress1()
   {
    final Address address = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, Street.of(AddressTests.ARBERGER_HEERSTR), BuildingNr.of(AddressTests.BUILDINGNR92), null, null, null, null, null, null, null, null);
    final String addressText = address.getFormattedAddress(AddressTests.KAI_HOFMANN).replace(AddressTests.LINEBREAK_WIN, AddressTests.LINEBREAK_UNIX).replace('\r', '\n');
    assertEquals("Kai Hofmann\nArberger Heerstr. 92\n28307 Bremen\n\n", addressText, AddressTests.WRONG_ADDRESS); //$NON-NLS-1$
   }


  /**
   * Get formatted address test.
   */
  @Test
  /* default */ void testGetFormattedAddress2()
   {
    final Address address = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, null, null, null, null, PoBoxNumber.of(4711), null, null, null, null, null);
    final String addressText = address.getFormattedAddress(AddressTests.KAI_HOFMANN).replace(AddressTests.LINEBREAK_WIN, AddressTests.LINEBREAK_UNIX).replace('\r', '\n');
    assertEquals("Kai Hofmann\nPostfach 4711\n28307 Bremen\n\n", addressText, AddressTests.WRONG_ADDRESS); //$NON-NLS-1$
   }


  /**
   * Get formatted address test.
   */
  @Test
  /* default */ void testGetFormattedAddress3()
   {
    final Address address = Address.of(Country.of(AddressTests.GB), PostalCode.of(AddressTests.POSTALCODE_GB), City.of(AddressTests.BEDFORDSHIRE), null, null, null, null, null, null, null, Department.of(AddressTests.TEST), null, null, BFPONumber.of(1), Lines.of(AddressTests.TEST2));
    final String addressText = address.getFormattedAddress(AddressTests.KAI_HOFMANN).replace(AddressTests.LINEBREAK_WIN, AddressTests.LINEBREAK_UNIX).replace('\r', '\n');
    assertEquals("Kai Hofmann\ntest\nTest\nBedfordshire\nAL3 8QE\n1\n\n", addressText, AddressTests.WRONG_ADDRESS); //$NON-NLS-1$
   }


  /**
   * Get formatted address test.
   */
  @Test
  /* default */ void testGetFormattedAddress4()
   {
    final Address address = Address.of(Country.of(AddressTests.HK), null, null, null, District.of(AddressTests.DISTRICT), Street.of(AddressTests.TEST_STR), BuildingNr.of(AddressTests.POSTALCODE4711), BuildingName.of(AddressTests.TEST_BUILDING), SubBuilding.of(AddressTests.SUBBUILDING), PoBoxNumber.of(1), null, null, null, null, null);
    final String addressText = address.getFormattedAddress(AddressTests.KAI_HOFMANN).replace(AddressTests.LINEBREAK_WIN, AddressTests.LINEBREAK_UNIX).replace('\r', '\n');
    assertEquals("Kai Hofmann\nSubB\nTestBuilding\n4711 Test str.\nP.O. Box 1\n9\n\n", addressText, AddressTests.WRONG_ADDRESS); //$NON-NLS-1$
   }


  /**
   * Get formatted address test.
   */
  @Test
  /* default */ void testGetFormattedAddress5()
   {
    final Address address = Address.of(Country.of(AddressTests.JP), PostalCode.of(AddressTests.POSTALCODE_JP), City.of(AddressTests.AICHI), Province.of(AddressTests.TEST2), District.of(AddressTests.DISTRICT), null, BuildingNr.of(AddressTests.POSTALCODE4711), BuildingName.of(AddressTests.BUILDING), null, null, null, Neighbourhood.of(AddressTests.NEIGHBOUR), Block.of(AddressTests.BLK), null, null);
    final String addressText = address.getFormattedAddress(AddressTests.KAI_HOFMANN).replace(AddressTests.LINEBREAK_WIN, AddressTests.LINEBREAK_UNIX).replace('\r', '\n');
    assertEquals("Kai Hofmann\nBuilding4711 blk, neighbour\n9, AICHI, Test\n4434567\n\n", addressText, AddressTests.WRONG_ADDRESS); //$NON-NLS-1$
   }


  /**
   * Get formatted address test.
   */
  @Test
  /* default */ void testGetFormattedAddress6()
   {
    final Address address = Address.of(Country.of("AQ"), PostalCode.of(AddressTests.POSTALCODE_JP), City.of(AddressTests.AICHI), Province.of(AddressTests.TEST2), District.of(AddressTests.DISTRICT), null, BuildingNr.of(AddressTests.POSTALCODE4711), BuildingName.of(AddressTests.BUILDING), null, null, null, Neighbourhood.of(AddressTests.NEIGHBOUR), Block.of(AddressTests.BLK), null, null); //$NON-NLS-1$
    final String addressText = address.getFormattedAddress(AddressTests.KAI_HOFMANN).replace(AddressTests.LINEBREAK_WIN, AddressTests.LINEBREAK_UNIX).replace('\r', '\n');
    assertEquals("", addressText, AddressTests.WRONG_ADDRESS); //$NON-NLS-1$
   }


  /**
   * Get country test.
   */
  @Test
  /* default */ void testGetCountry()
   {
    final Address address = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, Street.of(AddressTests.ARBERGER_HEERSTR), BuildingNr.of(AddressTests.BUILDINGNR92), null, null, null, null, null, null, null, null);
    final String country = address.getCountry().stringValue();
    assertEquals(AddressTests.DE, country, AddressTests.WRONG_COUNTRY);
   }


  /**
   * Get postal code test.
   */
  @Test
  /* default */ void testGetPostalCode()
   {
    final Address address = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, Street.of(AddressTests.ARBERGER_HEERSTR), BuildingNr.of(AddressTests.BUILDINGNR92), null, null, null, null, null, null, null, null);
    final String postalCode = address.getPostalCode().stringValue();
    assertEquals(AddressTests.POSTALCODE28307, postalCode, AddressTests.WRONG_POSTAL_CODE);
   }


  /**
   * Get city test.
   */
  @Test
  /* default */ void testGetCity()
   {
    final Address address = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, Street.of(AddressTests.ARBERGER_HEERSTR), BuildingNr.of(AddressTests.BUILDINGNR92), null, null, null, null, null, null, null, null);
    final String city = address.getCity().stringValue();
    assertEquals(AddressTests.BREMEN, city, AddressTests.WRONG_CITY);
   }


  /**
   * Get street test.
   */
  @Test
  /* default */ void testGetStreet()
   {
    final Address address = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, Street.of(AddressTests.ARBERGER_HEERSTR), BuildingNr.of(AddressTests.BUILDINGNR92), null, null, null, null, null, null, null, null);
    final String street = address.getStreet().stringValue();
    assertEquals(AddressTests.ARBERGER_HEERSTR, street, AddressTests.WRONG_STREET);
   }


  /**
   * Get building nr test.
   */
  @Test
  /* default */ void testGetBuildingNr()
   {
    final Address address = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, Street.of(AddressTests.ARBERGER_HEERSTR), BuildingNr.of(AddressTests.BUILDINGNR92), null, null, null, null, null, null, null, null);
    final String buildingNr = address.getBuildingNr().stringValue();
    assertEquals(AddressTests.BUILDINGNR92, buildingNr, AddressTests.WRONG_BUILDING_NR);
   }


  /**
   * Get po box number test.
   */
  @Test
  /* default */ void testGetPoBoxNumber()
   {
    final Address address = Address.of(Country.of(AddressTests.DE), PostalCode.of(AddressTests.POSTALCODE28307), City.of(AddressTests.BREMEN), null, null, null, null, null, null, PoBoxNumber.of(12345), null, null, null, null, null);
    final String poBoxNumber = address.getPoBoxNumber().stringValue();
    assertEquals(AddressTests.POSTALCODE_HK, poBoxNumber, AddressTests.WRONG_PO_BOX_NUMBER);
   }


  /**
   * Get sub building test.
   */
  @Test
  /* default */ void testGetSubBuilding()
   {
    final Address address = Address.of(Country.of("AL"), PostalCode.of(AddressTests.POSTALCODE4711), City.of(AddressTests.TESTCITY), null, null, Street.of("Teststreet"), BuildingNr.of(AddressTests.BUILDINGNR0815), BuildingName.of(AddressTests.TESTBUILDING), SubBuilding.of(AddressTests.TEST_SUB_BUILDING), null, null, null, null, null, null); //$NON-NLS-1$ //$NON-NLS-2$
    final String subBuilding = address.getSubBuilding().stringValue();
    assertEquals(AddressTests.TEST_SUB_BUILDING, subBuilding, "Wrong subBuilding"); //$NON-NLS-1$
   }


  /**
   * Get province test.
   */
  @Test
  /* default */ void testGetProvince()
   {
    final Address address = Address.of(Country.of(AddressTests.JP), PostalCode.of(AddressTests.POSTALCODE4711), City.of(AddressTests.TESTCITY), Province.of(AddressTests.TESTPROVINCE), District.of(AddressTests.TESTDISTRICT), null, BuildingNr.of(AddressTests.BUILDINGNR0815), BuildingName.of(AddressTests.TESTBUILDING), null, null, null, Neighbourhood.of(AddressTests.TESTNEIGHBOUR), Block.of(AddressTests.TESTBLOCK13), null, null);
    final String province = address.getProvince().stringValue();
    assertEquals(AddressTests.TESTPROVINCE, province, "Wrong province"); //$NON-NLS-1$
   }


  /**
   * Get district test.
   */
  @Test
  /* default */ void testGetDistrict()
   {
    final Address address = Address.of(Country.of(AddressTests.JP), PostalCode.of(AddressTests.POSTALCODE4711), City.of(AddressTests.TESTCITY), Province.of(AddressTests.TESTPROVINCE), District.of(AddressTests.TESTDISTRICT), null, BuildingNr.of(AddressTests.BUILDINGNR0815), BuildingName.of(AddressTests.TESTBUILDING), null, null, null, Neighbourhood.of(AddressTests.TESTNEIGHBOUR), Block.of(AddressTests.TESTBLOCK13), null, null);
    final String district = address.getDistrict().stringValue();
    assertEquals(AddressTests.TESTDISTRICT, district, "Wrong district"); //$NON-NLS-1$
   }


  /**
   * Get building name test.
   */
  @Test
  /* default */ void testGetBuildingName()
   {
    final Address address = Address.of(Country.of(AddressTests.JP), PostalCode.of(AddressTests.POSTALCODE4711), City.of(AddressTests.TESTCITY), Province.of(AddressTests.TESTPROVINCE), District.of(AddressTests.TESTDISTRICT), null, BuildingNr.of(AddressTests.BUILDINGNR0815), BuildingName.of(AddressTests.TESTBUILDING), null, null, null, Neighbourhood.of(AddressTests.TESTNEIGHBOUR), Block.of(AddressTests.TESTBLOCK13), null, null);
    final String buildingName = address.getBuildingName().stringValue();
    assertEquals(AddressTests.TESTBUILDING, buildingName, "Wrong buildingName"); //$NON-NLS-1$
   }


  /**
   * Get beighbourhood test.
   */
  @Test
  /* default */ void testGetNeighbourhood()
   {
    final Address address = Address.of(Country.of(AddressTests.JP), PostalCode.of(AddressTests.POSTALCODE4711), City.of(AddressTests.TESTCITY), Province.of(AddressTests.TESTPROVINCE), District.of(AddressTests.TESTDISTRICT), null, BuildingNr.of(AddressTests.BUILDINGNR0815), BuildingName.of(AddressTests.TESTBUILDING), null, null, null, Neighbourhood.of(AddressTests.TESTNEIGHBOUR), Block.of(AddressTests.TESTBLOCK13), null, null);
    final String neighbourhood = address.getNeighbourhood().stringValue();
    assertEquals(AddressTests.TESTNEIGHBOUR, neighbourhood, "Wrong neighbourhood"); //$NON-NLS-1$
   }


  /**
   * Get block test.
   */
  @Test
  /* default */ void testGetBlock()
   {
    final Address address = Address.of(Country.of(AddressTests.JP), PostalCode.of(AddressTests.POSTALCODE4711), City.of(AddressTests.TESTCITY), Province.of(AddressTests.TESTPROVINCE), District.of(AddressTests.TESTDISTRICT), null, BuildingNr.of(AddressTests.BUILDINGNR0815), BuildingName.of(AddressTests.TESTBUILDING), null, null, null, Neighbourhood.of(AddressTests.TESTNEIGHBOUR), Block.of(AddressTests.TESTBLOCK13), null, null);
    final String block = address.getBlock().stringValue();
    assertEquals(AddressTests.TESTBLOCK13, block, "Wrong block"); //$NON-NLS-1$
   }


  /**
   * Get department test.
   */
  @Test
  /* default */ void testGetDepartment()
   {
    final Address address = Address.of(Country.of(AddressTests.GB), PostalCode.of(AddressTests.POSTALCODE4711), City.of(AddressTests.TESTCITY), null, null, null, null, null, null, null, Department.of(AddressTests.TESTDEPARTMENT), null, null, BFPONumber.of(123), Lines.of(AddressTests.TESTLINES));
    final String department = address.getDepartment().stringValue();
    assertEquals(AddressTests.TESTDEPARTMENT, department, "Wrong department"); //$NON-NLS-1$
   }


  /**
   * Get BFPONumber test.
   */
  @Test
  /* default */ void testGetBFPONumber()
   {
    final Address address = Address.of(Country.of(AddressTests.GB), PostalCode.of(AddressTests.POSTALCODE4711), City.of(AddressTests.TESTCITY), null, null, null, null, null, null, null, Department.of(AddressTests.TESTDEPARTMENT), null, null, BFPONumber.of(123), Lines.of(AddressTests.TESTLINES));
    final String bFPONumber = address.getBFPONumber().stringValue();
    assertEquals("123", bFPONumber, "Wrong BFPONumber"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Get lines test.
   */
  @Test
  /* default */ void testGetLines()
   {
    final Address address = Address.of(Country.of(AddressTests.GB), PostalCode.of(AddressTests.POSTALCODE4711), City.of(AddressTests.TESTCITY), null, null, null, null, null, null, null, Department.of(AddressTests.TESTDEPARTMENT), null, null, BFPONumber.of(123), Lines.of(AddressTests.TESTLINES));
    final String lines = address.getLines().stringValue();
    assertEquals(AddressTests.TESTLINES, lines, "Wrong lines"); //$NON-NLS-1$
   }

 }
