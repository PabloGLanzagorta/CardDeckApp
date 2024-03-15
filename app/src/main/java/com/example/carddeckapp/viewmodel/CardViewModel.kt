package com.example.carddeckapp.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carddeckapp.network.CardApi
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface CardUiState{
    data class Success(val photos:String): CardUiState
    object Error:CardUiState
    object Loading:CardUiState
}

class CardViewModel: ViewModel() {
    var cardUiState:CardUiState by mutableStateOf(CardUiState.Loading)
        private set

    init {
        getCardPhotos()
    }
    fun getCardPhotos(){
        viewModelScope.launch {
            cardUiState = try {
                val listResult = CardApi.retrofitService.getCard()
                CardUiState.Success(listResult)
            }catch (e: IOException){
                CardUiState.Error
            }
        }
    }
}