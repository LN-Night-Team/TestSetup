package com.example.test

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.Modifier
import com.example.test.presentation.navigation.NewsApp
import com.example.test.presentation.viewmodel.MainViewModel
import com.example.test.ui.theme.TestTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel = koinViewModel<MainViewModel>()
            TestTheme {
                NewsApp(viewModel = viewModel, modifier = Modifier)
            }
        }
    }
}
