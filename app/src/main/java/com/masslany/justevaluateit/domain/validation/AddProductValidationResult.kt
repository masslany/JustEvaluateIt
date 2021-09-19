package com.masslany.justevaluateit.domain.validation

sealed class AddProductValidationResult {
    object EmptyProductName : AddProductValidationResult()
    object AlreadyTakenProductName : AddProductValidationResult()
    object InvalidBarcode : AddProductValidationResult()
    object Valid : AddProductValidationResult()
}
