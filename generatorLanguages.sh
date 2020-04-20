#!/bin/bash
# $0 Script
# $1 Path to downloaded file
# cd "$(dirname "$(readlink -f "${BASH_SOURCE[0]}")")"
echo "package de.powerstat.validation.generated;"
echo ""
echo ""
echo "import java.util.ArrayList;"
echo "import java.util.List;"
echo "import java.util.Locale;"
echo ""
echo ""
echo "public final class GeneratedISO6391"
echo " {"
echo "  private static final List<String> CODES = new ArrayList<>();"
echo ""
echo ""
echo "  static"
echo "   {"
for i in `grep -oE "^[a-z]{2}" $1`; do
  echo "    CODES.add(\"$i\".toUpperCase(Locale.getDefault()));"
done
echo "   }"
echo ""
echo ""
echo "  private GeneratedISO6391()"
echo "   {"
echo "    super();"
echo "   }"
echo ""
echo ""
echo "  public static boolean contains(String code)"
echo "   {"
echo "    return CODES.contains(code.toUpperCase(Locale.getDefault()));"
echo "   }"
echo ""
echo ""
echo "}"
