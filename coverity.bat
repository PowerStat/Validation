@echo off
setlocal ENABLEDELAYEDEXPANSION

set covbin=D:\Programme\cov-analysis-win64-2022.6.0\bin

rem wget https://scan.coverity.com/download/java/win64 --post-data "token=y02AK7p2pBIVfYkPXHQT-w&project=Validation" -O coverity_tool.zip
rem %covbin%\cov-configure --java
%covbin%\cov-build --dir cov-int mvn clean compile
rem curl --form token=y02AK7p2pBIVfYkPXHQT-w --form email=powerstat@web.de --form file=@cov-int.zip --form version="Version" --form description="Description" https://scan.coverity.com/builds?project=Validation

endlocal
exit /b 0
