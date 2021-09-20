package com.masslany.justevaluateit.presentation.addproduct.state

import androidx.annotation.StringRes
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class AddProductScreenState {
    var productName by mutableStateOf("")
    var barcode by mutableStateOf("")
    var description by mutableStateOf("")
    var productErrorMessage by mutableStateOf(0)
    var isInvalidName by mutableStateOf(false)
    var isInvalidBarcode by mutableStateOf(false)

    fun showInvalidProductName(@StringRes message: Int) {
        isInvalidName = true
        productErrorMessage = message
    }

    fun showInvalidBarcode() {
        isInvalidBarcode = true
    }

    fun onProductNameFieldChange(value: String) {
        productName = if (value.any { it == '\n' }) {
            productName
        } else {
            value
        }
    }

    fun onBarcodeFieldChange(value: String) {
        barcode = if (value.any { it == '\n' || !it.isDigit() }) {
            barcode
        } else {
            value
        }
    }

    fun onDescriptionFieldChange(value: String) {
        description = value
    }

    fun resetUiState() {
        isInvalidName = false
        isInvalidBarcode = false
        productErrorMessage = 0
    }
}
