/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.ddd.values;


import java.util.Objects;

import de.powerstat.ddd.interfaces.IValueObject;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.jmolecules.ddd.annotation.ValueObject;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Address with wgs84 position.
 *
 * @param address Address
 * @param position WGS84Position
 *
 * DSGVO relevant.
 *
 * TODO compareTo(): AddressWithWGS84Position
 */
@ValueObject
public record AddressWithWGS84Position(Address address, WGS84Position position) implements IValueObject // Comparable<AddressWithWGS84Position>,
 {
  /**
   * Constructor.
   *
   * @param address Address
   * @param position WGS84Position
   */
  public AddressWithWGS84Position
   {
    Objects.requireNonNull(address, "address"); //$NON-NLS-1$
    Objects.requireNonNull(position, "position"); //$NON-NLS-1$
   }


  /**
   * AddressWithWGS84Position factory.
   *
   * @param address Address
   * @param position WGS84Position
   * @return AddressWithWGS84Position object
   */
  public static AddressWithWGS84Position of(final Address address, final WGS84Position position)
   {
    return new AddressWithWGS84Position(address, position);
   }


  /**
   * AddressWithWGS84Position factory.
   *
   * @param country Country
   * @param postalCode Postal code
   * @param city City
   * @param province Province
   * @param district District
   * @param street Street
   * @param buildingNr Bulding number
   * @param buildingName Building name
   * @param subBuilding Sub building
   * @param poBoxNumber Post office box number
   * @param department Department
   * @param neighbourhood Neighbourhood
   * @param block Block
   * @param bFPONumber British Forces Post Office Number
   * @param lines Lines 1-5
   * @param position WGS84Position
   * @return AddressWithWGS84Position object
   */
  public static AddressWithWGS84Position of(final Country country, final @Nullable PostalCode postalCode, final @Nullable City city, final @Nullable Province province, final @Nullable District district, final @Nullable Street street, final @Nullable BuildingNr buildingNr, final @Nullable BuildingName buildingName, final @Nullable SubBuilding subBuilding, final @Nullable PoBoxNumber poBoxNumber, final @Nullable Department department, final @Nullable Neighbourhood neighbourhood, final @Nullable Block block, final @Nullable BFPONumber bFPONumber, final @Nullable Lines lines, final WGS84Position position)
   {
    Address address = Address.of(country, postalCode, city, province, district, street, buildingNr, buildingName, subBuilding, poBoxNumber, department, neighbourhood, block, bFPONumber, lines);
    return new AddressWithWGS84Position(address, position);
   }


  /**
   * AddressWithWGS84Position factory.
   *
   * @param value country,postalcode,city,province,district,street,buildingnr,buildingname,subbuilding,poboxnumber,department,neighbourhood,block,bfponumber,lines,latitude longitude altitude
   * @return AddressWithWGS84Position object
   */
  @SuppressWarnings({"PMD.NPathComplexity"})
  public static AddressWithWGS84Position of(final String value)
   {
    Objects.requireNonNull(value, "value"); //$NON-NLS-1$
    final String[] values = value.split(",");
    if ((values.length < 16) || (values.length > 16))
     {
      throw new IllegalArgumentException("value not in expected format: " + values.length);
     }
    /*
    if (values.length < 16) // NO PITEST
     {
      values = Arrays.copyOf(values, 16);
      for (int i = 1; i < 16; ++i)
       {
        if (values[i] == null)
         {
          values[i] = "";
         }
       }
     }
    */
    final var country = Country.of(values[0]);
    final PostalCode postalCode = values[1].isEmpty() ? null : PostalCode.of(values[1]);
    final City city = values[2].isEmpty() ? null : City.of(values[2]);
    final Province province = values[3].isEmpty() ? null : Province.of(values[3]);
    final District district = values[4].isEmpty() ? null : District.of(values[4]);
    final Street street = values[5].isEmpty() ? null : Street.of(values[5]);
    final BuildingNr buildingNr = values[6].isEmpty() ? null : BuildingNr.of(values[6]);
    final BuildingName buildingName = values[7].isEmpty() ? null : BuildingName.of(values[7]);
    final SubBuilding subBuilding = values[8].isEmpty() ? null : SubBuilding.of(values[8]);
    final PoBoxNumber poBoxNumber = values[9].isEmpty() ? null : PoBoxNumber.of(values[9]);
    final Department department = values[10].isEmpty() ? null : Department.of(values[10]);
    final Neighbourhood neighbourhood = values[11].isEmpty() ? null : Neighbourhood.of(values[11]);
    final Block block = values[12].isEmpty() ? null : Block.of(values[12]);
    final BFPONumber bFPONumber = values[13].isEmpty() ? null : BFPONumber.of(values[13]);
    final Lines lines = values[14].isEmpty() ? null : Lines.of(values[14]);
    final Address address = Address.of(country, postalCode, city, province, district, street, buildingNr, buildingName, subBuilding, poBoxNumber, department, neighbourhood, block, bFPONumber, lines);
    final WGS84Position position = values[15].isEmpty() ? null : WGS84Position.of(values[15]);
    return of(address, position);
   }


  /**
   * Returns the value of this AddressWithWGS84Position as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return address.stringValue() + position.stringValue();
   }

 }
