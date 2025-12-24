/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import org.jmolecules.ddd.annotation.ValueObject;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Communication channels.
 *
 * Not DSGVO relevant.
 */
@ValueObject
public enum CommunicationChannel implements IValueObject
 {
  /**
   * Letter.
   */
  LETTER(0),

  /**
   * (Mobile) Phone.
   */
  PHONE(1),

  /**
   * Carrier pigeon.
   */
  CARRIER_PIGEON(2),

  /**
   * Book.
   */
  BOOK(3),

  /**
   * Loudspeaker.
   */
  LOUDSPEAKER(4),

  /**
   * Siren.
   */
  SIREN(5),

  /**
   * Radio.
   */
  RADIO(6),

  /**
   * Television.
   */
  TV(7),

  /**
   * Videotext.
   */
  VIDEOTEXT(8),

  /**
   * Poster.
   */
  POSTER(9),

  /**
   * Amateur radio.
   */
  AMATEUR_RADIO(10),

  /**
   * Bluetooth.
   */
  BLUETOOTH(11),

  /**
   * EMail.
   */
  EMAIL(12),

  /**
   * SIP.
   */
  SIP(13),

  /**
   * Skype.
   */
  SKYPE(14),

  /**
   * Facetime.
   */
  FACETIME(15),

  /**
   * News.
   */
  NEWS(16),

  /**
   * Gopher.
   */
  GOPHER(17),

  /**
   * IRC.
   */
  IRC(18),

  /**
   * Jabber.
   */
  JABBER(19),

  /**
   * Matrix.
   */
  MATRIX(20),

  /**
   * Teamspeak.
   */
  TEAMSPEAK(21),

  /**
   * Ventrilo.
   */
  VENTRILO(22),

  /**
   * Steam.
   */
  STEAM(23),

  /**
   * Diaspora.
   */
  DIASPORA(24),

  /**
   * Lorawan.
   */
  LORAWAN(25),

  /**
   * Meshtastic.
   */
  MESHTASTIC(26),

  /**
   * Discord.
   */
  DISCORD(27),

  /**
   * Kik.
   */
  KIK(28),

  /**
   * Signal.
   */
  SIGNAL(29),

  /**
   * Telegram.
   */
  TELEGRAM(30),

  /**
   * Threema.
   */
  THREEMA(31),

  /**
   * Whatsapp.
   */
  WHATSAPP(32),

  /**
   * Teleguard.
   */
  TELEGUARD(33),

  /**
   * Snapchat.
   */
  SNAPCHAT(34),

  /**
   * Webex.
   */
  WEBEX(35),

  /**
   * Google meet.
   */
  GOOGLE_MEET(36),

  /**
   * Jitsi.
   */
  JITSI(37),

  /**
   * Microsoft Teams.
   */
  TEAMS(38),

  /**
   * Zoom.
   */
  ZOOM(39),

  /**
   * Facebook.
   */
  FACEBOOK(40),

  /**
   * YouTube.
   */
  YOUTUBE(41),

  /**
   * Instagram.
   */
  INSTAGRAM(42),

  /**
   * TikTok.
   */
  TIKTOK(43),

  /**
   * WeChat.
   */
  WECHAT(44),

  /**
   * Reddit.
   */
  REDDIT(45),

  /**
   * Xing.
   */
  XING(46),

  /**
   * LinkedIn.
   */
  LINKEDIN(47),

  /**
   * X.
   */
  X(48),

  /**
   * Pinterest.
   */
  PINTEREST(49),

  /**
   * Twitch.
   */
  TWITCH(50),

  /**
   * Threads.
   */
  THREADS(51),

  /**
   * Stayfriends.
   */
  STAYFRIENDS(52),

  /**
   * Drift bottle.
   */
  DRIFT_BOTTLE(53),

  /**
   * GitHub.
   */
  GITHUB(54),

  /**
   * GitLab.
   */
  GITLAB(55),

  /**
   * SourceForge.
   */
  SOURCEFORGE(56),

  /**
   * Homepage.
   */
  HOMEPAGE(57);



  /**
   * Action number.
   */
  private final int action;


  /**
   * Ordinal constructor.
   *
   * @param action Action number
   */
  CommunicationChannel(final int action)
   {
    this.action = action;
   }


  /**
   * Communication channel factory.
   *
   * @param value CommunicationChannel enum string
   * @return CommunicationChannel enum
   */
  public static CommunicationChannel of(final String value)
   {
    return CommunicationChannel.valueOf(value);
   }


  /**
   * Get action number.
   *
   * @return Action number
   */
  public int getAction()
   {
    return action;
   }


  /**
   * Returns the value of this CommunicationChannel as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return this.name();
   }

 }
