/*
 * Copyright (C) 2022-2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.containers;


import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentSkipListMap;


/**
 * History of a specific type.
 *
 * @param <T> Use only value objects
 *
 * TODO Change Datetime to an earlier Datetime
 */
public class HistoryOf<T>
 {
  /**
   * History.
   */
  private final SortedMap<OffsetDateTime, T> history = new ConcurrentSkipListMap<>();


  /**
   * Constructor.
   */
  public HistoryOf()
   {
    super();
   }


  /**
   * Calculate hash code.
   *
   * @return Hash
   * @see java.lang.Object#hashCode()
   */
  @Override
  public final int hashCode()
   {
    if (history.isEmpty())
     {
      return 0;
     }
    return Objects.hash(history);
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @throws NoSuchElementException If there is no entry in this HistoryOf
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public final boolean equals(final Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof HistoryOf<?>))
    // if ((obj == null) || (this.getClass() != obj.getClass()))
     {
      return false;
     }
    final HistoryOf<T> other = (HistoryOf<T>)obj;
    if ((history.isEmpty()) || (other.history.isEmpty()))
     {
      return ((history.isEmpty()) && (other.history.isEmpty()));
     }
    // return this.getLatestEntry().equals(other.getLatestEntry());
    return history.equals(other.history);
   }


  /**
   * Returns the string representation of this HistoryOf.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "HistoryOf&lt;&gt;[2020-01-11T21:10:00+01=?, ...]"
   *
   * @return String representation of this HistoryOf
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("HistoryOf<>["); //$NON-NLS-1$
    final int initLength = builder.length();
    for (final Map.Entry<OffsetDateTime, T> entry : history.entrySet())
     {
      builder.append(entry.getKey().format(DateTimeFormatter.ISO_DATE_TIME));
      builder.append('=');
      builder.append(entry.getValue());
      builder.append(", "); //$NON-NLS-1$
     }
    if (builder.length() > initLength)
     {
      builder.setLength(builder.length() - 2);
     }
    builder.append(']');
    return builder.toString();
   }


  /**
   * Is empty.
   *
   * @return true: empty; false otherwise
   */
  public boolean isEmpty()
   {
    return history.isEmpty();
   }


  /**
   * Add entry.
   *
   * @param since Since datetime
   * @param entry Entry
   * @throws NullPointerException If since and/or entry is/are null
   * @throws IndexOutOfBoundsException If since lies in the future
   * @throws IllegalArgumentException If entry is already latest in history
   */
  public void addEntry(final OffsetDateTime since, final T entry)
   {
    Objects.requireNonNull(since, "since"); //$NON-NLS-1$
    Objects.requireNonNull(entry, "entry"); //$NON-NLS-1$
    if (since.isAfter(OffsetDateTime.now()))
     {
      throw new IndexOutOfBoundsException("since lies in the future!"); //$NON-NLS-1$
     }
    if ((!history.isEmpty()) && entry.equals(this.getLatestEntry()))
     {
      throw new IllegalArgumentException("entry is already latest in HistoryOf!");
     }
    history.put(since, entry);
   }


  /**
   * Get first entry from history.
   *
   * @return First known entry
   * @throws NoSuchElementException If there is no entry in this HistoryOf
   */
  public T getFirstEntry()
   {
    return history.get(history.firstKey());
   }


  /**
   * Get latest entry.
   *
   * @return Latest entry
   * @throws NoSuchElementException If there is no entry in this HistoryOf
   */
  public T getLatestEntry()
   {
    return history.get(history.lastKey());
   }


  /**
   * Get entry before latest entry.
   *
   * @return Entry before latest entry
   * @throws NoSuchElementException If there is no entry in this HistoryOf
   */
  public T getPreviousEntry()
   {
    final Set<OffsetDateTime> keys = history.keySet();
    OffsetDateTime previous = history.firstKey();
    OffsetDateTime latest = history.firstKey();
    for (final OffsetDateTime key : keys)
     {
      if (!latest.equals(key))
       {
        if (!previous.equals(latest))
         {
          previous = latest;
         }
        latest = key;
       }
     }
    return history.get(previous);
   }


  /**
   * Get history.
   *
   * @return History sorted map
   */
  public SortedMap<OffsetDateTime, T> getHistory()
   {
    return new ConcurrentSkipListMap<>(history);
   }

 }
