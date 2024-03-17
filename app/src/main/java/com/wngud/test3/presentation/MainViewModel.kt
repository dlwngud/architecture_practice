package com.wngud.test3.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wngud.test3.domain.usecase.AddProductUseCase
import com.wngud.test3.domain.usecase.GetProductsUseCase
import com.wngud.test3.domain.usecase.LoadProductAllUseCase
import com.wngud.test3.domain.model.Product
import com.wngud.test3.domain.usecase.RemoveLastProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase,
    private val loadProductAllUseCase: LoadProductAllUseCase,
    private val addProductUseCase: AddProductUseCase,
    private val removeLastProductUseCase: RemoveLastProductUseCase
) : ViewModel() {
    val products = getProductsUseCase().stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    fun loadProductAll() {
        viewModelScope.launch {
            loadProductAllUseCase()
        }
    }

    fun addProduct(product: Product) {
        viewModelScope.launch {
            addProductUseCase(product)
        }
    }

    fun removeLastProduct() {
        viewModelScope.launch {
            removeLastProductUseCase()
        }
    }
}