/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import nl.jqno.equalsverifier.*;
import de.powerstat.validation.values.Province;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Province tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
final class ProvinceTests
 {
  /**
   * abc.
   */
  private static final String ABC = "abc"; //$NON-NLS-1$

  /**
   * abcd.
   */
  private static final String ABCD = "abcd"; //$NON-NLS-1$

  /**
   * def.
   */
  private static final String DEF = "def"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected constant.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Province not as expected constant.
   */
  private static final String PROVINCE_NOT_AS_EXPECTED = "Province not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  /* default */ ProvinceTests()
   {
    super();
   }


  /**
   * Test correct Province.
   *
   * @param province Province
   */
  @ParameterizedTest
  @ValueSource(strings = {"A", "Abcdefghijklmnopqr"})
  /* default */ void testProvinceCorrect(final String province)
   {
    final Province cleanProvince = Province.of(province);
    assertEquals(province, cleanProvince.stringValue(), ProvinceTests.PROVINCE_NOT_AS_EXPECTED);
   }


  /**
   * Test Province with wrong lengths.
   *
   * @param province Province
   */
  @ParameterizedTest
  @ValueSource(strings = {"", "Abcdefghijklmnopqrs"})
  /* default */ void testProvinceLength(final String province)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Province cleanProvince = */ Province.of(province);
     }, ProvinceTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test wrong Province.
   *
   * @param province Province
   */
  @ParameterizedTest
  @ValueSource(strings = {"abc0815", "abc_def"})
  /* default */ void testProvinceWrong(final String province)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Province cleanProvince = */ Province.of(province);
     }, ProvinceTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test get province.
   */
  @Test
  /* default */ void testStringValue()
   {
    final Province province = Province.of(ProvinceTests.ABCD);
    assertEquals(ProvinceTests.ABCD, province.stringValue(), ProvinceTests.PROVINCE_NOT_AS_EXPECTED);
   }


  /**
   * Equalsverifier.
   */
  @Test
  public void equalsContract()
   {
    EqualsVerifier.forClass(Province.class).withNonnullFields("province").verify();
   }


  /**
   * Test toString.
   */
  @Test
  /* default */ void testToString()
   {
    final Province province = Province.of(ProvinceTests.ABC);
    assertEquals("Province[province=abc]", province.toString(), "toString not equal"); //$NON-NLS-1$ //$NON-NLS-2$
   }


  /**
   * Test compareTo.
   */
  @Test
  @SuppressWarnings("java:S5785")
  /* default */ void testCompareTo()
   {
    final Province province1 = Province.of(ProvinceTests.ABC);
    final Province province2 = Province.of(ProvinceTests.ABC);
    final Province province3 = Province.of(ProvinceTests.DEF);
    final Province province4 = Province.of("ghi"); //$NON-NLS-1$
    final Province province5 = Province.of(ProvinceTests.ABC);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(province1.compareTo(province2) == -province2.compareTo(province1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(province1.compareTo(province3) == -province3.compareTo(province1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((province4.compareTo(province3) > 0) && (province3.compareTo(province1) > 0) && (province4.compareTo(province1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((province1.compareTo(province2) == 0) && (Math.abs(province1.compareTo(province5)) == Math.abs(province2.compareTo(province5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((province1.compareTo(province2) == 0) && province1.equals(province2), "equals") //$NON-NLS-1$
    );
   }

 }
