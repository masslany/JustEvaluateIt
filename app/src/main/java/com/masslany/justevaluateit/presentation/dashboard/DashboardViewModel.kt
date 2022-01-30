package com.masslany.justevaluateit.presentation.dashboard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.masslany.justevaluateit.data.local.entity.Product
import com.masslany.justevaluateit.domain.usecase.product.GetRecentProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    getRecentProductsUseCase: GetRecentProductsUseCase,
) : ViewModel() {
    var recentProducts by mutableStateOf(emptyList<Product>())
        private set

    init {
        viewModelScope.launch {
            getRecentProductsUseCase.execute(RECENT_PRODUCT_COUNT).collect {
                recentProducts = it
            }
        }
    }

    private companion object {
        const val RECENT_PRODUCT_COUNT = 10
    }
}
