package com.masslany.justevaluateit.presentation

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.masslany.justevaluateit.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @IdRes
    var startDestination: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val runOnboarding = true
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        if (runOnboarding) {
            startDestination = R.id.onboardingFragment

            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.nav_graph, false)
                .build()
            navController.navigate(startDestination, null, navOptions)

        } else {
            startDestination = R.id.dashboardFragment

            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.nav_graph, true)
                .build()
            navController.navigate(startDestination, null, navOptions)
        }
    }
}

