@echo off
rem Generate Java class source from tld text file.
rem
rem $0 script
rem $1 Path to downloaded file
setlocal ENABLEDELAYEDEXPANSION
pushd %~dp0
echo /*
echo  * Code generator Copyright (C) 2022-2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
echo  */
echo package de.powerstat.validation.generated;
echo:
echo:
echo import java.util.Map;
echo import java.util.Locale;
echo import java.util.concurrent.ConcurrentHashMap;
echo:
echo import de.powerstat.validation.values.Country;
echo:
echo:
echo /**
echo  * International phone area codes.
echo  */
echo public final class GeneratedInternationalPhoneAreaCodes
echo  {
echo   /**
echo    * Phone area codes map.
echo    */
echo   private static final Map^<String, Country^> PHONEAREAS = new ConcurrentHashMap^<^>();
echo:
echo:
echo   /**
echo    * Static initialization.
echo    */
echo   static
echo    {
FOR /F "usebackq tokens=2,7,9,10 delims=," %%i IN (`findstr /R "^[A-Z]*,[0-9][0-9-]*,[A-Z][A-Z][A-Z],[a-z]*,[a-zA-Z ]*,[0-9]*,[0-9]*,[A-Z]*,[A-Z]*,[A-Z][A-Z]," %1`) DO (
  set t=%%i
  if "!t!"=="!t:-=!" (
    if 1%%i equ +1%%i (
      echo %%l > %TMP%\country.txt
      for %%a in (%TMP%\country.txt) do set /a len=%%~za
      if !len! EQU 5 (
        echo     PHONEAREAS.put("%%i", Country.of^("%%l"^)^); //$NON-NLS-1$
      ) else (
        if !len! EQU 6 (
          echo     PHONEAREAS.put("%%i", Country.of^("%%k"^)^); //$NON-NLS-1$
        ) else (
          echo     PHONEAREAS.put("%%i", Country.of^("%%j"^)^); //$NON-NLS-1$
        )
      )
    )
  ) else (
    if '!t!'=='!t:^"=!' (
      echo %%l > %TMP%\country.txt
      for %%a in (%TMP%\country.txt) do set /a len=%%~za
      if !len! EQU 5 (
        echo     PHONEAREAS.put("%%i", Country.of^("%%l"^)^); //$NON-NLS-1$
      ) else (
        echo     PHONEAREAS.put("%%i", Country.of^("%%k"^)^); //$NON-NLS-1$
      )
    )
  )
)
del /f %TMP%\country.txt
echo    }
echo:
echo:
echo   /**
echo    * Private default constructor.
echo    */
echo   private GeneratedInternationalPhoneAreaCodes()
echo    {
echo     super();
echo    }
echo:
echo:
echo   /**
echo    * Check if phone area code exists.
echo    *
echo    * @param phoneArea Phone area code to check
echo    * @return true if phone area code exists, false otherwise
echo    */
echo   public static boolean contains(final String phoneArea)
echo    {
echo     return PHONEAREAS.containsKey(phoneArea.toUpperCase(Locale.getDefault()));
echo    }
echo:
echo:
echo   /**
echo    * Get country for phone area code.
echo    *
echo    * @param phoneArea Phone area code
echo    * @return Country
echo    */
echo   public static Country getCountry(final String phoneArea)
echo    {
echo     return PHONEAREAS.get(phoneArea.toUpperCase(Locale.getDefault()));
echo    }
echo:
echo:
echo   /**
echo    * Get phone area code for country.
echo    *
echo    * @param country Country
echo    * @return Phone area code or empty string
echo    */
echo   public static String getForCountry(final Country country)
echo    {
echo     for (Map.Entry^<String, Country^> entry : PHONEAREAS.entrySet())
echo      {
echo       if (country.equals(entry.getValue()))
echo        {
echo         return entry.getKey();
echo        }
echo      }
echo     return "";
echo    }
echo:
echo }
popd
endlocal
