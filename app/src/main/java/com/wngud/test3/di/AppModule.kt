package com.wngud.test3.di

import com.wngud.test3.data.InMemoryProductDataSource
import com.wngud.test3.data.ProductDataSource
import com.wngud.test3.data.ProductRepositoryImpl
import com.wngud.test3.domain.usecase.AddProductUseCase
import com.wngud.test3.domain.usecase.GetProductsUseCase
import com.wngud.test3.domain.usecase.LoadProductAllUseCase
import com.wngud.test3.domain.ProductRepository
import com.wngud.test3.domain.usecase.RemoveLastProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideGetProductsUseCase(productRepository: ProductRepository): GetProductsUseCase = GetProductsUseCase(productRepository)

    @Provides
    @Singleton
    fun provideLoadProductAllUseCase(productRepository: ProductRepository): LoadProductAllUseCase = LoadProductAllUseCase(productRepository)

    @Provides
    @Singleton
    fun provideAddProductUseCase(productRepository: ProductRepository): AddProductUseCase = AddProductUseCase(productRepository)

    @Provides
    @Singleton
    fun provideRemoveLastProductUseCase(productRepository: ProductRepository): RemoveLastProductUseCase = RemoveLastProductUseCase(productRepository)


    @Provides
    @Singleton
    fun provideDataSource(): ProductDataSource = InMemoryProductDataSource()

    @Provides
    @Singleton
    fun provideRepository(productDataSource: ProductDataSource): ProductRepository = ProductRepositoryImpl(productDataSource)
}