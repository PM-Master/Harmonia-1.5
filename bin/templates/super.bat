REM  -----------------------------------------------------------
REM  PM Run Admin (same as old PmAdmin/super.bat)
REM  Steve Quirolgico
REM  06/07/08
REM  -----------------------------------------------------------


REM ------------------------------------------------------------
REM     MODIFY THE FOLLOWING PATHS FOR YOUR ENVIRONMENT!
REM ------------------------------------------------------------



set PM_VERSION=1.5

set PM_ROOT=C:\PM\pm%PM_VERSION%

set MY_KEYSTORE=superKeystore

set MY_TRUSTSTORE=clientTruststore

set ENGINE_HOST=%computername%

set ENGINE_PORT=8080

set JAVA_JRE=%JAVA_HOME%

TITLE Policy Machine Admin Tool


REM ------------------------------------------------------------
REM       DO NOT MODIFY ANYTHING BELOW THIS LINE!
REM ------------------------------------------------------------



set KEYSTORES=%PM_ROOT%\keystores

set MY_KEYSTORE_PATH=%KEYSTORES%\%MY_KEYSTORE%

set MY_TRUSTSTORE_PATH=%KEYSTORES%\%MY_TRUSTSTORE%

set JAVA_BIN=%JAVA_JRE%\bin

set JAVA_LIB=%JAVA_JRE%\lib

set JAVA_JARS=%JAVA_LIB%\rt.jar;%JAVA_LIB%\jsse.jar

set PM_ADMIN_JAR=%PM_ROOT%\dist\pm-admin-%PM_VERSION%.jar

rem set CLASSPATH=%PM_ADMIN_JAR%;%JAVA_JARS%



set CLASSPATH=%PM_ADMIN_JAR%;%PM_ROOT%\dist\pm-commons-1.5.jar;%PM_ROOT%\lib\activation-1.1.jar;%PM_ROOT%\lib\aopalliance-1.0.jar;%PM_ROOT%\lib\asm-3.1.jar;%PM_ROOT%\lib\bcmail-jdk15-1.44.jar;%PM_ROOT%\lib\bcprov-jdk15-1.44.jar;%PM_ROOT%\lib\cglib-2.2.1-v20090111.jar;%PM_ROOT%\lib\colorchooser-1.0.jar;%PM_ROOT%\lib\commons-logging-1.1.1.jar;%PM_ROOT%\lib\fontbox-1.6.0.jar;%PM_ROOT%\lib\guava-r09.jar;%PM_ROOT%\lib\guice-3.0.jar;%PM_ROOT%\lib\icu4j-3.8.jar;%PM_ROOT%\lib\jarjar-1.0.jar;%PM_ROOT%\lib\javax.inject-1.jar;%PM_ROOT%\lib\javax.mail-1.4.4.jar;%PM_ROOT%\lib\jempbox-1.6.0.jar;%PM_ROOT%\lib\jfontchooser-1.0.5-pm.jar;%PM_ROOT%\lib\jna-3.2.7-pm-platform.jar;%PM_ROOT%\lib\jna-3.2.7-pm.jar;%PM_ROOT%\lib\jsr305-1.3.7.jar;%PM_ROOT%\lib\miglayout-3.7.3.1-swing.jar;%PM_ROOT%\lib\pdfbox-1.6.0.jar;%PM_ROOT%\lib\wrapper-3.2.3.jar;%PM_ROOT%\lib\wrapper.jar;%PM_ROOT%\lib\mysql-connector-java-5.1.31-bin.jar

set SERVER_MODE=y
set WAIT_FOR_DEBUGGER=n
set DEBUG_PORT=8004

set DEBUG_ARGS=-Xdebug -agentlib:jdwp=transport=dt_socket,suspend=%WAIT_FOR_DEBUGGER%,server=%SERVER_MODE%,address=%DEBUG_PORT%

echo Debug ARGS: %DEBUG_ARGS%
"%JAVA_BIN%\java" -cp "%CLASSPATH%" gov.nist.csd.pm.admin.PmAdmin -enginehost %ENGINE_HOST% -engineport %ENGINE_PORT% -debug
