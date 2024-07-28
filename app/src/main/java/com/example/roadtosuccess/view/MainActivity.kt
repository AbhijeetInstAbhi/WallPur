package com.example.roadtosuccess.view

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.core.view.WindowCompat
import com.example.roadtosuccess.navigation.Navigation
import com.example.roadtosuccess.view.theme.RoadToSuccessTheme
import com.example.roadtosuccess.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        val viewModel: MainViewModel by viewModels()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContent {
            RoadToSuccessTheme {
                // A surface container using the 'background' color from the theme
                Navigation()

            }
        }
    }
}


