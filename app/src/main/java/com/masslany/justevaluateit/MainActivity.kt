package com.masslany.justevaluateit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.masslany.justevaluateit.ui.dashboard.DashboardScreen
import com.masslany.justevaluateit.ui.theme.JustEvaluateItTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JustEvaluateItTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    DashboardScreen()
                }
            }
        }
    }
}

