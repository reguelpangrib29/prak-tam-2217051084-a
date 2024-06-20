package com.example.campusevoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GalleryAdapter(private val galleryItems: List<GalleryItem>) : RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_gallery, parent, false)
        return GalleryViewHolder(view)
    }

    override fun onBindViewHolder(holder: GalleryViewHolder, position: Int) {
        val item = galleryItems[position]
        holder.tvGalleryTitle.text = item.title
        holder.tvGalleryDate.text = item.date
        holder.ivGalleryImage.setImageResource(item.image)
        holder.tvGalleryDescription.text = item.description
    }

    override fun getItemCount(): Int = galleryItems.size

    class GalleryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvGalleryTitle: TextView = itemView.findViewById(R.id.tvGalleryTitle)
        val tvGalleryDate: TextView = itemView.findViewById(R.id.tvGalleryDate)
        val ivGalleryImage: ImageView = itemView.findViewById(R.id.ivGalleryImage)
        val tvGalleryDescription: TextView = itemView.findViewById(R.id.tvGalleryDescription)
    }
}
