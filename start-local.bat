@echo off
echo ====================================
echo  Real-Time Chat Application Starter
echo ====================================
echo.

echo [1/3] Building application...
mvn clean package -DskipTests

if %ERRORLEVEL% NEQ 0 (
    echo.
    echo ERROR: Build failed! Please check the error messages above.
    echo Make sure you have Java 17+ and Maven installed.
    pause
    exit /b 1
)

echo.
echo [2/3] Build successful!
echo [3/3] Starting application...
echo.
echo Application will be available at: http://localhost:8080
echo Frontend will be available at: http://localhost:8080
echo.
echo Press Ctrl+C to stop the application
echo ====================================
echo.

java -jar target/Real-Time-Chat-Application-with-WebSockets-0.0.1-SNAPSHOT.jar

echo.
echo Application stopped.
pause 