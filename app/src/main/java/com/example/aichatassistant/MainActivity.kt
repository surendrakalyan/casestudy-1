package com.example.aichatassistant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aichatassistant.adapter.ChatAdapter
import com.example.aichatassistant.model.Message

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ChatAdapter
    private val messageList = mutableListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.chatRecyclerView)

        adapter = ChatAdapter(messageList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        loadDummyMessages()
    }

    private fun loadDummyMessages() {

        messageList.add(
            Message("Hello! I'm your AI Assistant 👋", false)
        )

        messageList.add(
            Message("Hi", true)
        )

        messageList.add(
            Message("How can I help you today?", false)
        )

        adapter.notifyDataSetChanged()
    }
}