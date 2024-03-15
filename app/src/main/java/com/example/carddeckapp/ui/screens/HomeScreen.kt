package com.example.carddeckapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.carddeckapp.R
import com.example.carddeckapp.viewmodel.CardUiState

@Composable

fun HomeScreen(
    cardUiState: CardUiState,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp)
){
    when(cardUiState){
        is CardUiState.Loading -> LoadingScreen(modifier= Modifier.fillMaxSize())
        is CardUiState.Success -> ResultScreen(photos = cardUiState.photos,
            modifier = Modifier.fillMaxWidth())
        is CardUiState.Error -> ErrorScreen(modifier = Modifier.fillMaxSize())
    }
}

@Composable
fun ErrorScreen(modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.error),
            contentDescription = stringResource(R.string.error)
        )
        Text(text = stringResource(R.string.Error_conexion))
    }
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Image(painter = painterResource(R.drawable.loading_934434),
            contentDescription = stringResource(R.string.cargando)
        )
    }
}


@Composable
fun ResultScreen(photos:String, modifier: Modifier = Modifier){
    Box(modifier = modifier,
        contentAlignment = Alignment.Center
    ){
        Text(text = photos )
    }
}