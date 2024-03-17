package com.wngud.test3.data

import com.wngud.test3.domain.model.Product
import com.wngud.test3.domain.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val productDataSource: ProductDataSource
) : ProductRepository {
    override val products: Flow<List<Product>> = productDataSource.products

    override suspend fun loadProductAll() {
        productDataSource.loadProductAll()
    }

    override suspend fun addProduct(product: Product) {
        productDataSource.addProduct(product)
    }

    override suspend fun removeLastProduct() {
        productDataSource.removeLastProduct()
    }
}