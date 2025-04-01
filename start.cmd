@echo off
setlocal enabledelayedexpansion

echo 🔨 Сборка всех модулей через Maven...
call build.cmd all

if %ERRORLEVEL% NEQ 0 (
    echo ❌ Ошибка при сборке. Остановлено.
    exit /b %ERRORLEVEL%
)

echo.
echo 🐳 Запуск docker-compose...
docker-compose up --build
