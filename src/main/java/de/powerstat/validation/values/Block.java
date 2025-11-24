/*
 * Copyright (C) 2020-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements; and to You under the Apache License, Version 2.0.
 */
package de.powerstat.validation.values;


import java.util.Objects;
import java.util.regex.Pattern;

import de.powerstat.validation.interfaces.IValueObject;


/**
 * Address Block.
 *
 * @param block Address block
 *
 * Not DSGVO relevant.
 */
public record Block(String block) implements Comparable<Block>, IValueObject
 {
  /**
   * Block regexp.
   */
  private static final Pattern BLOCK_REGEXP = Pattern.compile("^[\\p{L}\\p{Digit}]*$"); //$NON-NLS-1$


  /**
   * Constructor.
   *
   * @param block Address block
   * @throws NullPointerException if block is null
   * @throws IllegalArgumentException if block is not a correct Block
   */
  public Block
   {
    Objects.requireNonNull(block, "block"); //$NON-NLS-1$
    if (block.isEmpty() || (block.length() > 16))
     {
      throw new IllegalArgumentException("Block with wrong length"); //$NON-NLS-1$
     }
    if (!Block.BLOCK_REGEXP.matcher(block).matches())
     {
      throw new IllegalArgumentException("Block with wrong format"); //$NON-NLS-1$
     }
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
   * Returns the value of this Block as a string.
   *
   * @return The text value represented by this object after conversion to type string.
   */
  @Override
  public String stringValue()
   {
    return block;
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
    return block.compareTo(obj.block);
   }

 }


