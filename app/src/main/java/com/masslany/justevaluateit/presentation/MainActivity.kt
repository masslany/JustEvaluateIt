package com.masslany.justevaluateit.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.data.local.JEIDatabase
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

