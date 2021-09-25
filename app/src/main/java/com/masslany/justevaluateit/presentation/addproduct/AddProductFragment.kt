package com.masslany.justevaluateit.presentation.addproduct

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.ComposeView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.zxing.BarcodeFormat
import com.google.zxing.Result
import com.kroegerama.kaiteki.bcode.BarcodeResultListener
import com.kroegerama.kaiteki.bcode.ui.showBarcodeAlertDialog
import com.masslany.justevaluateit.R
import com.masslany.justevaluateit.presentation.ui.theme.JustEvaluateItTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@ExperimentalComposeUiApi
@AndroidEntryPoint
class AddProductFragment : Fragment(), BarcodeResultListener {

    private val viewModel: AddProductViewModel by viewModels()

    private val requiredCameraPermission by lazy {
        Manifest.permission.CAMERA
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val requestPermissionLauncher =
            registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) {

            }
        requestPermissionLauncher.launch(requiredCameraPermission)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val navController = findNavController()

        return ComposeView(requireContext()).apply {
            setContent {
                JustEvaluateItTheme {
                    Surface(color = MaterialTheme.colors.background) {
                        AddProductScreen(
                            viewModel = viewModel,
                            navController = navController
                        )
                    }
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenStarted {
            viewModel.addProductChannel.collect { event ->
                when (event) {
                    AddProductEvent.LaunchBarcodeScanner -> {
                        if (hasCameraPermission(requireContext())) {
                            requireContext().showBarcodeAlertDialog(
                                owner = this@AddProductFragment,
                                listener = this@AddProductFragment,
                                formats = listOf(BarcodeFormat.EAN_8, BarcodeFormat.EAN_13),
                                barcodeInverted = false
                            )
                        } else {
                            Toast.makeText(
                                requireContext(),
                                getString(R.string.camera_permission_not_granted),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }
                }
            }
        }
    }

    private fun hasCameraPermission(context: Context) =
        ContextCompat.checkSelfPermission(
            context,
            requiredCameraPermission
        ) == PackageManager.PERMISSION_GRANTED


    override fun onBarcodeResult(result: Result): Boolean {
        viewModel.onBarcodeChanged(result.text)
        return true
    }

    override fun onBarcodeScanCancelled() {
        // Do nothing
    }
}
