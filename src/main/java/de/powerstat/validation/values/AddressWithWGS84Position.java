/*
 * Copyright (C) 2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

import de.powerstat.validation.values.containers.NTuple16;


/**
 * Address.
 *
 * DSGVO relevant.
 */
// @SuppressFBWarnings("PMB_POSSIBLE_MEMORY_BLOAT")
@SuppressWarnings("PMD.UseConcurrentHashMap")
public final class AddressWithWGS84Position extends Address
 {
  /**
   * Cache for singletons.
   */
  private static final Map<NTuple16<Country, PostalCode, City, Province, District, Street, BuildingNr, BuildingName, SubBuilding, PoBoxNumber, Department, Neighbourhood, Block, BFPONumber, Lines, WGS84Position>, AddressWithWGS84Position> CACHE = new WeakHashMap<>();

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
    // return new AddressWithWGS84Position(country, postalCode, city, province, district, street, buildingNr, buildingName, subBuilding, poBoxNumber, department, neighbourhood, block, bFPONumber, lines, position);
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
   }


  /**
   * Get position.
   *
   * @return The position
   */
  public WGS84Position getPosition()
   {
    return this.position;
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
    return Objects.hash(super.hashCode(), this.position);
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
    if ((obj == null) || (this.getClass() != obj.getClass()))
    // if (!(obj instanceof AddressWithWGS84Position))
     {
      return false;
     }
    final AddressWithWGS84Position other = (AddressWithWGS84Position)obj;
    boolean result = this.position.equals(other.position);
    if (result)
     {
      result = super.equals(other);
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
    final StringBuilder builder = new StringBuilder(182);
    builder.append("AddressWithWGS84Position[position=").append(this.position) //$NON-NLS-1$
      .append(", ").append(super.toString()) //$NON-NLS-1$
      .append(']');
    return builder.toString();
   }

 }
