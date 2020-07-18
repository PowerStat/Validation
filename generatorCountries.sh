#!/bin/bash
# $0 Script
# $1 Path to downloaded file
# cd "$(dirname "$(readlink -f "${BASH_SOURCE[0]}")")"
echo "/*"
echo " * Code generator Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!"
echo " */"
echo "package de.powerstat.validation.generated;"
echo ""
echo ""
echo "import java.util.Map;"
echo "import java.util.Locale;"
echo "import java.util.concurrent.ConcurrentHashMap;"
echo ""
echo ""
echo "/**"
echo " * ISO 3166 Alpha 2."
echo " */"
echo "public final class GeneratedISO3166A2"
echo " {"
echo "  /**"
echo "   * Alpha 2 codes map."
echo "   */"
echo "  private static final Map<String, String> ALPHA2 = new ConcurrentHashMap<>();"
echo ""
echo ""
echo "  /**"
echo "   * Static initialization."
echo "   */"
echo "  static"
echo "   {"
for i in `grep -oE "[A-Z]{2}" $1`; do
  echo "    ALPHA2.put(\"$i\".toUpperCase(Locale.getDefault()), \"\"); //\$NON-NLS-1\$"
done
echo "   }"
echo ""
echo ""
echo "  /**"
echo "   * Private default constructor."
echo "   */"
echo "  private GeneratedISO3166A2()"
echo "   {"
echo "    super();"
echo "   }"
echo ""
echo ""
echo "  /**"
echo "   * Check if alpha2 code exists."
echo "   *"
echo "   * @param alpha2 Alpha 2 code to check"
echo "   * @return true if alpha2 code exists, false otherwise"
echo "   */"
echo "  public static boolean contains(final String alpha2)"
echo "   {"
echo "    return ALPHA2.containsKey(alpha2.toUpperCase(Locale.getDefault()));"
echo "   }"
echo ""
echo ""
echo "  /**"
echo "   * Get english country name for Alpha 2 code."
echo "   *"
echo "   * @param alpha2 Alpha 2 code"
echo "   * @return Country name in english"
echo "   */"
echo "  public static String getName(final String alpha2)"
echo "   {"
echo "    return ALPHA2.get(alpha2.toUpperCase(Locale.getDefault()));"
echo "   }"
echo ""
echo ""
echo "}"
