package com.masslany.justevaluateit.presentation.addproduct

sealed class AddProductEvent {
    object LaunchBarcodeScanner : AddProductEvent()
}
