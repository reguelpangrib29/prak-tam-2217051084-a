package com.example.campusevoapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GalleryActivity : AppCompatActivity() {

    private lateinit var rvGallery: RecyclerView
    private lateinit var galleryAdapter: GalleryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        rvGallery = findViewById(R.id.rvGallery)
        rvGallery.layoutManager = LinearLayoutManager(this)
        galleryAdapter = GalleryAdapter(getGalleryItems())
        rvGallery.adapter = galleryAdapter

        val btnBack: ImageButton = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            navigateToDashboard(it)
        }

        val btnHome: ImageButton = findViewById(R.id.btnHome)
        btnHome.setOnClickListener {
            navigateToHome(it)
        }

        val btnAdd: ImageButton = findViewById(R.id.btnAdd)
        btnAdd.setOnClickListener {
            navigateToAdd(it)
        }

        val btnProfile: ImageButton = findViewById(R.id.btnProfile)
        btnProfile.setOnClickListener {
            navigateToProfile(it)
        }
    }

    private fun getGalleryItems(): List<GalleryItem> {
        // Simulate fetching data from a database or API
        return listOf(
            GalleryItem("Event 1", "Monday, 20 June 2023", R.drawable.sample_image_1, "Description of event 1."),
            GalleryItem("Event 2", "Tuesday, 21 June 2023", R.drawable.sample_image_2, "Description of event 2."),
            GalleryItem("Event 3", "Wednesday, 22 June 2023", R.drawable.sampel_image_3, "Description of event 3.")
        )
    }

    private fun navigateToDashboard(view: View) {
        finish()
    }

    private fun navigateToHome(view: View) {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToAdd(view: View) {
        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToProfile(view: View) {
        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
    }
}
