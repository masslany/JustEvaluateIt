package com.masslany.justevaluateit.domain.validation

import com.google.common.truth.Truth
import org.junit.Test

internal class AddProductValidationTest {

    private val validator = AddProductValidation()

    @Test
    fun `valid 8 digit barcode return valid state`() {
        // Given
        val barcode = "12345678"

        // When
        val result = validator.validate(
            productName = "valid_irrelevant",
            barcode = barcode
        )

        // Then
        Truth.assertThat(result).isInstanceOf(AddProductValidationResult.Valid::class.java)
    }

    @Test
    fun `valid 13 digit barcode return valid state`() {
        // Given
        val barcode = "1234567890123"

        // When
        val result = validator.validate(
            productName = "valid_irrelevant",
            barcode = barcode
        )

        // Then
        Truth.assertThat(result).isInstanceOf(AddProductValidationResult.Valid::class.java)
    }

    @Test
    fun `empty barcode return valid state`() {
        // Given
        val barcode = ""

        // When
        val result = validator.validate(
            productName = "valid_irrelevant",
            barcode = barcode
        )

        // Then
        Truth.assertThat(result).isInstanceOf(AddProductValidationResult.Valid::class.java)
    }

    @Test
    fun `invalid barcode return invalid state`() {
        // Given
        val barcode = "112"

        // When
        val result = validator.validate(
            productName = "valid_irrelevant",
            barcode = barcode
        )

        // Then
        Truth.assertThat(result).isInstanceOf(AddProductValidationResult.InvalidBarcode::class.java)
    }

    @Test
    fun `empty product name return invalid state`() {
        // Given
        val name = ""

        // When
        val result = validator.validate(
            productName = name,
            barcode = "" // Irrelevant
        )

        // Then
        Truth.assertThat(result).isInstanceOf(AddProductValidationResult.EmptyProductName::class.java)
    }
}