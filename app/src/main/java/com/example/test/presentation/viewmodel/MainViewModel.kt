package com.example.test.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.test.domain.usecases.NewsUseCase
import com.example.test.presentation.navigation.model.ArgsNewsItem
import com.example.test.presentation.navigation.model.toPresentation
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

    fun getNews() {
        viewModelScope.launch {
            newsUseCase.getNews().collect { result ->
                result.fold(
                    onSuccess = { result ->
                        _news.value = result.map { it.toPresentation() }
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