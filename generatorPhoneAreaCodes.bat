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
echo:
echo /**
echo  * International phone area codes.
echo  */
echo public final class GeneratedInternationalPhoneAreaCodes
echo  {
echo   /**
echo    * Phone area codes map.
echo    */
echo   private static final Map^<String, String^> PHONEAREAS = new ConcurrentHashMap^<^>();
echo:
echo:
echo   /**
echo    * Static initialization.
echo    */
echo   static
echo    {
FOR /F "usebackq tokens=2 delims=," %%i IN (`findstr /R "^[A-Z][A-Z][A-Z],[0-9-]*," %1`) DO (
  set t=%%i
  if "!t!"=="!t: =!" (
    echo     PHONEAREAS.put("%%i", ""^); //$NON-NLS-1$
  ) else (
    echo     PHONEAREAS.put("%%i", ""^); //$NON-NLS-1$
  )
)
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
echo    * Get english country name for phone area code.
echo    *
echo    * @param phoneArea Phone area code
echo    * @return Country name in english
echo    */
echo   public static String getName(final String phoneArea)
echo    {
echo     return PHONEAREAS.get(phoneArea.toUpperCase(Locale.getDefault()));
echo    }
echo:
echo }
popd
endlocal
