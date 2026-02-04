package com.example.test.presentation.navigation.model

import com.example.test.domain.entities.NewsItem
import kotlinx.serialization.Serializable

@Serializable
data class ArgsNewsItem(
    val title: String,
    val description: String?,
    val articleUrl: String,
    val imageUrl: String?,
    val date: String,
    val source: String
)

fun NewsItem.toPresentation(): ArgsNewsItem {
    return ArgsNewsItem(
        title = this.title,
        description = this.description,
        articleUrl = this.articleUrl,
        imageUrl = this.imageUrl,
        date = this.date,
        source = this.source
    )
}