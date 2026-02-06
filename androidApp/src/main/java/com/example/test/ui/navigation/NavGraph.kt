package com.example.test.ui.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.detailsfeature.presentation.DetailEntryPoint
import com.example.shared.presentation.viewmodel.MainViewModel
import com.example.test.ui.navigation.Destinations.*
import com.example.shared.presentation.ui.MainScreen
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavGraph(modifier: Modifier = Modifier, viewModel: MainViewModel = koinViewModel()) {
    val backStack = remember { mutableStateListOf<Any>(HomeFeature) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is HomeFeature -> NavEntry(key) {
                    MainScreen(modifier, viewModel) {
                        backStack.add(DetailFeature(navItem = it))
                    }
                }

                is DetailFeature -> NavEntry(key) {
                    DetailEntryPoint(newsItem = key.navItem) {
                        backStack.removeLastOrNull()
                    }
                }

                else -> NavEntry(Unit) {
                    Text("Unknown server")
                }
            }
        }
    )
}