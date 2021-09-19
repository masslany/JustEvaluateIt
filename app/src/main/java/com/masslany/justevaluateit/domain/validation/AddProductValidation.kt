package com.masslany.justevaluateit.domain.validation

import java.util.regex.Pattern

class AddProductValidation {

    private companion object {
        private const val BARCODE_EAN8_PATTERN = """\d{8}"""
        private const val BARCODE_EAN13_PATTERN = """\d{13}"""
    }

    private val barcodeEan8Pattern = Pattern.compile(BARCODE_EAN8_PATTERN)
    private val barcodeEan13Pattern = Pattern.compile(BARCODE_EAN13_PATTERN)

    fun validate(
        productName: String,
        barcode: String
    ): AddProductValidationResult {
        return if (productName.isBlank() || productName.isEmpty()) {
            AddProductValidationResult.EmptyProductName
        } else if ((!barcodeEan8Pattern.matcher(barcode).matches() &&
                    !barcodeEan13Pattern.matcher(barcode).matches()) && barcode.isNotEmpty()
        ) {
            AddProductValidationResult.InvalidBarcode
        } else {
            AddProductValidationResult.Valid
        }
    }
}