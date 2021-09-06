package com.masslany.justevaluateit.presentation.addproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.masslany.justevaluateit.presentation.ui.theme.JustEvaluateItTheme

@ExperimentalComposeUiApi
class AddProductFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val navController = findNavController()

        return ComposeView(requireContext()).apply {
            setContent {
                JustEvaluateItTheme {
                    // A surface container using the 'background' color from the theme
                    Surface(color = MaterialTheme.colors.background) {
                        AddProductScreen(
                            onNavigationIconClicked = {
                                navController.navigateUp()
                            }
                        )
                    }
                }
            }
        }
    }
}