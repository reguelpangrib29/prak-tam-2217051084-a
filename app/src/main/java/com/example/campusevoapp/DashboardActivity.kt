package com.example.campusevoapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.campusevoapp.utils.NotificationHelper

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
    }

    fun navigateToDashboard(view: View) {
        // Navigate to dashboard
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
    }

    fun navigateToAbout(view: View) {
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    fun navigateToAirQuality(view: View) {
        val intent = Intent(this, AirQualityActivity::class.java)
        startActivity(intent)
    }

    fun navigateToScheduleReport(view: View) {
        val intent = Intent(this, ScheduleReportActivity::class.java)
        startActivity(intent)
    }

    fun navigateToEvents(view: View) {
        val intent = Intent(this, EventsActivity::class.java)
        startActivity(intent)
    }

    fun logoutUser(view: View) {
        // Handle logout
        NotificationHelper.sendNotification(
            this,
            "Logout Successful",
            "You have successfully logged out."
        )

        // Navigate to login screen
        val intent = Intent(this, LoginActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
        finish()

        // Show a toast message
        Toast.makeText(this, "You have been logged out", Toast.LENGTH_SHORT).show()
    }
}
