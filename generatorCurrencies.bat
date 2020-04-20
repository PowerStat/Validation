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
echo public final class GeneratedISO4217
echo  {
echo   private static final List^<String^> CODES = new ArrayList^<^>();
echo:
echo:
echo   static
echo    {
FOR /F "usebackq tokens=3,4 delims=," %%i IN (`findstr /R ",[A-Z][A-Z][A-Z]," %1`) DO (
  set t=%%i
  if "!t!"=="!t: =!" (
    echo     CODES.add("%%i".toLowerCase(Locale.getDefault(^)^)^);
  ) else (
    echo     CODES.add("%%j".toLowerCase(Locale.getDefault(^)^)^);
  )
)
echo    }
echo:
echo:
echo   private GeneratedISO4217()
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
