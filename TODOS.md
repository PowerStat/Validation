Entity: MeterReader
ID, Hersteller/Company name, Bezeichnung/Description, Installationsort/place of installation, History meter reader (Datum, Zählerstand, [Foto})


Meter type: Stromzähler/electric meter, Gaszähler/gas meter, Wasserzähler/water meter, Wärmezähler/heat meter, ...
unit of measurement: mwh, kwh, m3, ... 
Zählwerk: 5-6, Nachkomma: 0,1,3
id: 8, 10, uuid  
https://en.wikipedia.org/wiki/EAN-8
https://de.wikipedia.org/wiki/European_Article_Number


- [ ] Month (enum) names (language dependend)
- [ ] Timezone
- [ ] Date
- [ ] Format
- [ ] Holidays
- [ ] DateDuration, TimeDuration, DateTimeDuration
- [ ] DateRange, TimeRange, DateTimeRange
- [ ] Recurring Date / Time
- [ ] Time
- [ ] DateTime
- [ ] UnixEpoche


Geburtsdatum (Tag Monat Jahr)
Datum, Unterschrift
Familienstand: Verheiratet, Verpartnert, geschieden, verwitwert, ledig
  https://de.wikipedia.org/wiki/Familienstand
Staatsangehörigkeit(en)? = Country?
  https://de.wikipedia.org/wiki/Staatsb%C3%BCrgerschaft
Telefonnummer/Fax
  Internationale Vorwahlen: https://de.wikipedia.org/wiki/L%C3%A4ndervorwahlliste_sortiert_nach_Nummern
  Ortsvorwahl(de) https://de.wikipedia.org/wiki/Telefonvorwahl_(Deutschland)
  Rufnummer https://de.wikipedia.org/wiki/Rufnummer
Krankenkasse: Name, Verischertennr
  https://de.wikipedia.org/wiki/Liste_deutscher_Krankenkassen
Personalausweisnummer(n)
  https://de.wikipedia.org/wiki/Personalausweis
  https://de.wikipedia.org/wiki/Personalausweis_(Deutschland)
Reisepassausweisnr
  https://de.wikipedia.org/wiki/Reisepass
  https://de.wikipedia.org/wiki/Deutscher_Reisepass
Sozialversicherungsnummer
  https://de.wikipedia.org/wiki/Sozialversicherung
  https://de.wikipedia.org/wiki/Sozialversicherung_(Deutschland)
Steueridentifikationsnummer
  https://de.wikipedia.org/wiki/Steuerliche_Identifikationsnummer
Steuernummer
  https://de.wikipedia.org/wiki/Steuernummer
Bundesländer (de)
  https://de.wikipedia.org/wiki/Land_(Deutschland)
Europäische Union
  https://de.wikipedia.org/wiki/Europ%C3%A4ische_Union
Umsatzsteueridentifikationsnr
  https://de.wikipedia.org/wiki/Umsatzsteuer-Identifikationsnummer
Aktezeichen
  https://de.wikipedia.org/wiki/Aktenzeichen_(Deutschland)
Flurstückskennzeichen (Gemarkung / Flur / Flurstück)
  https://de.wikipedia.org/wiki/Gemarkung
  https://de.wikipedia.org/wiki/Flur_(Gel%C3%A4nde)
  https://de.wikipedia.org/wiki/Flurst%C3%BCck
Grundbuch: Grundbuchbezirk, Blatt, Laufendrnr
  https://de.wikipedia.org/wiki/Kataster
  https://de.wikipedia.org/wiki/Katasterbezirk
Firmenname/arten
  https://de.wikipedia.org/wiki/Firma
Wohnungsnummer
  https://de.wikipedia.org/wiki/Wohnungsnummer
Kundennummer
Vertragsnummer
Foto(s)


# TODOS

VCARD:
- Categories
- KEY
- KIND
- Preference 1-..
- Nickname
- Note
- Organisation
- Related
- Job Role
- Job Title
- Sound
- Photo
- LOGO
- URL: IMPP, Sound, Photo, Logo, Phone, Web
- Phone
- Time zone
- UUID


https://datahub.io/collections/reference-data#currency-codes

- [ ] SSID
     1. Dürfen nicht mit einem Leerzeichen beginnen und/oder enden
     2. können max. 32 Zeichen lang sein
     3. darf nicht leer sein
     4. Erlaubte Zeichen sind: 
   Leerzeichen, a-z A-Z 0-9 ! " # $ % & ' ( ) * + , - . / : ; < = > ? @ [ \ ] ^ _ ` { | } ~

- [ ] Country names, Language names

- [ ] PhoneNumber Area Codes   https://datahub.io/core/country-codes/r/country-codes.csv
      https://en.wikipedia.org/wiki/National_conventions_for_writing_telephone_numbers
