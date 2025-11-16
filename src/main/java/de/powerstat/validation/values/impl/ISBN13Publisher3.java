/*
 * Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
 */
package de.powerstat.validation.values.impl;


/**
 * ISBN group number 3 publisher numbers.
 */
public final class ISBN13Publisher3 implements IISBN13Publisher
 {
  /**
   * Default constructor.
   */
  public ISBN13Publisher3()
   {
    super();
   }


  /**
   * German publishers.
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
        switch (rest.charAt(1))
         {
          case '0': // Sammelnummer für Einzeltitel, etwa ab 1986
          case '1': // mehrere Verlage, überwiegend von der Österreichischen Nationalbibliothek genutzt; als 3-01*-... auch von Kleinverlagen
          case '2': // nicht vergeben
          case '4': // nicht vergeben
          case '5', '6', '7', '8', '9':
            return rest.substring(0, 2);
          case '3':
            switch (rest.charAt(2))
             {
              case '0', '1', '2', '3': // Sammelnummer für Einzeltitel
                return rest.substring(0, 3);
              case '4', '5', '6': // 034* Schweizer Verlage
                return rest.substring(0, 4);
              case '7', '8', '9':
                return rest.substring(0, 5);
              default:
                throw new IllegalArgumentException("Publisher nr not 03(0-9)");
             }
          default:
            throw new IllegalArgumentException("Publisher nr not 0(0-9)");
         }
      case '1':
        return rest.substring(0, 2);
      case '2': // 200 Einzel-ISBN Bereich Österreich (Jede ISBN aus diesem Bereich ist einem anderen Verlag zugeordnet.)
      case '3', '4', '5', '6':
        return rest.substring(0, 3);
      case '7':
        return rest.substring(0, 4);
      case '8':
        switch (rest.charAt(1))
         {
          case '0', '1', '2', '3', '4':
            return rest.substring(0, 4);
          case '5', '6', '7', '8', '9':
            return rest.substring(0, 5);
          default:
            throw new IllegalArgumentException("Publisher nr not 8(0-9)");
         }
      case '9':
        switch (rest.charAt(1))
         {
          case '0', '1', '2', '3', '4':
            return rest.substring(0, 6);
          case '5':
            switch (rest.charAt(2))
             {
              case '0', '1', '2', '3':
                return rest.substring(0, 7);
              case '4', '5', '6', '7', '8', '9':
                return rest.substring(0, 5);
              default:
                throw new IllegalArgumentException("Publisher nr not 95(0-9)");
             }
          case '6':
            return rest.substring(0, 5);
          case '7', '8':
            return rest.substring(0, 7);
          case '9':
            return rest.substring(0, 5);
          default:
            throw new IllegalArgumentException("Publisher nr not 9(0-9)");
         }
      default:
        throw new IllegalArgumentException("Publisher nr not 0-9");
     }
   }

 }
