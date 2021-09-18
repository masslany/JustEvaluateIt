package com.masslany.justevaluateit.domain.validation

import com.masslany.justevaluateit.data.local.JEIDatabase
import java.util.regex.Pattern

class AddProductValidation(database: JEIDatabase) {

    private companion object {
        private const val BARCODE_PATTERN = """\d{8}|\d{13}"""
    }

    private val barcodePattern = Pattern.compile(BARCODE_PATTERN)
    private val productDao = database.productDao

    suspend fun validate(
        productName: String,
        barcode: String
    ): AddProductValidationResult {
        return if (productName.isBlank() || productName.isEmpty()) {
            AddProductValidationResult.EmptyProductName
        } else if (!barcodePattern.matcher(barcode).matches()) {
            AddProductValidationResult.InvalidBarcode
        } else if (productDao.getProductByName(productName).isNotEmpty()) {
            AddProductValidationResult.AlreadyTakenProductName
        } else {
            AddProductValidationResult.Valid
        }
    }
}