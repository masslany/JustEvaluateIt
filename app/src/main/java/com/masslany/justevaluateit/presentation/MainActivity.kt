package com.masslany.justevaluateit.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.masslany.justevaluateit.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycleScope.launchWhenCreated {
            viewModel.shouldShowOnboarding.collect { showOnboarding ->
                handleNavigation(showOnboarding)
            }
        }
    }

    private fun handleNavigation(showOnboarding: Boolean) {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        val navInflater = navController.navInflater

        val navGraph = if (showOnboarding) {
            navInflater.inflate(R.navigation.onboarding_nav_graph)
        } else {
            navInflater.inflate(R.navigation.app_nav_graph)
        }

        navHostFragment.navController.graph = navGraph
    }
}

