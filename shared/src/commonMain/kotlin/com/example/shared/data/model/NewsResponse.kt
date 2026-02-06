package com.example.shared.data.model

import com.example.shared.domain.entities.NewsItem
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class NewsResponse(
    @SerialName("status")
    val status: String,
    @SerialName("totalResults")
    val totalResults: Int = 0,
    @SerialName("articles")
    val articles: List<Article> = emptyList()
)

@Serializable
data class Article(
    @SerialName("source")
    val source: Source,
    @SerialName("author")
    val author: String?,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String?,
    @SerialName("url")
    val url: String,
    @SerialName("urlToImage")
    val urlToImage: String?,
    @SerialName("publishedAt")
    val publishedAt: String,
    @SerialName("content")
    val content: String?
)

@Serializable
data class Source(
    @SerialName("id")
    val id: String?,
    @SerialName("name")
    val name: String
)

//Mapper
fun Article.toDomain(): NewsItem {
    return NewsItem(
        title = this.title,
        description = this.description,
        articleUrl = this.url,
        imageUrl = this.urlToImage,
        date = this.publishedAt,
        source = this.source.name
    )
}