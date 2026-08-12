# ساخت APK Release با یک کلیک

1. پروژه را در Android Studio باز کن و Gradle Sync را یک‌بار کامل کن.
2. بعد از آماده‌شدن Gradle Wrapper:
   - Windows: روی `build_release.bat` دوبار کلیک کن.
   - macOS/Linux: `./build_release.sh`
3. خروجی در این مسیر ساخته می‌شود:
   `app/build/outputs/apk/release/app-release-unsigned.apk`

## نکته
این خروجی **unsigned** است و برای انتشار Google Play مناسب نیست.
برای نصب تستی می‌توان آن را با ابزارهای مناسب امضا کرد، اما برای Release واقعی باید keystore متعلق به خودت ساخته و در Gradle/Android Studio تنظیم شود.

Backend، PostgreSQL و Payment Provider داخل APK نیستند و جداگانه روی سرور اجرا می‌شوند.
