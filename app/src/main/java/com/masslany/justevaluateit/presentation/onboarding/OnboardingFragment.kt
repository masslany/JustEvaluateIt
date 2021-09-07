package com.masslany.justevaluateit.presentation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.google.accompanist.pager.ExperimentalPagerApi
import com.masslany.justevaluateit.presentation.ui.theme.JustEvaluateItTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalPagerApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class OnboardingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                JustEvaluateItTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
                        OnboardingScreen({}, {})
                    }
                }
            }
        }
    }
}