@echo off
rem Generate Java class source from tld text file.
rem
rem $0 script
rem $1 Path to downloaded file
setlocal ENABLEDELAYEDEXPANSION
pushd %~dp0
echo /*
echo  * Code generator Copyright (C) 2020 Dipl.-Inform. Kai Hofmann. All rights reserved!
echo  */
echo package de.powerstat.validation.generated;
echo:
echo:
echo import java.util.ArrayList;
echo import java.util.List;
echo import java.util.Locale;
echo:
echo:
echo /**
echo  * ISO 3166 Alpha 2.
echo  */
echo public final class GeneratedISO3166A2
echo  {
echo   /**
echo    * Alpha 2 codes list.
echo    */
echo   private static final List^<String^> ALPHA2 = new ArrayList^<^>();
echo:
echo:
echo   /**
echo    * Static initialization.
echo    */
echo   static
echo    {
FOR /F "usebackq tokens=2,3 delims=," %%i IN (`findstr /R ",[A-Z][A-Z]$" %1`) DO (
  set t=%%i
  if "!t!"=="!t: =!" (
    echo     ALPHA2.add("%%i".toLowerCase(Locale.getDefault(^)^)^); //$NON-NLS-1$
  ) else (
    echo     ALPHA2.add("%%j".toLowerCase(Locale.getDefault(^)^)^); //$NON-NLS-1$
  )
)
echo    }
echo:
echo:
echo   /**
echo    * Private default constructor.
echo    */
echo   private GeneratedISO3166A2()
echo    {
echo     super();
echo    }
echo:
echo:
echo   /**
echo    * Check if alpha2 code exists.
echo    *
echo    * @param alpha2 Alpha 2 code to check
echo    * @return true if alpha2 code exists, false otherwise
echo    */
echo   public static boolean contains(final String alpha2)
echo    {
echo     return ALPHA2.contains(alpha2.toLowerCase(Locale.getDefault()));
echo    }
echo:
echo }
popd
endlocal
