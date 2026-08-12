@echo off
setlocal
echo === Ghadam Release APK ===
if not exist gradlew.bat (
  echo ERROR: Gradle wrapper is missing.
  echo Open this project in Android Studio and run Gradle Sync first.
  pause
  exit /b 1
)
call gradlew.bat :app:assembleRelease
if errorlevel 1 (
  echo.
  echo BUILD FAILED.
  pause
  exit /b 1
)
echo.
echo APK created:
echo app\build\outputs\apk\release\app-release-unsigned.apk
pause
