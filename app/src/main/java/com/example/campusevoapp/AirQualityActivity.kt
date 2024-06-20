package com.example.campusevoapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AirQualityActivity : AppCompatActivity() {

    private lateinit var tvAirQualityIndex: TextView
    private lateinit var tvAirQualityDescription: TextView
    private lateinit var ivCampusMap1: ImageView
    private lateinit var ivCampusMap2: ImageView
    private lateinit var ivCampusMap3: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_air_quality)

        tvAirQualityIndex = findViewById(R.id.tvAirQualityIndex)
        tvAirQualityDescription = findViewById(R.id.tvAirQualityDescription)
        ivCampusMap1 = findViewById(R.id.ivCampusMap1)
        ivCampusMap2 = findViewById(R.id.ivCampusMap2)
        ivCampusMap3 = findViewById(R.id.ivCampusMap3)

        // Simulate real-time air quality data fetching
        fetchAirQualityData()

        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            navigateToDashboard()
        }
    }

    private fun fetchAirQualityData() {
        // Simulasi data real-time (dalam implementasi nyata, ini akan mengambil data dari API)
        val airQualityIndex = 50 // Nilai AQI
        val airQualityStatus = "Baik" // Status AQI

        tvAirQualityIndex.text = "AQI: $airQualityIndex ($airQualityStatus)"
        tvAirQualityDescription.text = "Kualitas udara di wilayah kampus saat ini dalam kondisi baik."

        // Update the images (use different images if available)
        ivCampusMap1.setImageResource(R.drawable.campus_map_1)
        ivCampusMap2.setImageResource(R.drawable.campus_map_2)
        ivCampusMap3.setImageResource(R.drawable.campus_map_3)
    }

    private fun navigateToDashboard() {
        val intent = Intent(this, DashboardActivity::class.java)
        startActivity(intent)
        finish()
    }
}
