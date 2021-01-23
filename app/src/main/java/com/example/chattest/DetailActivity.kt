package com.example.chattest

import android.content.ClipData
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.detail_layout.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_layout)
        val chatName: String? = intent.getStringExtra("chatName_data")
        val chatImage: Int = intent.getIntExtra("image_data", 0)
        val creatorName: String? = intent.getStringExtra("creatorName_data")
        imageView.setImageResource(chatImage)
        var image: ImageView = findViewById(R.id.imageView)
        image.setImageResource(chatImage)
        var chatNameText: TextView = findViewById(R.id.textView1)
        chatNameText.text = chatName
        var creatNameText: TextView = findViewById(R.id.textView2)
        creatNameText.text = creatorName
        textView2.setText(creatorName)
    }
}