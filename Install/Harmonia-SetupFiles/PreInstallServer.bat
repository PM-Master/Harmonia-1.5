REM ----------- server preInstallation script (for server, admin tool)
REM ----------- Update 4 .ldf files to replace DOMAIN

SET PM_ROOT=C:\PM
REM -- replace DOMAIN with domain --- fart %PM_ROOT%\doc\ADSchema\*.ldf [DOMAIN] %USERDNSDOMAIN%
fart %PM_ROOT%\conf\PMServerConfiguration.pm [CLIENT_COMPUTER_NAME] %computername%
fart %PM_ROOT%\conf\PMServerConfiguration.pm [SERVER_COMPUTER_NAME] %computername%

REM ldifde -i -f %PM_ROOT%\doc\ADSchema\PMAttributes.ldf
REM ldifde -i -f %PM_ROOT%\doc\ADSchema\PMClasses.ldf
REM ldifde –i –f %PM_ROOT%\doc\ADSchema\PMContainers.ldf
REM ldifde -i -f %PM_ROOT%\doc\ADSchema\PMNames.ldf

call %PM_ROOT%\bin\StartPMEngine.bat
