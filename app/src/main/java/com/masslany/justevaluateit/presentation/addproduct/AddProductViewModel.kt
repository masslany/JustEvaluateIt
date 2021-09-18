package com.masslany.justevaluateit.presentation.addproduct

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masslany.justevaluateit.data.local.entity.Category
import com.masslany.justevaluateit.data.local.entity.Product
import com.masslany.justevaluateit.domain.usecase.category.GetAllCategoriesUseCase
import com.masslany.justevaluateit.domain.usecase.product.AddProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel @Inject constructor(
    getAllCategoriesUseCase: GetAllCategoriesUseCase,
    private val addProductUseCase: AddProductUseCase,
) : ViewModel() {

    private val _productNameFieldState: MutableState<String> = mutableStateOf("")
    val productNameFieldState: State<String> = _productNameFieldState

    private val _barcodeFieldState: MutableState<String> = mutableStateOf("")
    val barcodeFieldState: State<String> = _barcodeFieldState

    private val _descriptionFieldState: MutableState<String> = mutableStateOf("")
    val descriptionFieldState: State<String> = _descriptionFieldState

    val categories = getAllCategoriesUseCase.execute()
    private val selectedCategory: MutableState<Category?> = mutableStateOf(null)

    //    private lateinit var defaultCategory: Category
//
//    init {
//        println("dfgdfdfgdfgdgfffdfgdfdf")
//        viewModelScope.launch {
//            val cat = categories.collect {
//                defaultCategory = it.first()
//            }
//            println("CATEGORIES $cat")
//            println("DEFAULT $defaultCategory")
//            selectedCategory = mutableStateOf(defaultCategory)
//            println("SELECTED $defaultCategory")
//        }
//    }


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

    fun onCategoryChanged(category: Category) {
        selectedCategory.value = category
    }

    fun onDescriptionFieldChange(value: String) {
        _descriptionFieldState.value = value
    }

    fun onSaveProductButtonClicked() {

        val categoryId = selectedCategory.value?.categoryId ?: -1
        if (categoryId == -1) {
            Log.e("AddProductViewModel", "onSaveProductButtonClicked: Unknown category selected")
        }

        val product = Product(
            name = productNameFieldState.value,
            categoryId = categoryId,
            barcode = barcodeFieldState.value,
            photo = null,
            description = descriptionFieldState.value
        )

        viewModelScope.launch {
            addProductUseCase.execute(product)
        }
    }
}