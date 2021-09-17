package com.masslany.justevaluateit.domain.usecase.product

import com.masslany.justevaluateit.data.local.entity.Product
import com.masslany.justevaluateit.di.IoDispatcher
import com.masslany.justevaluateit.domain.repository.ProductRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AddProductUseCase @Inject constructor(
    private val productRepository: ProductRepository,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun execute(product: Product) {
        withContext(ioDispatcher) {
            productRepository.addProduct(product)
        }
    }
}