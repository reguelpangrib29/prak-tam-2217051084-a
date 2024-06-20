package com.example.campusevoapp

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class AboutActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        // Setup ViewPager
        viewPager = findViewById(R.id.viewPager)
        val images = listOf(R.drawable.ic_about_image, R.drawable.ic_about_image2, R.drawable.ic_about_image3)
        val adapter = ImagePagerAdapter(this, images)
        viewPager.adapter = adapter

        val btnPrev: ImageButton = findViewById(R.id.btnPrev)
        val btnNext: ImageButton = findViewById(R.id.btnNext)

        btnPrev.setOnClickListener {
            viewPager.currentItem = viewPager.currentItem - 1
        }

        btnNext.setOnClickListener {
            viewPager.currentItem = viewPager.currentItem + 1
        }
    }

    fun navigateToDashboard(view: View) {
        finish()
    }
}
