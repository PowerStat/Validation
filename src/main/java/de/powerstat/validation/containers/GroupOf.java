/*
 * Copyright (C) 2023-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.containers;


import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.regex.Pattern;

import org.checkerframework.checker.nullness.qual.Nullable;
import org.jmolecules.ddd.annotation.Entity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;


/**
 * Group of a specific type.
 *
 * @param <T> Use only entities
 */
public final class GroupOf<T> implements Set<T>
 {
  /**
   * Separation.
   */
  private static final String SEPARATION = ", ";

  /**
   * Group name regexp.
   */
  private static final Pattern GROUPNAME_REGEXP = Pattern.compile("^[\\p{L}][\\p{L}-]*$"); //$NON-NLS-1$

  /**
   * Group name.
   */
  private final String name;

  /**
   * Group.
   */
  private final SortedSet<T> group = new ConcurrentSkipListSet<>();


  /**
   * Constructor.
   *
   * @param groupName Group name (maximum 40 characters)
   */
  public GroupOf(final String groupName)
   {
    super();
    Objects.requireNonNull(groupName, "groupName"); //$NON-NLS-1$
    if (groupName.isEmpty() || (groupName.length() > 40))
     {
      throw new IllegalArgumentException("groupName with wrong length"); //$NON-NLS-1$
     }
    if (!GroupOf.GROUPNAME_REGEXP.matcher(groupName).matches())
     {
      throw new IllegalArgumentException("groupName with wrong format"); //$NON-NLS-1$
     }
    name = groupName;
   }


  /**
   * Returns the name of this GroupOf.
   *
   * @return The name of this group.
   */
  public String name()
   {
    return name;
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
    return Objects.hash(name, group);
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @throws NoSuchElementException If there is no entry in this GroupOf
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @SuppressWarnings({"PMD.LooseCoupling"})
  @Override
  public final boolean equals(final @Nullable Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof GroupOf<?>))
     {
      return false;
     }
    final GroupOf<T> other = (GroupOf<T>)obj;
    return name.equals(other.name) && group.equals(other.group);
   }


  /**
   * Returns the string representation of this GroupOf.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "GroupOf&lt;&gt;[, ...]"
   *
   * @return String representation of this GroupOf
   * @see java.lang.Object#toString()
   */
  @SuppressFBWarnings("POTENTIAL_XML_INJECTION")
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("GroupOf<>[name=").append(name).append(SEPARATION); //$NON-NLS-1$
    for (final T entry : group)
     {
      builder.append(entry).append(SEPARATION);
     }
    if (SEPARATION.equals(builder.substring(builder.length() - 2)))
     {
      builder.setLength(builder.length() - 2);
     }
    builder.append(']');
    return builder.toString();
   }


  /**
   * Returns the number of elements in this set (its cardinality).
   *
   * @return The number of elements in this set (its cardinality)
   */
  @Override
  public int size()
   {
    return group.size();
   }


  /**
   * Returns true if this set contains no elements.
   *
   * @return True if this set contains no elements
   */
  @Override
  public boolean isEmpty()
   {
    return group.isEmpty();
   }


  /**
   * Returns true if this set contains the specified element. More formally, returns true if and only if this set contains an element e such that (o==null ? e==null : o.equals(e)).
   *
   * @param obj Element whose presence in this set is to be tested
   * @return true if this set contains the specified element
   */
  @Override
  public boolean contains(final Object obj)
   {
    return group.contains(obj);
   }


  /**
   * Returns an iterator over the elements in this set. The elements are returned in no particular order (unless this set is an instance of some class that provides a guarantee).
   *
   * @return An iterator over the elements in this set
   */
  @Override
  public Iterator<T> iterator()
   {
    return group.iterator();
   }


  /**
   * Returns an array containing all of the elements in this set. If this set makes any guarantees as to what order its elements are returned by its iterator, this method must return the elements in the same order.
   *
   * @return An array containing all the elements in this set
   */
  @Override
  public Object[] toArray()
   {
    return group.toArray();
   }


  /**
   * Returns an array containing all of the elements in this set; the runtime type of the returned array is that of the specified array. If the set fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this set.
   *
   * @param arr The array into which the elements of this set are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose.
   * @return An array containing all the elements in this set
   */
  @Override
  public <T> T[] toArray(final T[] arr)
   {
    return group.toArray(arr);
   }


  /**
   * Adds the specified element to this set if it is not already present.
   *
   * @param elem Element to be added to this set
   * @return true if this set did not already contain the specified element
   */
  @Override
  public boolean add(final T elem)
   {
    return group.add(elem);
   }


  /**
   * Removes the specified element from this set if it is present.
   *
   * @param obj object to be removed from this set, if present
   * @return true if this set contained the specified element
   */
  @Override
  public boolean remove(final Object obj)
   {
    return group.remove(obj);
   }


  /**
   * Returns true if this set contains all of the elements of the specified collection. If the specified collection is also a set, this method returns true if it is a subset of this set.
   *
   * @param coll Collection to be checked for containment in this set
   * @return true if this set contains all of the elements of the specified collection
   */
  @Override
  public boolean containsAll(final Collection<?> coll)
   {
    return group.containsAll(coll);
   }


  /**
   * Returns true if this set contains all of the elements of the specified collection. If the specified collection is also a set, this method returns true if it is a subset of this set.
   *
   * @param coll Collection to be checked for containment in this set
   * @return true if this collection changed as a result of the call
   */
  @Override
  public boolean addAll(final Collection<? extends T> coll)
   {
    return group.addAll(coll);
   }


  /**
   * Retains only the elements in this set that are contained in the specified collection.
   *
   * @param coll Collection containing elements to be retained in this set
   * @return true if this set changed as a result of the call
   */
  @Override
  public boolean retainAll(final Collection<?> coll)
   {
    return group.retainAll(coll);
   }


  /**
   * Removes from this set all of its elements that are contained in the specified collection.
   *
   * @param coll Collection containing elements to be removed from this set
   * @return true if this set changed as a result of the call
   */
  @Override
  public boolean removeAll(final Collection<?> coll)
   {
    return group.removeAll(coll);
   }


  /**
   * Removes all of the elements from this set (optional operation). The set will be empty after this call returns.
   */
  @Override
  public void clear()
   {
    group.clear();
   }

 }
