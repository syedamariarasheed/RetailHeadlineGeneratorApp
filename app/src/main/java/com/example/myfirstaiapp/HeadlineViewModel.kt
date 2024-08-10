package com.example.myfirstaiapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myfirstaiapp.data.discountedItems
import com.example.myfirstaiapp.data.pastHistory
import com.google.ai.client.generativeai.GenerativeModel
import com.google.ai.client.generativeai.type.content
import com.google.ai.client.generativeai.type.generationConfig
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HeadlineViewModel : ViewModel() {

    private val _uiState: MutableStateFlow<UiState> =
        MutableStateFlow(UiState.Initial)
    val uiState: StateFlow<UiState> =
        _uiState.asStateFlow()

    private val config = generationConfig {
        temperature = 0.2f // Deterministic Output
        maxOutputTokens = 200
    }

    private val generativeModel = GenerativeModel(
        modelName = "gemini-1.5-flash",
        apiKey = BuildConfig.apiKey,
        generationConfig = config
    )

    private val outputParameters = arrayListOf(
        "check best discounted pricing and similar category not item which he bought earlier and",
        "best discount = price - discountedPrice",
        "send me only one best option",
        "text must be in roman urdu not in urdu",
        "headline must have fun element",
        "only return headline text which I directly show it to user",
        "only mention discounted item name which is suggested",
        "also write fun quote regarding the category of result"
    )

    private val instruction =
        "Give me daily headline text according to past history of user buying which is = $pastHistory " +
                "retrieve best discounted price item discounted data is $discountedItems" +
                " here are some outputParameters which needs to be fulfilled = $outputParameters"


    fun sendPrompt() {
        _uiState.value = UiState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = generativeModel.generateContent(

                    content(role = "user") {
                        text(
                            instruction
                        )
                    }
                )
                response.text?.let { outputContent ->
                    _uiState.value = UiState.Success(outputContent)
                }
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.localizedMessage ?: "")
            }
        }
    }
}