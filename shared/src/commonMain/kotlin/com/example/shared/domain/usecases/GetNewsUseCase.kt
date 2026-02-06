package com.example.shared.domain.usecases

import com.example.shared.domain.repository.NewsRepository
import com.example.shared.domain.entities.NewsItem
import kotlinx.coroutines.flow.Flow

class GetNewsUseCase(
    val newsRepository: NewsRepository
) {
    suspend operator fun invoke(): Flow<Result<List<NewsItem>>>{
        return newsRepository.getNews()
    }
}