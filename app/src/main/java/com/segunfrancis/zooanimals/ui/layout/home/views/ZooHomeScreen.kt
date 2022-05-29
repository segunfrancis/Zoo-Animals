package com.segunfrancis.zooanimals.ui.layout.home.views

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.segunfrancis.zooanimals.data.BaseZooResponseItem
import com.segunfrancis.zooanimals.data.RemoteModule
import com.segunfrancis.zooanimals.util.views.ZooTopAppBar
import com.segunfrancis.zooanimals.ui.layout.home.HomeViewModel
import com.segunfrancis.zooanimals.ui.layout.home.HomeViewModelFactory
import com.segunfrancis.zooanimals.util.ZooState
import com.segunfrancis.zooanimals.util.views.ErrorScreen
import com.segunfrancis.zooanimals.util.views.ProgressIndicator

@Composable
fun ZooHomeScreen(
    viewModel: HomeViewModel = viewModel(
        factory = HomeViewModelFactory(
            api = RemoteModule.provideApi()
        )
    ),
    onItemClick: ((BaseZooResponseItem) -> Unit)? = null
) {
    Scaffold(topBar = { ZooTopAppBar(title = "Zoo Animals") }) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ) {
            when (val responseState = viewModel.zooResponse.collectAsState().value) {
                is ZooState.Error -> {
                    ErrorScreen(errorMessage = responseState.error.localizedMessage) {
                        viewModel.getZooAnimals()
                    }
                }
                ZooState.Loading -> {
                    Log.d("MainActivity", "Loading")
                    ProgressIndicator()
                }
                is ZooState.Success -> {
                    LazyColumn {
                        items(responseState.data) { name ->
                            ZooAnimalItem(item = name, onItemClick = {
                                onItemClick?.invoke(it)
                            })
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyPreview() {
    ZooHomeScreen()
}
