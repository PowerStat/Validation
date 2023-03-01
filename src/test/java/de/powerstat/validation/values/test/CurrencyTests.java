/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.test;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import de.powerstat.validation.values.Currency;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Currency tests.
 */
@SuppressFBWarnings({"EC_NULL_ARG", "RV_NEGATING_RESULT_OF_COMPARETO", "RV_RETURN_VALUE_IGNORED_NO_SIDE_EFFECT", "SPP_USE_ZERO_WITH_COMPARATOR"})
public class CurrencyTests
 {
  /**
   * EURO.
   */
  private static final String EUR = "EUR"; //$NON-NLS-1$

  /**
   * USD.
   */
  private static final String USD = "USD"; //$NON-NLS-1$

  /**
   * Illegal argument exception expected.
   */
  private static final String ILLEGAL_ARGUMENT = "Illegal argument exception expected"; //$NON-NLS-1$

  /**
   * Currency code not as expected.
   */
  private static final String CURRENCY_CODE_NOT_AS_EXPECTED = "Currency code not as expected"; //$NON-NLS-1$


  /**
   * Default constructor.
   */
  public CurrencyTests()
   {
    super();
   }


  /**
   * Test Currency with valid currency codes.
   *
   * @param code ISO 4217 code
   */
  @ParameterizedTest
  @ValueSource(strings = {CurrencyTests.EUR})
  public void currencyOk0(final String code)
   {
    final Currency cleanCurrency = Currency.of(code);
    assertEquals(code, cleanCurrency.code(), CurrencyTests.CURRENCY_CODE_NOT_AS_EXPECTED);
   }


  /**
   * Test Currency with currency codes to short or long.
   *
   * @param code ISO 4217 codes
   */
  @ParameterizedTest
  @ValueSource(strings = {"EU", "EURO"})
  public void currencyLength(final String code)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Currency cleanCurrency = */ Currency.of(code);
     }, CurrencyTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test Currency with illegal parameters.
   *
   * @param code ISO 4217 code
   */
  @ParameterizedTest
  @ValueSource(strings = {"EU~", "ZZZ"})
  public void ccurrencyIllegalParameters(final String code)
   {
    assertThrows(IllegalArgumentException.class, () ->
     {
      /* final Currency cleanCurrency = */ Currency.of(code);
     }, CurrencyTests.ILLEGAL_ARGUMENT
    );
   }


  /**
   * Test compareTo.
   */
  @Test
  public void testCompareTo()
   {
    final Currency currency1 = Currency.of(CurrencyTests.EUR);
    final Currency currency2 = Currency.of(CurrencyTests.EUR);
    final Currency currency3 = Currency.of("RUB"); //$NON-NLS-1$
    final Currency currency4 = Currency.of(CurrencyTests.USD);
    final Currency currency5 = Currency.of(CurrencyTests.EUR);
    assertAll("testCompareTo", //$NON-NLS-1$
      () -> assertTrue(currency1.compareTo(currency2) == -currency2.compareTo(currency1), "reflexive1"), //$NON-NLS-1$
      () -> assertTrue(currency1.compareTo(currency3) == -currency3.compareTo(currency1), "reflexive2"), //$NON-NLS-1$
      () -> assertTrue((currency4.compareTo(currency3) > 0) && (currency3.compareTo(currency1) > 0) && (currency4.compareTo(currency1) > 0), "transitive1"), //$NON-NLS-1$
      () -> assertTrue((currency1.compareTo(currency2) == 0) && (Math.abs(currency1.compareTo(currency5)) == Math.abs(currency2.compareTo(currency5))), "sgn1"), //$NON-NLS-1$
      () -> assertTrue((currency1.compareTo(currency2) == 0) && currency1.equals(currency2), "equals") //$NON-NLS-1$
    );
   }

 }
