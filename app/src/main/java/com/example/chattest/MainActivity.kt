package com.example.chattest

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.chat_item.*

class MainActivity : AppCompatActivity() {

    private val chatList = ArrayList<Chat>()

    private var adapter: ChatAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initChats()
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = ChatAdapter(chatList)
        recyclerView.adapter = adapter
    }

    private fun initChats() {
        chatList.add(Chat("开心一家人", "迪迦", R.drawable.atm_1))
        chatList.add(Chat("单身狗保护协会", "赛文", R.drawable.atm_2))
        chatList.add(Chat("光之国", "盖亚", R.drawable.atm_3))
        chatList.add(Chat("宇宙无敌", "jqgg", R.drawable.atm_4))
        chatList.add(Chat("防脱发研究小组", "黄林敏", R.drawable.atm_5))
        chatList.add(Chat("魔仙堡", "zbgg", R.drawable.atm_6))
        chatList.add(Chat("仙女驻凡大使馆", "dygg", R.drawable.atm_7))
//        chatList.add(Chat("乌鸦坐飞机", "frog", R.drawable.atm_8))
//        chatList.add(Chat("六级必过", "six", R.drawable.atm_9))
//        chatList.add(Chat("健胃消食片", "江中", R.drawable.atm_10))
//        chatList.add(Chat("MG城管", "agr640", R.drawable.atm_11))
//        chatList.add(Chat("金色家园", "yummy", R.drawable.atm_12))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.addGroup_item -> {
                val intent = Intent(this, AddActivity::class.java)
                startActivityForResult(intent, 1)
            }
            R.id.clear_item -> {
                chatList.clear()
                adapter?.notifyDataSetChanged()
            }
            R.id.exit_item -> {
                finish()
            }
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1 -> if (resultCode == Activity.RESULT_OK) {
                val addChatName = data?.getStringExtra("addChatName")
                val addCreatorName = data?.getStringExtra("addCreatorName")
                if(addChatName != null && addCreatorName != null) {
                    val chat = Chat(addChatName, addCreatorName, R.drawable.atm_13)
                    chatList.add(0, chat)
                    adapter?.notifyItemInserted(0)
                    recyclerView.scrollToPosition(0)
                    Toast.makeText(this, "添加群聊成功", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}