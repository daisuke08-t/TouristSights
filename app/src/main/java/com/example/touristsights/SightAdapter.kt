package com.example.touristsights

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SightAdapter(
    private val context: Context,
    private val sight: List<Sight>
) : RecyclerView.Adapter<SightAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name)
        val image: ImageView = view.findViewById(R.id.image)
        val description: TextView = view.findViewById(R.id.description)
        val kind: TextView = view.findViewById(R.id.kind)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = sight[position].name
        holder.description.text = sight[position].description
        holder.kind.text = sight[position].kind
        var imageResource = context.resources.getIdentifier(
            sight[position].imageName,
            "drawable", context.packageName
        )
        holder.image.setImageResource(imageResource)
    }

    override fun getItemCount(): Int = sight.size
}