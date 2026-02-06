package com.example.shared.domain.repository

import com.example.shared.domain.entities.NewsItem
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    suspend fun getNews(): Flow<Result<List<NewsItem>>>
}