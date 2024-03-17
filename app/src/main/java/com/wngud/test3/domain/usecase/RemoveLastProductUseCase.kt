package com.wngud.test3.domain.usecase

import com.wngud.test3.domain.ProductRepository

class RemoveLastProductUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke() {
        productRepository.removeLastProduct()
    }
}