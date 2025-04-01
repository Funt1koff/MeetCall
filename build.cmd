@echo off
setlocal enabledelayedexpansion

REM === Настраиваем список доступных модулей ===
set MODULES=config-service eureka-service user-service

REM === Если аргумент отсутствует — показать справку ===
if "%1"=="" (
    echo [INFO] 🔨 Использование:
    echo   build.cmd all                - собрать все модули
    echo   build.cmd user-service       - собрать один модуль
    echo.
    echo [INFO] Доступные модули: %MODULES%
    exit /b 0
)

REM === Сборка всех модулей ===
if /i "%1"=="all" (
    echo [INFO] 🚀 Сборка всех модулей...
    mvn clean install -DskipTests
    exit /b %ERRORLEVEL%
)

REM === Сборка выбранного модуля ===
set FOUND=false
for %%M in (%MODULES%) do (
    if /i "%1"=="%%M" (
        set FOUND=true
        echo [INFO] 🚀 Сборка модуля: %%M
        mvn clean install -pl %%M -am -DskipTests
        exit /b %ERRORLEVEL%
    )
)

if "%FOUND%"=="false" (
    echo [ERROR] ❌ Неизвестный модуль: %1
    echo [INFO] Доступные модули: %MODULES%
    exit /b 1
)
