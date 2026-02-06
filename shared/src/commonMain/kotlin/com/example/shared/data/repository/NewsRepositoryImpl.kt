package com.example.shared.data.repository

import com.example.shared.data.di.BASE_URL
import com.example.shared.data.model.NewsResponse
import com.example.shared.data.model.toDomain
import com.example.shared.domain.entities.NewsItem
import com.example.shared.domain.repository.NewsRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

internal class NewsRepositoryImpl(
    val client: HttpClient
) : NewsRepository {
    override suspend fun getNews(): Flow<Result<List<NewsItem>>> = flow {
        try {
            val response: NewsResponse = client.get(BASE_URL + "top-headlines") {
                url {
                    parameters.append("apiKey", "490b461d624041878ae288088031eec7")
                    parameters.append("country", "us")
                }
            }.body()
            val newsList: List<NewsItem> = response.articles.map { article -> article.toDomain() }
            println("REPOSITORYIMPL $newsList")
            emit(Result.success(newsList))
        } catch (e: Exception) {
            println("NETWORK_DEBUG Error: ${e.message}")
            emit(Result.failure(e))
        }
    }
}