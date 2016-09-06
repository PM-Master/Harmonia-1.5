REM ----------- server preInstallation script (for server, admin tool)
REM ----------- Update 4 .ldf files to replace DOMAIN
echo off
set PM_ROOT=C:\PM 
echo Domain: %userdnsdomain%

for /f "tokens=1,2,3,4,5 delims=. " %%a in ("%userdnsdomain%") do (
 set a=%%a
 set b=%%b
 set c=%%c
 set d=%%d
 set e=%%e
)
 echo %a%
 echo %b%
 echo %c%
 echo %d%
 echo %e%

 set dom=DC=%a%
 if [%b%] == [] goto out
 set dom=%dom%, DC=%b%
 if [%c%] == [] goto out
 set dom=%dom%, DC=%c%
 if [%d%] == [] goto out
 set dom=%dom%, DC=%d%
 if [%e%] == [] goto out
 set dom=%dom%, DC=%e%

:out
echo %dom%

set ldfFile1=C:\PM\doc\ADSchema\PMAttributes.ldf
set ldfFile2=C:\PM\doc\ADSchema\PMClasses.ldf
set ldfFile3=C:\PM\doc\ADSchema\PMContainers.ldf
set ldfFile4=C:\PM\doc\ADSchema\PMNames.ldf

stringUtil %ldfFile1% [DOMAIN] "%dom%"
stringUtil %ldfFile2% [DOMAIN] "%dom%"
stringUtil %ldfFile3% [DOMAIN] "%dom%"
stringUtil %ldfFile4% [DOMAIN] "%dom%"

ldifde -i -f C:\PM\doc\ADSchema\PMAttributes.ldf
ldifde -i -f C:\PM\doc\ADSchema\PMClasses.ldf
ldifde –i –f C:\PM\doc\ADSchema\PMContainers.ldf
ldifde -i -f C:\PM\doc\ADSchema\PMNames.ldf

REM -- replace DOMAIN with domain --- fart C:\PM\doc\ADSchema\*.ldf [DOMAIN] %USERDNSDOMAIN%
set InFile1=C:\PM\conf\PMServerConfiguration.pm
set InFile2=C:\PM\conf\PMClientConfiguration.pm

stringUtil %InFile1% [SERVER_COMPUTER_NAME] %computername%
stringUtil %InFile1% [CLIENT_COMPUTER_NAME] %computername%
stringUtil %InFile2% [CLIENT_COMPUTER_NAME] %computername%


