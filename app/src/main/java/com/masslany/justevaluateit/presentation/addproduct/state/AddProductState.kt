package com.masslany.justevaluateit.presentation.addproduct.state

import com.masslany.justevaluateit.data.local.entity.Product

sealed class AddProductState {
    object EmptyProductName : AddProductState()
    object AlreadyTakenProductName : AddProductState()
    object InvalidBarcode : AddProductState()
    data class AddedProduct(val product: Product) : AddProductState()
}
