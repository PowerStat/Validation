@echo off
rem Generate Java class source from uri-schemes file.
rem
rem $0 script
rem $1 Path to downloaded file
setlocal ENABLEDELAYEDEXPANSION
pushd %~dp0
echo /*
echo  * Code generator Copyright (C) 2025 Dipl.-Inform. Kai Hofmann. All rights reserved!
echo  */
echo package de.powerstat.validation.generated;
echo:
echo:
echo import java.util.HashSet;
echo import java.util.Set;
echo import java.util.Locale;
echo:
echo:
echo /**
echo  * URI scheme names.
echo  */
echo public final class GeneratedURISchemeNames
echo  {
echo   /**
echo    * URI scheme names list.
echo    */
echo   private static final Set^<String^> URISCHEMES = new HashSet^<^>();
echo:
echo:
echo   /**
echo    * Static initialization.
echo    */
echo   static
echo    {
FOR /F "usebackq tokens=1 delims=," %%i IN (`findstr /R "^[a-z][a-z0-9+-]*," %1`) DO (
  echo     URISCHEMES.add("%%i"^); //$NON-NLS-1$
)

echo    }
echo:
echo:
echo   /**
echo    * Private default constructor.
echo    */
echo   private GeneratedURISchemeNames()
echo    {
echo     super();
echo    }
echo:
echo:
echo   /**
echo    * Check if uri scheme name exists.
echo    *
echo    * @param scheme URI scheme name
echo    * @return true if schem name exists, false otherwise
echo    */
echo   public static boolean contains(final String scheme)
echo    {
echo     return URISCHEMES.contains(scheme.toLowerCase(Locale.getDefault()));
echo    }
echo:
echo }
popd
endlocal
