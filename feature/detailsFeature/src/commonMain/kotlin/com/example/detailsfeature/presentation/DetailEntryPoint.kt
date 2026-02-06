package com.example.detailsfeature.presentation

import androidx.compose.runtime.Composable
import com.example.shared.presentation.ArgsNewsItem

@Composable
fun DetailEntryPoint(newsItem: ArgsNewsItem,
                     onClick: () -> Unit) {
    DetailScreen(newsItem = newsItem, onBackClicked = onClick)
}