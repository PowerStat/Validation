/*
 * Copyright (C) 2020-2022 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;


/**
 * Address Block.
 *
 * Not DSGVO relevant.
 */
public final class Block implements Comparable<Block>
 {
  /**
   * Block regexp.
   */
  private static final Pattern BLOCK_REGEXP = Pattern.compile("^[\\p{L}\\p{Digit}]*$"); //$NON-NLS-1$

  /**
   * Block.
   */
  private final String block;


  /**
   * Constructor.
   *
   * @param block Block
   * @throws NullPointerException if block is null
   * @throws IllegalArgumentException if block is not a correct Block
   */
  public Block(final String block)
   {
    super();
    Objects.requireNonNull(block, "block"); //$NON-NLS-1$
    if ((block.length() < 1) || (block.length() > 16))
     {
      throw new IllegalArgumentException("Block with wrong length"); //$NON-NLS-1$
     }
    if (!Block.BLOCK_REGEXP.matcher(block).matches())
     {
      throw new IllegalArgumentException("Block with wrong format"); //$NON-NLS-1$
     }
    this.block = block;
   }


  /**
   * Block factory.
   *
   * @param block Block
   * @return Block object
   */
  public static Block of(final String block)
   {
    return new Block(block);
   }


  /**
   * Get block string.
   *
   * @return Block string
   * @deprecated Use stringValue() instead.
   */
  @Deprecated
  public String getBlock()
   {
    return this.block;
   }


  /**
   * Returns the value of this Block as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  public String stringValue()
   {
    return this.block;
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
    return this.block.hashCode();
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
    if (!(obj instanceof Block))
     {
      return false;
     }
    final Block other = (Block)obj;
    return this.block.equals(other.block);
   }


  /**
   * Returns the string representation of this Block.
   *
   * The exact details of this representation are unspecified and subject to change, but the following may be regarded as typical:
   *
   * "Block[block=A]"
   *
   * @return String representation of this Block
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString()
   {
    final StringBuilder builder = new StringBuilder();
    builder.append("Block[block=").append(this.block).append(']'); //$NON-NLS-1$
    return builder.toString();
   }


  /**
   * Compare with another object.
   *
   * @param obj Object to compare with
   * @return 0: equal; 1: greater; -1: smaller
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(final Block obj)
   {
    Objects.requireNonNull(obj, "obj"); //$NON-NLS-1$
    return this.block.compareTo(obj.block);
   }

 }


