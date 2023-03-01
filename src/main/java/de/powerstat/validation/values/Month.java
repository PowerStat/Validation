/*
 * Copyright (C) 2020-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;


/**
 * Month.
 *
 * @param month Month 1-12
 * 
 * Not DSGVO relevant.
 *
 * TODO constructor with year
 * TODO daysWithin() = 31, 30, 29, 28, n (Year specific for february, or october 1582)
 * TODO Listener
 * TODO Translations short/long
 */
public record Month(int month) implements Comparable<Month>
 {
  /**
   * Overflow constant.
   */
  private static final String OVERFLOW = "Overflow"; //$NON-NLS-1$

  /**
   * Underflow constant.
   */
  private static final String UNDERFLOW = "Underflow"; //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @throws IndexOutOfBoundsException When the month is less than 1 or greater than 12
   */
  public Month
   {
    if ((month < 1) || (month > 12))
     {
      throw new IndexOutOfBoundsException("Month number out of range (1-12)!"); //$NON-NLS-1$
     }
   }


  /**
   * Month factory.
   *
   * @param month Month 1-12
   * @return Month object
   */
  public static Month of(final int month)
   {
    return new Month(month);
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Month obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return Integer.compare(this.month, obj.month);
   }


  /**
   * Add months to this month.
   *
   * @param months Months to add to this month
   * @return New month after adding the months to this month
   * @throws ArithmeticException In case of an overflow
   */
  public Month add(final Months months)
   {
    final long newMonth = Math.toIntExact(Math.addExact(this.month, months.months()));
    if (newMonth > 12) // while (newMonth > 12)
     {
      // TODO Listener
      // newMonth -= 12;
      // incrementYear();
      throw new ArithmeticException(Month.OVERFLOW);
     }
    return Month.of(Math.toIntExact(newMonth));
   }


  /**
   * Subtract months from this month.
   *
   * @param months Months to subtract from this month
   * @return New month after subtracting months from this month
   * @throws ArithmeticException In case of an underflow
   */
  public Month subtract(final Months months)
   {
    final long newMonth = Math.toIntExact(Math.subtractExact(this.month, months.months()));
    if (newMonth <= 0) // while (newMonth <= 0)
     {
      // TODO Listener
      // newMonth += 12;
      // decrementYear();
      throw new ArithmeticException(Month.UNDERFLOW);
     }
    return Month.of(Math.toIntExact(newMonth));
   }


  /**
   * Increment this week.
   *
   * @return New month after incrementing this month
   * @throws ArithmeticException In case of an overflow
   */
  public Month increment()
   {
    final int newMonth = Math.incrementExact(this.month);
    if (newMonth == 13)
     {
      // TODO Listener
      // newMonth = 1;
      // incrementYear();
      throw new ArithmeticException(Month.OVERFLOW);
     }
    return Month.of(newMonth);
   }


  /**
   * Decrement this month.
   *
   * @return New month after decrement this month
   * @throws ArithmeticException In case of an overflow
   */
  public Month decrement()
   {
    final int newMonth = Math.decrementExact(this.month);
    if (newMonth == 0)
     {
      // TODO Listener
      // newMonth = 12;
      // decrementYear();
      throw new ArithmeticException(Month.UNDERFLOW);
     }
    return Month.of(newMonth);
   }

 }
