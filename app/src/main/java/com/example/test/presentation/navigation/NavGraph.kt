package com.example.test.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.example.test.presentation.MainScreen
import com.example.test.presentation.viewmodel.MainViewModel

@Composable
fun NewsApp(modifier: Modifier = Modifier, viewModel: MainViewModel) {
    val backStack = remember { mutableStateListOf<Any>(HomeScreen) }

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = { key ->
            when (key) {
                is HomeScreen -> NavEntry(key) {
                    MainScreen(modifier, viewModel){ item ->
                        backStack.add(DetailScreen(navItem = item))
                    }
                }

                is DetailScreen -> NavEntry(key) {
                   Text("${key.navItem}")
                }

                else -> NavEntry(Unit) {
                    Text("Unknown server")
                }
            }
        }
    )
}