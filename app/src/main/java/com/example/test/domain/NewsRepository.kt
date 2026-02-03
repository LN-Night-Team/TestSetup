package com.example.test.domain

import com.example.test.data.NewsResponse
import com.example.test.domain.entities.NewsItem
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNews(): Flow<Result<List<NewsItem>>>
}