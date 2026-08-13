package com.ghadam.app

import androidx.activity.ComponentActivity
import android.os.Bundle
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.health.connect.client.HealthConnectClient
import androidx.health.connect.client.permission.HealthPermission
import androidx.health.connect.client.records.StepsRecord
import androidx.health.connect.client.request.AggregateRequest
import androidx.health.connect.client.time.TimeRangeFilter
import androidx.lifecycle.lifecycleScope
import androidx.work.*
import java.time.*
import java.util.concurrent.TimeUnit
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private lateinit var health: HealthConnectClient
    private val permissionLauncher = registerForActivityResult(
        androidx.health.connect.client.PermissionController.createRequestPermissionResultContract()
    ) { granted ->
        if (granted.contains(HealthPermission.getReadPermission(StepsRecord::class))) readToday()
    }

    override fun onCreate(state: Bundle?) {
        super.onCreate(state)
        setContentView(R.layout.activity_main)
        health = HealthConnectClient.getOrCreate(this)

        findViewById<Button>(R.id.otp).setOnClickListener {
            Toast.makeText(this, "اتصال OTP در ApiClient.kt آماده است؛ URL سرور را تنظیم کنید.", Toast.LENGTH_LONG).show()
        }
        findViewById<Button>(R.id.sync).setOnClickListener { requestHealthPermission() }
        scheduleSync()
    }

    private fun requestHealthPermission() {
        val p = setOf(HealthPermission.getReadPermission(StepsRecord::class))
        lifecycleScope.launch {
            val granted = health.permissionController.getGrantedPermissions()
            if (granted.containsAll(p)) readToday() else permissionLauncher.launch(p)
        }
    }

    private fun readToday() {
        lifecycleScope.launch {
            try {
                val now = Instant.now()
                val start = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()
                val r = health.aggregate(
                    AggregateRequest(setOf(StepsRecord.COUNT_TOTAL), TimeRangeFilter.between(start, now))
                )
                val steps = r[StepsRecord.COUNT_TOTAL] ?: 0L
                findViewById<TextView>(R.id.steps).text = "$steps قدم"
            } catch (_: Exception) {
                Toast.makeText(this@MainActivity, "خواندن قدم‌ها ناموفق بود.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun scheduleSync() {
        val request = PeriodicWorkRequestBuilder
