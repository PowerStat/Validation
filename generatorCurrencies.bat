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
echo  * ISO 4217.
echo  */
echo public final class GeneratedISO4217
echo  {
echo   /**
echo    * ISO 4217 code list.
echo    */
echo   private static final List^<String^> CODES = new ArrayList^<^>();
echo:
echo:
echo   /**
echo    * Static initialization.
echo    */
echo   static
echo    {
FOR /F "usebackq tokens=3,4 delims=," %%i IN (`findstr /R ",[A-Z][A-Z][A-Z]," %1`) DO (
  set t=%%i
  if "!t!"=="!t: =!" (
    echo     CODES.add("%%i".toLowerCase(Locale.getDefault(^)^)^); //$NON-NLS-1$
  ) else (
    echo     CODES.add("%%j".toLowerCase(Locale.getDefault(^)^)^); //$NON-NLS-1$
  )
)
echo    }
echo:
echo:
echo   /**
echo    * Private default constructor.
echo    */
echo   private GeneratedISO4217()
echo    {
echo     super();
echo    }
echo:
echo:
echo   /**
echo    * Check if ISO 4217 code exists.
echo    *
echo    * @param code Code to check
echo    * @return true if code exists, false otherwise
echo    */
echo   public static boolean contains(final String code)
echo    {
echo     return CODES.contains(code.toLowerCase(Locale.getDefault()));
echo    }
echo:
echo }
popd
endlocal
