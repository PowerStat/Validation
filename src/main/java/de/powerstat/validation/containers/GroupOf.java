/*
 * Copyright (C) 2023 Dipl.-Inform. Kai Hofmann. All rights reserved!
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


/**
 * Group of a specific type.
 *
 * @param <T> Use only entities
 */
public class GroupOf<T> implements Set<T>
 {
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
    if ((groupName.length() < 1) || (groupName.length() > 40))
     {
      throw new IllegalArgumentException("groupName with wrong length"); //$NON-NLS-1$
     }
    if (!GroupOf.GROUPNAME_REGEXP.matcher(groupName).matches())
     {
      throw new IllegalArgumentException("groupName with wrong format"); //$NON-NLS-1$
     }
    this.name = groupName;
   }


  /**
   * Returns the name of this GroupOf.
   *
   * @return The name of this group.
   */
  public String name()
   {
    return this.name;
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
    return Objects.hash(this.name, this.group);
   }


  /**
   * Is equal with another object.
   *
   * @param obj Object
   * @return true when equal, false otherwise
   * @throws NoSuchElementException If there is no entry in this GroupOf
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(final Object obj)
   {
    if (this == obj)
     {
      return true;
     }
    if (!(obj instanceof GroupOf<?>))
    // if ((obj == null) || (this.getClass() != obj.getClass()))
     {
      return false;
     }
    final GroupOf<T> other = (GroupOf<T>)obj;
    return this.name.equals(other.name) && this.group.equals(other.group);
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
  @Override
  public String toString()
   {
    final var builder = new StringBuilder();
    builder.append("GroupOf<>[name="); //$NON-NLS-1$
    builder.append(this.name);
    builder.append(", ");
    final int initLength = builder.length();
    for (final T entry : this.group)
     {
      builder.append(entry);
      builder.append(", "); //$NON-NLS-1$
     }
    if (", ".equals(builder.substring(builder.length() - 2)))
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
    return this.group.size();
   }


  /**
   * Returns true if this set contains no elements.
   *
   * @return True if this set contains no elements
   */
  @Override
  public boolean isEmpty()
   {
    return this.group.isEmpty();
   }


  /**
   * Returns true if this set contains the specified element. More formally, returns true if and only if this set contains an element e such that (o==null ? e==null : o.equals(e)).
   *
   * @param o Element whose presence in this set is to be tested
   * @return true if this set contains the specified element
   */
  @Override
  public boolean contains(final Object o)
   {
    return this.group.contains(o);
   }


  /**
   * Returns an iterator over the elements in this set. The elements are returned in no particular order (unless this set is an instance of some class that provides a guarantee).
   *
   * @return An iterator over the elements in this set
   */
  @Override
  public Iterator<T> iterator()
   {
    return this.group.iterator();
   }


  /**
   * Returns an array containing all of the elements in this set. If this set makes any guarantees as to what order its elements are returned by its iterator, this method must return the elements in the same order.
   *
   * @return An array containing all the elements in this set
   */
  @Override
  public Object[] toArray()
   {
    return this.group.toArray();
   }


  /**
   * Returns an array containing all of the elements in this set; the runtime type of the returned array is that of the specified array. If the set fits in the specified array, it is returned therein. Otherwise, a new array is allocated with the runtime type of the specified array and the size of this set.
   *
   * @param a The array into which the elements of this set are to be stored, if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose.
   * @return An array containing all the elements in this set
   */
  @Override
  public <T> T[] toArray(final T[] a)
   {
    return this.group.toArray(a);
   }


  /**
   * Adds the specified element to this set if it is not already present.
   *
   * @param e Element to be added to this set
   * @return true if this set did not already contain the specified element
   */
  @Override
  public boolean add(final T e)
   {
    return this.group.add(e);
   }


  /**
   * Removes the specified element from this set if it is present.
   *
   * @param o object to be removed from this set, if present
   * @return true if this set contained the specified element
   */
  @Override
  public boolean remove(final Object o)
   {
    return this.group.remove(o);
   }


  /**
   * Returns true if this set contains all of the elements of the specified collection. If the specified collection is also a set, this method returns true if it is a subset of this set.
   *
   * @param c Collection to be checked for containment in this set
   * @return true if this set contains all of the elements of the specified collection
   */
  @Override
  public boolean containsAll(final Collection<?> c)
   {
    return this.group.containsAll(c);
   }


  /**
   * Returns true if this set contains all of the elements of the specified collection. If the specified collection is also a set, this method returns true if it is a subset of this set.
   *
   * @param c Collection to be checked for containment in this set
   * @return true if this set contains all of the elements of the specified collection
   */
  @Override
  public boolean addAll(final Collection<? extends T> c)
   {
    return this.group.addAll(c);
   }


  /**
   * Retains only the elements in this set that are contained in the specified collection.
   *
   * @param c Collection containing elements to be retained in this set
   * @return true if this set changed as a result of the call
   */
  @Override
  public boolean retainAll(final Collection<?> c)
   {
    return this.group.retainAll(c);
   }


  /**
   * Removes from this set all of its elements that are contained in the specified collection.
   *
   * @param c Collection containing elements to be removed from this set
   * @return true if this set changed as a result of the call
   */
  @Override
  public boolean removeAll(final Collection<?> c)
   {
    return this.group.removeAll(c);
   }


  /**
   * Removes all of the elements from this set (optional operation). The set will be empty after this call returns.
   */
  @Override
  public void clear()
   {
    this.group.clear();
   }

 }
