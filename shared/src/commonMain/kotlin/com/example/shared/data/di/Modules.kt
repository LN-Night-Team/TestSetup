package com.example.shared.data.di

import com.example.shared.data.repository.NewsRepositoryImpl
import com.example.shared.domain.repository.NewsRepository
import com.example.shared.domain.usecases.GetNewsUseCase
import com.example.shared.domain.usecases.NewsUseCase
import com.example.shared.presentation.viewmodel.MainViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

const val BASE_URL = "https://newsapi.org/v2/"
val networkModule = module {
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true
                        prettyPrint = true
                    }
                )
            }
        }
    }
}
val appModule = module {
    factory { MainViewModel(newsUseCase = get()) }
    single<NewsRepository> { NewsRepositoryImpl(get()) }
    factory<GetNewsUseCase> { GetNewsUseCase(get()) }
    factory<NewsUseCase> { NewsUseCase(get()) }
}

val appModules = listOf(appModule, networkModule)