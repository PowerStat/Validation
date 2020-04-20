@echo off
rem Generate Java class source from tld text file.
rem
rem $0 script
rem $1 Path to downloaded file
setlocal ENABLEDELAYEDEXPANSION
pushd %~dp0
echo package de.powerstat.validation.generated;
echo:
echo:
echo import java.util.ArrayList;
echo import java.util.List;
echo import java.util.Locale;
echo:
echo:
echo public final class GeneratedISO6391
echo  {
echo   private static final List^<String^> CODES = new ArrayList^<^>();
echo:
echo:
echo   static
echo    {
FOR /F "usebackq tokens=1 delims=," %%i IN (`findstr /R "^[a-z][a-z]," %1`) DO (
  echo     CODES.add("%%i".toLowerCase(Locale.getDefault(^)^)^);
)
echo    }
echo:
echo:
echo   private GeneratedISO6391()
echo    {
echo     super();
echo    }
echo:
echo:
echo   public static boolean contains(String code)
echo    {
echo     return CODES.contains(code.toLowerCase(Locale.getDefault()));
echo    }
echo:
echo:
echo }
popd
endlocal
