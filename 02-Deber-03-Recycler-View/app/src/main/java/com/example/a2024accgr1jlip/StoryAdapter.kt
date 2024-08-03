package com.example.a2024accgr1jlip

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StoryAdapter(private val stories: List<Story>) : RecyclerView.Adapter<StoryAdapter.StoryViewHolder>() {

    class StoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val userImage: ImageView = itemView.findViewById(R.id.storyUserImage)
        val userName: TextView = itemView.findViewById(R.id.storyUserName)
        val storyImage: ImageView = itemView.findViewById(R.id.storyImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_story, parent, false)
        return StoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: StoryViewHolder, position: Int) {
        val story = stories[position]
        holder.userName.text = story.userName

        ImageLoader(holder.userImage).execute(story.userImageUrl)
        ImageLoader(holder.storyImage).execute(story.storyImageUrl)
    }

    override fun getItemCount() = stories.size
}