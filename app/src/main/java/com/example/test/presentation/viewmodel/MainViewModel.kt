package com.example.test.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewModelScope
import com.example.test.domain.entities.NewsItem
import com.example.test.domain.usecases.GetNewsUseCase
import com.example.test.domain.usecases.NewsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val newsUseCase: NewsUseCase
) : ViewModel() {
    private val _news = MutableStateFlow<List<NewsItem>>(emptyList())
    val news = _news.asStateFlow()

    init {
        getNews()
    }

    fun getNews() {
        viewModelScope.launch {
            newsUseCase.getNews().collect { result ->
                result.fold(
                    onSuccess = { result ->
                        _news.value = result
                        Log.d("WOW", "${_news.value}")
                    },
                    onFailure = { error ->
                        Log.e("WOW", "Something went wrong... ${error.message}")

                    }
                )

            }

        }
    }
}