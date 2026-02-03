package com.example.test

import com.example.test.data.NewsRepositoryImpl
import com.example.test.domain.NewsRepository
import com.example.test.domain.usecases.GetNewsUseCase
import com.example.test.domain.usecases.NewsUseCase
import com.example.test.presentation.viewmodel.MainViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val BASE_URL = "https://newsapi.org/v2/"
val networkModule = module {
    single {
        HttpClient(OkHttp) {
            install(Logging) {
                level = LogLevel.BODY
            }
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
    viewModel { MainViewModel(newsUseCase = get()) }
    single<NewsRepository> { NewsRepositoryImpl(get()) }
    factory<GetNewsUseCase> { GetNewsUseCase(get()) }
    factory<NewsUseCase> { NewsUseCase(get()) }
}

val appModules = listOf(appModule, networkModule)