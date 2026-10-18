@echo off
cd /d "%~dp0"
java -jar SecureCheck.jar
if errorlevel 1 (
 echo Nao foi possivel iniciar. Confira se o Java 17 ou superior esta instalado.
 pause
)
