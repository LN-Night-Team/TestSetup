package com.example.test.domain.usecases

import com.example.test.domain.NewsRepository
import com.example.test.domain.entities.NewsItem
import kotlinx.coroutines.flow.Flow

class GetNewsUseCase(
    val newsRepository: NewsRepository
) {
    suspend operator fun invoke(): Flow<Result<List<NewsItem>>>{
        return newsRepository.getNews()
    }
}