package com.example.chattest

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter(val chatList: List<Chat>) :
        RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    inner class FirstViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val chatImage: ImageView = view.findViewById(R.id.chatImage)
        val chatName: TextView = view.findViewById(R.id.chatName)
        val creatorName: TextView = view.findViewById(R.id.creatorName)
    }

    inner class SecondViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val chatImage2: ImageView = view.findViewById(R.id.chatImage2)
        val chatName2: TextView = view.findViewById(R.id.chatName2)
        val creatorName2: TextView = view.findViewById(R.id.creatorName2)
    }

    override fun getItemViewType(position: Int): Int {
        return position % 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = if (viewType == 1) {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item, parent, false)
        val viewHolder = FirstViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val chat = chatList[position]
            val intent = Intent(parent.context, DetailActivity::class.java)
            intent.putExtra("chatName_data", chat.chatName)
            intent.putExtra("creatorName_data", chat.creatorName)
            intent.putExtra("image_data", chat.imageId)
            startActivity(parent.context, intent, null)
        }
        viewHolder
    } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.chat_item2, parent, false)
            val viewHolder = SecondViewHolder(view)
            viewHolder.itemView.setOnClickListener {
                val position = viewHolder.adapterPosition
                val chat = chatList[position]
                val intent = Intent(parent.context, DetailActivity::class.java)
                intent.putExtra("chatName_data", chat.chatName)
                intent.putExtra("creatorName_data", chat.creatorName)
                intent.putExtra("image_data", chat.imageId)
                startActivity(parent.context, intent, null)
            }
        viewHolder
    }
    /*: ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.chat_item, parent, false)
        val viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            val position = viewHolder.adapterPosition
            val chat = chatList[position]
            val intent = Intent(parent.context, DetailActivity::class.java)
            intent.putExtra("chatName_data", chat.chatName)
            intent.putExtra("creatorName_data", chat.creatorName)
            intent.putExtra("image_data", chat.imageId)
            startActivity(parent.context, intent, null)
        }
        return viewHolder
    }*/

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chat = chatList[position]
        when (holder) {
            is FirstViewHolder -> {
                holder.chatImage.setImageResource(chat.imageId)
                holder.chatName.text = chat.chatName
                holder.creatorName.text = chat.creatorName
            }
            is SecondViewHolder -> {
                holder.chatImage2.setImageResource(chat.imageId)
                holder.chatName2.text = chat.chatName
                holder.creatorName2.text = chat.creatorName
            }
        }
//        holder.chatImage.setImageResource(chat.imageId)
//        holder.chatName.text = chat.chatName
//        holder.creatorName.text = chat.creatorName
//        holder.itemView.setOnClickListener {
//            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
//            intent.putExtra("chatName_data", chat.chatName)
//            holder.itemView.context.startActivity(intent)
//        }
    }

    override fun getItemCount() = chatList.size

}