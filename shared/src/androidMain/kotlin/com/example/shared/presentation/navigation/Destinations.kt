package com.example.shared.presentation.navigation

import androidx.navigation3.runtime.NavKey
import com.example.shared.presentation.ArgsNewsItem
import kotlinx.serialization.Serializable

@Serializable
internal sealed interface Destinations : NavKey {
    @Serializable
    data object HomeFeature: Destinations

    @Serializable
    data class DetailFeature(val navItem: ArgsNewsItem): Destinations
}