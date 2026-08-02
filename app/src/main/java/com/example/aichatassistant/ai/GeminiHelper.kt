package com.example.aichatassistant.ai

import com.example.aichatassistant.Constants
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content

object GeminiHelper {

    private val model = GenerativeModel(
        modelName = "gemini-2.5-flash",
        apiKey = Constants.GEMINI_API_KEY
    )

    suspend fun getResponse(prompt: String): String {

        return try {

            val response = model.generateContent(
                content {
                    text(prompt)
                }
            )

            response.text ?: "No response."

        } catch (e: Exception) {
            "Error: ${e.message}"
        }
    }
}