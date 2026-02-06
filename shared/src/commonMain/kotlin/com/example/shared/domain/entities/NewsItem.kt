package com.example.shared.domain.entities

data class NewsItem(
    val title: String,
    val description: String?,
    val articleUrl: String,
    val imageUrl: String?,
    val date: String,
    val source: String
)