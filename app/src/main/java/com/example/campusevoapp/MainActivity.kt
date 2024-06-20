package com.example.campusevoapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnAirQuality: Button
    private lateinit var btnScheduleReport: Button
    private lateinit var btnEvents: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAirQuality = findViewById(R.id.btnAirQuality)
        btnScheduleReport = findViewById(R.id.btnScheduleReport)
        btnEvents = findViewById(R.id.btnEvents)

        btnAirQuality.setOnClickListener {
            startActivity(Intent(this, AirQualityActivity::class.java))
        }

        btnScheduleReport.setOnClickListener {
            startActivity(Intent(this, ScheduleReportActivity::class.java))
        }

        btnEvents.setOnClickListener {
            startActivity(Intent(this, EventsActivity::class.java))
        }
    }
}
