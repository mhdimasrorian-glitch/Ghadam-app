package com.ghadam.app

/**
 * قرارداد API نسخه نهایی.
 *
 * Base URL را در BuildConfig/سرور واقعی تنظیم کنید.
 * برای production فقط HTTPS استفاده شود.
 *
 * POST /auth/request-otp  { phone }
 * POST /auth/verify-otp   { phone, code, name? }
 * POST /auth/refresh       { sessionId, refreshToken }
 * POST /auth/logout
 * GET  /me
 * POST /profile/sheba     { sheba }
 * POST /steps/sync        { date, steps, source }
 * POST /withdrawals       { amountRial }
 */
object ApiContract {
    const val REQUEST_OTP = "/auth/request-otp"
    const val VERIFY_OTP = "/auth/verify-otp"
    const val REFRESH = "/auth/refresh"
    const val ME = "/me"
    const val STEPS_SYNC = "/steps/sync"
    const val WITHDRAWAL = "/withdrawals"
}
