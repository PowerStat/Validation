/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.powerstat.validation.values.CommunicationChannel;


/**
 * Communication channel tests.
 */
final class CommunicationChannelTests
 {
  /**
   * Julian action not as expected constant.
   */
  private static final String ACTION_NOT_AS_EXPECTED = "Action not as expected";


  /**
   * Default constructor.
   */
  /* default */ CommunicationChannelTests()
   {
    super();
   }


  /**
   * Factory string test.
   */
  @Test
  /* default */ void testFactory1()
   {
    assertEquals(0, CommunicationChannel.of("LETTER").getAction(), ACTION_NOT_AS_EXPECTED); //$NON-NLS-1$
   }


  /**
   * Test getAction of CommunicationChannel.
   */
  @Test
  /* default */ void testGetAction()
   {
    assertAll("constructor", //$NON-NLS-1$
      () -> assertEquals(0, CommunicationChannel.LETTER.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(1, CommunicationChannel.PHONE.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(2, CommunicationChannel.CARRIER_PIGEON.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(3, CommunicationChannel.BOOK.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(4, CommunicationChannel.LOUDSPEAKER.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(5, CommunicationChannel.SIREN.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(6, CommunicationChannel.RADIO.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(7, CommunicationChannel.TV.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(8, CommunicationChannel.VIDEOTEXT.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(9, CommunicationChannel.POSTER.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(10, CommunicationChannel.AMATEUR_RADIO.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(11, CommunicationChannel.BLUETOOTH.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(12, CommunicationChannel.EMAIL.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(13, CommunicationChannel.SIP.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(14, CommunicationChannel.SKYPE.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(15, CommunicationChannel.FACETIME.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(16, CommunicationChannel.NEWS.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(17, CommunicationChannel.GOPHER.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(18, CommunicationChannel.IRC.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(19, CommunicationChannel.JABBER.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(20, CommunicationChannel.MATRIX.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(21, CommunicationChannel.TEAMSPEAK.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(22, CommunicationChannel.VENTRILO.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(23, CommunicationChannel.STEAM.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(24, CommunicationChannel.DIASPORA.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(25, CommunicationChannel.LORAWAN.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(26, CommunicationChannel.MESHTASTIC.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(27, CommunicationChannel.DISCORD.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(28, CommunicationChannel.KIK.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(29, CommunicationChannel.SIGNAL.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(30, CommunicationChannel.TELEGRAM.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(31, CommunicationChannel.THREEMA.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(32, CommunicationChannel.WHATSAPP.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(33, CommunicationChannel.TELEGUARD.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(34, CommunicationChannel.SNAPCHAT.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(35, CommunicationChannel.WEBEX.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(36, CommunicationChannel.GOOGLE_MEET.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(37, CommunicationChannel.JITSI.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(38, CommunicationChannel.TEAMS.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(39, CommunicationChannel.ZOOM.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(40, CommunicationChannel.FACEBOOK.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(41, CommunicationChannel.YOUTUBE.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(42, CommunicationChannel.INSTAGRAM.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(43, CommunicationChannel.TIKTOK.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(44, CommunicationChannel.WECHAT.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(45, CommunicationChannel.REDDIT.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(46, CommunicationChannel.XING.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(47, CommunicationChannel.LINKEDIN.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(48, CommunicationChannel.X.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(49, CommunicationChannel.PINTEREST.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(50, CommunicationChannel.TWITCH.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(51, CommunicationChannel.THREADS.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(52, CommunicationChannel.STAYFRIENDS.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(53, CommunicationChannel.DRIFT_BOTTLE.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(54, CommunicationChannel.GITHUB.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(55, CommunicationChannel.GITLAB.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(56, CommunicationChannel.SOURCEFORGE.getAction(), ACTION_NOT_AS_EXPECTED),
      () -> assertEquals(57, CommunicationChannel.HOMEPAGE.getAction(), ACTION_NOT_AS_EXPECTED)
    );
   }


  /**
   * Test stringValue.
   */
  @Test
  /* default */ void testStringValue()
   {
    final CommunicationChannel channel = CommunicationChannel.LETTER;
    assertEquals("LETTER", channel.stringValue(), "stringValue not as expected");
   }

 }
