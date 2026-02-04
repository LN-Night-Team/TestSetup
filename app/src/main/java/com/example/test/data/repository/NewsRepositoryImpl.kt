package com.example.test.data.repository

import android.util.Log
import com.example.test.data.model.NewsResponse
import com.example.test.data.di.BASE_URL
import com.example.test.data.model.toDomain
import com.example.test.domain.repository.NewsRepository
import com.example.test.domain.entities.NewsItem
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NewsRepositoryImpl(
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
            Log.d("REPOSITORYIMPL", "$newsList")
            emit(Result.success(newsList))
        } catch (e: Exception) {
            Log.e("NETWORK_DEBUG", "Error: ${e.message}", e)
            emit(Result.failure(e))
        }
    }.flowOn(Dispatchers.IO)
}