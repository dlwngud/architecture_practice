package com.wngud.test3.domain.usecase

import com.wngud.test3.domain.ProductRepository

class LoadProductAllUseCase(
    private val productRepository: ProductRepository
) {
    suspend operator fun invoke() {
        productRepository.loadProductAll()
    }
}