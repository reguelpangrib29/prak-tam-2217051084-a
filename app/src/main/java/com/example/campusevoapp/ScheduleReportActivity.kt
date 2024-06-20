package com.example.campusevoapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.campusevoapp.utils.NotificationHelper
import java.util.*

class ScheduleReportActivity : AppCompatActivity() {

    private lateinit var etDescription: EditText
    private lateinit var etLocation: EditText
    private lateinit var btnPickDate: Button
    private lateinit var btnPickTime: Button
    private lateinit var spinnerFrequency: Spinner
    private lateinit var btnSubmit: Button
    private lateinit var btnEdit: Button
    private lateinit var btnCancel: Button

    private lateinit var calendar: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule_report)

        etDescription = findViewById(R.id.etDescription)
        etLocation = findViewById(R.id.etLocation)
        btnPickDate = findViewById(R.id.btnPickDate)
        btnPickTime = findViewById(R.id.btnPickTime)
        spinnerFrequency = findViewById(R.id.spinnerFrequency)
        btnSubmit = findViewById(R.id.btnSubmit)
        btnEdit = findViewById(R.id.btnEdit)
        btnCancel = findViewById(R.id.btnCancel)

        calendar = Calendar.getInstance()

        btnPickDate.setOnClickListener { pickDate() }
        btnPickTime.setOnClickListener { pickTime() }
        btnSubmit.setOnClickListener { submitSchedule() }
        btnEdit.setOnClickListener { editSchedule() }
        btnCancel.setOnClickListener { cancelSchedule() }

        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            navigateToDashboard(it)
        }
    }

    private fun pickDate() {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            calendar.set(selectedYear, selectedMonth, selectedDay)
            btnPickDate.text = "$selectedDay/${selectedMonth + 1}/$selectedYear"
        }, year, month, day)

        datePickerDialog.show()
    }

    private fun pickTime() {
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(this, { _, selectedHour, selectedMinute ->
            calendar.set(Calendar.HOUR_OF_DAY, selectedHour)
            calendar.set(Calendar.MINUTE, selectedMinute)
            btnPickTime.text = "$selectedHour:$selectedMinute"
        }, hour, minute, true)

        timePickerDialog.show()
    }

    private fun submitSchedule() {
        // Simulate submitting schedule report
        val description = etDescription.text.toString()
        val location = etLocation.text.toString()
        val date = btnPickDate.text.toString()
        val time = btnPickTime.text.toString()
        val frequency = spinnerFrequency.selectedItem.toString()

        // Logic to handle submission, e.g., save to database, send notifications, etc.
        NotificationHelper.sendNotification(
            this,
            "Laporan Sampah Dijadwalkan",
            "Laporan sampah untuk $location pada $date $time telah dijadwalkan"
        )
        Toast.makeText(this, "Laporan sampah berhasil dijadwalkan", Toast.LENGTH_SHORT).show()
    }

    private fun editSchedule() {
        // Logic to handle editing schedule report
        Toast.makeText(this, "Edit jadwal laporan sampah", Toast.LENGTH_SHORT).show()
    }

    private fun cancelSchedule() {
        // Logic to handle canceling schedule report
        Toast.makeText(this, "Jadwal laporan sampah dibatalkan", Toast.LENGTH_SHORT).show()
    }

    private fun navigateToDashboard(view: View) {
        finish()
    }
}
