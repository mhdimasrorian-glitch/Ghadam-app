# ساخت خودکار APK

1. یک Repository جدید در GitHub بساز.
2. محتویات این پروژه را در repository قرار بده.
3. Commit را روی `main` یا `master` بزن.
4. وارد **Actions** شو و Workflow با نام **Build Ghadam APK** را باز کن.
5. بعد از اتمام، از بخش **Artifacts** فایل `ghadam-release-apk` را دانلود کن.

برای اجرای دستی:
Actions → Build Ghadam APK → Run workflow

نکته: این workflow APK را unsigned می‌سازد. برای انتشار Google Play باید keystore شخصی خودت را به GitHub Secrets اضافه و signing را فعال کنی.
