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
echo public final class GeneratedTlds
echo  {
echo   private static final List^<String^> TOP_LEVEL_DOMAINS = new ArrayList^<^>();
echo:
echo:
echo   static
echo    {
FOR /F "usebackq" %%i IN (`findstr /v # %1`) DO (
  echo     TOP_LEVEL_DOMAINS.add("%%i".toLowerCase(Locale.getDefault(^)^)^);
)
echo    }
echo:
echo:
echo   private GeneratedTlds()
echo    {
echo     super();
echo    }
echo:
echo:
echo   public static boolean contains(String tld)
echo    {
echo     return TOP_LEVEL_DOMAINS.contains(tld.toLowerCase(Locale.getDefault()));
echo    }
echo:
echo:
echo }
popd
endlocal
