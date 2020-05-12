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
echo  * Top level domains.
echo  */
echo public final class GeneratedTlds
echo  {
echo   /**
echo    * Top level domain list.
echo    */
echo   private static final List^<String^> TOP_LEVEL_DOMAINS = new ArrayList^<^>();
echo:
echo:
echo   /**
echo    * Static initialization.
echo    */
echo   static
echo    {
FOR /F "usebackq" %%i IN (`findstr /v # %1`) DO (
  echo     TOP_LEVEL_DOMAINS.add("%%i".toLowerCase(Locale.getDefault(^)^)^); //$NON-NLS-1$
)
echo    }
echo:
echo:
echo   /**
echo    * Private default constructor.
echo    */
echo   private GeneratedTlds()
echo    {
echo     super();
echo    }
echo:
echo:
echo   /**
echo    * Check if top level domain exists.
echo    *
echo    * @param tld Top level domain to check
echo    * @return true if top level domain exists, false otherwise
echo    */
echo   public static boolean contains(final String tld)
echo    {
echo     return TOP_LEVEL_DOMAINS.contains(tld.toLowerCase(Locale.getDefault()));
echo    }
echo:
echo:
echo }
popd
endlocal
