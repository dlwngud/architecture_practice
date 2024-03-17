package com.wngud.test3.domain.usecase

import com.wngud.test3.domain.ProductRepository
import com.wngud.test3.domain.model.Product

class AddProductUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke(product: Product) {
        productRepository.addProduct(product)
    }
}