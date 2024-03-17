package com.wngud.test3.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.wngud.test3.domain.model.Product
import kotlin.random.Random
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(viewModel: MainViewModel = viewModel()) {
    val products by viewModel.products.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            Button(onClick = { viewModel.loadProductAll() }) {
                Text(text = "load product")
            }
            Button(onClick = { viewModel.addProduct(product()) }) {
                Text(text = "add new product")
            }
            Button(onClick = { viewModel.removeLastProduct() }) {
                Text(text = "remove last product")
            }
        }
        LazyColumn {
            items(products) {
                Text(text = it.name)
            }
        }
    }
}

fun product(): Product = Product(
    id = "p${Random.nextInt()}",
    name = "product-${Random.nextInt()}",
    price = Random.nextInt()
)