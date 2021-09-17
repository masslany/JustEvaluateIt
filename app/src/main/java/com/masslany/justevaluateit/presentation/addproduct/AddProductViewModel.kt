package com.masslany.justevaluateit.presentation.addproduct

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.masslany.justevaluateit.domain.usecase.category.GetAllCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel @Inject constructor(
    getAllCategoriesUseCase: GetAllCategoriesUseCase,
) : ViewModel() {

    private val _productNameFieldState: MutableState<String> = mutableStateOf("")
    val productNameFieldState: State<String> = _productNameFieldState

    private val _barcodeFieldState: MutableState<String> = mutableStateOf("")
    val barcodeFieldState: State<String> = _barcodeFieldState

    val categories = getAllCategoriesUseCase.execute()

    fun onProductNameFieldChange(value: String) {
        _productNameFieldState.value = if (value.any { it == '\n' }) {
            _productNameFieldState.value
        } else {
            value
        }
    }

    fun onBarcodeFieldChange(value: String) {
        _barcodeFieldState.value = if (value.any { it == '\n' || !it.isDigit() }) {
            _barcodeFieldState.value
        } else {
            value
        }
    }

    fun onSaveProductButtonClicked() {

    }
}