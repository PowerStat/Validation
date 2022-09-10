/*
 * Copyright (C) 2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Blood group AB0 rhesus system.
 *
 * @see https://de.wikipedia.org/wiki/Blutgruppe
 */
public enum BloodGroup
 {
  /**
   * 0-.
   */
  ON(0),

  /**
   * 0+.
   */
  OP(1),

  /**
   * A-.
   */
  AN(2),

  /**
   * A+.
   */
  AP(3),

  /**
   * B-.
   */
  BN(4),

  /**
   * B+.
   */
  BP(5),

  /**
   * AB-.
   */
  ABN(6),

  /**
   * AB+.
   */
  ABP(7);


  /**
   * Donate to other blood group.
   */
  private static final Map<BloodGroup, List<BloodGroup>> DONATE_TO = new HashMap<>();

  /**
   * Receive from other blood group.
   */
  private static final Map<BloodGroup, List<BloodGroup>> RECEIVE_FROM = new HashMap<>();

  /**
   * Action number.
   */
  private final int action;


  static
   {
    final List<BloodGroup> onTo = new ArrayList<>();
    onTo.add(ABP);
    onTo.add(ABN);
    onTo.add(AP);
    onTo.add(AN);
    onTo.add(BP);
    onTo.add(BN);
    onTo.add(OP);
    onTo.add(ON);
    DONATE_TO.put(ON, onTo);

    final List<BloodGroup> opTo = new ArrayList<>();
    opTo.add(ABP);
    opTo.add(AP);
    opTo.add(BP);
    opTo.add(OP);
    DONATE_TO.put(OP, opTo);

    final List<BloodGroup> bnTo = new ArrayList<>();
    bnTo.add(ABP);
    bnTo.add(ABN);
    bnTo.add(BP);
    bnTo.add(BN);
    DONATE_TO.put(BN, bnTo);

    final List<BloodGroup> bpTo = new ArrayList<>();
    bpTo.add(ABP);
    bpTo.add(BP);
    DONATE_TO.put(BP, bpTo);

    final List<BloodGroup> anTo = new ArrayList<>();
    anTo.add(ABP);
    anTo.add(ABN);
    anTo.add(AP);
    anTo.add(AN);
    DONATE_TO.put(AN, anTo);

    final List<BloodGroup> apTo = new ArrayList<>();
    apTo.add(ABP);
    apTo.add(AP);
    DONATE_TO.put(AP, apTo);

    final List<BloodGroup> abnTo = new ArrayList<>();
    abnTo.add(ABP);
    abnTo.add(ABN);
    DONATE_TO.put(ABN, abnTo);

    final List<BloodGroup> abpTo = new ArrayList<>();
    abpTo.add(ABP);
    DONATE_TO.put(ABP, abpTo);

    final List<BloodGroup> abpFrom = new ArrayList<>();
    abpFrom.add(ON);
    abpFrom.add(OP);
    abpFrom.add(BN);
    abpFrom.add(BP);
    abpFrom.add(AN);
    abpFrom.add(AP);
    abpFrom.add(ABN);
    abpFrom.add(ABP);
    RECEIVE_FROM.put(ABP, abpFrom);

    final List<BloodGroup> abnFrom = new ArrayList<>();
    abnFrom.add(ON);
    abnFrom.add(BN);
    abnFrom.add(AN);
    abnFrom.add(ABN);
    RECEIVE_FROM.put(ABN, abnFrom);

    final List<BloodGroup> apFrom = new ArrayList<>();
    apFrom.add(ON);
    apFrom.add(OP);
    apFrom.add(AN);
    apFrom.add(AP);
    RECEIVE_FROM.put(AP, apFrom);

    final List<BloodGroup> anFrom = new ArrayList<>();
    anFrom.add(ON);
    anFrom.add(AN);
    RECEIVE_FROM.put(AN, anFrom);

    final List<BloodGroup> bpFrom = new ArrayList<>();
    bpFrom.add(ON);
    bpFrom.add(OP);
    bpFrom.add(BN);
    bpFrom.add(BP);
    RECEIVE_FROM.put(BP, bpFrom);

    final List<BloodGroup> bnFrom = new ArrayList<>();
    bnFrom.add(ON);
    bnFrom.add(BN);
    RECEIVE_FROM.put(BN, bnFrom);

    final List<BloodGroup> opFrom = new ArrayList<>();
    opFrom.add(ON);
    opFrom.add(OP);
    RECEIVE_FROM.put(OP, opFrom);

    final List<BloodGroup> onFrom = new ArrayList<>();
    onFrom.add(ON);
    RECEIVE_FROM.put(ON, onFrom);
   }


  /**
   * Ordinal constructor.
   *
   * @param action Action number
   */
  BloodGroup(final int action)
   {
    this.action = action;
   }


  /**
   * Get action number.
   *
   * @return Action number
   */
  public int getAction()
   {
    return this.action;
   }


  /**
   * Could donate blood to other blood group.
   *
   * @param other Other blood group to donate to
   * @return true: possible; false: not possible
   */
  public boolean couldDonateTo(final BloodGroup other)
   {
    return DONATE_TO.get(this).contains(other);
   }


  /**
   * Could receive blood from other blood group.
   *
   * @param other Other blood group to receive from
   * @return true: possible; false: not possible
   */
  public boolean couldReceiveFrom(final BloodGroup other)
   {
    return RECEIVE_FROM.get(this).contains(other);
   }

 }