- [ ] PostCodes https://de.wikipedia.org/wiki/Liste_der_Postleitsysteme
- [ ] Salutations   Frau, Herrn, Frau und Herrn, Firma, "empty", Berufsbezeichnung, Akademischer Titel
- [ ] Organisations / Companies, types of (legal forms)

- [ ] NationalityPlates
      https://en.wikipedia.org/wiki/International_vehicle_registration_code
- [ ] MimeTypes
- [ ] UN/LOCODE
- [ ] Amtlicher Gemeindeschlüssel
- [ ] World Port Index
- [ ] NUTS
- [ ] IATA Flughafen Codes
      https://datahub.io/core/airport-codes/r/airport-codes.csv
- [ ] UN-Nummern

- [ ] Colors
- [ ] FileType
- [ ] ImageType

- [ ] ISBN-10, ISBN-13
      https://de.wikipedia.org/wiki/Internationale_Standardbuchnummer
- [ ] ISSN
      https://de.wikipedia.org/wiki/Internationale_Standardnummer_f%C3%BCr_fortlaufende_Sammelwerke
- [ ] ISAN, ISMN, ISRC, ISRN, ISWC
- [ ] VD16, VD17
- [ ] DOI
- [ ] EAN8, EAN13 
      https://de.wikipedia.org/wiki/European_Article_Number

- [ ] CountryUnions
- [ ] URI (encoding, decoding, exists)
- [ ] CommunicationTypes
- [ ] Locations
- [ ] Continents   https://datahub.io/core/continent-codes/r/continent-codes.csv
- [ ] Planets
- [ ] Moons
- [ ] SolarSystems
- [ ] Galaxies
- [ ] Universes
- [ ] TaxNumber
- [ ] SocialSecurityNumber
- [ ] TypeOfCompany / Organisation
- [ ] JobTitle
- [ ] RelationshipTypes
- [ ] CivilStatus
- [ ] AcademicDegrees
- [ ] EconomicSectors
- [ ] ReligiousCommunities
- [ ] Flags
- [ ] GTIN
- [ ] Barcodes
- [ ] QRCodes
- [ ] GPCProductClassifications

- [ ] Promille
- [ ] NumberRange
- [ ] Text
- [ ] RegExp  
- [ ] VersionNumber

- [ ] Signature
- [ ] FaceId
- [ ] FingerId
- [ ] EyeId
- [ ] Eye colors
- [ ] Body height
- [ ] Blood group
- [ ] Characteristics
- [ ] identification card(s)
- [ ] passport
- [ ] vaccination card
- [ ] drivers license
- [ ] payment types

- [ ] Words: NOUNS, PRONOUNS, VERBS, ADJECTIVES, ADVERBS, PREPOSITIONS, CONJUNCTIONS, INTERJECTIONS
      https://en.wikipedia.org/wiki/English_grammar
- [ ] Grammars    https://mein-deutschbuch.de/grammatik.html
- [ ] Acronyms
- [ ] Synonyms

- [ ] Knowledges
- [ ] Interests
- [ ] Things: Items, Products
- [ ] Lifeforms: Persons, Animals, Plant, Virus, Bacterium
- [ ] Roles
- [ ] Functions
- [ ] Requirements


- [ ] SI base units
      Mass                        M  kilogram  kg
      Length                      L  metre     m
      Temperature                    kelvin    K
      Time                        T  second    s
      Amount of substance         N  mole      mol
      Electric current intensity  I  ampere    A
      Luminous intensity          J  candela   cd
      
      
     Supplementary SI units
     
     Plane angle  radiant     rad
     Solid angle  steradiant  sr
     
     Energy    Radiant intensity
     Visible   Luminous intensity
     Particle  Photon intensity
     
     
     SI derived Units
     
     becquerel
     coulomb
     farad
     gray
     henry
     hertz
     joule
     lumen
     lux
     newton
     ohm
     pascal
     poiseuille
     siemens
     sievert
     tesla
     volt
     watt
     weber
     
     
     non-SI units
     
     ampere-hour
     day
     degree
     diotre
     hour
     kilowatt-hour
     litre
     minute
     minute of angle
     second of angle
     tex
     tonne
     
     
     SI Prefixes
     
     deca  da  10
     hecto h   10^2
     kilo  k   10^3
     mega  M   10^6
     giga  G   10^9
     tera  T   10^12
     peta  P   10^15
     exa   E   10^18
     zetta Z   10^21
     yotta Y   10^24
     
     
     Kilobyte  KB 2^10 = 1024 bytes
     Megabyte  MB 2^20 
     Gigabyte  GB 2^30
     Terrabyte TB 2^40 ?
     Petabyte  PB 2^50 ?
     Exabyte   EB 2^60 ?
 



# Sources

- http://datenbank-osteuropa.imoe.de/kategorien-orange-pages.html?&no_cache=1&user_katalog_pi1[new_wid]=250

- https://datahub.io/collections/reference-data
