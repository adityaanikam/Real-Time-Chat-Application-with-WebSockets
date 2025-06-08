@echo off
echo ====================================
echo  Docker Chat Application Starter
echo ====================================
echo.

echo Checking if Docker is running...
docker --version >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo ERROR: Docker is not running or not installed!
    echo Please start Docker Desktop and try again.
    pause
    exit /b 1
)

echo Docker is available!
echo.

echo [1/2] Building Docker image...
docker-compose build

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ERROR: Docker build failed!
    pause
    exit /b 1
)

echo.
echo [2/2] Starting application with Docker...
echo.
echo Application will be available at: http://localhost:8080
echo.
echo Press Ctrl+C to stop the application
echo ====================================
echo.

docker-compose up

echo.
echo Application stopped.
echo To completely remove containers and volumes, run: docker-compose down -v
pause 