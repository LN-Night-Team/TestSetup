package com.example.shared.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shared.domain.usecases.NewsUseCase
import com.example.shared.presentation.ArgsNewsItem
import com.example.shared.presentation.toPresentation
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val newsUseCase: NewsUseCase
) : ViewModel() {
    private val _news = MutableStateFlow<List<ArgsNewsItem>>(emptyList())
    val news = _news.asStateFlow()

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            newsUseCase.getNews().collect { result ->
                result.fold(
                    onSuccess = { result ->
                        _news.value = result.map { it.toPresentation() }
                        println("WOW ${_news.value}")
                    },
                    onFailure = { error ->
                        println("WOW Something went wrong... ${error.message}")

                    }
                )

            }

        }
    }
}