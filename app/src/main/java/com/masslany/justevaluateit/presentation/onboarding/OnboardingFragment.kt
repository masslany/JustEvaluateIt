package com.masslany.justevaluateit.presentation.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ComposeView
import com.google.accompanist.pager.ExperimentalPagerApi
import com.masslany.justevaluateit.presentation.ui.theme.JustEvaluateItTheme
import com.zhuinden.simplestackextensions.fragments.KeyedFragment
import com.zhuinden.simplestackextensions.fragmentsktx.backstack
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalComposeUiApi
@ExperimentalPagerApi
@ExperimentalAnimationApi
@AndroidEntryPoint
class OnboardingFragment : KeyedFragment() {

    @Inject
    lateinit var viewModel: OnboardingViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                JustEvaluateItTheme {
                    Surface(color = MaterialTheme.colors.background) {
                        OnboardingScreen(
                            viewModel = viewModel,
                            backstack = backstack,
                        )
                    }
                }
            }
        }
    }
}
