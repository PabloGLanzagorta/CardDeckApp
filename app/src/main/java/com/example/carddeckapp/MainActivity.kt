package com.example.carddeckapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.carddeckapp.ui.CardApp
import com.example.carddeckapp.ui.theme.CardDeckAppTheme

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CardDeckAppTheme {
                //Initial App without Model
                CardApp()
            }
        }
    }
}