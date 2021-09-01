package com.masslany.justevaluateit.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.presentation.dashboard.DashboardScreen
import com.masslany.justevaluateit.presentation.ui.theme.JustEvaluateItTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

