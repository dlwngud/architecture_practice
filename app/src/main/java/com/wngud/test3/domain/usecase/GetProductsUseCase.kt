package com.wngud.test3.domain.usecase

import com.wngud.test3.domain.ProductRepository

class GetProductsUseCase(
    private val productRepository: ProductRepository
) {

    // 연산자를 오버로딩하는 함수 선언
    operator fun invoke() = productRepository.products
}