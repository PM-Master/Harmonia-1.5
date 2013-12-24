REM ----------- server preInstallation script (for server, admin tool)
REM ----------- Update 4 .ldf files to replace DOMAIN


fart PMServerConfiguration.pm [CLIENT_COMPUTER_NAME] %computername%
fart PMServerConfiguration.pm [SERVER_COMPUTER_NAME] %computername%

set PM_ROOT "C:\PM"
set SERVER_KEYSTORE serverKeystore
set SERVER_TRUSTSTORE serverTruststore

ldifde -i -f %PM_ROOT%\doc\ADSchema\PMNames.ldf
ldifde -i -f %PM_ROOT%\doc\ADSchema\PMAttributes.ldf
ldifde -i -f %PM_ROOT%\doc\ADSchema\PMClasses.ldf
ldifde –i –f %PM_ROOT%\doc\ADSchema\PMContainers.ldf


* run installer - install files on server - PM directory with necessary files


REM ------------- Client preInstallation script (for simulator, sesmgr)


fart PMClientConfiguration.pm [CLIENT_COMPUTER_NAME] %computername%

set CLIENT_KEYSTORE %computername%||Keystore
set CLIENT_KEYSTORE_PASSWORD aaaaaa
set CLIENT_TRUSTSTORE %computername%||Truststore

* run installer - install files on server - PM directory with necessary files

REM ---------------- start PMEngine servers

%PM_ROOT%\bin\server
%PM_ROOT%\bin\super



REM ---------------- start PMEngine servers

%PM_ROOT%\bin\simulator
%PM_ROOT%\bin\sesmgr
