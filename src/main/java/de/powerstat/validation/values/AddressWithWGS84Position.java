/*
 * Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Address with wgs84 position.
 *
 * DSGVO relevant.
 *
 * TODO compareTo(): AddressWithWGS84Position
 */
public final class AddressWithWGS84Position extends Address
 {
  /* *
   * Cache for singletons.
   */
  // private static final Map<NTuple16<Country, PostalCode, City, Province, District, Street, BuildingNr, BuildingName, SubBuilding, PoBoxNumber, Department, Neighbourhood, Block, BFPONumber, Lines, WGS84Position>, AddressWithWGS84Position> CACHE = new WeakHashMap<>();

  /**
   * WGS84 position.
   */
  private final WGS84Position position;


  /**
   * Constructor.
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
   */
  private AddressWithWGS84Position(final Country country, final PostalCode postalCode, final City city, final Province province, final District district, final Street street, final BuildingNr buildingNr, final BuildingName buildingName, final SubBuilding subBuilding, final PoBoxNumber poBoxNumber, final Department department, final Neighbourhood neighbourhood, final Block block, final BFPONumber bFPONumber, final Lines lines, final WGS84Position position)
   {
    super(country, postalCode, city, province, district, street, buildingNr, buildingName, subBuilding, poBoxNumber, department, neighbourhood, block, bFPONumber, lines);
    Objects.requireNonNull(position, "position"); //$NON-NLS-1$
    this.position = position;
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
  public static AddressWithWGS84Position of(final Country country, final PostalCode postalCode, final City city, final Province province, final District district, final Street street, final BuildingNr buildingNr, final BuildingName buildingName, final SubBuilding subBuilding, final PoBoxNumber poBoxNumber, final Department department, final Neighbourhood neighbourhood, final Block block, final BFPONumber bFPONumber, final Lines lines, final WGS84Position position)
   {
    /*
    final NTuple16<Country, PostalCode, City, Province, District, Street, BuildingNr, BuildingName, SubBuilding, PoBoxNumber, Department, Neighbourhood, Block, BFPONumber, Lines, WGS84Position> tuple = NTuple16.of(country, postalCode, city, province, district, street, buildingNr, buildingName, subBuilding, poBoxNumber, department, neighbourhood, block, bFPONumber, lines, position);
    synchronized (AddressWithWGS84Position.class)
     {
      AddressWithWGS84Position obj = AddressWithWGS84Position.CACHE.get(tuple);
      if (obj != null)
       {
        return obj;
       }
      obj = new AddressWithWGS84Position(country, postalCode, city, province, district, street, buildingNr, buildingName, subBuilding, poBoxNumber, department, neighbourhood, block, bFPONumber, lines, position);
      AddressWithWGS84Position.CACHE.put(tuple, obj);
      return obj;
     }
    */
    return new AddressWithWGS84Position(country, postalCode, city, province, district, street, buildingNr, buildingName, subBuilding, poBoxNumber, department, neighbourhood, block, bFPONumber, lines, position);
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
    final WGS84Position position = values[15].isEmpty() ? null : WGS84Position.of(values[15]);
    return of(country, postalCode, city, province, district, street, buildingNr, buildingName, subBuilding, poBoxNumber, department, neighbourhood, block, bFPONumber, lines, position);
   }


  /**
   * Get position.
   *
   * @return The position
   */
  public WGS84Position getPosition()
   {
    return position;
   }


  /**
   * Returns the value of this AddressWithWGS84Position as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return super.stringValue() + position.stringValue();
   }


  /**
   * Calculate hash code.
   *
   * @return Hash
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode()
   {
    return Objects.hash(super.hashCode(), position);
   }


  /**
   * Can equal.
   *
   * @param other Other object
   * @return true if it can be equal; false otherwise
   */
  @SuppressFBWarnings("COM_COPIED_OVERRIDDEN_METHOD")
  @Override
  public boolean canEqual(final Object other)
   {
    return (other instanceof AddressWithWGS84Position);
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof final AddressWithWGS84Position other))
     {
      return false;
     }
    boolean result = other.canEqual(this);
    if (result)
     {
      result = position.equals(other.position);
      if (result)
       {
        result = super.equals(other);
       }
     }
    return result;
   }


  /**
   * Returns the string representation of this AddressWithWGS84Position.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "AddressWithWGS84Position[]"
   *
   * @return String representation of this AddressWithWGS84Position
   * @see java.lang.Object#toString()
   */
  @SuppressWarnings({"checkstyle:NoWhitespaceBefore", "checkstyle:SeparatorWrap"})
  @Override
  public String toString()
   {
    final var builder = new StringBuilder(182);
    builder.append("AddressWithWGS84Position[position=").append(position) //$NON-NLS-1$
      .append(", ").append(super.toString()) //$NON-NLS-1$
      .append(']');
    return builder.toString();
   }

 }
