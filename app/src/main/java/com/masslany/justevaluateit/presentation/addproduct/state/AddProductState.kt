package com.masslany.justevaluateit.presentation.addproduct.state

sealed class AddProductState {
    object EmptyProductName : AddProductState()
    object AlreadyTakenProductName : AddProductState()
    object InvalidBarcode : AddProductState()
}
