package com.wngud.test3.domain

import com.wngud.test3.domain.model.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    val products: Flow<List<Product>>
    suspend fun loadProductAll()
    suspend fun addProduct(product: Product)
    suspend fun removeLastProduct()
}