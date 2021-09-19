package com.masslany.justevaluateit.domain.usecase.product

import com.masslany.justevaluateit.data.local.entity.Product
import com.masslany.justevaluateit.di.IoDispatcher
import com.masslany.justevaluateit.domain.repository.ProductRepository
import com.masslany.justevaluateit.presentation.addproduct.state.AddProductState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddProductUseCase @Inject constructor(
    private val productRepository: ProductRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun execute(product: Product): AddProductState {
        return withContext(ioDispatcher) {
            if (productRepository.getProductByName(product.name).isNotEmpty()) {
                AddProductState.AlreadyTakenProductName
            }
            productRepository.addProduct(product)
            AddProductState.AddedProduct(product)
        }
    }
}