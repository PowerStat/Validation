/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.impl;


/**
 * ISBN group number 1 publisher numbers.
 */
public final class ISBN13Publisher1 implements IISBN13Publisher
 {
  /**
   * Default constructor.
   */
  public ISBN13Publisher1()
   {
    super();
   }


  /**
   * English publishers.
   *
   * @param rest Rest of isbn number
   * @return Publisher number (variable length)
   * @throws IllegalArgumentException When an illegal character appears
   */
  @SuppressWarnings({"PMD.CyclomaticComplexity"})
  @Override
  public String publisher(final String rest)
   {
    switch (rest.charAt(0))
     {
      case '0':
        return rest.substring(0, 2);
      case '1', '2', '3':
        return rest.substring(0, 3);
      case '4':
        return rest.substring(0, 4);
      case '5':
        switch (rest.charAt(1))
         {
          case '0', '1', '2', '3', '4':
            return rest.substring(0, 4);
          case '5', '6', '7', '8', '9':
            return rest.substring(0, 5);
          default:
            throw new IllegalArgumentException("Publisher nr not 5(0-9)");
         }
      case '6', '7':
        return rest.substring(0, 5);
      case '8':
        switch (rest.charAt(1))
         {
          case '0', '1', '2', '3', '4', '5':
            return rest.substring(0, 5);
          case '6':
            switch (rest.charAt(2))
             {
              case '0', '1', '2', '3', '4', '5', '6', '7', '8':
                return rest.substring(0, 5);
              case '9':
                switch (rest.charAt(3))
                 {
                  case '0', '1', '2', '3', '4', '5', '6', '7':
                    return rest.substring(0, 5);
                  case '8', '9':
                    return rest.substring(0, 6);
                  default:
                    throw new IllegalArgumentException("Publisher nr not 869(0-9)");
                 }
              default:
                throw new IllegalArgumentException("Publisher nr not 86(0-9)");
             }
          case '7', '8', '9':
            return rest.substring(0, 6);
          default:
            throw new IllegalArgumentException("Publisher nr not 8(0-9)");
         }
      case '9':
      default:
        throw new IllegalArgumentException("Publisher nr not 0-9");
     }
   }

 }
