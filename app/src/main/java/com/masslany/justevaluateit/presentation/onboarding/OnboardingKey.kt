package com.masslany.justevaluateit.presentation.onboarding

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.ExperimentalComposeUiApi
import com.google.accompanist.pager.ExperimentalPagerApi
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey
import kotlinx.parcelize.Parcelize

@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Parcelize
@ExperimentalPagerApi
class OnboardingKey : DefaultFragmentKey() {
    override fun instantiateFragment(): OnboardingFragment = OnboardingFragment()
}