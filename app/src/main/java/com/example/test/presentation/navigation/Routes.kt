package com.example.test.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeScreen

@Serializable
data class DetailScreen(val navItem: NavNewsItem)