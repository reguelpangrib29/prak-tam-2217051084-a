package com.example.campusevoapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.campusevoapp.utils.NotificationHelper

class EventsActivity : AppCompatActivity() {

    private val REQUEST_NOTIFICATION_PERMISSION = 1
    private lateinit var etSearchEvent: EditText
    private lateinit var rvEventList: RecyclerView
    private lateinit var btnFilterEvents: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_events)

        etSearchEvent = findViewById(R.id.etSearchEvent)
        rvEventList = findViewById(R.id.rvEventList)
        btnFilterEvents = findViewById(R.id.btnFilterEvents)

        rvEventList.layoutManager = LinearLayoutManager(this)
        rvEventList.adapter = EventAdapter(getEventList())

        btnFilterEvents.setOnClickListener {
            // Filter functionality here
        }

        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            navigateToDashboard()
        }

        // Request notification permission on Android 13 and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.POST_NOTIFICATIONS), REQUEST_NOTIFICATION_PERMISSION)
            }
        }
    }

    private fun navigateToDashboard() {
        finish()
    }

    private fun getEventList(): List<Event> {
        // Tambahkan lebih banyak event untuk menguji scrolling
        return listOf(
            Event("Event 1", "Monday, 20 June 2023", R.drawable.sample_image_1, "Description of event 1."),
            Event("Event 2", "Tuesday, 21 June 2023", R.drawable.sample_image_2, "Description of event 2."),
            Event("Event 3", "Wednesday, 22 June 2023", R.drawable.sampel_image_3, "Description of event 3."),
            Event("Event 4", "Thursday, 23 June 2023", R.drawable.sample_image_1, "Description of event 4."),
            Event("Event 5", "Friday, 24 June 2023", R.drawable.sample_image_2, "Description of event 5."),
            Event("Event 6", "Saturday, 25 June 2023", R.drawable.sampel_image_3, "Description of event 6."),
            Event("Event 7", "Sunday, 26 June 2023", R.drawable.sample_image_1, "Description of event 7."),
            Event("Event 8", "Monday, 27 June 2023", R.drawable.sample_image_2, "Description of event 8."),
            Event("Event 9", "Tuesday, 28 June 2023", R.drawable.sampel_image_3, "Description of event 9."),
            Event("Event 10", "Wednesday, 29 June 2023", R.drawable.sample_image_1, "Description of event 10."),
            Event("Event 11", "Thursday, 30 June 2023", R.drawable.sample_image_2, "Description of event 11."),
            Event("Event 12", "Friday, 1 July 2023", R.drawable.sampel_image_3, "Description of event 12.")
        )
    }

    private fun sendNotification() {
        NotificationHelper.sendNotification(
            this,
            "Event Reminder",
            "Don't forget to attend the event!"
        )
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_NOTIFICATION_PERMISSION) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission granted, you can show notifications now
            } else {
                // Permission denied, show a message to the user
            }
        }
    }
}
