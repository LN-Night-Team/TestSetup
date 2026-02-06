package com.example.test.presentation.navigation

import androidx.navigation3.runtime.NavKey
import com.example.test.presentation.navigation.model.ArgsNewsItem
import kotlinx.serialization.Serializable

@Serializable
internal sealed interface Destinations : NavKey {
    @Serializable
    data object HomeScreen: Destinations

    @Serializable
    data class DetailScreen(val navItem: ArgsNewsItem): Destinations
}