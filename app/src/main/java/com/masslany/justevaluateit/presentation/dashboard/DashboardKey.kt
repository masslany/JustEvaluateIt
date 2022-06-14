package com.masslany.justevaluateit.presentation.dashboard

import androidx.compose.ui.ExperimentalComposeUiApi
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey
import kotlinx.parcelize.Parcelize

@ExperimentalComposeUiApi
@Parcelize
class DashboardKey : DefaultFragmentKey() {
    override fun instantiateFragment(): DashboardFragment = DashboardFragment()
}
