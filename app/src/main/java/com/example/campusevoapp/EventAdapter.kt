package com.example.campusevoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventAdapter(private val eventList: List<Event>) : RecyclerView.Adapter<EventAdapter.EventViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_event, parent, false)
        return EventViewHolder(view)
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        val event = eventList[position]
        holder.tvEventTitle.text = event.title
        holder.tvEventDate.text = event.date
        holder.ivEventImage.setImageResource(event.image)
        holder.tvEventDescription.text = event.description
    }

    override fun getItemCount(): Int = eventList.size

    class EventViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvEventTitle: TextView = itemView.findViewById(R.id.tvEventTitle)
        val tvEventDate: TextView = itemView.findViewById(R.id.tvEventDate)
        val ivEventImage: ImageView = itemView.findViewById(R.id.ivEventImage)
        val tvEventDescription: TextView = itemView.findViewById(R.id.tvEventDescription)
    }
}
