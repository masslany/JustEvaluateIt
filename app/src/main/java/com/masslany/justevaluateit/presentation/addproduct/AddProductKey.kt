package com.masslany.justevaluateit.presentation.addproduct

import androidx.compose.ui.ExperimentalComposeUiApi
import com.zhuinden.simplestackextensions.fragments.DefaultFragmentKey
import kotlinx.parcelize.Parcelize

@ExperimentalComposeUiApi
@Parcelize
class AddProductKey : DefaultFragmentKey() {
    override fun instantiateFragment(): AddProductFragment = AddProductFragment()
}