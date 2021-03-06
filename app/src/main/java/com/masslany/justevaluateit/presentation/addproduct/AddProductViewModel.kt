package com.masslany.justevaluateit.presentation.addproduct

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masslany.justevaluateit.data.local.entity.Category
import com.masslany.justevaluateit.data.local.entity.Product
import com.masslany.justevaluateit.domain.usecase.category.GetAllCategoriesUseCase
import com.masslany.justevaluateit.domain.usecase.product.AddProductUseCase
import com.masslany.justevaluateit.domain.validation.AddProductValidation
import com.masslany.justevaluateit.domain.validation.AddProductValidationResult
import com.masslany.justevaluateit.presentation.addproduct.state.AddProductState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel @Inject constructor(
    private val addProductValidation: AddProductValidation,
    getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val addProductUseCase: AddProductUseCase,
) : ViewModel() {

    private val selectedCategory: MutableState<Category?> = mutableStateOf(null)
    val categories = getAllCategoriesUseCase.execute()

    private val _barcode: MutableState<String> = mutableStateOf("")
    val barcode: State<String> = _barcode

    private val _addProductState = MutableLiveData<AddProductState>()
    val addProductState: LiveData<AddProductState> = _addProductState

    private val _addProductChannel = Channel<AddProductEvent>()
    val addProductChannel = _addProductChannel.receiveAsFlow()

    fun onCategoryChanged(category: Category) {
        selectedCategory.value = category
    }

    fun onSaveProductButtonClicked(
        productName: String,
        barcode: String,
        description: String,
    ) {
        viewModelScope.launch {
            when (addProductValidation.validate(productName, barcode)) {
                AddProductValidationResult.EmptyProductName ->
                    _addProductState.value = AddProductState.EmptyProductName
                AddProductValidationResult.InvalidBarcode ->
                    _addProductState.value = AddProductState.InvalidBarcode
                AddProductValidationResult.AlreadyTakenProductName ->
                    _addProductState.value = AddProductState.AlreadyTakenProductName
                AddProductValidationResult.Valid -> {
                    proceedWithAddingProduct(
                        productName = productName,
                        barcode = barcode,
                        description = description
                    )
                }
            }
        }
    }

    private fun proceedWithAddingProduct(
        productName: String,
        barcode: String,
        description: String,
        photo: String? = null,
    ) {
        val categoryId = selectedCategory.value?.categoryId ?: -1

        if (categoryId == -1) {
            Log.e(
                "AddProductViewModel",
                "onSaveProductButtonClicked: Unknown category selected"
            )
        }

        val product = Product(
            name = productName,
            categoryId = categoryId,
            barcode = barcode,
            photo = photo,
            description = description
        )

        viewModelScope.launch {
            val state = addProductUseCase.execute(product)
            _addProductState.value = state
        }
    }

    fun onBarcodeChanged(barcode: String) {
        _barcode.value = barcode
    }

    fun onBarcodeButtonClicked() {
        viewModelScope.launch {
            _addProductChannel.send(AddProductEvent.LaunchBarcodeScanner)
        }
    }
}
