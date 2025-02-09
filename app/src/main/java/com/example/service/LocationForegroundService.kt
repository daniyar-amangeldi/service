package com.example.service

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.content.pm.ServiceInfo.FOREGROUND_SERVICE_TYPE_LOCATION
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.ServiceCompat

class LocationForegroundService : Service() {

    companion object {
        private const val NOTIFICATION_ID = 1
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startLocationUpdates()
        ServiceCompat.startForeground(
            this,
            NOTIFICATION_ID,
            createNotification(),
            FOREGROUND_SERVICE_TYPE_LOCATION
        )
        return START_STICKY
    }

    private fun createNotification(): Notification {
        return NotificationCompat.Builder(this, "location_service_channel")
            .setContentTitle("Location Service Running")
            .setContentText("Tracking your location in real-time")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .build()
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onDestroy() {
        super.onDestroy()
        stopLocationUpdates()
    }

    private fun startLocationUpdates() {
        // Implement location tracking logic
    }

    private fun stopLocationUpdates() {
        // Stop location tracking
    }
}