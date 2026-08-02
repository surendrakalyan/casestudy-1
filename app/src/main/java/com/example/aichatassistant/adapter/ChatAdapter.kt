package com.example.aichatassistant.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aichatassistant.R
import com.example.aichatassistant.model.Message

class ChatAdapter(
    private val messageList: MutableList<Message>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val USER = 1
        private const val AI = 2
    }

    override fun getItemViewType(position: Int): Int {
        return if (messageList[position].isUser) USER else AI
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == USER) {

            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_user_message, parent, false)

            UserViewHolder(view)

        } else {

            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_ai_message, parent, false)

            AIViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val message = messageList[position]

        if (holder is UserViewHolder) {
            holder.message.text = message.text
        }

        if (holder is AIViewHolder) {
            holder.message.text = message.text
        }

    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val message: TextView =
            itemView.findViewById(R.id.txtUserMessage)

    }

    class AIViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val message: TextView =
            itemView.findViewById(R.id.txtAiMessage)

    }

}