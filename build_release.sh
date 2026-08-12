#!/usr/bin/env bash
set -e
./gradlew :app:assembleRelease
echo "APK: app/build/outputs/apk/release/app-release-unsigned.apk"
