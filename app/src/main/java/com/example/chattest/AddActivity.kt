package com.example.chattest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.add_layout.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_layout)
        button.setOnClickListener {
            val chatName = chatNameInput.text.toString()
            val creatorName = creatorNameInput.text.toString()
            if (chatName.isNotEmpty() && creatorName.isNotEmpty()) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("addChatName", chatName)
                intent.putExtra("addCreatorName", creatorName)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}