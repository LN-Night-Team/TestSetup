package com.example.test.presentation.navigation

import com.example.test.domain.entities.NewsItem
import kotlinx.serialization.Serializable

@Serializable
data class NavNewsItem(
    val title: String,
    val description: String?,
    val articleUrl: String,
    val imageUrl: String?,
    val date: String,
    val source: String
)

fun NewsItem.toPresentation(): NavNewsItem {
    return NavNewsItem(
        title = this.title,
        description = this.description,
        articleUrl = this.articleUrl,
        imageUrl = this.imageUrl,
        date = this.date,
        source = this.source
    )
}