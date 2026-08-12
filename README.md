# Ghadam Android Studio Project

این فایل، نسخه Android Studio پروژه «قدم» است.

## Build
1. Android Studio جدید را باز کنید.
2. گزینه **Open** را بزنید و همین پوشه را انتخاب کنید.
3. اجازه دهید Gradle Sync انجام شود.
4. یک دستگاه Android 8+ یا emulator انتخاب کنید.
5. Run را بزنید.

## اتصال به backend
اپ باید به API پروژه `Ghadam_Final` متصل شود. در production:
- API را روی یک domain با HTTPS اجرا کنید.
- Base URL را به `ApiContract`/network layer اضافه کنید.
- OTP provider واقعی را روی server تنظیم کنید.
- Payment Provider واقعی فقط روی server باشد.

## Health Connect
اپ مجوز READ_STEPS می‌خواهد. در Android 14+ Health Connect در سیستم است؛ در نسخه‌های قدیمی‌تر ممکن است نیاز به نصب Health Connect باشد.

## وضعیت این خروجی
پروژه Android Studio، manifest، Gradle، UI، Health Connect و قرارداد API را در یک پروژه واحد جمع می‌کند. Backend همچنان جداگانه روی server اجرا می‌شود؛ دیتابیس و کلیدهای پرداخت داخل APK قرار نمی‌گیرند.


## GitHub Actions
این پروژه شامل `.github/workflows/build-apk.yml` است و می‌تواند APK Release را در GitHub Actions بسازد.
